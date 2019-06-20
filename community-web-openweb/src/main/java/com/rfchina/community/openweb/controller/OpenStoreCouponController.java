package com.rfchina.community.openweb.controller;

import com.rfchina.community.base.Constant;
import com.rfchina.community.base.Result;
import com.rfchina.community.base.util.DateTimeUtils;
import com.rfchina.community.persistence.mapper.OpenStoreCouponMapper;
import com.rfchina.community.persistence.mapper.ext.ExtOpenStoreCouponMapper;
import com.rfchina.community.persistence.model.OpenStoreCoupon;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 优惠券 controller
 * 
 * `id` bigint(20) NOT NULL AUTO_INCREMENT, `pic` varchar(200) DEFAULT NULL
 * COMMENT '优惠券图片：', `title` varchar(100) DEFAULT NULL COMMENT '优惠券标题*：',
 * `sub_title` varchar(100) DEFAULT NULL COMMENT '优惠内容*：', `coupon_no`
 * varchar(40) DEFAULT NULL COMMENT '优惠编号：', `details` text COMMENT '优惠券详情：',
 * `begin_time` date DEFAULT NULL COMMENT '有限期', `end_time` date DEFAULT NULL
 * COMMENT '有限期', `create_time` datetime DEFAULT NULL, `status` int(11) DEFAULT
 * NULL COMMENT '1启用,2停用,3删除',
 */
@RestController
@RequestMapping(value = { Constant.ROOT_PATH_OPENWEB + "/coupon" })
public class OpenStoreCouponController extends BaseController {

	@Autowired
	private ExtOpenStoreCouponMapper extOpenStoreCouponMapper;
	@Autowired
	private OpenStoreCouponMapper openStoreCouponMapper;

	@RequestMapping(value = { "/add_open_store_coupon" })
	public Result<?> addOpenStoreCoupon(@RequestParam(value = "serviceId") int serviceId,
										@RequestParam(value = "pic", defaultValue = "") String pic,
										@RequestParam(value = "title", defaultValue = "") String title,
										@RequestParam(value = "sub_title", defaultValue = "") String subTitle,
										@RequestParam(value = "coupon_no", defaultValue = "") String couponNo,
										@RequestParam(value = "details", defaultValue = "") String details,
										@RequestParam(value = "begin_time", defaultValue = "") String begin_time,
										@RequestParam(value = "end_time", defaultValue = "") String end_time) {

		validator(StringUtils.isBlank(title), "优惠券标题必须输入");
		validator(StringUtils.isBlank(subTitle), "优惠内容必须输入");
		validator(StringUtils.isBlank(begin_time) || StringUtils.isBlank(end_time), "有限期必须输入");

		// 权限检查
		authorityCheck(serviceId);
		// 验证参数

		OpenStoreCoupon record = new OpenStoreCoupon();
		record.setCouponNo(couponNo);
		record.setCreateTime(new Date());
		record.setTitle(title);
		record.setSubTitle(subTitle);
		record.setDetails(details);
		record.setBeginTime(DateTimeUtils.parseDate(begin_time));
		record.setEndTime(DateTimeUtils.parseDate(end_time));
		record.setPic(pic);
		record.setServiceId(serviceId);
		record.setStatus(1);
		openStoreCouponMapper.insertSelective(record);
		return Result.successData(record);
	}

	@RequestMapping(value = { "/update_open_store_coupon" })
	public Result<?> updateOpenStoreCoupon(@RequestParam(value = "id") Long id,
										   @RequestParam(value = "serviceId") Integer serviceId,
										   @RequestParam(value = "pic", defaultValue = "") String pic,
										   @RequestParam(value = "title", defaultValue = "") String title,
										   @RequestParam(value = "sub_title", defaultValue = "") String subTitle,
										   @RequestParam(value = "coupon_no", defaultValue = "") String couponNo,
										   @RequestParam(value = "details", defaultValue = "") String details,
										   @RequestParam(value = "begin_time", defaultValue = "") String begin_time,
										   @RequestParam(value = "end_time", defaultValue = "") String end_time) {
		// 验证通用参数

		validator(id < 0, "ID不能为空");
		validator(StringUtils.isBlank(title), "优惠券标题必须输入");
		validator(StringUtils.isBlank(subTitle), "优惠内容必须输入");
		validator(StringUtils.isBlank(begin_time) || StringUtils.isBlank(end_time), "有限期必须输入");

		OpenStoreCoupon coupon = openStoreCouponMapper.selectByPrimaryKey(id);
		validator(coupon == null, "数据不存在!");
		validator(coupon.getServiceId() != serviceId.intValue(), "非法访问!");
		authorityCheck(serviceId);

		OpenStoreCoupon record = new OpenStoreCoupon();
		record.setId(id);
		record.setCouponNo(couponNo);
		record.setTitle(title);
		record.setSubTitle(subTitle);
		record.setDetails(details);
		record.setBeginTime(DateTimeUtils.parseDate(begin_time));
		record.setEndTime(DateTimeUtils.parseDate(end_time));
		record.setPic(pic);
		int i = openStoreCouponMapper.updateByPrimaryKeySelective(record);

		return Result.successData(i);
	}

	@RequestMapping(value = { "/update_open_store_coupon_status" })
	public Result<?> updateOpenStoreCouponStatus(@RequestParam(value = "id") Long id,
												 @RequestParam(value = "serviceId") Integer serviceId,
												 @RequestParam(value = "status") Integer status) {
		// 验证通用参数

		validator(id < 0, "ID不能为空");
		validator(status != 2 && status != 1 && status != 3, "状态只能是启动,停用,删除.");

		OpenStoreCoupon coupon = openStoreCouponMapper.selectByPrimaryKey(id);
		validator(coupon == null, "数据不存在!");
		validator(coupon.getServiceId() != serviceId.intValue() , "非法访问!"+coupon.getServiceId() +"=="+ serviceId);
		validator(coupon.getStatus() == 3, "该信息已经删除!");
		authorityCheck(serviceId);

		OpenStoreCoupon record = new OpenStoreCoupon();
		record.setId(id);
		record.setStatus(status);
		int i = openStoreCouponMapper.updateByPrimaryKeySelective(record);

		return Result.successData(i);
	}

	@RequestMapping(value = { "/list_open_store_coupon" })
	public Result<?> listOpenStoreCoupon(@RequestParam(value = "serviceId") int serviceId,
										 @RequestParam(value = "title", required = false, defaultValue = "") String title,
										 @RequestParam(value = "sub_title", required = false, defaultValue = "") String sub_title,
										 @RequestParam(value = "status", required = false, defaultValue = "0") int status,
										 @RequestParam(value = "coupon_no", defaultValue = "") String couponNo,
										 @RequestParam(value = "start_create_time", required = false, defaultValue = "") String startCreateTime,
										 @RequestParam(value = "end_create_time", required = false, defaultValue = "") String endCreateTime,
										 @RequestParam(value = "index", required = false, defaultValue = "1") int index,
										 @RequestParam(value = "size", required = false, defaultValue = "10") int size) throws ParseException {
		// 创建时间：
		// 优惠券标题：
		// 优惠券编号：
		// 优惠券状态：

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date startCreateDate = null;
		Date endCreateDate = null;
		if (StringUtils.isNotBlank(startCreateTime)) {
			startCreateDate = sdf.parse(startCreateTime);
		}
		if (StringUtils.isNotBlank(endCreateTime)) {
			endCreateDate = sdf.parse(endCreateTime);
		}
		Map<String, Object> param = new HashMap<>();
		// if(serviceId > 0){
		param.put("serviceId", serviceId);
		// }
		if (StringUtils.isNotBlank(title)) {
			param.put("title", "%" + title + "%");
		}
		if (StringUtils.isNotBlank(sub_title)) {
			param.put("sub_title", "%" + sub_title + "%");
		}
		if (StringUtils.isNotBlank(couponNo)) {
			param.put("coupon_no", "%" + couponNo + "%");
		}
		if (status > 0) {
			param.put("status", status);
		}
		if (startCreateDate != null) {
			param.put("startCreateDate", startCreateDate);
		}
		if (endCreateDate != null) {
			param.put("endCreateDate", endCreateDate);
		}
		PageBounds pageBounds = new PageBounds(index, size);

		PageList<OpenStoreCoupon> pager = extOpenStoreCouponMapper.pageByCondition(param, pageBounds);

		return Result.successData(pager.convert());
	}

	@RequestMapping(value = { "/get_open_store_coupon" })
	public Result<?> getGoodDetail(@RequestParam(value = "serviceId") int serviceId,
			@RequestParam(value = "id") Long id) {
		validator(id <= 0, "ID不能为空");
		OpenStoreCoupon coupon = openStoreCouponMapper.selectByPrimaryKey(id);
		validator(coupon == null, "数据不存在!");
		validator(coupon.getServiceId() != serviceId, "非法访问!");
		validator(coupon.getStatus() == 3, "该信息已经删除!");
		authorityCheck(serviceId);
		return Result.successData(coupon);
	}

}
