package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenStatsOrder;
import com.rfchina.community.persistence.model.OpenStatsOrderExample.Criteria;
import com.rfchina.community.persistence.model.OpenStatsOrderExample.Criterion;
import com.rfchina.community.persistence.model.OpenStatsOrderExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class OpenStatsOrderSqlProvider {

    public String countByExample(OpenStatsOrderExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("open_stats_order");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(OpenStatsOrderExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("open_stats_order");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(OpenStatsOrder record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("open_stats_order");
        
        if (record.getStatDate() != null) {
            sql.VALUES("stat_date", "#{statDate,jdbcType=DATE}");
        }
        
        if (record.getCommunityId() != null) {
            sql.VALUES("community_id", "#{communityId,jdbcType=INTEGER}");
        }
        
        if (record.getServiceId() != null) {
            sql.VALUES("service_id", "#{serviceId,jdbcType=INTEGER}");
        }
        
        if (record.getStatWreek() != null) {
            sql.VALUES("stat_wreek", "#{statWreek,jdbcType=INTEGER}");
        }
        
        if (record.getStatMonth() != null) {
            sql.VALUES("stat_month", "#{statMonth,jdbcType=INTEGER}");
        }
        
        if (record.getOrderCount() != null) {
            sql.VALUES("order_count", "#{orderCount,jdbcType=INTEGER}");
        }
        
        if (record.getTotalAmount() != null) {
            sql.VALUES("total_amount", "#{totalAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getOrderCountTotal() != null) {
            sql.VALUES("order_count_total", "#{orderCountTotal,jdbcType=INTEGER}");
        }
        
        if (record.getTotalAmountTotal() != null) {
            sql.VALUES("total_amount_total", "#{totalAmountTotal,jdbcType=DECIMAL}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(OpenStatsOrderExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("stat_date");
        } else {
            sql.SELECT("stat_date");
        }
        sql.SELECT("community_id");
        sql.SELECT("service_id");
        sql.SELECT("stat_wreek");
        sql.SELECT("stat_month");
        sql.SELECT("order_count");
        sql.SELECT("total_amount");
        sql.SELECT("order_count_total");
        sql.SELECT("total_amount_total");
        sql.SELECT("create_time");
        sql.FROM("open_stats_order");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        OpenStatsOrder record = (OpenStatsOrder) parameter.get("record");
        OpenStatsOrderExample example = (OpenStatsOrderExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("open_stats_order");
        
        if (record.getStatDate() != null) {
            sql.SET("stat_date = #{record.statDate,jdbcType=DATE}");
        }
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        }
        
        if (record.getServiceId() != null) {
            sql.SET("service_id = #{record.serviceId,jdbcType=INTEGER}");
        }
        
        if (record.getStatWreek() != null) {
            sql.SET("stat_wreek = #{record.statWreek,jdbcType=INTEGER}");
        }
        
        if (record.getStatMonth() != null) {
            sql.SET("stat_month = #{record.statMonth,jdbcType=INTEGER}");
        }
        
        if (record.getOrderCount() != null) {
            sql.SET("order_count = #{record.orderCount,jdbcType=INTEGER}");
        }
        
        if (record.getTotalAmount() != null) {
            sql.SET("total_amount = #{record.totalAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getOrderCountTotal() != null) {
            sql.SET("order_count_total = #{record.orderCountTotal,jdbcType=INTEGER}");
        }
        
        if (record.getTotalAmountTotal() != null) {
            sql.SET("total_amount_total = #{record.totalAmountTotal,jdbcType=DECIMAL}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("open_stats_order");
        
        sql.SET("stat_date = #{record.statDate,jdbcType=DATE}");
        sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        sql.SET("service_id = #{record.serviceId,jdbcType=INTEGER}");
        sql.SET("stat_wreek = #{record.statWreek,jdbcType=INTEGER}");
        sql.SET("stat_month = #{record.statMonth,jdbcType=INTEGER}");
        sql.SET("order_count = #{record.orderCount,jdbcType=INTEGER}");
        sql.SET("total_amount = #{record.totalAmount,jdbcType=DECIMAL}");
        sql.SET("order_count_total = #{record.orderCountTotal,jdbcType=INTEGER}");
        sql.SET("total_amount_total = #{record.totalAmountTotal,jdbcType=DECIMAL}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        
        OpenStatsOrderExample example = (OpenStatsOrderExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(OpenStatsOrder record) {
        SQL sql = new SQL();
        sql.UPDATE("open_stats_order");
        
        if (record.getStatWreek() != null) {
            sql.SET("stat_wreek = #{statWreek,jdbcType=INTEGER}");
        }
        
        if (record.getStatMonth() != null) {
            sql.SET("stat_month = #{statMonth,jdbcType=INTEGER}");
        }
        
        if (record.getOrderCount() != null) {
            sql.SET("order_count = #{orderCount,jdbcType=INTEGER}");
        }
        
        if (record.getTotalAmount() != null) {
            sql.SET("total_amount = #{totalAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getOrderCountTotal() != null) {
            sql.SET("order_count_total = #{orderCountTotal,jdbcType=INTEGER}");
        }
        
        if (record.getTotalAmountTotal() != null) {
            sql.SET("total_amount_total = #{totalAmountTotal,jdbcType=DECIMAL}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("stat_date = #{statDate,jdbcType=DATE}");
        sql.WHERE("community_id = #{communityId,jdbcType=INTEGER}");
        sql.WHERE("service_id = #{serviceId,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, OpenStatsOrderExample example, boolean includeExamplePhrase) {
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