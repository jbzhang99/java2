package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.VisitVisitorInfo;
import com.rfchina.community.persistence.model.VisitVisitorInfoExample.Criteria;
import com.rfchina.community.persistence.model.VisitVisitorInfoExample.Criterion;
import com.rfchina.community.persistence.model.VisitVisitorInfoExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class VisitVisitorInfoSqlProvider {

    public String countByExample(VisitVisitorInfoExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("visit_visitor_info");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(VisitVisitorInfoExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("visit_visitor_info");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(VisitVisitorInfo record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("visit_visitor_info");
        
        if (record.getAid() != null) {
            sql.VALUES("aid", "#{aid,jdbcType=BIGINT}");
        }
        
        if (record.getAppointment() != null) {
            sql.VALUES("appointment", "#{appointment,jdbcType=VARCHAR}");
        }
        
        if (record.getAppointmentPhone() != null) {
            sql.VALUES("appointment_phone", "#{appointmentPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getAppointmentUid() != null) {
            sql.VALUES("appointment_uid", "#{appointmentUid,jdbcType=BIGINT}");
        }
        
        if (record.getAppointmentReadStatus() != null) {
            sql.VALUES("appointment_read_status", "#{appointmentReadStatus,jdbcType=INTEGER}");
        }
        
        if (record.getIsMaster() != null) {
            sql.VALUES("is_master", "#{isMaster,jdbcType=TINYINT}");
        }
        
        if (record.getQrcodeCreateTime() != null) {
            sql.VALUES("qrcode_create_time", "#{qrcodeCreateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getQrcodeExpireTime() != null) {
            sql.VALUES("qrcode_expire_time", "#{qrcodeExpireTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getQrcodeLastUseTime() != null) {
            sql.VALUES("qrcode_last_use_time", "#{qrcodeLastUseTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getQrcodeEntryUseTimes() != null) {
            sql.VALUES("qrcode_entry_use_times", "#{qrcodeEntryUseTimes,jdbcType=INTEGER}");
        }
        
        if (record.getQrcodeExitUseTimes() != null) {
            sql.VALUES("qrcode_exit_use_times", "#{qrcodeExitUseTimes,jdbcType=INTEGER}");
        }
        
        if (record.getQrcodeEntryElapseTimes() != null) {
            sql.VALUES("qrcode_entry_elapse_times", "#{qrcodeEntryElapseTimes,jdbcType=INTEGER}");
        }
        
        if (record.getQrcodeExitElapseTimes() != null) {
            sql.VALUES("qrcode_exit_elapse_times", "#{qrcodeExitElapseTimes,jdbcType=INTEGER}");
        }
        
        if (record.getApplyRenewTimes() != null) {
            sql.VALUES("apply_renew_times", "#{applyRenewTimes,jdbcType=INTEGER}");
        }
        
        if (record.getQrcodeToken() != null) {
            sql.VALUES("qrcode_token", "#{qrcodeToken,jdbcType=VARCHAR}");
        }
        
        if (record.getQrcodeTokenTime() != null) {
            sql.VALUES("qrcode_token_time", "#{qrcodeTokenTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getQrcodeTokenIp() != null) {
            sql.VALUES("qrcode_token_ip", "#{qrcodeTokenIp,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(VisitVisitorInfoExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("aid");
        sql.SELECT("appointment");
        sql.SELECT("appointment_phone");
        sql.SELECT("appointment_uid");
        sql.SELECT("appointment_read_status");
        sql.SELECT("is_master");
        sql.SELECT("qrcode_create_time");
        sql.SELECT("qrcode_expire_time");
        sql.SELECT("qrcode_last_use_time");
        sql.SELECT("qrcode_entry_use_times");
        sql.SELECT("qrcode_exit_use_times");
        sql.SELECT("qrcode_entry_elapse_times");
        sql.SELECT("qrcode_exit_elapse_times");
        sql.SELECT("apply_renew_times");
        sql.SELECT("qrcode_token");
        sql.SELECT("qrcode_token_time");
        sql.SELECT("qrcode_token_ip");
        sql.FROM("visit_visitor_info");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        VisitVisitorInfo record = (VisitVisitorInfo) parameter.get("record");
        VisitVisitorInfoExample example = (VisitVisitorInfoExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("visit_visitor_info");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getAid() != null) {
            sql.SET("aid = #{record.aid,jdbcType=BIGINT}");
        }
        
        if (record.getAppointment() != null) {
            sql.SET("appointment = #{record.appointment,jdbcType=VARCHAR}");
        }
        
        if (record.getAppointmentPhone() != null) {
            sql.SET("appointment_phone = #{record.appointmentPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getAppointmentUid() != null) {
            sql.SET("appointment_uid = #{record.appointmentUid,jdbcType=BIGINT}");
        }
        
        if (record.getAppointmentReadStatus() != null) {
            sql.SET("appointment_read_status = #{record.appointmentReadStatus,jdbcType=INTEGER}");
        }
        
        if (record.getIsMaster() != null) {
            sql.SET("is_master = #{record.isMaster,jdbcType=TINYINT}");
        }
        
        if (record.getQrcodeCreateTime() != null) {
            sql.SET("qrcode_create_time = #{record.qrcodeCreateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getQrcodeExpireTime() != null) {
            sql.SET("qrcode_expire_time = #{record.qrcodeExpireTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getQrcodeLastUseTime() != null) {
            sql.SET("qrcode_last_use_time = #{record.qrcodeLastUseTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getQrcodeEntryUseTimes() != null) {
            sql.SET("qrcode_entry_use_times = #{record.qrcodeEntryUseTimes,jdbcType=INTEGER}");
        }
        
        if (record.getQrcodeExitUseTimes() != null) {
            sql.SET("qrcode_exit_use_times = #{record.qrcodeExitUseTimes,jdbcType=INTEGER}");
        }
        
        if (record.getQrcodeEntryElapseTimes() != null) {
            sql.SET("qrcode_entry_elapse_times = #{record.qrcodeEntryElapseTimes,jdbcType=INTEGER}");
        }
        
        if (record.getQrcodeExitElapseTimes() != null) {
            sql.SET("qrcode_exit_elapse_times = #{record.qrcodeExitElapseTimes,jdbcType=INTEGER}");
        }
        
        if (record.getApplyRenewTimes() != null) {
            sql.SET("apply_renew_times = #{record.applyRenewTimes,jdbcType=INTEGER}");
        }
        
        if (record.getQrcodeToken() != null) {
            sql.SET("qrcode_token = #{record.qrcodeToken,jdbcType=VARCHAR}");
        }
        
        if (record.getQrcodeTokenTime() != null) {
            sql.SET("qrcode_token_time = #{record.qrcodeTokenTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getQrcodeTokenIp() != null) {
            sql.SET("qrcode_token_ip = #{record.qrcodeTokenIp,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("visit_visitor_info");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("aid = #{record.aid,jdbcType=BIGINT}");
        sql.SET("appointment = #{record.appointment,jdbcType=VARCHAR}");
        sql.SET("appointment_phone = #{record.appointmentPhone,jdbcType=VARCHAR}");
        sql.SET("appointment_uid = #{record.appointmentUid,jdbcType=BIGINT}");
        sql.SET("appointment_read_status = #{record.appointmentReadStatus,jdbcType=INTEGER}");
        sql.SET("is_master = #{record.isMaster,jdbcType=TINYINT}");
        sql.SET("qrcode_create_time = #{record.qrcodeCreateTime,jdbcType=TIMESTAMP}");
        sql.SET("qrcode_expire_time = #{record.qrcodeExpireTime,jdbcType=TIMESTAMP}");
        sql.SET("qrcode_last_use_time = #{record.qrcodeLastUseTime,jdbcType=TIMESTAMP}");
        sql.SET("qrcode_entry_use_times = #{record.qrcodeEntryUseTimes,jdbcType=INTEGER}");
        sql.SET("qrcode_exit_use_times = #{record.qrcodeExitUseTimes,jdbcType=INTEGER}");
        sql.SET("qrcode_entry_elapse_times = #{record.qrcodeEntryElapseTimes,jdbcType=INTEGER}");
        sql.SET("qrcode_exit_elapse_times = #{record.qrcodeExitElapseTimes,jdbcType=INTEGER}");
        sql.SET("apply_renew_times = #{record.applyRenewTimes,jdbcType=INTEGER}");
        sql.SET("qrcode_token = #{record.qrcodeToken,jdbcType=VARCHAR}");
        sql.SET("qrcode_token_time = #{record.qrcodeTokenTime,jdbcType=TIMESTAMP}");
        sql.SET("qrcode_token_ip = #{record.qrcodeTokenIp,jdbcType=VARCHAR}");
        
        VisitVisitorInfoExample example = (VisitVisitorInfoExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(VisitVisitorInfo record) {
        SQL sql = new SQL();
        sql.UPDATE("visit_visitor_info");
        
        if (record.getAid() != null) {
            sql.SET("aid = #{aid,jdbcType=BIGINT}");
        }
        
        if (record.getAppointment() != null) {
            sql.SET("appointment = #{appointment,jdbcType=VARCHAR}");
        }
        
        if (record.getAppointmentPhone() != null) {
            sql.SET("appointment_phone = #{appointmentPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getAppointmentUid() != null) {
            sql.SET("appointment_uid = #{appointmentUid,jdbcType=BIGINT}");
        }
        
        if (record.getAppointmentReadStatus() != null) {
            sql.SET("appointment_read_status = #{appointmentReadStatus,jdbcType=INTEGER}");
        }
        
        if (record.getIsMaster() != null) {
            sql.SET("is_master = #{isMaster,jdbcType=TINYINT}");
        }
        
        if (record.getQrcodeCreateTime() != null) {
            sql.SET("qrcode_create_time = #{qrcodeCreateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getQrcodeExpireTime() != null) {
            sql.SET("qrcode_expire_time = #{qrcodeExpireTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getQrcodeLastUseTime() != null) {
            sql.SET("qrcode_last_use_time = #{qrcodeLastUseTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getQrcodeEntryUseTimes() != null) {
            sql.SET("qrcode_entry_use_times = #{qrcodeEntryUseTimes,jdbcType=INTEGER}");
        }
        
        if (record.getQrcodeExitUseTimes() != null) {
            sql.SET("qrcode_exit_use_times = #{qrcodeExitUseTimes,jdbcType=INTEGER}");
        }
        
        if (record.getQrcodeEntryElapseTimes() != null) {
            sql.SET("qrcode_entry_elapse_times = #{qrcodeEntryElapseTimes,jdbcType=INTEGER}");
        }
        
        if (record.getQrcodeExitElapseTimes() != null) {
            sql.SET("qrcode_exit_elapse_times = #{qrcodeExitElapseTimes,jdbcType=INTEGER}");
        }
        
        if (record.getApplyRenewTimes() != null) {
            sql.SET("apply_renew_times = #{applyRenewTimes,jdbcType=INTEGER}");
        }
        
        if (record.getQrcodeToken() != null) {
            sql.SET("qrcode_token = #{qrcodeToken,jdbcType=VARCHAR}");
        }
        
        if (record.getQrcodeTokenTime() != null) {
            sql.SET("qrcode_token_time = #{qrcodeTokenTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getQrcodeTokenIp() != null) {
            sql.SET("qrcode_token_ip = #{qrcodeTokenIp,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, VisitVisitorInfoExample example, boolean includeExamplePhrase) {
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