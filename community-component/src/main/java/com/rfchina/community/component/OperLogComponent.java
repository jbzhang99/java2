package com.rfchina.community.component;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.rfchina.community.entity.LogItemEntity;
import com.rfchina.community.base.Constant;
import com.rfchina.community.persistence.mapper.SysFieldMapMapper;
import com.rfchina.community.persistence.mapper.SysOperLogMapper;
import com.rfchina.community.persistence.model.SysFieldMap;
import com.rfchina.community.persistence.model.SysFieldMapExample;
import com.rfchina.community.persistence.model.SysOperLog;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 */
@Component
public class OperLogComponent {

    public static final Logger LOGGER = LoggerFactory.getLogger(OperLogComponent.class);

    public static Map<String, String> DEFAULT_FIELD_MAP = new HashMap<>();
    static {
        DEFAULT_FIELD_MAP.put("createTime", "创建时间");
        DEFAULT_FIELD_MAP.put("comment", "评论");
        DEFAULT_FIELD_MAP.put("content", "内容");
        DEFAULT_FIELD_MAP.put("id", "ID");
        DEFAULT_FIELD_MAP.put("link", "链接");
        DEFAULT_FIELD_MAP.put("parentId", "父ID");
        DEFAULT_FIELD_MAP.put("phone", "手机号码");
        DEFAULT_FIELD_MAP.put("name", "名称");
        DEFAULT_FIELD_MAP.put("remark", "备注");
        DEFAULT_FIELD_MAP.put("sorting", "排序");
        DEFAULT_FIELD_MAP.put("status", "状态");
        DEFAULT_FIELD_MAP.put("tel", "固定电话");
        DEFAULT_FIELD_MAP.put("title", "标题");
        DEFAULT_FIELD_MAP.put("type", "类型");
        DEFAULT_FIELD_MAP.put("uid", "用户ID");
        DEFAULT_FIELD_MAP.put("updateTime", "修改时间");
    }

    public static class OperEvent {

    }

    public static final Cache<String, SysFieldMap> FIELD_MAP_CACHE = CacheBuilder.newBuilder()
            .expireAfterWrite(5, TimeUnit.MINUTES)
            .build();

    private static final String CACHE_KEY_FORMAT = "fm_%s_%s";

    @Autowired
    private SysFieldMapMapper sysFieldMapMapper;

    @Autowired
    private SysOperLogMapper sysOperLogMapper;


/*    @PostConstruct
    public void init() {
        loadIntoCache();
    }*/

    public String getName(String className, String field) {
        String cacheKey = String.format(CACHE_KEY_FORMAT, className, field);
        SysFieldMap cacheFieldMap = FIELD_MAP_CACHE.getIfPresent(cacheKey);
        if(null == cacheFieldMap) {
            cacheFieldMap = getSysFieldMap(className, field);
            if(null != cacheFieldMap) {
                FIELD_MAP_CACHE.put(cacheKey, cacheFieldMap);
            } else {
                return field;
            }
        }
        String name = null;
        if(Constant.YesOrNo.YES.equals(cacheFieldMap.getUseDefault())) {
            name = DEFAULT_FIELD_MAP.get(field);
        } else if(Constant.YesOrNo.NO.equals(cacheFieldMap.getUseDefault())) {
            name = cacheFieldMap.getName();
        }
        name = StringUtils.isNotBlank(name) ? name:field;
        return name;
    }

    /** 按照 KEY1:VALUE1, KEY2:VALUE2 分隔 */
    public <T> String translate(T item, String[] exclusiveFields) {
        Field[] fields = item.getClass().getDeclaredFields();
        if(ArrayUtils.isNotEmpty(fields)) {

        }
        return "";
    }

    protected void loadIntoCache() {
        SysFieldMapExample example = new SysFieldMapExample();
        List<SysFieldMap> list = sysFieldMapMapper.selectByExample(example);
        if(CollectionUtils.isNotEmpty(list)) {
            for(SysFieldMap item:list) {
                String cacheKey = String.format(CACHE_KEY_FORMAT, item.getClassName(), item.getField());
                FIELD_MAP_CACHE.put(cacheKey, item);
            }
        }
    }

    protected SysFieldMap getSysFieldMap(String className, String field) {
        SysFieldMapExample example = new SysFieldMapExample();
        example.createCriteria().andClassNameEqualTo(className)
                .andFieldEqualTo(field);
        List<SysFieldMap> list = sysFieldMapMapper.selectByExample(example);
        return CollectionUtils.isNotEmpty(list)? list.get(0):null;
    }

    public <T> void log(Integer appId, Integer communityId, String operIp, Date operTime, String event, Long operId, String operName, Long targetId, String targetName, String prvContent, String newContent) {
        SysOperLog record = new SysOperLog();
        record.setAppId(appId);
        record.setCommunityId(communityId==null? 0:communityId);
        record.setOperEvent(event);
        record.setOperId(operId);
        record.setOperName(operName);
        record.setOperIp(StringUtils.defaultIfBlank(operIp, ""));
        record.setOperContent(prvContent);
        record.setTargetId(targetId);
        record.setTargetName(targetName);
        record.setTargetContent(newContent);
        record.setOperTime(operTime);
        try {
            this.sysOperLogMapper.insertSelective(record);
        } catch (Exception ex) {
            LOGGER.info("Insert into sys_oper_log error", ex);
        }
    }

    public <T> void log(Integer appId, Integer communityId, String operIp, Date operTime, String event, Long operId, String operName, Long targetId, String targetName, LogItemEntity<T> previousLogItemEntity, LogItemEntity<T> newLogItemEntity) {
        if(null != previousLogItemEntity && null != newLogItemEntity) {

        }
        String prvLogStr = previousLogItemEntity!=null? StringUtils.join(previousLogItemEntity.getLogItemList(), ", "):"";
        String newLogStr = newLogItemEntity!=null? StringUtils.join(newLogItemEntity.getLogItemList(), ", "):"";
        this.log(appId, communityId, operIp, operTime, event, operId, operName, targetId, targetName, prvLogStr, newLogStr);
    }

    public <T> void log(Integer appId, Integer communityId, String operIp, Date operTime, String event, Long operId, String operName, Long targetId, String targetName, LogItemEntity<T> newLogItemEntity) {
        this.log(appId, communityId, operIp, operTime, event, operId, operName, targetId, targetName, null, newLogItemEntity);
    }
}
