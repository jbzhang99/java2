package com.rfchina.community.persistence.mapper.ext;

import com.rfchina.community.persistence.mapper.CommunityAroundSqlProvider;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class ExtCommunityAroundSqlProvider extends CommunityAroundSqlProvider {


    public String page(Map map) {
        SQL sql = new SQL();
        sql.SELECT("id");
        sql.SELECT("city");
        sql.SELECT("city_name");
        sql.SELECT("status");
        sql.SELECT("name");
        sql.SELECT("longitude");
        sql.SELECT("latitude");
        sql.SELECT("create_time");
        sql.SELECT("update_time");
        sql.FROM("community_around");
        if(map != null && !map.isEmpty()){
            if(map.get("communityId") != null){
                sql.WHERE("id = "+map.get("communityId"));
            }else if(map.get("communityIds") != null){
                sql.WHERE("id in ("+map.get("communityIds")+")");
            }else if(map.get("city") != null){
                sql.WHERE("city = "+map.get("city"));
            }
        }
        return sql.toString();
    }


}