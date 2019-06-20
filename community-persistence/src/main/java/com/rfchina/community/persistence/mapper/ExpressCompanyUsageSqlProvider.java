package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.ExpressCompanyUsage;
import com.rfchina.community.persistence.model.ExpressCompanyUsageExample.Criteria;
import com.rfchina.community.persistence.model.ExpressCompanyUsageExample.Criterion;
import com.rfchina.community.persistence.model.ExpressCompanyUsageExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class ExpressCompanyUsageSqlProvider {

    public String countByExample(ExpressCompanyUsageExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("express_company_usage");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(ExpressCompanyUsageExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("express_company_usage");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(ExpressCompanyUsage record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("express_company_usage");
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=VARCHAR}");
        }
        
        if (record.getServiceId() != null) {
            sql.VALUES("service_id", "#{serviceId,jdbcType=BIGINT}");
        }
        
        if (record.getComCode() != null) {
            sql.VALUES("com_code", "#{comCode,jdbcType=VARCHAR}");
        }
        
        if (record.getComName() != null) {
            sql.VALUES("com_name", "#{comName,jdbcType=VARCHAR}");
        }
        
        if (record.getUsageCount() != null) {
            sql.VALUES("usage_count", "#{usageCount,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(ExpressCompanyUsageExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("status");
        sql.SELECT("service_id");
        sql.SELECT("com_code");
        sql.SELECT("com_name");
        sql.SELECT("usage_count");
        sql.SELECT("create_time");
        sql.FROM("express_company_usage");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        ExpressCompanyUsage record = (ExpressCompanyUsage) parameter.get("record");
        ExpressCompanyUsageExample example = (ExpressCompanyUsageExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("express_company_usage");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=VARCHAR}");
        }
        
        if (record.getServiceId() != null) {
            sql.SET("service_id = #{record.serviceId,jdbcType=BIGINT}");
        }
        
        if (record.getComCode() != null) {
            sql.SET("com_code = #{record.comCode,jdbcType=VARCHAR}");
        }
        
        if (record.getComName() != null) {
            sql.SET("com_name = #{record.comName,jdbcType=VARCHAR}");
        }
        
        if (record.getUsageCount() != null) {
            sql.SET("usage_count = #{record.usageCount,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("express_company_usage");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("status = #{record.status,jdbcType=VARCHAR}");
        sql.SET("service_id = #{record.serviceId,jdbcType=BIGINT}");
        sql.SET("com_code = #{record.comCode,jdbcType=VARCHAR}");
        sql.SET("com_name = #{record.comName,jdbcType=VARCHAR}");
        sql.SET("usage_count = #{record.usageCount,jdbcType=INTEGER}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        
        ExpressCompanyUsageExample example = (ExpressCompanyUsageExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(ExpressCompanyUsage record) {
        SQL sql = new SQL();
        sql.UPDATE("express_company_usage");
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=VARCHAR}");
        }
        
        if (record.getServiceId() != null) {
            sql.SET("service_id = #{serviceId,jdbcType=BIGINT}");
        }
        
        if (record.getComCode() != null) {
            sql.SET("com_code = #{comCode,jdbcType=VARCHAR}");
        }
        
        if (record.getComName() != null) {
            sql.SET("com_name = #{comName,jdbcType=VARCHAR}");
        }
        
        if (record.getUsageCount() != null) {
            sql.SET("usage_count = #{usageCount,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, ExpressCompanyUsageExample example, boolean includeExamplePhrase) {
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