package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CommunityAroundPoiData;
import com.rfchina.community.persistence.model.CommunityAroundPoiDataExample;
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

public interface CommunityAroundPoiDataMapper extends BaseMapper {
    @SelectProvider(type=CommunityAroundPoiDataSqlProvider.class, method="countByExample")
    long countByExample(CommunityAroundPoiDataExample example);

    @DeleteProvider(type=CommunityAroundPoiDataSqlProvider.class, method="deleteByExample")
    int deleteByExample(CommunityAroundPoiDataExample example);

    @Delete({
        "delete from community_around_poi_data",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into community_around_poi_data (id, community_id, ",
        "type_id, data, status)",
        "values (#{id,jdbcType=VARCHAR}, #{communityId,jdbcType=BIGINT}, ",
        "#{typeId,jdbcType=BIGINT}, #{data,jdbcType=VARCHAR}, #{status,jdbcType=INTEGER})"
    })
    int insert(CommunityAroundPoiData record);

    @InsertProvider(type=CommunityAroundPoiDataSqlProvider.class, method="insertSelective")
    int insertSelective(CommunityAroundPoiData record);

    @SelectProvider(type=CommunityAroundPoiDataSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.BIGINT),
        @Result(column="type_id", property="typeId", jdbcType=JdbcType.BIGINT),
        @Result(column="data", property="data", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    })
    List<CommunityAroundPoiData> selectByExample(CommunityAroundPoiDataExample example);

    @Select({
        "select",
        "id, community_id, type_id, data, status",
        "from community_around_poi_data",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.BIGINT),
        @Result(column="type_id", property="typeId", jdbcType=JdbcType.BIGINT),
        @Result(column="data", property="data", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    })
    CommunityAroundPoiData selectByPrimaryKey(String id);

    @UpdateProvider(type=CommunityAroundPoiDataSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CommunityAroundPoiData record, @Param("example") CommunityAroundPoiDataExample example);

    @UpdateProvider(type=CommunityAroundPoiDataSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CommunityAroundPoiData record, @Param("example") CommunityAroundPoiDataExample example);

    @UpdateProvider(type=CommunityAroundPoiDataSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CommunityAroundPoiData record);

    @Update({
        "update community_around_poi_data",
        "set community_id = #{communityId,jdbcType=BIGINT},",
          "type_id = #{typeId,jdbcType=BIGINT},",
          "data = #{data,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(CommunityAroundPoiData record);
}