package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.StatVenueOrder;
import com.rfchina.community.persistence.model.StatVenueOrderExample.Criteria;
import com.rfchina.community.persistence.model.StatVenueOrderExample.Criterion;
import com.rfchina.community.persistence.model.StatVenueOrderExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class StatVenueOrderSqlProvider {

    public String countByExample(StatVenueOrderExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("stat_venue_order");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(StatVenueOrderExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("stat_venue_order");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(StatVenueOrder record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("stat_venue_order");
        
        if (record.getAreaId() != null) {
            sql.VALUES("area_id", "#{areaId,jdbcType=INTEGER}");
        }
        
        if (record.getCommunityId() != null) {
            sql.VALUES("community_id", "#{communityId,jdbcType=INTEGER}");
        }
        
        if (record.getCommunityType() != null) {
            sql.VALUES("community_type", "#{communityType,jdbcType=INTEGER}");
        }
        
        if (record.getUserCount() != null) {
            sql.VALUES("user_count", "#{userCount,jdbcType=INTEGER}");
        }
        
        if (record.getOrderCount() != null) {
            sql.VALUES("order_count", "#{orderCount,jdbcType=INTEGER}");
        }
        
        if (record.getRoomCount() != null) {
            sql.VALUES("room_count", "#{roomCount,jdbcType=INTEGER}");
        }
        
        if (record.getStatTime() != null) {
            sql.VALUES("stat_time", "#{statTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(StatVenueOrderExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("area_id");
        sql.SELECT("community_id");
        sql.SELECT("community_type");
        sql.SELECT("user_count");
        sql.SELECT("order_count");
        sql.SELECT("room_count");
        sql.SELECT("stat_time");
        sql.SELECT("create_time");
        sql.FROM("stat_venue_order");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        StatVenueOrder record = (StatVenueOrder) parameter.get("record");
        StatVenueOrderExample example = (StatVenueOrderExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("stat_venue_order");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getAreaId() != null) {
            sql.SET("area_id = #{record.areaId,jdbcType=INTEGER}");
        }
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        }
        
        if (record.getCommunityType() != null) {
            sql.SET("community_type = #{record.communityType,jdbcType=INTEGER}");
        }
        
        if (record.getUserCount() != null) {
            sql.SET("user_count = #{record.userCount,jdbcType=INTEGER}");
        }
        
        if (record.getOrderCount() != null) {
            sql.SET("order_count = #{record.orderCount,jdbcType=INTEGER}");
        }
        
        if (record.getRoomCount() != null) {
            sql.SET("room_count = #{record.roomCount,jdbcType=INTEGER}");
        }
        
        if (record.getStatTime() != null) {
            sql.SET("stat_time = #{record.statTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("stat_venue_order");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("area_id = #{record.areaId,jdbcType=INTEGER}");
        sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        sql.SET("community_type = #{record.communityType,jdbcType=INTEGER}");
        sql.SET("user_count = #{record.userCount,jdbcType=INTEGER}");
        sql.SET("order_count = #{record.orderCount,jdbcType=INTEGER}");
        sql.SET("room_count = #{record.roomCount,jdbcType=INTEGER}");
        sql.SET("stat_time = #{record.statTime,jdbcType=TIMESTAMP}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        
        StatVenueOrderExample example = (StatVenueOrderExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(StatVenueOrder record) {
        SQL sql = new SQL();
        sql.UPDATE("stat_venue_order");
        
        if (record.getAreaId() != null) {
            sql.SET("area_id = #{areaId,jdbcType=INTEGER}");
        }
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{communityId,jdbcType=INTEGER}");
        }
        
        if (record.getCommunityType() != null) {
            sql.SET("community_type = #{communityType,jdbcType=INTEGER}");
        }
        
        if (record.getUserCount() != null) {
            sql.SET("user_count = #{userCount,jdbcType=INTEGER}");
        }
        
        if (record.getOrderCount() != null) {
            sql.SET("order_count = #{orderCount,jdbcType=INTEGER}");
        }
        
        if (record.getRoomCount() != null) {
            sql.SET("room_count = #{roomCount,jdbcType=INTEGER}");
        }
        
        if (record.getStatTime() != null) {
            sql.SET("stat_time = #{statTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, StatVenueOrderExample example, boolean includeExamplePhrase) {
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