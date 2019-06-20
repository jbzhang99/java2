package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.VisitVisitorInfo;
import com.rfchina.community.persistence.model.VisitVisitorInfoExample;
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

public interface VisitVisitorInfoMapper extends Serializable {
    @SelectProvider(type=VisitVisitorInfoSqlProvider.class, method="countByExample")
    long countByExample(VisitVisitorInfoExample example);

    @DeleteProvider(type=VisitVisitorInfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(VisitVisitorInfoExample example);

    @Delete({
        "delete from visit_visitor_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into visit_visitor_info (aid, appointment, ",
        "appointment_phone, appointment_uid, ",
        "appointment_read_status, is_master, ",
        "qrcode_create_time, qrcode_expire_time, ",
        "qrcode_last_use_time, qrcode_entry_use_times, ",
        "qrcode_exit_use_times, qrcode_entry_elapse_times, ",
        "qrcode_exit_elapse_times, apply_renew_times, ",
        "qrcode_token, qrcode_token_time, ",
        "qrcode_token_ip)",
        "values (#{aid,jdbcType=BIGINT}, #{appointment,jdbcType=VARCHAR}, ",
        "#{appointmentPhone,jdbcType=VARCHAR}, #{appointmentUid,jdbcType=BIGINT}, ",
        "#{appointmentReadStatus,jdbcType=INTEGER}, #{isMaster,jdbcType=TINYINT}, ",
        "#{qrcodeCreateTime,jdbcType=TIMESTAMP}, #{qrcodeExpireTime,jdbcType=TIMESTAMP}, ",
        "#{qrcodeLastUseTime,jdbcType=TIMESTAMP}, #{qrcodeEntryUseTimes,jdbcType=INTEGER}, ",
        "#{qrcodeExitUseTimes,jdbcType=INTEGER}, #{qrcodeEntryElapseTimes,jdbcType=INTEGER}, ",
        "#{qrcodeExitElapseTimes,jdbcType=INTEGER}, #{applyRenewTimes,jdbcType=INTEGER}, ",
        "#{qrcodeToken,jdbcType=VARCHAR}, #{qrcodeTokenTime,jdbcType=TIMESTAMP}, ",
        "#{qrcodeTokenIp,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(VisitVisitorInfo record);

    @InsertProvider(type=VisitVisitorInfoSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(VisitVisitorInfo record);

    @SelectProvider(type=VisitVisitorInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="aid", property="aid", jdbcType=JdbcType.BIGINT),
        @Result(column="appointment", property="appointment", jdbcType=JdbcType.VARCHAR),
        @Result(column="appointment_phone", property="appointmentPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="appointment_uid", property="appointmentUid", jdbcType=JdbcType.BIGINT),
        @Result(column="appointment_read_status", property="appointmentReadStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="is_master", property="isMaster", jdbcType=JdbcType.TINYINT),
        @Result(column="qrcode_create_time", property="qrcodeCreateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="qrcode_expire_time", property="qrcodeExpireTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="qrcode_last_use_time", property="qrcodeLastUseTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="qrcode_entry_use_times", property="qrcodeEntryUseTimes", jdbcType=JdbcType.INTEGER),
        @Result(column="qrcode_exit_use_times", property="qrcodeExitUseTimes", jdbcType=JdbcType.INTEGER),
        @Result(column="qrcode_entry_elapse_times", property="qrcodeEntryElapseTimes", jdbcType=JdbcType.INTEGER),
        @Result(column="qrcode_exit_elapse_times", property="qrcodeExitElapseTimes", jdbcType=JdbcType.INTEGER),
        @Result(column="apply_renew_times", property="applyRenewTimes", jdbcType=JdbcType.INTEGER),
        @Result(column="qrcode_token", property="qrcodeToken", jdbcType=JdbcType.VARCHAR),
        @Result(column="qrcode_token_time", property="qrcodeTokenTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="qrcode_token_ip", property="qrcodeTokenIp", jdbcType=JdbcType.VARCHAR)
    })
    List<VisitVisitorInfo> selectByExample(VisitVisitorInfoExample example);

    @Select({
        "select",
        "id, aid, appointment, appointment_phone, appointment_uid, appointment_read_status, ",
        "is_master, qrcode_create_time, qrcode_expire_time, qrcode_last_use_time, qrcode_entry_use_times, ",
        "qrcode_exit_use_times, qrcode_entry_elapse_times, qrcode_exit_elapse_times, ",
        "apply_renew_times, qrcode_token, qrcode_token_time, qrcode_token_ip",
        "from visit_visitor_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="aid", property="aid", jdbcType=JdbcType.BIGINT),
        @Result(column="appointment", property="appointment", jdbcType=JdbcType.VARCHAR),
        @Result(column="appointment_phone", property="appointmentPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="appointment_uid", property="appointmentUid", jdbcType=JdbcType.BIGINT),
        @Result(column="appointment_read_status", property="appointmentReadStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="is_master", property="isMaster", jdbcType=JdbcType.TINYINT),
        @Result(column="qrcode_create_time", property="qrcodeCreateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="qrcode_expire_time", property="qrcodeExpireTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="qrcode_last_use_time", property="qrcodeLastUseTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="qrcode_entry_use_times", property="qrcodeEntryUseTimes", jdbcType=JdbcType.INTEGER),
        @Result(column="qrcode_exit_use_times", property="qrcodeExitUseTimes", jdbcType=JdbcType.INTEGER),
        @Result(column="qrcode_entry_elapse_times", property="qrcodeEntryElapseTimes", jdbcType=JdbcType.INTEGER),
        @Result(column="qrcode_exit_elapse_times", property="qrcodeExitElapseTimes", jdbcType=JdbcType.INTEGER),
        @Result(column="apply_renew_times", property="applyRenewTimes", jdbcType=JdbcType.INTEGER),
        @Result(column="qrcode_token", property="qrcodeToken", jdbcType=JdbcType.VARCHAR),
        @Result(column="qrcode_token_time", property="qrcodeTokenTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="qrcode_token_ip", property="qrcodeTokenIp", jdbcType=JdbcType.VARCHAR)
    })
    VisitVisitorInfo selectByPrimaryKey(Long id);

    @UpdateProvider(type=VisitVisitorInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") VisitVisitorInfo record, @Param("example") VisitVisitorInfoExample example);

    @UpdateProvider(type=VisitVisitorInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") VisitVisitorInfo record, @Param("example") VisitVisitorInfoExample example);

    @UpdateProvider(type=VisitVisitorInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(VisitVisitorInfo record);

    @Update({
        "update visit_visitor_info",
        "set aid = #{aid,jdbcType=BIGINT},",
          "appointment = #{appointment,jdbcType=VARCHAR},",
          "appointment_phone = #{appointmentPhone,jdbcType=VARCHAR},",
          "appointment_uid = #{appointmentUid,jdbcType=BIGINT},",
          "appointment_read_status = #{appointmentReadStatus,jdbcType=INTEGER},",
          "is_master = #{isMaster,jdbcType=TINYINT},",
          "qrcode_create_time = #{qrcodeCreateTime,jdbcType=TIMESTAMP},",
          "qrcode_expire_time = #{qrcodeExpireTime,jdbcType=TIMESTAMP},",
          "qrcode_last_use_time = #{qrcodeLastUseTime,jdbcType=TIMESTAMP},",
          "qrcode_entry_use_times = #{qrcodeEntryUseTimes,jdbcType=INTEGER},",
          "qrcode_exit_use_times = #{qrcodeExitUseTimes,jdbcType=INTEGER},",
          "qrcode_entry_elapse_times = #{qrcodeEntryElapseTimes,jdbcType=INTEGER},",
          "qrcode_exit_elapse_times = #{qrcodeExitElapseTimes,jdbcType=INTEGER},",
          "apply_renew_times = #{applyRenewTimes,jdbcType=INTEGER},",
          "qrcode_token = #{qrcodeToken,jdbcType=VARCHAR},",
          "qrcode_token_time = #{qrcodeTokenTime,jdbcType=TIMESTAMP},",
          "qrcode_token_ip = #{qrcodeTokenIp,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(VisitVisitorInfo record);
}