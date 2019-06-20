package com.rfchina.community.service.openser;

import com.rfchina.community.persistence.mapper.BaseMapper;
import com.rfchina.community.persistence.mapper.OpenManagerInviteMapper;
import com.rfchina.community.persistence.model.OpenManagerInvite;
import com.rfchina.community.persistence.model.OpenManagerInviteExample;
import com.rfchina.community.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName OpenAuditInfoService
 * @Description 审核信息
 * @Author wlrllr
 * @Date 2018/12/25 11:38
 * @Version 1.0
 **/
@Service
public class OpenManagerInviteService extends AbstractService<OpenManagerInvite, OpenManagerInviteExample,Long> {

    @Autowired
    protected OpenManagerInviteMapper mapper;

    @Override
    public BaseMapper<OpenManagerInvite, OpenManagerInviteExample, Long> getMapper() {
        return mapper;
    }

    public OpenManagerInvite getbyMerchantId(Long merchantId){
         OpenManagerInviteExample example = new OpenManagerInviteExample();
         example.createCriteria().andMerchantIdEqualTo(merchantId);
         List<OpenManagerInvite> openManagerInviteList = selectByExample(example);
         if(openManagerInviteList != null && openManagerInviteList.size()>0){
             return openManagerInviteList.get(0);
         }
         return new OpenManagerInvite();
    }
}
