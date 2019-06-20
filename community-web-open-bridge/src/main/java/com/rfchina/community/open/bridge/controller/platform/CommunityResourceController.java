package com.rfchina.community.open.bridge.controller.platform;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.Result;
import com.rfchina.community.base.StatusCode;
import com.rfchina.community.open.bridge.controller.BaseController;
import com.rfchina.community.open.bridge.entity.ExtCommunityResourceActivity;
import com.rfchina.community.open.bridge.service.CommunityResourceService;
import com.rfchina.community.persistence.model.CommunityResource;

/**
 * 活动资源管理
 * @author maixingnian
 * @since 3.3
 */
@RestController
@RequestMapping(value = OpenConstant.ROOT_PATH_PLATFORM)
public class CommunityResourceController extends BaseController{
	
	@Autowired
	private CommunityResourceService communityResourceService;
	
	/**
	 * 获取所有社区所有资源列表
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/listCommunityResource")
	public Result<?> listCommunityResource(
			@RequestParam(value="index", required=false, defaultValue="1") Integer index,
			@RequestParam(value="size", required=false, defaultValue="10")  Integer size) throws Exception {
	
		List<CommunityResource> list =  communityResourceService.listCommunityResource(index, size);
		return Result.successData(list);
	}
	
	/**
	 * 1、获取所有社区所有资源列表（什么参数都不传）
	 * 2、根据社区获取列表
	 * 3、根据城市获取社区资源
	 * 4、根据管家手机号码
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/listCommunityResourceByCondition")
	public Result<?> listCommunityResourceByCondition(
			@RequestParam(value = "cityId", required = false) Integer cityId,
			@RequestParam(value = "communityId", required = false) Integer communityId,
			@RequestParam(value = "phone", required = false) String phone,
			@RequestParam(value="index", required=false, defaultValue="1") Integer index,
			@RequestParam(value="size", required=false, defaultValue="10") Integer size) throws Exception {

		List<CommunityResource> list = communityResourceService.getByCondition(cityId, communityId, phone, index, size);
		return Result.successData(list);
	}
	
	/**
	 * 新增列表
     * @return
	 * @throws Exception
	 */
	@RequestMapping("/addCommunityResource")
	public Result<?> addCommunityResource(
			@RequestParam(value = "cityId", required = true) Integer cityId,
			@RequestParam(value = "communityId", required = true) Integer communityId,
			@RequestParam(value = "resourceTypeId", required = true) Integer resourceTypeId,
			@RequestParam(value = "addrDetail", required = false) String addrDetail,
			@RequestParam(value = "resourceDesc", required = false) String resourceDesc,
			@RequestParam(value = "resourceTotal", required = true) Integer resourceTotal,
			@RequestParam(value = "resourceUsed", required = true) Integer resourceUsed,
			@RequestParam(value = "resourceFee", required = false) BigDecimal resourceFee,
			@RequestParam(value = "img", required = true) String img,
			@RequestParam(value = "adminId", required= true) Integer adminId) throws Exception {

		boolean result = communityResourceService.addCommunityResource(cityId, communityId, resourceTypeId,addrDetail, resourceDesc, resourceTotal,resourceUsed,resourceFee,img, adminId);
		if(!result) {
			return Result.create(StatusCode.FAILURE, "新增社区资源失败");
		}
		return Result.success();
	}
	
//	public Result<?> uploadImg() {
//		http://s.zizai.test.thinkinpower.net/api/community/admin/uploadImg
//	}
	
	/**
	 * 更新列表:什么时候不允许更新？
	 * @param type
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateCommunityResource")
	public Result<?> updateCommunityResource(
			@RequestParam(value = "communityResourceId", required = true) Integer communityResourceId,
			@RequestParam(value = "cityId", required = false) Integer cityId,
			@RequestParam(value = "communityId", required = true) Integer communityId,
			@RequestParam(value = "resourceTypeId", required = true) Integer resourceTypeId,
			@RequestParam(value = "addrDetail", required = false) String addrDetail,
			@RequestParam(value = "resourceDesc", required = false) String resourceDesc,
			@RequestParam(value = "resourceTotal", required = true) Integer resourceTotal,
			@RequestParam(value = "resourceUsed", required = true) Integer resourceUsed,
			@RequestParam(value = "resourceFee", required = false) BigDecimal resourceFee,
			@RequestParam(value = "img", required = true) String img,
			@RequestParam(value = "adminId", required= true) Integer adminId) throws Exception {
	
		boolean result = communityResourceService.updateCommunityResource(communityResourceId, cityId, communityId, resourceTypeId,addrDetail, resourceDesc, resourceTotal,resourceUsed,resourceFee,img, adminId);
		if(!result) {
			return Result.create(StatusCode.FAILURE, "更新社区资源失败");
		}
		return Result.success();
	}
	
	/** 
	 * 根据社区资源id删除社区资源
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteCommunityResourceById")
	public Result<?> deleteCommunityResourceById(
			@RequestParam(value = "communityResourceId", required = true) Integer communityResourceId,
			@RequestParam(value = "adminId", required = true) Integer adminId) throws Exception {
	
		boolean result = communityResourceService.deleteCommunityResourceById(communityResourceId, adminId);
		if(!result) {
			return Result.create(StatusCode.FAILURE, "删除社区资源失败");
		}
		return Result.success();
	}
	
	/**
	 * 获取资源详情
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getCommunityResourceById")
	public Result<?> getCommunityResourceById(@RequestParam(value = "communityResourceId", required = true) Integer communityResourceId) throws Exception {
		CommunityResource communityResource = communityResourceService.getCommunityResourceById(communityResourceId);
		return Result.successData(communityResource);
	}
	
	/**
	 * 根据社区举行的活动获取列表
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/listCommunityResourceByActivityId")
	public Result<?> listCommunityResourceByActivityId(@RequestParam(value = "activityId", required = true) Long activityId) throws Exception {
		List<ExtCommunityResourceActivity> list = communityResourceService.listCommunityResourceByActivityId(activityId);
		return Result.successData(list);
	}
	
	/**
	 * 社区活动关联资源(活动侧已写)
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/relatedActivityCommunityResource")
	public Result<?> relatedActivityCommunityResource(
			@RequestParam(value = "city_id", required = false) Integer city_id,
			@RequestParam(value = "community_id", required = false) Integer community_id,
			@RequestParam(value = "activity_id", required = false) Long activity_id,
			@RequestParam(value = "community_resource_id", required = false) Integer community_resource_id) throws Exception {
		return Result.success("");
	}
}
