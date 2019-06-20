package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.RepairProblemType;
import com.rfchina.community.persistence.model.RepairProblemTypeExample;
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

public interface RepairProblemTypeMapper extends Serializable {
    @SelectProvider(type=RepairProblemTypeSqlProvider.class, method="countByExample")
    long countByExample(RepairProblemTypeExample example);

    @DeleteProvider(type=RepairProblemTypeSqlProvider.class, method="deleteByExample")
    int deleteByExample(RepairProblemTypeExample example);

    @Delete({
        "delete from repair_problem_type",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into repair_problem_type (outer_id, name, ",
        "display_name, create_time, ",
        "sequence, type, ",
        "status)",
        "values (#{outerId,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
        "#{displayName,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{sequence,jdbcType=INTEGER}, #{type,jdbcType=TINYINT}, ",
        "#{status,jdbcType=TINYINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(RepairProblemType record);

    @InsertProvider(type=RepairProblemTypeSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(RepairProblemType record);

    @SelectProvider(type=RepairProblemTypeSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="outer_id", property="outerId", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="display_name", property="displayName", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="sequence", property="sequence", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.TINYINT),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT)
    })
    List<RepairProblemType> selectByExample(RepairProblemTypeExample example);

    @Select({
        "select",
        "id, outer_id, name, display_name, create_time, sequence, type, status",
        "from repair_problem_type",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="outer_id", property="outerId", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="display_name", property="displayName", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="sequence", property="sequence", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.TINYINT),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT)
    })
    RepairProblemType selectByPrimaryKey(Integer id);

    @UpdateProvider(type=RepairProblemTypeSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") RepairProblemType record, @Param("example") RepairProblemTypeExample example);

    @UpdateProvider(type=RepairProblemTypeSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") RepairProblemType record, @Param("example") RepairProblemTypeExample example);

    @UpdateProvider(type=RepairProblemTypeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RepairProblemType record);

    @Update({
        "update repair_problem_type",
        "set outer_id = #{outerId,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "display_name = #{displayName,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "sequence = #{sequence,jdbcType=INTEGER},",
          "type = #{type,jdbcType=TINYINT},",
          "status = #{status,jdbcType=TINYINT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(RepairProblemType record);
}