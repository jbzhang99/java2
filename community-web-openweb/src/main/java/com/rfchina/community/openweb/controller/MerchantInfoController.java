package com.rfchina.community.openweb.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.rfchina.community.base.util.RegexUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.rfchina.community.base.Constant;
import com.rfchina.community.base.Result;
import com.rfchina.community.base.util.ValidatorUtil;
import com.rfchina.community.component.OpenAuditInfoComponent;
import com.rfchina.community.component.PlatformGlobalComponent;
import com.rfchina.community.component.SysMsgInfoComponent;
import com.rfchina.community.openweb.entity.AdminUserInfo;
import com.rfchina.community.openweb.service.AreaService;
import com.rfchina.community.openweb.service.MerchantInfoService;
import com.rfchina.community.persistence.mapper.AreaMapper;
import com.rfchina.community.persistence.mapper.OpenAuditInfoMapper;
import com.rfchina.community.persistence.mapper.OpenMerchantInfoMapper;
import com.rfchina.community.persistence.mapper.PassportMapper;
import com.rfchina.community.persistence.model.Area;
import com.rfchina.community.persistence.model.OpenMerchantInfo;
import com.rfchina.community.persistence.model.OpenMerchantInfoExample;
import com.rfchina.community.persistence.model.Passport;
import com.rfchina.community.service.SmsGlobalService;

/**
 */
@RestController
@RequestMapping(value = { Constant.ROOT_PATH_OPENWEB })
public class MerchantInfoController extends BaseController {

	@Autowired
	private OpenMerchantInfoMapper openMerchantInfoMapper;
	@Value("${app.environment}")
	private String environment;
	@Autowired
	private SmsGlobalService smsGlobalService;
	/*@Autowired
	private PassportMapper passportMapper;
	@Autowired
	private AreaMapper areaMapper;
	@Autowired
	private OpenAuditInfoComponent openAuditInfoComponent;
	@Autowired
	private OpenAuditInfoMapper openAuditInfoMapper;
	@Autowired
	private SysMsgInfoComponent sysMsgInfoComponent;
	@Autowired
	private AreaService areaService;
	@Autowired
	private PlatformGlobalComponent platformGlobalComponent;
	@Autowired
	private MerchantInfoService merchantInfoService;*/

	

	@RequestMapping(value = { "/send_phone_check_code" }, method = { RequestMethod.POST })
	public Result<?> sendPhoneCheckCode(@RequestParam(required = true) String phone) {
		Long uid = getAdminId();
		ValidatorUtil.matches(phone, "手机号码格式不对", "1[3-9][0-9]{9}");
		checkPhoneCode(phone, uid);
		isCanBindPhone(phone, uid);
		String code = RandomStringUtils.randomNumeric(6);
		long now = System.currentTimeMillis();
		request.getSession().setAttribute("code", uid + "_" + now + "_" + phone + "_" + code);
		// String content = String.format("[自在社区]开放平台资料填写验证码:%s ,10分钟有效 ", code);
		// platformGlobalComponent.sendSms(phone, content);
		smsGlobalService.sendSms(phone, SmsGlobalService.SmsType.zizai_3f_phone_check, code);

		return Result.successData("");
	}


	private void checkPhoneCode(String phone, Long uid) {
		HttpSession session = request.getSession();
		validator(session == null, "请重新登录!");
		String acode = (String) session.getAttribute("code");
		if (acode == null)
			return;
		String[] acodes = acode.split("_");
		if (acodes.length != 4 || !acodes[0].equals(uid.toString()))
			return;
		long cc = Long.valueOf(acodes[1]) + 60 * 1000L - System.currentTimeMillis();
		validator(cc > 0, "请不要频换获得手机验证码!" + cc / 1000L + "秒后");
	}

	private void isCanBindPhone(String phone, Long uid) {
		OpenMerchantInfoExample example = new OpenMerchantInfoExample();
		example.createCriteria().andContactPhoneEqualTo(phone).andIdNotEqualTo(uid);
		validator(openMerchantInfoMapper.countByExample(example) > 0, "错误,联系人手机号码已经绑定过!");
	}


	/**
	 * @author:fukangwen
	 * @Description: 获取商家信息，小富市集也用这个
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping(value = { "/get_merchant_info" }, method = { RequestMethod.POST })
	public Result<?> getMerchantInfo() {
		Long uid = getAdminId();
		OpenMerchantInfo info = openMerchantInfoMapper.selectByPrimaryKey(uid);
		JSONObject json = new JSONObject();
		json.put("info", info);

		if (info != null) {
			json.put("statusTitle", Constant.merchantInfo.status.translate(info.getStatus()));
			json.put("address", info.getAreaInfo());
		}
		// area.setMergerName(area.getMergerName().replaceAll("中国,", ""));
		return Result.successData(json);
	}



}
