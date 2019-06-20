package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenServiceInterface;
import com.rfchina.community.persistence.model.OpenServiceInterfaceExample.Criteria;
import com.rfchina.community.persistence.model.OpenServiceInterfaceExample.Criterion;
import com.rfchina.community.persistence.model.OpenServiceInterfaceExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class OpenServiceInterfaceSqlProvider {

    public String countByExample(OpenServiceInterfaceExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("open_service_interface");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(OpenServiceInterfaceExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("open_service_interface");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(OpenServiceInterface record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("open_service_interface");
        
        if (record.getServiceId() != null) {
            sql.VALUES("service_id", "#{serviceId,jdbcType=INTEGER}");
        }
        
        if (record.getInterfaceId() != null) {
            sql.VALUES("interface_id", "#{interfaceId,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAuditStatus() != null) {
            sql.VALUES("audit_status", "#{auditStatus,jdbcType=INTEGER}");
        }
        
        if (record.getAuditComment() != null) {
            sql.VALUES("audit_comment", "#{auditComment,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String selectByExample(OpenServiceInterfaceExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("service_id");
        sql.SELECT("interface_id");
        sql.SELECT("create_time");
        sql.SELECT("audit_status");
        sql.SELECT("audit_comment");
        sql.SELECT("status");
        sql.FROM("open_service_interface");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        OpenServiceInterface record = (OpenServiceInterface) parameter.get("record");
        OpenServiceInterfaceExample example = (OpenServiceInterfaceExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("open_service_interface");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getServiceId() != null) {
            sql.SET("service_id = #{record.serviceId,jdbcType=INTEGER}");
        }
        
        if (record.getInterfaceId() != null) {
            sql.SET("interface_id = #{record.interfaceId,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAuditStatus() != null) {
            sql.SET("audit_status = #{record.auditStatus,jdbcType=INTEGER}");
        }
        
        if (record.getAuditComment() != null) {
            sql.SET("audit_comment = #{record.auditComment,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=INTEGER}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("open_service_interface");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("service_id = #{record.serviceId,jdbcType=INTEGER}");
        sql.SET("interface_id = #{record.interfaceId,jdbcType=INTEGER}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("audit_status = #{record.auditStatus,jdbcType=INTEGER}");
        sql.SET("audit_comment = #{record.auditComment,jdbcType=VARCHAR}");
        sql.SET("status = #{record.status,jdbcType=INTEGER}");
        
        OpenServiceInterfaceExample example = (OpenServiceInterfaceExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(OpenServiceInterface record) {
        SQL sql = new SQL();
        sql.UPDATE("open_service_interface");
        
        if (record.getServiceId() != null) {
            sql.SET("service_id = #{serviceId,jdbcType=INTEGER}");
        }
        
        if (record.getInterfaceId() != null) {
            sql.SET("interface_id = #{interfaceId,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAuditStatus() != null) {
            sql.SET("audit_status = #{auditStatus,jdbcType=INTEGER}");
        }
        
        if (record.getAuditComment() != null) {
            sql.SET("audit_comment = #{auditComment,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, OpenServiceInterfaceExample example, boolean includeExamplePhrase) {
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