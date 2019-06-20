package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CommunityServiceRelaTemp;
import com.rfchina.community.persistence.model.CommunityServiceRelaTempExample;
import com.rfchina.community.persistence.model.CommunityServiceRelaTempKey;
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

public interface CommunityServiceRelaTempMapper extends Serializable {
    @SelectProvider(type=CommunityServiceRelaTempSqlProvider.class, method="countByExample")
    long countByExample(CommunityServiceRelaTempExample example);

    @DeleteProvider(type=CommunityServiceRelaTempSqlProvider.class, method="deleteByExample")
    int deleteByExample(CommunityServiceRelaTempExample example);

    @Delete({
        "delete from community_service_rela_temp",
        "where community_id = #{communityId,jdbcType=INTEGER}",
          "and service_id = #{serviceId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(CommunityServiceRelaTempKey key);

    @Insert({
        "insert into community_service_rela_temp (community_id, service_id, ",
        "reorder, remark, ",
        "create_time, status, ",
        "update_time, ground_time, ",
        "audit_status, apply_time, ",
        "service_contacts_name, service_contacts_phone, ",
        "service_contacts_email, community_contacts_name, ",
        "community_contacts_phone, community_contacts_email, ",
        "interview_time, interview_address, ",
        "select_status, audit_comment, ",
        "is_menu_show, notify_time, ",
        "contact_way)",
        "values (#{communityId,jdbcType=INTEGER}, #{serviceId,jdbcType=INTEGER}, ",
        "#{reorder,jdbcType=INTEGER}, #{remark,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{status,jdbcType=INTEGER}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{groundTime,jdbcType=TIMESTAMP}, ",
        "#{auditStatus,jdbcType=INTEGER}, #{applyTime,jdbcType=TIMESTAMP}, ",
        "#{serviceContactsName,jdbcType=VARCHAR}, #{serviceContactsPhone,jdbcType=VARCHAR}, ",
        "#{serviceContactsEmail,jdbcType=VARCHAR}, #{communityContactsName,jdbcType=VARCHAR}, ",
        "#{communityContactsPhone,jdbcType=VARCHAR}, #{communityContactsEmail,jdbcType=VARCHAR}, ",
        "#{interviewTime,jdbcType=TIMESTAMP}, #{interviewAddress,jdbcType=VARCHAR}, ",
        "#{selectStatus,jdbcType=INTEGER}, #{auditComment,jdbcType=VARCHAR}, ",
        "#{isMenuShow,jdbcType=INTEGER}, #{notifyTime,jdbcType=TIMESTAMP}, ",
        "#{contactWay,jdbcType=LONGVARCHAR})"
    })
    int insert(CommunityServiceRelaTemp record);

    @InsertProvider(type=CommunityServiceRelaTempSqlProvider.class, method="insertSelective")
    int insertSelective(CommunityServiceRelaTemp record);

    @SelectProvider(type=CommunityServiceRelaTempSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="reorder", property="reorder", jdbcType=JdbcType.INTEGER),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="ground_time", property="groundTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="audit_status", property="auditStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="apply_time", property="applyTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="service_contacts_name", property="serviceContactsName", jdbcType=JdbcType.VARCHAR),
        @Result(column="service_contacts_phone", property="serviceContactsPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="service_contacts_email", property="serviceContactsEmail", jdbcType=JdbcType.VARCHAR),
        @Result(column="community_contacts_name", property="communityContactsName", jdbcType=JdbcType.VARCHAR),
        @Result(column="community_contacts_phone", property="communityContactsPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="community_contacts_email", property="communityContactsEmail", jdbcType=JdbcType.VARCHAR),
        @Result(column="interview_time", property="interviewTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="interview_address", property="interviewAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="select_status", property="selectStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="audit_comment", property="auditComment", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_menu_show", property="isMenuShow", jdbcType=JdbcType.INTEGER),
        @Result(column="notify_time", property="notifyTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="contact_way", property="contactWay", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<CommunityServiceRelaTemp> selectByExampleWithBLOBs(CommunityServiceRelaTempExample example);

    @SelectProvider(type=CommunityServiceRelaTempSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="reorder", property="reorder", jdbcType=JdbcType.INTEGER),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="ground_time", property="groundTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="audit_status", property="auditStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="apply_time", property="applyTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="service_contacts_name", property="serviceContactsName", jdbcType=JdbcType.VARCHAR),
        @Result(column="service_contacts_phone", property="serviceContactsPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="service_contacts_email", property="serviceContactsEmail", jdbcType=JdbcType.VARCHAR),
        @Result(column="community_contacts_name", property="communityContactsName", jdbcType=JdbcType.VARCHAR),
        @Result(column="community_contacts_phone", property="communityContactsPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="community_contacts_email", property="communityContactsEmail", jdbcType=JdbcType.VARCHAR),
        @Result(column="interview_time", property="interviewTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="interview_address", property="interviewAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="select_status", property="selectStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="audit_comment", property="auditComment", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_menu_show", property="isMenuShow", jdbcType=JdbcType.INTEGER),
        @Result(column="notify_time", property="notifyTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<CommunityServiceRelaTemp> selectByExample(CommunityServiceRelaTempExample example);

    @Select({
        "select",
        "community_id, service_id, reorder, remark, create_time, status, update_time, ",
        "ground_time, audit_status, apply_time, service_contacts_name, service_contacts_phone, ",
        "service_contacts_email, community_contacts_name, community_contacts_phone, community_contacts_email, ",
        "interview_time, interview_address, select_status, audit_comment, is_menu_show, ",
        "notify_time, contact_way",
        "from community_service_rela_temp",
        "where community_id = #{communityId,jdbcType=INTEGER}",
          "and service_id = #{serviceId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="reorder", property="reorder", jdbcType=JdbcType.INTEGER),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="ground_time", property="groundTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="audit_status", property="auditStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="apply_time", property="applyTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="service_contacts_name", property="serviceContactsName", jdbcType=JdbcType.VARCHAR),
        @Result(column="service_contacts_phone", property="serviceContactsPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="service_contacts_email", property="serviceContactsEmail", jdbcType=JdbcType.VARCHAR),
        @Result(column="community_contacts_name", property="communityContactsName", jdbcType=JdbcType.VARCHAR),
        @Result(column="community_contacts_phone", property="communityContactsPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="community_contacts_email", property="communityContactsEmail", jdbcType=JdbcType.VARCHAR),
        @Result(column="interview_time", property="interviewTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="interview_address", property="interviewAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="select_status", property="selectStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="audit_comment", property="auditComment", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_menu_show", property="isMenuShow", jdbcType=JdbcType.INTEGER),
        @Result(column="notify_time", property="notifyTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="contact_way", property="contactWay", jdbcType=JdbcType.LONGVARCHAR)
    })
    CommunityServiceRelaTemp selectByPrimaryKey(CommunityServiceRelaTempKey key);

    @UpdateProvider(type=CommunityServiceRelaTempSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CommunityServiceRelaTemp record, @Param("example") CommunityServiceRelaTempExample example);

    @UpdateProvider(type=CommunityServiceRelaTempSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") CommunityServiceRelaTemp record, @Param("example") CommunityServiceRelaTempExample example);

    @UpdateProvider(type=CommunityServiceRelaTempSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CommunityServiceRelaTemp record, @Param("example") CommunityServiceRelaTempExample example);

    @UpdateProvider(type=CommunityServiceRelaTempSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CommunityServiceRelaTemp record);

    @Update({
        "update community_service_rela_temp",
        "set reorder = #{reorder,jdbcType=INTEGER},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=INTEGER},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "ground_time = #{groundTime,jdbcType=TIMESTAMP},",
          "audit_status = #{auditStatus,jdbcType=INTEGER},",
          "apply_time = #{applyTime,jdbcType=TIMESTAMP},",
          "service_contacts_name = #{serviceContactsName,jdbcType=VARCHAR},",
          "service_contacts_phone = #{serviceContactsPhone,jdbcType=VARCHAR},",
          "service_contacts_email = #{serviceContactsEmail,jdbcType=VARCHAR},",
          "community_contacts_name = #{communityContactsName,jdbcType=VARCHAR},",
          "community_contacts_phone = #{communityContactsPhone,jdbcType=VARCHAR},",
          "community_contacts_email = #{communityContactsEmail,jdbcType=VARCHAR},",
          "interview_time = #{interviewTime,jdbcType=TIMESTAMP},",
          "interview_address = #{interviewAddress,jdbcType=VARCHAR},",
          "select_status = #{selectStatus,jdbcType=INTEGER},",
          "audit_comment = #{auditComment,jdbcType=VARCHAR},",
          "is_menu_show = #{isMenuShow,jdbcType=INTEGER},",
          "notify_time = #{notifyTime,jdbcType=TIMESTAMP},",
          "contact_way = #{contactWay,jdbcType=LONGVARCHAR}",
        "where community_id = #{communityId,jdbcType=INTEGER}",
          "and service_id = #{serviceId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(CommunityServiceRelaTemp record);

    @Update({
        "update community_service_rela_temp",
        "set reorder = #{reorder,jdbcType=INTEGER},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=INTEGER},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "ground_time = #{groundTime,jdbcType=TIMESTAMP},",
          "audit_status = #{auditStatus,jdbcType=INTEGER},",
          "apply_time = #{applyTime,jdbcType=TIMESTAMP},",
          "service_contacts_name = #{serviceContactsName,jdbcType=VARCHAR},",
          "service_contacts_phone = #{serviceContactsPhone,jdbcType=VARCHAR},",
          "service_contacts_email = #{serviceContactsEmail,jdbcType=VARCHAR},",
          "community_contacts_name = #{communityContactsName,jdbcType=VARCHAR},",
          "community_contacts_phone = #{communityContactsPhone,jdbcType=VARCHAR},",
          "community_contacts_email = #{communityContactsEmail,jdbcType=VARCHAR},",
          "interview_time = #{interviewTime,jdbcType=TIMESTAMP},",
          "interview_address = #{interviewAddress,jdbcType=VARCHAR},",
          "select_status = #{selectStatus,jdbcType=INTEGER},",
          "audit_comment = #{auditComment,jdbcType=VARCHAR},",
          "is_menu_show = #{isMenuShow,jdbcType=INTEGER},",
          "notify_time = #{notifyTime,jdbcType=TIMESTAMP}",
        "where community_id = #{communityId,jdbcType=INTEGER}",
          "and service_id = #{serviceId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CommunityServiceRelaTemp record);
}