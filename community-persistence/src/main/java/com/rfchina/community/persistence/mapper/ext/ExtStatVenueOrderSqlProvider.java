package com.rfchina.community.persistence.mapper.ext;

import com.rfchina.community.persistence.mapper.StatVenueOrderSqlProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 */
public class ExtStatVenueOrderSqlProvider extends StatVenueOrderSqlProvider {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public String statVenueOrder(Map<String, Object> param) {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append(" select b.area_id, a.community_id, b.type as community_type,              ")
                .append(" count(distinct uid) as user_count,                                         ")
                .append(" count(a.id) as order_count,                                                ")
                .append(" count(distinct uid) as room_count                                          ")
                .append(" from venue_order a join community b                                        ")
                .append(" on a.community_id = b.id                                                   ")
                .append(" where a.uid > 0                                                            ")
                .append(" and a.status in (5, 10, 20, 21)                                               ")
                .append(" and a.create_time >= #{startTime,jdbcType=TIMESTAMP}                       ")
                .append(" and a.create_time <= #{endTime,jdbcType=TIMESTAMP}                         ")
                .append(" group by b.area_id, a.community_id, b.type;                                ");
        String sql = sqlBuilder.toString();
        logger.info("statVenueOrder sql: {}", sql);
        return sql;
    }
}
