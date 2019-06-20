package com.rfchina.community.service.openser;

import com.rfchina.community.persistence.mapper.BaseMapper;
import com.rfchina.community.persistence.mapper.CommunityAroundPoiTypeMapper;
import com.rfchina.community.persistence.model.CommunityAroundPoiType;
import com.rfchina.community.persistence.model.CommunityAroundPoiTypeExample;
import com.rfchina.community.service.AbstractService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName CommunityAroundPoiTypeService
 * @Author wlrllr
 * @Date 2019/4/23 14:57
 * @Version 1.0
 **/
@Service
public class CommunityAroundPoiTypeService extends AbstractService<CommunityAroundPoiType, CommunityAroundPoiTypeExample,Long> {

    @Autowired
    private CommunityAroundPoiTypeMapper communityAroundPoiTypeMapper;

    @Override
    public BaseMapper getMapper() {
        return communityAroundPoiTypeMapper;
    }

    public boolean isExitName(String name){
        if(StringUtils.isNotBlank(name)){
            CommunityAroundPoiTypeExample example = new CommunityAroundPoiTypeExample();
            example.createCriteria().andNameEqualTo(name);
            return countByExample(example)>0;
        }
        return false;
    }

    public boolean isExitName(String name,Integer level){
        if(StringUtils.isNotBlank(name)){
            CommunityAroundPoiTypeExample example = new CommunityAroundPoiTypeExample();
            example.createCriteria().andNameEqualTo(name).andLevelEqualTo(level);
            return countByExample(example)>0;
        }
        return false;
    }

    public CommunityAroundPoiType getByName(String name,Integer level){
        if(StringUtils.isNotBlank(name)){
            CommunityAroundPoiTypeExample example = new CommunityAroundPoiTypeExample();
            example.createCriteria().andNameEqualTo(name).andLevelEqualTo(level);
            List<CommunityAroundPoiType> list =  selectByExample(example);
            if(list != null){
                return list.get(0);
            }
        }
        return null;
    }
}
