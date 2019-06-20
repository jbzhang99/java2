package com.rfchina.community.persistence.mapper.ext;

import com.rfchina.community.persistence.mapper.SensitiveWordsSqlProvider;
import com.rfchina.community.persistence.model.SensitiveWordsExample;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 */
public class ExtSensitiveWordsSqlProvider extends SensitiveWordsSqlProvider {

    public String pageByExample(Map<String, Object> param) {
        SensitiveWordsExample example = (SensitiveWordsExample) param.get("example");
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("community_id");
        sql.SELECT("words");
        sql.SELECT("rpl_words");
        sql.FROM("sensitive_words");
        applyWhere(sql, example, true);

        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }

        return sql.toString();
    }
}
