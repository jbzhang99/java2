package com.rfchina.community.persistence.mapper.ext;

import com.rfchina.community.persistence.mapper.OpenGoodShowCategorySqlProvider;

import java.util.Map;

/**
 */
public class ExtOpenGoodShowCategorySqlProvider extends OpenGoodShowCategorySqlProvider {

    public String pageByCondition(Map<String, Object> param) {
    	StringBuffer sql = new StringBuffer(" select * from open_good_show_category where 1=1");
		if(param.get("serviceId") != null) {
			sql.append(" and service_id = #{serviceId} ");
		}
		if(param.get("isShow") != null) {
			sql.append(" and is_show = #{isShow} ");
		}
		sql.append(" order by id desc");
        return sql.toString();
    }

}
