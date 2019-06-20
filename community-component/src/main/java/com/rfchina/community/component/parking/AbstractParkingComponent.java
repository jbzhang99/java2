package com.rfchina.community.component.parking;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rfchina.community.component.IfaceComponent;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 */
abstract class AbstractParkingComponent extends IfaceComponent {

    protected final OkHttpClient OK_HTTP_CLIENT  = new OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build();

    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    static {
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    protected <T extends AbstractParkingRequest> String jsonGet(String url, T req) throws IOException {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(url);
        Map<String, String> reqMap = req.toMap();
        reqMap.forEach((mapKey, mapValue) -> {
            if(StringUtils.isNotBlank(mapValue)) {
                uriComponentsBuilder.queryParam(mapKey, mapValue);
            }
        });
        Request request = new Request.Builder()
                .url(uriComponentsBuilder.build().toUriString())
                .get()
                .build();
        Response response = OK_HTTP_CLIENT.newCall(request).execute();
        String rspJsonStr = null;
        if(response.isSuccessful()) {
            rspJsonStr = response.body().string();
        } else {
            logger.info("code:{}, headers:{}", response.code(), response.headers());
        }
        logger.info("req:{}, rsp:,{}", reqMap, rspJsonStr);
        saveIfaceLog(url, String.valueOf(reqMap), rspJsonStr);
        return rspJsonStr;
    }

    protected <Req extends AbstractParkingRequest> String jsonPost(String url, Req req) throws IOException {
        FormBody.Builder formBodyBuilder = new FormBody.Builder();
        Map<String, String> reqMap = req.toMap();
        reqMap.forEach((mapKey, mapValue) -> {
            if(StringUtils.isNotBlank(mapValue)) {
                formBodyBuilder.add(mapKey, mapValue);
            }
        });
        Request request = new Request.Builder()
                .url(url)
                .post(formBodyBuilder.build())
                .build();
        Response response = OK_HTTP_CLIENT.newCall(request).execute();
        String rspJsonStr = null;
        if(response.isSuccessful()) {
            rspJsonStr = response.body().string();
        }
        logger.info("req:{}, rsp:,{}", reqMap, rspJsonStr);
        saveIfaceLog(url, String.valueOf(reqMap), rspJsonStr);
        return rspJsonStr;
    }

}
