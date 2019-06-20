package com.rfchina.community.component.parking;

import com.rfchina.community.component.parking.ralid.RalidLoginRequest;
import com.rfchina.community.component.parking.ralid.RalidLoginResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 */
@Component
public class RalidParkingComponent extends AbstractParkingComponent {

    interface ApiPath {

        String GET_FEE = "/rest/api/parking/getFee.action";

        String LOGIN = "/rest/api/parking/login.action";

        String GET_MONTHLY_INFO = "/rest/api/parking/getMonthlyInfo.action";

        String PAY_NOTIFY = "/rest/api/parking/payNotify.action";

        String PAY_MONTH_NOTIFY = "/rest/api/parking/payMonthNotify.action";

        String CREATE_MONTH_ORDER_NO = "/rest/api/parking/createMonthOrderNo.action";

        String GET_REAL_TIME = "/rest/api/parking/getRealTime.action";
    }


    public RalidLoginResponse login(String host, RalidLoginRequest request) {
        String url = host + ApiPath.LOGIN;
        try {
            String rspJsonStr = jsonPost(url, request);
            logger.info("Invoke[ralid-login], response: {}", rspJsonStr);
            if(StringUtils.isNotBlank(rspJsonStr)) {
                RalidLoginResponse rsp = OBJECT_MAPPER.readValue(rspJsonStr, RalidLoginResponse.class);
                return rsp;
            }
        } catch (IOException e) {
            logger.error("Invoke ralid-login error", e);
        }
        return null;
    }

    public GetParkingFeeResponse getParkingFee(String host, GetParkingFeeRequest request) {
        String url = host + ApiPath.GET_FEE;
        try {
            String rspJsonStr = jsonPost(url, request);
            logger.info("Invoke[getParkingFee], response: {}", rspJsonStr);
            if(StringUtils.isNotBlank(rspJsonStr)) {
                GetParkingFeeResponse rsp = OBJECT_MAPPER.readValue(rspJsonStr, GetParkingFeeResponse.class);
                return rsp;
            }
        } catch (IOException e) {
            logger.error("Invoke getParkingFee error", e);
        }
        return null;
    }

    public GetMonthlyInfoResponse getMonthlyInfo(String host, GetMonthlyInfoRequest request) {
        String url = host + ApiPath.GET_MONTHLY_INFO;
        try {
            String rspJsonStr = jsonPost(url, request);
            logger.info("Invoke[getMonthlyInfo], response: {}", rspJsonStr);
            if(StringUtils.isNotBlank(rspJsonStr)) {
                GetMonthlyInfoResponse rsp = OBJECT_MAPPER.readValue(rspJsonStr, GetMonthlyInfoResponse.class);
                return rsp;
            }
        } catch (IOException e) {
            logger.error("Invoke getMonthlyInfo error", e);
        }
        return null;
    }

    public PayNotifyResponse payNotify(String host, PayNotifyRequest request) {
        String url = host + ApiPath.PAY_NOTIFY;
        try {
            String rspJsonStr = jsonPost(url, request);
            logger.info("Invoke[payNotify], response: {}", rspJsonStr);
            if(StringUtils.isNotBlank(rspJsonStr)) {
                PayNotifyResponse rsp = OBJECT_MAPPER.readValue(rspJsonStr, PayNotifyResponse.class);
                return rsp;
            }
        } catch (IOException e) {
            logger.error("Invoke payNotify error", e);
        }
        return null;
    }

    public PayMonthNotifyResponse payMonthNotify(String host, PayMonthNotifyRequest request) {
        String url = host + ApiPath.PAY_MONTH_NOTIFY;
        try {
            String rspJsonStr = jsonPost(url, request);
            logger.info("Invoke[payMonthNotify], response: {}", rspJsonStr);
            if(StringUtils.isNotBlank(rspJsonStr)) {
                PayMonthNotifyResponse rsp = OBJECT_MAPPER.readValue(rspJsonStr, PayMonthNotifyResponse.class);
                return rsp;
            }
        } catch (IOException e) {
            logger.error("Invoke payMonthNotify error", e);
        }
        return null;
    }

    public CreateMonthOrderNoResponse createMonthOrderNo(String host, CreateMonthOrderNoRequest request) {
        String url = host + ApiPath.CREATE_MONTH_ORDER_NO;
        try {
            String rspJsonStr = jsonPost(url, request);
            logger.info("Invoke[createMonthOrderNo], response: {}", rspJsonStr);
            if(StringUtils.isNotBlank(rspJsonStr)) {
                CreateMonthOrderNoResponse rsp = OBJECT_MAPPER.readValue(rspJsonStr, CreateMonthOrderNoResponse.class);
                return rsp;
            }
        } catch (IOException e) {
            logger.error("Invoke createMonthOrderNo error", e);
        }
        return null;
    }

    public GetRealTimeResponse getRealTime(String host, GetRealTimeRequest request) {
        String url = host + ApiPath.GET_REAL_TIME;
        try {
            String rspJsonStr = jsonPost(url, request);
            logger.info("Invoke[getRealTime], response: {}", rspJsonStr);
            if(StringUtils.isNotBlank(rspJsonStr)) {
                GetRealTimeResponse rsp = OBJECT_MAPPER.readValue(rspJsonStr, GetRealTimeResponse.class);
                return rsp;
            }
        } catch (IOException e) {
            logger.error("Invoke getRealTime error", e);
        }
        return null;
    }
}
