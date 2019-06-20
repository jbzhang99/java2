package com.rfchina.community.openweb.controller;

import com.rfchina.community.base.Constant;
import com.rfchina.community.base.Result;
import com.rfchina.community.openweb.service.OpenOperatorTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 活动协助
 */
@RestController
@RequestMapping(value = Constant.ROOT_PATH_OPENWEB)
public class OpenOperatorTaskController extends BaseController {
	@Autowired
	private OpenOperatorTaskService openOperatorTaskService;
	@RequestMapping(value = { "/operator_query_page" })
	public Result<?> operator_query_page(
	   @RequestParam(value = "serviceId", required = true) int serviceId,
	   @RequestParam(value = "operatorName", required = false, defaultValue = "") String operatorName,
	   @RequestParam(value = "operatorPhone", required = false, defaultValue = "") String operatorPhone,
	   @RequestParam(value = "index", required = false, defaultValue = "1") int index,
	   @RequestParam(value = "size", required = false, defaultValue = "10") int size
	) {
		// 权限检查
		authorityCheck(serviceId);

		return Result.successData(openOperatorTaskService.operatorList(serviceId,
				operatorName, operatorPhone, index, size).convert());
	}


}
