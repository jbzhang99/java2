package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CommunityAroundPoiExt;
import com.rfchina.community.persistence.model.CommunityAroundPoiExtExample;
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

public interface CommunityAroundPoiExtMapper extends BaseMapper {
    @SelectProvider(type=CommunityAroundPoiExtSqlProvider.class, method="countByExample")
    long countByExample(CommunityAroundPoiExtExample example);

    @DeleteProvider(type=CommunityAroundPoiExtSqlProvider.class, method="deleteByExample")
    int deleteByExample(CommunityAroundPoiExtExample example);

    @Delete({
        "delete from community_around_poi_ext",
        "where poi_id = #{poiId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long poiId);

    @Insert({
        "insert into community_around_poi_ext (poi_id, rating, ",
        "cost, native_rating, ",
        "shop_hours, baidu_detail_url, ",
        "featured_service, sync_status, ",
        "baidu_uid)",
        "values (#{poiId,jdbcType=BIGINT}, #{rating,jdbcType=DOUBLE}, ",
        "#{cost,jdbcType=DOUBLE}, #{nativeRating,jdbcType=DOUBLE}, ",
        "#{shopHours,jdbcType=VARCHAR}, #{baiduDetailUrl,jdbcType=VARCHAR}, ",
        "#{featuredService,jdbcType=VARCHAR}, #{syncStatus,jdbcType=INTEGER}, ",
        "#{baiduUid,jdbcType=VARCHAR})"
    })
    int insert(CommunityAroundPoiExt record);

    @InsertProvider(type=CommunityAroundPoiExtSqlProvider.class, method="insertSelective")
    int insertSelective(CommunityAroundPoiExt record);

    @SelectProvider(type=CommunityAroundPoiExtSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="poi_id", property="poiId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="rating", property="rating", jdbcType=JdbcType.DOUBLE),
        @Result(column="cost", property="cost", jdbcType=JdbcType.DOUBLE),
        @Result(column="native_rating", property="nativeRating", jdbcType=JdbcType.DOUBLE),
        @Result(column="shop_hours", property="shopHours", jdbcType=JdbcType.VARCHAR),
        @Result(column="baidu_detail_url", property="baiduDetailUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="featured_service", property="featuredService", jdbcType=JdbcType.VARCHAR),
        @Result(column="sync_status", property="syncStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="baidu_uid", property="baiduUid", jdbcType=JdbcType.VARCHAR)
    })
    List<CommunityAroundPoiExt> selectByExample(CommunityAroundPoiExtExample example);

    @Select({
        "select",
        "poi_id, rating, cost, native_rating, shop_hours, baidu_detail_url, featured_service, ",
        "sync_status, baidu_uid",
        "from community_around_poi_ext",
        "where poi_id = #{poiId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="poi_id", property="poiId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="rating", property="rating", jdbcType=JdbcType.DOUBLE),
        @Result(column="cost", property="cost", jdbcType=JdbcType.DOUBLE),
        @Result(column="native_rating", property="nativeRating", jdbcType=JdbcType.DOUBLE),
        @Result(column="shop_hours", property="shopHours", jdbcType=JdbcType.VARCHAR),
        @Result(column="baidu_detail_url", property="baiduDetailUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="featured_service", property="featuredService", jdbcType=JdbcType.VARCHAR),
        @Result(column="sync_status", property="syncStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="baidu_uid", property="baiduUid", jdbcType=JdbcType.VARCHAR)
    })
    CommunityAroundPoiExt selectByPrimaryKey(Long poiId);

    @UpdateProvider(type=CommunityAroundPoiExtSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CommunityAroundPoiExt record, @Param("example") CommunityAroundPoiExtExample example);

    @UpdateProvider(type=CommunityAroundPoiExtSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CommunityAroundPoiExt record, @Param("example") CommunityAroundPoiExtExample example);

    @UpdateProvider(type=CommunityAroundPoiExtSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CommunityAroundPoiExt record);

    @Update({
        "update community_around_poi_ext",
        "set rating = #{rating,jdbcType=DOUBLE},",
          "cost = #{cost,jdbcType=DOUBLE},",
          "native_rating = #{nativeRating,jdbcType=DOUBLE},",
          "shop_hours = #{shopHours,jdbcType=VARCHAR},",
          "baidu_detail_url = #{baiduDetailUrl,jdbcType=VARCHAR},",
          "featured_service = #{featuredService,jdbcType=VARCHAR},",
          "sync_status = #{syncStatus,jdbcType=INTEGER},",
          "baidu_uid = #{baiduUid,jdbcType=VARCHAR}",
        "where poi_id = #{poiId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(CommunityAroundPoiExt record);
}