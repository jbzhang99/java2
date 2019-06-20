package com.rfchina.community.openweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.rfchina.community.base.Constant;
import com.rfchina.community.base.Result;
import com.rfchina.community.persistence.mapper.OpenMerchantInfoMapper;
import com.rfchina.community.persistence.mapper.OpenTempletInfoMapper;
import com.rfchina.community.persistence.model.OpenMerchantInfo;
import com.rfchina.community.persistence.model.OpenTempletInfo;
import com.rfchina.community.persistence.model.OpenTempletInfoExample;

@RestController
@RequestMapping(value = Constant.ROOT_PATH_OPENWEB)
public class OpenTempletInfoController extends BaseController {

	@Autowired
	private OpenMerchantInfoMapper openMerchantInfoMapper;
	@Autowired
	private OpenTempletInfoMapper openTempletInfoMapper;

	// 服务列表必须设置银行账号.
	@RequestMapping("/list_open_templet_info")
	public Result<?> list_open_templet_info() {
		OpenTempletInfoExample example = new OpenTempletInfoExample();
		example.createCriteria().andStatusEqualTo(1);
		List<OpenTempletInfo> list = openTempletInfoMapper.selectByExample(example);

		JSONObject json = new JSONObject();
		json.put("list", list);
		return Result.successData(json);
	}

}
