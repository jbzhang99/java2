package com.rfchina.community.persistence.mapper.ext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 */
public class ExtStatRegUserSqlProvider {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public String statRegUser(Map<String, Object> param) {
        StringBuilder sqlBuilder = new StringBuilder(" select ");
        sqlBuilder.append(" count(a.id) as acc_count, ")
                .append(" sum(case when a.reg_src = 1 then 1 else 0 end) as app_count, ")
                .append(" sum(case when a.reg_src != 1 then 1 else 0 end) as other_count ")
                .append(" from user_info a where a.create_time < #{statTime,jdbcType=TIMESTAMP} " );

        String sql = sqlBuilder.toString();
        logger.info("statRegUser:{}", sql);
        return sql;
    }
}
