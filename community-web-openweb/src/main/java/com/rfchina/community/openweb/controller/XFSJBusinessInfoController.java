package com.rfchina.community.openweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rfchina.community.base.Constant;
import com.rfchina.community.base.OpenXFSJConstant;
import com.rfchina.community.base.Result;
import com.rfchina.community.openweb.entity.AdminUserInfo;
import com.rfchina.community.openweb.service.OpenXFSJActivityService;
import com.rfchina.community.openweb.service.XFSJBusinessInfoService;
import com.rfchina.community.openweb.service.XFSJSignUpInfoService;

/**
 * @author:fukangwen
 * @Description: 小富市集活动管理
 */
@RestController
@RequestMapping(value = Constant.ROOT_PATH_OPENWEB)
public class XFSJBusinessInfoController extends BaseController {

	@Autowired
	private XFSJBusinessInfoService businessInfoService;
	@Autowired
	private XFSJSignUpInfoService signUpInfoService;
	@Autowired
	private OpenXFSJActivityService openXFSJActivityService;
	/**
	 * 活动列表	
	 */
	@RequestMapping("/list_business_info")
	public Result<?> listBusinessInfo(
			@RequestParam(value="city_id", required=false, defaultValue="0") int cityId,
			@RequestParam(value="community_id",required=false, defaultValue="0") int communityId,
			@RequestParam(value="activity_name",required=false, defaultValue="") String activityName,
			@RequestParam(value="beginTime", required=false, defaultValue="") String beginTime,//日期
			@RequestParam(value="activityStatus", required=false) Integer activityStatus,//0未开始, 1进行中，2已结束
			@RequestParam(value="status", required=false, defaultValue="0") int status,//1.可报名 ,2 已报名待审核, 3报名成功待缴费, 4报名成功已缴费,5报名不通过（需要拒绝理由）, 6报名截止
			@RequestParam(value="serviceId", required=true) int serviceId,
			@RequestParam(value="index" , required = false , defaultValue = "1") int index,
			@RequestParam(value = "size" , required = false , defaultValue = "10") int size){
		// 权限检查
		AdminUserInfo admin = getAdminInfo();
		return Result.successData(businessInfoService.listBusinessInfo(admin.getUid(), cityId, communityId, activityName, beginTime, activityStatus,
				status, serviceId, OpenXFSJConstant.ActivityType.community, index, size));
	}
	
	/**
	 * 报名成功列表	
	 */
	@RequestMapping("/list_my_business_info")
	public Result<?> listMyBusinessInfo(
			@RequestParam(value="city_id", required=false, defaultValue="0") int cityId,
			@RequestParam(value="community_id",required=false, defaultValue="0") int communityId,
			@RequestParam(value="activity_name",required=false, defaultValue="") String activityName,
			@RequestParam(value="beginTime", required=false, defaultValue="") String beginTime,//日期
			@RequestParam(value="activityStatus", required=false) Integer activityStatus,//0未开始, 1进行中，2已结束
			@RequestParam(value="serviceId", required=true) Integer serviceId,
			@RequestParam(value="index" , required = false , defaultValue = "1") int index,
			@RequestParam(value = "size" , required = false , defaultValue = "10") int size){
		// 权限检查
		AdminUserInfo admin = getAdminInfo();
		return Result.successData(businessInfoService.listMyBusinessInfo(admin.getUid(), cityId, communityId
				,activityName , beginTime, activityStatus,serviceId, index, size));
	}
	
	/**
	 * 活动报名
	 */
	@RequestMapping("/sign_up_xfsj")
	public Result<?> signUp(
			@RequestParam(value="id", required=true) long xfsjId,
			@RequestParam(value="serviceId", required=true) int serviceId){
		// 权限检查
		AdminUserInfo admin = getAdminInfo();
		signUpInfoService.signUp(admin.getUid(), serviceId, xfsjId);
		return Result.successData(null);
	}
	
	/**
	 * 活动详情
	 */
	@RequestMapping("/getOpenXFSJBusinessInfo")
	public Result<?> getOpenXFSJBusinessInfo(
			@RequestParam(value = "id", required = true) Long id,
			@RequestParam(value = "serviceId", required = true) int serviceId
			){
		AdminUserInfo admin = getAdminInfo();
		return Result.successData(businessInfoService.getOpenXFSJBusinessInfo(id, admin.getUid(),serviceId));
	}

	/**
	 * 活动详情
	 */
	@RequestMapping("/getActivityInfo")
	public Result<?> getActivityInfo(
			@RequestParam(value = "id", required = true) Long id
	){
		return Result.successData(businessInfoService.getActivityInfo(id));
	}



	/**
	 * 报名的活动商品列表
	 */
	
	@RequestMapping("/listOpenXFSJStoreGood")
	public Result<?> listOpenXFSJStoreGood(
			@RequestParam(value = "xfsjId", required = true) Long xfsjId,
			@RequestParam(value = "serviceId", required = true) Integer serviceId) throws Exception {
		authorityCheck(serviceId);
		logger.info("url:listOpenXFSJStoreGood: params={}", xfsjId);
		return Result.successData(openXFSJActivityService.listOpenXFSJStoreGood(xfsjId,serviceId));
	}
	
	@RequestMapping("/createOpenXFSJStoreGood")
	public Result<?> createOpenXFSJStoreGood(
			@RequestParam(value = "xfsjId", required = true) Long xfsjId,
			@RequestParam(value = "goodId", required = true) Integer goodId,
			@RequestParam(value = "storeId", required = true) Integer storeId) throws Exception {
		authorityCheck(storeId);
		long id = openXFSJActivityService.createOpenXFSJStoreGood(xfsjId, goodId, storeId);
		return Result.successData(id);
	}

	// 删除商品
	@RequestMapping("/deleteOpenXFSJStoreGood")
	public Result<?> deleteOpenXFSJStoreGood(
			@RequestParam(value = "id", required = true) Long id) throws Exception {
		int i = openXFSJActivityService.deleteOpenXFSJStoreGood(id);
		return Result.successData(i);
	}
}
