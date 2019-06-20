package com.rfchina.community.persistence.mapper.ext;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;

import com.rfchina.community.persistence.model.BaseSettlementApply;
import com.rfchina.community.persistence.model.BaseSettlementApplyExample;

public interface ExtBaseSettlementApplyMapper {

	@SelectProvider(type = ExtBaseSettlementApplySqlProvider.class , method = "pageByExample")
	@Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="start_time", property="startTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="end_time", property="endTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="pay_account", property="payAccount", jdbcType=JdbcType.VARCHAR),
        @Result(column="merchant_id", property="merchantId", jdbcType=JdbcType.VARCHAR),
        @Result(column="settle_id", property="settleId", jdbcType=JdbcType.VARCHAR),
        @Result(column="settle_status", property="settleStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="check_time", property="checkTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="check_text", property="checkText", jdbcType=JdbcType.VARCHAR),
        @Result(column="approve_comment", property="approveComment", jdbcType=JdbcType.VARCHAR),
        @Result(column="approve_time", property="approveTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="approve_status", property="approveStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="image", property="image", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_uid", property="createUid", jdbcType=JdbcType.BIGINT)
    })
	public PageList<BaseSettlementApply> pageByExample(@Param("example") BaseSettlementApplyExample example,PageBounds pageBounds);
}
