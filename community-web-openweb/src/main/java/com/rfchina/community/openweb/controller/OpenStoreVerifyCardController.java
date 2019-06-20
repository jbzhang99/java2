package com.rfchina.community.openweb.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rfchina.community.base.Constant;
import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.Result;
import com.rfchina.community.base.util.DateTimeUtils;
import com.rfchina.community.openweb.entity.ExtOpenOrder;
import com.rfchina.community.openweb.entity.ExtOpenStoreVerifyCard;
import com.rfchina.community.openweb.mapper.ext.ExtOpenStoreVerifyCardMapper;
import com.rfchina.community.openweb.service.OpenStoreOrderService;
import com.rfchina.community.service.openser.OpenStoreVerifyCardService;
import com.rfchina.community.service.openser.entity.ExtVerifyCardVO;

@RestController
@RequestMapping(value = Constant.ROOT_PATH_OPENWEB)
public class OpenStoreVerifyCardController extends BaseController {

	@Autowired
	private OpenStoreVerifyCardService openStoreVerifyCardService;
	@Autowired
	private OpenStoreOrderService openStoreOrderService;
	@Autowired
	private ExtOpenStoreVerifyCardMapper extOpenStoreVerifyCardMapper;

	/**
	 * @author:fukangwen
	 * @Description: 扫码获取信息
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping("/get_verify_card_details")
	public Result<?> getVerifyCardDetails(
			@RequestParam(value="code", required=true) String code,
			@RequestParam(value="serviceId", required=true) int serviceId,
			@RequestParam(value="type", required=true) int type //1扫码，2输入
			) {
		//权限检查
		authorityCheck(serviceId);
		ExtOpenStoreVerifyCard data = openStoreOrderService.getVerifyCardDetail(code, type, serviceId);
		return Result.successData(data);
	}
	
	/**
	 * @author:fukangwen
	 * @Description: 核销
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping("/verify_card")
	public Result<?> verifyCard(
			@RequestParam(value="ids", required=true) String ids,
			@RequestParam(value="serviceId", required=true) int serviceId
			) {
		//权限检查
		authorityCheck(serviceId);
		openStoreOrderService.verifyCard(ids, serviceId);
		return Result.success();
	}
	
	/**
	 * @throws java.text.ParseException 
	 * @throws ParseException 
	 * @author:fukangwen
	 * @Description: 扫码获取信息
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping("/verify_card_page_query")
	public Result<?> verifyCardPageQuery(
			@RequestParam(value="serviceId", required=true) int serviceId,
			@RequestParam(value="startCreateTime", required=false) String startCreateTime,
			@RequestParam(value="endCreateTime", required=false) String endCreateTime,
			@RequestParam(value="startVerifyTime", required=false) String startVerifyTime,
			@RequestParam(value="endVerifyTime", required=false) String endVerifyTime,
			@RequestParam(value="code", required=false,defaultValue="") String code,
			@RequestParam(value="goodCode", required=false,defaultValue="") String goodCode,
			@RequestParam(value="outTradeNo", required=false,defaultValue="") String outTradeNo,
			@RequestParam(value="index", required=false, defaultValue="1") int index,
			@RequestParam(value="size", required=false, defaultValue="10") int size
			) throws ParseException, java.text.ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date startCreateDate = null;
		Date endCreateDate = null;
		Date startVerifyDate = null;
		Date endVerifyDate= null;
		if (StringUtils.isNotBlank(startCreateTime)) {
			startCreateDate = DateTimeUtils.date000000(sdf.parse(startCreateTime));
		}
		if (StringUtils.isNotBlank(endCreateTime)) {
			endCreateDate = DateTimeUtils.date235959(sdf.parse(endCreateTime));
		}
		if (StringUtils.isNotBlank(startVerifyTime)) {
			startVerifyDate = DateTimeUtils.date000000(sdf.parse(startVerifyTime));
		}
		if (StringUtils.isNotBlank(endVerifyTime)) {
			endVerifyDate = DateTimeUtils.date235959(sdf.parse(endVerifyTime));
		}
		
		Map<String, Object> param = new HashMap<>();
		if(serviceId > 0){
			param.put("serviceId", serviceId);
		}
		if(startCreateDate != null){
			param.put("startCreateDate", startCreateDate);
		}
		if(endCreateDate != null){
			param.put("endCreateDate", endCreateDate);
		}
		if(StringUtils.isNotBlank(code)){
			param.put("code", "%" + code + "%");
		}
		if(StringUtils.isNotBlank(goodCode)){
			param.put("goodCode", goodCode);
		}
		if(StringUtils.isNotBlank(outTradeNo)){
			param.put("outTradeNo", outTradeNo);
		}
		
		if(startVerifyDate != null){
			param.put("startVerifyDate", startVerifyDate);
		}
		if(endVerifyDate != null){
			param.put("endVerifyDate", endVerifyDate);
		}
		PageBounds pageBounds = new PageBounds(index, size);
		
		PageList<ExtVerifyCardVO> list = extOpenStoreVerifyCardMapper.pageByCondition(param, pageBounds);

		list = this.setVerifyStatusList(list);
		return Result.successData(list.convert());
		
	}
	
	
	/**
	 * 设置溢价
	 * @author maixingnian
	 * @param list
	 * @return
	 */
	private PageList<ExtVerifyCardVO> setVerifyStatusList(PageList<ExtVerifyCardVO>  list) {
		for(ExtVerifyCardVO vo : list) {
			vo.setVerifyStatus(openStoreVerifyCardService.getVerifyStatus(vo.getVerifyStartTime(), vo.getVerifyEndTime(), 
						vo.getVerifyStatus()));
			if(vo.getVerifyStatus() != OpenConstant.VerifyStatus.USED) {
				vo.setCode(openStoreVerifyCardService.hideCode(vo.getCode()));
			}
		}
		return list;
	}

	
	@RequestMapping("/export_verify_card")
	public Result<?> exportVerifyCard(
			@RequestParam(value="serviceId", required=true) int serviceId,
			@RequestParam(value="startCreateTime", required=false) String startCreateTime,
			@RequestParam(value="endCreateTime", required=false) String endCreateTime,
			@RequestParam(value="startVerifyTime", required=false) String startVerifyTime,
			@RequestParam(value="endVerifyTime", required=false) String endVerifyTime,
			@RequestParam(value="code", required=false,defaultValue="") String code,
			@RequestParam(value="goodCode", required=false,defaultValue="") String goodCode,
			@RequestParam(value="outTradeNo", required=false,defaultValue="") String outTradeNo) {
		logger.info("export_verify_card:serviceId={},startCreateTime={},endCreateTime={},startVerifyTime={},endVerifyTime={}"
				+ "code={}, goodCode={}, outTradeNo{}",serviceId, startCreateTime, endCreateTime,startVerifyTime,endVerifyTime,code,goodCode,outTradeNo);
		InputStream is = null;
		OutputStream os = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date startCreateDate = null;
			Date endCreateDate = null;
			Date startVerifyDate = null;
			Date endVerifyDate= null;
			if (StringUtils.isNotBlank(startCreateTime)) {
				startCreateDate = DateTimeUtils.date000000(sdf.parse(startCreateTime));
			}
			if (StringUtils.isNotBlank(endCreateTime)) {
				endCreateDate = DateTimeUtils.date235959(sdf.parse(endCreateTime));
			}
			if (StringUtils.isNotBlank(startVerifyTime)) {
				startVerifyDate = DateTimeUtils.date000000(sdf.parse(startVerifyTime));
			}
			if (StringUtils.isNotBlank(endVerifyTime)) {
				endVerifyDate = DateTimeUtils.date235959(sdf.parse(endVerifyTime));
			}
			
			Map<String, Object> param = new HashMap<>();
			if(serviceId > 0){
				param.put("serviceId", serviceId);
			}
			if(startCreateDate != null){
				param.put("startCreateDate", startCreateDate);
			}
			if(endCreateDate != null){
				param.put("endCreateDate", endCreateDate);
			}
			if(StringUtils.isNotBlank(code)){
				param.put("code", "%" + code + "%");
			}
			if(StringUtils.isNotBlank(goodCode)){
				param.put("goodCode", goodCode);
			}
			if(StringUtils.isNotBlank(outTradeNo)){
				param.put("outTradeNo", outTradeNo);
			}
			
			if(startVerifyDate != null){
				param.put("startVerifyDate", startVerifyDate);
			}
			if(endVerifyDate != null){
				param.put("endVerifyDate", endVerifyDate);
			}

			// 生成文件
			String filePath = this.createVerifyWorkBook(param);
			if (filePath == null) {
				error("导出核销记录失败");
			}

			// 把生成的文件进行导出
			File file = new File(filePath);
			is = new BufferedInputStream(new FileInputStream(file));
			os = new BufferedOutputStream(response.getOutputStream());
			response.setContentType("application/octet-stream;charset=utf-8");
			response.addHeader("Content-Disposition", "attachment;filename="
					+ new String(("【"+ DateTimeUtils.format(new Date(), DateTimeUtils.DATE_FORMAT) + "】核销记录.xlsx").getBytes(), "iso-8859-1"));
			response.addHeader("Content-Length", "" + file.length());
			int len = 0;
			byte[] buffer = new byte[2048];
			while ((len = is.read(buffer, 0, buffer.length)) != -1) {
				os.write(buffer, 0, len);
			}
			logger.debug("导出核销记录完成");
		} catch (Exception e) {
			error("导出核销记录失败");
		} finally {
			try {
				if (os != null) {
					os.close();
				}

				if (is != null) {
					is.close();
				}
			} catch (Exception e2) {
				error("导出核销记录出错");
			}
		}

		return Result.success();
	}
	
	
	private String createVerifyWorkBook(Map<String, Object> param) throws FileNotFoundException, IOException {
		
		PageBounds pageBounds = new PageBounds(1, 20000);
		PageList<ExtVerifyCardVO> list = extOpenStoreVerifyCardMapper.pageByCondition(param, pageBounds);
		list = this.setVerifyStatusList(list);
		// 创建Excel工作簿
		Workbook workbook = new XSSFWorkbook();
		
		Sheet sheet = workbook.createSheet("核销记录");

		// 创建表头数据
		Row headerRow = sheet.createRow(0);
		int i=0;
		headerRow.createCell(i++).setCellValue("卡券创建时间");
		headerRow.createCell(i++).setCellValue("商品卡券号");
		headerRow.createCell(i++).setCellValue("关联的服务订单号");
		headerRow.createCell(i++).setCellValue("商品编号");
		headerRow.createCell(i++).setCellValue("卡券价格");
		headerRow.createCell(i++).setCellValue("卡券名称");
		headerRow.createCell(i++).setCellValue("核销状态");
		headerRow.createCell(i++).setCellValue("卡券有效期");
		headerRow.createCell(i++).setCellValue("核销时间");
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		// 创建表数据
		int j = 1;
		for (ExtVerifyCardVO extVerifyCardVO : list) {
			Row row = sheet.createRow(j);
			int g = 0;
			// 第1列 卡券创建时间
			row.createCell(g++).setCellValue(sdf.format(extVerifyCardVO.getCreateTime()));
			// 第2列 商品卡券号
			row.createCell(g++).setCellValue(extVerifyCardVO.getCode());
			// 第3列 关联的服务订单号
			row.createCell(g++).setCellValue(extVerifyCardVO.getOutTradeNo());
			// 第4列 商品编号
			row.createCell(g++).setCellValue(extVerifyCardVO.getGoodCode());
			// 第5列 卡券价格
			row.createCell(g++).setCellValue(str(extVerifyCardVO.getSingleScalePrice()));
			// 第6列 卡券名称
			row.createCell(g++).setCellValue(extVerifyCardVO.getGoodName());
			// 第7列 核销状态
			row.createCell(g++).setCellValue(OpenConstant.VerifyStatus.translate(extVerifyCardVO.getVerifyStatus()));
			// 第8列 卡券有效期
			row.createCell(g++).setCellValue(sdf2.format(extVerifyCardVO.getVerifyStartTime()) + "-" + sdf2.format(extVerifyCardVO.getVerifyEndTime()));
			// 第9列 核销时间
			row.createCell(g++).setCellValue(extVerifyCardVO.getVerifyTime() == null ? "-" : sdf.format(extVerifyCardVO.getVerifyTime()));

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
		String storeFileName =  "核销记录_" + System.currentTimeMillis() + ".xlsx";
		workbook.write(new FileOutputStream(new File(storeFilePath + "/" + storeFileName)));
		workbook.close();
		logger.debug("生成excel文件到本地完成,文件保存路径为：" + storeFilePath + "/" + storeFileName);

		return storeFilePath + "/"+storeFileName;
	}

	private String str(Object obj) {
		if(obj==null)return "";
		return obj.toString();
	}
}
