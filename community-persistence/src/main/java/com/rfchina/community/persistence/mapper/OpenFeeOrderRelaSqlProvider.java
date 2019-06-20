package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenFeeOrderRelaExample.Criteria;
import com.rfchina.community.persistence.model.OpenFeeOrderRelaExample.Criterion;
import com.rfchina.community.persistence.model.OpenFeeOrderRelaExample;
import com.rfchina.community.persistence.model.OpenFeeOrderRelaKey;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class OpenFeeOrderRelaSqlProvider {

    public String countByExample(OpenFeeOrderRelaExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("open_fee_order_rela");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(OpenFeeOrderRelaExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("open_fee_order_rela");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(OpenFeeOrderRelaKey record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("open_fee_order_rela");
        
        if (record.getFeeId() != null) {
            sql.VALUES("fee_id", "#{feeId,jdbcType=BIGINT}");
        }
        
        if (record.getPayId() != null) {
            sql.VALUES("pay_id", "#{payId,jdbcType=BIGINT}");
        }
        
        return sql.toString();
    }

    public String selectByExample(OpenFeeOrderRelaExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("fee_id");
        } else {
            sql.SELECT("fee_id");
        }
        sql.SELECT("pay_id");
        sql.FROM("open_fee_order_rela");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        OpenFeeOrderRelaKey record = (OpenFeeOrderRelaKey) parameter.get("record");
        OpenFeeOrderRelaExample example = (OpenFeeOrderRelaExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("open_fee_order_rela");
        
        if (record.getFeeId() != null) {
            sql.SET("fee_id = #{record.feeId,jdbcType=BIGINT}");
        }
        
        if (record.getPayId() != null) {
            sql.SET("pay_id = #{record.payId,jdbcType=BIGINT}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("open_fee_order_rela");
        
        sql.SET("fee_id = #{record.feeId,jdbcType=BIGINT}");
        sql.SET("pay_id = #{record.payId,jdbcType=BIGINT}");
        
        OpenFeeOrderRelaExample example = (OpenFeeOrderRelaExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    protected void applyWhere(SQL sql, OpenFeeOrderRelaExample example, boolean includeExamplePhrase) {
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