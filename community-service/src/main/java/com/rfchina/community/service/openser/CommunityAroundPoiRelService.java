package com.rfchina.community.service.openser;

import com.rfchina.community.base.util.HarvenSinUtils;
import com.rfchina.community.persistence.mapper.BaseMapper;
import com.rfchina.community.persistence.mapper.ext.ExtCommunityAroundPoiRelMapper;
import com.rfchina.community.persistence.model.*;
import com.rfchina.community.persistence.model.ext.ExtCommunityAroundPoiRel;
import com.rfchina.community.service.AbstractService;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName CommunityAroundPoiService
 * @Author wlrllr
 * @Date 2019/4/23 14:54
 * @Version 1.0
 **/
@Service
public class CommunityAroundPoiRelService extends AbstractService<CommunityAroundPoiRel, CommunityAroundPoiRelExample, CommunityAroundPoiRelKey> {

    @Autowired
    private ExtCommunityAroundPoiRelMapper extCommunityAroundPoiRelMapper;

    @Override
    public BaseMapper<CommunityAroundPoiRel, CommunityAroundPoiRelExample, CommunityAroundPoiRelKey> getMapper() {
        return extCommunityAroundPoiRelMapper;
    }

    public Boolean hasRel(Long communityId,Long poiId){
        CommunityAroundPoiRelExample example = new CommunityAroundPoiRelExample();
        example.createCriteria().andCommunityIdEqualTo(communityId).andPoiIdEqualTo(poiId);
        return countByExample(example)>0?true : false;
    }

    public void deleteRel(Long communityId,Long poiId){
        CommunityAroundPoiRelKey key = new CommunityAroundPoiRelKey();
        key.setCommunityId(communityId);
        key.setPoiId(poiId);
        deleteByPrimaryKey(key);
    }

    public void delByCommunityId(Long communityId){
        CommunityAroundPoiRelExample example = new CommunityAroundPoiRelExample();
        example.createCriteria().andCommunityIdEqualTo(communityId);
        deleteByExample(example);
    }

    public void delByPoiId(Long poiId){
        CommunityAroundPoiRelExample example = new CommunityAroundPoiRelExample();
        example.createCriteria().andPoiIdEqualTo(poiId);
        deleteByExample(example);
    }

    public void saveCommunityRel(CommunityAroundPoi poi, CommunityAround ca) {
        deleteRel(ca.getId(),poi.getId());
        CommunityAroundPoiRel rel = new CommunityAroundPoiRel();
        rel.setCommunityId(ca.getId());
        rel.setPoiId(poi.getId());
        rel.setStatus(0);
        Double distance = HarvenSinUtils.distance(poi.getLatitude(), poi.getLongitude(), ca.getLatitude(), ca.getLongitude());
        rel.setDistance(Double.valueOf(String.format("%.2f", distance)));
        insert(rel);
    }

    public void batchInsert(List<CommunityAroundPoiRel> rels) {
        extCommunityAroundPoiRelMapper.batchInsert(rels);
    }

    public PageList<ExtCommunityAroundPoiRel> pageOldRel(PageBounds pageBounds){
        return extCommunityAroundPoiRelMapper.pageOldRel(pageBounds);
    }
}
