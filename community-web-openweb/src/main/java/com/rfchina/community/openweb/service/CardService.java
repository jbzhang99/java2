package com.rfchina.community.openweb.service;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import org.apache.commons.lang3.StringUtils;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rfchina.community.base.Constant;
import com.rfchina.community.base.constant.CardInfoConstant;
import com.rfchina.community.base.util.DateTimeUtils;
import com.rfchina.community.component.AreaComponent;
import com.rfchina.community.component.SensitiveWordsComponent;
import com.rfchina.community.openweb.component.CardComponent;
import com.rfchina.community.openweb.entity.CardInfoExt;
import com.rfchina.community.openweb.entity.Image;
import com.rfchina.community.openweb.entity.StoreCardInfoExt;
import com.rfchina.community.openweb.entity.Video;
import com.rfchina.community.openweb.mapper.ext.ExtCardInfoMapper;
import com.rfchina.community.openweb.mapper.ext.ExtCardInfoOpenMapper;
import com.rfchina.community.persistence.mapper.CardCountMapper;
import com.rfchina.community.persistence.mapper.CardInfoMapper;
import com.rfchina.community.persistence.mapper.CardInfoOpenRelaMapper;
import com.rfchina.community.persistence.mapper.CommunityMapper;
import com.rfchina.community.persistence.mapper.HomeCardInfoMapper;
import com.rfchina.community.persistence.model.Area;
import com.rfchina.community.persistence.model.CardCategory;
import com.rfchina.community.persistence.model.CardCount;
import com.rfchina.community.persistence.model.CardInfo;
import com.rfchina.community.persistence.model.CardInfoExample;
import com.rfchina.community.persistence.model.Community;
import com.rfchina.community.persistence.model.HomeCardInfo;
import com.rfchina.community.persistence.model.HomeCardInfoExample;

/**
 */
@Service
public class CardService {

    private static Logger logger = LoggerFactory.getLogger(CardService.class);

    @Autowired
    private CardInfoMapper cardInfoMapper;

    @Autowired
    private HomeCardInfoMapper homeCardInfoMapper;

    @Autowired
    private ExtCardInfoMapper extCardInfoMapper;

    @Autowired
    private ExtCardInfoOpenMapper extCardInfoOpenMapper;

    @Autowired
    private CardCountMapper cardCountMapper;

    @Autowired
    private CardComponent cardComponent;

    @Autowired
    private SensitiveWordsComponent sensitiveWordsComponent;

    @Autowired
    private CommunityMapper communityMapper;

    @Autowired
    private AreaComponent areaComponent;

    @Autowired
    private CardInfoOpenRelaMapper cardInfoOpenRelaMapper;

    /**
     * 新增卡片
     */
    public boolean addCardInfo(CardInfo cardInfo) {
        String content = cardInfo.getContent();
        if (StringUtils.isNotBlank(content)) {
            content = sensitiveWordsComponent.replaceSensitiveWords(cardInfo.getCommunityId(), content);
            cardInfo.setContent(content);
        }
        int i = cardInfoMapper.insertSelective(cardInfo);
        if (1 == i) {
            Integer pubToSquare = cardInfo.getPubToSquare() != null ? cardInfo.getPubToSquare() : 0;
            CardCount cardCount = new CardCount();
            cardCount.setId(cardInfo.getId());
            cardCount.setLikeCount(0L);
            cardCount.setUnlikeCount(0L);
            cardCount.setShareCount(0L);
            cardCount.setCommentCount(0L);
            int j = cardCountMapper.insert(cardCount);
            if (Constant.YesOrNo.YES.equals(pubToSquare)) {  //发送到首页
                insertHomeCardInfo(cardInfo);
            }
        }
        return i == 1;
    }


    public boolean pubToSquare(Long cardId, int pubToSquare) {
        Date now = new Date();
        CardInfo updateRecord = new CardInfo();
        updateRecord.setId(cardId);
        updateRecord.setPubToSquare(pubToSquare);
        updateRecord.setApplyTime(now);
        updateRecord.setSquareAuditStatus(CardInfoConstant.CardInfo.SquareAuditStatus.UNAUDIT);
        cardInfoMapper.updateByPrimaryKeySelective(updateRecord);
        if (Constant.YesOrNo.NO.equals(pubToSquare)) { //如果不发布到平台,从home_card_info表删除记录
            HomeCardInfo homeRecord = new HomeCardInfo();
            homeRecord.setId(cardId);
            homeRecord.setStatus(CardInfoConstant.CardInfo.Status.HIDDEN);
            homeRecord.setDeleteTime(new Date());
            homeCardInfoMapper.updateByPrimaryKeySelective(homeRecord);
        } else {
            CardInfo newCardInfo = cardInfoMapper.selectByPrimaryKey(cardId);
            if (!hasHomeCardInfo(newCardInfo.getId())) {
                insertHomeCardInfo(newCardInfo);
            }
        }
        return true;
    }

    /**
     * 删除卡片接口
     */
    public boolean deleteCardInfo(Long id) {
        Date now = new Date();
        CardInfo record = new CardInfo();
        record.setId(id);
        record.setStatus(CardInfoConstant.CardInfo.Status.DELETED);
        record.setAuditStatus(CardInfoConstant.CardInfo.AuditStatus.REPEAL);
        record.setSquareAuditStatus(CardInfoConstant.CardInfo.SquareAuditStatus.REPEAL);
        record.setUpdateTime(now);
        record.setDeleteTime(now);
        int i = cardInfoMapper.updateByPrimaryKeySelective(record);
        if (1 == i) {
            HomeCardInfo homeRecord = new HomeCardInfo();
            homeRecord.setId(id);
            homeRecord.setStatus(CardInfoConstant.CardInfo.Status.DELETED);
            homeCardInfoMapper.deleteByPrimaryKey(id);
        }
        return i == 1;
    }

    public CardInfoExt getCardInfo(Long id) {
        CardInfoExt cardInfoExt = new CardInfoExt();
        CardInfo record = cardInfoMapper.selectByPrimaryKey(id);
        if (null != record) {
            CardCategory cardCategory = cardComponent.getCardCategory(record.getCategoryId());
            CardCount cardCount = cardCountMapper.selectByPrimaryKey(id);
            BeanUtils.copyProperties(record, cardInfoExt);
            BeanUtils.copyProperties(cardCount, cardInfoExt);
            cardInfoExt.setAttachment(null);
            String attachment = record.getAttachment();
            List<Image> imageList = cardComponent.getImageListFromAttachment(attachment);
            Video video = cardComponent.getVideoFromAttachment(attachment);
            cardInfoExt.setImageList(imageList);
            cardInfoExt.setVideo(video);
            cardInfoExt.setCardCategoryName(cardCategory != null ? cardCategory.getName() : "");
            Community community = communityMapper.selectByPrimaryKey(record.getCommunityId());
            Area cityArea = areaComponent.getArea(community.getCityId());
            cardInfoExt.setCommunityName(community.getName());
            cardInfoExt.setCityId(cityArea.getId());
            cardInfoExt.setCityName(cityArea.getShortName());
        }
        return cardInfoExt;
    }

    public PageList<StoreCardInfoExt> getStoreCardInfoList(Long passportId, Integer serviceId,
                                                           Integer templateId, String serviceName, String merchantName, Integer pubToSquare,
                                                           Date startCreateTime, Date endCreateTime, Integer auditStatus,
                                                           Integer index, Integer size) {

        Map<String, Object> param = new HashMap<>();
        param.put("communityId", 500);

        if (null != templateId && 0 != templateId) {
            param.put("templateId", templateId);
        }
        if (null != serviceId && 0 != serviceId) {
            param.put("serviceId", serviceId);
            if (null != passportId && 0 != passportId) {
                param.put("passportId", passportId);
            }
        }
        if (StringUtils.isNotEmpty(serviceName)) {
            param.put("serviceName", "%" + serviceName + "%");
        }
        if (StringUtils.isNotEmpty(merchantName)) {
            param.put("merchantName", "%" + merchantName + "%");
        }
        if (-1 != pubToSquare) {
            param.put("pubToSquare", pubToSquare);
        }
        if (null != startCreateTime) {
            param.put("startCreateTime", startCreateTime);
        }
        if (null != endCreateTime) {
            param.put("endCreateTime", endCreateTime);
        }
        if (null != auditStatus && 0 != auditStatus) {
            param.put("auditStatus", auditStatus);
        }
        PageBounds pageBounds = new PageBounds(index, size);
        PageList<StoreCardInfoExt> pageList = extCardInfoMapper.pageByExample4Store(param, pageBounds);

        return pageList;
    }


    public boolean hasHomeCardInfo(Long id) {
        HomeCardInfoExample example = new HomeCardInfoExample();
        example.createCriteria().andIdEqualTo(id);
        long count = homeCardInfoMapper.countByExample(example);
        return count > 0;
    }

    public int insertHomeCardInfo(CardInfo cardInfo) {
        HomeCardInfo homeCardInfo = new HomeCardInfo();
        BeanUtils.copyProperties(cardInfo, homeCardInfo);
        homeCardInfo.setStatus(CardInfoConstant.CardInfo.Status.HIDDEN);
        int k = homeCardInfoMapper.insert(homeCardInfo);
        return k;
    }

    /**
     * 获取当月发布次数
     *
     * @param serviceId
     * @return
     */
    public long getCurrentMonthCount(Long passportId, Integer serviceId) {
        Map<String, Object> param = new HashMap<>();
        //获取当前月第一天：
        String firstDayStr = DateTimeUtils.formatDateTime(DateTimeUtils.getFirstDayOfMonth(new Date()));
        //DateTime.now().toString("yyyy-MM-01 00:00:00");
        Date firstDay = DateTimeUtils.parseDateTime(firstDayStr);

        param.put("subject_id", passportId);
        param.put("service_id", serviceId);
        param.put("create_time", DateTimeUtils.formatDateTime(firstDay));
        long cardCount = extCardInfoOpenMapper.countOperationByExample(param);
        return cardCount;
    }

    /**
     * 获取当天发布次数
     *
     * @param subjectId
     * @return
     */
    public long getCurrentDayCount(Long subjectId) {

        long current = System.currentTimeMillis();//当前时间毫秒数
        long zero = current / (1000 * 3600 * 24) * (1000 * 3600 * 24) - TimeZone.getDefault().getRawOffset();//今天零点零分零秒的毫秒数
        long twelve = zero + 24 * 60 * 60 * 1000 - 1;//今天23点59分59秒的毫秒数
        DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String zeroStr = sdf.format(zero);
        String twelveStr = sdf.format(twelve);

        CardInfoExample example = new CardInfoExample();
        example.createCriteria().andSubjectIdEqualTo(subjectId).andCreateTimeBetween(new Date(zeroStr), new Date(twelveStr));

        long cardCount = extCardInfoMapper.countOperationByExample(example);
        return cardCount;
    }
}
