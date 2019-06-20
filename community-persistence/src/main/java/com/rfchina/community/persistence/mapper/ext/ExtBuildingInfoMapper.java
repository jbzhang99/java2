package com.rfchina.community.persistence.mapper.ext;

import com.rfchina.community.persistence.model.BuildingInfo;
import com.rfchina.community.persistence.model.BuildingInfoExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;


/**
 */
public interface ExtBuildingInfoMapper {

    @SelectProvider(type=ExtBuildingInfoSqlProvider.class, method="pageByExample")
    @Results({
            @Result(column="id", property="id", jdbcType= JdbcType.BIGINT, id=true),
            @Result(column="area_id", property="areaId", jdbcType=JdbcType.INTEGER),
            @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
            @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
            @Result(column="prop_type", property="propType", jdbcType=JdbcType.INTEGER),
            @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
            @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
            @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    PageList<BuildingInfo> pageByExample(@Param("example") BuildingInfoExample example, PageBounds pageBounds);
}
