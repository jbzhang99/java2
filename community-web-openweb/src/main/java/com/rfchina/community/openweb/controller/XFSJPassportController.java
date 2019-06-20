//package com.rfchina.community.openweb.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.rfchina.community.base.Constant;
//import com.rfchina.community.base.Result;
//import com.rfchina.community.base.StatusCode;
//import com.rfchina.community.base.util.ValidatorUtil;
//import com.rfchina.community.openweb.service.XFSJPassportService;
//import com.rfchina.community.persistence.model.Passport;
//
///**
// * 小富市集-忘记密码
// * @author maixingnian
// * @since 3.2
// */
//@RestController
//@RequestMapping(value = { Constant.ROOT_PATH_OPENWEB })
//public class XFSJPassportController extends BaseController{
//
//	@Autowired
//	private XFSJPassportService passportService;
//
//	 /**
//	  * 重置密码（忘记密码）
//	 * @param moblie  手机账号
//	 * @param moblieVerifyCode 电信验证码
//	 * @param picVerifyCode 图片验证码
//	 * @param newPassword 新密码
//	 * @param newPasswordConfirm 新密码确认
//	 * @return
//	 */
//	@RequestMapping(value = { "/acc/xfsj/reset_password" }, method = { RequestMethod.POST })
//	public Result<?> resetPassword(
//		@RequestParam(value = "moblie", required = true) String mobile,
//		@RequestParam(value = "moblieVerifyCode", required = true) String mobileVerifyCode,
//		@RequestParam(value = "picVerifyCode", required = true) String picVerifyCode,
//		@RequestParam(value = "newPassword", required = true) String newPassword,
//		@RequestParam(value = "newPasswordConfirm", required = true) String newPasswordConfirm) {
//
//		//校验空值
//		ValidatorUtil.verify(mobile, "手机账号");
//		ValidatorUtil.verify(mobileVerifyCode, "手机验证码");
//		ValidatorUtil.verify(picVerifyCode, "图片验证码");
//		ValidatorUtil.equals(newPassword, newPasswordConfirm, "新密码");
//
//		//校验图形码
//		Object sessionGifCode = request.getSession().getAttribute("gifCode");
//		if(!picVerifyCode.equals(sessionGifCode)) {
//			return Result.create(StatusCode.FAILURE, "图形验证码不正确");
//		}
//
//		//校验手机短信息
//		Object xfsjRegisterCode = request.getSession().getAttribute("xfsjRegisterCode");
//		validator(xfsjRegisterCode == null, "验证码已经失效,请重新发送");
//		if(!passportService.checkSms(mobileVerifyCode, xfsjRegisterCode.toString())) {
//			return Result.create(StatusCode.FAILURE, "短信验证码不正确");
//		}
//
//		//查询旧密码
//		Passport passport = passportService.queryOldPasswd(mobile);
//		if(null == passport) {
//			return Result.create(StatusCode.FAILURE, "手机账号不存在");
//		}
//		boolean checkSamePasswd = passportService.checkSamePasswd(passport, newPassword);
//
//		//新密码与旧密码不能一样
//		if(checkSamePasswd) {
//			return Result.create(StatusCode.FAILURE, "重置的新密码不能与旧密码相同");
//		}
//
//		boolean updateIsOk = passportService.updatePasswdById(passport.getId(), newPassword);
//		//更新失败
//		if(!updateIsOk) {
//			return Result.create(StatusCode.FAILURE, "密码重置失败");
//		}
//
//		//修改密码成功把session里面的信息清空
//		request.getSession().removeAttribute("xfsjRegisterCode");
//		request.getSession().removeAttribute("gifCode");
//
//		return Result.successData(null);
//	}
//
//}
