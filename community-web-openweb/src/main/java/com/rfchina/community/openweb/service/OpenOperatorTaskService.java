package com.rfchina.community.openweb.service;

import com.rfchina.community.base.OpenOperatorTaskConstant;
import com.rfchina.community.openweb.mapper.ext.ExtOpenOperatorTaskMapper;
import com.rfchina.community.persistence.mapper.OpenOperatorTaskMapper;
import com.rfchina.community.persistence.mapper.OpenOperatorTaskRelMapper;
import com.rfchina.community.persistence.model.ext.ExtOperator;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:fukangwen
 * @Description: 运营任务
 */
@Service
public class OpenOperatorTaskService extends BaseService {
	@Autowired
	private OpenOperatorTaskMapper openOperatorTaskMapper;
	@Autowired
	private OpenOperatorTaskRelMapper openOperatorTaskRelMapper;
	@Autowired
	private ExtOpenOperatorTaskMapper extOpenOperatorTaskMapper;


	/**
	 * 运营者信息列表
	 */
	public PageList<ExtOperator> operatorList(int serviceId,
		   String operatorName, String operatorPhone, int index, int size){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("serviceId", serviceId);
		if (StringUtils.isNotBlank(operatorName)) {
			param.put("operatorName", operatorName);
		}
		if (StringUtils.isNotBlank(operatorPhone)) {
			param.put("operatorPhone", operatorPhone);
		}
		PageBounds pageBounds = new PageBounds(index, size);
		PageList<ExtOperator> list = extOpenOperatorTaskMapper.operatorList(param, pageBounds);
		for(ExtOperator rel : list){
			rel.setSumAmount(sumAmount(rel.getTaskId(), rel.getEmpGuid(), false));

			if(rel.getEndTime().getTime() < new Date().getTime() || rel.getValidStatus() == 0
					|| rel.getReleaseStatus() == OpenOperatorTaskConstant.ReleaseStatus.stop.getCode()){
				rel.setStatus(2);//已结束
			}else{
				rel.setStatus(1);//协助中
			}
		}

		return list;
	}

	public BigDecimal sumAmount(Long taskId, String empGuid, Boolean isContainRefund){
		Map<String, Object> param = new HashMap<>();
		if(taskId != null){
			param.put("taskId", taskId);
		}
		if(taskId != null){
			param.put("taskId", taskId);
		}
		if(isContainRefund != null){
			param.put("isContainRefund", isContainRefund);
		}
		return extOpenOperatorTaskMapper.sumAmount(param);
	}
}
