package com.rfchina.community.openstore.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

/**
 */
public class OpenLogRequestInterceptor implements HandlerInterceptor {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		logger.info("preHandle...getRequestURI:{},method:{},{}", request.getRequestURI(), request.getMethod(),
				JSON.toJSONString(request.getParameterMap()));
		return true;
	}

	/**
	 * @Author wlrllr
	 * @Description 不需要处理
	 * @Date 2018/12/28
	 * @Param [request, response, handler, modelAndView]
	 * @return void
	 **/
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView){
		logger.info("postHandle...getRequestURI:{},method:{},{}", request.getRequestURI(), request.getMethod(),
				JSON.toJSONString(request.getParameterMap()));
	}

	/**
	 * @Author wlrllr
	 * @Description 不需要处理
	 * @Date 2018/12/28
	 * @Param [request, response, handler, ex]
	 * @return void
	 **/
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex){
		logger.info("afterCompletion...getRequestURI:{},method:{},{}", request.getRequestURI(), request.getMethod(),
				JSON.toJSONString(request.getParameterMap()));
	}
}
