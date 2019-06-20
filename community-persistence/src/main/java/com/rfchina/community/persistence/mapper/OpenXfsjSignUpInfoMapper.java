package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenXfsjSignUpInfo;
import com.rfchina.community.persistence.model.OpenXfsjSignUpInfoExample;
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

public interface OpenXfsjSignUpInfoMapper extends Serializable {
    @SelectProvider(type=OpenXfsjSignUpInfoSqlProvider.class, method="countByExample")
    long countByExample(OpenXfsjSignUpInfoExample example);

    @DeleteProvider(type=OpenXfsjSignUpInfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenXfsjSignUpInfoExample example);

    @Delete({
        "delete from open_xfsj_sign_up_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into open_xfsj_sign_up_info (uid, xfsj_id, ",
        "service_id, bill_id, ",
        "bill_status, bill_create_time, ",
        "service_fee, refuse_content, ",
        "status, create_time, ",
        "order_id, platform_charge_rate, ",
        "platform_charge, receipt_amount)",
        "values (#{uid,jdbcType=BIGINT}, #{xfsjId,jdbcType=BIGINT}, ",
        "#{serviceId,jdbcType=INTEGER}, #{billId,jdbcType=VARCHAR}, ",
        "#{billStatus,jdbcType=INTEGER}, #{billCreateTime,jdbcType=TIMESTAMP}, ",
        "#{serviceFee,jdbcType=DECIMAL}, #{refuseContent,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{orderId,jdbcType=BIGINT}, #{platformChargeRate,jdbcType=DECIMAL}, ",
        "#{platformCharge,jdbcType=DECIMAL}, #{receiptAmount,jdbcType=DECIMAL})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(OpenXfsjSignUpInfo record);

    @InsertProvider(type=OpenXfsjSignUpInfoSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(OpenXfsjSignUpInfo record);

    @SelectProvider(type=OpenXfsjSignUpInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="xfsj_id", property="xfsjId", jdbcType=JdbcType.BIGINT),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
        @Result(column="bill_id", property="billId", jdbcType=JdbcType.VARCHAR),
        @Result(column="bill_status", property="billStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="bill_create_time", property="billCreateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="service_fee", property="serviceFee", jdbcType=JdbcType.DECIMAL),
        @Result(column="refuse_content", property="refuseContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.BIGINT),
        @Result(column="platform_charge_rate", property="platformChargeRate", jdbcType=JdbcType.DECIMAL),
        @Result(column="platform_charge", property="platformCharge", jdbcType=JdbcType.DECIMAL),
        @Result(column="receipt_amount", property="receiptAmount", jdbcType=JdbcType.DECIMAL)
    })
    List<OpenXfsjSignUpInfo> selectByExample(OpenXfsjSignUpInfoExample example);

    @Select({
        "select",
        "id, uid, xfsj_id, service_id, bill_id, bill_status, bill_create_time, service_fee, ",
        "refuse_content, status, create_time, order_id, platform_charge_rate, platform_charge, ",
        "receipt_amount",
        "from open_xfsj_sign_up_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="xfsj_id", property="xfsjId", jdbcType=JdbcType.BIGINT),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
        @Result(column="bill_id", property="billId", jdbcType=JdbcType.VARCHAR),
        @Result(column="bill_status", property="billStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="bill_create_time", property="billCreateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="service_fee", property="serviceFee", jdbcType=JdbcType.DECIMAL),
        @Result(column="refuse_content", property="refuseContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.BIGINT),
        @Result(column="platform_charge_rate", property="platformChargeRate", jdbcType=JdbcType.DECIMAL),
        @Result(column="platform_charge", property="platformCharge", jdbcType=JdbcType.DECIMAL),
        @Result(column="receipt_amount", property="receiptAmount", jdbcType=JdbcType.DECIMAL)
    })
    OpenXfsjSignUpInfo selectByPrimaryKey(Long id);

    @UpdateProvider(type=OpenXfsjSignUpInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenXfsjSignUpInfo record, @Param("example") OpenXfsjSignUpInfoExample example);

    @UpdateProvider(type=OpenXfsjSignUpInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenXfsjSignUpInfo record, @Param("example") OpenXfsjSignUpInfoExample example);

    @UpdateProvider(type=OpenXfsjSignUpInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpenXfsjSignUpInfo record);

    @Update({
        "update open_xfsj_sign_up_info",
        "set uid = #{uid,jdbcType=BIGINT},",
          "xfsj_id = #{xfsjId,jdbcType=BIGINT},",
          "service_id = #{serviceId,jdbcType=INTEGER},",
          "bill_id = #{billId,jdbcType=VARCHAR},",
          "bill_status = #{billStatus,jdbcType=INTEGER},",
          "bill_create_time = #{billCreateTime,jdbcType=TIMESTAMP},",
          "service_fee = #{serviceFee,jdbcType=DECIMAL},",
          "refuse_content = #{refuseContent,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "order_id = #{orderId,jdbcType=BIGINT},",
          "platform_charge_rate = #{platformChargeRate,jdbcType=DECIMAL},",
          "platform_charge = #{platformCharge,jdbcType=DECIMAL},",
          "receipt_amount = #{receiptAmount,jdbcType=DECIMAL}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(OpenXfsjSignUpInfo record);
}