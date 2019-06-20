package com.rfchina.community.openweb.mapper.ext;

import com.rfchina.community.openweb.entity.StoreCardInfoExt;
import com.rfchina.community.persistence.mapper.CardInfoSqlProvider;
import com.rfchina.community.persistence.model.CardInfo;
import com.rfchina.community.persistence.model.CardInfoExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;

import java.util.Map;

/**
 */
public interface ExtCardInfoMapper {

    @SelectProvider(type=ExtCardInfoSqlProvider.class, method="countOperationByExample")
    long countOperationByExample(CardInfoExample example);

    @SelectProvider(type = ExtCardInfoSqlProvider.class, method = "pageByExample")
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "category_id", property = "categoryId", jdbcType = JdbcType.INTEGER),
            @Result(column = "template_id", property = "templateId", jdbcType = JdbcType.INTEGER),
            @Result(column = "community_id", property = "communityId", jdbcType = JdbcType.INTEGER),
            @Result(column = "title", property = "title", jdbcType = JdbcType.VARCHAR),
            @Result(column = "content", property = "content", jdbcType = JdbcType.VARCHAR),
            @Result(column = "status", property = "status", jdbcType = JdbcType.TINYINT),
            @Result(column = "audit_status", property = "auditStatus", jdbcType = JdbcType.TINYINT),
            @Result(column = "audit_reason", property = "auditReason", jdbcType = JdbcType.VARCHAR),
            @Result(column = "square_audit_reason", property = "squareAuditReason", jdbcType = JdbcType.VARCHAR),
            @Result(column = "square_audit_status", property = "squareAuditStatus", jdbcType = JdbcType.TINYINT),
            @Result(column = "square_audit_time", property = "squareAuditTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "square_publish_time", property = "squarePublishTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "publish_time", property = "publishTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "attachment", property = "attachment", jdbcType = JdbcType.VARCHAR),
            @Result(column = "subject_id", property = "subjectId", jdbcType = JdbcType.BIGINT),
            @Result(column = "subject_name", property = "subjectName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "subject_type", property = "subjectType", jdbcType = JdbcType.INTEGER),
            @Result(column = "subject_icon", property = "subjectIcon", jdbcType = JdbcType.VARCHAR),
            @Result(column = "pub_to_square", property = "pubToSquare", jdbcType = JdbcType.TINYINT),
            @Result(column = "creator_id", property = "creatorId", jdbcType = JdbcType.BIGINT),
            @Result(column = "cid", property = "cid", jdbcType = JdbcType.BIGINT),
            @Result(column = "apply_time", property = "applyTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "delete_time", property = "deleteTime", jdbcType = JdbcType.TIMESTAMP)
    })
    PageList<CardInfo> pageByExample(@Param("example") CardInfoExample example, PageBounds pageBounds);

    @SelectProvider(type = ExtCardInfoSqlProvider.class, method = "pageByExampleOrderBy")
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "category_id", property = "categoryId", jdbcType = JdbcType.INTEGER),
            @Result(column = "template_id", property = "templateId", jdbcType = JdbcType.INTEGER),
            @Result(column = "community_id", property = "communityId", jdbcType = JdbcType.INTEGER),
            @Result(column = "title", property = "title", jdbcType = JdbcType.VARCHAR),
            @Result(column = "content", property = "content", jdbcType = JdbcType.VARCHAR),
            @Result(column = "status", property = "status", jdbcType = JdbcType.TINYINT),
            @Result(column = "audit_status", property = "auditStatus", jdbcType = JdbcType.TINYINT),
            @Result(column = "audit_reason", property = "auditReason", jdbcType = JdbcType.VARCHAR),
            @Result(column = "square_audit_reason", property = "squareAuditReason", jdbcType = JdbcType.VARCHAR),
            @Result(column = "square_audit_status", property = "squareAuditStatus", jdbcType = JdbcType.TINYINT),
            @Result(column = "square_audit_time", property = "squareAuditTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "square_publish_time", property = "squarePublishTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "publish_time", property = "publishTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "attachment", property = "attachment", jdbcType = JdbcType.VARCHAR),
            @Result(column = "subject_id", property = "subjectId", jdbcType = JdbcType.BIGINT),
            @Result(column = "subject_name", property = "subjectName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "subject_type", property = "subjectType", jdbcType = JdbcType.INTEGER),
            @Result(column = "subject_icon", property = "subjectIcon", jdbcType = JdbcType.VARCHAR),
            @Result(column = "pub_to_square", property = "pubToSquare", jdbcType = JdbcType.TINYINT),
            @Result(column = "creator_id", property = "creatorId", jdbcType = JdbcType.BIGINT),
            @Result(column = "cid", property = "cid", jdbcType = JdbcType.BIGINT),
            @Result(column = "apply_time", property = "applyTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "delete_time", property = "deleteTime", jdbcType = JdbcType.TIMESTAMP)
    })
    PageList<CardInfo> pageByExampleOrderBy(@Param("example") CardInfoExample example, PageBounds pageBounds);

    @SelectProvider(type = ExtCardInfoSqlProvider.class, method = "pageByExample4Store")
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "category_id", property = "categoryId", jdbcType = JdbcType.INTEGER),
            @Result(column = "merchant_name", property = "merchantName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "service_name", property = "serviceName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "operation_id", property = "operationId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "template_id", property = "templateId", jdbcType = JdbcType.INTEGER),
            @Result(column = "community_id", property = "communityId", jdbcType = JdbcType.INTEGER),
            @Result(column = "title", property = "title", jdbcType = JdbcType.VARCHAR),
            @Result(column = "content", property = "content", jdbcType = JdbcType.VARCHAR),
            @Result(column = "status", property = "status", jdbcType = JdbcType.TINYINT),
            @Result(column = "audit_status", property = "auditStatus", jdbcType = JdbcType.TINYINT),
            @Result(column = "audit_reason", property = "auditReason", jdbcType = JdbcType.VARCHAR),
            @Result(column = "square_audit_reason", property = "squareAuditReason", jdbcType = JdbcType.VARCHAR),
            @Result(column = "square_audit_status", property = "squareAuditStatus", jdbcType = JdbcType.TINYINT),
            @Result(column = "square_audit_time", property = "squareAuditTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "square_publish_time", property = "squarePublishTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "publish_time", property = "publishTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "attachment", property = "attachment", jdbcType = JdbcType.VARCHAR),
            @Result(column = "subject_id", property = "subjectId", jdbcType = JdbcType.BIGINT),
            @Result(column = "subject_name", property = "subjectName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "subject_type", property = "subjectType", jdbcType = JdbcType.INTEGER),
            @Result(column = "subject_icon", property = "subjectIcon", jdbcType = JdbcType.VARCHAR),
            @Result(column = "pub_to_square", property = "pubToSquare", jdbcType = JdbcType.TINYINT),
            @Result(column = "creator_id", property = "creatorId", jdbcType = JdbcType.BIGINT),
            @Result(column = "cid", property = "cid", jdbcType = JdbcType.BIGINT),
            @Result(column = "apply_time", property = "applyTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "delete_time", property = "deleteTime", jdbcType = JdbcType.TIMESTAMP)
    })
    PageList<StoreCardInfoExt> pageByExample4Store(Map<String, Object> param, PageBounds pageBounds);
}
