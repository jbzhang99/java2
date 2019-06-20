package com.rfchina.community.open.bridge.controller.platform;

import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.Result;
import com.rfchina.community.base.util.DateTimeUtils;
import com.rfchina.community.open.bridge.controller.BaseController;
import com.rfchina.community.open.bridge.entity.ExtOpenStoreGroupData;
import com.rfchina.community.open.bridge.service.OpenStoreGroupDataService;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.paginator.model.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *团数据
 */
@RestController
@RequestMapping(value = OpenConstant.ROOT_PATH_PLATFORM)
public class OpenStoreGroupDataPFController extends BaseController {

	@Autowired
	private OpenStoreGroupDataService openStoreGroupDataService;


	/**
	 * 详情
	 */

	@RequestMapping(value={"/groupdata_getDetail"})
	public Result<?> getDetail(
			@RequestParam(value = "id") long id
		) {
		return Result.successData(openStoreGroupDataService.groupDataDetailList(id));
	}


	/**
	 * 列表搜索
	 */
	@RequestMapping(value={"/groupdata_pageByParam"})

	public Result<?> pageByParam(
			@RequestParam(value = "groupInfoId", required = false) Long groupInfoId,
			@RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "goodName", required = false, defaultValue = "") String goodName,
			@RequestParam(value = "serviceName", required = false, defaultValue = "") String serviceName,
			@RequestParam(value = "phone", required = false, defaultValue = "") String phone,
			@RequestParam(value = "type", required = false, defaultValue = "1") String type,
			@RequestParam(value = "status", required = false) Integer status,
			@RequestParam(value = "startTime", required = false, defaultValue = "") String startTime,
			@RequestParam(value = "endTime", required = false, defaultValue = "") String endTime,
			@RequestParam(value = "startSuccessTime", required = false, defaultValue = "") String startSuccessTime,
			@RequestParam(value = "endSuccessTime", required = false, defaultValue = "") String endSuccessTime,
			@RequestParam(value = "index", required = false, defaultValue = "1") int index,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size
	) throws ParseException {

		Date startDate = null;
		Date endDate = null;
		Date startSuccessDate = null;
		Date endSuccessDate = null;

		if(StringUtils.isNotBlank(startTime) && StringUtils.isNotBlank(endTime)){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			startDate = DateTimeUtils.date000000(sdf.parse(startTime));
			endDate = DateTimeUtils.date235959(sdf.parse(endTime));
		}
		if(StringUtils.isNotBlank(startSuccessTime) && StringUtils.isNotBlank(endSuccessTime)){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			startSuccessDate = DateTimeUtils.date000000(sdf.parse(startSuccessTime));
			endSuccessDate = DateTimeUtils.date235959(sdf.parse(endSuccessTime));
		}

		PageList<ExtOpenStoreGroupData> list = openStoreGroupDataService.pageByParam(groupInfoId, id, goodName, serviceName, phone, startDate,
				endDate, startSuccessDate, endSuccessDate, status, index, size);
		return Result.successData(list.convert());
	}

}
