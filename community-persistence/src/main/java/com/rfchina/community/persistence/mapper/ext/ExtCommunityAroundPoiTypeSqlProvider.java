package com.rfchina.community.persistence.mapper.ext;

import com.rfchina.community.persistence.mapper.CommunityAroundPoiTypeSqlProvider;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class ExtCommunityAroundPoiTypeSqlProvider extends CommunityAroundPoiTypeSqlProvider {


    public String page(Map map) {
        SQL sql = new SQL();
        sql.SELECT("_s.id");
        sql.SELECT("_s.type");
        sql.SELECT("_s.parent_type,_s.parent_name");
        sql.SELECT("_s.name");
        sql.SELECT("_s.sort");
        sql.SELECT("_s.status");
        sql.SELECT("_s.level");
        sql.SELECT("_s.pic_url");
        sql.SELECT("_s.poi_pic_url");
        sql.SELECT("_f.sort parentSort");
        sql.SELECT("GROUP_CONCAT(_t.type separator '|') as poiType");
        sql.FROM("  community_around_poi_type _f,community_around_poi_type _s");
        sql.LEFT_OUTER_JOIN(" community_around_poi_type _t on _t.parent_type = _s.type");
        sql.WHERE("  _s.`level` = 2 AND _s.parent_type = _f.type ");
        sql.GROUP_BY(" _s.id ");
        if(map != null && !map.isEmpty()){
            if(map.get("firstType") != null){
                sql.WHERE( " _f.type = "+map.get("firstType"));
            }
            if(map.get("secondType") != null){
                sql.WHERE(" _s.type = "+map.get("secondType"));
            }
            if(map.get("status") != null){
                sql.WHERE(" _s.status = "+map.get("status"));
            }
        }
        sql.ORDER_BY( "_f.sort ASC,_s.sort ASC");
        return sql.toString();
    }


}