package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.StatAttUser;
import com.rfchina.community.persistence.model.StatAttUserExample;
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

public interface StatAttUserMapper extends Serializable {
    @SelectProvider(type=StatAttUserSqlProvider.class, method="countByExample")
    long countByExample(StatAttUserExample example);

    @DeleteProvider(type=StatAttUserSqlProvider.class, method="deleteByExample")
    int deleteByExample(StatAttUserExample example);

    @Delete({
        "delete from stat_att_user",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into stat_att_user (area_id, community_id, ",
        "community_type, acc_count, ",
        "cur_count, stat_time, ",
        "create_time)",
        "values (#{areaId,jdbcType=INTEGER}, #{communityId,jdbcType=INTEGER}, ",
        "#{communityType,jdbcType=INTEGER}, #{accCount,jdbcType=INTEGER}, ",
        "#{curCount,jdbcType=INTEGER}, #{statTime,jdbcType=TIMESTAMP}, ",
        "#{createTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(StatAttUser record);

    @InsertProvider(type=StatAttUserSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(StatAttUser record);

    @SelectProvider(type=StatAttUserSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="area_id", property="areaId", jdbcType=JdbcType.INTEGER),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="community_type", property="communityType", jdbcType=JdbcType.INTEGER),
        @Result(column="acc_count", property="accCount", jdbcType=JdbcType.INTEGER),
        @Result(column="cur_count", property="curCount", jdbcType=JdbcType.INTEGER),
        @Result(column="stat_time", property="statTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<StatAttUser> selectByExample(StatAttUserExample example);

    @Select({
        "select",
        "id, area_id, community_id, community_type, acc_count, cur_count, stat_time, ",
        "create_time",
        "from stat_att_user",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="area_id", property="areaId", jdbcType=JdbcType.INTEGER),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="community_type", property="communityType", jdbcType=JdbcType.INTEGER),
        @Result(column="acc_count", property="accCount", jdbcType=JdbcType.INTEGER),
        @Result(column="cur_count", property="curCount", jdbcType=JdbcType.INTEGER),
        @Result(column="stat_time", property="statTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    StatAttUser selectByPrimaryKey(Long id);

    @UpdateProvider(type=StatAttUserSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") StatAttUser record, @Param("example") StatAttUserExample example);

    @UpdateProvider(type=StatAttUserSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") StatAttUser record, @Param("example") StatAttUserExample example);

    @UpdateProvider(type=StatAttUserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(StatAttUser record);

    @Update({
        "update stat_att_user",
        "set area_id = #{areaId,jdbcType=INTEGER},",
          "community_id = #{communityId,jdbcType=INTEGER},",
          "community_type = #{communityType,jdbcType=INTEGER},",
          "acc_count = #{accCount,jdbcType=INTEGER},",
          "cur_count = #{curCount,jdbcType=INTEGER},",
          "stat_time = #{statTime,jdbcType=TIMESTAMP},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(StatAttUser record);
}