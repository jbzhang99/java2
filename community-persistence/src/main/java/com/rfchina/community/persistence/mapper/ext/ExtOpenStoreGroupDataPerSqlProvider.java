package com.rfchina.community.persistence.mapper.ext;

import com.rfchina.community.persistence.mapper.OpenStoreGroupDataSqlProvider;

import java.util.Map;

/**
 */
public class ExtOpenStoreGroupDataPerSqlProvider extends OpenStoreGroupDataSqlProvider {

	public String lockGroupDataUsableNum(Map<String, Object> param) {
		StringBuilder sb = new StringBuilder("update open_store_group_data set usable_num=usable_num-#{decNum}, lock_num=lock_num+#{decNum}");
		sb.append(" where id=#{groupDataId}");
		sb.append(" and usable_num >= #{decNum}");
		return sb.toString();
	}
}
