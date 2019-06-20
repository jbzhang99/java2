package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.Visit4Info;
import com.rfchina.community.persistence.model.Visit4InfoExample.Criteria;
import com.rfchina.community.persistence.model.Visit4InfoExample.Criterion;
import com.rfchina.community.persistence.model.Visit4InfoExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class Visit4InfoSqlProvider {

    public String countByExample(Visit4InfoExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("visit4_info");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(Visit4InfoExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("visit4_info");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(Visit4Info record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("visit4_info");
        
        if (record.getCreateUid() != null) {
            sql.VALUES("create_uid", "#{createUid,jdbcType=BIGINT}");
        }
        
        if (record.getCreateDate() != null) {
            sql.VALUES("create_date", "#{createDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCommunityId() != null) {
            sql.VALUES("community_id", "#{communityId,jdbcType=INTEGER}");
        }
        
        if (record.getChildId() != null) {
            sql.VALUES("child_id", "#{childId,jdbcType=BIGINT}");
        }
        
        if (record.getMasterId() != null) {
            sql.VALUES("master_id", "#{masterId,jdbcType=BIGINT}");
        }
        
        if (record.getType() != null) {
            sql.VALUES("type", "#{type,jdbcType=INTEGER}");
        }
        
        if (record.getVisitDate() != null) {
            sql.VALUES("visit_date", "#{visitDate,jdbcType=DATE}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getVisitCount() != null) {
            sql.VALUES("visit_count", "#{visitCount,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String selectByExample(Visit4InfoExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("create_uid");
        sql.SELECT("create_date");
        sql.SELECT("community_id");
        sql.SELECT("child_id");
        sql.SELECT("master_id");
        sql.SELECT("type");
        sql.SELECT("visit_date");
        sql.SELECT("status");
        sql.SELECT("visit_count");
        sql.FROM("visit4_info");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Visit4Info record = (Visit4Info) parameter.get("record");
        Visit4InfoExample example = (Visit4InfoExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("visit4_info");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getCreateUid() != null) {
            sql.SET("create_uid = #{record.createUid,jdbcType=BIGINT}");
        }
        
        if (record.getCreateDate() != null) {
            sql.SET("create_date = #{record.createDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        }
        
        if (record.getChildId() != null) {
            sql.SET("child_id = #{record.childId,jdbcType=BIGINT}");
        }
        
        if (record.getMasterId() != null) {
            sql.SET("master_id = #{record.masterId,jdbcType=BIGINT}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{record.type,jdbcType=INTEGER}");
        }
        
        if (record.getVisitDate() != null) {
            sql.SET("visit_date = #{record.visitDate,jdbcType=DATE}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=INTEGER}");
        }
        
        if (record.getVisitCount() != null) {
            sql.SET("visit_count = #{record.visitCount,jdbcType=INTEGER}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("visit4_info");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("create_uid = #{record.createUid,jdbcType=BIGINT}");
        sql.SET("create_date = #{record.createDate,jdbcType=TIMESTAMP}");
        sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        sql.SET("child_id = #{record.childId,jdbcType=BIGINT}");
        sql.SET("master_id = #{record.masterId,jdbcType=BIGINT}");
        sql.SET("type = #{record.type,jdbcType=INTEGER}");
        sql.SET("visit_date = #{record.visitDate,jdbcType=DATE}");
        sql.SET("status = #{record.status,jdbcType=INTEGER}");
        sql.SET("visit_count = #{record.visitCount,jdbcType=INTEGER}");
        
        Visit4InfoExample example = (Visit4InfoExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Visit4Info record) {
        SQL sql = new SQL();
        sql.UPDATE("visit4_info");
        
        if (record.getCreateUid() != null) {
            sql.SET("create_uid = #{createUid,jdbcType=BIGINT}");
        }
        
        if (record.getCreateDate() != null) {
            sql.SET("create_date = #{createDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{communityId,jdbcType=INTEGER}");
        }
        
        if (record.getChildId() != null) {
            sql.SET("child_id = #{childId,jdbcType=BIGINT}");
        }
        
        if (record.getMasterId() != null) {
            sql.SET("master_id = #{masterId,jdbcType=BIGINT}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{type,jdbcType=INTEGER}");
        }
        
        if (record.getVisitDate() != null) {
            sql.SET("visit_date = #{visitDate,jdbcType=DATE}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getVisitCount() != null) {
            sql.SET("visit_count = #{visitCount,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, Visit4InfoExample example, boolean includeExamplePhrase) {
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