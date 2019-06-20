package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.IfaceLog;
import com.rfchina.community.persistence.model.IfaceLogExample.Criteria;
import com.rfchina.community.persistence.model.IfaceLogExample.Criterion;
import com.rfchina.community.persistence.model.IfaceLogExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class IfaceLogSqlProvider {

    public String countByExample(IfaceLogExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("iface_log");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(IfaceLogExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("iface_log");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(IfaceLog record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("iface_log");
        
        if (record.getTargetUrl() != null) {
            sql.VALUES("target_url", "#{targetUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getReqBody() != null) {
            sql.VALUES("req_body", "#{reqBody,jdbcType=VARCHAR}");
        }
        
        if (record.getRspBody() != null) {
            sql.VALUES("rsp_body", "#{rspBody,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(IfaceLogExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("target_url");
        sql.SELECT("req_body");
        sql.SELECT("rsp_body");
        sql.SELECT("create_time");
        sql.FROM("iface_log");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        IfaceLog record = (IfaceLog) parameter.get("record");
        IfaceLogExample example = (IfaceLogExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("iface_log");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getTargetUrl() != null) {
            sql.SET("target_url = #{record.targetUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getReqBody() != null) {
            sql.SET("req_body = #{record.reqBody,jdbcType=VARCHAR}");
        }
        
        if (record.getRspBody() != null) {
            sql.SET("rsp_body = #{record.rspBody,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("iface_log");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("target_url = #{record.targetUrl,jdbcType=VARCHAR}");
        sql.SET("req_body = #{record.reqBody,jdbcType=VARCHAR}");
        sql.SET("rsp_body = #{record.rspBody,jdbcType=VARCHAR}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        
        IfaceLogExample example = (IfaceLogExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(IfaceLog record) {
        SQL sql = new SQL();
        sql.UPDATE("iface_log");
        
        if (record.getTargetUrl() != null) {
            sql.SET("target_url = #{targetUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getReqBody() != null) {
            sql.SET("req_body = #{reqBody,jdbcType=VARCHAR}");
        }
        
        if (record.getRspBody() != null) {
            sql.SET("rsp_body = #{rspBody,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, IfaceLogExample example, boolean includeExamplePhrase) {
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