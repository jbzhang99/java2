package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenStoreGroupData;
import com.rfchina.community.persistence.model.OpenStoreGroupDataExample;
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

public interface OpenStoreGroupDataMapper extends Serializable {
    @SelectProvider(type=OpenStoreGroupDataSqlProvider.class, method="countByExample")
    long countByExample(OpenStoreGroupDataExample example);

    @DeleteProvider(type=OpenStoreGroupDataSqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenStoreGroupDataExample example);

    @Delete({
        "delete from open_store_group_data",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into open_store_group_data (good_group_id, good_id, ",
        "service_id, uid, pic_url, ",
        "start_type, nick_name, ",
        "phone, people_num, ",
        "success_num, usable_num, ",
        "lock_num, create_time, ",
        "stop_time, end_time, ",
        "status, type, success_time)",
        "values (#{goodGroupId,jdbcType=BIGINT}, #{goodId,jdbcType=INTEGER}, ",
        "#{serviceId,jdbcType=INTEGER}, #{uid,jdbcType=BIGINT}, #{picUrl,jdbcType=VARCHAR}, ",
        "#{startType,jdbcType=VARCHAR}, #{nickName,jdbcType=VARCHAR}, ",
        "#{phone,jdbcType=VARCHAR}, #{peopleNum,jdbcType=INTEGER}, ",
        "#{successNum,jdbcType=INTEGER}, #{usableNum,jdbcType=INTEGER}, ",
        "#{lockNum,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{stopTime,jdbcType=TIMESTAMP}, #{endTime,jdbcType=TIMESTAMP}, ",
        "#{status,jdbcType=INTEGER}, #{type,jdbcType=VARCHAR}, #{successTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(OpenStoreGroupData record);

    @InsertProvider(type=OpenStoreGroupDataSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(OpenStoreGroupData record);

    @SelectProvider(type=OpenStoreGroupDataSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="good_group_id", property="goodGroupId", jdbcType=JdbcType.BIGINT),
        @Result(column="good_id", property="goodId", jdbcType=JdbcType.INTEGER),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="pic_url", property="picUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="start_type", property="startType", jdbcType=JdbcType.VARCHAR),
        @Result(column="nick_name", property="nickName", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="people_num", property="peopleNum", jdbcType=JdbcType.INTEGER),
        @Result(column="success_num", property="successNum", jdbcType=JdbcType.INTEGER),
        @Result(column="usable_num", property="usableNum", jdbcType=JdbcType.INTEGER),
        @Result(column="lock_num", property="lockNum", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="stop_time", property="stopTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="end_time", property="endTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="success_time", property="successTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<OpenStoreGroupData> selectByExample(OpenStoreGroupDataExample example);

    @Select({
        "select",
        "id, good_group_id, good_id, service_id, uid, pic_url, start_type, nick_name, ",
        "phone, people_num, success_num, usable_num, lock_num, create_time, stop_time, ",
        "end_time, status, type, success_time",
        "from open_store_group_data",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="good_group_id", property="goodGroupId", jdbcType=JdbcType.BIGINT),
        @Result(column="good_id", property="goodId", jdbcType=JdbcType.INTEGER),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="pic_url", property="picUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="start_type", property="startType", jdbcType=JdbcType.VARCHAR),
        @Result(column="nick_name", property="nickName", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="people_num", property="peopleNum", jdbcType=JdbcType.INTEGER),
        @Result(column="success_num", property="successNum", jdbcType=JdbcType.INTEGER),
        @Result(column="usable_num", property="usableNum", jdbcType=JdbcType.INTEGER),
        @Result(column="lock_num", property="lockNum", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="stop_time", property="stopTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="end_time", property="endTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="success_time", property="successTime", jdbcType=JdbcType.TIMESTAMP)
    })
    OpenStoreGroupData selectByPrimaryKey(Long id);

    @UpdateProvider(type=OpenStoreGroupDataSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenStoreGroupData record, @Param("example") OpenStoreGroupDataExample example);

    @UpdateProvider(type=OpenStoreGroupDataSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenStoreGroupData record, @Param("example") OpenStoreGroupDataExample example);

    @UpdateProvider(type=OpenStoreGroupDataSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpenStoreGroupData record);

    @Update({
        "update open_store_group_data",
        "set good_group_id = #{goodGroupId,jdbcType=BIGINT},",
          "good_id = #{goodId,jdbcType=INTEGER},",
          "service_id = #{serviceId,jdbcType=INTEGER},",
          "uid = #{uid,jdbcType=BIGINT},",
          "pic_url = #{picUrl,jdbcType=VARCHAR},",
          "start_type = #{startType,jdbcType=VARCHAR},",
          "nick_name = #{nickName,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "people_num = #{peopleNum,jdbcType=INTEGER},",
          "success_num = #{successNum,jdbcType=INTEGER},",
          "usable_num = #{usableNum,jdbcType=INTEGER},",
          "lock_num = #{lockNum,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "stop_time = #{stopTime,jdbcType=TIMESTAMP},",
          "end_time = #{endTime,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=INTEGER},",
          "type = #{type,jdbcType=VARCHAR},",
          "success_time = #{successTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(OpenStoreGroupData record);
}