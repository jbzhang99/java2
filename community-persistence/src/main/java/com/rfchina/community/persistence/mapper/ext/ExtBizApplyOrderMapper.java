package com.rfchina.community.persistence.mapper.ext;

import com.rfchina.community.persistence.model.BizApplyOrder;
import com.rfchina.community.persistence.model.BizApplyOrderExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;

import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 */
public interface ExtBizApplyOrderMapper {

    @SelectProvider(type=ExtBizApplyOrderSqlProvider.class, method="pageByExample")
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
            @Result(column="trade_no", property="tradeNo", jdbcType=JdbcType.VARCHAR),
            @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
            @Result(column="master_id", property="masterId", jdbcType=JdbcType.BIGINT),
            @Result(column="master_child_id", property="masterChildId", jdbcType=JdbcType.BIGINT),
            @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
            @Result(column="contact", property="contact", jdbcType=JdbcType.VARCHAR),
            @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
            @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
            @Result(column="order_type", property="orderType", jdbcType=JdbcType.INTEGER),
            @Result(column="order_status", property="orderStatus", jdbcType=JdbcType.INTEGER),
            @Result(column="pay_status", property="payStatus", jdbcType=JdbcType.INTEGER),
            @Result(column="pay_type", property="payType", jdbcType=JdbcType.VARCHAR),
            @Result(column="pay_price", property="payPrice", jdbcType=JdbcType.DECIMAL),
            @Result(column="pay_amount", property="payAmount", jdbcType=JdbcType.DECIMAL),
            @Result(column="pay_time", property="payTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="attachment", property="attachment", jdbcType=JdbcType.VARCHAR),
            @Result(column="apply_time", property="applyTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="apply_num", property="applyNum", jdbcType=JdbcType.INTEGER),
            @Result(column="apply_address", property="applyAddress", jdbcType=JdbcType.VARCHAR),
            @Result(column="obtain_address", property="obtainAddress", jdbcType=JdbcType.VARCHAR),
            @Result(column="obtain_time", property="obtainTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="audit_status", property="auditStatus", jdbcType=JdbcType.TINYINT),
            @Result(column="audit_reason", property="auditReason", jdbcType=JdbcType.VARCHAR),
            @Result(column="audit_time", property="auditTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="validation_code", property="validationCode", jdbcType=JdbcType.VARCHAR),
            @Result(column="rfpay_bill_id", property="rfpayBillId", jdbcType=JdbcType.VARCHAR),
            @Result(column="rfpay_trade_no", property="rfpayTradeNo", jdbcType=JdbcType.VARCHAR),
            @Result(column="rfpay_body", property="rfpayBody", jdbcType=JdbcType.VARCHAR),
            @Result(column="rfpay_type", property="rfpayType", jdbcType=JdbcType.VARCHAR),
            @Result(column="rfpay_create_time", property="rfpayCreateTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="rfpay_close_time", property="rfpayCloseTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="rfpay_account", property="rfpayAccount", jdbcType=JdbcType.VARCHAR),
            @Result(column="rfpay_fee_rate", property="rfpayFeeRate", jdbcType=JdbcType.DECIMAL),
            @Result(column="rfpay_clearing_fee", property="rfpayClearingFee", jdbcType=JdbcType.DECIMAL),
            @Result(column="rfpay_actual_clearing_fee", property="rfpayActualClearingFee", jdbcType=JdbcType.BIGINT),
            @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    PageList<BizApplyOrder> pageByExample(@Param("example") BizApplyOrderExample example, PageBounds pageBounds);


    @Select(value = {
            "select community_id, count(1) as count, ",
            "sum(pay_amount) as price, ",
            "sum(rfpay_actual_clearing_fee) as counter_fee " ,
            "from biz_apply_order where pay_status = #{payStatus,jdbcType=INTEGER} ",
            "and community_id=#{communityId,jdbcType=INTEGER} ",
            "and pay_time>=#{startDate} and pay_time<=#{endDate} "})
    Map<String, Object> totalSettlement(@Param("communityId") Integer communityId,
                                        @Param("payStatus") Integer payStatus,
                                        @Param("startDate") Date startDate,
                                        @Param("endDate") Date endDate);


    @Select(value = {
        " SELECT                                                          ",
        " 	a.community_id,                                               ",
        " 	a.pay_price,                                                  ",
        " 	a.rfpay_fee_rate,                                             ",
        " 	count(id) as apply_num,                                       ",
        " 	sum(a.pay_amount) as pay_amount,                              ",
        " 	sum(a.rfpay_actual_clearing_fee) as rfpay_actual_clearing_fee ",
        " FROM                                                            ",
        " 	biz_apply_order a                                             ",
        " WHERE a.community_id = #{communityId,jdbcType=INTEGER}          ",
        " AND a.pay_status = #{payStatus,jdbcType=INTEGER}                ",
        " AND a.pay_time >= #{startDate} and a.pay_time <= #{endDate}     ",
        " GROUP BY                                                        ",
        " 	a.community_id,                                               ",
        " 	a.pay_price,                                                  ",
        " 	a.rfpay_fee_rate                                              "
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
            @Result(column="trade_no", property="tradeNo", jdbcType=JdbcType.VARCHAR),
            @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
            @Result(column="master_id", property="masterId", jdbcType=JdbcType.BIGINT),
            @Result(column="master_child_id", property="masterChildId", jdbcType=JdbcType.BIGINT),
            @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
            @Result(column="contact", property="contact", jdbcType=JdbcType.VARCHAR),
            @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
            @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
            @Result(column="order_type", property="orderType", jdbcType=JdbcType.INTEGER),
            @Result(column="order_status", property="orderStatus", jdbcType=JdbcType.INTEGER),
            @Result(column="pay_status", property="payStatus", jdbcType=JdbcType.INTEGER),
            @Result(column="pay_type", property="payType", jdbcType=JdbcType.VARCHAR),
            @Result(column="pay_price", property="payPrice", jdbcType=JdbcType.DECIMAL),
            @Result(column="pay_amount", property="payAmount", jdbcType=JdbcType.DECIMAL),
            @Result(column="pay_time", property="payTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="attachment", property="attachment", jdbcType=JdbcType.VARCHAR),
            @Result(column="apply_time", property="applyTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="apply_num", property="applyNum", jdbcType=JdbcType.INTEGER),
            @Result(column="apply_address", property="applyAddress", jdbcType=JdbcType.VARCHAR),
            @Result(column="obtain_address", property="obtainAddress", jdbcType=JdbcType.VARCHAR),
            @Result(column="obtain_time", property="obtainTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="audit_status", property="auditStatus", jdbcType=JdbcType.TINYINT),
            @Result(column="audit_reason", property="auditReason", jdbcType=JdbcType.VARCHAR),
            @Result(column="audit_time", property="auditTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="validation_code", property="validationCode", jdbcType=JdbcType.VARCHAR),
            @Result(column="rfpay_bill_id", property="rfpayBillId", jdbcType=JdbcType.VARCHAR),
            @Result(column="rfpay_trade_no", property="rfpayTradeNo", jdbcType=JdbcType.VARCHAR),
            @Result(column="rfpay_body", property="rfpayBody", jdbcType=JdbcType.VARCHAR),
            @Result(column="rfpay_type", property="rfpayType", jdbcType=JdbcType.VARCHAR),
            @Result(column="rfpay_create_time", property="rfpayCreateTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="rfpay_close_time", property="rfpayCloseTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="rfpay_account", property="rfpayAccount", jdbcType=JdbcType.VARCHAR),
            @Result(column="rfpay_fee_rate", property="rfpayFeeRate", jdbcType=JdbcType.DECIMAL),
            @Result(column="rfpay_clearing_fee", property="rfpayClearingFee", jdbcType=JdbcType.DECIMAL),
            @Result(column="rfpay_actual_clearing_fee", property="rfpayActualClearingFee", jdbcType=JdbcType.BIGINT),
            @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<BizApplyOrder> caculateBizApplyOrderReport(@Param("communityId") Integer communityId,
                                                    @Param("payStatus") Integer payStatus,
                                                    @Param("startDate") Date startDate,
                                                    @Param("endDate") Date endDate);
}
