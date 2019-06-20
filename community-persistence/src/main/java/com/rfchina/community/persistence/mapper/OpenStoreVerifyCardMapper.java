package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenStoreVerifyCard;
import com.rfchina.community.persistence.model.OpenStoreVerifyCardExample;
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

public interface OpenStoreVerifyCardMapper extends Serializable {
    @SelectProvider(type=OpenStoreVerifyCardSqlProvider.class, method="countByExample")
    long countByExample(OpenStoreVerifyCardExample example);

    @DeleteProvider(type=OpenStoreVerifyCardSqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenStoreVerifyCardExample example);

    @Delete({
        "delete from open_store_verify_card",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into open_store_verify_card (service_id, order_id, ",
        "uid, good_id, good_order_rel_id, ",
        "good_code, good_name, ",
        "code, verify_start_time, ",
        "verify_end_time, verify_status, ",
        "create_time, verify_time, ",
        "single_scale_price)",
        "values (#{serviceId,jdbcType=INTEGER}, #{orderId,jdbcType=INTEGER}, ",
        "#{uid,jdbcType=BIGINT}, #{goodId,jdbcType=INTEGER}, #{goodOrderRelId,jdbcType=INTEGER}, ",
        "#{goodCode,jdbcType=VARCHAR}, #{goodName,jdbcType=VARCHAR}, ",
        "#{code,jdbcType=VARCHAR}, #{verifyStartTime,jdbcType=TIMESTAMP}, ",
        "#{verifyEndTime,jdbcType=TIMESTAMP}, #{verifyStatus,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{verifyTime,jdbcType=TIMESTAMP}, ",
        "#{singleScalePrice,jdbcType=DECIMAL})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(OpenStoreVerifyCard record);

    @InsertProvider(type=OpenStoreVerifyCardSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(OpenStoreVerifyCard record);

    @SelectProvider(type=OpenStoreVerifyCardSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.INTEGER),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="good_id", property="goodId", jdbcType=JdbcType.INTEGER),
        @Result(column="good_order_rel_id", property="goodOrderRelId", jdbcType=JdbcType.INTEGER),
        @Result(column="good_code", property="goodCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="good_name", property="goodName", jdbcType=JdbcType.VARCHAR),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="verify_start_time", property="verifyStartTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="verify_end_time", property="verifyEndTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="verify_status", property="verifyStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="verify_time", property="verifyTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="single_scale_price", property="singleScalePrice", jdbcType=JdbcType.DECIMAL)
    })
    List<OpenStoreVerifyCard> selectByExample(OpenStoreVerifyCardExample example);

    @Select({
        "select",
        "id, service_id, order_id, uid, good_id, good_order_rel_id, good_code, good_name, ",
        "code, verify_start_time, verify_end_time, verify_status, create_time, verify_time, ",
        "single_scale_price",
        "from open_store_verify_card",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.INTEGER),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="good_id", property="goodId", jdbcType=JdbcType.INTEGER),
        @Result(column="good_order_rel_id", property="goodOrderRelId", jdbcType=JdbcType.INTEGER),
        @Result(column="good_code", property="goodCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="good_name", property="goodName", jdbcType=JdbcType.VARCHAR),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="verify_start_time", property="verifyStartTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="verify_end_time", property="verifyEndTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="verify_status", property="verifyStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="verify_time", property="verifyTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="single_scale_price", property="singleScalePrice", jdbcType=JdbcType.DECIMAL)
    })
    OpenStoreVerifyCard selectByPrimaryKey(Long id);

    @UpdateProvider(type=OpenStoreVerifyCardSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenStoreVerifyCard record, @Param("example") OpenStoreVerifyCardExample example);

    @UpdateProvider(type=OpenStoreVerifyCardSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenStoreVerifyCard record, @Param("example") OpenStoreVerifyCardExample example);

    @UpdateProvider(type=OpenStoreVerifyCardSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpenStoreVerifyCard record);

    @Update({
        "update open_store_verify_card",
        "set service_id = #{serviceId,jdbcType=INTEGER},",
          "order_id = #{orderId,jdbcType=INTEGER},",
          "uid = #{uid,jdbcType=BIGINT},",
          "good_id = #{goodId,jdbcType=INTEGER},",
          "good_order_rel_id = #{goodOrderRelId,jdbcType=INTEGER},",
          "good_code = #{goodCode,jdbcType=VARCHAR},",
          "good_name = #{goodName,jdbcType=VARCHAR},",
          "code = #{code,jdbcType=VARCHAR},",
          "verify_start_time = #{verifyStartTime,jdbcType=TIMESTAMP},",
          "verify_end_time = #{verifyEndTime,jdbcType=TIMESTAMP},",
          "verify_status = #{verifyStatus,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "verify_time = #{verifyTime,jdbcType=TIMESTAMP},",
          "single_scale_price = #{singleScalePrice,jdbcType=DECIMAL}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(OpenStoreVerifyCard record);
}