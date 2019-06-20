package com.rfchina.community.open.bridge.mapper.ext;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

public class ExtCommunityServiceSqlProvider {

	private static Logger logger = LoggerFactory.getLogger(ExtCommunityServiceSqlProvider.class);

	public String getCommunityService(Map<String, Object> param) {
		StringBuffer sb = new StringBuffer("select t.*,sp.community_rate,b.`name` as category_name,sst.quick_pay");
		sb.append(" ,d.title as merchant_name,d.type as merchant_type,sd.templete_name ")
		  .append( " from community_service t left join open_merchant_info d on t.merchant_id=d.id ")
		  .append(" left join community_service_category b on t.category_id=b.id ")
		  .append(" left join open_service_detail sd on t.id=sd.service_id ")
		  .append(" left join open_service_pay sp on t.id=sp.service_id ")
		  .append( " left join open_store_service_templete sst on t.id=sst.service_id ");
		if (param.get("type") != null) {
			sb.append(" left join open_service_detail_tab tab on tab.service_id=t.id ");
		}
		sb.append(" where t.type > 2 ");
		if (param.get("id") != null) {
			sb.append(" and t.id = #{id}");
		}

		if (param.get("title") != null) {
			sb.append(" and t.title like #{title}");
		}

		if (param.get("merchantName") != null) {
			sb.append(" and d.title like #{merchantName}");
		}

		if (param.get("merchantId") != null) {
			sb.append(" and d.id = #{merchantId}");
		}
		
		if (param.get("verifyRole") != null) {
			sb.append(" and sd.verify_role = #{verifyRole}");
		}
		
		if (param.get("categoryId") != null) {
			sb.append(" and t.category_id = #{categoryId}");
		}
		if (param.get("cautionMoneyStatus") != null) {
			sb.append(" and t.caution_money_status = #{cautionMoneyStatus}");
		}
		if (param.get("groundAuditStatus") != null) {
			sb.append(" and t.ground_audit_status = #{groundAuditStatus}");
		}

		if (param.get("status") != null) {
			sb.append(" and t.status = #{status}");
		}
		if (param.get("type") != null) {
			sb.append(" and tab.type = #{type}");
		}
		if (param.get("quickPay") != null) {
			sb.append(" and sst.quick_pay = #{quickPay}");
		}

		if (param.get("startCreateTime") != null) {
			sb.append(" and t.create_time >= #{startCreateTime}");
		}

		if (param.get("endCreateTime") != null) {
			sb.append(" and t.create_time <= #{endCreateTime}");
		}
		logger.info("getCommunityService:{},param:{}", sb, JSON.toJSONString(param));
		return sb.toString();
	}
	
	/**
	 * @author:fukangwen
	 * @Description: 实体服务市场列表
	 * @return String
	 * @throws
	 */
	public String getSimCommunityServiceList(Map<String, Object> param) {
		StringBuffer sb = new StringBuffer("select  t.id, t.title, t.png,t.description,t.create_time, t.category_id,b.`name` 'category_name' " + 
				" ,t.`status`,t.recommend_level,b.valid_status 'select_status',t.ground_audit_status " + 
				" FROM community_service t JOIN community_service_category b ON t.category_id = b.id " + 
				" JOIN community_service_rela a ON t.id = a.service_id where t.type>2");
		
		if (param.get("categoryId") != null) {
			sb.append(" and t.category_id = #{categoryId}");
		}
		if (param.get("status") != null) {
			sb.append(" and t.status = #{status}");
		}
		if (param.get("communityId") != null) {
			sb.append(" and a.community_id = #{communityId}");
		}
		logger.info("getSimCommunityServiceList:{},param:{}", sb, JSON.toJSONString(param));
		return sb.toString();
	}
	
	/**
	 * @author:fukangwen
	 * @Description: 虚拟服务市场列表
	 * @return String
	 * @throws
	 */
	public String getVirtualSimCommunityServiceList(Map<String, Object> param) {
		StringBuffer sb = new StringBuffer("select  t.id, t.title, t.png,t.description,t.create_time, t.category_id,b.`name` 'category_name' "
				+ " ,t.`status`,t.recommend_level,t.ground_audit_status FROM community_service t  " + 
				" LEFT JOIN community_service_category b ON t.category_id = b.id where t.type>2 ");
		
		if (param.get("categoryId") != null) {
			sb.append(" and t.category_id = #{categoryId}");
		}
		if (param.get("status") != null) {
			sb.append(" and t.status = #{status}");
		}
		logger.info("getVirtualSimCommunityServiceList:{},param:{}", sb, JSON.toJSONString(param));
		return sb.toString();
	}

	public String searchStoreName(Map<String, Object> param) {
		StringBuffer sb = new StringBuffer(
				"select s.id,s.title,s.type  ");
		sb.append(" FROM community_service s ");
		sb.append(" where  s.status=1 and s.type>2 ");
		
		if (StringUtils.isNotBlank(MapUtils.getString(param, "type"))) {
			sb.append(" and s.type = #{type} ");
		}
		if (StringUtils.isNotBlank(MapUtils.getString(param, "storeName"))) {
			sb.append(" and s.title like #{storeName}");
		}
		logger.info("{}", sb);
		return sb.toString();
	}
	
	public String searchServiceName(Map<String, Object> param) {
		StringBuffer sb = new StringBuffer(
				"select s.id,s.title,c.name as category_name,s.category_id,r.community_id,m.title as merchant_title  ");
		sb.append(" FROM community_service s ");
		sb.append(" LEFT JOIN community_service_rela r on s.id=r.service_id ");
		sb.append(" LEFT JOIN open_merchant_info m on s.merchant_id=m.id");
		sb.append(" LEFT JOIN community_service_category c on s.category_id=c.id");
		sb.append(" LEFT JOIN open_store_service_templete _temp on _temp.service_id=s.id");
		sb.append(" where  s.status=1 and r.status=1 and s.type>2 and _temp.service_id > 0");
		
		if (param.get("community_id") != null) {
			sb.append(" and r.community_id = #{community_id}");
		}
		
		if (StringUtils.isNotBlank(MapUtils.getString(param, "title"))) {
			sb.append(" and s.title like #{title}");
		}
		logger.info("{}", sb);
		return sb.toString();
	}
	
	//	服务ID	店铺名称	店铺类型	商家名称
	public String searchServiceName2(Map<String, Object> param) {
		StringBuffer sb = new StringBuffer(
				"select s.id,s.title,s.category_id,det.category_second_type,m.title as merchant_title  ");
		sb.append(" FROM community_service s ");
		sb.append(" LEFT JOIN open_merchant_info m on s.merchant_id=m.id");
		sb.append(" LEFT JOIN open_service_detail det on s.id=det.service_id");
		sb.append(" LEFT JOIN open_store_service_templete _temp on _temp.service_id=s.id");
		sb.append(" where  s.status=1 and s.type>2 and _temp.service_id > 0");
		
		if (StringUtils.isNotBlank(MapUtils.getString(param, "title"))) {
			sb.append(" and s.title like #{title}");
		}
		logger.info("{}", sb);
		return sb.toString();
	}

	public String businessManagerAdminList(Map<String, Object> param) {
		StringBuffer sb = new StringBuffer(
				"select s.id,s.paid_caution_money,s.receivable_caution_money,s.caution_money_status,d.caution_refund_status,"
				+ "s.title as service_title,d.category_second_type,c.`name` as category_second_title,m.title as merchant_title,"
				+ "m.type as merchant_type,sp.platform_fee,sp.community_rate,sp.community_rate commission_rate,s.create_time ,s.status  as service_status");
		sb.append(" from community_service s");
		sb.append(" left JOIN open_service_detail d on d.service_id=s.id ");
		sb.append(" left JOIN open_service_pay sp on sp.service_id=s.id ");
		sb.append(" LEFT JOIN open_merchant_info m on s.merchant_id=m.id ");
		sb.append(" left join community_service_category c on d.category_second_type = c.id ");
		sb.append(" where d.xfsj_status=1 ");

		if (StringUtils.isNotBlank(MapUtils.getString(param, "service_title"))) {
			sb.append(" and s.title like #{service_title}");
		}
		if (StringUtils.isNotBlank(MapUtils.getString(param, "merchant_title"))) {
			sb.append(" and m.title like #{merchant_title}");
		}
		if (MapUtils.getInteger(param, "category_second_type", 0) > 0) {
			sb.append(" and d.category_second_type = #{category_second_type}");
		}
		logger.info("businessManagerAdminList,param:{}:{}", param, sb);
		return sb.toString();
	}
	
	public String businessManagerListByType(Map<String, Object> param) {
		StringBuffer sb = new StringBuffer(
				"select s.id,s.paid_caution_money,s.receivable_caution_money,s.caution_money_status,d.caution_refund_status,"
				+ "s.title as service_title,d.category_second_type,c.`name` as category_second_title,m.title as merchant_title,"
				+ "m.type as merchant_type,sp.platform_fee,sp.community_rate ,sp.community_rate commission_rate,s.create_time ,s.status  as service_status");
		sb.append("	from open_service_detail_tab _tab");
		sb.append(" left JOIN community_service s on s.id=_tab.service_id");
		sb.append(" left JOIN open_service_detail d on d.service_id=s.id ");
		sb.append(" left JOIN open_service_pay sp on sp.service_id=s.id ");
		sb.append(" LEFT JOIN open_merchant_info m on s.merchant_id=m.id ");
		sb.append(" left join community_service_category c on s.category_id = c.id ");
		sb.append(" where 1=1 and _tab.type=#{type} ");

		if (StringUtils.isNotBlank(MapUtils.getString(param, "service_title"))) {
			sb.append(" and s.title like #{service_title}");
		}
		if (StringUtils.isNotBlank(MapUtils.getString(param, "merchant_title"))) {
			sb.append(" and m.title like #{merchant_title}");
		}
		if (MapUtils.getInteger(param, "category_id", 0) > 0) {
			sb.append(" and s.category_id = #{category_id}");
		}
		logger.info("businessManagerListByType,param:{}:{}", param, sb);
		return sb.toString();
	}
	
	public String getMyServiceList(Map<String, Object> param) {
		StringBuilder sb = new StringBuilder(
				" select t.*,a.reorder as community_service_reorder,a.is_menu_show,a.status as community_service_status,a.select_status,"
						+ " a.audit_status as community_audit_status, a.apply_time,b.`name` as category_name,d.title as merchant_name,"
						+ " d.type as merchant_type "
						+ " from community_service  t "
						+ " join community_service_rela a on t.id=a.service_id "
						+ " left join open_merchant_info d on t.merchant_id=d.id "
						+ " left join community_service_category b on t.category_id=b.id where 1=1 ");
		buildCondition(param, sb);
		if (param.get("communityServiceStatus") != null) {
			sb.append(" and a.status = #{communityServiceStatus}");
		}

		if (param.get("selectStatus") != null) {
			sb.append(" and a.select_status = #{selectStatus}");
		}
		return sb.toString();
	}
	
	
	public String getCommunityServiceApply(Map<String, Object> param) {
		StringBuilder sb = new StringBuilder(
				"select t.*,a.select_status,a.audit_comment as community_audit_comment,a.audit_status as community_audit_status,a.apply_time,"
				+ "b.`name` as category_name,d.title as merchant_name,d.type as merchant_type"
				+ " from community_service t join open_merchant_info d on t.merchant_id=d.id "
				+ " join community_service_category b on t.category_id=b.id  "
				+ " join community_service_rela a on t.id=a.service_id "
				+ " where 1=1 and a.audit_status != 1");
		buildCondition(param, sb);
		return sb.toString();
	}

	@Select({"select id as serviceId,title from community_service ",
			" where status=1 and r.is_menu_show=1 and ",
			" r.select_status=1 and r.community_id=#{community_id}"})
	public String findServiceTitle(Map<String, Object> param) {
		StringBuilder sql = new StringBuilder(
				"select id as serviceId,title from community_service  where status=1 ");
		//title types
		if (param.get("title") != null) {
			sql.append(" and title like #{title}");
		}
		if (param.get("types") != null ) {
			List<Integer> list = (List<Integer>) param.get("types");
			sql.append(" and type in (");
			for(Integer type : list){
				sql.append(type).append(",");
			}
			sql.replace(sql.length()-1,sql.length(),")");
		}
		return sql.toString();
	}
	private void buildCondition(Map<String, Object> param, StringBuilder sb) {
		if (param.get("id") != null) {
			sb.append(" and t.id = #{id}");
		}

		if (param.get("title") != null) {
			sb.append(" and t.title like #{title}");
		}

		if (param.get("merchantName") != null) {
			sb.append(" and d.title like #{merchantName}");
		}

		if (param.get("merchantType") != null) {
			sb.append(" and d.type = #{merchantType}");
		}

		if (param.get("communityAuditStatus") != null) {
			sb.append(" and a.audit_status = #{communityAuditStatus}");
		}

		if (param.get("startApplyTime") != null) {
			sb.append(" and a.apply_time >= #{startApplyTime}");
		}

		if (param.get("endApplyTime") != null) {
			sb.append(" and a.apply_time <= #{endApplyTime}");
		}

		if (param.get("merchantId") != null) {
			sb.append(" and d.id = #{merchantId}");
		}

		if (param.get("categoryId") != null) {
			sb.append(" and t.category_id = #{categoryId}");
		}

		if (param.get("status") != null) {
			sb.append(" and t.status = #{status}");
		}

		if (param.get("startCreateTime") != null) {
			sb.append(" and t.create_time >= #{startCreateTime}");
		}

		if (param.get("endCreateTime") != null) {
			sb.append(" and t.create_time <= #{endCreateTime}");
		}

		if (param.get("communityId") != null) {
			sb.append(" and a.community_id = #{communityId}");
		}

	}

}
