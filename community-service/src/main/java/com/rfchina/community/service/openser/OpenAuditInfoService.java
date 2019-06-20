package com.rfchina.community.service.openser;

import com.rfchina.community.persistence.mapper.BaseMapper;
import com.rfchina.community.persistence.mapper.OpenAuditInfoMapper;
import com.rfchina.community.persistence.mapper.OpenMerchantInfoMapper;
import com.rfchina.community.persistence.model.OpenAuditInfo;
import com.rfchina.community.persistence.model.OpenAuditInfoExample;
import com.rfchina.community.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName OpenAuditInfoService
 * @Description 审核信息
 * @Author wlrllr
 * @Date 2018/12/25 11:38
 * @Version 1.0
 **/
@Service
public class OpenAuditInfoService extends AbstractService<OpenAuditInfo, OpenAuditInfoExample,Long> {

    @Autowired
    protected OpenAuditInfoMapper openAuditInfoMapper;

    @Override
    public BaseMapper<OpenAuditInfo, OpenAuditInfoExample, Long> getMapper() {
        return openAuditInfoMapper;
    }
}
