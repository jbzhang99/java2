package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.RepairRecordState;
import com.rfchina.community.persistence.model.RepairRecordStateExample;
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

public interface RepairRecordStateMapper extends Serializable {
    @SelectProvider(type=RepairRecordStateSqlProvider.class, method="countByExample")
    long countByExample(RepairRecordStateExample example);

    @DeleteProvider(type=RepairRecordStateSqlProvider.class, method="deleteByExample")
    int deleteByExample(RepairRecordStateExample example);

    @Delete({
        "delete from repair_record_state",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into repair_record_state (tsk_code, tsk_state, ",
        "tsk_istate, tsk_complete, ",
        "tsk_desc, tsk_complete_time, ",
        "form_type, out_reason, ",
        "create_time)",
        "values (#{tskCode,jdbcType=VARCHAR}, #{tskState,jdbcType=VARCHAR}, ",
        "#{tskIstate,jdbcType=INTEGER}, #{tskComplete,jdbcType=INTEGER}, ",
        "#{tskDesc,jdbcType=VARCHAR}, #{tskCompleteTime,jdbcType=TIMESTAMP}, ",
        "#{formType,jdbcType=INTEGER}, #{outReason,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(RepairRecordState record);

    @InsertProvider(type=RepairRecordStateSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(RepairRecordState record);

    @SelectProvider(type=RepairRecordStateSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="tsk_code", property="tskCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="tsk_state", property="tskState", jdbcType=JdbcType.VARCHAR),
        @Result(column="tsk_istate", property="tskIstate", jdbcType=JdbcType.INTEGER),
        @Result(column="tsk_complete", property="tskComplete", jdbcType=JdbcType.INTEGER),
        @Result(column="tsk_desc", property="tskDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="tsk_complete_time", property="tskCompleteTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="form_type", property="formType", jdbcType=JdbcType.INTEGER),
        @Result(column="out_reason", property="outReason", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<RepairRecordState> selectByExample(RepairRecordStateExample example);

    @Select({
        "select",
        "id, tsk_code, tsk_state, tsk_istate, tsk_complete, tsk_desc, tsk_complete_time, ",
        "form_type, out_reason, create_time",
        "from repair_record_state",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="tsk_code", property="tskCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="tsk_state", property="tskState", jdbcType=JdbcType.VARCHAR),
        @Result(column="tsk_istate", property="tskIstate", jdbcType=JdbcType.INTEGER),
        @Result(column="tsk_complete", property="tskComplete", jdbcType=JdbcType.INTEGER),
        @Result(column="tsk_desc", property="tskDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="tsk_complete_time", property="tskCompleteTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="form_type", property="formType", jdbcType=JdbcType.INTEGER),
        @Result(column="out_reason", property="outReason", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    RepairRecordState selectByPrimaryKey(Long id);

    @UpdateProvider(type=RepairRecordStateSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") RepairRecordState record, @Param("example") RepairRecordStateExample example);

    @UpdateProvider(type=RepairRecordStateSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") RepairRecordState record, @Param("example") RepairRecordStateExample example);

    @UpdateProvider(type=RepairRecordStateSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RepairRecordState record);

    @Update({
        "update repair_record_state",
        "set tsk_code = #{tskCode,jdbcType=VARCHAR},",
          "tsk_state = #{tskState,jdbcType=VARCHAR},",
          "tsk_istate = #{tskIstate,jdbcType=INTEGER},",
          "tsk_complete = #{tskComplete,jdbcType=INTEGER},",
          "tsk_desc = #{tskDesc,jdbcType=VARCHAR},",
          "tsk_complete_time = #{tskCompleteTime,jdbcType=TIMESTAMP},",
          "form_type = #{formType,jdbcType=INTEGER},",
          "out_reason = #{outReason,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(RepairRecordState record);
}