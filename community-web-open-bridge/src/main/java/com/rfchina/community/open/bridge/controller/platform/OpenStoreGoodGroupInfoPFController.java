package com.rfchina.community.open.bridge.controller.platform;

import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.Result;
import com.rfchina.community.base.util.RegexUtils;
import com.rfchina.community.open.bridge.controller.BaseController;
import com.rfchina.community.open.bridge.entity.ExtOpenStoreGoodGroupInfo;
import com.rfchina.community.open.bridge.service.OpenStoreGoodGroupInfoService;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.paginator.model.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *团购管理
 */
@RestController
@RequestMapping(value = OpenConstant.ROOT_PATH_PLATFORM)
public class OpenStoreGoodGroupInfoPFController extends BaseController {

	@Autowired
	private OpenStoreGoodGroupInfoService openStoreGoodGroupInfoService;


	/**
	 * 新增
	 */
	@RequestMapping(value={"/group_insert"} , method = { RequestMethod.POST })
	public Result<?> insert(
			@RequestParam(value = "goodId") int goodId,
			@RequestParam(value = "peopleNum") int peopleNum,
			@RequestParam(value = "price", required = false, defaultValue = "") String price,
			@RequestParam(value = "groupPrice", required = false, defaultValue = "") String groupPrice,
			@RequestParam(value = "stock") int stock,
			@RequestParam(value = "startTime", required = false, defaultValue = "") String startTime,
			@RequestParam(value = "endTime", required = false, defaultValue = "") String endTime,
			@RequestParam(value = "limitTimes") int limitTimes,
			@RequestParam(value = "virturalSuccessHour") int virturalSuccessHour
			) throws ParseException {

		//验证参数
		validator(!RegexUtils.isPositiveNum(price), "商品现价必须为正的数字");
		validator(!RegexUtils.isPositiveNum(groupPrice), "商品团购价必须为正的数字");
		validator(peopleNum <= 1, "成团人数必须大于1");
		validator(stock <= 0, "团购库存必须大于0");
		validator(limitTimes <= 0 , "购买限制参数有误");
		validator(StringUtils.isBlank(startTime), "活动开始时间不能为空");
		validator(StringUtils.isBlank(endTime), "活动结束时间不能为空");

		// 转换参数
		BigDecimal decimalPrice = new BigDecimal(price);
		BigDecimal decimalGroupPrice = new BigDecimal(groupPrice);
		validator(decimalGroupPrice.compareTo(decimalPrice) >= 0, "商品团购价必须比商品单买价小");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date startDate = sdf.parse(startTime);
		Date endDate = sdf.parse(endTime);
		Long duration = endDate.getTime()-startDate.getTime();
		validator(duration<=0, "活动开始时间要小于结束时间");
		validator((duration/1000)<=(virturalSuccessHour*3600), "活动时长要大于成团时间");
		validator(System.currentTimeMillis() > startDate.getTime(), "活动开始时间要大于等于当前时间");
		//调用新增方法
		openStoreGoodGroupInfoService.insert(goodId, peopleNum, decimalPrice, decimalGroupPrice,
				stock , startDate, endDate, limitTimes, virturalSuccessHour);
		return Result.success();
	}

	/**
	 * 修改
	 */
	@RequestMapping(value={"/group_update"} , method = { RequestMethod.POST })
	public Result<?> update(
			@RequestParam(value = "id") long id,
			@RequestParam(value = "stock") int stock,
			@RequestParam(value = "endTime", required = false, defaultValue = "") String endTime
	) throws ParseException {

		//验证参数
		validator(stock <= 0, "团购库存必须大于0");
		validator(StringUtils.isBlank(endTime), "活动结束时间不能为空");

		// 转换参数
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date endDate = sdf.parse(endTime);

		openStoreGoodGroupInfoService.update(id, stock , endDate);
		return Result.successData(null);
	}

	/**
	 * 禁用
	 */
	@RequestMapping(value={"/group_forbidden"} , method = { RequestMethod.POST })
	public Result<?> forbidden(
			@RequestParam(value = "id") long id
	) {
		openStoreGoodGroupInfoService.forbidden(id);
		return Result.success();
	}

	/**
	 * 详情
	 */
	@RequestMapping(value={"/group_getDetail"} )
	public Result<?> getDetail(
			@RequestParam(value = "id") long id
		) {
		return Result.successData(openStoreGoodGroupInfoService.getDetail(id));
	}


	/**
	 * 列表搜索
	 */
	@RequestMapping(value={"/group_pageByParam"})
	public Result<?> pageByParam(
			@RequestParam(value = "goodName", required = false, defaultValue = "") String goodName,
			@RequestParam(value = "serviceName", required = false, defaultValue = "") String serviceName,
			@RequestParam(value = "merchantName", required = false, defaultValue = "") String merchantName,
			@RequestParam(value = "groupInfoStatus", required = false) Integer groupInfoStatus,
			@RequestParam(value = "index", required = false, defaultValue = "1") int index,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size
	) {
		PageList<ExtOpenStoreGoodGroupInfo> list = openStoreGoodGroupInfoService.pageByParam(goodName, serviceName,
				merchantName, groupInfoStatus, index, size);
		return Result.successData(list.convert());
	}

	/**
	 * 下载二维码
	 */
	@RequestMapping(value={"/group_getQrcode"})
	public Result<?> getQrcode(
			@RequestParam(value = "goodId") int goodId,
			@RequestParam(value = "communityId") int communityId
	) {
		return Result.successData(openStoreGoodGroupInfoService.getQrcode(goodId, communityId, response));
	}


	/**
	 * 下载服务支持的社区的链接
	 */
	@RequestMapping(value = {"/group_downloadLinkBatch"} )
	public void downloadLinkBatch(HttpServletResponse response,
		 @RequestParam(value = "goodId", required = true) int goodId) throws IOException {
		openStoreGoodGroupInfoService.downloadLinkBatch(goodId, response);
	}


}
