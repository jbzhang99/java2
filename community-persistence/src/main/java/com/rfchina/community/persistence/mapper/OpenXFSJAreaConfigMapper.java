package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenXFSJAreaConfig;
import com.rfchina.community.persistence.model.OpenXFSJAreaConfigExample;
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

public interface OpenXFSJAreaConfigMapper extends Serializable {
    @SelectProvider(type=OpenXFSJAreaConfigSqlProvider.class, method="countByExample")
    long countByExample(OpenXFSJAreaConfigExample example);

    @DeleteProvider(type=OpenXFSJAreaConfigSqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenXFSJAreaConfigExample example);

    @Delete({
        "delete from open_xfsj_area_config",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into open_xfsj_area_config (id, group_config_id, ",
        "city_id, name, create_time, ",
        "status)",
        "values (#{id,jdbcType=BIGINT}, #{groupConfigId,jdbcType=BIGINT}, ",
        "#{cityId,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{status,jdbcType=INTEGER})"
    })
    int insert(OpenXFSJAreaConfig record);

    @InsertProvider(type=OpenXFSJAreaConfigSqlProvider.class, method="insertSelective")
    int insertSelective(OpenXFSJAreaConfig record);

    @SelectProvider(type=OpenXFSJAreaConfigSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="group_config_id", property="groupConfigId", jdbcType=JdbcType.BIGINT),
        @Result(column="city_id", property="cityId", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    })
    List<OpenXFSJAreaConfig> selectByExample(OpenXFSJAreaConfigExample example);

    @Select({
        "select",
        "id, group_config_id, city_id, name, create_time, status",
        "from open_xfsj_area_config",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="group_config_id", property="groupConfigId", jdbcType=JdbcType.BIGINT),
        @Result(column="city_id", property="cityId", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    })
    OpenXFSJAreaConfig selectByPrimaryKey(Long id);

    @UpdateProvider(type=OpenXFSJAreaConfigSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenXFSJAreaConfig record, @Param("example") OpenXFSJAreaConfigExample example);

    @UpdateProvider(type=OpenXFSJAreaConfigSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenXFSJAreaConfig record, @Param("example") OpenXFSJAreaConfigExample example);

    @UpdateProvider(type=OpenXFSJAreaConfigSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpenXFSJAreaConfig record);

    @Update({
        "update open_xfsj_area_config",
        "set group_config_id = #{groupConfigId,jdbcType=BIGINT},",
          "city_id = #{cityId,jdbcType=INTEGER},",
          "name = #{name,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(OpenXFSJAreaConfig record);
}