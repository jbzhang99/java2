package com.rfchina.community.open.bridge.controller.platform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.Result;
import com.rfchina.community.open.bridge.controller.BaseController;
import com.rfchina.community.persistence.mapper.OpenServiceDetailMapper;
import com.rfchina.community.persistence.model.OpenServiceDetail;

@RestController
@RequestMapping(value = OpenConstant.ROOT_PATH_PLATFORM)
public class CommunityServiceDetailPFController extends BaseController {

	@Autowired
	private OpenServiceDetailMapper openServiceDetailMapper;

	@RequestMapping("/updateOpenServiceDetail")
	public Result<?> updateOpenServiceDetail(@RequestParam(value = "serviceId") int serviceId,
			@RequestParam(value = "appIndexSort", defaultValue = "0") Integer appIndexSort,
			@RequestParam(value = "appCatSort", defaultValue = "999") Integer appCatSort) {
		OpenServiceDetail detail = openServiceDetailMapper.selectByPrimaryKey(serviceId);
		validator(detail == null, "请联系工程师,不存在!" + serviceId);
		detail.setAppIndexSort(appIndexSort);
		detail.setAppCatSort(appCatSort);
		openServiceDetailMapper.updateByPrimaryKeySelective(detail);
		return Result.successData(detail);
	}

	@RequestMapping("/updateServiceVerifyStatus")
	public Result<?> updateServiceVerifyStatus(@RequestParam(value = "serviceId") int serviceId,
			@RequestParam(value = "verifyRole") String verifyRole) {
		OpenServiceDetail detail = openServiceDetailMapper.selectByPrimaryKey(serviceId);
		validator(detail == null, "请联系工程师,不存在!" + serviceId);

		OpenServiceDetail data = new OpenServiceDetail();
		data.setServiceId(serviceId);
		data.setVerifyRole(verifyRole);

		openServiceDetailMapper.updateByPrimaryKeySelective(data);
		return Result.successData(detail);
	}



}
