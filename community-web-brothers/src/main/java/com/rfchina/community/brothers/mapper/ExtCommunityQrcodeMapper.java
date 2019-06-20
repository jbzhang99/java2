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

public interface ExtCommunityQrcodeMapper extends Serializable {

	@Select({
			"select c.id from community c left join community_qrcode_info i on c.id=i.community_id where i.other_community is null; " })
	public List<Integer> communityNotCom();

	@Select({
			"select other_community from community_qrcode_info ORDER BY other_community desc limit 1; " })
	public Integer communityQrcodeLimit();

	@Select({
			"select c.id from community c left join visit_community v on c.id=v.community_id where v.community_id is null; " })
	public List<Integer> communityNotVisit();

}