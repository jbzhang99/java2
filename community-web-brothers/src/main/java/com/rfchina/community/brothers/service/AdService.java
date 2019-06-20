package com.rfchina.community.brothers.service;

import java.util.Date;

import org.apache.commons.collections4.CollectionUtils;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rfchina.community.base.Constant;
import com.rfchina.community.brothers.mapper.ext.ExtAdMapper;
import com.rfchina.community.component.SysMsgInfoComponent;
import com.rfchina.community.persistence.mapper.AdMapper;
import com.rfchina.community.persistence.model.Ad;
import com.rfchina.community.persistence.model.AdExample;

/**
 */
@Service
public class AdService {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private AdMapper mapper;

	@Autowired
	private ExtAdMapper extMapper;

	@Autowired
	private SysMsgInfoComponent sysMsgInfoComponent;

	public void runAutoRepeal() {
		Date now = new Date();
		AdExample example = new AdExample();
		example.createCriteria().andEndTimeLessThan(now).andStatusEqualTo(Constant.Ad.Status.PLATFORM_PUBLISH);
		PageBounds pageBounds = new PageBounds(1, 20, false);
		PageList<Ad> pageList = extMapper.pageByExample(example, pageBounds);
		if (CollectionUtils.isNotEmpty(pageList)) {
			for (Ad item : pageList) {
				Ad updateRecord = new Ad();
				updateRecord.setId(item.getId());
				updateRecord.setStatus(Constant.Ad.Status.PLATFORM_REPEAL);
				updateRecord.setAutoRepeal(Constant.YesOrNo.YES);
				updateRecord.setAutoRepealTime(now);
				int k = mapper.updateByPrimaryKeySelective(updateRecord);
				logger.info("Invoke[runAutoRepeal]:{},{}", item.getId(), k);
				// 系统消息
				sysMsgInfoComponent.add(SysMsgInfoComponent.ObjectType.ad_pf_sys_repeal, item.getId() + "", item.getCommunityId(), item.getApplyAdminId());
			}
		} else {
			logger.debug("No ad need to auto repeal");
		}
	}

	public void runAutoPublish() {
		Date now = new Date();
		AdExample example = new AdExample();
		example.createCriteria().andStartTimeLessThanOrEqualTo(now).andEndTimeGreaterThanOrEqualTo(now)
				.andStatusEqualTo(Constant.Ad.Status.PLATFORM_AUDIT_PASS);
		PageBounds pageBounds = new PageBounds(1, 20, false);
		PageList<Ad> pageList = extMapper.pageByExample(example, pageBounds);
		if (CollectionUtils.isNotEmpty(pageList)) {
			for (Ad item : pageList) {
				Ad updateRecord = new Ad();
				updateRecord.setId(item.getId());
				updateRecord.setStatus(Constant.Ad.Status.PLATFORM_PUBLISH);
				updateRecord.setPublishTime(now);
				updateRecord.setAutoPublish(Constant.YesOrNo.YES);
				updateRecord.setAutoPublishTime(now);
				int k = mapper.updateByPrimaryKeySelective(updateRecord);
				logger.info("Invoke[runAutoPublish]:{},{}", item.getId(), k);

				// 系统消息
				sysMsgInfoComponent.add(SysMsgInfoComponent.ObjectType.ad_pf_sys_publish, item.getId() + "", item.getCommunityId(), item.getApplyAdminId());
			}
		} else {
			logger.debug("No ad need to auto publish");
		}
	}
}
