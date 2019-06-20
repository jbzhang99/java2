package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.MasterInfo;
import com.rfchina.community.persistence.model.MasterInfoExample;
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

public interface MasterInfoMapper extends Serializable {
    @SelectProvider(type=MasterInfoSqlProvider.class, method="countByExample")
    long countByExample(MasterInfoExample example);

    @DeleteProvider(type=MasterInfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(MasterInfoExample example);

    @Delete({
        "delete from master_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into master_info (id, community_id, ",
        "floor, room, title, ",
        "address, tel, area_id, ",
        "status, charge_name, ",
        "charge_phone, type, ",
        "loudong, agree_protocol, ",
        "agree_protocol_time, building_id, ",
        "floor_id, unit_id, create_time, ",
        "update_time)",
        "values (#{id,jdbcType=BIGINT}, #{communityId,jdbcType=INTEGER}, ",
        "#{floor,jdbcType=VARCHAR}, #{room,jdbcType=VARCHAR}, #{title,jdbcType=VARCHAR}, ",
        "#{address,jdbcType=VARCHAR}, #{tel,jdbcType=VARCHAR}, #{areaId,jdbcType=INTEGER}, ",
        "#{status,jdbcType=TINYINT}, #{chargeName,jdbcType=VARCHAR}, ",
        "#{chargePhone,jdbcType=VARCHAR}, #{type,jdbcType=INTEGER}, ",
        "#{loudong,jdbcType=VARCHAR}, #{agreeProtocol,jdbcType=INTEGER}, ",
        "#{agreeProtocolTime,jdbcType=TIMESTAMP}, #{buildingId,jdbcType=BIGINT}, ",
        "#{floorId,jdbcType=BIGINT}, #{unitId,jdbcType=BIGINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(MasterInfo record);

    @InsertProvider(type=MasterInfoSqlProvider.class, method="insertSelective")
    int insertSelective(MasterInfo record);

    @SelectProvider(type=MasterInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="floor", property="floor", jdbcType=JdbcType.VARCHAR),
        @Result(column="room", property="room", jdbcType=JdbcType.VARCHAR),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="tel", property="tel", jdbcType=JdbcType.VARCHAR),
        @Result(column="area_id", property="areaId", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="charge_name", property="chargeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="charge_phone", property="chargePhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="loudong", property="loudong", jdbcType=JdbcType.VARCHAR),
        @Result(column="agree_protocol", property="agreeProtocol", jdbcType=JdbcType.INTEGER),
        @Result(column="agree_protocol_time", property="agreeProtocolTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="building_id", property="buildingId", jdbcType=JdbcType.BIGINT),
        @Result(column="floor_id", property="floorId", jdbcType=JdbcType.BIGINT),
        @Result(column="unit_id", property="unitId", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<MasterInfo> selectByExample(MasterInfoExample example);

    @Select({
        "select",
        "id, community_id, floor, room, title, address, tel, area_id, status, charge_name, ",
        "charge_phone, type, loudong, agree_protocol, agree_protocol_time, building_id, ",
        "floor_id, unit_id, create_time, update_time",
        "from master_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="floor", property="floor", jdbcType=JdbcType.VARCHAR),
        @Result(column="room", property="room", jdbcType=JdbcType.VARCHAR),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="tel", property="tel", jdbcType=JdbcType.VARCHAR),
        @Result(column="area_id", property="areaId", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="charge_name", property="chargeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="charge_phone", property="chargePhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="loudong", property="loudong", jdbcType=JdbcType.VARCHAR),
        @Result(column="agree_protocol", property="agreeProtocol", jdbcType=JdbcType.INTEGER),
        @Result(column="agree_protocol_time", property="agreeProtocolTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="building_id", property="buildingId", jdbcType=JdbcType.BIGINT),
        @Result(column="floor_id", property="floorId", jdbcType=JdbcType.BIGINT),
        @Result(column="unit_id", property="unitId", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    MasterInfo selectByPrimaryKey(Long id);

    @UpdateProvider(type=MasterInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") MasterInfo record, @Param("example") MasterInfoExample example);

    @UpdateProvider(type=MasterInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") MasterInfo record, @Param("example") MasterInfoExample example);

    @UpdateProvider(type=MasterInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(MasterInfo record);

    @Update({
        "update master_info",
        "set community_id = #{communityId,jdbcType=INTEGER},",
          "floor = #{floor,jdbcType=VARCHAR},",
          "room = #{room,jdbcType=VARCHAR},",
          "title = #{title,jdbcType=VARCHAR},",
          "address = #{address,jdbcType=VARCHAR},",
          "tel = #{tel,jdbcType=VARCHAR},",
          "area_id = #{areaId,jdbcType=INTEGER},",
          "status = #{status,jdbcType=TINYINT},",
          "charge_name = #{chargeName,jdbcType=VARCHAR},",
          "charge_phone = #{chargePhone,jdbcType=VARCHAR},",
          "type = #{type,jdbcType=INTEGER},",
          "loudong = #{loudong,jdbcType=VARCHAR},",
          "agree_protocol = #{agreeProtocol,jdbcType=INTEGER},",
          "agree_protocol_time = #{agreeProtocolTime,jdbcType=TIMESTAMP},",
          "building_id = #{buildingId,jdbcType=BIGINT},",
          "floor_id = #{floorId,jdbcType=BIGINT},",
          "unit_id = #{unitId,jdbcType=BIGINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(MasterInfo record);
}