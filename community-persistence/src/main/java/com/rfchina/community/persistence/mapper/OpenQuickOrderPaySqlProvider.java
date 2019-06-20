package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenQuickOrderPay;
import com.rfchina.community.persistence.model.OpenQuickOrderPayExample.Criteria;
import com.rfchina.community.persistence.model.OpenQuickOrderPayExample.Criterion;
import com.rfchina.community.persistence.model.OpenQuickOrderPayExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class OpenQuickOrderPaySqlProvider {

    public String countByExample(OpenQuickOrderPayExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("open_quick_order_pay");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(OpenQuickOrderPayExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("open_quick_order_pay");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(OpenQuickOrderPay record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("open_quick_order_pay");
        
        if (record.getOutTradeNo() != null) {
            sql.VALUES("out_trade_no", "#{outTradeNo,jdbcType=VARCHAR}");
        }
        
        if (record.getQuickId() != null) {
            sql.VALUES("quick_id", "#{quickId,jdbcType=BIGINT}");
        }
        
        if (record.getCommunityTradeNo() != null) {
            sql.VALUES("community_trade_no", "#{communityTradeNo,jdbcType=VARCHAR}");
        }
        
        if (record.getBillId() != null) {
            sql.VALUES("bill_id", "#{billId,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getPayChannel() != null) {
            sql.VALUES("pay_channel", "#{payChannel,jdbcType=VARCHAR}");
        }
        
        if (record.getTradeType() != null) {
            sql.VALUES("trade_type", "#{tradeType,jdbcType=VARCHAR}");
        }
        
        if (record.getSuccessTime() != null) {
            sql.VALUES("success_time", "#{successTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(OpenQuickOrderPayExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("out_trade_no");
        } else {
            sql.SELECT("out_trade_no");
        }
        sql.SELECT("quick_id");
        sql.SELECT("community_trade_no");
        sql.SELECT("bill_id");
        sql.SELECT("create_time");
        sql.SELECT("status");
        sql.SELECT("pay_channel");
        sql.SELECT("trade_type");
        sql.SELECT("success_time");
        sql.FROM("open_quick_order_pay");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        OpenQuickOrderPay record = (OpenQuickOrderPay) parameter.get("record");
        OpenQuickOrderPayExample example = (OpenQuickOrderPayExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("open_quick_order_pay");
        
        if (record.getOutTradeNo() != null) {
            sql.SET("out_trade_no = #{record.outTradeNo,jdbcType=VARCHAR}");
        }
        
        if (record.getQuickId() != null) {
            sql.SET("quick_id = #{record.quickId,jdbcType=BIGINT}");
        }
        
        if (record.getCommunityTradeNo() != null) {
            sql.SET("community_trade_no = #{record.communityTradeNo,jdbcType=VARCHAR}");
        }
        
        if (record.getBillId() != null) {
            sql.SET("bill_id = #{record.billId,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=INTEGER}");
        }
        
        if (record.getPayChannel() != null) {
            sql.SET("pay_channel = #{record.payChannel,jdbcType=VARCHAR}");
        }
        
        if (record.getTradeType() != null) {
            sql.SET("trade_type = #{record.tradeType,jdbcType=VARCHAR}");
        }
        
        if (record.getSuccessTime() != null) {
            sql.SET("success_time = #{record.successTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("open_quick_order_pay");
        
        sql.SET("out_trade_no = #{record.outTradeNo,jdbcType=VARCHAR}");
        sql.SET("quick_id = #{record.quickId,jdbcType=BIGINT}");
        sql.SET("community_trade_no = #{record.communityTradeNo,jdbcType=VARCHAR}");
        sql.SET("bill_id = #{record.billId,jdbcType=VARCHAR}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("status = #{record.status,jdbcType=INTEGER}");
        sql.SET("pay_channel = #{record.payChannel,jdbcType=VARCHAR}");
        sql.SET("trade_type = #{record.tradeType,jdbcType=VARCHAR}");
        sql.SET("success_time = #{record.successTime,jdbcType=TIMESTAMP}");
        
        OpenQuickOrderPayExample example = (OpenQuickOrderPayExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(OpenQuickOrderPay record) {
        SQL sql = new SQL();
        sql.UPDATE("open_quick_order_pay");
        
        if (record.getQuickId() != null) {
            sql.SET("quick_id = #{quickId,jdbcType=BIGINT}");
        }
        
        if (record.getCommunityTradeNo() != null) {
            sql.SET("community_trade_no = #{communityTradeNo,jdbcType=VARCHAR}");
        }
        
        if (record.getBillId() != null) {
            sql.SET("bill_id = #{billId,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getPayChannel() != null) {
            sql.SET("pay_channel = #{payChannel,jdbcType=VARCHAR}");
        }
        
        if (record.getTradeType() != null) {
            sql.SET("trade_type = #{tradeType,jdbcType=VARCHAR}");
        }
        
        if (record.getSuccessTime() != null) {
            sql.SET("success_time = #{successTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("out_trade_no = #{outTradeNo,jdbcType=VARCHAR}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, OpenQuickOrderPayExample example, boolean includeExamplePhrase) {
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