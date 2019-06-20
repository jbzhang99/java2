package com.rfchina.community.open.bridge.mapper.ext;

import java.util.Map;

import com.rfchina.community.persistence.mapper.CommunityServiceCommentSqlProvider;

public class ExtCommunityServiceCommentSqlProvider extends CommunityServiceCommentSqlProvider{

	
	public String pageCommunityServiceCommnet(Map<String, Object> param){
		StringBuffer sb  = new StringBuffer("select t.*,d.`name` as community_name,a.phone as user_phone,b.`name` as area_name from community_service_comment t join community d on t.community_id=d.id join user_info a on t.uid=a.id left join area b on d.area_id=b.id where 1=1 ");
		
		if(param.get("serviceId") != null){
			sb.append(" and t.service_id = #{serviceId}");
		}
        
        return sb.toString();
	}
}
