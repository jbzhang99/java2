package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.VisitAppointment;
import com.rfchina.community.persistence.model.VisitAppointmentExample.Criteria;
import com.rfchina.community.persistence.model.VisitAppointmentExample.Criterion;
import com.rfchina.community.persistence.model.VisitAppointmentExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class VisitAppointmentSqlProvider {

    public String countByExample(VisitAppointmentExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("visit_appointment");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(VisitAppointmentExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("visit_appointment");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(VisitAppointment record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("visit_appointment");
        
        if (record.getCommunityId() != null) {
            sql.VALUES("community_id", "#{communityId,jdbcType=INTEGER}");
        }
        
        if (record.getMasterId() != null) {
            sql.VALUES("master_id", "#{masterId,jdbcType=BIGINT}");
        }
        
        if (record.getVisitor() != null) {
            sql.VALUES("visitor", "#{visitor,jdbcType=VARCHAR}");
        }
        
        if (record.getVisitorPhone() != null) {
            sql.VALUES("visitor_phone", "#{visitorPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getVisitorUid() != null) {
            sql.VALUES("visitor_uid", "#{visitorUid,jdbcType=BIGINT}");
        }
        
        if (record.getVisitorReadStatus() != null) {
            sql.VALUES("visitor_read_status", "#{visitorReadStatus,jdbcType=TINYINT}");
        }
        
        if (record.getFollowQty() != null) {
            sql.VALUES("follow_qty", "#{followQty,jdbcType=INTEGER}");
        }
        
        if (record.getType() != null) {
            sql.VALUES("type", "#{type,jdbcType=TINYINT}");
        }
        
        if (record.getDuration() != null) {
            sql.VALUES("duration", "#{duration,jdbcType=INTEGER}");
        }
        
        if (record.getCreateUid() != null) {
            sql.VALUES("create_uid", "#{createUid,jdbcType=BIGINT}");
        }
        
        if (record.getCreateDate() != null) {
            sql.VALUES("create_date", "#{createDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAppointmentDate() != null) {
            sql.VALUES("appointment_date", "#{appointmentDate,jdbcType=DATE}");
        }
        
        if (record.getMasterAuditStatus() != null) {
            sql.VALUES("master_audit_status", "#{masterAuditStatus,jdbcType=INTEGER}");
        }
        
        if (record.getMasterAuditTime() != null) {
            sql.VALUES("master_audit_time", "#{masterAuditTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getMasterAuditUid() != null) {
            sql.VALUES("master_audit_uid", "#{masterAuditUid,jdbcType=BIGINT}");
        }
        
        if (record.getMasterAuditPhone() != null) {
            sql.VALUES("master_audit_phone", "#{masterAuditPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getCommunityAuditTime() != null) {
            sql.VALUES("community_audit_time", "#{communityAuditTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCommunityAuditUid() != null) {
            sql.VALUES("community_audit_uid", "#{communityAuditUid,jdbcType=BIGINT}");
        }
        
        if (record.getCommunityAuditStatus() != null) {
            sql.VALUES("community_audit_status", "#{communityAuditStatus,jdbcType=TINYINT}");
        }
        
        if (record.getVisitorAuditTime() != null) {
            sql.VALUES("visitor_audit_time", "#{visitorAuditTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getVisitorAuditUid() != null) {
            sql.VALUES("visitor_audit_uid", "#{visitorAuditUid,jdbcType=BIGINT}");
        }
        
        if (record.getVisitorAuditStatus() != null) {
            sql.VALUES("visitor_audit_status", "#{visitorAuditStatus,jdbcType=TINYINT}");
        }
        
        if (record.getRenewAuditTime() != null) {
            sql.VALUES("renew_audit_time", "#{renewAuditTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRenewAuditUid() != null) {
            sql.VALUES("renew_audit_uid", "#{renewAuditUid,jdbcType=BIGINT}");
        }
        
        if (record.getRenewAuditStatus() != null) {
            sql.VALUES("renew_audit_status", "#{renewAuditStatus,jdbcType=TINYINT}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=TINYINT}");
        }
        
        if (record.getToken() != null) {
            sql.VALUES("token", "#{token,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(VisitAppointmentExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("community_id");
        sql.SELECT("master_id");
        sql.SELECT("visitor");
        sql.SELECT("visitor_phone");
        sql.SELECT("visitor_uid");
        sql.SELECT("visitor_read_status");
        sql.SELECT("follow_qty");
        sql.SELECT("type");
        sql.SELECT("duration");
        sql.SELECT("create_uid");
        sql.SELECT("create_date");
        sql.SELECT("appointment_date");
        sql.SELECT("master_audit_status");
        sql.SELECT("master_audit_time");
        sql.SELECT("master_audit_uid");
        sql.SELECT("master_audit_phone");
        sql.SELECT("community_audit_time");
        sql.SELECT("community_audit_uid");
        sql.SELECT("community_audit_status");
        sql.SELECT("visitor_audit_time");
        sql.SELECT("visitor_audit_uid");
        sql.SELECT("visitor_audit_status");
        sql.SELECT("renew_audit_time");
        sql.SELECT("renew_audit_uid");
        sql.SELECT("renew_audit_status");
        sql.SELECT("status");
        sql.SELECT("token");
        sql.FROM("visit_appointment");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        VisitAppointment record = (VisitAppointment) parameter.get("record");
        VisitAppointmentExample example = (VisitAppointmentExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("visit_appointment");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        }
        
        if (record.getMasterId() != null) {
            sql.SET("master_id = #{record.masterId,jdbcType=BIGINT}");
        }
        
        if (record.getVisitor() != null) {
            sql.SET("visitor = #{record.visitor,jdbcType=VARCHAR}");
        }
        
        if (record.getVisitorPhone() != null) {
            sql.SET("visitor_phone = #{record.visitorPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getVisitorUid() != null) {
            sql.SET("visitor_uid = #{record.visitorUid,jdbcType=BIGINT}");
        }
        
        if (record.getVisitorReadStatus() != null) {
            sql.SET("visitor_read_status = #{record.visitorReadStatus,jdbcType=TINYINT}");
        }
        
        if (record.getFollowQty() != null) {
            sql.SET("follow_qty = #{record.followQty,jdbcType=INTEGER}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{record.type,jdbcType=TINYINT}");
        }
        
        if (record.getDuration() != null) {
            sql.SET("duration = #{record.duration,jdbcType=INTEGER}");
        }
        
        if (record.getCreateUid() != null) {
            sql.SET("create_uid = #{record.createUid,jdbcType=BIGINT}");
        }
        
        if (record.getCreateDate() != null) {
            sql.SET("create_date = #{record.createDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAppointmentDate() != null) {
            sql.SET("appointment_date = #{record.appointmentDate,jdbcType=DATE}");
        }
        
        if (record.getMasterAuditStatus() != null) {
            sql.SET("master_audit_status = #{record.masterAuditStatus,jdbcType=INTEGER}");
        }
        
        if (record.getMasterAuditTime() != null) {
            sql.SET("master_audit_time = #{record.masterAuditTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getMasterAuditUid() != null) {
            sql.SET("master_audit_uid = #{record.masterAuditUid,jdbcType=BIGINT}");
        }
        
        if (record.getMasterAuditPhone() != null) {
            sql.SET("master_audit_phone = #{record.masterAuditPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getCommunityAuditTime() != null) {
            sql.SET("community_audit_time = #{record.communityAuditTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCommunityAuditUid() != null) {
            sql.SET("community_audit_uid = #{record.communityAuditUid,jdbcType=BIGINT}");
        }
        
        if (record.getCommunityAuditStatus() != null) {
            sql.SET("community_audit_status = #{record.communityAuditStatus,jdbcType=TINYINT}");
        }
        
        if (record.getVisitorAuditTime() != null) {
            sql.SET("visitor_audit_time = #{record.visitorAuditTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getVisitorAuditUid() != null) {
            sql.SET("visitor_audit_uid = #{record.visitorAuditUid,jdbcType=BIGINT}");
        }
        
        if (record.getVisitorAuditStatus() != null) {
            sql.SET("visitor_audit_status = #{record.visitorAuditStatus,jdbcType=TINYINT}");
        }
        
        if (record.getRenewAuditTime() != null) {
            sql.SET("renew_audit_time = #{record.renewAuditTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRenewAuditUid() != null) {
            sql.SET("renew_audit_uid = #{record.renewAuditUid,jdbcType=BIGINT}");
        }
        
        if (record.getRenewAuditStatus() != null) {
            sql.SET("renew_audit_status = #{record.renewAuditStatus,jdbcType=TINYINT}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=TINYINT}");
        }
        
        if (record.getToken() != null) {
            sql.SET("token = #{record.token,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("visit_appointment");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        sql.SET("master_id = #{record.masterId,jdbcType=BIGINT}");
        sql.SET("visitor = #{record.visitor,jdbcType=VARCHAR}");
        sql.SET("visitor_phone = #{record.visitorPhone,jdbcType=VARCHAR}");
        sql.SET("visitor_uid = #{record.visitorUid,jdbcType=BIGINT}");
        sql.SET("visitor_read_status = #{record.visitorReadStatus,jdbcType=TINYINT}");
        sql.SET("follow_qty = #{record.followQty,jdbcType=INTEGER}");
        sql.SET("type = #{record.type,jdbcType=TINYINT}");
        sql.SET("duration = #{record.duration,jdbcType=INTEGER}");
        sql.SET("create_uid = #{record.createUid,jdbcType=BIGINT}");
        sql.SET("create_date = #{record.createDate,jdbcType=TIMESTAMP}");
        sql.SET("appointment_date = #{record.appointmentDate,jdbcType=DATE}");
        sql.SET("master_audit_status = #{record.masterAuditStatus,jdbcType=INTEGER}");
        sql.SET("master_audit_time = #{record.masterAuditTime,jdbcType=TIMESTAMP}");
        sql.SET("master_audit_uid = #{record.masterAuditUid,jdbcType=BIGINT}");
        sql.SET("master_audit_phone = #{record.masterAuditPhone,jdbcType=VARCHAR}");
        sql.SET("community_audit_time = #{record.communityAuditTime,jdbcType=TIMESTAMP}");
        sql.SET("community_audit_uid = #{record.communityAuditUid,jdbcType=BIGINT}");
        sql.SET("community_audit_status = #{record.communityAuditStatus,jdbcType=TINYINT}");
        sql.SET("visitor_audit_time = #{record.visitorAuditTime,jdbcType=TIMESTAMP}");
        sql.SET("visitor_audit_uid = #{record.visitorAuditUid,jdbcType=BIGINT}");
        sql.SET("visitor_audit_status = #{record.visitorAuditStatus,jdbcType=TINYINT}");
        sql.SET("renew_audit_time = #{record.renewAuditTime,jdbcType=TIMESTAMP}");
        sql.SET("renew_audit_uid = #{record.renewAuditUid,jdbcType=BIGINT}");
        sql.SET("renew_audit_status = #{record.renewAuditStatus,jdbcType=TINYINT}");
        sql.SET("status = #{record.status,jdbcType=TINYINT}");
        sql.SET("token = #{record.token,jdbcType=VARCHAR}");
        
        VisitAppointmentExample example = (VisitAppointmentExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(VisitAppointment record) {
        SQL sql = new SQL();
        sql.UPDATE("visit_appointment");
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{communityId,jdbcType=INTEGER}");
        }
        
        if (record.getMasterId() != null) {
            sql.SET("master_id = #{masterId,jdbcType=BIGINT}");
        }
        
        if (record.getVisitor() != null) {
            sql.SET("visitor = #{visitor,jdbcType=VARCHAR}");
        }
        
        if (record.getVisitorPhone() != null) {
            sql.SET("visitor_phone = #{visitorPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getVisitorUid() != null) {
            sql.SET("visitor_uid = #{visitorUid,jdbcType=BIGINT}");
        }
        
        if (record.getVisitorReadStatus() != null) {
            sql.SET("visitor_read_status = #{visitorReadStatus,jdbcType=TINYINT}");
        }
        
        if (record.getFollowQty() != null) {
            sql.SET("follow_qty = #{followQty,jdbcType=INTEGER}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{type,jdbcType=TINYINT}");
        }
        
        if (record.getDuration() != null) {
            sql.SET("duration = #{duration,jdbcType=INTEGER}");
        }
        
        if (record.getCreateUid() != null) {
            sql.SET("create_uid = #{createUid,jdbcType=BIGINT}");
        }
        
        if (record.getCreateDate() != null) {
            sql.SET("create_date = #{createDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAppointmentDate() != null) {
            sql.SET("appointment_date = #{appointmentDate,jdbcType=DATE}");
        }
        
        if (record.getMasterAuditStatus() != null) {
            sql.SET("master_audit_status = #{masterAuditStatus,jdbcType=INTEGER}");
        }
        
        if (record.getMasterAuditTime() != null) {
            sql.SET("master_audit_time = #{masterAuditTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getMasterAuditUid() != null) {
            sql.SET("master_audit_uid = #{masterAuditUid,jdbcType=BIGINT}");
        }
        
        if (record.getMasterAuditPhone() != null) {
            sql.SET("master_audit_phone = #{masterAuditPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getCommunityAuditTime() != null) {
            sql.SET("community_audit_time = #{communityAuditTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCommunityAuditUid() != null) {
            sql.SET("community_audit_uid = #{communityAuditUid,jdbcType=BIGINT}");
        }
        
        if (record.getCommunityAuditStatus() != null) {
            sql.SET("community_audit_status = #{communityAuditStatus,jdbcType=TINYINT}");
        }
        
        if (record.getVisitorAuditTime() != null) {
            sql.SET("visitor_audit_time = #{visitorAuditTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getVisitorAuditUid() != null) {
            sql.SET("visitor_audit_uid = #{visitorAuditUid,jdbcType=BIGINT}");
        }
        
        if (record.getVisitorAuditStatus() != null) {
            sql.SET("visitor_audit_status = #{visitorAuditStatus,jdbcType=TINYINT}");
        }
        
        if (record.getRenewAuditTime() != null) {
            sql.SET("renew_audit_time = #{renewAuditTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRenewAuditUid() != null) {
            sql.SET("renew_audit_uid = #{renewAuditUid,jdbcType=BIGINT}");
        }
        
        if (record.getRenewAuditStatus() != null) {
            sql.SET("renew_audit_status = #{renewAuditStatus,jdbcType=TINYINT}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=TINYINT}");
        }
        
        if (record.getToken() != null) {
            sql.SET("token = #{token,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, VisitAppointmentExample example, boolean includeExamplePhrase) {
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