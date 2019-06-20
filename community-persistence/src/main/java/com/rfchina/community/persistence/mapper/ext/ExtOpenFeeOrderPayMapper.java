package com.rfchina.community.persistence.mapper.ext;

import java.util.Map;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;

import com.rfchina.community.persistence.model.ext.ExtOpenFeeOrderPay;

/**
 */
public interface ExtOpenFeeOrderPayMapper {
    
    @SelectProvider(type=ExtOpenFeeOrderPaySqlProvider.class, method="pageByCondition")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
        @Result(column="out_trade_no", property="outTradeNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="bill_id", property="billId", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="pay_status", property="payStatus", jdbcType=JdbcType.CHAR),
        @Result(column="pay_type", property="payType", jdbcType=JdbcType.CHAR),
        @Result(column="pay_amount", property="payAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="pay_time", property="payTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="open_id", property="openId", jdbcType=JdbcType.BIGINT),
        @Result(column="img_link", property="imgLink", jdbcType=JdbcType.VARCHAR),
        @Result(column="pay_channel", property="payChannel", jdbcType=JdbcType.VARCHAR),
        @Result(column="reject_reason", property="rejectReason", jdbcType=JdbcType.VARCHAR),
        @Result(column="service_name", property="serviceName", jdbcType=JdbcType.VARCHAR),
        @Result(column="merchant_name", property="merchantName", jdbcType=JdbcType.VARCHAR)
    })
	public PageList<ExtOpenFeeOrderPay> pageByCondition(Map<String, Object> param , PageBounds pageBounds);
}
