package com.rfchina.community.open.bridge.controller.platform;

import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.Result;
import com.rfchina.community.base.util.MyUtils;
import com.rfchina.community.open.bridge.controller.BaseController;
import com.rfchina.community.persistence.mapper.CmActivityCardCouponItemMapper;
import com.rfchina.community.persistence.mapper.CmStoreCouponExtendMapper;
import com.rfchina.community.persistence.mapper.CommunityServiceMapper;
import com.rfchina.community.persistence.model.CmActivityCardCouponItem;
import com.rfchina.community.persistence.model.CmStoreCouponExtend;
import com.rfchina.community.persistence.model.CommunityService;
import com.rfchina.community.service.openser.CmStoreCouponRecordService;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

@RestController
@RequestMapping(value = OpenConstant.ROOT_PATH_PLATFORM)
public class CmStoreCouponRecordPFController extends BaseController {

	@Autowired
	private CmStoreCouponRecordService cmStoreCouponRecordService;
	@Autowired
	private CmActivityCardCouponItemMapper cmActivityCardCouponItemMapper;
	@Autowired
	private CommunityServiceMapper communityServiceMapper;
	@Autowired
	private CmStoreCouponExtendMapper cmStoreCouponExtendMapper;

	@RequestMapping(value = { "/store_coupon_record_page_list" })
	public Result<?> pageList(@RequestParam(value = "index", required = false, defaultValue = "1") int index,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size, Long coupon_id) {
		return Result.successData(cmStoreCouponRecordService.pageList(coupon_id, index, size, false).convert());
	}

	@RequestMapping(value = { "/store_coupon_record_batch" })
	public Result<?> batchAddCoupon(@RequestParam(value = "link") String link,
			@RequestParam(value = "__phone", required = false, defaultValue = "") String operatorPhone,
			@RequestParam(value = "__realname", required = false, defaultValue = "") String operatorName,
			@RequestParam(value = "coupon_id") Long couponId, HttpServletResponse response)
			throws Exception {

		CmActivityCardCouponItem coupon = cmActivityCardCouponItemMapper.selectByPrimaryKey(couponId);
		validator(coupon == null, couponId + "该券不存在!");
		validator(coupon.getStatus() != 1, couponId + "该券没有启用!");
		//获取店铺名
		CmStoreCouponExtend extend = cmStoreCouponExtendMapper.selectByPrimaryKey(couponId);
		validator(extend == null , "该券不存在!");
		CommunityService store = communityServiceMapper.selectByPrimaryKey(extend.getServiceId());
		validator(store == null, "店铺不存在");
		String content = "恭喜您获得【" + store.getTitle() +"】的优惠券【" + coupon.getCouponName() + "】,赶快去购买使用吧~";
		
		URL url = new URL(link);
		URLConnection conn = url.openConnection();
		InputStream is = conn.getInputStream();
		Workbook workbook = new XSSFWorkbook(is);
		try {
			Sheet sheet = workbook.getSheetAt(0);
			int lastRow = sheet.getLastRowNum();
			for (int i = 1; i <= lastRow; i++) {
				Row row = sheet.getRow(i);
				String userPhone = MyUtils.getCellValue(row, 1);
				logger.info("store_coupon_record_batch i={},phone={}", i, userPhone);
				if(StringUtils.isNotBlank(userPhone)) {
					String msg = cmStoreCouponRecordService.batchCouponByPhone(coupon, userPhone, content,
							store.getId(), operatorName, operatorPhone);
					Cell msgcell = row.createCell(2);
					msgcell.setCellValue(msg);
				}
			}
			
			logger.info("处理完成!");
			ServletOutputStream stream=	MyUtils.createServletOutputStream(response, "批量发券");
			workbook.write(stream);
		} finally {
			IOUtils.closeQuietly(workbook);
		}
		return Result.success();
	}

}
