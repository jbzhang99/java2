package com.rfchina.community.brothers.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rfchina.api.response.ResponseData;
import com.rfchina.api.response.model.user.VerifyUserTokenResponseModel;
import com.rfchina.community.base.Constant;
import com.rfchina.community.base.Result;
import com.rfchina.community.component.PlatformGlobalComponent;
import com.rfchina.community.persistence.mapper.UserInfoMapper;
import com.rfchina.community.persistence.model.UserInfo;
import com.rfchina.community.persistence.model.UserInfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = Constant.ROOT_PATH_BROTHERS)
public class UserInfoController extends BaseController {

	@Autowired
	private UserInfoMapper userInfoMapper;

	@Autowired
	private PlatformGlobalComponent platformGlobalComponent;

	@RequestMapping("/token_by_user_info")
	public Result<?> tokenByUserInfo(@RequestParam("access_token") String accessToken) {
		ResponseData<VerifyUserTokenResponseModel> res = platformGlobalComponent.verifyUserToken(accessToken);

		validator(res.getCode() != 1001, JSON.toJSONString(res));
		Long id = res.getData().getUserId();
		UserInfo user = userInfoMapper.selectByPrimaryKey(id);
		validator(user == null, "没有注册" + id);
		JSONObject json = new JSONObject();
		json.put("phone", user.getPhone());
		json.put("nick_name", user.getNickname());
		json.put("id", user.getId());
		json.put("create_time", user.getCreateTime());
		return Result.successData(json);
	}

	@RequestMapping("/reg_has_phone")
	public Result<?> regHasPhone(@RequestParam("phone") String phone) {
		UserInfoExample example = new UserInfoExample();
		example.createCriteria().andPhoneEqualTo(phone);
		List<UserInfo> users = userInfoMapper.selectByExample(example);
		validator(users.isEmpty(), "该手机号码未注册");
		return Result.successData(users.size()); 
	}

	@RequestMapping("/reg_has_phone2")
	public Result<?> regHasPhone2(@RequestParam("phone") String phone) {
		UserInfoExample example = new UserInfoExample();
		example.createCriteria().andPhoneEqualTo(phone);
		List<UserInfo> users = userInfoMapper.selectByExample(example);
		validator(users.isEmpty(), "该手机号码未注册");
		UserInfo user=users.get(0);
		JSONObject json = new JSONObject();
		json.put("count", users.size());
		json.put("phone", user.getPhone());
		json.put("nick_name", user.getNickname());
		json.put("id", user.getId());
		json.put("create_time", user.getCreateTime());
		return Result.successData(json); 
	}
	

}
