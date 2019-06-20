package com.rfchina.community.openweb.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rfchina.api.ApiClient;
import com.rfchina.api.request.app.GetAccessTokenRequest;
import com.rfchina.api.request.oauth2.Oauth2ClientTicketRequest;
import com.rfchina.api.response.ResponseData;
import com.rfchina.api.response.model.app.GetAccessTokenReponseModel;
import com.rfchina.api.response.model.oauth2.Oauth2ClientTicketResponseModel;
import com.rfchina.community.base.Constant;
import com.rfchina.community.base.Result;
import com.rfchina.community.persistence.mapper.CommunityServiceTempMapper;
import com.rfchina.community.persistence.model.CommunityServiceTemp;

import javax.servlet.http.HttpServletRequest;

/**
 */
@RestController
@RequestMapping(value = {Constant.ROOT_PATH_OPENWEB})
public class TestController extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(TestController.class);

    @Value("${platform.host}")
    private String host;

    @RequestMapping(value = {"/acc/login2"})
    public Result<?> login2(@RequestParam(required = true) Long appId,
                            @RequestParam(required = true) String appSecret) {
        GetAccessTokenRequest request = new GetAccessTokenRequest(appId, appSecret);
        ApiClient apiClient = new ApiClient(host, appId, appSecret);
        ResponseData<GetAccessTokenReponseModel> responseData = apiClient.execute(request);
        logger.info("TestController login2 host:{}, appId:{}, appSecret:{},responseData:{}", host, appId, appSecret,
                JSON.toJSONString(responseData));
        if (responseData.getCode() == 1001) {
            Oauth2ClientTicketRequest request1 = new Oauth2ClientTicketRequest(responseData.getData().getAccessToken(),
                    "JSTICKET");
            ResponseData<Oauth2ClientTicketResponseModel> responseData1 = apiClient.execute(request1);
            if (responseData.getCode() == 1001) {
                return Result.create(200, host, responseData1);
            } else {
                return Result.create(405, host, responseData1);
            }
        }
        return Result.create(404, host, responseData);
    }

    @RequestMapping(value = {"/acc/login3"})
    public Result<?> login3(@RequestParam(required = true) Long appId,
                            @RequestParam(required = true) String appSecret) {
        GetAccessTokenRequest request = new GetAccessTokenRequest(appId, appSecret);
        ApiClient apiClient = new ApiClient(host, appId, appSecret);
        ResponseData<GetAccessTokenReponseModel> responseData = apiClient.execute(request);
        logger.info("TestController login3 host:{}, appId:{}, appSecret:{},responseData:{}", host, appId, appSecret,
                JSON.toJSONString(responseData));
        return Result.create(404, host, responseData);
    }

    @RequestMapping(value = {"/acc/testCallBack"})
    @ResponseBody
    public String testCallBack(@RequestParam Map<String, Object> map) {

        logger.info("testCallBack==:{}", JSON.toJSONString(map));
        return "success";
    }

    @Autowired
    private CommunityServiceTempMapper communityServiceTempMapper;

    @RequestMapping(value = {"/acc/Service"})
    public Result<?> service(@RequestParam(required = true) Integer service_id) {
        CommunityServiceTemp data = communityServiceTempMapper.selectByPrimaryKey(service_id);
        JSONObject json = new JSONObject();
        json.put("appId", data.getAppId());
        json.put("appSecret", data.getAppSecret());
        return Result.successData(data);
    }

    @RequestMapping(value = {"/acc/request"})
    public Result<?> service(HttpServletRequest request) {
        JSONObject json = new JSONObject();
        json.put("getAuthType", request.getAuthType());
        json.put("getContextPath", request.getContextPath());
        json.put("getCookies", request.getCookies());
        json.put("getMethod", request.getMethod());
        json.put("getPathInfo", request.getPathInfo());
        json.put("getPathTranslated", request.getPathTranslated());
        json.put("getRemoteUser", request.getRemoteUser());
        json.put("getRequestedSessionId", request.getRequestedSessionId());
        json.put("getRequestURI", request.getRequestURI());
        json.put("getRequestURL", request.getRequestURL());
        json.put("getContentType", request.getContentType());
        json.put("getProtocol", request.getProtocol());
        json.put("getLocalAddr", request.getLocalAddr());

        StringBuffer url = request.getRequestURL();
        String url2 = url.substring(0, url.indexOf("/", 8));
        json.put("url2", url2);


        json.put("url3", url.substring(0,url.indexOf(request.getRequestURI())));

        return Result.successData(json);
    }

}
