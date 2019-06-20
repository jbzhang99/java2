package com.rfchina.community.persistence.mapper.ext;

import com.rfchina.community.persistence.mapper.BuildingInfoSqlProvider;
import com.rfchina.community.persistence.model.BuildingInfoExample;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 */
public class ExtBuildingInfoSqlProvider extends BuildingInfoSqlProvider {

    public String pageByExample(Map<String, Object> param) {
        BuildingInfoExample example = (BuildingInfoExample) param.get("example");
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("area_id");
        sql.SELECT("community_id");
        sql.SELECT("name");
        sql.SELECT("address");
        sql.SELECT("prop_type");
        sql.SELECT("status");
        sql.SELECT("remark");
        sql.SELECT("create_time");
        sql.SELECT("update_time");
        sql.FROM("building_info");
        applyWhere(sql, example, true);

        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }

        return sql.toString();
    }
}
