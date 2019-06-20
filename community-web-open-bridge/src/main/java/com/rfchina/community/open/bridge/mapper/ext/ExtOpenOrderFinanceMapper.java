package com.rfchina.community.open.bridge.mapper.ext;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 包含社区和平台
 * 
 * @author liyicun
 *
 */
public interface ExtOpenOrderFinanceMapper {

	@Select({
			"<script><![CDATA[ select  s.id,s.title as service_title,m.title as merchant_title,s.app_id "
					+ " from open_order a,community_service s,open_merchant_info m "
					+ " where a.app_id=s.app_id and m.id=s.merchant_id  ]]>",
			"<if test=\"stitle != null \"> and s.title like #{stitle} </if> ",
			"<if test=\"mtitle != null \"> and m.title like #{mtitle}</if> ",
			"<![CDATA[ group by  s.id  limit #{index},#{limit} ]]></script>" })
	public List<Map<String, Object>> listPF(@Param("stitle") String stitle, @Param("mtitle") String mtitle,
			@Param("index") int index, @Param("limit") int limit);

	@Select({ "<script><![CDATA[ SELECT count(*) FROM	("
			+ " select  count(1) from open_order a,community_service s,open_merchant_info m where a.app_id=s.app_id and m.id=s.merchant_id  ]]>",
			"<if test=\"stitle != null \"> and s.title like #{stitle} </if> ",
			"<if test=\"mtitle != null \"> and m.title like #{mtitle} </if> ",
			"<![CDATA[ group by  s.id  ) AS b  ]]></script>" })
	public long countListPF(@Param("stitle") String stitle, @Param("mtitle") String mtitle);

	/// 提现金额
	@Select({
			"<script><![CDATA[ select service_id,sum(receipt_amount) as sum from open_order where type in(1, 4) and bill_status=2  and balance_status=2  ]]>",
			" and withdraw_status in (${withdraw_status}) ", " and service_id in (${service_id}) ",
			"<![CDATA[  group by service_id    ]]></script>" })
	public List<Map<String, Object>> sumWithdrawalAmountPF(@Param("withdraw_status") String withdraw_status,
			@Param("service_id") String service_id);

	// 社区服务费
	@Select({
			"<script><![CDATA[ select service_id,sum(service_charge) as sum from open_order where type in(1, 4) and bill_status=2  and balance_status=2  ]]>",
			" and service_charge_status =${service_charge_status} ", " and service_id in (${service_id}) ",
			"<![CDATA[  group by service_id    ]]></script>" })
	public List<Map<String, Object>> sumServiceChargePF(@Param("service_charge_status") String service_charge_status,
			@Param("service_id") String service_id);

	// 平台手续费
	@Select({
			"<script><![CDATA[ select service_id,sum(platform_charge) as sum from open_order where type in(1, 4) and bill_status=2    ]]>",
			" and service_id in (${service_id}) ", "<![CDATA[  group by service_id    ]]></script>" })
	public List<Map<String, Object>> sumPlatformChargePF(@Param("service_id") String service_id);

	// 平台退款金额
	@Select({
			"<script><![CDATA[ select service_id,sum(refund_money) as sum from open_order where type in(1, 4) and bill_status=2  and refund_status=2   ]]>",
			" and service_id in (${service_id}) ", "<![CDATA[  group by service_id    ]]></script>" })
	public List<Map<String, Object>> sumRefundMoneyPF(@Param("service_id") String service_id);

	// 统计 提现金额
	@Select({
			"<script><![CDATA[ select sum(receipt_amount) as sum from open_order where type in(1, 4) and bill_status=2  and balance_status=2  ]]>",
			" and withdraw_status in (${withdraw_status}) ", " </script>" })
	public Double sumTotalWithdrawalAmountPF(@Param("withdraw_status") String withdraw_status);

	// 统计 社区服务费 去掉退款的金额
	@Select({
			"<script><![CDATA[ select sum(service_charge) as sum from open_order where type in(1, 4) and bill_status=2  and balance_status=2  ]]>",
			" and service_charge_status = #{service_charge_status} ", " </script>" })
	public Double sumTotalServiceChargePF(@Param("service_charge_status") String service_charge_status);

	// 统计 平台手续费
	@Select({
			"<script><![CDATA[ select  sum(platform_charge) as sum from open_order where type in(1, 4) and bill_status= 2    ]]>",
			" </script>" })
	public Double sumTotalPlatformChargePF();

	// 统计 平台退款金额
	@Select({
			"<script><![CDATA[ select  sum(refund_money) as sum from open_order where type in(1, 4) and bill_status= 2 and refund_status=2   ]]>",
			" </script>" })
	public Double sumTotalRefundMoneyPF();

	// ------------------------------------
	@Select({
			"<script><![CDATA[ select  s.id,s.title as service_title,m.title as merchant_title,s.app_id,a.community_id "
					+ " from open_order a,community_service s,open_merchant_info m "
					+ " where a.app_id=s.app_id and m.id=s.merchant_id  and a.community_id= #{commid} ]]>",
			"<if test=\"stitle != null \"> and s.title like #{stitle} </if> ",
			"<if test=\"mtitle != null \"> and m.title like #{mtitle}</if> ",
			"<![CDATA[ group by  s.id  limit #{index},#{limit} ]]></script>" })
	public List<Map<String, Object>> listCommunity(@Param("commid") int commid, @Param("stitle") String stitle,
			@Param("mtitle") String mtitle, @Param("index") int index, @Param("limit") int limit);

	@Select({
			"<script><![CDATA[ SELECT count(*) FROM	( select  count(1) from open_order a,community_service s,open_merchant_info m where a.app_id=s.app_id and m.id=s.merchant_id  and a.community_id= #{commid} ]]>",
			"<if test=\"stitle != null \"> and s.title like #{stitle} </if> ",
			"<if test=\"mtitle != null \"> and m.title like #{mtitle} </if> ",
			"<![CDATA[ group by  s.id  ) AS b  ]]></script>" })
	public long countListCommunity(@Param("commid") int commid, @Param("stitle") String stitle,
			@Param("mtitle") String mtitle);

	/// 提现金额
	// @Select({
	// "<script><![CDATA[ select service_id,sum(receipt_amount) as sum from
	/// open_order where type =1 and bill_status=2 and balance_status=2 and
	/// a.community_id= #{commid} ]]>",
	// " and withdraw_status in (${withdraw_status}) ", " and service_id in
	/// (${service_id}) ", "<![CDATA[ group by service_id ]]></script>"})
	// public List<Map<String, Object>>
	/// sumWithdrawalAmountCommunity(@Param("commid") Integer commid,
	/// @Param("withdraw_status") String withdraw_status,
	// @Param("service_id") String service_id);

	// 社区服务费
	@Select({
			"<script><![CDATA[ select service_id,sum(service_charge) as sum from open_order where type in(1, 4) and bill_status=2  and balance_status=2  and  community_id= #{commid} ]]>",
			" and service_charge_status =${service_charge_status} ", " and service_id in (${service_id}) ",
			"<![CDATA[  group by service_id    ]]></script>" })
	public List<Map<String, Object>> sumServiceChargeCommunity(@Param("commid") int commid,
			@Param("service_charge_status") String service_charge_status, @Param("service_id") String service_id);

	// 平台手续费
	// @Select({
	// "<script><![CDATA[ select service_id,sum(platform_charge) as sum from
	// open_order where type =1 and bill_status=2 and community_id= #{commid} ]]>",
	// " and service_id in (${service_id}) ", "<![CDATA[ group by service_id
	// ]]></script>"})
	// public List<Map<String, Object>> sumPlatformChargeCommunity(@Param("commid")
	// Integer commid, @Param("service_id") String service_id);

	/// 提现金额
	// @Select({
	// "<script><![CDATA[ select sum(receipt_amount) as sum from open_order where
	/// type =1 and bill_status=2 and balance_status=2 and community_id= #{commid}
	/// ]]>",
	// " and withdraw_status in (${withdraw_status}) ", " </script>"})
	// public Double sumTotalWithdrawalAmountCommunity(@Param("commid") Integer
	/// commid, @Param("withdraw_status") String withdraw_status);

	// 社区服务费
	@Select({
			"<script><![CDATA[ select sum(service_charge) as sum from open_order where type in(1, 4) and bill_status=2  and balance_status=2   and community_id= #{commid}]]>",
			" and service_charge_status = #{service_charge_status} ", " </script>" })
	public Double sumTotalServiceChargeCommunity(@Param("commid") int commid,
			@Param("service_charge_status") String service_charge_status);

	// 平台手续费
	// @Select({"<script><![CDATA[ select sum(platform_charge) as sum from
	// open_order where type = 1 and bill_status= 2 and a.community_id= #{commid}
	// ]]>",
	// " </script>"})
	// public Double sumTotalPlatformChargeCommunity(@Param("commid") Integer
	// commid);

	// 是否能提现
	@Select(value = { "select count(*) as count ",
			" from open_order where bill_status=2 and type in(1,4) and service_id=#{service_id} ",
			" and  bill_finished_time>=#{startDate} and bill_finished_time<=#{endDate} and withdraw_status!=2 group by service_id " })
	//不要了,李一村
	@Deprecated
	public Long countServiceNotSplit(@Param("service_id") int serviceId, @Param("startDate") Date startTime,
			@Param("endDate") Date endTime);

	// 是否能提现
	@Select(value = { "select count(*) as count ",
			" from open_order where bill_status=2 and type in(1,4) and service_id=#{service_id} ",
			" and  bill_split_time>=#{startDate} and bill_split_time<=#{endDate} and withdraw_status!=2 group by service_id " })
	public Long countServiceNotSplitNew(@Param("service_id") int serviceId, @Param("startDate") Date startTime,
			@Param("endDate") Date endTime);


	@Select({
			"<script>" +
					"SELECT s.id,s.title AS service_title,m.title AS merchant_title,s.app_id,total.* " +
					"FROM open_order a, " +
					" open_merchant_info m,  " +
					" community_service s " +
					"  LEFT JOIN (select service_id, " +
					"      sum(CASE WHEN balance_status=2 AND withdraw_status = 4 THEN receipt_amount ELSE 0 END ) as sum_withdrawal_amount, " +
					"      sum(CASE WHEN balance_status=2 AND withdraw_status in(2,3,5) THEN receipt_amount ELSE 0 END ) as sum_un_withdrawal_amount, " +
					"      sum(CASE WHEN balance_status=2 AND  service_charge_status = 2 THEN service_charge ELSE 0 END) as sum_un_service_charge, " +
					"      sum(CASE WHEN balance_status=2 AND  service_charge_status = 3 THEN service_charge ELSE 0 END) as sum_service_charge , " +
					"      sum(CASE WHEN refund_status=2 THEN refund_money ELSE 0 END) as sum_refund_money , " +
					"      sum(platform_charge) as sum_platform_charge,  " +
					"      sum(think_charge) as sum_think_charge  " +
					"from open_order where type in(1, 4, 5) and bill_status=2  group by service_id) total ON total.service_id=s.id " +
					"WHERE a.app_id = s.app_id " +
					"AND m.id = s.merchant_id ",
			"<if test=\"stitle != null \"> and s.title like #{stitle} </if> ",
			"<if test=\"mtitle != null \"> and m.title like #{mtitle}</if> ",
			"<![CDATA[ group by  s.id  limit #{index},#{limit} ]]></script>" })
	 List<Map<String, Object>> listOrderFinance(@Param("stitle") String stitle, @Param("mtitle") String mtitle,
											@Param("index") int index, @Param("limit") int limit);


	@Select({
			"select service_id, " +
					"      sum(CASE WHEN balance_status=2 AND withdraw_status = 4 THEN receipt_amount ELSE 0 END ) as sum_withdrawal_amount, " + //提现金额
					"      sum(CASE WHEN balance_status=2 AND withdraw_status in(2,3,5) THEN receipt_amount ELSE 0 END ) as sum_un_withdrawal_amount, " + //未提现金额
					"      sum(CASE WHEN balance_status=2 AND  service_charge_status = 2 THEN service_charge ELSE 0 END) as sum_un_service_charge, " + //未结算社区服务费
					"      sum(CASE WHEN balance_status=2 AND  service_charge_status = 3 THEN service_charge ELSE 0 END) as sum_service_charge , " + //已结算社区服务费
					"      sum(CASE WHEN refund_status=2 THEN refund_money ELSE 0 END) as sum_refund_money , " + //平台退款金额
					"      sum(platform_charge) as sum_platform_charge,  " + //支付手续费
					"      sum(think_charge) as sum_think_charge  " + //平台手续费
					"from open_order where type in(1, 4, 5) and bill_status=2" })
	Map<String, Object> totalOrderFinance();
}
