package com.rfchina.community.openweb.controller;

import com.rfchina.community.base.Constant;
import com.rfchina.community.base.Result;
import com.rfchina.community.base.util.ValidatorUtil;
import com.rfchina.community.openweb.service.OpenGoodShowCategoryService;
import com.rfchina.community.persistence.model.OpenGoodShowCategory;
import org.mybatis.paginator.model.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author:fukangwen
 * @Description: 商品展示分类controller
 */
@RestController
@RequestMapping(value = Constant.ROOT_PATH_OPENWEB)
public class OpenGoodShowCategoryController extends BaseController {

    @Autowired
    private OpenGoodShowCategoryService openGoodShowCategoryService;

    /**
     * 新增分类
     */
    @RequestMapping("/insert_category")
    public Result<?> insertCategory(
            @RequestParam(value = "serviceId", required = true) int serviceId,
            @RequestParam(value = "categoryName", required = true) String categoryName,
            @RequestParam(value = "sorting", required = true) int sorting,
            @RequestParam(value = "picUrl", required = false, defaultValue = "") String picUrl,
            @RequestParam(value = "isShow", required = true, defaultValue="0") int isShow
    ){
        insertCheck(serviceId, categoryName, sorting, isShow);
        openGoodShowCategoryService.insert(serviceId, categoryName, sorting, picUrl, isShow);
        return Result.success();
    }

    private void insertCheck(int serviceId, String categoryName, int sorting, int isShow){
        authorityCheck(serviceId);
        ValidatorUtil.verify(categoryName, "分类名称",true, 1, 12);
        validator(sorting <= 0 || sorting > 999, "分类排序应该在1~999之间");
        validator(isShow != 0 && isShow != 1 , "首页展示参数有误");
    }
    /**
     * 分类列表
     */
    @RequestMapping("/page_category")
    public Result<?> pageCategory(
            @RequestParam(value = "serviceId", required = true) int serviceId,
            @RequestParam(value = "index", required = false, defaultValue = "1") int index,
            @RequestParam(value = "size", required = false, defaultValue = "10") int size
    ){
        PageList<OpenGoodShowCategory> list = openGoodShowCategoryService.pageQuery(serviceId, index, size);
        return Result.successData(list.convert());
    }

    /**
     * 店内分类选择列表
     */
    @RequestMapping("/category_list")
    public Result<?> categoryList(
            @RequestParam(value = "serviceId", required = true) int serviceId,
            @RequestParam(value = "isShow", required = false, defaultValue = "1") Integer isShow
    ){
        authorityCheck(serviceId);
        List<OpenGoodShowCategory> list = openGoodShowCategoryService.categoryList(serviceId);
        return Result.successData(list);
    }

    /**
     * 修改分类
     */
    @RequestMapping("/update_category")
    public Result<?> updateCategory(
            @RequestParam(value = "serviceId", required = true) int serviceId,
            @RequestParam(value = "categoryId", required = true) long categoryId,
            @RequestParam(value = "categoryName", required = true) String categoryName,
            @RequestParam(value = "sorting", required = true) int sorting,
            @RequestParam(value = "picUrl", required = true) String picUrl,
            @RequestParam(value = "isShow", required = true) int isShow
    ){
        authorityCheck(serviceId);
        updateCheck(categoryName, sorting, isShow);
        openGoodShowCategoryService.update(serviceId, categoryId, categoryName, sorting, picUrl, isShow);
        return Result.success();
    }

    private void updateCheck(String categoryName, int sorting, int isShow){
        ValidatorUtil.verify(categoryName, "分类名称",true, 1, 12);
        validator(sorting <= 0 || sorting > 999, "分类排序应该在1~999之间");
        validator(isShow != 0 && isShow != 1 , "首页展示参数有误");
    }

    /**
     * 删除分类
     */
    @RequestMapping("/delete_category")
    public Result<?> deleteCategory(
            @RequestParam(value = "serviceId", required = true) int serviceId,
            @RequestParam(value = "categoryId", required = true) long categoryId
    ){
        authorityCheck(serviceId);
        openGoodShowCategoryService.delete(categoryId);
        return Result.success();
    }
}
