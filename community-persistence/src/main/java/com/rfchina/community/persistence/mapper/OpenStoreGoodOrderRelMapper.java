package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenStoreGoodOrderRel;
import com.rfchina.community.persistence.model.OpenStoreGoodOrderRelExample;
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

public interface OpenStoreGoodOrderRelMapper extends BaseMapper {
    @SelectProvider(type=OpenStoreGoodOrderRelSqlProvider.class, method="countByExample")
    long countByExample(OpenStoreGoodOrderRelExample example);

    @DeleteProvider(type=OpenStoreGoodOrderRelSqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenStoreGoodOrderRelExample example);

    @Delete({
        "delete from open_store_good_order_rel",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into open_store_good_order_rel (order_id, good_id, ",
        "current_single_price, amount, ",
        "good_name, good_code, ",
        "good_img_url, verify_times, ",
        "verify_start_time, verify_end_time, ",
        "pay_status)",
        "values (#{orderId,jdbcType=INTEGER}, #{goodId,jdbcType=INTEGER}, ",
        "#{currentSinglePrice,jdbcType=DECIMAL}, #{amount,jdbcType=INTEGER}, ",
        "#{goodName,jdbcType=VARCHAR}, #{goodCode,jdbcType=VARCHAR}, ",
        "#{goodImgUrl,jdbcType=VARCHAR}, #{verifyTimes,jdbcType=INTEGER}, ",
        "#{verifyStartTime,jdbcType=TIMESTAMP}, #{verifyEndTime,jdbcType=TIMESTAMP}, ",
        "#{payStatus,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(OpenStoreGoodOrderRel record);

    @InsertProvider(type=OpenStoreGoodOrderRelSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(OpenStoreGoodOrderRel record);

    @SelectProvider(type=OpenStoreGoodOrderRelSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.INTEGER),
        @Result(column="good_id", property="goodId", jdbcType=JdbcType.INTEGER),
        @Result(column="current_single_price", property="currentSinglePrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="amount", property="amount", jdbcType=JdbcType.INTEGER),
        @Result(column="good_name", property="goodName", jdbcType=JdbcType.VARCHAR),
        @Result(column="good_code", property="goodCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="good_img_url", property="goodImgUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="verify_times", property="verifyTimes", jdbcType=JdbcType.INTEGER),
        @Result(column="verify_start_time", property="verifyStartTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="verify_end_time", property="verifyEndTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="pay_status", property="payStatus", jdbcType=JdbcType.INTEGER)
    })
    List<OpenStoreGoodOrderRel> selectByExample(OpenStoreGoodOrderRelExample example);

    @Select({
        "select",
        "id, order_id, good_id, current_single_price, amount, good_name, good_code, good_img_url, ",
        "verify_times, verify_start_time, verify_end_time, pay_status",
        "from open_store_good_order_rel",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.INTEGER),
        @Result(column="good_id", property="goodId", jdbcType=JdbcType.INTEGER),
        @Result(column="current_single_price", property="currentSinglePrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="amount", property="amount", jdbcType=JdbcType.INTEGER),
        @Result(column="good_name", property="goodName", jdbcType=JdbcType.VARCHAR),
        @Result(column="good_code", property="goodCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="good_img_url", property="goodImgUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="verify_times", property="verifyTimes", jdbcType=JdbcType.INTEGER),
        @Result(column="verify_start_time", property="verifyStartTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="verify_end_time", property="verifyEndTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="pay_status", property="payStatus", jdbcType=JdbcType.INTEGER)
    })
    OpenStoreGoodOrderRel selectByPrimaryKey(Integer id);

    @UpdateProvider(type=OpenStoreGoodOrderRelSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenStoreGoodOrderRel record, @Param("example") OpenStoreGoodOrderRelExample example);

    @UpdateProvider(type=OpenStoreGoodOrderRelSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenStoreGoodOrderRel record, @Param("example") OpenStoreGoodOrderRelExample example);

    @UpdateProvider(type=OpenStoreGoodOrderRelSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpenStoreGoodOrderRel record);

    @Update({
        "update open_store_good_order_rel",
        "set order_id = #{orderId,jdbcType=INTEGER},",
          "good_id = #{goodId,jdbcType=INTEGER},",
          "current_single_price = #{currentSinglePrice,jdbcType=DECIMAL},",
          "amount = #{amount,jdbcType=INTEGER},",
          "good_name = #{goodName,jdbcType=VARCHAR},",
          "good_code = #{goodCode,jdbcType=VARCHAR},",
          "good_img_url = #{goodImgUrl,jdbcType=VARCHAR},",
          "verify_times = #{verifyTimes,jdbcType=INTEGER},",
          "verify_start_time = #{verifyStartTime,jdbcType=TIMESTAMP},",
          "verify_end_time = #{verifyEndTime,jdbcType=TIMESTAMP},",
          "pay_status = #{payStatus,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(OpenStoreGoodOrderRel record);
}