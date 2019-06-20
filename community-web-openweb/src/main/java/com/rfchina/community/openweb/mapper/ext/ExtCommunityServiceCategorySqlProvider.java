package com.rfchina.community.openweb.mapper.ext;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.rfchina.community.persistence.mapper.CommunityServiceCategorySqlProvider;
import com.rfchina.community.persistence.model.CommunityAdminExample;
import com.rfchina.community.persistence.model.CommunityServiceCategoryExample;

public class ExtCommunityServiceCategorySqlProvider extends CommunityServiceCategorySqlProvider {
 
	public String pageCommunityServiceCategory(Map<String, Object> param) {
		CommunityServiceCategoryExample example = (CommunityServiceCategoryExample) param.get("example");
		SQL sql = new SQL();
		if (example != null && example.isDistinct()) {
			sql.SELECT_DISTINCT("id");
		} else {
			sql.SELECT("id");
		}
		sql.SELECT("name");
		sql.SELECT("create_time");
		sql.SELECT("type");
		sql.FROM("community_service_category");
		applyWhere(sql, example, true);

		if (example != null && example.getOrderByClause() != null) {
			sql.ORDER_BY(example.getOrderByClause());
		}

		return sql.toString();
	}
}
