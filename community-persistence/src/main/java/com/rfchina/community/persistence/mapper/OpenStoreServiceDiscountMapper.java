package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenStoreServiceDiscount;
import com.rfchina.community.persistence.model.OpenStoreServiceDiscountExample;
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

public interface OpenStoreServiceDiscountMapper extends Serializable {
    @SelectProvider(type=OpenStoreServiceDiscountSqlProvider.class, method="countByExample")
    long countByExample(OpenStoreServiceDiscountExample example);

    @DeleteProvider(type=OpenStoreServiceDiscountSqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenStoreServiceDiscountExample example);

    @Delete({
        "delete from open_store_service_discount",
        "where service_id = #{serviceId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer serviceId);

    @Insert({
        "insert into open_store_service_discount (service_id, discount_price, ",
        "discount_money, each_money_top, ",
        "valid_status)",
        "values (#{serviceId,jdbcType=INTEGER}, #{discountPrice,jdbcType=DECIMAL}, ",
        "#{discountMoney,jdbcType=DECIMAL}, #{eachMoneyTop,jdbcType=DECIMAL}, ",
        "#{validStatus,jdbcType=INTEGER})"
    })
    int insert(OpenStoreServiceDiscount record);

    @InsertProvider(type=OpenStoreServiceDiscountSqlProvider.class, method="insertSelective")
    int insertSelective(OpenStoreServiceDiscount record);

    @SelectProvider(type=OpenStoreServiceDiscountSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="discount_price", property="discountPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="discount_money", property="discountMoney", jdbcType=JdbcType.DECIMAL),
        @Result(column="each_money_top", property="eachMoneyTop", jdbcType=JdbcType.DECIMAL),
        @Result(column="valid_status", property="validStatus", jdbcType=JdbcType.INTEGER)
    })
    List<OpenStoreServiceDiscount> selectByExample(OpenStoreServiceDiscountExample example);

    @Select({
        "select",
        "service_id, discount_price, discount_money, each_money_top, valid_status",
        "from open_store_service_discount",
        "where service_id = #{serviceId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="discount_price", property="discountPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="discount_money", property="discountMoney", jdbcType=JdbcType.DECIMAL),
        @Result(column="each_money_top", property="eachMoneyTop", jdbcType=JdbcType.DECIMAL),
        @Result(column="valid_status", property="validStatus", jdbcType=JdbcType.INTEGER)
    })
    OpenStoreServiceDiscount selectByPrimaryKey(Integer serviceId);

    @UpdateProvider(type=OpenStoreServiceDiscountSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenStoreServiceDiscount record, @Param("example") OpenStoreServiceDiscountExample example);

    @UpdateProvider(type=OpenStoreServiceDiscountSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenStoreServiceDiscount record, @Param("example") OpenStoreServiceDiscountExample example);

    @UpdateProvider(type=OpenStoreServiceDiscountSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpenStoreServiceDiscount record);

    @Update({
        "update open_store_service_discount",
        "set discount_price = #{discountPrice,jdbcType=DECIMAL},",
          "discount_money = #{discountMoney,jdbcType=DECIMAL},",
          "each_money_top = #{eachMoneyTop,jdbcType=DECIMAL},",
          "valid_status = #{validStatus,jdbcType=INTEGER}",
        "where service_id = #{serviceId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(OpenStoreServiceDiscount record);
}