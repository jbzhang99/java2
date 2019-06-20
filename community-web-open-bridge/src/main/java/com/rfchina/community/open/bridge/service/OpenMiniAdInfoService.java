package com.rfchina.community.open.bridge.service;

import com.rfchina.community.base.KeyValueDomain;
import com.rfchina.community.base.OpenMiniConstant;
import com.rfchina.community.persistence.mapper.*;
import com.rfchina.community.persistence.mapper.ext.ExtOpenMiniAdInfoMapper;
import com.rfchina.community.persistence.model.*;
import com.rfchina.community.persistence.model.ext.ExtOpenMiniAdInfo;
import com.rfchina.community.persistence.model.ext.ExtOpenMiniAdTab;
import com.rfchina.community.persistence.model.ext.SimCommunity;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * fukangwen
 */
@Service
public class OpenMiniAdInfoService extends BaseService {
	@Autowired
	private OpenMiniAdCommunityRelaMapper openMiniAdCommunityRelaMapper;
	@Autowired
	private OpenMiniAdInfoMapper openMiniAdInfoMapper;
	@Autowired
	private ExtOpenMiniAdInfoMapper extOpenMiniAdInfoMapper;
	@Autowired
	private OpenMiniAdTabMapper openMiniAdTabMapper;
	@Autowired
	private CommunityServiceMapper communityServiceMapper;
	@Autowired
	private OpenStoreGoodMapper openStoreGoodMapper;
	@Autowired
	private OpenXFSJInfoMapper openXFSJInfoMapper;

	public static final int defaltSorting = 999;

	/**
	 * 新增
	 */
	public void insert(List<Integer> communityIdList, String title, String style, List<OpenMiniAdTab> tabList){
		Long infoId = this.insertAdInfo(title, style);
		this.insertAdCommunityRelaList(infoId, communityIdList);
		this.insertAdTabList(infoId, tabList);
	}

	/**
	 * 新增信息表
	 * @param title
	 * @param style
	 * @return
	 */
	private Long insertAdInfo(String title, String style){
		OpenMiniAdInfo info = new OpenMiniAdInfo();
		info.setCreateTime(new Date());
		info.setUpdateTime(info.getCreateTime());
		info.setSorting(defaltSorting);
		info.setStatus(0);
		info.setStyle(style);
		info.setTitle(title);
		openMiniAdInfoMapper.insertSelective(info);
		return info.getId();
	}

	/**
	 * 更新信息表
	 * @param title
	 * @return
	 */
	private void updateAdInfo(Long infoId, String title){
		OpenMiniAdInfo info = openMiniAdInfoMapper.selectByPrimaryKey(infoId);
		validator(info == null, "数据不存在");
		info.setUpdateTime(new Date());
		info.setTitle(title);
		openMiniAdInfoMapper.updateByPrimaryKeySelective(info);
	}

	/**
	 * 新增广告展位表
	 * @param infoId
	 * @param tabList
	 */
	private void insertAdTabList(Long infoId, List<OpenMiniAdTab> tabList){
		Date createTime = new Date();
		for(OpenMiniAdTab tab : tabList){
			tab.setMiniAdInfoId(infoId);
			tab.setCreateTime(createTime);
			tab.setUpdateTime(createTime);
			openMiniAdTabMapper.insertSelective(tab);
		}
	}

	/**
	 * 更新广告展位表
	 * @param tabList
	 */
	private void updateAdTablist(List<OpenMiniAdTab> tabList){
		Date createTime = new Date();
		for(OpenMiniAdTab tab : tabList){
			tab.setUpdateTime(createTime);
			openMiniAdTabMapper.updateByPrimaryKeySelective(tab);
		}
	}

	/**
	 * 新增社区广告关联表
	 * @param infoId
	 * @param communityIdList
	 */
	private void insertAdCommunityRelaList(Long infoId, List<Integer> communityIdList){
		Date createTime = new Date();
		for(Integer communityId : communityIdList){
			this.insertAdCommunityRela(infoId, communityId, createTime);
		}
	}

	/**
	 * 更新社区广告关联表
	 * @param infoId
	 * @param communityIdList
	 */
	private void updateAdCommunityRelaList(Long infoId, List<Integer> communityIdList){
		//把没有选到的删除掉
		OpenMiniAdCommunityRelaExample example = new OpenMiniAdCommunityRelaExample();
		example.createCriteria().andAdIdEqualTo(infoId).andCommunityIdNotIn(communityIdList);
		openMiniAdCommunityRelaMapper.deleteByExample(example);

		//把选到的且在数据库有记录的用map装起来，并用categoryId为key
		OpenMiniAdCommunityRelaExample example1 = new OpenMiniAdCommunityRelaExample();
		example1.createCriteria().andAdIdEqualTo(infoId).andCommunityIdIn(communityIdList);
		List<OpenMiniAdCommunityRela> relList = openMiniAdCommunityRelaMapper.selectByExample(example1);

		Map<Integer, List<OpenMiniAdCommunityRela>> groupBy = relList.stream().collect(Collectors.groupingBy(OpenMiniAdCommunityRela::getCommunityId));

		//把没有在map里面的全部新增
		Date createTime = new Date();
		for(Integer communityId : communityIdList){
			if(communityId != null && groupBy.get(communityId) == null){
				this.insertAdCommunityRela(infoId, communityId, createTime);
			}
		}

	}

	/**
	 * 新增关联表
	 * @param infoId
	 * @param communityId
	 * @param createTime
	 */
	private void insertAdCommunityRela(Long infoId, Integer communityId, Date createTime){
		OpenMiniAdCommunityRela rela = new OpenMiniAdCommunityRela();
		rela.setAdId(infoId);
		rela.setCommunityId(communityId);
		rela.setCreateTime(createTime);
		openMiniAdCommunityRelaMapper.insertSelective(rela);
	}

	/**
	 * 更新
	 */
	public void update(Long infoId, List<Integer> communityIdList, String title, List<OpenMiniAdTab> tabList){
		OpenMiniAdInfo info = openMiniAdInfoMapper.selectByPrimaryKey(infoId);
		validator(info == null, "数据不存在");
		this.updateAdInfo(infoId, title);

		this.updateAdTablist(tabList);

		this.updateAdCommunityRelaList(infoId, communityIdList);
	}

	/**
	 * 启用禁用
	 */
	public void updateStatus(Long infoId, int status){
		OpenMiniAdInfo info = openMiniAdInfoMapper.selectByPrimaryKey(infoId);
		validator(info == null, "数据不存在");
		info.setStatus(status);
		info.setUpdateTime(new Date());
		openMiniAdInfoMapper.updateByPrimaryKeySelective(info);
	}

	/**
	 * 删除
	 */
	public void delete(Long infoId){
		openMiniAdInfoMapper.deleteByPrimaryKey(infoId);

		OpenMiniAdCommunityRelaExample relaExample = new OpenMiniAdCommunityRelaExample();
		relaExample.createCriteria().andAdIdEqualTo(infoId);
		openMiniAdCommunityRelaMapper.deleteByExample(relaExample);

		OpenMiniAdTabExample tabExample = new OpenMiniAdTabExample();
		tabExample.createCriteria().andMiniAdInfoIdEqualTo(infoId);

		openMiniAdTabMapper.deleteByExample(tabExample);

	}

	/**
	 * 板块列表
	 */
	public List<KeyValueDomain> getStyle(){
		return OpenMiniConstant.ShowStyle.getList();
	}


	/**
	 * 修改排序
	 */
	public void updateSorting(Long infoId, int sorting){
		OpenMiniAdInfo info = openMiniAdInfoMapper.selectByPrimaryKey(infoId);
		validator(info == null, "数据不存在");
		info.setSorting(sorting);
		info.setUpdateTime(new Date());
		openMiniAdInfoMapper.updateByPrimaryKeySelective(info);
	}

	public ExtOpenMiniAdInfo getMiniDetail(long infoId){
		OpenMiniAdInfo info = openMiniAdInfoMapper.selectByPrimaryKey(infoId);
		validator(info == null, "数据不存在");
		ExtOpenMiniAdInfo ext = new ExtOpenMiniAdInfo();
		BeanUtils.copyProperties(info, ext);
		ext.setTabList(this.getTabList(infoId));
		ext.setCommunityList(this.getCommunityList(infoId));
		return ext;
	}
	/**
	 * 列表搜索
	 */
	public PageList<?> pageList(String title, String style, Integer status, int communityId, int index, int size){
		Map<String, Object> param = new HashMap<>();
		if (StringUtils.isNotBlank(title)) {
			param.put("title", "%" + title + "%");
		}
		if (StringUtils.isNotBlank(style)) {
			param.put("style", style);
		}
		if(status != null){
			param.put("status", status);
		}
		if(communityId > 0){
			param.put("communityId", communityId);
		}
		PageBounds pageBounds = new PageBounds(index, size);

		PageList<ExtOpenMiniAdInfo> pager = extOpenMiniAdInfoMapper.pageByCondition(param, pageBounds);

		// TODO 处理集合数据
		for(ExtOpenMiniAdInfo ext : pager){
			ext.setTabList(this.getTabList(ext.getId()));
		}
		return pager;
	}

	private List<ExtOpenMiniAdTab> getTabList(long infoId){
		OpenMiniAdTabExample example = new OpenMiniAdTabExample();
		example.createCriteria().andMiniAdInfoIdEqualTo(infoId);
		example.setOrderByClause("serial_number");
		List<OpenMiniAdTab> list = openMiniAdTabMapper.selectByExample(example);
		List<ExtOpenMiniAdTab> extList = new ArrayList<>();
		for(OpenMiniAdTab tab : list){
			ExtOpenMiniAdTab extTab = new ExtOpenMiniAdTab();
			BeanUtils.copyProperties(tab, extTab);
			String title = "";
			if(OpenMiniConstant.Type.SERVICE.getCode().equals(tab.getType())){
				CommunityService service = communityServiceMapper.selectByPrimaryKey(tab.getTargetId());
				title = service == null ? "" : service.getTitle();
			}else if(OpenMiniConstant.Type.GOOD.getCode().equals(tab.getType())){
				OpenStoreGood good = openStoreGoodMapper.selectByPrimaryKey(tab.getTargetId());
				title = good == null ? "" : good.getName();
			}else{
				title = tab.getTargetUrl();
			}
			extTab.setTitle(title);
			extList.add(extTab);
		}

		return extList;
	}

	public List<SimCommunity> getCommunityList(long infoId){
		return extOpenMiniAdInfoMapper.getCommunityList(infoId);
	}

}
