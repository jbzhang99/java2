package com.rfchina.community.openstore.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rfchina.community.base.Constant;
import com.rfchina.community.base.Result;
import com.rfchina.community.openstore.service.OpenConfService;

/*
 * conf
 */
@RestController
@RequestMapping(value = { Constant.ROOT_PATH_OPENSTORE+"/conf" })
public class OpenConfController extends BaseController {

	@Autowired
	private OpenConfService openConfService;

	/**
	 * @author:fukangwen
	 * @Description: 判断是否可以用pos支付
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping(value = { "/canUserPos" })
	public Result<?> canUserPos() throws ParseException {
		Boolean conf = openConfService.getCodeByType(OpenConfService.Type.POS.toString());
		return Result.successData(conf);
	}
	
}
