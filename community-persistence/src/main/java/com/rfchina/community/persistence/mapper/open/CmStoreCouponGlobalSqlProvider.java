package com.rfchina.community.persistence.mapper.open;

import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CmStoreCouponGlobalSqlProvider {

	private static Logger logger = LoggerFactory.getLogger(CmStoreCouponGlobalSqlProvider.class);

	public String pageByExample(Map<String, Object> param) {
		StringBuilder sql = new StringBuilder();

		sql.append(" select i.*,e.*,s.title service_name,m.title merchant_name from cm_activity_card_coupon_item i ");
		sql.append(" LEFT JOIN cm_store_coupon_extend e on i.id=e.card_item_id ");
		sql.append(" LEFT JOIN community_service s on s.id=e.service_id ");
		sql.append(" LEFT JOIN open_merchant_info m on m.id=e.merchant_id ");
		sql.append(" where 1=1 ");

		// 商家名称
		if (StringUtils.isNotBlank(MapUtils.getString(param, "merchant_name", ""))) {
			sql.append(" and m.title like #{merchant_name} ");
		}
		// 店铺名称
		if (StringUtils.isNotBlank(MapUtils.getString(param, "service_name", ""))) {
			sql.append(" and s.title like #{service_name} ");
		}

		// 优惠券名称
		if (StringUtils.isNotBlank(MapUtils.getString(param, "coupon_name", ""))) {
			sql.append(" and i.coupon_name like #{coupon_name} ");
		}

		// 优惠券状态
		if (MapUtils.getInteger(param, "status", -1) >= 0) {
			sql.append(" and i.status = #{status} ");
		}
		// 商家券
		if (MapUtils.getInteger(param, "coupon_type", -1) >= 0) {
			sql.append(" and i.coupon_type = #{coupon_type} ");
		}

		// 服务id
		if (MapUtils.getInteger(param, "service_id", -1) > 0) {
			sql.append(" and e.service_id = #{service_id} ");
		}

		// 发放形式*： 公开状态0不公开1公开
		if (MapUtils.getInteger(param, "open_status", -1) >= 0) {
			sql.append(" and i.open_status = #{open_status} ");
		}

		sql.append(" order by i.id desc");
		logger.info("{}", sql);
		return sql.toString();
	}
	
	public String reduceCouponNum(Map<String, Object> param) {
		StringBuffer sb = new StringBuffer("update cm_activity_card_coupon_item set coupon_num=coupon_num-#{decNum}");
		sb.append(" where id=#{id}");
		sb.append(" and coupon_num >= #{decNum}");
		System.out.println(sb.toString());
		return sb.toString();
	}

}