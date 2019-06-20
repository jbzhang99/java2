package com.rfchina.community.openweb.controller;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.mybatis.paginator.model.PageList;
import org.mybatis.paginator.model.Paginator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rfchina.community.base.Constant;
import com.rfchina.community.base.Result;
import com.rfchina.community.openweb.entity.AdminUserInfo;
import com.rfchina.community.persistence.mapper.SysMsgObjectTypeMapper;
import com.rfchina.community.persistence.mapper.SysMsgReadMapper;
import com.rfchina.community.persistence.mapper.ext.ExtSysMsgInfoGlobalMapper;
import com.rfchina.community.persistence.mapper.ext.ExtSysNoticeGlobalMapper;
import com.rfchina.community.persistence.model.SysMsgObjectType;
import com.rfchina.community.persistence.model.SysMsgRead;
import com.rfchina.community.persistence.model.ext.ExtSysMsgInfo;
/**
 */
@RestController
@RequestMapping(value = {Constant.ROOT_PATH_OPENWEB})
public class SysMsgInfoController extends BaseController {

	private static Logger logger = LoggerFactory.getLogger(SysMsgInfoController.class);

	@Autowired
	private ExtSysMsgInfoGlobalMapper extSysMsgInfoMapper;

	@Autowired
	private ExtSysNoticeGlobalMapper extSysNoticeGlobalMapper;

	@Autowired
	private SysMsgObjectTypeMapper sysMsgObjectTypeMapper;

	@Autowired
	private SysMsgReadMapper sysMsgReadMapper;

	@RequestMapping(value = {"/sysMsgInfoIndex"})
	public Result<?> sysMsgInfoIndex(@RequestParam(value = "index", required = false, defaultValue = "1") Integer index,
			@RequestParam(value = "size", required = false, defaultValue = "10") Integer size) {
		Long adminUid = getAdminId();
		int limit = (index - 1) * size;
		List<ExtSysMsgInfo> list = extSysMsgInfoMapper.indexList(adminUid, limit, size);
		List<JSONObject> lst = new ArrayList<>();
		for (ExtSysMsgInfo extSysMsgInfo : list) {
			JSONObject sys = (JSONObject) JSON.toJSON(extSysMsgInfo);
			SysMsgObjectType obj = sysMsgObjectTypeMapper.selectByPrimaryKey(extSysMsgInfo.getObjectType());
			if (obj == null) {
				obj = new SysMsgObjectType();
				obj.setOtTitle("");
				obj.setOtObjectType(extSysMsgInfo.getObjectType());
			}
			if (obj != null)
				obj.setOtContent("");
			sys.put("object_type", obj);
			lst.add(sys);
		}
		Long total = extSysMsgInfoMapper.indexListcount(adminUid);
		PageList<JSONObject> page = new PageList<>(lst, new Paginator(index, size, total));
		// logger.info("adminUid:{},page:{}", adminUid, page);
		return Result.successData(page.convert());
	}

	@RequestMapping(value = {"/sysMsgInfoIndexUnreadTotal"})
	public Result<?> sysMsgInfoIndexTotal() {
		AdminUserInfo admin = getAdminInfo();
		Long total1 = extSysMsgInfoMapper.indexListcountUnReadTotal(admin.getUid());
		// Long total2 = unreadsysnotice(admin);
		JSONObject json = new JSONObject();
		json.put("admin", admin);
		json.put("msgInfo", total1);
		// json.put("sysNotice", total2);
		// json.put("unreadTotal", total1 + total2);
		json.put("unreadTotal", total1);
		return Result.successData(json);
	}

	@RequestMapping(value = {"/sysMsgInfoUpdateRead"})
	public Result<?> sysMsgInfoUpdateRead(String id) {
		validator(StringUtils.isBlank(id), "id不能为空");
		Long adminUid = getAdminId();
		for (String ids : id.split(",")) {
			SysMsgRead record = new SysMsgRead();
			record.setAdminUid(adminUid);
			record.setMsgId(Long.valueOf(ids));
			record.setIsRead(2);
			record.setReadTime(new Date());
			sysMsgReadMapper.updateByPrimaryKeySelective(record);
		}
		return Result.successData(1);
	}
	// private Long unreadsysnotice(AdminUserInfo admin) {
	// String sql = " and platform_uid=-1 ";
	// return extSysNoticeGlobalMapper.unReadSysNoticeCount(admin.getAdminId(), admin.getCreateTime(), sql);
	// }
	// @RequestMapping(value = {"/unReadSysNoticeCount"})
	// public Result<?> unReadSysNoticeCount() {
	// AdminUserInfo admin = getAdminInfo();
	// // Long total = unreadsysnotice(admin);
	// JSONObject json = new JSONObject();
	// json.put("admin", admin);
	// // json.put("unreadTotal", total);
	// json.put("unreadTotal", 0);
	// return Result.successData(json);
	// }
}
