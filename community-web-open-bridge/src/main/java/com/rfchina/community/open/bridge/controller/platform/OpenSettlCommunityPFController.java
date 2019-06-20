package com.rfchina.community.open.bridge.controller.platform;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rfchina.api.response.ResponseData;
import com.rfchina.api.response.model.pay.FuPayGetAccountResponseModel;
import com.rfchina.community.base.Constant;
import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.Result;
import com.rfchina.community.base.util.DateTimeUtils;
import com.rfchina.community.component.PlatformGlobalComponent;
import com.rfchina.community.open.bridge.controller.BaseController;
import com.rfchina.community.persistence.mapper.CommunityMapper;
import com.rfchina.community.persistence.mapper.CommunityPayMapper;
import com.rfchina.community.persistence.mapper.PaySettlementInfoMapper;
import com.rfchina.community.persistence.mapper.ext.ExtOpenSettCommunityAdminMapper;
import com.rfchina.community.persistence.model.Community;
import com.rfchina.community.persistence.model.CommunityPay;
import com.rfchina.community.persistence.model.PaySettlementInfo;
import com.rfchina.community.service.openser.OpenSettCommunityGlobalService;

@RestController
@RequestMapping(value = OpenConstant.ROOT_PATH_PLATFORM)
public class OpenSettlCommunityPFController extends BaseController {

	@Autowired
	private ExtOpenSettCommunityAdminMapper extOpenSettCommunityAdminMapper;

	@Autowired
	private PaySettlementInfoMapper paySettlementInfoMapper;

	@Autowired
	private CommunityMapper communityMapper;
	@Autowired
	private CommunityPayMapper communityPayMapper;
	@Autowired
	private PlatformGlobalComponent platformGlobalComponent;

	@Autowired
	private OpenSettCommunityGlobalService openSettCommunityGlobalService;

	@Value("${app.environment}")
	private String environment;

	@RequestMapping("/openSettCommunityList")
	public Result<?> openSettCommunityList(@RequestParam(value = "title", required = false) String title1,
			@RequestParam(value = "begin_create_time", required = false) String begin_create_time1,
			@RequestParam(value = "end_create_time", required = false) String end_create_time1,
			@RequestParam(value = "account_id", required = false) String account_id1,
			@RequestParam(value = "set_id", required = false) String set_id1,
			@RequestParam(value = "pf_status", required = false) String pf_status1,
			@RequestParam(value = "community_id", required = false) String community_id1,
			@RequestParam(value = "index", required = false, defaultValue = "1") int index,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size) throws Exception {
		String title = null;
		Integer pf_status = null;
		String account_id = null;
		Date end_create_time = null;
		Date begin_create_time = null;
		String set_id = null;
		Integer community_id = null;
		if (StringUtils.isNotEmpty(begin_create_time1)) {
			begin_create_time = DateTimeUtils.parseDateTime(begin_create_time1);
		}
		if (StringUtils.isNotEmpty(end_create_time1)) {
			end_create_time = DateTimeUtils.parseDateTime(end_create_time1);
		}
		if (StringUtils.isNotEmpty(community_id1)) {
			community_id = Integer.valueOf(community_id1);
		}
		if (StringUtils.isNotEmpty(pf_status1)) {
			pf_status = Integer.valueOf(pf_status1);
		}
		if (StringUtils.isNotEmpty(account_id1)) {
			account_id = account_id1;
		}
		if (StringUtils.isNotEmpty(set_id1)) {
			set_id = set_id1;
		}
		if (StringUtils.isNotEmpty(title1)) {
			title = "%" + title1 + "%";
		}

		PageBounds pageBounds = new PageBounds(index, size);

		PageList<Map<String, Object>> data = extOpenSettCommunityAdminMapper.selectByExample(community_id, pf_status,
				set_id, begin_create_time, end_create_time, title, account_id, null, pageBounds);
		for (Map<String, Object> map : data) {
			Integer community_id2 = MapUtils.getInteger(map, "community_id", 0);
			String setid = MapUtils.getString(map, "set_id", "");
			PaySettlementInfo settl = null;
			if (StringUtils.isNotEmpty(setid)) {
				settl = paySettlementInfoMapper.selectByPrimaryKey(setid);
			} else {
				// settl = new PaySettlementInfo();
			}
			Community community = null;
			if (community_id2 != null && community_id2 > 0) {
				community = communityMapper.selectByPrimaryKey(community_id2);
				community.setIntro("");
			} else {
				// settl = new PaySettlementInfo();
			}

			map.put("community", community);
			map.put("settl", settl);
		}
		return Result.successData(data.convert());
	}

	@RequestMapping("/openCommunitySettDate")
	public Result<?> openCommunitySettDate(@RequestParam("community_id") int communityId) {

		CommunityPay cs = communityPayMapper.selectByPrimaryKey(communityId);

		Date lastSettleTime = getLastSettleTime(communityId, cs);
		JSONObject json = new JSONObject();
		json.put("lastSettleTime", DateTimeUtils.formatDate(lastSettleTime));
		Set<String> array = getEndDates(lastSettleTime);
		json.put("account", cs.getOpenPayAccount());
		json.put("endDates", array);
		json.put("environment", environment);
		return Result.successData(json);
	}

	private Date getLastSettleTime(int communityId, CommunityPay cp) {
		validator(cp == null, "该社区没有配置" + communityId);
		validator(StringUtils.isBlank(cp.getOpenPayAccount()) || StringUtils.isBlank(cp.getOpenMerchantId()),
				"该社区没有配置服务结算账号" + communityId);
		String accid = cp.getOpenPayAccount();
		ResponseData<FuPayGetAccountResponseModel> res = platformGlobalComponent.getAccount(accid);
		validator(res.getCode() != 1001, JSON.toJSONString(res));
		FuPayGetAccountResponseModel acc = res.getData();
		// 账号结算状态, 1:存在进行中的结算申请, 2:不存在进行中的结算申请
		validator(acc.getSettle() != 2, "失败，该结算账号有正在审批中的提现申请，请等待提现申请完成后再发起新的提现申请。" + accid);
		validator(acc.getStatus() != 1, "申请失败，账号已冻结!" + accid);
		return DateUtils.addDays(acc.getLastSettleTime(), 1);
	}

	private Set<String> getEndDates(Date lastSettleTime) {
		Set<String> array = new LinkedHashSet<>();
		for (int i = 0; i <= 12; i++) {
			Date date = DateUtils.addMonths(lastSettleTime, i);
			Calendar calendar = Calendar.getInstance();
			// 设置时间,当前时间不用设置
			calendar.setTime(date);
			// 设置日期为本月最大日期
			calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
			date = calendar.getTime();
			if (System.currentTimeMillis() - date.getTime() > 16 * 24 * 3600 * 1000L) {
				array.add(DateTimeUtils.formatDate(date));
			}
		}
		if ("test".equals(environment) || "default".equals(environment) || "local".equals(environment)) {
			array.add(DateTimeUtils.formatDate(DateUtils.addDays(new Date(), -2)));
		}
		return array;
	}

	// 提现申请
	@RequestMapping("/openCommunitySettlementApply")
	public Result<?> openCommunitySettlementApply(@RequestParam(value = "end_date", required = true) String endDate,
			@RequestParam("community_id") int communityId) {
		validator(!endDate.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}"), "申请失败，日期格式不对!如:2017-06-29");

		Community community = communityMapper.selectByPrimaryKey(communityId);
		validator(community == null, "社区id不存在" + community);
		validator(community.getStatus() != 1, "社区已经禁用");
		CommunityPay cs = communityPayMapper.selectByPrimaryKey(communityId);

		Date lastSettleTime = getLastSettleTime(communityId, cs);
		Set<String> enddates = getEndDates(lastSettleTime);
		validator(!enddates.contains(endDate), "申请失败，该日期不能结算!" + endDate);

		Date startTime = DateTimeUtils.date000000(lastSettleTime);
		Date endTime = DateTimeUtils.date235959(DateTimeUtils.parseDate(endDate));

		String name = community.getName();
		String accountId = cs.getOpenPayAccount();
		long count = -1;
		Integer id = openSettCommunityGlobalService.singleCommunitySettl(startTime, endTime, count, communityId,
				accountId, name);

		return Result.successData(id);
	}

}
