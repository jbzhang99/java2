package com.rfchina.community.persistence.mapper.ext;

import com.rfchina.community.persistence.mapper.OpenMiniAdInfoMapper;
import com.rfchina.community.persistence.model.Community;
import com.rfchina.community.persistence.model.ext.ExtOpenMiniAdInfo;
import com.rfchina.community.persistence.model.ext.SimCommunity;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;

import java.util.List;
import java.util.Map;

public interface ExtOpenMiniAdInfoMapper extends OpenMiniAdInfoMapper {

	@SelectProvider(type = ExtOpenMiniAdInfoSqlProvider.class , method = "pageByCondition")
	@Results({
			@Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
			@Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
			@Result(column="style", property="style", jdbcType=JdbcType.VARCHAR),
			@Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
			@Result(column="sorting", property="sorting", jdbcType=JdbcType.INTEGER),
			@Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
			@Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
	public PageList<ExtOpenMiniAdInfo> pageByCondition(Map<String, Object> param, PageBounds pageBounds);

	@Results({
			@Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
			@Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
			@Result(column="city_name", property="cityName", jdbcType=JdbcType.VARCHAR)
	})
	@Select({
			" select id, name ,c.city_name from open_mini_ad_community_rela rela, community c where rela.community_id=c.id and rela.ad_id=#{infoId,jdbcType=BIGINT}"
	})
	public List<SimCommunity> getCommunityList(@Param("infoId") long infoId);

	@SelectProvider(type = ExtOpenMiniAdInfoSqlProvider.class , method = "getMiniInfoListByCommunity")
	@Results({
			@Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
			@Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
			@Result(column="style", property="style", jdbcType=JdbcType.VARCHAR),
			@Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
			@Result(column="sorting", property="sorting", jdbcType=JdbcType.INTEGER),
			@Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
			@Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
	})
	public PageList<ExtOpenMiniAdInfo> getMiniInfoListByCommunity(Map<String, Object> param);


	@SelectProvider(type = ExtOpenMiniAdInfoSqlProvider.class , method = "getRecentlyCommunity")
	@Results({
			@Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
			@Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
			@Result(column="city_id", property="cityId", jdbcType=JdbcType.INTEGER),
			@Result(column="city_name", property="cityName", jdbcType=JdbcType.VARCHAR)
	})
	public List<Community> getRecentlyCommunity(Map<String, Object> param);
}
