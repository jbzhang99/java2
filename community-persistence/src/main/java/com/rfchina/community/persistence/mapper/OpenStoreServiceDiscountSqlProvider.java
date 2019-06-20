package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenStoreServiceDiscount;
import com.rfchina.community.persistence.model.OpenStoreServiceDiscountExample.Criteria;
import com.rfchina.community.persistence.model.OpenStoreServiceDiscountExample.Criterion;
import com.rfchina.community.persistence.model.OpenStoreServiceDiscountExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class OpenStoreServiceDiscountSqlProvider {

    public String countByExample(OpenStoreServiceDiscountExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("open_store_service_discount");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(OpenStoreServiceDiscountExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("open_store_service_discount");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(OpenStoreServiceDiscount record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("open_store_service_discount");
        
        if (record.getServiceId() != null) {
            sql.VALUES("service_id", "#{serviceId,jdbcType=INTEGER}");
        }
        
        if (record.getDiscountPrice() != null) {
            sql.VALUES("discount_price", "#{discountPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getDiscountMoney() != null) {
            sql.VALUES("discount_money", "#{discountMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getEachMoneyTop() != null) {
            sql.VALUES("each_money_top", "#{eachMoneyTop,jdbcType=DECIMAL}");
        }
        
        if (record.getValidStatus() != null) {
            sql.VALUES("valid_status", "#{validStatus,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String selectByExample(OpenStoreServiceDiscountExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("service_id");
        } else {
            sql.SELECT("service_id");
        }
        sql.SELECT("discount_price");
        sql.SELECT("discount_money");
        sql.SELECT("each_money_top");
        sql.SELECT("valid_status");
        sql.FROM("open_store_service_discount");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        OpenStoreServiceDiscount record = (OpenStoreServiceDiscount) parameter.get("record");
        OpenStoreServiceDiscountExample example = (OpenStoreServiceDiscountExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("open_store_service_discount");
        
        if (record.getServiceId() != null) {
            sql.SET("service_id = #{record.serviceId,jdbcType=INTEGER}");
        }
        
        if (record.getDiscountPrice() != null) {
            sql.SET("discount_price = #{record.discountPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getDiscountMoney() != null) {
            sql.SET("discount_money = #{record.discountMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getEachMoneyTop() != null) {
            sql.SET("each_money_top = #{record.eachMoneyTop,jdbcType=DECIMAL}");
        }
        
        if (record.getValidStatus() != null) {
            sql.SET("valid_status = #{record.validStatus,jdbcType=INTEGER}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("open_store_service_discount");
        
        sql.SET("service_id = #{record.serviceId,jdbcType=INTEGER}");
        sql.SET("discount_price = #{record.discountPrice,jdbcType=DECIMAL}");
        sql.SET("discount_money = #{record.discountMoney,jdbcType=DECIMAL}");
        sql.SET("each_money_top = #{record.eachMoneyTop,jdbcType=DECIMAL}");
        sql.SET("valid_status = #{record.validStatus,jdbcType=INTEGER}");
        
        OpenStoreServiceDiscountExample example = (OpenStoreServiceDiscountExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(OpenStoreServiceDiscount record) {
        SQL sql = new SQL();
        sql.UPDATE("open_store_service_discount");
        
        if (record.getDiscountPrice() != null) {
            sql.SET("discount_price = #{discountPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getDiscountMoney() != null) {
            sql.SET("discount_money = #{discountMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getEachMoneyTop() != null) {
            sql.SET("each_money_top = #{eachMoneyTop,jdbcType=DECIMAL}");
        }
        
        if (record.getValidStatus() != null) {
            sql.SET("valid_status = #{validStatus,jdbcType=INTEGER}");
        }
        
        sql.WHERE("service_id = #{serviceId,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, OpenStoreServiceDiscountExample example, boolean includeExamplePhrase) {
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