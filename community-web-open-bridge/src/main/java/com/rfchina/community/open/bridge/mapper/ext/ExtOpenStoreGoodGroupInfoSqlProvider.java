package com.rfchina.community.open.bridge.mapper.ext;

import com.rfchina.community.base.OpenGoodGroupConstant;
import com.rfchina.community.persistence.mapper.OpenStoreGoodGroupInfoSqlProvider;

import java.util.Map;

/**
 */
public class ExtOpenStoreGoodGroupInfoSqlProvider extends OpenStoreGoodGroupInfoSqlProvider {
	public String pageByCondition(Map<String, Object> param){
		StringBuffer sb = new StringBuffer("select _info.*,_good.name good_name, _service.title service_name, _merchant.title merchant_name" +
				"  from open_store_good_group_info _info LEFT JOIN open_store_good _good on _good.id=_info.good_id " +
				"	LEFT JOIN community_service _service on _service.id=_good.service_id " +
				"	LEFT JOIN open_merchant_info _merchant on _merchant.id=_service.merchant_id where 1=1 ");
		
		if(param.get("goodName") != null){
			sb.append(" and _good.name like #{goodName}");
		}
		if(param.get("serviceName") != null){
			sb.append(" and _service.title like #{serviceName}");
		}
		if(param.get("merchantName") != null){
			sb.append(" and _merchant.title like #{merchantName}");
		}

		if(param.get("status") != null){
			sb.append(" and _info.status = #{status}");
		}

		if(param.get("groupInfoStatus") != null){
			int groupInfoStatus = (int)param.get("groupInfoStatus");
			if(groupInfoStatus == OpenGoodGroupConstant.groupInfoStatus.un_start){
				sb.append(" and _info.start_time > now()");
			}else if(groupInfoStatus == OpenGoodGroupConstant.groupInfoStatus.over){
				sb.append(" and _info.end_time < now()");
			}else{
				sb.append(" and _info.end_time >= now() and _info.start_time <= now()");
			}
		}
		sb.append(" order by _info.id desc ");
		
		return sb.toString();
	}
	
}
