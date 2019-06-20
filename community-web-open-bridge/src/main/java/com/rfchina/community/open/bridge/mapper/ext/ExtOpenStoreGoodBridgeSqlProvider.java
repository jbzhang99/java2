package com.rfchina.community.open.bridge.mapper.ext;

import java.util.Map;

import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

public class ExtOpenStoreGoodBridgeSqlProvider {

	public String listStoreGood(Map<String, Object> param) {
		StringBuffer sb = new StringBuffer("select g.*");
		sb.append(" from open_store_good g");
		sb.append(" LEFT JOIN community_service s on g.service_id=s.id");
		sb.append(" where g.`status`=1 ");
		sb.append(" and s.id = #{service_id}");
		if (StringUtils.isNotBlank(MapUtils.getString(param, "goodTitle"))) {
			sb.append(" and g.name like #{goodTitle}");
		}
		System.out.println(sb);
		return sb.toString();

	}
}