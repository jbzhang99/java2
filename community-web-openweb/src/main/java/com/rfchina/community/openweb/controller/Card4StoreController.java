package com.rfchina.community.openweb.controller;

import com.alibaba.fastjson.JSONObject;
import com.rfchina.community.base.Constant;
import com.rfchina.community.base.Result;
import com.rfchina.community.base.StatusCode;
import com.rfchina.community.base.constant.CardInfoConstant;
import com.rfchina.community.base.exception.WorkRunTimeException;
import com.rfchina.community.component.SysMsgInfoComponent;
import com.rfchina.community.component.WebappConfComponent;
import com.rfchina.community.openweb.component.CardComponent;
import com.rfchina.community.openweb.entity.CardInfoExt;
import com.rfchina.community.openweb.entity.Page;
import com.rfchina.community.openweb.entity.StoreCardInfoExt;
import com.rfchina.community.openweb.service.CardService;
import com.rfchina.community.persistence.mapper.*;
import com.rfchina.community.persistence.model.*;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.paginator.model.PageList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 */
@RestController
@RequestMapping(value = {Constant.ROOT_PATH_OPENWEB})
public class Card4StoreController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private WebappConfComponent webappConfComponent;

    @Autowired
    private CardService cardService;

    @Autowired
    private CardComponent cardComponent;

    @Autowired
    private CardInfoMapper cardInfoMapper;

    @Autowired
    private OpenStoreGoodMapper openStoreGoodMapper;

    @Autowired
    private CardInfoOpenRelaMapper cardInfoOpenRelaMapper;

    @Autowired
    private CommunityServiceMapper communityServiceMapper;

    @Autowired
    private CommunityServiceRelaMapper communityServiceRelaMapper;

    @Autowired
    private CardCategoryMapper cardCategoryMapper;

    @Autowired
    private HomeCardInfoMapper homeCardInfoMapper;

    @Autowired
    private SysMsgInfoComponent sysMsgInfoComponent;

    @Value("${merchant.monthly.publish}")
    private Integer merchantMonthlyPublish;

    @RequestMapping(value = {"/getCardInfo"})
    @ResponseBody
    public Result<StoreCardInfoExt> getCardInfo(@RequestParam(value = "id") Long id) {
        CardInfoExt info = cardService.getCardInfo(id);
        StoreCardInfoExt ext = new StoreCardInfoExt();
        if (info != null && info.getId() != null) {
            BeanUtils.copyProperties(info, ext);
            CardInfoOpenRelaExample example = new CardInfoOpenRelaExample();
            example.createCriteria().andCardIdEqualTo(info.getId());
            List<CardInfoOpenRela> openRelas = cardInfoOpenRelaMapper.selectByExample(example);
            if (CollectionUtils.isNotEmpty(openRelas)) {
                if (openRelas.get(0).getGoodsId() != null) {
                    OpenStoreGood good = openStoreGoodMapper.selectByPrimaryKey(openRelas.get(0).getGoodsId());
                    if (good != null) {
                        ext.setGoodName(good.getName());
                        ext.setGood(good);
                    }
                }
            }
        } else {
            throw new WorkRunTimeException("非法参数");
        }
        return Result.successData(ext);
    }

    @RequestMapping(value = {"/getCardInfoList"})
    @ResponseBody
    public Result<Page<StoreCardInfoExt>> getCardInfoList(
            @RequestParam(value = "serviceId", required = false, defaultValue = "0") Integer serviceId,
            @RequestParam(value = "templateId", required = false, defaultValue = "0") Integer templateId,
            @RequestParam(value = "serviceName", required = false) String serviceName,
            @RequestParam(value = "merchantName", required = false) String merchantName,
            @RequestParam(value = "pubToSquare", required = false, defaultValue = "-1") Integer pubToSquare,
            @RequestParam(value = "auditStatus", required = false, defaultValue = "0") Integer auditStatus,
            @DateTimeFormat(pattern = Constant.DEFAULT_DATETIME_FORMAT) @RequestParam(value = "startCreateTime", required = false) Date startCreateTime,
            @DateTimeFormat(pattern = Constant.DEFAULT_DATETIME_FORMAT) @RequestParam(value = "endCreateTime", required = false) Date endCreateTime,
            @RequestParam(value = "index", required = false, defaultValue = "1") Integer index,
            @RequestParam(value = "size", required = false, defaultValue = "10") Integer size) {

        Long passportId = getAdminId();
        PageList<StoreCardInfoExt> list = cardService.getStoreCardInfoList(passportId, serviceId, templateId, serviceName, merchantName, pubToSquare, startCreateTime,
                endCreateTime, auditStatus, index, size);

        list.forEach(p ->
        {
            CardInfoOpenRelaExample example = new CardInfoOpenRelaExample();
            example.createCriteria().andCardIdEqualTo(p.getId());
            List<CardInfoOpenRela> openRelas = cardInfoOpenRelaMapper.selectByExample(example);
            if (CollectionUtils.isNotEmpty(openRelas)) {
                if (openRelas.get(0).getCardId() != null) {
                    OpenStoreGood good = openStoreGoodMapper.selectByPrimaryKey(openRelas.get(0).getGoodsId());
                    if (null != good) {
                        p.setGood(good);
                        p.setGoodName(good.getName());
                    }
                }
            }
        });
        Page<StoreCardInfoExt> pageList = new Page(list.getPaginator().getIndex(), list.getPaginator().getSize(), new Long(list.size()), list.getPaginator().getTotal(), list);

        return Result.successData(pageList);
    }

    @RequestMapping(value = {"/addCardInfo"})
    @ResponseBody
    @Transactional(rollbackFor = {Exception.class})
    public Result<String> addCardInfo(@RequestParam(value = "template_id") Integer template_id,
                                      @RequestParam(value = "service_id") Integer service_id,
                                      @RequestParam(value = "goods_id", required = false) Integer goods_id,
                                      @RequestParam(value = "pubToSquare", required = false, defaultValue = "0") Integer pubToSquare,
                                      @RequestParam(value = "submitAudit", required = false, defaultValue = "0") Integer submitAudit,
                                      @RequestParam(value = "content", required = false, defaultValue = "") String content,
                                      @RequestParam(value = "attachment", required = false, defaultValue = "") String attachment) {

        Result<String> result = new Result<>();
        CommunityService communityService = communityServiceService.getCommunityServiceByPrimaryKey(service_id);
        validator(communityService == null, "店铺信息不存在");
        validator(communityService.getStatus() != Constant.OpenAdmin.CommunityServiceGroundStatus.GROUNDING,
				"您的店铺未上架，无法发布");
        
        String squareCommunityId = webappConfComponent.getWebConf(Constant.App.Id.COMMUNITY_API.value(), "square.community.id", 3, TimeUnit.MINUTES);
        logger.info("squareCommunityId：" + squareCommunityId);
        String merchantMonthlyCount = webappConfComponent.getWebConf(Constant.App.Id.COMMUNITY_API.value(), "merchant.monthly.publish", 3, TimeUnit.MINUTES);

        if (StringUtils.isNotEmpty(merchantMonthlyCount) && StringUtils.isNumeric(merchantMonthlyCount)) {
            merchantMonthlyPublish = Integer.parseInt(merchantMonthlyCount);
        }

        if (StringUtils.isEmpty(squareCommunityId) || !StringUtils.isNumeric(squareCommunityId)) {
            result.setStatus(StatusCode.FAILURE_INFO.value());
            result.setMessage("未配置广场社区");
            return result;
        }

        if (cardComponent.getImageNumFromAttachment(attachment) > 9) {
            result.setStatus(StatusCode.FAILURE_INFO.value());
            result.setMessage("上传图片数量最多9张");
            return result;
        }

        Long passportId = getAdminId();
        long cardCount = cardService.getCurrentMonthCount(passportId, service_id);  // 测试，要改回getCurrentMonthCount
        if (cardCount > merchantMonthlyPublish) {
            throw new WorkRunTimeException("本月推广额度已用完，请到下个月再推广");
        }

        int templeteId = CardInfoConstant.CardTemplate.BUSINESS_COMMON_TEMPLTE_ID;
        if (template_id != null && template_id.equals(CardInfoConstant.CardTemplate.BUSINESS_GOODS_TEMPLTE_ID)) {
            templeteId = CardInfoConstant.CardTemplate.BUSINESS_GOODS_TEMPLTE_ID;
        }

        if (templeteId == CardInfoConstant.CardTemplate.BUSINESS_GOODS_TEMPLTE_ID) {
            OpenStoreGood good = openStoreGoodMapper.selectByPrimaryKey(goods_id);
            if (good == null) {
                throw new WorkRunTimeException("商品id无效");
            }
        }

        CommunityServiceRelaExample communityServiceRelaExample = new CommunityServiceRelaExample();
        communityServiceRelaExample.createCriteria().andServiceIdEqualTo(service_id);
        List<CommunityServiceRela> communityServiceRelaList = communityServiceRelaMapper.selectByExample(communityServiceRelaExample);

        //添加到广场社区
        CommunityServiceRela square = new CommunityServiceRela();
        square.setCommunityId(Integer.parseInt(squareCommunityId));
        if (!communityServiceRelaList.stream().map(CommunityServiceRela::getCommunityId).collect(Collectors.toList()).contains(square.getCommunityId())) {
            communityServiceRelaList.add(square);
            //logger.info("squareCommunityId-ADD：" + squareCommunityId);
        }

        Date now = new Date();
        String operationId = UUID.randomUUID().toString();
        boolean flag = false;
        for (CommunityServiceRela item : communityServiceRelaList) {
            //logger.info("squareCommunityId-item：" + item.getCommunityId());
            CardInfo record = new CardInfo();
            CardCategoryExample cardCategoryExample = new CardCategoryExample();
            cardCategoryExample.createCriteria().andCommunityIdEqualTo(item.getCommunityId()).andTypeEqualTo(CardInfoConstant.CardCategory.Type.FIXED_CATEGORY).andNameEqualTo("购物");
            List<CardCategory> cardCategories = cardCategoryMapper.selectByExample(cardCategoryExample);
            if (CollectionUtils.isEmpty(cardCategories)) {
                continue;
            }

            record.setCategoryId(cardCategories.get(0).getId());
            record.setCommunityId(item.getCommunityId());
            record.setOperationId(operationId);
            if (template_id != null && template_id.equals(CardInfoConstant.CardTemplate.BUSINESS_GOODS_TEMPLTE_ID)) {
                record.setTemplateId(CardInfoConstant.CardTemplate.BUSINESS_GOODS_TEMPLTE_ID);
            } else {
                record.setTemplateId(CardInfoConstant.CardTemplate.BUSINESS_COMMON_TEMPLTE_ID);
            }

            record.setContent(content);
            record.setSubjectId(passportId);
            record.setSubjectName(communityServiceMapper.selectByPrimaryKey(service_id).getTitle());
            record.setSubjectType(CardInfoConstant.CardSubject.Type.OPEN_WEB);

            record.setAttachment(transAttachmentToImageList(attachment).toJSONString());
            record.setCreatorId(passportId);
            record.setPubToSquare(pubToSquare);
            record.setSquareAuditStatus(CardInfoConstant.CardInfo.SquareAuditStatus.UNAUDIT);

            record.setAuditStatus(CardInfoConstant.CardInfo.AuditStatus.PUBLISH);
            record.setStatus(CardInfoConstant.CardInfo.Status.NORMAL);

            record.setCreateTime(now);
            record.setUpdateTime(now);
            record.setApplyTime(now);
            record.setCid(now.getTime());
            record.setSource(CardInfoConstant.CardInfo.Source.OPEN);
            flag = cardService.addCardInfo(record);

            //店铺卡片
            CardInfoOpenRela cardInfoOpenRela = new CardInfoOpenRela();
            cardInfoOpenRela.setCardId(record.getId());
            cardInfoOpenRela.setMerchantId(passportId);
            cardInfoOpenRela.setServiceId(service_id);
            cardInfoOpenRela.setGoodsId(goods_id);
            cardInfoOpenRelaMapper.insertSelective(cardInfoOpenRela);

        }

        if (flag) {
            return Result.success();
        } else {
            result.setStatus(StatusCode.FAILURE_INFO.value());
            result.setMessage("创建失败!");
            result.setData("");
            return result;
        }
    }


    @RequestMapping(value = {"/deleteCardInfo"})
    @ResponseBody
    public Result<String> deleteCardInfo(@RequestParam(value = "operation_id") String operation_id) {


        CardInfoExample example = new CardInfoExample();
        example.createCriteria().andOperationIdEqualTo(operation_id);
        List<CardInfo> cardInfoList = cardInfoMapper.selectByExample(example);

        for (CardInfo prvRecord : cardInfoList) {
            cardService.deleteCardInfo(prvRecord.getId());
        }

        Result<String> result = new Result<>();
        result.setStatus(StatusCode.SUCCESS_INFO.value());
        result.setMessage("删除成功!");
        result.setData("");
        return result;
    }

    @RequestMapping(value = {"/auditCardInfo"})
    @Transactional(rollbackFor = {Exception.class})
    public Result<String> auditCardInfo(@RequestParam(value = "id") Integer id,
                                        @RequestParam(value = "operation_id") String operation_id,
                                        @RequestParam("auditStatus") Integer auditStatus,
                                        @RequestParam(value = "auditReason", required = false, defaultValue = "") String auditReason) {
        Result<String> result = new Result<>();
        Date now = new Date();

        CardInfoExample example = new CardInfoExample();
        example.createCriteria().andOperationIdEqualTo(operation_id);
        List<CardInfo> cardInfoList = cardInfoMapper.selectByExample(example);

        for (CardInfo prvRecord : cardInfoList) {
            CardInfo newRecord = new CardInfo();
            newRecord.setId(prvRecord.getId());
            newRecord.setUpdateTime(now);
            newRecord.setAuditStatus(auditStatus);
            if (CardInfoConstant.CardInfo.SquareAuditStatus.REPEAL.equals(auditStatus)) {// 下架
                if (null != prvRecord) {
                    if (!CardInfoConstant.CardInfo.AuditStatus.PUBLISH.equals(prvRecord.getAuditStatus())) {
                        result.setStatus(StatusCode.FAILURE_INFO.value());
                        result.setMessage("未上架的不允许下架");
                        return result;
                    }
                    if (id.equals(prvRecord.getId())) {
                        HomeCardInfo updateHomeCardInfo = new HomeCardInfo();
                        updateHomeCardInfo.setId(prvRecord.getId());
                        updateHomeCardInfo.setStatus(CardInfoConstant.CardInfo.Status.HIDDEN);
                        homeCardInfoMapper.updateByPrimaryKeySelective(updateHomeCardInfo);
                    }
                }
                newRecord.setStatus(CardInfoConstant.CardInfo.Status.HIDDEN);
                newRecord.setSquareAuditStatus(CardInfoConstant.CardInfo.SquareAuditStatus.REPEAL);
            } else if (CardInfoConstant.CardInfo.AuditStatus.PUBLISH.equals(auditStatus)) { // 上架
                if (null != prvRecord) {
                    if (!CardInfoConstant.CardInfo.AuditStatus.AUDIT_PASS.equals(prvRecord.getAuditStatus())) { // 不是审核通过的不允许上架
                        result.setStatus(StatusCode.FAILURE_INFO.value());
                        result.setMessage("审核通过的才允许上架");
                        return result;
                    }
                    newRecord.setPublishTime(now);
                }
                newRecord.setStatus(CardInfoConstant.CardInfo.Status.NORMAL);
                newRecord.setCid(now.getTime());

                if (Constant.YesOrNo.YES.equals(prvRecord.getPubToSquare())) {
                    // 增加消息操作
                    sysMsgInfoComponent.add(SysMsgInfoComponent.ObjectType.card_pf_audit, prvRecord.getId() + "", prvRecord.getCommunityId());
                }
            } else if (CardInfoConstant.CardInfo.AuditStatus.AUDIT_NOTPASS.equals(auditStatus)) { // 审核不通过，需要求填写审核不通过原因
                if (StringUtils.isBlank(auditReason)) {
                    result.setStatus(StatusCode.FAILURE_INFO.value());
                    result.setMessage("不通过原因不能为空");
                    return result;
                }
                if (null != prvRecord) {
                    if (!CardInfoConstant.CardInfo.AuditStatus.AUDITING.equals(prvRecord.getAuditStatus())
                            && !CardInfoConstant.CardInfo.AuditStatus.REPEAL.equals(prvRecord.getAuditStatus())) { // 不是审核通过的不允许上架
                        result.setStatus(StatusCode.FAILURE_INFO.value());
                        result.setMessage("非审核中状态");
                        return result;
                    }
                }
                newRecord.setStatus(CardInfoConstant.CardInfo.Status.HIDDEN);
                newRecord.setAuditReason(auditReason);
            } else if (CardInfoConstant.CardInfo.AuditStatus.AUDIT_PASS.equals(auditStatus)) { // 审核通过,隐藏但不上架
                if (null != prvRecord) {
                    if (!CardInfoConstant.CardInfo.AuditStatus.AUDITING.equals(prvRecord.getAuditStatus())
                            && !CardInfoConstant.CardInfo.AuditStatus.REPEAL.equals(prvRecord.getAuditStatus())) { // 不是审核通过的不允许上架
                        result.setStatus(StatusCode.FAILURE_INFO.value());
                        result.setMessage("非审核中状态");
                        return result;
                    }
                }
                newRecord.setStatus(CardInfoConstant.CardInfo.Status.HIDDEN);
            } else {
                result.setStatus(StatusCode.FAILURE_INFO.value());
                result.setMessage("输入值不正确");
                return result;
            }
            int j = cardInfoMapper.updateByPrimaryKeySelective(newRecord);
        }
        result.setStatus(StatusCode.SUCCESS_INFO.value());
        result.setMessage(StatusCode.SUCCESS_INFO.name());
        result.setData("");
        return result;
    }

    @RequestMapping(value = {"/pubToSquare"})
    @ResponseBody
    public Result<String> pubToSquare(@RequestParam(value = "id") Long id) {
        Result<String> result = new Result<>();

        String squareCommunityId = webappConfComponent.getWebConf(Constant.App.Id.COMMUNITY_API.value(), "square.community.id", 3, TimeUnit.MINUTES);
        if (StringUtils.isEmpty(squareCommunityId) || !StringUtils.isNumeric(squareCommunityId)) {
            result.setStatus(StatusCode.FAILURE_INFO.value());
            result.setMessage("未配置广场社区");
            return result;
        }


        CardInfo prvRecord = cardService.getCardInfo(id);
        if (prvRecord == null) {
            throw new WorkRunTimeException("找不到卡片信息");
        }
        if (squareCommunityId.equals(prvRecord.getCommunityId().toString())) {
            if (Constant.YesOrNo.YES.equals(prvRecord.getPubToSquare())) {
                result.setStatus(StatusCode.FAILURE_INFO.value());
                result.setMessage("同步到广场失败，该卡片已同步到广场");
                return result;
            }
            Integer communityId = prvRecord.getCommunityId();

            boolean flag = cardService.pubToSquare(prvRecord.getId(), Constant.YesOrNo.YES);
            if (flag) {
                if (CardInfoConstant.CardInfo.AuditStatus.PUBLISH.equals(prvRecord.getAuditStatus())) {
                    sysMsgInfoComponent.add(SysMsgInfoComponent.ObjectType.card_pf_audit, prvRecord.getId() + "", prvRecord.getCommunityId());
                }
            }
        } else {
            throw new WorkRunTimeException("该卡片非店铺推广卡片");
        }
        result.setStatus(StatusCode.SUCCESS);
        result.setMessage("操作成功!");
        result.setData("");
        return result;
    }


    private JSONObject transAttachmentToImageList(String attachment) {
        List<String> list = new ArrayList<>();
        if (StringUtils.isNotBlank(attachment)) {
            String[] array = attachment.split(",");
            if (null != array && 0 != array.length) {
                for (String imgUrl : array) {
                    list.add(imgUrl);
                }
            }
        }
        JSONObject attachmentJSON = new JSONObject();
        attachmentJSON.put("images", list);
        return attachmentJSON;
    }
}
