package com.rfchina.community.persistence.mapper.ext;

import com.rfchina.community.persistence.mapper.CommunityAroundUpdatePlanSqlProvider;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class ExtCommunityAroundUpdatePlanSqlProvider extends CommunityAroundUpdatePlanSqlProvider {



    public String pageByExample(Map map) {
        SQL sql = new SQL();
        sql.SELECT("community_id");
        sql.SELECT("type_id");
        sql.SELECT("status");
        sql.SELECT("type_code");
        sql.FROM("community_around_update_plan");
        Object status = map.get("status");
        if(status != null){
            sql.WHERE("status = "+status);
        }
        sql.ORDER_BY("community_id desc");
        return sql.toString();
    }




}