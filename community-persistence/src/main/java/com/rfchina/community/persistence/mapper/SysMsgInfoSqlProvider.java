package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.SysMsgInfo;
import com.rfchina.community.persistence.model.SysMsgInfoExample.Criteria;
import com.rfchina.community.persistence.model.SysMsgInfoExample.Criterion;
import com.rfchina.community.persistence.model.SysMsgInfoExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class SysMsgInfoSqlProvider {

    public String countByExample(SysMsgInfoExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("sys_msg_info");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(SysMsgInfoExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("sys_msg_info");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(SysMsgInfo record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("sys_msg_info");
        
        if (record.getContent() != null) {
            sql.VALUES("content", "#{content,jdbcType=VARCHAR}");
        }
        
        if (record.getObjectKey() != null) {
            sql.VALUES("object_key", "#{objectKey,jdbcType=VARCHAR}");
        }
        
        if (record.getObjectType() != null) {
            sql.VALUES("object_type", "#{objectType,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateCommunityId() != null) {
            sql.VALUES("create_community_id", "#{createCommunityId,jdbcType=INTEGER}");
        }
        
        if (record.getMsgSourceType() != null) {
            sql.VALUES("msg_source_type", "#{msgSourceType,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(SysMsgInfoExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("content");
        sql.SELECT("object_key");
        sql.SELECT("object_type");
        sql.SELECT("create_time");
        sql.SELECT("create_community_id");
        sql.SELECT("msg_source_type");
        sql.FROM("sys_msg_info");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        SysMsgInfo record = (SysMsgInfo) parameter.get("record");
        SysMsgInfoExample example = (SysMsgInfoExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("sys_msg_info");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getContent() != null) {
            sql.SET("content = #{record.content,jdbcType=VARCHAR}");
        }
        
        if (record.getObjectKey() != null) {
            sql.SET("object_key = #{record.objectKey,jdbcType=VARCHAR}");
        }
        
        if (record.getObjectType() != null) {
            sql.SET("object_type = #{record.objectType,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateCommunityId() != null) {
            sql.SET("create_community_id = #{record.createCommunityId,jdbcType=INTEGER}");
        }
        
        if (record.getMsgSourceType() != null) {
            sql.SET("msg_source_type = #{record.msgSourceType,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("sys_msg_info");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("content = #{record.content,jdbcType=VARCHAR}");
        sql.SET("object_key = #{record.objectKey,jdbcType=VARCHAR}");
        sql.SET("object_type = #{record.objectType,jdbcType=VARCHAR}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("create_community_id = #{record.createCommunityId,jdbcType=INTEGER}");
        sql.SET("msg_source_type = #{record.msgSourceType,jdbcType=VARCHAR}");
        
        SysMsgInfoExample example = (SysMsgInfoExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SysMsgInfo record) {
        SQL sql = new SQL();
        sql.UPDATE("sys_msg_info");
        
        if (record.getContent() != null) {
            sql.SET("content = #{content,jdbcType=VARCHAR}");
        }
        
        if (record.getObjectKey() != null) {
            sql.SET("object_key = #{objectKey,jdbcType=VARCHAR}");
        }
        
        if (record.getObjectType() != null) {
            sql.SET("object_type = #{objectType,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateCommunityId() != null) {
            sql.SET("create_community_id = #{createCommunityId,jdbcType=INTEGER}");
        }
        
        if (record.getMsgSourceType() != null) {
            sql.SET("msg_source_type = #{msgSourceType,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, SysMsgInfoExample example, boolean includeExamplePhrase) {
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