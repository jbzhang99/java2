package com.rfchina.community.openstore.mapper.ext;

import java.io.Serializable;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import com.rfchina.community.persistence.model.OpenStoreServiceTemplete;

public interface ExtOpenStoreServiceTempleteMapper extends Serializable{
	
	 @Select({
	        "select",
	        "service_id, premium_num ",
	        "from open_store_service_templete ",
	        "where service_id = #{serviceId,jdbcType=INTEGER}"
	    })
	 @Results({
		@Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER, id=true),
		@Result(column="premium_num", property="premiumNum", jdbcType=JdbcType.INTEGER)
	})
	OpenStoreServiceTemplete getPremiumNumById(Integer serviceId);
}
