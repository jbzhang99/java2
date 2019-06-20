package com.rfchina.community.openweb.mapper.ext;

import com.rfchina.community.persistence.model.CardInfoOpenRelaExample;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.Map;

/**
 */
public interface ExtCardInfoOpenMapper {

    @SelectProvider(type=ExtCardInfoOpenSqlProvider.class, method="countOperationByExample")
    long countOperationByExample(Map<String, Object> param);


}
