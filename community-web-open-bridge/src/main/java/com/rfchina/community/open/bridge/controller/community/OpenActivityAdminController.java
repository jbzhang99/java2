package com.rfchina.community.open.bridge.controller.community;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.OpenXFSJConstant;
import com.rfchina.community.base.Result;
import com.rfchina.community.base.util.DateTimeUtils;
import com.rfchina.community.open.bridge.controller.BaseController;
import com.rfchina.community.open.bridge.service.OpenXFSJActivityService;

//社区后台-活动管理
@RestController
@RequestMapping(value = OpenConstant.ROOT_PATH_COMMUNITY)
public class OpenActivityAdminController extends BaseController {

	@Autowired
	private OpenXFSJActivityService openXFSJActivityService;

	/**
	 * @author:fukangwen
	 * @Description: 根据社区显示该社区的平台活动， type: WinterTerm 拎包 ， EStation 自在e站
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping("/listActivity_{type}")
	public Result<?> listActivity(
			@RequestParam(value = "type", required = true) String type,
			@RequestParam(value = "cityId", required = false, defaultValue = "0") int cityId,
			@RequestParam(value = "communityId", required = false, defaultValue = "") String communityId,
			@RequestParam(value = "activityName", required = false, defaultValue = "") String activityName,
			@RequestParam(value = "status", required = false, defaultValue = "0") int status,	//活动状态，1启用，2禁用
			@RequestParam(value = "index", required = false, defaultValue = "1") int index,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size) throws Exception {
		int categoryId = 0;
		if("WinterTerm".equals(type)) {
			categoryId = 49;//写死id
		}
		if("EStation".equals(type)) {
			categoryId = 50;
		}
		return Result.successData(openXFSJActivityService.listPlatformActivity(cityId,communityId, activityName, categoryId, status, index, size).convert());
	}
	
	/**
	 * @author:fukangwen
	 * @Description: 获取链接二维码
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping("/getAdminActivityQrcode")
	public Result<?> getActivityQrcode(
			@RequestParam(value = "xfsjId", required = true, defaultValue = "0") int xfsjId) throws Exception {
		return Result.successData(openXFSJActivityService.getPlatformActivityQrcode(xfsjId));
	}

	/**
	 * @author:fukangwen
	 * @Description: 获取活动详情
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping("/getAdminActivityDetail")
	public Result<?> getAdminActivityDetail(@RequestParam(value = "id", required = true) Long id) throws Exception {
		return Result.successData(openXFSJActivityService.getOpenXFSJInfo(id));
	}

	@RequestMapping("/listAdminStoreGood")
	public Result<?> listAdminStoreGood(@RequestParam(value = "xfsjId", required = true) Long xfsjId,
			@RequestParam(value = "type", required = true) Integer type) throws Exception {
		logger.info("listAdminStoreGood: params={}", xfsjId);
		return Result.successData(openXFSJActivityService.listOpenXFSJStoreGood(xfsjId, type));
	}
	
}
