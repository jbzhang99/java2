package com.rfchina.community.openstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rfchina.community.base.Constant;
import com.rfchina.community.base.Result;
import com.rfchina.community.base.util.ValidatorUtil;
import com.rfchina.community.openstore.service.AddressManageService;

/**
 */
@RestController
@RequestMapping(value = {Constant.ROOT_PATH_OPENSTORE})
public class AddressManageController extends BaseController {
	@Autowired
	private AddressManageService addressManageService;

	/**
	 * 我的收货地址列表
	 */
	@RequestMapping("/address_manage_list")
	public Result<?> addressManageList(
			@RequestParam(value = "accessToken", required = true) String accessToken
			) {
		long uid = validateAndGetUid(null, accessToken);
		return Result.successData(addressManageService.list(uid));
	}
	
	/**
	 * 我的认证地址列表,最多20条
	 */
	@RequestMapping("/address_manage_auth_list")
	public Result<?> addressManageAuthList(
			@RequestParam(value = "accessToken", required = true) String accessToken
			) {
		long uid = validateAndGetUid(null, accessToken);
		return Result.successData(addressManageService.listAuthAddress(uid));
	}
	
	/**
	 * 新增收货地址
	 */
	@RequestMapping("/address_manage_insert")
	public Result<?> addressManageInsert(
			@RequestParam(value = "accessToken", required = true) String accessToken,
			@RequestParam(value = "provinceId", required = true) int provinceId,
			@RequestParam(value = "cityId", required = true) int cityId,
			@RequestParam(value = "areaId", required = true) int areaId,
			@RequestParam(value = "addrDetail", required = true) String addrDetail,
			@RequestParam(value = "userName", required = true) String userName,
			@RequestParam(value = "phone", required = true) String phone
			) {
		long uid = validateAndGetUid(null, accessToken);
		
		ValidatorUtil.verify(addrDetail, "收货地址", true, 1, 50);
		ValidatorUtil.verify(userName, "联系人姓名", true, 1, 10);
		ValidatorUtil.verify(phone, "联系人手机", true, 1, 11);
		
		addressManageService.insert(uid, provinceId, cityId, areaId,
				addrDetail, userName, phone);	
		return Result.success();
	}
	
	/**
	 * 修改收货地址
	 */
	@RequestMapping("/address_manage_modify")
	public Result<?> addressManageModify(
			@RequestParam(value = "accessToken", required = true) String accessToken,
			@RequestParam(value = "id", required = true) long id,
			@RequestParam(value = "provinceId", required = true) int provinceId,
			@RequestParam(value = "cityId", required = true) int cityId,
			@RequestParam(value = "areaId", required = true) int areaId,
			@RequestParam(value = "addrDetail", required = true) String addrDetail,
			@RequestParam(value = "userName", required = true) String userName,
			@RequestParam(value = "phone", required = true) String phone
			) {
		validateAndGetUid(null, accessToken);
		
		ValidatorUtil.verify(addrDetail, "收货地址", true, 1, 50);
		ValidatorUtil.verify(userName, "联系人姓名", true, 1, 10);
		ValidatorUtil.verify(phone, "联系人手机", true, 1, 11);
		
		addressManageService.modify(id, provinceId, cityId, areaId, 
				addrDetail, userName, phone);	
		return Result.success();
	}
	
	/**
	 * 删除收货地址
	 */
	@RequestMapping("/address_manage_delete")
	public Result<?> addressManageDelete(
			@RequestParam(value = "id", required = true) long id,
			@RequestParam(value = "accessToken", required = true) String accessToken
			) {
		long uid = validateAndGetUid(null, accessToken);
		addressManageService.delete(id, uid);
		return Result.success();
	}
	
	/**
	 * 设置默认收货地址
	 */
	@RequestMapping("/address_manage_set_default")
	public Result<?> addressManageSetDefault(
			@RequestParam(value = "id", required = true) long id,
			@RequestParam(value = "accessToken", required = true) String accessToken
			) {
		validateAndGetUid(null, accessToken);
		addressManageService.setDefaultStatus(id);
		return Result.success();
	}
	
	/**
	 * 获取默认收货地址
	 */
	@RequestMapping("/get_defalut_address_manage")
	public Result<?> getDefalutAddressManage(
			@RequestParam(value = "accessToken", required = true) String accessToken
			) {
		long uid = validateAndGetUid(null, accessToken);
		return Result.successData(addressManageService.getDefaultAddress(uid));
	}
}
