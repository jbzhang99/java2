package com.rfchina.community.open.bridge.mapper.ext;

import com.rfchina.community.open.bridge.entity.ExtOpenStoreOrder;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;

import java.math.BigDecimal;
import java.util.Map;

/**
 */
public interface ExtOpenStoreOrderMapper {

	 	 @SelectProvider(type=ExtOpenStoreOrderSqlProvider.class, method="pageByCondition")
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
	         @Result(column="express_code", property="expressCode", jdbcType=JdbcType.VARCHAR),
	         @Result(column="express_time", property="expressTime", jdbcType=JdbcType.VARCHAR),
	         @Result(column="express_area", property="expressArea", jdbcType=JdbcType.VARCHAR),
	         @Result(column="express_phone", property="expressPhone", jdbcType=JdbcType.VARCHAR),
	         @Result(column="pay_status", property="payStatus", jdbcType=JdbcType.INTEGER),
	         @Result(column="pay_channel", property="payChannel", jdbcType=JdbcType.VARCHAR),
	         @Result(column="send_status", property="sendStatus", jdbcType=JdbcType.INTEGER),
	         @Result(column="send_time", property="sendTime", jdbcType=JdbcType.TIMESTAMP),
	         @Result(column="refund_time", property="refundTime", jdbcType=JdbcType.TIMESTAMP),
	         @Result(column="refund_status", property="refundStatus", jdbcType=JdbcType.INTEGER),
	         @Result(column="refund_approval", property="refundApproval", jdbcType=JdbcType.VARCHAR),
	         @Result(column="refund_comment", property="refundComment", jdbcType=JdbcType.VARCHAR),
	         @Result(column="result_status", property="resultStatus", jdbcType=JdbcType.INTEGER),
	         @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
	         @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
	         @Result(column="invalid_time", property="invalidTime", jdbcType=JdbcType.TIMESTAMP),
	         @Result(column="confirm_time", property="confirmTime", jdbcType=JdbcType.TIMESTAMP),
	         @Result(column="service_title", property="serviceTitle", jdbcType=JdbcType.VARCHAR),
	         @Result(column="merchant_id", property="merchantId", jdbcType=JdbcType.BIGINT),
	         @Result(column="merchant_title", property="merchantTitle", jdbcType=JdbcType.VARCHAR),
	         @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
	         @Result(column="xfsj_id", property="xfsjId", jdbcType=JdbcType.BIGINT),
	         @Result(column="community_title", property="communityTitle", jdbcType=JdbcType.VARCHAR),
			 @Result(column="comment_status", property="commentStatus", jdbcType=JdbcType.VARCHAR),
			 @Result(column="group_status", property="groupStatus", jdbcType=JdbcType.INTEGER),
			 @Result(column="express_company_code", property="expressCompanyCode", jdbcType=JdbcType.VARCHAR),
			 @Result(column="express_status", property="expressStatus", jdbcType=JdbcType.INTEGER),
			 @Result(column="sign_for_time", property="signForTime", jdbcType=JdbcType.TIMESTAMP)
	     })
	 	public PageList<ExtOpenStoreOrder> pageByCondition(Map<String, Object> param, PageBounds pageBounds);

	 	 @SelectProvider(type=ExtOpenStoreOrderSqlProvider.class, method="pageByExportCondition")
	     @Results({
	         @Result(column="order_code", property="orderCode", jdbcType=JdbcType.VARCHAR),
	         @Result(column="community_trade_no", property="communityTradeNo", jdbcType=JdbcType.VARCHAR),
	         @Result(column="out_trade_no", property="outTradeNo", jdbcType=JdbcType.VARCHAR),
	         @Result(column="express_money", property="expressMoney", jdbcType=JdbcType.DECIMAL),
	         @Result(column="goods_total", property="goodsTotal", jdbcType=JdbcType.DECIMAL),
	         @Result(column="original_price", property="originalPrice", jdbcType=JdbcType.DECIMAL),
	         @Result(column="discount_price", property="discountPrice", jdbcType=JdbcType.DECIMAL),
	         @Result(column="total_amount", property="totalAmount", jdbcType=JdbcType.DECIMAL),
	         @Result(column="coupon_price", property="couponPrice", jdbcType=JdbcType.DECIMAL),
	         @Result(column="platform_charge", property="platformCharge", jdbcType=JdbcType.DECIMAL),
	         @Result(column="service_charge", property="serviceCharge", jdbcType=JdbcType.DECIMAL),
			 @Result(column="think_charge", property="thinkCharge", jdbcType=JdbcType.DECIMAL),
	         @Result(column="refund_money", property="refundMoney", jdbcType=JdbcType.DECIMAL),
	         @Result(column="receipt_amount", property="receiptAmount", jdbcType=JdbcType.DECIMAL),
	         @Result(column="verify_status", property="verifyStatus", jdbcType=JdbcType.CHAR),
	         @Result(column="pay_status", property="payStatus", jdbcType=JdbcType.INTEGER),
	         @Result(column="pay_channel", property="payChannel", jdbcType=JdbcType.VARCHAR),
	         @Result(column="send_status", property="sendStatus", jdbcType=JdbcType.INTEGER),
	         @Result(column="refund_status", property="refundStatus", jdbcType=JdbcType.INTEGER),
	         @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
	         @Result(column="bill_finished_time", property="billFinishTime", jdbcType=JdbcType.TIMESTAMP),
	         @Result(column="service_title", property="serviceTitle", jdbcType=JdbcType.VARCHAR),
	         @Result(column="merchant_title", property="merchantTitle", jdbcType=JdbcType.VARCHAR),
	         @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
	         @Result(column="refund_id", property="refundId", jdbcType=JdbcType.VARCHAR),
			 @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
	         @Result(column="bill_id", property="billId", jdbcType=JdbcType.VARCHAR),
	         @Result(column="activity_title", property="activityTitle", jdbcType=JdbcType.VARCHAR),
			 @Result(column="user_phone", property="userPhone", jdbcType=JdbcType.VARCHAR),
			 @Result(column="express_name", property="expressName", jdbcType=JdbcType.VARCHAR),
			 @Result(column="express_area", property="expressArea", jdbcType=JdbcType.VARCHAR),
			 @Result(column="express_phone", property="expressPhone", jdbcType=JdbcType.VARCHAR),
			 @Result(column="addr_detail", property="addrDetail", jdbcType=JdbcType.VARCHAR),
			 @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
			 @Result(column="mobile", property="mobile", jdbcType=JdbcType.VARCHAR),
			 @Result(column="group_status", property="groupStatus", jdbcType=JdbcType.INTEGER),
	         @Result(column="community_title", property="communityTitle", jdbcType=JdbcType.VARCHAR),
			 @Result(column="comment_status", property="commentStatus", jdbcType=JdbcType.VARCHAR)
	     })

	public PageList<ExtOpenStoreOrder> pageByExportCondition(Map<String, Object> param, PageBounds pageBounds);

	 	 
	 	@SelectProvider(type=ExtOpenStoreOrderSqlProvider.class, method="getSuccessTotalMoney")
		public BigDecimal getSuccessTotalMoney(Map<String, Object> param);
}
