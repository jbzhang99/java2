package com.rfchina.community.open.bridge.mapper.ext;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.rfchina.community.persistence.mapper.CommunityServiceCategorySqlProvider;
import com.rfchina.community.persistence.model.CommunityServiceCategoryExample;

public class ExtCommunityServiceCategorySqlProvider extends CommunityServiceCategorySqlProvider {

	public String pageCommunityServiceCategory(Map<String, Object> param) {
		CommunityServiceCategoryExample example = (CommunityServiceCategoryExample) param.get("example");
		SQL sql = new SQL();
		if (example != null && example.isDistinct()) {
//			sql.SELECT_DISTINCT("id");
		} else {
//			sql.SELECT("id");
		}
		sql.SELECT("*");
		sql.FROM("community_service_category");
		applyWhere(sql, example, true);

		if (example != null && example.getOrderByClause() != null) {
			sql.ORDER_BY(example.getOrderByClause());
		}

		return sql.toString();
	}
	
	public String pageCategory(Map<String, Object> param) {
		StringBuffer sb = new StringBuffer("SELECT _ca.*, _type.NAME category_type_name  FROM community_service_category _ca LEFT JOIN community_service_category_type _type ON "
				+ " _ca.type=_type.id where _ca.valid_status=1 ");
		if(param.get("type") != null) {
			sb.append(" and _ca.type=#{type}");
		}
		sb.append("	order by create_time desc;");
		return sb.toString();
	}
}
