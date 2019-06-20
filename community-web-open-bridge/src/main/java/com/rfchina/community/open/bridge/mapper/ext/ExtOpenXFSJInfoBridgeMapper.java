package com.rfchina.community.open.bridge.mapper.ext;

import com.rfchina.community.open.bridge.entity.ExtOpenXFSJInfo;
import com.rfchina.community.persistence.model.OpenXFSJInfo;
import com.rfchina.community.persistence.model.OpenXFSJInfoExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;

import java.io.Serializable;
import java.util.Map;

public interface ExtOpenXFSJInfoBridgeMapper extends Serializable {
	
    @SelectProvider(type=ExtOpenXFSJInfoBridgeSqlProvider.class, method="pageByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="act_titile", property="actTitile", jdbcType=JdbcType.VARCHAR),
        @Result(column="act_address", property="actAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="act_time", property="actTime", jdbcType=JdbcType.VARCHAR),
        @Result(column="act_img", property="actImg", jdbcType=JdbcType.VARCHAR),
        @Result(column="act_url", property="actUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_uid", property="createUid", jdbcType=JdbcType.BIGINT)
    })
    
	PageList<OpenXFSJInfo> pageByExample(@Param("example") OpenXFSJInfoExample example, PageBounds pageBounds);
    
    
    @SelectProvider(type=ExtOpenXFSJInfoBridgeSqlProvider.class, method="pageByParam")
    @Results({
    	@Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
    	@Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
    	@Result(column="act_titile", property="actTitile", jdbcType=JdbcType.VARCHAR),
    	@Result(column="act_address", property="actAddress", jdbcType=JdbcType.VARCHAR),
    	@Result(column="act_time", property="actTime", jdbcType=JdbcType.VARCHAR),
    	@Result(column="act_img", property="actImg", jdbcType=JdbcType.VARCHAR),
    	@Result(column="act_url", property="actUrl", jdbcType=JdbcType.VARCHAR),
    	@Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
    	@Result(column="sign_up_status", property="signUpStatus", jdbcType=JdbcType.INTEGER),
    	@Result(column="amount", property="amount", jdbcType=JdbcType.INTEGER),
    	@Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
    	@Result(column="create_uid", property="createUid", jdbcType=JdbcType.BIGINT)
    })
    PageList<ExtOpenXFSJInfo> pageByParam(Map<String, Object> param, PageBounds pageBounds);

    
    @SelectProvider(type=ExtOpenXFSJInfoBridgeSqlProvider.class, method="generalServiceOrder")
    PageList<Map<String,Object>> generalServiceOrder(Map<String, Object> param, PageBounds pageBounds);

    
    @SelectProvider(type=ExtOpenXFSJInfoBridgeSqlProvider.class, method="listPlatformActivity")
    @Results({
    	@Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
    	@Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
    	@Result(column="act_titile", property="actTitile", jdbcType=JdbcType.VARCHAR),
    	@Result(column="act_address", property="actAddress", jdbcType=JdbcType.VARCHAR),
    	@Result(column="act_time", property="actTime", jdbcType=JdbcType.VARCHAR),
    	@Result(column="act_img", property="actImg", jdbcType=JdbcType.VARCHAR),
    	@Result(column="act_url", property="actUrl", jdbcType=JdbcType.VARCHAR),
    	@Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
    	@Result(column="sign_up_status", property="signUpStatus", jdbcType=JdbcType.INTEGER),
    	@Result(column="amount", property="amount", jdbcType=JdbcType.INTEGER),
    	@Result(column="category_id", property="categoryId", jdbcType=JdbcType.INTEGER),
    	@Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
    	@Result(column="begin_time", property="beginTime", jdbcType=JdbcType.TIMESTAMP),
    	@Result(column="end_time", property="endTime", jdbcType=JdbcType.TIMESTAMP),
    	@Result(column="create_uid", property="createUid", jdbcType=JdbcType.BIGINT)
    })
	PageList<ExtOpenXFSJInfo> listPlatformActivity(Map<String, Object> param, PageBounds pageBounds);

	@SelectProvider(type=ExtOpenXFSJInfoBridgeSqlProvider.class, method="listValidActivity")
	@Results({
			@Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
			@Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
			@Result(column="act_titile", property="actTitile", jdbcType=JdbcType.VARCHAR),
			@Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
			@Result(column="category_id", property="categoryId", jdbcType=JdbcType.INTEGER),
			@Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
			@Result(column="begin_time", property="beginTime", jdbcType=JdbcType.TIMESTAMP),
			@Result(column="detail", property="detail", jdbcType=JdbcType.LONGNVARCHAR),
			@Result(column="act_address", property="actAddress", jdbcType=JdbcType.VARCHAR),
			@Result(column="end_time", property="endTime", jdbcType=JdbcType.TIMESTAMP)
	})
	PageList<ExtOpenXFSJInfo> listValidActivity(Map<String, Object> param, PageBounds pageBounds);

    
    
}