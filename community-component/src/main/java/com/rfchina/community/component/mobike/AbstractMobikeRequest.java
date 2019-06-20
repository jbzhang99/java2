package com.rfchina.community.component.mobike;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 */
abstract class AbstractMobikeRequest implements Serializable {

    protected String accesstoken;

    public String getAccesstoken() {
        return accesstoken;
    }

    public void setAccesstoken(String accesstoken) {
        this.accesstoken = accesstoken;
    }

    public String sign() {
        Set<Map.Entry<String, String>> entrySet = toMap().entrySet();
        List<String> list = new ArrayList<>();
        for(Map.Entry<String, String> entry: entrySet) {
            String key = entry.getKey();
            String value = entry.getValue();
            if(StringUtils.isNotBlank(value)) {
                list.add(key + "=" + value);
            }
        }
        String joinString = StringUtils.join(list, "&");
        String signString = StringUtils.lowerCase( DigestUtils.md5Hex(joinString));
        return signString;
    }

    public abstract Map<String, String> toMap();
}
