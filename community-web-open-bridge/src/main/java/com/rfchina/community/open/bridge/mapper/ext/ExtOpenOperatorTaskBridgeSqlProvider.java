package com.rfchina.community.open.bridge.mapper.ext;

import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class ExtOpenOperatorTaskBridgeSqlProvider {
	private static transient Logger logger = LoggerFactory.getLogger(ExtOpenOperatorTaskBridgeSqlProvider.class);
	public String pageQuery(Map<String, Object> param) {
		StringBuffer sb = new StringBuffer("");
		sb.append(" select _task.*,_info.category_id, _category.name category_name,_area.name city_name, _community.name community_name, _info.type, _info.act_titile, _merchant.title merchant_name,_service.title service_name, _info.status activity_status\n");
		sb.append(" from open_operator_task _task");
		sb.append(" LEFT JOIN area _area on _task.city_id=_area.id");
		sb.append("	LEFT JOIN community _community on _community.id=_task.community_id");
		sb.append("	LEFT JOIN open_xfsj_info _info on _info.id=_task.xfsj_id");
		sb.append("	LEFT JOIN community_service _service on _service.id=_task.service_id");
		sb.append("	LEFT JOIN open_merchant_info _merchant on _merchant.id=_task.merchant_id");
		sb.append("	LEFT JOIN community_service_category _category on _category.id=_info.category_id");
		sb.append(" where 1=1");
		if(MapUtils.getInteger(param, "cityId", 0) > 0){
			sb.append( " and _task.city_id=#{cityId}");
		}
		if(MapUtils.getInteger(param, "communityId", 0) > 0){
			sb.append( " and _task.community_id=#{communityId}");
		}
		if(StringUtils.isNotBlank(MapUtils.getString(param, "merchantName"))){
			sb.append( " and _merchant.title like #{merchantName}");
		}
		if(StringUtils.isNotBlank(MapUtils.getString(param, "serviceName"))){
			sb.append( " and _service.title like #{serviceName}");
		}
		if(MapUtils.getLong(param, "taskId", 0L) > 0){
			sb.append( " and _task.id=#{taskId}");
		}
		if(MapUtils.getInteger(param, "categoryId", 0) > 0){
			sb.append( " and _info.category_id=#{categoryId}");
		}
		if (StringUtils.isNotBlank(MapUtils.getString(param, "activityTitle"))) {
			sb.append( " and _info.act_titile like #{activityTitle}");
		}
		if(MapUtils.getInteger(param, "releaseStatus") != null){
			sb.append( " and _task.release_status=#{releaseStatus}");
		}
		if(MapUtils.getInteger(param, "receiveStatus") != null){
			sb.append( " and _task.receive_status=#{receiveStatus}");
		}

		Integer timeStatus = MapUtils.getInteger(param, "timeStatus");
		if(timeStatus != null){
			if(timeStatus == 0){
				sb.append( " and _task.start_time > now()");
			}
			else if(timeStatus == 1){
				sb.append( " and _task.start_time < now() and _task.end_time > now()");
			}else{
				sb.append( " and _task.end_time < now()");
			}
		}

		if(MapUtils.getInteger(param, "activityStatus")  != null){
			sb.append( " and _info.status=#{activityStatus}");
		}
		sb.append(" order by _task.id desc");
		logger.info(sb.toString());
		return sb.toString();

	}
}