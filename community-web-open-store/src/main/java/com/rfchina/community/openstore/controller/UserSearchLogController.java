package com.rfchina.community.openstore.controller;

import com.rfchina.community.base.Constant;
import com.rfchina.community.base.Result;
import com.rfchina.community.base.util.ValidatorUtil;
import com.rfchina.community.openstore.service.UserSearchLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 */
@RestController
@RequestMapping(value = Constant.ROOT_PATH_OPENSTORE)
public class UserSearchLogController extends BaseController {

	@Autowired
	private UserSearchLogService userSearchLogService;

	@RequestMapping("/userSearchLogs")
	public Result<?> userSearchLogs(@RequestParam(value = "accessToken", required = true) String accessToken) {
		ValidatorUtil.verify(accessToken, "accessToken");

		Long uid = getUidByToken(accessToken);

		if (uid == null) {
			error("用户未登录");
		}
		return Result.successData(userSearchLogService.list(uid));
	}

	@RequestMapping("/delUserSearchLogs")
	public Result<?> delUserSearchLogs(@RequestParam(value = "accessToken", required = true) String accessToken,
			@RequestParam(value = "words", required = true) String words) {
		ValidatorUtil.verify(accessToken, "accessToken");
		Long uid = getUidByToken(accessToken);
		if (uid == null) {
			error("用户未登录");
		}
		return Result.successData(userSearchLogService.delete(uid, words));
	}

}
