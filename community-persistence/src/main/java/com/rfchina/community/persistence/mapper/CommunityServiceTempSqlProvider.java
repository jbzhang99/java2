package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.CommunityServiceTemp;
import com.rfchina.community.persistence.model.CommunityServiceTempExample.Criteria;
import com.rfchina.community.persistence.model.CommunityServiceTempExample.Criterion;
import com.rfchina.community.persistence.model.CommunityServiceTempExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class CommunityServiceTempSqlProvider {

    public String countByExample(CommunityServiceTempExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("community_service_temp");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(CommunityServiceTempExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("community_service_temp");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(CommunityServiceTemp record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("community_service_temp");
        
        if (record.getTitle() != null) {
            sql.VALUES("title", "#{title,jdbcType=VARCHAR}");
        }
        
        if (record.getPng() != null) {
            sql.VALUES("png", "#{png,jdbcType=VARCHAR}");
        }
        
        if (record.getDisablePng() != null) {
            sql.VALUES("disable_png", "#{disablePng,jdbcType=VARCHAR}");
        }
        
        if (record.getReorder() != null) {
            sql.VALUES("reorder", "#{reorder,jdbcType=INTEGER}");
        }
        
        if (record.getClause() != null) {
            sql.VALUES("clause", "#{clause,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.VALUES("type", "#{type,jdbcType=INTEGER}");
        }
        
        if (record.getIsAccount() != null) {
            sql.VALUES("is_account", "#{isAccount,jdbcType=INTEGER}");
        }
        
        if (record.getLink() != null) {
            sql.VALUES("link", "#{link,jdbcType=VARCHAR}");
        }
        
        if (record.getProvideType() != null) {
            sql.VALUES("provide_type", "#{provideType,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getAppId() != null) {
            sql.VALUES("app_id", "#{appId,jdbcType=BIGINT}");
        }
        
        if (record.getDescription() != null) {
            sql.VALUES("description", "#{description,jdbcType=VARCHAR}");
        }
        
        if (record.getAuditComment() != null) {
            sql.VALUES("audit_comment", "#{auditComment,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAuditTime() != null) {
            sql.VALUES("audit_time", "#{auditTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCategoryId() != null) {
            sql.VALUES("category_id", "#{categoryId,jdbcType=INTEGER}");
        }
        
        if (record.getIsNeedHardware() != null) {
            sql.VALUES("is_need_hardware", "#{isNeedHardware,jdbcType=INTEGER}");
        }
        
        if (record.getTargetMonthTurnover() != null) {
            sql.VALUES("target_month_turnover", "#{targetMonthTurnover,jdbcType=DECIMAL}");
        }
        
        if (record.getPaidCautionMoney() != null) {
            sql.VALUES("paid_caution_money", "#{paidCautionMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getCautionMoneyStatus() != null) {
            sql.VALUES("caution_money_status", "#{cautionMoneyStatus,jdbcType=INTEGER}");
        }
        
        if (record.getGroundMode() != null) {
            sql.VALUES("ground_mode", "#{groundMode,jdbcType=INTEGER}");
        }
        
        if (record.getMerchantId() != null) {
            sql.VALUES("merchant_id", "#{merchantId,jdbcType=BIGINT}");
        }
        
        if (record.getAccountId() != null) {
            sql.VALUES("account_id", "#{accountId,jdbcType=VARCHAR}");
        }
        
        if (record.getAuditStatus() != null) {
            sql.VALUES("audit_status", "#{auditStatus,jdbcType=INTEGER}");
        }
        
        if (record.getClauseId() != null) {
            sql.VALUES("clause_id", "#{clauseId,jdbcType=INTEGER}");
        }
        
        if (record.getAppSecret() != null) {
            sql.VALUES("app_secret", "#{appSecret,jdbcType=VARCHAR}");
        }
        
        if (record.getReceivableCautionMoney() != null) {
            sql.VALUES("receivable_caution_money", "#{receivableCautionMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getRecommendLevel() != null) {
            sql.VALUES("recommend_level", "#{recommendLevel,jdbcType=DOUBLE}");
        }
        
        if (record.getCautionMoneyType() != null) {
            sql.VALUES("caution_money_type", "#{cautionMoneyType,jdbcType=INTEGER}");
        }
        
        if (record.getCautionMoneyPic() != null) {
            sql.VALUES("caution_money_pic", "#{cautionMoneyPic,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            sql.VALUES("remark", "#{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getCautionBillId() != null) {
            sql.VALUES("caution_bill_id", "#{cautionBillId,jdbcType=VARCHAR}");
        }
        
        if (record.getUserRange() != null) {
            sql.VALUES("user_range", "#{userRange,jdbcType=INTEGER}");
        }
        
        if (record.getGroundAuditStatus() != null) {
            sql.VALUES("ground_audit_status", "#{groundAuditStatus,jdbcType=INTEGER}");
        }
        
        if (record.getShot() != null) {
            sql.VALUES("shot", "#{shot,jdbcType=VARCHAR}");
        }
        
        if (record.getAccountReceivableProject() != null) {
            sql.VALUES("account_receivable_project", "#{accountReceivableProject,jdbcType=VARCHAR}");
        }
        
        if (record.getNotifyUrl() != null) {
            sql.VALUES("notify_url", "#{notifyUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getBalanceReceiveEmail() != null) {
            sql.VALUES("balance_receive_email", "#{balanceReceiveEmail,jdbcType=VARCHAR}");
        }
        
        if (record.getUnderReason() != null) {
            sql.VALUES("under_reason", "#{underReason,jdbcType=VARCHAR}");
        }
        
        if (record.getGroundTime() != null) {
            sql.VALUES("ground_time", "#{groundTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getMaxIosVersion() != null) {
            sql.VALUES("max_ios_version", "#{maxIosVersion,jdbcType=VARCHAR}");
        }
        
        if (record.getMinIosVersion() != null) {
            sql.VALUES("min_ios_version", "#{minIosVersion,jdbcType=VARCHAR}");
        }
        
        if (record.getMaxAndoirdVersion() != null) {
            sql.VALUES("max_andoird_version", "#{maxAndoirdVersion,jdbcType=VARCHAR}");
        }
        
        if (record.getMinAndoirdVersion() != null) {
            sql.VALUES("min_andoird_version", "#{minAndoirdVersion,jdbcType=VARCHAR}");
        }
        
        if (record.getServiceNeed() != null) {
            sql.VALUES("service_need", "#{serviceNeed,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(CommunityServiceTempExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("title");
        sql.SELECT("png");
        sql.SELECT("disable_png");
        sql.SELECT("reorder");
        sql.SELECT("clause");
        sql.SELECT("type");
        sql.SELECT("is_account");
        sql.SELECT("link");
        sql.SELECT("provide_type");
        sql.SELECT("status");
        sql.SELECT("app_id");
        sql.SELECT("description");
        sql.SELECT("audit_comment");
        sql.SELECT("create_time");
        sql.SELECT("update_time");
        sql.SELECT("audit_time");
        sql.SELECT("category_id");
        sql.SELECT("is_need_hardware");
        sql.SELECT("target_month_turnover");
        sql.SELECT("paid_caution_money");
        sql.SELECT("caution_money_status");
        sql.SELECT("ground_mode");
        sql.SELECT("merchant_id");
        sql.SELECT("account_id");
        sql.SELECT("audit_status");
        sql.SELECT("clause_id");
        sql.SELECT("app_secret");
        sql.SELECT("receivable_caution_money");
        sql.SELECT("recommend_level");
        sql.SELECT("caution_money_type");
        sql.SELECT("caution_money_pic");
        sql.SELECT("remark");
        sql.SELECT("caution_bill_id");
        sql.SELECT("user_range");
        sql.SELECT("ground_audit_status");
        sql.SELECT("shot");
        sql.SELECT("account_receivable_project");
        sql.SELECT("notify_url");
        sql.SELECT("balance_receive_email");
        sql.SELECT("under_reason");
        sql.SELECT("ground_time");
        sql.SELECT("max_ios_version");
        sql.SELECT("min_ios_version");
        sql.SELECT("max_andoird_version");
        sql.SELECT("min_andoird_version");
        sql.SELECT("service_need");
        sql.FROM("community_service_temp");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        CommunityServiceTemp record = (CommunityServiceTemp) parameter.get("record");
        CommunityServiceTempExample example = (CommunityServiceTempExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("community_service_temp");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getTitle() != null) {
            sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        }
        
        if (record.getPng() != null) {
            sql.SET("png = #{record.png,jdbcType=VARCHAR}");
        }
        
        if (record.getDisablePng() != null) {
            sql.SET("disable_png = #{record.disablePng,jdbcType=VARCHAR}");
        }
        
        if (record.getReorder() != null) {
            sql.SET("reorder = #{record.reorder,jdbcType=INTEGER}");
        }
        
        if (record.getClause() != null) {
            sql.SET("clause = #{record.clause,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{record.type,jdbcType=INTEGER}");
        }
        
        if (record.getIsAccount() != null) {
            sql.SET("is_account = #{record.isAccount,jdbcType=INTEGER}");
        }
        
        if (record.getLink() != null) {
            sql.SET("link = #{record.link,jdbcType=VARCHAR}");
        }
        
        if (record.getProvideType() != null) {
            sql.SET("provide_type = #{record.provideType,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=INTEGER}");
        }
        
        if (record.getAppId() != null) {
            sql.SET("app_id = #{record.appId,jdbcType=BIGINT}");
        }
        
        if (record.getDescription() != null) {
            sql.SET("description = #{record.description,jdbcType=VARCHAR}");
        }
        
        if (record.getAuditComment() != null) {
            sql.SET("audit_comment = #{record.auditComment,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAuditTime() != null) {
            sql.SET("audit_time = #{record.auditTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCategoryId() != null) {
            sql.SET("category_id = #{record.categoryId,jdbcType=INTEGER}");
        }
        
        if (record.getIsNeedHardware() != null) {
            sql.SET("is_need_hardware = #{record.isNeedHardware,jdbcType=INTEGER}");
        }
        
        if (record.getTargetMonthTurnover() != null) {
            sql.SET("target_month_turnover = #{record.targetMonthTurnover,jdbcType=DECIMAL}");
        }
        
        if (record.getPaidCautionMoney() != null) {
            sql.SET("paid_caution_money = #{record.paidCautionMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getCautionMoneyStatus() != null) {
            sql.SET("caution_money_status = #{record.cautionMoneyStatus,jdbcType=INTEGER}");
        }
        
        if (record.getGroundMode() != null) {
            sql.SET("ground_mode = #{record.groundMode,jdbcType=INTEGER}");
        }
        
        if (record.getMerchantId() != null) {
            sql.SET("merchant_id = #{record.merchantId,jdbcType=BIGINT}");
        }
        
        if (record.getAccountId() != null) {
            sql.SET("account_id = #{record.accountId,jdbcType=VARCHAR}");
        }
        
        if (record.getAuditStatus() != null) {
            sql.SET("audit_status = #{record.auditStatus,jdbcType=INTEGER}");
        }
        
        if (record.getClauseId() != null) {
            sql.SET("clause_id = #{record.clauseId,jdbcType=INTEGER}");
        }
        
        if (record.getAppSecret() != null) {
            sql.SET("app_secret = #{record.appSecret,jdbcType=VARCHAR}");
        }
        
        if (record.getReceivableCautionMoney() != null) {
            sql.SET("receivable_caution_money = #{record.receivableCautionMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getRecommendLevel() != null) {
            sql.SET("recommend_level = #{record.recommendLevel,jdbcType=DOUBLE}");
        }
        
        if (record.getCautionMoneyType() != null) {
            sql.SET("caution_money_type = #{record.cautionMoneyType,jdbcType=INTEGER}");
        }
        
        if (record.getCautionMoneyPic() != null) {
            sql.SET("caution_money_pic = #{record.cautionMoneyPic,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            sql.SET("remark = #{record.remark,jdbcType=VARCHAR}");
        }
        
        if (record.getCautionBillId() != null) {
            sql.SET("caution_bill_id = #{record.cautionBillId,jdbcType=VARCHAR}");
        }
        
        if (record.getUserRange() != null) {
            sql.SET("user_range = #{record.userRange,jdbcType=INTEGER}");
        }
        
        if (record.getGroundAuditStatus() != null) {
            sql.SET("ground_audit_status = #{record.groundAuditStatus,jdbcType=INTEGER}");
        }
        
        if (record.getShot() != null) {
            sql.SET("shot = #{record.shot,jdbcType=VARCHAR}");
        }
        
        if (record.getAccountReceivableProject() != null) {
            sql.SET("account_receivable_project = #{record.accountReceivableProject,jdbcType=VARCHAR}");
        }
        
        if (record.getNotifyUrl() != null) {
            sql.SET("notify_url = #{record.notifyUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getBalanceReceiveEmail() != null) {
            sql.SET("balance_receive_email = #{record.balanceReceiveEmail,jdbcType=VARCHAR}");
        }
        
        if (record.getUnderReason() != null) {
            sql.SET("under_reason = #{record.underReason,jdbcType=VARCHAR}");
        }
        
        if (record.getGroundTime() != null) {
            sql.SET("ground_time = #{record.groundTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getMaxIosVersion() != null) {
            sql.SET("max_ios_version = #{record.maxIosVersion,jdbcType=VARCHAR}");
        }
        
        if (record.getMinIosVersion() != null) {
            sql.SET("min_ios_version = #{record.minIosVersion,jdbcType=VARCHAR}");
        }
        
        if (record.getMaxAndoirdVersion() != null) {
            sql.SET("max_andoird_version = #{record.maxAndoirdVersion,jdbcType=VARCHAR}");
        }
        
        if (record.getMinAndoirdVersion() != null) {
            sql.SET("min_andoird_version = #{record.minAndoirdVersion,jdbcType=VARCHAR}");
        }
        
        if (record.getServiceNeed() != null) {
            sql.SET("service_need = #{record.serviceNeed,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("community_service_temp");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        sql.SET("png = #{record.png,jdbcType=VARCHAR}");
        sql.SET("disable_png = #{record.disablePng,jdbcType=VARCHAR}");
        sql.SET("reorder = #{record.reorder,jdbcType=INTEGER}");
        sql.SET("clause = #{record.clause,jdbcType=VARCHAR}");
        sql.SET("type = #{record.type,jdbcType=INTEGER}");
        sql.SET("is_account = #{record.isAccount,jdbcType=INTEGER}");
        sql.SET("link = #{record.link,jdbcType=VARCHAR}");
        sql.SET("provide_type = #{record.provideType,jdbcType=INTEGER}");
        sql.SET("status = #{record.status,jdbcType=INTEGER}");
        sql.SET("app_id = #{record.appId,jdbcType=BIGINT}");
        sql.SET("description = #{record.description,jdbcType=VARCHAR}");
        sql.SET("audit_comment = #{record.auditComment,jdbcType=VARCHAR}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        sql.SET("audit_time = #{record.auditTime,jdbcType=TIMESTAMP}");
        sql.SET("category_id = #{record.categoryId,jdbcType=INTEGER}");
        sql.SET("is_need_hardware = #{record.isNeedHardware,jdbcType=INTEGER}");
        sql.SET("target_month_turnover = #{record.targetMonthTurnover,jdbcType=DECIMAL}");
        sql.SET("paid_caution_money = #{record.paidCautionMoney,jdbcType=DECIMAL}");
        sql.SET("caution_money_status = #{record.cautionMoneyStatus,jdbcType=INTEGER}");
        sql.SET("ground_mode = #{record.groundMode,jdbcType=INTEGER}");
        sql.SET("merchant_id = #{record.merchantId,jdbcType=BIGINT}");
        sql.SET("account_id = #{record.accountId,jdbcType=VARCHAR}");
        sql.SET("audit_status = #{record.auditStatus,jdbcType=INTEGER}");
        sql.SET("clause_id = #{record.clauseId,jdbcType=INTEGER}");
        sql.SET("app_secret = #{record.appSecret,jdbcType=VARCHAR}");
        sql.SET("receivable_caution_money = #{record.receivableCautionMoney,jdbcType=DECIMAL}");
        sql.SET("recommend_level = #{record.recommendLevel,jdbcType=DOUBLE}");
        sql.SET("caution_money_type = #{record.cautionMoneyType,jdbcType=INTEGER}");
        sql.SET("caution_money_pic = #{record.cautionMoneyPic,jdbcType=VARCHAR}");
        sql.SET("remark = #{record.remark,jdbcType=VARCHAR}");
        sql.SET("caution_bill_id = #{record.cautionBillId,jdbcType=VARCHAR}");
        sql.SET("user_range = #{record.userRange,jdbcType=INTEGER}");
        sql.SET("ground_audit_status = #{record.groundAuditStatus,jdbcType=INTEGER}");
        sql.SET("shot = #{record.shot,jdbcType=VARCHAR}");
        sql.SET("account_receivable_project = #{record.accountReceivableProject,jdbcType=VARCHAR}");
        sql.SET("notify_url = #{record.notifyUrl,jdbcType=VARCHAR}");
        sql.SET("balance_receive_email = #{record.balanceReceiveEmail,jdbcType=VARCHAR}");
        sql.SET("under_reason = #{record.underReason,jdbcType=VARCHAR}");
        sql.SET("ground_time = #{record.groundTime,jdbcType=TIMESTAMP}");
        sql.SET("max_ios_version = #{record.maxIosVersion,jdbcType=VARCHAR}");
        sql.SET("min_ios_version = #{record.minIosVersion,jdbcType=VARCHAR}");
        sql.SET("max_andoird_version = #{record.maxAndoirdVersion,jdbcType=VARCHAR}");
        sql.SET("min_andoird_version = #{record.minAndoirdVersion,jdbcType=VARCHAR}");
        sql.SET("service_need = #{record.serviceNeed,jdbcType=VARCHAR}");
        
        CommunityServiceTempExample example = (CommunityServiceTempExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(CommunityServiceTemp record) {
        SQL sql = new SQL();
        sql.UPDATE("community_service_temp");
        
        if (record.getTitle() != null) {
            sql.SET("title = #{title,jdbcType=VARCHAR}");
        }
        
        if (record.getPng() != null) {
            sql.SET("png = #{png,jdbcType=VARCHAR}");
        }
        
        if (record.getDisablePng() != null) {
            sql.SET("disable_png = #{disablePng,jdbcType=VARCHAR}");
        }
        
        if (record.getReorder() != null) {
            sql.SET("reorder = #{reorder,jdbcType=INTEGER}");
        }
        
        if (record.getClause() != null) {
            sql.SET("clause = #{clause,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{type,jdbcType=INTEGER}");
        }
        
        if (record.getIsAccount() != null) {
            sql.SET("is_account = #{isAccount,jdbcType=INTEGER}");
        }
        
        if (record.getLink() != null) {
            sql.SET("link = #{link,jdbcType=VARCHAR}");
        }
        
        if (record.getProvideType() != null) {
            sql.SET("provide_type = #{provideType,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getAppId() != null) {
            sql.SET("app_id = #{appId,jdbcType=BIGINT}");
        }
        
        if (record.getDescription() != null) {
            sql.SET("description = #{description,jdbcType=VARCHAR}");
        }
        
        if (record.getAuditComment() != null) {
            sql.SET("audit_comment = #{auditComment,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAuditTime() != null) {
            sql.SET("audit_time = #{auditTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCategoryId() != null) {
            sql.SET("category_id = #{categoryId,jdbcType=INTEGER}");
        }
        
        if (record.getIsNeedHardware() != null) {
            sql.SET("is_need_hardware = #{isNeedHardware,jdbcType=INTEGER}");
        }
        
        if (record.getTargetMonthTurnover() != null) {
            sql.SET("target_month_turnover = #{targetMonthTurnover,jdbcType=DECIMAL}");
        }
        
        if (record.getPaidCautionMoney() != null) {
            sql.SET("paid_caution_money = #{paidCautionMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getCautionMoneyStatus() != null) {
            sql.SET("caution_money_status = #{cautionMoneyStatus,jdbcType=INTEGER}");
        }
        
        if (record.getGroundMode() != null) {
            sql.SET("ground_mode = #{groundMode,jdbcType=INTEGER}");
        }
        
        if (record.getMerchantId() != null) {
            sql.SET("merchant_id = #{merchantId,jdbcType=BIGINT}");
        }
        
        if (record.getAccountId() != null) {
            sql.SET("account_id = #{accountId,jdbcType=VARCHAR}");
        }
        
        if (record.getAuditStatus() != null) {
            sql.SET("audit_status = #{auditStatus,jdbcType=INTEGER}");
        }
        
        if (record.getClauseId() != null) {
            sql.SET("clause_id = #{clauseId,jdbcType=INTEGER}");
        }
        
        if (record.getAppSecret() != null) {
            sql.SET("app_secret = #{appSecret,jdbcType=VARCHAR}");
        }
        
        if (record.getReceivableCautionMoney() != null) {
            sql.SET("receivable_caution_money = #{receivableCautionMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getRecommendLevel() != null) {
            sql.SET("recommend_level = #{recommendLevel,jdbcType=DOUBLE}");
        }
        
        if (record.getCautionMoneyType() != null) {
            sql.SET("caution_money_type = #{cautionMoneyType,jdbcType=INTEGER}");
        }
        
        if (record.getCautionMoneyPic() != null) {
            sql.SET("caution_money_pic = #{cautionMoneyPic,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            sql.SET("remark = #{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getCautionBillId() != null) {
            sql.SET("caution_bill_id = #{cautionBillId,jdbcType=VARCHAR}");
        }
        
        if (record.getUserRange() != null) {
            sql.SET("user_range = #{userRange,jdbcType=INTEGER}");
        }
        
        if (record.getGroundAuditStatus() != null) {
            sql.SET("ground_audit_status = #{groundAuditStatus,jdbcType=INTEGER}");
        }
        
        if (record.getShot() != null) {
            sql.SET("shot = #{shot,jdbcType=VARCHAR}");
        }
        
        if (record.getAccountReceivableProject() != null) {
            sql.SET("account_receivable_project = #{accountReceivableProject,jdbcType=VARCHAR}");
        }
        
        if (record.getNotifyUrl() != null) {
            sql.SET("notify_url = #{notifyUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getBalanceReceiveEmail() != null) {
            sql.SET("balance_receive_email = #{balanceReceiveEmail,jdbcType=VARCHAR}");
        }
        
        if (record.getUnderReason() != null) {
            sql.SET("under_reason = #{underReason,jdbcType=VARCHAR}");
        }
        
        if (record.getGroundTime() != null) {
            sql.SET("ground_time = #{groundTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getMaxIosVersion() != null) {
            sql.SET("max_ios_version = #{maxIosVersion,jdbcType=VARCHAR}");
        }
        
        if (record.getMinIosVersion() != null) {
            sql.SET("min_ios_version = #{minIosVersion,jdbcType=VARCHAR}");
        }
        
        if (record.getMaxAndoirdVersion() != null) {
            sql.SET("max_andoird_version = #{maxAndoirdVersion,jdbcType=VARCHAR}");
        }
        
        if (record.getMinAndoirdVersion() != null) {
            sql.SET("min_andoird_version = #{minAndoirdVersion,jdbcType=VARCHAR}");
        }
        
        if (record.getServiceNeed() != null) {
            sql.SET("service_need = #{serviceNeed,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, CommunityServiceTempExample example, boolean includeExamplePhrase) {
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