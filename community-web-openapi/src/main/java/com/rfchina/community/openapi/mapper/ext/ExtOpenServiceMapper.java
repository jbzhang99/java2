package com.rfchina.community.openapi.mapper.ext;

import com.rfchina.community.openapi.entity.ExtServiceMerchantInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface ExtOpenServiceMapper {

	@Select({
			"select s.id service_id,s.account_id,s.app_id,p.community_rate,p.platform_fee, p.think_rate from community_service s ,open_service_pay p "
					+ " where s.id=p.service_id and s.app_id in(${appids})" })
	@Results({ 
			@Result(column = "account_id", property = "accountId", jdbcType = JdbcType.VARCHAR),
			@Result(column = "app_id", property = "appId", jdbcType = JdbcType.BIGINT),
			@Result(column = "service_id", property = "serviceId", jdbcType = JdbcType.INTEGER),
			// DOUBLE
			@Result(column = "community_rate", property = "communityRate", jdbcType = JdbcType.DECIMAL),
			@Result(column = "think_rate", property = "thinkRate", jdbcType = JdbcType.DECIMAL),
			@Result(column = "platform_fee", property = "platformFee", jdbcType = JdbcType.DECIMAL), })
	public List<ExtServiceMerchantInfo> selectOpenService(@Param("appids")  String appids);

}
