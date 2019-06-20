package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CommunityResourceType;
import com.rfchina.community.persistence.model.CommunityResourceTypeExample;
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

public interface CommunityResourceTypeMapper extends Serializable {
    @SelectProvider(type=CommunityResourceTypeSqlProvider.class, method="countByExample")
    long countByExample(CommunityResourceTypeExample example);

    @DeleteProvider(type=CommunityResourceTypeSqlProvider.class, method="deleteByExample")
    int deleteByExample(CommunityResourceTypeExample example);

    @Delete({
        "delete from community_resource_type",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into community_resource_type (id, status, ",
        "title, creater_id, ",
        "create_time, type)",
        "values (#{id,jdbcType=INTEGER}, #{status,jdbcType=TINYINT}, ",
        "#{title,jdbcType=VARCHAR}, #{createrId,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{type,jdbcType=TINYINT})"
    })
    int insert(CommunityResourceType record);

    @InsertProvider(type=CommunityResourceTypeSqlProvider.class, method="insertSelective")
    int insertSelective(CommunityResourceType record);

    @SelectProvider(type=CommunityResourceTypeSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="creater_id", property="createrId", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="type", property="type", jdbcType=JdbcType.TINYINT)
    })
    List<CommunityResourceType> selectByExample(CommunityResourceTypeExample example);

    @Select({
        "select",
        "id, status, title, creater_id, create_time, type",
        "from community_resource_type",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="creater_id", property="createrId", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="type", property="type", jdbcType=JdbcType.TINYINT)
    })
    CommunityResourceType selectByPrimaryKey(Integer id);

    @UpdateProvider(type=CommunityResourceTypeSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CommunityResourceType record, @Param("example") CommunityResourceTypeExample example);

    @UpdateProvider(type=CommunityResourceTypeSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CommunityResourceType record, @Param("example") CommunityResourceTypeExample example);

    @UpdateProvider(type=CommunityResourceTypeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CommunityResourceType record);

    @Update({
        "update community_resource_type",
        "set status = #{status,jdbcType=TINYINT},",
          "title = #{title,jdbcType=VARCHAR},",
          "creater_id = #{createrId,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "type = #{type,jdbcType=TINYINT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CommunityResourceType record);
}