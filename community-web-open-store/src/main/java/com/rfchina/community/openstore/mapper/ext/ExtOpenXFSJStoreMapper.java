package com.rfchina.community.openstore.mapper.ext;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import com.rfchina.community.openstore.entity.SearchServiceBean;

/**
 */
public interface ExtOpenXFSJStoreMapper {

	@SelectProvider(type = ExtOpenXFSJStoreSqlProvider.class, method = "getStoreIdList")
	@Results({ @Result(column = "store_id", property = "storeId", jdbcType = JdbcType.INTEGER, id = true) })
	public List<Integer> getStoreIdList(Map<String, Object> param);
	
	@SelectProvider(type = ExtOpenXFSJStoreSqlProvider.class, method = "getPlatformActivityStoreIdList")
	@Results({ @Result(column = "store_id", property = "storeId", jdbcType = JdbcType.INTEGER, id = true) })
	public List<Integer> getPlatformActivityStoreIdList(Map<String, Object> param);

	@SelectProvider(type = ExtOpenXFSJStoreSqlProvider.class, method = "searchService")
	@Results({ @Result(column = "service_id", property = "serviceId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "title", property = "title", jdbcType = JdbcType.VARCHAR),
			@Result(column = "png", property = "png", jdbcType = JdbcType.VARCHAR),
			@Result(column = "user_range", property = "userRange", jdbcType = JdbcType.INTEGER),
			@Result(column = "service_description", property = "serviceDescription", jdbcType = JdbcType.VARCHAR),
			@Result(column = "type", property = "type", jdbcType = JdbcType.INTEGER),
			@Result(column = "provide_type", property = "provideType", jdbcType = JdbcType.INTEGER)
	})
	public List<SearchServiceBean> searchService(@Param("likeKeyWords") String likeKeyWords);

}
