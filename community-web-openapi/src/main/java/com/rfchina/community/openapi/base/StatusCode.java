package com.rfchina.community.openapi.base;

import com.rfchina.community.base.ValueNamePair;

/**
 */
public class StatusCode {

	public static final ValueNamePair<Integer, String> SUCCESS = ValueNamePair.of(200, "成功");

	public static final ValueNamePair<Integer, String> FAILURE = ValueNamePair.of(100, "失败");

	public static final ValueNamePair<Integer, String> UNAUTHORIZED = ValueNamePair.of(403, "用户会话超时，请重新登录");

	/** 参数不正确 */
	public static final ValueNamePair<Integer, String> INVALID_PARAM_FORMAT = ValueNamePair.of(406, "参数格式错误");

	/** */
	public static final ValueNamePair<Integer, String> PARAM_REQUIRED = ValueNamePair.of(420, "必填的参数不能为空");

	public static final ValueNamePair<Integer, String> SERVICE_ERROR = ValueNamePair.of(500, "系统错误");

	public static final ValueNamePair<Integer, String> UNKNOWN_ERROR = ValueNamePair.of(503, "未知错误");

	public static final ValueNamePair<Integer, String> INVALID_PARAM = ValueNamePair.of(10006, "非法令牌");

	public static final ValueNamePair<Integer, String> INVALID_USERNAME = ValueNamePair.of(20001, "非法用户名");

	public static final ValueNamePair<Integer, String> INVALID_PASSWORD = ValueNamePair.of(20002, "用户密码不正确");

	public static final ValueNamePair<Integer, String> USER_IS_EXISTED = ValueNamePair.of(20003, "用户已存在");

	public static final ValueNamePair<Integer, String> USER_IS_NOT_EXISTED = ValueNamePair.of(20004, "登录失败, 用户不存在");

	public static final ValueNamePair<Integer, String> USER_IS_NOT_VERIFIED = ValueNamePair.of(20005, "用户未验证");

	public static final ValueNamePair<Integer, String> USER_IS_FORBIDDEN = ValueNamePair.of(20006,
			"登录失败, 您的账号已被禁用, 如需帮助, 请找高级管理员解决");

	public static final ValueNamePair<Integer, String> CONTENT_IS_TOO_SHORT = ValueNamePair.of(20007, "内容的长度过短");

	public static final ValueNamePair<Integer, String> CONTENT_IS_TOO_LONG = ValueNamePair.of(20008, "内容的长度过长");

	public static final ValueNamePair<Integer, String> WEAK_PASSWORD = ValueNamePair.of(20009, "弱密码");;

	public static final ValueNamePair<Integer, String> USER_IS_NOT_LOGGED_IN = ValueNamePair.of(20010, "用户未登录");

	public static final ValueNamePair<Integer, String> LOGIN_FAILED = ValueNamePair.of(20011, "登录失败");

	public static final ValueNamePair<Integer, String> USER_NOT_ROLE = ValueNamePair.of(20012, "没有权限");

	public static final ValueNamePair<Integer, String> LEADER_ADMIN_ID_IS_NOT_CONFIGURED = ValueNamePair.of(30010,
			"未配置上级审核管理员");

	public static final ValueNamePair<Integer, String> DEPT_IS_FORBIDDEN = ValueNamePair.of(30011, "登录失败, 您的所属部门已被禁用");

	public static final ValueNamePair<Integer, String> USER_HAS_NO_COMMUNITY_INFO = ValueNamePair.of(30012,
			"登录失败, 您的账号未配置相关社区");

	public static final ValueNamePair<Integer, String> USER_HAS_NO_DEPT = ValueNamePair.of(30013, "登录失败, 您的账号未配置任何部门");
	public static final ValueNamePair<Integer, String> COMMUNITY_FORBIDDEN = ValueNamePair.of(30014, "登录失败, 社区已经禁用");
	public static final ValueNamePair<Integer, String> NO_HAVE_COMMUNITY= ValueNamePair.of(30015, "登录失败, 社区不存在");
}
