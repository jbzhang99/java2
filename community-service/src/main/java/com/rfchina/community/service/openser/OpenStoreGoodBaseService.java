package com.rfchina.community.service.openser;

import com.rfchina.community.persistence.mapper.BaseMapper;
import com.rfchina.community.persistence.mapper.OpenStoreGoodMapper;
import com.rfchina.community.persistence.model.OpenStoreGood;
import com.rfchina.community.persistence.model.OpenStoreGoodExample;
import com.rfchina.community.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName OpenStoreGoodBaseService
 * @Description 店铺商品service
 * @Author wlrllr
 * @Date 2018/12/25 11:38
 * @Version 1.0
 **/
@Service
public class OpenStoreGoodBaseService extends AbstractService<OpenStoreGood, OpenStoreGoodExample,Integer> {

    @Autowired
    protected OpenStoreGoodMapper mapper;

    @Override
    public BaseMapper<OpenStoreGood, OpenStoreGoodExample,Integer> getMapper() {
        return mapper;
    }

    public List<OpenStoreGood> getGoodsByIds(List<Integer> goodsIds){
        if(goodsIds != null && goodsIds.size()>0){
            OpenStoreGoodExample example = new OpenStoreGoodExample();
            example.createCriteria().andIdIn(goodsIds);
            return selectByExample(example);
        }
        return null;
    }
}
