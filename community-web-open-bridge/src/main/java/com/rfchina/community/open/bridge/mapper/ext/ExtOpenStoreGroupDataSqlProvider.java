package com.rfchina.community.open.bridge.mapper.ext;

import com.rfchina.community.persistence.mapper.OpenStoreGroupDataSqlProvider;

import java.util.Map;

/**
 */
public class ExtOpenStoreGroupDataSqlProvider extends OpenStoreGroupDataSqlProvider {
	public String pageByCondition(Map<String, Object> param){
		StringBuffer sb = new StringBuffer("select  _data.*,_service.title service_name, _good.name good_name from open_store_group_data _data" +
				"	LEFT JOIN open_store_good_group_info _info ON _data.good_group_id=_info.id" +
				"	LEFT JOIN open_store_good _good ON _good.id=_data.good_id LEFT JOIN community_service _service ON _service.id=_good.service_id where 1=1 ");

		if(param.get("groupInfoId") != null){
			sb.append(" and _data.good_group_id= #{groupInfoId}");
		}
		if(param.get("id") != null){
			sb.append(" and _data.id= #{id}");
		}
		if(param.get("goodName") != null){
			sb.append(" and _good.name like #{goodName}");
		}
		if(param.get("serviceName") != null){
			sb.append(" and _service.title like #{serviceName}");
		}
		if(param.get("phone") != null){
			sb.append(" and _data.phone like #{phone}");
		}

		if(param.get("status") != null){
			sb.append(" and _data.status = #{status}");
		}

		if(param.get("startDate") != null && param.get("endDate") != null){
			sb.append(" and _data.create_time >= #{startDate} and _data.create_time <= #{endDate}");
		}

		if(param.get("startSuccessDate") != null && param.get("endSuccessDate") != null){
			sb.append(" and _data.success_time >= #{startSuccessDate} and _data.success_time <= #{endSuccessDate}");
		}

		sb.append(" order by _data.id desc ");
		
		return sb.toString();
	}
	
}
