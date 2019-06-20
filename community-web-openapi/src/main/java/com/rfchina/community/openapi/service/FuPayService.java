package com.rfchina.community.openapi.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.rfchina.api.ApiClient;
import com.rfchina.api.request.app.GetAccessTokenRequest;
import com.rfchina.api.request.oauth2.Oauth2ClientTicketRequest;
import com.rfchina.api.request.pay.FuPayCreateRequest;
import com.rfchina.api.request.pay.FuPayCreateRequest.GoodsDetail;
import com.rfchina.api.request.pay.FuPayPosCreateBillRequest;
import com.rfchina.api.request.pay.FuPayQrCodeGenRequest;
import com.rfchina.api.request.user.GetUserInfoWithOpenIdRequest;
import com.rfchina.api.response.ResponseData;
import com.rfchina.api.response.model.app.GetAccessTokenReponseModel;
import com.rfchina.api.response.model.oauth2.Oauth2ClientTicketResponseModel;
import com.rfchina.api.response.model.pay.FuPayCreateResponseModel;
import com.rfchina.api.response.model.pay.FuPayPreOrderResponseModel;
import com.rfchina.api.response.model.pay.FuPayQrCodeGenResponseModel;
import com.rfchina.api.response.model.user.GetUserInfoWithOpenIdResponseModel;
import com.rfchina.community.base.OpenConstant;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class FuPayService {

    private static transient Logger logger = LoggerFactory.getLogger(FuPayService.class);

    private Cache<String, String> accessTokenLocalCache = CacheBuilder.newBuilder()
            .expireAfterWrite(55, TimeUnit.MINUTES).build();

    @Value("${rfpay.host}")
    private String rfpayHost;

    // 获取平台的accessToken
    public String getAccessToken(Long rfpayAppId, String rfpayAppSecret) {
        // 从缓存里面获取accessToken
        String accessToken = accessTokenLocalCache.getIfPresent(rfpayAppSecret + "_" + rfpayAppId);

        // 如果缓存里面为空，则从平台重新获取accessToken
        if (StringUtils.isBlank(accessToken)) {
            accessToken = getRemoteAccessToken(rfpayAppId, rfpayAppSecret);
            if (accessToken != null) {
                accessTokenLocalCache.put(rfpayAppSecret + "_" + rfpayAppId, accessToken);
            }
        }
        return accessToken;
    }

    protected String getRemoteAccessToken(Long appId, String appSecret) {
        GetAccessTokenRequest request = new GetAccessTokenRequest(appId, appSecret);
        ApiClient apiClient = new ApiClient(rfpayHost, appId, appSecret);
        ResponseData<GetAccessTokenReponseModel> responseData = apiClient.execute(request);
        logger.info("Invoke [getRemoteAccessToken] with parameters:rfpayHost:{}, appId{}, appSecret{}  and response: {}",
                rfpayHost, appId, appSecret, JSON.toJSONString(responseData));
        GetAccessTokenReponseModel model = responseData.getData();
        return null != model ? model.getAccessToken() : null;
    }

    public ResponseData<Oauth2ClientTicketResponseModel> getClientTicket(String accessToken, long appId,
                                                                         String appSecret) {

        // Map<String, String> params = new HashMap<>();
        // params.put("access_token", accessToken);
        // params.put("type", "JSTICKET");

        Oauth2ClientTicketRequest request = new Oauth2ClientTicketRequest(accessToken, "JSTICKET");

        ApiClient apiClient = new ApiClient(rfpayHost, appId, appSecret);

        ResponseData<Oauth2ClientTicketResponseModel> responseData = apiClient.execute(request);

        // if (1001 == responseData.getCode()) {
        // return responseData.getData().getClientTicket();
        // }
        logger.info("getClientTicket:{},appId:{},appSecret:{},{}", accessToken, appId, appSecret,
                JSON.toJSONString(responseData));

        return responseData;
    }


    public ResponseData<GetUserInfoWithOpenIdResponseModel> getUserInfoWithOpenIdRequest(Long rfpayAppId,
                                                                                         String rfpayAppSecret, long appId, String openId) {
        logger.info(
                " getUserInfoWithOpenIdRequest rfpayHost:{} ,rfpayAppId :{},   rfpayAppSecret :{},  appId:{},   openId:{} ",
                rfpayHost, rfpayAppId, rfpayAppSecret, appId, openId);
        String accessToken = getAccessToken(rfpayAppId, rfpayAppSecret);
        GetUserInfoWithOpenIdRequest payApplyRequest = new GetUserInfoWithOpenIdRequest(accessToken, appId, openId);

        ApiClient apiClient = new ApiClient(rfpayHost, rfpayAppId, rfpayAppSecret);
        ResponseData<GetUserInfoWithOpenIdResponseModel> responseData = apiClient.execute(payApplyRequest);
        return responseData;
    }


    public ResponseData<FuPayCreateResponseModel> fuPayCreate(Long rfpayAppId, String rfpayAppSecret, String accountId,
                                                              String payChannel, String outTradeNo, long totalAmount, long feeAmount, String subject, String body,
                                                              String detail, String clientIp, Integer bussinessType, LocalDateTime expireTime, String projectType,
                                                              String tradeType, String openId, String wapName, String wapUrl, String wapRedirectUrl, FuPayCreateRequest.GoodsDetail... goodsDetails) {
        return fuPayCreate(rfpayAppId, rfpayAppSecret, accountId,
                payChannel, outTradeNo, totalAmount, feeAmount, subject, body,
                detail, clientIp, bussinessType, expireTime, projectType,
                tradeType, openId, wapName, wapUrl, wapRedirectUrl, null, null, null, null, null, goodsDetails);
    }

    public ResponseData<FuPayCreateResponseModel> fuPayCreateForSAPP(Long rfpayAppId, String rfpayAppSecret, String accountId,
                                                                     String payChannel, String outTradeNo, long totalAmount, long feeAmount, String subject,
                                                                     String body, String detail, String clientIp, Integer businessType, LocalDateTime expireTime,
                                                                     String projectType, String openId, String channelAppName, String wapName, String wapUrl, String wapRedirectUrl,
                                                                     FuPayCreateRequest.GoodsDetail... goodsDetails) {
        return fuPayCreate(rfpayAppId, rfpayAppSecret, accountId,
                payChannel, outTradeNo, totalAmount, feeAmount, subject, body,
                detail, clientIp, businessType, expireTime, projectType,
                OpenConstant.TradeType.SAPP, openId, wapName, wapUrl, wapRedirectUrl, channelAppName, null, null, null, null, goodsDetails);
    }

    public ResponseData<FuPayCreateResponseModel> fuPayCreate(Long rfpayAppId, String rfpayAppSecret, String accountId,
                                                              String payChannel, String outTradeNo, long totalAmount, long feeAmount, String subject, String body,
                                                              String detail, String clientIp, Integer bussinessType, LocalDateTime expireTime, String projectType,
                                                              String tradeType, String openId, String wapName, String wapUrl, String wapRedirectUrl,
                                                              String channelAppName, String deviceId, String mobile, Long uid, String wid,
                                                              FuPayCreateRequest.GoodsDetail... goodsDetails) {
        String accessToken = getAccessToken(rfpayAppId, rfpayAppSecret);
        FuPayCreateRequest payApplyRequest = new FuPayCreateRequest(accessToken, accountId, payChannel, outTradeNo,
                totalAmount, feeAmount, subject, body, detail, clientIp, bussinessType, expireTime, projectType,
                tradeType, openId, channelAppName, deviceId, mobile, uid, wid, wapName, wapUrl, wapRedirectUrl, goodsDetails);

        ApiClient apiClient = new ApiClient(rfpayHost, rfpayAppId, rfpayAppSecret);
        ResponseData<FuPayCreateResponseModel> responseData = apiClient.execute(payApplyRequest);
        return responseData;
    }

    /**
     * @return ResponseData<FuPayCreateResponseModel>
     * @throws
     * @author:fukangwen
     * @Description: 渠道未知时, 扫码付预建单 FuPayQrCodeGenRequest
     */
    public ResponseData<FuPayQrCodeGenResponseModel> prePayCreate(Long rfpayAppId, String rfpayAppSecret, String accountId, String outTradeNo, long totalAmount, long feeAmount,
                                                                  String subject, String body, String clientIp, String projectType, LocalDateTime expireTime, String bussinessType,
                                                                  List<GoodsDetail> goodsDetails, String redirectUrl, String deviceId, String mobile, String uid, String wid) {
        String accessToken = getAccessToken(rfpayAppId, rfpayAppSecret);
        logger.info("prePayCreate : accessToken={},accountId={},outTradeNo={},totalAmount={},"
                        + "feeAmount={},subject={},body={},clientIp={},expireTime{},goodsDetails={}, redirectUrl={}",
                accessToken, accountId, outTradeNo, totalAmount, feeAmount, subject, body, clientIp, expireTime, JSONArray.toJSONString(goodsDetails), redirectUrl);
        FuPayQrCodeGenRequest payCreateRequest = new FuPayQrCodeGenRequest(
                accessToken, accountId, outTradeNo, totalAmount,
                feeAmount, subject, body, clientIp, projectType,
                expireTime, bussinessType, goodsDetails, redirectUrl, deviceId, mobile, uid, wid);
        ApiClient apiClient = new ApiClient(rfpayHost, rfpayAppId, rfpayAppSecret);
        ResponseData<FuPayQrCodeGenResponseModel> responseData = apiClient.execute(payCreateRequest);
        logger.info("response:{}", JSON.toJSONString(responseData));
        return responseData;
    }


    /**
     * @return ResponseData<FuPayCreateResponseModel>
     * @throws
     * @author:fukangwen
     * @Description: pos支付
     */
    public ResponseData<FuPayPreOrderResponseModel> posPayCreate(Long rfpayAppId, String rfpayAppSecret, String accountId, String outTradeNo,
                                                                 long totalAmount, long feeAmount, String subject, String body, String clientIp, String projectType, LocalDateTime expireTime,
                                                                 int bussinessType, String mobile, String tradeType, FuPayCreateRequest.GoodsDetail... goodsDetails) {
        String accessToken = getAccessToken(rfpayAppId, rfpayAppSecret);
        logger.info("prePayCreate : accessToken={},accountId={},outTradeNo={},totalAmount={},"
                        + "feeAmount={},subject={},body={},clientIp={},expireTime{},goodsDetails={}",
                accessToken, accountId, outTradeNo, totalAmount, feeAmount, subject, body, clientIp, expireTime, JSONArray.toJSONString(goodsDetails));

        FuPayPosCreateBillRequest posCreateBillRequest = new FuPayPosCreateBillRequest(accessToken, accountId, outTradeNo,
                totalAmount, feeAmount, subject, body, bussinessType, expireTime, projectType, tradeType, mobile,
                goodsDetails);

        ApiClient apiClient = new ApiClient(rfpayHost, rfpayAppId, rfpayAppSecret);

        ResponseData<FuPayPreOrderResponseModel> responseData = apiClient.execute(posCreateBillRequest);
        logger.info("response:{}", JSON.toJSONString(responseData));
        return responseData;
    }
}
