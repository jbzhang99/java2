package com.rfchina.community.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.rfchina.community.base.ValueNamePair;
import com.rfchina.community.persistence.mapper.UserInfoMapper;
import com.rfchina.community.persistence.model.UserInfo;
import com.rfchina.community.service.push.AndroidNotification;
import com.rfchina.community.service.push.AndroidNotification.AfterOpenAction;
import com.rfchina.community.service.push.PushClient;
import com.rfchina.community.service.push.android.AndroidBroadcast;
import com.rfchina.community.service.push.android.AndroidCustomizedcast;
import com.rfchina.community.service.push.android.AndroidGroupcast;
import com.rfchina.community.service.push.ios.IOSBroadcast;
import com.rfchina.community.service.push.ios.IOSCustomizedcast;
import com.rfchina.community.service.push.ios.IOSGroupcast;

@Service
public class UmengPushGlobalService {

	private static Logger logger = LoggerFactory.getLogger(UmengPushGlobalService.class);

	@Value("${push.umeng.android.appkey}")
	private String android_appkey;
	@Value("${push.umeng.android.appMasterSecret}")
	private String android_appMasterSecret;

	@Value("${push.umeng.ios.appkey}")
	private String ios_appkey;
	@Value("${push.umeng.ios.appMasterSecret}")
	private String ios_app_master_secert;

	@Value("${push.umeng.aliasType:rfzizai}")
	private String aliasType;
	@Value("${push.umeng.productionMode:false}")
	private Boolean productionMode;

	PushClient client = new PushClient();

	@Autowired
	private UserInfoMapper userInfoMapper;

	private boolean isPush(Long uid) {
		if (uid == null || uid <= 0) {
			return false;
		}

		UserInfo info = userInfoMapper.selectByPrimaryKey(uid);
		if (info == null || info.getPush() == null) {
			return false;
		}
		if (info.getPush() != 1) {
			logger.info("uid:{} not push ", uid);
			return false;
		}
		return true;
	}

	public <T> void push(Long uid, String text, String ticker, String title, ValueNamePair<PushProtocol, T> action) {
		if (!isPush(uid)) {
			return;
		}
		try {
			logger.info("Start for android msg push uid:{} ; action:{}",uid,action);
			AndroidCustomizedcast push = new AndroidCustomizedcast(android_appkey, android_appMasterSecret);
			push.setAlias(uid.toString(), aliasType);
			push.setTicker(ticker);
			push.setTitle(title);
			push.setText(text);
			// push.goCustomAfterOpen("");
			push.setDisplayType(AndroidNotification.DisplayType.NOTIFICATION);
			// TODO Set 'production_mode' to 'false' if it's a test device.
			// For how to register a test device, please see the developer doc.
			if (productionMode) {
				push.setProductionMode();
			} else {
				push.setTestMode();
			}
			push.setAfterOpenAction(AfterOpenAction.go_custom);
			// JSONObject customFields = new JSONObject();
			// customFields.put("type","OPEN_ORDER_DETAIL");
			// customFields.put("id", order_id);
			// push.setCustomField(customFields);
			if (action != null) {
				push.setExtraField("action", action.value().getAction(action.name()));
				push.setCustomField(action.value().getAction(action.name()));
			}

			client.send(push);
			logger.info("End for android msg push uid:{} ; action:{}",uid,action);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		try {
			// ---------------------------
			logger.info("Start for ios msg push uid:{} ; action:{}",uid,action);
			IOSCustomizedcast push = new IOSCustomizedcast(ios_appkey, ios_app_master_secert);

			// them
			// if there are multiple alias.
			// And if you have many alias, you can also upload a file containing
			// these alias, then
			// use file_id to send customized notification.
			push.setAlias(uid.toString(), aliasType);
			push.setAlert(text);
			push.setBadge(1);
			push.setSound("default");

			// TODO Set 'production_mode' to 'false' if it's a test device.
			// For how to register a test device, please see the developer doc.

			// JSONObject iosjson = new JSONObject();
			// iosjson.put("type", "OPEN_ORDER_DETAIL");
			// iosjson.put("id", order_id);
			// TODO set 'production_mode' to 'true' if your app is under
			// production
			// mode

			if (productionMode) {
				push.setProductionMode();
			} else {
				push.setTestMode();
			}
			if (action != null) {
				push.setCustomizedField("action", action.value().getAction(action.name()));
			}
			client.send(push);
			logger.info("End for ios msg push uid:{} ; action:{}",uid,action);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	public enum PushProtocol {
		community, card, message_community, message_system, message_notice;
		//
		// 推送行为定义：
		// 进入社区, id为社区ID
		// rfzizai://open_page?action=community&id=1
		// 进入卡片详情 id为卡片ID
		// rfzizai://open_page?action=card&id=1
		// 进入社区消息列表页 id为社区ID
		// rfzizai://open_page?action=message_community&id=1
		// 进入系统消息列表页 不带ID
		// rfzizai://open_page?action=message_system
		// 进入系统公告列表页 不带ID
		// rfzizai://open_page?action=message_notice

		public <T> String getAction(T extraParams) {
			String URLPrefix = "rfzizai://open_page?action=";
			String extraParamsStr = "";
			//兼容之前Long类型的逻辑
			extraParamsStr += (extraParams instanceof  Long ? "id=" + extraParams :extraParams);

			switch (this) {
				case community :
					return URLPrefix + " community&" + extraParamsStr;
				case card :
					return URLPrefix + " card&" + extraParamsStr;
				case message_community :
					return URLPrefix + " message_community&" + extraParamsStr;
				case message_system :
					return URLPrefix + (extraParams instanceof  Long ? " message_system&" :"") + extraParamsStr;
				case message_notice :
					return URLPrefix + " message_notice&" + extraParamsStr;
				default :
					return "";
			}

		}
	}

	/**
	 * broadcast-广播
	 * 
	 * @param title
	 */
	public void broadcast(String title, String ticker, ValueNamePair<PushProtocol, Long> action) {

		try {
			AndroidBroadcast push = new AndroidBroadcast(android_appkey, android_appMasterSecret);
			push.setTicker(ticker);
			push.setTitle(title);
			push.setText(ticker);
			if (productionMode) {
				push.setProductionMode();
			} else {
				push.setTestMode();
			}
			push.setAfterOpenAction(AfterOpenAction.go_custom);
			push.setExtraField("action", action.value().getAction(action.name()));
			push.setCustomField(action.value().getAction(action.name()));
			push.setDisplayType(AndroidNotification.DisplayType.NOTIFICATION);
			if (productionMode) {
				push.setProductionMode();
			} else {
				push.setTestMode();
			}
			client.send(push);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

		try {
			IOSBroadcast push = new IOSBroadcast(ios_appkey, ios_app_master_secert);
			push.setAlert(title);
			push.setBadge(1);
			push.setSound("default");
			if (productionMode) {
				push.setProductionMode();
			} else {
				push.setTestMode();
			}
			if (action != null) {
				push.setCustomizedField("action", action.value().getAction(action.name()));
			}
			if (productionMode) {
				push.setProductionMode();
			} else {
				push.setTestMode();
			}
			client.send(push);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

	}

	/**
	 * 
	 * groupcast-组播
	 * @param title
	 * @param ticker
	 */
	public void groupcast(List<String> tags, String title, String ticker, ValueNamePair<PushProtocol, Long> action) {

		try {
			AndroidGroupcast push = new AndroidGroupcast(android_appkey, android_appMasterSecret);

			/*
			 * Construct the filter condition: "where": { "and": [
			 * {"tag":"test"}, {"tag":"Test"} ] }
			 */
			JSONObject filterJson = new JSONObject();
			JSONObject whereJson = new JSONObject();
			JSONArray tagArray = new JSONArray();
			for (String tag : tags) {
				JSONObject testTag = new JSONObject();
				testTag.put("tag", tag);
				tagArray.add(testTag);
			}
			whereJson.put("and", tagArray);
			filterJson.put("where", whereJson);
			push.setFilter(filterJson);
			push.setTicker(ticker);
			push.setTitle(title);
			push.setText(ticker);
			if (productionMode) {
				push.setProductionMode();
			} else {
				push.setTestMode();
			}
			push.setAfterOpenAction(AfterOpenAction.go_custom);
			push.setExtraField("action", action.value().getAction(action.name()));
			push.setCustomField(action.value().getAction(action.name()));
			push.setDisplayType(AndroidNotification.DisplayType.NOTIFICATION);
			if (productionMode) {
				push.setProductionMode();
			} else {
				push.setTestMode();
			}
			client.send(push);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

		try {
			IOSGroupcast push = new IOSGroupcast(ios_appkey, ios_app_master_secert);
			JSONObject filterJson = new JSONObject();
			JSONObject whereJson = new JSONObject();
			JSONArray tagArray = new JSONArray();
			for (String tag : tags) {
				JSONObject testTag = new JSONObject();
				testTag.put("tag", tag);
				tagArray.add(testTag);
			}
			whereJson.put("and", tagArray);
			filterJson.put("where", whereJson);
			push.setFilter(filterJson);
			push.setAlert(title);
			
			push.setBadge(1);
			push.setSound("default");
			
			
			if (productionMode) {
				push.setProductionMode();
			} else {
				push.setTestMode();
			}
			if (action != null) {
				push.setCustomizedField("action", action.value().getAction(action.name()));
			}
			client.send(push);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

	}
}
