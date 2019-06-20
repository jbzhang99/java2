package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CommunityAroundSearchLog;
import com.rfchina.community.persistence.model.CommunityAroundSearchLogExample;
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

public interface CommunityAroundSearchLogMapper extends BaseMapper {
    @SelectProvider(type=CommunityAroundSearchLogSqlProvider.class, method="countByExample")
    long countByExample(CommunityAroundSearchLogExample example);

    @DeleteProvider(type=CommunityAroundSearchLogSqlProvider.class, method="deleteByExample")
    int deleteByExample(CommunityAroundSearchLogExample example);

    @Delete({
        "delete from community_around_search_log",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into community_around_search_log (type, user_id, ",
        "status, search_key, ",
        "create_time)",
        "values (#{type,jdbcType=VARCHAR}, #{userId,jdbcType=BIGINT}, ",
        "#{status,jdbcType=INTEGER}, #{searchKey,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(CommunityAroundSearchLog record);

    @InsertProvider(type=CommunityAroundSearchLogSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(CommunityAroundSearchLog record);

    @SelectProvider(type=CommunityAroundSearchLogSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="search_key", property="searchKey", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<CommunityAroundSearchLog> selectByExample(CommunityAroundSearchLogExample example);

    @Select({
        "select",
        "id, type, user_id, status, search_key, create_time",
        "from community_around_search_log",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="search_key", property="searchKey", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    CommunityAroundSearchLog selectByPrimaryKey(Long id);

    @UpdateProvider(type=CommunityAroundSearchLogSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CommunityAroundSearchLog record, @Param("example") CommunityAroundSearchLogExample example);

    @UpdateProvider(type=CommunityAroundSearchLogSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CommunityAroundSearchLog record, @Param("example") CommunityAroundSearchLogExample example);

    @UpdateProvider(type=CommunityAroundSearchLogSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CommunityAroundSearchLog record);

    @Update({
        "update community_around_search_log",
        "set type = #{type,jdbcType=VARCHAR},",
          "user_id = #{userId,jdbcType=BIGINT},",
          "status = #{status,jdbcType=INTEGER},",
          "search_key = #{searchKey,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(CommunityAroundSearchLog record);
}