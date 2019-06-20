package com.rfchina.community.open.bridge.controller.platform;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rfchina.community.base.Constant;
import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.Result;
import com.rfchina.community.open.bridge.controller.BaseController;
import com.rfchina.community.persistence.mapper.CommunityServiceMapper;
import com.rfchina.community.persistence.mapper.OpenOrderMapper;
import com.rfchina.community.persistence.model.CommunityService;
import com.rfchina.community.persistence.model.OpenOrder;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.FormBody.Builder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 */
@Controller
@RequestMapping(value = OpenConstant.ROOT_PATH_PLATFORM)
public class PayCallbackController extends BaseController {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private OpenOrderMapper openOrderMapper;
	@Autowired
	private CommunityServiceMapper communityServiceMapper;

	OkHttpClient client = new OkHttpClient();

	@RequestMapping(value = { "/open_callback" }, method = { RequestMethod.POST })
	@ResponseBody
	public Result<?> payCallback(@RequestParam(value = "id", required = true) long id, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// 修改第三方订单状态，并且回调第三方
		OpenOrder openOrder = openOrderMapper.selectByPrimaryKey(id);
		validator(openOrder == null, "数据不存在!openOrder");
		String getCommunityTradeNo = openOrder.getCommunityTradeNo();
		validator(!getCommunityTradeNo.startsWith(Constant.OpenOrder.PAY_TRADE_NO_PREFIX)
				&& !getCommunityTradeNo.startsWith(Constant.OpenOrder.PAY_TRADE_NO_PREFIX_NEW), "只能订单才能使用"+getCommunityTradeNo);
		CommunityService communityService = communityServiceMapper.selectByPrimaryKey(openOrder.getServiceId());
		validator(communityService == null, "数据不存在!communityService");

		// 退款状态

		// 回调第三方
		// 根据订单中的APPID查询对应的回调地址
		Map<String, String> params = new HashMap<>();
		// params.put("notify_id", notifyId);
		// params.put("notify_time", notifyTime);
		// params.put("bill_id", billId);
		// params.put("account_id", accountId);
		// params.put("app_id", ""+openOrder.getAppId());

		params.put("out_trade_no", openOrder.getOutTradeNo());
		params.put("community_trade_no", getCommunityTradeNo);
		params.put("pay_channel", openOrder.getPayChannel());

		// if(StringUtils.isNotBlank(payTime)){
		// params.put("pay_time", sdf.format(payTime));
		// }else{
		// params.put("pay_time", null);
		// }
		// params.put("client_ip", clientIp);

		String tradeStatus = "";

		if (openOrder.getRefundStatus() == 2) {
			tradeStatus = "TRADE_REFUND_SUCCESS";
		} else if (openOrder.getRefundStatus() == 3) {
			tradeStatus = "TRADE_REFUND_FAILURE";
		} else {
			validator(true, "该订单不支持");
		}
		String str = "";
		// params.put("subject", subject);
		// params.put("body", body);
		// params.put("detail", detail);
		params.put("trade_status", tradeStatus);
		// params.put("timestamp", timestamp);
		// params.put("sign", sign);
		// return
		// HttpUtil.post("http://demo.zizai.rfmember.net/api/third/admin/payFinished",
		// params);

		// 如果是三方的正常交易单，则需要回调第三方

		// 返回结果
		String url = communityService.getNotifyUrl();

		validator(StringUtils.isBlank(url), "该服务没有url" + communityService.getId());
		try {
			str = post(url, params);
		} catch (Exception e) {
			logger.error(
					"payCallback:url error:" + openOrder.getServiceId() + "  " + url + "  " + JSON.toJSONString(params),
					e);
			str = "failure";
		}
		return Result.successData(str);

	}

	public String post(String url, Map<String, String> params) throws IOException {
		logger.info("post125:url:{} params:{}", url, JSONObject.toJSONString(params));

		Builder builder = new FormBody.Builder();
		params.forEach((k, v) -> {
			builder.add(k, v);
		});
		RequestBody formBody = builder.build();

		Request request = new Request.Builder().url(url).post(formBody).build();
		Call call = client.newCall(request);

		Response response = call.execute();
		return response.body().string();

	}

}
