package com.rfchina.community.openweb.service;

import com.rfchina.community.openweb.mapper.ext.ExtCommunityServiceRelaMapper;
import com.rfchina.community.persistence.mapper.CommunityServiceRelaMapper;
import com.rfchina.community.persistence.mapper.CommunityServiceRelaTempMapper;
import com.rfchina.community.persistence.model.*;
import com.rfchina.community.persistence.model.CommunityServiceRelaExample.Criteria;
import com.rfchina.community.persistence.model.ext.ExtCommunityServiceRela;
import org.apache.commons.beanutils.BeanUtils;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

@Service
public class CommunityServiceRelaService {

	private static Logger logger = LoggerFactory.getLogger(CommunityServiceRelaService.class);

	@Autowired
	private CommunityServiceRelaTempMapper communityServiceRelaTempMapper;

	@Autowired
	private CommunityServiceRelaMapper communityServiceRelaMapper;

	@Autowired
	private ExtCommunityServiceRelaMapper extCommunityServiceRelaMapper;

	@Autowired
	private OpenServiceAreaService openServiceAreaService;

	public void addCommunityServiceRelaTemp(CommunityServiceRelaTemp communityServiceRelaTemp) {
		communityServiceRelaTempMapper.insertSelective(communityServiceRelaTemp);
	}

	public List<CommunityServiceRelaTemp> getCommunityServiceRelaTempList(int serviceId) {
		CommunityServiceRelaTempExample example = new CommunityServiceRelaTempExample();
		example.createCriteria().andServiceIdEqualTo(serviceId);
		return communityServiceRelaTempMapper.selectByExample(example);
	}

	public void updateCommunityServiceRelaTemp(CommunityServiceRelaTemp communityServiceRelaTemp) {
		communityServiceRelaTempMapper.updateByPrimaryKeySelective(communityServiceRelaTemp);
	}

	public void deleteCommunityServiceRela(int serviceId) {
		CommunityServiceRelaExample example = new CommunityServiceRelaExample();
		example.createCriteria().andServiceIdEqualTo(serviceId);
		communityServiceRelaMapper.deleteByExample(example);
	}

	public void deleteCommunityServiceRelaTemp(int serviceId) {
		CommunityServiceRelaTempExample example = new CommunityServiceRelaTempExample();
		example.createCriteria().andServiceIdEqualTo(serviceId);
		communityServiceRelaTempMapper.deleteByExample(example);
	}

	public void addCommunityServiceRela(CommunityServiceRela communityServiceRela) {
		communityServiceRelaMapper.insertSelective(communityServiceRela);
	}

	public CommunityServiceRela getCommunityServiceRela(int serviceId, int communityId) {

		CommunityServiceRelaKey communityServiceRelaKey = new CommunityServiceRelaKey();
		communityServiceRelaKey.setCommunityId(communityId);
		communityServiceRelaKey.setServiceId(serviceId);

		return communityServiceRelaMapper.selectByPrimaryKey(communityServiceRelaKey);
	}

	public CommunityServiceRelaTemp getCommunityServiceRelaTemp(int serviceId, int communityId) {

		CommunityServiceRelaTempKey communityServiceRelaTempKey = new CommunityServiceRelaTempKey();
		communityServiceRelaTempKey.setCommunityId(communityId);
		communityServiceRelaTempKey.setServiceId(serviceId);

		return communityServiceRelaTempMapper.selectByPrimaryKey(communityServiceRelaTempKey);
	}

	public void updateCommunityServiceRela(CommunityServiceRela communityServiceRela) {
		communityServiceRelaMapper.updateByPrimaryKeySelective(communityServiceRela);
	}

	public PageList<ExtCommunityServiceRela> getCommunityServiceAddList(int serviceId, int index, int size) {

		PageBounds pageBounds = new PageBounds(index, size);

		return extCommunityServiceRelaMapper.getCommunityServiceRelaList(serviceId, pageBounds);
	}

	public PageList<ExtCommunityServiceRela> getCommunityServiceRelaTempList(int serviceId, int index, int size) {

		PageBounds pageBounds = new PageBounds(index, size);

		return extCommunityServiceRelaMapper.getCommunityServiceRelaTempList(serviceId, pageBounds);
	}

	public PageList<ExtCommunityServiceRela> getCommunityServiceRelaList(int serviceId, int index, int size) {

		PageBounds pageBounds = new PageBounds(index, size);

		return extCommunityServiceRelaMapper.getCommunityServiceRelaList(serviceId, pageBounds);
	}

	public long getCommunityServiceRelaCount(int serviceId, int status) {
		CommunityServiceRelaExample example = new CommunityServiceRelaExample();

		Criteria criteria = example.createCriteria();

		criteria.andServiceIdEqualTo(serviceId);

		if (status > 0) {
			criteria.andStatusEqualTo(status);
		}

		return communityServiceRelaMapper.countByExample(example);
	}

	// 保存服务范围信息
	public void saveByIds(String communityIds, int serviceId, String contactsName, String contactsPhone,
			String contactsEmail, int auditStatus, int status) {
		logger.info("saveByIds:communityIds:{}, serviceId:{}, contactsName:{}, contactsPhone:{}, contactsEmail:{}, auditStatus:{}, status:{}",communityIds, serviceId, contactsName, contactsPhone, contactsEmail, auditStatus, status);
		String[] ids = communityIds.split(",");
		if (ids != null && ids.length > 0) {
			for (int i = 0; i < ids.length; i++) {
				if (ids[i].startsWith("a") || ids[i].startsWith("A")) {
					// 保存到服务区域表中
					OpenServiceArea openServiceArea = new OpenServiceArea();
					openServiceArea.setAreaId(Integer.parseInt(ids[i].substring(1)));
					openServiceArea.setServiceId(serviceId);
					openServiceAreaService.addOpenServiceArea(openServiceArea);
				} else {
					CommunityServiceRelaTemp communityServiceRelaTemp = new CommunityServiceRelaTemp();
					communityServiceRelaTemp.setServiceId(serviceId);
					communityServiceRelaTemp.setCommunityId(Integer.parseInt(ids[i]));
					communityServiceRelaTemp.setCreateTime(new Date());
					communityServiceRelaTemp.setAuditStatus(auditStatus);
					communityServiceRelaTemp.setStatus(status);
					communityServiceRelaTemp.setServiceContactsName(contactsName);
					communityServiceRelaTemp.setServiceContactsPhone(contactsPhone);
					communityServiceRelaTemp.setServiceContactsEmail(contactsEmail);
					communityServiceRelaTemp.setReorder(99);

					this.addCommunityServiceRelaTemp(communityServiceRelaTemp);

					CommunityServiceRela communityServiceRela = new CommunityServiceRela();
					try {
						BeanUtils.copyProperties(communityServiceRela, communityServiceRelaTemp);
					} catch (IllegalAccessException e) {
						logger.error(e.getMessage(), e);
					} catch (InvocationTargetException e) {
						logger.error(e.getMessage(), e);
					}
					this.addCommunityServiceRela(communityServiceRela);
				}
			}
		}
	}
}
