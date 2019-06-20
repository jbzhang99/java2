package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenFeeOrderPay;
import com.rfchina.community.persistence.model.OpenFeeOrderPayExample;
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

public interface OpenFeeOrderPayMapper extends Serializable {
    @SelectProvider(type=OpenFeeOrderPaySqlProvider.class, method="countByExample")
    long countByExample(OpenFeeOrderPayExample example);

    @DeleteProvider(type=OpenFeeOrderPaySqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenFeeOrderPayExample example);

    @Delete({
        "delete from open_fee_order_pay",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into open_fee_order_pay (service_id, out_trade_no, ",
        "bill_id, create_time, ",
        "pay_status, pay_type, pay_amount, ",
        "pay_time, open_id, ",
        "img_link, pay_channel, ",
        "reject_reason, platform_charge, ",
        "service_charge, community_id, ",
        "audit_uid, audit_phone, ",
        "audit_name, audit_time)",
        "values (#{serviceId,jdbcType=INTEGER}, #{outTradeNo,jdbcType=VARCHAR}, ",
        "#{billId,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{payStatus,jdbcType=CHAR}, #{payType,jdbcType=CHAR}, #{payAmount,jdbcType=DECIMAL}, ",
        "#{payTime,jdbcType=TIMESTAMP}, #{openId,jdbcType=BIGINT}, ",
        "#{imgLink,jdbcType=VARCHAR}, #{payChannel,jdbcType=VARCHAR}, ",
        "#{rejectReason,jdbcType=VARCHAR}, #{platformCharge,jdbcType=DECIMAL}, ",
        "#{serviceCharge,jdbcType=DECIMAL}, #{communityId,jdbcType=INTEGER}, ",
        "#{auditUid,jdbcType=BIGINT}, #{auditPhone,jdbcType=VARCHAR}, ",
        "#{auditName,jdbcType=VARCHAR}, #{auditTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(OpenFeeOrderPay record);

    @InsertProvider(type=OpenFeeOrderPaySqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(OpenFeeOrderPay record);

    @SelectProvider(type=OpenFeeOrderPaySqlProvider.class, method="selectByExample")
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
        @Result(column="platform_charge", property="platformCharge", jdbcType=JdbcType.DECIMAL),
        @Result(column="service_charge", property="serviceCharge", jdbcType=JdbcType.DECIMAL),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="audit_uid", property="auditUid", jdbcType=JdbcType.BIGINT),
        @Result(column="audit_phone", property="auditPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="audit_name", property="auditName", jdbcType=JdbcType.VARCHAR),
        @Result(column="audit_time", property="auditTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<OpenFeeOrderPay> selectByExample(OpenFeeOrderPayExample example);

    @Select({
        "select",
        "id, service_id, out_trade_no, bill_id, create_time, pay_status, pay_type, pay_amount, ",
        "pay_time, open_id, img_link, pay_channel, reject_reason, platform_charge, service_charge, ",
        "community_id, audit_uid, audit_phone, audit_name, audit_time",
        "from open_fee_order_pay",
        "where id = #{id,jdbcType=BIGINT}"
    })
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
        @Result(column="platform_charge", property="platformCharge", jdbcType=JdbcType.DECIMAL),
        @Result(column="service_charge", property="serviceCharge", jdbcType=JdbcType.DECIMAL),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="audit_uid", property="auditUid", jdbcType=JdbcType.BIGINT),
        @Result(column="audit_phone", property="auditPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="audit_name", property="auditName", jdbcType=JdbcType.VARCHAR),
        @Result(column="audit_time", property="auditTime", jdbcType=JdbcType.TIMESTAMP)
    })
    OpenFeeOrderPay selectByPrimaryKey(Long id);

    @UpdateProvider(type=OpenFeeOrderPaySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenFeeOrderPay record, @Param("example") OpenFeeOrderPayExample example);

    @UpdateProvider(type=OpenFeeOrderPaySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenFeeOrderPay record, @Param("example") OpenFeeOrderPayExample example);

    @UpdateProvider(type=OpenFeeOrderPaySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpenFeeOrderPay record);

    @Update({
        "update open_fee_order_pay",
        "set service_id = #{serviceId,jdbcType=INTEGER},",
          "out_trade_no = #{outTradeNo,jdbcType=VARCHAR},",
          "bill_id = #{billId,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "pay_status = #{payStatus,jdbcType=CHAR},",
          "pay_type = #{payType,jdbcType=CHAR},",
          "pay_amount = #{payAmount,jdbcType=DECIMAL},",
          "pay_time = #{payTime,jdbcType=TIMESTAMP},",
          "open_id = #{openId,jdbcType=BIGINT},",
          "img_link = #{imgLink,jdbcType=VARCHAR},",
          "pay_channel = #{payChannel,jdbcType=VARCHAR},",
          "reject_reason = #{rejectReason,jdbcType=VARCHAR},",
          "platform_charge = #{platformCharge,jdbcType=DECIMAL},",
          "service_charge = #{serviceCharge,jdbcType=DECIMAL},",
          "community_id = #{communityId,jdbcType=INTEGER},",
          "audit_uid = #{auditUid,jdbcType=BIGINT},",
          "audit_phone = #{auditPhone,jdbcType=VARCHAR},",
          "audit_name = #{auditName,jdbcType=VARCHAR},",
          "audit_time = #{auditTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(OpenFeeOrderPay record);
}