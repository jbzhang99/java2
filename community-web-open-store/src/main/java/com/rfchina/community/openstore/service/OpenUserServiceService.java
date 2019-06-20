package com.rfchina.community.openstore.service;

import com.rfchina.community.persistence.mapper.OpenUserServiceMapper;
import com.rfchina.community.persistence.model.OpenUserService;
import com.rfchina.community.persistence.model.OpenUserServiceKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OpenUserServiceService {

    @Autowired
    private OpenUserServiceMapper openUserServiceMapper;
    

    public void insertOrUpdate(Integer serviceId, Long uid, Integer commId) {
        // 记录最后一次
        OpenUserServiceKey key = new OpenUserServiceKey();
        key.setServiceId(serviceId);
        key.setUid(uid);
        OpenUserService ous = openUserServiceMapper.selectByPrimaryKey(key);
        if (ous == null) {
            // 新增最后登录急了
            ous = new OpenUserService();
            ous.setLastUseCommunityId(commId);
            ous.setServiceId(serviceId);
            ous.setUid(uid);
            openUserServiceMapper.insertSelective(ous);
        } else {
            // 修改 最后登录
            ous = new OpenUserService();
            ous.setLastUseCommunityId(commId);
            ous.setServiceId(serviceId);
            ous.setUid(uid);
            openUserServiceMapper.updateByPrimaryKeySelective(ous);
        }
    }
}
