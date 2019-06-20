package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CmActivityCardCouponRecord;
import com.rfchina.community.persistence.model.CmActivityCardCouponRecordExample;
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

public interface CmActivityCardCouponRecordMapper extends Serializable {
    @SelectProvider(type=CmActivityCardCouponRecordSqlProvider.class, method="countByExample")
    long countByExample(CmActivityCardCouponRecordExample example);

    @DeleteProvider(type=CmActivityCardCouponRecordSqlProvider.class, method="deleteByExample")
    int deleteByExample(CmActivityCardCouponRecordExample example);

    @Delete({
        "delete from cm_activity_card_coupon_record",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into cm_activity_card_coupon_record (activity_id, card_coupon_id, ",
        "coupon_id, coupon_sn, ",
        "uid, valid_from_date, ",
        "valid_to_date, coupon_type, ",
        "item_type, use_channel, ",
        "source, confirm_status, ",
        "remark, confirm_code, ",
        "confirm_time, confirm_uid, ",
        "idcard_no, status, ",
        "create_time, update_time, ",
        "operator_name, operator_phone)",
        "values (#{activityId,jdbcType=BIGINT}, #{cardCouponId,jdbcType=BIGINT}, ",
        "#{couponId,jdbcType=BIGINT}, #{couponSn,jdbcType=VARCHAR}, ",
        "#{uid,jdbcType=BIGINT}, #{validFromDate,jdbcType=TIMESTAMP}, ",
        "#{validToDate,jdbcType=TIMESTAMP}, #{couponType,jdbcType=INTEGER}, ",
        "#{itemType,jdbcType=INTEGER}, #{useChannel,jdbcType=INTEGER}, ",
        "#{source,jdbcType=INTEGER}, #{confirmStatus,jdbcType=INTEGER}, ",
        "#{remark,jdbcType=VARCHAR}, #{confirmCode,jdbcType=VARCHAR}, ",
        "#{confirmTime,jdbcType=TIMESTAMP}, #{confirmUid,jdbcType=BIGINT}, ",
        "#{idcardNo,jdbcType=VARCHAR}, #{status,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{operatorName,jdbcType=VARCHAR}, #{operatorPhone,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(CmActivityCardCouponRecord record);

    @InsertProvider(type=CmActivityCardCouponRecordSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(CmActivityCardCouponRecord record);

    @SelectProvider(type=CmActivityCardCouponRecordSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="activity_id", property="activityId", jdbcType=JdbcType.BIGINT),
        @Result(column="card_coupon_id", property="cardCouponId", jdbcType=JdbcType.BIGINT),
        @Result(column="coupon_id", property="couponId", jdbcType=JdbcType.BIGINT),
        @Result(column="coupon_sn", property="couponSn", jdbcType=JdbcType.VARCHAR),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="valid_from_date", property="validFromDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="valid_to_date", property="validToDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="coupon_type", property="couponType", jdbcType=JdbcType.INTEGER),
        @Result(column="item_type", property="itemType", jdbcType=JdbcType.INTEGER),
        @Result(column="use_channel", property="useChannel", jdbcType=JdbcType.INTEGER),
        @Result(column="source", property="source", jdbcType=JdbcType.INTEGER),
        @Result(column="confirm_status", property="confirmStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="confirm_code", property="confirmCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="confirm_time", property="confirmTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="confirm_uid", property="confirmUid", jdbcType=JdbcType.BIGINT),
        @Result(column="idcard_no", property="idcardNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="operator_name", property="operatorName", jdbcType=JdbcType.VARCHAR),
        @Result(column="operator_phone", property="operatorPhone", jdbcType=JdbcType.VARCHAR)
    })
    List<CmActivityCardCouponRecord> selectByExample(CmActivityCardCouponRecordExample example);

    @Select({
        "select",
        "id, activity_id, card_coupon_id, coupon_id, coupon_sn, uid, valid_from_date, ",
        "valid_to_date, coupon_type, item_type, use_channel, source, confirm_status, ",
        "remark, confirm_code, confirm_time, confirm_uid, idcard_no, status, create_time, ",
        "update_time, operator_name, operator_phone",
        "from cm_activity_card_coupon_record",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="activity_id", property="activityId", jdbcType=JdbcType.BIGINT),
        @Result(column="card_coupon_id", property="cardCouponId", jdbcType=JdbcType.BIGINT),
        @Result(column="coupon_id", property="couponId", jdbcType=JdbcType.BIGINT),
        @Result(column="coupon_sn", property="couponSn", jdbcType=JdbcType.VARCHAR),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="valid_from_date", property="validFromDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="valid_to_date", property="validToDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="coupon_type", property="couponType", jdbcType=JdbcType.INTEGER),
        @Result(column="item_type", property="itemType", jdbcType=JdbcType.INTEGER),
        @Result(column="use_channel", property="useChannel", jdbcType=JdbcType.INTEGER),
        @Result(column="source", property="source", jdbcType=JdbcType.INTEGER),
        @Result(column="confirm_status", property="confirmStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="confirm_code", property="confirmCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="confirm_time", property="confirmTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="confirm_uid", property="confirmUid", jdbcType=JdbcType.BIGINT),
        @Result(column="idcard_no", property="idcardNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="operator_name", property="operatorName", jdbcType=JdbcType.VARCHAR),
        @Result(column="operator_phone", property="operatorPhone", jdbcType=JdbcType.VARCHAR)
    })
    CmActivityCardCouponRecord selectByPrimaryKey(Long id);

    @UpdateProvider(type=CmActivityCardCouponRecordSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CmActivityCardCouponRecord record, @Param("example") CmActivityCardCouponRecordExample example);

    @UpdateProvider(type=CmActivityCardCouponRecordSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CmActivityCardCouponRecord record, @Param("example") CmActivityCardCouponRecordExample example);

    @UpdateProvider(type=CmActivityCardCouponRecordSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CmActivityCardCouponRecord record);

    @Update({
        "update cm_activity_card_coupon_record",
        "set activity_id = #{activityId,jdbcType=BIGINT},",
          "card_coupon_id = #{cardCouponId,jdbcType=BIGINT},",
          "coupon_id = #{couponId,jdbcType=BIGINT},",
          "coupon_sn = #{couponSn,jdbcType=VARCHAR},",
          "uid = #{uid,jdbcType=BIGINT},",
          "valid_from_date = #{validFromDate,jdbcType=TIMESTAMP},",
          "valid_to_date = #{validToDate,jdbcType=TIMESTAMP},",
          "coupon_type = #{couponType,jdbcType=INTEGER},",
          "item_type = #{itemType,jdbcType=INTEGER},",
          "use_channel = #{useChannel,jdbcType=INTEGER},",
          "source = #{source,jdbcType=INTEGER},",
          "confirm_status = #{confirmStatus,jdbcType=INTEGER},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "confirm_code = #{confirmCode,jdbcType=VARCHAR},",
          "confirm_time = #{confirmTime,jdbcType=TIMESTAMP},",
          "confirm_uid = #{confirmUid,jdbcType=BIGINT},",
          "idcard_no = #{idcardNo,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "operator_name = #{operatorName,jdbcType=VARCHAR},",
          "operator_phone = #{operatorPhone,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(CmActivityCardCouponRecord record);
}