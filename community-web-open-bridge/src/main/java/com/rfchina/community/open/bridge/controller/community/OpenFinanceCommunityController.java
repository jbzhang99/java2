package com.rfchina.community.open.bridge.controller.community;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.paginator.model.PageList;
import org.mybatis.paginator.model.Paginator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.Result;
import com.rfchina.community.base.util.BaseSqlUtil;
import com.rfchina.community.open.bridge.controller.BaseController;
import com.rfchina.community.open.bridge.mapper.ext.ExtOpenOrderFinanceMapper;

@RestController
@RequestMapping(value = OpenConstant.ROOT_PATH_COMMUNITY)
public class OpenFinanceCommunityController extends BaseController {

	@Autowired
	private ExtOpenOrderFinanceMapper extOpenOrderFinanceMapper;

	@RequestMapping("/listOpenOrderFinance")
	public Result<?> listOpenOrderFinance(
			@RequestParam(value = "cityId", required = false, defaultValue = "0") int cityId,
			@RequestParam(value = "communityIds", required = false, defaultValue = "0") String communityIds,
			@RequestParam(value = "index", required = false, defaultValue = "1") int index,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size, String stitle, String mtitle)
			throws Exception {
		// Integer commid = __community_id;
		// 现在只能查询一个社区,2017-12-15
		Integer commid = Integer.valueOf(communityIds);
		stitle = BaseSqlUtil.whereLike(StringUtils.isNotBlank(stitle), stitle);
		mtitle = BaseSqlUtil.whereLike(StringUtils.isNotBlank(mtitle), mtitle);
		if (StringUtils.isBlank(stitle)) {
			stitle = null;
		}
		if (StringUtils.isBlank(mtitle)) {
			mtitle = null;
		}
		// bill_status=2 支付状态
		// type=1 订单类型，1：正常交易单，2：保证金单
		// balance_status=2 对账状态，1:未对账, 2:已对账, 3:对账出错
		// withdraw_status=2,3,5 '提现状态 1：未到提现时间，2：可提现，3：提现审批中，4：提现成功，5：提现失败',
		List<Map<String, Object>> list = extOpenOrderFinanceMapper.listCommunity(commid, stitle, mtitle,
				(index - 1) * size, size);
		long total = extOpenOrderFinanceMapper.countListCommunity(commid, stitle, mtitle);
		if (!list.isEmpty()) {
			String sids = "";
			for (Map<String, Object> map : list) {
				sids += "," + map.get("id");
			}
			if (sids.startsWith(",")) {
				sids = sids.substring(1);
			}
			// List<Map<String, Object>> listwa2 =
			// extOpenOrderFinanceMapper.sumWithdrawalAmount(commid,"2,3,5",
			// sids);
			// List<Map<String, Object>> listwa4 =
			// extOpenOrderFinanceMapper.sumWithdrawalAmount(commid,"4", sids);
			List<Map<String, Object>> listsc2 = extOpenOrderFinanceMapper.sumServiceChargeCommunity(commid, "2", sids);
			List<Map<String, Object>> listsc3 = extOpenOrderFinanceMapper.sumServiceChargeCommunity(commid, "3", sids);
			// List<Map<String, Object>> listpc =
			// extOpenOrderFinanceMapper.sumPlatformCharge(commid,sids);
			for (Map<String, Object> map : list) {
				Integer sid = MapUtils.getInteger(map, "id", 0);
				// map.put("sum_un_withdrawal_amount", extractData(sid,
				// listwa2));
				// map.put("sum_withdrawal_amount", extractData(sid, listwa4));
				map.put("sum_un_service_charge", extractData(sid, listsc2));
				map.put("sum_service_charge", extractData(sid, listsc3));
				// map.put("sum_platform_charge", extractData(sid, listpc));
				//
			}
		}
		PageList<Map<String, Object>> pl = new PageList<>(list, new Paginator(index, size, total));
		//
		return Result.successData(pl.convert());
	}

	private Object extractData(Integer sid, List<Map<String, Object>> list) {
		for (Map<String, Object> map : list) {
			Integer temp = MapUtils.getInteger(map, "service_id");
			if (sid.intValue() == temp) {
				return new BigDecimal(MapUtils.getString(map, "sum", "0"));
			}
		}
		return 0;
	}

	@RequestMapping("/listTotalOpenOrderFinance")
	public Result<?> listTotalOpenOrderFinance(
			@RequestParam(value = "cityId", required = false, defaultValue = "0") int cityId,
			@RequestParam(value = "communityIds", required = false, defaultValue = "0") String communityIds
			) throws Exception {
		// 现在只能查询一个社区,2017-12-15
		Integer commid = Integer.valueOf(communityIds);
		JSONObject json = new JSONObject();
		// Integer commid = getCommunityId();
		// json.put("sum_un_withdrawal_amount",
		// getDouble(extOpenOrderFinanceMapper.sumTotalWithdrawalAmount(commid,"2,3,5")));
		// json.put("sum_withdrawal_amount",
		// getDouble(extOpenOrderFinanceMapper.sumTotalWithdrawalAmount(commid,"4")));
		json.put("sum_un_service_charge",
				getDouble(extOpenOrderFinanceMapper.sumTotalServiceChargeCommunity(commid, "2")));
		json.put("sum_service_charge",
				getDouble(extOpenOrderFinanceMapper.sumTotalServiceChargeCommunity(commid, "3")));
		json.put("__community_id", commid);
		// json.put("sum_platform_charge",
		// getDouble(extOpenOrderFinanceMapper.sumTotalPlatformCharge(commid)));
		//
		return Result.successData(json);
	}

	private double getDouble(Double d) {
		return d == null ? 0d : d;
	}
}
