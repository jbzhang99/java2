package com.rfchina.community.brothers.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rfchina.community.base.Constant;
import com.rfchina.community.base.Result;
import com.rfchina.community.brothers.mapper.ExtMasterChildSelectMapper;

@RestController
@RequestMapping(value = Constant.ROOT_PATH_BROTHERS)
public class MasterChildController extends BaseController {

	private static transient Logger logger = LoggerFactory.getLogger(MasterChildController.class);

	@Autowired
	private ExtMasterChildSelectMapper extMasterChildMapper;

	@RequestMapping("/is_master_child")
	public Result<?> is_master_child(@RequestParam("phone") String phone) {
		Long count = extMasterChildMapper.isMasterChildByPhone(phone);
		logger.info("is_master_child phone:{},count:{}", phone, count);
		return Result.successData(count);
	}

	@RequestMapping("/is_master_child_in_area")
	public Result<?> is_master_child_in_area(@RequestParam("phone") String phone,
			@RequestParam("area_ids") String areaIds) {
		try {
			String[] a = areaIds.split(",");
			for (String string : a) {
				Integer.valueOf(string);
			}
		} catch (Exception e) {
			validator(true, e.getMessage());
		}

		Long count = extMasterChildMapper.isMasterChildByPhoneArea(phone, areaIds);
		logger.info("is_master_child_in_area phone:{},area_ids:{},count:{}", phone, areaIds, count);
		return Result.successData(count);
	}
}
