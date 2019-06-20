package com.rfchina.community.open.bridge.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.rfchina.community.base.exception.WorkRunTimeException;
import com.rfchina.community.base.util.HttpUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 */
public abstract class BaseController {

	protected final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	protected HttpServletResponse response;

	protected String getIp2(HttpServletRequest request) {
		return HttpUtil.getIp2(request);
	}

	protected void error(String msg) {
		throw new WorkRunTimeException(msg);
	}

	protected void error(Exception e) {
		throw new RuntimeException(e);
	}
	
	protected void validator(boolean fag, String msg) {
		if (fag) {
			error(msg);
		}
	}

	protected Date convertDate(String date, String pattern){
		try {
			if (StringUtils.isNotBlank(date)) {
				if(StringUtils.isBlank(pattern)){
					pattern = "yyyy-MM-dd HH:mm:ss";
				}
				SimpleDateFormat sdf = new SimpleDateFormat(pattern);
					return sdf.parse(date);
			}
		} catch (ParseException e) {
			logger.error("转换时间错误",e);
		}
		return null;
	}

	protected Date convertDate(String date){
		return convertDate(date,null);
	}



	/**
	 * 将一个json字串转为list
	 * @return
	 */
	protected List<?> converFormString(String converString, Class targetClass){

		if (converString == null || converString.equals("")) {
			return new ArrayList();
		}
		List<?> list = null;
		try {
			list = JSONArray.parseArray(converString, targetClass);
		}catch (Exception e){
			this.error("参数传递错误");
		}


		return list;
	}
}
