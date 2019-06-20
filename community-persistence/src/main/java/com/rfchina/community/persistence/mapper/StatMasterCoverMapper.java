package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.StatMasterCover;
import com.rfchina.community.persistence.model.StatMasterCoverExample;
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

public interface StatMasterCoverMapper extends Serializable {
    @SelectProvider(type=StatMasterCoverSqlProvider.class, method="countByExample")
    long countByExample(StatMasterCoverExample example);

    @DeleteProvider(type=StatMasterCoverSqlProvider.class, method="deleteByExample")
    int deleteByExample(StatMasterCoverExample example);

    @Delete({
        "delete from stat_master_cover",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into stat_master_cover (area_id, community_id, ",
        "community_type, master_count, ",
        "master_child_count, room_count, ",
        "parking_count, prop_type, ",
        "create_time, stat_time)",
        "values (#{areaId,jdbcType=INTEGER}, #{communityId,jdbcType=INTEGER}, ",
        "#{communityType,jdbcType=INTEGER}, #{masterCount,jdbcType=INTEGER}, ",
        "#{masterChildCount,jdbcType=INTEGER}, #{roomCount,jdbcType=INTEGER}, ",
        "#{parkingCount,jdbcType=INTEGER}, #{propType,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{statTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(StatMasterCover record);

    @InsertProvider(type=StatMasterCoverSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(StatMasterCover record);

    @SelectProvider(type=StatMasterCoverSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="area_id", property="areaId", jdbcType=JdbcType.INTEGER),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="community_type", property="communityType", jdbcType=JdbcType.INTEGER),
        @Result(column="master_count", property="masterCount", jdbcType=JdbcType.INTEGER),
        @Result(column="master_child_count", property="masterChildCount", jdbcType=JdbcType.INTEGER),
        @Result(column="room_count", property="roomCount", jdbcType=JdbcType.INTEGER),
        @Result(column="parking_count", property="parkingCount", jdbcType=JdbcType.INTEGER),
        @Result(column="prop_type", property="propType", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="stat_time", property="statTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<StatMasterCover> selectByExample(StatMasterCoverExample example);

    @Select({
        "select",
        "id, area_id, community_id, community_type, master_count, master_child_count, ",
        "room_count, parking_count, prop_type, create_time, stat_time",
        "from stat_master_cover",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="area_id", property="areaId", jdbcType=JdbcType.INTEGER),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="community_type", property="communityType", jdbcType=JdbcType.INTEGER),
        @Result(column="master_count", property="masterCount", jdbcType=JdbcType.INTEGER),
        @Result(column="master_child_count", property="masterChildCount", jdbcType=JdbcType.INTEGER),
        @Result(column="room_count", property="roomCount", jdbcType=JdbcType.INTEGER),
        @Result(column="parking_count", property="parkingCount", jdbcType=JdbcType.INTEGER),
        @Result(column="prop_type", property="propType", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="stat_time", property="statTime", jdbcType=JdbcType.TIMESTAMP)
    })
    StatMasterCover selectByPrimaryKey(Long id);

    @UpdateProvider(type=StatMasterCoverSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") StatMasterCover record, @Param("example") StatMasterCoverExample example);

    @UpdateProvider(type=StatMasterCoverSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") StatMasterCover record, @Param("example") StatMasterCoverExample example);

    @UpdateProvider(type=StatMasterCoverSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(StatMasterCover record);

    @Update({
        "update stat_master_cover",
        "set area_id = #{areaId,jdbcType=INTEGER},",
          "community_id = #{communityId,jdbcType=INTEGER},",
          "community_type = #{communityType,jdbcType=INTEGER},",
          "master_count = #{masterCount,jdbcType=INTEGER},",
          "master_child_count = #{masterChildCount,jdbcType=INTEGER},",
          "room_count = #{roomCount,jdbcType=INTEGER},",
          "parking_count = #{parkingCount,jdbcType=INTEGER},",
          "prop_type = #{propType,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "stat_time = #{statTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(StatMasterCover record);
}