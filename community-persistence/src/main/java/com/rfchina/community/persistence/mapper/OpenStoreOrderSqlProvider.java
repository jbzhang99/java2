package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.OpenStoreOrder;
import com.rfchina.community.persistence.model.OpenStoreOrderExample.Criteria;
import com.rfchina.community.persistence.model.OpenStoreOrderExample.Criterion;
import com.rfchina.community.persistence.model.OpenStoreOrderExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class OpenStoreOrderSqlProvider {

    public String countByExample(OpenStoreOrderExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("open_store_order");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(OpenStoreOrderExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("open_store_order");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(OpenStoreOrder record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("open_store_order");
        
        if (record.getUserId() != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=BIGINT}");
        }
        
        if (record.getOpenId() != null) {
            sql.VALUES("open_id", "#{openId,jdbcType=VARCHAR}");
        }
        
        if (record.getCommunityId() != null) {
            sql.VALUES("community_id", "#{communityId,jdbcType=BIGINT}");
        }
        
        if (record.getServiceId() != null) {
            sql.VALUES("service_id", "#{serviceId,jdbcType=INTEGER}");
        }
        
        if (record.getAddrInfoId() != null) {
            sql.VALUES("addr_info_id", "#{addrInfoId,jdbcType=INTEGER}");
        }
        
        if (record.getAddrInfo() != null) {
            sql.VALUES("addr_info", "#{addrInfo,jdbcType=VARCHAR}");
        }
        
        if (record.getAddrDetail() != null) {
            sql.VALUES("addr_detail", "#{addrDetail,jdbcType=VARCHAR}");
        }
        
        if (record.getUserName() != null) {
            sql.VALUES("user_name", "#{userName,jdbcType=VARCHAR}");
        }
        
        if (record.getMobile() != null) {
            sql.VALUES("mobile", "#{mobile,jdbcType=VARCHAR}");
        }
        
        if (record.getOrderCode() != null) {
            sql.VALUES("order_code", "#{orderCode,jdbcType=VARCHAR}");
        }
        
        if (record.getOutTradeNo() != null) {
            sql.VALUES("out_trade_no", "#{outTradeNo,jdbcType=VARCHAR}");
        }
        
        if (record.getExpressMoney() != null) {
            sql.VALUES("express_money", "#{expressMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getGoodsTotal() != null) {
            sql.VALUES("goods_total", "#{goodsTotal,jdbcType=DECIMAL}");
        }
        
        if (record.getOriginalPrice() != null) {
            sql.VALUES("original_price", "#{originalPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getDiscountPrice() != null) {
            sql.VALUES("discount_price", "#{discountPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getTotalAmount() != null) {
            sql.VALUES("total_amount", "#{totalAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getCouponPrice() != null) {
            sql.VALUES("coupon_price", "#{couponPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getVerifyStatus() != null) {
            sql.VALUES("verify_status", "#{verifyStatus,jdbcType=CHAR}");
        }
        
        if (record.getSubject() != null) {
            sql.VALUES("subject", "#{subject,jdbcType=VARCHAR}");
        }
        
        if (record.getBody() != null) {
            sql.VALUES("body", "#{body,jdbcType=VARCHAR}");
        }
        
        if (record.getDetail() != null) {
            sql.VALUES("detail", "#{detail,jdbcType=VARCHAR}");
        }
        
        if (record.getExpressType() != null) {
            sql.VALUES("express_type", "#{expressType,jdbcType=VARCHAR}");
        }
        
        if (record.getExpressName() != null) {
            sql.VALUES("express_name", "#{expressName,jdbcType=VARCHAR}");
        }
        
        if (record.getExpressCompanyCode() != null) {
            sql.VALUES("express_company_code", "#{expressCompanyCode,jdbcType=VARCHAR}");
        }
        
        if (record.getExpressCode() != null) {
            sql.VALUES("express_code", "#{expressCode,jdbcType=VARCHAR}");
        }
        
        if (record.getExpressStatus() != null) {
            sql.VALUES("express_status", "#{expressStatus,jdbcType=INTEGER}");
        }
        
        if (record.getSignForTime() != null) {
            sql.VALUES("sign_for_time", "#{signForTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getExpressTime() != null) {
            sql.VALUES("express_time", "#{expressTime,jdbcType=VARCHAR}");
        }
        
        if (record.getExpressArea() != null) {
            sql.VALUES("express_area", "#{expressArea,jdbcType=VARCHAR}");
        }
        
        if (record.getExpressPhone() != null) {
            sql.VALUES("express_phone", "#{expressPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getPayStatus() != null) {
            sql.VALUES("pay_status", "#{payStatus,jdbcType=INTEGER}");
        }
        
        if (record.getPayChannel() != null) {
            sql.VALUES("pay_channel", "#{payChannel,jdbcType=VARCHAR}");
        }
        
        if (record.getSendStatus() != null) {
            sql.VALUES("send_status", "#{sendStatus,jdbcType=INTEGER}");
        }
        
        if (record.getSendTime() != null) {
            sql.VALUES("send_time", "#{sendTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRefundTime() != null) {
            sql.VALUES("refund_time", "#{refundTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPayTime() != null) {
            sql.VALUES("pay_time", "#{payTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRefundStatus() != null) {
            sql.VALUES("refund_status", "#{refundStatus,jdbcType=INTEGER}");
        }
        
        if (record.getRefundApproval() != null) {
            sql.VALUES("refund_approval", "#{refundApproval,jdbcType=VARCHAR}");
        }
        
        if (record.getRefundComment() != null) {
            sql.VALUES("refund_comment", "#{refundComment,jdbcType=VARCHAR}");
        }
        
        if (record.getRefundRemark() != null) {
            sql.VALUES("refund_remark", "#{refundRemark,jdbcType=VARCHAR}");
        }
        
        if (record.getResultStatus() != null) {
            sql.VALUES("result_status", "#{resultStatus,jdbcType=INTEGER}");
        }
        
        if (record.getSameWay() != null) {
            sql.VALUES("same_way", "#{sameWay,jdbcType=INTEGER}");
        }
        
        if (record.getOpenRefundId() != null) {
            sql.VALUES("open_refund_id", "#{openRefundId,jdbcType=BIGINT}");
        }
        
        if (record.getRemark() != null) {
            sql.VALUES("remark", "#{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getInvalidTime() != null) {
            sql.VALUES("invalid_time", "#{invalidTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getConfirmTime() != null) {
            sql.VALUES("confirm_time", "#{confirmTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getResourceType() != null) {
            sql.VALUES("resource_type", "#{resourceType,jdbcType=INTEGER}");
        }
        
        if (record.getCouponRecordId() != null) {
            sql.VALUES("coupon_record_id", "#{couponRecordId,jdbcType=BIGINT}");
        }
        
        if (record.getType() != null) {
            sql.VALUES("type", "#{type,jdbcType=VARCHAR}");
        }
        
        if (record.getXfsjId() != null) {
            sql.VALUES("xfsj_id", "#{xfsjId,jdbcType=BIGINT}");
        }
        
        if (record.getCommentStatus() != null) {
            sql.VALUES("comment_status", "#{commentStatus,jdbcType=VARCHAR}");
        }
        
        if (record.getGroupStatus() != null) {
            sql.VALUES("group_status", "#{groupStatus,jdbcType=INTEGER}");
        }
        
        if (record.getGroupInfoId() != null) {
            sql.VALUES("group_info_id", "#{groupInfoId,jdbcType=BIGINT}");
        }
        
        if (record.getGroupDataId() != null) {
            sql.VALUES("group_data_id", "#{groupDataId,jdbcType=BIGINT}");
        }
        
        return sql.toString();
    }

    public String selectByExample(OpenStoreOrderExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("user_id");
        sql.SELECT("open_id");
        sql.SELECT("community_id");
        sql.SELECT("service_id");
        sql.SELECT("addr_info_id");
        sql.SELECT("addr_info");
        sql.SELECT("addr_detail");
        sql.SELECT("user_name");
        sql.SELECT("mobile");
        sql.SELECT("order_code");
        sql.SELECT("out_trade_no");
        sql.SELECT("express_money");
        sql.SELECT("goods_total");
        sql.SELECT("original_price");
        sql.SELECT("discount_price");
        sql.SELECT("total_amount");
        sql.SELECT("coupon_price");
        sql.SELECT("verify_status");
        sql.SELECT("subject");
        sql.SELECT("body");
        sql.SELECT("detail");
        sql.SELECT("express_type");
        sql.SELECT("express_name");
        sql.SELECT("express_company_code");
        sql.SELECT("express_code");
        sql.SELECT("express_status");
        sql.SELECT("sign_for_time");
        sql.SELECT("express_time");
        sql.SELECT("express_area");
        sql.SELECT("express_phone");
        sql.SELECT("pay_status");
        sql.SELECT("pay_channel");
        sql.SELECT("send_status");
        sql.SELECT("send_time");
        sql.SELECT("refund_time");
        sql.SELECT("pay_time");
        sql.SELECT("refund_status");
        sql.SELECT("refund_approval");
        sql.SELECT("refund_comment");
        sql.SELECT("refund_remark");
        sql.SELECT("result_status");
        sql.SELECT("same_way");
        sql.SELECT("open_refund_id");
        sql.SELECT("remark");
        sql.SELECT("create_time");
        sql.SELECT("invalid_time");
        sql.SELECT("confirm_time");
        sql.SELECT("resource_type");
        sql.SELECT("coupon_record_id");
        sql.SELECT("type");
        sql.SELECT("xfsj_id");
        sql.SELECT("comment_status");
        sql.SELECT("group_status");
        sql.SELECT("group_info_id");
        sql.SELECT("group_data_id");
        sql.FROM("open_store_order");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        OpenStoreOrder record = (OpenStoreOrder) parameter.get("record");
        OpenStoreOrderExample example = (OpenStoreOrderExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("open_store_order");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{record.userId,jdbcType=BIGINT}");
        }
        
        if (record.getOpenId() != null) {
            sql.SET("open_id = #{record.openId,jdbcType=VARCHAR}");
        }
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{record.communityId,jdbcType=BIGINT}");
        }
        
        if (record.getServiceId() != null) {
            sql.SET("service_id = #{record.serviceId,jdbcType=INTEGER}");
        }
        
        if (record.getAddrInfoId() != null) {
            sql.SET("addr_info_id = #{record.addrInfoId,jdbcType=INTEGER}");
        }
        
        if (record.getAddrInfo() != null) {
            sql.SET("addr_info = #{record.addrInfo,jdbcType=VARCHAR}");
        }
        
        if (record.getAddrDetail() != null) {
            sql.SET("addr_detail = #{record.addrDetail,jdbcType=VARCHAR}");
        }
        
        if (record.getUserName() != null) {
            sql.SET("user_name = #{record.userName,jdbcType=VARCHAR}");
        }
        
        if (record.getMobile() != null) {
            sql.SET("mobile = #{record.mobile,jdbcType=VARCHAR}");
        }
        
        if (record.getOrderCode() != null) {
            sql.SET("order_code = #{record.orderCode,jdbcType=VARCHAR}");
        }
        
        if (record.getOutTradeNo() != null) {
            sql.SET("out_trade_no = #{record.outTradeNo,jdbcType=VARCHAR}");
        }
        
        if (record.getExpressMoney() != null) {
            sql.SET("express_money = #{record.expressMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getGoodsTotal() != null) {
            sql.SET("goods_total = #{record.goodsTotal,jdbcType=DECIMAL}");
        }
        
        if (record.getOriginalPrice() != null) {
            sql.SET("original_price = #{record.originalPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getDiscountPrice() != null) {
            sql.SET("discount_price = #{record.discountPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getTotalAmount() != null) {
            sql.SET("total_amount = #{record.totalAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getCouponPrice() != null) {
            sql.SET("coupon_price = #{record.couponPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getVerifyStatus() != null) {
            sql.SET("verify_status = #{record.verifyStatus,jdbcType=CHAR}");
        }
        
        if (record.getSubject() != null) {
            sql.SET("subject = #{record.subject,jdbcType=VARCHAR}");
        }
        
        if (record.getBody() != null) {
            sql.SET("body = #{record.body,jdbcType=VARCHAR}");
        }
        
        if (record.getDetail() != null) {
            sql.SET("detail = #{record.detail,jdbcType=VARCHAR}");
        }
        
        if (record.getExpressType() != null) {
            sql.SET("express_type = #{record.expressType,jdbcType=VARCHAR}");
        }
        
        if (record.getExpressName() != null) {
            sql.SET("express_name = #{record.expressName,jdbcType=VARCHAR}");
        }
        
        if (record.getExpressCompanyCode() != null) {
            sql.SET("express_company_code = #{record.expressCompanyCode,jdbcType=VARCHAR}");
        }
        
        if (record.getExpressCode() != null) {
            sql.SET("express_code = #{record.expressCode,jdbcType=VARCHAR}");
        }
        
        if (record.getExpressStatus() != null) {
            sql.SET("express_status = #{record.expressStatus,jdbcType=INTEGER}");
        }
        
        if (record.getSignForTime() != null) {
            sql.SET("sign_for_time = #{record.signForTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getExpressTime() != null) {
            sql.SET("express_time = #{record.expressTime,jdbcType=VARCHAR}");
        }
        
        if (record.getExpressArea() != null) {
            sql.SET("express_area = #{record.expressArea,jdbcType=VARCHAR}");
        }
        
        if (record.getExpressPhone() != null) {
            sql.SET("express_phone = #{record.expressPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getPayStatus() != null) {
            sql.SET("pay_status = #{record.payStatus,jdbcType=INTEGER}");
        }
        
        if (record.getPayChannel() != null) {
            sql.SET("pay_channel = #{record.payChannel,jdbcType=VARCHAR}");
        }
        
        if (record.getSendStatus() != null) {
            sql.SET("send_status = #{record.sendStatus,jdbcType=INTEGER}");
        }
        
        if (record.getSendTime() != null) {
            sql.SET("send_time = #{record.sendTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRefundTime() != null) {
            sql.SET("refund_time = #{record.refundTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPayTime() != null) {
            sql.SET("pay_time = #{record.payTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRefundStatus() != null) {
            sql.SET("refund_status = #{record.refundStatus,jdbcType=INTEGER}");
        }
        
        if (record.getRefundApproval() != null) {
            sql.SET("refund_approval = #{record.refundApproval,jdbcType=VARCHAR}");
        }
        
        if (record.getRefundComment() != null) {
            sql.SET("refund_comment = #{record.refundComment,jdbcType=VARCHAR}");
        }
        
        if (record.getRefundRemark() != null) {
            sql.SET("refund_remark = #{record.refundRemark,jdbcType=VARCHAR}");
        }
        
        if (record.getResultStatus() != null) {
            sql.SET("result_status = #{record.resultStatus,jdbcType=INTEGER}");
        }
        
        if (record.getSameWay() != null) {
            sql.SET("same_way = #{record.sameWay,jdbcType=INTEGER}");
        }
        
        if (record.getOpenRefundId() != null) {
            sql.SET("open_refund_id = #{record.openRefundId,jdbcType=BIGINT}");
        }
        
        if (record.getRemark() != null) {
            sql.SET("remark = #{record.remark,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getInvalidTime() != null) {
            sql.SET("invalid_time = #{record.invalidTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getConfirmTime() != null) {
            sql.SET("confirm_time = #{record.confirmTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getResourceType() != null) {
            sql.SET("resource_type = #{record.resourceType,jdbcType=INTEGER}");
        }
        
        if (record.getCouponRecordId() != null) {
            sql.SET("coupon_record_id = #{record.couponRecordId,jdbcType=BIGINT}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{record.type,jdbcType=VARCHAR}");
        }
        
        if (record.getXfsjId() != null) {
            sql.SET("xfsj_id = #{record.xfsjId,jdbcType=BIGINT}");
        }
        
        if (record.getCommentStatus() != null) {
            sql.SET("comment_status = #{record.commentStatus,jdbcType=VARCHAR}");
        }
        
        if (record.getGroupStatus() != null) {
            sql.SET("group_status = #{record.groupStatus,jdbcType=INTEGER}");
        }
        
        if (record.getGroupInfoId() != null) {
            sql.SET("group_info_id = #{record.groupInfoId,jdbcType=BIGINT}");
        }
        
        if (record.getGroupDataId() != null) {
            sql.SET("group_data_id = #{record.groupDataId,jdbcType=BIGINT}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("open_store_order");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("user_id = #{record.userId,jdbcType=BIGINT}");
        sql.SET("open_id = #{record.openId,jdbcType=VARCHAR}");
        sql.SET("community_id = #{record.communityId,jdbcType=BIGINT}");
        sql.SET("service_id = #{record.serviceId,jdbcType=INTEGER}");
        sql.SET("addr_info_id = #{record.addrInfoId,jdbcType=INTEGER}");
        sql.SET("addr_info = #{record.addrInfo,jdbcType=VARCHAR}");
        sql.SET("addr_detail = #{record.addrDetail,jdbcType=VARCHAR}");
        sql.SET("user_name = #{record.userName,jdbcType=VARCHAR}");
        sql.SET("mobile = #{record.mobile,jdbcType=VARCHAR}");
        sql.SET("order_code = #{record.orderCode,jdbcType=VARCHAR}");
        sql.SET("out_trade_no = #{record.outTradeNo,jdbcType=VARCHAR}");
        sql.SET("express_money = #{record.expressMoney,jdbcType=DECIMAL}");
        sql.SET("goods_total = #{record.goodsTotal,jdbcType=DECIMAL}");
        sql.SET("original_price = #{record.originalPrice,jdbcType=DECIMAL}");
        sql.SET("discount_price = #{record.discountPrice,jdbcType=DECIMAL}");
        sql.SET("total_amount = #{record.totalAmount,jdbcType=DECIMAL}");
        sql.SET("coupon_price = #{record.couponPrice,jdbcType=DECIMAL}");
        sql.SET("verify_status = #{record.verifyStatus,jdbcType=CHAR}");
        sql.SET("subject = #{record.subject,jdbcType=VARCHAR}");
        sql.SET("body = #{record.body,jdbcType=VARCHAR}");
        sql.SET("detail = #{record.detail,jdbcType=VARCHAR}");
        sql.SET("express_type = #{record.expressType,jdbcType=VARCHAR}");
        sql.SET("express_name = #{record.expressName,jdbcType=VARCHAR}");
        sql.SET("express_company_code = #{record.expressCompanyCode,jdbcType=VARCHAR}");
        sql.SET("express_code = #{record.expressCode,jdbcType=VARCHAR}");
        sql.SET("express_status = #{record.expressStatus,jdbcType=INTEGER}");
        sql.SET("sign_for_time = #{record.signForTime,jdbcType=TIMESTAMP}");
        sql.SET("express_time = #{record.expressTime,jdbcType=VARCHAR}");
        sql.SET("express_area = #{record.expressArea,jdbcType=VARCHAR}");
        sql.SET("express_phone = #{record.expressPhone,jdbcType=VARCHAR}");
        sql.SET("pay_status = #{record.payStatus,jdbcType=INTEGER}");
        sql.SET("pay_channel = #{record.payChannel,jdbcType=VARCHAR}");
        sql.SET("send_status = #{record.sendStatus,jdbcType=INTEGER}");
        sql.SET("send_time = #{record.sendTime,jdbcType=TIMESTAMP}");
        sql.SET("refund_time = #{record.refundTime,jdbcType=TIMESTAMP}");
        sql.SET("pay_time = #{record.payTime,jdbcType=TIMESTAMP}");
        sql.SET("refund_status = #{record.refundStatus,jdbcType=INTEGER}");
        sql.SET("refund_approval = #{record.refundApproval,jdbcType=VARCHAR}");
        sql.SET("refund_comment = #{record.refundComment,jdbcType=VARCHAR}");
        sql.SET("refund_remark = #{record.refundRemark,jdbcType=VARCHAR}");
        sql.SET("result_status = #{record.resultStatus,jdbcType=INTEGER}");
        sql.SET("same_way = #{record.sameWay,jdbcType=INTEGER}");
        sql.SET("open_refund_id = #{record.openRefundId,jdbcType=BIGINT}");
        sql.SET("remark = #{record.remark,jdbcType=VARCHAR}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("invalid_time = #{record.invalidTime,jdbcType=TIMESTAMP}");
        sql.SET("confirm_time = #{record.confirmTime,jdbcType=TIMESTAMP}");
        sql.SET("resource_type = #{record.resourceType,jdbcType=INTEGER}");
        sql.SET("coupon_record_id = #{record.couponRecordId,jdbcType=BIGINT}");
        sql.SET("type = #{record.type,jdbcType=VARCHAR}");
        sql.SET("xfsj_id = #{record.xfsjId,jdbcType=BIGINT}");
        sql.SET("comment_status = #{record.commentStatus,jdbcType=VARCHAR}");
        sql.SET("group_status = #{record.groupStatus,jdbcType=INTEGER}");
        sql.SET("group_info_id = #{record.groupInfoId,jdbcType=BIGINT}");
        sql.SET("group_data_id = #{record.groupDataId,jdbcType=BIGINT}");
        
        OpenStoreOrderExample example = (OpenStoreOrderExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(OpenStoreOrder record) {
        SQL sql = new SQL();
        sql.UPDATE("open_store_order");
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{userId,jdbcType=BIGINT}");
        }
        
        if (record.getOpenId() != null) {
            sql.SET("open_id = #{openId,jdbcType=VARCHAR}");
        }
        
        if (record.getCommunityId() != null) {
            sql.SET("community_id = #{communityId,jdbcType=BIGINT}");
        }
        
        if (record.getServiceId() != null) {
            sql.SET("service_id = #{serviceId,jdbcType=INTEGER}");
        }
        
        if (record.getAddrInfoId() != null) {
            sql.SET("addr_info_id = #{addrInfoId,jdbcType=INTEGER}");
        }
        
        if (record.getAddrInfo() != null) {
            sql.SET("addr_info = #{addrInfo,jdbcType=VARCHAR}");
        }
        
        if (record.getAddrDetail() != null) {
            sql.SET("addr_detail = #{addrDetail,jdbcType=VARCHAR}");
        }
        
        if (record.getUserName() != null) {
            sql.SET("user_name = #{userName,jdbcType=VARCHAR}");
        }
        
        if (record.getMobile() != null) {
            sql.SET("mobile = #{mobile,jdbcType=VARCHAR}");
        }
        
        if (record.getOrderCode() != null) {
            sql.SET("order_code = #{orderCode,jdbcType=VARCHAR}");
        }
        
        if (record.getOutTradeNo() != null) {
            sql.SET("out_trade_no = #{outTradeNo,jdbcType=VARCHAR}");
        }
        
        if (record.getExpressMoney() != null) {
            sql.SET("express_money = #{expressMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getGoodsTotal() != null) {
            sql.SET("goods_total = #{goodsTotal,jdbcType=DECIMAL}");
        }
        
        if (record.getOriginalPrice() != null) {
            sql.SET("original_price = #{originalPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getDiscountPrice() != null) {
            sql.SET("discount_price = #{discountPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getTotalAmount() != null) {
            sql.SET("total_amount = #{totalAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getCouponPrice() != null) {
            sql.SET("coupon_price = #{couponPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getVerifyStatus() != null) {
            sql.SET("verify_status = #{verifyStatus,jdbcType=CHAR}");
        }
        
        if (record.getSubject() != null) {
            sql.SET("subject = #{subject,jdbcType=VARCHAR}");
        }
        
        if (record.getBody() != null) {
            sql.SET("body = #{body,jdbcType=VARCHAR}");
        }
        
        if (record.getDetail() != null) {
            sql.SET("detail = #{detail,jdbcType=VARCHAR}");
        }
        
        if (record.getExpressType() != null) {
            sql.SET("express_type = #{expressType,jdbcType=VARCHAR}");
        }
        
        if (record.getExpressName() != null) {
            sql.SET("express_name = #{expressName,jdbcType=VARCHAR}");
        }
        
        if (record.getExpressCompanyCode() != null) {
            sql.SET("express_company_code = #{expressCompanyCode,jdbcType=VARCHAR}");
        }
        
        if (record.getExpressCode() != null) {
            sql.SET("express_code = #{expressCode,jdbcType=VARCHAR}");
        }
        
        if (record.getExpressStatus() != null) {
            sql.SET("express_status = #{expressStatus,jdbcType=INTEGER}");
        }
        
        if (record.getSignForTime() != null) {
            sql.SET("sign_for_time = #{signForTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getExpressTime() != null) {
            sql.SET("express_time = #{expressTime,jdbcType=VARCHAR}");
        }
        
        if (record.getExpressArea() != null) {
            sql.SET("express_area = #{expressArea,jdbcType=VARCHAR}");
        }
        
        if (record.getExpressPhone() != null) {
            sql.SET("express_phone = #{expressPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getPayStatus() != null) {
            sql.SET("pay_status = #{payStatus,jdbcType=INTEGER}");
        }
        
        if (record.getPayChannel() != null) {
            sql.SET("pay_channel = #{payChannel,jdbcType=VARCHAR}");
        }
        
        if (record.getSendStatus() != null) {
            sql.SET("send_status = #{sendStatus,jdbcType=INTEGER}");
        }
        
        if (record.getSendTime() != null) {
            sql.SET("send_time = #{sendTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRefundTime() != null) {
            sql.SET("refund_time = #{refundTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPayTime() != null) {
            sql.SET("pay_time = #{payTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRefundStatus() != null) {
            sql.SET("refund_status = #{refundStatus,jdbcType=INTEGER}");
        }
        
        if (record.getRefundApproval() != null) {
            sql.SET("refund_approval = #{refundApproval,jdbcType=VARCHAR}");
        }
        
        if (record.getRefundComment() != null) {
            sql.SET("refund_comment = #{refundComment,jdbcType=VARCHAR}");
        }
        
        if (record.getRefundRemark() != null) {
            sql.SET("refund_remark = #{refundRemark,jdbcType=VARCHAR}");
        }
        
        if (record.getResultStatus() != null) {
            sql.SET("result_status = #{resultStatus,jdbcType=INTEGER}");
        }
        
        if (record.getSameWay() != null) {
            sql.SET("same_way = #{sameWay,jdbcType=INTEGER}");
        }
        
        if (record.getOpenRefundId() != null) {
            sql.SET("open_refund_id = #{openRefundId,jdbcType=BIGINT}");
        }
        
        if (record.getRemark() != null) {
            sql.SET("remark = #{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getInvalidTime() != null) {
            sql.SET("invalid_time = #{invalidTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getConfirmTime() != null) {
            sql.SET("confirm_time = #{confirmTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getResourceType() != null) {
            sql.SET("resource_type = #{resourceType,jdbcType=INTEGER}");
        }
        
        if (record.getCouponRecordId() != null) {
            sql.SET("coupon_record_id = #{couponRecordId,jdbcType=BIGINT}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{type,jdbcType=VARCHAR}");
        }
        
        if (record.getXfsjId() != null) {
            sql.SET("xfsj_id = #{xfsjId,jdbcType=BIGINT}");
        }
        
        if (record.getCommentStatus() != null) {
            sql.SET("comment_status = #{commentStatus,jdbcType=VARCHAR}");
        }
        
        if (record.getGroupStatus() != null) {
            sql.SET("group_status = #{groupStatus,jdbcType=INTEGER}");
        }
        
        if (record.getGroupInfoId() != null) {
            sql.SET("group_info_id = #{groupInfoId,jdbcType=BIGINT}");
        }
        
        if (record.getGroupDataId() != null) {
            sql.SET("group_data_id = #{groupDataId,jdbcType=BIGINT}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, OpenStoreOrderExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}