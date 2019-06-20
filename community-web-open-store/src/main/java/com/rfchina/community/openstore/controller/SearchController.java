package com.rfchina.community.openstore.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rfchina.community.base.Constant;
import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.Result;
import com.rfchina.community.openstore.entity.SearchGoodBean;
import com.rfchina.community.openstore.entity.SearchServiceBean;
import com.rfchina.community.openstore.mapper.ext.ExtOpenStoreGoodMapper;
import com.rfchina.community.openstore.mapper.ext.ExtOpenXFSJStoreMapper;
import com.rfchina.community.openstore.service.OpenStoreGoodGroupInfoService;
import com.rfchina.community.openstore.service.UserSearchLogService;
import com.rfchina.community.persistence.mapper.OpenStoreServiceDiscountMapper;
import com.rfchina.community.persistence.mapper.OpenStoreServiceTempleteMapper;
import com.rfchina.community.persistence.model.OpenStoreGoodGroupInfo;
import com.rfchina.community.persistence.model.OpenStoreServiceDiscount;
import com.rfchina.community.persistence.model.OpenStoreServiceTemplete;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
@RestController
@RequestMapping(value = Constant.ROOT_PATH_OPENSTORE)
public class SearchController extends BaseController {

    @Autowired
    private ExtOpenStoreGoodMapper extOpenStoreGoodMapper;

    @Autowired
    private OpenStoreServiceTempleteMapper openStoreServiceTempleteMapper;
    @Autowired
    private UserSearchLogService userSearchLogService;

    @Autowired
    private OpenStoreServiceDiscountMapper openStoreServiceDiscountMapper;
    @Autowired
    private ExtOpenXFSJStoreMapper extOpenXFSJStoreMapper;
    @Autowired
    private OpenStoreGoodGroupInfoService openStoreGoodGroupInfoService;

    @RequestMapping("/searchGoods")
    public Result<?> searchGoods(@RequestParam(value = "accessToken", required = false) String accessToken,
                                 @RequestParam(value = "words", required = false, defaultValue = "") String words,
                                 @RequestParam(value = "sort_name", required = false, defaultValue = "sale_amount") String sortName,
                                 @RequestParam(value = "sort_type", required = false, defaultValue = "desc") String sortType,
                                 @RequestParam(value = "type", required = false, defaultValue = "GENERAL") String type,
                                 @RequestParam(value = "sort", required = false, defaultValue = OpenConstant.OpenStoreGoodSort.down) String sort,
                                 @RequestParam(value = "discountType", required = false, defaultValue = "") String discountType,//优惠
                                 @RequestParam(value = "openStoreType", required = false, defaultValue = "") String openStoreType,//店铺
                                 @RequestParam(value = "postage", required = false, defaultValue = "") String postage,//邮费
                                 @RequestParam(value = "index", required = false, defaultValue = "1") int index,
                                 @RequestParam(value = "size", required = false, defaultValue = "10") int size) {
        logger.info("获取搜索产品列表:参数,likeKeyWords:{},index:{},size:{}", words, index, size);
        PageHelper.startPage(index, size);
        Map<String, Object> map = new HashMap<>();
        if(StringUtils.isNotBlank(words)) {
            map.put("likeKeyWords", "%" + words + "%");
        }
        map.put("discountType", discountType);
        map.put("openStoreType", openStoreType);
        map.put("postage", postage);
        map.put("type", type);
        map.put("sort", sort);
        PageInfo pageInfo = new PageInfo(searchGoods(map));
        if (StringUtils.isNotBlank(accessToken)) {
            Long uid = getUidByToken(accessToken);
            if (uid == null) {
                error("用户未登录");
            }
            userSearchLogService.addLogSysn(uid, words);
        }
        return Result.successData(pageInfo);
    }

    @RequestMapping("/searchService")
    public Result<?> searchService(@RequestParam(value = "words", required = true) String words,
                                   @RequestParam(value = "index", required = false, defaultValue = "1") int index,
                                   @RequestParam(value = "size", required = false, defaultValue = "10") int size) {
        logger.info("获取搜索店铺列表:参数,words:{},index:{},size:{}", words, index, size);
        PageHelper.startPage(index, size);
        List<SearchServiceBean> list = extOpenXFSJStoreMapper.searchService("%" + words + "%");
        PageInfo pageInfo = new PageInfo(list);
        for (SearchServiceBean bean : list) {
            Integer serviceId = bean.getServiceId();
            OpenStoreServiceTemplete temp = openStoreServiceTempleteMapper.selectByPrimaryKey(serviceId);
            if (temp != null) {
                BigDecimal expressMoney = temp.getExpressMoney();
                bean.setExpressMoney(expressMoney);
                bean.setFlagship(temp.getFlagship());
            }
            OpenStoreServiceDiscount discount = openStoreServiceDiscountMapper.selectByPrimaryKey(serviceId);
            if (discount == null) {
                bean.setDiscount(new OpenStoreServiceDiscount());
            } else {
                bean.setDiscount(discount);
            }

        }
        return Result.successData(pageInfo);
    }

    @RequestMapping("/listGoodsInfoByCategory")
    public Result<?> listGoodsInfoByCategory(@RequestParam(value = "category_id", required = false, defaultValue = "0") Integer categoryId,
                                             @RequestParam(value = "words", required = false, defaultValue = "") String words,
                                             @RequestParam(value = "type", required = false, defaultValue = "GENERAL") String type,
                                             @RequestParam(value = "sort", required = false, defaultValue = OpenConstant.OpenStoreGoodSort.down) String sort,
                                             @RequestParam(value = "discountType", required = false, defaultValue = "") String discountType,//优惠
                                             @RequestParam(value = "openStoreType", required = false, defaultValue = "") String openStoreType,//店铺
                                             @RequestParam(value = "postage", required = false, defaultValue = "") String postage,//邮费
                                             @RequestParam(value = "index", required = false, defaultValue = "1") int index,
                                             @RequestParam(value = "size", required = false, defaultValue = "10") int size) {
        logger.info("获取搜索产品列表:参数,category_id:{},index:{},size:{}", categoryId, index, size);
        PageHelper.startPage(index, size);
        Map<String, Object> map = new HashMap<>();
        map.put("category_id", categoryId);
        if(StringUtils.isNotBlank(words)) {
            map.put("likeKeyWords", "%" + words + "%");
        }
        map.put("discountType", discountType);
        map.put("openStoreType", openStoreType);
        map.put("postage", postage);
        map.put("type", type);
        map.put("sort", sort);
        return Result.successData(new PageInfo(searchGoods(map)));
    }

    private List<SearchGoodBean> searchGoods(Map<String, Object> map) {
        List<SearchGoodBean> list = extOpenStoreGoodMapper.searchGood(map);
        for (SearchGoodBean bean : list) {
            String[] urls = bean.getPicUrl().split(",");
            bean.setPicUrl(urls[0]);

            Integer serviceId = bean.getServiceId();
            OpenStoreServiceTemplete temp = openStoreServiceTempleteMapper.selectByPrimaryKey(serviceId);
            if (temp != null) {
                BigDecimal expressMoney = temp.getExpressMoney();
                bean.setExpressMoney(expressMoney);
                bean.setFlagship(temp.getFlagship());
            }
            OpenStoreServiceDiscount discount = openStoreServiceDiscountMapper.selectByPrimaryKey(serviceId);
            if (discount == null) {
                bean.setDiscount(new OpenStoreServiceDiscount());
            } else {
                bean.setDiscount(discount);
            }

            //获取团购状态跟团购价,
            OpenStoreGoodGroupInfo groupInfo = openStoreGoodGroupInfoService.getValidGoodGroupInfo(bean.getGoodId());
            if(groupInfo != null){
                bean.setGroupStatus(1);
                bean.setGroupPrice(groupInfo.getGroupPrice());
                bean.setPrice(groupInfo.getPrice());
            }
        }
        return list;
    }

    @RequestMapping("/getSearchBaseInfo")
    public Result<?> getSearchBaseInfo(){
        Map<String, Object> map = new HashMap<>();
        map.put("openStoreDiscountType", OpenConstant.OpenStoreDiscountType.getList());
        map.put("openStoreType", OpenConstant.OpenStoreType.getList());
        map.put("openStorePostage", OpenConstant.OpenStorePostage.getList());
        return Result.successData(map);
    }



}
