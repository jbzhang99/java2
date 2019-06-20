package com.rfchina.community.openstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rfchina.community.base.Constant;
import com.rfchina.community.persistence.mapper.CommunityServiceRelaMapper;
import com.rfchina.community.persistence.model.CommunityServiceRela;
import com.rfchina.community.persistence.model.CommunityServiceRelaExample;
import com.rfchina.community.persistence.model.CommunityServiceRelaKey;

@Service
public class CommunityServiceRelaService {

	@Autowired
	private CommunityServiceRelaMapper communityServiceRelaMapper;


	public int isRelate(int serviceId, int communityId) {
		
		CommunityServiceRelaKey communityServiceRelaKey = new CommunityServiceRelaKey();
		communityServiceRelaKey.setCommunityId(communityId);
		communityServiceRelaKey.setServiceId(serviceId);
		CommunityServiceRela rela = communityServiceRelaMapper.selectByPrimaryKey(communityServiceRelaKey);
		if(rela == null || rela.getStatus() != 1) {//状态为1时启用
			return 0;
		}
		return 1;
	}
	
	public long checkCount(Integer serviceId, Integer commid) {
        CommunityServiceRelaExample ex3 = new CommunityServiceRelaExample();
        ex3.createCriteria().andCommunityIdEqualTo(commid).andServiceIdEqualTo(serviceId)
                .andStatusEqualTo(Constant.CommunityServiceRela.Status.ENABLE);
        return communityServiceRelaMapper.countByExample(ex3);
    }

    public boolean checkService(int serviceId, int communityId) {
        long count = checkCount(serviceId, communityId);
        if (count <= 0) {
            return false;
        }
        return true;
    }



}
