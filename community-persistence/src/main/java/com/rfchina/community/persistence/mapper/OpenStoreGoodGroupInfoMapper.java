package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenStoreGoodGroupInfo;
import com.rfchina.community.persistence.model.OpenStoreGoodGroupInfoExample;
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

public interface OpenStoreGoodGroupInfoMapper extends Serializable {
    @SelectProvider(type=OpenStoreGoodGroupInfoSqlProvider.class, method="countByExample")
    long countByExample(OpenStoreGoodGroupInfoExample example);

    @DeleteProvider(type=OpenStoreGoodGroupInfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenStoreGoodGroupInfoExample example);

    @Delete({
        "delete from open_store_good_group_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into open_store_good_group_info (good_id, service_id, ",
        "price, group_price, ",
        "people_num, stock, ",
        "start_time, end_time, ",
        "limit_times, virtural_success_hour, ",
        "create_time, status)",
        "values (#{goodId,jdbcType=INTEGER}, #{serviceId,jdbcType=INTEGER}, ",
        "#{price,jdbcType=DECIMAL}, #{groupPrice,jdbcType=DECIMAL}, ",
        "#{peopleNum,jdbcType=INTEGER}, #{stock,jdbcType=INTEGER}, ",
        "#{startTime,jdbcType=TIMESTAMP}, #{endTime,jdbcType=TIMESTAMP}, ",
        "#{limitTimes,jdbcType=INTEGER}, #{virturalSuccessHour,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{status,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(OpenStoreGoodGroupInfo record);

    @InsertProvider(type=OpenStoreGoodGroupInfoSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(OpenStoreGoodGroupInfo record);

    @SelectProvider(type=OpenStoreGoodGroupInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="good_id", property="goodId", jdbcType=JdbcType.INTEGER),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
        @Result(column="price", property="price", jdbcType=JdbcType.DECIMAL),
        @Result(column="group_price", property="groupPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="people_num", property="peopleNum", jdbcType=JdbcType.INTEGER),
        @Result(column="stock", property="stock", jdbcType=JdbcType.INTEGER),
        @Result(column="start_time", property="startTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="end_time", property="endTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="limit_times", property="limitTimes", jdbcType=JdbcType.INTEGER),
        @Result(column="virtural_success_hour", property="virturalSuccessHour", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    })
    List<OpenStoreGoodGroupInfo> selectByExample(OpenStoreGoodGroupInfoExample example);

    @Select({
        "select",
        "id, good_id, service_id, price, group_price, people_num, stock, start_time, ",
        "end_time, limit_times, virtural_success_hour, create_time, status",
        "from open_store_good_group_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="good_id", property="goodId", jdbcType=JdbcType.INTEGER),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
        @Result(column="price", property="price", jdbcType=JdbcType.DECIMAL),
        @Result(column="group_price", property="groupPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="people_num", property="peopleNum", jdbcType=JdbcType.INTEGER),
        @Result(column="stock", property="stock", jdbcType=JdbcType.INTEGER),
        @Result(column="start_time", property="startTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="end_time", property="endTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="limit_times", property="limitTimes", jdbcType=JdbcType.INTEGER),
        @Result(column="virtural_success_hour", property="virturalSuccessHour", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    })
    OpenStoreGoodGroupInfo selectByPrimaryKey(Long id);

    @UpdateProvider(type=OpenStoreGoodGroupInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenStoreGoodGroupInfo record, @Param("example") OpenStoreGoodGroupInfoExample example);

    @UpdateProvider(type=OpenStoreGoodGroupInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenStoreGoodGroupInfo record, @Param("example") OpenStoreGoodGroupInfoExample example);

    @UpdateProvider(type=OpenStoreGoodGroupInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpenStoreGoodGroupInfo record);

    @Update({
        "update open_store_good_group_info",
        "set good_id = #{goodId,jdbcType=INTEGER},",
          "service_id = #{serviceId,jdbcType=INTEGER},",
          "price = #{price,jdbcType=DECIMAL},",
          "group_price = #{groupPrice,jdbcType=DECIMAL},",
          "people_num = #{peopleNum,jdbcType=INTEGER},",
          "stock = #{stock,jdbcType=INTEGER},",
          "start_time = #{startTime,jdbcType=TIMESTAMP},",
          "end_time = #{endTime,jdbcType=TIMESTAMP},",
          "limit_times = #{limitTimes,jdbcType=INTEGER},",
          "virtural_success_hour = #{virturalSuccessHour,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(OpenStoreGoodGroupInfo record);
}