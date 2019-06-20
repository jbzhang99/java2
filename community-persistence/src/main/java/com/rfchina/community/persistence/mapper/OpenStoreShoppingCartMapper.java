package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenStoreShoppingCart;
import com.rfchina.community.persistence.model.OpenStoreShoppingCartExample;
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

public interface OpenStoreShoppingCartMapper extends Serializable {
    @SelectProvider(type=OpenStoreShoppingCartSqlProvider.class, method="countByExample")
    long countByExample(OpenStoreShoppingCartExample example);

    @DeleteProvider(type=OpenStoreShoppingCartSqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenStoreShoppingCartExample example);

    @Delete({
        "delete from open_store_shopping_cart",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into open_store_shopping_cart (service_id, user_id, ",
        "open_id, good_id, ",
        "amount, create_time, ",
        "valid_status, update_time)",
        "values (#{serviceId,jdbcType=INTEGER}, #{userId,jdbcType=BIGINT}, ",
        "#{openId,jdbcType=VARCHAR}, #{goodId,jdbcType=INTEGER}, ",
        "#{amount,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{validStatus,jdbcType=INTEGER}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(OpenStoreShoppingCart record);

    @InsertProvider(type=OpenStoreShoppingCartSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(OpenStoreShoppingCart record);

    @SelectProvider(type=OpenStoreShoppingCartSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="open_id", property="openId", jdbcType=JdbcType.VARCHAR),
        @Result(column="good_id", property="goodId", jdbcType=JdbcType.INTEGER),
        @Result(column="amount", property="amount", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="valid_status", property="validStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<OpenStoreShoppingCart> selectByExample(OpenStoreShoppingCartExample example);

    @Select({
        "select",
        "id, service_id, user_id, open_id, good_id, amount, create_time, valid_status, ",
        "update_time",
        "from open_store_shopping_cart",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="open_id", property="openId", jdbcType=JdbcType.VARCHAR),
        @Result(column="good_id", property="goodId", jdbcType=JdbcType.INTEGER),
        @Result(column="amount", property="amount", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="valid_status", property="validStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    OpenStoreShoppingCart selectByPrimaryKey(Integer id);

    @UpdateProvider(type=OpenStoreShoppingCartSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenStoreShoppingCart record, @Param("example") OpenStoreShoppingCartExample example);

    @UpdateProvider(type=OpenStoreShoppingCartSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenStoreShoppingCart record, @Param("example") OpenStoreShoppingCartExample example);

    @UpdateProvider(type=OpenStoreShoppingCartSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpenStoreShoppingCart record);

    @Update({
        "update open_store_shopping_cart",
        "set service_id = #{serviceId,jdbcType=INTEGER},",
          "user_id = #{userId,jdbcType=BIGINT},",
          "open_id = #{openId,jdbcType=VARCHAR},",
          "good_id = #{goodId,jdbcType=INTEGER},",
          "amount = #{amount,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "valid_status = #{validStatus,jdbcType=INTEGER},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(OpenStoreShoppingCart record);
}