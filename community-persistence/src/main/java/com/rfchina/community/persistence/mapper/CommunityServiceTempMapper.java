package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CommunityServiceTemp;
import com.rfchina.community.persistence.model.CommunityServiceTempExample;
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

public interface CommunityServiceTempMapper extends Serializable {
    @SelectProvider(type=CommunityServiceTempSqlProvider.class, method="countByExample")
    long countByExample(CommunityServiceTempExample example);

    @DeleteProvider(type=CommunityServiceTempSqlProvider.class, method="deleteByExample")
    int deleteByExample(CommunityServiceTempExample example);

    @Delete({
        "delete from community_service_temp",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into community_service_temp (title, png, ",
        "disable_png, reorder, ",
        "clause, type, is_account, ",
        "link, provide_type, ",
        "status, app_id, description, ",
        "audit_comment, create_time, ",
        "update_time, audit_time, ",
        "category_id, is_need_hardware, ",
        "target_month_turnover, paid_caution_money, ",
        "caution_money_status, ground_mode, ",
        "merchant_id, account_id, ",
        "audit_status, clause_id, ",
        "app_secret, receivable_caution_money, ",
        "recommend_level, caution_money_type, ",
        "caution_money_pic, remark, ",
        "caution_bill_id, user_range, ",
        "ground_audit_status, shot, ",
        "account_receivable_project, notify_url, ",
        "balance_receive_email, under_reason, ",
        "ground_time, max_ios_version, ",
        "min_ios_version, max_andoird_version, ",
        "min_andoird_version, service_need)",
        "values (#{title,jdbcType=VARCHAR}, #{png,jdbcType=VARCHAR}, ",
        "#{disablePng,jdbcType=VARCHAR}, #{reorder,jdbcType=INTEGER}, ",
        "#{clause,jdbcType=VARCHAR}, #{type,jdbcType=INTEGER}, #{isAccount,jdbcType=INTEGER}, ",
        "#{link,jdbcType=VARCHAR}, #{provideType,jdbcType=INTEGER}, ",
        "#{status,jdbcType=INTEGER}, #{appId,jdbcType=BIGINT}, #{description,jdbcType=VARCHAR}, ",
        "#{auditComment,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{auditTime,jdbcType=TIMESTAMP}, ",
        "#{categoryId,jdbcType=INTEGER}, #{isNeedHardware,jdbcType=INTEGER}, ",
        "#{targetMonthTurnover,jdbcType=DECIMAL}, #{paidCautionMoney,jdbcType=DECIMAL}, ",
        "#{cautionMoneyStatus,jdbcType=INTEGER}, #{groundMode,jdbcType=INTEGER}, ",
        "#{merchantId,jdbcType=BIGINT}, #{accountId,jdbcType=VARCHAR}, ",
        "#{auditStatus,jdbcType=INTEGER}, #{clauseId,jdbcType=INTEGER}, ",
        "#{appSecret,jdbcType=VARCHAR}, #{receivableCautionMoney,jdbcType=DECIMAL}, ",
        "#{recommendLevel,jdbcType=DOUBLE}, #{cautionMoneyType,jdbcType=INTEGER}, ",
        "#{cautionMoneyPic,jdbcType=VARCHAR}, #{remark,jdbcType=VARCHAR}, ",
        "#{cautionBillId,jdbcType=VARCHAR}, #{userRange,jdbcType=INTEGER}, ",
        "#{groundAuditStatus,jdbcType=INTEGER}, #{shot,jdbcType=VARCHAR}, ",
        "#{accountReceivableProject,jdbcType=VARCHAR}, #{notifyUrl,jdbcType=VARCHAR}, ",
        "#{balanceReceiveEmail,jdbcType=VARCHAR}, #{underReason,jdbcType=VARCHAR}, ",
        "#{groundTime,jdbcType=TIMESTAMP}, #{maxIosVersion,jdbcType=VARCHAR}, ",
        "#{minIosVersion,jdbcType=VARCHAR}, #{maxAndoirdVersion,jdbcType=VARCHAR}, ",
        "#{minAndoirdVersion,jdbcType=VARCHAR}, #{serviceNeed,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(CommunityServiceTemp record);

    @InsertProvider(type=CommunityServiceTempSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(CommunityServiceTemp record);

    @SelectProvider(type=CommunityServiceTempSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="png", property="png", jdbcType=JdbcType.VARCHAR),
        @Result(column="disable_png", property="disablePng", jdbcType=JdbcType.VARCHAR),
        @Result(column="reorder", property="reorder", jdbcType=JdbcType.INTEGER),
        @Result(column="clause", property="clause", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="is_account", property="isAccount", jdbcType=JdbcType.INTEGER),
        @Result(column="link", property="link", jdbcType=JdbcType.VARCHAR),
        @Result(column="provide_type", property="provideType", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="app_id", property="appId", jdbcType=JdbcType.BIGINT),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="audit_comment", property="auditComment", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="audit_time", property="auditTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="category_id", property="categoryId", jdbcType=JdbcType.INTEGER),
        @Result(column="is_need_hardware", property="isNeedHardware", jdbcType=JdbcType.INTEGER),
        @Result(column="target_month_turnover", property="targetMonthTurnover", jdbcType=JdbcType.DECIMAL),
        @Result(column="paid_caution_money", property="paidCautionMoney", jdbcType=JdbcType.DECIMAL),
        @Result(column="caution_money_status", property="cautionMoneyStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="ground_mode", property="groundMode", jdbcType=JdbcType.INTEGER),
        @Result(column="merchant_id", property="merchantId", jdbcType=JdbcType.BIGINT),
        @Result(column="account_id", property="accountId", jdbcType=JdbcType.VARCHAR),
        @Result(column="audit_status", property="auditStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="clause_id", property="clauseId", jdbcType=JdbcType.INTEGER),
        @Result(column="app_secret", property="appSecret", jdbcType=JdbcType.VARCHAR),
        @Result(column="receivable_caution_money", property="receivableCautionMoney", jdbcType=JdbcType.DECIMAL),
        @Result(column="recommend_level", property="recommendLevel", jdbcType=JdbcType.DOUBLE),
        @Result(column="caution_money_type", property="cautionMoneyType", jdbcType=JdbcType.INTEGER),
        @Result(column="caution_money_pic", property="cautionMoneyPic", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="caution_bill_id", property="cautionBillId", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_range", property="userRange", jdbcType=JdbcType.INTEGER),
        @Result(column="ground_audit_status", property="groundAuditStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="shot", property="shot", jdbcType=JdbcType.VARCHAR),
        @Result(column="account_receivable_project", property="accountReceivableProject", jdbcType=JdbcType.VARCHAR),
        @Result(column="notify_url", property="notifyUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="balance_receive_email", property="balanceReceiveEmail", jdbcType=JdbcType.VARCHAR),
        @Result(column="under_reason", property="underReason", jdbcType=JdbcType.VARCHAR),
        @Result(column="ground_time", property="groundTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="max_ios_version", property="maxIosVersion", jdbcType=JdbcType.VARCHAR),
        @Result(column="min_ios_version", property="minIosVersion", jdbcType=JdbcType.VARCHAR),
        @Result(column="max_andoird_version", property="maxAndoirdVersion", jdbcType=JdbcType.VARCHAR),
        @Result(column="min_andoird_version", property="minAndoirdVersion", jdbcType=JdbcType.VARCHAR),
        @Result(column="service_need", property="serviceNeed", jdbcType=JdbcType.VARCHAR)
    })
    List<CommunityServiceTemp> selectByExample(CommunityServiceTempExample example);

    @Select({
        "select",
        "id, title, png, disable_png, reorder, clause, type, is_account, link, provide_type, ",
        "status, app_id, description, audit_comment, create_time, update_time, audit_time, ",
        "category_id, is_need_hardware, target_month_turnover, paid_caution_money, caution_money_status, ",
        "ground_mode, merchant_id, account_id, audit_status, clause_id, app_secret, receivable_caution_money, ",
        "recommend_level, caution_money_type, caution_money_pic, remark, caution_bill_id, ",
        "user_range, ground_audit_status, shot, account_receivable_project, notify_url, ",
        "balance_receive_email, under_reason, ground_time, max_ios_version, min_ios_version, ",
        "max_andoird_version, min_andoird_version, service_need",
        "from community_service_temp",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="png", property="png", jdbcType=JdbcType.VARCHAR),
        @Result(column="disable_png", property="disablePng", jdbcType=JdbcType.VARCHAR),
        @Result(column="reorder", property="reorder", jdbcType=JdbcType.INTEGER),
        @Result(column="clause", property="clause", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="is_account", property="isAccount", jdbcType=JdbcType.INTEGER),
        @Result(column="link", property="link", jdbcType=JdbcType.VARCHAR),
        @Result(column="provide_type", property="provideType", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="app_id", property="appId", jdbcType=JdbcType.BIGINT),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="audit_comment", property="auditComment", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="audit_time", property="auditTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="category_id", property="categoryId", jdbcType=JdbcType.INTEGER),
        @Result(column="is_need_hardware", property="isNeedHardware", jdbcType=JdbcType.INTEGER),
        @Result(column="target_month_turnover", property="targetMonthTurnover", jdbcType=JdbcType.DECIMAL),
        @Result(column="paid_caution_money", property="paidCautionMoney", jdbcType=JdbcType.DECIMAL),
        @Result(column="caution_money_status", property="cautionMoneyStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="ground_mode", property="groundMode", jdbcType=JdbcType.INTEGER),
        @Result(column="merchant_id", property="merchantId", jdbcType=JdbcType.BIGINT),
        @Result(column="account_id", property="accountId", jdbcType=JdbcType.VARCHAR),
        @Result(column="audit_status", property="auditStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="clause_id", property="clauseId", jdbcType=JdbcType.INTEGER),
        @Result(column="app_secret", property="appSecret", jdbcType=JdbcType.VARCHAR),
        @Result(column="receivable_caution_money", property="receivableCautionMoney", jdbcType=JdbcType.DECIMAL),
        @Result(column="recommend_level", property="recommendLevel", jdbcType=JdbcType.DOUBLE),
        @Result(column="caution_money_type", property="cautionMoneyType", jdbcType=JdbcType.INTEGER),
        @Result(column="caution_money_pic", property="cautionMoneyPic", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="caution_bill_id", property="cautionBillId", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_range", property="userRange", jdbcType=JdbcType.INTEGER),
        @Result(column="ground_audit_status", property="groundAuditStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="shot", property="shot", jdbcType=JdbcType.VARCHAR),
        @Result(column="account_receivable_project", property="accountReceivableProject", jdbcType=JdbcType.VARCHAR),
        @Result(column="notify_url", property="notifyUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="balance_receive_email", property="balanceReceiveEmail", jdbcType=JdbcType.VARCHAR),
        @Result(column="under_reason", property="underReason", jdbcType=JdbcType.VARCHAR),
        @Result(column="ground_time", property="groundTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="max_ios_version", property="maxIosVersion", jdbcType=JdbcType.VARCHAR),
        @Result(column="min_ios_version", property="minIosVersion", jdbcType=JdbcType.VARCHAR),
        @Result(column="max_andoird_version", property="maxAndoirdVersion", jdbcType=JdbcType.VARCHAR),
        @Result(column="min_andoird_version", property="minAndoirdVersion", jdbcType=JdbcType.VARCHAR),
        @Result(column="service_need", property="serviceNeed", jdbcType=JdbcType.VARCHAR)
    })
    CommunityServiceTemp selectByPrimaryKey(Integer id);

    @UpdateProvider(type=CommunityServiceTempSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CommunityServiceTemp record, @Param("example") CommunityServiceTempExample example);

    @UpdateProvider(type=CommunityServiceTempSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CommunityServiceTemp record, @Param("example") CommunityServiceTempExample example);

    @UpdateProvider(type=CommunityServiceTempSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CommunityServiceTemp record);

    @Update({
        "update community_service_temp",
        "set title = #{title,jdbcType=VARCHAR},",
          "png = #{png,jdbcType=VARCHAR},",
          "disable_png = #{disablePng,jdbcType=VARCHAR},",
          "reorder = #{reorder,jdbcType=INTEGER},",
          "clause = #{clause,jdbcType=VARCHAR},",
          "type = #{type,jdbcType=INTEGER},",
          "is_account = #{isAccount,jdbcType=INTEGER},",
          "link = #{link,jdbcType=VARCHAR},",
          "provide_type = #{provideType,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "app_id = #{appId,jdbcType=BIGINT},",
          "description = #{description,jdbcType=VARCHAR},",
          "audit_comment = #{auditComment,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "audit_time = #{auditTime,jdbcType=TIMESTAMP},",
          "category_id = #{categoryId,jdbcType=INTEGER},",
          "is_need_hardware = #{isNeedHardware,jdbcType=INTEGER},",
          "target_month_turnover = #{targetMonthTurnover,jdbcType=DECIMAL},",
          "paid_caution_money = #{paidCautionMoney,jdbcType=DECIMAL},",
          "caution_money_status = #{cautionMoneyStatus,jdbcType=INTEGER},",
          "ground_mode = #{groundMode,jdbcType=INTEGER},",
          "merchant_id = #{merchantId,jdbcType=BIGINT},",
          "account_id = #{accountId,jdbcType=VARCHAR},",
          "audit_status = #{auditStatus,jdbcType=INTEGER},",
          "clause_id = #{clauseId,jdbcType=INTEGER},",
          "app_secret = #{appSecret,jdbcType=VARCHAR},",
          "receivable_caution_money = #{receivableCautionMoney,jdbcType=DECIMAL},",
          "recommend_level = #{recommendLevel,jdbcType=DOUBLE},",
          "caution_money_type = #{cautionMoneyType,jdbcType=INTEGER},",
          "caution_money_pic = #{cautionMoneyPic,jdbcType=VARCHAR},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "caution_bill_id = #{cautionBillId,jdbcType=VARCHAR},",
          "user_range = #{userRange,jdbcType=INTEGER},",
          "ground_audit_status = #{groundAuditStatus,jdbcType=INTEGER},",
          "shot = #{shot,jdbcType=VARCHAR},",
          "account_receivable_project = #{accountReceivableProject,jdbcType=VARCHAR},",
          "notify_url = #{notifyUrl,jdbcType=VARCHAR},",
          "balance_receive_email = #{balanceReceiveEmail,jdbcType=VARCHAR},",
          "under_reason = #{underReason,jdbcType=VARCHAR},",
          "ground_time = #{groundTime,jdbcType=TIMESTAMP},",
          "max_ios_version = #{maxIosVersion,jdbcType=VARCHAR},",
          "min_ios_version = #{minIosVersion,jdbcType=VARCHAR},",
          "max_andoird_version = #{maxAndoirdVersion,jdbcType=VARCHAR},",
          "min_andoird_version = #{minAndoirdVersion,jdbcType=VARCHAR},",
          "service_need = #{serviceNeed,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CommunityServiceTemp record);
}