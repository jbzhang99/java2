package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenCommunityAppRela;
import com.rfchina.community.persistence.model.OpenCommunityAppRelaExample;
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

public interface OpenCommunityAppRelaMapper extends Serializable {
    @SelectProvider(type=OpenCommunityAppRelaSqlProvider.class, method="countByExample")
    long countByExample(OpenCommunityAppRelaExample example);

    @DeleteProvider(type=OpenCommunityAppRelaSqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenCommunityAppRelaExample example);

    @Delete({
        "delete from open_community_app_rela",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into open_community_app_rela (community_id, app_id, ",
        "create_time, status, ",
        "update_time, ground_time)",
        "values (#{communityId,jdbcType=BIGINT}, #{appId,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{status,jdbcType=INTEGER}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{groundTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(OpenCommunityAppRela record);

    @InsertProvider(type=OpenCommunityAppRelaSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(OpenCommunityAppRela record);

    @SelectProvider(type=OpenCommunityAppRelaSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.BIGINT),
        @Result(column="app_id", property="appId", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="ground_time", property="groundTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<OpenCommunityAppRela> selectByExample(OpenCommunityAppRelaExample example);

    @Select({
        "select",
        "id, community_id, app_id, create_time, status, update_time, ground_time",
        "from open_community_app_rela",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.BIGINT),
        @Result(column="app_id", property="appId", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="ground_time", property="groundTime", jdbcType=JdbcType.TIMESTAMP)
    })
    OpenCommunityAppRela selectByPrimaryKey(Long id);

    @UpdateProvider(type=OpenCommunityAppRelaSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenCommunityAppRela record, @Param("example") OpenCommunityAppRelaExample example);

    @UpdateProvider(type=OpenCommunityAppRelaSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenCommunityAppRela record, @Param("example") OpenCommunityAppRelaExample example);

    @UpdateProvider(type=OpenCommunityAppRelaSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpenCommunityAppRela record);

    @Update({
        "update open_community_app_rela",
        "set community_id = #{communityId,jdbcType=BIGINT},",
          "app_id = #{appId,jdbcType=BIGINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=INTEGER},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "ground_time = #{groundTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(OpenCommunityAppRela record);
}