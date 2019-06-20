package com.rfchina.community.open.bridge.controller.platform;

import com.alibaba.fastjson.JSON;
import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.OpenXFSJConstant;
import com.rfchina.community.base.Result;
import com.rfchina.community.base.util.DateTimeUtils;
import com.rfchina.community.open.bridge.controller.BaseController;
import com.rfchina.community.open.bridge.service.CommunityServiceRelaService;
import com.rfchina.community.open.bridge.service.OpenXFSJActivityService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

//小富市集
@RestController
@RequestMapping(value = OpenConstant.ROOT_PATH_PLATFORM)
public class OpenPlatformActivityController extends BaseController {

	@Autowired
	private OpenXFSJActivityService openXFSJActivityService;
	@Autowired
	private CommunityServiceRelaService communityServiceRelaService;

	/**
	 * @author:fukangwen
	 * @Description: 根据社区显示该社区的平台活动
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping("/listPlatformActivity")
	public Result<?> listPlatformActivity(
			@RequestParam(value = "cityId", required = false, defaultValue = "0") int cityId,
			@RequestParam(value = "communityId", required = false, defaultValue = "") String communityId,
			@RequestParam(value = "activityName", required = false, defaultValue = "") String activityName,
			@RequestParam(value = "status", required = false, defaultValue = "0") int status,	//活动状态，1启用，2禁用
			@RequestParam(value = "index", required = false, defaultValue = "1") int index,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size) throws Exception {

		return Result.successData(openXFSJActivityService.listPlatformActivity(cityId,communityId, activityName,0, status, index, size).convert());
	}

	/**
	 * @author:fukangwen
	 * @Description: 获取可用的活动
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping("/listValidActivity")
	public Result<?> listValidActivity(
			@RequestParam(value = "activityName", required = false, defaultValue = "") String activityName,
			@RequestParam(value = "status", required = false, defaultValue = "0") Integer status,	//活动状态，1启用，2禁用
			@RequestParam(value = "index", required = false, defaultValue = "1") int index,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size) throws Exception {

		return Result.successData(openXFSJActivityService.listValidActivity(activityName, status, index, size).convert());
	}
	
	/**
	 * @author:fukangwen
	 * @Description: 获取链接二维码
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping("/getPlatformActivityQrcode")
	public Result<?> getPlatformActivityQrcode(
			@RequestParam(value = "xfsjId", required = true, defaultValue = "0") int xfsjId) throws Exception {
		
		return Result.successData(openXFSJActivityService.getPlatformActivityQrcode(xfsjId));
	}

	/**
	 * @author:fukangwen
	 * @Description: 获取活动详情
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping("/getPlatformActivity")
	public Result<?> getPlatformActivity(@RequestParam(value = "id", required = true) Long id) throws Exception {
		return Result.successData(openXFSJActivityService.getOpenXFSJInfo(id));
	}

	/**
	 * @author:fukangwen
	 * @Description: 更新活动状态
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping("/updatePlatformActivityStatus")
	public Result<?> updatePlatformActivityStatus(@RequestParam(value = "id", required = true) Long id,
			@RequestParam(value = "status", required = true) int status) throws Exception {
		int i = openXFSJActivityService.updatePlatformActivityStatus(id, status);
		return Result.successData(i);
	}

	/**
	 * @author:fukangwen
	 * @Description: 创建平台活动
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping("/createPlatformActivity")
	public Result<?> createPlatformActivity(
			@RequestParam(value = "cityId", required = true) int cityId,
			@RequestParam(value = "communityId", required = true) int communityId,
			@RequestParam(value = "categoryId", required = true) int categoryId,
			@RequestParam(value = "actAddress", required = false) String actAddress,
			@RequestParam(value = "actImg", required = true) String actImg,
			@RequestParam(value = "actTitile", required = true) String actTitile,
			@RequestParam(value = "detail", required = false) String detail,
			@RequestParam(value = "beginTime", required = false, defaultValue = "") String beginTime,
			@RequestParam(value = "endTime", required = false, defaultValue = "") String endTime
			) throws Exception {
		validator(StringUtils.isBlank(beginTime), "活动开始时间不能为空");
		validator(StringUtils.isBlank(endTime), "活动结束时间不能为空");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date beginDate = DateTimeUtils.date000000(sdf.parse(beginTime));
		Date endDate = DateTimeUtils.date235959(sdf.parse(endTime));
		validator(endDate.getTime() <= beginDate.getTime(), "活动开始时间要小于结束时间");
		
		Long id = openXFSJActivityService.createPlatformActivity(OpenXFSJConstant.ActivityType.platform, categoryId,
				communityId, actAddress, actImg, actTitile,detail, beginDate, endDate);
		return Result.successData(id);
	}

	/**
	 * @author:fukangwen
	 * @Description: 更新平台活动信息
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping("/updatePlatformActivity")
	public Result<?> updatePlatformActivity(@RequestParam(value = "id", required = true) Long id,
			@RequestParam(value = "communityId", required = true) int communityId,
			@RequestParam(value = "categoryId", required = true) int categoryId,
			@RequestParam(value = "actAddress", required = false) String actAddress,
			@RequestParam(value = "actImg", required = false) String actImg,
			@RequestParam(value = "actTitile", required = false) String actTitile,
			@RequestParam(value = "detail", required = false) String detail,
			@RequestParam(value = "beginTime", required = false, defaultValue = "") String beginTime,
			@RequestParam(value = "endTime", required = false, defaultValue = "") String endTime) throws Exception {
		
		validator(StringUtils.isBlank(beginTime), "活动开始时间不能为空");
		validator(StringUtils.isBlank(endTime), "活动结束时间不能为空");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date beginDate = DateTimeUtils.date000000(sdf.parse(beginTime));
		Date endDate = DateTimeUtils.date235959(sdf.parse(endTime));
		validator(endDate.getTime() <= beginDate.getTime(), "活动开始时间要小于结束时间");
		
		int i = openXFSJActivityService.updateOpenXFSJInfo(id, communityId, categoryId, actAddress, actImg, null, actTitile
				,detail, 0L, 0L , beginDate, endDate);
		return Result.successData(i);
	}
	
	/**
	 * @author:fukangwen
	 * @Description: 创建平台活动商家
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping("/createOpenXFSJStore")
	public Result<?> createOpenXFSJStore(
			@RequestParam(value = "xfsjId", required = true) Long xfsjId,
			@RequestParam(value = "storeId", required = true) Integer storeId,
			@RequestParam(value = "orderby", required = false, defaultValue = "0") Integer orderby,
			@RequestParam(value = "coverImg", required = true) String coverImg) throws Exception {
		openXFSJActivityService.createOpenXFSJStore(xfsjId,storeId, orderby, coverImg);
		return Result.successData(null);
	}
	
	/**
	 * @author:fukangwen
	 * @Description: 创建商品（商品多选）
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping("/createOpenXFSJStoreGood")
	public Result<?> createOrUpdateOpenXFSJStoreGood(
			@RequestParam(value = "xfsjId", required = true) Long xfsjId,
			@RequestParam(value = "goodIds", required = false) String goodIds,
			@RequestParam(value = "storeId", required = true) Integer storeId,
			@RequestParam(value = "title", required = false) String title,
			@RequestParam(value = "orderby", required = false, defaultValue = "0") Integer orderby) throws Exception {
		openXFSJActivityService.createPlatformActivityStoreGood(xfsjId, goodIds, OpenXFSJConstant.Type.SHOP_BETTER, storeId, null, title, orderby);
		return Result.successData(null);
	}

	// 删除店铺
	@RequestMapping("/deleteOpenXFSJStore")
	public Result<?> deleteOpenXFSJStore(@RequestParam(value = "xfsjId", required = true) Long xfsjId,
			@RequestParam(value = "storeId", required = true) Integer storeId) throws Exception {
		int i = openXFSJActivityService.deleteOpenXFSJStore(xfsjId, storeId);
		return Result.successData(i);
	}

	// 删除商品
	@RequestMapping("/deleteOpenXFSJStoreGood")
	public Result<?> deleteOpenXFSJStoreGood(@RequestParam(value = "xfsjId", required = true) Long xfsjId,
			@RequestParam(value = "id", required = false, defaultValue = "0") Long id) throws Exception {
		int i = openXFSJActivityService.deleteOpenXFSJStoreGood(xfsjId, id, OpenXFSJConstant.ActivityType.platform);
		return Result.successData(i);
	}

	/**
	 * @author:fukangwen
	 * @Description: 平台活动的商店商品
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping("/listOpenXFSJStoreGood")
	public Result<?> listOpenXFSJStoreGood(@RequestParam(value = "xfsjId", required = true) Long xfsjId) throws Exception {
		logger.info("url:listOpenXFSJStoreGood: params={}", xfsjId);
		return Result.successData(openXFSJActivityService.listOpenXFSJStoreGood(xfsjId, OpenXFSJConstant.Type.SHOP_BETTER));
	}

	@RequestMapping("/listStoreName")
	public Result<?> listStoreName(@RequestParam(value = "cityId", required = false, defaultValue = "0") int cityId,
			@RequestParam(value = "communityIds", required = true, defaultValue = "0") int communityIds,
			@RequestParam(value = "title", required = false) String title,
			@RequestParam(value = "index", required = false, defaultValue = "1") int index,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size) throws Exception {
		return Result.successData(openXFSJActivityService.listStoreName(communityIds, title, index, size).convert());
	}

	@RequestMapping("/listStoreGood")
	public Result<?> listStoreGood(@RequestParam(value = "storeId", required = false, defaultValue = "0") int storeId,
			@RequestParam(value = "title", required = false) String title,
			@RequestParam(value = "index", required = false, defaultValue = "1") int index,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size) throws Exception {
		return Result.successData(openXFSJActivityService.listStoreGood(storeId, title, index, size).convert());
	}
	
	/**
	 * @author:fukangwen
	 * @Description: 更换图片
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping("/updateCoverImg")
	public Result<?> updateCoverImg(
			@RequestParam(value = "xfsjId", required = true) Long xfsjId,
			@RequestParam(value = "storeId", required = true) Integer storeId,
			@RequestParam(value = "coverImg", required = false) String coverImg) throws Exception {
		long id = openXFSJActivityService.updateCoverImg(xfsjId, storeId, coverImg);
		return Result.successData(id);
	}

	/**
	 *
	 * @param xfsjId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getStoreList")
	public Result<?> getStoreList(
			@RequestParam(value = "xfsjId", required = true) Long xfsjId) throws Exception {
		return Result.successData(openXFSJActivityService.getStoreList(xfsjId));
	}


	/**
	 * @Author wlrllr
	 * @Description //复制平台活动
	 * @Date 2018/12/29
	 * @Param [cityId, communityId, categoryId, actAddress, actImg, actTitle, detail, beginTime, endTime]
	 * @return com.rfchina.community.base.Result<?>
	 **/
	@RequestMapping("/clonePlatformActivity")
	public Result<?> clonePlatformActivity(
			@RequestParam(value = "communityId") int communityId,
			@RequestParam(value = "categoryId") int categoryId,
			@RequestParam(value = "actAddress", required = false) String actAddress,
			@RequestParam(value = "actImg") String actImg,
			@RequestParam(value = "actTitle") String actTitle,
			@RequestParam(value = "detail", required = false) String detail,
			@RequestParam(value = "beginTime") String beginTime,
			@RequestParam(value = "endTime") String endTime,
            @RequestParam(required = false) String stores
	) throws Exception {
		validator(StringUtils.isBlank(beginTime), "活动开始时间不能为空");
		validator(StringUtils.isBlank(endTime), "活动结束时间不能为空");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date beginDate = DateTimeUtils.date000000(sdf.parse(beginTime));
		Date endDate = DateTimeUtils.date235959(sdf.parse(endTime));
		validator(endDate.getTime() <= beginDate.getTime(), "活动开始时间要小于结束时间");
		//查询sql
		Long id = openXFSJActivityService.clonePlatformActivity(OpenXFSJConstant.ActivityType.platform, categoryId,
				communityId, actAddress, actImg, actTitle,detail, beginDate, endDate, JSON.parseArray(stores));
		return Result.successData(id);
	}
}
