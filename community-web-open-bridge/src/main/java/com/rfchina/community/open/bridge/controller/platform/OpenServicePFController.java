package com.rfchina.community.open.bridge.controller.platform;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.Result;
import com.rfchina.community.base.util.DateTimeUtils;
import com.rfchina.community.open.bridge.WorkBookUtils;
import com.rfchina.community.open.bridge.controller.BaseController;
import com.rfchina.community.open.bridge.mapper.ext.ExtCommunityServiceMapper;
import com.rfchina.community.persistence.mapper.CommunityMapper;
import com.rfchina.community.persistence.mapper.CommunityServiceCategoryMapper;
import com.rfchina.community.persistence.mapper.CommunityServiceMapper;
import com.rfchina.community.persistence.mapper.CommunityServiceRelaMapper;
import com.rfchina.community.persistence.mapper.OpenMerchantInfoMapper;
import com.rfchina.community.persistence.model.Community;
import com.rfchina.community.persistence.model.CommunityService;
import com.rfchina.community.persistence.model.CommunityServiceCategory;
import com.rfchina.community.persistence.model.CommunityServiceRela;
import com.rfchina.community.persistence.model.CommunityServiceRelaExample;
import com.rfchina.community.persistence.model.OpenMerchantInfo;

@RestController
@RequestMapping(value = OpenConstant.ROOT_PATH_PLATFORM)
public class OpenServicePFController extends BaseController {

	@Autowired
	private CommunityServiceMapper communityServiceMapper;
	@Autowired
	private CommunityServiceRelaMapper communityServiceRelaMapper;
	@Autowired
	private CommunityServiceCategoryMapper communityServiceCategoryMapper;
	@Autowired
	private CommunityMapper communityMapper;
	@Autowired
	private OpenMerchantInfoMapper openMerchantInfoMapper;
	@Autowired
	private ExtCommunityServiceMapper extCommunityServiceMapper;

	@Value("${open.storeapi.url:HOST}")
	private String host;

	@RequestMapping("/loadServiceRelaQrcode")
	public void loadServiceRelaQrcode(@RequestParam(value = "id") Integer id, HttpServletResponse response)
			throws IOException {

		CommunityService sc = communityServiceMapper.selectByPrimaryKey(id);
		validator(sc == null, "服务不存在" + id);
		OpenMerchantInfo mc = openMerchantInfoMapper.selectByPrimaryKey(sc.getMerchantId());

		CommunityServiceRelaExample example = new CommunityServiceRelaExample();
		example.createCriteria().andServiceIdEqualTo(id);
		List<CommunityServiceRela> list = communityServiceRelaMapper.selectByExample(example);

		String fileName = sc.getTitle() + "服务的二维码地址" + DateTimeUtils.format(new Date(), "_yyyyMMdd_HHmmss") + ".xlsx";
		response.setContentType("application/octet-stream;charset=utf-8");
		response.addHeader("Content-Disposition",
				"attachment;filename=" + java.net.URLEncoder.encode(fileName, "UTF-8"));
		ServletOutputStream stream = response.getOutputStream();
		Workbook workbook = new XSSFWorkbook();
		try {
			Sheet sheet = workbook.createSheet(sc.getTitle() + "服务");
			Integer r1 = 0;
			String titles = "社区名称,社区地址,服务商,服务名称,二维码地址";
			WorkBookUtils.setTitle(titles, sheet.createRow(r1++));
			for (CommunityServiceRela a : list) {
				Integer key = a.getCommunityId();
				Community community = communityMapper.selectByPrimaryKey(a.getCommunityId());
				if (community == null) {
					community = new Community();
					community.setName("" + key);
					community.setAddress("" + key);

				}
				int cnum = 0;
				Row row = sheet.createRow(r1++);
				WorkBookUtils.setCell(row, cnum++, community.getName());
				WorkBookUtils.setCell(row, cnum++, community.getAddress());
				WorkBookUtils.setCell(row, cnum++, mc.getTitle());
				WorkBookUtils.setCell(row, cnum++, sc.getTitle());
				String url = host + "#/home?isNew=1&serviceId=" + id + "&communityId=" + key;
				WorkBookUtils.setCell(row, cnum++, url);

			}

			workbook.write(stream);
		} finally {
			IOUtils.closeQuietly(workbook);
		}

	}

	@RequestMapping("/sreachServiceName")
	public Result<?> sreachServiceName(@RequestParam(value = "title", required = false) String title,
			@RequestParam(value = "index", required = false, defaultValue = "1") int index,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size) throws Exception {

		PageBounds pageBounds = new PageBounds(index, size);
		Map<String, Object> param = new HashMap<>();

		if (StringUtils.isNotBlank(title)) {
			param.put("title", "%" + title + "%");
		}
		PageList<Map<String, Object>> pager = extCommunityServiceMapper.searchServiceName2(param, pageBounds);

		// s.id,s.title,s.category_id,det.category_second_type,m.title as merchant_title
		for (Map<String, Object> map : pager) {
			Integer category_id = MapUtils.getInteger(map, "category_id", 0);
			Integer category_second_type = MapUtils.getInteger(map, "category_second_type", 0);

			CommunityServiceCategory cate = communityServiceCategoryMapper.selectByPrimaryKey(category_id);
			map.put("category_name", "");
			if (cate != null) {
				map.put("category_name", cate.getName());
			}
			CommunityServiceCategory cate2 = communityServiceCategoryMapper.selectByPrimaryKey(category_second_type);
			map.put("category_second_name", "");
			if (cate2 != null) {
				map.put("category_second_name", cate2.getName());
			}
		}

		return Result.successData(pager.convert());
	}

}
