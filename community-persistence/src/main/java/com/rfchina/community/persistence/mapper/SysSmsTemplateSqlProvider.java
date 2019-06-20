package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.SysSmsTemplate;
import com.rfchina.community.persistence.model.SysSmsTemplateExample.Criteria;
import com.rfchina.community.persistence.model.SysSmsTemplateExample.Criterion;
import com.rfchina.community.persistence.model.SysSmsTemplateExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class SysSmsTemplateSqlProvider {

    public String countByExample(SysSmsTemplateExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("sys_sms_template");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(SysSmsTemplateExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("sys_sms_template");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(SysSmsTemplate record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("sys_sms_template");
        
        if (record.getSmsType() != null) {
            sql.VALUES("sms_type", "#{smsType,jdbcType=VARCHAR}");
        }
        
        if (record.getSmsTemp() != null) {
            sql.VALUES("sms_temp", "#{smsTemp,jdbcType=VARCHAR}");
        }
        
        if (record.getAppid() != null) {
            sql.VALUES("appid", "#{appid,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String selectByExample(SysSmsTemplateExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("sms_type");
        } else {
            sql.SELECT("sms_type");
        }
        sql.SELECT("sms_temp");
        sql.SELECT("appid");
        sql.FROM("sys_sms_template");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        SysSmsTemplate record = (SysSmsTemplate) parameter.get("record");
        SysSmsTemplateExample example = (SysSmsTemplateExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("sys_sms_template");
        
        if (record.getSmsType() != null) {
            sql.SET("sms_type = #{record.smsType,jdbcType=VARCHAR}");
        }
        
        if (record.getSmsTemp() != null) {
            sql.SET("sms_temp = #{record.smsTemp,jdbcType=VARCHAR}");
        }
        
        if (record.getAppid() != null) {
            sql.SET("appid = #{record.appid,jdbcType=INTEGER}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("sys_sms_template");
        
        sql.SET("sms_type = #{record.smsType,jdbcType=VARCHAR}");
        sql.SET("sms_temp = #{record.smsTemp,jdbcType=VARCHAR}");
        sql.SET("appid = #{record.appid,jdbcType=INTEGER}");
        
        SysSmsTemplateExample example = (SysSmsTemplateExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SysSmsTemplate record) {
        SQL sql = new SQL();
        sql.UPDATE("sys_sms_template");
        
        if (record.getSmsTemp() != null) {
            sql.SET("sms_temp = #{smsTemp,jdbcType=VARCHAR}");
        }
        
        if (record.getAppid() != null) {
            sql.SET("appid = #{appid,jdbcType=INTEGER}");
        }
        
        sql.WHERE("sms_type = #{smsType,jdbcType=VARCHAR}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, SysSmsTemplateExample example, boolean includeExamplePhrase) {
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