package com.rfchina.community.open.bridge.service;
import java.util.Map;
public interface IOpenAuditTypeReturn {

	/**
	 * @param uid    用户id
	 * @param objectId  业务id
	 * @param parameter  参数放在这里
	 * @throws Exception
	 */
	public void passAudit(Long uid, String objectId, Map<String, String> parameter) throws Exception;

	/**
	 * @param uid
	 * @param objectId
	 * @param reason
	 *            原因
	 */
	public void unpassAudit(Long uid, String objectId, String reason) throws Exception;
}
