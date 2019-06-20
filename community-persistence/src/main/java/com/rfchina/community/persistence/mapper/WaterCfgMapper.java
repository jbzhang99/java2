package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.WaterCfg;
import com.rfchina.community.persistence.model.WaterCfgExample;
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

public interface WaterCfgMapper extends Serializable {
    @SelectProvider(type=WaterCfgSqlProvider.class, method="countByExample")
    long countByExample(WaterCfgExample example);

    @DeleteProvider(type=WaterCfgSqlProvider.class, method="deleteByExample")
    int deleteByExample(WaterCfgExample example);

    @Delete({
        "delete from water_cfg",
        "where community_id = #{communityId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer communityId);

    @Insert({
        "insert into water_cfg (community_id, phone, ",
        "interval_limit, remark, ",
        "create_time, update_time)",
        "values (#{communityId,jdbcType=INTEGER}, #{phone,jdbcType=VARCHAR}, ",
        "#{intervalLimit,jdbcType=INTEGER}, #{remark,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(WaterCfg record);

    @InsertProvider(type=WaterCfgSqlProvider.class, method="insertSelective")
    int insertSelective(WaterCfg record);

    @SelectProvider(type=WaterCfgSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="interval_limit", property="intervalLimit", jdbcType=JdbcType.INTEGER),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<WaterCfg> selectByExample(WaterCfgExample example);

    @Select({
        "select",
        "community_id, phone, interval_limit, remark, create_time, update_time",
        "from water_cfg",
        "where community_id = #{communityId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="interval_limit", property="intervalLimit", jdbcType=JdbcType.INTEGER),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    WaterCfg selectByPrimaryKey(Integer communityId);

    @UpdateProvider(type=WaterCfgSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") WaterCfg record, @Param("example") WaterCfgExample example);

    @UpdateProvider(type=WaterCfgSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") WaterCfg record, @Param("example") WaterCfgExample example);

    @UpdateProvider(type=WaterCfgSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(WaterCfg record);

    @Update({
        "update water_cfg",
        "set phone = #{phone,jdbcType=VARCHAR},",
          "interval_limit = #{intervalLimit,jdbcType=INTEGER},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where community_id = #{communityId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(WaterCfg record);
}