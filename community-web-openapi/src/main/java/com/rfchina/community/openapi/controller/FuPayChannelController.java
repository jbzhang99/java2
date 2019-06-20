package com.rfchina.community.openapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rfchina.community.base.Constant;
import com.rfchina.community.openapi.base.Result;


@RestController
@RequestMapping(value = Constant.ROOT_PATH_OPEN)
public class FuPayChannelController extends BaseController {
 
 

	@RequestMapping("/get_pay_channel")
	public Result<?> getPayChannel(@RequestParam(value = "pay_amount", required = true) Double amount) {
		List<PayChannel> list = new ArrayList<>();
		list.add(new PayChannel("AliPay", "支付宝"));
		list.add(new PayChannel("WeiXin", "微信"));
		return Result.successData(list);
	}

	class PayChannel {

		String channel;

		String channel_title;

		public String getChannel() {
			return channel;
		}

		public void setChannel(String channel) {
			this.channel = channel;
		}

		public String getChannel_title() {
			return channel_title;
		}

		public void setChannel_title(String channel_title) {
			this.channel_title = channel_title;
		}

		public PayChannel(String channel, String channel_title) {
			this.channel = channel;
			this.channel_title = channel_title;
		}
	}
}
