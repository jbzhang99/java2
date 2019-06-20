package com.rfchina.community.openweb.entity;

import com.rfchina.api.response.model.app.GetApiListResponseModel;
import com.rfchina.community.persistence.model.OpenInterface;

public class ExtInterfaceList extends OpenInterface{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GetApiListResponseModel apiListResponseModel;

	public GetApiListResponseModel getApiListResponseModel() {
		return apiListResponseModel;
	}

	public void setApiListResponseModel(GetApiListResponseModel apiListResponseModel) {
		this.apiListResponseModel = apiListResponseModel;
	}
	
	
}
