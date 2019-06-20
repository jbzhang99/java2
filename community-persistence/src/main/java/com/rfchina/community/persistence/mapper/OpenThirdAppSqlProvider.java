package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenThirdApp;
import com.rfchina.community.persistence.model.OpenThirdAppExample.Criteria;
import com.rfchina.community.persistence.model.OpenThirdAppExample.Criterion;
import com.rfchina.community.persistence.model.OpenThirdAppExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class OpenThirdAppSqlProvider {

    public String countByExample(OpenThirdAppExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("open_third_app");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(OpenThirdAppExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("open_third_app");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(OpenThirdApp record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("open_third_app");
        
        if (record.getAppId() != null) {
            sql.VALUES("app_id", "#{appId,jdbcType=BIGINT}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getUrl() != null) {
            sql.VALUES("url", "#{url,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            sql.VALUES("description", "#{description,jdbcType=VARCHAR}");
        }
        
        if (record.getIcon() != null) {
            sql.VALUES("icon", "#{icon,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getAuditComment() != null) {
            sql.VALUES("audit_comment", "#{auditComment,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAuditTime() != null) {
            sql.VALUES("audit_time", "#{auditTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCategoryId() != null) {
            sql.VALUES("category_id", "#{categoryId,jdbcType=BIGINT}");
        }
        
        if (record.getIsNeedHardware() != null) {
            sql.VALUES("is_need_hardware", "#{isNeedHardware,jdbcType=INTEGER}");
        }
        
        if (record.getTargetMonthTurnover() != null) {
            sql.VALUES("target_month_turnover", "#{targetMonthTurnover,jdbcType=DECIMAL}");
        }
        
        if (record.getPaidCautionMoney() != null) {
            sql.VALUES("paid_caution_money", "#{paidCautionMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getCautionMoneyStatus() != null) {
            sql.VALUES("caution_money_status", "#{cautionMoneyStatus,jdbcType=INTEGER}");
        }
        
        if (record.getGroundMode() != null) {
            sql.VALUES("ground_mode", "#{groundMode,jdbcType=INTEGER}");
        }
        
        if (record.getMerchantId() != null) {
            sql.VALUES("merchant_id", "#{merchantId,jdbcType=BIGINT}");
        }
        
        if (record.getAccountId() != null) {
            sql.VALUES("account_id", "#{accountId,jdbcType=VARCHAR}");
        }
        
        if (record.getSubmitAuditTime() != null) {
            sql.VALUES("submit_audit_time", "#{submitAuditTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(OpenThirdAppExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("app_id");
        } else {
            sql.SELECT("app_id");
        }
        sql.SELECT("name");
        sql.SELECT("url");
        sql.SELECT("description");
        sql.SELECT("icon");
        sql.SELECT("status");
        sql.SELECT("audit_comment");
        sql.SELECT("create_time");
        sql.SELECT("update_time");
        sql.SELECT("audit_time");
        sql.SELECT("category_id");
        sql.SELECT("is_need_hardware");
        sql.SELECT("target_month_turnover");
        sql.SELECT("paid_caution_money");
        sql.SELECT("caution_money_status");
        sql.SELECT("ground_mode");
        sql.SELECT("merchant_id");
        sql.SELECT("account_id");
        sql.SELECT("submit_audit_time");
        sql.FROM("open_third_app");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        OpenThirdApp record = (OpenThirdApp) parameter.get("record");
        OpenThirdAppExample example = (OpenThirdAppExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("open_third_app");
        
        if (record.getAppId() != null) {
            sql.SET("app_id = #{record.appId,jdbcType=BIGINT}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        }
        
        if (record.getUrl() != null) {
            sql.SET("url = #{record.url,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            sql.SET("description = #{record.description,jdbcType=VARCHAR}");
        }
        
        if (record.getIcon() != null) {
            sql.SET("icon = #{record.icon,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=INTEGER}");
        }
        
        if (record.getAuditComment() != null) {
            sql.SET("audit_comment = #{record.auditComment,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAuditTime() != null) {
            sql.SET("audit_time = #{record.auditTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCategoryId() != null) {
            sql.SET("category_id = #{record.categoryId,jdbcType=BIGINT}");
        }
        
        if (record.getIsNeedHardware() != null) {
            sql.SET("is_need_hardware = #{record.isNeedHardware,jdbcType=INTEGER}");
        }
        
        if (record.getTargetMonthTurnover() != null) {
            sql.SET("target_month_turnover = #{record.targetMonthTurnover,jdbcType=DECIMAL}");
        }
        
        if (record.getPaidCautionMoney() != null) {
            sql.SET("paid_caution_money = #{record.paidCautionMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getCautionMoneyStatus() != null) {
            sql.SET("caution_money_status = #{record.cautionMoneyStatus,jdbcType=INTEGER}");
        }
        
        if (record.getGroundMode() != null) {
            sql.SET("ground_mode = #{record.groundMode,jdbcType=INTEGER}");
        }
        
        if (record.getMerchantId() != null) {
            sql.SET("merchant_id = #{record.merchantId,jdbcType=BIGINT}");
        }
        
        if (record.getAccountId() != null) {
            sql.SET("account_id = #{record.accountId,jdbcType=VARCHAR}");
        }
        
        if (record.getSubmitAuditTime() != null) {
            sql.SET("submit_audit_time = #{record.submitAuditTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("open_third_app");
        
        sql.SET("app_id = #{record.appId,jdbcType=BIGINT}");
        sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        sql.SET("url = #{record.url,jdbcType=VARCHAR}");
        sql.SET("description = #{record.description,jdbcType=VARCHAR}");
        sql.SET("icon = #{record.icon,jdbcType=VARCHAR}");
        sql.SET("status = #{record.status,jdbcType=INTEGER}");
        sql.SET("audit_comment = #{record.auditComment,jdbcType=VARCHAR}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        sql.SET("audit_time = #{record.auditTime,jdbcType=TIMESTAMP}");
        sql.SET("category_id = #{record.categoryId,jdbcType=BIGINT}");
        sql.SET("is_need_hardware = #{record.isNeedHardware,jdbcType=INTEGER}");
        sql.SET("target_month_turnover = #{record.targetMonthTurnover,jdbcType=DECIMAL}");
        sql.SET("paid_caution_money = #{record.paidCautionMoney,jdbcType=DECIMAL}");
        sql.SET("caution_money_status = #{record.cautionMoneyStatus,jdbcType=INTEGER}");
        sql.SET("ground_mode = #{record.groundMode,jdbcType=INTEGER}");
        sql.SET("merchant_id = #{record.merchantId,jdbcType=BIGINT}");
        sql.SET("account_id = #{record.accountId,jdbcType=VARCHAR}");
        sql.SET("submit_audit_time = #{record.submitAuditTime,jdbcType=TIMESTAMP}");
        
        OpenThirdAppExample example = (OpenThirdAppExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(OpenThirdApp record) {
        SQL sql = new SQL();
        sql.UPDATE("open_third_app");
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getUrl() != null) {
            sql.SET("url = #{url,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            sql.SET("description = #{description,jdbcType=VARCHAR}");
        }
        
        if (record.getIcon() != null) {
            sql.SET("icon = #{icon,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getAuditComment() != null) {
            sql.SET("audit_comment = #{auditComment,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAuditTime() != null) {
            sql.SET("audit_time = #{auditTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCategoryId() != null) {
            sql.SET("category_id = #{categoryId,jdbcType=BIGINT}");
        }
        
        if (record.getIsNeedHardware() != null) {
            sql.SET("is_need_hardware = #{isNeedHardware,jdbcType=INTEGER}");
        }
        
        if (record.getTargetMonthTurnover() != null) {
            sql.SET("target_month_turnover = #{targetMonthTurnover,jdbcType=DECIMAL}");
        }
        
        if (record.getPaidCautionMoney() != null) {
            sql.SET("paid_caution_money = #{paidCautionMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getCautionMoneyStatus() != null) {
            sql.SET("caution_money_status = #{cautionMoneyStatus,jdbcType=INTEGER}");
        }
        
        if (record.getGroundMode() != null) {
            sql.SET("ground_mode = #{groundMode,jdbcType=INTEGER}");
        }
        
        if (record.getMerchantId() != null) {
            sql.SET("merchant_id = #{merchantId,jdbcType=BIGINT}");
        }
        
        if (record.getAccountId() != null) {
            sql.SET("account_id = #{accountId,jdbcType=VARCHAR}");
        }
        
        if (record.getSubmitAuditTime() != null) {
            sql.SET("submit_audit_time = #{submitAuditTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("app_id = #{appId,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, OpenThirdAppExample example, boolean includeExamplePhrase) {
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