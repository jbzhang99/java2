package com.rfchina.community.service.openser;

import com.google.common.collect.Maps;
import com.rfchina.community.base.SysConstant;
import com.rfchina.community.persistence.mapper.*;
import com.rfchina.community.persistence.mapper.ext.*;
import com.rfchina.community.persistence.model.*;
import com.rfchina.community.persistence.model.ext.ExtCommunityAroundPoi;
import com.rfchina.community.persistence.model.ext.ExtCommunityAroundPoiType;
import com.rfchina.community.service.AbstractService;
import org.mybatis.paginator.model.Page;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ClassName CommunityAroundPoiService
 * @Author wlrllr
 * @Date 2019/4/23 14:54
 * @Version 1.0
 **/
@Service
public class CommunityAroundPoiService extends AbstractService<CommunityAroundPoi, CommunityAroundPoiExample, Long> {

    @Autowired
    private CommunityAroundService communityAroundService;
    @Autowired
    private ExtCommunityAroundPoiMapper extCommunityAroundPoiMapper;
    @Autowired
    private ExtCommunityAroundPoiTagMapper extCommunityAroundPoiTagMapper;
    @Autowired
    private ExtCommunityAroundPoiTagRelMapper extCommunityAroundPoiTagRelMapper;
    @Autowired
    private ExtCommunityAroundPoiExtMapper extCommunityAroundPoiExtMapper;
    @Autowired
    private ExtCommunityPicMapper extCommunityPicMapper;
    @Autowired
    private CommunityAroundPoiTypeRelMapper communityAroundPoiTypeRelMapper;
    @Autowired
    private ExtCommunityAroundUpdatePlanMapper extCommunityAroundUpdatePlanMapper;
    @Autowired
    private ExtCommunityAroundPoiTypeMapper extCommunityAroundPoiTypeMapper;
    @Autowired
    private ExtCommunityAroundSearchLogMapper extCommunityAroundSearchLogMapper;

    @Override
    public BaseMapper<CommunityAroundPoi, CommunityAroundPoiExample, Long> getMapper() {
        return extCommunityAroundPoiMapper;
    }


    public PageList<CommunityAroundUpdatePlan> getUnCompleteUpdatePlan(PageBounds pageBounds) {
        if (pageBounds == null) {
            pageBounds = new PageBounds();
        }
        Map map = Maps.newHashMap();
        map.put("status", -1);
        return extCommunityAroundUpdatePlanMapper.pageByExample(map, pageBounds);
    }

    public PageList<ExtCommunityAroundPoi> pagePoi(Map<String, Object> param, PageBounds pageBounds) {
        return extCommunityAroundPoiMapper.page(param, pageBounds);
    }

    public List<ExtCommunityAroundPoi> getUnSyncPoiExtCommunity() {
        return extCommunityAroundPoiMapper.getUnSyncPoiExtCommunity();
    }

    public void updatePoiExtInfo(CommunityAroundPoiExt ext) {
        if (ext != null && ext.getPoiId() != null) {
            extCommunityAroundPoiExtMapper.updateByPrimaryKeySelective(ext);
        }
    }

    /**
     * @return boolean
     * @Author wlrllr
     * @Description //通过高德apiId查询商户
     * @Date 2019/4/25
     * @Param [apiId]
     **/
    public CommunityAroundPoi getByApiId(String apiId) {
        CommunityAroundPoiExample example = new CommunityAroundPoiExample();
        example.createCriteria().andApiIdEqualTo(apiId);
        List<CommunityAroundPoi> list = selectByExample(example);
        if (list == null || list.size() < 1) {
            return null;
        }
        return list.get(0);
    }

    public CommunityAroundPoiTag saveTag(String tagName) {
        CommunityAroundPoiTag tag = new CommunityAroundPoiTag();
        tag.setName(tagName);
        tag.setSort(0);
        tag.setCreateTime(new Date());
        tag.setStatus(Integer.valueOf(SysConstant.COMMON_STATUS_NORMAL));
        return saveTag(tag);
    }

    public CommunityAroundPoiTag saveTag(CommunityAroundPoiTag tag) {
        CommunityAroundPoiTagExample example = new CommunityAroundPoiTagExample();
        example.createCriteria().andNameEqualTo(tag.getName());
        List<CommunityAroundPoiTag> list = extCommunityAroundPoiTagMapper.selectByExample(example);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        extCommunityAroundPoiTagMapper.insertSelective(tag);
        return tag;
    }

    public void saveTagAndRel(CommunityAroundPoiTag tag, Long poiId) {
        tag = saveTag(tag);
        saveTagRel(tag.getId(), poiId);
    }

    public void deleteTagRelByPoiId(Long poiId) {
        extCommunityAroundPoiTagRelMapper.deleteByPoiId(poiId);
    }

    public void saveTagRel(Long tagId, Long poiId) {
        try {
            CommunityAroundPoiTagRelKey relKey = new CommunityAroundPoiTagRelKey();
            relKey.setPoiId(poiId);
            relKey.setTagId(tagId);
            long num = extCommunityAroundPoiTagRelMapper.countByPrimaryKey(relKey);
            if(num == 0){
                extCommunityAroundPoiTagRelMapper.insert(relKey);
            }
        } catch (Exception e) {
            logger.error("该标签关系已存在，新增失败", e);
        }
    }

    public CommunityAroundPoiTag getTagByName(String tagName) {
        CommunityAroundPoiTagExample example = new CommunityAroundPoiTagExample();
        example.createCriteria().andNameEqualTo(tagName);
        List<CommunityAroundPoiTag> list = extCommunityAroundPoiTagMapper.selectByExample(example);
        return list != null && list.size() > 0 ? list.get(0) : null;
    }

    public void savePoiTypeRel(List<String> types, Long poiId, String poiType) {
        for (String str : types) {
            if (str.equals(poiType) && !hasTypeRel(str, poiId)) {
                CommunityAroundPoiTypeRelKey relKey = new CommunityAroundPoiTypeRelKey();
                relKey.setPoiId(poiId);
                relKey.setType(str);
                communityAroundPoiTypeRelMapper.insert(relKey);
            }
        }
    }

    public void savePoiTypeRel(Long poiId, String poiType) {
        if (!hasTypeRel(poiType, poiId)) {
            CommunityAroundPoiTypeRelKey relKey = new CommunityAroundPoiTypeRelKey();
            relKey.setPoiId(poiId);
            relKey.setType(poiType);
            communityAroundPoiTypeRelMapper.insert(relKey);
        }
    }

    @Transactional
    public void batchAddPoiPic(List<CommunityPic> list) {
        if (list != null && list.size() > 0) {
            deletePicByPoiId(list.get(0).getTargetId());
            extCommunityPicMapper.batchInsert(list);
        }
    }

    public void deletePicByPoiId(Long poiId) {
        CommunityPicExample example = new CommunityPicExample();
        example.createCriteria().andTargetIdEqualTo(poiId);
        extCommunityPicMapper.deleteByExample(example);
    }

    public CommunityAroundPoiExt addPoiExtInfo(CommunityAroundPoiExt ext) {
        if (ext != null && ext.getPoiId() != null) {
            CommunityAroundPoiExt e = extCommunityAroundPoiExtMapper.selectByPrimaryKey(ext.getPoiId());
            if (e == null) {
                extCommunityAroundPoiExtMapper.insertSelective(ext);
            } else {
                return e;
            }
        }
        return ext;
    }

    private Boolean hasTypeRel(String type, Long poiId) {
        CommunityAroundPoiTypeRelExample example = new CommunityAroundPoiTypeRelExample();
        example.createCriteria().andPoiIdEqualTo(poiId).andTypeEqualTo(type);
        return communityAroundPoiTypeRelMapper.countByExample(example) > 0 ? true : false;
    }

    public void savePoiExt(CommunityAroundPoiExt ext, Boolean addFlag) {
        if (ext != null) {
            if (addFlag) {
                extCommunityAroundPoiExtMapper.insertSelective(ext);
            } else {
                extCommunityAroundPoiExtMapper.updateByPrimaryKeySelective(ext);
            }
        }
    }

    public List<CommunityPic> selectByPoiId(Long poiId) {
        CommunityPicExample example = new CommunityPicExample();
        example.createCriteria().andTargetIdEqualTo(poiId);
        return extCommunityPicMapper.selectByExample(example);
    }

    /**
     * 获取所有社区
     */
    public List<CommunityAround> getAllCommunity() {
        return communityAroundService.getAllCommunity();
    }

    /**
     * 社区查询
     *
     * @param param
     * @param index
     * @param size
     */
    public Page<CommunityAround> pageCommunityAround(Map<String, Object> param, Integer index, Integer size) {
        PageList<CommunityAround> list = communityAroundService.page(param, index, size);
        return list.convert();
    }

    /**
     * 查询分类
     *
     * @param param
     * @param pageBounds
     * @return
     */
    public PageList<ExtCommunityAroundPoiType> pageCommunityAroundPoiType(Map<String, Object> param, PageBounds pageBounds) {
        return extCommunityAroundPoiTypeMapper.page(param, pageBounds);
    }

    /**
     * 校验分类是否存在
     * @param secondTypeName
     * @return
     */
    public boolean hasPoiType(String secondTypeName,Integer level) {
        CommunityAroundPoiTypeExample example = new CommunityAroundPoiTypeExample();
        example.createCriteria().andNameEqualTo(secondTypeName).andLevelEqualTo(level);
        return extCommunityAroundPoiTypeMapper.countByExample(example)>0;
    }

    public void savePoiType(CommunityAroundPoiType type) {
        if(type != null ){
            extCommunityAroundPoiTypeMapper.insertSelective(type);
        }
    }

    /**
     * @Author wlrllr
     * @Description //通过type更新类目
     * @Date 2019/5/5
     * @Param [poiType]
     * @return void
     **/
    public void updatePoiType(CommunityAroundPoiType poiType) {
        CommunityAroundPoiTypeExample example = new CommunityAroundPoiTypeExample();
        example.createCriteria().andTypeEqualTo(poiType.getType());
        extCommunityAroundPoiTypeMapper.updateByExampleSelective(poiType,example);
    }

    public void updateChildPoiType(CommunityAroundPoiType poiType) {
        CommunityAroundPoiTypeExample example = new CommunityAroundPoiTypeExample();
        example.createCriteria().andParentTypeEqualTo(poiType.getParentType());
        extCommunityAroundPoiTypeMapper.updateByExampleSelective(poiType,example);
    }

    public CommunityAroundPoiType getPoiType(String type) {
        CommunityAroundPoiTypeExample example = new CommunityAroundPoiTypeExample();
        example.createCriteria().andTypeEqualTo(type);
        List<CommunityAroundPoiType> list = extCommunityAroundPoiTypeMapper.selectByExample(example);
        if(list != null){
            return list.get(0);
        }
        return null;
    }

    public ExtCommunityAroundPoi getPoiById(Long poiId) {
        return extCommunityAroundPoiMapper.getPoiById(poiId);
    }

    public List<CommunityAroundPoiTag> getTagByPoiId(Long poiId) {
        return extCommunityAroundPoiTagMapper.getTagByPoiId(poiId);
    }

    public CommunityAround getCommunityById(Long communityId) {
        return communityAroundService.selectByPrimaryKey(communityId);
    }

    public List<CommunityPic> getPicByPoiId(Long poiId) {
        if(poiId != null){
            CommunityPicExample example = new CommunityPicExample();
            example.createCriteria().andTargetIdEqualTo(poiId);
            return extCommunityPicMapper.selectByExample(example);
        }
        return new ArrayList<>();
    }

    public PageList<CommunityPic> getPic(Integer status,int size) {
        return extCommunityPicMapper.page(status,new PageBounds(0,size));
    }

    public List<Map> groupType() {
        return extCommunityAroundPoiTypeMapper.groupType();
    }

    public PageList<ExtCommunityAroundPoi> searchPoi(Map<String, Object> param, PageBounds pageBounds) {
        return extCommunityAroundPoiMapper.searchPoi(param,pageBounds);
    }

    public List<CommunityAroundSearchLog> getUserSearchLog(Long uid) {
       return extCommunityAroundSearchLogMapper.getUserSearchLog(uid);
    }

    public void updatePicByPrimarykey(CommunityPic pic) {
        if(pic != null){
            extCommunityPicMapper.updateByPrimaryKeySelective(pic);
        }
    }

    public List<CommunityAroundPoiType> getFirstPoiType() {
        CommunityAroundPoiTypeExample example = new CommunityAroundPoiTypeExample();
        example.createCriteria().andLevelEqualTo(1).andStatusEqualTo(Integer.valueOf(SysConstant.COMMON_STATUS_NORMAL));
        return extCommunityAroundPoiTypeMapper.selectByExample(example);
    }

    public List<CommunityAroundPoiType> getPoiTypeByParentType(String parentType) {
        CommunityAroundPoiTypeExample example = new CommunityAroundPoiTypeExample();
        example.createCriteria().andParentTypeEqualTo(parentType).andStatusEqualTo(Integer.valueOf(SysConstant.COMMON_STATUS_NORMAL));
        return extCommunityAroundPoiTypeMapper.selectByExample(example);
    }

    public CommunityAroundPoiExt getPoiExt(Long poiId) {
        return extCommunityAroundPoiExtMapper.selectByPrimaryKey(poiId);
    }

    public PageList<CommunityAroundPoiExt> pagePoiExt(int size) {
        return extCommunityAroundPoiExtMapper.pageByExample(new PageBounds(0,size));
    }

    public List<ExtCommunityAroundPoi> getUnSyncPoi() {
       return extCommunityAroundPoiMapper.getUnSyncPoi();
    }

}
