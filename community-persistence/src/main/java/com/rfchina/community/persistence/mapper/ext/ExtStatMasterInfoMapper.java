package com.rfchina.community.persistence.mapper.ext;

import com.rfchina.community.persistence.model.StatMasterCover;
import com.rfchina.community.persistence.model.StatMasterInfo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;
import java.util.List;

/**
 */
public interface ExtStatMasterInfoMapper {


/*    SELECT
            area_id,
            community_id,
            community_type,
    count(master_id) AS mc,
    sum(child_count) AS cc
    FROM
            (
                    SELECT
                            a.area_id,
                    a.community_id,
                    c.type AS community_type,
                    a.id AS master_id,
                    CASE
                            WHEN count(b.id) > 0 THEN
			1
    ELSE
			0
    END AS child_count
            FROM
    master_info a
    LEFT JOIN master_child b ON a.id = b.master_id
    LEFT JOIN community c ON a.community_id = c.id
    GROUP BY
    a.area_id,
    a.community_id,
    a.id
	) k
    GROUP BY
    area_id,
    community_id,
    community_type;*/
/*    @Select({
        "SELECT area_id, community_id, community_type,",
        "count(master_id) as master_count,",
        "sum(child_count) as master_child_count",
        "FROM ( SELECT a.area_id, a.community_id, c.type as community_type,",
        "a.id AS master_id, case when count(b.id)>0 then 1 else 0 end as child_count",
        "FROM master_info a",
        "LEFT JOIN master_child b ON a.id = b.master_id",
        "left join community c on a.community_id = c.id",
        "where a.create_time <= DATE_ADD(CURRENT_DATE(),INTERVAL -1 DAY)",
        "and b.create_time <= DATE_ADD(CURRENT_DATE(),INTERVAL -1 DAY)",
        "GROUP BY a.area_id, a.community_id, a.id) as k",
        "GROUP BY area_id, community_id, community_type"
    })*/
    @SelectProvider(type=ExtStatMasterInfoSqlProvider.class, method="statMasterCover")
    @Results({
            @Result(column="area_id", property="areaId", jdbcType=JdbcType.INTEGER),
            @Result(column="prop_type", property="propType", jdbcType=JdbcType.INTEGER),
            @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
            @Result(column="community_type", property="communityType", jdbcType=JdbcType.TINYINT),
            @Result(column="master_count", property="masterCount", jdbcType=JdbcType.INTEGER),
            @Result(column="master_child_count", property="masterChildCount", jdbcType=JdbcType.INTEGER),
            @Result(column="room_count", property="roomCount", jdbcType=JdbcType.INTEGER),
            @Result(column="parking_count", property="parkingCount", jdbcType=JdbcType.INTEGER),
            @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    public List<StatMasterCover> statMasterCover(@Param("statDate") Date statDate
                                                 /* @Param("startTime") Date endTime*/);

    @SelectProvider(type=ExtStatMasterInfoSqlProvider.class, method="statMasterUserInfoRegister")
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
            @Result(column="area_id", property="areaId", jdbcType=JdbcType.INTEGER),
            @Result(column="prop_type", property="propType", jdbcType=JdbcType.INTEGER),
            @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
            @Result(column="community_type", property="communityType", jdbcType=JdbcType.TINYINT),
            @Result(column="user_count", property="userCount", jdbcType=JdbcType.INTEGER),
            @Result(column="master_count", property="masterCount", jdbcType=JdbcType.INTEGER),
            @Result(column="master_child_count", property="masterChildCount", jdbcType=JdbcType.INTEGER),
            @Result(column="room_count", property="roomCount", jdbcType=JdbcType.INTEGER),
            @Result(column="parking_count", property="parkingCount", jdbcType=JdbcType.INTEGER),
            @Result(column="owner_count", property="ownerCount", jdbcType=JdbcType.INTEGER),
            @Result(column="biz_owner_count", property="bizOwnerCount", jdbcType=JdbcType.INTEGER),
            @Result(column="tenant_count", property="tenantCount", jdbcType=JdbcType.INTEGER),
            @Result(column="family_count", property="familyCount", jdbcType=JdbcType.INTEGER),
            @Result(column="staff_count", property="staffCount", jdbcType=JdbcType.INTEGER),
            @Result(column="site_staff_count", property="siteStaffCount", jdbcType=JdbcType.INTEGER),
            @Result(column="other_count", property="otherCount", jdbcType=JdbcType.INTEGER),
            @Result(column="type", property="type", jdbcType=JdbcType.TINYINT),
            @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    public List<StatMasterInfo> statMasterUserInfoRegister(@Param("statDate") Date statDate);

    @SelectProvider(type=ExtStatMasterInfoSqlProvider.class, method="statMasterUserInfoImport")
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
            @Result(column="area_id", property="areaId", jdbcType=JdbcType.INTEGER),
            @Result(column="prop_type", property="propType", jdbcType=JdbcType.INTEGER),
            @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
            @Result(column="community_type", property="communityType", jdbcType=JdbcType.TINYINT),
            @Result(column="user_count", property="userCount", jdbcType=JdbcType.INTEGER),
            @Result(column="master_count", property="masterCount", jdbcType=JdbcType.INTEGER),
            @Result(column="master_child_count", property="masterChildCount", jdbcType=JdbcType.INTEGER),
            @Result(column="room_count", property="roomCount", jdbcType=JdbcType.INTEGER),
            @Result(column="parking_count", property="parkingCount", jdbcType=JdbcType.INTEGER),
            @Result(column="owner_count", property="ownerCount", jdbcType=JdbcType.INTEGER),
            @Result(column="biz_owner_count", property="bizOwnerCount", jdbcType=JdbcType.INTEGER),
            @Result(column="tenant_count", property="tenantCount", jdbcType=JdbcType.INTEGER),
            @Result(column="family_count", property="familyCount", jdbcType=JdbcType.INTEGER),
            @Result(column="staff_count", property="staffCount", jdbcType=JdbcType.INTEGER),
            @Result(column="site_staff_count", property="siteStaffCount", jdbcType=JdbcType.INTEGER),
            @Result(column="other_count", property="otherCount", jdbcType=JdbcType.INTEGER),
            @Result(column="type", property="type", jdbcType=JdbcType.TINYINT),
            @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    public List<StatMasterInfo> statMasterUserInfoImport(@Param("statDate") Date statDate);

    @SelectProvider(type=ExtStatMasterInfoSqlProvider.class, method="statMasterInfo")
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
            @Result(column="area_id", property="areaId", jdbcType=JdbcType.INTEGER),
            @Result(column="prop_type", property="propType", jdbcType=JdbcType.INTEGER),
            @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
            @Result(column="community_type", property="communityType", jdbcType=JdbcType.TINYINT),
            @Result(column="user_count", property="userCount", jdbcType=JdbcType.INTEGER),
            @Result(column="master_count", property="masterCount", jdbcType=JdbcType.INTEGER),
            @Result(column="master_child_count", property="masterChildCount", jdbcType=JdbcType.INTEGER),
            @Result(column="room_count", property="roomCount", jdbcType=JdbcType.INTEGER),
            @Result(column="parking_count", property="parkingCount", jdbcType=JdbcType.INTEGER),
            @Result(column="owner_count", property="ownerCount", jdbcType=JdbcType.INTEGER),
            @Result(column="biz_owner_count", property="bizOwnerCount", jdbcType=JdbcType.INTEGER),
            @Result(column="tenant_count", property="tenantCount", jdbcType=JdbcType.INTEGER),
            @Result(column="family_count", property="familyCount", jdbcType=JdbcType.INTEGER),
            @Result(column="staff_count", property="staffCount", jdbcType=JdbcType.INTEGER),
            @Result(column="site_staff_count", property="siteStaffCount", jdbcType=JdbcType.INTEGER),
            @Result(column="other_count", property="otherCount", jdbcType=JdbcType.INTEGER),
            @Result(column="type", property="type", jdbcType=JdbcType.TINYINT),
            @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    public List<StatMasterInfo> statMasterInfo(@Param("statDate") Date statDate);

    @SelectProvider(type=ExtStatMasterInfoSqlProvider.class, method="statRegisterUserCount")
    public Integer statRegisterUserCount(@Param("statDate") Date statDate);

    @SelectProvider(type=ExtStatMasterInfoSqlProvider.class, method="statUserCount")
    public Integer statUserCount(@Param("statDate") Date statDate);

    @SelectProvider(type=ExtStatMasterInfoSqlProvider.class, method="statMasterChildUserCount")
    public Integer statMasterChildUserCount(@Param("statDate") Date statDate);
}
