package com.rfchina.community.open.bridge.mapper.ext;

import java.io.Serializable;
import java.util.Map;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;

import com.rfchina.community.open.bridge.entity.ExtOpenManagerInvite;
import com.rfchina.community.open.bridge.entity.ExtOpenManagerInviteMerchant;


public interface ExtOpenManagerInviteMapper extends Serializable{
	
	@SelectProvider(method = "pageByCondition", type = ExtOpenManagerInviteSqlProvider.class)
	@Results({
		@Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
		@Result(column="emp_name", property="empName", jdbcType=JdbcType.VARCHAR),
		@Result(column="emp_guid", property="empGuid", jdbcType=JdbcType.VARCHAR),
		@Result(column="merchant_count", property="merchantCount", jdbcType=JdbcType.VARCHAR)
	})
	public PageList<ExtOpenManagerInvite> pageByCondition(Map<String, Object> param, PageBounds pageBounds);
	
	@SelectProvider(method = "queryDetailsByPhone", type = ExtOpenManagerInviteSqlProvider.class )
	@Results({
		@Result(column="merchant_id", property="merchantId", jdbcType=JdbcType.INTEGER, id=true),
		@Result(column="merchant_title", property="merchantTitle", jdbcType=JdbcType.VARCHAR),
		@Result(column="service_title", property="serviceTitle", jdbcType=JdbcType.VARCHAR),
		@Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
	})
	public PageList<ExtOpenManagerInviteMerchant> queryDetailsByPhone(String phone);
}
