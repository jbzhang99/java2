package com.rfchina.community.persistence.model.ext;

import com.rfchina.community.persistence.model.CommunityAroundPoi;
import com.rfchina.community.persistence.model.CommunityAroundPoiExt;
import com.rfchina.community.persistence.model.CommunityAroundPoiRel;
import com.rfchina.community.persistence.model.CommunityAroundPoiType;

public class ExtCommunityAroundPoi extends CommunityAroundPoi {

	private CommunityAroundPoiExt ext;

	private CommunityAroundPoiType poiType;

	private CommunityAroundPoiRel poiRel;

	public CommunityAroundPoiExt getExt() {
		return ext;
	}

	public void setExt(CommunityAroundPoiExt ext) {
		this.ext = ext;
	}

	public CommunityAroundPoiType getPoiType() {
		return poiType;
	}

	public void setPoiType(CommunityAroundPoiType poiType) {
		this.poiType = poiType;
	}

	public CommunityAroundPoiRel getPoiRel() {
		return poiRel;
	}

	public void setPoiRel(CommunityAroundPoiRel poiRel) {
		this.poiRel = poiRel;
	}
}
