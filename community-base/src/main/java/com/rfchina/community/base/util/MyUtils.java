package com.rfchina.community.base.util;

import com.alibaba.fastjson.JSONArray;
import com.rfchina.community.base.exception.WorkRunTimeException;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class MyUtils {
	public static String fillSeats(String abc, int length) {
		String temp = "000000000000000" + abc;
		return temp.substring(temp.length() - length);
	}

	public static void error(String msg) {
		throw new WorkRunTimeException(msg);
	}

	public static String shuzi = "0123456789";

	public static String randomNumeric(int count) {
		if (count < 1) {
			error(" count < 0");
		}
		return RandomStringUtils.randomNumeric(count);
	}

	public static void likeMap(Map<String, Object> example, String... keys) {
		for (String str : keys) {
			String value = MapUtils.getString(example, str, "");
			if (StringUtils.isNotBlank(value)) {
				example.put(str, "%" + value + "%");
			}
		}
	}

	public static Cell setCell(Row row, int cnum, Object obj) {
		Cell cell = row.createCell(cnum);
		if (obj == null) {
			cell.setCellValue("");
		} else {
			if (obj instanceof Date) {
				cell.setCellValue(DateTimeUtils.formatDateTime((Date) obj));
			} else {
				cell.setCellValue(obj.toString());
			}
		}
		return cell;
	}

	public static void setCellTitle(Row row, String titles) {
		String[] ts = titles.split(",");
		for (int i = 0; i < ts.length; i++) {
			setCell(row, i, ts[i]);
		}
	}

	public static ServletOutputStream createServletOutputStream(HttpServletResponse response, String fileName) throws Exception {
		fileName = fileName + DateTimeUtils.format(new Date(), "_yyyyMMdd_HHmmss") + ".xlsx";
		response.setContentType("application/octet-stream;charset=utf-8");
		response.addHeader("Content-Disposition",
				"attachment;filename=" + java.net.URLEncoder.encode(fileName, "UTF-8"));
		return response.getOutputStream();
	}
	
	public static Workbook createXSSFWorkbook() {
		return  new XSSFWorkbook();
	}
	
	public static String getCellValue(Row row, int i) {
		if (row == null)
			return "";
		Cell cell = row.getCell(i);
		if (cell == null)
			return "";
		if (cell.getCellTypeEnum() == CellType.STRING) {
			return cell.getStringCellValue();
		} else if (cell.getCellTypeEnum() == CellType.NUMERIC) {
			return new DecimalFormat("#").format(cell.getNumericCellValue()) + "";
		} else {
			return cell.getStringCellValue();
		}
	}

	/**
	 * 将一个json字串转为list
	 * @return
	 */
	public static List<Integer> converIntegerFormString(String idList){
		if (idList == null || idList.equals(""))
			return new ArrayList();

		return JSONArray.parseArray(idList, Integer.class);
	}

	/**
	 * 将一个json字串转为list
	 * @return
	 */
	public static List<Long> converLongFormString(String idList){
		if (idList == null || idList.equals(""))
			return new ArrayList();

		return JSONArray.parseArray(idList, Long.class);
	}
}
