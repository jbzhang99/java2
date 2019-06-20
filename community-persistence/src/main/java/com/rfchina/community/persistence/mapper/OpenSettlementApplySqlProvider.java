package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenSettlementApply;
import com.rfchina.community.persistence.model.OpenSettlementApplyExample.Criteria;
import com.rfchina.community.persistence.model.OpenSettlementApplyExample.Criterion;
import com.rfchina.community.persistence.model.OpenSettlementApplyExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class OpenSettlementApplySqlProvider {

    public String countByExample(OpenSettlementApplyExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("open_settlement_apply");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(OpenSettlementApplyExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("open_settlement_apply");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(OpenSettlementApply record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("open_settlement_apply");
        
        if (record.getServiceId() != null) {
            sql.VALUES("service_id", "#{serviceId,jdbcType=INTEGER}");
        }
        
        if (record.getSettlementId() != null) {
            sql.VALUES("settlement_id", "#{settlementId,jdbcType=VARCHAR}");
        }
        
        if (record.getOrderAmountCount() != null) {
            sql.VALUES("order_amount_count", "#{orderAmountCount,jdbcType=DECIMAL}");
        }
        
        if (record.getPlatformPoundageAmount() != null) {
            sql.VALUES("platform_poundage_amount", "#{platformPoundageAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getPlatformCommissionAmount() != null) {
            sql.VALUES("platform_commission_amount", "#{platformCommissionAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getPlatformThinkAmount() != null) {
            sql.VALUES("platform_think_amount", "#{platformThinkAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getSettlementAmountCount() != null) {
            sql.VALUES("settlement_amount_count", "#{settlementAmountCount,jdbcType=DECIMAL}");
        }
        
        if (record.getPaidSettlementAmount() != null) {
            sql.VALUES("paid_settlement_amount", "#{paidSettlementAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getRefundMoney() != null) {
            sql.VALUES("refund_money", "#{refundMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAuditTime() != null) {
            sql.VALUES("audit_time", "#{auditTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getOrderCount() != null) {
            sql.VALUES("order_count", "#{orderCount,jdbcType=INTEGER}");
        }
        
        if (record.getInvoiceTitle() != null) {
            sql.VALUES("invoice_title", "#{invoiceTitle,jdbcType=VARCHAR}");
        }
        
        if (record.getContactsName() != null) {
            sql.VALUES("contacts_name", "#{contactsName,jdbcType=VARCHAR}");
        }
        
        if (record.getContactsPhone() != null) {
            sql.VALUES("contacts_phone", "#{contactsPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getMailingAddress() != null) {
            sql.VALUES("mailing_address", "#{mailingAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getInvoiceStatus() != null) {
            sql.VALUES("invoice_status", "#{invoiceStatus,jdbcType=INTEGER}");
        }
        
        if (record.getSettlementStartTime() != null) {
            sql.VALUES("settlement_start_time", "#{settlementStartTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getSettlementEndTime() != null) {
            sql.VALUES("settlement_end_time", "#{settlementEndTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAuditComment() != null) {
            sql.VALUES("audit_comment", "#{auditComment,jdbcType=VARCHAR}");
        }
        
        if (record.getMerchantId() != null) {
            sql.VALUES("merchant_id", "#{merchantId,jdbcType=BIGINT}");
        }
        
        if (record.getInvoiceType() != null) {
            sql.VALUES("invoice_type", "#{invoiceType,jdbcType=INTEGER}");
        }
        
        if (record.getCompanyName() != null) {
            sql.VALUES("company_name", "#{companyName,jdbcType=VARCHAR}");
        }
        
        if (record.getTaxpayerCode() != null) {
            sql.VALUES("taxpayer_code", "#{taxpayerCode,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyAddress() != null) {
            sql.VALUES("company_address", "#{companyAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyPhone() != null) {
            sql.VALUES("company_phone", "#{companyPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getBankName() != null) {
            sql.VALUES("bank_name", "#{bankName,jdbcType=VARCHAR}");
        }
        
        if (record.getBankAccount() != null) {
            sql.VALUES("bank_account", "#{bankAccount,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.VALUES("type", "#{type,jdbcType=INTEGER}");
        }
        
        if (record.getCommunityId() != null) {
            sql.VALUES("community_id", "#{communityId,jdbcType=INTEGER}");
        }
        
        if (record.getPlatformSettlementId() != null) {
            sql.VALUES("platform_settlement_id", "#{platformSettlementId,jdbcType=VARCHAR}");
        }
        
        if (record.getMchId() != null) {
            sql.VALUES("mch_id", "#{mchId,jdbcType=VARCHAR}");
        }
        
        if (record.getAccountId() != null) {
            sql.VALUES("account_id", "#{accountId,jdbcType=VARCHAR}");
        }
        
        if (record.getTitle() != null) {
            sql.VALUES("title", "#{title,jdbcType=VARCHAR}");
        }
        
        if (record.getPfStatus() != null) {
            sql.VALUES("pf_status", "#{pfStatus,jdbcType=INTEGER}");
        }
        
        if (record.getAuditPhone() != null) {
            sql.VALUES("audit_phone", "#{auditPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getAuditName() != null) {
            sql.VALUES("audit_name", "#{auditName,jdbcType=VARCHAR}");
        }
        
        if (record.getSettleSuccessTime() != null) {
            sql.VALUES("settle_success_time", "#{settleSuccessTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(OpenSettlementApplyExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("service_id");
        sql.SELECT("settlement_id");
        sql.SELECT("order_amount_count");
        sql.SELECT("platform_poundage_amount");
        sql.SELECT("platform_commission_amount");
        sql.SELECT("platform_think_amount");
        sql.SELECT("settlement_amount_count");
        sql.SELECT("paid_settlement_amount");
        sql.SELECT("refund_money");
        sql.SELECT("status");
        sql.SELECT("create_time");
        sql.SELECT("audit_time");
        sql.SELECT("order_count");
        sql.SELECT("invoice_title");
        sql.SELECT("contacts_name");
        sql.SELECT("contacts_phone");
        sql.SELECT("mailing_address");
        sql.SELECT("invoice_status");
        sql.SELECT("settlement_start_time");
        sql.SELECT("settlement_end_time");
        sql.SELECT("audit_comment");
        sql.SELECT("merchant_id");
        sql.SELECT("invoice_type");
        sql.SELECT("company_name");
        sql.SELECT("taxpayer_code");
        sql.SELECT("company_address");
        sql.SELECT("company_phone");
        sql.SELECT("bank_name");
        sql.SELECT("bank_account");
        sql.SELECT("type");
        sql.SELECT("community_id");
        sql.SELECT("platform_settlement_id");
        sql.SELECT("mch_id");
        sql.SELECT("account_id");
        sql.SELECT("title");
        sql.SELECT("pf_status");
        sql.SELECT("audit_phone");
        sql.SELECT("audit_name");
        sql.SELECT("settle_success_time");
        sql.FROM("open_settlement_apply");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        OpenSettlementApply record = (OpenSettlementApply) parameter.get("record");
        OpenSettlementApplyExample example = (OpenSettlementApplyExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("open_settlement_apply");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getServiceId() != null) {
            sql.SET("service_id = #{record.serviceId,jdbcType=INTEGER}");
        }
        
        if (record.getSettlementId() != null) {
            sql.SET("settlement_id = #{record.settlementId,jdbcType=VARCHAR}");
        }
        
        if (record.getOrderAmountCount() != null) {
            sql.SET("order_amount_count = #{record.orderAmountCount,jdbcType=DECIMAL}");
        }
        
        if (record.getPlatformPoundageAmount() != null) {
            sql.SET("platform_poundage_amount = #{record.platformPoundageAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getPlatformCommissionAmount() != null) {
            sql.SET("platform_commission_amount = #{record.platformCommissionAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getPlatformThinkAmount() != null) {
            sql.SET("platform_think_amount = #{record.platformThinkAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getSettlementAmountCount() != null) {
            sql.SET("settlement_amount_count = #{record.settlementAmountCount,jdbcType=DECIMAL}");
        }
        
        if (record.getPaidSettlementAmount() != null) {
            sql.SET("paid_settlement_amount = #{record.paidSettlementAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getRefundMoney() != null) {
            sql.SET("refund_money = #{record.refundMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAuditTime() != null) {
            sql.SET("audit_time = #{record.auditTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getOrderCount() != null) {
            sql.SET("order_count = #{record.orderCount,jdbcType=INTEGER}");
        }
        
        if (record.getInvoiceTitle() != null) {
            sql.SET("invoice_title = #{record.invoiceTitle,jdbcType=VARCHAR}");
        }
        
        if (record.getContactsName() != null) {
            sql.SET("contacts_name = #{record.contactsName,jdbcType=VARCHAR}");
        }
        
        if (record.getContactsPhone() != null) {
            sql.SET("contacts_phone = #{record.contactsPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getMailingAddress() != null) {
            sql.SET("mailing_address = #{record.mailingAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getInvoiceStatus() != null) {
            sql.SET("invoice_status = #{record.invoiceStatus,jdbcType=INTEGER}");
        }
        
        if (record.getSettlementStartTime() != null) {
            sql.SET("settlement_start_time = #{record.settlementStartTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getSettlementEndTime() != null) {
            sql.SET("settlement_end_time = #{record.settlementEndTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAuditComment() != null) {
            sql.SET("audit_comment = #{record.auditComment,jdbcType=VARCHAR}");
        }
        
        if (record.getMerchantId() != null) {
            sql.SET("merchant_id = #{record.merchantId,jdbcType=BIGINT}");
        }
        
        if (record.getInvoiceType() != null) {
            sql.SET("invoice_type = #{record.invoiceType,jdbcType=INTEGER}");
        }
        
        if (record.getCompanyName() != null) {
            sql.SET("company_name = #{record.companyName,jdbcType=VARCHAR}");
        }
        
        if (record.getTaxpayerCode() != null) {
            sql.SET("taxpayer_code = #{record.taxpayerCode,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyAddress() != null) {
            sql.SET("company_address = #{record.companyAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyPhone() != null) {
            sql.SET("company_phone = #{record.companyPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getBankName() != null) {
            sql.SET("bank_name = #{record.bankName,jdbcType=VARCHAR}");
        }
        
        if (record.getBankAccount() != null) {
            sql.SET("bank_account = #{record.bankAccount,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{record.type,jdbcType=INTEGER}");
        }
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        }
        
        if (record.getPlatformSettlementId() != null) {
            sql.SET("platform_settlement_id = #{record.platformSettlementId,jdbcType=VARCHAR}");
        }
        
        if (record.getMchId() != null) {
            sql.SET("mch_id = #{record.mchId,jdbcType=VARCHAR}");
        }
        
        if (record.getAccountId() != null) {
            sql.SET("account_id = #{record.accountId,jdbcType=VARCHAR}");
        }
        
        if (record.getTitle() != null) {
            sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        }
        
        if (record.getPfStatus() != null) {
            sql.SET("pf_status = #{record.pfStatus,jdbcType=INTEGER}");
        }
        
        if (record.getAuditPhone() != null) {
            sql.SET("audit_phone = #{record.auditPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getAuditName() != null) {
            sql.SET("audit_name = #{record.auditName,jdbcType=VARCHAR}");
        }
        
        if (record.getSettleSuccessTime() != null) {
            sql.SET("settle_success_time = #{record.settleSuccessTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("open_settlement_apply");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("service_id = #{record.serviceId,jdbcType=INTEGER}");
        sql.SET("settlement_id = #{record.settlementId,jdbcType=VARCHAR}");
        sql.SET("order_amount_count = #{record.orderAmountCount,jdbcType=DECIMAL}");
        sql.SET("platform_poundage_amount = #{record.platformPoundageAmount,jdbcType=DECIMAL}");
        sql.SET("platform_commission_amount = #{record.platformCommissionAmount,jdbcType=DECIMAL}");
        sql.SET("platform_think_amount = #{record.platformThinkAmount,jdbcType=DECIMAL}");
        sql.SET("settlement_amount_count = #{record.settlementAmountCount,jdbcType=DECIMAL}");
        sql.SET("paid_settlement_amount = #{record.paidSettlementAmount,jdbcType=DECIMAL}");
        sql.SET("refund_money = #{record.refundMoney,jdbcType=DECIMAL}");
        sql.SET("status = #{record.status,jdbcType=INTEGER}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("audit_time = #{record.auditTime,jdbcType=TIMESTAMP}");
        sql.SET("order_count = #{record.orderCount,jdbcType=INTEGER}");
        sql.SET("invoice_title = #{record.invoiceTitle,jdbcType=VARCHAR}");
        sql.SET("contacts_name = #{record.contactsName,jdbcType=VARCHAR}");
        sql.SET("contacts_phone = #{record.contactsPhone,jdbcType=VARCHAR}");
        sql.SET("mailing_address = #{record.mailingAddress,jdbcType=VARCHAR}");
        sql.SET("invoice_status = #{record.invoiceStatus,jdbcType=INTEGER}");
        sql.SET("settlement_start_time = #{record.settlementStartTime,jdbcType=TIMESTAMP}");
        sql.SET("settlement_end_time = #{record.settlementEndTime,jdbcType=TIMESTAMP}");
        sql.SET("audit_comment = #{record.auditComment,jdbcType=VARCHAR}");
        sql.SET("merchant_id = #{record.merchantId,jdbcType=BIGINT}");
        sql.SET("invoice_type = #{record.invoiceType,jdbcType=INTEGER}");
        sql.SET("company_name = #{record.companyName,jdbcType=VARCHAR}");
        sql.SET("taxpayer_code = #{record.taxpayerCode,jdbcType=VARCHAR}");
        sql.SET("company_address = #{record.companyAddress,jdbcType=VARCHAR}");
        sql.SET("company_phone = #{record.companyPhone,jdbcType=VARCHAR}");
        sql.SET("bank_name = #{record.bankName,jdbcType=VARCHAR}");
        sql.SET("bank_account = #{record.bankAccount,jdbcType=VARCHAR}");
        sql.SET("type = #{record.type,jdbcType=INTEGER}");
        sql.SET("community_id = #{record.communityId,jdbcType=INTEGER}");
        sql.SET("platform_settlement_id = #{record.platformSettlementId,jdbcType=VARCHAR}");
        sql.SET("mch_id = #{record.mchId,jdbcType=VARCHAR}");
        sql.SET("account_id = #{record.accountId,jdbcType=VARCHAR}");
        sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        sql.SET("pf_status = #{record.pfStatus,jdbcType=INTEGER}");
        sql.SET("audit_phone = #{record.auditPhone,jdbcType=VARCHAR}");
        sql.SET("audit_name = #{record.auditName,jdbcType=VARCHAR}");
        sql.SET("settle_success_time = #{record.settleSuccessTime,jdbcType=TIMESTAMP}");
        
        OpenSettlementApplyExample example = (OpenSettlementApplyExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(OpenSettlementApply record) {
        SQL sql = new SQL();
        sql.UPDATE("open_settlement_apply");
        
        if (record.getServiceId() != null) {
            sql.SET("service_id = #{serviceId,jdbcType=INTEGER}");
        }
        
        if (record.getSettlementId() != null) {
            sql.SET("settlement_id = #{settlementId,jdbcType=VARCHAR}");
        }
        
        if (record.getOrderAmountCount() != null) {
            sql.SET("order_amount_count = #{orderAmountCount,jdbcType=DECIMAL}");
        }
        
        if (record.getPlatformPoundageAmount() != null) {
            sql.SET("platform_poundage_amount = #{platformPoundageAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getPlatformCommissionAmount() != null) {
            sql.SET("platform_commission_amount = #{platformCommissionAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getPlatformThinkAmount() != null) {
            sql.SET("platform_think_amount = #{platformThinkAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getSettlementAmountCount() != null) {
            sql.SET("settlement_amount_count = #{settlementAmountCount,jdbcType=DECIMAL}");
        }
        
        if (record.getPaidSettlementAmount() != null) {
            sql.SET("paid_settlement_amount = #{paidSettlementAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getRefundMoney() != null) {
            sql.SET("refund_money = #{refundMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAuditTime() != null) {
            sql.SET("audit_time = #{auditTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getOrderCount() != null) {
            sql.SET("order_count = #{orderCount,jdbcType=INTEGER}");
        }
        
        if (record.getInvoiceTitle() != null) {
            sql.SET("invoice_title = #{invoiceTitle,jdbcType=VARCHAR}");
        }
        
        if (record.getContactsName() != null) {
            sql.SET("contacts_name = #{contactsName,jdbcType=VARCHAR}");
        }
        
        if (record.getContactsPhone() != null) {
            sql.SET("contacts_phone = #{contactsPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getMailingAddress() != null) {
            sql.SET("mailing_address = #{mailingAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getInvoiceStatus() != null) {
            sql.SET("invoice_status = #{invoiceStatus,jdbcType=INTEGER}");
        }
        
        if (record.getSettlementStartTime() != null) {
            sql.SET("settlement_start_time = #{settlementStartTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getSettlementEndTime() != null) {
            sql.SET("settlement_end_time = #{settlementEndTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAuditComment() != null) {
            sql.SET("audit_comment = #{auditComment,jdbcType=VARCHAR}");
        }
        
        if (record.getMerchantId() != null) {
            sql.SET("merchant_id = #{merchantId,jdbcType=BIGINT}");
        }
        
        if (record.getInvoiceType() != null) {
            sql.SET("invoice_type = #{invoiceType,jdbcType=INTEGER}");
        }
        
        if (record.getCompanyName() != null) {
            sql.SET("company_name = #{companyName,jdbcType=VARCHAR}");
        }
        
        if (record.getTaxpayerCode() != null) {
            sql.SET("taxpayer_code = #{taxpayerCode,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyAddress() != null) {
            sql.SET("company_address = #{companyAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyPhone() != null) {
            sql.SET("company_phone = #{companyPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getBankName() != null) {
            sql.SET("bank_name = #{bankName,jdbcType=VARCHAR}");
        }
        
        if (record.getBankAccount() != null) {
            sql.SET("bank_account = #{bankAccount,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{type,jdbcType=INTEGER}");
        }
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{communityId,jdbcType=INTEGER}");
        }
        
        if (record.getPlatformSettlementId() != null) {
            sql.SET("platform_settlement_id = #{platformSettlementId,jdbcType=VARCHAR}");
        }
        
        if (record.getMchId() != null) {
            sql.SET("mch_id = #{mchId,jdbcType=VARCHAR}");
        }
        
        if (record.getAccountId() != null) {
            sql.SET("account_id = #{accountId,jdbcType=VARCHAR}");
        }
        
        if (record.getTitle() != null) {
            sql.SET("title = #{title,jdbcType=VARCHAR}");
        }
        
        if (record.getPfStatus() != null) {
            sql.SET("pf_status = #{pfStatus,jdbcType=INTEGER}");
        }
        
        if (record.getAuditPhone() != null) {
            sql.SET("audit_phone = #{auditPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getAuditName() != null) {
            sql.SET("audit_name = #{auditName,jdbcType=VARCHAR}");
        }
        
        if (record.getSettleSuccessTime() != null) {
            sql.SET("settle_success_time = #{settleSuccessTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, OpenSettlementApplyExample example, boolean includeExamplePhrase) {
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