package com.rfchina.community.open.bridge.service;

import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.OpenGoodGroupConstant;
import com.rfchina.community.base.util.FileUtil;
import com.rfchina.community.base.util.WorkBookUtil;
import com.rfchina.community.open.bridge.entity.ExtOpenStoreGoodGroupInfo;
import com.rfchina.community.open.bridge.mapper.ext.ExtCommunityBridgeMapper;
import com.rfchina.community.open.bridge.mapper.ext.ExtOpenStoreGoodGroupInfoMapper;
import com.rfchina.community.persistence.mapper.CommunityServiceMapper;
import com.rfchina.community.persistence.mapper.OpenStoreGoodGroupInfoMapper;
import com.rfchina.community.persistence.model.CommunityService;
import com.rfchina.community.persistence.model.OpenStoreGood;
import com.rfchina.community.persistence.model.OpenStoreGoodGroupInfo;
import com.rfchina.community.persistence.model.OpenStoreGoodGroupInfoExample;
import com.rfchina.community.persistence.model.ext.ExtCommunityServiceRela;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OpenStoreGoodGroupInfoService extends BaseService {
	@Autowired
	private OpenStoreGoodGroupInfoMapper openStoreGoodGroupInfoMapper;
	@Autowired
	private ExtOpenStoreGoodGroupInfoMapper extOpenStoreGoodGroupInfoMapper;
	@Autowired
	private OpenStoreGoodService openStoreGoodService;
	@Autowired
	private CommunityServiceMapper communityServiceMapper;
	@Autowired
	private ExtCommunityBridgeMapper extCommunityBridgeMapper;
	@Autowired
	private OpenStoreGroupDataService openStoreGroupDataService;

	@Value("${open.storeapi.url}")
	private String openStoreUrl;
	/**
	 * 新增
	 */
	public void insert(int goodId, int peopleNum, BigDecimal price, BigDecimal groupPrice, int stock, Date startDate, Date endDate,
					   int limitTimes, int virturalSuccessHour) {
		OpenStoreGood openStoreGood = openStoreGoodService.selectByPrimaryKey(goodId);
		validator(openStoreGood == null, "商品不存在");
		validator(openStoreGood.getStatus() != OpenConstant.GoodStatus.GROUNDING.getKey(), "该商品已下架或删除");
		validator(this.getValidGoodGroupInfoCount(goodId,startDate, endDate) > 0, "选择的商品有未开始或者进行中的团购活动与当前活动时间重叠。");
		OpenStoreGoodGroupInfo info = new  OpenStoreGoodGroupInfo();
		info.setCreateTime(new Date());
		info.setGoodId(goodId);
		info.setServiceId(openStoreGood.getServiceId());
		info.setEndTime(endDate);
		info.setStartTime(startDate);
		info.setGroupPrice(groupPrice);
		info.setLimitTimes(limitTimes);
		info.setPeopleNum(peopleNum);
		info.setPrice(price);
		info.setStatus(OpenGoodGroupConstant.status.start);
		info.setStock(stock);
		info.setVirturalSuccessHour(virturalSuccessHour);

		openStoreGoodGroupInfoMapper.insertSelective(info);
	}

	private int getValidGoodGroupInfoCount(int goodId, Date startDate, Date endDate){
		OpenStoreGoodGroupInfoExample example = new OpenStoreGoodGroupInfoExample();
		example.or().andStartTimeLessThanOrEqualTo(startDate).andEndTimeGreaterThanOrEqualTo(endDate).andStatusEqualTo(OpenGoodGroupConstant.status.start).andGoodIdEqualTo(goodId);
		example.or().andStartTimeGreaterThanOrEqualTo(startDate).andEndTimeLessThanOrEqualTo(endDate).andStatusEqualTo(OpenGoodGroupConstant.status.start).andGoodIdEqualTo(goodId);//包含原来的时间
		example.or().andStartTimeGreaterThanOrEqualTo(startDate).andStartTimeLessThan(endDate).andStatusEqualTo(OpenGoodGroupConstant.status.start).andGoodIdEqualTo(goodId);
		example.or().andEndTimeGreaterThan(startDate).andEndTimeLessThanOrEqualTo(endDate).andStatusEqualTo(OpenGoodGroupConstant.status.start).andGoodIdEqualTo(goodId);
		List<OpenStoreGoodGroupInfo> list = openStoreGoodGroupInfoMapper.selectByExample(example);
		return list.size();
	}

	/**
	 * 修改
	 * @param id
	 * @param stock
	 * @param endDate
	 */
	public void update(long id,int stock, Date endDate){
		OpenStoreGoodGroupInfo info = openStoreGoodGroupInfoMapper.selectByPrimaryKey(id);
		validator(info == null, "活动不存在");
		validator(endDate.getTime() <= info.getStartTime().getTime(), "活动开始时间要小于结束时间");
		OpenStoreGoodGroupInfoExample example = new OpenStoreGoodGroupInfoExample();
		example.createCriteria().andStartTimeLessThan(endDate).andEndTimeGreaterThan(endDate)
				.andStatusEqualTo(OpenGoodGroupConstant.status.start).andGoodIdEqualTo(info.getGoodId())
				.andIdNotEqualTo(id);
		List<OpenStoreGoodGroupInfo> list = openStoreGoodGroupInfoMapper.selectByExample(example);
		validator(list.size() > 0, "选择的商品有未开始或者进行中的团购活动与当前活动时间重叠。");
		info.setCreateTime(new Date());
		info.setEndTime(endDate);
		info.setStock(stock);

		openStoreGoodGroupInfoMapper.updateByPrimaryKeySelective(info);
	}

	/**
	 * 禁用
	 * @param id
	 */
	public void forbidden(long id){
		OpenStoreGoodGroupInfo info = openStoreGoodGroupInfoMapper.selectByPrimaryKey(id);
		info.setStatus(OpenGoodGroupConstant.status.forbidden);
		openStoreGoodGroupInfoMapper.updateByPrimaryKeySelective(info);
	}

	/**
	 * 详情
	 * @param id
	 */
	public OpenStoreGoodGroupInfo getDetail(long id){
		return openStoreGoodGroupInfoMapper.selectByPrimaryKey(id);
	}


	/**
	 * 列表搜索
	 * @param goodName
	 * @param serviceName
	 * @param merchantName
	 * @param groupInfoStatus
	 * @param index
	 * @param size
	 */
	public PageList<ExtOpenStoreGoodGroupInfo> pageByParam(String goodName, String serviceName, String merchantName,
													   Integer groupInfoStatus, int index, int size){
		Map<String, Object> param = new HashMap<>();
		if(StringUtils.isNotBlank(goodName)){
			param.put("goodName", "%" + goodName + "%");
		}
		if(StringUtils.isNotBlank(serviceName)){
			param.put("serviceName", "%" + serviceName + "%");
		}
		if(StringUtils.isNotBlank(merchantName)){
			param.put("merchantName", "%" + merchantName + "%");
		}

		if(groupInfoStatus != null){
			if(OpenGoodGroupConstant.groupInfoStatus.forbidden == groupInfoStatus){
				param.put("status", OpenGoodGroupConstant.status.forbidden);
			}else{
				param.put("status", OpenGoodGroupConstant.status.start);
				param.put("groupInfoStatus", groupInfoStatus);
			}
		}

		PageBounds pageBounds = new PageBounds(index, size);

		PageList<ExtOpenStoreGoodGroupInfo> list = extOpenStoreGoodGroupInfoMapper.pageByCondition(param, pageBounds);

		completeGroupInfoList(list);
		return list;
	}

	private void completeGroupInfoList(PageList<ExtOpenStoreGoodGroupInfo> list) {
		for(ExtOpenStoreGoodGroupInfo info : list){
			//设置活动显示状态
			if(OpenGoodGroupConstant.status.forbidden == info.getStatus()){
				info.setGroupInfoStatus(OpenGoodGroupConstant.groupInfoStatus.forbidden);
			}else{
				if(info.getStartTime().getTime() > System.currentTimeMillis()){
					info.setGroupInfoStatus(OpenGoodGroupConstant.groupInfoStatus.un_start);
				}else if(info.getEndTime().getTime() < System.currentTimeMillis()){
					info.setGroupInfoStatus(OpenGoodGroupConstant.groupInfoStatus.over);
				}else{
					info.setGroupInfoStatus(OpenGoodGroupConstant.groupInfoStatus.ing);
				}
			}

			//计算成团数量
			info.setGroupDataCount(openStoreGroupDataService.countByGoupInfoId(info.getId()));
		}
	}


	/**
	 * 下载二维码
	 */
	public String getQrcode(int goodId, int communityId, HttpServletResponse response){
		OpenStoreGood openStoreGood = openStoreGoodService.selectByPrimaryKey(goodId);
		validator(openStoreGood == null, "商品不存在");
		CommunityService ser = communityServiceMapper.selectByPrimaryKey(openStoreGood.getServiceId());
		validator(ser == null, "无数据");
		String con = openStoreUrl + "index.html#/goodsDetail?isNew=1&serviceId=" + ser.getId() + "&goodId=" + goodId + "&communityId=" + communityId;
		response.setContentType("image/png");
		ServletOutputStream sos = null;
		File file;
		try {
			file = QRCode.from(con).to(ImageType.PNG).withSize(350, 350).file();
		} finally {
			if (sos != null) {
				try {
					sos.close();
				} catch (IOException e) {
					error("生成二维码失败");
				}
			}
		}
		String base64Str = FileUtil.fileToBase64(file);
		validator(base64Str == null, "生成二维码失败");
		return base64Str;
	}

	/**
	 * 下载链接表
	 */
	public void downloadLinkBatch(int goodId, HttpServletResponse response){
		OpenStoreGood openStoreGood = openStoreGoodService.selectByPrimaryKey(goodId);
		validator(openStoreGood == null, "商品不存在");
		CommunityService ser = communityServiceMapper.selectByPrimaryKey(openStoreGood.getServiceId());
		validator(ser == null, "无数据");

		PageList<ExtCommunityServiceRela> list = extCommunityBridgeMapper.getCommunityServiceRelaList(openStoreGood.getServiceId(), new PageBounds(1, Integer.MAX_VALUE));

		if(!list.isEmpty()) {
			XSSFWorkbook wb = this.getWorkBook(list, goodId, openStoreGood.getServiceId());
			String fileName = "";
			try {
				fileName = URLEncoder.encode(openStoreGood.getName()+"二维码","UTF-8")+".xlsx";
			} catch (UnsupportedEncodingException e) {
				error("下载文件失败");
			}
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
			try {
				wb.write(response.getOutputStream());
				wb.close();
				response.getOutputStream().flush();
				response.getOutputStream().close();

			} catch (IOException e) {
				error("下载文件失败");
			}

		}
	}

	public XSSFWorkbook getWorkBook(PageList<ExtCommunityServiceRela> list, int goodId, int serviceId) {

		XSSFWorkbook workbook = new XSSFWorkbook();

		Sheet sheet = workbook.createSheet("二维码地址下载");

		Row row = sheet.createRow(0);
		String titleTops = "社区,二维码地址";
		String[] titles = titleTops.split(",");
		for (int i = 0; i < titles.length; i++) {
			WorkBookUtil.createCellValue(row, i, titles[i]);
		}
		String con = "";
		int r = 1;
		for (ExtCommunityServiceRela e : list) {
			row = sheet.createRow(r++);
			int i = 0;
			WorkBookUtil.createCellValue(row, i++, e.getCommunityName() + "");
			con = openStoreUrl + "index.html#/goodsDetail?isNew=1&serviceId=" + serviceId + "&goodId=" + goodId + "&communityId=" + e.getCommunityId();
			WorkBookUtil.createCellValue(row, i++, con + "");
		}

		return workbook;
	}

}
