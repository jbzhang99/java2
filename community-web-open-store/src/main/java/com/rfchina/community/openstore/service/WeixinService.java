package com.rfchina.community.openstore.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jfinal.kit.HashKit;
import com.jfinal.weixin.sdk.api.ApiConfig;
import com.jfinal.weixin.sdk.api.JsTicket;
import com.jfinal.weixin.sdk.api.JsTicketApi;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 *
 */
@Service
public class WeixinService extends BaseService{

    private static final Logger LOGGER = LoggerFactory.getLogger(WeixinService.class);

    @Value("${wx.info}")
    private String wxInfo;

    private static Map<Integer,AppInfo> wxInfoPair = new HashMap<>();

    private static String createNonceStr() {
        return UUID.randomUUID().toString();
    }

    private static String createTimestamp() {
        return Long.toString(System.currentTimeMillis() / 1000);
    }

    public AppInfo getAppInfoByType(Integer type) {
        AppInfo appInfo = wxInfoPair.get(type);
        if(appInfo == null){
            if(wxInfo != null && wxInfo.length()>0){
                JSONObject info = JSONObject.parseObject(wxInfo);
                JSONObject obj = info.getJSONObject(String.valueOf(type));
                appInfo = new AppInfo(obj.getString("appId"),obj.getString("appSecret"),obj.getString("channelAppName"));
                wxInfoPair.put(type,appInfo);
            }
        }
        return appInfo;
    }


    public Map<String, Object> getWXJsConfig(String url,Integer type) {
        if(type == null || type == 0){ //获取默认的微信配置
            return getWXJsConfig(url);
        }
        AppInfo appInfo = getAppInfoByType(type);
        if(appInfo == null){
            error("无法获取微信appId和appSecret");
        }
        LOGGER.info("getWXJsConfig url:{}", JSON.toJSONString(url));
        JsTicket jsApiTicket = ApiConfigService.getTicket(JsTicketApi.JsApiType.jsapi,appInfo.getAppId());
        return getStringObjectMap(url, appInfo.getAppId(), jsApiTicket);
    }

    public Map<String, Object> getWXJsConfig(String url) {
        LOGGER.info("getWXJsConfig url:{}", JSON.toJSONString(url));
        ApiConfig apiConfig = ApiConfigService.getDefaultApiConfig();
        JsTicket jsApiTicket = ApiConfigService.getTicket(JsTicketApi.JsApiType.jsapi);
        return getStringObjectMap(url, apiConfig.getAppId(), jsApiTicket);
    }

    private Map<String, Object> getStringObjectMap(String url, String appId, JsTicket jsApiTicket) {
        String jsapi_ticket = jsApiTicket.getTicket();
        String nonce_str = createNonceStr();
        String timestamp = createTimestamp();
        // 这里参数的顺序要按照 key 值 ASCII 码升序排序
        // 注意这里参数名必须全部小写，且必须有序
        String str = "jsapi_ticket=" + jsapi_ticket + "&noncestr=" + nonce_str + "&timestamp=" + timestamp + "&url="
                + url;
        String signature = HashKit.sha1(str);
        Map<String, Object> result = new HashMap<>();
        result.put("timestamp", timestamp);
        result.put("appId", appId);
        result.put("nonceStr", nonce_str);
        result.put("signature", signature);
        result.put("url", url);
        LOGGER.info("result:{}", JSON.toJSONString(result));
        return result;
    }

    public class AppInfo{
        private String appId;
        private String appSecret;
        private String channelAppName;

        public AppInfo(String appId, String appSecret, String channelAppName) {
            this.appId = appId;
            this.appSecret = appSecret;
            this.channelAppName = channelAppName;
        }

        public String getAppId() {
            return appId;
        }

        public void setAppId(String appId) {
            this.appId = appId;
        }

        public String getAppSecret() {
            return appSecret;
        }

        public void setAppSecret(String appSecret) {
            this.appSecret = appSecret;
        }

        public String getChannelAppName() {
            return channelAppName;
        }

        public void setChannelAppName(String channelAppName) {
            this.channelAppName = channelAppName;
        }
    }
}
