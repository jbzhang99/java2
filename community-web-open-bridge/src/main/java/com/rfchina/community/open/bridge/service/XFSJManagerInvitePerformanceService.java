package com.rfchina.community.open.bridge.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.mybatis.paginator.model.Page;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rfchina.community.base.OpenXFSJConstant;
import com.rfchina.community.component.WorkOrderComponent;
import com.rfchina.community.entity.wo.EmpBean;
import com.rfchina.community.entity.wo.GetEmpInfoReq;
import com.rfchina.community.entity.wo.GetEmpInfoRsp;
import com.rfchina.community.open.bridge.entity.ExtOpenManagerInvite;
import com.rfchina.community.open.bridge.entity.ExtOpenManagerInviteMerchant;
import com.rfchina.community.open.bridge.mapper.ext.ExtOpenManagerInviteMapper;


/**
 * @desc 小富市集-管理绩效服务
 * @author maixingnian
 * @since 3.2
 */
@Service
public class XFSJManagerInvitePerformanceService {
	
	private static transient Logger logger = LoggerFactory.getLogger(XFSJManagerInvitePerformanceService.class);
	@Autowired
	private ExtOpenManagerInviteMapper extOpenManagerInviteMapper;
	@Autowired
	private WorkOrderComponent workOrderComponent;
	
	/**
	 * 分页查询管家绩效
	 * @param param
	 * @param pageBounds
	 * @return
	 */
	public Page<ExtOpenManagerInvite> queryList(Map<String, Object> param, PageBounds pageBounds) {
		PageList<ExtOpenManagerInvite> eomiList = extOpenManagerInviteMapper.pageByCondition(param, pageBounds);
		//组装empGuidList
		List<String> empGidList = new ArrayList<>();
		for(ExtOpenManagerInvite eomi : eomiList) {
			empGidList.add(eomi.getEmpGuid());
		}
		//获取管家组织层级list(管家接口)-方便取值设置，不需双层循环嵌套
		List<EmpBean> epmList = getEmpBean(empGidList);
		//设置管家对应的城市地区
		Map<String, ExtOpenManagerInvite> eomiMap = List2Map(eomiList);
		for(EmpBean eb : epmList) {
			ExtOpenManagerInvite eomi = eomiMap.get(eb.getEmpGuid());
			eomi.setCtiy(eb.getCityName());
			eomi.setEmpComName(eb.getEmpComName());
			eomi.setEmpProjectName(eb.getEmpProjectName());
			eomi.setEmpDepName(eb.getEmpDepName());
		}
		return eomiList.convert();
	}

	/**
	 * 根据管家手机号码查询邀请商家详情
	 * @param phone 管家手机号码
	 * @return
	 */
	public List<ExtOpenManagerInviteMerchant> queryDetailsByPhone(String phone) {
		PageList<ExtOpenManagerInviteMerchant> list = extOpenManagerInviteMapper.queryDetailsByPhone(phone);
		return list;
	}
	
	/**
	 * 导出文件
	 * @param param
	 * @param pageBounds
	 * @param response
	 */
	public void export(Map<String, Object> param, PageBounds pageBounds, HttpServletResponse response) {
		//查询导出数据
		Page<ExtOpenManagerInvite> page = queryExportData(param, pageBounds);
		//生成文件
		String filePath = createWorkBook(page);
		//导出文件
		exportFile(filePath, response);
	}
	
	/**
	 * 查询导出数据
	 * @param param
	 * @param pageBounds
	 * @return
	 */
	public Page<ExtOpenManagerInvite> queryExportData(Map<String, Object> param, PageBounds pageBounds) {
		//默认从第一页开始导出
		pageBounds.setPage(1);
		//导出条数限制
		if(pageBounds.getLimit() >= OpenXFSJConstant.EXPORT_FILE_MAX_ROW_LIMIT) {
			pageBounds.setLimit(OpenXFSJConstant.EXPORT_FILE_MAX_ROW_LIMIT);
		}
		return queryList(param, pageBounds);
	}
	
	
	/**
	 * 创建EXL文件，保存到文件服务器
	 * @param listData
	 * @return
	 * @throws IOException
	 */
	public String createWorkBook(Page<ExtOpenManagerInvite> listData) {
		// 创建Excel工作簿
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("管家绩效");
		// 创建表头数据
		Row headerRow = sheet.createRow(0);
		int i=0;
		headerRow.createCell(i++).setCellValue("城市");
		headerRow.createCell(i++).setCellValue("公司名称");
		headerRow.createCell(i++).setCellValue("项目名称");
		headerRow.createCell(i++).setCellValue("部门名称");
		headerRow.createCell(i++).setCellValue("管家");
		headerRow.createCell(i++).setCellValue("账号");
		headerRow.createCell(i++).setCellValue("邀请商家");
		// 创建表数据
		int j = 1;
		for (ExtOpenManagerInvite eomi : listData.getList()) {
			Row row = sheet.createRow(j);
			int g = 0;
			// 第1列
			row.createCell(g++).setCellValue(eomi.getCtiy());
			// 第2列
			row.createCell(g++).setCellValue(eomi.getEmpComName());
			// 第3列
			row.createCell(g++).setCellValue(eomi.getEmpProjectName());
			// 第4列
			row.createCell(g++).setCellValue(eomi.getEmpDepName());
			// 第5列
			row.createCell(g++).setCellValue(eomi.getEmpName());
			// 第6列
			row.createCell(g++).setCellValue(eomi.getPhone());
			// 第7列
			row.createCell(g++).setCellValue(eomi.getMerchantCount());

			j++;
		}
		String storeFilePath = System.getProperty("java.class.path");
		int firstIndex = storeFilePath.lastIndexOf(System.getProperty("path.separator")) + 1;
		int lastIndex = storeFilePath.lastIndexOf(File.separator) + 1;
		storeFilePath = storeFilePath.substring(firstIndex, lastIndex) + "/file/export";
		File dir = new File(storeFilePath);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		// 保存文件到服务器
		String storeFileName =  "管家绩效_" + System.currentTimeMillis() + ".xlsx";
		try {
			workbook.write(new FileOutputStream(new File(storeFilePath + "/" + storeFileName)));
		} catch (IOException e) {
			logger.error("生成文件错误" + e);
		} finally {
			try {
				workbook.close();
			} catch (IOException e) {
				logger.error("生成文件错误" + e);
			}
		}
		logger.debug("生成excel文件到本地完成,文件保存路径为：" + storeFilePath + "/" + storeFileName);

		return storeFilePath + "/"+storeFileName;
	}
	
	/**
	 * 导出文件
	 * @param filePath
	 * @param response
	 */
	public void exportFile(String filePath, HttpServletResponse response) {
		InputStream is = null;
		OutputStream os = null;
		// 把生成的文件进行导出
		File file = new File(filePath);
		try {
			is = new BufferedInputStream(new FileInputStream(file));
			os = new BufferedOutputStream(response.getOutputStream());
			response.setContentType("application/octet-stream;charset=utf-8");
			response.addHeader("Content-Disposition", "attachment;filename=" + new String((file.getName().split("_")[0] + ".xlsx").getBytes(), "iso-8859-1"));
			response.addHeader("Content-Length", "" + file.length());
			int len = 0;
			byte[] buffer = new byte[2048];
			while ((len = is.read(buffer, 0, buffer.length)) != -1) {
				os.write(buffer, 0, len);
			}
			logger.debug("导出管家绩效完成");
		} catch (IOException e) {
			logger.error("导出文件错误" + e);
		} finally {
			try {
				if (os != null) {
					os.close();
				}

				if (is != null) {
					is.close();
				}
			} catch (Exception e2) {
				logger.error("导出文件关闭流错误");
			}
		}
		
	}
	

	/**
	 * list转换为map
	 * @param list
	 * @return
	 */
	private Map<String, ExtOpenManagerInvite> List2Map(PageList<ExtOpenManagerInvite> list) {
		Map<String, ExtOpenManagerInvite> map = new HashMap<>();
		for(ExtOpenManagerInvite eomi : list) {
			map.put(eomi.getEmpGuid(), eomi);
		}
		return map;
	}
	
	/**
	 * @author:maixingnian
	 * @Description: 获取管家那边手机账号信息
	 * @return
	 */
	private List<EmpBean> getEmpBean(List<String> empGuids) {
		GetEmpInfoReq getEmpInfoReq = new GetEmpInfoReq();
		getEmpInfoReq.setEmpGuids(empGuids);
		GetEmpInfoRsp getEmpInfoRsp = workOrderComponent.getEmpInfo(getEmpInfoReq);
		return getEmpInfoRsp.getEmpBeans();
	}
	
	public Map<String, EmpBean> getEmpBeanMap(List<String> empGuids){
		if(empGuids.isEmpty())
			return new HashMap<>();
		
		List<EmpBean> list = this.getEmpBean(empGuids);
		Map<String, EmpBean> map = new HashMap<>();
		for(EmpBean empBean : list) {
			map.put(empBean.getEmpGuid(), empBean);
		}
		return map;
	}

}
