package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CommunityResource;
import com.rfchina.community.persistence.model.CommunityResourceExample;
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
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface CommunityResourceMapper extends Serializable {
    @SelectProvider(type=CommunityResourceSqlProvider.class, method="countByExample")
    long countByExample(CommunityResourceExample example);

    @DeleteProvider(type=CommunityResourceSqlProvider.class, method="deleteByExample")
    int deleteByExample(CommunityResourceExample example);

    @Delete({
        "delete from community_resource",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into community_resource (id, city_id, ",
        "community_id, resource_type_id, ",
        "addr_detail, resource_desc, ",
        "resource_total, resource_used, ",
        "resource_fee, imgs, ",
        "resource_status, create_time, ",
        "creater_id, modify_time, ",
        "modifier_id)",
        "values (#{id,jdbcType=INTEGER}, #{cityId,jdbcType=INTEGER}, ",
        "#{communityId,jdbcType=INTEGER}, #{resourceTypeId,jdbcType=INTEGER}, ",
        "#{addrDetail,jdbcType=VARCHAR}, #{resourceDesc,jdbcType=VARCHAR}, ",
        "#{resourceTotal,jdbcType=INTEGER}, #{resourceUsed,jdbcType=INTEGER}, ",
        "#{resourceFee,jdbcType=DECIMAL}, #{imgs,jdbcType=VARCHAR}, ",
        "#{resourceStatus,jdbcType=TINYINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{createrId,jdbcType=INTEGER}, #{modifyTime,jdbcType=TIMESTAMP}, ",
        "#{modifierId,jdbcType=INTEGER})"
    })
    int insert(CommunityResource record);

    @InsertProvider(type=CommunityResourceSqlProvider.class, method="insertSelective")
    int insertSelective(CommunityResource record);

    @SelectProvider(type=CommunityResourceSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="city_id", property="cityId", jdbcType=JdbcType.INTEGER),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="resource_type_id", property="resourceTypeId", jdbcType=JdbcType.INTEGER),
        @Result(column="addr_detail", property="addrDetail", jdbcType=JdbcType.VARCHAR),
        @Result(column="resource_desc", property="resourceDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="resource_total", property="resourceTotal", jdbcType=JdbcType.INTEGER),
        @Result(column="resource_used", property="resourceUsed", jdbcType=JdbcType.INTEGER),
        @Result(column="resource_fee", property="resourceFee", jdbcType=JdbcType.DECIMAL),
        @Result(column="imgs", property="imgs", jdbcType=JdbcType.VARCHAR),
        @Result(column="resource_status", property="resourceStatus", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creater_id", property="createrId", jdbcType=JdbcType.INTEGER),
        @Result(column="modify_time", property="modifyTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modifier_id", property="modifierId", jdbcType=JdbcType.INTEGER)
    })
    List<CommunityResource> selectByExample(CommunityResourceExample example);

    @Select({
        "select",
        "id, city_id, community_id, resource_type_id, addr_detail, resource_desc, resource_total, ",
        "resource_used, resource_fee, imgs, resource_status, create_time, creater_id, ",
        "modify_time, modifier_id",
        "from community_resource",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="city_id", property="cityId", jdbcType=JdbcType.INTEGER),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="resource_type_id", property="resourceTypeId", jdbcType=JdbcType.INTEGER),
        @Result(column="addr_detail", property="addrDetail", jdbcType=JdbcType.VARCHAR),
        @Result(column="resource_desc", property="resourceDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="resource_total", property="resourceTotal", jdbcType=JdbcType.INTEGER),
        @Result(column="resource_used", property="resourceUsed", jdbcType=JdbcType.INTEGER),
        @Result(column="resource_fee", property="resourceFee", jdbcType=JdbcType.DECIMAL),
        @Result(column="imgs", property="imgs", jdbcType=JdbcType.VARCHAR),
        @Result(column="resource_status", property="resourceStatus", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creater_id", property="createrId", jdbcType=JdbcType.INTEGER),
        @Result(column="modify_time", property="modifyTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modifier_id", property="modifierId", jdbcType=JdbcType.INTEGER)
    })
    CommunityResource selectByPrimaryKey(Integer id);

    @UpdateProvider(type=CommunityResourceSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CommunityResource record, @Param("example") CommunityResourceExample example);

    @UpdateProvider(type=CommunityResourceSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CommunityResource record, @Param("example") CommunityResourceExample example);

    @UpdateProvider(type=CommunityResourceSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CommunityResource record);

    @Update({
        "update community_resource",
        "set city_id = #{cityId,jdbcType=INTEGER},",
          "community_id = #{communityId,jdbcType=INTEGER},",
          "resource_type_id = #{resourceTypeId,jdbcType=INTEGER},",
          "addr_detail = #{addrDetail,jdbcType=VARCHAR},",
          "resource_desc = #{resourceDesc,jdbcType=VARCHAR},",
          "resource_total = #{resourceTotal,jdbcType=INTEGER},",
          "resource_used = #{resourceUsed,jdbcType=INTEGER},",
          "resource_fee = #{resourceFee,jdbcType=DECIMAL},",
          "imgs = #{imgs,jdbcType=VARCHAR},",
          "resource_status = #{resourceStatus,jdbcType=TINYINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "creater_id = #{createrId,jdbcType=INTEGER},",
          "modify_time = #{modifyTime,jdbcType=TIMESTAMP},",
          "modifier_id = #{modifierId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CommunityResource record);
}