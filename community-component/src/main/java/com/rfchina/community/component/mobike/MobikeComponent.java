package com.rfchina.community.component.mobike;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rfchina.community.component.IfaceComponent;
import com.rfchina.community.persistence.mapper.IfaceLogMapper;
import com.rfchina.community.persistence.model.IfaceLog;
import okhttp3.*;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 */
//@Component
public class MobikeComponent extends IfaceComponent {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public static final String CHANNEL_NO = "32";

    private static final String PARTNER_NAME = "fuli";
    private static final String PARTNER_PASSWORD = "flsecret";
    public static final String PARTNER_CHANNEL_NO = "rf_mobike";
    private static final String GRANT_TYPE = "client_credentials";

    public static final String MOBIKE_PLATFORM = "";

    public static final String API_URL = "http://api.dev6.mobike.io";

    public static final String TOKEN_URL = "http://" + PARTNER_NAME + ":" + PARTNER_PASSWORD + "@passport.dev6.mobike.io/oauth/token";

    private final OkHttpClient OK_HTTP_CLIENT  = new OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build();

    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    static {
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    interface ApiPath {

        String GET_OPEN_CITY_LIST = "/mobike-api/api/getopencitylist.do";

        String UNLOCK_BIKE = "/mobike-api/rentmgr/unlockBike.do";

        String PARTNERLOGIN = "/mobike-api/usermgr/partnerlogin.do";
    }

    public OAuthTokenResponse oauthToken() {
        try {
            Map<String, String> map = new HashMap<>();
            map.put("grant_type", GRANT_TYPE);
            map.put("parntername", PARTNER_NAME);
            map.put("partnerPassword", PARTNER_PASSWORD);
            String credential = Credentials.basic(PARTNER_NAME, PARTNER_PASSWORD);
            String rspJsonStr = jsonPost(TOKEN_URL, map, credential);
            OAuthTokenResponse rsp = OBJECT_MAPPER.readValue(rspJsonStr, OAuthTokenResponse.class);
            return rsp;
        } catch (IOException e) {
            logger.error("Cannot get oauthToken from mobike", e);
        }
        return  null;
    }

    public GetOpenCityListResponse getOpenCityList(GetOpenCityListRequest req) {
        try {
            String rspJsonStr = jsonPost(API_URL + ApiPath.GET_OPEN_CITY_LIST, req);
            GetOpenCityListResponse rsp = new GetOpenCityListResponse();
            List<OpenCityObject> list = JSON.parseArray(rspJsonStr, OpenCityObject.class);
            rsp.setCityCode(list);
            return rsp;
        } catch (IOException e) {
            logger.error("Cannot get oauthToken from mobike", e);
        }
        return  null;
    }

    public UnlockBikeResponse unlockBike(UnlockBikeRequest pRequest) {
        try {
            FormBody.Builder formBodyBuilder = new FormBody.Builder();
            Map<String, String> map = pRequest.toMap();
            if(MapUtils.isNotEmpty(map)) {
                for(Map.Entry<String, String> entry: map.entrySet()) {
                    formBodyBuilder.add(entry.getKey(), entry.getValue());
                }
            }
            String url = API_URL + ApiPath.UNLOCK_BIKE;
            Request request = new Request.Builder()
                    .url(url)
                    .addHeader("platform", MOBIKE_PLATFORM)
                    .post(formBodyBuilder.build())
                    .build();
            Response response = OK_HTTP_CLIENT.newCall(request).execute();
            String rspJsonStr = null;
            if(response.isSuccessful()) {
                rspJsonStr = response.body().string();
                logger.info("req:{}, rsp:,{}", map, rspJsonStr);
                saveIfaceLog(url, String.valueOf(map), rspJsonStr);
                UnlockBikeResponse rsp = OBJECT_MAPPER.readValue(rspJsonStr, UnlockBikeResponse.class);
                return rsp;
            }
        } catch (IOException e) {
            logger.error("Cannot get partnerlogin from mobike", e);
        }
        return  null;
    }

    public PartnerloginResponse partnerlogin(PartnerloginRequest pRequest) {
        try {
            pRequest.setChannelNo(CHANNEL_NO);
            FormBody.Builder formBodyBuilder = new FormBody.Builder();
            Map<String, String> map = pRequest.toMap();
            if(MapUtils.isNotEmpty(map)) {
                for(Map.Entry<String, String> entry: map.entrySet()) {
                    formBodyBuilder.add(entry.getKey(), entry.getValue());
                }
            }
            String url = API_URL + ApiPath.PARTNERLOGIN;
            String accesstoken = pRequest.getAccesstoken();
            String mobileNo = pRequest.getMobileNo();
            Request request = new Request.Builder()
                    .url(url)
                    .addHeader("accesstoken", accesstoken)
                    .addHeader("time", String.valueOf(Instant.now().getEpochSecond()))
                    .addHeader("mobileNo", mobileNo)
                    .post(formBodyBuilder.build())
                    .build();
            Response response = OK_HTTP_CLIENT.newCall(request).execute();
            String rspJsonStr = null;
            if(response.isSuccessful()) {
                rspJsonStr = response.body().string();
                logger.info("req:{}, rsp:,{}", map, rspJsonStr);
                saveIfaceLog(url, String.valueOf(map), rspJsonStr);
                PartnerloginResponse rsp = OBJECT_MAPPER.readValue(rspJsonStr, PartnerloginResponse.class);
                return rsp;
            }
        } catch (IOException e) {
            logger.error("Cannot get partnerlogin from mobike", e);
        }
        return  null;
    }

    private <Req extends AbstractMobikeRequest> String jsonPost(String url, Req req) throws IOException {
        FormBody.Builder formBodyBuilder = new FormBody.Builder();
        Map<String, String> map = req.toMap();
        if(MapUtils.isNotEmpty(map)) {
            for(Map.Entry<String, String> entry: map.entrySet()) {
                formBodyBuilder.add(entry.getKey(), entry.getValue());
            }
            String sign = req.sign();
            formBodyBuilder.add("sign", sign);
        }
        Request request = new Request.Builder()
                .url(url)
                .post(formBodyBuilder.build())
                .build();
        Response response = OK_HTTP_CLIENT.newCall(request).execute();
        String rspJsonStr = null;
        if(response.isSuccessful()) {
            rspJsonStr = response.body().string();
        }
        logger.info("req:{}, rsp:,{}", req, rspJsonStr);
        saveIfaceLog(url, String.valueOf(req), rspJsonStr);
        return rspJsonStr;
    }

    private String jsonPost(String url, Map<String, String> map, String credential) throws IOException {
        FormBody.Builder formBodyBuilder = new FormBody.Builder();
        if(MapUtils.isNotEmpty(map)) {
            for(Map.Entry<String, String> entry: map.entrySet()) {
                formBodyBuilder.add(entry.getKey(), entry.getValue());
            }
        }
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Authorization", StringUtils.defaultString(credential, ""))
                .post(formBodyBuilder.build())
                .build();
        Response response = OK_HTTP_CLIENT.newCall(request).execute();
        String rspJsonStr = null;
        if(response.isSuccessful()) {
            rspJsonStr = response.body().string();
        }
        logger.info("req:{}, rsp:,{}", map, rspJsonStr);
        saveIfaceLog(url, String.valueOf(map), rspJsonStr);
        return rspJsonStr;
    }
}
