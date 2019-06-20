package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.ParkingOrder;
import com.rfchina.community.persistence.model.ParkingOrderExample.Criteria;
import com.rfchina.community.persistence.model.ParkingOrderExample.Criterion;
import com.rfchina.community.persistence.model.ParkingOrderExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class ParkingOrderSqlProvider {

    public String countByExample(ParkingOrderExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("parking_order");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(ParkingOrderExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("parking_order");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(ParkingOrder record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("parking_order");
        
        if (record.getCommunityId() != null) {
            sql.VALUES("community_id", "#{communityId,jdbcType=INTEGER}");
        }
        
        if (record.getSerialNo() != null) {
            sql.VALUES("serial_no", "#{serialNo,jdbcType=VARCHAR}");
        }
        
        if (record.getMobile() != null) {
            sql.VALUES("mobile", "#{mobile,jdbcType=VARCHAR}");
        }
        
        if (record.getUid() != null) {
            sql.VALUES("uid", "#{uid,jdbcType=BIGINT}");
        }
        
        if (record.getCarPlateNo() != null) {
            sql.VALUES("car_plate_no", "#{carPlateNo,jdbcType=VARCHAR}");
        }
        
        if (record.getCardNo() != null) {
            sql.VALUES("card_no", "#{cardNo,jdbcType=VARCHAR}");
        }
        
        if (record.getOrderType() != null) {
            sql.VALUES("order_type", "#{orderType,jdbcType=INTEGER}");
        }
        
        if (record.getOrderStatus() != null) {
            sql.VALUES("order_status", "#{orderStatus,jdbcType=INTEGER}");
        }
        
        if (record.getPayStatus() != null) {
            sql.VALUES("pay_status", "#{payStatus,jdbcType=INTEGER}");
        }
        
        if (record.getPayType() != null) {
            sql.VALUES("pay_type", "#{payType,jdbcType=VARCHAR}");
        }
        
        if (record.getPayTime() != null) {
            sql.VALUES("pay_time", "#{payTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPayAmount() != null) {
            sql.VALUES("pay_amount", "#{payAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getPayPrice() != null) {
            sql.VALUES("pay_price", "#{payPrice,jdbcType=VARCHAR}");
        }
        
        if (record.getPaySrc() != null) {
            sql.VALUES("pay_src", "#{paySrc,jdbcType=INTEGER}");
        }
        
        if (record.getWxOpenid() != null) {
            sql.VALUES("wx_openid", "#{wxOpenid,jdbcType=VARCHAR}");
        }
        
        if (record.getDuration() != null) {
            sql.VALUES("duration", "#{duration,jdbcType=VARCHAR}");
        }
        
        if (record.getFreeDuration() != null) {
            sql.VALUES("free_duration", "#{freeDuration,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            sql.VALUES("address", "#{address,jdbcType=VARCHAR}");
        }
        
        if (record.getEnterTime() != null) {
            sql.VALUES("enter_time", "#{enterTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCancelTime() != null) {
            sql.VALUES("cancel_time", "#{cancelTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getMonthlyPayNum() != null) {
            sql.VALUES("monthly_pay_num", "#{monthlyPayNum,jdbcType=INTEGER}");
        }
        
        if (record.getMonthlyPayStartTime() != null) {
            sql.VALUES("monthly_pay_start_time", "#{monthlyPayStartTime,jdbcType=VARCHAR}");
        }
        
        if (record.getMonthlyPayEndTime() != null) {
            sql.VALUES("monthly_pay_end_time", "#{monthlyPayEndTime,jdbcType=VARCHAR}");
        }
        
        if (record.getRfpayBillId() != null) {
            sql.VALUES("rfpay_bill_id", "#{rfpayBillId,jdbcType=VARCHAR}");
        }
        
        if (record.getRfpayTradeNo() != null) {
            sql.VALUES("rfpay_trade_no", "#{rfpayTradeNo,jdbcType=VARCHAR}");
        }
        
        if (record.getRfpayBody() != null) {
            sql.VALUES("rfpay_body", "#{rfpayBody,jdbcType=VARCHAR}");
        }
        
        if (record.getRfpayType() != null) {
            sql.VALUES("rfpay_type", "#{rfpayType,jdbcType=VARCHAR}");
        }
        
        if (record.getRfpayCreateTime() != null) {
            sql.VALUES("rfpay_create_time", "#{rfpayCreateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRfpayCloseTime() != null) {
            sql.VALUES("rfpay_close_time", "#{rfpayCloseTime,jdbcType=TIMESTAMP}");
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
        
        if (record.getPrvUid() != null) {
            sql.VALUES("prv_uid", "#{prvUid,jdbcType=BIGINT}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(ParkingOrderExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("community_id");
        sql.SELECT("serial_no");
        sql.SELECT("mobile");
        sql.SELECT("uid");
        sql.SELECT("car_plate_no");
        sql.SELECT("card_no");
        sql.SELECT("order_type");
        sql.SELECT("order_status");
        sql.SELECT("pay_status");
        sql.SELECT("pay_type");
        sql.SELECT("pay_time");
        sql.SELECT("pay_amount");
        sql.SELECT("pay_price");
        sql.SELECT("pay_src");
        sql.SELECT("wx_openid");
        sql.SELECT("duration");
        sql.SELECT("free_duration");
        sql.SELECT("address");
        sql.SELECT("enter_time");
        sql.SELECT("cancel_time");
        sql.SELECT("monthly_pay_num");
        sql.SELECT("monthly_pay_start_time");
        sql.SELECT("monthly_pay_end_time");
        sql.SELECT("rfpay_bill_id");
        sql.SELECT("rfpay_trade_no");
        sql.SELECT("rfpay_body");
        sql.SELECT("rfpay_type");
        sql.SELECT("rfpay_create_time");
        sql.SELECT("rfpay_close_time");
        sql.SELECT("rfpay_account");
        sql.SELECT("rfpay_fee_rate");
        sql.SELECT("rfpay_clearing_fee");
        sql.SELECT("rfpay_actual_clearing_fee");
        sql.SELECT("prv_uid");
        sql.SELECT("create_time");
        sql.SELECT("update_time");
        sql.FROM("parking_order");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        ParkingOrder record = (ParkingOrder) parameter.get("record");
        ParkingOrderExample example = (ParkingOrderExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("parking_order");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        }
        
        if (record.getSerialNo() != null) {
            sql.SET("serial_no = #{record.serialNo,jdbcType=VARCHAR}");
        }
        
        if (record.getMobile() != null) {
            sql.SET("mobile = #{record.mobile,jdbcType=VARCHAR}");
        }
        
        if (record.getUid() != null) {
            sql.SET("uid = #{record.uid,jdbcType=BIGINT}");
        }
        
        if (record.getCarPlateNo() != null) {
            sql.SET("car_plate_no = #{record.carPlateNo,jdbcType=VARCHAR}");
        }
        
        if (record.getCardNo() != null) {
            sql.SET("card_no = #{record.cardNo,jdbcType=VARCHAR}");
        }
        
        if (record.getOrderType() != null) {
            sql.SET("order_type = #{record.orderType,jdbcType=INTEGER}");
        }
        
        if (record.getOrderStatus() != null) {
            sql.SET("order_status = #{record.orderStatus,jdbcType=INTEGER}");
        }
        
        if (record.getPayStatus() != null) {
            sql.SET("pay_status = #{record.payStatus,jdbcType=INTEGER}");
        }
        
        if (record.getPayType() != null) {
            sql.SET("pay_type = #{record.payType,jdbcType=VARCHAR}");
        }
        
        if (record.getPayTime() != null) {
            sql.SET("pay_time = #{record.payTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPayAmount() != null) {
            sql.SET("pay_amount = #{record.payAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getPayPrice() != null) {
            sql.SET("pay_price = #{record.payPrice,jdbcType=VARCHAR}");
        }
        
        if (record.getPaySrc() != null) {
            sql.SET("pay_src = #{record.paySrc,jdbcType=INTEGER}");
        }
        
        if (record.getWxOpenid() != null) {
            sql.SET("wx_openid = #{record.wxOpenid,jdbcType=VARCHAR}");
        }
        
        if (record.getDuration() != null) {
            sql.SET("duration = #{record.duration,jdbcType=VARCHAR}");
        }
        
        if (record.getFreeDuration() != null) {
            sql.SET("free_duration = #{record.freeDuration,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            sql.SET("address = #{record.address,jdbcType=VARCHAR}");
        }
        
        if (record.getEnterTime() != null) {
            sql.SET("enter_time = #{record.enterTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCancelTime() != null) {
            sql.SET("cancel_time = #{record.cancelTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getMonthlyPayNum() != null) {
            sql.SET("monthly_pay_num = #{record.monthlyPayNum,jdbcType=INTEGER}");
        }
        
        if (record.getMonthlyPayStartTime() != null) {
            sql.SET("monthly_pay_start_time = #{record.monthlyPayStartTime,jdbcType=VARCHAR}");
        }
        
        if (record.getMonthlyPayEndTime() != null) {
            sql.SET("monthly_pay_end_time = #{record.monthlyPayEndTime,jdbcType=VARCHAR}");
        }
        
        if (record.getRfpayBillId() != null) {
            sql.SET("rfpay_bill_id = #{record.rfpayBillId,jdbcType=VARCHAR}");
        }
        
        if (record.getRfpayTradeNo() != null) {
            sql.SET("rfpay_trade_no = #{record.rfpayTradeNo,jdbcType=VARCHAR}");
        }
        
        if (record.getRfpayBody() != null) {
            sql.SET("rfpay_body = #{record.rfpayBody,jdbcType=VARCHAR}");
        }
        
        if (record.getRfpayType() != null) {
            sql.SET("rfpay_type = #{record.rfpayType,jdbcType=VARCHAR}");
        }
        
        if (record.getRfpayCreateTime() != null) {
            sql.SET("rfpay_create_time = #{record.rfpayCreateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRfpayCloseTime() != null) {
            sql.SET("rfpay_close_time = #{record.rfpayCloseTime,jdbcType=TIMESTAMP}");
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
        
        if (record.getPrvUid() != null) {
            sql.SET("prv_uid = #{record.prvUid,jdbcType=BIGINT}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("parking_order");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        sql.SET("serial_no = #{record.serialNo,jdbcType=VARCHAR}");
        sql.SET("mobile = #{record.mobile,jdbcType=VARCHAR}");
        sql.SET("uid = #{record.uid,jdbcType=BIGINT}");
        sql.SET("car_plate_no = #{record.carPlateNo,jdbcType=VARCHAR}");
        sql.SET("card_no = #{record.cardNo,jdbcType=VARCHAR}");
        sql.SET("order_type = #{record.orderType,jdbcType=INTEGER}");
        sql.SET("order_status = #{record.orderStatus,jdbcType=INTEGER}");
        sql.SET("pay_status = #{record.payStatus,jdbcType=INTEGER}");
        sql.SET("pay_type = #{record.payType,jdbcType=VARCHAR}");
        sql.SET("pay_time = #{record.payTime,jdbcType=TIMESTAMP}");
        sql.SET("pay_amount = #{record.payAmount,jdbcType=DECIMAL}");
        sql.SET("pay_price = #{record.payPrice,jdbcType=VARCHAR}");
        sql.SET("pay_src = #{record.paySrc,jdbcType=INTEGER}");
        sql.SET("wx_openid = #{record.wxOpenid,jdbcType=VARCHAR}");
        sql.SET("duration = #{record.duration,jdbcType=VARCHAR}");
        sql.SET("free_duration = #{record.freeDuration,jdbcType=VARCHAR}");
        sql.SET("address = #{record.address,jdbcType=VARCHAR}");
        sql.SET("enter_time = #{record.enterTime,jdbcType=TIMESTAMP}");
        sql.SET("cancel_time = #{record.cancelTime,jdbcType=TIMESTAMP}");
        sql.SET("monthly_pay_num = #{record.monthlyPayNum,jdbcType=INTEGER}");
        sql.SET("monthly_pay_start_time = #{record.monthlyPayStartTime,jdbcType=VARCHAR}");
        sql.SET("monthly_pay_end_time = #{record.monthlyPayEndTime,jdbcType=VARCHAR}");
        sql.SET("rfpay_bill_id = #{record.rfpayBillId,jdbcType=VARCHAR}");
        sql.SET("rfpay_trade_no = #{record.rfpayTradeNo,jdbcType=VARCHAR}");
        sql.SET("rfpay_body = #{record.rfpayBody,jdbcType=VARCHAR}");
        sql.SET("rfpay_type = #{record.rfpayType,jdbcType=VARCHAR}");
        sql.SET("rfpay_create_time = #{record.rfpayCreateTime,jdbcType=TIMESTAMP}");
        sql.SET("rfpay_close_time = #{record.rfpayCloseTime,jdbcType=TIMESTAMP}");
        sql.SET("rfpay_account = #{record.rfpayAccount,jdbcType=VARCHAR}");
        sql.SET("rfpay_fee_rate = #{record.rfpayFeeRate,jdbcType=DECIMAL}");
        sql.SET("rfpay_clearing_fee = #{record.rfpayClearingFee,jdbcType=DECIMAL}");
        sql.SET("rfpay_actual_clearing_fee = #{record.rfpayActualClearingFee,jdbcType=BIGINT}");
        sql.SET("prv_uid = #{record.prvUid,jdbcType=BIGINT}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        
        ParkingOrderExample example = (ParkingOrderExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(ParkingOrder record) {
        SQL sql = new SQL();
        sql.UPDATE("parking_order");
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{communityId,jdbcType=INTEGER}");
        }
        
        if (record.getSerialNo() != null) {
            sql.SET("serial_no = #{serialNo,jdbcType=VARCHAR}");
        }
        
        if (record.getMobile() != null) {
            sql.SET("mobile = #{mobile,jdbcType=VARCHAR}");
        }
        
        if (record.getUid() != null) {
            sql.SET("uid = #{uid,jdbcType=BIGINT}");
        }
        
        if (record.getCarPlateNo() != null) {
            sql.SET("car_plate_no = #{carPlateNo,jdbcType=VARCHAR}");
        }
        
        if (record.getCardNo() != null) {
            sql.SET("card_no = #{cardNo,jdbcType=VARCHAR}");
        }
        
        if (record.getOrderType() != null) {
            sql.SET("order_type = #{orderType,jdbcType=INTEGER}");
        }
        
        if (record.getOrderStatus() != null) {
            sql.SET("order_status = #{orderStatus,jdbcType=INTEGER}");
        }
        
        if (record.getPayStatus() != null) {
            sql.SET("pay_status = #{payStatus,jdbcType=INTEGER}");
        }
        
        if (record.getPayType() != null) {
            sql.SET("pay_type = #{payType,jdbcType=VARCHAR}");
        }
        
        if (record.getPayTime() != null) {
            sql.SET("pay_time = #{payTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPayAmount() != null) {
            sql.SET("pay_amount = #{payAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getPayPrice() != null) {
            sql.SET("pay_price = #{payPrice,jdbcType=VARCHAR}");
        }
        
        if (record.getPaySrc() != null) {
            sql.SET("pay_src = #{paySrc,jdbcType=INTEGER}");
        }
        
        if (record.getWxOpenid() != null) {
            sql.SET("wx_openid = #{wxOpenid,jdbcType=VARCHAR}");
        }
        
        if (record.getDuration() != null) {
            sql.SET("duration = #{duration,jdbcType=VARCHAR}");
        }
        
        if (record.getFreeDuration() != null) {
            sql.SET("free_duration = #{freeDuration,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            sql.SET("address = #{address,jdbcType=VARCHAR}");
        }
        
        if (record.getEnterTime() != null) {
            sql.SET("enter_time = #{enterTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCancelTime() != null) {
            sql.SET("cancel_time = #{cancelTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getMonthlyPayNum() != null) {
            sql.SET("monthly_pay_num = #{monthlyPayNum,jdbcType=INTEGER}");
        }
        
        if (record.getMonthlyPayStartTime() != null) {
            sql.SET("monthly_pay_start_time = #{monthlyPayStartTime,jdbcType=VARCHAR}");
        }
        
        if (record.getMonthlyPayEndTime() != null) {
            sql.SET("monthly_pay_end_time = #{monthlyPayEndTime,jdbcType=VARCHAR}");
        }
        
        if (record.getRfpayBillId() != null) {
            sql.SET("rfpay_bill_id = #{rfpayBillId,jdbcType=VARCHAR}");
        }
        
        if (record.getRfpayTradeNo() != null) {
            sql.SET("rfpay_trade_no = #{rfpayTradeNo,jdbcType=VARCHAR}");
        }
        
        if (record.getRfpayBody() != null) {
            sql.SET("rfpay_body = #{rfpayBody,jdbcType=VARCHAR}");
        }
        
        if (record.getRfpayType() != null) {
            sql.SET("rfpay_type = #{rfpayType,jdbcType=VARCHAR}");
        }
        
        if (record.getRfpayCreateTime() != null) {
            sql.SET("rfpay_create_time = #{rfpayCreateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRfpayCloseTime() != null) {
            sql.SET("rfpay_close_time = #{rfpayCloseTime,jdbcType=TIMESTAMP}");
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
        
        if (record.getPrvUid() != null) {
            sql.SET("prv_uid = #{prvUid,jdbcType=BIGINT}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, ParkingOrderExample example, boolean includeExamplePhrase) {
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