package com.rfchina.community.open.bridge.controller.community;

import com.alibaba.fastjson.JSON;
import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.OpenXFSJConstant;
import com.rfchina.community.base.Result;
import com.rfchina.community.base.util.DateTimeUtils;
import com.rfchina.community.open.bridge.controller.BaseController;
import com.rfchina.community.open.bridge.entity.ExtOpenXFSJInfoBatch;
import com.rfchina.community.open.bridge.service.OpenXFSJActivityService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

//小富市集
@RestController
@RequestMapping(value = OpenConstant.ROOT_PATH_COMMUNITY)
public class OpenXFSJInfoController extends BaseController {

	@Autowired
	private OpenXFSJActivityService openXFSJActivityService;

	/**
	 * @author:fukangwen @Description: 根据社区显示该社区的小富市集活动 @return Result<?> @throws
	 */
	@RequestMapping("/listOpenXFSJInfo")
	public Result<?> listOpenXFSJInfo(@RequestParam(value = "cityId", required = false, defaultValue = "0") int cityId,
			@RequestParam(value = "communityIds", required = false, defaultValue = "0") int communityIds,
			@RequestParam(value = "signUpStatus", required = false, defaultValue = "0") int signUpStatus, // 1招商中，2停止招商
			@RequestParam(value = "index", required = false, defaultValue = "1") int index,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size) throws Exception {
		return Result.successData(
				openXFSJActivityService.listOpenXFSJInfo(communityIds, signUpStatus, index, size).convert());
	}

	@RequestMapping("/getOpenXFSJInfoStatus")
	public Result<?> getOpenXFSJInfoStatus(
			@RequestParam(value = "cityId", required = false, defaultValue = "0") int cityId,
			@RequestParam(value = "communityIds", required = false, defaultValue = "0") int communityIds)
			throws Exception {
		return Result.successData(openXFSJActivityService.getOpenXFSJInfoStatus(communityIds));
	}

	@RequestMapping("/getOpenXFSJInfo")
	public Result<?> getOpenXFSJInfo(@RequestParam(value = "id", required = true) Long id) throws Exception {

		return Result.successData(openXFSJActivityService.getOpenXFSJInfo(id));
	}

	@RequestMapping("/updateOpenXFSJInfoStatus")
	public Result<?> updateOpenXFSJInfoStatus(@RequestParam(value = "id", required = true) Long id,
			@RequestParam(value = "status", required = true) int status) throws Exception {

		int i = openXFSJActivityService.updateOpenXFSJInfoStatus(id, status);
		return Result.successData(i);
	}

	@RequestMapping("/createOpenXFSJInfo")
	public Result<?> createOpenXFSJInfo(
			@RequestParam(value = "cityId", required = false, defaultValue = "0") int cityId,
			@RequestParam(value = "communityIds", required = false, defaultValue = "0") int communityIds,
			@RequestParam(value = "actAddress", required = false) String actAddress,
			@RequestParam(value = "actImg", required = false) String actImg,
			@RequestParam(value = "actTime", required = false) String actTime,
			@RequestParam(value = "actTitile", required = false) String actTitile,
			@RequestParam(value = "detail", required = false) String detail,
			@RequestParam(value = "beginTime", required = false, defaultValue = "") String beginTime,
			@RequestParam(value = "endTime", required = false, defaultValue = "") String endTime,
			@RequestParam(value = "signUpEndTime", required = false, defaultValue = "") String signUpEndTime,
			@RequestParam(value = "amount", required = true) int amount,
			@RequestParam(value = "serviceFee", required = true) BigDecimal serviceFee,
			@RequestParam(value = "resource", required = false) String resource,
			@RequestParam(value = "localeImg", required = true) String localeImg,
			@RequestParam(value = "type", required = true) String type,
			@RequestParam(value = "contactPhone", required = true) String contactPhone,
			@RequestParam(value = "localeDetail", required = false) String localeDetail,
			@RequestParam(value = "groupConfigId", required = false, defaultValue = "1") long groupConfigId, // 默认第一个
			@RequestParam(value = "areaConfigId", required = false, defaultValue = "1") long areaConfigId)
			throws Exception {
		validator(StringUtils.isBlank(beginTime), "活动开始时间不能为空");
		validator(StringUtils.isBlank(endTime), "活动结束时间不能为空");
		validator(StringUtils.isBlank(signUpEndTime), "报名截止时间不能为空");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date beginDate = DateTimeUtils.date000000(sdf.parse(beginTime));
		Date endDate = DateTimeUtils.date235959(sdf.parse(endTime));
		Date signUpEndDate = sdf.parse(signUpEndTime);
		validator(endDate.getTime() <= beginDate.getTime(), "活动开始时间要小于结束时间");
		validator(beginDate.getTime() <= signUpEndDate.getTime(), "活动报名时间要小于活动开始时间");
		validator(amount < 1, "招商名额需正整数");

		Long id = openXFSJActivityService.createOpenXFSJInfo(OpenXFSJConstant.ActivityType.community, 3, communityIds,
				actAddress, actImg, actTime, actTitile, detail, beginDate, endDate, signUpEndDate, amount, serviceFee,
				resource, localeImg, type, contactPhone, localeDetail, groupConfigId, areaConfigId);
		return Result.successData(id);
	}

	@RequestMapping("/createOpenXFSJInfoBatch")
	public Result<?> createOpenXFSJInfoBatch(@RequestParam(value = "actImg", required = false) String actImg,
			@RequestParam(value = "actTime", required = false) String actTime,
			@RequestParam(value = "actTitile", required = false) String actTitile,
			@RequestParam(value = "detail", required = false) String detail,
			@RequestParam(value = "beginTime", required = false, defaultValue = "") String beginTime,
			@RequestParam(value = "endTime", required = false, defaultValue = "") String endTime,
			@RequestParam(value = "signUpEndTime", required = false, defaultValue = "") String signUpEndTime,
			@RequestParam(value = "resource", required = false) String resource,
			@RequestParam(value = "localeImg", required = true) String localeImg,
			@RequestParam(value = "type", required = true) String type,
			@RequestParam(value = "batchData", required = true) String batchData,
			@RequestParam(value = "localeDetail", required = false) String localeDetail,
			@RequestParam(value = "groupConfigId", required = false, defaultValue = "1") long groupConfigId, // 默认第一个
			@RequestParam(value = "areaConfigId", required = false, defaultValue = "1") long areaConfigId)
			throws Exception {
		validator(StringUtils.isBlank(beginTime), "活动开始时间不能为空");
		validator(StringUtils.isBlank(endTime), "活动结束时间不能为空");
		validator(StringUtils.isBlank(batchData), "批量信息不能为空!");
		validator(StringUtils.isBlank(signUpEndTime), "报名截止时间不能为空");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date beginDate = DateTimeUtils.date000000(sdf.parse(beginTime));
		Date endDate = DateTimeUtils.date235959(sdf.parse(endTime));
		Date signUpEndDate = sdf.parse(signUpEndTime);
		validator(endDate.getTime() <= beginDate.getTime(), "活动开始时间要小于结束时间");
		validator(beginDate.getTime() <= signUpEndDate.getTime(), "活动报名时间要小于活动开始时间");

		List<ExtOpenXFSJInfoBatch> list = null;

		try {

			list = JSON.parseArray(batchData, ExtOpenXFSJInfoBatch.class);
		} catch (Exception e) {
			logger.info(batchData+"\t"+e.getMessage(), e);
			validator(true, e.getMessage());
		}

		

		
		for (ExtOpenXFSJInfoBatch extOpenXFSJInfoBatch : list) {
			validator(extOpenXFSJInfoBatch.getAmount() < 1, "招商名额需正整数");
		}

		return Result.success();
	}

	@RequestMapping("/updateOpenXFSJInfo")
	public Result<?> updateOpenXFSJInfo(@RequestParam(value = "id", required = true) Long id,
			@RequestParam(value = "actAddress", required = false) String actAddress,
			@RequestParam(value = "actImg", required = false) String actImg,
			@RequestParam(value = "actTime", required = false) String actTime,
			@RequestParam(value = "actTitile", required = false) String actTitile,
			@RequestParam(value = "detail", required = false) String detail,
			@RequestParam(value = "groupConfigId", required = false, defaultValue = "1") long groupConfigId, // 默认第一个
			@RequestParam(value = "areaConfigId", required = false, defaultValue = "1") long areaConfigId)
			throws Exception {

		int i = openXFSJActivityService.updateOpenXFSJInfo(id, 0, 3, actAddress, actImg, actTime, actTitile, detail,
				groupConfigId, areaConfigId, null, null);
		return Result.successData(i);
	}

	@RequestMapping("/createOpenXFSJStoreGood")
	public Result<?> createOpenXFSJStoreGood(
			@RequestParam(value = "cityId", required = false, defaultValue = "0") int cityId,
			@RequestParam(value = "communityIds", required = false, defaultValue = "0") int communityIds,
			@RequestParam(value = "xfsjId", required = true) Long xfsjId,
			@RequestParam(value = "goodId", required = true) Integer goodId,
			@RequestParam(value = "type", required = true) Integer type,
			@RequestParam(value = "storeId", required = true) Integer storeId,
			@RequestParam(value = "img", required = false) String img,
			@RequestParam(value = "title", required = false) String title,
			@RequestParam(value = "orderby", required = false, defaultValue = "0") Integer orderby) throws Exception {
		long id = openXFSJActivityService.createOpenXFSJStoreGood(xfsjId, goodId, type, storeId, img, title, orderby);
		return Result.successData(id);
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
		int i = openXFSJActivityService.deleteOpenXFSJStoreGood(xfsjId, id, OpenXFSJConstant.ActivityType.community);
		return Result.successData(i);
	}

	@RequestMapping("/listOpenXFSJStoreGood")
	public Result<?> listOpenXFSJStoreGood(@RequestParam(value = "xfsjId", required = true) Long xfsjId,
			@RequestParam(value = "type", required = true) Integer type) throws Exception {
		logger.info("url:listOpenXFSJStoreGood: params={}", xfsjId);
		return Result.successData(openXFSJActivityService.listOpenXFSJStoreGood(xfsjId, type));
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
			@RequestParam(value = "goodTitle", required = false) String goodTitle,
			@RequestParam(value = "index", required = false, defaultValue = "1") int index,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size) throws Exception {
		return Result.successData(openXFSJActivityService.listStoreGood(storeId, goodTitle, index, size).convert());
	}

	/**
	 * 获取巡查情况
	 */
	@RequestMapping("/getPatrolInfo")
	public Result<?> getPatrolInfo(@RequestParam(value = "xfsjId", required = true) long xfsjId) throws Exception {
		return Result.successData(openXFSJActivityService.getPatrolInfo(xfsjId));
	}
}
