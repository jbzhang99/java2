package com.rfchina.community.open.bridge.controller.community;

import java.math.BigDecimal;
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
import com.rfchina.community.persistence.mapper.OpenServiceDetailMapper;
import com.rfchina.community.persistence.model.CommunityServiceCategory;
import com.rfchina.community.persistence.model.CommunityServiceTempExample;
import com.rfchina.community.persistence.model.OpenServiceDetailExample;

@RestController
@RequestMapping(value = OpenConstant.ROOT_PATH_COMMUNITY)
public class CommunityServiceCategoryAdminController extends BaseController {

	@Autowired
	private CommunityServiceCategoryService communityServiceCategoryService;

	@Autowired
	private CommunityServiceTempMapper communityServiceTempMapper;
	@Autowired
	private OpenServiceDetailMapper openServiceDetailMapper;

	// @Autowired
	// private CommunityServicePFService communityServiceService;

	private long getCommunityServiceTempCount(int categoryId) {
		CommunityServiceTempExample example = new CommunityServiceTempExample();
		example.createCriteria().andCategoryIdEqualTo(categoryId);
		return communityServiceTempMapper.countByExample(example);
	}

	private long getOpenServiceDetailExampleCount(int categoryId) {
		OpenServiceDetailExample example = new OpenServiceDetailExample();
		example.createCriteria().andCategorySecondTypeEqualTo(categoryId);
		return openServiceDetailMapper.countByExample(example);
	}

	@RequestMapping("/addCommunityServiceCategory")
	public Result<?> addCommunityServiceCategory(@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "sort", defaultValue = "999") int sort,
			@RequestParam(value = "type", required = true) int type,
			@RequestParam(value = "premiumNum", required = true) int premiumNum,
			@RequestParam(value = "communityFee", required = true) BigDecimal communityFee,
			@RequestParam(value = "exposure", defaultValue = "1") int exposure) {

		if (StringUtils.isBlank(name)) {
			error("类别名称不能为空");
		}
		validator(name.length() > 6, "支持中英文、数字、符号。不超过6个字");

		Long count = communityServiceCategoryService.getCommunityServiceCategory(name, 0,type);
		if (count != null && count > 0) {
			error("类别名称已经存在");
		}
		validator(type != 3, "现在只能增加小富市集分类!");
		validator(premiumNum < 0, "必须正整数溢价幅度!");
		validator(communityFee.compareTo(BigDecimal.valueOf(0)) < 0, "社区服务费不能小于0");
		validator(communityFee.compareTo(BigDecimal.valueOf(99)) > 0, "社区服务费不能大于99");
		CommunityServiceCategory communityServiceCategory = new CommunityServiceCategory();
		communityServiceCategory.setCreateTime(new Date());
		communityServiceCategory.setType(type);
		communityServiceCategory.setName(name);
		communityServiceCategory.setSort(sort);
		communityServiceCategory.setExposure(exposure);
		communityServiceCategory.setCommunityFee(communityFee);
		communityServiceCategory.setPremiumNum(premiumNum);

		communityServiceCategoryService.addCommunityServiceCategory(communityServiceCategory);

		return Result.successData(communityServiceCategory);
	}

	@RequestMapping("/deleteCommunityServiceCategory")
	public Result<?> deleteCommunityServiceCategory(@RequestParam("id") int id) {

		// 判断是否被服务所应用
		validator(getCommunityServiceTempCount(id) > 0, "此服务类别已被服务所应用，不能进行删除");
		validator(getOpenServiceDetailExampleCount(id) > 0, "此二级分类已被服务所应用，不能进行删除");
		CommunityServiceCategory data = communityServiceCategoryService.getCommunityServiceCategory(id);
		validator(data.getType() == 1, "系统分类不能删除");
		validator(data.getType() == 4, "系统分类不能删除");
		validator(data.getType() == 0, "系统分类不能删除");
		int i = communityServiceCategoryService.deleteCommunityServiceCategory(id);
		return Result.successData(i);
	}

	@RequestMapping("/updateCommunityServiceCategory")
	public Result<?> updateCommunityServiceCategory(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam(value = "sort", defaultValue = "999") int sort,
			@RequestParam(value = "premiumNum", required = true) int premiumNum,
			@RequestParam(value = "communityFee", required = true) BigDecimal communityFee) {
		CommunityServiceCategory data = communityServiceCategoryService.getCommunityServiceCategory(id);
		validator(data.getType() == 1, "系统分类不能修改");
		long count = communityServiceCategoryService.getCommunityServiceCategory(name, id,data.getType());
		if (count > 0) {
			error("类别名称已经存在");
		}
		validator(premiumNum < 0, "必须正整数溢价幅度!");
		validator(communityFee.compareTo(BigDecimal.valueOf(0)) < 0, "社区服务费不能小于0");
		validator(communityFee.compareTo(BigDecimal.valueOf(99)) > 0, "社区服务费不能大于99");
		validator(name.length() > 6, "支持中英文、数字、符号。不超过6个字");

		data.setName(name);
		data.setCommunityFee(communityFee);
		data.setPremiumNum(premiumNum);
		data.setSort(sort);
		int i = communityServiceCategoryService.updateCommunityServiceCategory(data);
		return Result.successData(i);
	}

	@RequestMapping("/listCommunityServiceCategory")
	public Result<?> listCommunityServiceCategory(@RequestParam(value = "type", defaultValue = "3") int type,
			@RequestParam(value = "index", required = false, defaultValue = "1") int index,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size) {
		return Result.successData(communityServiceCategoryService.getCommunityServiceCategoryList(index, size, type));
	}
}
