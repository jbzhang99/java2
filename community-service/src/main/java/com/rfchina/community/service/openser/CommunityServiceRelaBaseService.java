package com.rfchina.community.service.openser;

import com.rfchina.community.base.Constant;
import com.rfchina.community.persistence.mapper.BaseMapper;
import com.rfchina.community.persistence.mapper.CommunityServiceRelaMapper;
import com.rfchina.community.persistence.model.CommunityServiceRela;
import com.rfchina.community.persistence.model.CommunityServiceRelaExample;
import com.rfchina.community.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName CommunityServiceRelaBaseService
 * @Description 服务分类service
 * @Author wlrllr
 * @Date 2018/12/25 11:38
 * @Version 1.0
 **/
@Service
public class CommunityServiceRelaBaseService extends AbstractService<CommunityServiceRela, CommunityServiceRelaExample,Integer> {

    @Autowired
    protected CommunityServiceRelaMapper mapper;

    @Override
    public BaseMapper<CommunityServiceRela, CommunityServiceRelaExample, Integer> getMapper() {
        return mapper;
    }

    public boolean check(Integer serviceId, Integer commId) {
        if (countByServiceIdAndCommunityId(serviceId,commId) <= 0) {
            return false;
        }
        return true;
    }

    public boolean check(List<Integer> serviceId, Integer commId) {
        long count = countByServiceIdAndCommunityId(serviceId,commId);
        if (count <= 0) {
            return false;
        }
        return true;
    }

    private long countByServiceIdAndCommunityId(Object serviceId,Integer communityId){
        if(serviceId == null || communityId == null){
            return 0L;
        }
        CommunityServiceRelaExample example = new CommunityServiceRelaExample();
        CommunityServiceRelaExample.Criteria criteria =example.createCriteria();
        if(serviceId instanceof Integer){
            criteria.andServiceIdEqualTo((Integer) serviceId);
        }else if(serviceId instanceof List){
            criteria.andServiceIdIn((List<Integer>) serviceId);
        }
        criteria.andCommunityIdEqualTo(communityId);
        criteria.andStatusEqualTo(Constant.CommunityServiceRela.Status.ENABLE);
        return countByExample(example);
    }

    public CommunityServiceRela getCommunityServiceRela(int serviceId , int communityId){
        CommunityServiceRelaExample example = new CommunityServiceRelaExample();
        example.createCriteria().andServiceIdEqualTo(serviceId).andCommunityIdEqualTo(communityId);
        List<CommunityServiceRela> list = selectByExample(example);
        if(list != null && list.size() > 0){
            return list.get(0);
        }
        return null;
    }
}
