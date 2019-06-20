package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenOperatorTaskRel;
import com.rfchina.community.persistence.model.OpenOperatorTaskRelExample;
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

public interface OpenOperatorTaskRelMapper extends Serializable {
    @SelectProvider(type=OpenOperatorTaskRelSqlProvider.class, method="countByExample")
    long countByExample(OpenOperatorTaskRelExample example);

    @DeleteProvider(type=OpenOperatorTaskRelSqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenOperatorTaskRelExample example);

    @Delete({
        "delete from open_operator_task_rel",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into open_operator_task_rel (emp_guid, emp_phone, ",
        "emp_name, task_id, ",
        "create_time, invalid_time, ",
        "valid_status)",
        "values (#{empGuid,jdbcType=VARCHAR}, #{empPhone,jdbcType=VARCHAR}, ",
        "#{empName,jdbcType=VARCHAR}, #{taskId,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{invalidTime,jdbcType=TIMESTAMP}, ",
        "#{validStatus,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(OpenOperatorTaskRel record);

    @InsertProvider(type=OpenOperatorTaskRelSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(OpenOperatorTaskRel record);

    @SelectProvider(type=OpenOperatorTaskRelSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="emp_guid", property="empGuid", jdbcType=JdbcType.VARCHAR),
        @Result(column="emp_phone", property="empPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="emp_name", property="empName", jdbcType=JdbcType.VARCHAR),
        @Result(column="task_id", property="taskId", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="invalid_time", property="invalidTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="valid_status", property="validStatus", jdbcType=JdbcType.INTEGER)
    })
    List<OpenOperatorTaskRel> selectByExample(OpenOperatorTaskRelExample example);

    @Select({
        "select",
        "id, emp_guid, emp_phone, emp_name, task_id, create_time, invalid_time, valid_status",
        "from open_operator_task_rel",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="emp_guid", property="empGuid", jdbcType=JdbcType.VARCHAR),
        @Result(column="emp_phone", property="empPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="emp_name", property="empName", jdbcType=JdbcType.VARCHAR),
        @Result(column="task_id", property="taskId", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="invalid_time", property="invalidTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="valid_status", property="validStatus", jdbcType=JdbcType.INTEGER)
    })
    OpenOperatorTaskRel selectByPrimaryKey(Long id);

    @UpdateProvider(type=OpenOperatorTaskRelSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenOperatorTaskRel record, @Param("example") OpenOperatorTaskRelExample example);

    @UpdateProvider(type=OpenOperatorTaskRelSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenOperatorTaskRel record, @Param("example") OpenOperatorTaskRelExample example);

    @UpdateProvider(type=OpenOperatorTaskRelSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpenOperatorTaskRel record);

    @Update({
        "update open_operator_task_rel",
        "set emp_guid = #{empGuid,jdbcType=VARCHAR},",
          "emp_phone = #{empPhone,jdbcType=VARCHAR},",
          "emp_name = #{empName,jdbcType=VARCHAR},",
          "task_id = #{taskId,jdbcType=BIGINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "invalid_time = #{invalidTime,jdbcType=TIMESTAMP},",
          "valid_status = #{validStatus,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(OpenOperatorTaskRel record);
}