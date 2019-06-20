package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.Ad;
import com.rfchina.community.persistence.model.AdExample;
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

public interface AdMapper extends Serializable {
    @SelectProvider(type=AdSqlProvider.class, method="countByExample")
    long countByExample(AdExample example);

    @DeleteProvider(type=AdSqlProvider.class, method="deleteByExample")
    int deleteByExample(AdExample example);

    @Delete({
        "delete from ad",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into ad (category_id, community_id, ",
        "name, img_url, link, ",
        "sorting, status, ",
        "src_type, click_count, ",
        "intro, reason, platform_reason, ",
        "leader_reason, start_time, ",
        "end_time, create_time, ",
        "audit_time, leader_audit_time, ",
        "platform_audit_time, publish_time, ",
        "auto_publish, auto_publish_time, ",
        "auto_repeal, auto_repeal_time, ",
        "apply_admin_id, apply_time)",
        "values (#{categoryId,jdbcType=INTEGER}, #{communityId,jdbcType=INTEGER}, ",
        "#{name,jdbcType=VARCHAR}, #{imgUrl,jdbcType=VARCHAR}, #{link,jdbcType=VARCHAR}, ",
        "#{sorting,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, ",
        "#{srcType,jdbcType=INTEGER}, #{clickCount,jdbcType=INTEGER}, ",
        "#{intro,jdbcType=VARCHAR}, #{reason,jdbcType=VARCHAR}, #{platformReason,jdbcType=VARCHAR}, ",
        "#{leaderReason,jdbcType=VARCHAR}, #{startTime,jdbcType=TIMESTAMP}, ",
        "#{endTime,jdbcType=TIMESTAMP}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{auditTime,jdbcType=TIMESTAMP}, #{leaderAuditTime,jdbcType=TIMESTAMP}, ",
        "#{platformAuditTime,jdbcType=TIMESTAMP}, #{publishTime,jdbcType=TIMESTAMP}, ",
        "#{autoPublish,jdbcType=TINYINT}, #{autoPublishTime,jdbcType=TIMESTAMP}, ",
        "#{autoRepeal,jdbcType=TINYINT}, #{autoRepealTime,jdbcType=TIMESTAMP}, ",
        "#{applyAdminId,jdbcType=BIGINT}, #{applyTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(Ad record);

    @InsertProvider(type=AdSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(Ad record);

    @SelectProvider(type=AdSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="category_id", property="categoryId", jdbcType=JdbcType.INTEGER),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="img_url", property="imgUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="link", property="link", jdbcType=JdbcType.VARCHAR),
        @Result(column="sorting", property="sorting", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="src_type", property="srcType", jdbcType=JdbcType.INTEGER),
        @Result(column="click_count", property="clickCount", jdbcType=JdbcType.INTEGER),
        @Result(column="intro", property="intro", jdbcType=JdbcType.VARCHAR),
        @Result(column="reason", property="reason", jdbcType=JdbcType.VARCHAR),
        @Result(column="platform_reason", property="platformReason", jdbcType=JdbcType.VARCHAR),
        @Result(column="leader_reason", property="leaderReason", jdbcType=JdbcType.VARCHAR),
        @Result(column="start_time", property="startTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="end_time", property="endTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="audit_time", property="auditTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="leader_audit_time", property="leaderAuditTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="platform_audit_time", property="platformAuditTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="publish_time", property="publishTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="auto_publish", property="autoPublish", jdbcType=JdbcType.TINYINT),
        @Result(column="auto_publish_time", property="autoPublishTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="auto_repeal", property="autoRepeal", jdbcType=JdbcType.TINYINT),
        @Result(column="auto_repeal_time", property="autoRepealTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="apply_admin_id", property="applyAdminId", jdbcType=JdbcType.BIGINT),
        @Result(column="apply_time", property="applyTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Ad> selectByExample(AdExample example);

    @Select({
        "select",
        "id, category_id, community_id, name, img_url, link, sorting, status, src_type, ",
        "click_count, intro, reason, platform_reason, leader_reason, start_time, end_time, ",
        "create_time, audit_time, leader_audit_time, platform_audit_time, publish_time, ",
        "auto_publish, auto_publish_time, auto_repeal, auto_repeal_time, apply_admin_id, ",
        "apply_time",
        "from ad",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="category_id", property="categoryId", jdbcType=JdbcType.INTEGER),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="img_url", property="imgUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="link", property="link", jdbcType=JdbcType.VARCHAR),
        @Result(column="sorting", property="sorting", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="src_type", property="srcType", jdbcType=JdbcType.INTEGER),
        @Result(column="click_count", property="clickCount", jdbcType=JdbcType.INTEGER),
        @Result(column="intro", property="intro", jdbcType=JdbcType.VARCHAR),
        @Result(column="reason", property="reason", jdbcType=JdbcType.VARCHAR),
        @Result(column="platform_reason", property="platformReason", jdbcType=JdbcType.VARCHAR),
        @Result(column="leader_reason", property="leaderReason", jdbcType=JdbcType.VARCHAR),
        @Result(column="start_time", property="startTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="end_time", property="endTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="audit_time", property="auditTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="leader_audit_time", property="leaderAuditTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="platform_audit_time", property="platformAuditTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="publish_time", property="publishTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="auto_publish", property="autoPublish", jdbcType=JdbcType.TINYINT),
        @Result(column="auto_publish_time", property="autoPublishTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="auto_repeal", property="autoRepeal", jdbcType=JdbcType.TINYINT),
        @Result(column="auto_repeal_time", property="autoRepealTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="apply_admin_id", property="applyAdminId", jdbcType=JdbcType.BIGINT),
        @Result(column="apply_time", property="applyTime", jdbcType=JdbcType.TIMESTAMP)
    })
    Ad selectByPrimaryKey(Integer id);

    @UpdateProvider(type=AdSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Ad record, @Param("example") AdExample example);

    @UpdateProvider(type=AdSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Ad record, @Param("example") AdExample example);

    @UpdateProvider(type=AdSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Ad record);

    @Update({
        "update ad",
        "set category_id = #{categoryId,jdbcType=INTEGER},",
          "community_id = #{communityId,jdbcType=INTEGER},",
          "name = #{name,jdbcType=VARCHAR},",
          "img_url = #{imgUrl,jdbcType=VARCHAR},",
          "link = #{link,jdbcType=VARCHAR},",
          "sorting = #{sorting,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "src_type = #{srcType,jdbcType=INTEGER},",
          "click_count = #{clickCount,jdbcType=INTEGER},",
          "intro = #{intro,jdbcType=VARCHAR},",
          "reason = #{reason,jdbcType=VARCHAR},",
          "platform_reason = #{platformReason,jdbcType=VARCHAR},",
          "leader_reason = #{leaderReason,jdbcType=VARCHAR},",
          "start_time = #{startTime,jdbcType=TIMESTAMP},",
          "end_time = #{endTime,jdbcType=TIMESTAMP},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "audit_time = #{auditTime,jdbcType=TIMESTAMP},",
          "leader_audit_time = #{leaderAuditTime,jdbcType=TIMESTAMP},",
          "platform_audit_time = #{platformAuditTime,jdbcType=TIMESTAMP},",
          "publish_time = #{publishTime,jdbcType=TIMESTAMP},",
          "auto_publish = #{autoPublish,jdbcType=TINYINT},",
          "auto_publish_time = #{autoPublishTime,jdbcType=TIMESTAMP},",
          "auto_repeal = #{autoRepeal,jdbcType=TINYINT},",
          "auto_repeal_time = #{autoRepealTime,jdbcType=TIMESTAMP},",
          "apply_admin_id = #{applyAdminId,jdbcType=BIGINT},",
          "apply_time = #{applyTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Ad record);
}