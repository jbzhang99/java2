package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.VenueOrderDetail;
import com.rfchina.community.persistence.model.VenueOrderDetailExample.Criteria;
import com.rfchina.community.persistence.model.VenueOrderDetailExample.Criterion;
import com.rfchina.community.persistence.model.VenueOrderDetailExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class VenueOrderDetailSqlProvider {

    public String countByExample(VenueOrderDetailExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("venue_order_detail");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(VenueOrderDetailExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("venue_order_detail");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(VenueOrderDetail record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("venue_order_detail");
        
        if (record.getOrderId() != null) {
            sql.VALUES("order_id", "#{orderId,jdbcType=BIGINT}");
        }
        
        if (record.getVenueId() != null) {
            sql.VALUES("venue_id", "#{venueId,jdbcType=BIGINT}");
        }
        
        if (record.getWeek() != null) {
            sql.VALUES("week", "#{week,jdbcType=INTEGER}");
        }
        
        if (record.getTimeSlice() != null) {
            sql.VALUES("time_slice", "#{timeSlice,jdbcType=VARCHAR}");
        }
        
        if (record.getPlayDate() != null) {
            sql.VALUES("play_date", "#{playDate,jdbcType=DATE}");
        }
        
        if (record.getPrice() != null) {
            sql.VALUES("price", "#{price,jdbcType=DECIMAL}");
        }
        
        return sql.toString();
    }

    public String selectByExample(VenueOrderDetailExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("order_id");
        sql.SELECT("venue_id");
        sql.SELECT("week");
        sql.SELECT("time_slice");
        sql.SELECT("play_date");
        sql.SELECT("price");
        sql.FROM("venue_order_detail");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        VenueOrderDetail record = (VenueOrderDetail) parameter.get("record");
        VenueOrderDetailExample example = (VenueOrderDetailExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("venue_order_detail");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getOrderId() != null) {
            sql.SET("order_id = #{record.orderId,jdbcType=BIGINT}");
        }
        
        if (record.getVenueId() != null) {
            sql.SET("venue_id = #{record.venueId,jdbcType=BIGINT}");
        }
        
        if (record.getWeek() != null) {
            sql.SET("week = #{record.week,jdbcType=INTEGER}");
        }
        
        if (record.getTimeSlice() != null) {
            sql.SET("time_slice = #{record.timeSlice,jdbcType=VARCHAR}");
        }
        
        if (record.getPlayDate() != null) {
            sql.SET("play_date = #{record.playDate,jdbcType=DATE}");
        }
        
        if (record.getPrice() != null) {
            sql.SET("price = #{record.price,jdbcType=DECIMAL}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("venue_order_detail");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("order_id = #{record.orderId,jdbcType=BIGINT}");
        sql.SET("venue_id = #{record.venueId,jdbcType=BIGINT}");
        sql.SET("week = #{record.week,jdbcType=INTEGER}");
        sql.SET("time_slice = #{record.timeSlice,jdbcType=VARCHAR}");
        sql.SET("play_date = #{record.playDate,jdbcType=DATE}");
        sql.SET("price = #{record.price,jdbcType=DECIMAL}");
        
        VenueOrderDetailExample example = (VenueOrderDetailExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(VenueOrderDetail record) {
        SQL sql = new SQL();
        sql.UPDATE("venue_order_detail");
        
        if (record.getOrderId() != null) {
            sql.SET("order_id = #{orderId,jdbcType=BIGINT}");
        }
        
        if (record.getVenueId() != null) {
            sql.SET("venue_id = #{venueId,jdbcType=BIGINT}");
        }
        
        if (record.getWeek() != null) {
            sql.SET("week = #{week,jdbcType=INTEGER}");
        }
        
        if (record.getTimeSlice() != null) {
            sql.SET("time_slice = #{timeSlice,jdbcType=VARCHAR}");
        }
        
        if (record.getPlayDate() != null) {
            sql.SET("play_date = #{playDate,jdbcType=DATE}");
        }
        
        if (record.getPrice() != null) {
            sql.SET("price = #{price,jdbcType=DECIMAL}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, VenueOrderDetailExample example, boolean includeExamplePhrase) {
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