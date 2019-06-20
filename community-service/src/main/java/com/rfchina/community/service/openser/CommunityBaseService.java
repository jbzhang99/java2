package com.rfchina.community.service.openser;

import com.rfchina.community.persistence.mapper.BaseMapper;
import com.rfchina.community.persistence.mapper.CommunityMapper;
import com.rfchina.community.persistence.mapper.CommunityServiceCategoryMapper;
import com.rfchina.community.persistence.mapper.ext.ExtBaseCommunityMapper;
import com.rfchina.community.persistence.model.Community;
import com.rfchina.community.persistence.model.CommunityExample;
import com.rfchina.community.persistence.model.CommunityServiceCategory;
import com.rfchina.community.persistence.model.CommunityServiceCategoryExample;
import com.rfchina.community.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName CommunityService
 * @Description 社区service
 * @Author wlrllr
 * @Date 2018/12/25 11:38
 * @Version 1.0
 **/
@Service
public class CommunityBaseService extends AbstractService<Community, CommunityExample,Integer> {

    @Autowired
    protected ExtBaseCommunityMapper mapper;

    @Override
    public BaseMapper<Community, CommunityExample, Integer> getMapper() {
        return mapper;
    }

    public List<Map<String,String>> getCommunityAreaByCommunityIds(List<Integer> communityIds){
        return mapper.getCommunityAreaByCommunityIds(communityIds);
    }

    public  List<Map> getCommunityByCityId(Integer cityId) {
        return mapper.getCommunityByCityId(cityId);
    }
}
