package com.rfchina.community.openapi.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rfchina.api.request.pay.FuPayCreateRequest.GoodsDetail;
import com.rfchina.community.base.Constant;
import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.openapi.ExtAppMoney;
import com.rfchina.community.base.openapi.ExtAppMoneyBase;
import com.rfchina.community.openapi.base.Result;
import com.rfchina.community.openapi.entity.AccountData;
import com.rfchina.community.openapi.service.PayCreateService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

//第三方服务使用这个服务,
@RestController
@RequestMapping(value = Constant.ROOT_PATH_OPEN)
public class FuPayV2Controller extends BaseController {

	@Autowired
	private PayCreateService payCreateService;

	private static transient Logger logger = LoggerFactory.getLogger(FuPayV2Controller.class);

	@RequestMapping("/pay_create")
	public Result<?> payCreate(
			// @RequestParam(value = "account_id") String accountId,
			// /@RequestParam(value = "access_token", required = false) String accessToken,
			@RequestParam(value = "token", required = false) String token,
			@RequestParam(value = "community_id", required = true) int communityId,
			// 没有意义去掉 @RequestParam(value = "app_id") long appId2,
			@RequestParam(value = "pay_channel") String payChannel,
			@RequestParam(value = "client_ip", required = false, defaultValue = "") String clientIp,
			@RequestParam(value = "project_type", required = false, defaultValue = "") String projectType,
			@RequestParam(value = "trade_type", required = false, defaultValue = "APP") String tradeType,
			@RequestParam(value = "weixin_open_id", required = false, defaultValue = "") String weiXinOpenId,
			@RequestParam(value = "expire_time", required = false, defaultValue = "") String expireTime,
			@RequestParam(value = "bussiness_type", required = false, defaultValue = "1") int bussinessType,
			@RequestParam(value = "timestamp", required = false, defaultValue = "0") long timestamp,
			@RequestParam(value = "sign", required = false, defaultValue = "") String sign,

			@RequestParam(value = "rf_open_id", required = false) String rfOpenId,
			@RequestParam(value = "subject", required = false, defaultValue = "") String subject,
			@RequestParam(value = "body", required = false, defaultValue = "") String body,
			@RequestParam(value = "detail", required = false, defaultValue = "") String detail,
			@RequestParam(value = "out_trade_no", required = false) String outTradeNo,
			@RequestParam(value = "total_amount", required = false) BigDecimal totalAmount,
			@RequestParam(value = "goods_detail", required = false, defaultValue = "") String goodsDetail,
			@RequestParam(value = "__app_id", required = false) Long appId,
			@RequestParam(value = "channelAppName", required = false, defaultValue = "") String channelAppName,
			@RequestParam(value = "batch_order", required = false, defaultValue = "") String batch_order)
			throws Exception {

		logger.info(
				"subject:appId:{},totalAmount:{},subject{}, communityId:{},rfOpenId:{},payChannel:{},communityId:{},outTradeNo:{},goods_detail:{},batch_order:{}",
				appId, totalAmount, subject, communityId, rfOpenId, payChannel, outTradeNo, goodsDetail, batch_order);

		//
		AccountData communityAccountId = payCreateService.checkCommunityPay(communityId);
		//先截断
		if(totalAmount != null) {
			totalAmount = totalAmount.setScale(2, BigDecimal.ROUND_HALF_DOWN);
		}

		Long uid = 0L;
		List<ExtAppMoneyBase> list1 = new ArrayList<>();
		if (StringUtils.isBlank(batch_order)) {
			// 单个
			ExtAppMoneyBase e = new ExtAppMoneyBase();
			e.setAppId(appId);
			e.setRfOpenId(rfOpenId);
			e.setBody(body);
			e.setDetail(detail);
			e.setOutTradeNo(outTradeNo);
			e.setSubject(subject);
			e.setTotalAmount(totalAmount);
			if (StringUtils.isNotBlank(goodsDetail)) {
				e.setGoodsDetails(JSON.parseArray(goodsDetail, GoodsDetail.class));
			}
			list1.add(e);
		} else {
			// 批量
			list1 = JSON.parseArray(batch_order, ExtAppMoneyBase.class);
		}

		List<ExtAppMoney> list = new ArrayList<>();
		for (ExtAppMoneyBase extAppMoney : list1) {
			if (uid == 0 || uid > 0 && StringUtils.isBlank(token)) {
				uid = payCreateService.getUidByToken(token, extAppMoney);
			}
			validator(uid == 0, "获得用户信息错误!");
			//
			ExtAppMoney target = new ExtAppMoney();
			BeanUtils.copyProperties(extAppMoney, target);
			list.add(target);
		}
		//
		String redirectUrl = null;
		int type=4;
		String payType = OpenConstant.PayType.APP;
		if(OpenConstant.TradeType.SAPP.equals(tradeType)){
			payType = OpenConstant.PayType.SAPP;
		}
		JSONObject jsonObject = payCreateService.buildData(payType, communityId, payChannel, clientIp, projectType,
				tradeType, weiXinOpenId, expireTime, bussinessType, uid, list, redirectUrl,communityAccountId,type,null,null,null,null,channelAppName);
		return Result.successData(jsonObject);
	}

}
