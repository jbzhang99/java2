package com.rfchina.community.open.bridge.service;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.rfchina.community.base.IdGenerator;
import com.rfchina.community.base.SysConstant;
import com.rfchina.community.base.util.HarvenSinUtils;
import com.rfchina.community.component.FastDFSGlobalService;
import com.rfchina.community.open.bridge.WorkBookUtils;
import com.rfchina.community.open.bridge.entity.BridgeCommunityAroundPoi;
import com.rfchina.community.persistence.model.*;
import com.rfchina.community.persistence.model.ext.ExtCommunityAroundPoi;
import com.rfchina.community.persistence.model.ext.ExtCommunityAroundPoiType;
import com.rfchina.community.persistence.model.ext.ExtUserComment;
import com.rfchina.community.service.openser.CommunityAroundPoiRelService;
import com.rfchina.community.service.openser.CommunityAroundPoiService;
import com.rfchina.community.service.openser.UserCommentService;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.mybatis.paginator.model.Page;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ClassName CommunityAroundManageBridgeService
 * @Description 社区周边service包含单个社区周边信息刷新
 * @Author wlrllr
 * @Date 2019/4/25 15:24
 * @Version 1.0
 **/
@Service
public class CommunityAroundManageBridgeService extends BaseService {

    @Autowired
    private CommunityAroundPoiService communityAroundPoiService;
    @Autowired
    private UserCommentService userCommentService;
    @Autowired
    private CommunityAroundPoiRelService communityAroundPoiRelService;
    @Autowired
    private FastDFSGlobalService fastDFSGlobalService;

    public Page<ExtCommunityAroundPoi> pagePoi(Map<String, Object> param, PageBounds pageBounds) {
        PageList<ExtCommunityAroundPoi> pageList = communityAroundPoiService.pagePoi(param, pageBounds);
        return pageList.convert();
    }

    public SXSSFWorkbook exportPoi(Map<String, Object> param) {
        PageList<ExtCommunityAroundPoi> pageList = communityAroundPoiService.pagePoi(param, new PageBounds());

        SXSSFWorkbook workbook = configWorkBook();
        Sheet sheet = workbook.createSheet("社区周边商家统计");
        String titleTops = "商家ID,商家名称,商家一级类别,商家二级类别,省份,城市,区镇,详细地址,商家电话,人均消费,商家评分,商家标签,创建时间,更新时间,状态";
        WorkBookUtils.setTitle(titleTops, sheet.createRow(0));
        int r = 1;
        for (ExtCommunityAroundPoi poi : pageList) {
            //设置单元格合并
            Row row = sheet.createRow(r++);
            int i = 0;
            WorkBookUtils.setCell(row, i++, poi.getId());
            WorkBookUtils.setCell(row, i++, poi.getName());
            WorkBookUtils.setCell(row, i++, poi.getPoiType().getParentName());
            WorkBookUtils.setCell(row, i++, poi.getPoiType().getName());
            WorkBookUtils.setCell(row, i++, poi.getProvinceName());
            WorkBookUtils.setCell(row, i++, poi.getCityName());
            WorkBookUtils.setCell(row, i++, poi.getAdName());
            WorkBookUtils.setCell(row, i++, poi.getAddress());
            WorkBookUtils.setCell(row, i++, poi.getTel());
            CommunityAroundPoiExt ext = poi.getExt();
            Double cost = null;
            Double rating = null;
            if (ext != null) {
                cost = ext.getCost();
                rating = ext.getRating();
            }
            WorkBookUtils.setCell(row, i++, cost);
            WorkBookUtils.setCell(row, i++, rating);
            WorkBookUtils.setCell(row, i++, poi.getApiType());
            WorkBookUtils.setCell(row, i++, poi.getCreateTime());
            WorkBookUtils.setCell(row, i++, poi.getUpdateTime());
            WorkBookUtils.setCell(row, i++, poi.getStatus() == 1 ? "启用" : "禁用");
        }
        return workbook;
    }

    /**
     * 新增商户信息
     *
     * @param bridgePoi
     */
    @Transactional(rollbackFor = Throwable.class)
    public void addPoi(BridgeCommunityAroundPoi bridgePoi) {
        try{
            CommunityAroundPoi poi = savePoi(bridgePoi);
            Long poiId = poi.getId();
            buildTag(bridgePoi.getTag(), poiId);
            buildPoiExt(bridgePoi, poiId);
            buildPic(bridgePoi, poiId);
            //重新计算社区与商户的绑定关系
            buildPoiRel(poi);
        }catch (Exception e){
            logger.error("新增/修改商户失败",e);
            error("新增/修改商户失败");
        }

    }

    public List<CommunityPic> getPoiPic(Long poiId) {
        return communityAroundPoiService.selectByPoiId(poiId);
    }

    public Page<Map<String, Object>> getCommunityDistance(Long poiId, Integer index, Integer size) {
        CommunityAroundPoi poi = communityAroundPoiService.selectByPrimaryKey(poiId);
        Page<CommunityAround> page = communityAroundPoiService.pageCommunityAround(null, index, size);
        String lat1 = poi.getLatitude();
        String lon1 = poi.getLongitude();
        List<Map<String, Object>> list = new ArrayList<>();
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        numberFormat.setMaximumFractionDigits(1);
        numberFormat.setRoundingMode(RoundingMode.HALF_UP);
        for (CommunityAround ca : page.getList()) {
            Map<String, Object> map = Maps.newHashMap();
            Double distance = HarvenSinUtils.distance(lat1, lon1, ca.getLatitude(), ca.getLongitude());
            if (distance > 1000) {
                map.put("distance", numberFormat.format(distance / 1000) + "公里");
            } else {
                map.put("distance", distance.intValue() + "米");
            }
            map.put("communityName", ca.getName());
            map.put("cityName", ca.getCityName());
            map.put("communityId", ca.getId());
            list.add(map);
        }
        return Page.convert(page.getIndex(), page.getSize(), page.getTotal(), list);
    }

    public Page<ExtUserComment> getPoiComment(Long poiId, int index, int size) {
        PageList<ExtUserComment> list = userCommentService.pageComment(poiId, SysConstant.COMMENT_TARGET_TYPE_POI, index, size);
        return list.convert();
    }

    private void buildPoiRel(CommunityAroundPoi poi) {
        communityAroundPoiRelService.delByPoiId(poi.getId());
        //查询所有社区
        List<CommunityAround> list = communityAroundPoiService.getAllCommunity();
        if (list != null && list.size() > 0) {
            String latitude = poi.getLatitude();
            String longitude = poi.getLongitude();
            List<CommunityAroundPoiRel> rels = new ArrayList<>();
            for (CommunityAround around : list) {
                Double distance = HarvenSinUtils.distance(around.getLatitude(), around.getLongitude(), latitude, longitude);
                if (distance <= 5000) {
                    CommunityAroundPoiRel rel = new CommunityAroundPoiRel();
                    rels.add(rel);
                    rel.setPoiId(poi.getId());
                    rel.setCommunityId(around.getId());
                    rel.setDistance(Double.valueOf(String.format("%.2f", distance)));
                }
            }
            if (rels != null && rels.size() > 0) {
                communityAroundPoiRelService.batchInsert(rels);
            }
        }
    }

    private CommunityAroundPoi savePoi(BridgeCommunityAroundPoi bridgePoi) {
        Long poiId = bridgePoi.getId();
        CommunityAroundPoi poi = new CommunityAroundPoi();
        String olcPicUrl = null;
        if (poiId != null) {
            poi = communityAroundPoiService.selectByPrimaryKey(bridgePoi.getId());
            if(poi != null){
                olcPicUrl = poi.getPicUrl();
            }else{
                poi = new CommunityAroundPoi();
            }
        }
        BeanUtils.copyProperties(bridgePoi, poi);
        String picUrl = bridgePoi.getPicUrl();
        if (picUrl != null) {
            poi.setPicUrl((picUrl.split(","))[0]);
        }
        if (poi.getId() != null) {
            poi.setUpdateTime(new Date());
            communityAroundPoiService.updateByPrimaryKeySelective(poi);
            deletePic(olcPicUrl);
            bridgePoi.setAddFlag(false);
        } else {
            poi.setCreateTime(new Date());
            poi.setSyncStatus(1); //新增商户默认为百度经纬度不需要转换
            bridgePoi.setAddFlag(true);
            communityAroundPoiService.insertSelective(poi);
        }
        return poi;
    }

    private void buildPoiExt(BridgeCommunityAroundPoi bridgeCommunityAroundPoi, Long poiId) {
        CommunityAroundPoiExt ext = new CommunityAroundPoiExt();
        ext.setPoiId(poiId);
        ext.setCost(bridgeCommunityAroundPoi.getCost() == null ? 0L : bridgeCommunityAroundPoi.getCost());
        ext.setRating(bridgeCommunityAroundPoi.getRating());
        ext.setShopHours(bridgeCommunityAroundPoi.getShopHours());
        ext.setSyncStatus(Integer.valueOf(SysConstant.COMMON_STATUS_NORMAL));
        ext.setFeaturedService(parseFeaturedService(bridgeCommunityAroundPoi.getFeaturedService()));
        communityAroundPoiService.savePoiExt(ext, bridgeCommunityAroundPoi.getAddFlag());
    }

    private String parseFeaturedService(String featuredService){
        List<String> featuredServiceList = new ArrayList<>();
        if(StringUtils.isNotBlank(featuredService)){
            String[] services = featuredService.split(";");
            for(String s : services){
                if(StringUtils.isNotBlank(s)){
                    featuredServiceList.add(s);
                }
            }
        }
        return JSON.toJSONString(featuredServiceList);
    }
    private void buildTag(String tagStr, Long poiId) {
        communityAroundPoiService.deleteTagRelByPoiId(poiId);
        if (StringUtils.isNotBlank(tagStr) && poiId != null) {
            String[] tags = tagStr.split(";");
            int index = 1;
            Date now = new Date();
            for (String tag : tags) {
                if (tag != null && StringUtils.isNotBlank(tag.trim())) {
                    CommunityAroundPoiTag poiTag = new CommunityAroundPoiTag();
                    poiTag.setName(tag);
                    poiTag.setSort(index++);
                    poiTag.setCreateTime(now);
                    poiTag.setStatus(Integer.valueOf(SysConstant.COMMON_STATUS_NORMAL));
                    communityAroundPoiService.saveTagAndRel(poiTag, poiId);
                }
            }
        }
    }

    private void buildPic(BridgeCommunityAroundPoi bridgeCommunityAroundPoi, Long poiId) {
        String picUrlStr = bridgeCommunityAroundPoi.getPicUrl();
        String[] picUrls = null;
        if (picUrlStr != null) {
            picUrls = picUrlStr.split(",");
        }
        List<CommunityPic> oldPics = communityAroundPoiService.getPicByPoiId(poiId);
        if (picUrls != null && picUrls.length > 0) {
            List<CommunityPic> pics = new ArrayList<>();
            for (String picUrl : picUrls) {
                CommunityPic pic = new CommunityPic();
                pics.add(pic);
                pic.setTargetId(poiId);
                pic.setPicUrl(picUrl);
                pic.setStatus(Integer.valueOf(SysConstant.COMMON_STATUS_NORMAL));
            }
            if (pics.size() > 0) {
                communityAroundPoiService.batchAddPoiPic(pics);
            }
        }
        //最后删除图片
        if(oldPics != null && oldPics.size()>0){
            for(CommunityPic pic : oldPics){
                if(indexOf(pic.getPicUrl(),picUrls)<0){
                    deletePic(pic.getPicUrl());
                }
            }
        }
    }

    /**
     * 查询社区
     *
     * @param param
     * @param index
     * @param size
     * @return
     */
    public Page<CommunityAround> pageCommunityAround(Map<String, Object> param, Integer index, Integer size) {
        return communityAroundPoiService.pageCommunityAround(param, index, size);
    }

    /**
     * 查询商户分类
     *
     * @param param
     * @param index
     * @param size
     * @return
     */
    public Page<ExtCommunityAroundPoiType> pageCommunityAroundPoiType(Map<String, Object> param, Integer index, Integer size) {
        return communityAroundPoiService.pageCommunityAroundPoiType(param, new PageBounds(index, size)).convert();
    }

    public SXSSFWorkbook exportCommunityAroundPoiType(Map<String, Object> param) {
        PageList<ExtCommunityAroundPoiType> list = communityAroundPoiService.pageCommunityAroundPoiType(param, new PageBounds());
        SXSSFWorkbook workbook = configWorkBook();
        Sheet sheet = workbook.createSheet("社区周边类目统计");
        String titleTops = "一级分类ID,一级分类,一级分类排序,二级分类ID,二级分类,二级分类排序,二级分类状态,高德分类ID";
        WorkBookUtils.setTitle(titleTops, sheet.createRow(0));
        int r = 1;
        for (ExtCommunityAroundPoiType poiType : list) {
            //设置单元格合并
            Row row = sheet.createRow(r++);
            int i = 0;
            WorkBookUtils.setCell(row, i++, poiType.getParentType());
            WorkBookUtils.setCell(row, i++, poiType.getParentName());
            WorkBookUtils.setCell(row, i++, poiType.getParentSort());
            WorkBookUtils.setCell(row, i++, poiType.getType());
            WorkBookUtils.setCell(row, i++, poiType.getName());
            WorkBookUtils.setCell(row, i++, poiType.getSort());
            WorkBookUtils.setCell(row, i++, buildStatus(poiType.getStatus()));
            WorkBookUtils.setCell(row, i++, poiType.getPoiType());
        }
        return workbook;
    }

    /**
     * 添加分类
     *
     * @param parentType
     * @param secondTypeName
     * @param sort
     */
    public void addPoiTyp(String parentType, String secondTypeName, Integer sort) {
        //校验二级分类是否存在
        validator(secondTypeName.length() > 10, "分类名称超过长度");
        validator(communityAroundPoiService.hasPoiType(secondTypeName, 2), "分类已存在");
        CommunityAroundPoiType parent = communityAroundPoiService.getPoiType(parentType);
        validator(parent == null, "找不到一级分类");
        CommunityAroundPoiType type = new CommunityAroundPoiType();
        type.setCreateTime(new Date());
        type.setLevel(2);
        type.setName(secondTypeName);
        type.setSort(sort);
        type.setStatus(Integer.valueOf(SysConstant.COMMON_STATUS_NORMAL));
        type.setType(IdGenerator.generate());
        type.setParentType(parentType);
        type.setParentName(parent.getName());
        type.setPoiPicUrl(parent.getPoiPicUrl());
        type.setPicUrl(parent.getPicUrl());
        communityAroundPoiService.savePoiType(type);
    }

    /**
     * @return void
     * @Author wlrllr
     * @Description //编辑类目
     * @Date 2019/5/5
     * @Param [parentType, name, type, sort]
     **/
    @Transactional
    public void editPoiType(String parentType, String name, String type, String picUrl, String poiPicUrl, String apiIdStr, Integer sort) {
        validator(name.length() > 10, "分类名称超过长度");
        CommunityAroundPoiType poiType = new CommunityAroundPoiType();
        if (StringUtils.isNotBlank(parentType)) {
            CommunityAroundPoiType parent = communityAroundPoiService.getPoiType(parentType);
            validator(parent == null, "找不到一级分类");
            poiType.setParentName(parent.getName());
            poiType.setParentType(parentType);
            poiType.setPicUrl(parent.getPicUrl());
            poiType.setPoiPicUrl(parent.getPoiPicUrl());
            //FIXME 新增高德分类
            /*if(StringUtils.isNotBlank(apiIdStr)){
                String[] apiIds = apiIdStr.split(",");
                for(String apiId : apiIds){

                }
            }*/
        } else { //修改一级分类时，更新二级分类中的一级分类名称，一级分类图片地址，一级分类默认商家图片地址
            CommunityAroundPoiType childPoiType = new CommunityAroundPoiType();
            if (StringUtils.isNotBlank(picUrl)) {
                childPoiType.setPicUrl(picUrl);
            }
            if (StringUtils.isNotBlank(poiPicUrl)) {
                childPoiType.setPoiPicUrl(poiPicUrl);
            }
            if (StringUtils.isNotBlank(name)) {
                childPoiType.setParentName(name);
            }
            childPoiType.setParentType(type);
            communityAroundPoiService.updateChildPoiType(childPoiType);
        }
        poiType.setUpdateTime(new Date());
        poiType.setName(name);
        poiType.setSort(sort);
        poiType.setType(type);
        if (StringUtils.isNotBlank(poiPicUrl)) {
            poiType.setPoiPicUrl(poiPicUrl);
        }
        if (StringUtils.isNotBlank(picUrl)) {
            poiType.setPicUrl(picUrl);
        }
        communityAroundPoiService.updatePoiType(poiType);
    }

    public void editPoiType(String type, Integer status) {
        CommunityAroundPoiType poiType = new CommunityAroundPoiType();
        poiType.setUpdateTime(new Date());
        poiType.setStatus(status);
        poiType.setType(type);
        communityAroundPoiService.updatePoiType(poiType);
    }

    public void editPoiStatus(Long poiId, Integer status) {
        CommunityAroundPoi poi = new CommunityAroundPoi();
        poi.setUpdateTime(new Date());
        poi.setStatus(status);
        poi.setId(poiId);
        communityAroundPoiService.updateByPrimaryKeySelective(poi);
    }

    public Map<String, Object> getPoiDetail(Long poiId) {
        Map<String, Object> result = Maps.newHashMap();
        List<CommunityAroundPoiTag> tags = communityAroundPoiService.getTagByPoiId(poiId);
        CommunityAroundPoiExt ext = communityAroundPoiService.getPoiExt(poiId);
        result.put("tags", tags == null ? new ArrayList<>() : tags);
        result.put("ext", ext == null ? new CommunityAroundPoiExt() : ext);
        List<CommunityPic> pics = getPoiPic(poiId);
        result.put("pics", pics == null ? new ArrayList<>() : pics);
        return result;
    }

    public void delPoiComment(Long commentId) {
        userCommentService.deleteComment(commentId);
    }


    public List<CommunityAroundPoiType> getFirstPoiType() {
        return communityAroundPoiService.getFirstPoiType();
    }

    public List<CommunityAroundPoiType> getPoiTypeByParentType(String parentType) {
        return communityAroundPoiService.getPoiTypeByParentType(parentType);
    }

    private SXSSFWorkbook configWorkBook() {
        SXSSFWorkbook workbook = new SXSSFWorkbook(500);
        workbook.setCompressTempFiles(true);
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setWrapText(true);
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        return workbook;
    }

    private String buildStatus(Integer status) {
        if (status.intValue() == Integer.valueOf(SysConstant.COMMON_STATUS_NORMAL)) {
            return "启用";
        } else if (status.intValue() == Integer.valueOf(SysConstant.COMMON_STATUS_DISABLE)) {
            return "禁用";
        }
        return "";
    }

    private void deletePic(String picUrl){
        if(StringUtils.isNotBlank(picUrl)){
            try {
                fastDFSGlobalService.delete(picUrl);
            } catch (Exception e) {
                logger.error("删除图片异常",e);
            }
        }
    }

    public int indexOf(Object o,Object[] elementData) {
        if(elementData != null && elementData.length>0){
            int size = elementData.length;
            if (o == null) {
                for (int i = 0; i < size; i++)
                    if (elementData[i]==null)
                        return i;
            } else {
                for (int i = 0; i < size; i++)
                    if (o.equals(elementData[i]))
                        return i;
            }
        }
        return -1;
    }
}
