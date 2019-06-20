package com.rfchina.community.open.bridge.controller.platform;

import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.Result;
import com.rfchina.community.base.util.DateTimeUtils;
import com.rfchina.community.open.bridge.controller.BaseController;
import com.rfchina.community.open.bridge.service.OpenOperatorTaskService;
import com.rfchina.community.open.bridge.service.OpenOrderService;
import com.rfchina.community.persistence.model.ext.EmpGuidOrderStat;
import com.rfchina.community.persistence.model.ext.ExtOpenOperatorTask;
import com.rfchina.community.persistence.model.ext.OpenOperatorTaskDetail;
import com.rfchina.community.persistence.model.ext.OperatorOrder;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.paginator.model.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = OpenConstant.ROOT_PATH_PLATFORM)
public class OpenOperatorTaskPFController extends BaseController {

	@Autowired
	private OpenOperatorTaskService openOperatorTaskService;
	@Autowired
	private OpenOrderService openOrderService;

	//任务列表
	@RequestMapping(value = { "/operator_task_list" })
	public Result<?> page_query_operator_task(
			@RequestParam(value = "cityId", required = false,defaultValue = "0") int cityId, //城市搜索
			@RequestParam(value = "communityId", required = false,defaultValue = "0") int communityId,	//社区搜索
			@RequestParam(value = "merchantName", required = false,defaultValue = "") String merchantName,	//商家搜索
			@RequestParam(value = "serviceName", required = false,defaultValue = "") String serviceName,	//服务搜索
			@RequestParam(value = "taskId", required = false,defaultValue = "0") long taskId,
			@RequestParam(value = "type", required = false,defaultValue = "") String categoryId,
			@RequestParam(value = "activityTitle", required = false,defaultValue = "") String activityTitle,
			@RequestParam(value = "releaseStatus", required = false) Integer releaseStatus,
			@RequestParam(value = "receiveStatus", required = false) Integer receiveStatus,
			@RequestParam(value = "timeStatus", required = false) Integer timeStatus,
			@RequestParam(value = "activityStatus", required = false) Integer activityStatus,
			@RequestParam(value = "index", required = false, defaultValue = "1") int index,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size) {
		PageList<ExtOpenOperatorTask> list = openOperatorTaskService.pageQuery(cityId, communityId, merchantName, serviceName, taskId,
				categoryId, activityTitle,releaseStatus, receiveStatus, timeStatus, index, size);
		return Result.successData(list.convert());
	}

	//新增任务（可能多个）
	@RequestMapping(value = { "/add_operator_tasks" })
	public Result<?> add_operator_tasks (
			@RequestParam(value = "cityId", required = true) int cityId,
			@RequestParam(value = "communityId", required = true) int communityId,
			@RequestParam(value = "xfsjId", required = true) long xfsjId,
			@RequestParam(value = "serviceIds", required = true) String serviceIds,
			@RequestParam(value = "address", required = true) String address,
			@RequestParam(value = "helpDetail", required = true) String helpDetail,
			@RequestParam(value = "startTime", required = false, defaultValue = "") String startTime,
			@RequestParam(value = "endTime", required = false, defaultValue = "") String endTime)
			throws Exception{
		validator(StringUtils.isBlank(startTime), "活动开始时间不能为空");
		validator(StringUtils.isBlank(endTime), "活动结束时间不能为空");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date beginDate = DateTimeUtils.date000000(sdf.parse(startTime));
		Date endDate = DateTimeUtils.date235959(sdf.parse(endTime));
		validator(endDate.getTime() <= beginDate.getTime(), "活动开始时间要小于结束时间");

		openOperatorTaskService.insertTaskBatch(cityId, communityId, xfsjId, serviceIds, address,
				helpDetail, beginDate, endDate);
		return Result.success();
	}

	//任务详情
	@RequestMapping(value = { "/get_operator_task_detail" })
	public Result<?> get_operator_task_detail(
			@RequestParam(value = "taskId", required = true) long taskId
	) {
		OpenOperatorTaskDetail detail = openOperatorTaskService.getTaskDetail(taskId);
		return Result.successData(detail);
	}

	//发布停用任务
	@RequestMapping(value = { "/update_task_release_status" })
	public Result<?> update_task_release_status(
			@RequestParam(value = "taskId", required = true) long taskId,
			@RequestParam(value = "status", required = true) int status
	) {
		openOperatorTaskService.updateReleaseStatus(taskId, status);
		return Result.success();
	}

	//运营者信息列表
	@RequestMapping(value = { "/operator_task_rel_list" })
	public Result<?> operator_task_rel_list(
			@RequestParam(value = "taskId", required = true) long taskId
	) {
		openOperatorTaskService.operatorList(taskId);
		return Result.success();
	}

	//运营者销售列表
	@RequestMapping(value = { "/operator_task_rel_order_list" })
	public Result<?> operator_task_rel_order_list(
			@RequestParam(value = "taskId", required = false) long taskId,
			@RequestParam(value = "taskRelId", required = true) long taskRelId,
			@RequestParam(value = "empGuid", required = true) String empGuid,
			@RequestParam(value = "index", required = false, defaultValue = "1") int index,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size
	) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", openOrderService.taskOrderList(taskId, taskRelId, empGuid, index, size).convert());
		map.put("stat", openOrderService.taskOrderStat(taskId, taskRelId, empGuid));
		return Result.successData(map);
	}

	//任务修改,发布后只能修改helpDetail
	@RequestMapping(value = { "/operator_task_edit" })
	public Result<?> operator_task_edit(
			@RequestParam(value = "taskId", required = true) long taskId,
			@RequestParam(value = "address", required = false) String address,
			@RequestParam(value = "helpDetail", required = false) String helpDetail,
			@RequestParam(value = "startTime", required = false, defaultValue = "") String startTime,
			@RequestParam(value = "endTime", required = false, defaultValue = "") String endTime
	) throws Exception {

		openOperatorTaskService.editTask(taskId, address, helpDetail, startTime, endTime);
		return Result.success();
	}

	//踢除运营者
	@RequestMapping(value = { "/operator_quit" })
	public Result<?> operator_quit(
			@RequestParam(value = "relId", required = true) long relId
	) {
		openOperatorTaskService.quitOperator(relId);
		return Result.success();
	}


	//任务导出
	@RequestMapping(value = { "/export_operator_task_list" })
	public void export_operator_task_list(
			@RequestParam(value = "cityId", required = false,defaultValue = "0") int cityId, //城市搜索
			@RequestParam(value = "communityId", required = false,defaultValue = "0") int communityId,	//社区搜索
			@RequestParam(value = "merchantName", required = false,defaultValue = "") String merchantName,	//商家搜索
			@RequestParam(value = "serviceName", required = false,defaultValue = "") String serviceName,	//服务搜索
			@RequestParam(value = "taskId", required = false,defaultValue = "0") long taskId,
			@RequestParam(value = "type", required = false,defaultValue = "") String categoryId,
			@RequestParam(value = "activityTitle", required = false,defaultValue = "") String activityTitle,
			@RequestParam(value = "releaseStatus", required = false) Integer releaseStatus,
			@RequestParam(value = "activityStatus", required = false) Integer activityStatus,
			@RequestParam(value = "receiveStatus", required = false) Integer receiveStatus,
			@RequestParam(value = "timeStatus", required = false) Integer timeStatus,
			HttpServletResponse response
	) throws Exception{
		openOperatorTaskService.export(cityId, communityId, merchantName, serviceName,
				taskId, categoryId, activityTitle,releaseStatus, receiveStatus,timeStatus, response);
	}

	//根据运营者id获取管理统计
	@RequestMapping(value = { "/get_operator_stat" })
	public Result<?> get_operator_stat(
			@RequestParam(value = "empGuids", required = true) String empGuids
	) {
		List<EmpGuidOrderStat> list = openOrderService.getOperatorStat(empGuids);
		Map<String, Object> map = new HashMap<String, Object>();
		for(EmpGuidOrderStat stat : list){
			map.put(stat.getEmpGuid(), stat);
		}
		return Result.successData(map);
	}

	//运营者销售记录
	@RequestMapping(value = { "/list_operator_order" })
	public Result<?> list_operator_order(
			@RequestParam(value = "empGuidName", required = false,defaultValue = "") String empGuidName, //姓名
			@RequestParam(value = "empGuidPhone", required = false,defaultValue = "") String empGuidPhone,	//手机
			@RequestParam(value = "outTradeNo", required = false,defaultValue = "") String outTradeNo,	//服务订单号
			@RequestParam(value = "billFinishedStartTime", required = false,defaultValue = "") String billFinishedStartTime,
			@RequestParam(value = "billFinishedEndTime", required = false,defaultValue = "") String billFinishedEndTime,
			@RequestParam(value = "taskId", required = false,defaultValue = "0") long taskId,
			@RequestParam(value = "refundStatus", required = false) Integer refundStatus,
			@RequestParam(value = "serviceName", required = false,defaultValue = "") String serviceName,//店铺名称
			@RequestParam(value = "index", required = false, defaultValue = "1") int index,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size
	) throws Exception{
		Date beginDate = null;
		Date endDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if(StringUtils.isNotBlank(billFinishedStartTime)) {
			beginDate = DateTimeUtils.date000000(sdf.parse(billFinishedStartTime));
		}
		if(StringUtils.isNotBlank(billFinishedEndTime)) {
			endDate = DateTimeUtils.date235959(sdf.parse(billFinishedEndTime));
		}
		PageList<OperatorOrder> list= openOrderService.listOperatorOrder(empGuidName, empGuidPhone,outTradeNo, beginDate,
				endDate, taskId, refundStatus, serviceName, index, size);
		return Result.successData(list.convert());
	}

	//运营者销售记录导出
	@RequestMapping(value = { "/export_operator_order" })
	public void export_operator_order(
			@RequestParam(value = "empGuidName", required = false,defaultValue = "") String empGuidName, //姓名
			@RequestParam(value = "empGuidPhone", required = false,defaultValue = "") String empGuidPhone,	//手机
			@RequestParam(value = "outTradeNo", required = false,defaultValue = "") String outTradeNo,	//服务订单号
			@RequestParam(value = "billFinishedStartTime", required = false,defaultValue = "") String billFinishedStartTime,
			@RequestParam(value = "billFinishedEndTime", required = false,defaultValue = "") String billFinishedEndTime,
			@RequestParam(value = "taskId", required = false,defaultValue = "0") long taskId,
			@RequestParam(value = "refundStatus", required = false) Integer refundStatus,
			@RequestParam(value = "serviceName", required = false,defaultValue = "") String serviceName,//店铺名称
			HttpServletResponse response
	) throws Exception{
		Date beginDate = null;
		Date endDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if(StringUtils.isNotBlank(billFinishedStartTime)) {
			beginDate = DateTimeUtils.date000000(sdf.parse(billFinishedStartTime));
		}
		if(StringUtils.isNotBlank(billFinishedEndTime)) {
			endDate = DateTimeUtils.date235959(sdf.parse(billFinishedEndTime));
		}
		openOrderService.exportOperatorOrder(empGuidName, empGuidPhone,outTradeNo, beginDate,
				endDate, taskId, refundStatus, serviceName, response);
	}


	//根据运营者id和社区ids停用任务跟提出该运营者
	@RequestMapping(value = { "/update_task_and_operator" })
	public Result<?> update_task_and_operator(
			@RequestParam(value = "empGuid", required = true) String empGuid,
			@RequestParam(value = "communityIds", required = false,defaultValue = "") String communityIds
	) {
		openOperatorTaskService.updateTaskAndOperator(empGuid, communityIds);
		return Result.success();
	}



}