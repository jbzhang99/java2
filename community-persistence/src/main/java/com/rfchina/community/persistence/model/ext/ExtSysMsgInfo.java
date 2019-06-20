package com.rfchina.community.persistence.model.ext;

import com.rfchina.community.persistence.model.SysMsgInfo;

public class ExtSysMsgInfo extends SysMsgInfo {

	private Integer isRead;
	private Long adminUid;
	private static final long serialVersionUID = 1L;

	public Integer getIsRead() {
		return isRead;
	}

	public void setIsRead(Integer isRead) {
		this.isRead = isRead;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getAdminUid() {
		return adminUid;
	}

	public void setAdminUid(Long adminUid) {
		this.adminUid = adminUid;
	}
}