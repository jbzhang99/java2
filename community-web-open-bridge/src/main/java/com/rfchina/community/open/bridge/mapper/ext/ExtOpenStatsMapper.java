package com.rfchina.community.open.bridge.mapper.ext;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface ExtOpenStatsMapper {

    // 注册商家数：365 家
    @Select({"select count(*) from open_merchant_info where status=1 "})
    public Long regSum();

    // 上架服务总数：71 个
    @Select({"select count(*) from community_service where type in(3,4) and status=1 "})
    public Long wufuShelves();

    // 创建订单数量：688 单
    @Select({"select count(*) from open_order  where type in (1,4,5,6)   "})
    public Long countOpenOrederAll();

    // 成交订单总数：79 单
    @Select({"select count(*) from open_order  where type in (1,4,5,6) and bill_status=2 "})
    public Long countOpenOrederPay();

    // 成交总金额：8761.50 元
    @Select({"select sum(total_amount) from open_order  where type in (1,4,5,6) and bill_status=2 "})
    public BigDecimal totalAmount();

    //根据年份获取成交总额
    @SelectProvider(type = ExtOpenStatsSqlProvider.class, method = "totalAmountByYear")
    public BigDecimal totalAmountByYear(Map<String, Object> param);

    //根据年份获取成交总额
    @SelectProvider(type = ExtOpenStatsSqlProvider.class, method = "totalAmountPicCaution")
    public BigDecimal totalAmountPicCaution(Map<String, Object> param);

    @Select({"SELECT * from",
            "(SELECT count(1) orderNum,",
            " sum( CASE WHEN bill_status = 2 THEN 1 ELSE 0 END ) AS successOrderNum,",
            " sum( CASE WHEN bill_status = 2 THEN total_amount ELSE 0 END ) AS successOrderAmount ",
            " FROM open_order WHERE type IN (1, 3, 4, 5, 6)) openOrder,",
            "(select count(*) merchantNum from open_merchant_info where status=1) merchant,",
            "(select count(*) serviceNum from community_service where type in(3,4) and status=1) service,",
            "(select sum(money) cautionMoney,count(1) cautionNum from open_caution_info where status in (2,4)) caution"})
    List<Map<String, Object>> getZZServiceTotalData();

    @Select({
            "select * from ",
            "(select sum(case WHEN create_time> #{year} THEN 1 ELSE 0 END ) yearOrderNum,",
            "sum(CASE WHEN create_time>= #{year} AND bill_status = 2 THEN 1 ELSE 0 END ) AS yearSuccessOrderNum,",
            "sum(CASE WHEN create_time>= #{year} AND bill_status = 2 THEN total_amount ELSE 0 END ) AS yearSuccessOrderAmount,",
            "sum(case WHEN create_time>= #{curMonth} THEN 1 ELSE 0 END ) curMonthOrderNum,",
            "sum(CASE WHEN create_time>= #{curMonth} AND bill_status = 2 THEN 1 ELSE 0 END ) AS curMonthSuccessOrderNum,",
            "sum(CASE WHEN create_time>= #{curMonth} AND bill_status = 2 THEN total_amount ELSE 0 END ) AS curMonthSuccessOrderAmount,",
            "sum(case WHEN create_time>= #{lastMonth} and create_time<#{curMonth} THEN 1 ELSE 0 END ) lastMonthOrderNum,",
            "sum(CASE WHEN create_time>= #{lastMonth} and create_time<#{curMonth} and bill_status = 2 THEN 1 ELSE 0 END ) AS lastMonthSuccessOrderNum,",
            "sum(CASE WHEN create_time>= #{lastMonth} and create_time<#{curMonth} and bill_status = 2 THEN total_amount ELSE 0 END ) AS lastMonthSuccessOrderAmount,",
            "count(1) orderNum,",
            "sum( CASE WHEN bill_status = 2 THEN 1 ELSE 0 END ) AS successOrderNum,",
            "sum( CASE WHEN bill_status = 2 THEN total_amount ELSE 0 END ) AS successOrderAmount",
            "from open_order where type in (1, 3, 4, 5, 6)) t,",

            "(select sum(case WHEN pay_time>= #{year} THEN 1 ELSE 0 END ) cautionYearOrderNum,",
            "sum(CASE WHEN pay_time>= #{year} THEN money ELSE 0 END ) AS cautionYearAmount,",
            "sum(case WHEN pay_time>= #{curMonth} THEN 1 ELSE 0 END ) cautionCurMonthOrderNum,",
            "sum(CASE WHEN pay_time>= #{curMonth} THEN money ELSE 0 END ) AS cautionCurMonthAmount,",
            "sum(case WHEN pay_time>= #{lastMonth} and pay_time<#{curMonth} THEN 1 ELSE 0 END ) cautionLastMonthOrderNum,",
            "sum(CASE WHEN pay_time>= #{lastMonth} and pay_time<#{curMonth} THEN money ELSE 0 END ) AS cautionLastMonthAmount,",
            "count(1) cautionOrderNum,",
            "sum(money) AS cautionAmount ",
            "from open_caution_info where `status` in (2,4)) t1,",
            "(select count(*) merchantNum from open_merchant_info where status=1) merchant,",
            "(select count(*) serviceNum from community_service where type in(3,4) and status=1) service"
    })
    List<Map<String, Object>> getZZServiceData(Map<String, Object> param);
}
