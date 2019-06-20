package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenAuditInfo;
import com.rfchina.community.persistence.model.OpenAuditInfoExample.Criteria;
import com.rfchina.community.persistence.model.OpenAuditInfoExample.Criterion;
import com.rfchina.community.persistence.model.OpenAuditInfoExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class OpenAuditInfoSqlProvider {

    public String countByExample(OpenAuditInfoExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("open_audit_info");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(OpenAuditInfoExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("open_audit_info");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(OpenAuditInfo record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("open_audit_info");
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getSrcUid() != null) {
            sql.VALUES("src_uid", "#{srcUid,jdbcType=BIGINT}");
        }
        
        if (record.getAuditType() != null) {
            sql.VALUES("audit_type", "#{auditType,jdbcType=VARCHAR}");
        }
        
        if (record.getAuditStatus() != null) {
            sql.VALUES("audit_status", "#{auditStatus,jdbcType=INTEGER}");
        }
        
        if (record.getAuditContent() != null) {
            sql.VALUES("audit_content", "#{auditContent,jdbcType=VARCHAR}");
        }
        
        if (record.getObjectId() != null) {
            sql.VALUES("object_id", "#{objectId,jdbcType=VARCHAR}");
        }
        
        if (record.getAuditUid() != null) {
            sql.VALUES("audit_uid", "#{auditUid,jdbcType=BIGINT}");
        }
        
        if (record.getServiceId() != null) {
            sql.VALUES("service_id", "#{serviceId,jdbcType=INTEGER}");
        }
        
        if (record.getPagerId() != null) {
            sql.VALUES("pager_id", "#{pagerId,jdbcType=VARCHAR}");
        }
        
        if (record.getMerchantId() != null) {
            sql.VALUES("merchant_id", "#{merchantId,jdbcType=BIGINT}");
        }
        
        if (record.getAuditPhone() != null) {
            sql.VALUES("audit_phone", "#{auditPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getAuditName() != null) {
            sql.VALUES("audit_name", "#{auditName,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(OpenAuditInfoExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("create_time");
        sql.SELECT("update_time");
        sql.SELECT("src_uid");
        sql.SELECT("audit_type");
        sql.SELECT("audit_status");
        sql.SELECT("audit_content");
        sql.SELECT("object_id");
        sql.SELECT("audit_uid");
        sql.SELECT("service_id");
        sql.SELECT("pager_id");
        sql.SELECT("merchant_id");
        sql.SELECT("audit_phone");
        sql.SELECT("audit_name");
        sql.FROM("open_audit_info");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        OpenAuditInfo record = (OpenAuditInfo) parameter.get("record");
        OpenAuditInfoExample example = (OpenAuditInfoExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("open_audit_info");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getSrcUid() != null) {
            sql.SET("src_uid = #{record.srcUid,jdbcType=BIGINT}");
        }
        
        if (record.getAuditType() != null) {
            sql.SET("audit_type = #{record.auditType,jdbcType=VARCHAR}");
        }
        
        if (record.getAuditStatus() != null) {
            sql.SET("audit_status = #{record.auditStatus,jdbcType=INTEGER}");
        }
        
        if (record.getAuditContent() != null) {
            sql.SET("audit_content = #{record.auditContent,jdbcType=VARCHAR}");
        }
        
        if (record.getObjectId() != null) {
            sql.SET("object_id = #{record.objectId,jdbcType=VARCHAR}");
        }
        
        if (record.getAuditUid() != null) {
            sql.SET("audit_uid = #{record.auditUid,jdbcType=BIGINT}");
        }
        
        if (record.getServiceId() != null) {
            sql.SET("service_id = #{record.serviceId,jdbcType=INTEGER}");
        }
        
        if (record.getPagerId() != null) {
            sql.SET("pager_id = #{record.pagerId,jdbcType=VARCHAR}");
        }
        
        if (record.getMerchantId() != null) {
            sql.SET("merchant_id = #{record.merchantId,jdbcType=BIGINT}");
        }
        
        if (record.getAuditPhone() != null) {
            sql.SET("audit_phone = #{record.auditPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getAuditName() != null) {
            sql.SET("audit_name = #{record.auditName,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("open_audit_info");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        sql.SET("src_uid = #{record.srcUid,jdbcType=BIGINT}");
        sql.SET("audit_type = #{record.auditType,jdbcType=VARCHAR}");
        sql.SET("audit_status = #{record.auditStatus,jdbcType=INTEGER}");
        sql.SET("audit_content = #{record.auditContent,jdbcType=VARCHAR}");
        sql.SET("object_id = #{record.objectId,jdbcType=VARCHAR}");
        sql.SET("audit_uid = #{record.auditUid,jdbcType=BIGINT}");
        sql.SET("service_id = #{record.serviceId,jdbcType=INTEGER}");
        sql.SET("pager_id = #{record.pagerId,jdbcType=VARCHAR}");
        sql.SET("merchant_id = #{record.merchantId,jdbcType=BIGINT}");
        sql.SET("audit_phone = #{record.auditPhone,jdbcType=VARCHAR}");
        sql.SET("audit_name = #{record.auditName,jdbcType=VARCHAR}");
        
        OpenAuditInfoExample example = (OpenAuditInfoExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(OpenAuditInfo record) {
        SQL sql = new SQL();
        sql.UPDATE("open_audit_info");
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getSrcUid() != null) {
            sql.SET("src_uid = #{srcUid,jdbcType=BIGINT}");
        }
        
        if (record.getAuditType() != null) {
            sql.SET("audit_type = #{auditType,jdbcType=VARCHAR}");
        }
        
        if (record.getAuditStatus() != null) {
            sql.SET("audit_status = #{auditStatus,jdbcType=INTEGER}");
        }
        
        if (record.getAuditContent() != null) {
            sql.SET("audit_content = #{auditContent,jdbcType=VARCHAR}");
        }
        
        if (record.getObjectId() != null) {
            sql.SET("object_id = #{objectId,jdbcType=VARCHAR}");
        }
        
        if (record.getAuditUid() != null) {
            sql.SET("audit_uid = #{auditUid,jdbcType=BIGINT}");
        }
        
        if (record.getServiceId() != null) {
            sql.SET("service_id = #{serviceId,jdbcType=INTEGER}");
        }
        
        if (record.getPagerId() != null) {
            sql.SET("pager_id = #{pagerId,jdbcType=VARCHAR}");
        }
        
        if (record.getMerchantId() != null) {
            sql.SET("merchant_id = #{merchantId,jdbcType=BIGINT}");
        }
        
        if (record.getAuditPhone() != null) {
            sql.SET("audit_phone = #{auditPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getAuditName() != null) {
            sql.SET("audit_name = #{auditName,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, OpenAuditInfoExample example, boolean includeExamplePhrase) {
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