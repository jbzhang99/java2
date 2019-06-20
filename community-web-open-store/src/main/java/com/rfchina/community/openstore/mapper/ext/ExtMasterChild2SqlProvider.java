package com.rfchina.community.openstore.mapper.ext;

import com.rfchina.community.persistence.mapper.MasterChildSqlProvider;

import java.util.Map;

/**
 */
public class ExtMasterChild2SqlProvider extends MasterChildSqlProvider {
	public String listAuthAddress(Map<String, Object> param) {
		StringBuilder sb = new StringBuilder("select child.name first_name, child.phone first_phone, community.city_id, community.area_id,community.city_name, community.name,info.loudong, "
				+ " info.floor,info.room,community.id community_id,info.type,info.title  from master_child child " + 
				"	LEFT JOIN master_info info on child.master_id=info.id " + 
				"	LEFT JOIN community community on child.community_id=community.id " + 
				"	where community.status = 1 and community.category=1 and child.status=1 and info.status=1 ");
			sb.append(" and child.uid = #{uid}");
		sb.append(" order by child.id desc limit 20");
		return sb.toString();
	}

}
