package com.rfchina.community.open.bridge.mapper.ext;

import com.rfchina.community.persistence.mapper.OpenXFSJInfoSqlProvider;
import com.rfchina.community.persistence.model.OpenXFSJInfoExample;
import org.apache.ibatis.jdbc.SQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class ExtOpenXFSJInfoBridgeSqlProvider extends OpenXFSJInfoSqlProvider {

	private static Logger logger = LoggerFactory.getLogger(ExtOpenXFSJInfoBridgeSqlProvider.class);

	public String pageByExample(Map<String, Object> param) {

		OpenXFSJInfoExample example = (OpenXFSJInfoExample) param.get("example");
		SQL sql = new SQL();

		sql.SELECT("*");
		sql.FROM("open_xfsj_info");
		applyWhere(sql, example, true);

		if (example != null && example.getOrderByClause() != null) {
			sql.ORDER_BY(example.getOrderByClause());
		}

		return sql.toString();
	}

	public String pageByParam(Map<String, Object> param) {

		StringBuffer sb = new StringBuffer(
				"SELECT _info.*, _bus.sign_up_status, _bus.amount " + " FROM open_xfsj_info _info "
						+ " LEFT JOIN open_xfsj_business_info _bus ON _info.id = _bus.xfsj_id where _info.type='community' ");
		if (param.get("communityIds") != null) {
			sb.append(" AND community_id = #{communityIds}");
		}
		if (param.get("signUpStatus") != null) {
			sb.append(" AND sign_up_status = #{signUpStatus}");
		}

		sb.append(" order by status, _info.id desc");
		logger.info("{}", sb);
		return sb.toString();
	}
	
	public String listPlatformActivity(Map<String, Object> param) {

		SQL sql = new SQL();
		sql.SELECT("_info.*");
		sql.FROM("open_xfsj_info _info");
		StringBuffer condition = new StringBuffer("_info.type='platform' ");
		if (param.get("cityId") != null && param.get("communityId") == null) {
			sql.INNER_JOIN("community _community  on _info.community_id = _community.id");
			condition.append(" AND _community.city_id = #{cityId}");
		}
		if (param.get("communityId") != null) {
			String communityId = (String)param.get("communityId");
			String[] communityIds = communityId.split(",");
			if(communityIds.length>1){
				condition.append(" AND _info.community_id in ( ");
				for(String id : communityIds){
					condition.append(id).append(",");
				}
				condition.delete(condition.length()-1,condition.length());
				condition.append(" ) ");
			}else{
				condition.append(" AND _info.community_id = #{communityId}");
			}
		}
		if (param.get("status") != null) {
			condition.append(" AND _info.status = #{status}");
		}
		if (param.get("categoryId") != null) {
			condition.append(" AND _info.category_id = #{categoryId}");
		}
		if (param.get("activityName") != null) {
			condition.append(" AND _info.act_titile like #{activityName}");
		}

		sql.WHERE(condition.toString());
		sql.ORDER_BY("_info.create_time desc");

		return sql.toString();
	}

	public String listValidActivity(Map<String, Object> param) {

		StringBuffer sb = new StringBuffer(
				"SELECT _info.*,_detail.detail FROM open_xfsj_info _info LEFT JOIN open_xfsj_info_detail _detail on _info.id=_detail.id "
						+ " where 1=1 ");
		if (param.get("communityId") != null) {
			sb.append(" AND community_id = #{communityId}");
		}
		if (param.get("status") != null) {
			sb.append(" AND status = #{status}");
		}

		if (param.get("activityName") != null) {
			sb.append(" AND act_titile like #{activityName}");
		}

		sb.append(" order by status,_info.id desc");
		return sb.toString();
	}

	// 综合服务费订单
	public String generalServiceOrder(Map<String, Object> param) {
		StringBuffer sb = new StringBuffer("");
		sb.append(
				" select o.id,o.bill_id,c.name community_name,o.bill_status,o.total_amount,o.create_time,m.title merchant_title,s.merchant_id,i.community_id,s.title service_title,i.act_titile,a.`name` city_name,c.city_id ");
		sb.append(" from  open_order o left join open_xfsj_sign_up_info u on o.caution_id=u.id  ");
		sb.append(" left join open_xfsj_info i on u.xfsj_id=i.id ");
		sb.append(" left join community_service s on s.id=u.service_id ");
		sb.append(" left join open_merchant_info m on m.id=s.merchant_id ");
		sb.append(" LEFT JOIN community c on i.community_id=c.id ");
		sb.append(" LEFT JOIN area a on c.city_id=a.id ");
		sb.append(" where o.type=3  ");

		if (param.get("cityId") != null) {
			sb.append(" AND c.city_id = #{cityId} ");
		}
		if (param.get("communityIds") != null) {
			sb.append(" AND c.id in ( "+param.get("communityIds")+" ) ");
		}
		if (param.get("create_time_begin") != null) {
			sb.append(" AND o.create_time >=#{create_time_begin} ");
		}
		if (param.get("create_time_end") != null) {
			sb.append(" AND o.create_time <=#{create_time_end}");
		}
		// 支付状态
		if (param.get("bill_status") != null) {
			sb.append(" AND o.bill_status = #{bill_status} ");
		}
		// 商家名称
		if (param.get("merchant_title") != null) {
			sb.append(" AND m.title like #{merchant_title}  ");
		}
		// 店铺/服务名称
		if (param.get("service_title") != null) {
			sb.append(" AND s.title  like #{service_title}  ");
		}
		// 活动名称
		if (param.get("act_titile") != null) {
			sb.append(" AND i.act_titile like #{act_titile}  ");
		}
		// 订单号
		if (param.get("bill_id") != null) {
			sb.append(" AND o.bill_id like #{bill_id}  ");
		}

		sb.append("  order by o.create_time desc");
		logger.info("{}", sb);
		return sb.toString();
	}

}