package com.rfchina.community.openstore.controller;

import com.rfchina.community.base.Constant;
import com.rfchina.community.base.Result;
import com.rfchina.community.openstore.service.OpenOrderWSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = {Constant.ROOT_PATH_OPENSTORE})
public class OpenOrderController extends BaseController {

	@Autowired
	private OpenOrderWSService openOrderWSService;

	@RequestMapping(value = {"/list_order_three_by_my"})
	public Result<?> listOrderThreeByUid(
			@RequestParam(value = "index", required = false, defaultValue = "1") int index,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size,
			@RequestParam(value = "type", required = false, defaultValue = "0") int type,
			@RequestParam(value = "clientType", required = false, defaultValue="APP") String clientType,
			@RequestParam(value = "access_token", required = false) String accessToken){
		Long uid = validateAndGetUid(clientType, accessToken);
		return Result.successData(openOrderWSService.listOrderThreeByUid(uid,index,size));
	}

	@RequestMapping(value = {"/get_order_three_by_my"})
	public Result<?> getOrderThreeByUid(
			@RequestParam(value = "id", required = false, defaultValue = "0") Long id,
			@RequestParam(value = "clientType", required = false, defaultValue="APP") String clientType,
			@RequestParam(value = "access_token", required = false) String accessToken){
		Long uid = validateAndGetUid(clientType, accessToken);
		return Result.successData(openOrderWSService.oneOrderThreeByUid(uid,id));
	}

}
