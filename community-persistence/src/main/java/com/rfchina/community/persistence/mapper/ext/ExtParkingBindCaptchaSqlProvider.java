package com.rfchina.community.persistence.mapper.ext;

import com.rfchina.community.persistence.mapper.ParkingBindCaptchaSqlProvider;
import com.rfchina.community.persistence.model.ParkingBindCaptchaExample;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 */
public class ExtParkingBindCaptchaSqlProvider extends ParkingBindCaptchaSqlProvider {


    public String pageByExample(Map<String, Object> param) {
        ParkingBindCaptchaExample example = (ParkingBindCaptchaExample)param.get("example");
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("uid");
        sql.SELECT("mobile");
        sql.SELECT("captcha");
        sql.SELECT("salt");
        sql.SELECT("token");
        sql.SELECT("type");
        sql.SELECT("expire_time");
        sql.FROM("parking_bind_captcha");
        applyWhere(sql, example, true);

        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }

        return sql.toString();
    }
}
