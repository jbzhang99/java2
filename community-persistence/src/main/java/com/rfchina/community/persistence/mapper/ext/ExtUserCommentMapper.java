package com.rfchina.community.persistence.mapper.ext;

import com.rfchina.community.persistence.mapper.UserCommentMapper;
import com.rfchina.community.persistence.model.OpenStoreOrder;
import com.rfchina.community.persistence.model.UserComment;
import com.rfchina.community.persistence.model.ext.ExtUserComment;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;

import java.util.List;
import java.util.Map;

public interface ExtUserCommentMapper extends UserCommentMapper {
    @InsertProvider(type = ExtUserCommentSqlProvider.class, method = "batchInsert")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Long.class)
    int batchInsert(@Param("list") List<UserComment> list);

    @SelectProvider(type = ExtUserCommentSqlProvider.class, method = "pageByCondition")
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "comment_target_type", property = "commentTargetType", jdbcType = JdbcType.VARCHAR),
            @Result(column = "comment_target", property = "commentTarget", jdbcType = JdbcType.BIGINT),
            @Result(column = "out_trade_no", property = "outTradeNo", jdbcType = JdbcType.VARCHAR),
            @Result(column = "pic_url", property = "picUrl", jdbcType = JdbcType.VARCHAR),
            @Result(column = "logistics_grade", property = "logisticsGrade", jdbcType = JdbcType.INTEGER),
            @Result(column = "service_grade", property = "serviceGrade", jdbcType = JdbcType.INTEGER),
            @Result(column = "goods_grade", property = "goodsGrade", jdbcType = JdbcType.INTEGER),
            @Result(column = "commentator", property = "commentator", jdbcType = JdbcType.BIGINT),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "comment", property = "comment", jdbcType = JdbcType.VARCHAR),
            @Result(column = "status", property = "status", jdbcType = JdbcType.VARCHAR),
            @Result(column = "reply_status", property = "replyStatus", jdbcType = JdbcType.VARCHAR),

            @Result(column = "replyComment", property = "reply.replyComment", jdbcType = JdbcType.VARCHAR),
            @Result(column = "replyStatus", property = "reply.status", jdbcType = JdbcType.VARCHAR),
            @Result(column = "replyTime", property = "reply.createTime", jdbcType = JdbcType.TIMESTAMP),

            @Result(column = "userTelephone", property = "userTelephone", jdbcType = JdbcType.VARCHAR),
            @Result(column = "goodsInfo", property = "goodsInfo", jdbcType = JdbcType.VARCHAR),
            @Result(column = "goodsPrice", property = "goodsPrice", jdbcType = JdbcType.VARCHAR),
            @Result(column = "goodsPicUrl", property = "goodsPicUrl", jdbcType = JdbcType.VARCHAR),

            @Result(column = "serviceName", property = "serviceName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "merchantName", property = "merchantName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "communityName", property = "communityName", jdbcType = JdbcType.VARCHAR)
    })
    PageList<ExtUserComment> pageByCondition(Map<String, Object> param, PageBounds pageBounds);

    @SelectProvider(type = ExtUserCommentSqlProvider.class, method = "pageTargetComment")
    @Results({
            @Result(column = "pic_url", property = "picUrl", jdbcType = JdbcType.VARCHAR),
            @Result(column = "goods_grade", property = "goodsGrade", jdbcType = JdbcType.INTEGER),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "comment", property = "comment", jdbcType = JdbcType.VARCHAR),
            @Result(column = "replyComment", property = "reply.replyComment", jdbcType = JdbcType.VARCHAR),
            @Result(column = "replyStatus", property = "reply.status", jdbcType = JdbcType.VARCHAR),
            @Result(column = "replyTime", property = "reply.createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "userTelephone", property = "userTelephone", jdbcType = JdbcType.VARCHAR),
            @Result(column = "userPic", property = "userPic", jdbcType = JdbcType.VARCHAR),
            @Result(column = "status", property = "status", jdbcType = JdbcType.VARCHAR),
            @Result(column = "reply_status", property = "replyStatus", jdbcType = JdbcType.VARCHAR),
            @Result(column = "nickName", property = "nickName", jdbcType = JdbcType.VARCHAR)
    })
    PageList<ExtUserComment> pageTargetComment(@Param("targetId") Long targetId, PageBounds pageBounds);


    @SelectProvider(type = ExtUserCommentSqlProvider.class, method = "pageGoodsComment")
    @Results({
            @Result(column = "pic_url", property = "picUrl", jdbcType = JdbcType.VARCHAR),
            @Result(column = "goods_grade", property = "goodsGrade", jdbcType = JdbcType.INTEGER),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "comment", property = "comment", jdbcType = JdbcType.VARCHAR),
            @Result(column = "replyComment", property = "reply.replyComment", jdbcType = JdbcType.VARCHAR),
            @Result(column = "replyStatus", property = "reply.status", jdbcType = JdbcType.VARCHAR),
            @Result(column = "replyTime", property = "reply.createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "userTelephone", property = "userTelephone", jdbcType = JdbcType.VARCHAR),
            @Result(column = "userPic", property = "userPic", jdbcType = JdbcType.VARCHAR),
            @Result(column = "nickName", property = "nickName", jdbcType = JdbcType.VARCHAR)
    })
    PageList<ExtUserComment> pageGoodsComment(@Param("goodsId") Long goodsId, PageBounds pageBounds);

    @SelectProvider(type = ExtUserCommentSqlProvider.class, method = "getFirstGoodComment")
    @Results({
            @Result(column = "pic_url", property = "picUrl", jdbcType = JdbcType.VARCHAR),
            @Result(column = "goods_grade", property = "goodsGrade", jdbcType = JdbcType.INTEGER),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "comment", property = "comment", jdbcType = JdbcType.VARCHAR),
            @Result(column = "replyComment", property = "reply.replyComment", jdbcType = JdbcType.VARCHAR),
            @Result(column = "replyStatus", property = "reply.status", jdbcType = JdbcType.VARCHAR),
            @Result(column = "replyTime", property = "reply.createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "userTelephone", property = "userTelephone", jdbcType = JdbcType.VARCHAR),
            @Result(column = "userPic", property = "userPic", jdbcType = JdbcType.VARCHAR),
            @Result(column = "nickName", property = "nickName", jdbcType = JdbcType.VARCHAR)
    })
    List<ExtUserComment> getFirstGoodComment(@Param("goodsId") Integer goodsId);

    @SelectProvider(type = ExtUserCommentSqlProvider.class, method = "getCommentById")
    @Results({
            @Result(column = "pic_url", property = "picUrl", jdbcType = JdbcType.VARCHAR),
            @Result(column = "out_trade_no", property = "outTradeNo", jdbcType = JdbcType.VARCHAR),
            @Result(column = "goods_grade", property = "goodsGrade", jdbcType = JdbcType.INTEGER),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "comment", property = "comment", jdbcType = JdbcType.VARCHAR),
            @Result(column = "replyComment", property = "reply.replyComment", jdbcType = JdbcType.VARCHAR),
            @Result(column = "replyStatus", property = "reply.status", jdbcType = JdbcType.VARCHAR),
            @Result(column = "replyTime", property = "reply.createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "userTelephone", property = "userTelephone", jdbcType = JdbcType.VARCHAR),
            @Result(column = "userPic", property = "userPic", jdbcType = JdbcType.VARCHAR),
            @Result(column = "goodsInfo", property = "goodsInfo", jdbcType = JdbcType.VARCHAR),
            @Result(column = "status", property = "status", jdbcType = JdbcType.VARCHAR),
            @Result(column = "nickName", property = "nickName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "goodsPicUrl", property = "goodsPicUrl", jdbcType = JdbcType.VARCHAR)
    })
    ExtUserComment getCommentById(@Param("commentId") Long commentId);

    @SelectProvider(type = ExtUserCommentSqlProvider.class, method = "getOrderByCommentId")
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
            @Result(column="community_id", property="communityId", jdbcType=JdbcType.BIGINT),
            @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
            @Result(column="out_trade_no", property="outTradeNo", jdbcType=JdbcType.VARCHAR),
            @Result(column="pay_status", property="payStatus", jdbcType=JdbcType.INTEGER),
            @Result(column="send_status", property="sendStatus", jdbcType=JdbcType.INTEGER),
            @Result(column="comment_status", property="commentStatus", jdbcType=JdbcType.VARCHAR)
    })
    OpenStoreOrder getOrderByCommentId(@Param("commentId") Long commentId);


    @SelectProvider(type = ExtUserCommentSqlProvider.class, method = "pageComment")
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER),
            @Result(column = "pic_url", property = "picUrl", jdbcType = JdbcType.VARCHAR),
            @Result(column = "service_grade", property = "serviceGrade", jdbcType = JdbcType.INTEGER),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "comment", property = "comment", jdbcType = JdbcType.VARCHAR),
            @Result(column = "nickName", property = "nickName", jdbcType = JdbcType.VARCHAR)
    })
    PageList<ExtUserComment> pageComment(@Param("targetId") Long targetId,@Param("targetType") String targetType, PageBounds pageBounds);
}