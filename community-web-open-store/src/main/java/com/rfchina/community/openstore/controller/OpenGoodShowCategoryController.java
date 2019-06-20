package com.rfchina.community.openstore.controller;

import com.rfchina.community.base.Constant;
import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.Result;
import com.rfchina.community.openstore.service.OpenGoodShowCategoryService;
import com.rfchina.community.openstore.service.OpenStoreGoodService;
import com.rfchina.community.persistence.model.OpenGoodShowCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:fukangwen
 * @Description: 商品展示分类controller
 */
@RestController
@RequestMapping(value = Constant.ROOT_PATH_OPENSTORE )
public class OpenGoodShowCategoryController extends BaseController {

    @Autowired
    public OpenGoodShowCategoryService openGoodShowCategoryService;
    @Autowired
    public OpenStoreGoodService openStoreGoodService;

    /**
     * 分类列表
     */
    @RequestMapping("/categoryList")
    public Result<?> categoryList(
            @RequestParam(value = "serviceId", required = true) int serviceId
    ){
        List<OpenGoodShowCategory> list = openGoodShowCategoryService.categoryList(serviceId, null);
        return Result.successData(list);
    }

    /**
     * 主页数据
     * @param serviceId
     * @return
     */
    @RequestMapping(value = { "/getServiceHomePage" })
    public Result<?> getServiceHomePage(@RequestParam(value = "serviceId", required = true) int serviceId) {
        logger.info("method ： getServiceHomePage; serviceId={}", serviceId);
        validator(serviceId < 0, "参数有误");
        Map<String, Object> map = new HashMap<String, Object>();
        //推荐商品
        map.put("recommendGoodList", openGoodShowCategoryService.getRecommendGoodList(serviceId));
        map.put("categoryDataList", openGoodShowCategoryService.categoryDataList(serviceId));
        map.put("openStoreGoodList", openStoreGoodService.pageQuery(serviceId, null, OpenConstant.OpenStoreGoodSortType.GENERAL.getCode(),
                OpenConstant.OpenStoreGoodSort.down, null, 1, 10).getList());
        return Result.successData(map);
    }
}
