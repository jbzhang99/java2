package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.BizApplyOrder;
import com.rfchina.community.persistence.model.BizApplyOrderExample.Criteria;
import com.rfchina.community.persistence.model.BizApplyOrderExample.Criterion;
import com.rfchina.community.persistence.model.BizApplyOrderExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class BizApplyOrderSqlProvider {

    public String countByExample(BizApplyOrderExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("biz_apply_order");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(BizApplyOrderExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("biz_apply_order");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(BizApplyOrder record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("biz_apply_order");
        
        if (record.getTradeNo() != null) {
            sql.VALUES("trade_no", "#{tradeNo,jdbcType=VARCHAR}");
        }
        
        if (record.getTskCode() != null) {
            sql.VALUES("tsk_code", "#{tskCode,jdbcType=VARCHAR}");
        }
        
        if (record.getCommunityId() != null) {
            sql.VALUES("community_id", "#{communityId,jdbcType=INTEGER}");
        }
        
        if (record.getMasterId() != null) {
            sql.VALUES("master_id", "#{masterId,jdbcType=BIGINT}");
        }
        
        if (record.getMasterChildId() != null) {
            sql.VALUES("master_child_id", "#{masterChildId,jdbcType=BIGINT}");
        }
        
        if (record.getUid() != null) {
            sql.VALUES("uid", "#{uid,jdbcType=BIGINT}");
        }
        
        if (record.getContact() != null) {
            sql.VALUES("contact", "#{contact,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            sql.VALUES("phone", "#{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getTitle() != null) {
            sql.VALUES("title", "#{title,jdbcType=VARCHAR}");
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
        
        if (record.getPayPrice() != null) {
            sql.VALUES("pay_price", "#{payPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getPayAmount() != null) {
            sql.VALUES("pay_amount", "#{payAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getPayTime() != null) {
            sql.VALUES("pay_time", "#{payTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAttachment() != null) {
            sql.VALUES("attachment", "#{attachment,jdbcType=VARCHAR}");
        }
        
        if (record.getApplyTime() != null) {
            sql.VALUES("apply_time", "#{applyTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getApplyNum() != null) {
            sql.VALUES("apply_num", "#{applyNum,jdbcType=INTEGER}");
        }
        
        if (record.getApplyAddress() != null) {
            sql.VALUES("apply_address", "#{applyAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getObtainAddress() != null) {
            sql.VALUES("obtain_address", "#{obtainAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getObtainTime() != null) {
            sql.VALUES("obtain_time", "#{obtainTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAuditStatus() != null) {
            sql.VALUES("audit_status", "#{auditStatus,jdbcType=INTEGER}");
        }
        
        if (record.getAuditReason() != null) {
            sql.VALUES("audit_reason", "#{auditReason,jdbcType=VARCHAR}");
        }
        
        if (record.getAuditTime() != null) {
            sql.VALUES("audit_time", "#{auditTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getValidationCode() != null) {
            sql.VALUES("validation_code", "#{validationCode,jdbcType=VARCHAR}");
        }
        
        if (record.getIssueTskCode() != null) {
            sql.VALUES("issue_tsk_code", "#{issueTskCode,jdbcType=VARCHAR}");
        }
        
        if (record.getIssueBody() != null) {
            sql.VALUES("issue_body", "#{issueBody,jdbcType=VARCHAR}");
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
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(BizApplyOrderExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("trade_no");
        sql.SELECT("tsk_code");
        sql.SELECT("community_id");
        sql.SELECT("master_id");
        sql.SELECT("master_child_id");
        sql.SELECT("uid");
        sql.SELECT("contact");
        sql.SELECT("phone");
        sql.SELECT("title");
        sql.SELECT("order_type");
        sql.SELECT("order_status");
        sql.SELECT("pay_status");
        sql.SELECT("pay_type");
        sql.SELECT("pay_price");
        sql.SELECT("pay_amount");
        sql.SELECT("pay_time");
        sql.SELECT("attachment");
        sql.SELECT("apply_time");
        sql.SELECT("apply_num");
        sql.SELECT("apply_address");
        sql.SELECT("obtain_address");
        sql.SELECT("obtain_time");
        sql.SELECT("audit_status");
        sql.SELECT("audit_reason");
        sql.SELECT("audit_time");
        sql.SELECT("validation_code");
        sql.SELECT("issue_tsk_code");
        sql.SELECT("issue_body");
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
        sql.SELECT("create_time");
        sql.SELECT("update_time");
        sql.FROM("biz_apply_order");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        BizApplyOrder record = (BizApplyOrder) parameter.get("record");
        BizApplyOrderExample example = (BizApplyOrderExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("biz_apply_order");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getTradeNo() != null) {
            sql.SET("trade_no = #{record.tradeNo,jdbcType=VARCHAR}");
        }
        
        if (record.getTskCode() != null) {
            sql.SET("tsk_code = #{record.tskCode,jdbcType=VARCHAR}");
        }
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        }
        
        if (record.getMasterId() != null) {
            sql.SET("master_id = #{record.masterId,jdbcType=BIGINT}");
        }
        
        if (record.getMasterChildId() != null) {
            sql.SET("master_child_id = #{record.masterChildId,jdbcType=BIGINT}");
        }
        
        if (record.getUid() != null) {
            sql.SET("uid = #{record.uid,jdbcType=BIGINT}");
        }
        
        if (record.getContact() != null) {
            sql.SET("contact = #{record.contact,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            sql.SET("phone = #{record.phone,jdbcType=VARCHAR}");
        }
        
        if (record.getTitle() != null) {
            sql.SET("title = #{record.title,jdbcType=VARCHAR}");
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
        
        if (record.getPayPrice() != null) {
            sql.SET("pay_price = #{record.payPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getPayAmount() != null) {
            sql.SET("pay_amount = #{record.payAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getPayTime() != null) {
            sql.SET("pay_time = #{record.payTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAttachment() != null) {
            sql.SET("attachment = #{record.attachment,jdbcType=VARCHAR}");
        }
        
        if (record.getApplyTime() != null) {
            sql.SET("apply_time = #{record.applyTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getApplyNum() != null) {
            sql.SET("apply_num = #{record.applyNum,jdbcType=INTEGER}");
        }
        
        if (record.getApplyAddress() != null) {
            sql.SET("apply_address = #{record.applyAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getObtainAddress() != null) {
            sql.SET("obtain_address = #{record.obtainAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getObtainTime() != null) {
            sql.SET("obtain_time = #{record.obtainTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAuditStatus() != null) {
            sql.SET("audit_status = #{record.auditStatus,jdbcType=INTEGER}");
        }
        
        if (record.getAuditReason() != null) {
            sql.SET("audit_reason = #{record.auditReason,jdbcType=VARCHAR}");
        }
        
        if (record.getAuditTime() != null) {
            sql.SET("audit_time = #{record.auditTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getValidationCode() != null) {
            sql.SET("validation_code = #{record.validationCode,jdbcType=VARCHAR}");
        }
        
        if (record.getIssueTskCode() != null) {
            sql.SET("issue_tsk_code = #{record.issueTskCode,jdbcType=VARCHAR}");
        }
        
        if (record.getIssueBody() != null) {
            sql.SET("issue_body = #{record.issueBody,jdbcType=VARCHAR}");
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
        sql.UPDATE("biz_apply_order");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("trade_no = #{record.tradeNo,jdbcType=VARCHAR}");
        sql.SET("tsk_code = #{record.tskCode,jdbcType=VARCHAR}");
        sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        sql.SET("master_id = #{record.masterId,jdbcType=BIGINT}");
        sql.SET("master_child_id = #{record.masterChildId,jdbcType=BIGINT}");
        sql.SET("uid = #{record.uid,jdbcType=BIGINT}");
        sql.SET("contact = #{record.contact,jdbcType=VARCHAR}");
        sql.SET("phone = #{record.phone,jdbcType=VARCHAR}");
        sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        sql.SET("order_type = #{record.orderType,jdbcType=INTEGER}");
        sql.SET("order_status = #{record.orderStatus,jdbcType=INTEGER}");
        sql.SET("pay_status = #{record.payStatus,jdbcType=INTEGER}");
        sql.SET("pay_type = #{record.payType,jdbcType=VARCHAR}");
        sql.SET("pay_price = #{record.payPrice,jdbcType=DECIMAL}");
        sql.SET("pay_amount = #{record.payAmount,jdbcType=DECIMAL}");
        sql.SET("pay_time = #{record.payTime,jdbcType=TIMESTAMP}");
        sql.SET("attachment = #{record.attachment,jdbcType=VARCHAR}");
        sql.SET("apply_time = #{record.applyTime,jdbcType=TIMESTAMP}");
        sql.SET("apply_num = #{record.applyNum,jdbcType=INTEGER}");
        sql.SET("apply_address = #{record.applyAddress,jdbcType=VARCHAR}");
        sql.SET("obtain_address = #{record.obtainAddress,jdbcType=VARCHAR}");
        sql.SET("obtain_time = #{record.obtainTime,jdbcType=TIMESTAMP}");
        sql.SET("audit_status = #{record.auditStatus,jdbcType=INTEGER}");
        sql.SET("audit_reason = #{record.auditReason,jdbcType=VARCHAR}");
        sql.SET("audit_time = #{record.auditTime,jdbcType=TIMESTAMP}");
        sql.SET("validation_code = #{record.validationCode,jdbcType=VARCHAR}");
        sql.SET("issue_tsk_code = #{record.issueTskCode,jdbcType=VARCHAR}");
        sql.SET("issue_body = #{record.issueBody,jdbcType=VARCHAR}");
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
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        
        BizApplyOrderExample example = (BizApplyOrderExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(BizApplyOrder record) {
        SQL sql = new SQL();
        sql.UPDATE("biz_apply_order");
        
        if (record.getTradeNo() != null) {
            sql.SET("trade_no = #{tradeNo,jdbcType=VARCHAR}");
        }
        
        if (record.getTskCode() != null) {
            sql.SET("tsk_code = #{tskCode,jdbcType=VARCHAR}");
        }
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{communityId,jdbcType=INTEGER}");
        }
        
        if (record.getMasterId() != null) {
            sql.SET("master_id = #{masterId,jdbcType=BIGINT}");
        }
        
        if (record.getMasterChildId() != null) {
            sql.SET("master_child_id = #{masterChildId,jdbcType=BIGINT}");
        }
        
        if (record.getUid() != null) {
            sql.SET("uid = #{uid,jdbcType=BIGINT}");
        }
        
        if (record.getContact() != null) {
            sql.SET("contact = #{contact,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            sql.SET("phone = #{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getTitle() != null) {
            sql.SET("title = #{title,jdbcType=VARCHAR}");
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
        
        if (record.getPayPrice() != null) {
            sql.SET("pay_price = #{payPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getPayAmount() != null) {
            sql.SET("pay_amount = #{payAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getPayTime() != null) {
            sql.SET("pay_time = #{payTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAttachment() != null) {
            sql.SET("attachment = #{attachment,jdbcType=VARCHAR}");
        }
        
        if (record.getApplyTime() != null) {
            sql.SET("apply_time = #{applyTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getApplyNum() != null) {
            sql.SET("apply_num = #{applyNum,jdbcType=INTEGER}");
        }
        
        if (record.getApplyAddress() != null) {
            sql.SET("apply_address = #{applyAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getObtainAddress() != null) {
            sql.SET("obtain_address = #{obtainAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getObtainTime() != null) {
            sql.SET("obtain_time = #{obtainTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAuditStatus() != null) {
            sql.SET("audit_status = #{auditStatus,jdbcType=INTEGER}");
        }
        
        if (record.getAuditReason() != null) {
            sql.SET("audit_reason = #{auditReason,jdbcType=VARCHAR}");
        }
        
        if (record.getAuditTime() != null) {
            sql.SET("audit_time = #{auditTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getValidationCode() != null) {
            sql.SET("validation_code = #{validationCode,jdbcType=VARCHAR}");
        }
        
        if (record.getIssueTskCode() != null) {
            sql.SET("issue_tsk_code = #{issueTskCode,jdbcType=VARCHAR}");
        }
        
        if (record.getIssueBody() != null) {
            sql.SET("issue_body = #{issueBody,jdbcType=VARCHAR}");
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
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, BizApplyOrderExample example, boolean includeExamplePhrase) {
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