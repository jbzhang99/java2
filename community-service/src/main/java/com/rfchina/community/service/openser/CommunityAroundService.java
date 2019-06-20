package com.rfchina.community.service.openser;

import com.rfchina.community.persistence.mapper.BaseMapper;
import com.rfchina.community.persistence.mapper.ext.ExtCommunityAroundMapper;
import com.rfchina.community.persistence.model.CommunityAround;
import com.rfchina.community.persistence.model.CommunityAroundExample;
import com.rfchina.community.service.AbstractService;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName CommunityAroundService
 * @Author wlrllr
 * @Date 2019/4/23 14:54
 * @Version 1.0
 **/
@Service
public class CommunityAroundService extends AbstractService<CommunityAround, CommunityAroundExample, Long> {

    @Autowired
    private ExtCommunityAroundMapper extCommunityAroundMapper;

    @Override
    public BaseMapper<CommunityAround, CommunityAroundExample, Long> getMapper() {
        return extCommunityAroundMapper;
    }

    /**
     * @Author wlrllr
     * @Description //获取所有社区
     * @Date 2019/4/26
     * @Param []
     * @return java.util.List<com.rfchina.community.persistence.model.Community>
     **/
    public List<CommunityAround> getAllCommunity(){
        return extCommunityAroundMapper.getAllCommunity();
    }

    public PageList<CommunityAround> page(Map<String,Object> param, int index, int size){
        return extCommunityAroundMapper.page(param,new PageBounds(index,size));
    }

    public List<CommunityAround> getUnSyncCommunity(){
        return extCommunityAroundMapper.getUnSyncCommunity();
    }

    public int addNewCommunityAround(){
        return extCommunityAroundMapper.addNewCommunityAround();
    }

    public int updateCommunityAroundLocation(){
        return extCommunityAroundMapper.updateCommunityAroundLocation();
    }

    public int markCommunityAroundPoiRel(){
        return extCommunityAroundMapper.markCommunityAroundPoiRel();
    }
}
