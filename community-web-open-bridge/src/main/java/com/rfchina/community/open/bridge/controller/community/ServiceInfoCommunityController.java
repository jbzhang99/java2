package com.rfchina.community.open.bridge.controller.community;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.Result;
import com.rfchina.community.open.bridge.controller.BaseController;
import com.rfchina.community.open.bridge.entity.KeyValueDomain;
import com.rfchina.community.open.bridge.service.CommunityServiceInfoService;
import com.rfchina.community.persistence.mapper.CommunityServiceMapper;
import com.rfchina.community.persistence.model.CommunityService;
import com.rfchina.community.persistence.model.CommunityServiceExample;
import com.rfchina.community.persistence.model.OpenMerchantInfo;

@RestController
@RequestMapping(value = OpenConstant.ROOT_PATH_COMMUNITY)
public class ServiceInfoCommunityController extends BaseController {

	@Autowired
	private CommunityServiceInfoService communityServiceInfoService;

	@RequestMapping("/getCommunityServiceInfo")
	public Result<?> getCommunityServiceInfo(@RequestParam(value = "id", required = true) Integer id) {

		JSONObject json = communityServiceInfoService.getCommunityServiceInfo(id);

		return Result.successData(json);
	}
	
	@RequestMapping(value = { "/searchCommunityServiceList" }, method = { RequestMethod.POST })
	public Result<?> getCommunityServiceList(
			@RequestParam("keyword") String keyword) {
		return Result.successData(communityServiceInfoService.searchCommunityServiceList(keyword));
	}

}
