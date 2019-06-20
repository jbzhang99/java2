package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.SysOperLog;
import com.rfchina.community.persistence.model.SysOperLogExample.Criteria;
import com.rfchina.community.persistence.model.SysOperLogExample.Criterion;
import com.rfchina.community.persistence.model.SysOperLogExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class SysOperLogSqlProvider {

    public String countByExample(SysOperLogExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("sys_oper_log");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(SysOperLogExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("sys_oper_log");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(SysOperLog record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("sys_oper_log");
        
        if (record.getCommunityId() != null) {
            sql.VALUES("community_id", "#{communityId,jdbcType=INTEGER}");
        }
        
        if (record.getAppId() != null) {
            sql.VALUES("app_id", "#{appId,jdbcType=INTEGER}");
        }
        
        if (record.getOperId() != null) {
            sql.VALUES("oper_id", "#{operId,jdbcType=BIGINT}");
        }
        
        if (record.getOperName() != null) {
            sql.VALUES("oper_name", "#{operName,jdbcType=VARCHAR}");
        }
        
        if (record.getOperEvent() != null) {
            sql.VALUES("oper_event", "#{operEvent,jdbcType=VARCHAR}");
        }
        
        if (record.getOperContent() != null) {
            sql.VALUES("oper_content", "#{operContent,jdbcType=VARCHAR}");
        }
        
        if (record.getOperIp() != null) {
            sql.VALUES("oper_ip", "#{operIp,jdbcType=VARCHAR}");
        }
        
        if (record.getTargetId() != null) {
            sql.VALUES("target_id", "#{targetId,jdbcType=BIGINT}");
        }
        
        if (record.getTargetName() != null) {
            sql.VALUES("target_name", "#{targetName,jdbcType=VARCHAR}");
        }
        
        if (record.getTargetContent() != null) {
            sql.VALUES("target_content", "#{targetContent,jdbcType=VARCHAR}");
        }
        
        if (record.getOperLevel() != null) {
            sql.VALUES("oper_level", "#{operLevel,jdbcType=INTEGER}");
        }
        
        if (record.getOperType() != null) {
            sql.VALUES("oper_type", "#{operType,jdbcType=INTEGER}");
        }
        
        if (record.getOperTime() != null) {
            sql.VALUES("oper_time", "#{operTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(SysOperLogExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("community_id");
        sql.SELECT("app_id");
        sql.SELECT("oper_id");
        sql.SELECT("oper_name");
        sql.SELECT("oper_event");
        sql.SELECT("oper_content");
        sql.SELECT("oper_ip");
        sql.SELECT("target_id");
        sql.SELECT("target_name");
        sql.SELECT("target_content");
        sql.SELECT("oper_level");
        sql.SELECT("oper_type");
        sql.SELECT("oper_time");
        sql.FROM("sys_oper_log");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        SysOperLog record = (SysOperLog) parameter.get("record");
        SysOperLogExample example = (SysOperLogExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("sys_oper_log");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        }
        
        if (record.getAppId() != null) {
            sql.SET("app_id = #{record.appId,jdbcType=INTEGER}");
        }
        
        if (record.getOperId() != null) {
            sql.SET("oper_id = #{record.operId,jdbcType=BIGINT}");
        }
        
        if (record.getOperName() != null) {
            sql.SET("oper_name = #{record.operName,jdbcType=VARCHAR}");
        }
        
        if (record.getOperEvent() != null) {
            sql.SET("oper_event = #{record.operEvent,jdbcType=VARCHAR}");
        }
        
        if (record.getOperContent() != null) {
            sql.SET("oper_content = #{record.operContent,jdbcType=VARCHAR}");
        }
        
        if (record.getOperIp() != null) {
            sql.SET("oper_ip = #{record.operIp,jdbcType=VARCHAR}");
        }
        
        if (record.getTargetId() != null) {
            sql.SET("target_id = #{record.targetId,jdbcType=BIGINT}");
        }
        
        if (record.getTargetName() != null) {
            sql.SET("target_name = #{record.targetName,jdbcType=VARCHAR}");
        }
        
        if (record.getTargetContent() != null) {
            sql.SET("target_content = #{record.targetContent,jdbcType=VARCHAR}");
        }
        
        if (record.getOperLevel() != null) {
            sql.SET("oper_level = #{record.operLevel,jdbcType=INTEGER}");
        }
        
        if (record.getOperType() != null) {
            sql.SET("oper_type = #{record.operType,jdbcType=INTEGER}");
        }
        
        if (record.getOperTime() != null) {
            sql.SET("oper_time = #{record.operTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("sys_oper_log");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        sql.SET("app_id = #{record.appId,jdbcType=INTEGER}");
        sql.SET("oper_id = #{record.operId,jdbcType=BIGINT}");
        sql.SET("oper_name = #{record.operName,jdbcType=VARCHAR}");
        sql.SET("oper_event = #{record.operEvent,jdbcType=VARCHAR}");
        sql.SET("oper_content = #{record.operContent,jdbcType=VARCHAR}");
        sql.SET("oper_ip = #{record.operIp,jdbcType=VARCHAR}");
        sql.SET("target_id = #{record.targetId,jdbcType=BIGINT}");
        sql.SET("target_name = #{record.targetName,jdbcType=VARCHAR}");
        sql.SET("target_content = #{record.targetContent,jdbcType=VARCHAR}");
        sql.SET("oper_level = #{record.operLevel,jdbcType=INTEGER}");
        sql.SET("oper_type = #{record.operType,jdbcType=INTEGER}");
        sql.SET("oper_time = #{record.operTime,jdbcType=TIMESTAMP}");
        
        SysOperLogExample example = (SysOperLogExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SysOperLog record) {
        SQL sql = new SQL();
        sql.UPDATE("sys_oper_log");
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{communityId,jdbcType=INTEGER}");
        }
        
        if (record.getAppId() != null) {
            sql.SET("app_id = #{appId,jdbcType=INTEGER}");
        }
        
        if (record.getOperId() != null) {
            sql.SET("oper_id = #{operId,jdbcType=BIGINT}");
        }
        
        if (record.getOperName() != null) {
            sql.SET("oper_name = #{operName,jdbcType=VARCHAR}");
        }
        
        if (record.getOperEvent() != null) {
            sql.SET("oper_event = #{operEvent,jdbcType=VARCHAR}");
        }
        
        if (record.getOperContent() != null) {
            sql.SET("oper_content = #{operContent,jdbcType=VARCHAR}");
        }
        
        if (record.getOperIp() != null) {
            sql.SET("oper_ip = #{operIp,jdbcType=VARCHAR}");
        }
        
        if (record.getTargetId() != null) {
            sql.SET("target_id = #{targetId,jdbcType=BIGINT}");
        }
        
        if (record.getTargetName() != null) {
            sql.SET("target_name = #{targetName,jdbcType=VARCHAR}");
        }
        
        if (record.getTargetContent() != null) {
            sql.SET("target_content = #{targetContent,jdbcType=VARCHAR}");
        }
        
        if (record.getOperLevel() != null) {
            sql.SET("oper_level = #{operLevel,jdbcType=INTEGER}");
        }
        
        if (record.getOperType() != null) {
            sql.SET("oper_type = #{operType,jdbcType=INTEGER}");
        }
        
        if (record.getOperTime() != null) {
            sql.SET("oper_time = #{operTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, SysOperLogExample example, boolean includeExamplePhrase) {
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