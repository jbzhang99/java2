package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenStoreOrderPay;
import com.rfchina.community.persistence.model.OpenStoreOrderPayExample;
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

public interface OpenStoreOrderPayMapper extends Serializable {
    @SelectProvider(type=OpenStoreOrderPaySqlProvider.class, method="countByExample")
    long countByExample(OpenStoreOrderPayExample example);

    @DeleteProvider(type=OpenStoreOrderPaySqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenStoreOrderPayExample example);

    @Delete({
        "delete from open_store_order_pay",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into open_store_order_pay (service_id, open_id, ",
        "store_order_id, pay_channel, ",
        "pay_status, out_trade_no, ",
        "community_trade_no, total_amount, ",
        "trade_type, create_time, ",
        "pay_time, refund_status, ",
        "refund_time, refund_approval, ",
        "refund_email, original_price, ",
        "discount_price)",
        "values (#{serviceId,jdbcType=INTEGER}, #{openId,jdbcType=VARCHAR}, ",
        "#{storeOrderId,jdbcType=INTEGER}, #{payChannel,jdbcType=VARCHAR}, ",
        "#{payStatus,jdbcType=INTEGER}, #{outTradeNo,jdbcType=VARCHAR}, ",
        "#{communityTradeNo,jdbcType=VARCHAR}, #{totalAmount,jdbcType=DECIMAL}, ",
        "#{tradeType,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{payTime,jdbcType=TIMESTAMP}, #{refundStatus,jdbcType=INTEGER}, ",
        "#{refundTime,jdbcType=TIMESTAMP}, #{refundApproval,jdbcType=VARCHAR}, ",
        "#{refundEmail,jdbcType=INTEGER}, #{originalPrice,jdbcType=DECIMAL}, ",
        "#{discountPrice,jdbcType=DECIMAL})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(OpenStoreOrderPay record);

    @InsertProvider(type=OpenStoreOrderPaySqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(OpenStoreOrderPay record);

    @SelectProvider(type=OpenStoreOrderPaySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
        @Result(column="open_id", property="openId", jdbcType=JdbcType.VARCHAR),
        @Result(column="store_order_id", property="storeOrderId", jdbcType=JdbcType.INTEGER),
        @Result(column="pay_channel", property="payChannel", jdbcType=JdbcType.VARCHAR),
        @Result(column="pay_status", property="payStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="out_trade_no", property="outTradeNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="community_trade_no", property="communityTradeNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="total_amount", property="totalAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="trade_type", property="tradeType", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="pay_time", property="payTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="refund_status", property="refundStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="refund_time", property="refundTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="refund_approval", property="refundApproval", jdbcType=JdbcType.VARCHAR),
        @Result(column="refund_email", property="refundEmail", jdbcType=JdbcType.INTEGER),
        @Result(column="original_price", property="originalPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="discount_price", property="discountPrice", jdbcType=JdbcType.DECIMAL)
    })
    List<OpenStoreOrderPay> selectByExample(OpenStoreOrderPayExample example);

    @Select({
        "select",
        "id, service_id, open_id, store_order_id, pay_channel, pay_status, out_trade_no, ",
        "community_trade_no, total_amount, trade_type, create_time, pay_time, refund_status, ",
        "refund_time, refund_approval, refund_email, original_price, discount_price",
        "from open_store_order_pay",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
        @Result(column="open_id", property="openId", jdbcType=JdbcType.VARCHAR),
        @Result(column="store_order_id", property="storeOrderId", jdbcType=JdbcType.INTEGER),
        @Result(column="pay_channel", property="payChannel", jdbcType=JdbcType.VARCHAR),
        @Result(column="pay_status", property="payStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="out_trade_no", property="outTradeNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="community_trade_no", property="communityTradeNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="total_amount", property="totalAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="trade_type", property="tradeType", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="pay_time", property="payTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="refund_status", property="refundStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="refund_time", property="refundTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="refund_approval", property="refundApproval", jdbcType=JdbcType.VARCHAR),
        @Result(column="refund_email", property="refundEmail", jdbcType=JdbcType.INTEGER),
        @Result(column="original_price", property="originalPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="discount_price", property="discountPrice", jdbcType=JdbcType.DECIMAL)
    })
    OpenStoreOrderPay selectByPrimaryKey(Integer id);

    @UpdateProvider(type=OpenStoreOrderPaySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenStoreOrderPay record, @Param("example") OpenStoreOrderPayExample example);

    @UpdateProvider(type=OpenStoreOrderPaySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenStoreOrderPay record, @Param("example") OpenStoreOrderPayExample example);

    @UpdateProvider(type=OpenStoreOrderPaySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpenStoreOrderPay record);

    @Update({
        "update open_store_order_pay",
        "set service_id = #{serviceId,jdbcType=INTEGER},",
          "open_id = #{openId,jdbcType=VARCHAR},",
          "store_order_id = #{storeOrderId,jdbcType=INTEGER},",
          "pay_channel = #{payChannel,jdbcType=VARCHAR},",
          "pay_status = #{payStatus,jdbcType=INTEGER},",
          "out_trade_no = #{outTradeNo,jdbcType=VARCHAR},",
          "community_trade_no = #{communityTradeNo,jdbcType=VARCHAR},",
          "total_amount = #{totalAmount,jdbcType=DECIMAL},",
          "trade_type = #{tradeType,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "pay_time = #{payTime,jdbcType=TIMESTAMP},",
          "refund_status = #{refundStatus,jdbcType=INTEGER},",
          "refund_time = #{refundTime,jdbcType=TIMESTAMP},",
          "refund_approval = #{refundApproval,jdbcType=VARCHAR},",
          "refund_email = #{refundEmail,jdbcType=INTEGER},",
          "original_price = #{originalPrice,jdbcType=DECIMAL},",
          "discount_price = #{discountPrice,jdbcType=DECIMAL}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(OpenStoreOrderPay record);
}