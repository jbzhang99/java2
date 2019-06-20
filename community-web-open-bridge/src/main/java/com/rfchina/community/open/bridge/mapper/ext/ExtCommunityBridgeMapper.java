package com.rfchina.community.open.bridge.mapper.ext;

import com.rfchina.community.persistence.model.ext.ExtCommunityServiceRela;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;

import java.util.List;
import java.util.Map;

/**
 */
public interface ExtCommunityBridgeMapper {

	@Select("select  a.id,a.name from community c,area a where c.city_id=a.id and c.status =1 group by c.city_id")
	List<Map<String, Object>> searchCityByCommuntiy();

	@Select({"select t.*,d.`name` as community_name from community_service_rela t left join community d on t.community_id = d.id left join area a on a.id=d.area_id where 1=1 and t.service_id = #{serviceId}"})
	@Results({
			@Result(column="community_id", property="communityId", jdbcType= JdbcType.INTEGER, id=true),
			@Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER, id=true),
			@Result(column="area_name", property="areaName", jdbcType=JdbcType.VARCHAR),
			@Result(column="community_name", property="communityName", jdbcType=JdbcType.VARCHAR)
	})
	public PageList<ExtCommunityServiceRela> getCommunityServiceRelaList(int serviceId , PageBounds pageBounds);
}
