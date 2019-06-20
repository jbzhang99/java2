package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CommunityAroundPoiTag;
import com.rfchina.community.persistence.model.CommunityAroundPoiTagExample;
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

public interface CommunityAroundPoiTagMapper extends BaseMapper {
    @SelectProvider(type=CommunityAroundPoiTagSqlProvider.class, method="countByExample")
    long countByExample(CommunityAroundPoiTagExample example);

    @DeleteProvider(type=CommunityAroundPoiTagSqlProvider.class, method="deleteByExample")
    int deleteByExample(CommunityAroundPoiTagExample example);

    @Delete({
        "delete from community_around_poi_tag",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into community_around_poi_tag (name, sort, ",
        "status, create_time)",
        "values (#{name,jdbcType=VARCHAR}, #{sort,jdbcType=INTEGER}, ",
        "#{status,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(CommunityAroundPoiTag record);

    @InsertProvider(type=CommunityAroundPoiTagSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(CommunityAroundPoiTag record);

    @SelectProvider(type=CommunityAroundPoiTagSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<CommunityAroundPoiTag> selectByExample(CommunityAroundPoiTagExample example);

    @Select({
        "select",
        "id, name, sort, status, create_time",
        "from community_around_poi_tag",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    CommunityAroundPoiTag selectByPrimaryKey(Long id);

    @UpdateProvider(type=CommunityAroundPoiTagSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CommunityAroundPoiTag record, @Param("example") CommunityAroundPoiTagExample example);

    @UpdateProvider(type=CommunityAroundPoiTagSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CommunityAroundPoiTag record, @Param("example") CommunityAroundPoiTagExample example);

    @UpdateProvider(type=CommunityAroundPoiTagSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CommunityAroundPoiTag record);

    @Update({
        "update community_around_poi_tag",
        "set name = #{name,jdbcType=VARCHAR},",
          "sort = #{sort,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(CommunityAroundPoiTag record);

}