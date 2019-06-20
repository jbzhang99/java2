package com.rfchina.community.open.bridge.controller.community;

import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.Result;
import com.rfchina.community.open.bridge.service.CommunityBridgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = OpenConstant.ROOT_PATH_COMMUNITY)
public class CommunityBridgeController {

	@Autowired
	private CommunityBridgeService communityService;

	/**
	 * 有效城市
	 * 
	 * @return
	 */
	@RequestMapping("/city_by_community")
	public Result<?> searchCityByCommuntiy() {
		return Result.successData(communityService.searchCityByCommuntiy());
	}

}
