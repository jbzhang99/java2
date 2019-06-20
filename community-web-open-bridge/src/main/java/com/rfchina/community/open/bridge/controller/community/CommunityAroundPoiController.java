package com.rfchina.community.open.bridge.controller.community;

import com.google.common.collect.Maps;
import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.Result;
import com.rfchina.community.open.bridge.controller.BaseController;
import com.rfchina.community.open.bridge.entity.BridgeCommunityAroundPoi;
import com.rfchina.community.open.bridge.service.CommunityAroundManageBridgeService;
import com.rfchina.platform.common.utils.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.mybatis.paginator.model.PageBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping(value = OpenConstant.ROOT_PATH_COMMUNITY )
public class CommunityAroundPoiController extends BaseController {

    @Autowired
    private CommunityAroundManageBridgeService communityAroundManageBridgeService;

    private ExecutorService executorService = new ThreadPoolExecutor(1, 3,0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>());
    /**
     * 分页查询社区周边商户
     *
     * @param firstType
     * @param secondType
     * @param name
     * @param cityCode
     * @param communityId
     * @param poiStatus
     * @param index
     * @param size
     * @return
     */
    @PostMapping("/pageCommunityAroundPoiList")
    public Result pageCommunityAroundPoiList(@RequestParam(required = false) String firstType,
                                             @RequestParam(required = false) String secondType,
                                             @RequestParam(required = false) String name,
                                             @RequestParam(required = false) String cityCode,
                                             @RequestParam(required = false) Long communityId,
                                             @RequestParam(required = false) Integer poiStatus,
                                             @RequestParam(required = false, defaultValue = "0") Integer index,
                                             @RequestParam(required = false, defaultValue = "10") Integer size) {
        return Result.successData(communityAroundManageBridgeService.pagePoi(buildParam(firstType, secondType, name, cityCode, communityId, poiStatus), new PageBounds(index, size)));
    }

    /**
     * 导出社区周边商户
     *
     * @param firstType
     * @param secondType
     * @param name
     * @param cityCode
     * @param communityId
     * @param poiStatus
     */
    @PostMapping("/exportCommunityAroundPoiList")
    public void exportCommunityAroundPoiList(@RequestParam(required = false) String firstType,
                                             @RequestParam(required = false) String secondType,
                                             @RequestParam(required = false) String name,
                                             @RequestParam(required = false) String cityCode,
                                             @RequestParam(required = false) Long communityId,
                                             @RequestParam(required = false) Integer poiStatus) {
        export(communityAroundManageBridgeService.exportPoi(buildParam(firstType, secondType, name, cityCode, communityId, poiStatus)),new StringBuilder("社区周边商家_"));
    }

    /**
     * 添加社区商户
     *
     * @param poi
     * @return
     */
    @PostMapping("/addCommunityAroundPoi")
    public Result addCommunityAroundPoi(@ModelAttribute BridgeCommunityAroundPoi poi) {
        validateParam(poi);
        executorService.execute(()->{
            poi.setAddFlag(true);
            communityAroundManageBridgeService.addPoi(poi);
        });
        return Result.success();
    }

    /**
     * 修改社区商户
     * @param poi
     * @return
     */
    @PostMapping("/editCommunityAroundPoi")
    public Result editCommunityAroundPoi(@ModelAttribute BridgeCommunityAroundPoi poi) {
        validateParam(poi);
        executorService.execute(()->{
            poi.setAddFlag(false);
            communityAroundManageBridgeService.addPoi(poi);
        });
        return Result.success();
    }

    @PostMapping("/{status}CommunityAroundPoi")
    public Result disableCommunityAroundPoi(@PathVariable String status, Long poiId) {
        if(status.equals("disable")){
            communityAroundManageBridgeService.editPoiStatus(poiId, -1);
        }else if(status.equals("enable")){
            communityAroundManageBridgeService.editPoiStatus(poiId, 1);
        }
        return Result.success();
    }

    /**
     * 查看商户详情
     * @param poiId
     * @return
     */
    @RequestMapping("/getPoiDetail")
    public Result getPoiDetail(Long poiId) {
        return Result.successData(communityAroundManageBridgeService.getPoiDetail(poiId));
    }

    /**
     * 获取社区商户图片
     *
     * @param poiId
     * @return
     */
    @PostMapping("/getCommunityAroundPoiPic")
    public Result getCommunityAroundPoiPic(Long poiId) {
        return Result.successData(communityAroundManageBridgeService.getPoiPic(poiId));
    }

    /**
     * 获取商户到社区距离
     *
     * @param poiId
     * @return
     */
    @RequestMapping("/getCommunityDistance")
    public Result getCommunityDistance(Long poiId,
                                       @RequestParam(required = false, defaultValue = "0") Integer index,
                                       @RequestParam(required = false, defaultValue = "10") Integer size) {
        return Result.successData(communityAroundManageBridgeService.getCommunityDistance(poiId,index,size));
    }

    /**
     * 获取商户评论
     *
     * @param poiId
     * @return
     */
    @PostMapping("/getPoiComment")
    public Result getPoiComment(Long poiId,
                                @RequestParam(required = false, defaultValue = "0") Integer index,
                                @RequestParam(required = false, defaultValue = "10") Integer size) {
        return Result.successData(communityAroundManageBridgeService.getPoiComment(poiId, index, size));
    }

    @RequestMapping("/delPoiComment")
    public Result delPoiComment(Long commentId) {
        communityAroundManageBridgeService.delPoiComment(commentId);
        return Result.success();
    }


    /**
     * 周边社区列表
     *
     * @param city
     * @param communityId
     * @param index
     * @param size
     * @return
     */
    @PostMapping("/pageCommunityAround")
    public Result pageCommunityAround(@RequestParam(required = false) String city,
                                      @RequestParam(required = false) String communityId,
                                      @RequestParam(required = false, defaultValue = "0") Integer index,
                                      @RequestParam(required = false, defaultValue = "10") Integer size) {
        Map<String, Object> param = Maps.newHashMap();
        if (StringUtils.isNotBlank(city)) {
            param.put("city", city);
        }
        if (StringUtils.isNotBlank(communityId)) {
            if(communityId.contains(",")){
                param.put("communityIds", communityId);
            }else{
                param.put("communityId", communityId);
            }
        }
        return Result.successData(communityAroundManageBridgeService.pageCommunityAround(param, index, size));
    }

    /**
     * 社区周边类目分页
     *
     * @param firstType
     * @param secondType
     * @param status
     * @param index
     * @param size
     * @return
     */
    @PostMapping("/pageCommunityAroundPoiType")
    public Result pageCommunityAroundPoiType(@RequestParam(required = false) String firstType,
                                             @RequestParam(required = false) String secondType,
                                             @RequestParam(required = false) Integer status,
                                             @RequestParam(required = false, defaultValue = "0") Integer index,
                                             @RequestParam(required = false, defaultValue = "10") Integer size) {
        Map<String, Object> param = buildParamPoiTypeCondition(firstType,secondType,status);
        return Result.successData(communityAroundManageBridgeService.pageCommunityAroundPoiType(param, index, size));
    }

    @PostMapping("/exportCommunityAroundPoiType")
    public void exportCommunityAroundPoiType(@RequestParam(required = false) String firstType,
                                             @RequestParam(required = false) String secondType,
                                             @RequestParam(required = false) Integer status) {
        Map<String, Object> param = buildParamPoiTypeCondition(firstType,secondType,status);
        export(communityAroundManageBridgeService.exportCommunityAroundPoiType(param),new StringBuilder("社区周边类目_"));
    }

    @PostMapping("/addCommunityAroundPoiType")
    public Result addCommunityAroundPoiType( String parentType,
                                            String secondTypeName,
                                            Integer sort) {
        communityAroundManageBridgeService.addPoiTyp(parentType, secondTypeName, sort);
        return Result.success();
    }

    @PostMapping("/editCommunityAroundPoiType")
    public Result editCommunityAroundPoiType(@RequestParam(required = false,defaultValue = "")String parentType,
                                             @RequestParam(required = false)String name,
                                             @RequestParam String type,
                                             @RequestParam(required = false) String picUrl,
                                             @RequestParam(required = false) String poiPicUrl,
                                             @RequestParam(required = false) String apiId,
                                             @RequestParam(required = false)Integer sort) {
        communityAroundManageBridgeService.editPoiType(parentType, name,type,picUrl,poiPicUrl,apiId, sort);
        return Result.success();
    }

    /**
     * @Author wlrllr
     * @Description //启用禁用类型
     * @Date 2019/5/5
     * @Param [type]
     * @return com.rfchina.community.base.Result
     **/
    @PostMapping("/{status}CommunityAroundPoiType")
    public Result disableCommunityAroundPoiType(@PathVariable String status, String type) {
        if(status.equals("disable")){
            communityAroundManageBridgeService.editPoiType(type, -1);
        }else if(status.equals("enable")){
            communityAroundManageBridgeService.editPoiType(type, 1);
        }
        return Result.success();
    }

    @RequestMapping("/getFirstPoiType")
    public Result getFirstPoiType() {
        return Result.successData(communityAroundManageBridgeService.getFirstPoiType());
    }

    @RequestMapping("/getPoiTypeByParentType")
    public Result getPoiTypeByParentType(String parentType) {
        return Result.successData(communityAroundManageBridgeService.getPoiTypeByParentType(parentType));
    }

    /**
     * 新增商户，参数校验
     *
     * @param poi
     */
    private void validateParam(BridgeCommunityAroundPoi poi) {
        validator(poi == null,"参数异常");
        validator(StringUtils.isBlank(poi.getName()),"商家名称不能为空");
        validator(StringUtils.isBlank(poi.getType()),"商家分类不能为空");
        validator(StringUtils.isBlank(poi.getLongitude()),"商家经度不能为空");
        validator(StringUtils.isBlank(poi.getLatitude()),"商家纬度不能为空");
        validator(StringUtils.isAnyBlank(poi.getProvinceCode(),poi.getProvinceName()),"省份不能为空");
        validator(StringUtils.isAnyBlank(poi.getCityCode(),poi.getCityName()),"城市不能为空");
        validator(StringUtils.isAnyBlank(poi.getAdCode(),poi.getAdName()),"区镇不能为空");
        validator(StringUtils.isBlank(poi.getAddress()),"详细地址不能为空");
    }

    private Map<String, Object> buildParam(String firstType, String secondType, String name, String cityCode, Long communityId, Integer posStatus) {
        Map<String, Object> param = new HashMap<>();
        if (StringUtils.isNotBlank(firstType)) {
            param.put("firstType", firstType);
        }
        if (StringUtils.isNotBlank(secondType)) {
            param.put("secondType", secondType);
        }
        if (StringUtils.isNotBlank(name)) {
            param.put("name", name);
        }
        if (StringUtils.isNotBlank(cityCode)) {
            param.put("cityCode", cityCode);
        }
        if (communityId != null) {
            param.put("communityId", communityId);
        }
        if (posStatus != null) {
            param.put("posStatus", posStatus);
        }
        return param;
    }

    private Map<String, Object> buildParamPoiTypeCondition(String firstType, String secondType, Integer status) {
        Map<String, Object> param = Maps.newHashMap();
        if (StringUtils.isNotBlank(firstType)) {
            param.put("firstType", firstType);
        }
        if (StringUtils.isNotBlank(secondType)) {
            param.put("secondType", secondType);
        }
        if (status != null) {
            param.put("status", status);
        }
        return param;
    }

    private void export(SXSSFWorkbook wb, StringBuilder fileName){
        try (OutputStream outputStream = response.getOutputStream()) {
            fileName.append(DateUtil.formatDate(new Date(), "yyyyMMdd")).append(".xlsx");
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName.toString(), "UTF-8"));
            wb.write(outputStream);
            outputStream.flush();
        } catch (IOException e) {
            error("下载文件失败");
        }finally {
            if(wb != null){
                try {
                    wb.dispose();
                    wb.close();
                } catch (IOException e) {
                    logger.error("导出文件时，关闭资源异常",e);
                }
            }
        }
    }
}
