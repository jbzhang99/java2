package com.rfchina.community.persistence.mapper.ext;

import com.rfchina.community.persistence.mapper.UserCommentSqlProvider;
import com.rfchina.community.persistence.model.UserComment;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

public class ExtUserCommentSqlProvider extends UserCommentSqlProvider {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public String pageByCondition(Map param) {
        SQL sql = new SQL();
        sql.SELECT("com.*,reply.reply_comment replyComment,reply.`status` replyStatus,reply.create_time replyTime,u.phone as userTelephone");
        sql.SELECT("good.name goodsInfo,good.price goodsPrice,good.pic_url goodsPicUrl");
        sql.SELECT("service.title serviceName,merchant.title merchantName,community.name communityName");
        sql.FROM("user_comment com");
        sql.LEFT_OUTER_JOIN("open_store_order store_order ON store_order.out_trade_no = com.out_trade_no");
        sql.LEFT_OUTER_JOIN("open_store_good good ON com.comment_target = good.id");
        sql.LEFT_OUTER_JOIN("community_service service ON service.id = store_order.service_id");
        sql.LEFT_OUTER_JOIN("open_merchant_info merchant ON merchant.id = service.merchant_id");
        sql.LEFT_OUTER_JOIN("community community ON community.id = store_order.community_id");
        sql.LEFT_OUTER_JOIN("user_info u ON u.id = com.commentator");
        sql.LEFT_OUTER_JOIN("user_comment_reply reply ON (reply.comment_id = com.id AND reply.status <> '-1')");
        StringBuilder sb = new StringBuilder();
        if (isNotBlank(param.get("status"))) {
            sb.append("  com.status = #{status}");
        } else {
            sb.append("  com.status <> '-1'");
        }
        if (isNotBlank(param.get("commentTargetType"))) {
            sb.append(" and com.comment_target_type = #{commentTargetType}");
        }
        if (isNotBlank(param.get("startTime"))) {
            sb.append(" and com.create_time >= #{startTime}");
        }
        if (isNotBlank(param.get("endTime"))) {
            sb.append(" and com.create_time < #{endTime}");
        }
        if (isNotBlank(param.get("merchantName"))) {
            sb.append(" and merchant.title like #{merchantName}");
        }
        if (isNotBlank(param.get("goodsName"))) {
            sb.append(" and good.name like #{goodsName}");
        }
        if (isNotBlank(param.get("serviceName"))) {
            sb.append(" and service.title like #{serviceName}");
        }
        if (isNotBlank(param.get("serviceId"))) {
            sb.append(" and service.id = #{serviceId}");
        }
        if (isNotBlank(param.get("goodsGrade"))) {
            sb.append(" and com.goods_grade = #{goodsGrade}");
        }
        if (isNotBlank(param.get("serviceGrade"))) {
            sb.append(" and com.service_grade = #{serviceGrade}");
        }
        if (isNotBlank(param.get("logisticsGrade"))) {
            sb.append(" and com.logistics_grade = #{logisticsGrade}");
        }
        if (isNotBlank(param.get("goodsType"))) {
            sb.append(" and good.category_id = #{goodsType}");
        }
        if (isNotBlank(param.get("communityId"))) {
            sb.append(" and store_order.community_id = #{communityId}");
        }
        if (isNotBlank(param.get("outTradeNo"))) {
            sb.append(" and com.out_trade_no = #{outTradeNo}");
        }
        if (isNotBlank(param.get("userTelephone"))) {
            sb.append(" and u.phone = #{userTelephone}");
        }
        if (isNotBlank(param.get("cityId"))) {
            sb.append(" and community.city_id = #{cityId}");
        }
        if (isNotBlank(param.get("categoryId"))) {
            sb.append(" and service.category_id = #{categoryId}");
        }

        sql.WHERE(sb.toString());
        sql.GROUP_BY("com.id");
        sql.ORDER_BY("com.create_time desc");
        logger.info("userComment pageByCondition:{}",sql.toString());
        return sql.toString();
    }

    public String pageTargetComment() {
        SQL sql = buildSql(true);
        sql.WHERE("com.status = '1' and com.comment_target_type = 'G' and comment_target = #{targetId}");
        sql.GROUP_BY("com.id");
        sql.ORDER_BY("com.create_time desc");
        return sql.toString();
    }

    public String pageGoodsComment() {
        SQL sql = buildSql(false);
        sql.WHERE("com.status = '1' and com.comment_target_type = 'G' and comment_target = #{goodsId}");
        sql.GROUP_BY("com.id");
        sql.ORDER_BY("com.goods_grade desc,com.create_time desc");
        return sql.toString();
    }

    public String batchInsert(Map map) {
        List<UserComment> list = (List<UserComment>) map.get("list");
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO user_comment (comment_target_type, comment_target, logistics_grade, service_grade, goods_grade, commentator, create_time, status, reply_status,out_trade_no,pic_url,comment,user_name) VALUES ");
        MessageFormat mf = new MessageFormat(
                "(#'{'list[{0}].commentTargetType}, #'{'list[{0}].commentTarget}, #'{'list[{0}].logisticsGrade}, #'{'list[{0}].serviceGrade}, #'{'list[{0}].goodsGrade}," +
                        " #'{'list[{0}].commentator}, #'{'list[{0}].createTime}, #'{'list[{0}].status}, #'{'list[{0}].replyStatus}, #'{'list[{0}].outTradeNo}, #'{'list[{0}].picUrl}, #'{'list[{0}].comment}, #'{'list[{0}].userName})"
        );
        for (int i = 0; i < list.size(); i++) {
            sb.append(mf.format(new Object[]{i}));
            if (i < list.size() - 1)
                sb.append(",");
        }
        return sb.toString();
    }

    public String getFirstGoodComment() {
        SQL sql = buildSql(false);
        sql.WHERE("com.status = '1' and com.comment_target_type = 'G' and goods_grade in (4,5) and comment_target = #{goodsId}");
        sql.GROUP_BY("com.id");
        sql.ORDER_BY("com.create_time desc");
        return sql.toString();
    }

    public String getCommentById() {
        SQL sql = new SQL();
        sql.SELECT("com.pic_url,com.goods_grade,com.create_time,com.comment,com.out_trade_no,com.status");
        sql.SELECT("u.phone as userTelephone,u.nickname,u.pic userPic");
        sql.SELECT("reply.reply_comment replyComment,reply.`status` replyStatus,max(reply.create_time) replyTime");
        sql.SELECT("good.name goodsInfo,good.pic_url goodsPicUrl");
        sql.FROM("user_comment com");
        sql.LEFT_OUTER_JOIN("open_store_good good ON com.comment_target = good.id");
        sql.LEFT_OUTER_JOIN("user_info u ON u.id = com.commentator");
        sql.LEFT_OUTER_JOIN("user_comment_reply reply ON (reply.comment_id = com.id AND reply.status <> '-1')");
        sql.WHERE("com.id = #{commentId}");
        return sql.toString();
    }

    public String getOrderByCommentId() {
        SQL sql = new SQL();
        sql.SELECT("_order.id,_order.user_id,_order.community_id,_order.service_id,_order.pay_status,_order.send_status,_order.comment_status,_order.out_trade_no");
        sql.FROM("open_store_order _order");
        sql.INNER_JOIN("user_comment _comment ON _comment.out_trade_no = _order.out_trade_no");
        sql.WHERE("_comment.id = #{commentId}");
        return sql.toString();
    }


    public String pageComment() {
        SQL sql = new SQL();
        sql.SELECT("com.id,com.pic_url,com.user_name as nickName,com.service_grade,com.create_time,com.comment");
        sql.FROM("user_comment com");
        sql.WHERE("com.comment_target=#{targetId} and com.comment_target_type=#{targetType} and com.status='1'");
        sql.ORDER_BY("com.create_time desc");
        return sql.toString();
    }

    private SQL buildSql(Boolean allReplyFlag) {
        SQL sql = new SQL();
        sql.SELECT("com.pic_url,com.goods_grade,com.create_time,com.comment,com.status,com.reply_status");
        sql.SELECT("u.phone as userTelephone,u.nickname,u.pic userPic");
        sql.SELECT("reply.reply_comment replyComment,reply.`status` replyStatus,reply.create_time replyTime");
        sql.FROM("user_comment com");
        sql.LEFT_OUTER_JOIN("user_info u ON u.id = com.commentator");
        if (allReplyFlag) {
            sql.LEFT_OUTER_JOIN("user_comment_reply reply ON reply.comment_id = com.id");
        } else {
            sql.LEFT_OUTER_JOIN("user_comment_reply reply ON (reply.comment_id = com.id and reply.status = '1')");
        }
        return sql;
    }

    private boolean isNotBlank(Object obj) {
        if (obj != null && StringUtils.isNotBlank(obj.toString())) {
            return true;
        }
        return false;
    }
}