package com.rfchina.community.openweb.mapper.ext;

import com.rfchina.community.persistence.model.ext.ExtCommunityServiceRela;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;

public interface ExtCommunityServiceRelaMapper {

	@Select({"select t.*,a.merger_name as area_name,d.`name` as community_name from community_service_rela t left join community d on t.community_id = d.id left join area a on a.id=d.area_id where 1=1 and t.service_id = #{serviceId}"})
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
        @Result(column="audit_comment", property="auditComment", jdbcType=JdbcType.VARCHAR),
        @Result(column="apply_time", property="applyTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="service_contacts_name", property="serviceContactsName", jdbcType=JdbcType.VARCHAR),
        @Result(column="service_contacts_phone", property="serviceContactsPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="service_contacts_email", property="serviceContactsEmail", jdbcType=JdbcType.VARCHAR),
        @Result(column="community_contacts_name", property="communityContactsName", jdbcType=JdbcType.VARCHAR),
        @Result(column="community_contacts_phone", property="communityContactsPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="community_contacts_email", property="communityContactsEmail", jdbcType=JdbcType.VARCHAR),
        @Result(column="interview_time", property="interviewTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="interview_address", property="interviewAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="contact_way", property="contactWay", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="area_name", property="areaName", jdbcType=JdbcType.VARCHAR),
        @Result(column="community_name", property="communityName", jdbcType=JdbcType.VARCHAR)
    })
	public PageList<ExtCommunityServiceRela> getCommunityServiceRelaList(int serviceId , PageBounds pageBounds);
	
	
	@Select({"select t.*,a.merger_name as area_name,d.`name` as community_name from community_service_rela_temp t join community d on t.community_id = d.id join area a on a.id=d.area_id where 1=1 and t.service_id = #{serviceId}"})
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
        @Result(column="contact_way", property="contactWay", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="area_name", property="areaName", jdbcType=JdbcType.VARCHAR),
        @Result(column="community_name", property="communityName", jdbcType=JdbcType.VARCHAR)
    })
	public PageList<ExtCommunityServiceRela> getCommunityServiceRelaTempList(int serviceId ,PageBounds pageBounds);
}
