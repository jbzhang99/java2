package com.rfchina.community.service.openser;

import com.rfchina.community.persistence.mapper.BaseMapper;
import com.rfchina.community.persistence.mapper.OpenStoreGoodOrderRelMapper;
import com.rfchina.community.persistence.model.OpenStoreGoodOrderRel;
import com.rfchina.community.persistence.model.OpenStoreGoodOrderRelExample;
import com.rfchina.community.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName OpenStoreGoodOrderRelBaseService
 * @Author wlrllr
 * @Date 2019/3/26 10:38
 * @Version 1.0
 **/
@Service
public class OpenStoreGoodOrderRelBaseService extends AbstractService<OpenStoreGoodOrderRel, OpenStoreGoodOrderRelExample,Integer> {

    @Autowired
    protected OpenStoreGoodOrderRelMapper mapper;

    @Override
    public BaseMapper<OpenStoreGoodOrderRel, OpenStoreGoodOrderRelExample, Integer> getMapper() {
        return mapper;
    }

    /**
     * @Description: 获取订单中商品的详情
     * @return List<OpenStoreGoodOrderRel>
     * @throws
     */
    public List<OpenStoreGoodOrderRel> getList(int orderId) {
        OpenStoreGoodOrderRelExample example = new OpenStoreGoodOrderRelExample();
        example.createCriteria().andOrderIdEqualTo(orderId);

        return mapper.selectByExample(example);
    }

}
