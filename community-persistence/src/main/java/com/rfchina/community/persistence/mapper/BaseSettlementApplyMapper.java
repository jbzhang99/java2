package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.BaseSettlementApply;
import com.rfchina.community.persistence.model.BaseSettlementApplyExample;
import java.io.Serializable;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface BaseSettlementApplyMapper extends Serializable {
    @SelectProvider(type=BaseSettlementApplySqlProvider.class, method="countByExample")
    long countByExample(BaseSettlementApplyExample example);

    @DeleteProvider(type=BaseSettlementApplySqlProvider.class, method="deleteByExample")
    int deleteByExample(BaseSettlementApplyExample example);

    @Delete({
        "delete from base_settlement_apply",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into base_settlement_apply (community_id, create_time, ",
        "start_time, end_time, ",
        "status, pay_account, ",
        "merchant_id, settle_id, ",
        "settle_status, check_time, ",
        "check_text, approve_comment, ",
        "approve_time, approve_status, ",
        "image, create_uid)",
        "values (#{communityId,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{startTime,jdbcType=TIMESTAMP}, #{endTime,jdbcType=TIMESTAMP}, ",
        "#{status,jdbcType=INTEGER}, #{payAccount,jdbcType=VARCHAR}, ",
        "#{merchantId,jdbcType=VARCHAR}, #{settleId,jdbcType=VARCHAR}, ",
        "#{settleStatus,jdbcType=INTEGER}, #{checkTime,jdbcType=TIMESTAMP}, ",
        "#{checkText,jdbcType=VARCHAR}, #{approveComment,jdbcType=VARCHAR}, ",
        "#{approveTime,jdbcType=TIMESTAMP}, #{approveStatus,jdbcType=INTEGER}, ",
        "#{image,jdbcType=VARCHAR}, #{createUid,jdbcType=BIGINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(BaseSettlementApply record);

    @InsertProvider(type=BaseSettlementApplySqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(BaseSettlementApply record);

    @SelectProvider(type=BaseSettlementApplySqlProvider.class, method="selectByExample")
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
    List<BaseSettlementApply> selectByExample(BaseSettlementApplyExample example);

    @Select({
        "select",
        "id, community_id, create_time, start_time, end_time, status, pay_account, merchant_id, ",
        "settle_id, settle_status, check_time, check_text, approve_comment, approve_time, ",
        "approve_status, image, create_uid",
        "from base_settlement_apply",
        "where id = #{id,jdbcType=BIGINT}"
    })
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
    BaseSettlementApply selectByPrimaryKey(Long id);

    @UpdateProvider(type=BaseSettlementApplySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") BaseSettlementApply record, @Param("example") BaseSettlementApplyExample example);

    @UpdateProvider(type=BaseSettlementApplySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") BaseSettlementApply record, @Param("example") BaseSettlementApplyExample example);

    @UpdateProvider(type=BaseSettlementApplySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(BaseSettlementApply record);

    @Update({
        "update base_settlement_apply",
        "set community_id = #{communityId,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "start_time = #{startTime,jdbcType=TIMESTAMP},",
          "end_time = #{endTime,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=INTEGER},",
          "pay_account = #{payAccount,jdbcType=VARCHAR},",
          "merchant_id = #{merchantId,jdbcType=VARCHAR},",
          "settle_id = #{settleId,jdbcType=VARCHAR},",
          "settle_status = #{settleStatus,jdbcType=INTEGER},",
          "check_time = #{checkTime,jdbcType=TIMESTAMP},",
          "check_text = #{checkText,jdbcType=VARCHAR},",
          "approve_comment = #{approveComment,jdbcType=VARCHAR},",
          "approve_time = #{approveTime,jdbcType=TIMESTAMP},",
          "approve_status = #{approveStatus,jdbcType=INTEGER},",
          "image = #{image,jdbcType=VARCHAR},",
          "create_uid = #{createUid,jdbcType=BIGINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(BaseSettlementApply record);
}