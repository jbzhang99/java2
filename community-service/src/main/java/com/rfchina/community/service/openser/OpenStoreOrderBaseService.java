package com.rfchina.community.service.openser;

import com.rfchina.community.persistence.mapper.BaseMapper;
import com.rfchina.community.persistence.mapper.OpenStoreOrderMapper;
import com.rfchina.community.persistence.model.OpenStoreOrder;
import com.rfchina.community.persistence.model.OpenStoreOrderExample;
import com.rfchina.community.service.AbstractService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserCommentService
 * @Description 用户评价接口
 * @Author wlrllr
 * @Date 2019/2/18 9:44
 * @Version 1.0
 **/
@Service
public class OpenStoreOrderBaseService extends AbstractService<OpenStoreOrder, OpenStoreOrderExample, Long> {

    @Autowired
    private OpenStoreOrderMapper openStoreOrderMapper;

    @Override
    public BaseMapper<OpenStoreOrder, OpenStoreOrderExample, Long> getMapper() {
        return openStoreOrderMapper;
    }

    public OpenStoreOrder findByOutTradeNo(String outTradeNo){
        if(StringUtils.isNotBlank(outTradeNo)){
            OpenStoreOrderExample example = new OpenStoreOrderExample();
            example.createCriteria().andOutTradeNoEqualTo(outTradeNo);
            List<OpenStoreOrder> openStoreOrders =  openStoreOrderMapper.selectByExample(example);
            if(openStoreOrders != null && openStoreOrders.size()>0){
                return openStoreOrders.get(0);
            }
        }
        return null;
    }
}
