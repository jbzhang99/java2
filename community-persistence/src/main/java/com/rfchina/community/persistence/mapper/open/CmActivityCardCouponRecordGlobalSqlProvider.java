package com.rfchina.community.persistence.mapper.open;

import java.util.Map;

import org.apache.commons.collections.MapUtils;

import com.rfchina.community.persistence.mapper.CmActivityCardCouponRecordSqlProvider;

public class CmActivityCardCouponRecordGlobalSqlProvider extends CmActivityCardCouponRecordSqlProvider {

	public String pageByExample(Map<String, Object> param) {
		StringBuilder sql = new StringBuilder();

		
		sql.append("select * from cm_activity_card_coupon_record where 1=1");
		
		if (MapUtils.getInteger(param, "coupon_id", -1) >= 0) {
			sql.append(" and  coupon_id = #{coupon_id} ");
		} 
		
		sql.append(" order by id desc");
		return sql.toString();
	}
	
	public String pageByParam(Map<String, Object> param) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT _record.id,_record.coupon_id, _record.uid,_record.valid_from_date, _record.valid_to_date, _record.coupon_type," + 
				" _record.item_type,_record.confirm_status,_record.status,_record.create_time ,_extend.service_id card_coupon_id, "
			  + " _item.coupon_name, _item.pay_amount,_extend.limit_money, _item.use_rule"
			  + " FROM cm_activity_card_coupon_record _record ");
		sql.append(" LEFT JOIN cm_activity_card_coupon_item _item ON _item.id = _record.coupon_id ");
		sql.append(" LEFT JOIN cm_store_coupon_extend _extend ON _item.id = _extend.card_item_id ");
		sql.append(" where _record.uid=#{uid} and _record.status=1 ");
		if (MapUtils.getInteger(param, "serviceId", -1) >= 0) {
			sql.append(" and  _extend.service_id = #{serviceId} ");
		}
		
		int status = MapUtils.getInteger(param, "status", 0);
		// 已使用1 , 未使用 2 ,已过期3
		if(status == 1) {
			sql.append(" and  _record.confirm_status = 1 ");
		}
		if(status == 2) {
			sql.append(" and  _record.confirm_status = 0");
		}
		if(status == 3) {
			sql.append(" and  _record.confirm_status = 0 and _record.valid_to_date<#{now} ");
		}
		
		sql.append(" order by _record.id desc ");
		System.out.println(sql);
		return sql.toString();
	}
	
	public String lockCardCouponRecord(Map<String, Object> param) {
		//核销状态 0未核销 1核销 2核销中
		StringBuffer sb = new StringBuffer("update cm_activity_card_coupon_record set confirm_status=2,confirm_code=#{orderCode}");
		sb.append(" where id=#{id}");
		sb.append(" and confirm_status = 0");
		return sb.toString();
	}

}