package com.rfchina.community.service.openser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rfchina.community.persistence.mapper.OpenServiceDetailTabMapper;
import com.rfchina.community.persistence.model.OpenServiceDetailTabExample;
import com.rfchina.community.persistence.model.OpenServiceDetailTabKey;
import com.rfchina.community.service.openser.entity.OpenServiceDetailTab;

@Service
public class OpenServiceDetailTabService {

	@Autowired
	private OpenServiceDetailTabMapper openServiceDetailTabMapper;
	//platfrom_winter_term(4, "平台拎包入住"),service_winter_term(5, "物业拎包入住")zizai_e(6, "自在e站");
	public static List<Integer> setList = Arrays.asList(4, 5, 6);
	
	
	public List<OpenServiceDetailTab> getTabs(int serviceId) {
		OpenServiceDetailTabExample example = new OpenServiceDetailTabExample();
		example.createCriteria().andServiceIdEqualTo(serviceId);
		List<OpenServiceDetailTabKey> list = openServiceDetailTabMapper.selectByExample(example);
		return this.domainList2VoList(list);
	}
	
	private List<OpenServiceDetailTab> domainList2VoList(List<OpenServiceDetailTabKey> list){
		 List<OpenServiceDetailTab> tabList = new ArrayList<>();
		for(OpenServiceDetailTabKey key : list) {
			OpenServiceDetailTab tab = new OpenServiceDetailTab();
			BeanUtils.copyProperties(key, tab);
			tab.setTypeName(com.rfchina.community.base.OpenConstant.OpenServiceDetailTab.getTabName(key.getType()));
			tabList.add(tab);
		}
		return tabList;
	}

	public void saveServiceTabs(String types, int serviceId) {
		//原来的全部删除
		this.deleteServiceTabs(serviceId);
		//新增对应的tab
		if(StringUtils.isBlank(types))
			return;
		
		String[] typeStr = types.split(",");
		for(String type : typeStr) {
			OpenServiceDetailTabKey key = new OpenServiceDetailTabKey();
			key.setServiceId(serviceId);
			key.setType(Integer.parseInt(type));
			if(setList.contains(key.getType())) {
				openServiceDetailTabMapper.insertSelective(key);
			}
		}
		
	}
	
	private void deleteServiceTabs(int serviceId) {
		OpenServiceDetailTabExample example = new OpenServiceDetailTabExample();
		example.createCriteria().andServiceIdEqualTo(serviceId).andTypeIn(setList);
		openServiceDetailTabMapper.deleteByExample(example);
	}

	
	public void insert(int code, Integer serviceId) {
		OpenServiceDetailTabKey key = new OpenServiceDetailTabKey();
		key.setServiceId(serviceId);
		key.setType(code);
		openServiceDetailTabMapper.insertSelective(key);
	}
}
