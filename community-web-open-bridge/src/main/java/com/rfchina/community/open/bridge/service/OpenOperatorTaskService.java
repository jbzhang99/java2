package com.rfchina.community.open.bridge.service;

import com.rfchina.community.base.Constant;
import com.rfchina.community.base.OpenOperatorTaskConstant;
import com.rfchina.community.base.util.DateTimeUtils;
import com.rfchina.community.component.WorkOrderComponent;
import com.rfchina.community.open.bridge.controller.task.NoticeExecutor;
import com.rfchina.community.open.bridge.mapper.ext.ExtOpenOperatorTaskBridgeMapper;
import com.rfchina.community.persistence.mapper.*;
import com.rfchina.community.persistence.model.*;
import com.rfchina.community.persistence.model.ext.*;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author:fukangwen
 * @Description: 运营任务
 */
@Service
public class OpenOperatorTaskService extends BaseService {
	@Autowired
	private OpenOperatorTaskMapper openOperatorTaskMapper;
	@Autowired
	private OpenOperatorTaskRelMapper openOperatorTaskRelMapper;
	@Autowired
	private CommunityServiceService communityServiceService;
	@Autowired
	private CommunityMapper communityMapper;
	@Autowired
	private OpenXFSJInfoMapper openXFSJInfoMapper;
	@Autowired
	private ExtOpenOperatorTaskBridgeMapper extOpenOperatorTaskBridgeMapper;
	@Autowired
	private OpenMerchantInfoMapper openMerchantInfoMapper;
	@Autowired
	private OpenStoreServiceTempleteMapper openStoreServiceTempleteMapper;
	@Autowired
	private OpenOrderService openOrderService;
	@Autowired
	private CommunityServiceCategoryService communityServiceCategoryService;
	@Autowired
	private OpenXFSJInfoDetailMapper openXFSJInfoDetailMapper;
	@Autowired
	private WorkOrderComponent workOrderComponent;

	/**
	 * 新增任务batch
	 * @param cityId
	 * @param communityId
	 * @param xfsjId
	 * @param serviceIds
	 * @param address
	 * @param helpDetail
	 * @param beginDate
	 * @param endDate
	 */

	@Transactional
	public void insertTaskBatch(int cityId, int communityId, long xfsjId, String serviceIds, String address,
	String helpDetail, Date beginDate, Date endDate){
		//判断小富市集是否存在，是否可以创建
		OpenXFSJInfo info = openXFSJInfoMapper.selectByPrimaryKey(xfsjId);
		validator(info == null ,"该活动不存在");
//		validator(info.getStatus() == OpenXFSJConstant.Status.ACT_STATUS_INVALID, "活动已停止,不能创建任务");

		//验证服务id是否存在
		String[] serviceIdArr = serviceIds.split(",");
		for(String serviceIdStr : serviceIdArr){
			int serviceId = Integer.parseInt(serviceIdStr);
			this.insertTask(cityId, communityId, xfsjId, serviceId, address,
					helpDetail, beginDate, endDate);
		}


	}

	public void insertTask(int cityId, int communityId, long xfsjId, int serviceId, String address,
								String helpDetail, Date beginDate, Date endDate){
		//验证任务在该时间段是否存在
		CommunityService communityService = communityServiceService.getCommunityService(serviceId);
		validator(communityService == null , "店铺不存在");
		validator(communityService.getStatus() != Constant.CommunityService.Status.ENABLE, "有店铺未审核通过");
		insertCheck(communityId, serviceId, beginDate, endDate);

		OpenOperatorTask task = new OpenOperatorTask();
		task.setAddress(address);
		task.setCityId(cityId);
		task.setCommunityId(communityId);
		task.setCreateTime(new Date());
		task.setEndTime(endDate);
		task.setHelpDetail(helpDetail);
		task.setReceiveStatus(OpenOperatorTaskConstant.ReceiveStatus.no_receive);
		task.setReleaseStatus(OpenOperatorTaskConstant.ReleaseStatus.no_start.getCode());
		task.setServiceId(serviceId);
		task.setMerchantId(communityService.getMerchantId());
		task.setStartTime(beginDate);
		task.setXfsjId(xfsjId);
		openOperatorTaskMapper.insertSelective(task);
	}

	/**
	 * 判断该的商家是否已经创建过该时间段的任务，如果有就不能再创建了
	 * @param communityId
	 * @param communityId
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public void insertCheck(int communityId, int serviceId, Date beginDate, Date endDate){
		OpenOperatorTaskExample example = new OpenOperatorTaskExample();
		OpenOperatorTaskExample.Criteria criteria = example.createCriteria().andCommunityIdEqualTo(communityId)
				.andServiceIdEqualTo(serviceId)
				.andReleaseStatusNotEqualTo(OpenOperatorTaskConstant.ReleaseStatus.stop.getCode())
				.andEndTimeBetween(beginDate, endDate);
		example.or().andCommunityIdEqualTo(communityId)
				.andReleaseStatusNotEqualTo(OpenOperatorTaskConstant.ReleaseStatus.stop.getCode())
				.andServiceIdEqualTo(serviceId).andStartTimeBetween(beginDate, endDate);
		long count = openOperatorTaskMapper.countByExample(example);
		validator(count > 0, "创建失败,对应时间段内已存在该商家的任务");

	}

	/**
	 * 判断该的商家是否已经创建过该时间段的任务，如果有就不能再创建了
	 * @param communityId
	 * @param communityId
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public void editCheck(long taskId, int communityId, int serviceId, Date beginDate, Date endDate){
		OpenOperatorTaskExample example = new OpenOperatorTaskExample();
		OpenOperatorTaskExample.Criteria criteria = example.createCriteria().andCommunityIdEqualTo(communityId)
				.andReleaseStatusNotEqualTo(OpenOperatorTaskConstant.ReleaseStatus.stop.getCode())
				.andServiceIdEqualTo(serviceId).andEndTimeBetween(beginDate, endDate).andIdNotEqualTo(taskId);
		example.or().andCommunityIdEqualTo(communityId)
				.andReleaseStatusNotEqualTo(OpenOperatorTaskConstant.ReleaseStatus.stop.getCode())
				.andServiceIdEqualTo(serviceId).andStartTimeBetween(beginDate, endDate).andIdNotEqualTo(taskId);
		long count = openOperatorTaskMapper.countByExample(example);
		validator(count > 0, "修改失败,对应时间段内已存在该商家的任务");

	}

	public PageList<ExtOpenOperatorTask> pageQuery(int cityId, int communityId, String merchantName, String serviceName, long taskId,
				String categoryId, String activityTitle, Integer releaseStatus,
				Integer receiveStatus,Integer timeStatus, int index, int size){
		Map<String, Object> param = new HashMap<>();
		if (cityId > 0) {
			param.put("cityId", cityId);
		}
		if (communityId > 0) {
			param.put("communityId", communityId);
		}
		if (StringUtils.isNotBlank(merchantName)) {
			param.put("merchantName","%" + merchantName + "%");
		}
		if (StringUtils.isNotBlank(serviceName)) {
			param.put("serviceName","%" + serviceName + "%");
		}
		if (taskId > 0) {
			param.put("taskId", taskId);
		}
		if (StringUtils.isNotBlank(categoryId)) {
			param.put("categoryId", Integer.parseInt(categoryId));
		}
		if (StringUtils.isNotBlank(activityTitle)) {
			param.put("activityTitle", "%" + activityTitle + "%");
		}
		if (releaseStatus != null) {
			param.put("releaseStatus", releaseStatus);
		}
		if (receiveStatus != null) {
			param.put("receiveStatus", receiveStatus);
		}
		if (timeStatus != null) {
			param.put("timeStatus", timeStatus);
		}

		PageBounds pageBounds = new PageBounds(index, size);

		PageList<ExtOpenOperatorTask> pager = extOpenOperatorTaskBridgeMapper.pageQuery(param, pageBounds);
		for(ExtOpenOperatorTask ext : pager){
			BigDecimal sum = openOrderService.sumAmount(ext.getId(), null,null, false);
			ext.setSumAmount(sum);
			ext.setTimeStatus(getTaskTimeStatus(ext.getStartTime(), ext.getEndTime()));
			ext.setRateStatus(this.getTaskRateStatus(ext.getStartTime(), ext.getEndTime(),
					ext.getReleaseStatus(), ext.getReceiveStatus()));
		}
		return pager;
	}

	private int getTaskTimeStatus(Date startTime, Date endTime){
		long now = System.currentTimeMillis();
		if(endTime.getTime() < now){
			return OpenOperatorTaskConstant.TimeStatus.over.getCode();
		}

		if(startTime.getTime() > now){
			return OpenOperatorTaskConstant.TimeStatus.no_start.getCode();
		}

		return OpenOperatorTaskConstant.TimeStatus.running.getCode();
	}


	// 0“-”：任务未发布时，显示为-
	//1未被领取：任务已发布，未被运营者领取。若运营者被剔除，但是未到任务结束时间，此时也会更新为未被领取
	//2筹备中：任务被领取，但未到任务开始时间
	//3进行中：任务被领取，且到了任务开始时间
	//4已结束：任务被领取，到了任务结束时间或者任务被停用。
	private int getTaskRateStatus(Date startTime, Date endTime, int releaseStatus, int receiveStatus){
		if(releaseStatus == OpenOperatorTaskConstant.ReleaseStatus.no_start.getCode())
			return OpenOperatorTaskConstant.RateStatus.no_release.getCode();

		long now = System.currentTimeMillis();
		if(releaseStatus == OpenOperatorTaskConstant.ReleaseStatus.stop.getCode()
				|| endTime.getTime() < now){
			return OpenOperatorTaskConstant.RateStatus.over.getCode();
		}

		if(receiveStatus == OpenOperatorTaskConstant.ReceiveStatus.receive &&
				(startTime.getTime() < now && endTime.getTime() > now)){
			return OpenOperatorTaskConstant.RateStatus.running.getCode();
		}

		if(receiveStatus == OpenOperatorTaskConstant.ReceiveStatus.receive
				&& startTime.getTime() > now){
			return OpenOperatorTaskConstant.RateStatus.before_running.getCode();
		}

		return OpenOperatorTaskConstant.RateStatus.no_receive.getCode();
	}

	public OpenOperatorTaskDetail getTaskDetail(Long taskId){
		OpenOperatorTaskDetail detail = new OpenOperatorTaskDetail();
		OpenOperatorTask task = openOperatorTaskMapper.selectByPrimaryKey(taskId);
		validator(task == null, "该任务不存在");
		//任务信息
		detail.setTask(task);

		//活动信息
		detail.setXfsjInfo(getSimXFSJInfo(task.getXfsjId()));

		//商家信息
		detail.setServiceInfo(getServiceInfo(task.getServiceId()));

		//运营者信息
		detail.setOperatorList(operatorList(taskId));

		return detail;
	}

	private SimXFSJInfo getSimXFSJInfo(long xfsjId){
		OpenXFSJInfo xfsj = openXFSJInfoMapper.selectByPrimaryKey(xfsjId);
		SimXFSJInfo info = new SimXFSJInfo();
		BeanUtils.copyProperties(xfsj, info);
		OpenXFSJInfoDetail detail = openXFSJInfoDetailMapper.selectByPrimaryKey(xfsj.getId());
		info.setDetail(detail == null ? "" : detail.getDetail());
		info.setXfsjId(xfsj.getId());
		Community community = communityMapper.selectByPrimaryKey(xfsj.getCommunityId());
		info.setCommunityName(community.getName());
		info.setCityId(community.getCityId());
		info.setCityName(community.getCityName());
		CommunityServiceCategory category = communityServiceCategoryService.getCommunityServiceCategory(info.getCategoryId());
		info.setCategoryName(category == null ? "" : category.getName());
		return info;
	}

	private SimServiceInfo getServiceInfo(int serviceId) {
		CommunityService service = communityServiceService.getCommunityService(serviceId);
		SimServiceInfo serviceInfo = new SimServiceInfo();
		BeanUtils.copyProperties(service, serviceInfo);
		serviceInfo.setServiceId(service.getId());
		serviceInfo.setServiceName(service.getTitle());
		serviceInfo.setMerchantId(service.getMerchantId());

		OpenMerchantInfo merchantInfo = openMerchantInfoMapper.selectByPrimaryKey(service.getMerchantId());
		serviceInfo.setMerchantName(merchantInfo.getTitle());
		serviceInfo.setContactPhone(merchantInfo.getContactPhone());
		serviceInfo.setAccount(merchantInfo.getUserName());

		OpenStoreServiceTemplete templete = openStoreServiceTempleteMapper.selectByPrimaryKey(serviceId);
		serviceInfo.setPhone(templete == null ? "" : templete.getPhone());
		return serviceInfo;
	}


	public void updateReleaseStatus(long taskId, int status){
		OpenOperatorTask task = openOperatorTaskMapper.selectByPrimaryKey(taskId);
		validator(task == null, "该任务不存在");

		int pushType = OpenOperatorTaskConstant.PushType.publish;
		OpenXFSJInfo info = openXFSJInfoMapper.selectByPrimaryKey(task.getXfsjId());

		if(status == OpenOperatorTaskConstant.ReleaseStatus.running.getCode()){
			validator(task.getReleaseStatus() != OpenOperatorTaskConstant.ReleaseStatus.no_start.getCode(), "该任务已经不是未发布状态了");
			task.setReleaseStatus(OpenOperatorTaskConstant.ReleaseStatus.running.getCode());
			task.setReleaseTime(new Date());

			//任务更新
			openOperatorTaskMapper.updateByPrimaryKeySelective(task);
			
			NoticeExecutor.getExecutor().execute(new Runnable() {
				@Override
				public void run() {
					workOrderComponent.sendOperatorTaskPush(OpenOperatorTaskConstant.PushType.publish,
							task.getCommunityId().longValue(), task.getId(), null, info.getActTitile(), null);
				}
			});
		}

		if(status == OpenOperatorTaskConstant.ReleaseStatus.stop.getCode()){
			validator(task.getReleaseStatus() != OpenOperatorTaskConstant.ReleaseStatus.running.getCode(), "该任务已经不是发布状态了");
			task.setReleaseStatus(OpenOperatorTaskConstant.ReleaseStatus.stop.getCode());
			//任务更新
			openOperatorTaskMapper.updateByPrimaryKeySelective(task);

			OpenOperatorTaskRelExample example = new OpenOperatorTaskRelExample();
			example.createCriteria().andValidStatusEqualTo(OpenOperatorTaskConstant.RelValidStatus.valid)
					.andTaskIdEqualTo(taskId);
			List<OpenOperatorTaskRel> relList = openOperatorTaskRelMapper.selectByExample(example);
			if(!relList.isEmpty()){
				OpenOperatorTaskRel rel = relList.get(0);
				rel.setInvalidTime(new Date());
				//停止任务不需要改变抢单状态
//				rel.setValidStatus(OpenOperatorTaskConstant.RelValidStatus.invalid);
				openOperatorTaskRelMapper.updateByPrimaryKeySelective(rel);

				NoticeExecutor.getExecutor().execute(new Runnable() {
					@Override
					public void run() {
						workOrderComponent.sendOperatorTaskPush(OpenOperatorTaskConstant.PushType.stop_task,
								task.getCommunityId().longValue(), task.getId(), rel.getId(), info.getActTitile(), rel.getEmpGuid());
					}
				});
			}

		}



	}

	/**
	 * 运营者信息列表
	 * @param taskId
	 */
	public List<ExtOperator> operatorList(Long taskId){
		OpenOperatorTaskRelExample example = new OpenOperatorTaskRelExample();
		example.createCriteria().andTaskIdEqualTo(taskId);
		example.setOrderByClause("id desc");
		List<OpenOperatorTaskRel> list = openOperatorTaskRelMapper.selectByExample(example);
		List<ExtOperator> extList = new ArrayList<ExtOperator>();
		for(OpenOperatorTaskRel rel : list){
			ExtOperator ext = new ExtOperator();
			BeanUtils.copyProperties(rel,ext);
			ext.setSumAmount(openOrderService.sumAmount(taskId, rel.getId(),rel.getEmpGuid(), false));
			extList.add(ext);
		}
		return extList;
	}

	/**
	 * 导出
	 * @param cityId
	 * @param communityId
	 * @param merchantName
	 * @param taskId
	 * @param categoryId
	 * @param activityTitle
	 * @param releaseStatus
	 */
	public void export(int cityId, int communityId, String merchantName, String serviceName, long taskId,
		String categoryId, String activityTitle, Integer releaseStatus, Integer receiveStatus, Integer timeStatus,
					   HttpServletResponse response) throws Exception{
		long now = System.currentTimeMillis();
		PageList<ExtOpenOperatorTask> list = this.pageQuery(cityId, communityId, merchantName, serviceName, taskId,
				categoryId, activityTitle,releaseStatus, receiveStatus, timeStatus, 1,Integer.MAX_VALUE);

		String fileName = "运营者任务列表" + DateTimeUtils.format(new Date(), "yyyyMMdd") + ".xlsx";
		response.setContentType("application/octet-stream;charset=utf-8");
		response.addHeader("Content-Disposition",
				"attachment;filename=" + java.net.URLEncoder.encode(fileName, "UTF-8"));

		ServletOutputStream stream = response.getOutputStream();
		Workbook workbook = new XSSFWorkbook();
		// 创建Excel工作簿
		try {
			Sheet sheet = workbook.createSheet("任务列表");
			// 创建表头数据
			Row headerRow = sheet.createRow(0);
			int i=0;
			headerRow.createCell(i++).setCellValue("任务ID");
			headerRow.createCell(i++).setCellValue("城市");
			headerRow.createCell(i++).setCellValue("社区");
			headerRow.createCell(i++).setCellValue("所属业务");
			headerRow.createCell(i++).setCellValue("活动名称");
			headerRow.createCell(i++).setCellValue("商家名称");
			headerRow.createCell(i++).setCellValue("任务销售额");
			headerRow.createCell(i++).setCellValue("任务日期");
			headerRow.createCell(i++).setCellValue("任务进度");
			headerRow.createCell(i++).setCellValue("领取状态");
			headerRow.createCell(i++).setCellValue("发布状态");
			headerRow.createCell(i++).setCellValue("协助事项");

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			// 创建表数据
			int j = 1;
			for (ExtOpenOperatorTask ext : list) {
				Row row = sheet.createRow(j);
				int g = 0;
				// 第1列 任务ID
				row.createCell(g++).setCellValue(ext.getId());
				// 第2列 城市
				row.createCell(g++).setCellValue(ext.getCityName());
				// 第3列 社区
				row.createCell(g++).setCellValue(ext.getCommunityName());
				// 第4列 所属业务
				row.createCell(g++).setCellValue(ext.getCategoryName());
				// 第5列 活动名称
				row.createCell(g++).setCellValue(ext.getActTitile());
				// 第6列 商家名称
				row.createCell(g++).setCellValue(ext.getServiceName());
				// 第7列 任务销售额
				row.createCell(g++).setCellValue(ext.getSumAmount() == null ? "" : ext.getSumAmount().toString());
				// 第8列 任务日期
				row.createCell(g++).setCellValue(ext.getStartTime()==null ? "":sdf.format(ext.getStartTime()) +
				"-" + ext.getEndTime()==null ? "":sdf.format(ext.getEndTime()) );
				// 第9列 任务进度
				row.createCell(g++).setCellValue(OpenOperatorTaskConstant.TimeStatus.getLabel(ext.getTimeStatus()));
				// 第10列 领取状态
				row.createCell(g++).setCellValue(OpenOperatorTaskConstant.ReceiveStatus.getLabel(ext.getReceiveStatus()));
				// 第11列 任务状态
				row.createCell(g++).setCellValue(OpenOperatorTaskConstant.ReleaseStatus.getLabel(ext.getReleaseStatus()));
				// 第12列 协助事项
				row.createCell(g++).setCellValue(ext.getHelpDetail());
				j++;
			}
			logger.info("export task pageQuery time={}", System.currentTimeMillis() - now);
			workbook.write(stream);
		}finally {
			IOUtils.closeQuietly(workbook);
		}
	}

	public void editTask(long taskId, String address, String helpDetail,
						 String startTime, String endTime) throws Exception{
		OpenOperatorTask task = openOperatorTaskMapper.selectByPrimaryKey(taskId);
		validator(task == null, "该任务不存在");
		validator(task.getReleaseStatus() == OpenOperatorTaskConstant.ReleaseStatus.stop.getCode()
				, "任务已经停止,不能修改");

		//发布中只能修改helpDetail
		if(StringUtils.isNotBlank(helpDetail)) {
			task.setHelpDetail(helpDetail);
		}
		if(task.getReleaseStatus() == OpenOperatorTaskConstant.ReleaseStatus.no_start.getCode()){
			Date beginDate = null;
			Date endDate = null;
			if(StringUtils.isNotBlank(startTime) && StringUtils.isNotBlank(endTime)){
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				beginDate = DateTimeUtils.date000000(sdf.parse(startTime));
				endDate= DateTimeUtils.date235959(sdf.parse(endTime));
				validator(endDate.getTime() <= beginDate.getTime(), "活动开始时间要小于结束时间");
			}
			if(beginDate != null && endDate != null){
				task.setStartTime(beginDate);
				task.setEndTime(endDate);
				//修改时间需要验证是否已经存在为停止的任务
				editCheck(taskId, task.getCommunityId(), task.getServiceId(),beginDate, endDate);
			}
			if(StringUtils.isNotBlank(address)) {
				task.setAddress(address);
			}
		}
		openOperatorTaskMapper.updateByPrimaryKeySelective(task);
	}

	//踢除运营者
	@Transactional
	public void quitOperator(Long relId){
		OpenOperatorTaskRel rel = openOperatorTaskRelMapper.selectByPrimaryKey(relId);
		validator(rel == null, "运营者信息不存在");
		validator(rel.getValidStatus() == OpenOperatorTaskConstant.RelValidStatus.invalid,
				"该运营者已经是踢除状态了");
		rel.setValidStatus(OpenOperatorTaskConstant.RelValidStatus.invalid);
		rel.setInvalidTime(new Date());
		openOperatorTaskRelMapper.updateByPrimaryKeySelective(rel);

		//任务的领取状态变成未领取
		OpenOperatorTask task = openOperatorTaskMapper.selectByPrimaryKey(rel.getTaskId());
		validator(task == null, "运营任务不存在");
		task.setReceiveStatus(OpenOperatorTaskConstant.ReceiveStatus.no_receive);
		openOperatorTaskMapper.updateByPrimaryKeySelective(task);

		OpenXFSJInfo info = openXFSJInfoMapper.selectByPrimaryKey(task.getXfsjId());
		//调用管家接口通知
		NoticeExecutor.getExecutor().execute(new Runnable() {
			@Override
			public void run() {
				workOrderComponent.sendOperatorTaskPush(OpenOperatorTaskConstant.PushType.quit_operator,
						task.getCommunityId().longValue(), task.getId(),rel.getId(), info.getActTitile(), rel.getEmpGuid());
			}
		});
	}

	public void updateTaskAndOperator(String empGuid, String communityIds){

		OpenOperatorTaskExample example = new OpenOperatorTaskExample();
		OpenOperatorTaskExample.Criteria criteria = example.createCriteria()
					.andReceiveStatusEqualTo(OpenOperatorTaskConstant.ReceiveStatus.receive)
					.andReleaseStatusEqualTo(OpenOperatorTaskConstant.ReleaseStatus.running.getCode())
					.andEmpGuidEqualTo(empGuid);
		if(StringUtils.isNotBlank(communityIds)){
			String[] ids = communityIds.split(",");
			List<Integer> list = new ArrayList<Integer>();
			for(String idStr :ids){
				list.add(Integer.parseInt(idStr));
			}
			criteria.andCommunityIdNotIn(list);
		}

		List<OpenOperatorTask> taskList = openOperatorTaskMapper.selectByExample(example);
		logger.info("empGuid:{}, communityIds:{}, taskList:{}", empGuid, communityIds,taskList.size());
		if(taskList.isEmpty())
			return;

		for(OpenOperatorTask task : taskList){
			OpenOperatorTaskRelExample relExample = new OpenOperatorTaskRelExample();
			relExample.createCriteria().andEmpGuidEqualTo(empGuid).andTaskIdEqualTo(task.getId())
					.andValidStatusEqualTo(1);

			List<OpenOperatorTaskRel> relList = openOperatorTaskRelMapper.selectByExample(relExample);
			if(relList.isEmpty())
				return;

			//
			this.quitOperator(relList.get(0).getId());
		}
	}
}
