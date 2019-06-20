package com.rfchina.community.openstore.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rfchina.community.base.Constant;
import com.rfchina.community.base.Result;
import com.rfchina.community.openstore.service.OpenStoreServiceTempleteService;
import com.rfchina.community.persistence.mapper.OpenStoreCouponMapper;
import com.rfchina.community.persistence.mapper.ext.ExtOpenStoreCouponMapper;
import com.rfchina.community.persistence.model.OpenStoreCoupon;
import com.rfchina.community.persistence.model.OpenStoreCouponExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

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
@RequestMapping(value = { Constant.ROOT_PATH_OPENSTORE+"/coupon" })
public class OpenStoreCouponController extends BaseController {

	@Autowired
	private OpenStoreCouponMapper openStoreCouponMapper;

	/**
	 * @author:fukangwen
	 * @Description: 优惠券列表
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping(value = { "/list_open_store_coupon" })
	public Result<?> listOpenStoreCoupon(
			@RequestParam(value = "index", required = false, defaultValue = "1") int index,
			@RequestParam(value = "size", required = false, defaultValue = "100") int size) {
		logger.info("method ： listOpenStoreCoupon; params:serviceId={},index={},size={}",getServiceId(),index, size);
		PageHelper.startPage(index, size);
		OpenStoreCouponExample example = new OpenStoreCouponExample();
		example.createCriteria().andServiceIdEqualTo(getServiceId()).andStatusEqualTo(1);
		example.setOrderByClause("create_time desc");
		List<OpenStoreCoupon> list = openStoreCouponMapper.selectByExample(example);
		PageInfo page = new PageInfo(list);
		return Result.successData(page);
	}

	/**
	 * @author:fukangwen
	 * @Description: 优惠券详情
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping(value = { "/get_open_store_coupon" })
	public Result<?> getCouponDetail(
			@RequestParam(value = "id") Long id) {
		validator(id <= 0, "ID不能为空");
		OpenStoreCoupon coupon = openStoreCouponMapper.selectByPrimaryKey(id);
		validator(coupon == null, "数据不存在!");
		validator(coupon.getServiceId() != getServiceId(), "非法访问!");
		validator(coupon.getStatus() == 3, "该信息已经删除!");
		return Result.successData(coupon);
	}

	
}
