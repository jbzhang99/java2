package com.rfchina.community.persistence.mapper.ext;

import java.util.Map;

import com.rfchina.community.persistence.mapper.OpenStoreCouponSqlProvider;

public class ExtOpenStoreCouponSqlProvider extends OpenStoreCouponSqlProvider {
	public String pageByCondition(Map<String, Object> param) {
		StringBuffer sb = new StringBuffer(
				"select * from open_store_coupon where 1=1 ");
		if (param.get("serviceId") != null) {
			sb.append(" and service_id = #{serviceId}");
		}
		if (param.get("startCreateDate") != null) {
			sb.append(" and create_time >= #{startCreateDate}");
		}

		if (param.get("endCreateDate") != null) {
			sb.append(" and create_time <= #{endCreateDate}");
		}

		if (param.get("status") != null) {
			sb.append(" and status = #{status}");
		} else {
			sb.append(" and status <> 3");// 除了删除的
		}

		if (param.get("title") != null) {
			sb.append(" and title like #{title}");
		}
		if (param.get("coupon_no") != null) {
			sb.append(" and coupon_no like #{coupon_no}");
		}
		if (param.get("sub_title") != null) {
			sb.append(" and sub_title like #{sub_title}");
		}

		sb.append(" order by id desc");

		return sb.toString();
	}
}