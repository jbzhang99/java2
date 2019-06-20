package com.rfchina.community.openweb.component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.rfchina.community.base.Constant;
import com.rfchina.community.base.constant.CardInfoConstant;
import com.rfchina.community.base.util.DateTimeUtils;
import com.rfchina.community.openweb.entity.Image;
import com.rfchina.community.openweb.entity.Video;
import com.rfchina.community.persistence.mapper.CardCategoryMapper;
import com.rfchina.community.persistence.mapper.CardCountMapper;
import com.rfchina.community.persistence.mapper.CardInfoMapper;
import com.rfchina.community.persistence.mapper.HomeCardInfoMapper;
import com.rfchina.community.persistence.model.*;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.*;

/**
 */
@Component
public class CardComponent {

    public final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private CardCountMapper cardCountMapper;

    @Autowired
    private CardCategoryMapper cardCategoryMapper;

    @Autowired
    private CardInfoMapper cardInfoMapper;

    @Autowired
    private HomeCardInfoMapper homeCardInfoMapper;

    public CardInfo getCardInfo(Long id) {
        return cardInfoMapper.selectByPrimaryKey(id);
    }

    public boolean setDeleted(Long id) {
        CardInfo record = new CardInfo();
        record.setId(id);
        record.setStatus(CardInfoConstant.CardInfo.Status.DELETED);
        record.setAuditStatus(CardInfoConstant.CardInfo.AuditStatus.REPEAL);
        record.setSquareAuditStatus(CardInfoConstant.CardInfo.SquareAuditStatus.REPEAL);
        int i = cardInfoMapper.updateByPrimaryKeySelective(record);
        if (i == 1) {
            HomeCardInfo updateHomeCardInfo = new HomeCardInfo();
            updateHomeCardInfo.setId(id);
            updateHomeCardInfo.setStatus(CardInfoConstant.CardInfo.Status.DELETED);
            int j = homeCardInfoMapper.updateByPrimaryKeySelective(updateHomeCardInfo);
            logger.info("Delete from home_card_info for id[{}], and result[{}]", id, j);
        }
        return i == 1;
    }

    public boolean setHidden(Long id) {
        CardInfo record = new CardInfo();
        record.setId(id);
        record.setStatus(CardInfoConstant.CardInfo.Status.HIDDEN);
        record.setAuditStatus(CardInfoConstant.CardInfo.AuditStatus.REPEAL);
        record.setSquareAuditStatus(CardInfoConstant.CardInfo.SquareAuditStatus.REPEAL);
        int i = cardInfoMapper.updateByPrimaryKeySelective(record);
        if (i == 1) {
            HomeCardInfo updateHomeCardInfo = new HomeCardInfo();
            updateHomeCardInfo.setId(id);
            updateHomeCardInfo.setStatus(CardInfoConstant.CardInfo.Status.HIDDEN);
            int j = homeCardInfoMapper.updateByPrimaryKeySelective(updateHomeCardInfo);
            logger.info("Set hidden for home_card_info for id[{}], and result[{}]", id, j);
        }
        return i == 1;
    }

    /*
     * public List<CardCategory> getFixedCardCategory(Integer communityId) {
     * String cacheKey = FIXED_CARD_CATEGORY_CACHE_KEY; List<CardCategory> list
     * = CARD_CATEGORY_CACHE.getIfPresent(cacheKey);
     * if(CollectionUtils.isEmpty(list)) { List<Integer> typeList = new
     * ArrayList<>();
     * typeList.add(CardInfoConstant.CardCategory.Type.FIXED_NOTICE_CATEGORY);
     * typeList.add(CardInfoConstant.CardCategory.Type.FIXED_EVENT_CATEGORY);
     * CardCategoryExample example = new CardCategoryExample();
     * example.createCriteria().andTypeIn(typeList)
     * .andStatusEqualTo(CardInfoConstant.CardCategory.Type.ENABLE)
     * .andCommunityIdEqualTo(communityId); list =
     * cardCategoryMapper.selectByExample(example);
     * if(CollectionUtils.isNotEmpty(list)) { CARD_CATEGORY_CACHE.put(cacheKey,
     * list); } } return list; }
     */

    public List<CardCategory> getCustomCardCategory(Integer communityId) {
        CardCategoryExample example = new CardCategoryExample();
        example.createCriteria().andTypeEqualTo(CardInfoConstant.CardCategory.Type.CUSTOM_CATEGORY).andStatusEqualTo(CardInfoConstant.CardCategory.Status.ENABLE)
                .andCommunityIdEqualTo(communityId);
        List<CardCategory> list = cardCategoryMapper.selectByExample(example);
        return list;
    }

    public CardCategory getCardCategory(Integer id) {
        CardCategory record = cardCategoryMapper.selectByPrimaryKey(id);
        return record;
    }

    public CardCount getCardCount(Long id) {
        CardCount record = cardCountMapper.selectByPrimaryKey(id);
        return record;
    }

    public Video getVideoFromAttachment(String attachment) {
        if (StringUtils.isNotBlank(attachment) && attachment.contains("videoUrl")) {
            try {
                JSONObject attachementJSON = JSON.parseObject(attachment);
                JSONObject videoObject = attachementJSON.getJSONObject("video");
                if (null != videoObject) {
                    Video video = new Video();
                    video.setVideoUrl(videoObject.getString("videoUrl"));
                    video.setImgUrl(videoObject.getString("imgUrl"));
                    video.setThumbImgUrl(videoObject.getString("imgUrl"));
                    video.setVideoType(Video.Type.MP4);
                    return video;
                }
            } catch (Exception e) {
                logger.error("Parse attachment JSON error for video", e);
            }
        }
        return null;
    }

    public List<Image> getImageListFromAttachment(String attachment) {
        List<Image> list = new ArrayList<>();
        if (StringUtils.isNotBlank(attachment)) {
            if (StringUtils.isNotBlank(attachment)) {
                try {
                    JSONObject attachementJSON = JSON.parseObject(attachment);
                    JSONArray imageArray = attachementJSON.getJSONArray("images");
                    if (CollectionUtils.isNotEmpty(imageArray)) {
                        for (int j = 0; j < imageArray.size(); j++) {
                            String imgUrl = imageArray.getString(j);
                            Image image = new Image();
                            image.setImgUrl(imgUrl);
                            list.add(image);
                        }
                    }
                } catch (Exception e) {
                    logger.error("Parse attachment JSON error for image list", e);
                }
            }
        }
        return list;
    }

    public int getImageNumFromAttachment(String attachment) {
        if (StringUtils.isNotBlank(attachment)) {
            try {
                JSONObject jsonObject = JSON.parseObject(attachment);
                JSONArray array = jsonObject.getJSONArray("images");
                return array != null ? array.size() : 0;
            } catch (Exception e) {
                logger.error("Parse json from attachment error", e);
            }
        }
        return 0;
    }

    public String attachmentJsonToArrayString(String attachment) {
        List<String> list = new ArrayList<>();
        if (StringUtils.isNotBlank(attachment)) {
            if (StringUtils.isNotBlank(attachment)) {
                try {
                    JSONObject attachementJSON = JSON.parseObject(attachment);
                    JSONArray imageArray = attachementJSON.getJSONArray("images");
                    if (CollectionUtils.isNotEmpty(imageArray)) {
                        for (int j = 0; j < imageArray.size(); j++) {
                            String imgUrl = imageArray.getString(j);
                            list.add(imgUrl);
                        }
                    }
                } catch (Exception e) {
                    logger.error("Parse attachment JSON error", e);
                }
            }
        }
        return CollectionUtils.isNotEmpty(list) ? StringUtils.join(list, ",") : "";
    }

    public Map<Long, CardInfo> getCardInfoMap(List<Long> idList) {
        if (CollectionUtils.isEmpty(idList)) {
            return Collections.emptyMap();
        }
        CardInfoExample example = new CardInfoExample();
        example.createCriteria().andIdIn(idList);
        List<CardInfo> cardInfoList = cardInfoMapper.selectByExample(example);
        Map<Long, CardInfo> resultMap = new HashMap<>();
        if (CollectionUtils.isNotEmpty(cardInfoList)) {
            for (CardInfo item : cardInfoList) {
                resultMap.put(item.getId(), item);
            }
        }
        return resultMap;
    }

    public boolean addFixedCardCaregory(String categoryName,int communityId,String createTime){
        boolean success = false;
        CardCategory noticeCardCaregory = new CardCategory();
        noticeCardCaregory.setCommunityId(communityId);
        noticeCardCaregory.setParentId(Constant.DEFAULT_ROOT_ID_INTEGER);
        noticeCardCaregory.setTemplateId(CardInfoConstant.CardTemplate.BASE_TEMPLTE_ID);
        noticeCardCaregory.setName(categoryName);
        noticeCardCaregory.setStatus(CardInfoConstant.CardCategory.Status.ENABLE);
        noticeCardCaregory.setType(CardInfoConstant.CardCategory.Type.FIXED_CATEGORY);
        if (StringUtils.isNotBlank(createTime)) {
            noticeCardCaregory.setCreateTime(DateTimeUtils.parseDateTime(createTime));
        }
        noticeCardCaregory.setSorting(1);
        int m = cardCategoryMapper.insert(noticeCardCaregory);
        if(m > 0){
            success = true;
        }
        return success;
    }
}
