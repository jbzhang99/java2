package com.rfchina.community.open.bridge.controller.platform;

import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.Result;
import com.rfchina.community.base.util.MyUtils;
import com.rfchina.community.open.bridge.controller.BaseController;
import com.rfchina.community.open.bridge.entity.ExtOpenStoreGood;
import com.rfchina.community.open.bridge.service.CommunityServiceCategoryService;
import com.rfchina.community.open.bridge.service.OpenStoreGoodService;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.mybatis.paginator.model.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 模板商品controller
 */
@RestController
@RequestMapping(value = { OpenConstant.ROOT_PATH_PLATFORM })
public class OpenStoreGoodPFController extends BaseController {

	@Autowired
	private OpenStoreGoodService openStoreGoodService;
	@Autowired
	private CommunityServiceCategoryService communityServiceCategoryService;

	/**
	 * @author:fukangwen @Description: 商品管理列表 @return Result<?> @throws
	 */
	@RequestMapping(value = { "/good_page_query" })
	public Result<?> list(@RequestParam(value = "storeName", required = false, defaultValue = "") String storeName,
			@RequestParam(value = "merchantName", required = false, defaultValue = "") String merchantName,
			@RequestParam(value = "name", required = false, defaultValue = "") String name,
			@RequestParam(value = "goodTypeId", required = false, defaultValue = "0") int categoryId,
			@RequestParam(value = "status", required = false, defaultValue = "0") int status,
			@RequestParam(value = "index", required = false, defaultValue = "1") int index,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size) {
		return Result.successData(openStoreGoodService
				.pageQuery1(storeName, merchantName, name, categoryId, status, index, size).convert());
	}

	@RequestMapping(value = { "/good_page_query_down" })
	public void good_page_query_down(
			@RequestParam(value = "storeName", required = false, defaultValue = "") String storeName,
			@RequestParam(value = "merchantName", required = false, defaultValue = "") String merchantName,
			@RequestParam(value = "name", required = false, defaultValue = "") String name,
			@RequestParam(value = "goodTypeId", required = false, defaultValue = "0") int categoryId,
			@RequestParam(value = "status", required = false, defaultValue = "0") int status

	) throws IOException, Exception {
		PageList<ExtOpenStoreGood> pager = openStoreGoodService.pageQuery1(storeName, merchantName, name, categoryId,
				status, 1, 50000);

		Workbook wb = MyUtils.createXSSFWorkbook();
		Sheet sheet = wb.createSheet("商品");
		int rownum = 0;
		Row row = sheet.createRow(rownum++);
		String titles = "ID,商品名称,分类ID,商品分类,店铺名称,商家名称,商品原价,商品现价,商品销量,添加时间,上架状态";
		MyUtils.setCellTitle(row, titles);

		Map<Integer, String> map = new HashMap<>();
		map.put(1, "上架");
		map.put(2, "下架");
		map.put(3, "删除");
		for (ExtOpenStoreGood data : pager) {
			row = sheet.createRow(rownum++);
			int cnum = 0;
			MyUtils.setCell(row, cnum++, data.getId());
			MyUtils.setCell(row, cnum++, data.getName());
			MyUtils.setCell(row, cnum++, data.getCategoryId());
			MyUtils.setCell(row, cnum++, data.getCategoryName());
			MyUtils.setCell(row, cnum++, data.getStoreName());
			MyUtils.setCell(row, cnum++, data.getMerchantName());
			MyUtils.setCell(row, cnum++, data.getPrePrice());
			MyUtils.setCell(row, cnum++, data.getPrice());
			MyUtils.setCell(row, cnum++, data.getSaleAmount());
			MyUtils.setCell(row, cnum++, data.getCreateTime());
			MyUtils.setCell(row, cnum++, map.getOrDefault(data.getStatus(), data.getStatus() + ""));
//				MyUtils.setCell(row, cnum++, data.get);
//				MyUtils.setCell(row, cnum++, data.get); 

		}

		wb.write(MyUtils.createServletOutputStream(response, "商品"));

	}

	/**
	 * @author:fukangwen @Description: 更改商品上下架状态 @return Result<?> @throws
	 */
	@RequestMapping(value = { "/change_good_ground_status" })
	public Result<?> changeGoodGroundStatus(@RequestParam(value = "goodId", required = true) int goodId,
			@RequestParam(value = "status", required = true) int status) {
		validator(goodId < 0 || status <= 0, "参数有误");
		validator(status != OpenConstant.GoodStatus.GROUNDING.getKey()
				&& status != OpenConstant.GoodStatus.UNDER.getKey(), "更新状态有误");
		openStoreGoodService.changeStatus(goodId, status);
		return Result.success();
	}

	/**
	 * @author:fukangwen @Description: 类型列表 @return Result<?> @throws
	 */
	@RequestMapping("/get_good_category_list")
	public Result<?> getCommunityServiceCategoryList(@RequestParam(value = "type", defaultValue = "5") int type,
			@RequestParam(value = "index", required = false, defaultValue = "1") int index,
			@RequestParam(value = "size", required = false, defaultValue = "100") int size) {
		return Result.successData(communityServiceCategoryService.getCommunityServiceCategoryList(index, size, type));
	}


	//设置产品的排序
	@RequestMapping("/updateGoodSorting")
	public Result<?> updateGoodSorting(@RequestParam(value = "id") int id,
									   @RequestParam(value = "sorting") int sorting,
									   @RequestParam(value = "likeSorting") int likeSorting) {
		return Result.successData(openStoreGoodService.updateGoodSorting(id,sorting, likeSorting));
	}



	//设置虚拟销量
	@RequestMapping("/addVirtualSaleAmount")
	public Result<?> addVirtualSaleAmount(@RequestParam(value = "id") int id,
										   @RequestParam(value = "amount") int amount) {
		validator(amount <= 0 , "请输入正整数");
		return Result.successData(openStoreGoodService.addVirtualSaleAmount(id,amount));
	}

	/**
	 * @author:fukangwen
	 * @Description: 获取商品详情
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping(value = {"/good_get_detail"})
	public Result<?> getGoodDetail(@RequestParam(value = "goodId") int goodId) {
		validator(goodId < 0 , "参数有误");
		logger.info("method ： getGoodDetail; goodId={}", goodId);
		return  Result.successData(openStoreGoodService.getGoodDetail(goodId));
	}
}
