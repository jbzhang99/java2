package com.rfchina.community.openstore.mapper.ext;

import java.util.Map;

import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

import com.rfchina.community.persistence.mapper.OpenXFSJStoreSqlProvider;

/**
 */
public class ExtOpenXFSJStoreSqlProvider extends OpenXFSJStoreSqlProvider {
	
	public String getStoreIdList(Map<String, Object> param){
		return new StringBuffer().append("	SELECT 	DISTINCT _store.store_id   FROM open_xfsj_store _store, open_xfsj_store_good _good ")
				.append("	WHERE _good.store_id = _store.store_id AND _store.xfsj_id = _good.xfsj_id AND _store.xfsj_id = ")
				.append(param.get("xfsjId"))
				.append("	AND _good.type= ")
				.append(param.get("type"))
				.append(" order by _store.orderby desc, _store.create_time ").toString();
	}
	
	public String getPlatformActivityStoreIdList(Map<String, Object> param){
		return new StringBuffer().append("	SELECT	DISTINCT _store.store_id  FROM 	open_xfsj_store _store 	WHERE _store.xfsj_id = ")
				.append(param.get("xfsjId"))
				.append("  order by _store.orderby desc, _store.create_time ").toString();
	}
	
	
	public String searchService(Map<String, Object> param) {
        String likeKeyWords = MapUtils.getString(param, "likeKeyWords", "");

        StringBuilder sqlBuilder = new StringBuilder(" SELECT");
        sqlBuilder.append(" _service.id service_id, _service.title, _service.png, _service.user_range, _service.description service_description, _service.type, _service.provide_type ");
        sqlBuilder.append(" FROM ");
        sqlBuilder.append(" community_service _service "
        		+ " LEFT JOIN open_service_detail _detail ON _detail.service_id = _service.id "
        		+ " LEFT JOIN open_service_extend  _extend on _extend.id=_service.id ");
        sqlBuilder.append(" WHERE ");
        sqlBuilder.append(" _service.STATUS = 1 ");

        if (StringUtils.isNotBlank(likeKeyWords)) {
            sqlBuilder.append(" AND (_service.title like  #{likeKeyWords, jdbcType=VARCHAR} ");
            sqlBuilder.append(" OR _extend.keyword Like #{likeKeyWords, jdbcType=VARCHAR}) ");
        }
        sqlBuilder.append(" ORDER BY _service.type, _detail.app_cat_sort, _service.id DESC ");

        return sqlBuilder.toString();
    }
}
