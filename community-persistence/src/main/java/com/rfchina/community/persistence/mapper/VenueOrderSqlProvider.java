package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.VenueOrder;
import com.rfchina.community.persistence.model.VenueOrderExample.Criteria;
import com.rfchina.community.persistence.model.VenueOrderExample.Criterion;
import com.rfchina.community.persistence.model.VenueOrderExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class VenueOrderSqlProvider {

    public String countByExample(VenueOrderExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("venue_order");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(VenueOrderExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("venue_order");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(VenueOrder record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("venue_order");
        
        if (record.getUid() != null) {
            sql.VALUES("uid", "#{uid,jdbcType=BIGINT}");
        }
        
        if (record.getOrderNumber() != null) {
            sql.VALUES("order_number", "#{orderNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getCommunityId() != null) {
            sql.VALUES("community_id", "#{communityId,jdbcType=INTEGER}");
        }
        
        if (record.getOrderName() != null) {
            sql.VALUES("order_name", "#{orderName,jdbcType=VARCHAR}");
        }
        
        if (record.getOrderPhone() != null) {
            sql.VALUES("order_phone", "#{orderPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getVenueId() != null) {
            sql.VALUES("venue_id", "#{venueId,jdbcType=BIGINT}");
        }
        
        if (record.getTotalPrice() != null) {
            sql.VALUES("total_price", "#{totalPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getRealPrice() != null) {
            sql.VALUES("real_price", "#{realPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPlayDate() != null) {
            sql.VALUES("play_date", "#{playDate,jdbcType=DATE}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getPayType() != null) {
            sql.VALUES("pay_type", "#{payType,jdbcType=VARCHAR}");
        }
        
        if (record.getPayStatus() != null) {
            sql.VALUES("pay_status", "#{payStatus,jdbcType=INTEGER}");
        }
        
        if (record.getPayTime() != null) {
            sql.VALUES("pay_time", "#{payTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRefundTime() != null) {
            sql.VALUES("refund_time", "#{refundTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getChargeType() != null) {
            sql.VALUES("charge_type", "#{chargeType,jdbcType=INTEGER}");
        }
        
        if (record.getChildren() != null) {
            sql.VALUES("children", "#{children,jdbcType=INTEGER}");
        }
        
        if (record.getChildrenPrice() != null) {
            sql.VALUES("children_price", "#{childrenPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getAdult() != null) {
            sql.VALUES("adult", "#{adult,jdbcType=INTEGER}");
        }
        
        if (record.getAdultPrice() != null) {
            sql.VALUES("adult_price", "#{adultPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getAdminUid() != null) {
            sql.VALUES("admin_uid", "#{adminUid,jdbcType=BIGINT}");
        }
        
        if (record.getBillId() != null) {
            sql.VALUES("bill_id", "#{billId,jdbcType=VARCHAR}");
        }
        
        if (record.getBillCloseTime() != null) {
            sql.VALUES("bill_close_time", "#{billCloseTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getBillCreateTime() != null) {
            sql.VALUES("bill_create_time", "#{billCreateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getNotifyId() != null) {
            sql.VALUES("notify_id", "#{notifyId,jdbcType=VARCHAR}");
        }
        
        if (record.getVerifyCode() != null) {
            sql.VALUES("verify_code", "#{verifyCode,jdbcType=VARCHAR}");
        }
        
        if (record.getUseTime() != null) {
            sql.VALUES("use_time", "#{useTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getReservationChannels() != null) {
            sql.VALUES("reservation_channels", "#{reservationChannels,jdbcType=INTEGER}");
        }
        
        if (record.getCancelTime() != null) {
            sql.VALUES("cancel_time", "#{cancelTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRfpayAccount() != null) {
            sql.VALUES("rfpay_account", "#{rfpayAccount,jdbcType=VARCHAR}");
        }
        
        if (record.getRfpayFeeRate() != null) {
            sql.VALUES("rfpay_fee_rate", "#{rfpayFeeRate,jdbcType=DECIMAL}");
        }
        
        if (record.getRfpayClearingFee() != null) {
            sql.VALUES("rfpay_clearing_fee", "#{rfpayClearingFee,jdbcType=DECIMAL}");
        }
        
        if (record.getRfpayActualClearingFee() != null) {
            sql.VALUES("rfpay_actual_clearing_fee", "#{rfpayActualClearingFee,jdbcType=BIGINT}");
        }
        
        return sql.toString();
    }

    public String selectByExample(VenueOrderExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("uid");
        sql.SELECT("order_number");
        sql.SELECT("community_id");
        sql.SELECT("order_name");
        sql.SELECT("order_phone");
        sql.SELECT("venue_id");
        sql.SELECT("total_price");
        sql.SELECT("real_price");
        sql.SELECT("create_time");
        sql.SELECT("play_date");
        sql.SELECT("status");
        sql.SELECT("pay_type");
        sql.SELECT("pay_status");
        sql.SELECT("pay_time");
        sql.SELECT("refund_time");
        sql.SELECT("charge_type");
        sql.SELECT("children");
        sql.SELECT("children_price");
        sql.SELECT("adult");
        sql.SELECT("adult_price");
        sql.SELECT("admin_uid");
        sql.SELECT("bill_id");
        sql.SELECT("bill_close_time");
        sql.SELECT("bill_create_time");
        sql.SELECT("notify_id");
        sql.SELECT("verify_code");
        sql.SELECT("use_time");
        sql.SELECT("reservation_channels");
        sql.SELECT("cancel_time");
        sql.SELECT("rfpay_account");
        sql.SELECT("rfpay_fee_rate");
        sql.SELECT("rfpay_clearing_fee");
        sql.SELECT("rfpay_actual_clearing_fee");
        sql.FROM("venue_order");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        VenueOrder record = (VenueOrder) parameter.get("record");
        VenueOrderExample example = (VenueOrderExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("venue_order");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getUid() != null) {
            sql.SET("uid = #{record.uid,jdbcType=BIGINT}");
        }
        
        if (record.getOrderNumber() != null) {
            sql.SET("order_number = #{record.orderNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        }
        
        if (record.getOrderName() != null) {
            sql.SET("order_name = #{record.orderName,jdbcType=VARCHAR}");
        }
        
        if (record.getOrderPhone() != null) {
            sql.SET("order_phone = #{record.orderPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getVenueId() != null) {
            sql.SET("venue_id = #{record.venueId,jdbcType=BIGINT}");
        }
        
        if (record.getTotalPrice() != null) {
            sql.SET("total_price = #{record.totalPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getRealPrice() != null) {
            sql.SET("real_price = #{record.realPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPlayDate() != null) {
            sql.SET("play_date = #{record.playDate,jdbcType=DATE}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=INTEGER}");
        }
        
        if (record.getPayType() != null) {
            sql.SET("pay_type = #{record.payType,jdbcType=VARCHAR}");
        }
        
        if (record.getPayStatus() != null) {
            sql.SET("pay_status = #{record.payStatus,jdbcType=INTEGER}");
        }
        
        if (record.getPayTime() != null) {
            sql.SET("pay_time = #{record.payTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRefundTime() != null) {
            sql.SET("refund_time = #{record.refundTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getChargeType() != null) {
            sql.SET("charge_type = #{record.chargeType,jdbcType=INTEGER}");
        }
        
        if (record.getChildren() != null) {
            sql.SET("children = #{record.children,jdbcType=INTEGER}");
        }
        
        if (record.getChildrenPrice() != null) {
            sql.SET("children_price = #{record.childrenPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getAdult() != null) {
            sql.SET("adult = #{record.adult,jdbcType=INTEGER}");
        }
        
        if (record.getAdultPrice() != null) {
            sql.SET("adult_price = #{record.adultPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getAdminUid() != null) {
            sql.SET("admin_uid = #{record.adminUid,jdbcType=BIGINT}");
        }
        
        if (record.getBillId() != null) {
            sql.SET("bill_id = #{record.billId,jdbcType=VARCHAR}");
        }
        
        if (record.getBillCloseTime() != null) {
            sql.SET("bill_close_time = #{record.billCloseTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getBillCreateTime() != null) {
            sql.SET("bill_create_time = #{record.billCreateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getNotifyId() != null) {
            sql.SET("notify_id = #{record.notifyId,jdbcType=VARCHAR}");
        }
        
        if (record.getVerifyCode() != null) {
            sql.SET("verify_code = #{record.verifyCode,jdbcType=VARCHAR}");
        }
        
        if (record.getUseTime() != null) {
            sql.SET("use_time = #{record.useTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getReservationChannels() != null) {
            sql.SET("reservation_channels = #{record.reservationChannels,jdbcType=INTEGER}");
        }
        
        if (record.getCancelTime() != null) {
            sql.SET("cancel_time = #{record.cancelTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRfpayAccount() != null) {
            sql.SET("rfpay_account = #{record.rfpayAccount,jdbcType=VARCHAR}");
        }
        
        if (record.getRfpayFeeRate() != null) {
            sql.SET("rfpay_fee_rate = #{record.rfpayFeeRate,jdbcType=DECIMAL}");
        }
        
        if (record.getRfpayClearingFee() != null) {
            sql.SET("rfpay_clearing_fee = #{record.rfpayClearingFee,jdbcType=DECIMAL}");
        }
        
        if (record.getRfpayActualClearingFee() != null) {
            sql.SET("rfpay_actual_clearing_fee = #{record.rfpayActualClearingFee,jdbcType=BIGINT}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("venue_order");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("uid = #{record.uid,jdbcType=BIGINT}");
        sql.SET("order_number = #{record.orderNumber,jdbcType=VARCHAR}");
        sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        sql.SET("order_name = #{record.orderName,jdbcType=VARCHAR}");
        sql.SET("order_phone = #{record.orderPhone,jdbcType=VARCHAR}");
        sql.SET("venue_id = #{record.venueId,jdbcType=BIGINT}");
        sql.SET("total_price = #{record.totalPrice,jdbcType=DECIMAL}");
        sql.SET("real_price = #{record.realPrice,jdbcType=DECIMAL}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("play_date = #{record.playDate,jdbcType=DATE}");
        sql.SET("status = #{record.status,jdbcType=INTEGER}");
        sql.SET("pay_type = #{record.payType,jdbcType=VARCHAR}");
        sql.SET("pay_status = #{record.payStatus,jdbcType=INTEGER}");
        sql.SET("pay_time = #{record.payTime,jdbcType=TIMESTAMP}");
        sql.SET("refund_time = #{record.refundTime,jdbcType=TIMESTAMP}");
        sql.SET("charge_type = #{record.chargeType,jdbcType=INTEGER}");
        sql.SET("children = #{record.children,jdbcType=INTEGER}");
        sql.SET("children_price = #{record.childrenPrice,jdbcType=DECIMAL}");
        sql.SET("adult = #{record.adult,jdbcType=INTEGER}");
        sql.SET("adult_price = #{record.adultPrice,jdbcType=DECIMAL}");
        sql.SET("admin_uid = #{record.adminUid,jdbcType=BIGINT}");
        sql.SET("bill_id = #{record.billId,jdbcType=VARCHAR}");
        sql.SET("bill_close_time = #{record.billCloseTime,jdbcType=TIMESTAMP}");
        sql.SET("bill_create_time = #{record.billCreateTime,jdbcType=TIMESTAMP}");
        sql.SET("notify_id = #{record.notifyId,jdbcType=VARCHAR}");
        sql.SET("verify_code = #{record.verifyCode,jdbcType=VARCHAR}");
        sql.SET("use_time = #{record.useTime,jdbcType=TIMESTAMP}");
        sql.SET("reservation_channels = #{record.reservationChannels,jdbcType=INTEGER}");
        sql.SET("cancel_time = #{record.cancelTime,jdbcType=TIMESTAMP}");
        sql.SET("rfpay_account = #{record.rfpayAccount,jdbcType=VARCHAR}");
        sql.SET("rfpay_fee_rate = #{record.rfpayFeeRate,jdbcType=DECIMAL}");
        sql.SET("rfpay_clearing_fee = #{record.rfpayClearingFee,jdbcType=DECIMAL}");
        sql.SET("rfpay_actual_clearing_fee = #{record.rfpayActualClearingFee,jdbcType=BIGINT}");
        
        VenueOrderExample example = (VenueOrderExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(VenueOrder record) {
        SQL sql = new SQL();
        sql.UPDATE("venue_order");
        
        if (record.getUid() != null) {
            sql.SET("uid = #{uid,jdbcType=BIGINT}");
        }
        
        if (record.getOrderNumber() != null) {
            sql.SET("order_number = #{orderNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{communityId,jdbcType=INTEGER}");
        }
        
        if (record.getOrderName() != null) {
            sql.SET("order_name = #{orderName,jdbcType=VARCHAR}");
        }
        
        if (record.getOrderPhone() != null) {
            sql.SET("order_phone = #{orderPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getVenueId() != null) {
            sql.SET("venue_id = #{venueId,jdbcType=BIGINT}");
        }
        
        if (record.getTotalPrice() != null) {
            sql.SET("total_price = #{totalPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getRealPrice() != null) {
            sql.SET("real_price = #{realPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPlayDate() != null) {
            sql.SET("play_date = #{playDate,jdbcType=DATE}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getPayType() != null) {
            sql.SET("pay_type = #{payType,jdbcType=VARCHAR}");
        }
        
        if (record.getPayStatus() != null) {
            sql.SET("pay_status = #{payStatus,jdbcType=INTEGER}");
        }
        
        if (record.getPayTime() != null) {
            sql.SET("pay_time = #{payTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRefundTime() != null) {
            sql.SET("refund_time = #{refundTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getChargeType() != null) {
            sql.SET("charge_type = #{chargeType,jdbcType=INTEGER}");
        }
        
        if (record.getChildren() != null) {
            sql.SET("children = #{children,jdbcType=INTEGER}");
        }
        
        if (record.getChildrenPrice() != null) {
            sql.SET("children_price = #{childrenPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getAdult() != null) {
            sql.SET("adult = #{adult,jdbcType=INTEGER}");
        }
        
        if (record.getAdultPrice() != null) {
            sql.SET("adult_price = #{adultPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getAdminUid() != null) {
            sql.SET("admin_uid = #{adminUid,jdbcType=BIGINT}");
        }
        
        if (record.getBillId() != null) {
            sql.SET("bill_id = #{billId,jdbcType=VARCHAR}");
        }
        
        if (record.getBillCloseTime() != null) {
            sql.SET("bill_close_time = #{billCloseTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getBillCreateTime() != null) {
            sql.SET("bill_create_time = #{billCreateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getNotifyId() != null) {
            sql.SET("notify_id = #{notifyId,jdbcType=VARCHAR}");
        }
        
        if (record.getVerifyCode() != null) {
            sql.SET("verify_code = #{verifyCode,jdbcType=VARCHAR}");
        }
        
        if (record.getUseTime() != null) {
            sql.SET("use_time = #{useTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getReservationChannels() != null) {
            sql.SET("reservation_channels = #{reservationChannels,jdbcType=INTEGER}");
        }
        
        if (record.getCancelTime() != null) {
            sql.SET("cancel_time = #{cancelTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRfpayAccount() != null) {
            sql.SET("rfpay_account = #{rfpayAccount,jdbcType=VARCHAR}");
        }
        
        if (record.getRfpayFeeRate() != null) {
            sql.SET("rfpay_fee_rate = #{rfpayFeeRate,jdbcType=DECIMAL}");
        }
        
        if (record.getRfpayClearingFee() != null) {
            sql.SET("rfpay_clearing_fee = #{rfpayClearingFee,jdbcType=DECIMAL}");
        }
        
        if (record.getRfpayActualClearingFee() != null) {
            sql.SET("rfpay_actual_clearing_fee = #{rfpayActualClearingFee,jdbcType=BIGINT}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, VenueOrderExample example, boolean includeExamplePhrase) {
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