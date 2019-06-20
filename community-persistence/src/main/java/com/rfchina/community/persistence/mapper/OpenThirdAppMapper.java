package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenThirdApp;
import com.rfchina.community.persistence.model.OpenThirdAppExample;
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
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface OpenThirdAppMapper extends Serializable {
    @SelectProvider(type=OpenThirdAppSqlProvider.class, method="countByExample")
    long countByExample(OpenThirdAppExample example);

    @DeleteProvider(type=OpenThirdAppSqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenThirdAppExample example);

    @Delete({
        "delete from open_third_app",
        "where app_id = #{appId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long appId);

    @Insert({
        "insert into open_third_app (app_id, name, ",
        "url, description, ",
        "icon, status, audit_comment, ",
        "create_time, update_time, ",
        "audit_time, category_id, ",
        "is_need_hardware, target_month_turnover, ",
        "paid_caution_money, caution_money_status, ",
        "ground_mode, merchant_id, ",
        "account_id, submit_audit_time)",
        "values (#{appId,jdbcType=BIGINT}, #{name,jdbcType=VARCHAR}, ",
        "#{url,jdbcType=VARCHAR}, #{description,jdbcType=VARCHAR}, ",
        "#{icon,jdbcType=VARCHAR}, #{status,jdbcType=INTEGER}, #{auditComment,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{auditTime,jdbcType=TIMESTAMP}, #{categoryId,jdbcType=BIGINT}, ",
        "#{isNeedHardware,jdbcType=INTEGER}, #{targetMonthTurnover,jdbcType=DECIMAL}, ",
        "#{paidCautionMoney,jdbcType=DECIMAL}, #{cautionMoneyStatus,jdbcType=INTEGER}, ",
        "#{groundMode,jdbcType=INTEGER}, #{merchantId,jdbcType=BIGINT}, ",
        "#{accountId,jdbcType=VARCHAR}, #{submitAuditTime,jdbcType=TIMESTAMP})"
    })
    int insert(OpenThirdApp record);

    @InsertProvider(type=OpenThirdAppSqlProvider.class, method="insertSelective")
    int insertSelective(OpenThirdApp record);

    @SelectProvider(type=OpenThirdAppSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="app_id", property="appId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="icon", property="icon", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="audit_comment", property="auditComment", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="audit_time", property="auditTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="category_id", property="categoryId", jdbcType=JdbcType.BIGINT),
        @Result(column="is_need_hardware", property="isNeedHardware", jdbcType=JdbcType.INTEGER),
        @Result(column="target_month_turnover", property="targetMonthTurnover", jdbcType=JdbcType.DECIMAL),
        @Result(column="paid_caution_money", property="paidCautionMoney", jdbcType=JdbcType.DECIMAL),
        @Result(column="caution_money_status", property="cautionMoneyStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="ground_mode", property="groundMode", jdbcType=JdbcType.INTEGER),
        @Result(column="merchant_id", property="merchantId", jdbcType=JdbcType.BIGINT),
        @Result(column="account_id", property="accountId", jdbcType=JdbcType.VARCHAR),
        @Result(column="submit_audit_time", property="submitAuditTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<OpenThirdApp> selectByExample(OpenThirdAppExample example);

    @Select({
        "select",
        "app_id, name, url, description, icon, status, audit_comment, create_time, update_time, ",
        "audit_time, category_id, is_need_hardware, target_month_turnover, paid_caution_money, ",
        "caution_money_status, ground_mode, merchant_id, account_id, submit_audit_time",
        "from open_third_app",
        "where app_id = #{appId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="app_id", property="appId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="icon", property="icon", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="audit_comment", property="auditComment", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="audit_time", property="auditTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="category_id", property="categoryId", jdbcType=JdbcType.BIGINT),
        @Result(column="is_need_hardware", property="isNeedHardware", jdbcType=JdbcType.INTEGER),
        @Result(column="target_month_turnover", property="targetMonthTurnover", jdbcType=JdbcType.DECIMAL),
        @Result(column="paid_caution_money", property="paidCautionMoney", jdbcType=JdbcType.DECIMAL),
        @Result(column="caution_money_status", property="cautionMoneyStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="ground_mode", property="groundMode", jdbcType=JdbcType.INTEGER),
        @Result(column="merchant_id", property="merchantId", jdbcType=JdbcType.BIGINT),
        @Result(column="account_id", property="accountId", jdbcType=JdbcType.VARCHAR),
        @Result(column="submit_audit_time", property="submitAuditTime", jdbcType=JdbcType.TIMESTAMP)
    })
    OpenThirdApp selectByPrimaryKey(Long appId);

    @UpdateProvider(type=OpenThirdAppSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenThirdApp record, @Param("example") OpenThirdAppExample example);

    @UpdateProvider(type=OpenThirdAppSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenThirdApp record, @Param("example") OpenThirdAppExample example);

    @UpdateProvider(type=OpenThirdAppSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpenThirdApp record);

    @Update({
        "update open_third_app",
        "set name = #{name,jdbcType=VARCHAR},",
          "url = #{url,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=VARCHAR},",
          "icon = #{icon,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER},",
          "audit_comment = #{auditComment,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "audit_time = #{auditTime,jdbcType=TIMESTAMP},",
          "category_id = #{categoryId,jdbcType=BIGINT},",
          "is_need_hardware = #{isNeedHardware,jdbcType=INTEGER},",
          "target_month_turnover = #{targetMonthTurnover,jdbcType=DECIMAL},",
          "paid_caution_money = #{paidCautionMoney,jdbcType=DECIMAL},",
          "caution_money_status = #{cautionMoneyStatus,jdbcType=INTEGER},",
          "ground_mode = #{groundMode,jdbcType=INTEGER},",
          "merchant_id = #{merchantId,jdbcType=BIGINT},",
          "account_id = #{accountId,jdbcType=VARCHAR},",
          "submit_audit_time = #{submitAuditTime,jdbcType=TIMESTAMP}",
        "where app_id = #{appId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(OpenThirdApp record);
}