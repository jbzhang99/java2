package com.rfchina.community.openstore.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rfchina.community.base.Constant;
import com.rfchina.community.base.Result;
import com.rfchina.community.base.util.ValidatorUtil;
import com.rfchina.community.openstore.entity.ext.ExtXFSJInfo;
import com.rfchina.community.openstore.service.CommunityService;
import com.rfchina.community.openstore.service.OpenXFSJService;

/**
 */
@RestController
@RequestMapping(value = {Constant.ROOT_PATH_OPENSTORE})
public class OpenXFSJController extends BaseController {

	@Autowired
	private OpenXFSJService openXFSJService;
	@Autowired
	private CommunityService communityService;
	@Value("${zizai.open.api.url}")
	private String openApiServer;
	@Value("${open.storeapi.url}")
	private String openStoreapiUrl;

	/**
	 * @author:fukangwen
	 * @Description: 获取小富市集活动详情
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping(value = {"/xfsj/get_activity_info"})
	public Result<?> getXFSJActivityInfo(
			@RequestParam(value = "communityId", required = true) int communityId
			) {
		validator(communityId <= 0, "社区参数有误");
		
		ExtXFSJInfo result = openXFSJService.getExtXFSJInfo(communityId);
 		
		return Result.successData(result);
	}
	
	/**
	 * @author:fukangwen
	 * @Description: 获取平台活动详情
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping(value = {"/platform/get_activity_info"})
	public Result<?> getPlatformActivityInfo(
			@RequestParam(value = "xfsjId", required = true) int xfsjId,
			@RequestParam(value="access_token",required = false) String accessToken
			) {
		validator(xfsjId <= 0, "活动参数有误");
		
		if(StringUtils.isNotBlank(accessToken)) {
			Long uid = getUidByToken(accessToken);
			if (uid == null) {
				error("用户未登录");
			}
			logger.info("uid={}",uid);
			request.getSession().setAttribute("uid", uid);
			request.getSession().setAttribute("openId", "xfsj_" + uid);
		}
		
		ExtXFSJInfo result = openXFSJService.getPlatformActivityInfo(xfsjId);
 		
		return Result.successData(result);
	}
	
	/**
	 * @throws IllegalAccessException
	 * @author:fukangwen
	 * @Description: 获取拥有小富市集的社区
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping("/getXFSJCommunity")
	public Result<?> getCommunityByService(@RequestParam("access_token") String accessToken,
			@RequestParam(value = "clientLng", required = false, defaultValue = "") String clientLng,
			@RequestParam(value = "clientLat", required = false, defaultValue = "") String clientLat,
			@RequestParam(value = "index", required = false, defaultValue = "1") int index,
			@RequestParam(value = "size", required = false, defaultValue = "1000") int size
			)  {
		ValidatorUtil.verify(accessToken, "access_token");
		
		Long uid = getUidByToken(accessToken);
		
		if (uid == null) {
			error("用户未登录");
		}
		request.getSession().setAttribute("uid", uid);
		request.getSession().setAttribute("token", accessToken);
		request.getSession().setAttribute("openId", "xfsj_" + uid);
		return Result.successData(communityService.getXFSJCommunity(uid, clientLng, clientLat, index, size));
	}
	
	
}
