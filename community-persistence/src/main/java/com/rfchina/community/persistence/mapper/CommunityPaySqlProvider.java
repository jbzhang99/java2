package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CommunityPay;
import com.rfchina.community.persistence.model.CommunityPayExample.Criteria;
import com.rfchina.community.persistence.model.CommunityPayExample.Criterion;
import com.rfchina.community.persistence.model.CommunityPayExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class CommunityPaySqlProvider {

    public String countByExample(CommunityPayExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("community_pay");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(CommunityPayExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("community_pay");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(CommunityPay record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("community_pay");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getPayAccount() != null) {
            sql.VALUES("pay_account", "#{payAccount,jdbcType=VARCHAR}");
        }
        
        if (record.getMerchantId() != null) {
            sql.VALUES("merchant_id", "#{merchantId,jdbcType=VARCHAR}");
        }
        
        if (record.getOpenPayAccount() != null) {
            sql.VALUES("open_pay_account", "#{openPayAccount,jdbcType=VARCHAR}");
        }
        
        if (record.getOpenMerchantId() != null) {
            sql.VALUES("open_merchant_id", "#{openMerchantId,jdbcType=VARCHAR}");
        }
        
        if (record.getFeeRate() != null) {
            sql.VALUES("fee_rate", "#{feeRate,jdbcType=DECIMAL}");
        }
        
        return sql.toString();
    }

    public String selectByExample(CommunityPayExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("pay_account");
        sql.SELECT("merchant_id");
        sql.SELECT("open_pay_account");
        sql.SELECT("open_merchant_id");
        sql.SELECT("fee_rate");
        sql.FROM("community_pay");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        CommunityPay record = (CommunityPay) parameter.get("record");
        CommunityPayExample example = (CommunityPayExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("community_pay");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getPayAccount() != null) {
            sql.SET("pay_account = #{record.payAccount,jdbcType=VARCHAR}");
        }
        
        if (record.getMerchantId() != null) {
            sql.SET("merchant_id = #{record.merchantId,jdbcType=VARCHAR}");
        }
        
        if (record.getOpenPayAccount() != null) {
            sql.SET("open_pay_account = #{record.openPayAccount,jdbcType=VARCHAR}");
        }
        
        if (record.getOpenMerchantId() != null) {
            sql.SET("open_merchant_id = #{record.openMerchantId,jdbcType=VARCHAR}");
        }
        
        if (record.getFeeRate() != null) {
            sql.SET("fee_rate = #{record.feeRate,jdbcType=DECIMAL}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("community_pay");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("pay_account = #{record.payAccount,jdbcType=VARCHAR}");
        sql.SET("merchant_id = #{record.merchantId,jdbcType=VARCHAR}");
        sql.SET("open_pay_account = #{record.openPayAccount,jdbcType=VARCHAR}");
        sql.SET("open_merchant_id = #{record.openMerchantId,jdbcType=VARCHAR}");
        sql.SET("fee_rate = #{record.feeRate,jdbcType=DECIMAL}");
        
        CommunityPayExample example = (CommunityPayExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(CommunityPay record) {
        SQL sql = new SQL();
        sql.UPDATE("community_pay");
        
        if (record.getPayAccount() != null) {
            sql.SET("pay_account = #{payAccount,jdbcType=VARCHAR}");
        }
        
        if (record.getMerchantId() != null) {
            sql.SET("merchant_id = #{merchantId,jdbcType=VARCHAR}");
        }
        
        if (record.getOpenPayAccount() != null) {
            sql.SET("open_pay_account = #{openPayAccount,jdbcType=VARCHAR}");
        }
        
        if (record.getOpenMerchantId() != null) {
            sql.SET("open_merchant_id = #{openMerchantId,jdbcType=VARCHAR}");
        }
        
        if (record.getFeeRate() != null) {
            sql.SET("fee_rate = #{feeRate,jdbcType=DECIMAL}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, CommunityPayExample example, boolean includeExamplePhrase) {
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