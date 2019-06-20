package com.rfchina.community.openapi.controller;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rfchina.community.base.Constant;
import com.rfchina.community.openapi.base.Result;
import com.rfchina.community.openapi.entity.ExtCommunity;
import com.rfchina.community.openapi.service.AreaService;
import com.rfchina.community.openapi.service.CommunityService;
import com.rfchina.community.persistence.model.Area;
import com.rfchina.community.persistence.model.Community;

@RestController
@RequestMapping(value = Constant.ROOT_PATH_OPEN)
public class CommunityController extends BaseController{

	@Autowired
	private CommunityService communityService;
	
	@Autowired
	private AreaService areaService;
	
	private static transient Logger logger = LoggerFactory.getLogger(CommunityController.class);
	
	@RequestMapping("/community_info")
	public Result<?> getCommunity(@RequestParam("community_id") int communityId) throws IllegalAccessException, InvocationTargetException{
		
		logger.info("查询信息，communityId:{}",communityId);
		
		Community community = communityService.getCommunity(communityId);
		
		ExtCommunity extCommunity = new ExtCommunity();
		
		if(community == null){
			error("社区ID："+communityId+",对应的社区信息不存在");
		}
		
		if(community.getStatus() != 1){
			error("社区ID："+communityId+",对应的社区已被禁用");
		}
		
		if(community != null){
			extCommunity.setAddress(community.getAddress());
			extCommunity.setId(community.getId());
			extCommunity.setIntro(community.getIntro());
			extCommunity.setLogo_url(community.getLogoUrl());
			extCommunity.setName(community.getName());
			
			//查询区域名称
			Area area = areaService.getArea(community.getAreaId());
			
			if(area != null){
				extCommunity.setArea_name(area.getMergerName());
			}
		}
		
		System.out.println(extCommunity.toString());
	
		return Result.successData(extCommunity);
	}
}
