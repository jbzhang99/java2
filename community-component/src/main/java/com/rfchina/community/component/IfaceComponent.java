package com.rfchina.community.component;

import com.rfchina.community.persistence.mapper.IfaceLogMapper;
import com.rfchina.community.persistence.model.IfaceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 */
public class IfaceComponent {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    protected IfaceLogMapper ifaceLogMapper;

    protected void saveIfaceLog(String targetUrl, String reqBody, String rspBody) {
        try {
            IfaceLog record = new IfaceLog();
            record.setTargetUrl(targetUrl);
            record.setReqBody(reqBody);
            record.setRspBody(rspBody);
            record.setCreateTime(new Date());
            ifaceLogMapper.insert(record);
        } catch (Exception e) {
            logger.info("Insert into iface_log error", e);
        }
    }
}
