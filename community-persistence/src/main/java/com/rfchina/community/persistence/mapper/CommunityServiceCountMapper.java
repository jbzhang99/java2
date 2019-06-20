package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CommunityServiceCount;
import com.rfchina.community.persistence.model.CommunityServiceCountExample;
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

public interface CommunityServiceCountMapper extends Serializable {
    @SelectProvider(type=CommunityServiceCountSqlProvider.class, method="countByExample")
    long countByExample(CommunityServiceCountExample example);

    @DeleteProvider(type=CommunityServiceCountSqlProvider.class, method="deleteByExample")
    int deleteByExample(CommunityServiceCountExample example);

    @Delete({
        "delete from community_service_count",
        "where service_id = #{serviceId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer serviceId);

    @Insert({
        "insert into community_service_count (service_id, like_count, ",
        "unlike_count)",
        "values (#{serviceId,jdbcType=INTEGER}, #{likeCount,jdbcType=INTEGER}, ",
        "#{unlikeCount,jdbcType=INTEGER})"
    })
    int insert(CommunityServiceCount record);

    @InsertProvider(type=CommunityServiceCountSqlProvider.class, method="insertSelective")
    int insertSelective(CommunityServiceCount record);

    @SelectProvider(type=CommunityServiceCountSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="like_count", property="likeCount", jdbcType=JdbcType.INTEGER),
        @Result(column="unlike_count", property="unlikeCount", jdbcType=JdbcType.INTEGER)
    })
    List<CommunityServiceCount> selectByExample(CommunityServiceCountExample example);

    @Select({
        "select",
        "service_id, like_count, unlike_count",
        "from community_service_count",
        "where service_id = #{serviceId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="like_count", property="likeCount", jdbcType=JdbcType.INTEGER),
        @Result(column="unlike_count", property="unlikeCount", jdbcType=JdbcType.INTEGER)
    })
    CommunityServiceCount selectByPrimaryKey(Integer serviceId);

    @UpdateProvider(type=CommunityServiceCountSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CommunityServiceCount record, @Param("example") CommunityServiceCountExample example);

    @UpdateProvider(type=CommunityServiceCountSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CommunityServiceCount record, @Param("example") CommunityServiceCountExample example);

    @UpdateProvider(type=CommunityServiceCountSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CommunityServiceCount record);

    @Update({
        "update community_service_count",
        "set like_count = #{likeCount,jdbcType=INTEGER},",
          "unlike_count = #{unlikeCount,jdbcType=INTEGER}",
        "where service_id = #{serviceId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CommunityServiceCount record);
}