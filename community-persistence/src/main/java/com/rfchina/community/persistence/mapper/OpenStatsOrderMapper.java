package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenStatsOrder;
import com.rfchina.community.persistence.model.OpenStatsOrderExample;
import com.rfchina.community.persistence.model.OpenStatsOrderKey;
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

public interface OpenStatsOrderMapper extends Serializable {
    @SelectProvider(type=OpenStatsOrderSqlProvider.class, method="countByExample")
    long countByExample(OpenStatsOrderExample example);

    @DeleteProvider(type=OpenStatsOrderSqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenStatsOrderExample example);

    @Delete({
        "delete from open_stats_order",
        "where stat_date = #{statDate,jdbcType=DATE}",
          "and community_id = #{communityId,jdbcType=INTEGER}",
          "and service_id = #{serviceId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(OpenStatsOrderKey key);

    @Insert({
        "insert into open_stats_order (stat_date, community_id, ",
        "service_id, stat_wreek, ",
        "stat_month, order_count, ",
        "total_amount, order_count_total, ",
        "total_amount_total, create_time)",
        "values (#{statDate,jdbcType=DATE}, #{communityId,jdbcType=INTEGER}, ",
        "#{serviceId,jdbcType=INTEGER}, #{statWreek,jdbcType=INTEGER}, ",
        "#{statMonth,jdbcType=INTEGER}, #{orderCount,jdbcType=INTEGER}, ",
        "#{totalAmount,jdbcType=DECIMAL}, #{orderCountTotal,jdbcType=INTEGER}, ",
        "#{totalAmountTotal,jdbcType=DECIMAL}, #{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(OpenStatsOrder record);

    @InsertProvider(type=OpenStatsOrderSqlProvider.class, method="insertSelective")
    int insertSelective(OpenStatsOrder record);

    @SelectProvider(type=OpenStatsOrderSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="stat_date", property="statDate", jdbcType=JdbcType.DATE, id=true),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="stat_wreek", property="statWreek", jdbcType=JdbcType.INTEGER),
        @Result(column="stat_month", property="statMonth", jdbcType=JdbcType.INTEGER),
        @Result(column="order_count", property="orderCount", jdbcType=JdbcType.INTEGER),
        @Result(column="total_amount", property="totalAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="order_count_total", property="orderCountTotal", jdbcType=JdbcType.INTEGER),
        @Result(column="total_amount_total", property="totalAmountTotal", jdbcType=JdbcType.DECIMAL),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<OpenStatsOrder> selectByExample(OpenStatsOrderExample example);

    @Select({
        "select",
        "stat_date, community_id, service_id, stat_wreek, stat_month, order_count, total_amount, ",
        "order_count_total, total_amount_total, create_time",
        "from open_stats_order",
        "where stat_date = #{statDate,jdbcType=DATE}",
          "and community_id = #{communityId,jdbcType=INTEGER}",
          "and service_id = #{serviceId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="stat_date", property="statDate", jdbcType=JdbcType.DATE, id=true),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="stat_wreek", property="statWreek", jdbcType=JdbcType.INTEGER),
        @Result(column="stat_month", property="statMonth", jdbcType=JdbcType.INTEGER),
        @Result(column="order_count", property="orderCount", jdbcType=JdbcType.INTEGER),
        @Result(column="total_amount", property="totalAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="order_count_total", property="orderCountTotal", jdbcType=JdbcType.INTEGER),
        @Result(column="total_amount_total", property="totalAmountTotal", jdbcType=JdbcType.DECIMAL),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    OpenStatsOrder selectByPrimaryKey(OpenStatsOrderKey key);

    @UpdateProvider(type=OpenStatsOrderSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenStatsOrder record, @Param("example") OpenStatsOrderExample example);

    @UpdateProvider(type=OpenStatsOrderSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenStatsOrder record, @Param("example") OpenStatsOrderExample example);

    @UpdateProvider(type=OpenStatsOrderSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpenStatsOrder record);

    @Update({
        "update open_stats_order",
        "set stat_wreek = #{statWreek,jdbcType=INTEGER},",
          "stat_month = #{statMonth,jdbcType=INTEGER},",
          "order_count = #{orderCount,jdbcType=INTEGER},",
          "total_amount = #{totalAmount,jdbcType=DECIMAL},",
          "order_count_total = #{orderCountTotal,jdbcType=INTEGER},",
          "total_amount_total = #{totalAmountTotal,jdbcType=DECIMAL},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where stat_date = #{statDate,jdbcType=DATE}",
          "and community_id = #{communityId,jdbcType=INTEGER}",
          "and service_id = #{serviceId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(OpenStatsOrder record);
}