package com.rfchina.community.open.bridge.controller.platform;

import org.mybatis.paginator.model.PageList;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.Result;
import com.rfchina.community.open.bridge.controller.BaseController;
import com.rfchina.community.persistence.model.CommunityResourceType;

/**
 * 活动资源类型管理
 * @author maixingnian
 * @since 3.3
 */
@RestController
@RequestMapping(value = OpenConstant.ROOT_PATH_PLATFORM)
public class CommunityResourceTypeController extends BaseController{
	
	/**
	 * 获取类型列表
	 * @param type
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/listCommunityResourceType")
	public Result<?> listCommunityResourceType() throws Exception {
		
		PageList<CommunityResourceType> pList = null;
		return Result.successData("");
	}
	
	/**
	 * 新增类型列表
	 * @param type
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/addCommunityResourceType")
	public Result<?> addCommunityResourceType(
			@RequestParam(value = "title", required = true) String title) throws Exception {
		return Result.success();
	}
	
	/**
	 * 更新类型列表
	 * @param type
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateCommunityResourceType")
	public Result<?> updateCommunityResourceType(
			@RequestParam(value = "id", required = true) int id,
			@RequestParam(value = "title", required = false) String title) throws Exception {
		return Result.success();
	}
	
	/**
	 * 删除类型列表：本类型没有挂靠资源才可以删除，否则得先删除干净资源
	 * @param type
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteCommunityResourceType")
	public Result<?> deleteCommunityResourceType(
			@RequestParam(value = "id", required = true) int id) throws Exception {
		return Result.success();
	}
}
