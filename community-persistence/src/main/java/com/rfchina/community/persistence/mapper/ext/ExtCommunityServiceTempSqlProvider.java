package com.rfchina.community.persistence.mapper.ext;

import java.util.Map;

public class ExtCommunityServiceTempSqlProvider {

	public String getCommunityServiceTemp(Map<String, Object> param) {
		StringBuffer sb = new StringBuffer(
				"select t.*,b.`name` as category_name,d.title as merchant_name,d.type as merchant_type,c.like_count,c.unlike_count,(select count(1) from community_service_rela_temp k where k.service_id=t.id and k.`status`=1) as community_added_count , (select count(1) from community_service_rela_temp h where h.service_id=t.id ) as community_count from community_service_temp t join open_merchant_info d on t.merchant_id=d.id join community_service_category b on t.category_id=b.id left join community_service_count c on t.id=c.service_id where 1=1 and t.status!=4 ");

		if(param.get("id") != null){
			sb.append(" and t.id = #{id}");
		}
		
		if(param.get("title") != null){
			sb.append(" and t.title like #{title}");
		}
		
		if(param.get("merchantName") != null){
			sb.append(" and d.title like #{merchantName}");
		}
		
		if(param.get("merchantId") != null){
			sb.append(" and d.id = #{merchantId}");
		}
		
		if(param.get("categoryId") != null){
			sb.append(" and t.category_id = #{categoryId}");
		}
		
		if(param.get("status") != null){
			sb.append(" and t.status = #{status}");
		}else{
			sb.append(" and t.status != 4 ");
		}
		
		if(param.get("startCreateTime") != null){
			sb.append(" and t.create_time >= #{startCreateTime}");
		}
		
		if(param.get("endCreateTime") != null){
			sb.append(" and t.create_time <= #{endCreateTime}");
		}
		
		return sb.toString();
	}
}
