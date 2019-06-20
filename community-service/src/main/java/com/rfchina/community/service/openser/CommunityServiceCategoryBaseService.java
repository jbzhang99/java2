package com.rfchina.community.service.openser;

import com.rfchina.community.persistence.mapper.BaseMapper;
import com.rfchina.community.persistence.mapper.CommunityServiceCategoryMapper;
import com.rfchina.community.persistence.model.CommunityServiceCategory;
import com.rfchina.community.persistence.model.CommunityServiceCategoryExample;
import com.rfchina.community.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName CommunityServiceCategoryService
 * @Description 服务分类service
 * @Author wlrllr
 * @Date 2018/12/25 11:38
 * @Version 1.0
 **/
@Service
public class CommunityServiceCategoryBaseService extends AbstractService<CommunityServiceCategory, CommunityServiceCategoryExample,Long> {

    @Autowired
    protected CommunityServiceCategoryMapper mapper;

    @Override
    public BaseMapper<CommunityServiceCategory, CommunityServiceCategoryExample, Long> getMapper() {
        return mapper;
    }

    public List<CommunityServiceCategory> getCommunityServiceCategoryByServiceId(Integer serviceId){
        return mapper.getCommunityServiceCategoryByServiceId(serviceId);
    }
}
