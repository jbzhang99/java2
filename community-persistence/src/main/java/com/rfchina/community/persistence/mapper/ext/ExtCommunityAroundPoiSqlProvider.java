package com.rfchina.community.persistence.mapper.ext;

import com.rfchina.community.persistence.mapper.CommunityAroundPoiSqlProvider;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class ExtCommunityAroundPoiSqlProvider extends CommunityAroundPoiSqlProvider {


    public String page(Map map) {
        SQL sql = new SQL();
        sql.SELECT("_p.id");
        sql.SELECT("_p.api_id");
        sql.SELECT("_p.status");
        sql.SELECT("_p.api_type");
        sql.SELECT("_p.pic_url");
        sql.SELECT("_p.name");
        sql.SELECT("_p.address");
        sql.SELECT("_p.longitude");
        sql.SELECT("_p.latitude");
        sql.SELECT("_p.tel");
        sql.SELECT("_p.post_code");
        sql.SELECT("_p.web_site");
        sql.SELECT("_p.email");
        sql.SELECT("_p.province_code");
        sql.SELECT("_p.province_name");
        sql.SELECT("_p.city_code");
        sql.SELECT("_p.city_name");
        sql.SELECT("_p.ad_code");
        sql.SELECT("_p.ad_name");
        sql.SELECT("_p.create_time");
        sql.SELECT("_p.update_time");
        sql.FROM("community_around_poi _p");
        sql.SELECT("_t.type t_type,_t.parent_type t_parent_type,_t.parent_name t_parent_name,_t.name t_name");
        sql.JOIN("community_around_poi_type _t ON _t.type = _p.type ");
        sql.SELECT("_ext.rating ext_rating,_ext.cost ext_cost");
        sql.LEFT_OUTER_JOIN("community_around_poi_ext _ext ON _ext.poi_id = _p.id ");
        if (map != null && !map.isEmpty()) {
            StringBuffer sb = new StringBuffer();
            if (map.get("cityCode") != null) {
                sb.append("and  _p.city_code = #{cityCode} ");
            }
            if (map.get("posStatus") != null) {
                sb.append("and  _p.status = #{posStatus} ");
            }
            if (map.get("communityId") != null) {
                sql.JOIN("community_around_poi_rel _pr ON _p.id = _pr.poi_id ");
                sb.append("and  _pr.community_id = #{communityId} ");
            }
            if (map.get("firstType") != null) {
                sb.append("and  _t.parent_type = #{firstType} ");
            }
            if (map.get("secondType") != null) {
                sb.append("and  _p.type = #{secondType} ");
            }
            if (map.get("name") != null) {
                sb.append("and  _p.name like '%" + map.get("name") + "%' ");
            }
            if (sb.length() > 0) {
                sql.WHERE(sb.delete(0, 3).toString());
            }
        }
        sql.ORDER_BY("_p.id desc");
        return sql.toString();
    }


    public String getPoiById() {
        SQL sql = new SQL();
        sql.SELECT("_p.api_type");
        sql.SELECT("_p.pic_url");
        sql.SELECT("_p.name");
        sql.SELECT("_p.address");
        sql.SELECT("_p.longitude");
        sql.SELECT("_p.latitude");
        sql.SELECT("_p.tel");
        sql.SELECT("_p.post_code");
        sql.SELECT("_p.web_site");
        sql.SELECT("_p.email");
        sql.SELECT("_p.province_name");
        sql.SELECT("_p.city_name");
        sql.SELECT("_p.ad_name");
        sql.FROM("community_around_poi _p");
        sql.SELECT("_ext.rating ext_rating,_ext.cost ext_cost,_ext.shop_hours ext_shop_hours,_ext.featured_service ext_featured_service ");
        sql.LEFT_OUTER_JOIN("community_around_poi_ext _ext ON _ext.poi_id = _p.id ");
        sql.SELECT("_type.name type_name,_type.parent_name type_parent_name,_type.poi_pic_url type_poi_pic_url ");
        sql.LEFT_OUTER_JOIN("community_around_poi_type _type ON _type.type = _p.type ");
        sql.WHERE("_p.id = #{poiId}");
        return sql.toString();
    }

    public String searchPoi(Map<String,Object> map){
        SQL sql = new SQL();
        sql.SELECT("_p.id");
        sql.SELECT("_p.api_type");
        sql.SELECT("_p.pic_url");
        sql.SELECT("_p.name");
        sql.SELECT("_p.address");
        sql.FROM("community_around_poi _p");
        sql.SELECT("_ext.rating ext_rating,_ext.cost ext_cost ");
        sql.LEFT_OUTER_JOIN("community_around_poi_ext _ext ON _ext.poi_id = _p.id ");
        sql.SELECT("_pr.distance poi_rel_distance");
        sql.LEFT_OUTER_JOIN(" LEFT JOIN community_around_poi_rel _pr ON _pr.poi_id = _p.id ");
        StringBuilder condition = new StringBuilder("_pr.community_id = #{communityId} ");
        if (map != null && !map.isEmpty()) {
            if (map.get("name") != null) {
                condition.append("and _p.name like '" + map.get("name") + "%' ");
            }
            if (map.get("type") != null) {
                condition.append("and _p.type = #{type} ");
            }
            if (map.get("sortBy") != null) {
                Integer sortBy = (Integer)map.get("sortBy");
                if(sortBy == 1){
                    sql.ORDER_BY(" _pr.distance asc");
                }else if(sortBy == 2){
                    sql.ORDER_BY(" _ext.rating desc");
                }
            }
        }
        return sql.toString();
    }
}