package com.rfchina.community.openweb.mapper.ext;

import com.rfchina.community.persistence.mapper.OpenStoreVerifyCardSqlProvider;
import org.apache.commons.collections4.MapUtils;

import java.util.Map;

/**
 */
public class ExtOpenOperatorTaskSqlProvider extends OpenStoreVerifyCardSqlProvider {
	public String operatorList(Map<String, Object> param){
		StringBuffer sb = new StringBuffer("select _task.release_status,_task.start_time, _task.end_time,_rel.*,_task.service_id, _task.xfsj_id,_info.act_titile from open_operator_task_rel _rel LEFT JOIN open_operator_task _task on _rel.task_id=_task.id"
				+" LEFT JOIN open_xfsj_info _info on _info.id=_task.xfsj_id where 1=1  ");
		if(param.get("serviceId") != null){
			sb.append(" and _task.service_id= #{serviceId}");
		}

		if(param.get("operatorPhone") != null){
			sb.append(" and _rel.emp_phone like #{operatorPhone}");
		}
		if(param.get("operatorName") != null){
			sb.append(" and _rel.emp_name like #{operatorName}");
		}
		sb.append(" order by _rel.id desc ");
		return sb.toString();
	}


	public String sumAmount(Map<String, Object> param) {

		StringBuffer sb = new StringBuffer("select IFNULL(sum(total_amount),0) total_amount from open_order where bill_status= 2 ");

		if (param.get("taskId") != null) {
			sb.append(" and task_id = #{taskId}");
		}

		if (param.get("empGuid") != null) {
			sb.append(" and emp_guid = #{empGuid}");
		}

		if (param.get("isContainRefund") != null && !MapUtils.getBoolean(param, "isContainRefund")) {
			sb.append(" and refund_status = 0");
		}

		return sb.toString();
	}
}
