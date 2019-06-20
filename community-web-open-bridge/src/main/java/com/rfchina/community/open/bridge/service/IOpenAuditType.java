package com.rfchina.community.open.bridge.service;

import com.rfchina.community.component.OpenAuditInfoComponent;

public interface IOpenAuditType {

	/**
	 * @param type
	 *            不认识就返回null
	 * @return
	 */
	public IOpenAuditTypeReturn audit(OpenAuditInfoComponent.ObjectType type) ;
}
