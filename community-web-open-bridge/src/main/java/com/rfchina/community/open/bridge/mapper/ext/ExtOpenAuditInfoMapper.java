package com.rfchina.community.open.bridge.mapper.ext;
import com.rfchina.community.persistence.model.OpenAuditInfo;
import com.rfchina.community.persistence.model.OpenAuditInfoExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;

import java.io.Serializable;
import java.util.Map;
public interface ExtOpenAuditInfoMapper extends Serializable {

	@SelectProvider(type = ExtOpenAuditInfoSqlProvider.class, method = "pageByExample")
	@Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="src_uid", property="srcUid", jdbcType=JdbcType.BIGINT),
        @Result(column="audit_type", property="auditType", jdbcType=JdbcType.VARCHAR),
        @Result(column="audit_status", property="auditStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="audit_content", property="auditContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="object_id", property="objectId", jdbcType=JdbcType.VARCHAR),
        @Result(column="audit_uid", property="auditUid", jdbcType=JdbcType.BIGINT),
		@Result(column="audit_phone", property="auditPhone", jdbcType=JdbcType.VARCHAR),
		@Result(column="audit_name", property="auditName", jdbcType=JdbcType.VARCHAR),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER)
    })
	PageList<OpenAuditInfo> pageByExample(@Param("example") OpenAuditInfoExample example, PageBounds pageBounds);

	
	@SelectProvider(type = ExtOpenAuditInfoSqlProvider.class, method = "pageByParam")
	@Results({
		  	@Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
	        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
	        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
	        @Result(column="src_uid", property="srcUid", jdbcType=JdbcType.BIGINT),
	        @Result(column="audit_type", property="auditType", jdbcType=JdbcType.VARCHAR),
	        @Result(column="audit_status", property="auditStatus", jdbcType=JdbcType.INTEGER),
	        @Result(column="audit_content", property="auditContent", jdbcType=JdbcType.VARCHAR),
	        @Result(column="object_id", property="objectId", jdbcType=JdbcType.VARCHAR),
	        @Result(column="audit_uid", property="auditUid", jdbcType=JdbcType.BIGINT),
	        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
	        @Result(column="pager_id", property="pagerId", jdbcType=JdbcType.VARCHAR),
	        @Result(column="merchant_id", property="merchantId", jdbcType=JdbcType.BIGINT),
	        @Result(column="audit_phone", property="auditPhone", jdbcType=JdbcType.VARCHAR),
	        @Result(column="audit_name", property="auditName", jdbcType=JdbcType.VARCHAR)
    })
	PageList<OpenAuditInfo> pageByParam(Map<String, Object> param, PageBounds pageBounds);

	@SelectProvider(type = ExtOpenAuditInfoSqlProvider.class, method = "listOpenXFSJMerchantAuditInfo")
	PageList<Map<String, Object>> listOpenXFSJMerchantAuditInfo(Map<String, Object> param, PageBounds pageBounds);
}