package com.rfchina.community.open.bridge.controller.platform;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import com.rfchina.community.base.Constant;
import com.rfchina.community.open.bridge.service.AuditService;
import com.rfchina.community.persistence.mapper.*;
import com.rfchina.community.persistence.model.*;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.Result;
import com.rfchina.community.base.util.ValidatorUtil;
import com.rfchina.community.component.OpenAuditInfoComponent;
import com.rfchina.community.open.bridge.controller.BaseController;
import com.rfchina.community.open.bridge.mapper.ext.ExtOpenAuditInfoMapper;
import com.rfchina.community.open.bridge.service.CommunityServicePFService;
import com.rfchina.community.open.bridge.service.IOpenAuditType;
import com.rfchina.community.open.bridge.service.IOpenAuditTypeReturn;

//自在服务评价
@RestController
@RequestMapping(value = { OpenConstant.ROOT_PATH_PLATFORM })
public class OpenAuditInfoPFController extends BaseController {

	@Autowired
	private OpenMerchantInfoMapper openMerchantInfoMapper;
	@Autowired
	private CommunityServiceTempMapper communityServiceTempMapper;
	@Autowired
	private CommunityServiceMapper communityServiceMapper;
	@Autowired
	private ExtOpenAuditInfoMapper extOpenAuditInfoMapper;

	@Autowired
	private OpenAuditInfoMapper openAuditInfoMapper;
	@Autowired
	private AuditService auditService;
	@Autowired
	private OpenXfsjSignUpInfoMapper openXfsjSignUpInfoMapper;

	@Autowired
	private OpenAuditInfoComponent openAuditInfoComponent;
	@Autowired
	private OpenXFSJInfoMapper openXFSJInfoMapper;
	@Autowired
	private CommunityMapper communityMapper;
	@Autowired
	private CommunityServicePFService communityServicePFService;
	@Autowired
	private AreaMapper areaMapper;
	@Autowired
	private CommunityServiceCategoryMapper communityServiceCategoryMapper;

	@RequestMapping(value = { "/listOpenAuditInfo" })
	public Result<?> listOpenAuditInfo(@RequestParam(defaultValue = "1") int index,
			@RequestParam(defaultValue = "20") int size,
			@RequestParam(value = "auditType", required = false, defaultValue = "") String auditType, Integer status,
			Long srcUid) {
		PageBounds pageBounds = new PageBounds(index, size);
		OpenAuditInfoExample example = new OpenAuditInfoExample();
		OpenAuditInfoExample.Criteria cr = example.createCriteria();
		cr.andPagerIdEqualTo(OpenAuditInfoComponent.PageIdType.platform.toString());
		if (srcUid != null && srcUid > 0) {
			cr.andSrcUidEqualTo(srcUid);
		}
		if (status != null && status > 0) {
			cr.andAuditStatusEqualTo(status);
		}
		// 没有筛选审核类型时，去掉小富市集的两个审核
		if (StringUtils.isNotBlank(auditType)) {
			cr.andAuditTypeEqualTo(auditType);
		}
		//
		example.setOrderByClause("id desc");
		List<JSONObject> array = new ArrayList<JSONObject>();
		PageList<OpenAuditInfo> pager = extOpenAuditInfoMapper.pageByExample(example, pageBounds);
		for (OpenAuditInfo openAuditInfo : pager) {
			JSONObject e = new JSONObject();
			e.put("auditInfo", openAuditInfo);
//			OpenMerchantInfoTemp info = openMerchantInfoTempMapper.selectByPrimaryKey(openAuditInfo.getSrcUid());
//			e.put("merchantTemp", info == null ? new OpenMerchantInfoTemp() : info);

			OpenMerchantInfo info = openMerchantInfoMapper.selectByPrimaryKey(openAuditInfo.getSrcUid());
			e.put("merchantTemp", info == null ? new OpenMerchantInfo() : info);

			if (openAuditInfo.getServiceId() != null && openAuditInfo.getServiceId() > 0) {
				CommunityServiceTemp serviceInfo = communityServiceTempMapper
						.selectByPrimaryKey(openAuditInfo.getServiceId());
				e.put("serviceInfo", serviceInfo == null ? new CommunityServiceTemp() : serviceInfo);
			} else {
				e.put("serviceInfo", new CommunityServiceTemp());
			}

			array.add(e);
		}
		return Result.successData(new PageList<JSONObject>(array, pager.getPaginator()).convert());
	}

	@RequestMapping(value = { "/auditOpenAuditInfo" })
	public Result<?> auditOpenAuditInfo(@RequestParam(value = "__uid", required = false) Long adminId,
			@RequestParam(value = "__admin_id", required = false, defaultValue = "0") Long adminId2,
			@RequestParam(value = "__phone", required = false, defaultValue = "") String phone,
			@RequestParam(value = "__realname", required = false, defaultValue = "") String realname,
			@RequestParam Long id, @RequestParam int status, String statusContent,
			String parameters, HttpServletRequest request) throws Exception {
		Long uid = adminId;
		if (uid == null) {
			uid = adminId2;
		}
		WebApplicationContext webApplicationContext = WebApplicationContextUtils
				.getWebApplicationContext(request.getServletContext());
		auditService.audit(phone, realname, id, status, statusContent, parameters,webApplicationContext.getBeansOfType(IOpenAuditType.class) , uid);
		return Result.successData(1);
	}

}
