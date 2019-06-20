package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.UserDefaultCommunity;
import com.rfchina.community.persistence.model.UserDefaultCommunityExample;
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

public interface UserDefaultCommunityMapper extends Serializable {
    @SelectProvider(type=UserDefaultCommunitySqlProvider.class, method="countByExample")
    long countByExample(UserDefaultCommunityExample example);

    @DeleteProvider(type=UserDefaultCommunitySqlProvider.class, method="deleteByExample")
    int deleteByExample(UserDefaultCommunityExample example);

    @Delete({
        "delete from user_default_community",
        "where uid = #{uid,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long uid);

    @Insert({
        "insert into user_default_community (uid, community_id, ",
        "create_time, update_time)",
        "values (#{uid,jdbcType=BIGINT}, #{communityId,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(UserDefaultCommunity record);

    @InsertProvider(type=UserDefaultCommunitySqlProvider.class, method="insertSelective")
    int insertSelective(UserDefaultCommunity record);

    @SelectProvider(type=UserDefaultCommunitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<UserDefaultCommunity> selectByExample(UserDefaultCommunityExample example);

    @Select({
        "select",
        "uid, community_id, create_time, update_time",
        "from user_default_community",
        "where uid = #{uid,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    UserDefaultCommunity selectByPrimaryKey(Long uid);

    @UpdateProvider(type=UserDefaultCommunitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") UserDefaultCommunity record, @Param("example") UserDefaultCommunityExample example);

    @UpdateProvider(type=UserDefaultCommunitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") UserDefaultCommunity record, @Param("example") UserDefaultCommunityExample example);

    @UpdateProvider(type=UserDefaultCommunitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserDefaultCommunity record);

    @Update({
        "update user_default_community",
        "set community_id = #{communityId,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where uid = #{uid,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(UserDefaultCommunity record);
}