package com.rfchina.community.open.bridge.mapper.ext;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.rfchina.community.persistence.mapper.CommunityResourceSqlProvider;
import com.rfchina.community.persistence.model.CommunityResourceExample;

public class ExtCommunityResourceSqlProvider extends CommunityResourceSqlProvider{
	
	public String pageByExample(Map<String, Object> param) {
		CommunityResourceExample example = (CommunityResourceExample) param.get("example");
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("city_id");
        sql.SELECT("community_id");
        sql.SELECT("resource_type_id");
        sql.SELECT("addr_detail");
        sql.SELECT("resource_desc");
        sql.SELECT("resource_total");
        sql.SELECT("resource_used");
        sql.SELECT("resource_fee");
        sql.SELECT("imgs");
        sql.SELECT("resource_status");
        sql.SELECT("create_time");
        sql.SELECT("creater_id");
        sql.SELECT("modify_time");
        sql.SELECT("modifier_id");
        sql.FROM("community_resource");
        applyWhere(sql, example, true);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

	public String getByActivityId(Long activityId) {
		StringBuffer sb = new StringBuffer("select cr.id, cr.city_id, cr.community_id, crt.title resource_type_title, cr.addr_detail, cr.resource_desc, cr.resource_fee, cr.imgs " +
				"from community_resource cr " +
				"LEFT JOIN community_resource_activity_rela craRela on cr.community_id = cr.community_id " +
				"LEFT JOIN community_resource_type crt on crt.id = cr.resource_type_id " +
				"where craRela.activity_id = #{activityId ,jdbcType=BIGINT} and cr.`resource_status` = '1' ");   
        return sb.toString();
    }
	
}
