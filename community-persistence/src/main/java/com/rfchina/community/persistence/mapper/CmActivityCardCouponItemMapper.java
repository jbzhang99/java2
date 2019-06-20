package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CmActivityCardCouponItem;
import com.rfchina.community.persistence.model.CmActivityCardCouponItemExample;
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

public interface CmActivityCardCouponItemMapper extends Serializable {
    @SelectProvider(type=CmActivityCardCouponItemSqlProvider.class, method="countByExample")
    long countByExample(CmActivityCardCouponItemExample example);

    @DeleteProvider(type=CmActivityCardCouponItemSqlProvider.class, method="deleteByExample")
    int deleteByExample(CmActivityCardCouponItemExample example);

    @Delete({
        "delete from cm_activity_card_coupon_item",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into cm_activity_card_coupon_item (coupon_name, coupon_type, ",
        "coupon_num, stock_num, ",
        "valid_from_date, valid_to_date, ",
        "allow_from_date, allow_to_date, ",
        "item_type, use_rule, ",
        "remark, coupon_amount, ",
        "pay_amount, open_status, ",
        "deliver_num, user_limit, ",
        "status, create_time, ",
        "update_time)",
        "values (#{couponName,jdbcType=VARCHAR}, #{couponType,jdbcType=INTEGER}, ",
        "#{couponNum,jdbcType=INTEGER}, #{stockNum,jdbcType=INTEGER}, ",
        "#{validFromDate,jdbcType=TIMESTAMP}, #{validToDate,jdbcType=TIMESTAMP}, ",
        "#{allowFromDate,jdbcType=TIMESTAMP}, #{allowToDate,jdbcType=TIMESTAMP}, ",
        "#{itemType,jdbcType=INTEGER}, #{useRule,jdbcType=VARCHAR}, ",
        "#{remark,jdbcType=VARCHAR}, #{couponAmount,jdbcType=DECIMAL}, ",
        "#{payAmount,jdbcType=DECIMAL}, #{openStatus,jdbcType=INTEGER}, ",
        "#{deliverNum,jdbcType=INTEGER}, #{userLimit,jdbcType=INTEGER}, ",
        "#{status,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(CmActivityCardCouponItem record);

    @InsertProvider(type=CmActivityCardCouponItemSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(CmActivityCardCouponItem record);

    @SelectProvider(type=CmActivityCardCouponItemSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="coupon_name", property="couponName", jdbcType=JdbcType.VARCHAR),
        @Result(column="coupon_type", property="couponType", jdbcType=JdbcType.INTEGER),
        @Result(column="coupon_num", property="couponNum", jdbcType=JdbcType.INTEGER),
        @Result(column="stock_num", property="stockNum", jdbcType=JdbcType.INTEGER),
        @Result(column="valid_from_date", property="validFromDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="valid_to_date", property="validToDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="allow_from_date", property="allowFromDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="allow_to_date", property="allowToDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="item_type", property="itemType", jdbcType=JdbcType.INTEGER),
        @Result(column="use_rule", property="useRule", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="coupon_amount", property="couponAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="pay_amount", property="payAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="open_status", property="openStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="deliver_num", property="deliverNum", jdbcType=JdbcType.INTEGER),
        @Result(column="user_limit", property="userLimit", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<CmActivityCardCouponItem> selectByExample(CmActivityCardCouponItemExample example);

    @Select({
        "select",
        "id, coupon_name, coupon_type, coupon_num, stock_num, valid_from_date, valid_to_date, ",
        "allow_from_date, allow_to_date, item_type, use_rule, remark, coupon_amount, ",
        "pay_amount, open_status, deliver_num, user_limit, status, create_time, update_time",
        "from cm_activity_card_coupon_item",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="coupon_name", property="couponName", jdbcType=JdbcType.VARCHAR),
        @Result(column="coupon_type", property="couponType", jdbcType=JdbcType.INTEGER),
        @Result(column="coupon_num", property="couponNum", jdbcType=JdbcType.INTEGER),
        @Result(column="stock_num", property="stockNum", jdbcType=JdbcType.INTEGER),
        @Result(column="valid_from_date", property="validFromDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="valid_to_date", property="validToDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="allow_from_date", property="allowFromDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="allow_to_date", property="allowToDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="item_type", property="itemType", jdbcType=JdbcType.INTEGER),
        @Result(column="use_rule", property="useRule", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="coupon_amount", property="couponAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="pay_amount", property="payAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="open_status", property="openStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="deliver_num", property="deliverNum", jdbcType=JdbcType.INTEGER),
        @Result(column="user_limit", property="userLimit", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    CmActivityCardCouponItem selectByPrimaryKey(Long id);

    @UpdateProvider(type=CmActivityCardCouponItemSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CmActivityCardCouponItem record, @Param("example") CmActivityCardCouponItemExample example);

    @UpdateProvider(type=CmActivityCardCouponItemSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CmActivityCardCouponItem record, @Param("example") CmActivityCardCouponItemExample example);

    @UpdateProvider(type=CmActivityCardCouponItemSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CmActivityCardCouponItem record);

    @Update({
        "update cm_activity_card_coupon_item",
        "set coupon_name = #{couponName,jdbcType=VARCHAR},",
          "coupon_type = #{couponType,jdbcType=INTEGER},",
          "coupon_num = #{couponNum,jdbcType=INTEGER},",
          "stock_num = #{stockNum,jdbcType=INTEGER},",
          "valid_from_date = #{validFromDate,jdbcType=TIMESTAMP},",
          "valid_to_date = #{validToDate,jdbcType=TIMESTAMP},",
          "allow_from_date = #{allowFromDate,jdbcType=TIMESTAMP},",
          "allow_to_date = #{allowToDate,jdbcType=TIMESTAMP},",
          "item_type = #{itemType,jdbcType=INTEGER},",
          "use_rule = #{useRule,jdbcType=VARCHAR},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "coupon_amount = #{couponAmount,jdbcType=DECIMAL},",
          "pay_amount = #{payAmount,jdbcType=DECIMAL},",
          "open_status = #{openStatus,jdbcType=INTEGER},",
          "deliver_num = #{deliverNum,jdbcType=INTEGER},",
          "user_limit = #{userLimit,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(CmActivityCardCouponItem record);
}