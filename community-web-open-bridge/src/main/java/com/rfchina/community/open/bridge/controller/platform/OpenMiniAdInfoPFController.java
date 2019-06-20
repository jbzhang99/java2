package com.rfchina.community.open.bridge.controller.platform;

import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.OpenMiniConstant;
import com.rfchina.community.base.Result;
import com.rfchina.community.base.util.ValidatorUtil;
import com.rfchina.community.open.bridge.controller.BaseController;
import com.rfchina.community.open.bridge.service.OpenMiniAdInfoService;
import com.rfchina.community.persistence.model.OpenMiniAdTab;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.paginator.model.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = OpenConstant.ROOT_PATH_PLATFORM)
public class OpenMiniAdInfoPFController extends BaseController {

	@Autowired
	private OpenMiniAdInfoService openMiniAdInfoService;

	/**
	 * 新增
	 */
	@RequestMapping("/insertMiniAdInfo")
	public Result<?> insertMiniAdInfo(
			@RequestParam(value="communityIdsJson") String communityIdsJson, //json格式
			@RequestParam(value="title") String title,
			@RequestParam(value="style") String style,
			@RequestParam(value="tabsJson") String tabsJson,
			HttpServletRequest request) {
		ValidatorUtil.verify(title, "板块标题", true, 1, 6, null);
		validator(!OpenMiniConstant.ShowStyle.isExist(style), "板块样式不存在");
		List<Integer> communityIdList = (List<Integer>)this.converFormString(communityIdsJson, Integer.class);
		List<OpenMiniAdTab> tabList = (List<OpenMiniAdTab>)this.converFormString(tabsJson, OpenMiniAdTab.class);
		validator(communityIdList.isEmpty(), "请选择社区覆盖范围");
		validateAdTabList(tabList);
		validator(OpenMiniConstant.ShowStyle.getAmountByCode(style) != tabList.size(), "请完善板块内容");
		openMiniAdInfoService.insert(communityIdList, title, style, tabList);
		return Result.success();
	}

	private void validateAdTabList(List<OpenMiniAdTab> tabList){
		validator(tabList.isEmpty(), "板块内容不能为空");
		for(OpenMiniAdTab tab : tabList){
			validator(!OpenMiniConstant.Type.isExist(tab.getType()), "板块内容类型不存在");
			validator(tab.getSerialNumber() == null , "板块序号不能为空");
			validator(tab.getTargetId() == null , "板块内容不能为空");
			if(OpenMiniConstant.Type.ACTIVITY.equals(tab.getType())){
				validator(StringUtils.isBlank(tab.getTargetUrl()), "板块内容不能为空");
			}else{
				validator(tab.getTargetId() == null , "板块内容不能为空");
			}

			validator(tab.getPicUrl() == null , "板块图片不能为空");
		}
	}

	/**
	 * 更新
	 */
	@RequestMapping("/updateMiniAdInfo")
	public Result<?> updateMiniAdInfo(
			@RequestParam(value="communityIdsJson") String communityIdsJson, //json格式
			@RequestParam(value="title") String title,
			@RequestParam(value="infoId") long infoId,
			@RequestParam(value="tabsJson") String tabsJson,
			HttpServletRequest request) {
		ValidatorUtil.verify(title, "板块标题", true, 1, 6, null);
		validator(infoId <= 0, "参数错误");
		List<Integer> communityIdList = (List<Integer>)this.converFormString(communityIdsJson, Integer.class);
		List<OpenMiniAdTab> tabList = (List<OpenMiniAdTab>)this.converFormString(tabsJson, OpenMiniAdTab.class);
		openMiniAdInfoService.update(infoId, communityIdList, title, tabList);
		return Result.success();
	}

	/**
	 * 启用禁用
	 */
	@RequestMapping("/updateMiniStatus")
	public Result<?> updateMiniStatus(@RequestParam(value = "infoId") long infoId,
									  @RequestParam(value = "status") int status){
		validator(infoId <= 0, "参数错误");
		validator(status != 0 && status !=1 , "参数错误");
		openMiniAdInfoService.updateStatus(infoId, status);
		return Result.success();
	}

	/**
	 * 删除
	 */
	@RequestMapping("/deleteMiniAdInfo")
	public Result<?> deleteMiniAdInfo(@RequestParam(value = "infoId") long infoId){
		validator(infoId <= 0, "参数错误");
		openMiniAdInfoService.delete(infoId);
		return Result.success();
	}

	/**
	 * 板块列表
	 */
	@RequestMapping("/getMiniStyleList")
	public Result<?> getMiniStyleList(){
		return Result.successData(openMiniAdInfoService.getStyle());
	}

	/**
	 * 修改排序
	 */
	@RequestMapping("/updateMiniSorting")
	public Result<?> updateMiniSorting(
			@RequestParam(value = "infoId") long infoId,
			@RequestParam(value = "sorting", required = true) int sorting){
		validator(infoId <= 0, "参数错误");
		validator(sorting <= 0 || sorting > OpenMiniAdInfoService.defaltSorting, "参数错误");
		openMiniAdInfoService.updateSorting(infoId, sorting);
		return Result.success();
	}

	/**
	 * 板块列表
	 */
	@RequestMapping("/getMiniDetail")
	public Result<?> getMiniDetail(@RequestParam(value = "infoId") long infoId){
		return Result.successData(openMiniAdInfoService.getMiniDetail(infoId));
	}


	/**
	 * 列表搜索
	 * (String title, String style, Integer status, int index, int size)
	 */
	@RequestMapping("/miniInfoList")
	public Result<?> miniInfoList(
			@RequestParam(value = "index", required = false, defaultValue = "1") int index,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size,
			@RequestParam(value = "title", required = false, defaultValue = "") String title,
			@RequestParam(value = "style", required = false, defaultValue="") String style,
			@RequestParam(value = "communityId", required = false, defaultValue = "0") int communityId,
			@RequestParam(value = "status", required = false) Integer status){
		PageList<?> list = openMiniAdInfoService.pageList(title, style, status, communityId, index, size);
		return Result.successData(list.convert());
	}

	/**
	 * 查看社区投放列表
	 */
	@RequestMapping("/getMiniCommunityList")
	public Result<?> getMiniCommunityList(@RequestParam(value = "infoId") long infoId){
		return Result.successData(openMiniAdInfoService.getCommunityList(infoId));
	}

}

