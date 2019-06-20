package com.rfchina.community.openweb.controller;

import com.rfchina.community.base.Constant;
import com.rfchina.community.base.Result;
import com.rfchina.community.component.AreaComponent;
import com.rfchina.community.openweb.entity.CityCommunity;
import com.rfchina.community.openweb.entity.SimCommunity;
import com.rfchina.community.openweb.service.CommunityService;
import com.rfchina.community.persistence.model.Area;
import com.rfchina.community.persistence.model.AreaExample;
import com.rfchina.community.persistence.model.Community;
import com.rfchina.community.service.AreaBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 */
@RestController
@RequestMapping(value = {Constant.ROOT_PATH_OPENWEB})
public class AreaController extends BaseController {

	@Autowired
	private AreaBaseService areaBaseService;
	@Autowired
	private CommunityService communityService;
	@Autowired
	private AreaComponent areaComponent;

	@RequestMapping(value = {"/get_area_list"})
	public Result<?> getAreaList(@RequestParam(value = "parent_id", required = false, defaultValue = "100000") Integer parentId) {
		AreaExample example = new AreaExample();
		example.createCriteria().andParentIdEqualTo(parentId);
		List<Area> list = areaBaseService.selectByExample(example);
		return Result.successData(list);
	}
	
	/**
	 * @author:fukangwen
	 * @Description: 获取有社区的城市已经城市包含的社区
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping(value = {"/xfsj/get_area_list"})
	public Result<?> getXFSJAreaList() {
		List<Community> communityList = communityService.getCommunityList();
		if(communityList.isEmpty())
			return Result.successData(new ArrayList<>());
		
		Map<Integer, List<Community>> communityListMap = communityList.stream()
                .distinct()
                .collect(Collectors.groupingBy(Community::getCityId));
		
		List<CityCommunity> cityCommunityList = new ArrayList<>();
		communityListMap.forEach((k, v) -> {
            Area area = areaComponent.getArea(k);
            if(area == null)
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
	
}
