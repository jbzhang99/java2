package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenQuickOrder;
import com.rfchina.community.persistence.model.OpenQuickOrderExample.Criteria;
import com.rfchina.community.persistence.model.OpenQuickOrderExample.Criterion;
import com.rfchina.community.persistence.model.OpenQuickOrderExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class OpenQuickOrderSqlProvider {

    public String countByExample(OpenQuickOrderExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("open_quick_order");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(OpenQuickOrderExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("open_quick_order");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(OpenQuickOrder record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("open_quick_order");
        
        if (record.getUid() != null) {
            sql.VALUES("uid", "#{uid,jdbcType=BIGINT}");
        }
        
        if (record.getCommunityId() != null) {
            sql.VALUES("community_id", "#{communityId,jdbcType=INTEGER}");
        }
        
        if (record.getServiceId() != null) {
            sql.VALUES("service_id", "#{serviceId,jdbcType=INTEGER}");
        }
        
        if (record.getTotalMoney() != null) {
            sql.VALUES("total_money", "#{totalMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getSubtractMoney() != null) {
            sql.VALUES("subtract_money", "#{subtractMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getCouponMoney() != null) {
            sql.VALUES("coupon_money", "#{couponMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getRealMoney() != null) {
            sql.VALUES("real_money", "#{realMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getCouponId() != null) {
            sql.VALUES("coupon_id", "#{couponId,jdbcType=BIGINT}");
        }
        
        if (record.getBillStatus() != null) {
            sql.VALUES("bill_status", "#{billStatus,jdbcType=INTEGER}");
        }
        
        if (record.getOutTradeNo() != null) {
            sql.VALUES("out_trade_no", "#{outTradeNo,jdbcType=VARCHAR}");
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
        
        if (record.getPayTime() != null) {
            sql.VALUES("pay_time", "#{payTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(OpenQuickOrderExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("uid");
        sql.SELECT("community_id");
        sql.SELECT("service_id");
        sql.SELECT("total_money");
        sql.SELECT("subtract_money");
        sql.SELECT("coupon_money");
        sql.SELECT("real_money");
        sql.SELECT("coupon_id");
        sql.SELECT("bill_status");
        sql.SELECT("out_trade_no");
        sql.SELECT("community_trade_no");
        sql.SELECT("bill_id");
        sql.SELECT("create_time");
        sql.SELECT("pay_time");
        sql.FROM("open_quick_order");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        OpenQuickOrder record = (OpenQuickOrder) parameter.get("record");
        OpenQuickOrderExample example = (OpenQuickOrderExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("open_quick_order");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getUid() != null) {
            sql.SET("uid = #{record.uid,jdbcType=BIGINT}");
        }
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        }
        
        if (record.getServiceId() != null) {
            sql.SET("service_id = #{record.serviceId,jdbcType=INTEGER}");
        }
        
        if (record.getTotalMoney() != null) {
            sql.SET("total_money = #{record.totalMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getSubtractMoney() != null) {
            sql.SET("subtract_money = #{record.subtractMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getCouponMoney() != null) {
            sql.SET("coupon_money = #{record.couponMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getRealMoney() != null) {
            sql.SET("real_money = #{record.realMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getCouponId() != null) {
            sql.SET("coupon_id = #{record.couponId,jdbcType=BIGINT}");
        }
        
        if (record.getBillStatus() != null) {
            sql.SET("bill_status = #{record.billStatus,jdbcType=INTEGER}");
        }
        
        if (record.getOutTradeNo() != null) {
            sql.SET("out_trade_no = #{record.outTradeNo,jdbcType=VARCHAR}");
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
        
        if (record.getPayTime() != null) {
            sql.SET("pay_time = #{record.payTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("open_quick_order");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("uid = #{record.uid,jdbcType=BIGINT}");
        sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        sql.SET("service_id = #{record.serviceId,jdbcType=INTEGER}");
        sql.SET("total_money = #{record.totalMoney,jdbcType=DECIMAL}");
        sql.SET("subtract_money = #{record.subtractMoney,jdbcType=DECIMAL}");
        sql.SET("coupon_money = #{record.couponMoney,jdbcType=DECIMAL}");
        sql.SET("real_money = #{record.realMoney,jdbcType=DECIMAL}");
        sql.SET("coupon_id = #{record.couponId,jdbcType=BIGINT}");
        sql.SET("bill_status = #{record.billStatus,jdbcType=INTEGER}");
        sql.SET("out_trade_no = #{record.outTradeNo,jdbcType=VARCHAR}");
        sql.SET("community_trade_no = #{record.communityTradeNo,jdbcType=VARCHAR}");
        sql.SET("bill_id = #{record.billId,jdbcType=VARCHAR}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("pay_time = #{record.payTime,jdbcType=TIMESTAMP}");
        
        OpenQuickOrderExample example = (OpenQuickOrderExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(OpenQuickOrder record) {
        SQL sql = new SQL();
        sql.UPDATE("open_quick_order");
        
        if (record.getUid() != null) {
            sql.SET("uid = #{uid,jdbcType=BIGINT}");
        }
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{communityId,jdbcType=INTEGER}");
        }
        
        if (record.getServiceId() != null) {
            sql.SET("service_id = #{serviceId,jdbcType=INTEGER}");
        }
        
        if (record.getTotalMoney() != null) {
            sql.SET("total_money = #{totalMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getSubtractMoney() != null) {
            sql.SET("subtract_money = #{subtractMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getCouponMoney() != null) {
            sql.SET("coupon_money = #{couponMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getRealMoney() != null) {
            sql.SET("real_money = #{realMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getCouponId() != null) {
            sql.SET("coupon_id = #{couponId,jdbcType=BIGINT}");
        }
        
        if (record.getBillStatus() != null) {
            sql.SET("bill_status = #{billStatus,jdbcType=INTEGER}");
        }
        
        if (record.getOutTradeNo() != null) {
            sql.SET("out_trade_no = #{outTradeNo,jdbcType=VARCHAR}");
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
        
        if (record.getPayTime() != null) {
            sql.SET("pay_time = #{payTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, OpenQuickOrderExample example, boolean includeExamplePhrase) {
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