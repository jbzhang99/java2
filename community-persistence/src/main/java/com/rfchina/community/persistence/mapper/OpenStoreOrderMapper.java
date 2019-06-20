package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenStoreOrder;
import com.rfchina.community.persistence.model.OpenStoreOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface OpenStoreOrderMapper extends BaseMapper {
    @SelectProvider(type=OpenStoreOrderSqlProvider.class, method="countByExample")
    long countByExample(OpenStoreOrderExample example);

    @DeleteProvider(type=OpenStoreOrderSqlProvider.class, method="deleteByExample")
    int deleteByExample(OpenStoreOrderExample example);

    @Delete({
        "delete from open_store_order",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into open_store_order (user_id, open_id, ",
        "community_id, service_id, ",
        "addr_info_id, addr_info, ",
        "addr_detail, user_name, ",
        "mobile, order_code, ",
        "out_trade_no, express_money, ",
        "goods_total, original_price, ",
        "discount_price, total_amount, ",
        "coupon_price, verify_status, ",
        "subject, body, detail, ",
        "express_type, express_name, ",
        "express_company_code, express_code, ",
        "express_status, sign_for_time, ",
        "express_time, express_area, ",
        "express_phone, pay_status, ",
        "pay_channel, send_status, ",
        "send_time, refund_time, ",
        "pay_time, refund_status, ",
        "refund_approval, refund_comment, ",
        "refund_remark, result_status, ",
        "same_way, open_refund_id, ",
        "remark, create_time, ",
        "invalid_time, confirm_time, ",
        "resource_type, coupon_record_id, ",
        "type, xfsj_id, comment_status, ",
        "group_status, group_info_id, ",
        "group_data_id)",
        "values (#{userId,jdbcType=BIGINT}, #{openId,jdbcType=VARCHAR}, ",
        "#{communityId,jdbcType=BIGINT}, #{serviceId,jdbcType=INTEGER}, ",
        "#{addrInfoId,jdbcType=INTEGER}, #{addrInfo,jdbcType=VARCHAR}, ",
        "#{addrDetail,jdbcType=VARCHAR}, #{userName,jdbcType=VARCHAR}, ",
        "#{mobile,jdbcType=VARCHAR}, #{orderCode,jdbcType=VARCHAR}, ",
        "#{outTradeNo,jdbcType=VARCHAR}, #{expressMoney,jdbcType=DECIMAL}, ",
        "#{goodsTotal,jdbcType=DECIMAL}, #{originalPrice,jdbcType=DECIMAL}, ",
        "#{discountPrice,jdbcType=DECIMAL}, #{totalAmount,jdbcType=DECIMAL}, ",
        "#{couponPrice,jdbcType=DECIMAL}, #{verifyStatus,jdbcType=CHAR}, ",
        "#{subject,jdbcType=VARCHAR}, #{body,jdbcType=VARCHAR}, #{detail,jdbcType=VARCHAR}, ",
        "#{expressType,jdbcType=VARCHAR}, #{expressName,jdbcType=VARCHAR}, ",
        "#{expressCompanyCode,jdbcType=VARCHAR}, #{expressCode,jdbcType=VARCHAR}, ",
        "#{expressStatus,jdbcType=INTEGER}, #{signForTime,jdbcType=TIMESTAMP}, ",
        "#{expressTime,jdbcType=VARCHAR}, #{expressArea,jdbcType=VARCHAR}, ",
        "#{expressPhone,jdbcType=VARCHAR}, #{payStatus,jdbcType=INTEGER}, ",
        "#{payChannel,jdbcType=VARCHAR}, #{sendStatus,jdbcType=INTEGER}, ",
        "#{sendTime,jdbcType=TIMESTAMP}, #{refundTime,jdbcType=TIMESTAMP}, ",
        "#{payTime,jdbcType=TIMESTAMP}, #{refundStatus,jdbcType=INTEGER}, ",
        "#{refundApproval,jdbcType=VARCHAR}, #{refundComment,jdbcType=VARCHAR}, ",
        "#{refundRemark,jdbcType=VARCHAR}, #{resultStatus,jdbcType=INTEGER}, ",
        "#{sameWay,jdbcType=INTEGER}, #{openRefundId,jdbcType=BIGINT}, ",
        "#{remark,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{invalidTime,jdbcType=TIMESTAMP}, #{confirmTime,jdbcType=TIMESTAMP}, ",
        "#{resourceType,jdbcType=INTEGER}, #{couponRecordId,jdbcType=BIGINT}, ",
        "#{type,jdbcType=VARCHAR}, #{xfsjId,jdbcType=BIGINT}, #{commentStatus,jdbcType=VARCHAR}, ",
        "#{groupStatus,jdbcType=INTEGER}, #{groupInfoId,jdbcType=BIGINT}, ",
        "#{groupDataId,jdbcType=BIGINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(OpenStoreOrder record);

    @InsertProvider(type=OpenStoreOrderSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(OpenStoreOrder record);

    @SelectProvider(type=OpenStoreOrderSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="open_id", property="openId", jdbcType=JdbcType.VARCHAR),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.BIGINT),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
        @Result(column="addr_info_id", property="addrInfoId", jdbcType=JdbcType.INTEGER),
        @Result(column="addr_info", property="addrInfo", jdbcType=JdbcType.VARCHAR),
        @Result(column="addr_detail", property="addrDetail", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="mobile", property="mobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_code", property="orderCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="out_trade_no", property="outTradeNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="express_money", property="expressMoney", jdbcType=JdbcType.DECIMAL),
        @Result(column="goods_total", property="goodsTotal", jdbcType=JdbcType.DECIMAL),
        @Result(column="original_price", property="originalPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="discount_price", property="discountPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="total_amount", property="totalAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="coupon_price", property="couponPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="verify_status", property="verifyStatus", jdbcType=JdbcType.CHAR),
        @Result(column="subject", property="subject", jdbcType=JdbcType.VARCHAR),
        @Result(column="body", property="body", jdbcType=JdbcType.VARCHAR),
        @Result(column="detail", property="detail", jdbcType=JdbcType.VARCHAR),
        @Result(column="express_type", property="expressType", jdbcType=JdbcType.VARCHAR),
        @Result(column="express_name", property="expressName", jdbcType=JdbcType.VARCHAR),
        @Result(column="express_company_code", property="expressCompanyCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="express_code", property="expressCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="express_status", property="expressStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="sign_for_time", property="signForTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="express_time", property="expressTime", jdbcType=JdbcType.VARCHAR),
        @Result(column="express_area", property="expressArea", jdbcType=JdbcType.VARCHAR),
        @Result(column="express_phone", property="expressPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="pay_status", property="payStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="pay_channel", property="payChannel", jdbcType=JdbcType.VARCHAR),
        @Result(column="send_status", property="sendStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="send_time", property="sendTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="refund_time", property="refundTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="pay_time", property="payTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="refund_status", property="refundStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="refund_approval", property="refundApproval", jdbcType=JdbcType.VARCHAR),
        @Result(column="refund_comment", property="refundComment", jdbcType=JdbcType.VARCHAR),
        @Result(column="refund_remark", property="refundRemark", jdbcType=JdbcType.VARCHAR),
        @Result(column="result_status", property="resultStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="same_way", property="sameWay", jdbcType=JdbcType.INTEGER),
        @Result(column="open_refund_id", property="openRefundId", jdbcType=JdbcType.BIGINT),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="invalid_time", property="invalidTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="confirm_time", property="confirmTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="resource_type", property="resourceType", jdbcType=JdbcType.INTEGER),
        @Result(column="coupon_record_id", property="couponRecordId", jdbcType=JdbcType.BIGINT),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="xfsj_id", property="xfsjId", jdbcType=JdbcType.BIGINT),
        @Result(column="comment_status", property="commentStatus", jdbcType=JdbcType.VARCHAR),
        @Result(column="group_status", property="groupStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="group_info_id", property="groupInfoId", jdbcType=JdbcType.BIGINT),
        @Result(column="group_data_id", property="groupDataId", jdbcType=JdbcType.BIGINT)
    })
    List<OpenStoreOrder> selectByExample(OpenStoreOrderExample example);

    @Select({
        "select",
        "id, user_id, open_id, community_id, service_id, addr_info_id, addr_info, addr_detail, ",
        "user_name, mobile, order_code, out_trade_no, express_money, goods_total, original_price, ",
        "discount_price, total_amount, coupon_price, verify_status, subject, body, detail, ",
        "express_type, express_name, express_company_code, express_code, express_status, ",
        "sign_for_time, express_time, express_area, express_phone, pay_status, pay_channel, ",
        "send_status, send_time, refund_time, pay_time, refund_status, refund_approval, ",
        "refund_comment, refund_remark, result_status, same_way, open_refund_id, remark, ",
        "create_time, invalid_time, confirm_time, resource_type, coupon_record_id, type, ",
        "xfsj_id, comment_status, group_status, group_info_id, group_data_id",
        "from open_store_order",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="open_id", property="openId", jdbcType=JdbcType.VARCHAR),
        @Result(column="community_id", property="communityId", jdbcType=JdbcType.BIGINT),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
        @Result(column="addr_info_id", property="addrInfoId", jdbcType=JdbcType.INTEGER),
        @Result(column="addr_info", property="addrInfo", jdbcType=JdbcType.VARCHAR),
        @Result(column="addr_detail", property="addrDetail", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="mobile", property="mobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_code", property="orderCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="out_trade_no", property="outTradeNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="express_money", property="expressMoney", jdbcType=JdbcType.DECIMAL),
        @Result(column="goods_total", property="goodsTotal", jdbcType=JdbcType.DECIMAL),
        @Result(column="original_price", property="originalPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="discount_price", property="discountPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="total_amount", property="totalAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="coupon_price", property="couponPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="verify_status", property="verifyStatus", jdbcType=JdbcType.CHAR),
        @Result(column="subject", property="subject", jdbcType=JdbcType.VARCHAR),
        @Result(column="body", property="body", jdbcType=JdbcType.VARCHAR),
        @Result(column="detail", property="detail", jdbcType=JdbcType.VARCHAR),
        @Result(column="express_type", property="expressType", jdbcType=JdbcType.VARCHAR),
        @Result(column="express_name", property="expressName", jdbcType=JdbcType.VARCHAR),
        @Result(column="express_company_code", property="expressCompanyCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="express_code", property="expressCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="express_status", property="expressStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="sign_for_time", property="signForTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="express_time", property="expressTime", jdbcType=JdbcType.VARCHAR),
        @Result(column="express_area", property="expressArea", jdbcType=JdbcType.VARCHAR),
        @Result(column="express_phone", property="expressPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="pay_status", property="payStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="pay_channel", property="payChannel", jdbcType=JdbcType.VARCHAR),
        @Result(column="send_status", property="sendStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="send_time", property="sendTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="refund_time", property="refundTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="pay_time", property="payTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="refund_status", property="refundStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="refund_approval", property="refundApproval", jdbcType=JdbcType.VARCHAR),
        @Result(column="refund_comment", property="refundComment", jdbcType=JdbcType.VARCHAR),
        @Result(column="refund_remark", property="refundRemark", jdbcType=JdbcType.VARCHAR),
        @Result(column="result_status", property="resultStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="same_way", property="sameWay", jdbcType=JdbcType.INTEGER),
        @Result(column="open_refund_id", property="openRefundId", jdbcType=JdbcType.BIGINT),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="invalid_time", property="invalidTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="confirm_time", property="confirmTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="resource_type", property="resourceType", jdbcType=JdbcType.INTEGER),
        @Result(column="coupon_record_id", property="couponRecordId", jdbcType=JdbcType.BIGINT),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="xfsj_id", property="xfsjId", jdbcType=JdbcType.BIGINT),
        @Result(column="comment_status", property="commentStatus", jdbcType=JdbcType.VARCHAR),
        @Result(column="group_status", property="groupStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="group_info_id", property="groupInfoId", jdbcType=JdbcType.BIGINT),
        @Result(column="group_data_id", property="groupDataId", jdbcType=JdbcType.BIGINT)
    })
    OpenStoreOrder selectByPrimaryKey(Integer id);

    @UpdateProvider(type=OpenStoreOrderSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpenStoreOrder record, @Param("example") OpenStoreOrderExample example);

    @UpdateProvider(type=OpenStoreOrderSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpenStoreOrder record, @Param("example") OpenStoreOrderExample example);

    @UpdateProvider(type=OpenStoreOrderSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpenStoreOrder record);

    @Update({
        "update open_store_order",
        "set user_id = #{userId,jdbcType=BIGINT},",
          "open_id = #{openId,jdbcType=VARCHAR},",
          "community_id = #{communityId,jdbcType=BIGINT},",
          "service_id = #{serviceId,jdbcType=INTEGER},",
          "addr_info_id = #{addrInfoId,jdbcType=INTEGER},",
          "addr_info = #{addrInfo,jdbcType=VARCHAR},",
          "addr_detail = #{addrDetail,jdbcType=VARCHAR},",
          "user_name = #{userName,jdbcType=VARCHAR},",
          "mobile = #{mobile,jdbcType=VARCHAR},",
          "order_code = #{orderCode,jdbcType=VARCHAR},",
          "out_trade_no = #{outTradeNo,jdbcType=VARCHAR},",
          "express_money = #{expressMoney,jdbcType=DECIMAL},",
          "goods_total = #{goodsTotal,jdbcType=DECIMAL},",
          "original_price = #{originalPrice,jdbcType=DECIMAL},",
          "discount_price = #{discountPrice,jdbcType=DECIMAL},",
          "total_amount = #{totalAmount,jdbcType=DECIMAL},",
          "coupon_price = #{couponPrice,jdbcType=DECIMAL},",
          "verify_status = #{verifyStatus,jdbcType=CHAR},",
          "subject = #{subject,jdbcType=VARCHAR},",
          "body = #{body,jdbcType=VARCHAR},",
          "detail = #{detail,jdbcType=VARCHAR},",
          "express_type = #{expressType,jdbcType=VARCHAR},",
          "express_name = #{expressName,jdbcType=VARCHAR},",
          "express_company_code = #{expressCompanyCode,jdbcType=VARCHAR},",
          "express_code = #{expressCode,jdbcType=VARCHAR},",
          "express_status = #{expressStatus,jdbcType=INTEGER},",
          "sign_for_time = #{signForTime,jdbcType=TIMESTAMP},",
          "express_time = #{expressTime,jdbcType=VARCHAR},",
          "express_area = #{expressArea,jdbcType=VARCHAR},",
          "express_phone = #{expressPhone,jdbcType=VARCHAR},",
          "pay_status = #{payStatus,jdbcType=INTEGER},",
          "pay_channel = #{payChannel,jdbcType=VARCHAR},",
          "send_status = #{sendStatus,jdbcType=INTEGER},",
          "send_time = #{sendTime,jdbcType=TIMESTAMP},",
          "refund_time = #{refundTime,jdbcType=TIMESTAMP},",
          "pay_time = #{payTime,jdbcType=TIMESTAMP},",
          "refund_status = #{refundStatus,jdbcType=INTEGER},",
          "refund_approval = #{refundApproval,jdbcType=VARCHAR},",
          "refund_comment = #{refundComment,jdbcType=VARCHAR},",
          "refund_remark = #{refundRemark,jdbcType=VARCHAR},",
          "result_status = #{resultStatus,jdbcType=INTEGER},",
          "same_way = #{sameWay,jdbcType=INTEGER},",
          "open_refund_id = #{openRefundId,jdbcType=BIGINT},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "invalid_time = #{invalidTime,jdbcType=TIMESTAMP},",
          "confirm_time = #{confirmTime,jdbcType=TIMESTAMP},",
          "resource_type = #{resourceType,jdbcType=INTEGER},",
          "coupon_record_id = #{couponRecordId,jdbcType=BIGINT},",
          "type = #{type,jdbcType=VARCHAR},",
          "xfsj_id = #{xfsjId,jdbcType=BIGINT},",
          "comment_status = #{commentStatus,jdbcType=VARCHAR},",
          "group_status = #{groupStatus,jdbcType=INTEGER},",
          "group_info_id = #{groupInfoId,jdbcType=BIGINT},",
          "group_data_id = #{groupDataId,jdbcType=BIGINT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(OpenStoreOrder record);
}