package com.rfchina.community.open.bridge.controller.platform;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.Result;
import com.rfchina.community.open.bridge.controller.BaseController;
import com.rfchina.community.open.bridge.entity.ExtCommunityServiceCategory;
import com.rfchina.community.open.bridge.service.CommunityServiceCategoryService;
import com.rfchina.community.persistence.mapper.CommunityServiceCategoryTypeMapper;
import com.rfchina.community.persistence.model.CommunityServiceCategory;
import com.rfchina.community.persistence.model.CommunityServiceCategoryType;
import com.rfchina.community.persistence.model.CommunityServiceCategoryTypeExample;


/**
 * @author:fukangwen
 * @Description: 统一起来，所有类型都按照这个方式来
 */
@RestController
@RequestMapping(value = OpenConstant.ROOT_PATH_PLATFORM)
public class CommunityServiceCategoryGatherController extends BaseController {

	@Autowired
	private CommunityServiceCategoryService communityServiceCategoryService;
	@Autowired
	private CommunityServiceCategoryTypeMapper communityServiceCategoryTypeMapper;
	@Value("${open.storeapi.url}")
	private String openStoreapiUrl;

	/**
	 * @author:fukangwen
	 * @Description: 获取分类的类型,物业类型不让操作编辑，使用无效状态
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping("/getCategoryTypeList")
	public Result<?> getCategoryTypeList() {
		CommunityServiceCategoryTypeExample example = new CommunityServiceCategoryTypeExample();
		example.createCriteria().andValidStatusEqualTo(1);//1为有效
		return Result.successData(communityServiceCategoryTypeMapper.selectByExample(example));
	}
	
	/**
	 * @author:fukangwen
	 * @Description: 增加分类
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping("/addCategory")
	public Result<?> addCategory(@RequestParam(value = "sort", defaultValue = "999") int sort,
			@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "type", required = true) int type,
			@RequestParam(value = "premiumNum", required = false) Integer premiumNum, //小富市集必填
			@RequestParam(value = "communityFee", required = false) BigDecimal communityFee,//小富市集必填
			@RequestParam(value = "exposure", defaultValue = "1") int exposure,
			@RequestParam(value = "png", required = false) String png
			) {

		if (StringUtils.isBlank(name)) {
			error("类别名称不能为空");
		}
		
		if(name.length() > 6) {
			error("名称不能为超过6位");
		}
		if(type == 3) {//小富市集类型
			validator(premiumNum == null, "小富市集类型商品溢价幅度必填");
			validator(communityFee == null, "小富市集类型社区服务费必填");
		}
		
		Long count = communityServiceCategoryService.getCommunityServiceCategory(name, 0, type);
		if (count != null && count > 0) {
			error("类别名称已经存在");
		}
		
		CommunityServiceCategory communityServiceCategory = new CommunityServiceCategory();
		communityServiceCategory.setCreateTime(new Date());
		communityServiceCategory.setType(type);
		communityServiceCategory.setName(name);
		communityServiceCategory.setSort(sort);
		communityServiceCategory.setCommunityFee(communityFee);
		communityServiceCategory.setPremiumNum(premiumNum);
		communityServiceCategory.setExposure(exposure);
		communityServiceCategory.setPng(png);
		
		communityServiceCategoryService.addCommunityServiceCategory(communityServiceCategory);
		
		// 625 商品类型需要生产访问地址
		if(type == 5) {
			communityServiceCategory.setLink(openStoreapiUrl + "index.html#/market/" + communityServiceCategory.getId() + "?isNew=1");
			communityServiceCategoryService.updateCommunityServiceCategory(communityServiceCategory);
		}

		return Result.successData(communityServiceCategory);
	}

	/**
	 * @author:fukangwen
	 * @Description: 删除分类，逻辑删除
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping("/deleteCategory")
	public Result<?> deleteCommunityServiceCategory(@RequestParam("id") int id) {
		CommunityServiceCategory data = communityServiceCategoryService.getCommunityServiceCategory(id);
		validator(data.getType() == 1 || data.getType() == 0 ||data.getType() == 4, "系统分类不能删除");
		
		data.setValidStatus(OpenConstant.CategoryStatus.invalid_status);
		data.setExposure(2);//不曝光
		communityServiceCategoryService.updateCommunityServiceCategory(data);
		return Result.success();
	}

	/**
	 * @author:fukangwen
	 * @Description: 更新分类名称
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping("/updateCategory")
	public Result<?> updateCommunityServiceCategory(
			@RequestParam("id") int id,
			@RequestParam("name") String name,
			@RequestParam(value = "sort", defaultValue = "999") int sort,
			@RequestParam(value = "premiumNum", required = true) int premiumNum,
			@RequestParam(value = "communityFee", required = true) BigDecimal communityFee,
			@RequestParam(value = "exposure", required = true) int exposure,
			@RequestParam(value = "png", required = false) String png) {
		
		if (StringUtils.isBlank(name)) {
			error("类别名称不能为空");
		}
		
		if(name.length() > 6) {
			error("名称不能为超过6位");
		}
		
		CommunityServiceCategory data = communityServiceCategoryService.getCommunityServiceCategory(id);
		validator(data.getType() == 1 || data.getType() == 0 ||data.getType() == 4, "系统分类不能修改");
		long count = communityServiceCategoryService.getCommunityServiceCategory(name, id, data.getType());
		if (count > 0) {
			error("类别名称已经存在");
		}
		if(data.getType() == 3) {//小富市集类型
			validator(premiumNum < 0, "必须正整数溢价幅度!");
			validator(communityFee.compareTo(BigDecimal.valueOf(0)) < 0, "社区服务费不能小于0");
			validator(communityFee.compareTo(BigDecimal.valueOf(99)) > 0, "社区服务费不能大于99");
		}
		data.setName(name);
		data.setSort(sort);
		data.setCommunityFee(communityFee);
		data.setPremiumNum(premiumNum);
		data.setExposure(exposure);
		data.setPng(png);
		communityServiceCategoryService.updateCommunityServiceCategory(data);
		return Result.successData(data);
	}

	/**
	 * @author:fukangwen
	 * @Description: 类型列表
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping("/getCategoryList")
	public Result<?> getCommunityServiceCategoryList(
			@RequestParam(value = "type", defaultValue = "2") int type,
			@RequestParam(value = "index", required = false, defaultValue = "1") int index,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size) {
		return Result.successData(communityServiceCategoryService.getCategoryList(index, size, type));
	}

	/**
	 * @author:fukangwen
	 * @Description: 活动业务
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping("/getActivityCategoryList")
	public Result<?> getActivityCategoryList() {
		return Result.successData(communityServiceCategoryService.getActivityCategoryList());
	}
	
	/**
	 * @author:fukangwen
	 * @Description: 分类详情
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping("/getCategory")
	public Result<?> getCommunityServiceCategory(
			@RequestParam(value = "categoryId", required=true) int categoryId) {
		CommunityServiceCategory category = communityServiceCategoryService.getCommunityServiceCategory(categoryId);
		validator(category == null, "该分类已删除");
		ExtCommunityServiceCategory extCategory = new ExtCommunityServiceCategory();
		BeanUtils.copyProperties(category, extCategory);
		CommunityServiceCategoryType type = communityServiceCategoryTypeMapper.selectByPrimaryKey(category.getType());
		extCategory.setCategoryTypeName(type == null ? "" : type.getName());
		return Result.successData(extCategory);
	}
}
