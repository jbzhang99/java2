package com.rfchina.community.brothers.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.rfchina.community.base.SysConstant;
import com.rfchina.community.base.util.HarvenSinUtils;
import com.rfchina.community.component.FastDFSGlobalService;
import com.rfchina.community.persistence.mapper.AreaMapper;
import com.rfchina.community.persistence.mapper.ext.ExtCommunityAroundPoiDataMapper;
import com.rfchina.community.persistence.mapper.ext.ExtCommunityAroundUpdatePlanMapper;
import com.rfchina.community.persistence.model.*;
import com.rfchina.community.persistence.model.ext.ExtCommunityAroundPoi;
import com.rfchina.community.persistence.model.ext.ExtCommunityAroundPoiRel;
import com.rfchina.community.service.openser.CommunityAroundPoiRelService;
import com.rfchina.community.service.openser.CommunityAroundPoiService;
import com.rfchina.community.service.openser.CommunityAroundService;
import com.rfchina.community.service.openser.UserCommentService;
import com.rfchina.platform.common.http.HttpUtil;
import com.rfchina.platform.common.utils.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static com.rfchina.community.base.SysConstant.POI_PIC_STATUS_1;
import static com.rfchina.community.base.SysConstant.POI_PIC_STATUS_2;

/**
 * @ClassName CommunityAroundManageBridgeService
 * @Description 社区周边service包含单个社区周边信息刷新
 * @Author wlrllr
 * @Date 2019/4/25 15:24
 * @Version 1.0
 **/
@Service
public class CommunityAroundManageBrotherService {

    private static Logger logger = LoggerFactory.getLogger(CommunityAroundManageBrotherService.class);

    @Autowired
    private AreaMapper areaMapper;
    @Autowired
    private CommunityAroundPoiService communityAroundPoiService;
    @Autowired
    private CommunityAroundService communityAroundService;
    @Autowired
    private CommunityAroundPoiRelService communityAroundPoiRelService;
    /**
     * 按照更新计划刷新社区周边商户信息
     */
    @Autowired
    private ExtCommunityAroundPoiDataMapper extCommunityAroundPoiDataMapper;
    @Autowired
    private ExtCommunityAroundUpdatePlanMapper extCommunityAroundUpdatePlanMapper;
    @Autowired
    private FastDFSGlobalService fastDFSGlobalService;
    @Autowired
    private UserCommentService userCommentService;

    @Value("${gaode.api.url.place_around}")
    private String placeAroundUrl;
    @Value("${gaode.api.url.place_detail}")
    private String placeDetailUrl;
    @Value("${baidu.api.url.poi_query}")
    private String baiduPoiQueryUrl;
    @Value("${baidu.api.url.poi_detail}")
    private String baiduPoiDetailUrl;
    @Value("${gaode.api.url.coordinate_convert}")
    private String gaodeCoordinateConvertUrl;
    @Value("${baidu.api.url.coordinate_convert}")
    private String baiduCoordinateConvertUrl;
    @Value("${baidu.api.url.poi_comment}")
    private String baiduPoiComment;


    private ExecutorService executorService = new ThreadPoolExecutor(2, 4, 0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>());

    private static Map<String, String> cityCodeMap = new HashMap<>();

    /**
     * 比对新增的社区，或d者是修改了经纬度的社区，将其添加到执行计划中
     */
    @Transactional
    public void syncCommunityInfo() {
        communityAroundService.addNewCommunityAround();
        communityAroundService.updateCommunityAroundLocation();
        //全量删除旧的执行计划
        extCommunityAroundUpdatePlanMapper.delOldPlan();
        //全量添加执行计划
        extCommunityAroundUpdatePlanMapper.addUpdatePlan();
        //标记社区与商户的关系表为旧状态
        communityAroundService.markCommunityAroundPoiRel();
        CommunityAround ca = new CommunityAround();
        ca.setStatus(1L);
        CommunityAroundExample example = new CommunityAroundExample();
        example.createCriteria().andStatusEqualTo(-1L);
        communityAroundService.updateByExampleSelective(ca, example);
    }

    /**
     * @return void
     * @Author wlrllr
     * @Description //通过api拉取社区周边商家数据
     * @Date 2019/5/8
     * @Param []
     **/
    public void executeUpdatePlan() {
        logger.info("通过api拉取社区周边商家数据,每次解析100条...");
        List<CommunityAroundUpdatePlan> list = communityAroundPoiService.getUnCompleteUpdatePlan(new PageBounds(0, 100));
        if (list != null && list.size() > 0) {
            for (CommunityAroundUpdatePlan plan : list) {
                CommunityAroundUpdatePlan p = new CommunityAroundUpdatePlan();
                p.setCommunityId(plan.getCommunityId());
                p.setTypeId(plan.getTypeId());
                p.setStatus(0);
                extCommunityAroundUpdatePlanMapper.updateByPrimaryKeySelective(p);
                executorService.execute(() -> {
                    CommunityAround ca = communityAroundService.selectByPrimaryKey(plan.getCommunityId());
                    String[] locations = coordinateBaidu2Gaode(ca.getLongitude() + "," + ca.getLatitude());
                    boolean flag = true;
                    if (locations != null && locations.length > 0) {
                        String url = String.format(placeAroundUrl, locations[0], plan.getTypeCode());
                        flag = fetchData(url, plan, 1, ca);
                    }
                    if (flag) {
                        p.setStatus(1);
                        extCommunityAroundUpdatePlanMapper.updateByPrimaryKeySelective(p);
                    }
                });
            }
        }
    }

    /**
     * @return void
     * @Author wlrllr
     * @Description //解析高德商家信息
     * @Date 2019/5/8
     * @Param []
     **/
    public void parsePoiData() {
        logger.info("开始解析高德商家信息,每次解析100条...");
        List<CommunityAroundPoiData> list = extCommunityAroundPoiDataMapper.page(0, 70);
        if (list != null && list.size() > 0) {
            for (CommunityAroundPoiData communityAroundPoiData : list) {
                updatePoiDataStatus(communityAroundPoiData.getId(),0);
                CommunityAround ca = communityAroundService.selectByPrimaryKey(communityAroundPoiData.getCommunityId());
                CommunityAroundUpdatePlanKey key = new CommunityAroundUpdatePlanKey();
                key.setCommunityId(communityAroundPoiData.getCommunityId());
                key.setTypeId(communityAroundPoiData.getTypeId());
                CommunityAroundUpdatePlan plan = extCommunityAroundUpdatePlanMapper.selectByPrimaryKey(key);
                String data = communityAroundPoiData.getData();
                executorService.execute(() -> {
                    buildPoi(JSONObject.parseObject(data), plan, ca);
                    updatePoiDataStatus(communityAroundPoiData.getId(),1);
                });
            }
        }
    }

    /**
     * @return void
     * @Author wlrllr
     * @Description //通过百度api获取数据
     * @Date 2019/5/8
     * @Param [poi]
     **/
    public void syncPoiExtInfoTask() {
        logger.info("开始通过百度api获取数据,每次解析100条...");
        List<ExtCommunityAroundPoi> list = communityAroundPoiService.getUnSyncPoiExtCommunity();
        if (list != null && list.size() > 0) {
            for (ExtCommunityAroundPoi poi : list) {
                updatePoiExtStatus(poi.getId(), 0);
                executorService.execute(() -> {
                    try {
                        CommunityAroundPoiExt ext = poi.getExt();
                        if (ext != null && StringUtils.isNotBlank(ext.getBaiduUid())) {
                            syncBaiduDetail(ext.getBaiduUid(), poi.getId());
                        } else {
                            String url = String.format(baiduPoiQueryUrl, URLEncoder.encode(poi.getName(), "utf-8"), poi.getLatitude() + "," + poi.getLongitude());
                            syncPoiExtInfo(url, poi.getId());
                        }
                    } catch (UnsupportedEncodingException e) {
                        logger.error("拉取百度api时，encode异常", e);
                        updatePoiExtStatus(poi.getId(), -1);
                    }
                });
            }
        }
    }

    public void uploadPoiPic() {
        List<CommunityPic> list = communityAroundPoiService.getPic(POI_PIC_STATUS_2, 20);
        if (list != null) {
            for (CommunityPic pic : list) {
                String url = pic.getPicUrl();
                try {
                    String newUrl = fastDFSGlobalService.upload(new URL(url));
                    if (StringUtils.isNotBlank(newUrl)) {
                        CommunityPic newPic = new CommunityPic();
                        newPic.setStatus(POI_PIC_STATUS_1);
                        newPic.setId(pic.getId());
                        newPic.setPicUrl(newUrl);
                        communityAroundPoiService.updatePicByPrimarykey(newPic);
                    }
                } catch (Exception e) {
                    logger.error("删除图片失败", e);
                }
            }
        }
    }

    public void convertLocation() {
        List<ExtCommunityAroundPoi> list = communityAroundPoiService.getUnSyncPoi();
        if (list != null) {
            for (ExtCommunityAroundPoi poi : list) {
                CommunityAroundPoi p = new CommunityAroundPoi();
                p.setId(poi.getId());
                p.setSyncStatus(0);
                communityAroundPoiService.updateByPrimaryKeySelective(poi);
                executorService.execute(() -> {
                    List<Pair<String, String>> pairs = coordinateGaode2Baidu(poi.getLongitude() + "," + poi.getLatitude());
                    if (pairs != null) {
                        p.setLongitude(pairs.get(0).getLeft());
                        p.setLatitude(pairs.get(0).getRight());
                        p.setSyncStatus(1);
                        communityAroundPoiService.updateByPrimaryKeySelective(p);
                    }
                });
            }
        }
    }

    public void syncPoiComment() {
        logger.info("开始通过百度api拉取商户评论,每次解析100条...");
        PageList<CommunityAroundPoiExt> list = communityAroundPoiService.pagePoiExt(100);
        if (list != null && list.size() > 0) {
            for (CommunityAroundPoiExt ext : list) {
                updatePoiExtStatus(ext.getPoiId(), 0);
                executorService.execute(() -> {
                    Long commentNum = userCommentService.countByTargetId(ext.getPoiId(),SysConstant.COMMENT_TARGET_TYPE_POI);
                    if(commentNum == null || commentNum<=0){
                        List<UserComment> userCommentList = new ArrayList<>();
                        String url = String.format(baiduPoiComment, 100, ext.getBaiduUid());
                        String response = HttpUtil.get(url);
                        JSONObject resp = JSON.parseObject(response);
                        if (resp.getInteger("errorNo") == 0) {
                            JSONObject comments = resp.getJSONObject("comment");
                            if (comments != null) {
                                JSONArray commentList = comments.getJSONArray("comment_list");
                                if (commentList != null && commentList.size() > 0) {
                                    for (int i = 0; i < commentList.size(); i++) {
                                        JSONObject commentObject = commentList.getJSONObject(i);
                                        UserComment userComment = new UserComment();
                                        userCommentList.add(userComment);
                                        userComment.setStatus(SysConstant.COMMON_STATUS_NORMAL);
                                        userComment.setCommentTarget(ext.getPoiId());
                                        userComment.setServiceGrade(0);
                                        userComment.setCommentTargetType(SysConstant.COMMENT_TARGET_TYPE_POI);
                                        userComment.setUserName(commentObject.getString("user_name"));
                                        Date d = parse(commentObject.getString("date"));
                                        userComment.setCreateTime(d);
                                        userComment.setComment(commentObject.getString("content"));
                                    }
                                }
                            }
                        }
                        if (userCommentList.size() > 0) {
                            userCommentService.batchAdd(userCommentList);
                        }
                    }
                    updatePoiExtStatus(ext.getPoiId(), 5);
                });
            }
        }
    }

    public void refreshDistance(){
        PageList<ExtCommunityAroundPoiRel> list = communityAroundPoiRelService.pageOldRel(new PageBounds(0,100));
        if (list != null && list.size() > 0) {
            for (ExtCommunityAroundPoiRel rel : list) {
                CommunityAroundPoiRel temp = new CommunityAroundPoiRel();
                temp.setStatus(1); //标志处理中
                temp.setCommunityId(rel.getCommunityId());
                temp.setPoiId(rel.getPoiId());
                communityAroundPoiRelService.updateByPrimaryKeySelective(temp);
                executorService.execute(() -> {
                    Double distance = HarvenSinUtils.distance(rel.getLatitude(),rel.getLongitude(),rel.getPoiLatitude(),rel.getPoiLongitude());
                    temp.setDistance(distance);
                    temp.setStatus(0);
                    communityAroundPoiRelService.updateByPrimaryKeySelective(temp);
                });
            }
        }
    }

    private boolean fetchData(String url, CommunityAroundUpdatePlan plan, Integer page, CommunityAround ca) {
        String response = HttpUtil.get(url + "&page=" + page);
        JSONObject obj = JSONObject.parseObject(response);
        if ("1".equals(obj.getString("status"))) {
            fetchData(obj, plan, ca);
            if (obj.getInteger("count") > 0) {
                fetchData(url, plan, ++page, ca);
            }
            return true;
        }
        return false;
    }

    private void fetchData(JSONObject obj, CommunityAroundUpdatePlan plan, CommunityAround ca) {
        JSONArray pois = obj.getJSONArray("pois");
        if (pois != null && pois.size() > 0) {
            List<CommunityAroundPoiData> list = new ArrayList<>();
            for (int i = 0; i < pois.size(); i++) {
                JSONObject poi = pois.getJSONObject(i);
                String apiId = poi.getString("id");
                CommunityAroundPoiData poiData = extCommunityAroundPoiDataMapper.selectByPrimaryKey(apiId);
                if (poiData == null) {
                    poiData = new CommunityAroundPoiData();
                    poiData.setId(apiId);
                    poiData.setCommunityId(plan.getCommunityId());
                    poiData.setTypeId(plan.getTypeId());
                    poiData.setData(poi.toJSONString());
                    poiData.setStatus(-1);
                    list.add(poiData);
                } else if (poiData.getStatus() != -1) {
                    CommunityAroundPoiData tempData = new CommunityAroundPoiData();
                    tempData.setId(poiData.getId());
                    tempData.setStatus(-1);
                    extCommunityAroundPoiDataMapper.updateByPrimaryKeySelective(tempData);
                }
            }
            if (list.size() > 0) {
                extCommunityAroundPoiDataMapper.batchInsert(list);
            }
        }
    }

    private void syncPoiExtInfo(String url, Long poiId) {
        try {
            String response = HttpUtil.get(url);
            JSONObject obj = JSONObject.parseObject(response);
            if ("0".equals(obj.getString("status"))) {
                JSONArray result = obj.getJSONArray("results");
                if (result != null && result.size() > 0) {
                    String uid = result.getJSONObject(0).getString("uid");
                    if (StringUtils.isNotBlank(uid)) {
                        syncBaiduDetail(uid, poiId);
                        return;
                    }
                }
                updatePoiExtStatus(poiId, 2);
            } else {
                updatePoiExtStatus(poiId, -1);
            }
        } catch (Exception e) {
            logger.error("请求百度api异常，下次处理...", e);
            updatePoiExtStatus(poiId, -1);
        }
    }

    private void updatePoiExtStatus(Long poiId, Integer status) {
        CommunityAroundPoiExt ext = new CommunityAroundPoiExt();
        ext.setPoiId(poiId);
        ext.setSyncStatus(status);
        communityAroundPoiService.updatePoiExtInfo(ext);
    }

    private void updatePoiDataStatus(String apiId, Integer status) {
        CommunityAroundPoiData d = new CommunityAroundPoiData();
        d.setId(apiId);
        d.setStatus(status);
        extCommunityAroundPoiDataMapper.updateByPrimaryKeySelective(d);
    }

    private void syncBaiduDetail(String baiduUid, Long poiId) {
        CommunityAroundPoiExt ext = new CommunityAroundPoiExt();
        ext.setPoiId(poiId);
        ext.setBaiduUid(baiduUid);
        //通过uid查询店铺详情
        String detailResponse = HttpUtil.get(String.format(baiduPoiDetailUrl, baiduUid));
        JSONObject detailObject = JSONObject.parseObject(detailResponse);
        if ("0".equals(detailObject.getString("status"))) {
            JSONObject detailObj = detailObject.getJSONObject("result");
            if (detailObj != null) {
                JSONObject detailInfo = getJSONObject(detailObj, "detail_info");
                if (detailInfo != null) {
                    String shopHours = detailInfo.getString("shop_hours");
                    if (StringUtils.isNotBlank(shopHours)) {
                        ext.setShopHours(shopHours);
                    }
                    JSONArray featuredService = detailInfo.getJSONArray("featured_service");
                    if (featuredService != null && featuredService.size() > 0) {
                        ext.setFeaturedService(JSONObject.toJSONString(featuredService));
                    }
                    String commentNum = detailInfo.getString("comment_num");
                    if (commentNum != null && Long.valueOf(commentNum) > 0) {
                        ext.setBaiduDetailUrl(detailInfo.getString("detail_url"));
                        ext.setSyncStatus(1);
                    } else {
                        ext.setSyncStatus(3);
                    }
                } else {
                    //找不到该详情
                    ext.setSyncStatus(4);
                }
            } else {
                //找不到该详情
                ext.setSyncStatus(4);
            }
        } else {
            ext.setSyncStatus(-2);
        }
        communityAroundPoiService.updatePoiExtInfo(ext);
    }

    public CommunityAroundPoi buildPoi(JSONObject obj, CommunityAroundUpdatePlan plan, CommunityAround ca) {
        String poiType = plan.getTypeCode();
        if (obj != null) {
            //保存商户
            CommunityAroundPoi poi = savePoi(obj, plan);
            Long poiId = poi.getId();
            //保存商家到社区关联关系
            communityAroundPoiRelService.saveCommunityRel(poi, ca);
            //构建分类信息
            communityAroundPoiService.savePoiTypeRel(poiId, poiType);
            //构建标签信息
            buildPoiTag(getString(obj, "tag"), poiId);
            //构建扩展信息
            buildPoiExtInfo(obj, poiId);
            //保存图片
            buildPoiPic(obj.getJSONArray("photos"), poiId);
            //通过百度拉取商户额外信息
            //syncPoiExtInfo(poi);
            return poi;
        }
        return null;
    }

    private CommunityAroundPoi savePoi(JSONObject obj, CommunityAroundUpdatePlan plan) {
        CommunityAroundPoi poi = updatePoi(obj, plan);
        if (poi != null) {
            return poi;
        }
        poi = new CommunityAroundPoi();
        poi.setApiId(obj.getString("id"));
        poi.setName(obj.getString("name"));
        poi.setApiType(delRepeat(getString(obj, "type"),";"));
        poi.setType(plan.getParentTypeCode());
        poi.setAddress(obj.getString("address"));
        //转换成百度经纬度
        buildLocation(poi, obj.getString("location"));
        String tel = getString(obj, "tel");
        if (StringUtils.isNotBlank(tel)) {
            poi.setTel(tel.split(";")[0]);
        }
        poi.setProvinceName(getString(obj, "pname"));
        poi.setProvinceCode(getString(obj, "pcode"));
        poi.setCityName(getString(obj, "cityname"));
        poi.setCityCode(getCityCode(getString(obj, "citycode")));
        poi.setAdName(getString(obj, "adname"));
        poi.setAdCode(getString(obj, "adcode"));
        poi.setPostCode(getString(obj, "postcode"));
        poi.setWebSite(getString(obj, "website"));
        poi.setEmail(getString(obj, "email"));
        JSONArray photos = obj.getJSONArray("photos");
        if (photos != null && photos.size() > 0) {
            poi.setPicUrl(photos.getJSONObject(0).getString("url"));
        }
        List<Pair<String, String>> pairs = coordinateGaode2Baidu(poi.getLongitude() + "," + poi.getLatitude());
        if (pairs != null) {
            poi.setLongitude(pairs.get(0).getLeft());
            poi.setLatitude(pairs.get(0).getRight());
            poi.setSyncStatus(1);
        } else {
            poi.setSyncStatus(-1);
        }
        communityAroundPoiService.insertSelective(poi);
        return poi;
    }

    private CommunityAroundPoi updatePoi(JSONObject obj, CommunityAroundUpdatePlan plan) {
        CommunityAroundPoi poi = communityAroundPoiService.getByApiId(obj.getString("id"));
        if (poi != null) {
            CommunityAroundPoi p = new CommunityAroundPoi();
            if (StringUtils.isBlank(poi.getApiType())) {
                p.setId(poi.getId());
                p.setApiType(getString(obj, "type"));
                poi.setApiType(p.getApiType());
            }
            if (StringUtils.isBlank(poi.getType())) {
                p.setId(poi.getId());
                p.setType(plan.getParentTypeCode());
                poi.setType(p.getType());
            }
            if (poi.getSyncStatus() != 1) {
                List<Pair<String, String>> pairs = coordinateGaode2Baidu(poi.getLongitude() + "," + poi.getLatitude());
                if (pairs != null) {
                    p.setId(poi.getId());
                    p.setLongitude(pairs.get(0).getLeft());
                    p.setLatitude(pairs.get(0).getRight());
                    p.setSyncStatus(1);
                    poi.setLongitude(p.getLongitude());
                    poi.setLatitude(p.getLatitude());
                }
            }
            if (p.getId() != null) {
                communityAroundPoiService.updateByPrimaryKeySelective(p);
            }
            return poi;
        }
        return null;
    }

    private void buildLocation(CommunityAroundPoi poi, String location) {
        if (StringUtils.isNotBlank(location)) {
            List<Pair<String, String>> locations = coordinateGaode2Baidu(location);
            if (locations != null && locations.size() > 0) {
                poi.setLongitude(locations.get(0).getLeft());
                poi.setLatitude(locations.get(0).getRight());
            }
        }
    }

    private void buildPoiPic(JSONArray picUrl, Long poiId) {
        if (picUrl != null && picUrl.size() > 0) {
            List<CommunityPic> list = new ArrayList<>();
            for (int i = 0; i < picUrl.size(); i++) {
                CommunityPic pic = new CommunityPic();
                pic.setTargetId(poiId);
                pic.setPicUrl(picUrl.getJSONObject(i).getString("url"));
                pic.setStatus(POI_PIC_STATUS_2);
                list.add(pic);
            }
            communityAroundPoiService.batchAddPoiPic(list);
        }
    }

    private CommunityAroundPoiExt buildPoiExtInfo(JSONObject obj, Long poiId) {
        JSONObject poiExt = obj.getJSONObject("biz_ext");
        CommunityAroundPoiExt ext = new CommunityAroundPoiExt();
        ext.setPoiId(poiId);
        Double cost = getDouble(poiExt, "cost");
        Double rating = getDouble(poiExt, "rating");
        ext.setCost(cost == null ? 0 : cost);
        ext.setRating(rating == null ? 0 : rating);
        return communityAroundPoiService.addPoiExtInfo(ext);
    }

    private CommunityAroundPoi buildPoiTag(String tagNameStr, Long poiId) {
        if (StringUtils.isNotBlank(tagNameStr)) {
            String[] tagNames = tagNameStr.split(",");
            for (String tagName : tagNames) {
                CommunityAroundPoiTag tag = communityAroundPoiService.getTagByName(tagName);
                if (tag == null) {
                    tag = communityAroundPoiService.saveTag(tagName);
                }
                communityAroundPoiService.saveTagRel(tag.getId(), poiId);
            }
        }
        return null;
    }


    private Double getDouble(JSONObject source, String key) {
        String value = source.getString(key);
        if (value == null || "[]".equals(value)) {
            return null;
        }
        return Double.parseDouble(value);
    }

    private String getString(JSONObject source, String key) {
        String value = source.getString(key);
        if (value != null && value.contains("[]")) {
            return value.replace("[]", "");
        }
        return value;
    }

    private List<String> getList(JSONObject source, String key, String split) {
        String value = getString(source, key);
        if (StringUtils.isNotBlank(value)) {
            return Arrays.asList(value.split(split));
        }
        return null;
    }

    private String delRepeat(String source, String split) {
        if(StringUtils.isNotBlank(source)){
            String[] strs = source.split(split);
            StringBuilder sb = new StringBuilder();
            for(String s : strs){
                if(sb.lastIndexOf(s)<0){
                    sb.append(s).append(split);
                }
            }
            if(sb.length()>0){
                sb.delete(sb.length()-split.length(),sb.length());
            }
            return sb.toString();
        }
        return source;
    }

    private String[] coordinateBaidu2Gaode(String oldlocations) {
        String url = String.format(gaodeCoordinateConvertUrl, oldlocations, "baidu");
        String response = HttpUtil.get(url);
        JSONObject obj = JSONObject.parseObject(response);
        if ("1".equals(obj.getString("status"))) {
            String locations = obj.getString("locations");
            return locations.split("\\|");
        }
        return null;
    }

    private List<Pair<String, String>> coordinateGaode2Baidu(String oldlocations) {
        String url = String.format(baiduCoordinateConvertUrl, oldlocations);
        String response = HttpUtil.get(url);
        JSONObject obj = JSONObject.parseObject(response);
        List<Pair<String, String>> list = new ArrayList<>();
        if ("0".equals(obj.getString("status"))) {
            JSONArray result = obj.getJSONArray("result");
            for (int i = 0; i < result.size(); i++) {
                JSONObject location = result.getJSONObject(i);
                if (location != null) {
                    list.add(Pair.of(location.getString("x"), location.getString("y")));
                }
            }
        }
        return list;
    }


    private JSONObject getJSONObject(JSONObject jsonObject, String key) {
        Object obj = jsonObject.get(key);
        JSONObject detailInfo = null;
        if (obj instanceof JSONObject) {
            detailInfo = (JSONObject) obj;
        } else if (obj instanceof JSONArray) {
            if (((JSONArray) obj).size() > 0) {
                detailInfo = ((JSONArray) obj).getJSONObject(0);
            }
        } else if (obj instanceof String) {
            detailInfo = JSON.parseObject((String) obj);
        } else {
            detailInfo = (JSONObject) JSONObject.toJSON(obj);
        }
        return detailInfo;
    }


    private Map<String, String> getCityCodeMap() {
        if (cityCodeMap == null || cityCodeMap.isEmpty()) {
            AreaExample example = new AreaExample();
            example.createCriteria().andLevelTypeEqualTo(2);
            List<Area> list = areaMapper.selectByExample(example);
            for (Area a : list) {
                cityCodeMap.put(a.getCityCode(), a.getId().toString());
            }
        }
        return cityCodeMap;
    }

    private String getCityCode(String key) {
        String code = getCityCodeMap().get(key);
        if (StringUtils.isNotBlank(code)) {
            return code;
        }
        return key;
    }


    public static Date parse(String datetime) {
        if (StringUtils.isNotBlank(datetime)) {
            Date d = DateUtil.parse(datetime, "yyyy-MM-dd HH:mm:ss");
            if (d == null) {
                d = DateUtil.parse(datetime, "yyyy-MM-dd HH:mm");
            }
            if (d == null) {
                d = DateUtil.parse(datetime, "yyyy-MM-dd HH");
            }
            if (d == null) {
                d = DateUtil.parse(datetime, "yyyy-MM-dd");
            }
            if (d == null) {
                d = DateUtil.parse(datetime, "yyyy-MM");
            }
            return d;
        }
        return null;
    }
}
