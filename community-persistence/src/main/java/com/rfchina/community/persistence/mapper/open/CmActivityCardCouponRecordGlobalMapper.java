package com.rfchina.community.persistence.mapper.open;

import com.rfchina.community.persistence.model.ext.EXTCmActivityCardCouponRecord;
import com.rfchina.community.persistence.model.ext.SimCmActivityCardCouponRecord;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;

import java.io.Serializable;
import java.util.Map;

public interface CmActivityCardCouponRecordGlobalMapper extends Serializable {

	@SelectProvider(type = CmActivityCardCouponRecordGlobalSqlProvider.class, method = "pageByExample")
	@Results({ @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "activity_id", property = "activityId", jdbcType = JdbcType.BIGINT),
			@Result(column = "card_coupon_id", property = "cardCouponId", jdbcType = JdbcType.BIGINT),
			@Result(column = "coupon_id", property = "couponId", jdbcType = JdbcType.BIGINT),
			@Result(column = "coupon_sn", property = "couponSn", jdbcType = JdbcType.VARCHAR),
			@Result(column = "uid", property = "uid", jdbcType = JdbcType.BIGINT),
			@Result(column = "valid_from_date", property = "validFromDate", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "valid_to_date", property = "validToDate", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "coupon_type", property = "couponType", jdbcType = JdbcType.INTEGER),
			@Result(column = "item_type", property = "itemType", jdbcType = JdbcType.INTEGER),
			@Result(column = "source", property = "source", jdbcType = JdbcType.INTEGER),
			@Result(column = "confirm_status", property = "confirmStatus", jdbcType = JdbcType.INTEGER),
			@Result(column = "confirm_code", property = "confirmCode", jdbcType = JdbcType.VARCHAR),
			@Result(column = "confirm_time", property = "confirmTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "idcard_no", property = "idcardNo", jdbcType = JdbcType.VARCHAR),
			@Result(column = "status", property = "status", jdbcType = JdbcType.INTEGER),
			@Result(column="operator_name", property="operatorName", jdbcType=JdbcType.VARCHAR),
			@Result(column="operator_phone", property="operatorPhone", jdbcType=JdbcType.VARCHAR),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.TIMESTAMP) })
	PageList<EXTCmActivityCardCouponRecord> pageByExample(Map<String, Object> example, PageBounds pageBounds);

	@SelectProvider(type = CmActivityCardCouponRecordGlobalSqlProvider.class, method = "pageByParam")
	@Results({ @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "card_coupon_id", property = "cardCouponId", jdbcType = JdbcType.BIGINT),
			@Result(column = "coupon_id", property = "couponId", jdbcType = JdbcType.BIGINT),
			@Result(column = "uid", property = "uid", jdbcType = JdbcType.BIGINT),
			@Result(column = "valid_from_date", property = "validFromDate", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "valid_to_date", property = "validToDate", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "coupon_type", property = "couponType", jdbcType = JdbcType.INTEGER),
			@Result(column = "item_type", property = "itemType", jdbcType = JdbcType.INTEGER),
			@Result(column = "confirm_status", property = "confirmStatus", jdbcType = JdbcType.INTEGER),
			@Result(column = "status", property = "status", jdbcType = JdbcType.INTEGER),
			@Result(column = "pay_amount", property = "payAmount", jdbcType = JdbcType.DECIMAL),
			@Result(column = "limit_money", property = "limitMoney", jdbcType = JdbcType.DECIMAL),
			@Result(column = "coupon_name", property = "couponName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "use_rule", property = "useRule", jdbcType = JdbcType.VARCHAR),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP) })
	PageList<SimCmActivityCardCouponRecord> pageByParam(Map<String, Object> map, PageBounds pageBounds);

	@UpdateProvider(type = CmActivityCardCouponRecordGlobalSqlProvider.class, method = "lockCardCouponRecord")
	int lockCardCouponRecord(Map<String, Object> param);

}