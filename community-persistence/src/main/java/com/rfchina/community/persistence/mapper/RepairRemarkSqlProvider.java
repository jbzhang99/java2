package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.RepairRemark;
import com.rfchina.community.persistence.model.RepairRemarkExample.Criteria;
import com.rfchina.community.persistence.model.RepairRemarkExample.Criterion;
import com.rfchina.community.persistence.model.RepairRemarkExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class RepairRemarkSqlProvider {

    public String countByExample(RepairRemarkExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("repair_remark");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(RepairRemarkExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("repair_remark");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(RepairRemark record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("repair_remark");
        
        if (record.getRepairRecordId() != null) {
            sql.VALUES("repair_record_id", "#{repairRecordId,jdbcType=BIGINT}");
        }
        
        if (record.getScore() != null) {
            sql.VALUES("score", "#{score,jdbcType=INTEGER}");
        }
        
        if (record.getScoreContent() != null) {
            sql.VALUES("score_content", "#{scoreContent,jdbcType=VARCHAR}");
        }
        
        if (record.getScoreMedia() != null) {
            sql.VALUES("score_media", "#{scoreMedia,jdbcType=VARCHAR}");
        }
        
        if (record.getScoreTime() != null) {
            sql.VALUES("score_time", "#{scoreTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(RepairRemarkExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("repair_record_id");
        sql.SELECT("score");
        sql.SELECT("score_content");
        sql.SELECT("score_media");
        sql.SELECT("score_time");
        sql.FROM("repair_remark");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        RepairRemark record = (RepairRemark) parameter.get("record");
        RepairRemarkExample example = (RepairRemarkExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("repair_remark");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getRepairRecordId() != null) {
            sql.SET("repair_record_id = #{record.repairRecordId,jdbcType=BIGINT}");
        }
        
        if (record.getScore() != null) {
            sql.SET("score = #{record.score,jdbcType=INTEGER}");
        }
        
        if (record.getScoreContent() != null) {
            sql.SET("score_content = #{record.scoreContent,jdbcType=VARCHAR}");
        }
        
        if (record.getScoreMedia() != null) {
            sql.SET("score_media = #{record.scoreMedia,jdbcType=VARCHAR}");
        }
        
        if (record.getScoreTime() != null) {
            sql.SET("score_time = #{record.scoreTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("repair_remark");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("repair_record_id = #{record.repairRecordId,jdbcType=BIGINT}");
        sql.SET("score = #{record.score,jdbcType=INTEGER}");
        sql.SET("score_content = #{record.scoreContent,jdbcType=VARCHAR}");
        sql.SET("score_media = #{record.scoreMedia,jdbcType=VARCHAR}");
        sql.SET("score_time = #{record.scoreTime,jdbcType=TIMESTAMP}");
        
        RepairRemarkExample example = (RepairRemarkExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(RepairRemark record) {
        SQL sql = new SQL();
        sql.UPDATE("repair_remark");
        
        if (record.getRepairRecordId() != null) {
            sql.SET("repair_record_id = #{repairRecordId,jdbcType=BIGINT}");
        }
        
        if (record.getScore() != null) {
            sql.SET("score = #{score,jdbcType=INTEGER}");
        }
        
        if (record.getScoreContent() != null) {
            sql.SET("score_content = #{scoreContent,jdbcType=VARCHAR}");
        }
        
        if (record.getScoreMedia() != null) {
            sql.SET("score_media = #{scoreMedia,jdbcType=VARCHAR}");
        }
        
        if (record.getScoreTime() != null) {
            sql.SET("score_time = #{scoreTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, RepairRemarkExample example, boolean includeExamplePhrase) {
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