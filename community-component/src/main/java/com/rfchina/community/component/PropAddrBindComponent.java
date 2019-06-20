package com.rfchina.community.component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rfchina.community.base.Result;
import com.rfchina.community.base.StatusCode;
import com.rfchina.community.entity.HouseType;
import com.rfchina.community.entity.PropHouse;
import com.rfchina.community.persistence.mapper.PropAddrBindMapper;
import com.rfchina.community.persistence.model.PropAddrBind;
import com.rfchina.community.persistence.model.PropAddrBindExample;
import okhttp3.*;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.paginator.model.PageList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 */
@Component
public class PropAddrBindComponent {

    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    static {
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    private final OkHttpClient OK_HTTP_CLIENT  = new OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .build();

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PropAddrBindMapper propAddrBindMapper;

    @Value("${property.payment.url:a}")
    private String paymentUrl;

    public Result<PageList<PropHouse>> getHousesList(Integer pageNum , Integer pageSize , Integer communityId , String keys , Integer type) {
        String url = paymentUrl + "getHousesList";
        RequestBody requestBody = new FormBody.Builder()
                .add("page_num", String.valueOf(pageNum))
                .add("page_size", String.valueOf(pageSize))
                .add("id", String.valueOf(communityId))
                .add("keys", StringUtils.defaultIfBlank(keys, ""))
                .add("type", String.valueOf(type))
                .build();
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        try {
            Response response = OK_HTTP_CLIENT.newCall(request).execute();
            if(response.isSuccessful()) {
                Result<PageList<PropHouse>> result = OBJECT_MAPPER.readValue(response.body().bytes(), new TypeReference<Result<PageList<PropHouse>>>() {});
                return result;
            }
        } catch (IOException e) {
            logger.error("Invoke [getHousesList] error", e);
        }
        return null;
    }

    public Result<List<HouseType>> getHousesType(Long communityId) {
        String url = paymentUrl + "getHousesType";
        RequestBody requestBody = new FormBody.Builder()
                .add("communityId", String.valueOf(communityId))
                .build();
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        try {
            Response response = OK_HTTP_CLIENT.newCall(request).execute();
            if(response.isSuccessful()) {
                Result<List<HouseType>> result = OBJECT_MAPPER.readValue(response.body().bytes(), new TypeReference<Result<List<HouseType>>>() {});
                return result;
            }
        } catch (IOException e) {
            logger.error("Invoke [getHousesType] error", e);
        }
        return null;
    }

    public List<PropAddrBind> getPropAddrBindList(List<Long> masterIdList) {
        if(CollectionUtils.isNotEmpty(masterIdList)) {
            PropAddrBindExample example= new PropAddrBindExample();
            example.createCriteria().andMasterIdIn(masterIdList);
            List<PropAddrBind> list = propAddrBindMapper.selectByExample(example);
            return list;
        }
        return Collections.emptyList();
    }

    public List<PropAddrBind> getPropAddrBindListByHouseIds(List<Long> houseIdList) {
        if(CollectionUtils.isNotEmpty(houseIdList)) {
            PropAddrBindExample example= new PropAddrBindExample();
            example.createCriteria().andHouseIdIn(houseIdList);
            List<PropAddrBind> list = propAddrBindMapper.selectByExample(example);
            return list;
        }
        return Collections.emptyList();
    }

    public List<PropAddrBind> getPropAddrBindList(Integer communityId) {
        if(null != communityId) {
            PropAddrBindExample example= new PropAddrBindExample();
            example.createCriteria().andCommunityIdEqualTo(communityId);
            List<PropAddrBind> list = propAddrBindMapper.selectByExample(example);
            return list;
        }
        return Collections.emptyList();
    }

    public PropAddrBind getPropAddrBind(Long masterId) {
        if(null != masterId) {
            PropAddrBindExample example= new PropAddrBindExample();
            example.createCriteria().andMasterIdEqualTo(masterId);
            List<PropAddrBind> list = propAddrBindMapper.selectByExample(example);
            return CollectionUtils.isNotEmpty(list)? list.get(0):null;
        }
        return null;
    }

    public PropAddrBind getPropAddrBind(Long masterId, List<PropAddrBind> list) {
        if(CollectionUtils.isNotEmpty(list) && null != masterId) {
            for(PropAddrBind item : list) {
                if(item.getMasterId().equals(masterId)) {
                    return item;
                }
            }
        }
        return null;
    }

    public PropHouse getPropHouse(Long houseId) {
        List<Long> houseIdList = new ArrayList<>();
        houseIdList.add(houseId);
        List<PropHouse> list = getPropHouseList(houseIdList, "");
        return CollectionUtils.isNotEmpty(list)? list.get(0):null;
    }

    public List<PropHouse> getPropHouseList(List<Long> houseIdList, String address) {
        if(CollectionUtils.isNotEmpty(houseIdList)) {
            Long[] idArray = new Long[houseIdList.size()];
            houseIdList.toArray(idArray);
            String joinStr = StringUtils.join(idArray, ",");
            String url = paymentUrl + "getHousesByIds";
            RequestBody requestBody = new FormBody.Builder()
                    .add("house_ids", joinStr)
                    .add("address", Optional.ofNullable(address).orElse(""))
                    .build();
            Request request = new Request.Builder()
                    .url(url)
                    .post(requestBody)
                    .build();
            try {
                Response response = OK_HTTP_CLIENT.newCall(request).execute();
                if(response.isSuccessful()) {
                    Result<List<PropHouse>> result = OBJECT_MAPPER.readValue(response.body().bytes(), new TypeReference<Result<List<PropHouse>>>() {});
                    Integer code =  result.getStatus();
                    if(StatusCode.SUCCESS.equals(code)) {
                        return result.getData();
                    }
                }
            } catch (IOException e) {
                logger.error("Invoke [getPropHouseList] error", e);
            }
        }
        return Collections.emptyList();
    }

    public PropHouse getPropHouse(Long houseId, List<PropHouse> list) {
        if(CollectionUtils.isNotEmpty(list) && null != houseId) {
            for(PropHouse item : list) {
                if(item.getId().equals(houseId)) {
                    return item;
                }
            }
        }
        return null;
    }
}
