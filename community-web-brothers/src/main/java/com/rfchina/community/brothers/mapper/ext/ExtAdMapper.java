package com.rfchina.community.brothers.mapper.ext;

import java.util.Date;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;

import com.rfchina.community.brothers.entity.AdSim;
import com.rfchina.community.persistence.model.Ad;
import com.rfchina.community.persistence.model.AdExample;

/**
 */
public interface ExtAdMapper {

    @SelectProvider(type=ExtAdSqlProvider.class, method="pageByExample")
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
    PageList<Ad> pageByExample(@Param("example") AdExample example, PageBounds pageBounds);

    @SelectProvider(type=ExtAdSqlProvider.class, method="pageByExampleWithJoin")
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
            @Result(column="apply_time", property="applyTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="apply_admin_name", property="applyAdminName", jdbcType=JdbcType.VARCHAR),
            @Result(column="community_name", property="communityName", jdbcType=JdbcType.VARCHAR),
            @Result(column="category_name", property="categoryName", jdbcType=JdbcType.VARCHAR)
    })
    PageList<AdSim> pageByExampleWithJoin(@Param("applyAdminName") String applyAdminName,
                                          @Param("communityName") String communityName,
                                          @Param("startAuditTime") Date startAuditTime,
                                          @Param("endAuditTime") Date endAuditTime,
                                          @Param("startPublishTime") Date startPublishTime,
                                          @Param("endPublishTime") Date endPublishTime,
                                          @Param("startApplyTime") Date startApplyTime,
                                          @Param("endApplyTime") Date endApplyTime,
                                          @Param("status") Integer status,
                                          PageBounds pageBounds);
}
