package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenXFSJGroupConfig;
import com.rfchina.community.persistence.model.OpenXFSJGroupConfigExample;
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

public interface OpenXFSJGroupConfigMapper extends Serializable {
    @SelectProvider(type=OpenXFSJGroupConfigSqlProvider.class, method="countByExample")
    long countByExample(OpenXFSJGroupConfigExample example);

    @DeleteProvider(type=OpenXFSJGroupConfigSqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenXFSJGroupConfigExample example);

    @Delete({
        "delete from open_xfsj_group_config",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into open_xfsj_group_config (id, name, ",
        "create_time, status)",
        "values (#{id,jdbcType=BIGINT}, #{name,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{status,jdbcType=INTEGER})"
    })
    int insert(OpenXFSJGroupConfig record);

    @InsertProvider(type=OpenXFSJGroupConfigSqlProvider.class, method="insertSelective")
    int insertSelective(OpenXFSJGroupConfig record);

    @SelectProvider(type=OpenXFSJGroupConfigSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    })
    List<OpenXFSJGroupConfig> selectByExample(OpenXFSJGroupConfigExample example);

    @Select({
        "select",
        "id, name, create_time, status",
        "from open_xfsj_group_config",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    })
    OpenXFSJGroupConfig selectByPrimaryKey(Long id);

    @UpdateProvider(type=OpenXFSJGroupConfigSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenXFSJGroupConfig record, @Param("example") OpenXFSJGroupConfigExample example);

    @UpdateProvider(type=OpenXFSJGroupConfigSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenXFSJGroupConfig record, @Param("example") OpenXFSJGroupConfigExample example);

    @UpdateProvider(type=OpenXFSJGroupConfigSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpenXFSJGroupConfig record);

    @Update({
        "update open_xfsj_group_config",
        "set name = #{name,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(OpenXFSJGroupConfig record);
}