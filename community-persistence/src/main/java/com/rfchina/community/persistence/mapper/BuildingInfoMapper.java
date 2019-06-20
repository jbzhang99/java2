package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.BuildingInfo;
import com.rfchina.community.persistence.model.BuildingInfoExample;
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

public interface BuildingInfoMapper extends Serializable {
    @SelectProvider(type=BuildingInfoSqlProvider.class, method="countByExample")
    long countByExample(BuildingInfoExample example);

    @DeleteProvider(type=BuildingInfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(BuildingInfoExample example);

    @Delete({
        "delete from building_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into building_info (area_id, community_id, ",
        "name, address, prop_type, ",
        "status, remark, ",
        "create_time, update_time)",
        "values (#{areaId,jdbcType=INTEGER}, #{communityId,jdbcType=INTEGER}, ",
        "#{name,jdbcType=VARCHAR}, #{address,jdbcType=VARCHAR}, #{propType,jdbcType=INTEGER}, ",
        "#{status,jdbcType=INTEGER}, #{remark,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(BuildingInfo record);

    @InsertProvider(type=BuildingInfoSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(BuildingInfo record);

    @SelectProvider(type=BuildingInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
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
    List<BuildingInfo> selectByExample(BuildingInfoExample example);

    @Select({
        "select",
        "id, area_id, community_id, name, address, prop_type, status, remark, create_time, ",
        "update_time",
        "from building_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
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
    BuildingInfo selectByPrimaryKey(Long id);

    @UpdateProvider(type=BuildingInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") BuildingInfo record, @Param("example") BuildingInfoExample example);

    @UpdateProvider(type=BuildingInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") BuildingInfo record, @Param("example") BuildingInfoExample example);

    @UpdateProvider(type=BuildingInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(BuildingInfo record);

    @Update({
        "update building_info",
        "set area_id = #{areaId,jdbcType=INTEGER},",
          "community_id = #{communityId,jdbcType=INTEGER},",
          "name = #{name,jdbcType=VARCHAR},",
          "address = #{address,jdbcType=VARCHAR},",
          "prop_type = #{propType,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(BuildingInfo record);
}