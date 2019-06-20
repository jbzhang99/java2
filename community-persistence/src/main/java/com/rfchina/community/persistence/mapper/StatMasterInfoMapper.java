package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.StatMasterInfo;
import com.rfchina.community.persistence.model.StatMasterInfoExample;
import java.io.Serializable;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface StatMasterInfoMapper extends Serializable {
    @SelectProvider(type=StatMasterInfoSqlProvider.class, method="countByExample")
    long countByExample(StatMasterInfoExample example);

    @DeleteProvider(type=StatMasterInfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(StatMasterInfoExample example);

    @Delete({
        "delete from stat_master_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into stat_master_info (area_id, community_id, ",
        "community_type, user_count, ",
        "master_count, room_count, ",
        "parking_count, master_child_count, ",
        "owner_count, biz_owner_count, ",
        "tenant_count, family_count, ",
        "staff_count, site_staff_count, ",
        "other_count, type, ",
        "prop_type, create_time, ",
        "stat_time)",
        "values (#{areaId,jdbcType=INTEGER}, #{communityId,jdbcType=INTEGER}, ",
        "#{communityType,jdbcType=INTEGER}, #{userCount,jdbcType=INTEGER}, ",
        "#{masterCount,jdbcType=INTEGER}, #{roomCount,jdbcType=INTEGER}, ",
        "#{parkingCount,jdbcType=INTEGER}, #{masterChildCount,jdbcType=INTEGER}, ",
        "#{ownerCount,jdbcType=INTEGER}, #{bizOwnerCount,jdbcType=INTEGER}, ",
        "#{tenantCount,jdbcType=INTEGER}, #{familyCount,jdbcType=INTEGER}, ",
        "#{staffCount,jdbcType=INTEGER}, #{siteStaffCount,jdbcType=INTEGER}, ",
        "#{otherCount,jdbcType=INTEGER}, #{type,jdbcType=INTEGER}, ",
        "#{propType,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{statTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(StatMasterInfo record);

    @InsertProvider(type=StatMasterInfoSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(StatMasterInfo record);

    @SelectProvider(type=StatMasterInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="area_id", property="areaId", jdbcType=JdbcType.INTEGER),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="community_type", property="communityType", jdbcType=JdbcType.INTEGER),
        @Result(column="user_count", property="userCount", jdbcType=JdbcType.INTEGER),
        @Result(column="master_count", property="masterCount", jdbcType=JdbcType.INTEGER),
        @Result(column="room_count", property="roomCount", jdbcType=JdbcType.INTEGER),
        @Result(column="parking_count", property="parkingCount", jdbcType=JdbcType.INTEGER),
        @Result(column="master_child_count", property="masterChildCount", jdbcType=JdbcType.INTEGER),
        @Result(column="owner_count", property="ownerCount", jdbcType=JdbcType.INTEGER),
        @Result(column="biz_owner_count", property="bizOwnerCount", jdbcType=JdbcType.INTEGER),
        @Result(column="tenant_count", property="tenantCount", jdbcType=JdbcType.INTEGER),
        @Result(column="family_count", property="familyCount", jdbcType=JdbcType.INTEGER),
        @Result(column="staff_count", property="staffCount", jdbcType=JdbcType.INTEGER),
        @Result(column="site_staff_count", property="siteStaffCount", jdbcType=JdbcType.INTEGER),
        @Result(column="other_count", property="otherCount", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="prop_type", property="propType", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="stat_time", property="statTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<StatMasterInfo> selectByExample(StatMasterInfoExample example);

    @Select({
        "select",
        "id, area_id, community_id, community_type, user_count, master_count, room_count, ",
        "parking_count, master_child_count, owner_count, biz_owner_count, tenant_count, ",
        "family_count, staff_count, site_staff_count, other_count, type, prop_type, create_time, ",
        "stat_time",
        "from stat_master_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="area_id", property="areaId", jdbcType=JdbcType.INTEGER),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="community_type", property="communityType", jdbcType=JdbcType.INTEGER),
        @Result(column="user_count", property="userCount", jdbcType=JdbcType.INTEGER),
        @Result(column="master_count", property="masterCount", jdbcType=JdbcType.INTEGER),
        @Result(column="room_count", property="roomCount", jdbcType=JdbcType.INTEGER),
        @Result(column="parking_count", property="parkingCount", jdbcType=JdbcType.INTEGER),
        @Result(column="master_child_count", property="masterChildCount", jdbcType=JdbcType.INTEGER),
        @Result(column="owner_count", property="ownerCount", jdbcType=JdbcType.INTEGER),
        @Result(column="biz_owner_count", property="bizOwnerCount", jdbcType=JdbcType.INTEGER),
        @Result(column="tenant_count", property="tenantCount", jdbcType=JdbcType.INTEGER),
        @Result(column="family_count", property="familyCount", jdbcType=JdbcType.INTEGER),
        @Result(column="staff_count", property="staffCount", jdbcType=JdbcType.INTEGER),
        @Result(column="site_staff_count", property="siteStaffCount", jdbcType=JdbcType.INTEGER),
        @Result(column="other_count", property="otherCount", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="prop_type", property="propType", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="stat_time", property="statTime", jdbcType=JdbcType.TIMESTAMP)
    })
    StatMasterInfo selectByPrimaryKey(Long id);

    @UpdateProvider(type=StatMasterInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") StatMasterInfo record, @Param("example") StatMasterInfoExample example);

    @UpdateProvider(type=StatMasterInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") StatMasterInfo record, @Param("example") StatMasterInfoExample example);

    @UpdateProvider(type=StatMasterInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(StatMasterInfo record);

    @Update({
        "update stat_master_info",
        "set area_id = #{areaId,jdbcType=INTEGER},",
          "community_id = #{communityId,jdbcType=INTEGER},",
          "community_type = #{communityType,jdbcType=INTEGER},",
          "user_count = #{userCount,jdbcType=INTEGER},",
          "master_count = #{masterCount,jdbcType=INTEGER},",
          "room_count = #{roomCount,jdbcType=INTEGER},",
          "parking_count = #{parkingCount,jdbcType=INTEGER},",
          "master_child_count = #{masterChildCount,jdbcType=INTEGER},",
          "owner_count = #{ownerCount,jdbcType=INTEGER},",
          "biz_owner_count = #{bizOwnerCount,jdbcType=INTEGER},",
          "tenant_count = #{tenantCount,jdbcType=INTEGER},",
          "family_count = #{familyCount,jdbcType=INTEGER},",
          "staff_count = #{staffCount,jdbcType=INTEGER},",
          "site_staff_count = #{siteStaffCount,jdbcType=INTEGER},",
          "other_count = #{otherCount,jdbcType=INTEGER},",
          "type = #{type,jdbcType=INTEGER},",
          "prop_type = #{propType,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "stat_time = #{statTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(StatMasterInfo record);
}