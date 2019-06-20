package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.VisitAppointment;
import com.rfchina.community.persistence.model.VisitAppointmentExample;
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

public interface VisitAppointmentMapper extends Serializable {
    @SelectProvider(type=VisitAppointmentSqlProvider.class, method="countByExample")
    long countByExample(VisitAppointmentExample example);

    @DeleteProvider(type=VisitAppointmentSqlProvider.class, method="deleteByExample")
    int deleteByExample(VisitAppointmentExample example);

    @Delete({
        "delete from visit_appointment",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into visit_appointment (community_id, master_id, ",
        "visitor, visitor_phone, ",
        "visitor_uid, visitor_read_status, ",
        "follow_qty, type, ",
        "duration, create_uid, ",
        "create_date, appointment_date, ",
        "master_audit_status, master_audit_time, ",
        "master_audit_uid, master_audit_phone, ",
        "community_audit_time, community_audit_uid, ",
        "community_audit_status, visitor_audit_time, ",
        "visitor_audit_uid, visitor_audit_status, ",
        "renew_audit_time, renew_audit_uid, ",
        "renew_audit_status, status, ",
        "token)",
        "values (#{communityId,jdbcType=INTEGER}, #{masterId,jdbcType=BIGINT}, ",
        "#{visitor,jdbcType=VARCHAR}, #{visitorPhone,jdbcType=VARCHAR}, ",
        "#{visitorUid,jdbcType=BIGINT}, #{visitorReadStatus,jdbcType=TINYINT}, ",
        "#{followQty,jdbcType=INTEGER}, #{type,jdbcType=TINYINT}, ",
        "#{duration,jdbcType=INTEGER}, #{createUid,jdbcType=BIGINT}, ",
        "#{createDate,jdbcType=TIMESTAMP}, #{appointmentDate,jdbcType=DATE}, ",
        "#{masterAuditStatus,jdbcType=INTEGER}, #{masterAuditTime,jdbcType=TIMESTAMP}, ",
        "#{masterAuditUid,jdbcType=BIGINT}, #{masterAuditPhone,jdbcType=VARCHAR}, ",
        "#{communityAuditTime,jdbcType=TIMESTAMP}, #{communityAuditUid,jdbcType=BIGINT}, ",
        "#{communityAuditStatus,jdbcType=TINYINT}, #{visitorAuditTime,jdbcType=TIMESTAMP}, ",
        "#{visitorAuditUid,jdbcType=BIGINT}, #{visitorAuditStatus,jdbcType=TINYINT}, ",
        "#{renewAuditTime,jdbcType=TIMESTAMP}, #{renewAuditUid,jdbcType=BIGINT}, ",
        "#{renewAuditStatus,jdbcType=TINYINT}, #{status,jdbcType=TINYINT}, ",
        "#{token,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(VisitAppointment record);

    @InsertProvider(type=VisitAppointmentSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(VisitAppointment record);

    @SelectProvider(type=VisitAppointmentSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="master_id", property="masterId", jdbcType=JdbcType.BIGINT),
        @Result(column="visitor", property="visitor", jdbcType=JdbcType.VARCHAR),
        @Result(column="visitor_phone", property="visitorPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="visitor_uid", property="visitorUid", jdbcType=JdbcType.BIGINT),
        @Result(column="visitor_read_status", property="visitorReadStatus", jdbcType=JdbcType.TINYINT),
        @Result(column="follow_qty", property="followQty", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.TINYINT),
        @Result(column="duration", property="duration", jdbcType=JdbcType.INTEGER),
        @Result(column="create_uid", property="createUid", jdbcType=JdbcType.BIGINT),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="appointment_date", property="appointmentDate", jdbcType=JdbcType.DATE),
        @Result(column="master_audit_status", property="masterAuditStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="master_audit_time", property="masterAuditTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="master_audit_uid", property="masterAuditUid", jdbcType=JdbcType.BIGINT),
        @Result(column="master_audit_phone", property="masterAuditPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="community_audit_time", property="communityAuditTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="community_audit_uid", property="communityAuditUid", jdbcType=JdbcType.BIGINT),
        @Result(column="community_audit_status", property="communityAuditStatus", jdbcType=JdbcType.TINYINT),
        @Result(column="visitor_audit_time", property="visitorAuditTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="visitor_audit_uid", property="visitorAuditUid", jdbcType=JdbcType.BIGINT),
        @Result(column="visitor_audit_status", property="visitorAuditStatus", jdbcType=JdbcType.TINYINT),
        @Result(column="renew_audit_time", property="renewAuditTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="renew_audit_uid", property="renewAuditUid", jdbcType=JdbcType.BIGINT),
        @Result(column="renew_audit_status", property="renewAuditStatus", jdbcType=JdbcType.TINYINT),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="token", property="token", jdbcType=JdbcType.VARCHAR)
    })
    List<VisitAppointment> selectByExample(VisitAppointmentExample example);

    @Select({
        "select",
        "id, community_id, master_id, visitor, visitor_phone, visitor_uid, visitor_read_status, ",
        "follow_qty, type, duration, create_uid, create_date, appointment_date, master_audit_status, ",
        "master_audit_time, master_audit_uid, master_audit_phone, community_audit_time, ",
        "community_audit_uid, community_audit_status, visitor_audit_time, visitor_audit_uid, ",
        "visitor_audit_status, renew_audit_time, renew_audit_uid, renew_audit_status, ",
        "status, token",
        "from visit_appointment",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER),
        @Result(column="master_id", property="masterId", jdbcType=JdbcType.BIGINT),
        @Result(column="visitor", property="visitor", jdbcType=JdbcType.VARCHAR),
        @Result(column="visitor_phone", property="visitorPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="visitor_uid", property="visitorUid", jdbcType=JdbcType.BIGINT),
        @Result(column="visitor_read_status", property="visitorReadStatus", jdbcType=JdbcType.TINYINT),
        @Result(column="follow_qty", property="followQty", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.TINYINT),
        @Result(column="duration", property="duration", jdbcType=JdbcType.INTEGER),
        @Result(column="create_uid", property="createUid", jdbcType=JdbcType.BIGINT),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="appointment_date", property="appointmentDate", jdbcType=JdbcType.DATE),
        @Result(column="master_audit_status", property="masterAuditStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="master_audit_time", property="masterAuditTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="master_audit_uid", property="masterAuditUid", jdbcType=JdbcType.BIGINT),
        @Result(column="master_audit_phone", property="masterAuditPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="community_audit_time", property="communityAuditTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="community_audit_uid", property="communityAuditUid", jdbcType=JdbcType.BIGINT),
        @Result(column="community_audit_status", property="communityAuditStatus", jdbcType=JdbcType.TINYINT),
        @Result(column="visitor_audit_time", property="visitorAuditTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="visitor_audit_uid", property="visitorAuditUid", jdbcType=JdbcType.BIGINT),
        @Result(column="visitor_audit_status", property="visitorAuditStatus", jdbcType=JdbcType.TINYINT),
        @Result(column="renew_audit_time", property="renewAuditTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="renew_audit_uid", property="renewAuditUid", jdbcType=JdbcType.BIGINT),
        @Result(column="renew_audit_status", property="renewAuditStatus", jdbcType=JdbcType.TINYINT),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="token", property="token", jdbcType=JdbcType.VARCHAR)
    })
    VisitAppointment selectByPrimaryKey(Long id);

    @UpdateProvider(type=VisitAppointmentSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") VisitAppointment record, @Param("example") VisitAppointmentExample example);

    @UpdateProvider(type=VisitAppointmentSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") VisitAppointment record, @Param("example") VisitAppointmentExample example);

    @UpdateProvider(type=VisitAppointmentSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(VisitAppointment record);

    @Update({
        "update visit_appointment",
        "set community_id = #{communityId,jdbcType=INTEGER},",
          "master_id = #{masterId,jdbcType=BIGINT},",
          "visitor = #{visitor,jdbcType=VARCHAR},",
          "visitor_phone = #{visitorPhone,jdbcType=VARCHAR},",
          "visitor_uid = #{visitorUid,jdbcType=BIGINT},",
          "visitor_read_status = #{visitorReadStatus,jdbcType=TINYINT},",
          "follow_qty = #{followQty,jdbcType=INTEGER},",
          "type = #{type,jdbcType=TINYINT},",
          "duration = #{duration,jdbcType=INTEGER},",
          "create_uid = #{createUid,jdbcType=BIGINT},",
          "create_date = #{createDate,jdbcType=TIMESTAMP},",
          "appointment_date = #{appointmentDate,jdbcType=DATE},",
          "master_audit_status = #{masterAuditStatus,jdbcType=INTEGER},",
          "master_audit_time = #{masterAuditTime,jdbcType=TIMESTAMP},",
          "master_audit_uid = #{masterAuditUid,jdbcType=BIGINT},",
          "master_audit_phone = #{masterAuditPhone,jdbcType=VARCHAR},",
          "community_audit_time = #{communityAuditTime,jdbcType=TIMESTAMP},",
          "community_audit_uid = #{communityAuditUid,jdbcType=BIGINT},",
          "community_audit_status = #{communityAuditStatus,jdbcType=TINYINT},",
          "visitor_audit_time = #{visitorAuditTime,jdbcType=TIMESTAMP},",
          "visitor_audit_uid = #{visitorAuditUid,jdbcType=BIGINT},",
          "visitor_audit_status = #{visitorAuditStatus,jdbcType=TINYINT},",
          "renew_audit_time = #{renewAuditTime,jdbcType=TIMESTAMP},",
          "renew_audit_uid = #{renewAuditUid,jdbcType=BIGINT},",
          "renew_audit_status = #{renewAuditStatus,jdbcType=TINYINT},",
          "status = #{status,jdbcType=TINYINT},",
          "token = #{token,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(VisitAppointment record);
}