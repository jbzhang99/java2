package com.rfchina.community.openstore.service;

import java.util.Date;
import java.util.List;

import com.rfchina.community.persistence.mapper.ext.ExtAreaMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rfchina.community.base.Constant;
import com.rfchina.community.base.OpenConstant.AddressManageDefaultStatus;
import com.rfchina.community.base.util.AddrUtils;
import com.rfchina.community.component.AreaComponent;
import com.rfchina.community.openstore.entity.ext.AuthAddress;
import com.rfchina.community.openstore.mapper.ext.ExtMasterChild2Mapper;
import com.rfchina.community.persistence.mapper.AddressManageMapper;
import com.rfchina.community.persistence.mapper.AreaMapper;
import com.rfchina.community.persistence.mapper.CommunityMapper;
import com.rfchina.community.persistence.model.AddressManage;
import com.rfchina.community.persistence.model.AddressManageExample;
import com.rfchina.community.persistence.model.Community;

@Service
public class AddressManageService extends BaseService{

    @Autowired
    private AddressManageMapper addressManageMapper;
    @Autowired
    private ExtMasterChild2Mapper extMasterChild2Mapper;
	@Autowired
	private ExtAreaMapper areaMapper;
    @Autowired
    private AreaComponent areaComponent;
    @Autowired
    private CommunityMapper communityMapper;
    
    /**
	 * 我的收货地址列表
	 */
    public List<AddressManage> list(long uid){
    	AddressManageExample example = new AddressManageExample();
    	example.createCriteria().andUidEqualTo(uid);
    	example.setOrderByClause("default_status desc, update_time desc");
    	return addressManageMapper.selectByExample(example);
    }
	
	/**
	 * 我的认证地址列表
	 */
    public List<AuthAddress> listAuthAddress(long uid){
    	List<AuthAddress> list = extMasterChild2Mapper.listAuthAddress(uid);
    	for(AuthAddress auth : list) {
    		com.rfchina.community.persistence.model.Area area = areaMapper.selectByPrimaryKey(auth.getCityId());
    		auth.setProvinceId(area == null ? 0 : area.getParentId());
    		Community community = communityMapper.selectByPrimaryKey(auth.getCommunityId());
            String cityName = areaComponent.getAreaShortName(community.getCityId());
            String companyName = Constant.MasterInfo.Type.COMPANY.equals(auth.getType()) ? auth.getTitle() : "";
            String roomName = AddrUtils.createForCert(cityName, community.getName(), auth.getLoudong(), auth.getFloor(), auth.getRoom(), companyName);
            auth.setAddress(community.getAddress() + roomName);
    	}
    	return list;
    }
	
	/**
	 * 新增收货地址
	 */
    public void insert(long uid, int provinceId, int cityId, int areaId, String addrDetail, String userName,
    		String phone) {
    	
    	AddressManage record = new AddressManage();
    	record.setUid(uid);
    	record.setProvinceId(provinceId);
    	record.setCityId(cityId);
    	record.setAreaId(areaId);
    	record.setAddrDetail(addrDetail);
    	record.setUserName(userName);
    	record.setPhone(phone);
    	record.setCreateTime(new Date());
    	record.setUpdateTime(record.getCreateTime());
    	com.rfchina.community.persistence.model.Area area = areaMapper.selectByPrimaryKey(areaId);
    	validator(area == null, "该地址不存在");
    	record.setMergerName(areaComponent.getMergerName(provinceId, cityId, areaId));
    	AddressManage defaultRecord = this.getDefaultAddress(uid);
    	record.setDefaultStatus(defaultRecord == null ? AddressManageDefaultStatus.default_status : AddressManageDefaultStatus.no_default_status);
    	addressManageMapper.insertSelective(record);
    }
	
	/**
	 * 修改收货地址
	 */
    public void modify(long id, int provinceId, int cityId, int areaId, String addrDetail, String userName,
    		String phone) {
    	AddressManage domain = addressManageMapper.selectByPrimaryKey(id);
    	validator(domain == null, "该地址不存在");
    	if(areaId != domain.getAreaId()) {
    		com.rfchina.community.persistence.model.Area area = areaMapper.selectByPrimaryKey(areaId);
    		validator(area == null, "该地址不存在");
    		domain.setMergerName(areaComponent.getMergerName(provinceId, cityId, areaId));
    	}
    	domain.setProvinceId(provinceId);
		domain.setCityId(cityId);
		domain.setAreaId(areaId);
    	domain.setAddrDetail(addrDetail);
    	domain.setUserName(userName);
    	domain.setPhone(phone);
    	domain.setUpdateTime(new Date());
    	addressManageMapper.updateByPrimaryKeySelective(domain);
    }
	
	/**
	 * 删除收货地址
	 */
    public void delete(long id, long uid) {
    	addressManageMapper.deleteByPrimaryKey(id);
    	
    	List<AddressManage> list = this.list(uid);
    	if(!list.isEmpty()) {
    		AddressManage address = list.get(0);
    		//设置第一个为默认
    		address.setDefaultStatus(AddressManageDefaultStatus.default_status);
    		address.setUpdateTime(new Date());
        	addressManageMapper.updateByPrimaryKeySelective(address);
    	}
    }
	
	/**
	 * 设置默认收货地址
	 */
    public void setDefaultStatus(long id) {
    	AddressManage domain = addressManageMapper.selectByPrimaryKey(id);
    	
    	//其他的地址设置为非默认
    	AddressManageExample example = new AddressManageExample();
    	example.createCriteria().andUidEqualTo(domain.getUid());
    	AddressManage record = new AddressManage();
    	record.setDefaultStatus(AddressManageDefaultStatus.no_default_status);
    	addressManageMapper.updateByExampleSelective(record, example);
    	
    	//设置默认
    	domain.setDefaultStatus(AddressManageDefaultStatus.default_status);
    	domain.setUpdateTime(new Date());
    	addressManageMapper.updateByPrimaryKeySelective(domain);
    }
	
	/**
	 * 获取默认收货地址
	 */
    public AddressManage getDefaultAddress(long uid) {
    	AddressManageExample example = new AddressManageExample();
    	example.createCriteria().andUidEqualTo(uid).andDefaultStatusEqualTo(AddressManageDefaultStatus.default_status);
    	
    	List<AddressManage> list = addressManageMapper.selectByExample(example);
    	if(list.isEmpty())
    		return null;
    	return list.get(0);
    }
    
    
}
