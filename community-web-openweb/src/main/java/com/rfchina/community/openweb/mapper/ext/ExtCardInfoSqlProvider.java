package com.rfchina.community.openweb.mapper.ext;

import com.alibaba.fastjson.JSON;
import com.rfchina.community.persistence.mapper.CardInfoSqlProvider;
import com.rfchina.community.persistence.model.CardInfoExample;
import org.apache.ibatis.jdbc.SQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 */
public class ExtCardInfoSqlProvider extends CardInfoSqlProvider {

private static Logger logger = LoggerFactory.getLogger(ExtCardInfoSqlProvider.class);
    public String countOperationByExample(CardInfoExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(DISTINCT operation_id)").FROM("card_info");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String pageByExample(Map<String, Object> param) {
        CardInfoExample example = (CardInfoExample) param.get("example");
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("category_id");
        sql.SELECT("template_id");
        sql.SELECT("community_id");
        sql.SELECT("title");
        sql.SELECT("content");
        sql.SELECT("status");
        sql.SELECT("audit_status");
        sql.SELECT("audit_reason");
        sql.SELECT("square_audit_reason");
        sql.SELECT("square_audit_status");
        sql.SELECT("square_audit_time");
        sql.SELECT("square_publish_time");
        sql.SELECT("publish_time");
        sql.SELECT("attachment");
        sql.SELECT("subject_id");
        sql.SELECT("subject_name");
        sql.SELECT("subject_type");
        sql.SELECT("subject_icon");
        sql.SELECT("pub_to_square");
        sql.SELECT("creator_id");
        sql.SELECT("cid");
        sql.SELECT("apply_time");
        sql.SELECT("create_time");
        sql.SELECT("update_time");
        sql.SELECT("delete_time");
        sql.FROM("card_info");
        applyWhere(sql, example, true);

        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }

        return sql.toString();
    }

    public String pageByExampleOrderBy(Map<String, Object> param) {
        CardInfoExample example = (CardInfoExample) param.get("example");
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("category_id");
        sql.SELECT("template_id");
        sql.SELECT("community_id");
        sql.SELECT("title");
        sql.SELECT("content");
        sql.SELECT("status");
        sql.SELECT("audit_status");
        sql.SELECT("audit_reason");
        sql.SELECT("square_audit_reason");
        sql.SELECT("square_audit_status");
        sql.SELECT("square_audit_time");
        sql.SELECT("square_publish_time");
        sql.SELECT("publish_time");
        sql.SELECT("attachment");
        sql.SELECT("subject_id");
        sql.SELECT("subject_name");
        sql.SELECT("subject_type");
        sql.SELECT("subject_icon");
        sql.SELECT("pub_to_square");
        sql.SELECT("creator_id");
        sql.SELECT("cid");
        sql.SELECT("apply_time");
        sql.SELECT("create_time");
        sql.SELECT("update_time");
        sql.SELECT("delete_time");
/*        sql.SELECT("(case when status = "
                + Constant.CardInfo.AuditStatus.UNAUDIT
                + " then 99 "
                + " when status= "
                + Constant.CardInfo.AuditStatus.PUBLISH
                + " then 88 "
                + "else 0 end) as cid");*/
        sql.FROM("card_info");
        applyWhere(sql, example, true);

        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }

        return sql.toString();
    }

    public String pageByExample4Store(Map<String, Object> param) {
        StringBuffer str = new StringBuffer(" select c.*,cr.merchant_id,cr.service_id,cr.goods_id,ms.title as service_name,m.title as merchant_name ");
        str.append(" from card_info c   ");
        str.append(" join card_info_open_rela cr on c.id=cr.card_id  ");
        str.append(" join open_merchant_info m on m.id=cr.merchant_id  ");
        str.append(" join community_service ms on ms.id=cr.service_id ");
        str.append(" where c.`status` in (1,2)  ");

        if (param.get("communityId") != null && (Integer) param.get("communityId") > 0) {
            str.append(" AND c.community_id = #{communityId, jdbcType=INTEGER}");
        }

        if (param.get("serviceId") != null) {
            str.append(" AND cr.service_id = #{serviceId, jdbcType=INTEGER}");

            if (param.get("passportId") != null) {
                str.append(" AND cr.merchant_id = #{passportId, jdbcType=INTEGER}");
            }
        }
        if (param.get("templateId") != null) {
            str.append(" AND c.template_id = #{templateId, jdbcType=INTEGER}");
        }
        if (param.get("serviceName") != null) {
            str.append(" AND ms.title like #{serviceName, jdbcType=VARCHAR}");
        }
        if (param.get("merchantName") != null) {
            str.append(" AND m.title like #{merchantName, jdbcType=VARCHAR}");
        }
        if (param.get("pubToSquare") != null) {
            Integer pubToSquare = Integer.parseInt(param.get("pubToSquare").toString());
            if (pubToSquare.equals(0)) {
                str.append(" AND c.pub_to_square = 0");
            } else if (pubToSquare.equals(1)) {
                str.append(" AND c.pub_to_square = 1 AND c.audit_status = 2 ");
            } else {
                str.append(" AND c.pub_to_square = 1 AND  c.audit_status != 2 ");
            }
        }
        if (param.get("pubToSquare") != null) {
            str.append(" AND c.pub_to_square = #{pubToSquare, jdbcType=INTEGER}");
        }
        if (param.get("subjectType") != null) {
            str.append(" AND c.subject_type = #{subjectType, jdbcType=INTEGER}");
        }
        if (param.get("startCreateTime") != null) {
            str.append(" AND c.create_time >= #{startCreateTime, jdbcType=TIMESTAMP}");
        }
        if (param.get("startCreateTime") != null) {
            str.append(" AND c.create_time <= #{endCreateTime, jdbcType=TIMESTAMP}");
        }

        str.append(" order by c.create_time desc ");
        logger.info("sql:{},param:{}",str.toString(),JSON.toJSONString(param));
        return str.toString();
    }

    public String pageByExampleWithHomeInfo(Map<String, Object> param) {
        CardInfoExample example = (CardInfoExample) param.get("example");
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("t.id");
        } else {
            sql.SELECT("t.id");
        }
        sql.SELECT("category_id");
        sql.SELECT("template_id");
        sql.SELECT("community_id");
        sql.SELECT("content");
        sql.SELECT("status");
        sql.SELECT("audit_status");
        sql.SELECT("attachment");
        sql.SELECT("subject_id");
        sql.SELECT("subject_name");
        sql.SELECT("subject_type");
        sql.SELECT("subject_icon");
        sql.SELECT("creator_id");
        sql.SELECT("cid");
        sql.SELECT("create_time");
        sql.FROM("card_info t join home_info h on t.id = h.sid");
        applyWhere(sql, example, true);

        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }

        return sql.toString();
    }
}
