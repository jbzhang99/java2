package com.rfchina.community.openstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rfchina.community.persistence.mapper.OpenServiceDetailMapper;
import com.rfchina.community.persistence.model.OpenServiceDetail;
/**
 * @author:fukangwen
 * @Description: 服务扩展service
 */
@Service
public class OpenServiceDetailService {

	@Autowired
	private OpenServiceDetailMapper openServiceDetailMapper;
	
	/**
	 * @author:fukangwen
	 * @Description: 判断是否模板开发
	 * @return Boolean
	 * @throws
	 */
	public Boolean isTemplete(int serviceId) {
		OpenServiceDetail detail = openServiceDetailMapper.selectByPrimaryKey(serviceId);
		if(detail == null)
			return false;
		if(DevelopType.SELF.toString().equals(detail.getDevelopType()))
			return false;
		return true;
	}
	
	/**
	 * @author:fukangwen
	 * @Description: 判断是否审核通过了
	 * @return Boolean
	 * @throws
	 */
	public Boolean hadCheck(int serviceId) {
		OpenServiceDetail detail = openServiceDetailMapper.selectByPrimaryKey(serviceId);
		if(detail == null)
			return false;
		if(DevelopType.TEMPLETE.toString().equals(detail.getDevelopType()) && 
				detail.getTempleteStatus() == TempleteStatus.USE.getCode()) {
			return true;
		}
		return false;
	}
	
	public enum DevelopType{
		SELF("SELF","自主开发"),TEMPLETE("TEMPLETE","模板");
		private String code;
		private String label;
		
		DevelopType(String code, String label) {
			this.code = code;
			this.label = label;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getLabel() {
			return label;
		}

		public void setLabel(String label) {
			this.label = label;
		}
	}
	
	public enum TempleteStatus{
		NO_USE(0,"模板未审核"),USE(1,"模板通过");
		private int code;
		private String label;
		
		TempleteStatus(int code, String label) {
			this.code = code;
			this.label = label;
		}

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}

		public String getLabel() {
			return label;
		}

		public void setLabel(String label) {
			this.label = label;
		}

	}

	/**
	 * @author:fukangwen
	 * @Description: 获取服务模板类型
	 * @return OpenServiceDetail
	 * @throws
	 */
	public OpenServiceDetail getByServiceId(int serviceId) {
		return openServiceDetailMapper.selectByPrimaryKey(serviceId);
	}
	
}
