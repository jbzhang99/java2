package com.rfchina.community.openstore.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.rfchina.community.entity.Coord;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 */
@Component
public class BaiduMapComponent {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${baidu.map.routematrix.walking_url:http://api.map.baidu.com/routematrix/v2/driving?}")
    private String routematrixWalkingUrl;

    @Value("${baidu.map.routematrix.ak}")
    private String ak;

    public Map<Coord, String> calculateDistance(Coord from, List<Coord> targetList) {
        logger.info("baidu-map-parameters:{} ||| {}", from, targetList);
        Map<Coord, String> resultMap = new HashMap<>();
        if(null == from || CollectionUtils.isEmpty(targetList)) {
            return resultMap;
        }
        if(StringUtils.isAnyBlank(from.getLng(),from.getLat())){
            return resultMap;
        }
        //去重
        List<Coord> newTargetList = delRepeatData(targetList);
        logger.info("parse-duplicated-list:{}", newTargetList);
        String origins = from.toString();
        String destinations = StringUtils.join(newTargetList, "|");
        String output = "json";
        StringBuilder url = new StringBuilder().append(routematrixWalkingUrl).append("origins=").append(origins)
                .append("&destinations=").append(destinations).append("&output=").append(output).append("&ak=").append(ak);
        resultMap = request(url.toString(),newTargetList);
        logger.info("baidu-map-response:{} ||| {}, response: {}", from, newTargetList, resultMap);
        return resultMap;
    }

    private Map<Coord, String> request(String url, List<Coord> newTargetList){
        Map<Coord, String> resultMap = new HashMap<>();
        Request request = new Request.Builder().url(url).get().build();
        final okhttp3.OkHttpClient.Builder httpBuilder = new OkHttpClient.Builder();
        OkHttpClient okHttpClient  = httpBuilder
                .connectTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .build();
        try {
            Response response = okHttpClient.newCall(request).execute();
            logger.info("response from baidu map:{}", response);
            if(response.isSuccessful()) {
                JSONObject jsonObject = JSON.parseObject(response.body().string());
                if(0 == jsonObject.getIntValue("status")) {
                    JSONArray arrayResult = jsonObject.getJSONArray("result");
                    dealData(arrayResult,newTargetList,resultMap);
                }
            }
        } catch (IOException e) {
            logger.error("get-distance-from-baidu-map-error", e);
        }
        return resultMap;
    }

    /**
     * @Author wlrllr
     * @Description 数据逻辑处理
     * @Date 2018/12/28
     * @Param [arrayResult, newTargetList, resultMap]
     * @return void
     **/
    private void dealData(JSONArray arrayResult,List<Coord> newTargetList,Map<Coord, String> resultMap){
        if(CollectionUtils.isNotEmpty(arrayResult)) {
            for(int v=0; v< arrayResult.size(); v++) {
                JSONObject distanceObject = arrayResult.getJSONObject(v).getJSONObject("distance");
                Coord targetCoord = newTargetList.get(v);
                String text = distanceObject.getString("text");
                String distance = "";
                if(StringUtils.contains(text, "米")) {
                    distance = StringUtils.replace(text, "米", "m");
                } else if(StringUtils.contains(text, "公里")) {
                    distance = StringUtils.replace(text, "公里", "km");
                }
                resultMap.put(targetCoord, distance);
            }
        }
    }
    /**
     * @Author wlrllr
     * @Description 去掉重复数据
     * @Date 2018/12/28
     * @Param [targetList]
     * @return java.util.List<com.rfchina.community.entity.Coord>
     **/
    private List<Coord> delRepeatData(List<Coord> targetList){
        List<Coord> newTargetList = new ArrayList<>();
        for(Coord item : targetList) {
            if(!newTargetList.contains(item)) {
                newTargetList.add(item);
            }
        }
        return newTargetList;
    }
}
