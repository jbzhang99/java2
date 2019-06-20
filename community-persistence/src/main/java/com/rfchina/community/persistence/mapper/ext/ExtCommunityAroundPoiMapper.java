package com.rfchina.community.persistence.mapper.ext;

import com.rfchina.community.persistence.mapper.CommunityAroundPoiMapper;
import com.rfchina.community.persistence.model.ext.ExtCommunityAroundPoi;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;

import java.util.List;
import java.util.Map;

public interface ExtCommunityAroundPoiMapper extends CommunityAroundPoiMapper {

    @Select({
            "select",
            "_poi.id,  _poi.name, _poi.address, _poi.longitude, _poi.latitude,_ext.baidu_uid ",
            "from community_around_poi _poi",
            "inner join community_around_poi_ext _ext on _poi.id=_ext.poi_id",
            "where _poi.sync_status=1 and _ext.sync_status=-1 limit 100"
    })
    @Results({
            @Result(column="id", property="id", jdbcType= JdbcType.BIGINT, id=true),

            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
            @Result(column="longitude", property="longitude", jdbcType=JdbcType.VARCHAR),
            @Result(column="latitude", property="latitude", jdbcType=JdbcType.VARCHAR),
            @Result(column="baidu_uid", property="ext.baiduUid", jdbcType=JdbcType.VARCHAR)

    })
    List<ExtCommunityAroundPoi> getUnSyncPoiExtCommunity();

    @Select({
            "select",
            "_poi.id,  _poi.name, _poi.address, _poi.longitude, _poi.latitude ",
            "from community_around_poi _poi",
            "where _poi.sync_status=-1 limit 100"
    })
    @Results({
            @Result(column="id", property="id", jdbcType= JdbcType.BIGINT, id=true),

            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
            @Result(column="longitude", property="longitude", jdbcType=JdbcType.VARCHAR),
            @Result(column="latitude", property="latitude", jdbcType=JdbcType.VARCHAR)

    })
    List<ExtCommunityAroundPoi> getUnSyncPoi();


    @SelectProvider(type = ExtCommunityAroundPoiSqlProvider.class,method = "page")
    @Results({
            @Result(column="id", property="id", jdbcType= JdbcType.BIGINT),
            @Result(column="api_id", property="apiId", jdbcType=JdbcType.VARCHAR),
            @Result(column="api_type", property="apiType", jdbcType=JdbcType.VARCHAR),
            @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
            @Result(column="pic_url", property="picUrl", jdbcType=JdbcType.VARCHAR),
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
            @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
            @Result(column="longitude", property="longitude", jdbcType=JdbcType.VARCHAR),
            @Result(column="latitude", property="latitude", jdbcType=JdbcType.VARCHAR),
            @Result(column="tel", property="tel", jdbcType=JdbcType.VARCHAR),
            @Result(column="post_code", property="postCode", jdbcType=JdbcType.VARCHAR),
            @Result(column="web_site", property="webSite", jdbcType=JdbcType.VARCHAR),
            @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
            @Result(column="province_code", property="provinceCode", jdbcType=JdbcType.VARCHAR),
            @Result(column="province_name", property="provinceName", jdbcType=JdbcType.VARCHAR),
            @Result(column="city_code", property="cityCode", jdbcType=JdbcType.VARCHAR),
            @Result(column="city_name", property="cityName", jdbcType=JdbcType.VARCHAR),
            @Result(column="ad_code", property="adCode", jdbcType=JdbcType.VARCHAR),
            @Result(column="ad_name", property="adName", jdbcType=JdbcType.VARCHAR),
            @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),

            @Result(column="t_type", property="poiType.type", jdbcType=JdbcType.VARCHAR),
            @Result(column="t_parent_type", property="poiType.parentType", jdbcType=JdbcType.VARCHAR),
            @Result(column="t_parent_name", property="poiType.parentName", jdbcType=JdbcType.VARCHAR),
            @Result(column="t_name", property="poiType.name", jdbcType=JdbcType.VARCHAR),

            @Result(column="ext_rating", property="ext.rating", jdbcType=JdbcType.DOUBLE),
            @Result(column="ext_cost", property="ext.cost", jdbcType=JdbcType.DOUBLE)

    })
    PageList<ExtCommunityAroundPoi> page(Map param, PageBounds pageBounds);

    @SelectProvider(type = ExtCommunityAroundPoiSqlProvider.class,method = "getPoiById")
    @Results({
            @Result(column="api_type", property="apiType", jdbcType=JdbcType.VARCHAR),
            @Result(column="pic_url", property="picUrl", jdbcType=JdbcType.VARCHAR),
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
            @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
            @Result(column="longitude", property="longitude", jdbcType=JdbcType.VARCHAR),
            @Result(column="latitude", property="latitude", jdbcType=JdbcType.VARCHAR),
            @Result(column="tel", property="tel", jdbcType=JdbcType.VARCHAR),
            @Result(column="post_code", property="postCode", jdbcType=JdbcType.VARCHAR),
            @Result(column="web_site", property="webSite", jdbcType=JdbcType.VARCHAR),
            @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
            @Result(column="province_name", property="provinceName", jdbcType=JdbcType.VARCHAR),
            @Result(column="city_name", property="cityName", jdbcType=JdbcType.VARCHAR),
            @Result(column="ad_name", property="adName", jdbcType=JdbcType.VARCHAR),

            @Result(column="type_name", property="poiType.name", jdbcType=JdbcType.VARCHAR),
            @Result(column="type_parent_name", property="poiType.parentName", jdbcType=JdbcType.VARCHAR),
            @Result(column="type_poi_pic_url", property="poiType.poiPicUrl", jdbcType=JdbcType.VARCHAR),

            @Result(column="ext_featured_service", property="ext.featuredService", jdbcType=JdbcType.VARCHAR),
            @Result(column="ext_shop_hours", property="ext.shopHours", jdbcType=JdbcType.VARCHAR),
            @Result(column="ext_rating", property="ext.rating", jdbcType=JdbcType.DOUBLE),
            @Result(column="ext_cost", property="ext.cost", jdbcType=JdbcType.DOUBLE)

    })
    ExtCommunityAroundPoi getPoiById(@Param("poiId")Long poiId);

    @SelectProvider(type = ExtCommunityAroundPoiSqlProvider.class,method = "searchPoi")
    @Results({
            @Result(column="id", property="id", jdbcType= JdbcType.BIGINT),
            @Result(column="api_type", property="apiType", jdbcType=JdbcType.VARCHAR),
            @Result(column="pic_url", property="picUrl", jdbcType=JdbcType.VARCHAR),
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
            @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),

            @Result(column="poi_rel_distance", property="poiRel.distance", jdbcType=JdbcType.DOUBLE),

            @Result(column="ext_rating", property="ext.rating", jdbcType=JdbcType.DOUBLE),
            @Result(column="ext_cost", property="ext.cost", jdbcType=JdbcType.DOUBLE)

    })
    PageList<ExtCommunityAroundPoi> searchPoi(Map<String, Object> param, PageBounds pageBounds);
}