package com.rfchina.community.brothers.mapper;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import com.rfchina.community.persistence.model.MasterChild;

public interface ExtMasterChildSelectMapper extends Serializable {

	@Select({ "select count(*) from master_child m " + " JOIN master_info i on m.master_id=i.id "
			+ " JOIN community c on c.id=i.community_id " + " where c.`status`=1 and  i.`status`=1 "
			+ " and m.`status`=1 and m.phone=#{phone}  " })
	public Long isMasterChildByPhone(@Param("phone") String phone);

	@Select({ "select count(*) from master_child m " + " JOIN master_info i on m.master_id=i.id "
			+ " JOIN community c on c.id=i.community_id " + " where c.`status`=1 and  i.`status`=1 "
			+ " and m.`status`=1 and m.phone=#{phone} and c.area_id in(${area_id})  " })
	public Long isMasterChildByPhoneArea(@Param("phone") String phone, @Param("area_id") String area_id);

}