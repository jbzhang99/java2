package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CommunityServiceRela;
import com.rfchina.community.persistence.model.CommunityServiceRelaExample.Criteria;
import com.rfchina.community.persistence.model.CommunityServiceRelaExample.Criterion;
import com.rfchina.community.persistence.model.CommunityServiceRelaExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class CommunityServiceRelaSqlProvider {

    public String countByExample(CommunityServiceRelaExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("community_service_rela");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(CommunityServiceRelaExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("community_service_rela");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(CommunityServiceRela record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("community_service_rela");
        
        if (record.getCommunityId() != null) {
            sql.VALUES("community_id", "#{communityId,jdbcType=INTEGER}");
        }
        
        if (record.getServiceId() != null) {
            sql.VALUES("service_id", "#{serviceId,jdbcType=INTEGER}");
        }
        
        if (record.getReorder() != null) {
            sql.VALUES("reorder", "#{reorder,jdbcType=INTEGER}");
        }
        
        if (record.getRemark() != null) {
            sql.VALUES("remark", "#{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGroundTime() != null) {
            sql.VALUES("ground_time", "#{groundTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAuditStatus() != null) {
            sql.VALUES("audit_status", "#{auditStatus,jdbcType=INTEGER}");
        }
        
        if (record.getApplyTime() != null) {
            sql.VALUES("apply_time", "#{applyTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getServiceContactsName() != null) {
            sql.VALUES("service_contacts_name", "#{serviceContactsName,jdbcType=VARCHAR}");
        }
        
        if (record.getServiceContactsPhone() != null) {
            sql.VALUES("service_contacts_phone", "#{serviceContactsPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getServiceContactsEmail() != null) {
            sql.VALUES("service_contacts_email", "#{serviceContactsEmail,jdbcType=VARCHAR}");
        }
        
        if (record.getCommunityContactsName() != null) {
            sql.VALUES("community_contacts_name", "#{communityContactsName,jdbcType=VARCHAR}");
        }
        
        if (record.getCommunityContactsPhone() != null) {
            sql.VALUES("community_contacts_phone", "#{communityContactsPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getCommunityContactsEmail() != null) {
            sql.VALUES("community_contacts_email", "#{communityContactsEmail,jdbcType=VARCHAR}");
        }
        
        if (record.getInterviewTime() != null) {
            sql.VALUES("interview_time", "#{interviewTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getInterviewAddress() != null) {
            sql.VALUES("interview_address", "#{interviewAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getSelectStatus() != null) {
            sql.VALUES("select_status", "#{selectStatus,jdbcType=INTEGER}");
        }
        
        if (record.getAuditComment() != null) {
            sql.VALUES("audit_comment", "#{auditComment,jdbcType=VARCHAR}");
        }
        
        if (record.getIsMenuShow() != null) {
            sql.VALUES("is_menu_show", "#{isMenuShow,jdbcType=INTEGER}");
        }
        
        if (record.getNotifyTime() != null) {
            sql.VALUES("notify_time", "#{notifyTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getContactWay() != null) {
            sql.VALUES("contact_way", "#{contactWay,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExampleWithBLOBs(CommunityServiceRelaExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("community_id");
        } else {
            sql.SELECT("community_id");
        }
        sql.SELECT("service_id");
        sql.SELECT("reorder");
        sql.SELECT("remark");
        sql.SELECT("create_time");
        sql.SELECT("status");
        sql.SELECT("update_time");
        sql.SELECT("ground_time");
        sql.SELECT("audit_status");
        sql.SELECT("apply_time");
        sql.SELECT("service_contacts_name");
        sql.SELECT("service_contacts_phone");
        sql.SELECT("service_contacts_email");
        sql.SELECT("community_contacts_name");
        sql.SELECT("community_contacts_phone");
        sql.SELECT("community_contacts_email");
        sql.SELECT("interview_time");
        sql.SELECT("interview_address");
        sql.SELECT("select_status");
        sql.SELECT("audit_comment");
        sql.SELECT("is_menu_show");
        sql.SELECT("notify_time");
        sql.SELECT("contact_way");
        sql.FROM("community_service_rela");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String selectByExample(CommunityServiceRelaExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("community_id");
        } else {
            sql.SELECT("community_id");
        }
        sql.SELECT("service_id");
        sql.SELECT("reorder");
        sql.SELECT("remark");
        sql.SELECT("create_time");
        sql.SELECT("status");
        sql.SELECT("update_time");
        sql.SELECT("ground_time");
        sql.SELECT("audit_status");
        sql.SELECT("apply_time");
        sql.SELECT("service_contacts_name");
        sql.SELECT("service_contacts_phone");
        sql.SELECT("service_contacts_email");
        sql.SELECT("community_contacts_name");
        sql.SELECT("community_contacts_phone");
        sql.SELECT("community_contacts_email");
        sql.SELECT("interview_time");
        sql.SELECT("interview_address");
        sql.SELECT("select_status");
        sql.SELECT("audit_comment");
        sql.SELECT("is_menu_show");
        sql.SELECT("notify_time");
        sql.FROM("community_service_rela");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        CommunityServiceRela record = (CommunityServiceRela) parameter.get("record");
        CommunityServiceRelaExample example = (CommunityServiceRelaExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("community_service_rela");
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        }
        
        if (record.getServiceId() != null) {
            sql.SET("service_id = #{record.serviceId,jdbcType=INTEGER}");
        }
        
        if (record.getReorder() != null) {
            sql.SET("reorder = #{record.reorder,jdbcType=INTEGER}");
        }
        
        if (record.getRemark() != null) {
            sql.SET("remark = #{record.remark,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=INTEGER}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGroundTime() != null) {
            sql.SET("ground_time = #{record.groundTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAuditStatus() != null) {
            sql.SET("audit_status = #{record.auditStatus,jdbcType=INTEGER}");
        }
        
        if (record.getApplyTime() != null) {
            sql.SET("apply_time = #{record.applyTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getServiceContactsName() != null) {
            sql.SET("service_contacts_name = #{record.serviceContactsName,jdbcType=VARCHAR}");
        }
        
        if (record.getServiceContactsPhone() != null) {
            sql.SET("service_contacts_phone = #{record.serviceContactsPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getServiceContactsEmail() != null) {
            sql.SET("service_contacts_email = #{record.serviceContactsEmail,jdbcType=VARCHAR}");
        }
        
        if (record.getCommunityContactsName() != null) {
            sql.SET("community_contacts_name = #{record.communityContactsName,jdbcType=VARCHAR}");
        }
        
        if (record.getCommunityContactsPhone() != null) {
            sql.SET("community_contacts_phone = #{record.communityContactsPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getCommunityContactsEmail() != null) {
            sql.SET("community_contacts_email = #{record.communityContactsEmail,jdbcType=VARCHAR}");
        }
        
        if (record.getInterviewTime() != null) {
            sql.SET("interview_time = #{record.interviewTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getInterviewAddress() != null) {
            sql.SET("interview_address = #{record.interviewAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getSelectStatus() != null) {
            sql.SET("select_status = #{record.selectStatus,jdbcType=INTEGER}");
        }
        
        if (record.getAuditComment() != null) {
            sql.SET("audit_comment = #{record.auditComment,jdbcType=VARCHAR}");
        }
        
        if (record.getIsMenuShow() != null) {
            sql.SET("is_menu_show = #{record.isMenuShow,jdbcType=INTEGER}");
        }
        
        if (record.getNotifyTime() != null) {
            sql.SET("notify_time = #{record.notifyTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getContactWay() != null) {
            sql.SET("contact_way = #{record.contactWay,jdbcType=LONGVARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("community_service_rela");
        
        sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        sql.SET("service_id = #{record.serviceId,jdbcType=INTEGER}");
        sql.SET("reorder = #{record.reorder,jdbcType=INTEGER}");
        sql.SET("remark = #{record.remark,jdbcType=VARCHAR}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("status = #{record.status,jdbcType=INTEGER}");
        sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        sql.SET("ground_time = #{record.groundTime,jdbcType=TIMESTAMP}");
        sql.SET("audit_status = #{record.auditStatus,jdbcType=INTEGER}");
        sql.SET("apply_time = #{record.applyTime,jdbcType=TIMESTAMP}");
        sql.SET("service_contacts_name = #{record.serviceContactsName,jdbcType=VARCHAR}");
        sql.SET("service_contacts_phone = #{record.serviceContactsPhone,jdbcType=VARCHAR}");
        sql.SET("service_contacts_email = #{record.serviceContactsEmail,jdbcType=VARCHAR}");
        sql.SET("community_contacts_name = #{record.communityContactsName,jdbcType=VARCHAR}");
        sql.SET("community_contacts_phone = #{record.communityContactsPhone,jdbcType=VARCHAR}");
        sql.SET("community_contacts_email = #{record.communityContactsEmail,jdbcType=VARCHAR}");
        sql.SET("interview_time = #{record.interviewTime,jdbcType=TIMESTAMP}");
        sql.SET("interview_address = #{record.interviewAddress,jdbcType=VARCHAR}");
        sql.SET("select_status = #{record.selectStatus,jdbcType=INTEGER}");
        sql.SET("audit_comment = #{record.auditComment,jdbcType=VARCHAR}");
        sql.SET("is_menu_show = #{record.isMenuShow,jdbcType=INTEGER}");
        sql.SET("notify_time = #{record.notifyTime,jdbcType=TIMESTAMP}");
        sql.SET("contact_way = #{record.contactWay,jdbcType=LONGVARCHAR}");
        
        CommunityServiceRelaExample example = (CommunityServiceRelaExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("community_service_rela");
        
        sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        sql.SET("service_id = #{record.serviceId,jdbcType=INTEGER}");
        sql.SET("reorder = #{record.reorder,jdbcType=INTEGER}");
        sql.SET("remark = #{record.remark,jdbcType=VARCHAR}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("status = #{record.status,jdbcType=INTEGER}");
        sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        sql.SET("ground_time = #{record.groundTime,jdbcType=TIMESTAMP}");
        sql.SET("audit_status = #{record.auditStatus,jdbcType=INTEGER}");
        sql.SET("apply_time = #{record.applyTime,jdbcType=TIMESTAMP}");
        sql.SET("service_contacts_name = #{record.serviceContactsName,jdbcType=VARCHAR}");
        sql.SET("service_contacts_phone = #{record.serviceContactsPhone,jdbcType=VARCHAR}");
        sql.SET("service_contacts_email = #{record.serviceContactsEmail,jdbcType=VARCHAR}");
        sql.SET("community_contacts_name = #{record.communityContactsName,jdbcType=VARCHAR}");
        sql.SET("community_contacts_phone = #{record.communityContactsPhone,jdbcType=VARCHAR}");
        sql.SET("community_contacts_email = #{record.communityContactsEmail,jdbcType=VARCHAR}");
        sql.SET("interview_time = #{record.interviewTime,jdbcType=TIMESTAMP}");
        sql.SET("interview_address = #{record.interviewAddress,jdbcType=VARCHAR}");
        sql.SET("select_status = #{record.selectStatus,jdbcType=INTEGER}");
        sql.SET("audit_comment = #{record.auditComment,jdbcType=VARCHAR}");
        sql.SET("is_menu_show = #{record.isMenuShow,jdbcType=INTEGER}");
        sql.SET("notify_time = #{record.notifyTime,jdbcType=TIMESTAMP}");
        
        CommunityServiceRelaExample example = (CommunityServiceRelaExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(CommunityServiceRela record) {
        SQL sql = new SQL();
        sql.UPDATE("community_service_rela");
        
        if (record.getReorder() != null) {
            sql.SET("reorder = #{reorder,jdbcType=INTEGER}");
        }
        
        if (record.getRemark() != null) {
            sql.SET("remark = #{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGroundTime() != null) {
            sql.SET("ground_time = #{groundTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAuditStatus() != null) {
            sql.SET("audit_status = #{auditStatus,jdbcType=INTEGER}");
        }
        
        if (record.getApplyTime() != null) {
            sql.SET("apply_time = #{applyTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getServiceContactsName() != null) {
            sql.SET("service_contacts_name = #{serviceContactsName,jdbcType=VARCHAR}");
        }
        
        if (record.getServiceContactsPhone() != null) {
            sql.SET("service_contacts_phone = #{serviceContactsPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getServiceContactsEmail() != null) {
            sql.SET("service_contacts_email = #{serviceContactsEmail,jdbcType=VARCHAR}");
        }
        
        if (record.getCommunityContactsName() != null) {
            sql.SET("community_contacts_name = #{communityContactsName,jdbcType=VARCHAR}");
        }
        
        if (record.getCommunityContactsPhone() != null) {
            sql.SET("community_contacts_phone = #{communityContactsPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getCommunityContactsEmail() != null) {
            sql.SET("community_contacts_email = #{communityContactsEmail,jdbcType=VARCHAR}");
        }
        
        if (record.getInterviewTime() != null) {
            sql.SET("interview_time = #{interviewTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getInterviewAddress() != null) {
            sql.SET("interview_address = #{interviewAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getSelectStatus() != null) {
            sql.SET("select_status = #{selectStatus,jdbcType=INTEGER}");
        }
        
        if (record.getAuditComment() != null) {
            sql.SET("audit_comment = #{auditComment,jdbcType=VARCHAR}");
        }
        
        if (record.getIsMenuShow() != null) {
            sql.SET("is_menu_show = #{isMenuShow,jdbcType=INTEGER}");
        }
        
        if (record.getNotifyTime() != null) {
            sql.SET("notify_time = #{notifyTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getContactWay() != null) {
            sql.SET("contact_way = #{contactWay,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("community_id = #{communityId,jdbcType=INTEGER}");
        sql.WHERE("service_id = #{serviceId,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, CommunityServiceRelaExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}