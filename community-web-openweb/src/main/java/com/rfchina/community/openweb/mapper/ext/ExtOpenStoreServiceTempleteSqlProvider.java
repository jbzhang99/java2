package com.rfchina.community.openweb.mapper.ext;

import java.util.Map;

import org.apache.commons.collections.MapUtils;

import com.rfchina.community.persistence.mapper.OpenStoreServiceTempleteSqlProvider;

/**
 */
public class ExtOpenStoreServiceTempleteSqlProvider extends OpenStoreServiceTempleteSqlProvider {
	public String getTempleteList(Map<String, Object> param){
		StringBuffer sb =
				new StringBuffer("SELECT" + 
						"	_detail.service_id, _service.title" + 
						"	FROM" + 
						"	open_service_detail _detail, community_service_temp _service" + 
						"	WHERE" + 
						"	_service.id = _detail.service_id  and _detail.develop_type='TEMPLETE' and _service.caution_money_status!=2 and status<>4");
		
		sb.append(" and merchant_id = #{merchantId}");
		
		if(MapUtils.getInteger(param, "templeteStatus", 0) == 1){
			sb.append(" and _detail.templete_status = #{templeteStatus}");
		}
		if(param.get("type") != null) {
			sb.append(" and _detail.templete_name = #{type}");
		}
		
		sb.append(" order by id desc");
		
		return sb.toString();
	}
}
