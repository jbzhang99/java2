package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CommunityAdmin;
import com.rfchina.community.persistence.model.CommunityAdminExample;
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

public interface CommunityAdminMapper extends Serializable {
    @SelectProvider(type=CommunityAdminSqlProvider.class, method="countByExample")
    long countByExample(CommunityAdminExample example);

    @DeleteProvider(type=CommunityAdminSqlProvider.class, method="deleteByExample")
    int deleteByExample(CommunityAdminExample example);

    @Delete({
        "delete from community_admin",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into community_admin (id, passport_id, ",
        "community_id, realname, ",
        "phone, tel, email, ",
        "intro, status, position, ",
        "dept, delete_flag, ",
        "latest_login_time, agree_protocol, ",
        "community_ids, def_community_ids, ",
        "create_time, update_time)",
        "values (#{id,jdbcType=BIGINT}, #{passportId,jdbcType=BIGINT}, ",
        "#{communityId,jdbcType=INTEGER}, #{realname,jdbcType=VARCHAR}, ",
        "#{phone,jdbcType=VARCHAR}, #{tel,jdbcType=VARCHAR}, #{email,jdbcType=VARCHAR}, ",
        "#{intro,jdbcType=VARCHAR}, #{status,jdbcType=TINYINT}, #{position,jdbcType=VARCHAR}, ",
        "#{dept,jdbcType=VARCHAR}, #{deleteFlag,jdbcType=TINYINT}, ",
        "#{latestLoginTime,jdbcType=TIMESTAMP}, #{agreeProtocol,jdbcType=TINYINT}, ",
        "#{communityIds,jdbcType=VARCHAR}, #{defCommunityIds,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(CommunityAdmin record);

    @InsertProvider(type=CommunityAdminSqlProvider.class, method="insertSelective")
    int insertSelective(CommunityAdmin record);

    @SelectProvider(type=CommunityAdminSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="passport_id", property="passportId", jdbcType=JdbcType.BIGINT),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="realname", property="realname", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="tel", property="tel", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="intro", property="intro", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="position", property="position", jdbcType=JdbcType.VARCHAR),
        @Result(column="dept", property="dept", jdbcType=JdbcType.VARCHAR),
        @Result(column="delete_flag", property="deleteFlag", jdbcType=JdbcType.TINYINT),
        @Result(column="latest_login_time", property="latestLoginTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="agree_protocol", property="agreeProtocol", jdbcType=JdbcType.TINYINT),
        @Result(column="community_ids", property="communityIds", jdbcType=JdbcType.VARCHAR),
        @Result(column="def_community_ids", property="defCommunityIds", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<CommunityAdmin> selectByExample(CommunityAdminExample example);

    @Select({
        "select",
        "id, passport_id, community_id, realname, phone, tel, email, intro, status, position, ",
        "dept, delete_flag, latest_login_time, agree_protocol, community_ids, def_community_ids, ",
        "create_time, update_time",
        "from community_admin",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="passport_id", property="passportId", jdbcType=JdbcType.BIGINT),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="realname", property="realname", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="tel", property="tel", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="intro", property="intro", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="position", property="position", jdbcType=JdbcType.VARCHAR),
        @Result(column="dept", property="dept", jdbcType=JdbcType.VARCHAR),
        @Result(column="delete_flag", property="deleteFlag", jdbcType=JdbcType.TINYINT),
        @Result(column="latest_login_time", property="latestLoginTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="agree_protocol", property="agreeProtocol", jdbcType=JdbcType.TINYINT),
        @Result(column="community_ids", property="communityIds", jdbcType=JdbcType.VARCHAR),
        @Result(column="def_community_ids", property="defCommunityIds", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    CommunityAdmin selectByPrimaryKey(Long id);

    @UpdateProvider(type=CommunityAdminSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CommunityAdmin record, @Param("example") CommunityAdminExample example);

    @UpdateProvider(type=CommunityAdminSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CommunityAdmin record, @Param("example") CommunityAdminExample example);

    @UpdateProvider(type=CommunityAdminSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CommunityAdmin record);

    @Update({
        "update community_admin",
        "set passport_id = #{passportId,jdbcType=BIGINT},",
          "community_id = #{communityId,jdbcType=INTEGER},",
          "realname = #{realname,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "tel = #{tel,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "intro = #{intro,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=TINYINT},",
          "position = #{position,jdbcType=VARCHAR},",
          "dept = #{dept,jdbcType=VARCHAR},",
          "delete_flag = #{deleteFlag,jdbcType=TINYINT},",
          "latest_login_time = #{latestLoginTime,jdbcType=TIMESTAMP},",
          "agree_protocol = #{agreeProtocol,jdbcType=TINYINT},",
          "community_ids = #{communityIds,jdbcType=VARCHAR},",
          "def_community_ids = #{defCommunityIds,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(CommunityAdmin record);
}