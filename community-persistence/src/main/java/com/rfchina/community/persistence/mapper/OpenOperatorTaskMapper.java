package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenOperatorTask;
import com.rfchina.community.persistence.model.OpenOperatorTaskExample;
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

public interface OpenOperatorTaskMapper extends Serializable {
    @SelectProvider(type=OpenOperatorTaskSqlProvider.class, method="countByExample")
    long countByExample(OpenOperatorTaskExample example);

    @DeleteProvider(type=OpenOperatorTaskSqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenOperatorTaskExample example);

    @Delete({
        "delete from open_operator_task",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into open_operator_task (city_id, community_id, ",
        "xfsj_id, service_id, ",
        "merchant_id, start_time, ",
        "end_time, release_status, ",
        "release_time, receive_status, ",
        "emp_guid, emp_phone, ",
        "emp_name, become_time, ",
        "address, create_time, ",
        "help_detail)",
        "values (#{cityId,jdbcType=INTEGER}, #{communityId,jdbcType=INTEGER}, ",
        "#{xfsjId,jdbcType=BIGINT}, #{serviceId,jdbcType=INTEGER}, ",
        "#{merchantId,jdbcType=BIGINT}, #{startTime,jdbcType=TIMESTAMP}, ",
        "#{endTime,jdbcType=TIMESTAMP}, #{releaseStatus,jdbcType=INTEGER}, ",
        "#{releaseTime,jdbcType=TIMESTAMP}, #{receiveStatus,jdbcType=INTEGER}, ",
        "#{empGuid,jdbcType=VARCHAR}, #{empPhone,jdbcType=VARCHAR}, ",
        "#{empName,jdbcType=VARCHAR}, #{becomeTime,jdbcType=TIMESTAMP}, ",
        "#{address,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{helpDetail,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(OpenOperatorTask record);

    @InsertProvider(type=OpenOperatorTaskSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(OpenOperatorTask record);

    @SelectProvider(type=OpenOperatorTaskSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="city_id", property="cityId", jdbcType=JdbcType.INTEGER),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="xfsj_id", property="xfsjId", jdbcType=JdbcType.BIGINT),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
        @Result(column="merchant_id", property="merchantId", jdbcType=JdbcType.BIGINT),
        @Result(column="start_time", property="startTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="end_time", property="endTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="release_status", property="releaseStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="release_time", property="releaseTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="receive_status", property="receiveStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="emp_guid", property="empGuid", jdbcType=JdbcType.VARCHAR),
        @Result(column="emp_phone", property="empPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="emp_name", property="empName", jdbcType=JdbcType.VARCHAR),
        @Result(column="become_time", property="becomeTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="help_detail", property="helpDetail", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<OpenOperatorTask> selectByExampleWithBLOBs(OpenOperatorTaskExample example);

    @SelectProvider(type=OpenOperatorTaskSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="city_id", property="cityId", jdbcType=JdbcType.INTEGER),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="xfsj_id", property="xfsjId", jdbcType=JdbcType.BIGINT),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
        @Result(column="merchant_id", property="merchantId", jdbcType=JdbcType.BIGINT),
        @Result(column="start_time", property="startTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="end_time", property="endTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="release_status", property="releaseStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="release_time", property="releaseTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="receive_status", property="receiveStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="emp_guid", property="empGuid", jdbcType=JdbcType.VARCHAR),
        @Result(column="emp_phone", property="empPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="emp_name", property="empName", jdbcType=JdbcType.VARCHAR),
        @Result(column="become_time", property="becomeTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<OpenOperatorTask> selectByExample(OpenOperatorTaskExample example);

    @Select({
        "select",
        "id, city_id, community_id, xfsj_id, service_id, merchant_id, start_time, end_time, ",
        "release_status, release_time, receive_status, emp_guid, emp_phone, emp_name, ",
        "become_time, address, create_time, help_detail",
        "from open_operator_task",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="city_id", property="cityId", jdbcType=JdbcType.INTEGER),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="xfsj_id", property="xfsjId", jdbcType=JdbcType.BIGINT),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
        @Result(column="merchant_id", property="merchantId", jdbcType=JdbcType.BIGINT),
        @Result(column="start_time", property="startTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="end_time", property="endTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="release_status", property="releaseStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="release_time", property="releaseTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="receive_status", property="receiveStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="emp_guid", property="empGuid", jdbcType=JdbcType.VARCHAR),
        @Result(column="emp_phone", property="empPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="emp_name", property="empName", jdbcType=JdbcType.VARCHAR),
        @Result(column="become_time", property="becomeTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="help_detail", property="helpDetail", jdbcType=JdbcType.LONGVARCHAR)
    })
    OpenOperatorTask selectByPrimaryKey(Long id);

    @UpdateProvider(type=OpenOperatorTaskSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenOperatorTask record, @Param("example") OpenOperatorTaskExample example);

    @UpdateProvider(type=OpenOperatorTaskSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") OpenOperatorTask record, @Param("example") OpenOperatorTaskExample example);

    @UpdateProvider(type=OpenOperatorTaskSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenOperatorTask record, @Param("example") OpenOperatorTaskExample example);

    @UpdateProvider(type=OpenOperatorTaskSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpenOperatorTask record);

    @Update({
        "update open_operator_task",
        "set city_id = #{cityId,jdbcType=INTEGER},",
          "community_id = #{communityId,jdbcType=INTEGER},",
          "xfsj_id = #{xfsjId,jdbcType=BIGINT},",
          "service_id = #{serviceId,jdbcType=INTEGER},",
          "merchant_id = #{merchantId,jdbcType=BIGINT},",
          "start_time = #{startTime,jdbcType=TIMESTAMP},",
          "end_time = #{endTime,jdbcType=TIMESTAMP},",
          "release_status = #{releaseStatus,jdbcType=INTEGER},",
          "release_time = #{releaseTime,jdbcType=TIMESTAMP},",
          "receive_status = #{receiveStatus,jdbcType=INTEGER},",
          "emp_guid = #{empGuid,jdbcType=VARCHAR},",
          "emp_phone = #{empPhone,jdbcType=VARCHAR},",
          "emp_name = #{empName,jdbcType=VARCHAR},",
          "become_time = #{becomeTime,jdbcType=TIMESTAMP},",
          "address = #{address,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "help_detail = #{helpDetail,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(OpenOperatorTask record);

    @Update({
        "update open_operator_task",
        "set city_id = #{cityId,jdbcType=INTEGER},",
          "community_id = #{communityId,jdbcType=INTEGER},",
          "xfsj_id = #{xfsjId,jdbcType=BIGINT},",
          "service_id = #{serviceId,jdbcType=INTEGER},",
          "merchant_id = #{merchantId,jdbcType=BIGINT},",
          "start_time = #{startTime,jdbcType=TIMESTAMP},",
          "end_time = #{endTime,jdbcType=TIMESTAMP},",
          "release_status = #{releaseStatus,jdbcType=INTEGER},",
          "release_time = #{releaseTime,jdbcType=TIMESTAMP},",
          "receive_status = #{receiveStatus,jdbcType=INTEGER},",
          "emp_guid = #{empGuid,jdbcType=VARCHAR},",
          "emp_phone = #{empPhone,jdbcType=VARCHAR},",
          "emp_name = #{empName,jdbcType=VARCHAR},",
          "become_time = #{becomeTime,jdbcType=TIMESTAMP},",
          "address = #{address,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(OpenOperatorTask record);
}