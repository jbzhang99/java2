package com.rfchina.community.openweb.mapper.ext;

import com.rfchina.community.persistence.mapper.CardInfoOpenRelaSqlProvider;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;


/**
 */
public class ExtCardInfoOpenSqlProvider extends CardInfoOpenRelaSqlProvider {

    private static Logger logger = LoggerFactory.getLogger(ExtCardInfoOpenSqlProvider.class);

    public String countOperationByExample(Map<String, Object> param) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" select count(DISTINCT c.operation_id,r.merchant_id,r.service_id) from card_info c join card_info_open_rela r");
        stringBuilder.append(" on c.id=r.card_id ");
        stringBuilder.append(" where 1=1 ");

        if (StringUtils.isNotEmpty(param.get("subject_id").toString())) {
            stringBuilder.append(" and subject_id =" + param.get("subject_id").toString());
        }
        if (StringUtils.isNotEmpty(param.get("service_id").toString())) {
            stringBuilder.append(" and service_id =" + param.get("service_id").toString());
        }
        if (StringUtils.isNotEmpty(param.get("create_time").toString())) {
            stringBuilder.append(" and create_time >='" + param.get("create_time").toString() + "'");
        }
        return stringBuilder.toString();
    }
}
