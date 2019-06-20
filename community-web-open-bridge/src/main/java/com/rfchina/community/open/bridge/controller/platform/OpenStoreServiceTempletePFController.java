package com.rfchina.community.open.bridge.controller.platform;

import com.rfchina.community.persistence.model.OpenServiceDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.Result;
import com.rfchina.community.open.bridge.controller.BaseController;
import com.rfchina.community.persistence.mapper.OpenStoreServiceTempleteMapper;
import com.rfchina.community.persistence.model.OpenStoreServiceTemplete;

@RestController
@RequestMapping(value = OpenConstant.ROOT_PATH_PLATFORM)
public class OpenStoreServiceTempletePFController extends BaseController {

	@Autowired
	private OpenStoreServiceTempleteMapper openStoreServiceTempleteMapper;

	@RequestMapping("/updateServiceQuickPay")
	public Result<?> updateOpenServiceDetail(@RequestParam(value = "serviceId") int serviceId, int quickPay) {
		OpenStoreServiceTemplete detail = openStoreServiceTempleteMapper.selectByPrimaryKey(serviceId);
		validator(detail == null, "请联系工程师,不存在!" + serviceId);
		OpenStoreServiceTemplete data = new OpenStoreServiceTemplete();
		data.setServiceId(serviceId);
		data.setQuickPay(quickPay);
		int i = openStoreServiceTempleteMapper.updateByPrimaryKeySelective(data);
		return Result.successData(i);
	}



	//旗舰店
	@RequestMapping("/updateServiceFlagship")
	public Result<?> updateServiceFlagship(@RequestParam(value = "serviceId") int serviceId,
										   @RequestParam(value = "flagShip") int flagShip) {
		OpenStoreServiceTemplete detail = openStoreServiceTempleteMapper.selectByPrimaryKey(serviceId);
		validator(detail == null, "请联系工程师,不存在!" + serviceId);

		OpenStoreServiceTemplete data = new OpenStoreServiceTemplete();
		data.setServiceId(serviceId);
		data.setFlagship(flagShip);
		openStoreServiceTempleteMapper.updateByPrimaryKeySelective(data);
		return Result.successData(detail);
	}

}
