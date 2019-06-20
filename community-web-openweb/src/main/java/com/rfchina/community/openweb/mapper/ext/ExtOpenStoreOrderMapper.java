package com.rfchina.community.openweb.mapper.ext;

import com.rfchina.community.openweb.entity.ExtOpenStoreOrder;
import com.rfchina.community.persistence.mapper.OpenStoreOrderMapper;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;

import java.util.Map;

/**
 */
public interface ExtOpenStoreOrderMapper extends OpenStoreOrderMapper {

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
	         @Result(column="refund_status", property="refundStatus", jdbcType=JdbcType.INTEGER),
	         @Result(column="refund_approval", property="refundApproval", jdbcType=JdbcType.VARCHAR),
	         @Result(column="refund_comment", property="refundComment", jdbcType=JdbcType.VARCHAR),
	         @Result(column="result_status", property="resultStatus", jdbcType=JdbcType.INTEGER),
	         @Result(column="same_way", property="sameWay", jdbcType=JdbcType.INTEGER),
	         @Result(column="open_refund_id", property="openRefundId", jdbcType=JdbcType.BIGINT),
	         @Result(column="refund_remark", property="refundRemark", jdbcType=JdbcType.VARCHAR),
	         @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
	         @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
	         @Result(column="invalid_time", property="invalidTime", jdbcType=JdbcType.TIMESTAMP),
	         @Result(column="confirm_time", property="confirmTime", jdbcType=JdbcType.TIMESTAMP),
			 @Result(column="comment_status", property="commentStatus", jdbcType=JdbcType.VARCHAR),
			 @Result(column="group_status", property="groupStatus", jdbcType=JdbcType.INTEGER),
			 @Result(column="group_success_status", property="groupSuccessStatus", jdbcType=JdbcType.INTEGER)
	     })
	 	public PageList<ExtOpenStoreOrder> pageByCondition(Map<String, Object> param, PageBounds pageBounds);
	 	 
	 	@Select(value = {
	 			"   SELECT " + 
	 			"	IFNULL(sum(amount),0) sum " + 
	 			"   FROM " + 
	 			"	open_store_order _order," + 
	 			"	open_store_good_order_rel _rel " +
	 			"   WHERE " +
	 			"   _order.id = _rel.order_id " + 
	 		    "   and _order.pay_status = 1 " +
	 		    "   and _rel.good_id = #{goodId} "}) 
		public int countSaleAmount(@Param("goodId") int goodId);
}
