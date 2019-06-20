package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenStatsMerchant;
import com.rfchina.community.persistence.model.OpenStatsMerchantExample;
import java.io.Serializable;
import java.util.Date;
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

public interface OpenStatsMerchantMapper extends Serializable {
    @SelectProvider(type=OpenStatsMerchantSqlProvider.class, method="countByExample")
    long countByExample(OpenStatsMerchantExample example);

    @DeleteProvider(type=OpenStatsMerchantSqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenStatsMerchantExample example);

    @Delete({
        "delete from open_stats_merchant",
        "where stat_date = #{statDate,jdbcType=DATE}"
    })
    int deleteByPrimaryKey(Date statDate);

    @Insert({
        "insert into open_stats_merchant (stat_date, stat_wreek, ",
        "stat_month, merchant_count, ",
        "shelves_count, merchant_total, ",
        "shelves_total, create_time)",
        "values (#{statDate,jdbcType=DATE}, #{statWreek,jdbcType=INTEGER}, ",
        "#{statMonth,jdbcType=INTEGER}, #{merchantCount,jdbcType=INTEGER}, ",
        "#{shelvesCount,jdbcType=INTEGER}, #{merchantTotal,jdbcType=INTEGER}, ",
        "#{shelvesTotal,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(OpenStatsMerchant record);

    @InsertProvider(type=OpenStatsMerchantSqlProvider.class, method="insertSelective")
    int insertSelective(OpenStatsMerchant record);

    @SelectProvider(type=OpenStatsMerchantSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="stat_date", property="statDate", jdbcType=JdbcType.DATE, id=true),
        @Result(column="stat_wreek", property="statWreek", jdbcType=JdbcType.INTEGER),
        @Result(column="stat_month", property="statMonth", jdbcType=JdbcType.INTEGER),
        @Result(column="merchant_count", property="merchantCount", jdbcType=JdbcType.INTEGER),
        @Result(column="shelves_count", property="shelvesCount", jdbcType=JdbcType.INTEGER),
        @Result(column="merchant_total", property="merchantTotal", jdbcType=JdbcType.INTEGER),
        @Result(column="shelves_total", property="shelvesTotal", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<OpenStatsMerchant> selectByExample(OpenStatsMerchantExample example);

    @Select({
        "select",
        "stat_date, stat_wreek, stat_month, merchant_count, shelves_count, merchant_total, ",
        "shelves_total, create_time",
        "from open_stats_merchant",
        "where stat_date = #{statDate,jdbcType=DATE}"
    })
    @Results({
        @Result(column="stat_date", property="statDate", jdbcType=JdbcType.DATE, id=true),
        @Result(column="stat_wreek", property="statWreek", jdbcType=JdbcType.INTEGER),
        @Result(column="stat_month", property="statMonth", jdbcType=JdbcType.INTEGER),
        @Result(column="merchant_count", property="merchantCount", jdbcType=JdbcType.INTEGER),
        @Result(column="shelves_count", property="shelvesCount", jdbcType=JdbcType.INTEGER),
        @Result(column="merchant_total", property="merchantTotal", jdbcType=JdbcType.INTEGER),
        @Result(column="shelves_total", property="shelvesTotal", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    OpenStatsMerchant selectByPrimaryKey(Date statDate);

    @UpdateProvider(type=OpenStatsMerchantSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenStatsMerchant record, @Param("example") OpenStatsMerchantExample example);

    @UpdateProvider(type=OpenStatsMerchantSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenStatsMerchant record, @Param("example") OpenStatsMerchantExample example);

    @UpdateProvider(type=OpenStatsMerchantSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpenStatsMerchant record);

    @Update({
        "update open_stats_merchant",
        "set stat_wreek = #{statWreek,jdbcType=INTEGER},",
          "stat_month = #{statMonth,jdbcType=INTEGER},",
          "merchant_count = #{merchantCount,jdbcType=INTEGER},",
          "shelves_count = #{shelvesCount,jdbcType=INTEGER},",
          "merchant_total = #{merchantTotal,jdbcType=INTEGER},",
          "shelves_total = #{shelvesTotal,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where stat_date = #{statDate,jdbcType=DATE}"
    })
    int updateByPrimaryKey(OpenStatsMerchant record);
}