package com.rfchina.community.open.bridge.controller.platform;

import com.rfchina.api.response.ResponseData;
import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.Result;
import com.rfchina.community.component.PlatformGlobalComponent;
import com.rfchina.community.open.bridge.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = OpenConstant.ROOT_PATH_PLATFORM)
public class PlatformTestPFController extends BaseController {

	@Autowired
	private PlatformGlobalComponent platformGlobalComponent;


	//
	@RequestMapping(value={"/businessConfirmRecord"} , method = { RequestMethod.GET })
	public Result<?> listOpenOrderFinance(
			@RequestParam(value = "billId", required = false, defaultValue = "") String billId,
			@RequestParam(value = "type", required = false, defaultValue = "1") String type
			) {
		ResponseData<Map<String, Object>> responseData = platformGlobalComponent.businessConfirmRecord(billId, type);
		return Result.successData(responseData);
	}

	//
	@RequestMapping(value={"/testpost"} , method = { RequestMethod.GET })
	public Result<?> testpost(
			@RequestParam(value = "billId", required = false, defaultValue = "") String billId,
			@RequestParam(value = "type", required = false, defaultValue = "1") String type
	) {

		return Result.success();
	}



}
