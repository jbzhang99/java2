package com.rfchina.community.open.bridge.entity;

import java.util.List;

import com.rfchina.community.persistence.model.ResourcePatrolInfo;
import com.rfchina.community.persistence.model.ResourcePatrolResult;

public class ExtResourcePatrolInfo extends ResourcePatrolInfo {
	private List<ExtResourcePatrolResult> resultList;

	private String empName;
	private String empMobile;
	
	public List<ExtResourcePatrolResult> getResultList() {
		return resultList;
	}

	public void setResultList(List<ExtResourcePatrolResult> resultList) {
		this.resultList = resultList;
	}
	
	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpMobile() {
		return empMobile;
	}

	public void setEmpMobile(String empMobile) {
		this.empMobile = empMobile;
	}

	@Override
	public String toString() {
		return "ExtResourcePatrolInfo [resultList=" + resultList + "]";
	}
	
}