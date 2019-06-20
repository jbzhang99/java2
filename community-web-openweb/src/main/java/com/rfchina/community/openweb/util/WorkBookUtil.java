package com.rfchina.community.openweb.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

public class WorkBookUtil {
//
//	public static void downloadExcel(HttpServletResponse response, String fileName, Workbook wb) {
//
//		response.setContentType("application/octet-stream");
//		response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
//		try {
//			wb.write(response.getOutputStream());
//			wb.close();
//			response.getOutputStream().flush();
//			response.getOutputStream().close();
//
//		} catch (IOException e) {
//			throw new RfchinaResponseException(ResponseCode.EnumResponseCode.COMMON_FAILURE, "下载文件失败");
//		}
//	}
//
//	public static void downloadExcel(HttpServletResponse response, Workbook workBook, String title) {
//		String fileName = "";
//		try {
//			fileName = new String(title.getBytes(), "iso-8859-1");
//		} catch (UnsupportedEncodingException e) {
//			throw new RfchinaResponseException(ResponseCode.EnumResponseCode.COMMON_FAILURE, "下载文件失败");
//		}
//		downloadExcel(response, fileName + ".xls", workBook);
//	}

	public static String getCellValue(Row row, int i) {
		if (row == null)
			return "";
		Cell cell = row.getCell(i);
		if (cell == null)
			return "";
		if (cell.getCellTypeEnum() == CellType.STRING) {
			return cell.getStringCellValue();
		} else if (cell.getCellTypeEnum() == CellType.NUMERIC) {
			return cell.getNumericCellValue() + "";
		} else {
			return cell.getStringCellValue();
		}
	}

	public static void createCellValue(Row row, int i, String title) {
		if (row == null)
			return;
		Cell cell = row.createCell(i);
		cell.setCellValue(title);
	}
}
