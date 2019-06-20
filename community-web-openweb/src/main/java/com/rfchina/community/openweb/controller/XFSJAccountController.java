package com.rfchina.community.openweb.controller;

import com.rfchina.api.response.model.pay.FuPayGetAccountListResponseModel;
import com.rfchina.community.base.Constant;
import com.rfchina.community.base.EmojiUtil;
import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.OpenConstant.OpenServiceDetailTab;
import com.rfchina.community.base.Result;
import com.rfchina.community.base.util.ValidatorUtil;
import com.rfchina.community.component.OpenAuditInfoComponent;
import com.rfchina.community.component.PlatformGlobalComponent;
import com.rfchina.community.component.WorkOrderComponent;
import com.rfchina.community.entity.wo.EmpBean;
import com.rfchina.community.entity.wo.GetEmpInfoReq;
import com.rfchina.community.entity.wo.GetEmpInfoRsp;
import com.rfchina.community.openweb.entity.AdminUserInfo;
import com.rfchina.community.openweb.service.*;
import com.rfchina.community.persistence.mapper.*;
import com.rfchina.community.persistence.model.CommunityService;
import com.rfchina.community.persistence.model.*;
import com.rfchina.community.service.SmsGlobalService;
import com.rfchina.community.service.openser.OpenServiceDetailTabService;
import com.rfchina.community.service.openser.OpenServicePayService;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 小富市集
 */
@RestController
@RequestMapping(value = { Constant.ROOT_PATH_OPENWEB })
public class XFSJAccountController extends BaseController {

	@Autowired
	private CommunityServiceCategoryMapper communityServiceCategoryMapper;

	@Autowired
	private WorkOrderComponent workOrderComponent;
	@Autowired
	private OpenManagerInviteMapper openManagerInviteMapper;
	@Autowired
	private OpenServicePayService openServicePayService;
	@Autowired
	private OpenAuditInfoComponent openAuditInfoComponent;
	@Autowired
	private AccountService accountService;
	@Autowired
	private OpenMerchantInfoMapper openMerchantInfoMapper;
	@Autowired
	private PlatformGlobalComponent platformGlobalComponent;
	@Autowired
	private CommunityServiceRelaService communityServiceRelaService;
	@Autowired
	private ChartGraphicsService chartGraphicsService;
	@Autowired
	private OpenStoreServiceTempleteMapper openStoreServiceTempleteMapper;
	@Autowired
	private OpenServiceDetailTabService openServiceDetailTabService;
	@Autowired
	private OpenStoreServiceTempleteService openStoreServiceTempleteService;
	@Value("${open.storeapi.url}")
	private String openStoreapiUrl;
	@Value("${app.environment}")
	private String environment;
	@Autowired
	private OpenStoreGoodService openStoreGoodService;
	@Autowired
	private CommunityServiceMapper communityServiceMapper;


	/**
	 * @author:fukangwen @Description: 判断管家那边是否存在这个手机账号 @return Boolean @throws
	 */
	private EmpBean getEmpBean(String phone) {
		GetEmpInfoReq getEmpInfoReq = new GetEmpInfoReq();
		getEmpInfoReq.setMobile(phone);
		GetEmpInfoRsp getEmpInfoRsp = workOrderComponent.getEmpInfo(getEmpInfoReq);
		if (getEmpInfoRsp == null || getEmpInfoRsp.getEmpBeans().isEmpty())
			return null;
		return getEmpInfoRsp.getEmpBeans().get(0);
	}

	private OpenManagerInvite getOpenManagerInvite(Long uid) {
		OpenManagerInviteExample example = new OpenManagerInviteExample();
		example.createCriteria().andUidEqualTo(uid);
		List<OpenManagerInvite> list = openManagerInviteMapper.selectByExample(example);
		if (list.isEmpty())
			return null;
		return list.get(0);
	}


	/**
	 * @author:fukangwen @Description: 注册接口,注册 @return Result<?> @throws  TODO 自动给服务添加accountId
	 */
	@Transactional
	@RequestMapping(value = { "/xfsj/register_service" }, method = { RequestMethod.POST })
	public Result<?> registerService(@RequestParam("title") String title,
			@RequestParam("description") String description, @RequestParam("category_id") int categoryId,
			@RequestParam("community_ids") String communityIds, @RequestParam("protocol_url") String protocolUrl,
//			@RequestParam(value = "phone", required = false) String phone,
		    @RequestParam("managerPhone") String managerPhone,//管家邀请账户
		    @RequestParam(value = "srcBusiness", required = true) String srcBusiness,
			@RequestParam(value = "srcCity", required = false) Integer srcCity
	) throws IllegalAccessException, InvocationTargetException {
		AdminUserInfo adminInfo = getAdminInfo();
		Long adminid = adminInfo.getUid();
		OpenMerchantInfo merchant = openMerchantInfoMapper.selectByPrimaryKey(adminid);
		validator(merchant == null, "服务商不存在!不能创建服务");
		validator(StringUtils.isBlank(title), "服务名称不能为空");
		title = EmojiUtil.replaceAll(title);

		validator(StringUtils.isBlank(description), "服务描述不能为空");
		validator(categoryId <= 0, "服务分类不能为空");
		validator(StringUtils.isBlank(communityIds), "服务范围不能为空");

		// 判断服务是否已经创建
		validator(communityServiceService.getCommunityServiceTempCount(adminid) > 0, "店铺已经创建,请直接登录");
		// 根据条件进行排重
		List<CommunityServiceTemp> list = communityServiceService.getCommunityServiceTemp(title);
		validator(list != null && list.size() > 0, "服务名称：" + title + "，已存在");

		ValidatorUtil.matches(managerPhone, "运营者手机号码格式不对", "1[3-9][0-9]{9}");

		//获取具体来源
		srcCity = this.getSrcCity(srcBusiness, srcCity);

		// 管家信息
		EmpBean empBean = getEmpBean(managerPhone);
		validator(empBean == null, "运营者手机账号不存在");

		//设置收款账号
		FuPayGetAccountListResponseModel accountList = platformGlobalComponent.getAccountListRequest(null,
				adminInfo.getMchId(), "", true, 50, 0);
		validator(accountList.getList().isEmpty(), "商家账号不存在");
		String account = accountList.getList().get(0).getAccountId();
		//验证收款账户状态
		Boolean accountHadUse = communityServiceService.getAccountHadUse(account);
		validator(accountHadUse, "收款账号已被使用,请联系管理员");

		//创建服务信息
		CommunityServiceTemp communityServiceTemp = this.createCommunityServiceTemp(title, description, adminid, account);
	


		communityServiceService.addCommunityServiceTemp(communityServiceTemp);
		Integer serviceId = communityServiceTemp.getId();




		CommunityService communityService = new CommunityService();
		BeanUtils.copyProperties(communityService, communityServiceTemp);
		communityServiceService.addCommunityService(communityService);


		// 设置社区服务费
		CommunityServiceCategory category = communityServiceCategoryMapper.selectByPrimaryKey(categoryId);
		validator(category == null, "店铺分类不存在");
//		communityServiceTemp.setCommissionRate(category.getCommunityFee());
		OpenServicePay pay=new OpenServicePay();
		pay.setServiceId(serviceId);
		pay.setCommunityRate(category.getCommunityFee());
		//		bean.setPlatformFee(1d);// 平台手续费默认
		pay.setPlatformFee(new BigDecimal(1));
		openServicePayService.insertOrUpdate(pay);


		//创建服务详情
		this.createOpenServiceDetail(serviceId, protocolUrl, categoryId);
		
		//新增服务tab
		openServiceDetailTabService.insert(OpenServiceDetailTab.xfsj.getCode(), serviceId);
		
		// 保存服务范围信息
		communityServiceRelaService.saveByIds(communityIds, serviceId, merchant.getContactPerson(),
				merchant.getContactPhone(), merchant.getEmail(),
				Constant.OpenAdmin.CommunityServiceRelaAuditStatus.AUDIT_PASS,
				Constant.OpenAdmin.CommunityServiceRelaStatus.ENABLE);

		// 创建商铺信息
		openStoreServiceTempleteService.insertOrUpdate(serviceId, BigDecimal.valueOf(0L), "", "", category.getPremiumNum());

		// 更新运营者邀请信息
		this.createManagerInvite(merchant.getId(), empBean.getEmpGuid(), empBean.getEmpName(),
				managerPhone, srcCity, srcBusiness, serviceId);

		//商家来源
		merchant.setSrcBusiness(srcBusiness);
		merchant.setSrcCity(srcCity);
		openMerchantInfoMapper.updateByPrimaryKeySelective(merchant);

		//添加审核信息
		openAuditInfoComponent.add(OpenAuditInfoComponent.ObjectType.xfsj_provider_apply, adminid, serviceId.toString(),
				serviceId, communityServiceTemp.getMerchantId(), OpenAuditInfoComponent.PageIdType.xfsj_register);

		return Result.successData(communityServiceTemp.getId());
	}

	private int getSrcCity(String srcBusiness, Integer srcCity){
		// 招商城市,-2位平台,-1物业
		if ("platform".equals(srcBusiness)) {
			srcCity = -2;
		} else if ("wuye".equals(srcBusiness)) {
			srcCity = -1;
		} else if ("area".equals(srcBusiness)) {
			//
			validator(srcCity == null || srcCity <= 0, "请选择正确的地区");
		} else {
			error("招商来源只能选择,平台,物业,地区");
		}
		return srcCity;
	}
	/**
	 * 创建服务
	 * @param title
	 * @param description
	 * @param merchantId
	 * @return
	 */
	private CommunityServiceTemp createCommunityServiceTemp(String title, String description, Long merchantId, String account){
		Date now = new Date();
		CommunityServiceTemp communityServiceTemp = new CommunityServiceTemp();
		communityServiceTemp.setTitle(title);
		communityServiceTemp.setDescription(description);
		communityServiceTemp.setCategoryId(3);// 小富市集的写死
		communityServiceTemp.setIsNeedHardware(Constant.OpenAdmin.IsNeedHardware.NO);
		communityServiceTemp.setTargetMonthTurnover(new BigDecimal(0));
		communityServiceTemp.setCreateTime(now);
		communityServiceTemp.setMerchantId(merchantId);
		communityServiceTemp.setReorder(1);
		communityServiceTemp.setProvideType(2);
		communityServiceTemp.setType(OpenConstant.CommunityServiceType.third_inner_life);
//		communityServiceTemp.setCommissionRate(BigDecimal.valueOf(0L));
		communityServiceTemp.setPng("http://img.thinkinpower.com/G1/M00/07/11/Ch3-Slp5fAmAVkRkAAAWtKnxBOM359.jpg");// 服务图标默认
		communityServiceTemp.setGroundMode(Constant.OpenAdmin.GroundMode.AUTO);
		communityServiceTemp.setStatus(Constant.OpenAdmin.CommunityServiceGroundStatus.UNGROUNDING);
		communityServiceTemp.setUserRange(Constant.OpenAdmin.UserRange.FOLLOWANDMASTERCHILD);
		communityServiceTemp.setAuditStatus(Constant.OpenAdmin.CommunityServiceAuditStatus.AUDIT);
		communityServiceTemp.setGroundAuditStatus(Constant.OpenAdmin.CommunityServiceGroundAuditStatus.AUDIT);
		communityServiceTemp.setCautionMoneyStatus(OpenConstant.CautionMoneyStatus.EXPERIENCING);
		communityServiceTemp.setPaidCautionMoney(new BigDecimal(0));
		communityServiceTemp.setReceivableCautionMoney(new BigDecimal(0));
		communityServiceTemp.setAccountId(account);
		return communityServiceTemp;
	}
	/**
	 *创建服务详情
	 */
	private void createOpenServiceDetail(Integer serviceId, String protocolUrl, Integer categoryId){
		OpenServiceDetail detail = new OpenServiceDetail();
		detail.setServiceId(serviceId);
		detail.setTempleteStatus(1);// 已应用
		detail.setDevelopType(OpenConstant.open_service_detail.develop_type.TEMPLETE.toString());
		detail.setTempleteName(OpenConstant.open_service_detail.templete_name.STORE.getCode());
		detail.setAppCatSort(999);
		detail.setAppIndexSort(999);
		detail.setRfchinaCode(2);
		detail.setXfsjStatus(1);// 小富市集状态，1为是
		detail.setProtocolUrl(protocolUrl);
		detail.setCategorySecondType(categoryId); // 小富市集子分类
		detail.setCautionRefundStatus(2);//
		communityServiceService.insertORUpdateOpenServiceDetail(detail);
	}

	/**
	 * 新增运营者邀请信息
	 * @param merchantId
	 * @param empGuid
	 * @param empName
	 * @param managerPhone
	 * @param srcCity
	 * @param srcBusiness
	 * @param serviceId
	 */
	private void createManagerInvite(Long merchantId, String empGuid, String empName,
									 String managerPhone, Integer srcCity, String srcBusiness, Integer serviceId){
		// 创建运营者信息
		OpenManagerInvite invite = new OpenManagerInvite();
		invite.setCreateTime(new Date());
		invite.setUpdateTime(invite.getCreateTime());
		invite.setUid(merchantId);
		invite.setEmpGuid(empGuid);
		invite.setMerchantId(merchantId);
		invite.setEmpName(empName);
		invite.setPhone(managerPhone);
		invite.setStatus(1);
		invite.setServiceId(serviceId);
		invite.setSrcCity(srcCity);
		invite.setSrcBusiness(srcBusiness);

		openManagerInviteMapper.insertSelective(invite);
	}

	/**
	 * @author:fukangwen @Description: 返回溢价比例 @return Result<?> @throws
	 */
	@RequestMapping(value = { "/xfsj/get_premium" }, method = { RequestMethod.POST })
	public Result<?> getPremium(@RequestParam(value = "service_id", required = true) int serviceId,
			HttpServletRequest request) {
		validator(serviceId <= 0, "参数错误");
		Long adminid = getAdminId();
		CommunityService communityService = communityServiceService.getCommunityServiceByPrimaryKey(serviceId);
		validator(communityService == null, "商品信息不存在");
		logger.info("返回溢价比例:用户id：{}, 商户id：{}", adminid, communityService.getMerchantId());
		validator(adminid.longValue() != communityService.getMerchantId().longValue(), "验证失效,请重新登录");

		OpenStoreServiceTemplete templete = openStoreServiceTempleteMapper.selectByPrimaryKey(serviceId);
		return Result.successData(templete == null ? 0 : templete.getPremiumNum());
	}

	/**
	 * @Description: 生成商品标签图片
	 * @author:maixingnian
	 * @return byte[] 商品图片字节码
	 */
	@RequestMapping(value = { "/xfsj/getImg" })
	public Result<?> qrcode(HttpServletResponse response, @RequestParam(value = "goodId", required = true) int goodId,
			@RequestParam(value = "communityId", required = true) int communityId) throws IOException {
		Long admin = getAdminId();
		OpenStoreGood openStoreGood = openStoreGoodService.selectByPrimaryKey(goodId);
		validator(openStoreGood == null, "商品不存在");
		CommunityService ser = communityServiceMapper.selectByPrimaryKey(openStoreGood.getServiceId());
		validator(ser == null, "无数据");
		// validator(ser.getMerchantId() != admin.longValue(), "非法访问");
		// http://store.zizai.test.thinkinpower.net/index.html#/goodsDetail?isNew=1&serviceId=413&goodId=352&communityId=1
		String con = openStoreapiUrl + "index.html#/goodsDetail?isNew=1&serviceId=" + ser.getId() + "&goodId=" + goodId
				+ "&communityId=" + communityId;
		// 生成商品图片字节码
		byte[] bytes = chartGraphicsService.createGoodSellImg(con, openStoreGood.getName(),
				openStoreGood.getPrice().toString());
		response.setContentType("image/png");
		return Result.successData(bytes);
	}

}
