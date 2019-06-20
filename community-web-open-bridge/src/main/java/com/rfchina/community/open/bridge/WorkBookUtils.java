package com.rfchina.community.open.bridge;

import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.rfchina.community.base.util.DateTimeUtils;

public class WorkBookUtils {
	public static void setCell(Row row, int cnum, Object obj) {
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

	}

	public static void setTitle(String titles, Row row) {
		// String titles =
		// "ID,appid,服务id,用户UID,社区id,社区名称,社区地址,支付渠道,BILLID,订单创建时间,完成支付时间,支付状态,"
		// + "第三方账号,支付中心账号,总金额,实收金额,平台手续率,平台手续费,社区手续率,社区手续费,拆单状态,"
		// + "拆单时间,母对应的子单,社区结算账号,社区billID,社区状态,提现状态,退款状态,退款金额,退款ID," +
		// "平台渠道对账状态,平台业务对账状态,平台退款状态,平台退款时间,社区提现单";
		String[] ts = titles.split(",");
		// Row row = sheet.createRow(0);
		for (int i = 0; i < ts.length; i++) {
			setCell(row, i, ts[i]);
		}
	}
}
