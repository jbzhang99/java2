package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CommunityAroundPoiTypeRelExample;
import com.rfchina.community.persistence.model.CommunityAroundPoiTypeRelKey;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface CommunityAroundPoiTypeRelMapper extends BaseMapper {
    @SelectProvider(type=CommunityAroundPoiTypeRelSqlProvider.class, method="countByExample")
    long countByExample(CommunityAroundPoiTypeRelExample example);

    @DeleteProvider(type=CommunityAroundPoiTypeRelSqlProvider.class, method="deleteByExample")
    int deleteByExample(CommunityAroundPoiTypeRelExample example);

    @Delete({
        "delete from community_around_poi_type_rel",
        "where poi_id = #{poiId,jdbcType=BIGINT}",
          "and type = #{type,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(CommunityAroundPoiTypeRelKey key);

    @Insert({
        "insert into community_around_poi_type_rel (poi_id, type)",
        "values (#{poiId,jdbcType=BIGINT}, #{type,jdbcType=VARCHAR})"
    })
    int insert(CommunityAroundPoiTypeRelKey record);

    @InsertProvider(type=CommunityAroundPoiTypeRelSqlProvider.class, method="insertSelective")
    int insertSelective(CommunityAroundPoiTypeRelKey record);

    @SelectProvider(type=CommunityAroundPoiTypeRelSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="poi_id", property="poiId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR, id=true)
    })
    List<CommunityAroundPoiTypeRelKey> selectByExample(CommunityAroundPoiTypeRelExample example);

    @UpdateProvider(type=CommunityAroundPoiTypeRelSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CommunityAroundPoiTypeRelKey record, @Param("example") CommunityAroundPoiTypeRelExample example);

    @UpdateProvider(type=CommunityAroundPoiTypeRelSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CommunityAroundPoiTypeRelKey record, @Param("example") CommunityAroundPoiTypeRelExample example);
}