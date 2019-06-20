package com.rfchina.community.openweb.controller;

import com.rfchina.community.base.Constant;
import com.rfchina.community.base.Result;
import com.rfchina.community.base.util.MyUtils;
import com.rfchina.community.base.util.RegexUtils;
import com.rfchina.community.base.util.ValidatorUtil;
import com.rfchina.community.openweb.service.*;
import com.rfchina.community.openweb.util.WorkBookUtil;
import com.rfchina.community.persistence.mapper.CommunityServiceMapper;
import com.rfchina.community.persistence.mapper.OpenStoreGoodMapper;
import com.rfchina.community.persistence.model.CommunityService;
import com.rfchina.community.persistence.model.OpenStoreGood;
import com.rfchina.community.persistence.model.OpenStoreGoodExample;
import com.rfchina.community.persistence.model.ext.ExtCommunityServiceRela;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.mybatis.paginator.model.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 模板商品controller
 */
@RestController
@RequestMapping(value = {Constant.ROOT_PATH_OPENWEB})
public class OpenStoreGoodController extends BaseController {

	@Autowired
	private OpenStoreServiceTempleteService openStoreServiceTempleteService;
	@Autowired
	private OpenStoreGoodService openStoreGoodService;
	@Autowired
	private CommunityServiceRelaService communityServiceRelaService;
	@Autowired
	private CommunityServiceMapper communityServiceMapper;
	@Autowired
	private CommunityServiceCategoryService communityServiceCategoryService;
	@Autowired
	private OpenStoreGoodRecommendService openStoreGoodRecommendService;
	@Autowired
	private OpenStoreGoodMapper openStoreGoodMapper;
	@Value("${open.storeapi.url}")
	private String openStoreUrl;
	
	
	@RequestMapping(value = {"/good_insert"})
	public Result<?> insert(
			@RequestParam(value = "serviceId", required = true) int serviceId,
			@RequestParam(value = "code", required = true) String code,
			@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "prePrice", required = true) String prePrice,
			@RequestParam(value = "price", required = true) String price,
			@RequestParam(value = "picUrl", required = true) String picUrl,
			@RequestParam(value = "detail", required = true) String detail,
			@RequestParam(value = "stock", required = true) Integer stock,
			@RequestParam(value = "limitTimes", required = false, defaultValue = "0") int limitTimes,
			@RequestParam(value="showCategoryIdList", required = false) String showCategoryIdList,
			@RequestParam(value = "categoryId", required = false, defaultValue="0") Integer categoryId
			) {
		//验证参数
		insertOrUpdateCheck(serviceId, code, name, prePrice, price, picUrl, detail, stock, categoryId, limitTimes);

		List<Long> list = MyUtils.converLongFormString(showCategoryIdList);

		openStoreGoodService.insert(serviceId, code, name, new BigDecimal(prePrice), new BigDecimal(price), picUrl, detail, 
				stock, categoryId, list, limitTimes);
		
		return Result.success();
	}
	
	/**
	 * @author:fukangwen
	 * @Description: 更新商品
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping(value = {"/good_update"})
	public Result<?> update(
			@RequestParam(value = "serviceId", required = true) int serviceId,
			@RequestParam(value = "goodId", required = true) int goodId,
			@RequestParam(value = "code", required = true) String code,
			@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "prePrice", required = true) String prePrice,
			@RequestParam(value = "price", required = true) String price,
			@RequestParam(value = "picUrl", required = true) String picUrl,
			@RequestParam(value = "detail", required = true) String detail,
			@RequestParam(value = "stock", required = false) Integer stock,
			@RequestParam(value = "limitTimes", required = false, defaultValue = "0") int limitTimes,
			@RequestParam(value="showCategoryIdList", required = false) String showCategoryIdList,
			@RequestParam(value = "categoryId", required = false, defaultValue="0") Integer categoryId
			
			) {
		//验证通用参数
		insertOrUpdateCheck(serviceId, code, name, prePrice, price, picUrl, detail, stock, categoryId,limitTimes );
		
		validator(goodId < 0, "商品id不能为空");
		List<Long> list = MyUtils.converLongFormString(showCategoryIdList);

		openStoreGoodService.update(goodId, code, name, new BigDecimal(prePrice), new BigDecimal(price), picUrl, detail, stock,
				categoryId, list, limitTimes);
		
		return Result.success();
	}
	
	/**
	 * @author:fukangwen
	 * @Description: 新增或修改參數驗證
	 * @return void
	 * @throws
	 */
	private void insertOrUpdateCheck(int serviceId, String code, String name, String prePrice, String price,
			String picUrl, String detail, Integer stock, Integer categoryId, int limitTimes) {
		validator(serviceId < 0, "参数有误");
		validator(StringUtils.isBlank(code), "商品编号不能为空");
		validator(StringUtils.isBlank(name), "商品名称不能为空");
		validator(!RegexUtils.isPositiveNum(prePrice), "商品原价必须为正的数字");
		validator(Double.parseDouble(prePrice) >= 100000, "商品原价不能超过100000");
		validator(!RegexUtils.isPositiveNum(price), "商品现价必须为正的数字");
		validator(Double.parseDouble(price) >= 100000, "商品现价不能超过100000");
		if(stock != null) {
			validator(stock > OpenStoreGoodService.STORE_GOOD_STOCK, "商品库存不能超过" + OpenStoreGoodService.STORE_GOOD_STOCK);
			validator(stock < 0, "商品库存介于0~" + OpenStoreGoodService.STORE_GOOD_STOCK + "的整数");
		}
		validator(StringUtils.isBlank(picUrl), "图片不能为空");
		validator(StringUtils.isBlank(detail), "商品详情不能为空");
		validator(limitTimes < 0 , "购买限制不能为负数");
		//图片最多5张
		String[] urls = picUrl.split(",");
		if(urls.length > 5)
			error("图片最多上传5张");
		
		//权限检查
		authorityCheck(serviceId);
		
		//判断店铺是否创建成功
		if(!openStoreServiceTempleteService.isExist(serviceId))
			error("请先创建好店铺再添加商品");
	}

	
	/**
	 * @author:fukangwen
	 * @Description: 商品列表
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping(value = {"/good_page_query"})
	public Result<?> list(
			@RequestParam(value = "serviceId", required = true) int serviceId,
			@RequestParam(value = "name", required = false, defaultValue = "") String name,
			@RequestParam(value = "code", required = false, defaultValue = "") String code,
			@RequestParam(value = "status", required = false, defaultValue = "0") int status,
			@RequestParam(value = "showCategoryId", required = false, defaultValue = "0") long showCategoryId,
			@RequestParam(value = "recommendStatus", required = false) Integer recommendStatus,
			@RequestParam(value = "startCreateTime", required = false, defaultValue = "") String startCreateTime,
			@RequestParam(value = "endCreateTime", required = false, defaultValue = "") String endCreateTime,
			@RequestParam(value = "index", required = false, defaultValue = "1") int index,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size
			)throws ParseException  {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date startCreateDate = null;
		Date endCreateDate = null;
		if (StringUtils.isNotBlank(startCreateTime)) {
			startCreateDate = sdf.parse(startCreateTime);
		}
		if (StringUtils.isNotBlank(endCreateTime)) {
			endCreateDate = sdf.parse(endCreateTime);
		}
		
		return Result.successData(openStoreGoodService.pageQuery(serviceId, name, code, status,
				showCategoryId, recommendStatus, startCreateDate, endCreateDate , index, size));
	}
	
	/**
	 * @author:fukangwen
	 * @Description: 更改商品状态 
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping(value = {"/good_change_status"})
	public Result<?> changeStatus(
			@RequestParam(value = "serviceId", required = true) int serviceId,
			@RequestParam(value = "goodId", required = true) int goodId,
			@RequestParam(value = "status", required = true) int status
			) {
		validator(serviceId < 0 || goodId < 0 || status <= 0, "参数有误");
		
		//权限检查
		authorityCheck(serviceId);
		
		openStoreGoodService.changeStatus(goodId, status);
		return Result.success();
	}
	
	/**
	 * @author:fukangwen
	 * @Description: 获取商品详情
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping(value = {"/good_get_detail"})
	public Result<?> getGoodDetail(@RequestParam(value = "goodId", required = true) int goodId) {
		validator(goodId < 0 , "参数有误");
		
		return  Result.successData(openStoreGoodService.getGoodDetail(goodId));
	}
	
	/**
	 * @return 
	 * @return 
	 * @author:fukangwen
	 * @Description: 生成商品二维码
	 * @return void
	 * @throws
	 */
	@RequestMapping(value = {"/get_good_qrcode"} )
	public Result<?> qrcode(HttpServletResponse response,
			@RequestParam(value = "goodId", required = true) int goodId,
			@RequestParam(value = "communityId", required = true) int communityId,
			@RequestParam(value = "type", required = false , defaultValue="0") int type)
			throws IOException {
		OpenStoreGood openStoreGood = openStoreGoodService.selectByPrimaryKey(goodId);
		validator(openStoreGood == null, "商品不存在");
		Long admin = getAdminId();
		CommunityService ser = communityServiceMapper.selectByPrimaryKey(openStoreGood.getServiceId());
		validator(ser == null, "无数据");
		validator(ser.getMerchantId() != admin.longValue(), "非法访问");
		//http://store.zizai.test.thinkinpower.net/index.html#/goodsDetail?isNew=1&serviceId=413&goodId=352&communityId=1
		String con = openStoreUrl + "index.html#/goodsDetail?isNew=1&serviceId=" + ser.getId() + "&goodId=" + goodId + "&communityId=" + communityId;
		response.setContentType("image/png");
		ServletOutputStream sos = null;
		File file;
		try {
			file = QRCode.from(con).to(ImageType.PNG).withSize(350, 350).file();
		} finally {
			if (sos != null) {
				try {
					sos.close();
				} catch (IOException e) {
					error("生成二维码失败");
				}
			}
		}
		return Result.successData(fileToBase64(file));
	}
	
	   public  String fileToBase64(File file) {
	        String base64 = null;
	        InputStream in = null;
	        try {
	            in = new FileInputStream(file);
	            byte[] bytes = new byte[in.available()];
	            int length = in.read(bytes);
	            base64 = java.util.Base64.getEncoder().encodeToString(bytes);
	        } catch (FileNotFoundException e) {
	        	error("生成二维码失败");
	        } catch (IOException e) {
	        	error("生成二维码失败");
	            e.printStackTrace();
	        } finally {
	            try {
	                if (in != null) {
	                    in.close();
	                }
	            } catch (IOException e) {
	            	error("生成二维码失败");
	                e.printStackTrace();
	            }
	        }
	        return base64;
	    }
	
	/**
	 * @return 
	 * @author:fukangwen
	 * @Description: 生成商品二维码
	 * @return void
	 * @throws
	 */
	@RequestMapping(value = {"/download_good_qrcode_by_community"} )
	public void downloadGoodQrcodeByCommunity(HttpServletResponse response,
			@RequestParam(value = "goodId", required = true) int goodId)
			throws IOException {
		OpenStoreGood openStoreGood = openStoreGoodService.selectByPrimaryKey(goodId);
		validator(openStoreGood == null, "商品不存在");
		Long admin = getAdminId();
		CommunityService ser = communityServiceMapper.selectByPrimaryKey(openStoreGood.getServiceId());
		validator(ser == null, "无数据");
		validator(ser.getMerchantId() != admin.longValue(), "非法访问");
		
		PageList<ExtCommunityServiceRela> list = communityServiceRelaService.getCommunityServiceRelaList(openStoreGood.getServiceId(), 1, Integer.MAX_VALUE);
		
		if(!list.isEmpty()) {
			XSSFWorkbook wb = this.getWorkBook(list, goodId, openStoreGood.getServiceId());
			String fileName = "";
			try {
				fileName = new String((openStoreGood.getName() + "二维码.xlsx").getBytes(), "iso-8859-1");
			} catch (UnsupportedEncodingException e) {
				error("下载文件失败");
			}
			
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
			try {
				wb.write(response.getOutputStream());
				wb.close();
				response.getOutputStream().flush();
				response.getOutputStream().close();
	
			} catch (IOException e) {
				error("下载文件失败");
			}
			
		}
	}
	
	public XSSFWorkbook getWorkBook(PageList<ExtCommunityServiceRela> list, int goodId, int serviceId) {

		XSSFWorkbook workbook = new XSSFWorkbook();

		Sheet sheet = workbook.createSheet("二维码地址下载");

		Row row = sheet.createRow(0);
		String titleTops = "社区,二维码地址";
		String[] titles = titleTops.split(",");
		for (int i = 0; i < titles.length; i++) {
			WorkBookUtil.createCellValue(row, i, titles[i]);
		}
		String con = "";
		int r = 1;
		for (ExtCommunityServiceRela e : list) {
			row = sheet.createRow(r++);
			int i = 0;
			WorkBookUtil.createCellValue(row, i++, e.getCommunityName() + "");
			//http://store.zizai.test.thinkinpower.net/index.html#/goodsDetail?isNew=1&serviceId=413&goodId=352&communityId=1
			con = openStoreUrl + "index.html#/goodsDetail?isNew=1&serviceId=" + serviceId + "&goodId=" + goodId + "&communityId=" + e.getCommunityId();
			WorkBookUtil.createCellValue(row, i++, con + "");
		}

		return workbook;
	}
	
	
	/**
	 * @author:fukangwen
	 * @Description: 设置库存
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping(value = {"/change_good_stock"})
	public Result<?> changeStock(
			@RequestParam(value = "serviceId", required = true) int serviceId,
			@RequestParam(value = "goodId", required = true) int goodId,
			@RequestParam(value = "stock", required = true) int stock
			) {
		validator(serviceId < 0 || goodId < 0 || stock < 0, "参数有误");
		
		validator(stock > OpenStoreGoodService.STORE_GOOD_STOCK, "库存不能大于" + OpenStoreGoodService.STORE_GOOD_STOCK);
			
		//权限检查
		authorityCheck(serviceId);
		
		openStoreGoodService.setStock(goodId, stock);
		return Result.success();
	}
	
	/**
	 * @author:fukangwen
	 * @Description: 获取商品编号
	 * @return Result<?>
	 * @throws
	 */
	@RequestMapping(value = {"/get_good_code"})
	public Result<?> getGoodCode(@RequestParam(value = "serviceId", required = true) int serviceId) {
		//权限检查
		authorityCheck(serviceId);
		OpenStoreGoodExample example = new OpenStoreGoodExample();
		example.createCriteria().andServiceIdEqualTo(serviceId);
		long num = openStoreGoodMapper.countByExample(example);
		int code = serviceId * 10000 + (int)num + 1;
		return  Result.successData(code);
	}

	@RequestMapping("/get_good_category_list")
	public Result<?> getGoodCategoryList(
			@RequestParam(value = "index", required = false, defaultValue = "1") int index,
			@RequestParam(value = "size", required = false, defaultValue = "100") int size,
			@RequestParam(value = "type", required = false, defaultValue = "5") int type//商品类型
			) {
		return Result.successData(communityServiceCategoryService.getCommunityServiceCategoryList(index, size, type));
	}

	/**
	 * 新增或更新商品推荐
	 */
	@RequestMapping("/insertOrUpdateGoodRecommend")
	public Result<?> insertOrUpdateGoodRecommend(
			@RequestParam(value = "serviceId", required = true) int serviceId,
			@RequestParam(value = "goodId", required = true) int goodId,
			@RequestParam(value = "remark", required = false, defaultValue = "") String remark,
			@RequestParam(value = "sorting", required = true) int sorting,
			@RequestParam(value = "showUrl", required = false, defaultValue = "") String showUrl,
			@RequestParam(value = "status", required = true, defaultValue="0") int status
	){
		insertOrUpdateCheck(serviceId, remark, sorting, status);
		openStoreGoodRecommendService.insertOrUpdate(serviceId, goodId,
				remark,sorting,showUrl,status);
		return Result.success();
	}

	private void insertOrUpdateCheck(int serviceId, String remark, int sorting, int status){
		authorityCheck(serviceId);
		if(StringUtils.isNotBlank(remark)){
			ValidatorUtil.verify(remark, "推荐理由", true, 1, 35);
		}
		validator(sorting <= 0 || sorting > 999, "推荐序号应该在1~999之间");
		validator(status != 0 && status != 1 , "是否启用参数有误");
	}

	/**
	 * 获取商品推荐信息
	 * @param goodId
	 * @return
	 */
	@RequestMapping("/getGoodRecommend")
	public Result<?> getGoodRecommend(
			@RequestParam(value = "goodId", required = true) int goodId
	) {
		return Result.successData(openStoreGoodRecommendService.getGoodRecomend(goodId));
	}

	//设置产品的排序
	@RequestMapping("/updateGoodSorting")
	public Result<?> updateGoodSorting(@RequestParam(value = "id") int id,
									   @RequestParam(value = "sorting") int sorting) {
		return Result.successData(openStoreGoodService.updateGoodSorting(id,sorting));
	}


}
