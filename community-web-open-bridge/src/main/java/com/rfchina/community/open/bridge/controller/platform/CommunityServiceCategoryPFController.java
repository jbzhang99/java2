package com.rfchina.community.open.bridge.controller.platform;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.Result;
import com.rfchina.community.open.bridge.controller.BaseController;
import com.rfchina.community.open.bridge.service.CommunityServiceCategoryService;
import com.rfchina.community.persistence.mapper.CommunityServiceTempMapper;
import com.rfchina.community.persistence.model.CommunityServiceCategory;
import com.rfchina.community.persistence.model.CommunityServiceTempExample;

/**
 * @author:fukangwen
 * @Description: 第三方服务分类
 */
@RestController
@RequestMapping(value = OpenConstant.ROOT_PATH_PLATFORM)
public class CommunityServiceCategoryPFController extends BaseController {

	@Autowired
	private CommunityServiceCategoryService communityServiceCategoryService;

	@Autowired
	private CommunityServiceTempMapper communityServiceTempMapper;

	// @Autowired
	// private CommunityServicePFService communityServiceService;
	private long getCommunityServiceTempCount(int categoryId) {
		CommunityServiceTempExample example = new CommunityServiceTempExample();
		example.createCriteria().andCategoryIdEqualTo(categoryId);
		return communityServiceTempMapper.countByExample(example);
	}

	@RequestMapping("/addCommunityServiceCategory")
	public Result<?> addCommunityServiceCategory(@RequestParam("name") String name,
			@RequestParam(value = "sort", defaultValue = "999") int sort) {

		if (StringUtils.isBlank(name)) {
			error("类别名称不能为空");
		}
		Long count = communityServiceCategoryService.getCommunityServiceCategory(name, 0, 2);
		if (count != null && count > 0) {
			error("类别名称已经存在");
		}
		CommunityServiceCategory communityServiceCategory = new CommunityServiceCategory();
		communityServiceCategory.setCreateTime(new Date());
		communityServiceCategory.setType(2);
		communityServiceCategory.setName(name);
		communityServiceCategory.setSort(sort);
		communityServiceCategoryService.addCommunityServiceCategory(communityServiceCategory);

		return Result.successData(communityServiceCategory);
	}

	@RequestMapping("/deleteCommunityServiceCategory")
	public Result<?> deleteCommunityServiceCategory(@RequestParam("id") int id) {

		// 判断是否被服务所应用
		if (getCommunityServiceTempCount(id) > 0) {
			error("此服务类别已被服务所应用，不能进行删除");
		}
		CommunityServiceCategory data = communityServiceCategoryService.getCommunityServiceCategory(id);
		validator(data.getType() == 1, "系统分类不能删除");
		communityServiceCategoryService.deleteCommunityServiceCategory(id);
		return Result.success();
	}

	@RequestMapping("/updateCommunityServiceCategory")
	public Result<?> updateCommunityServiceCategory(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam(value = "sort", defaultValue = "999") int sort) {
		CommunityServiceCategory data = communityServiceCategoryService.getCommunityServiceCategory(id);
		validator(data.getType() == 1, "系统分类不能修改");
		long count = communityServiceCategoryService.getCommunityServiceCategory(name, id, data.getType());
		if (count > 0) {
			error("类别名称已经存在");
		}
		data.setName(name);
		data.setSort(sort);
		communityServiceCategoryService.updateCommunityServiceCategory(data);
		return Result.successData(data);
	}

	@RequestMapping("/getCommunityServiceCategoryList")
	public Result<?> getCommunityServiceCategoryList(@RequestParam(value = "type", defaultValue = "2") int type,
			@RequestParam(value = "index", required = false, defaultValue = "1") int index,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size) {
		return Result.successData(communityServiceCategoryService.getCommunityServiceCategoryList(index, size, type));
	}
}
