package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenAppServiceRela;
import com.rfchina.community.persistence.model.OpenAppServiceRelaExample.Criteria;
import com.rfchina.community.persistence.model.OpenAppServiceRelaExample.Criterion;
import com.rfchina.community.persistence.model.OpenAppServiceRelaExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class OpenAppServiceRelaSqlProvider {

    public String countByExample(OpenAppServiceRelaExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("open_app_service_rela");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(OpenAppServiceRelaExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("open_app_service_rela");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(OpenAppServiceRela record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("open_app_service_rela");
        
        if (record.getAppId() != null) {
            sql.VALUES("app_id", "#{appId,jdbcType=BIGINT}");
        }
        
        if (record.getServiceId() != null) {
            sql.VALUES("service_id", "#{serviceId,jdbcType=BIGINT}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getAuditTime() != null) {
            sql.VALUES("audit_time", "#{auditTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAuditComment() != null) {
            sql.VALUES("audit_comment", "#{auditComment,jdbcType=VARCHAR}");
        }
        
        if (record.getLevelId() != null) {
            sql.VALUES("level_id", "#{levelId,jdbcType=INTEGER}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(OpenAppServiceRelaExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("app_id");
        sql.SELECT("service_id");
        sql.SELECT("create_time");
        sql.SELECT("status");
        sql.SELECT("audit_time");
        sql.SELECT("audit_comment");
        sql.SELECT("level_id");
        sql.SELECT("update_time");
        sql.FROM("open_app_service_rela");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        OpenAppServiceRela record = (OpenAppServiceRela) parameter.get("record");
        OpenAppServiceRelaExample example = (OpenAppServiceRelaExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("open_app_service_rela");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getAppId() != null) {
            sql.SET("app_id = #{record.appId,jdbcType=BIGINT}");
        }
        
        if (record.getServiceId() != null) {
            sql.SET("service_id = #{record.serviceId,jdbcType=BIGINT}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=INTEGER}");
        }
        
        if (record.getAuditTime() != null) {
            sql.SET("audit_time = #{record.auditTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAuditComment() != null) {
            sql.SET("audit_comment = #{record.auditComment,jdbcType=VARCHAR}");
        }
        
        if (record.getLevelId() != null) {
            sql.SET("level_id = #{record.levelId,jdbcType=INTEGER}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("open_app_service_rela");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("app_id = #{record.appId,jdbcType=BIGINT}");
        sql.SET("service_id = #{record.serviceId,jdbcType=BIGINT}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("status = #{record.status,jdbcType=INTEGER}");
        sql.SET("audit_time = #{record.auditTime,jdbcType=TIMESTAMP}");
        sql.SET("audit_comment = #{record.auditComment,jdbcType=VARCHAR}");
        sql.SET("level_id = #{record.levelId,jdbcType=INTEGER}");
        sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        
        OpenAppServiceRelaExample example = (OpenAppServiceRelaExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(OpenAppServiceRela record) {
        SQL sql = new SQL();
        sql.UPDATE("open_app_service_rela");
        
        if (record.getAppId() != null) {
            sql.SET("app_id = #{appId,jdbcType=BIGINT}");
        }
        
        if (record.getServiceId() != null) {
            sql.SET("service_id = #{serviceId,jdbcType=BIGINT}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getAuditTime() != null) {
            sql.SET("audit_time = #{auditTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAuditComment() != null) {
            sql.SET("audit_comment = #{auditComment,jdbcType=VARCHAR}");
        }
        
        if (record.getLevelId() != null) {
            sql.SET("level_id = #{levelId,jdbcType=INTEGER}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, OpenAppServiceRelaExample example, boolean includeExamplePhrase) {
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