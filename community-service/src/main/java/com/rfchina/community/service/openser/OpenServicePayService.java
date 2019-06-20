package com.rfchina.community.service.openser;

import com.rfchina.community.persistence.mapper.OpenServicePayMapper;
import com.rfchina.community.persistence.model.OpenServicePay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OpenServicePayService {

    @Autowired
    private OpenServicePayMapper openServicePayMapper;


    public OpenServicePay getOpenServicePay(Integer serviceId) {
        return openServicePayMapper.selectByPrimaryKey(serviceId);
    }


    public int updateOpenServicePay(OpenServicePay record) {
        return openServicePayMapper.updateByPrimaryKeySelective(record);
    }

    public int insertOrUpdate(OpenServicePay data) {
        OpenServicePay pay = getOpenServicePay(data.getServiceId());
        if (pay == null) {
            return insert(data);
        } else {
            return updateOpenServicePay(data);
        }

    }


    public int insert(OpenServicePay data) {
        return openServicePayMapper.insertSelective(data);
    }

    public int insert(Integer serviceId, BigDecimal platformFee, BigDecimal communityRate, BigDecimal thinkRate) {
        OpenServicePay data = new OpenServicePay();
        data.setCommunityRate(communityRate);
        data.setPlatformFee(platformFee);
        data.setServiceId(serviceId);
        data.setThinkRate(thinkRate);
        return insert(data);
    }


}
