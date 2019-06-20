package com.rfchina.community.openweb.mapper.ext;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;

import com.rfchina.community.persistence.model.CommunityServiceCategory;
import com.rfchina.community.persistence.model.CommunityServiceCategoryExample;

public interface ExtCommunityServiceCategoryMapper {

	@SelectProvider(type = ExtCommunityServiceCategorySqlProvider.class, method = "pageCommunityServiceCategory")
	@Results({ @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "type", property = "type", jdbcType = JdbcType.INTEGER) })
	public PageList<CommunityServiceCategory> pageCommunityServiceCategory(@Param("example") CommunityServiceCategoryExample example,
			PageBounds pageBounds);
}
