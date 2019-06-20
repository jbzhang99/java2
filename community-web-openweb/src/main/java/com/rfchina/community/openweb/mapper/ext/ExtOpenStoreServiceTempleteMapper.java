package com.rfchina.community.openweb.mapper.ext;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import com.rfchina.community.openweb.entity.ExtOpenStoreServiceTemplete;

/**
 */
public interface ExtOpenStoreServiceTempleteMapper {

	 	@SelectProvider(type=ExtOpenStoreServiceTempleteSqlProvider.class, method="getTempleteList")
	    @Results({
	        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
	        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
	    })
	 	public List<ExtOpenStoreServiceTemplete> getTempleteList(Map<String, Object> param);
}
