package com.rfchina.community.openstore.mapper.ext;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import com.rfchina.community.openstore.entity.UidCommunityCount;
import com.rfchina.community.openstore.entity.ext.AuthAddress;

public interface ExtMasterChild2Mapper extends Serializable {

	@Select({"<script> select community_id,count(*) as count from master_child where uid=#{uid} and `status`=1 "+
			"<if test=\"communityIdList != null \"> and community_id in <foreach collection=\"communityIdList\" item=\"item\""
			+ " index=\"index\" open=\"(\" close=\")\"" + " separator=\",\">", "#{item}",
			"</foreach></if> group by community_id </script>"
	})
	@Results( {
			@Result(column="count", property="count", jdbcType= JdbcType.BIGINT ),
			@Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER)
			
	})
	public List<UidCommunityCount> groupCommunityByUid(@Param("uid") long uid ,@Param("communityIdList") List<Integer> communityIdList );
	
	@SelectProvider(type = ExtMasterChild2SqlProvider.class, method = "listAuthAddress")
	@Results( {
		@Result(column="first_name", property="firstName", jdbcType= JdbcType.VARCHAR ),
		@Result(column="first_phone", property="firstPhone", jdbcType= JdbcType.VARCHAR ),
		@Result(column="address", property="address", jdbcType= JdbcType.VARCHAR ),
		@Result(column="city_id", property="cityId", jdbcType= JdbcType.INTEGER ),
		@Result(column="area_id", property="areaId", jdbcType= JdbcType.INTEGER ),
		@Result(column="city_name", property="cityName", jdbcType= JdbcType.VARCHAR ),
		@Result(column="name", property="name", jdbcType= JdbcType.VARCHAR ),
		@Result(column="loudong", property="loudong", jdbcType= JdbcType.VARCHAR ),
		@Result(column="floor", property="floor", jdbcType= JdbcType.VARCHAR ),
		@Result(column="room", property="room", jdbcType= JdbcType.VARCHAR ),
		@Result(column="community_id", property="communityId", jdbcType= JdbcType.INTEGER ),
		@Result(column="type", property="type", jdbcType= JdbcType.INTEGER ),
		@Result(column="title", property="title", jdbcType= JdbcType.VARCHAR )
	})
	
	public List<AuthAddress> listAuthAddress(@Param("uid") long uid);

}