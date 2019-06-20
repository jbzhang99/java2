package com.rfchina.community.persistence.mapper.ext;

import com.rfchina.community.persistence.mapper.CommunityAroundPoiExtMapper;
import com.rfchina.community.persistence.model.CommunityAroundPoiExt;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;

public interface ExtCommunityAroundPoiExtMapper extends CommunityAroundPoiExtMapper {


    @Select({
            "select",
            "poi_id, rating, cost, native_rating, shop_hours, baidu_detail_url, featured_service, ",
            "sync_status, baidu_uid",
            "from community_around_poi_ext",
            "where sync_status=1 and baidu_uid is not null and baidu_detail_url is not null"
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
    PageList<CommunityAroundPoiExt> pageByExample(PageBounds pageBounds);
}