package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenFeeOrderExample.Criteria;
import com.rfchina.community.persistence.model.OpenFeeOrderExample.Criterion;
import com.rfchina.community.persistence.model.OpenFeeOrderExample;
import com.rfchina.community.persistence.model.OpenFeeOrderWithBLOBs;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class OpenFeeOrderSqlProvider {

    public String countByExample(OpenFeeOrderExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("open_fee_order");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(OpenFeeOrderExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("open_fee_order");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(OpenFeeOrderWithBLOBs record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("open_fee_order");
        
        if (record.getCommunityId() != null) {
            sql.VALUES("community_id", "#{communityId,jdbcType=INTEGER}");
        }
        
        if (record.getServiceId() != null) {
            sql.VALUES("service_id", "#{serviceId,jdbcType=INTEGER}");
        }
        
        if (record.getVerifyNo() != null) {
            sql.VALUES("verify_no", "#{verifyNo,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getType() != null) {
            sql.VALUES("type", "#{type,jdbcType=CHAR}");
        }
        
        if (record.getOrderNo() != null) {
            sql.VALUES("order_no", "#{orderNo,jdbcType=VARCHAR}");
        }
        
        if (record.getStoreOrderId() != null) {
            sql.VALUES("store_order_id", "#{storeOrderId,jdbcType=INTEGER}");
        }
        
        if (record.getTradeAmount() != null) {
            sql.VALUES("trade_amount", "#{tradeAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getPlatformCharge() != null) {
            sql.VALUES("platform_charge", "#{platformCharge,jdbcType=DECIMAL}");
        }
        
        if (record.getPlatformChargeRate() != null) {
            sql.VALUES("platform_charge_rate", "#{platformChargeRate,jdbcType=DECIMAL}");
        }
        
        if (record.getServiceCharge() != null) {
            sql.VALUES("service_charge", "#{serviceCharge,jdbcType=DECIMAL}");
        }
        
        if (record.getServiceChargeRate() != null) {
            sql.VALUES("service_charge_rate", "#{serviceChargeRate,jdbcType=DECIMAL}");
        }
        
        if (record.getPayAmount() != null) {
            sql.VALUES("pay_amount", "#{payAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getPayId() != null) {
            sql.VALUES("pay_id", "#{payId,jdbcType=BIGINT}");
        }
        
        if (record.getPayStatus() != null) {
            sql.VALUES("pay_status", "#{payStatus,jdbcType=CHAR}");
        }
        
        if (record.getPayTime() != null) {
            sql.VALUES("pay_time", "#{payTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getOrderExplain() != null) {
            sql.VALUES("order_explain", "#{orderExplain,jdbcType=VARCHAR}");
        }
        
        if (record.getGoodsDetail() != null) {
            sql.VALUES("goods_detail", "#{goodsDetail,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getSalesContract() != null) {
            sql.VALUES("sales_contract", "#{salesContract,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExampleWithBLOBs(OpenFeeOrderExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("community_id");
        sql.SELECT("service_id");
        sql.SELECT("verify_no");
        sql.SELECT("create_time");
        sql.SELECT("type");
        sql.SELECT("order_no");
        sql.SELECT("store_order_id");
        sql.SELECT("trade_amount");
        sql.SELECT("platform_charge");
        sql.SELECT("platform_charge_rate");
        sql.SELECT("service_charge");
        sql.SELECT("service_charge_rate");
        sql.SELECT("pay_amount");
        sql.SELECT("pay_id");
        sql.SELECT("pay_status");
        sql.SELECT("pay_time");
        sql.SELECT("order_explain");
        sql.SELECT("goods_detail");
        sql.SELECT("sales_contract");
        sql.FROM("open_fee_order");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String selectByExample(OpenFeeOrderExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("community_id");
        sql.SELECT("service_id");
        sql.SELECT("verify_no");
        sql.SELECT("create_time");
        sql.SELECT("type");
        sql.SELECT("order_no");
        sql.SELECT("store_order_id");
        sql.SELECT("trade_amount");
        sql.SELECT("platform_charge");
        sql.SELECT("platform_charge_rate");
        sql.SELECT("service_charge");
        sql.SELECT("service_charge_rate");
        sql.SELECT("pay_amount");
        sql.SELECT("pay_id");
        sql.SELECT("pay_status");
        sql.SELECT("pay_time");
        sql.SELECT("order_explain");
        sql.FROM("open_fee_order");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        OpenFeeOrderWithBLOBs record = (OpenFeeOrderWithBLOBs) parameter.get("record");
        OpenFeeOrderExample example = (OpenFeeOrderExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("open_fee_order");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        }
        
        if (record.getServiceId() != null) {
            sql.SET("service_id = #{record.serviceId,jdbcType=INTEGER}");
        }
        
        if (record.getVerifyNo() != null) {
            sql.SET("verify_no = #{record.verifyNo,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{record.type,jdbcType=CHAR}");
        }
        
        if (record.getOrderNo() != null) {
            sql.SET("order_no = #{record.orderNo,jdbcType=VARCHAR}");
        }
        
        if (record.getStoreOrderId() != null) {
            sql.SET("store_order_id = #{record.storeOrderId,jdbcType=INTEGER}");
        }
        
        if (record.getTradeAmount() != null) {
            sql.SET("trade_amount = #{record.tradeAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getPlatformCharge() != null) {
            sql.SET("platform_charge = #{record.platformCharge,jdbcType=DECIMAL}");
        }
        
        if (record.getPlatformChargeRate() != null) {
            sql.SET("platform_charge_rate = #{record.platformChargeRate,jdbcType=DECIMAL}");
        }
        
        if (record.getServiceCharge() != null) {
            sql.SET("service_charge = #{record.serviceCharge,jdbcType=DECIMAL}");
        }
        
        if (record.getServiceChargeRate() != null) {
            sql.SET("service_charge_rate = #{record.serviceChargeRate,jdbcType=DECIMAL}");
        }
        
        if (record.getPayAmount() != null) {
            sql.SET("pay_amount = #{record.payAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getPayId() != null) {
            sql.SET("pay_id = #{record.payId,jdbcType=BIGINT}");
        }
        
        if (record.getPayStatus() != null) {
            sql.SET("pay_status = #{record.payStatus,jdbcType=CHAR}");
        }
        
        if (record.getPayTime() != null) {
            sql.SET("pay_time = #{record.payTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getOrderExplain() != null) {
            sql.SET("order_explain = #{record.orderExplain,jdbcType=VARCHAR}");
        }
        
        if (record.getGoodsDetail() != null) {
            sql.SET("goods_detail = #{record.goodsDetail,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getSalesContract() != null) {
            sql.SET("sales_contract = #{record.salesContract,jdbcType=LONGVARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("open_fee_order");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        sql.SET("service_id = #{record.serviceId,jdbcType=INTEGER}");
        sql.SET("verify_no = #{record.verifyNo,jdbcType=VARCHAR}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("type = #{record.type,jdbcType=CHAR}");
        sql.SET("order_no = #{record.orderNo,jdbcType=VARCHAR}");
        sql.SET("store_order_id = #{record.storeOrderId,jdbcType=INTEGER}");
        sql.SET("trade_amount = #{record.tradeAmount,jdbcType=DECIMAL}");
        sql.SET("platform_charge = #{record.platformCharge,jdbcType=DECIMAL}");
        sql.SET("platform_charge_rate = #{record.platformChargeRate,jdbcType=DECIMAL}");
        sql.SET("service_charge = #{record.serviceCharge,jdbcType=DECIMAL}");
        sql.SET("service_charge_rate = #{record.serviceChargeRate,jdbcType=DECIMAL}");
        sql.SET("pay_amount = #{record.payAmount,jdbcType=DECIMAL}");
        sql.SET("pay_id = #{record.payId,jdbcType=BIGINT}");
        sql.SET("pay_status = #{record.payStatus,jdbcType=CHAR}");
        sql.SET("pay_time = #{record.payTime,jdbcType=TIMESTAMP}");
        sql.SET("order_explain = #{record.orderExplain,jdbcType=VARCHAR}");
        sql.SET("goods_detail = #{record.goodsDetail,jdbcType=LONGVARCHAR}");
        sql.SET("sales_contract = #{record.salesContract,jdbcType=LONGVARCHAR}");
        
        OpenFeeOrderExample example = (OpenFeeOrderExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("open_fee_order");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        sql.SET("service_id = #{record.serviceId,jdbcType=INTEGER}");
        sql.SET("verify_no = #{record.verifyNo,jdbcType=VARCHAR}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("type = #{record.type,jdbcType=CHAR}");
        sql.SET("order_no = #{record.orderNo,jdbcType=VARCHAR}");
        sql.SET("store_order_id = #{record.storeOrderId,jdbcType=INTEGER}");
        sql.SET("trade_amount = #{record.tradeAmount,jdbcType=DECIMAL}");
        sql.SET("platform_charge = #{record.platformCharge,jdbcType=DECIMAL}");
        sql.SET("platform_charge_rate = #{record.platformChargeRate,jdbcType=DECIMAL}");
        sql.SET("service_charge = #{record.serviceCharge,jdbcType=DECIMAL}");
        sql.SET("service_charge_rate = #{record.serviceChargeRate,jdbcType=DECIMAL}");
        sql.SET("pay_amount = #{record.payAmount,jdbcType=DECIMAL}");
        sql.SET("pay_id = #{record.payId,jdbcType=BIGINT}");
        sql.SET("pay_status = #{record.payStatus,jdbcType=CHAR}");
        sql.SET("pay_time = #{record.payTime,jdbcType=TIMESTAMP}");
        sql.SET("order_explain = #{record.orderExplain,jdbcType=VARCHAR}");
        
        OpenFeeOrderExample example = (OpenFeeOrderExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(OpenFeeOrderWithBLOBs record) {
        SQL sql = new SQL();
        sql.UPDATE("open_fee_order");
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{communityId,jdbcType=INTEGER}");
        }
        
        if (record.getServiceId() != null) {
            sql.SET("service_id = #{serviceId,jdbcType=INTEGER}");
        }
        
        if (record.getVerifyNo() != null) {
            sql.SET("verify_no = #{verifyNo,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{type,jdbcType=CHAR}");
        }
        
        if (record.getOrderNo() != null) {
            sql.SET("order_no = #{orderNo,jdbcType=VARCHAR}");
        }
        
        if (record.getStoreOrderId() != null) {
            sql.SET("store_order_id = #{storeOrderId,jdbcType=INTEGER}");
        }
        
        if (record.getTradeAmount() != null) {
            sql.SET("trade_amount = #{tradeAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getPlatformCharge() != null) {
            sql.SET("platform_charge = #{platformCharge,jdbcType=DECIMAL}");
        }
        
        if (record.getPlatformChargeRate() != null) {
            sql.SET("platform_charge_rate = #{platformChargeRate,jdbcType=DECIMAL}");
        }
        
        if (record.getServiceCharge() != null) {
            sql.SET("service_charge = #{serviceCharge,jdbcType=DECIMAL}");
        }
        
        if (record.getServiceChargeRate() != null) {
            sql.SET("service_charge_rate = #{serviceChargeRate,jdbcType=DECIMAL}");
        }
        
        if (record.getPayAmount() != null) {
            sql.SET("pay_amount = #{payAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getPayId() != null) {
            sql.SET("pay_id = #{payId,jdbcType=BIGINT}");
        }
        
        if (record.getPayStatus() != null) {
            sql.SET("pay_status = #{payStatus,jdbcType=CHAR}");
        }
        
        if (record.getPayTime() != null) {
            sql.SET("pay_time = #{payTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getOrderExplain() != null) {
            sql.SET("order_explain = #{orderExplain,jdbcType=VARCHAR}");
        }
        
        if (record.getGoodsDetail() != null) {
            sql.SET("goods_detail = #{goodsDetail,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getSalesContract() != null) {
            sql.SET("sales_contract = #{salesContract,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, OpenFeeOrderExample example, boolean includeExamplePhrase) {
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