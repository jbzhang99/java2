package com.rfchina.community.open.bridge.controller.community;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.Result;
import com.rfchina.community.open.bridge.controller.BaseController;
import com.rfchina.community.open.bridge.service.OpenXFSJAreaConfigService;
import com.rfchina.community.open.bridge.service.OpenXFSJBusinessInfoService;
import com.rfchina.community.open.bridge.service.OpenXFSJGroupConfigService;
import com.rfchina.community.persistence.model.OpenXFSJAreaConfig;

//小富市集
@RestController
@RequestMapping(value = OpenConstant.ROOT_PATH_COMMUNITY)
public class OpenXFSJBusinessInfoController extends BaseController {

	@Autowired
	private OpenXFSJBusinessInfoService openXFSJBusinessInfoService;
	@Autowired
	private OpenXFSJGroupConfigService openXFSJGroupConfigService;
	@Autowired
	private OpenXFSJAreaConfigService openXFSJAreaConfigService;


	/**
	 * @author:fukangwen
	 * @Description: 更新报名状态
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping("/updateXFSJSignUpStatus")
	public Result<?> updateXFSJSignUpStatus(@RequestParam(value = "id", required = true) Long id,
			@RequestParam(value = "status", required = true) int status) throws Exception {
		int i = openXFSJBusinessInfoService.updateXFSJSignUpStatus(id, status);
		return Result.successData(i);
	}
	
	/**
	 * 招商信息展示
	 */
	@RequestMapping("/getOpenXFSJBusinessInfo")
	public Result<?> getOpenXFSJBusinessInfo(@RequestParam(value = "id", required = true) Long id) throws Exception {

		return Result.successData(openXFSJBusinessInfoService.getOpenXFSJBusinessInfo(id));
	}
	
	/**
	 * 招商审核信息详情
	 */
	@RequestMapping("/getOpenXFSJBusinessAuditInfo")
	public Result<?> getOpenXFSJBusinessAuditInfo(
			@RequestParam(value = "id", required = true) Long id) {

		return Result.successData(openXFSJBusinessInfoService.getOpenXFSJBusinessAuditInfo(id));
	}
	
	
	/**
	 * 店铺报名列表 
	 */
	@RequestMapping("/signUpList")
	public Result<?> signUpList(@RequestParam(value = "id", required = true) Long id){
		return Result.successData(openXFSJBusinessInfoService.getSignUpList(id));
	}
	
	/**
	 * 删除报名店铺 
	 */
	@RequestMapping("/deleteSignUpUser")
	public Result<?> deleteSignUpUser(@RequestParam(value = "id", required = true) Long id) {
		openXFSJBusinessInfoService.deleteSignUpUser(id);
		return Result.successData(null);
	}
	
	
	/**
	 * 集团主题配置
	 */
	@RequestMapping("/list_group_config")
	public Result<?> listGroupConfig() throws Exception {
		return Result.successData(openXFSJGroupConfigService.listGroupConfig());
	}
	
	
	/**
	 * 集团主题新增
	 */
	@RequestMapping("/insert_group_config")
	public Result<?> insertGroupConfig(@RequestParam(value = "name", required = true) String name) {
		openXFSJGroupConfigService.insertGroupConfig(name);
		return Result.successData(null);
	}
	
	/**
	 * 集团主题修改
	 */
	@RequestMapping("/update_group_config")
	public Result<?> updateGroupConfig(@RequestParam(value = "id", required = true) Long id,
			@RequestParam(value = "name", required = true) String name) {
		openXFSJGroupConfigService.updateGroupConfig(id, name);
		return Result.successData(null);
	}
	
	/**
	 * 地区主题配置
	 */
	@RequestMapping("/list_area_config")
	public Result<?> listAreaConfig(
			@RequestParam(value = "city_id", required = true) int cityId,
			@RequestParam(value = "group_config_id", required = true) long groupConfigId) {
		List<OpenXFSJAreaConfig> list = openXFSJAreaConfigService.listAreaConfig(cityId, groupConfigId);
		return Result.successData(openXFSJAreaConfigService.areaConfigList2ExtList(list));
	}
	
	
	/**
	 * 地区主题新增
	 */
	@RequestMapping("/insert_area_config")
	public Result<?> insertAreaConfig(
			@RequestParam(value = "city_id", required = true) int cityId,
			@RequestParam(value = "group_config_id", required = true) long groupConfigId,
			@RequestParam(value = "name", required = true) String name){
		openXFSJAreaConfigService.insertAreaConfig(cityId, groupConfigId, name);
		return Result.successData(null);
	}
	
	/**
	 * 地区主题修改
	 */
	@RequestMapping("/update_area_config")
	public Result<?> updateAreaConfig(
			@RequestParam(value = "id", required = true) Long id,
			@RequestParam(value = "name", required = true) String name) throws Exception {
		openXFSJAreaConfigService.updateAreaConfig(id, name);
		return Result.successData(null);
	}
}
