package com.rfchina.community.openstore.controller;

import com.github.pagehelper.PageInfo;
import com.rfchina.community.base.Constant;
import com.rfchina.community.base.OpenGoodGroupConstant;
import com.rfchina.community.base.Result;
import com.rfchina.community.openstore.service.OpenStoreGroupDataService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

/**
 *团数据
 */
@RestController
@RequestMapping(value = {Constant.ROOT_PATH_OPENSTORE})
public class OpenStoreGroupDataPFController extends BaseController {

	@Autowired
	private OpenStoreGroupDataService openStoreGroupDataService;


	/**
	 * 详情
	 */
	@RequestMapping(value={"/groupdata/getDetail"})
	public Result<?> getDetail(
			@RequestParam(value = "id") long id,
			@RequestParam(value = "accessToken",required = false) String token
		) {
		//Long uid = this.getUidId();
		return Result.successData(openStoreGroupDataService.groupDataDetailList(id, StringUtils.isNotBlank(token) ? getUidByToken(token) : 0L));
	}


	/**
	 * 正在拼单详情列表
	 */
	@RequestMapping(value={"/groupdata/getGroupDataList"})
	public Result<?> pageByParam(
			@RequestParam(value = "groupInfoId") Long groupInfoId,
			@RequestParam(value = "index", required = false, defaultValue = "1") int index,
			@RequestParam(value = "size", required = false, defaultValue = "20") int size	//默认20
	) throws ParseException {
		PageInfo list = openStoreGroupDataService.getOpenStoreGroupDataList(groupInfoId, OpenGoodGroupConstant.dataStatus.un_success,
				index, size);
		return Result.successData(list);
	}

}
