package com.rfchina.community.open.bridge.controller.community;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import com.rfchina.community.open.bridge.service.AuditService;
import com.rfchina.community.persistence.mapper.*;
import com.rfchina.community.persistence.model.*;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
import com.rfchina.community.open.bridge.service.IOpenAuditType;
import com.rfchina.community.open.bridge.service.IOpenAuditTypeReturn;

//自在服务评价
@RestController
@RequestMapping(value = { OpenConstant.ROOT_PATH_COMMUNITY })
public class OpenAuditInfoCommunityController extends BaseController {

	private static Logger logger = LoggerFactory.getLogger(OpenAuditInfoCommunityController.class);
	@Autowired
	private OpenMerchantInfoMapper openMerchantInfoMapper;
	@Autowired
	private CommunityServiceMapper communityServiceMapper;

	@Autowired
	private ExtOpenAuditInfoMapper extOpenAuditInfoMapper;

	@Autowired
	private OpenAuditInfoMapper openAuditInfoMapper;

	@Autowired
	private OpenXfsjSignUpInfoMapper openXfsjSignUpInfoMapper;

	@Autowired
	private OpenAuditInfoComponent openAuditInfoComponent;
	@Autowired
	private OpenXFSJInfoMapper openXFSJInfoMapper;
	@Autowired
	private CommunityMapper communityMapper;
	@Autowired
	private AreaMapper areaMapper;
	@Autowired
	private CommunityServiceCategoryMapper communityServiceCategoryMapper;
	@Autowired
	private OpenServiceDetailMapper openServiceDetailMapper;
	@Autowired
	private AuditService auditService;
	@Autowired
	private OpenManagerInviteMapper openManagerInviteMapper;

	@RequestMapping(value = { "/listOpenXFSJSignUpAuditInfo" })
	public Result<?> listOpenXFSJSignUpAuditInfo(
			@RequestParam(value = "index", defaultValue = "1", required = false) int index,
			@RequestParam(value = "size", defaultValue = "20", required = false) int size,
			@RequestParam(value = "activityName", required = false) String activityName,
			@RequestParam(value = "status", required = false) Integer status // 1 审核中， 2 审核通过 3审核不通过
	) {

		PageBounds pageBounds = new PageBounds(index, size);
		Map<String, Object> param = new HashMap<>();
		param.put("auditType", OpenAuditInfoComponent.ObjectType. xfsj_provider_apply.toString());
		// 报名审核
		if (status != null && status > 0) {
			param.put("auditStatus", status);
		}
		if (StringUtils.isNotBlank(activityName)) {
			param.put("activityName", "%" + activityName + "%");
		}
		PageList<OpenAuditInfo> pager = extOpenAuditInfoMapper.pageByParam(param, pageBounds);

		List<JSONObject> array = new ArrayList<JSONObject>();
		for (OpenAuditInfo openAuditInfo : pager) {
			JSONObject e = new JSONObject();
			e.put("auditInfo", openAuditInfo);
			OpenXfsjSignUpInfo openXfsjSignUpInfo = openXfsjSignUpInfoMapper
					.selectByPrimaryKey(Long.parseLong(openAuditInfo.getObjectId()));
			// 获取小富市集信息
			OpenXFSJInfo info = openXFSJInfoMapper.selectByPrimaryKey(openXfsjSignUpInfo.getXfsjId());

			e.put("info", info);

			Community comm = communityMapper.selectByPrimaryKey(info.getCommunityId());
			if (comm != null) {
				Integer cityId = comm.getCityId();
				if (cityId != null && cityId > 0) {
					Area city = areaMapper.selectByPrimaryKey(cityId);
					e.put("cityName", city.getName());
				}
				e.put("communityName", comm.getName());
			}

			// 获取商家信息
			OpenMerchantInfo openMerchantInfo = openMerchantInfoMapper.selectByPrimaryKey(openXfsjSignUpInfo.getUid());
			e.put("openMerchantInfo", openMerchantInfo);
			CommunityService communityService = communityServiceMapper
					.selectByPrimaryKey(openXfsjSignUpInfo.getServiceId());
			if (communityService != null) {
				e.put("storeName", communityService.getTitle());

				int categoryId = 0;
				OpenServiceDetail detail = openServiceDetailMapper.selectByPrimaryKey(communityService.getId());
				if (detail.getCategorySecondType() != null && detail.getCategorySecondType() > 0) {
					categoryId = detail.getCategorySecondType();
				} else {
					categoryId = communityService.getCategoryId();
				}
				e.put("storeType", communityServiceCategoryMapper.selectByPrimaryKey(categoryId).getName());
				array.add(e);
			}
		}
		return Result.successData(new PageList<JSONObject>(array, pager.getPaginator()).convert());
	}

	@RequestMapping(value = { "/xfsj_audit", "/xfsj_merchantAudit" })
	public Result<?> auditOpenAuditInfoCommunity(@RequestParam(value = "__uid") Long adminId,
			@RequestParam(value = "__phone") String phone,
			@RequestParam(value = "__realname") String realname,
			@RequestParam Long id, @RequestParam int status, String statusContent,
			String parameters, HttpServletRequest request) throws Exception {
		//
		// params.put("__uid", uid + "");
		// params.put("__phone", pro.getPhone());
		// params.put("__realname", pro.getRealname());

		WebApplicationContext webApplicationContext = WebApplicationContextUtils
				.getWebApplicationContext(request.getServletContext());
		Map<String, IOpenAuditType> map = webApplicationContext.getBeansOfType(IOpenAuditType.class);
		auditService.audit(phone, realname, id, status, statusContent, parameters,map , adminId);

		/*long now = System.currentTimeMillis();
		Long uid = adminId;
		OpenAuditInfo auditinfo = openAuditInfoMapper.selectByPrimaryKey(id);
		logger.info(
				"audit OpenAuditInfoCommunity adminId:{},id:{},status:{},phone:{},realname:{},statusContent:{},parameters:{},auditinfo:{}",
				adminId, id, status, phone, realname, statusContent, parameters, JSON.toJSONString(auditinfo));
		ValidatorUtil.verify(status, "审批状态值 只能为 1,2", 1, 2);
		validator(auditinfo == null, "数据不存在!");

		validator(auditinfo.getAuditStatus().intValue() != OpenAuditInfoComponent.Status.init.getV(), "非审批中状态不能审批!");

		for (Entry<String, IOpenAuditType> string : map.entrySet()) {
			IOpenAuditTypeReturn ret = string.getValue()
					.audit(OpenAuditInfoComponent.ObjectType.valueOf(auditinfo.getAuditType()));
			if (ret != null) {
				if (status == 1) {
					Map<String, String> parameter = new HashMap<String, String>();
					if (StringUtils.isNotBlank(parameters)) {
						parameter = JSONObject.parseObject(parameters, new TypeReference<Map<String, String>>() {
						});
					}
					ret.passAudit(auditinfo.getSrcUid(), auditinfo.getObjectId(), parameter);
					openAuditInfoComponent.audit(id, OpenAuditInfoComponent.Status.pass,
							StringUtils.isBlank(statusContent) ? "同意!" : statusContent, uid, phone, realname);
				} else {
					validator(StringUtils.isBlank(statusContent), "拒绝原因不能为空!");
					ret.unpassAudit(auditinfo.getSrcUid(), auditinfo.getObjectId(), statusContent);
					openAuditInfoComponent.audit(id, OpenAuditInfoComponent.Status.unpass, statusContent, uid, phone,
							realname);
				}
			}
		}
		logger.info("auditOpenAuditInfo: id:{}, status:{}, statusContent:{}, parameters:{},time:{}", id, status,
				statusContent, parameters, System.currentTimeMillis() - now);*/
		// openAuditInfoService
		return Result.successData(1);
	}

	@RequestMapping(value = { "/listMerchantAuditInfo_{type}" })
	public Result<?> listOpenXFSJMerchantAuditInfo(@PathVariable("type") String type,
			@RequestParam(value = "index", defaultValue = "1", required = false) int index,
			@RequestParam(value = "size", defaultValue = "20", required = false) int size,
			@RequestParam(value = "merchant_name", required = false) String merchant_name,
			@RequestParam(value = "src_business", required = false) String src_business,
			@RequestParam(value = "merchant_type", required = false) Integer merchant_type,
			@RequestParam(value = "src_city", required = false) Integer src_city,
			@RequestParam(value = "serviceName", required = false) String serviceName,
			@RequestParam(value = "audit_status", required = false) Integer audit_status // 1 审核中， 2 审核通过 3审核不通过
	) {
		// 商家类型 //公司名称/个人姓名 //商家来源 //审批状态

		PageBounds pageBounds = new PageBounds(index, size);
		Map<String, Object> param = new HashMap<>();
		param.put("pager_id", "xfsj_register");
		// 报名审核

		if ("area".equals(type)) {
			param.put("src_business", "area");
			if (src_city == null || src_city <= 0) {
				src_city = 9999999;
			}
		}

		if ("wuye".equals(type)) {
			param.put("no_src_business", "platform");
			// param.put("src_city_in", "platform");
		}

		if (audit_status != null && audit_status > 0) {
			param.put("audit_status", audit_status);
		}

		if (StringUtils.isNotBlank(merchant_name)) {
			param.put("merchant_name", "%" + merchant_name + "%");
		}
		if (StringUtils.isNotBlank(src_business)) {
			param.put("src_business", src_business);
		}
		if (merchant_type != null && merchant_type > 0) {
			param.put("merchant_type", merchant_type);
		}
		if (src_city != null && src_city > 0) {
			param.put("src_city", src_city);
		}
		if (StringUtils.isNotBlank(serviceName)) {
			param.put("serviceName", "%" + serviceName + "%");
		}

		PageList<Map<String, Object>> pager = extOpenAuditInfoMapper.listOpenXFSJMerchantAuditInfo(param, pageBounds);

		// List<Map<String, Object>> array = new ArrayList<Map<String, Object>>();
		for (Map<String, Object> openAuditInfo : pager) {
			// logger.info("-=-=----000----" + JSON.toJSONString(openAuditInfo));
			// array.add(openAuditInfo);

			Integer srcCity = MapUtils.getInteger(openAuditInfo, "src_city", -1);
			openAuditInfo.put("cityName", getCityShortName(srcCity));
		}
		// return Result.successData(new PageList<Map<String, Object>>(array,
		// pager.getPaginator()).convert());
		return Result.successData(pager.convert());
	}

	@RequestMapping(value = { "/getOpenXFSJAuditInfo" })
	public Result<?> getOpenXFSJMerchantInfo(@RequestParam(value = "id") long id,
			@RequestParam("merchant_id") Long merchant_id) {
		JSONObject json = new JSONObject();
		OpenAuditInfo audit = openAuditInfoMapper.selectByPrimaryKey(id);
		validator(audit == null, "数据不存在" + id);
		Long mid = audit.getMerchantId();
		validator(merchant_id.longValue() != mid, "请提供正确的商家id");
		OpenMerchantInfo merchant = openMerchantInfoMapper.selectByPrimaryKey(mid);
		List<Map> list = communityServiceMapper.selectByMerchantId(mid);
		json.put("audit", audit);
		json.put("merchant", merchant);
		json.put("services", list);
		json.put("cityName", getCityShortName(merchant.getSrcCity()));
		//查询邀请人
		OpenManagerInviteExample openManagerInviteExample = new OpenManagerInviteExample();
		openManagerInviteExample.createCriteria().andMerchantIdEqualTo(merchant_id);
		List<OpenManagerInvite> openManagerInvites = openManagerInviteMapper.selectByExample(openManagerInviteExample);
		OpenManagerInvite invite = new OpenManagerInvite();
		if(openManagerInvites != null && openManagerInvites.size()>0){
			invite = openManagerInvites.get(0);
		}
		json.put("invite",invite);
		return Result.successData(json);
	}

	private String getCityShortName(Integer srcCity) {
		if (srcCity != null && srcCity > 0) {
			Area city = areaMapper.selectByPrimaryKey(srcCity);
			if (city != null)  {
				return city.getShortName();
			}
		}
		return "";
	}

}
