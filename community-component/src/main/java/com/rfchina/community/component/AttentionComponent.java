package com.rfchina.community.component;

import com.rfchina.community.entity.AttentionSim;
import com.rfchina.community.persistence.mapper.ext.ExtCommunityAttentionRelaMapper;
import org.mybatis.paginator.model.Page;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 */
@Component
public class AttentionComponent {

    @Autowired
    public ExtCommunityAttentionRelaMapper extCommunityAttentionMapper;

    public Long countMasterChildAttentionByUid(Long uid) {
        return extCommunityAttentionMapper.countMasterChildAttentionByUid(uid);
    }

    public Long countUserAttentionByUid(Long uid) {
        return extCommunityAttentionMapper.countCommunityAttentionByUid(uid);
    }

    public Page<AttentionSim> getMasterChildAttentionList(Long uid, Integer index, Integer size) {
        PageBounds pageBounds = new PageBounds(index, size);
        PageList<AttentionSim> pageList = extCommunityAttentionMapper.getMasterChildAttentionList(uid, pageBounds);
        return pageList.convert();
    }

    public Page<AttentionSim> getCommunityAttentionList(Long uid, Integer index, Integer size) {
        PageBounds pageBounds = new PageBounds(index, size);
        PageList<AttentionSim> pageList = extCommunityAttentionMapper.getCommunityAttentionList(uid, pageBounds);
        return pageList.convert();
    }
}
