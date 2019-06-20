package com.rfchina.community.open.bridge.service;

import com.alibaba.fastjson.JSONObject;
import com.rfchina.community.open.bridge.mapper.ext.ExtOpenStatsMapper;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

/**
 * @ClassName ExtOpenStatsService
 * @Description TODO
 * @Author wlrllr
 * @Date 2019/1/16 11:41
 * @Version 1.0
 **/
@Service
public class ExtOpenStatsService extends BaseService {
    @Autowired
    private ExtOpenStatsMapper extOpenStatsMapper;

    public List<Map> getZZServiceTotalData() {
        List<Map<String, Object>> list = extOpenStatsMapper.getZZServiceTotalData();
        List<Map> result = new ArrayList<>(5);
        if (list != null && !list.isEmpty()) {
            Map<String, Object> data = list.get(0);
            result.add(getDataMap("merchantNum", "家", "注册商家数", data));
            result.add(getDataMap("serviceNum", "个", "上架服务总数", data));
            BigDecimal cautionMoney = (BigDecimal) data.get("cautionMoney");
            if (cautionMoney == null) {
                cautionMoney = BigDecimal.valueOf(0L);
            }
            BigDecimal orderNum = BigDecimal.valueOf((Long) data.get("orderNum"));
            BigDecimal successOrderAmount = (BigDecimal) data.get("successOrderAmount");
            BigDecimal cautionNum = BigDecimal.valueOf((Long) data.get("cautionNum"));
            BigDecimal successOrderNum = (BigDecimal) data.get("successOrderNum");
            result.add(getDataMap(orderNum.add(cautionNum), "单", "创建订单数量"));
            result.add(getDataMap(successOrderNum.add(cautionNum), "单", "成交订单总数"));
            result.add(getDataMap(successOrderAmount.add(cautionMoney), "元", "成交总金额"));
        }
        return result;
    }

    public JSONObject getZZServiceData() {
        Map<String, Object> param = new HashMap<>();
        Date now = new Date();
        param.put("curMonth", DateFormatUtils.format(now, "yyyy-MM-01 00:00:00"));
        param.put("year", DateFormatUtils.format(now, "yyyy-01-01 00:00:00"));
        param.put("lastMonth", DateFormatUtils.format(DateUtils.addMonths(now, -1), "yyyy-MM-01 00:00:00"));
        List<Map<String, Object>> zzData = extOpenStatsMapper.getZZServiceData(param);
        List<Map<String, Object>> orderData = new ArrayList<>();
        JSONObject serviceData = new JSONObject();
        JSONObject result = new JSONObject();
        result.put("total", serviceData);
        result.put("list", orderData);
        if (zzData != null && zzData.size() > 0) {
            Map<String, Object> obj = zzData.get(0);
            serviceData.put("merchantNum", obj.get("merchantNum"));
            serviceData.put("serviceNum", obj.get("serviceNum"));
            Map<String, Object> curMonthData = new HashMap<>();
            Map<String, Object> lastMonthData = new HashMap<>();
            Map<String, Object> yearData = new HashMap<>();
            Map<String, Object> allData = new HashMap<>();
            orderData.add(curMonthData);
            orderData.add(lastMonthData);
            orderData.add(yearData);
            orderData.add(allData);
            curMonthData.put("title", "本月新增");
            curMonthData.put("orderNum", obj.get("curMonthOrderNum"));//本月订单数
            curMonthData.put("successOrderNum", obj.get("curMonthSuccessOrderNum"));//本月成功订单数
            curMonthData.put("successOrderAmount", obj.get("curMonthSuccessOrderAmount"));//本月成功交易金额
            curMonthData.put("cautionOrderNum", obj.get("cautionCurMonthOrderNum"));//本月保证金订单数
            curMonthData.put("cautionAmount", obj.get("cautionCurMonthAmount"));//本月保证金交易金额
            lastMonthData.put("title", "上月新增");
            lastMonthData.put("orderNum", obj.get("lastMonthOrderNum"));//上月订单数
            lastMonthData.put("successOrderNum", obj.get("lastMonthSuccessOrderNum"));//上月成功订单数
            lastMonthData.put("successOrderAmount", obj.get("lastMonthSuccessOrderAmount"));//上月成功交易金额
            lastMonthData.put("cautionOrderNum", obj.get("cautionLastMonthOrderNum"));//上月保证金订单数
            lastMonthData.put("cautionAmount", obj.get("cautionLastMonthAmount"));//上月保证金交易金额
            yearData.put("title", "本年新增");
            yearData.put("orderNum", obj.get("yearOrderNum"));//本年订单数
            yearData.put("successOrderNum", obj.get("yearSuccessOrderNum"));//本年成功订单数
            yearData.put("successOrderAmount", obj.get("yearSuccessOrderAmount"));//本年成功交易金额
            yearData.put("cautionOrderNum", obj.get("cautionYearOrderNum"));//本年保证金订单数
            yearData.put("cautionAmount", obj.get("cautionYearAmount"));//本年保证金交易金额
            allData.put("title", "历史累计");
            allData.put("orderNum", obj.get("orderNum"));//历史订单数
            allData.put("successOrderNum", obj.get("successOrderNum"));//历史成功订单数
            allData.put("successOrderAmount", obj.get("successOrderAmount"));//历史成功交易金额
            allData.put("cautionOrderNum", obj.get("cautionOrderNum"));//历史保证金订单数
            allData.put("cautionAmount", obj.get("cautionAmount"));//历史保证金交易金额
        }
        return result;
    }

    private Map getDataMap(String key, String unitName, String title, Map<String, Object> data) {
        Map map = new HashMap(3);
        map.put("value", data.get(key));
        map.put("title", title);
        map.put("unit", unitName);
        return map;
    }

    private Map getDataMap(Object value, String unitName, String title) {
        Map map = new HashMap(3);
        map.put("value", value);
        map.put("title", title);
        map.put("unit", unitName);
        return map;
    }

}
