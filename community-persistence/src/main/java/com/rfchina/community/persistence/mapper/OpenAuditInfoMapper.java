package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenAuditInfo;
import com.rfchina.community.persistence.model.OpenAuditInfoExample;
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

public interface OpenAuditInfoMapper extends BaseMapper<OpenAuditInfo,OpenAuditInfoExample,Long> {
    @SelectProvider(type=OpenAuditInfoSqlProvider.class, method="countByExample")
    long countByExample(OpenAuditInfoExample example);

    @DeleteProvider(type=OpenAuditInfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenAuditInfoExample example);

    @Delete({
        "delete from open_audit_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into open_audit_info (create_time, update_time, ",
        "src_uid, audit_type, ",
        "audit_status, audit_content, ",
        "object_id, audit_uid, ",
        "service_id, pager_id, ",
        "merchant_id, audit_phone, ",
        "audit_name)",
        "values (#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{srcUid,jdbcType=BIGINT}, #{auditType,jdbcType=VARCHAR}, ",
        "#{auditStatus,jdbcType=INTEGER}, #{auditContent,jdbcType=VARCHAR}, ",
        "#{objectId,jdbcType=VARCHAR}, #{auditUid,jdbcType=BIGINT}, ",
        "#{serviceId,jdbcType=INTEGER}, #{pagerId,jdbcType=VARCHAR}, ",
        "#{merchantId,jdbcType=BIGINT}, #{auditPhone,jdbcType=VARCHAR}, ",
        "#{auditName,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(OpenAuditInfo record);

    @InsertProvider(type=OpenAuditInfoSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(OpenAuditInfo record);

    @SelectProvider(type=OpenAuditInfoSqlProvider.class, method="selectByExample")
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
    List<OpenAuditInfo> selectByExample(OpenAuditInfoExample example);

    @Select({
        "select",
        "id, create_time, update_time, src_uid, audit_type, audit_status, audit_content, ",
        "object_id, audit_uid, service_id, pager_id, merchant_id, audit_phone, audit_name",
        "from open_audit_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
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
    OpenAuditInfo selectByPrimaryKey(Long id);

    @UpdateProvider(type=OpenAuditInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenAuditInfo record, @Param("example") OpenAuditInfoExample example);

    @UpdateProvider(type=OpenAuditInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenAuditInfo record, @Param("example") OpenAuditInfoExample example);

    @UpdateProvider(type=OpenAuditInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpenAuditInfo record);

    @Update({
        "update open_audit_info",
        "set create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "src_uid = #{srcUid,jdbcType=BIGINT},",
          "audit_type = #{auditType,jdbcType=VARCHAR},",
          "audit_status = #{auditStatus,jdbcType=INTEGER},",
          "audit_content = #{auditContent,jdbcType=VARCHAR},",
          "object_id = #{objectId,jdbcType=VARCHAR},",
          "audit_uid = #{auditUid,jdbcType=BIGINT},",
          "service_id = #{serviceId,jdbcType=INTEGER},",
          "pager_id = #{pagerId,jdbcType=VARCHAR},",
          "merchant_id = #{merchantId,jdbcType=BIGINT},",
          "audit_phone = #{auditPhone,jdbcType=VARCHAR},",
          "audit_name = #{auditName,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(OpenAuditInfo record);
}