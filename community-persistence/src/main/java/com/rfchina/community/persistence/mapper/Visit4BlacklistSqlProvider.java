package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.Visit4Blacklist;
import com.rfchina.community.persistence.model.Visit4BlacklistExample.Criteria;
import com.rfchina.community.persistence.model.Visit4BlacklistExample.Criterion;
import com.rfchina.community.persistence.model.Visit4BlacklistExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class Visit4BlacklistSqlProvider {

    public String countByExample(Visit4BlacklistExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("visit4_blacklist");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(Visit4BlacklistExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("visit4_blacklist");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(Visit4Blacklist record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("visit4_blacklist");
        
        if (record.getCommunityId() != null) {
            sql.VALUES("community_id", "#{communityId,jdbcType=INTEGER}");
        }
        
        if (record.getTargetId() != null) {
            sql.VALUES("target_id", "#{targetId,jdbcType=BIGINT}");
        }
        
        if (record.getTargetType() != null) {
            sql.VALUES("target_type", "#{targetType,jdbcType=TINYINT}");
        }
        
        if (record.getTargetStatus() != null) {
            sql.VALUES("target_status", "#{targetStatus,jdbcType=TINYINT}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(Visit4BlacklistExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("community_id");
        } else {
            sql.SELECT("community_id");
        }
        sql.SELECT("target_id");
        sql.SELECT("target_type");
        sql.SELECT("target_status");
        sql.SELECT("create_time");
        sql.FROM("visit4_blacklist");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Visit4Blacklist record = (Visit4Blacklist) parameter.get("record");
        Visit4BlacklistExample example = (Visit4BlacklistExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("visit4_blacklist");
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        }
        
        if (record.getTargetId() != null) {
            sql.SET("target_id = #{record.targetId,jdbcType=BIGINT}");
        }
        
        if (record.getTargetType() != null) {
            sql.SET("target_type = #{record.targetType,jdbcType=TINYINT}");
        }
        
        if (record.getTargetStatus() != null) {
            sql.SET("target_status = #{record.targetStatus,jdbcType=TINYINT}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("visit4_blacklist");
        
        sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        sql.SET("target_id = #{record.targetId,jdbcType=BIGINT}");
        sql.SET("target_type = #{record.targetType,jdbcType=TINYINT}");
        sql.SET("target_status = #{record.targetStatus,jdbcType=TINYINT}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        
        Visit4BlacklistExample example = (Visit4BlacklistExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    protected void applyWhere(SQL sql, Visit4BlacklistExample example, boolean includeExamplePhrase) {
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