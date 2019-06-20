package com.rfchina.community.open.bridge.controller.community;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.Result;
import com.rfchina.community.open.bridge.controller.BaseController;
import com.rfchina.community.persistence.mapper.OpenMerchantInfoMapper;
import com.rfchina.community.persistence.model.OpenMerchantInfo;

@RestController
@RequestMapping(value = OpenConstant.ROOT_PATH_COMMUNITY)
public class XFSJMerchantInfoController extends BaseController {

	@Autowired
	private OpenMerchantInfoMapper openMerchantInfoMapper;

//	@Autowired
//	private OpenMerchantInfoTempMapper openMerchantInfoTempMapper;

	@RequestMapping(value = { "/updateMerchantSrcBusiness" }, method = { RequestMethod.POST })
	public Result<?> updateMerchantSrcBusiness(@RequestParam("merchant_id") Long merchant_id,
			@RequestParam(value = "srcBusiness", required = true) String srcBusiness,
			@RequestParam(value = "srcCity", required = false) Integer srcCity) {
		if ("platform".equals(srcBusiness)) {
			srcCity = -2;
		} else if ("wuye".equals(srcBusiness)) {
			srcCity = -1;
		} else if ("area".equals(srcBusiness)) {
			//
			validator(srcCity <= 0, "请选择正确的地区");
		} else {
			error("招商来源只能选择,平台,物业,地区");
		}
		/*
		OpenMerchantInfoTemp bean = openMerchantInfoTempMapper.selectByPrimaryKey(merchant_id);
		validator(bean == null, "数据不存在请联系平台客服," + merchant_id);
		OpenMerchantInfoTemp temp = new OpenMerchantInfoTemp();
		temp.setSrcCity(srcCity);
		temp.setSrcBusiness(srcBusiness);
		temp.setId(merchant_id);
		// 更新内容
		// 如果银行信息有一个更改了，去支付中心更改同步信息
		temp.setUpdateTime(new Date());

		openMerchantInfoTempMapper.updateByPrimaryKeySelective(temp);
		*/

		// 更新到正式表

		OpenMerchantInfo info = new OpenMerchantInfo();
		info.setSrcCity(srcCity);
		info.setSrcBusiness(srcBusiness);
		info.setId(merchant_id);
		// 更新内容
		// 如果银行信息有一个更改了，去支付中心更改同步信息
		info.setUpdateTime(new Date());
		openMerchantInfoMapper.updateByPrimaryKeySelective(info);

		return Result.successData(merchant_id);
	}

}
