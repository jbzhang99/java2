package com.rfchina.community.openstore.controller;

import com.rfchina.community.base.Constant;
import com.rfchina.community.base.Result;
import com.rfchina.community.openstore.entity.AreaVO;
import com.rfchina.community.persistence.model.Area;
import com.rfchina.community.persistence.model.AreaExample;
import com.rfchina.community.service.AreaBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 */
@RestController
@RequestMapping(value = {Constant.ROOT_PATH_OPENSTORE})
public class AreaController extends BaseController {

	@Autowired
	private AreaBaseService areaBaseService;

	@RequestMapping(value = {"/get_area_list"})
	public Result<?> getAreaList(@RequestParam(value = "parent_id", required = false, defaultValue = "100000") Integer parentId) {
		AreaExample example = new AreaExample();
		example.createCriteria().andParentIdEqualTo(parentId);
		List<Area> list = areaBaseService.selectByExample(example);
		return Result.successData(list);
	}
	
	@RequestMapping(value = {"/gender_area_list"})
	public Result<?> genderAreaList(@RequestParam(value = "parent_id", required = false, defaultValue = "100000") Integer parentId) {
		return Result.successData(this.genderAreaVO(parentId));
	}

	@RequestMapping(value = {"/group_area_list"})
	public Result<?> getAreaList() {
		return Result.successData(areaBaseService.groupCityHasCommunity());
	}

	private List<AreaVO> genderAreaVO(int parentId){
		List<Area> list = this.getAreaByParentId(parentId);
		List<AreaVO> volist = new ArrayList<>();
		if(!list.isEmpty()) {
			for(Area area : list) {
				AreaVO vo  = new AreaVO();
				vo.setId(area.getId());
				vo.setName(area.getName());
				vo.setParentId(area.getParentId());
				vo.setChildren(this.genderAreaVO(area.getId()));
				volist.add(vo);
			}
		}
		return volist;
	}
	
	
	private List<Area> getAreaByParentId(int parentId){
		AreaExample example = new AreaExample();
		example.createCriteria().andParentIdEqualTo(parentId);
		return areaBaseService.selectByExample(example);
	}
}
