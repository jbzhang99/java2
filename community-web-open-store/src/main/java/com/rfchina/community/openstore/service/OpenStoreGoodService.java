package com.rfchina.community.openstore.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.OpenGoodGroupConstant;
import com.rfchina.community.base.util.DecimalUtils;
import com.rfchina.community.openstore.entity.SimOpenStoreGood;
import com.rfchina.community.openstore.entity.ext.ExtOpenStoreGood;
import com.rfchina.community.openstore.entity.ext.ExtOpenStoreGoodGroupInfo;
import com.rfchina.community.openstore.entity.ext.ParamOpenStoreGood;
import com.rfchina.community.openstore.mapper.ext.ExtOpenStoreGoodMapper;
import com.rfchina.community.openstore.mapper.ext.ExtOpenStoreServiceTempleteMapper;
import com.rfchina.community.persistence.mapper.OpenStoreGoodDetailMapper;
import com.rfchina.community.persistence.mapper.OpenStoreGoodMapper;
import com.rfchina.community.persistence.model.*;
import com.rfchina.community.persistence.model.CommunityService;
import com.rfchina.community.persistence.model.ext.ExtUserComment;
import com.rfchina.community.service.openser.OpenStoreGoodStockDetailService;
import com.rfchina.community.service.openser.OpenStoreGroupDataSerService;
import com.rfchina.community.service.openser.UserCommentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:fukangwen
 * @Description: 服务商模板service
 */
@Service
public class OpenStoreGoodService extends BaseService {

    @Autowired
    private OpenStoreGoodMapper openStoreGoodMapper;
    @Autowired
    private OpenStoreGoodDetailMapper openStoreGoodDetailMapper;
    @Autowired
    private ExtOpenStoreGoodMapper extOpenStoreGoodMapper;
    @Autowired
    private OpenServiceDetailService openServiceDetailService;
    @Autowired
    private OpenConfService openConfService;
    @Autowired
    private OpenStoreGoodStockDetailService openStoreGoodStockDetailService;
    @Autowired
    private OpenStoreGoodOrderRelService openStoreGoodOrderRelService;
    @Autowired
    private ExtOpenStoreServiceTempleteMapper extOpenStoreServiceTempleteMapper;
    @Autowired
    private UserCommentService userCommentService;
    @Autowired
    private OpenStoreGoodGroupInfoService openStoreGoodGroupInfoService;
    @Autowired
    private OpenStoreGroupDataService openStoreGroupDataService;
    @Autowired
    private OpenStoreGroupDataSerService openStoreGroupDataSerService;
    @Autowired
    private CommunityServiceService communityServiceService;

    public enum Status {
        GROUNDING(1, "上架"), UNDER(2, "下架"), DEL(3, "删除");
        private int key;
        private String label;

        Status(int key, String label) {
            this.key = key;
            this.label = label;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }


    }

    /**
     * @return ExtOpenStoreGood
     * @throws
     * @author:fukangwen
     * @Description: 获取商品详情
     */
    public ExtOpenStoreGood getGoodDetail(int goodId) {
        OpenStoreGood domain = openStoreGoodMapper.selectByPrimaryKey(goodId);
        validator(domain == null, "商品不存在");
        ExtOpenStoreGood extOpenStoreGood = new ExtOpenStoreGood();
        BeanUtils.copyProperties(domain, extOpenStoreGood);
        //详情
        OpenStoreGoodDetail goodDetail = openStoreGoodDetailMapper.selectByPrimaryKey(goodId);
        extOpenStoreGood.setDetail(goodDetail == null ? "" : goodDetail.getDetail());
        //积分信息
        extOpenStoreGood.setOpenPoint(openConfService.getOpenPoint(domain.getPrice()));
        //溢价
        setPremiumPrice(extOpenStoreGood);
        CommunityService service = communityServiceService.getCommunityServiceByPrimaryKey(domain.getServiceId());
        validator(service == null, "店铺不存在");
        extOpenStoreGood.setServiceName(service.getTitle());
        getCommentInfo(extOpenStoreGood, goodId);

        //获取进行中的团购状态跟团购价,
        OpenStoreGoodGroupInfo groupInfo = openStoreGoodGroupInfoService.getValidGoodGroupInfo(extOpenStoreGood.getId());

        //获取之前最近的团购活动
        if (groupInfo == null) {
            extOpenStoreGood.setGroupStatus(0);
            OpenStoreGoodGroupInfo recentGroupInfo = openStoreGoodGroupInfoService.getRecentGroupInfo(extOpenStoreGood.getId());

            //如果没有进行中的团购，那把最近的团购拿出来，看看有没有正在进行中的团
            groupInfo = recentGroupInfo;

        } else {
            extOpenStoreGood.setGroupStatus(1);
            extOpenStoreGood.setGroupPrice(groupInfo.getGroupPrice());
            extOpenStoreGood.setPrice(groupInfo.getPrice());
            extOpenStoreGood.setGroupLimitTimes(groupInfo.getLimitTimes());
            extOpenStoreGood.setGroupStock(groupInfo.getStock());
        }

        if (groupInfo != null) {
            //团购信息
            ExtOpenStoreGoodGroupInfo info = new ExtOpenStoreGoodGroupInfo();
            BeanUtils.copyProperties(groupInfo, info);
            //正在拼团的数量
            info.setGroupDataCount(openStoreGroupDataService.getGroupDataCount(groupInfo.getId(), OpenGoodGroupConstant.dataStatus.un_success));
            //正在拼团的数据，这里显示前3个
            info.setDataList(openStoreGroupDataService.getOpenStoreGroupDataList(groupInfo.getId(),
                    OpenGoodGroupConstant.dataStatus.un_success, 1, 3).getList());

            extOpenStoreGood.setGroupInfo(info);
        }
        if (groupInfo == null || extOpenStoreGood.getGroupInfo().getGroupDataCount() == 0) {
            OpenStoreGoodGroupInfo unStartGroupInfo = openStoreGoodGroupInfoService.getUnStartGroupInfo(extOpenStoreGood.getId());
            extOpenStoreGood.setUnStartGroupInfo(unStartGroupInfo);
        }


        return extOpenStoreGood;
    }


    /**
     * @return ExtOpenStoreGood
     * @throws
     * @author:fukangwen
     * @Description: 获取商品详情
     */
    public ExtOpenStoreGood getSimpleGoodDetail(int goodId) {
        OpenStoreGood domain = openStoreGoodMapper.selectByPrimaryKey(goodId);
        validator(domain == null, "商品不存在");
        if (domain.getStatus() != Status.GROUNDING.key) {
            return null;
        }
        ExtOpenStoreGood extOpenStoreGood = new ExtOpenStoreGood();
        BeanUtils.copyProperties(domain, extOpenStoreGood);

        String[] urls = extOpenStoreGood.getPicUrl().split(",");
        extOpenStoreGood.setPicUrl(urls[0]);

        //溢价
        setPremiumPrice(extOpenStoreGood);

        //获取团购状态跟团购价,
        completeGoodGroupInfo(extOpenStoreGood);

        return extOpenStoreGood;
    }

    /**
     * @return Page<ExtOpenStoreGood>
     * @throws
     * @author:fukangwen
     * @Description: 商品管理列表
     */
    public PageInfo pageQuery(int serviceId, String keyword, String type, String sort, Long showCategoryId, int index, int size) {
        Map<String, Object> param = new HashMap<>();
        //如果服务下架了,返回空list
//		if(!communityServiceService.hadPutOnSale(serviceId)) {
//			logger.info("服务已下架； serviceId:{}" , serviceId);
//			return new PageInfo(new ArrayList<>());
//		}
        //如果模板还未审核通过，返回空list
        if (!openServiceDetailService.hadCheck(serviceId)) {
            logger.info("模板还未审核通过； serviceId:{}", serviceId);
            return new PageInfo(new ArrayList<>());
        }

        param.put("serviceId", serviceId);
        if (StringUtils.isNotBlank(keyword)) {
            param.put("keyword", "%" + keyword + "%");
        }
        param.put("type", type);
        param.put("sort", sort);
        if (showCategoryId != null) {
            param.put("showCategoryId", showCategoryId);
        }


        PageHelper.startPage(index, size);
        List<ExtOpenStoreGood> list = extOpenStoreGoodMapper.pageByCondition(param);

        PageInfo page = new PageInfo(list);

        for (ExtOpenStoreGood extOpenStoreGood : list) {
            String[] urls = extOpenStoreGood.getPicUrl().split(",");
            extOpenStoreGood.setPicUrl(urls[0]);

            completeGoodGroupInfo(extOpenStoreGood);
            calculatePremiumPrice(extOpenStoreGood);
        }
        //设置溢价
        //setPremiumPrice(list);
        return page;
    }

    //获取团购状态跟团购价,
    public OpenStoreGoodGroupInfo completeGoodGroupInfo(ExtOpenStoreGood extOpenStoreGood) {
        OpenStoreGoodGroupInfo groupInfo = openStoreGoodGroupInfoService.getValidGoodGroupInfo(extOpenStoreGood.getId());
        if (groupInfo != null) {
            extOpenStoreGood.setGroupStatus(1);
            extOpenStoreGood.setGroupPrice(groupInfo.getGroupPrice());
            extOpenStoreGood.setPrice(groupInfo.getPrice());
            extOpenStoreGood.setGroupLimitTimes(groupInfo.getLimitTimes());
            extOpenStoreGood.setGroupStock(groupInfo.getStock());
        }
        return groupInfo;
    }

    /**
     * 商品详情设置溢价逻辑
     */
    private void setPremiumPrice(ExtOpenStoreGood extOpenStoreGood) {
        OpenStoreServiceTemplete osst = extOpenStoreServiceTempleteMapper.getPremiumNumById(extOpenStoreGood.getServiceId());
        extOpenStoreGood.setPremiumNum(osst.getPremiumNum());
        //计算溢价
        calculatePremiumPrice(extOpenStoreGood);
    }

    /**
     * 商品列表设置溢价
     *
     * @param list
     * @return
     * @author maixingnian
     */
    private List<ExtOpenStoreGood> setPremiumPrice(List<ExtOpenStoreGood> list) {
        for (ExtOpenStoreGood eosg : list) {
            calculatePremiumPrice(eosg);
        }
        return list;
    }

    /**
     * 计算每个商品溢价
     *
     * @param eosg
     * @return
     * @author maixingnian
     */
    private ExtOpenStoreGood calculatePremiumPrice(ExtOpenStoreGood eosg) {
        if (eosg.getPremiumNum() > 0 && eosg.getPrice() != null) {
            //溢价计算
            BigDecimal b1 = DecimalUtils.obj2BigDecimal(eosg.getPremiumNum());
            b1 = DecimalUtils.mul(b1, eosg.getPrice()); //相乘
            b1 = DecimalUtils.div(b1, DecimalUtils.obj2BigDecimal(100)); //相除
            b1 = DecimalUtils.add(b1, eosg.getPrice());//相加
            b1 = DecimalUtils.bigDecimalScale(b1, 2, BigDecimal.ROUND_UP); //向上取整
            eosg.setPremiumPrice(b1);//设值
            eosg.setPrePrice(b1);//溢价赋值给原价（小富市集商家-这里并没有更新数据库数据）
        } else {
            //没溢价（普通商家和设置溢价为0的小富市集商家）
            eosg.setPremiumPrice(eosg.getPrice());
        }
        return eosg;
    }

    /**
     * @return OpenStoreGood
     * @throws
     * @author:fukangwen
     * @Description:
     */
    public OpenStoreGood getById(Integer goodId) {
        return openStoreGoodMapper.selectByPrimaryKey(goodId);
    }

    /**
     * @return List<OpenStoreGood>
     * @throws
     * @author:fukangwen
     * @Description: 根据多个商品Id获取对象信息
     */
    public List<OpenStoreGood> listGoodBeforePay(String goodIds) {
        String[] goodIdStr = goodIds.split(",");
        List<Integer> goodIdList = new ArrayList<Integer>();
        for (String goodId : goodIdStr) {
            goodIdList.add(Integer.parseInt(goodId));
        }
        OpenStoreGoodExample example = new OpenStoreGoodExample();
        example.createCriteria().andIdIn(goodIdList);
        List<OpenStoreGood> list = openStoreGoodMapper.selectByExample(example);
        for (OpenStoreGood openStoreGood : list) {
            validator(openStoreGood.getStatus() != Status.GROUNDING.key, "有商品下架或删除,请重新下单");
        }
        return list;

    }

    /**
     * @return List<OpenStoreGood>
     * @throws
     * @author:fukangwen
     * @Description: 根据多个商品Id获取对象信息
     */
    public List<SimOpenStoreGood> listGoodBeforePay(List<ParamOpenStoreGood> paramGoodlist) {
        List<SimOpenStoreGood> simGoodList = new ArrayList<SimOpenStoreGood>();

        for (ParamOpenStoreGood paramGood : paramGoodlist) {
            OpenStoreGood openStoreGood = openStoreGoodMapper.selectByPrimaryKey(paramGood.getGoodId());
            validator(openStoreGood == null, "商品不存在");
            validator(openStoreGood.getStatus() != Status.GROUNDING.key, "有商品下架或删除,请重新下单");
            SimOpenStoreGood sim = new SimOpenStoreGood();
            BeanUtils.copyProperties(openStoreGood, sim);
            sim.setAmount(paramGood.getAmount());
            String[] urls = sim.getPicUrl().split(",");
            sim.setPicUrl(urls[0]);
            simGoodList.add(sim);
        }
        return simGoodList;

    }


    /**
     * @return boolean
     * @throws
     * @author:fukangwen
     * @Description: 判断商品存不存在
     */
    public boolean isExist(int goodId) {
        OpenStoreGood openStoreGood = openStoreGoodMapper.selectByPrimaryKey(goodId);
        if (openStoreGood == null)
            return false;
        return true;
    }

    /**
     * @return void
     * @throws
     * @author:fukangwen
     * @Description: 更新库存量（增加，减少）
     */
    @Transactional
    public void reduceStock(ParamOpenStoreGood openStoreGood, int decNum, Integer orderId) {
        long now = System.currentTimeMillis();

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("id", openStoreGood.getGoodId());
        param.put("oldStock", openStoreGood.getStock());
        param.put("decNum", decNum);
        param.put("groupInfoId", openStoreGood.getGroupInfoId());

        int row = 0;
        if (openStoreGood.getGroupStockStatus() == OpenGoodGroupConstant.groupStockStatus.good_stock) {
            row = extOpenStoreGoodMapper.reduceGoodStock(param);
        } else {
            row = extOpenStoreGoodMapper.reduceGroupStock(param);
        }

        validator(row <= 0, "未获取到库存信息,或库存不足,请重新再试");
        String type = openStoreGood.getGroupStockStatus() == OpenGoodGroupConstant.groupStockStatus.good_stock ?
                OpenGoodGroupConstant.stockType.good : OpenGoodGroupConstant.stockType.group;
        //插入记录
        openStoreGoodStockDetailService.insert(openStoreGood.getGoodId(), openStoreGood.getGroupInfoId(), (int) param.get("oldStock"),
                openStoreGood.getStock(), decNum, type, OpenConstant.StockOperate.DEC.toString(),
                OpenConstant.StockSource.CLIENT.toString(), orderId);

        logger.info("单个改变库存的时间：商品信息={},耗时：{}", openStoreGood.toString(), System.currentTimeMillis() - now);
    }

    /**
     * @return void
     * @throws
     * @author:fukangwen
     * @Description:
     */
    @Transactional
    public void reduceStock(Long groupDataId, List<ParamOpenStoreGood> goodList, Integer orderId) {
        //根据id进行排序
        for (ParamOpenStoreGood good : goodList) {
            //
            this.reduceStock(good, good.getAmount(), orderId);

            //锁团订单,加入拼团才需要锁团订单
            if (groupDataId > 0) {
                openStoreGroupDataSerService.lockGroupDataUsableNum(good.getGoodId(), good.getGroupInfoId(), groupDataId, good.getAmount(), orderId);
            }
        }
    }


    /**
     * @return void
     * @throws
     * @author:fukangwen
     * @Description: 更新销量
     */
    public void updateSaleAmount(Integer orderId) {
        List<OpenStoreGoodOrderRel> relList = openStoreGoodOrderRelService.getList(orderId);
        if (relList.size() <= 0)
            return;

        //更新销量
        for (OpenStoreGoodOrderRel rel : relList) {
            OpenStoreGood good = openStoreGoodMapper.selectByPrimaryKey(rel.getGoodId());
            good.setSaleAmount(good.getSaleAmount() + rel.getAmount());
            good.setTotalSaleAmount(good.getSaleAmount() + good.getVirtualSaleAmount());
            openStoreGoodMapper.updateByPrimaryKey(good);
        }
    }

    /**
     * @return void
     * @Author wlrllr
     * @Description //商品详情获取用户评价
     * @Date 2019/3/6
     * @Param [extOpenStoreGood, goodId]
     **/
    private void getCommentInfo(ExtOpenStoreGood extOpenStoreGood, Integer goodId) {
        try {
            List<ExtUserComment> list = userCommentService.getFirstGoodComment(goodId);
            extOpenStoreGood.setCommentTotalNum(userCommentService.countByGoodsId(goodId));
            if (list != null && list.size() > 0) {
                extOpenStoreGood.setFirstGoodsComment(list.get(0));
            }
        } catch (Exception e) {
            logger.error("查询商品评价异常", e);
        }
    }
}
