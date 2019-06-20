package com.rfchina.community.open.bridge.mapper.ext;

import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;

import com.rfchina.community.open.bridge.entity.ExtCommunityServiceCategory;
import com.rfchina.community.persistence.model.CommunityServiceCategory;
import com.rfchina.community.persistence.model.CommunityServiceCategoryExample;

public interface ExtCommunityServiceCategoryMapper {

	@SelectProvider(type = ExtCommunityServiceCategorySqlProvider.class, method = "pageCommunityServiceCategory")
	@Results({ @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "type", property = "type", jdbcType = JdbcType.INTEGER),
			@Result(column = "sort", property = "sort", jdbcType = JdbcType.INTEGER),
			@Result(column = "exposure", property = "exposure", jdbcType = JdbcType.INTEGER),
			@Result(column = "pid", property = "pid", jdbcType = JdbcType.INTEGER),
			@Result(column = "png", property = "png", jdbcType = JdbcType.VARCHAR),
			@Result(column = "community_fee", property = "communityFee", jdbcType = JdbcType.DECIMAL),
			@Result(column = "premium_num", property = "premiumNum", jdbcType = JdbcType.INTEGER) })
	public PageList<CommunityServiceCategory> pageCommunityServiceCategory(
			@Param("example") CommunityServiceCategoryExample example, PageBounds pageBounds);
	
	
	@SelectProvider(type = ExtCommunityServiceCategorySqlProvider.class, method = "pageCategory")
	@Results({ @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "type", property = "type", jdbcType = JdbcType.INTEGER),
			@Result(column = "sort", property = "sort", jdbcType = JdbcType.INTEGER),
			@Result(column = "exposure", property = "exposure", jdbcType = JdbcType.INTEGER),
			@Result(column = "pid", property = "pid", jdbcType = JdbcType.INTEGER),
			@Result(column = "png", property = "png", jdbcType = JdbcType.VARCHAR),
			@Result(column = "community_fee", property = "communityFee", jdbcType = JdbcType.DECIMAL),
			@Result(column = "category_type_name", property = "categoryTypeName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "premium_num", property = "premiumNum", jdbcType = JdbcType.INTEGER) })
	public PageList<ExtCommunityServiceCategory> pageCategory(Map<String, Object> param, PageBounds pageBounds);
}
