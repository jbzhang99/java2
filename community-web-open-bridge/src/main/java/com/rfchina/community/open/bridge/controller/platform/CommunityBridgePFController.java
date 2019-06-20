package com.rfchina.community.open.bridge.controller.platform;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rfchina.community.base.Constant;
import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.Result;
import com.rfchina.community.component.AreaComponent;
import com.rfchina.community.open.bridge.entity.CityCommunity;
import com.rfchina.community.open.bridge.entity.SimCommunity;
import com.rfchina.community.open.bridge.service.CommunityBridgeService;
import com.rfchina.community.persistence.model.Area;
import com.rfchina.community.persistence.model.Community;

@RestController
@RequestMapping(value = OpenConstant.ROOT_PATH_PLATFORM)
public class CommunityBridgePFController {

	@Autowired
	private CommunityBridgeService communityService;
	@Autowired
	private AreaComponent areaComponent;

	/**
	 * @author:fukangwen @Description: 获取有社区的城市已经城市包含的社区 @return Result<?> @throws
	 */
	@RequestMapping(value = { "/city_by_community" })
	public Result<?> searchCityByCommuntiy() {
		List<Community> communityList = communityService.getCommunityList(Constant.CommunityCategory.ENTITY);
		if (communityList.isEmpty())
			return Result.successData(new ArrayList<>());

		Map<Integer, List<Community>> communityListMap = communityList.stream().distinct()
				.collect(Collectors.groupingBy(Community::getCityId));

		List<CityCommunity> cityCommunityList = new ArrayList<>();
		communityListMap.forEach((k, v) -> {
			Area area = areaComponent.getArea(k);
			if (area == null)
				return;
			CityCommunity cityCommunity = new CityCommunity();
			cityCommunity.setCityId(area.getId());
			cityCommunity.setCityName(area.getName());
			cityCommunity.setCommunityList(v.stream().map(c -> {
				SimCommunity simCommunity = new SimCommunity();
				simCommunity.setCommunityId(c.getId());
				simCommunity.setCommunityName(c.getName());
				return simCommunity;
			}).distinct().collect(Collectors.toList()));

			cityCommunityList.add(cityCommunity);
		});
		return Result.successData(cityCommunityList);
	}

	@RequestMapping(value = { "/community_list_by_category" })
	public Result<?> getCommunityList(@RequestParam(value = "category", required = false) Integer category) {
		List<Community> communityList = communityService.getCommunityList(category);
		return Result.successData(communityList);
	}
	
	@RequestMapping(value = { "/list_virtural_community" })
	public Result<?> list_virtural_community(
			@RequestParam(value = "category", required = false, defaultValue="2") Integer category) {
		return Result.successData(communityService.listVirturalCommunity(category));
	}
}
