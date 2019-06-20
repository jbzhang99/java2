package com.rfchina.community.openstore.mapper.ext;

import com.rfchina.community.persistence.mapper.UserInfoSqlProvider;
import com.rfchina.community.persistence.model.OpenStoreOrder;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;
import java.util.Map;

/**
 */
public interface ExtOpenStoreOrderMapper {

	 	@SelectProvider(type=ExtOpenStoreOrderSqlProvider.class, method="selectWithOutOpenId")
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
	        @Result(column="total_amount", property="totalAmount", jdbcType=JdbcType.DECIMAL),
	        @Result(column="subject", property="subject", jdbcType=JdbcType.VARCHAR),
	        @Result(column="body", property="body", jdbcType=JdbcType.VARCHAR),
	        @Result(column="detail", property="detail", jdbcType=JdbcType.VARCHAR),
	        @Result(column="express_type", property="expressType", jdbcType=JdbcType.VARCHAR),
	        @Result(column="express_name", property="expressName", jdbcType=JdbcType.VARCHAR),
	        @Result(column="express_code", property="expressCode", jdbcType=JdbcType.VARCHAR),
	        @Result(column="express_time", property="expressTime", jdbcType=JdbcType.VARCHAR),
	        @Result(column="express_area", property="expressArea", jdbcType=JdbcType.VARCHAR),
	        @Result(column="express_phone", property="expressPhone", jdbcType=JdbcType.VARCHAR),
			@Result(column="express_company_code", property="expressCompanyCode", jdbcType=JdbcType.VARCHAR),
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
			@Result(column="comment_status", property="commentStatus", jdbcType=JdbcType.VARCHAR)
	    })
		public List<OpenStoreOrder> selectWithOutOpenId(Map<String, Object> param);


	 	@Select({"select sum(CASE WHEN pay_status = 0 THEN 1 ELSE 0 END) type1," +
				"sum(CASE WHEN pay_status = 1 AND send_status = 0 THEN 1 ELSE 0 END) type2," +
				"sum(CASE WHEN pay_status = 1 AND send_status = 1 THEN 1 ELSE 0 END) type3," +
				"sum(CASE WHEN pay_status = 1 AND send_status = 2 THEN 1 ELSE 0 END) type4," +
				"sum(CASE WHEN pay_status = 1 AND comment_status = 0 THEN 1 ELSE 0 END) type5 " +
				"from open_store_order where user_id=#{userId}"})
	 	Map<String,Integer> countByUserId(@Param("userId") Long uid);

	@SelectProvider(type=ExtOpenStoreOrderSqlProvider.class, method="countByUserIdAndGoodId")
	long countByUserIdAndGoodId(Map<String, Object> param);
}
