package com.rfchina.community.openweb.mapper.ext;

import java.util.Map;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.type.JdbcType;

import com.rfchina.community.persistence.mapper.CommunityResourceSqlProvider;

public class ExtOpenXFSJBusinessInfoSqlProvider extends CommunityResourceSqlProvider{
	
	public String listBusinessInfo(Map<String, Object> param) {
		StringBuffer sb = new StringBuffer("SELECT _bus.*,_info.community_id, _info.act_titile, _info.act_address,_info.act_time, "
				+ "_info.act_img,_info.act_url, _info.status, _info.create_time, _info.create_uid, _info.begin_time, _info.end_time, _area.name area_name, _comm.name community_name FROM "
				+ " open_xfsj_info _info LEFT JOIN open_xfsj_business_info _bus ON _bus.xfsj_id = _info.id "
				+ " LEFT JOIN community _comm ON _info.community_id = _comm.id "
				+ " LEFT JOIN area _area ON _area.id = _comm.city_id "
				+ " where _bus.sign_up_status = 1 and _comm.id in (select  community_id from community_service_rela where service_id=#{serviceId} and status=1)");
	
		sb.append(" and _info.type=#{activityType}");
		if(param.get("cityId") != null) {
			sb.append(" and city_id=#{cityId}");
		}
		if(param.get("communityId") != null) {
			sb.append(" and community_id=#{communityId}");
		}
		if(param.get("activityName") != null) {
			sb.append(" and _info.act_titile like #{activityName}");
		}
		if(param.get("status") != null) {
			Integer status = (Integer)param.get("status");
			if(status == 1)
				sb.append(" and _bus.sign_up_end_time > #{localeTime}");
			else
				sb.append(" and _bus.sign_up_end_time < #{localeTime}");
		}
		if(param.get("activityStatus") != null) {
			Integer activityStatus = (Integer)param.get("activityStatus");
			if(activityStatus == 0) { //未开始
				sb.append(" and _info.begin_time > #{nowTime}");
			}else if(activityStatus == 1) {//进行中
				sb.append(" and _info.begin_time < #{nowTime} and _info.end_time > #{nowTime}");
			}else if(activityStatus == 2) {//已结束
				sb.append(" and _info.end_time < #{nowTime}");
			}
		}
		if(param.get("startDate") != null) {
			sb.append(" and _info.begin_time > #{startDate}");
			sb.append(" and _info.begin_time < #{endDate}");
		}
		sb.append(" order by _info.create_time desc");
        return sb.toString();
    }
	
	
	public String listMyBusinessInfo(Map<String, Object> param) {
		StringBuffer sb = new StringBuffer("SELECT _bus.*, _info.community_id,_info.act_titile,_info.act_address,_info.act_time,_info.act_img,_info.act_url, "
				+ " _info.STATUS,_info.create_time,_info.create_uid,_info.begin_time,_info.end_time,_area. NAME area_name,_comm. NAME community_name"
				+ " FROM((SELECT * FROM open_xfsj_sign_up_info WHERE `status` in(3,4) AND uid = #{uid}) _sign_up_info "
				+ " LEFT JOIN open_xfsj_info _info ON _info.id = _sign_up_info.xfsj_id"
				+ " LEFT JOIN open_xfsj_business_info _bus ON _bus.xfsj_id = _info.id "
				+ " LEFT JOIN community _comm ON _info.community_id = _comm.id "
				+ " LEFT JOIN area _area ON _area.id = _comm.city_id) where _bus.sign_up_status = 1 ");
		if(param.get("cityId") != null) {
			sb.append(" and city_id=#{cityId}");
		}
		if(param.get("communityId") != null) {
			sb.append(" and community_id=#{communityId}");
		}
		if(param.get("activityName") != null) {
			sb.append(" and _info.act_titile like #{activityName}");
		}
		
		if(param.get("activityStatus") != null) {
			Integer activityStatus = (Integer)param.get("activityStatus");
			if(activityStatus == 0) { //未开始
				sb.append(" and _info.begin_time > #{nowTime}");
			}else if(activityStatus == 1) {//进行中
				sb.append(" and _info.begin_time < #{nowTime} and _info.end_time > #{nowTime}");
			}else if(activityStatus == 2) {//已结束
				sb.append(" and _info.end_time < #{nowTime}");
			}
		}
		if(param.get("startDate") != null) {
			sb.append(" and _info.begin_time > #{startDate}");
			sb.append(" and _info.begin_time < #{endDate}");
		}
		
		sb.append(" order by _info.create_time desc");
		
        return sb.toString();
    }
	
	

}
