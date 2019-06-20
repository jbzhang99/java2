package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenStatsMerchant;
import com.rfchina.community.persistence.model.OpenStatsMerchantExample.Criteria;
import com.rfchina.community.persistence.model.OpenStatsMerchantExample.Criterion;
import com.rfchina.community.persistence.model.OpenStatsMerchantExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class OpenStatsMerchantSqlProvider {

    public String countByExample(OpenStatsMerchantExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("open_stats_merchant");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(OpenStatsMerchantExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("open_stats_merchant");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(OpenStatsMerchant record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("open_stats_merchant");
        
        if (record.getStatDate() != null) {
            sql.VALUES("stat_date", "#{statDate,jdbcType=DATE}");
        }
        
        if (record.getStatWreek() != null) {
            sql.VALUES("stat_wreek", "#{statWreek,jdbcType=INTEGER}");
        }
        
        if (record.getStatMonth() != null) {
            sql.VALUES("stat_month", "#{statMonth,jdbcType=INTEGER}");
        }
        
        if (record.getMerchantCount() != null) {
            sql.VALUES("merchant_count", "#{merchantCount,jdbcType=INTEGER}");
        }
        
        if (record.getShelvesCount() != null) {
            sql.VALUES("shelves_count", "#{shelvesCount,jdbcType=INTEGER}");
        }
        
        if (record.getMerchantTotal() != null) {
            sql.VALUES("merchant_total", "#{merchantTotal,jdbcType=INTEGER}");
        }
        
        if (record.getShelvesTotal() != null) {
            sql.VALUES("shelves_total", "#{shelvesTotal,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(OpenStatsMerchantExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("stat_date");
        } else {
            sql.SELECT("stat_date");
        }
        sql.SELECT("stat_wreek");
        sql.SELECT("stat_month");
        sql.SELECT("merchant_count");
        sql.SELECT("shelves_count");
        sql.SELECT("merchant_total");
        sql.SELECT("shelves_total");
        sql.SELECT("create_time");
        sql.FROM("open_stats_merchant");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        OpenStatsMerchant record = (OpenStatsMerchant) parameter.get("record");
        OpenStatsMerchantExample example = (OpenStatsMerchantExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("open_stats_merchant");
        
        if (record.getStatDate() != null) {
            sql.SET("stat_date = #{record.statDate,jdbcType=DATE}");
        }
        
        if (record.getStatWreek() != null) {
            sql.SET("stat_wreek = #{record.statWreek,jdbcType=INTEGER}");
        }
        
        if (record.getStatMonth() != null) {
            sql.SET("stat_month = #{record.statMonth,jdbcType=INTEGER}");
        }
        
        if (record.getMerchantCount() != null) {
            sql.SET("merchant_count = #{record.merchantCount,jdbcType=INTEGER}");
        }
        
        if (record.getShelvesCount() != null) {
            sql.SET("shelves_count = #{record.shelvesCount,jdbcType=INTEGER}");
        }
        
        if (record.getMerchantTotal() != null) {
            sql.SET("merchant_total = #{record.merchantTotal,jdbcType=INTEGER}");
        }
        
        if (record.getShelvesTotal() != null) {
            sql.SET("shelves_total = #{record.shelvesTotal,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("open_stats_merchant");
        
        sql.SET("stat_date = #{record.statDate,jdbcType=DATE}");
        sql.SET("stat_wreek = #{record.statWreek,jdbcType=INTEGER}");
        sql.SET("stat_month = #{record.statMonth,jdbcType=INTEGER}");
        sql.SET("merchant_count = #{record.merchantCount,jdbcType=INTEGER}");
        sql.SET("shelves_count = #{record.shelvesCount,jdbcType=INTEGER}");
        sql.SET("merchant_total = #{record.merchantTotal,jdbcType=INTEGER}");
        sql.SET("shelves_total = #{record.shelvesTotal,jdbcType=INTEGER}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        
        OpenStatsMerchantExample example = (OpenStatsMerchantExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(OpenStatsMerchant record) {
        SQL sql = new SQL();
        sql.UPDATE("open_stats_merchant");
        
        if (record.getStatWreek() != null) {
            sql.SET("stat_wreek = #{statWreek,jdbcType=INTEGER}");
        }
        
        if (record.getStatMonth() != null) {
            sql.SET("stat_month = #{statMonth,jdbcType=INTEGER}");
        }
        
        if (record.getMerchantCount() != null) {
            sql.SET("merchant_count = #{merchantCount,jdbcType=INTEGER}");
        }
        
        if (record.getShelvesCount() != null) {
            sql.SET("shelves_count = #{shelvesCount,jdbcType=INTEGER}");
        }
        
        if (record.getMerchantTotal() != null) {
            sql.SET("merchant_total = #{merchantTotal,jdbcType=INTEGER}");
        }
        
        if (record.getShelvesTotal() != null) {
            sql.SET("shelves_total = #{shelvesTotal,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("stat_date = #{statDate,jdbcType=DATE}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, OpenStatsMerchantExample example, boolean includeExamplePhrase) {
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