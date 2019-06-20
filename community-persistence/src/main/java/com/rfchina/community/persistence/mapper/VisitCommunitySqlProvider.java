package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.VisitCommunity;
import com.rfchina.community.persistence.model.VisitCommunityExample.Criteria;
import com.rfchina.community.persistence.model.VisitCommunityExample.Criterion;
import com.rfchina.community.persistence.model.VisitCommunityExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class VisitCommunitySqlProvider {

    public String countByExample(VisitCommunityExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("visit_community");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(VisitCommunityExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("visit_community");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(VisitCommunity record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("visit_community");
        
        if (record.getCommunityId() != null) {
            sql.VALUES("community_id", "#{communityId,jdbcType=INTEGER}");
        }
        
        if (record.getFollowMax() != null) {
            sql.VALUES("follow_max", "#{followMax,jdbcType=INTEGER}");
        }
        
        if (record.getFollowMust() != null) {
            sql.VALUES("follow_must", "#{followMust,jdbcType=TINYINT}");
        }
        
        if (record.getOpenTime() != null) {
            sql.VALUES("open_time", "#{openTime,jdbcType=VARCHAR}");
        }
        
        if (record.getClosingTime() != null) {
            sql.VALUES("closing_time", "#{closingTime,jdbcType=VARCHAR}");
        }
        
        if (record.getIsEntranceGuard() != null) {
            sql.VALUES("is_entrance_guard", "#{isEntranceGuard,jdbcType=INTEGER}");
        }
        
        if (record.getEntranceGuardType() != null) {
            sql.VALUES("entrance_guard_type", "#{entranceGuardType,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String selectByExample(VisitCommunityExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("community_id");
        } else {
            sql.SELECT("community_id");
        }
        sql.SELECT("follow_max");
        sql.SELECT("follow_must");
        sql.SELECT("open_time");
        sql.SELECT("closing_time");
        sql.SELECT("is_entrance_guard");
        sql.SELECT("entrance_guard_type");
        sql.FROM("visit_community");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        VisitCommunity record = (VisitCommunity) parameter.get("record");
        VisitCommunityExample example = (VisitCommunityExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("visit_community");
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        }
        
        if (record.getFollowMax() != null) {
            sql.SET("follow_max = #{record.followMax,jdbcType=INTEGER}");
        }
        
        if (record.getFollowMust() != null) {
            sql.SET("follow_must = #{record.followMust,jdbcType=TINYINT}");
        }
        
        if (record.getOpenTime() != null) {
            sql.SET("open_time = #{record.openTime,jdbcType=VARCHAR}");
        }
        
        if (record.getClosingTime() != null) {
            sql.SET("closing_time = #{record.closingTime,jdbcType=VARCHAR}");
        }
        
        if (record.getIsEntranceGuard() != null) {
            sql.SET("is_entrance_guard = #{record.isEntranceGuard,jdbcType=INTEGER}");
        }
        
        if (record.getEntranceGuardType() != null) {
            sql.SET("entrance_guard_type = #{record.entranceGuardType,jdbcType=INTEGER}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("visit_community");
        
        sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        sql.SET("follow_max = #{record.followMax,jdbcType=INTEGER}");
        sql.SET("follow_must = #{record.followMust,jdbcType=TINYINT}");
        sql.SET("open_time = #{record.openTime,jdbcType=VARCHAR}");
        sql.SET("closing_time = #{record.closingTime,jdbcType=VARCHAR}");
        sql.SET("is_entrance_guard = #{record.isEntranceGuard,jdbcType=INTEGER}");
        sql.SET("entrance_guard_type = #{record.entranceGuardType,jdbcType=INTEGER}");
        
        VisitCommunityExample example = (VisitCommunityExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(VisitCommunity record) {
        SQL sql = new SQL();
        sql.UPDATE("visit_community");
        
        if (record.getFollowMax() != null) {
            sql.SET("follow_max = #{followMax,jdbcType=INTEGER}");
        }
        
        if (record.getFollowMust() != null) {
            sql.SET("follow_must = #{followMust,jdbcType=TINYINT}");
        }
        
        if (record.getOpenTime() != null) {
            sql.SET("open_time = #{openTime,jdbcType=VARCHAR}");
        }
        
        if (record.getClosingTime() != null) {
            sql.SET("closing_time = #{closingTime,jdbcType=VARCHAR}");
        }
        
        if (record.getIsEntranceGuard() != null) {
            sql.SET("is_entrance_guard = #{isEntranceGuard,jdbcType=INTEGER}");
        }
        
        if (record.getEntranceGuardType() != null) {
            sql.SET("entrance_guard_type = #{entranceGuardType,jdbcType=INTEGER}");
        }
        
        sql.WHERE("community_id = #{communityId,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, VisitCommunityExample example, boolean includeExamplePhrase) {
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