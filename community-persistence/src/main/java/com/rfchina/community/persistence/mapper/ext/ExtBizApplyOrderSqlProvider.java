package com.rfchina.community.persistence.mapper.ext;

import com.rfchina.community.persistence.mapper.BizApplyOrderSqlProvider;
import com.rfchina.community.persistence.model.BizApplyOrderExample;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 */
public class ExtBizApplyOrderSqlProvider extends BizApplyOrderSqlProvider {

    public String pageByExample(Map<String, Object> param) {
        BizApplyOrderExample example = (BizApplyOrderExample)param.get("example");
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("trade_no");
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
        applyWhere(sql, example, true);

        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }

        return sql.toString();
    }
}
