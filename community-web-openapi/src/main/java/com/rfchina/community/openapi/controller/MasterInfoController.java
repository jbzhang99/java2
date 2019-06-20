package com.rfchina.community.openapi.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rfchina.api.response.ResponseData;
import com.rfchina.api.response.model.user.GetUserInfoWithOpenIdResponseModel;
import com.rfchina.community.base.Constant;
import com.rfchina.community.openapi.base.Result;
import com.rfchina.community.openapi.entity.ExtRoom;
import com.rfchina.community.openapi.service.FuPayService;
import com.rfchina.community.persistence.mapper.MasterChildMapper;
import com.rfchina.community.persistence.mapper.MasterInfoMapper;
import com.rfchina.community.persistence.model.MasterChild;
import com.rfchina.community.persistence.model.MasterChildExample;
import com.rfchina.community.persistence.model.MasterInfo;

@RestController
@RequestMapping(value = Constant.ROOT_PATH_OPEN)
public class MasterInfoController extends BaseController {

	@Autowired
	private MasterInfoMapper masterInfoMapper;

	@Autowired
	private MasterChildMapper masterChildMapper;

	@Autowired
	private FuPayService fuPayService;

	@Value("${rfpay.appId}")
	private Long rfpayAppId;

	@Value("${rfpay.appSecret}")
	private String rfpayAppSecret;

	private static transient Logger logger = LoggerFactory.getLogger(CommunityController.class);

	@RequestMapping("/room_info")
	public Result<?> getRoomInfo(@RequestParam("rf_open_id") String rfOpenId,
			@RequestParam("community_id") int communityId, @RequestParam(value = "__app_id") long appId)
			throws IllegalAccessException, InvocationTargetException {

		logger.info("查询信息，rf_open_id:{},community_id:{},_app_id:{}", rfOpenId, communityId, appId);

		// 根据openId获取用户ID
		long uid = 0;
		ResponseData<GetUserInfoWithOpenIdResponseModel> data1 = fuPayService.getUserInfoWithOpenIdRequest(rfpayAppId,
				rfpayAppSecret, appId, rfOpenId);
		if (data1 != null && data1.getCode() == 1001) {
			uid = data1.getData().getUid();
		} else {
			error("错误:" + data1.getCode() + "_" + data1.getMsg());
		}

		MasterChildExample masterChildExample = new MasterChildExample();
		masterChildExample.createCriteria().andUidEqualTo(uid).andStatusEqualTo(1).andCommunityIdEqualTo(communityId);

		List<MasterChild> masterChildList = masterChildMapper.selectByExample(masterChildExample);

		List<ExtRoom> roomList = new ArrayList<>();
		if (masterChildList == null || masterChildList.size() == 0) {
			logger.info("认证会员信息不存在");
			// error("房间信息不存在");
			return Result.successData(roomList);
		}

		for (MasterChild masterChild : masterChildList) {
			if (masterChild.getStatus() != 1) {
				logger.info("认证会员信息被禁用");
				continue;
			}
			// 查询主会员信息
			MasterInfo masterInfo = masterInfoMapper.selectByPrimaryKey(masterChild.getMasterId());
			if (masterInfo == null) {
				continue;
			}
			if (masterInfo.getStatus() != 1) {
				logger.info("主会员信息被禁用");
				continue;
			} else {
				ExtRoom extRoom = new ExtRoom();
				BeanUtils.copyProperties(extRoom, masterInfo);
				roomList.add(extRoom);
			}
		}

		return Result.successData(roomList);
	}
}
