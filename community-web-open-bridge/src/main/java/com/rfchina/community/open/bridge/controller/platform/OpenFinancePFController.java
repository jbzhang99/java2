package com.rfchina.community.open.bridge.controller.platform;

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
@RequestMapping(value = OpenConstant.ROOT_PATH_PLATFORM)
public class OpenFinancePFController extends BaseController {

	@Autowired
	private ExtOpenOrderFinanceMapper extOpenOrderFinanceMapper;


	//资金统计
	@RequestMapping("/listOpenOrderFinance")
	public Result<?> listOpenOrderFinance(
			@RequestParam(value = "index", required = false, defaultValue = "1") int index,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size, String stitle, String mtitle)
	{
		stitle = BaseSqlUtil.whereLike(stitle);
		mtitle = BaseSqlUtil.whereLike(mtitle);
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
		List<Map<String, Object>> list = extOpenOrderFinanceMapper.listOrderFinance(stitle, mtitle, (index - 1) * size, size);
		long total = extOpenOrderFinanceMapper.countListPF(stitle, 	mtitle);
		PageList<Map<String, Object>> pl = new PageList<>(list, new Paginator(index, size, total));
		return Result.successData(pl.convert());
	}

	//资金统计
	@RequestMapping("/listTotalOpenOrderFinance")
	public Result<?> listTotalOpenOrderFinance(){
		Map<String, Object> map = extOpenOrderFinanceMapper.totalOrderFinance();
		return Result.successData(map);
	}

}
