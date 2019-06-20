package com.rfchina.community.persistence.mapper.ext;

import com.rfchina.community.persistence.mapper.ParkingOrderSqlProvider;
import com.rfchina.community.persistence.model.ParkingOrderExample;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 */
public class ExtParkingOrderSqlProvider extends ParkingOrderSqlProvider {

    public String pageByExample(Map<String, Object> param) {
        ParkingOrderExample example = (ParkingOrderExample) param.get("example");
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
        sql.SELECT("create_time");
        sql.SELECT("update_time");
        sql.FROM("parking_order");
        applyWhere(sql, example, true);

        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }

        return sql.toString();
    }
}
