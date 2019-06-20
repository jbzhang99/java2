package com.rfchina.community.openweb.entity;

import java.io.Serializable;

public class ExtOpenManagerInvite implements Serializable{

	private static final long serialVersionUID = 1L;
	private String phone;
	private String empName;
	private String empGuid;
	private String merchantCount;
	private String ctiy;
	private String empComName;
	private String empProjectName;
	private String empDepName;
	
	public String getEmpComName() {
		return empComName;
	}
	public void setEmpComName(String empComName) {
		this.empComName = empComName;
	}
	public String getEmpProjectName() {
		return empProjectName;
	}
	public void setEmpProjectName(String empProjectName) {
		this.empProjectName = empProjectName;
	}
	public String getEmpDepName() {
		return empDepName;
	}
	public void setEmpDepName(String empDepName) {
		this.empDepName = empDepName;
	}
	public String getCtiy() {
		return ctiy;
	}
	public void setCtiy(String ctiy) {
		this.ctiy = ctiy;
	}
	public String getEmpGuid() {
		return empGuid;
	}
	public void setEmpGuid(String empGuid) {
		this.empGuid = empGuid;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getMerchantCount() {
		return merchantCount;
	}
	public void setMerchantCount(String merchantCount) {
		this.merchantCount = merchantCount;
	}
	
	@Override
	public String toString() {
		return "ExtOpenManagerInvite [phone=" + phone + ", empName=" + empName + ", merchantCount=" + merchantCount
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empName == null) ? 0 : empName.hashCode());
		result = prime * result + ((merchantCount == null) ? 0 : merchantCount.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExtOpenManagerInvite other = (ExtOpenManagerInvite) obj;
		if (empName == null) {
			if (other.empName != null)
				return false;
		} else if (!empName.equals(other.empName))
			return false;
		if (merchantCount == null) {
			if (other.merchantCount != null)
				return false;
		} else if (!merchantCount.equals(other.merchantCount))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		return true;
	}
	
	

}
