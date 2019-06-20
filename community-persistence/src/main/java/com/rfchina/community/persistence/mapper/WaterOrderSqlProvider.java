package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.WaterOrder;
import com.rfchina.community.persistence.model.WaterOrderExample.Criteria;
import com.rfchina.community.persistence.model.WaterOrderExample.Criterion;
import com.rfchina.community.persistence.model.WaterOrderExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class WaterOrderSqlProvider {

    public String countByExample(WaterOrderExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("water_order");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(WaterOrderExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("water_order");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(WaterOrder record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("water_order");
        
        if (record.getCommunityId() != null) {
            sql.VALUES("community_id", "#{communityId,jdbcType=INTEGER}");
        }
        
        if (record.getSerialNo() != null) {
            sql.VALUES("serial_no", "#{serialNo,jdbcType=VARCHAR}");
        }
        
        if (record.getWaterBrandId() != null) {
            sql.VALUES("water_brand_id", "#{waterBrandId,jdbcType=BIGINT}");
        }
        
        if (record.getUid() != null) {
            sql.VALUES("uid", "#{uid,jdbcType=BIGINT}");
        }
        
        if (record.getRoomId() != null) {
            sql.VALUES("room_id", "#{roomId,jdbcType=BIGINT}");
        }
        
        if (record.getRoomOwner() != null) {
            sql.VALUES("room_owner", "#{roomOwner,jdbcType=VARCHAR}");
        }
        
        if (record.getMasterChildId() != null) {
            sql.VALUES("master_child_id", "#{masterChildId,jdbcType=BIGINT}");
        }
        
        if (record.getContact() != null) {
            sql.VALUES("contact", "#{contact,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            sql.VALUES("phone", "#{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getTel() != null) {
            sql.VALUES("tel", "#{tel,jdbcType=VARCHAR}");
        }
        
        if (record.getNum() != null) {
            sql.VALUES("num", "#{num,jdbcType=INTEGER}");
        }
        
        if (record.getOrderType() != null) {
            sql.VALUES("order_type", "#{orderType,jdbcType=INTEGER}");
        }
        
        if (record.getOrderStatus() != null) {
            sql.VALUES("order_status", "#{orderStatus,jdbcType=INTEGER}");
        }
        
        if (record.getOrderSrc() != null) {
            sql.VALUES("order_src", "#{orderSrc,jdbcType=INTEGER}");
        }
        
        if (record.getOrderTime() != null) {
            sql.VALUES("order_time", "#{orderTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPayType() != null) {
            sql.VALUES("pay_type", "#{payType,jdbcType=INTEGER}");
        }
        
        if (record.getPayStatus() != null) {
            sql.VALUES("pay_status", "#{payStatus,jdbcType=INTEGER}");
        }
        
        if (record.getPayTime() != null) {
            sql.VALUES("pay_time", "#{payTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPayBody() != null) {
            sql.VALUES("pay_body", "#{payBody,jdbcType=VARCHAR}");
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
        
        if (record.getWechatTradeNo() != null) {
            sql.VALUES("wechat_trade_no", "#{wechatTradeNo,jdbcType=VARCHAR}");
        }
        
        if (record.getAlipayTradeNo() != null) {
            sql.VALUES("alipay_trade_no", "#{alipayTradeNo,jdbcType=VARCHAR}");
        }
        
        if (record.getTotalFee() != null) {
            sql.VALUES("total_fee", "#{totalFee,jdbcType=DECIMAL}");
        }
        
        if (record.getTakeWater() != null) {
            sql.VALUES("take_water", "#{takeWater,jdbcType=INTEGER}");
        }
        
        if (record.getTakeWaterTime() != null) {
            sql.VALUES("take_water_time", "#{takeWaterTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getReceiptTicket() != null) {
            sql.VALUES("receipt_ticket", "#{receiptTicket,jdbcType=INTEGER}");
        }
        
        if (record.getReceiptTicketTime() != null) {
            sql.VALUES("receipt_ticket_time", "#{receiptTicketTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getIssueTicket() != null) {
            sql.VALUES("issue_ticket", "#{issueTicket,jdbcType=INTEGER}");
        }
        
        if (record.getIssueTicketTime() != null) {
            sql.VALUES("issue_ticket_time", "#{issueTicketTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStaffName() != null) {
            sql.VALUES("staff_name", "#{staffName,jdbcType=VARCHAR}");
        }
        
        if (record.getStaffPhone() != null) {
            sql.VALUES("staff_phone", "#{staffPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getOrderWater() != null) {
            sql.VALUES("order_water", "#{orderWater,jdbcType=INTEGER}");
        }
        
        if (record.getOrderWaterNum() != null) {
            sql.VALUES("order_water_num", "#{orderWaterNum,jdbcType=INTEGER}");
        }
        
        if (record.getRemark() != null) {
            sql.VALUES("remark", "#{remark,jdbcType=VARCHAR}");
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
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDeleteStatus() != null) {
            sql.VALUES("delete_status", "#{deleteStatus,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String selectByExample(WaterOrderExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("community_id");
        sql.SELECT("serial_no");
        sql.SELECT("water_brand_id");
        sql.SELECT("uid");
        sql.SELECT("room_id");
        sql.SELECT("room_owner");
        sql.SELECT("master_child_id");
        sql.SELECT("contact");
        sql.SELECT("phone");
        sql.SELECT("tel");
        sql.SELECT("num");
        sql.SELECT("order_type");
        sql.SELECT("order_status");
        sql.SELECT("order_src");
        sql.SELECT("order_time");
        sql.SELECT("pay_type");
        sql.SELECT("pay_status");
        sql.SELECT("pay_time");
        sql.SELECT("pay_body");
        sql.SELECT("bill_id");
        sql.SELECT("bill_close_time");
        sql.SELECT("bill_create_time");
        sql.SELECT("notify_id");
        sql.SELECT("wechat_trade_no");
        sql.SELECT("alipay_trade_no");
        sql.SELECT("total_fee");
        sql.SELECT("take_water");
        sql.SELECT("take_water_time");
        sql.SELECT("receipt_ticket");
        sql.SELECT("receipt_ticket_time");
        sql.SELECT("issue_ticket");
        sql.SELECT("issue_ticket_time");
        sql.SELECT("staff_name");
        sql.SELECT("staff_phone");
        sql.SELECT("order_water");
        sql.SELECT("order_water_num");
        sql.SELECT("remark");
        sql.SELECT("rfpay_account");
        sql.SELECT("rfpay_fee_rate");
        sql.SELECT("rfpay_clearing_fee");
        sql.SELECT("rfpay_actual_clearing_fee");
        sql.SELECT("create_time");
        sql.SELECT("update_time");
        sql.SELECT("delete_status");
        sql.FROM("water_order");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        WaterOrder record = (WaterOrder) parameter.get("record");
        WaterOrderExample example = (WaterOrderExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("water_order");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        }
        
        if (record.getSerialNo() != null) {
            sql.SET("serial_no = #{record.serialNo,jdbcType=VARCHAR}");
        }
        
        if (record.getWaterBrandId() != null) {
            sql.SET("water_brand_id = #{record.waterBrandId,jdbcType=BIGINT}");
        }
        
        if (record.getUid() != null) {
            sql.SET("uid = #{record.uid,jdbcType=BIGINT}");
        }
        
        if (record.getRoomId() != null) {
            sql.SET("room_id = #{record.roomId,jdbcType=BIGINT}");
        }
        
        if (record.getRoomOwner() != null) {
            sql.SET("room_owner = #{record.roomOwner,jdbcType=VARCHAR}");
        }
        
        if (record.getMasterChildId() != null) {
            sql.SET("master_child_id = #{record.masterChildId,jdbcType=BIGINT}");
        }
        
        if (record.getContact() != null) {
            sql.SET("contact = #{record.contact,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            sql.SET("phone = #{record.phone,jdbcType=VARCHAR}");
        }
        
        if (record.getTel() != null) {
            sql.SET("tel = #{record.tel,jdbcType=VARCHAR}");
        }
        
        if (record.getNum() != null) {
            sql.SET("num = #{record.num,jdbcType=INTEGER}");
        }
        
        if (record.getOrderType() != null) {
            sql.SET("order_type = #{record.orderType,jdbcType=INTEGER}");
        }
        
        if (record.getOrderStatus() != null) {
            sql.SET("order_status = #{record.orderStatus,jdbcType=INTEGER}");
        }
        
        if (record.getOrderSrc() != null) {
            sql.SET("order_src = #{record.orderSrc,jdbcType=INTEGER}");
        }
        
        if (record.getOrderTime() != null) {
            sql.SET("order_time = #{record.orderTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPayType() != null) {
            sql.SET("pay_type = #{record.payType,jdbcType=INTEGER}");
        }
        
        if (record.getPayStatus() != null) {
            sql.SET("pay_status = #{record.payStatus,jdbcType=INTEGER}");
        }
        
        if (record.getPayTime() != null) {
            sql.SET("pay_time = #{record.payTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPayBody() != null) {
            sql.SET("pay_body = #{record.payBody,jdbcType=VARCHAR}");
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
        
        if (record.getWechatTradeNo() != null) {
            sql.SET("wechat_trade_no = #{record.wechatTradeNo,jdbcType=VARCHAR}");
        }
        
        if (record.getAlipayTradeNo() != null) {
            sql.SET("alipay_trade_no = #{record.alipayTradeNo,jdbcType=VARCHAR}");
        }
        
        if (record.getTotalFee() != null) {
            sql.SET("total_fee = #{record.totalFee,jdbcType=DECIMAL}");
        }
        
        if (record.getTakeWater() != null) {
            sql.SET("take_water = #{record.takeWater,jdbcType=INTEGER}");
        }
        
        if (record.getTakeWaterTime() != null) {
            sql.SET("take_water_time = #{record.takeWaterTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getReceiptTicket() != null) {
            sql.SET("receipt_ticket = #{record.receiptTicket,jdbcType=INTEGER}");
        }
        
        if (record.getReceiptTicketTime() != null) {
            sql.SET("receipt_ticket_time = #{record.receiptTicketTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getIssueTicket() != null) {
            sql.SET("issue_ticket = #{record.issueTicket,jdbcType=INTEGER}");
        }
        
        if (record.getIssueTicketTime() != null) {
            sql.SET("issue_ticket_time = #{record.issueTicketTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStaffName() != null) {
            sql.SET("staff_name = #{record.staffName,jdbcType=VARCHAR}");
        }
        
        if (record.getStaffPhone() != null) {
            sql.SET("staff_phone = #{record.staffPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getOrderWater() != null) {
            sql.SET("order_water = #{record.orderWater,jdbcType=INTEGER}");
        }
        
        if (record.getOrderWaterNum() != null) {
            sql.SET("order_water_num = #{record.orderWaterNum,jdbcType=INTEGER}");
        }
        
        if (record.getRemark() != null) {
            sql.SET("remark = #{record.remark,jdbcType=VARCHAR}");
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
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDeleteStatus() != null) {
            sql.SET("delete_status = #{record.deleteStatus,jdbcType=INTEGER}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("water_order");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        sql.SET("serial_no = #{record.serialNo,jdbcType=VARCHAR}");
        sql.SET("water_brand_id = #{record.waterBrandId,jdbcType=BIGINT}");
        sql.SET("uid = #{record.uid,jdbcType=BIGINT}");
        sql.SET("room_id = #{record.roomId,jdbcType=BIGINT}");
        sql.SET("room_owner = #{record.roomOwner,jdbcType=VARCHAR}");
        sql.SET("master_child_id = #{record.masterChildId,jdbcType=BIGINT}");
        sql.SET("contact = #{record.contact,jdbcType=VARCHAR}");
        sql.SET("phone = #{record.phone,jdbcType=VARCHAR}");
        sql.SET("tel = #{record.tel,jdbcType=VARCHAR}");
        sql.SET("num = #{record.num,jdbcType=INTEGER}");
        sql.SET("order_type = #{record.orderType,jdbcType=INTEGER}");
        sql.SET("order_status = #{record.orderStatus,jdbcType=INTEGER}");
        sql.SET("order_src = #{record.orderSrc,jdbcType=INTEGER}");
        sql.SET("order_time = #{record.orderTime,jdbcType=TIMESTAMP}");
        sql.SET("pay_type = #{record.payType,jdbcType=INTEGER}");
        sql.SET("pay_status = #{record.payStatus,jdbcType=INTEGER}");
        sql.SET("pay_time = #{record.payTime,jdbcType=TIMESTAMP}");
        sql.SET("pay_body = #{record.payBody,jdbcType=VARCHAR}");
        sql.SET("bill_id = #{record.billId,jdbcType=VARCHAR}");
        sql.SET("bill_close_time = #{record.billCloseTime,jdbcType=TIMESTAMP}");
        sql.SET("bill_create_time = #{record.billCreateTime,jdbcType=TIMESTAMP}");
        sql.SET("notify_id = #{record.notifyId,jdbcType=VARCHAR}");
        sql.SET("wechat_trade_no = #{record.wechatTradeNo,jdbcType=VARCHAR}");
        sql.SET("alipay_trade_no = #{record.alipayTradeNo,jdbcType=VARCHAR}");
        sql.SET("total_fee = #{record.totalFee,jdbcType=DECIMAL}");
        sql.SET("take_water = #{record.takeWater,jdbcType=INTEGER}");
        sql.SET("take_water_time = #{record.takeWaterTime,jdbcType=TIMESTAMP}");
        sql.SET("receipt_ticket = #{record.receiptTicket,jdbcType=INTEGER}");
        sql.SET("receipt_ticket_time = #{record.receiptTicketTime,jdbcType=TIMESTAMP}");
        sql.SET("issue_ticket = #{record.issueTicket,jdbcType=INTEGER}");
        sql.SET("issue_ticket_time = #{record.issueTicketTime,jdbcType=TIMESTAMP}");
        sql.SET("staff_name = #{record.staffName,jdbcType=VARCHAR}");
        sql.SET("staff_phone = #{record.staffPhone,jdbcType=VARCHAR}");
        sql.SET("order_water = #{record.orderWater,jdbcType=INTEGER}");
        sql.SET("order_water_num = #{record.orderWaterNum,jdbcType=INTEGER}");
        sql.SET("remark = #{record.remark,jdbcType=VARCHAR}");
        sql.SET("rfpay_account = #{record.rfpayAccount,jdbcType=VARCHAR}");
        sql.SET("rfpay_fee_rate = #{record.rfpayFeeRate,jdbcType=DECIMAL}");
        sql.SET("rfpay_clearing_fee = #{record.rfpayClearingFee,jdbcType=DECIMAL}");
        sql.SET("rfpay_actual_clearing_fee = #{record.rfpayActualClearingFee,jdbcType=BIGINT}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        sql.SET("delete_status = #{record.deleteStatus,jdbcType=INTEGER}");
        
        WaterOrderExample example = (WaterOrderExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(WaterOrder record) {
        SQL sql = new SQL();
        sql.UPDATE("water_order");
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{communityId,jdbcType=INTEGER}");
        }
        
        if (record.getSerialNo() != null) {
            sql.SET("serial_no = #{serialNo,jdbcType=VARCHAR}");
        }
        
        if (record.getWaterBrandId() != null) {
            sql.SET("water_brand_id = #{waterBrandId,jdbcType=BIGINT}");
        }
        
        if (record.getUid() != null) {
            sql.SET("uid = #{uid,jdbcType=BIGINT}");
        }
        
        if (record.getRoomId() != null) {
            sql.SET("room_id = #{roomId,jdbcType=BIGINT}");
        }
        
        if (record.getRoomOwner() != null) {
            sql.SET("room_owner = #{roomOwner,jdbcType=VARCHAR}");
        }
        
        if (record.getMasterChildId() != null) {
            sql.SET("master_child_id = #{masterChildId,jdbcType=BIGINT}");
        }
        
        if (record.getContact() != null) {
            sql.SET("contact = #{contact,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            sql.SET("phone = #{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getTel() != null) {
            sql.SET("tel = #{tel,jdbcType=VARCHAR}");
        }
        
        if (record.getNum() != null) {
            sql.SET("num = #{num,jdbcType=INTEGER}");
        }
        
        if (record.getOrderType() != null) {
            sql.SET("order_type = #{orderType,jdbcType=INTEGER}");
        }
        
        if (record.getOrderStatus() != null) {
            sql.SET("order_status = #{orderStatus,jdbcType=INTEGER}");
        }
        
        if (record.getOrderSrc() != null) {
            sql.SET("order_src = #{orderSrc,jdbcType=INTEGER}");
        }
        
        if (record.getOrderTime() != null) {
            sql.SET("order_time = #{orderTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPayType() != null) {
            sql.SET("pay_type = #{payType,jdbcType=INTEGER}");
        }
        
        if (record.getPayStatus() != null) {
            sql.SET("pay_status = #{payStatus,jdbcType=INTEGER}");
        }
        
        if (record.getPayTime() != null) {
            sql.SET("pay_time = #{payTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPayBody() != null) {
            sql.SET("pay_body = #{payBody,jdbcType=VARCHAR}");
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
        
        if (record.getWechatTradeNo() != null) {
            sql.SET("wechat_trade_no = #{wechatTradeNo,jdbcType=VARCHAR}");
        }
        
        if (record.getAlipayTradeNo() != null) {
            sql.SET("alipay_trade_no = #{alipayTradeNo,jdbcType=VARCHAR}");
        }
        
        if (record.getTotalFee() != null) {
            sql.SET("total_fee = #{totalFee,jdbcType=DECIMAL}");
        }
        
        if (record.getTakeWater() != null) {
            sql.SET("take_water = #{takeWater,jdbcType=INTEGER}");
        }
        
        if (record.getTakeWaterTime() != null) {
            sql.SET("take_water_time = #{takeWaterTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getReceiptTicket() != null) {
            sql.SET("receipt_ticket = #{receiptTicket,jdbcType=INTEGER}");
        }
        
        if (record.getReceiptTicketTime() != null) {
            sql.SET("receipt_ticket_time = #{receiptTicketTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getIssueTicket() != null) {
            sql.SET("issue_ticket = #{issueTicket,jdbcType=INTEGER}");
        }
        
        if (record.getIssueTicketTime() != null) {
            sql.SET("issue_ticket_time = #{issueTicketTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStaffName() != null) {
            sql.SET("staff_name = #{staffName,jdbcType=VARCHAR}");
        }
        
        if (record.getStaffPhone() != null) {
            sql.SET("staff_phone = #{staffPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getOrderWater() != null) {
            sql.SET("order_water = #{orderWater,jdbcType=INTEGER}");
        }
        
        if (record.getOrderWaterNum() != null) {
            sql.SET("order_water_num = #{orderWaterNum,jdbcType=INTEGER}");
        }
        
        if (record.getRemark() != null) {
            sql.SET("remark = #{remark,jdbcType=VARCHAR}");
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
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDeleteStatus() != null) {
            sql.SET("delete_status = #{deleteStatus,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, WaterOrderExample example, boolean includeExamplePhrase) {
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