package com.rfchina.community.openweb.mapper.ext;

import java.util.Map;

import com.rfchina.community.persistence.mapper.OpenManagerInviteSqlProvider;

public class ExtOpenManagerInviteSqlProvider extends OpenManagerInviteSqlProvider{
	
	public String pageByCondition(Map<String, Object> param) {
		
		
		StringBuffer sb = new StringBuffer("select  distinct(ominvi.phone), ominvi.emp_name, ominvi.emp_guid, COUNT(ominvi.phone) merchant_count from open_manager_invite ominvi where status = '1' ");
		if(null != param.get("phone")) {
			sb.append(" and ominvi.phone = #{phone ,jdbcType=VARCHAR}");
		}
		sb.append(" group by ominvi.phone");
		return sb.toString();
	}
	
	
	public String queryDetailsByPhone(String phone) {
		StringBuffer sb = new StringBuffer("select ominfo.id merchant_id, ominfo.title merchant_title, cs.title service_title, ominfo.create_time create_time " +
				"from open_merchant_info ominfo " +
				"LEFT JOIN community_service cs on ominfo.id = cs.merchant_id " +
				"where exists(select ominvi.id from open_manager_invite ominvi where ominvi.merchant_id = ominfo.id and ominvi.service_id = cs.id and ominvi.`status` = '1' ");
		sb.append(" and ominvi.phone = #{phone ,jdbcType=VARCHAR}) ");
		sb.append("ORDER BY ominfo.id asc");
		return sb.toString();
	}
}
