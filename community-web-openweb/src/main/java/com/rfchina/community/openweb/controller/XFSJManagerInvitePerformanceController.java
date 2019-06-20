package com.rfchina.community.openweb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.paginator.model.Page;
import org.mybatis.paginator.model.PageBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rfchina.community.base.Constant;
import com.rfchina.community.base.Result;
import com.rfchina.community.openweb.entity.ExtOpenManagerInvite;
import com.rfchina.community.openweb.entity.ExtOpenManagerInviteMerchant;
import com.rfchina.community.openweb.service.XFSJManagerInvitePerformanceService;
/**
 * @desc 小富市集-管家绩效管理
 * @author maixingnian
 * @since 3.2
 */
@RestController
@RequestMapping(value={Constant.ROOT_PATH_OPENWEB + "/xfsj"})
public class XFSJManagerInvitePerformanceController extends BaseController {
	
	@Autowired
	XFSJManagerInvitePerformanceService managerInvitePerformanceService;
	
	/**
	 * 查询管家绩效
	 * @param index 第几页
	 * @param size  每页多少条
	 * @return
	 */
	@RequestMapping(value={"/manager_invite_performance_list"} )
	public Result<?> getManagerPerfomanceListByPages(
			@RequestParam(value="phone", required=false) String phone,
			@RequestParam(value="index", required=false, defaultValue="1") int index,
			@RequestParam(value="size", required=false, defaultValue="10")  int size) {
		
		PageBounds pageBounds = new PageBounds(index, size);
		Map<String, Object> phoneMap = new HashMap<>();
		phoneMap.put("phone", phone);
		Page<ExtOpenManagerInvite> page = managerInvitePerformanceService.queryList(phoneMap, pageBounds);
		return Result.successData(page);
	}
	
	/**
	 * 查询管家绩效详情
	 * @param phone 管家手机号码
	 * @return
	 */
	@RequestMapping(value={"/manager_invite_performance_details"} )
	public Result<?> getManagerPerfomanceDetails(
			@RequestParam(value="phone", required=true) String phone) {
		
		List<ExtOpenManagerInviteMerchant> page = managerInvitePerformanceService.queryDetailsByPhone(phone);
		return Result.successData(page);
	}
	
	/**
	 * 管家绩效导出
	 * @return
	 */
	@RequestMapping(value={"/manager_invite_performance_export"})
	public Result<?> managerInvitePerformanceExport(
			@RequestParam(value="phone", required=false) String phone,
			@RequestParam(value="index", required=false, defaultValue="1") int index,
			@RequestParam(value="size", required=false, defaultValue="10")  int size) {
		
		PageBounds pageBounds = new PageBounds(index, size);
		Map<String, Object> phoneMap = new HashMap<>();
		phoneMap.put("phone", phone);
		//导出文件
		managerInvitePerformanceService.export(phoneMap, pageBounds, response);
		return Result.success();
	}
}
