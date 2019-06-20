package com.rfchina.community.openstore.controller;

import com.rfchina.community.base.Constant;
import com.rfchina.community.base.Result;
import com.rfchina.community.base.exception.LoginRunTimeException;
import com.rfchina.community.openstore.service.WeixinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {Constant.ROOT_PATH_OPENSTORE})
public class AppIdController extends BaseController{

	@Autowired
	private WeixinService weixinService;

	@RequestMapping("/getJsConfig")
	public Result<?> getJsConfig(@RequestParam(value = "url") String url,
								 @RequestParam(required = false,defaultValue = "0") Integer type) {
		return Result.successData(weixinService.getWXJsConfig(url,type));
	}

	@RequestMapping("/validateToken")
	public Result<?> validateAccessToken(String accessToken){
		Long id = getUidByToken(accessToken);
		if(id == null || id == 0){
            throw new LoginRunTimeException("token失效,请重新登录!");
		}
		return Result.success();
	}
}
