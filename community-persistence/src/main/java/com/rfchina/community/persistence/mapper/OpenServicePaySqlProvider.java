package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenServicePay;
import com.rfchina.community.persistence.model.OpenServicePayExample.Criteria;
import com.rfchina.community.persistence.model.OpenServicePayExample.Criterion;
import com.rfchina.community.persistence.model.OpenServicePayExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class OpenServicePaySqlProvider {

    public String countByExample(OpenServicePayExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("open_service_pay");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(OpenServicePayExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("open_service_pay");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(OpenServicePay record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("open_service_pay");
        
        if (record.getServiceId() != null) {
            sql.VALUES("service_id", "#{serviceId,jdbcType=INTEGER}");
        }
        
        if (record.getPlatformFee() != null) {
            sql.VALUES("platform_fee", "#{platformFee,jdbcType=DECIMAL}");
        }
        
        if (record.getThinkRate() != null) {
            sql.VALUES("think_rate", "#{thinkRate,jdbcType=DECIMAL}");
        }
        
        if (record.getCommunityRate() != null) {
            sql.VALUES("community_rate", "#{communityRate,jdbcType=DECIMAL}");
        }
        
        return sql.toString();
    }

    public String selectByExample(OpenServicePayExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("service_id");
        } else {
            sql.SELECT("service_id");
        }
        sql.SELECT("platform_fee");
        sql.SELECT("think_rate");
        sql.SELECT("community_rate");
        sql.FROM("open_service_pay");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        OpenServicePay record = (OpenServicePay) parameter.get("record");
        OpenServicePayExample example = (OpenServicePayExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("open_service_pay");
        
        if (record.getServiceId() != null) {
            sql.SET("service_id = #{record.serviceId,jdbcType=INTEGER}");
        }
        
        if (record.getPlatformFee() != null) {
            sql.SET("platform_fee = #{record.platformFee,jdbcType=DECIMAL}");
        }
        
        if (record.getThinkRate() != null) {
            sql.SET("think_rate = #{record.thinkRate,jdbcType=DECIMAL}");
        }
        
        if (record.getCommunityRate() != null) {
            sql.SET("community_rate = #{record.communityRate,jdbcType=DECIMAL}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("open_service_pay");
        
        sql.SET("service_id = #{record.serviceId,jdbcType=INTEGER}");
        sql.SET("platform_fee = #{record.platformFee,jdbcType=DECIMAL}");
        sql.SET("think_rate = #{record.thinkRate,jdbcType=DECIMAL}");
        sql.SET("community_rate = #{record.communityRate,jdbcType=DECIMAL}");
        
        OpenServicePayExample example = (OpenServicePayExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(OpenServicePay record) {
        SQL sql = new SQL();
        sql.UPDATE("open_service_pay");
        
        if (record.getPlatformFee() != null) {
            sql.SET("platform_fee = #{platformFee,jdbcType=DECIMAL}");
        }
        
        if (record.getThinkRate() != null) {
            sql.SET("think_rate = #{thinkRate,jdbcType=DECIMAL}");
        }
        
        if (record.getCommunityRate() != null) {
            sql.SET("community_rate = #{communityRate,jdbcType=DECIMAL}");
        }
        
        sql.WHERE("service_id = #{serviceId,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, OpenServicePayExample example, boolean includeExamplePhrase) {
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