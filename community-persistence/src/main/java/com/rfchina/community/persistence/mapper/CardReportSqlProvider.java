package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CardReport;
import com.rfchina.community.persistence.model.CardReportExample.Criteria;
import com.rfchina.community.persistence.model.CardReportExample.Criterion;
import com.rfchina.community.persistence.model.CardReportExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class CardReportSqlProvider {

    public String countByExample(CardReportExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("card_report");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(CardReportExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("card_report");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(CardReport record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("card_report");
        
        if (record.getCardId() != null) {
            sql.VALUES("card_id", "#{cardId,jdbcType=BIGINT}");
        }
        
        if (record.getCategoryId() != null) {
            sql.VALUES("category_id", "#{categoryId,jdbcType=INTEGER}");
        }
        
        if (record.getCommunityId() != null) {
            sql.VALUES("community_id", "#{communityId,jdbcType=INTEGER}");
        }
        
        if (record.getRuid() != null) {
            sql.VALUES("ruid", "#{ruid,jdbcType=BIGINT}");
        }
        
        if (record.getRfullname() != null) {
            sql.VALUES("rfullname", "#{rfullname,jdbcType=VARCHAR}");
        }
        
        if (record.getRphone() != null) {
            sql.VALUES("rphone", "#{rphone,jdbcType=VARCHAR}");
        }
        
        if (record.getSuid() != null) {
            sql.VALUES("suid", "#{suid,jdbcType=BIGINT}");
        }
        
        if (record.getStype() != null) {
            sql.VALUES("stype", "#{stype,jdbcType=INTEGER}");
        }
        
        if (record.getSfullname() != null) {
            sql.VALUES("sfullname", "#{sfullname,jdbcType=VARCHAR}");
        }
        
        if (record.getSphone() != null) {
            sql.VALUES("sphone", "#{sphone,jdbcType=VARCHAR}");
        }
        
        if (record.getContent() != null) {
            sql.VALUES("content", "#{content,jdbcType=VARCHAR}");
        }
        
        if (record.getCardContent() != null) {
            sql.VALUES("card_content", "#{cardContent,jdbcType=VARCHAR}");
        }
        
        if (record.getCardAttachment() != null) {
            sql.VALUES("card_attachment", "#{cardAttachment,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(CardReportExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("card_id");
        sql.SELECT("category_id");
        sql.SELECT("community_id");
        sql.SELECT("ruid");
        sql.SELECT("rfullname");
        sql.SELECT("rphone");
        sql.SELECT("suid");
        sql.SELECT("stype");
        sql.SELECT("sfullname");
        sql.SELECT("sphone");
        sql.SELECT("content");
        sql.SELECT("card_content");
        sql.SELECT("card_attachment");
        sql.SELECT("status");
        sql.SELECT("create_time");
        sql.FROM("card_report");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        CardReport record = (CardReport) parameter.get("record");
        CardReportExample example = (CardReportExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("card_report");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getCardId() != null) {
            sql.SET("card_id = #{record.cardId,jdbcType=BIGINT}");
        }
        
        if (record.getCategoryId() != null) {
            sql.SET("category_id = #{record.categoryId,jdbcType=INTEGER}");
        }
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        }
        
        if (record.getRuid() != null) {
            sql.SET("ruid = #{record.ruid,jdbcType=BIGINT}");
        }
        
        if (record.getRfullname() != null) {
            sql.SET("rfullname = #{record.rfullname,jdbcType=VARCHAR}");
        }
        
        if (record.getRphone() != null) {
            sql.SET("rphone = #{record.rphone,jdbcType=VARCHAR}");
        }
        
        if (record.getSuid() != null) {
            sql.SET("suid = #{record.suid,jdbcType=BIGINT}");
        }
        
        if (record.getStype() != null) {
            sql.SET("stype = #{record.stype,jdbcType=INTEGER}");
        }
        
        if (record.getSfullname() != null) {
            sql.SET("sfullname = #{record.sfullname,jdbcType=VARCHAR}");
        }
        
        if (record.getSphone() != null) {
            sql.SET("sphone = #{record.sphone,jdbcType=VARCHAR}");
        }
        
        if (record.getContent() != null) {
            sql.SET("content = #{record.content,jdbcType=VARCHAR}");
        }
        
        if (record.getCardContent() != null) {
            sql.SET("card_content = #{record.cardContent,jdbcType=VARCHAR}");
        }
        
        if (record.getCardAttachment() != null) {
            sql.SET("card_attachment = #{record.cardAttachment,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("card_report");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("card_id = #{record.cardId,jdbcType=BIGINT}");
        sql.SET("category_id = #{record.categoryId,jdbcType=INTEGER}");
        sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        sql.SET("ruid = #{record.ruid,jdbcType=BIGINT}");
        sql.SET("rfullname = #{record.rfullname,jdbcType=VARCHAR}");
        sql.SET("rphone = #{record.rphone,jdbcType=VARCHAR}");
        sql.SET("suid = #{record.suid,jdbcType=BIGINT}");
        sql.SET("stype = #{record.stype,jdbcType=INTEGER}");
        sql.SET("sfullname = #{record.sfullname,jdbcType=VARCHAR}");
        sql.SET("sphone = #{record.sphone,jdbcType=VARCHAR}");
        sql.SET("content = #{record.content,jdbcType=VARCHAR}");
        sql.SET("card_content = #{record.cardContent,jdbcType=VARCHAR}");
        sql.SET("card_attachment = #{record.cardAttachment,jdbcType=VARCHAR}");
        sql.SET("status = #{record.status,jdbcType=INTEGER}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        
        CardReportExample example = (CardReportExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(CardReport record) {
        SQL sql = new SQL();
        sql.UPDATE("card_report");
        
        if (record.getCardId() != null) {
            sql.SET("card_id = #{cardId,jdbcType=BIGINT}");
        }
        
        if (record.getCategoryId() != null) {
            sql.SET("category_id = #{categoryId,jdbcType=INTEGER}");
        }
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{communityId,jdbcType=INTEGER}");
        }
        
        if (record.getRuid() != null) {
            sql.SET("ruid = #{ruid,jdbcType=BIGINT}");
        }
        
        if (record.getRfullname() != null) {
            sql.SET("rfullname = #{rfullname,jdbcType=VARCHAR}");
        }
        
        if (record.getRphone() != null) {
            sql.SET("rphone = #{rphone,jdbcType=VARCHAR}");
        }
        
        if (record.getSuid() != null) {
            sql.SET("suid = #{suid,jdbcType=BIGINT}");
        }
        
        if (record.getStype() != null) {
            sql.SET("stype = #{stype,jdbcType=INTEGER}");
        }
        
        if (record.getSfullname() != null) {
            sql.SET("sfullname = #{sfullname,jdbcType=VARCHAR}");
        }
        
        if (record.getSphone() != null) {
            sql.SET("sphone = #{sphone,jdbcType=VARCHAR}");
        }
        
        if (record.getContent() != null) {
            sql.SET("content = #{content,jdbcType=VARCHAR}");
        }
        
        if (record.getCardContent() != null) {
            sql.SET("card_content = #{cardContent,jdbcType=VARCHAR}");
        }
        
        if (record.getCardAttachment() != null) {
            sql.SET("card_attachment = #{cardAttachment,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, CardReportExample example, boolean includeExamplePhrase) {
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