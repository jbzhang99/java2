package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.VenueFilterTime;
import com.rfchina.community.persistence.model.VenueFilterTimeExample.Criteria;
import com.rfchina.community.persistence.model.VenueFilterTimeExample.Criterion;
import com.rfchina.community.persistence.model.VenueFilterTimeExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class VenueFilterTimeSqlProvider {

    public String countByExample(VenueFilterTimeExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("venue_filter_time");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(VenueFilterTimeExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("venue_filter_time");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(VenueFilterTime record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("venue_filter_time");
        
        if (record.getVenueId() != null) {
            sql.VALUES("venue_id", "#{venueId,jdbcType=BIGINT}");
        }
        
        if (record.getFilterType() != null) {
            sql.VALUES("filter_type", "#{filterType,jdbcType=INTEGER}");
        }
        
        if (record.getStartDate() != null) {
            sql.VALUES("start_date", "#{startDate,jdbcType=DATE}");
        }
        
        if (record.getEndDate() != null) {
            sql.VALUES("end_date", "#{endDate,jdbcType=DATE}");
        }
        
        if (record.getFilterDate() != null) {
            sql.VALUES("filter_date", "#{filterDate,jdbcType=DATE}");
        }
        
        if (record.getTimeSlice() != null) {
            sql.VALUES("time_slice", "#{timeSlice,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExampleWithBLOBs(VenueFilterTimeExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("venue_id");
        sql.SELECT("filter_type");
        sql.SELECT("start_date");
        sql.SELECT("end_date");
        sql.SELECT("filter_date");
        sql.SELECT("time_slice");
        sql.FROM("venue_filter_time");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String selectByExample(VenueFilterTimeExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("venue_id");
        sql.SELECT("filter_type");
        sql.SELECT("start_date");
        sql.SELECT("end_date");
        sql.SELECT("filter_date");
        sql.FROM("venue_filter_time");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        VenueFilterTime record = (VenueFilterTime) parameter.get("record");
        VenueFilterTimeExample example = (VenueFilterTimeExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("venue_filter_time");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getVenueId() != null) {
            sql.SET("venue_id = #{record.venueId,jdbcType=BIGINT}");
        }
        
        if (record.getFilterType() != null) {
            sql.SET("filter_type = #{record.filterType,jdbcType=INTEGER}");
        }
        
        if (record.getStartDate() != null) {
            sql.SET("start_date = #{record.startDate,jdbcType=DATE}");
        }
        
        if (record.getEndDate() != null) {
            sql.SET("end_date = #{record.endDate,jdbcType=DATE}");
        }
        
        if (record.getFilterDate() != null) {
            sql.SET("filter_date = #{record.filterDate,jdbcType=DATE}");
        }
        
        if (record.getTimeSlice() != null) {
            sql.SET("time_slice = #{record.timeSlice,jdbcType=LONGVARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("venue_filter_time");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("venue_id = #{record.venueId,jdbcType=BIGINT}");
        sql.SET("filter_type = #{record.filterType,jdbcType=INTEGER}");
        sql.SET("start_date = #{record.startDate,jdbcType=DATE}");
        sql.SET("end_date = #{record.endDate,jdbcType=DATE}");
        sql.SET("filter_date = #{record.filterDate,jdbcType=DATE}");
        sql.SET("time_slice = #{record.timeSlice,jdbcType=LONGVARCHAR}");
        
        VenueFilterTimeExample example = (VenueFilterTimeExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("venue_filter_time");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("venue_id = #{record.venueId,jdbcType=BIGINT}");
        sql.SET("filter_type = #{record.filterType,jdbcType=INTEGER}");
        sql.SET("start_date = #{record.startDate,jdbcType=DATE}");
        sql.SET("end_date = #{record.endDate,jdbcType=DATE}");
        sql.SET("filter_date = #{record.filterDate,jdbcType=DATE}");
        
        VenueFilterTimeExample example = (VenueFilterTimeExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(VenueFilterTime record) {
        SQL sql = new SQL();
        sql.UPDATE("venue_filter_time");
        
        if (record.getVenueId() != null) {
            sql.SET("venue_id = #{venueId,jdbcType=BIGINT}");
        }
        
        if (record.getFilterType() != null) {
            sql.SET("filter_type = #{filterType,jdbcType=INTEGER}");
        }
        
        if (record.getStartDate() != null) {
            sql.SET("start_date = #{startDate,jdbcType=DATE}");
        }
        
        if (record.getEndDate() != null) {
            sql.SET("end_date = #{endDate,jdbcType=DATE}");
        }
        
        if (record.getFilterDate() != null) {
            sql.SET("filter_date = #{filterDate,jdbcType=DATE}");
        }
        
        if (record.getTimeSlice() != null) {
            sql.SET("time_slice = #{timeSlice,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, VenueFilterTimeExample example, boolean includeExamplePhrase) {
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