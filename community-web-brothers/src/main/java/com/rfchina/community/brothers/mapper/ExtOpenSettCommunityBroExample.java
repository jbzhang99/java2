package com.rfchina.community.brothers.mapper;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ExtOpenSettCommunityBroExample extends Serializable {

	//统计这个时间段有哪些社区能提现
	@Select({ "select community_id,service_account,count(*) as count from open_order "
			+ " where type=1 and bill_split_status=1 and bill_status=2 and service_charge>0 "
			+ "  and bill_split_time>=#{startDate} and bill_split_time<=#{endDate}  "
			+ " group by community_id,service_account " })
	public List<Map<String, Object>> selectSettCommunity(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

 
}