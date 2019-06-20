package com.rfchina.community.open.bridge.mapper.ext;
import com.rfchina.community.persistence.mapper.OpenAuditInfoSqlProvider;
import com.rfchina.community.persistence.model.OpenAuditInfoExample;
import org.apache.ibatis.jdbc.SQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
public class ExtOpenAuditInfoSqlProvider extends OpenAuditInfoSqlProvider {

private static Logger logger = LoggerFactory.getLogger(ExtOpenAuditInfoSqlProvider.class);
	public String pageByExample(Map<String, Object> param) {
		OpenAuditInfoExample example = (OpenAuditInfoExample) param.get("example");
		SQL sql = new SQL();
		// if (example != null && example.isDistinct()) {
		// sql.SELECT_DISTINCT("id");
		// } else {
		// sql.SELECT("id");
		// }
		sql.SELECT(" * ");
		sql.FROM("open_audit_info");
		applyWhere(sql, example, true);
		if (example != null && example.getOrderByClause() != null) {
			sql.ORDER_BY(example.getOrderByClause());
		}
		return sql.toString();
	}
	
	public String pageByParam(Map<String, Object> param) {
		StringBuffer sb = new StringBuffer("SELECT _audit.* from("
				+ " (SELECT * FROM open_audit_info WHERE audit_type = 'xfsj_sign_up_apply') _audit"
				+ " LEFT JOIN open_xfsj_sign_up_info _sign_up_info ON _audit.object_id = _sign_up_info.id"
				+ " LEFT JOIN open_xfsj_info _info ON _info.id=_sign_up_info.xfsj_id) where 1=1");
		if(param.get("auditStatus") !=null) {
			sb.append(" and _audit.audit_status=#{auditStatus}");
		}
		if(param.get("activityName") !=null) {
			sb.append(" and _info.act_titile like #{activityName}");
		}
			
		sb.append(" order by _audit.create_time desc ");
		return sb.toString();
	}
	
	

	public String listOpenXFSJMerchantAuditInfo(Map<String, Object> param) {
		StringBuffer sb = new StringBuffer("select a.*,cs.title as serviceName,i.user_name username,i.title as merchant_name,"
				+ " i.src_business,i.src_city,i.create_time as m_create_time,i.type as merchant_type "
				+ " from open_audit_info a left JOIN open_merchant_info i on a.merchant_id=i.id " +
				" left JOIN (select merchant_id,title from community_service GROUP BY merchant_id ) cs ON cs.merchant_id=i.id ");
		sb.append(" where a.pager_id=#{pager_id} ");
		
		if(param.get("audit_status") !=null) {
			sb.append(" and a.audit_status=#{audit_status}");
		}
		if(param.get("merchant_name") !=null) {
			sb.append(" and i.title  like #{merchant_name}");
		}
		if(param.get("src_business") !=null) {
			sb.append(" and i.src_business  = #{src_business}");
		}
		if(param.get("no_src_business") !=null) {
			sb.append(" and i.src_business  <> #{no_src_business}");
		}
		if(param.get("src_city") !=null) {
			sb.append(" and i.src_city  = #{src_city}");
		}
		
		if(param.get("src_city_in")!=null) {
			sb.append(" and i.src_city  in ("+param.get("src_city_in")+") ");
		}
		if(param.get("merchant_type") !=null) {
			sb.append(" and i.type  = #{merchant_type}");
		}
        if(param.get("serviceName") !=null) {
            sb.append(" and cs.title like #{serviceName}");
        }
			
		sb.append(" order by a.id desc ");
		logger.info("listOpenXFSJMerchantAuditInfo sql{}",sb);
		return sb.toString();
	}
}