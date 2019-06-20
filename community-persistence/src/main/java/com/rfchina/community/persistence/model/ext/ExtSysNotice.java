package com.rfchina.community.persistence.model.ext;

import java.util.Date;

import com.rfchina.community.persistence.model.SysNotice;

public class ExtSysNotice extends SysNotice {

	private Date readTime;

	public Date getReadTime() {
		return readTime;
	}

	public void setReadTime(Date readTime) {
		this.readTime = readTime;
	}
}
