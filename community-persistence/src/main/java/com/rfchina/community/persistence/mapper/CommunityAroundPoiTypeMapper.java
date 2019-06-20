package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CommunityAroundPoiType;
import com.rfchina.community.persistence.model.CommunityAroundPoiTypeExample;
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

public interface CommunityAroundPoiTypeMapper extends BaseMapper {
    @SelectProvider(type=CommunityAroundPoiTypeSqlProvider.class, method="countByExample")
    long countByExample(CommunityAroundPoiTypeExample example);

    @DeleteProvider(type=CommunityAroundPoiTypeSqlProvider.class, method="deleteByExample")
    int deleteByExample(CommunityAroundPoiTypeExample example);

    @Delete({
        "delete from community_around_poi_type",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into community_around_poi_type (type, parent_type, ",
        "parent_name, name, ",
        "sort, status, level, ",
        "create_time, update_time, ",
        "pic_url, poi_pic_url)",
        "values (#{type,jdbcType=VARCHAR}, #{parentType,jdbcType=VARCHAR}, ",
        "#{parentName,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
        "#{sort,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, #{level,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{picUrl,jdbcType=VARCHAR}, #{poiPicUrl,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(CommunityAroundPoiType record);

    @InsertProvider(type=CommunityAroundPoiTypeSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(CommunityAroundPoiType record);

    @SelectProvider(type=CommunityAroundPoiTypeSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_type", property="parentType", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_name", property="parentName", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="level", property="level", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="pic_url", property="picUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="poi_pic_url", property="poiPicUrl", jdbcType=JdbcType.VARCHAR)
    })
    List<CommunityAroundPoiType> selectByExample(CommunityAroundPoiTypeExample example);

    @Select({
        "select",
        "id, type, parent_type, parent_name, name, sort, status, level, create_time, ",
        "update_time, pic_url, poi_pic_url",
        "from community_around_poi_type",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_type", property="parentType", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_name", property="parentName", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="level", property="level", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="pic_url", property="picUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="poi_pic_url", property="poiPicUrl", jdbcType=JdbcType.VARCHAR)
    })
    CommunityAroundPoiType selectByPrimaryKey(Long id);

    @UpdateProvider(type=CommunityAroundPoiTypeSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CommunityAroundPoiType record, @Param("example") CommunityAroundPoiTypeExample example);

    @UpdateProvider(type=CommunityAroundPoiTypeSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CommunityAroundPoiType record, @Param("example") CommunityAroundPoiTypeExample example);

    @UpdateProvider(type=CommunityAroundPoiTypeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CommunityAroundPoiType record);

    @Update({
        "update community_around_poi_type",
        "set type = #{type,jdbcType=VARCHAR},",
          "parent_type = #{parentType,jdbcType=VARCHAR},",
          "parent_name = #{parentName,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "sort = #{sort,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "level = #{level,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "pic_url = #{picUrl,jdbcType=VARCHAR},",
          "poi_pic_url = #{poiPicUrl,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(CommunityAroundPoiType record);
}