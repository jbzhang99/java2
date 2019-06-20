package com.rfchina.community.open.bridge.entity;

import com.rfchina.community.persistence.model.ResourcePatrolResult;

public class ExtResourcePatrolResult extends ResourcePatrolResult {
	private String patrolTypeName;

	public String getPatrolTypeName() {
		return patrolTypeName;
	}

	public void setPatrolTypeName(String patrolTypeName) {
		this.patrolTypeName = patrolTypeName;
	}
	
}