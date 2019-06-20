package com.rfchina.community.openstore.mapper.ext;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface ExtOpenOrderStoreMapper extends Serializable {

    @Select({
            "select s.png,o.uid ,o.create_time,s.title as service_name ,i.title as merchant_name, ",
            " o.total_amount,o.bill_status ,o.out_trade_no,o.bill_id,o.community_trade_no,i.contact_phone,o.trade_type,o.pay_channel,o.bill_finished_time",
            " from open_order o ",
            "  LEFT JOIN community_service s on o.service_id=s.id",
            "  LEFT JOIN open_merchant_info i on s.merchant_id=i.id",
            "  where s.type=3  and o.uid=#{uid} order by o.id desc",
    })
    List<Map<String, Object>> listOrderThreeByUid(@Param("uid") long uid);


    @Select({
            "select s.png,o.uid ,o.create_time,s.title as service_name ,i.title as merchant_name, ",
            " o.total_amount,o.bill_status ,o.out_trade_no,o.bill_id,o.community_trade_no,i.contact_phone,o.trade_type,o.pay_channel,o.bill_finished_time",
            " from open_order o ",
            "  LEFT JOIN community_service s on o.service_id=s.id",
            "  LEFT JOIN open_merchant_info i on s.merchant_id=i.id",
            "  where s.type=3  and o.uid=#{uid} and o.id=#{id} order by o.id desc",
    })
    Map<String, Object> oneOrderThreeByUid(@Param("uid") long uid,@Param("id") long id);
}
