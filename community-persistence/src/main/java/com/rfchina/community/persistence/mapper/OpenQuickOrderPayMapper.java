package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenQuickOrderPay;
import com.rfchina.community.persistence.model.OpenQuickOrderPayExample;
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

public interface OpenQuickOrderPayMapper extends Serializable {
    @SelectProvider(type=OpenQuickOrderPaySqlProvider.class, method="countByExample")
    long countByExample(OpenQuickOrderPayExample example);

    @DeleteProvider(type=OpenQuickOrderPaySqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenQuickOrderPayExample example);

    @Delete({
        "delete from open_quick_order_pay",
        "where out_trade_no = #{outTradeNo,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String outTradeNo);

    @Insert({
        "insert into open_quick_order_pay (out_trade_no, quick_id, ",
        "community_trade_no, bill_id, ",
        "create_time, status, ",
        "pay_channel, trade_type, ",
        "success_time)",
        "values (#{outTradeNo,jdbcType=VARCHAR}, #{quickId,jdbcType=BIGINT}, ",
        "#{communityTradeNo,jdbcType=VARCHAR}, #{billId,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{status,jdbcType=INTEGER}, ",
        "#{payChannel,jdbcType=VARCHAR}, #{tradeType,jdbcType=VARCHAR}, ",
        "#{successTime,jdbcType=TIMESTAMP})"
    })
    int insert(OpenQuickOrderPay record);

    @InsertProvider(type=OpenQuickOrderPaySqlProvider.class, method="insertSelective")
    int insertSelective(OpenQuickOrderPay record);

    @SelectProvider(type=OpenQuickOrderPaySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="out_trade_no", property="outTradeNo", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="quick_id", property="quickId", jdbcType=JdbcType.BIGINT),
        @Result(column="community_trade_no", property="communityTradeNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="bill_id", property="billId", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="pay_channel", property="payChannel", jdbcType=JdbcType.VARCHAR),
        @Result(column="trade_type", property="tradeType", jdbcType=JdbcType.VARCHAR),
        @Result(column="success_time", property="successTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<OpenQuickOrderPay> selectByExample(OpenQuickOrderPayExample example);

    @Select({
        "select",
        "out_trade_no, quick_id, community_trade_no, bill_id, create_time, status, pay_channel, ",
        "trade_type, success_time",
        "from open_quick_order_pay",
        "where out_trade_no = #{outTradeNo,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="out_trade_no", property="outTradeNo", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="quick_id", property="quickId", jdbcType=JdbcType.BIGINT),
        @Result(column="community_trade_no", property="communityTradeNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="bill_id", property="billId", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="pay_channel", property="payChannel", jdbcType=JdbcType.VARCHAR),
        @Result(column="trade_type", property="tradeType", jdbcType=JdbcType.VARCHAR),
        @Result(column="success_time", property="successTime", jdbcType=JdbcType.TIMESTAMP)
    })
    OpenQuickOrderPay selectByPrimaryKey(String outTradeNo);

    @UpdateProvider(type=OpenQuickOrderPaySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenQuickOrderPay record, @Param("example") OpenQuickOrderPayExample example);

    @UpdateProvider(type=OpenQuickOrderPaySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenQuickOrderPay record, @Param("example") OpenQuickOrderPayExample example);

    @UpdateProvider(type=OpenQuickOrderPaySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpenQuickOrderPay record);

    @Update({
        "update open_quick_order_pay",
        "set quick_id = #{quickId,jdbcType=BIGINT},",
          "community_trade_no = #{communityTradeNo,jdbcType=VARCHAR},",
          "bill_id = #{billId,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=INTEGER},",
          "pay_channel = #{payChannel,jdbcType=VARCHAR},",
          "trade_type = #{tradeType,jdbcType=VARCHAR},",
          "success_time = #{successTime,jdbcType=TIMESTAMP}",
        "where out_trade_no = #{outTradeNo,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(OpenQuickOrderPay record);
}