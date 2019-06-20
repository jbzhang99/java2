package com.rfchina.community.open.bridge.mapper.ext;

import java.io.Serializable;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;

public interface ExtOpenStoreGoodBridgeMapper extends Serializable {
	
	@SelectProvider(type=ExtOpenStoreGoodBridgeSqlProvider.class, method="listStoreGood")
	public PageList<Map<String,Object>> listStoreGood( Map<String, Object> param , PageBounds pageBounds);
	
}