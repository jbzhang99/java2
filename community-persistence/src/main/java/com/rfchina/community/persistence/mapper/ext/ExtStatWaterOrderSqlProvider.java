package com.rfchina.community.persistence.mapper.ext;

import com.rfchina.community.persistence.mapper.WaterOrderSqlProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 */
public class ExtStatWaterOrderSqlProvider extends WaterOrderSqlProvider {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public String statWaterOrder(Map<String, Object> param) {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append(" select b.area_id, a.community_id, b.type,   ")
                .append(" count(distinct a.uid) as user_count,          ")
                .append(" count(distinct a.room_id) as room_count,      ")
                .append(" count(a.id) as order_count,                   ")
                .append(" sum(a.num) as bucket_count                    ")
                .append(" from water_order a join community b           ")
                .append(" on a.community_id = b.id                      ")
                .append(" where a.order_type=1                          ")
                .append(" and a.uid > 0                                 ")
                .append(" and a.order_status not in (5)                 ")
                .append(" and a.pay_status not in (1, 4)                ")
                .append(" and a.create_time >= #{startTime,jdbcType=TIMESTAMP} ")
                .append(" and a.create_time <= #{endTime,jdbcType=TIMESTAMP}   ")
                .append(" group by b.area_id, a.community_id, b.type    ");
        String sql = sqlBuilder.toString();
        logger.info("statWaterOrder sql: {}", sql);
        return sql;
    }

    public String statWaterTicketOrder(Map<String, Object> param) {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append(" select b.area_id, a.community_id, b.type,                           ")
                .append(" count(distinct a.uid) as user_count,                                  ")
                .append(" count(distinct a.room_id) as room_count,                              ")
                .append(" count(a.id) as order_count,                                           ")
                .append(" sum(a.num*c.num) as ticket_count,                                     ")
                .append(" sum(a.total_fee) as fee_count                                         ")
                .append(" from water_order a join community b                                   ")
                .append(" on a.community_id = b.id                                              ")
                .append(" join water_supply c                                                   ")
                .append(" on c.id = a.water_brand_id                                            ")
                .append(" where a.order_type=2                                                  ")
                .append(" and a.uid > 0                                                         ")
                .append(" and a.order_status not in (5)                                         ")
                .append(" and a.pay_status not in (1, 4)                                        ")
                .append(" and a.create_time >= #{startTime,jdbcType=TIMESTAMP}                  ")
                .append(" and a.create_time <= #{endTime,jdbcType=TIMESTAMP}                    ")
                .append(" group by b.area_id, a.community_id, b.type;                           ");
        String sql = sqlBuilder.toString();
        logger.info("statWaterTicketOrder sql: {}", sql);
        return sql;
    }
}
