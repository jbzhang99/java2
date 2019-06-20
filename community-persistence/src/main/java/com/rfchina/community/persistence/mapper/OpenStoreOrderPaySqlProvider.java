package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenStoreOrderPay;
import com.rfchina.community.persistence.model.OpenStoreOrderPayExample.Criteria;
import com.rfchina.community.persistence.model.OpenStoreOrderPayExample.Criterion;
import com.rfchina.community.persistence.model.OpenStoreOrderPayExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class OpenStoreOrderPaySqlProvider {

    public String countByExample(OpenStoreOrderPayExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("open_store_order_pay");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(OpenStoreOrderPayExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("open_store_order_pay");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(OpenStoreOrderPay record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("open_store_order_pay");
        
        if (record.getServiceId() != null) {
            sql.VALUES("service_id", "#{serviceId,jdbcType=INTEGER}");
        }
        
        if (record.getOpenId() != null) {
            sql.VALUES("open_id", "#{openId,jdbcType=VARCHAR}");
        }
        
        if (record.getStoreOrderId() != null) {
            sql.VALUES("store_order_id", "#{storeOrderId,jdbcType=INTEGER}");
        }
        
        if (record.getPayChannel() != null) {
            sql.VALUES("pay_channel", "#{payChannel,jdbcType=VARCHAR}");
        }
        
        if (record.getPayStatus() != null) {
            sql.VALUES("pay_status", "#{payStatus,jdbcType=INTEGER}");
        }
        
        if (record.getOutTradeNo() != null) {
            sql.VALUES("out_trade_no", "#{outTradeNo,jdbcType=VARCHAR}");
        }
        
        if (record.getCommunityTradeNo() != null) {
            sql.VALUES("community_trade_no", "#{communityTradeNo,jdbcType=VARCHAR}");
        }
        
        if (record.getTotalAmount() != null) {
            sql.VALUES("total_amount", "#{totalAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getTradeType() != null) {
            sql.VALUES("trade_type", "#{tradeType,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPayTime() != null) {
            sql.VALUES("pay_time", "#{payTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRefundStatus() != null) {
            sql.VALUES("refund_status", "#{refundStatus,jdbcType=INTEGER}");
        }
        
        if (record.getRefundTime() != null) {
            sql.VALUES("refund_time", "#{refundTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRefundApproval() != null) {
            sql.VALUES("refund_approval", "#{refundApproval,jdbcType=VARCHAR}");
        }
        
        if (record.getRefundEmail() != null) {
            sql.VALUES("refund_email", "#{refundEmail,jdbcType=INTEGER}");
        }
        
        if (record.getOriginalPrice() != null) {
            sql.VALUES("original_price", "#{originalPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getDiscountPrice() != null) {
            sql.VALUES("discount_price", "#{discountPrice,jdbcType=DECIMAL}");
        }
        
        return sql.toString();
    }

    public String selectByExample(OpenStoreOrderPayExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("service_id");
        sql.SELECT("open_id");
        sql.SELECT("store_order_id");
        sql.SELECT("pay_channel");
        sql.SELECT("pay_status");
        sql.SELECT("out_trade_no");
        sql.SELECT("community_trade_no");
        sql.SELECT("total_amount");
        sql.SELECT("trade_type");
        sql.SELECT("create_time");
        sql.SELECT("pay_time");
        sql.SELECT("refund_status");
        sql.SELECT("refund_time");
        sql.SELECT("refund_approval");
        sql.SELECT("refund_email");
        sql.SELECT("original_price");
        sql.SELECT("discount_price");
        sql.FROM("open_store_order_pay");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        OpenStoreOrderPay record = (OpenStoreOrderPay) parameter.get("record");
        OpenStoreOrderPayExample example = (OpenStoreOrderPayExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("open_store_order_pay");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getServiceId() != null) {
            sql.SET("service_id = #{record.serviceId,jdbcType=INTEGER}");
        }
        
        if (record.getOpenId() != null) {
            sql.SET("open_id = #{record.openId,jdbcType=VARCHAR}");
        }
        
        if (record.getStoreOrderId() != null) {
            sql.SET("store_order_id = #{record.storeOrderId,jdbcType=INTEGER}");
        }
        
        if (record.getPayChannel() != null) {
            sql.SET("pay_channel = #{record.payChannel,jdbcType=VARCHAR}");
        }
        
        if (record.getPayStatus() != null) {
            sql.SET("pay_status = #{record.payStatus,jdbcType=INTEGER}");
        }
        
        if (record.getOutTradeNo() != null) {
            sql.SET("out_trade_no = #{record.outTradeNo,jdbcType=VARCHAR}");
        }
        
        if (record.getCommunityTradeNo() != null) {
            sql.SET("community_trade_no = #{record.communityTradeNo,jdbcType=VARCHAR}");
        }
        
        if (record.getTotalAmount() != null) {
            sql.SET("total_amount = #{record.totalAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getTradeType() != null) {
            sql.SET("trade_type = #{record.tradeType,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPayTime() != null) {
            sql.SET("pay_time = #{record.payTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRefundStatus() != null) {
            sql.SET("refund_status = #{record.refundStatus,jdbcType=INTEGER}");
        }
        
        if (record.getRefundTime() != null) {
            sql.SET("refund_time = #{record.refundTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRefundApproval() != null) {
            sql.SET("refund_approval = #{record.refundApproval,jdbcType=VARCHAR}");
        }
        
        if (record.getRefundEmail() != null) {
            sql.SET("refund_email = #{record.refundEmail,jdbcType=INTEGER}");
        }
        
        if (record.getOriginalPrice() != null) {
            sql.SET("original_price = #{record.originalPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getDiscountPrice() != null) {
            sql.SET("discount_price = #{record.discountPrice,jdbcType=DECIMAL}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("open_store_order_pay");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("service_id = #{record.serviceId,jdbcType=INTEGER}");
        sql.SET("open_id = #{record.openId,jdbcType=VARCHAR}");
        sql.SET("store_order_id = #{record.storeOrderId,jdbcType=INTEGER}");
        sql.SET("pay_channel = #{record.payChannel,jdbcType=VARCHAR}");
        sql.SET("pay_status = #{record.payStatus,jdbcType=INTEGER}");
        sql.SET("out_trade_no = #{record.outTradeNo,jdbcType=VARCHAR}");
        sql.SET("community_trade_no = #{record.communityTradeNo,jdbcType=VARCHAR}");
        sql.SET("total_amount = #{record.totalAmount,jdbcType=DECIMAL}");
        sql.SET("trade_type = #{record.tradeType,jdbcType=VARCHAR}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("pay_time = #{record.payTime,jdbcType=TIMESTAMP}");
        sql.SET("refund_status = #{record.refundStatus,jdbcType=INTEGER}");
        sql.SET("refund_time = #{record.refundTime,jdbcType=TIMESTAMP}");
        sql.SET("refund_approval = #{record.refundApproval,jdbcType=VARCHAR}");
        sql.SET("refund_email = #{record.refundEmail,jdbcType=INTEGER}");
        sql.SET("original_price = #{record.originalPrice,jdbcType=DECIMAL}");
        sql.SET("discount_price = #{record.discountPrice,jdbcType=DECIMAL}");
        
        OpenStoreOrderPayExample example = (OpenStoreOrderPayExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(OpenStoreOrderPay record) {
        SQL sql = new SQL();
        sql.UPDATE("open_store_order_pay");
        
        if (record.getServiceId() != null) {
            sql.SET("service_id = #{serviceId,jdbcType=INTEGER}");
        }
        
        if (record.getOpenId() != null) {
            sql.SET("open_id = #{openId,jdbcType=VARCHAR}");
        }
        
        if (record.getStoreOrderId() != null) {
            sql.SET("store_order_id = #{storeOrderId,jdbcType=INTEGER}");
        }
        
        if (record.getPayChannel() != null) {
            sql.SET("pay_channel = #{payChannel,jdbcType=VARCHAR}");
        }
        
        if (record.getPayStatus() != null) {
            sql.SET("pay_status = #{payStatus,jdbcType=INTEGER}");
        }
        
        if (record.getOutTradeNo() != null) {
            sql.SET("out_trade_no = #{outTradeNo,jdbcType=VARCHAR}");
        }
        
        if (record.getCommunityTradeNo() != null) {
            sql.SET("community_trade_no = #{communityTradeNo,jdbcType=VARCHAR}");
        }
        
        if (record.getTotalAmount() != null) {
            sql.SET("total_amount = #{totalAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getTradeType() != null) {
            sql.SET("trade_type = #{tradeType,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPayTime() != null) {
            sql.SET("pay_time = #{payTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRefundStatus() != null) {
            sql.SET("refund_status = #{refundStatus,jdbcType=INTEGER}");
        }
        
        if (record.getRefundTime() != null) {
            sql.SET("refund_time = #{refundTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRefundApproval() != null) {
            sql.SET("refund_approval = #{refundApproval,jdbcType=VARCHAR}");
        }
        
        if (record.getRefundEmail() != null) {
            sql.SET("refund_email = #{refundEmail,jdbcType=INTEGER}");
        }
        
        if (record.getOriginalPrice() != null) {
            sql.SET("original_price = #{originalPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getDiscountPrice() != null) {
            sql.SET("discount_price = #{discountPrice,jdbcType=DECIMAL}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, OpenStoreOrderPayExample example, boolean includeExamplePhrase) {
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