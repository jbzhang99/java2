package com.rfchina.community.open.bridge.controller.stats;

import com.alibaba.fastjson.JSONObject;
import com.rfchina.community.base.OpenConstant;
import com.rfchina.community.base.Result;
import com.rfchina.community.base.util.DateTimeUtils;
import com.rfchina.community.open.bridge.WorkBookUtils;
import com.rfchina.community.open.bridge.controller.BaseController;
import com.rfchina.community.open.bridge.mapper.ext.ExtOpenStatsMapper;
import com.rfchina.community.open.bridge.service.CommunityServiceCategoryService;
import com.rfchina.community.open.bridge.service.CommunityServiceService;
import com.rfchina.community.open.bridge.service.ExtOpenStatsService;
import com.rfchina.community.persistence.mapper.CommunityMapper;
import com.rfchina.community.persistence.mapper.CommunityServiceMapper;
import com.rfchina.community.persistence.mapper.open.stats.StatsOpenMapper;
import com.rfchina.community.persistence.model.Community;
import com.rfchina.community.persistence.model.CommunityService;
import com.rfchina.community.persistence.model.OpenStatsMerchant;
import com.rfchina.community.persistence.model.OpenStatsOrder;
import com.rfchina.community.persistence.model.ext.ExtStatOrderStream;
import com.rfchina.community.persistence.model.ext.ExtStatOrderStreamDetail;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

@RestController
@RequestMapping(value = OpenConstant.ROOT_PATH_PLATFORM_STATS)
public class ZZDataStatisticsPFController extends BaseController {

    @Autowired
    private ExtOpenStatsMapper extOpenStatsMapper;

    @Autowired
    private StatsOpenMapper statsOpenOrderMapper;
    @Autowired
    private CommunityMapper communityMapper;
    @Autowired
    private CommunityServiceMapper communityServiceMapper;
    @Autowired
    private CommunityServiceCategoryService communityServiceCategoryService;
    @Autowired
    private CommunityServiceService communityServiceService;
    @Autowired
    private ExtOpenStatsService extOpenStatsService;

    @RequestMapping("/listCommunityServiceCategory")
    public Result<?> listCommunityServiceCategory(@RequestParam(value = "type", defaultValue = "3") int type,
                                                  @RequestParam(value = "index", required = false, defaultValue = "1") int index,
                                                  @RequestParam(value = "size", required = false, defaultValue = "10") int size) {
        return Result.successData(communityServiceCategoryService.getThirdServiceCategory());
    }

    @RequestMapping("/community_service_all")
    public Result<?> communityServiceAll(String title) {
        return Result.successData(communityServiceService.getServiceTitle(title, Arrays.asList(3, 4)));

    }

    @RequestMapping("/zizai_wufu_total_data")
    public Result<?> serviceTotalData() {
        return Result.successData(extOpenStatsService.getZZServiceTotalData());
    }

    @RequestMapping("/zizai_wufu_data_order")
    public Result<?> getZZServiceData() {
        return Result.successData(extOpenStatsService.getZZServiceData());
    }

    @RequestMapping("/zizai_wufu_stats_merchant")
    public Result<?> zizaiWufuStatsMerchant(
            @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(value = "startTime", required = true) LocalDate startTime,
            @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(value = "endTime", required = true) LocalDate endTime,
            @RequestParam(value = "queryType", defaultValue = "1") int queryType) {
        validatorParam(startTime, endTime);
        List<OpenStatsMerchant> list = statsOpenOrderMapper.zizaiWufuStatsMerchant(startTime, endTime);

        //根据开始时间获取当前时间累积的数据
        List<OpenStatsMerchant> tempList = statsOpenOrderMapper.zizaiWufuStatsMerchantByStartTime(startTime);
        OpenStatsMerchant startOpenStatsMerchant = tempList.get(0);

        LinkedHashMap<String, JSONObject> tempMap = new LinkedHashMap<String, JSONObject>();

        for (OpenStatsMerchant openStatsMerchant : list) {
            String stat = DateTimeUtils.formatDate(openStatsMerchant.getStatDate());
            tempMap.put(stat, new JSONObject());
        }

        //给没有的值赋值
        for (LocalDate next = startTime; !next.isAfter(endTime); next = next.plusDays(1)) {
            if (tempMap.get(next.toString()) == null) {
                OpenStatsMerchant record = new OpenStatsMerchant();
                record.setStatDate(DateTimeUtils.parseDate(next.toString()));
                record.setMerchantCount(0);
                record.setShelvesCount(0);
                list.add(record);
            }
        }

        //list 排序
        /*
         * 返回负数表示：p1 小于p2，
         * 返回0 表示：p1和p2相等，
         * 返回正数表示：p1大于p2
         */
        Collections.sort(list, (p1, p2) -> {
            if (p1.getStatDate().getTime() > p2.getStatDate().getTime()) {
                return 1;
            }
            if (p1.getStatDate().getTime() == p2.getStatDate().getTime()) {
                return 0;
            }
            return -1;
        });
        int totalMerchantCount = startOpenStatsMerchant.getMerchantCount();
        int totalShelvesCount = startOpenStatsMerchant.getShelvesCount();
        LinkedHashMap<String, JSONObject> map = new LinkedHashMap<String, JSONObject>();

        for (int i = 0; i < list.size(); i++) {
            OpenStatsMerchant merchant = list.get(i);
            String stat = DateTimeUtils.formatDate(merchant.getStatDate());
            JSONObject e = new JSONObject();
            totalMerchantCount += merchant.getMerchantCount();
            totalShelvesCount += merchant.getShelvesCount();
            e.put("statDate", stat);
            e.put("serchantCount", totalMerchantCount);
            e.put("shelvesCount", totalShelvesCount);
            map.put(stat, e);
        }

        return Result.successData(map.values());
    }

    private void validatorParam(LocalDate startTime, LocalDate endTime) {
        validator(startTime == null, "startTime时间不能为null");
        validator(endTime == null, "endTime时间不能为null");
        validator(startTime != null && endTime != null && endTime.isBefore(startTime), "开始时间大于结束时间");
        validator(endTime.isAfter(LocalDate.now()), "结束时间大于今天");
        validator(Period.between(startTime, endTime).getYears() > 0, "跨度不能相差一年");
    }

    @RequestMapping("/zizai_wufu_stats_order")
    public Result<?> zizai_wufu_stats_order(
            @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(value = "startTime", required = true) LocalDate startTime,
            @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(value = "endTime", required = true) LocalDate endTime,
            @RequestParam(value = "communityId", defaultValue = "0") int communityId,
            @RequestParam(value = "cityId", defaultValue = "0") int cityId,
            @RequestParam(value = "serviceId", defaultValue = "0") int serviceId,
            @RequestParam(value = "queryType", defaultValue = "1") int queryType,
            @RequestParam(value = "export", defaultValue = "0") int export, HttpServletResponse response)
            throws Exception {
        validatorParam(startTime, endTime);
        List<OpenStatsOrder> list = statsOpenOrderMapper.zizaiWufuStatsOrder(startTime, endTime, communityId, serviceId);
        //根据开始时间获取当前时间累积的数据
        List<OpenStatsOrder> tempList = statsOpenOrderMapper.zizaiWufuStatsOrderByStartTime(startTime, communityId, serviceId);
        OpenStatsOrder startOpenStatsOrder = tempList.get(0);

        LinkedHashMap<String, JSONObject> tempMap = new LinkedHashMap<String, JSONObject>();

        for (OpenStatsOrder openStatsOrder : list) {
            String stat = DateTimeUtils.formatDate(openStatsOrder.getStatDate());
            tempMap.put(stat, new JSONObject());
        }
        //给没有的值赋值
        for (LocalDate next = startTime; !next.isAfter(endTime); next = next.plusDays(1)) {
            if (tempMap.get(next.toString()) == null) {
                OpenStatsOrder record = new OpenStatsOrder();
                record.setStatDate(DateTimeUtils.parseDate(next.toString()));
                record.setOrderCount(0);
                record.setTotalAmount(new BigDecimal(0));
                list.add(record);
            }
        }

        //list 排序
        Collections.sort(list, new Comparator<OpenStatsOrder>() {
            /*
             * 返回负数表示：p1 小于p2，
             * 返回0 表示：p1和p2相等，
             * 返回正数表示：p1大于p2
             */
            @Override
            public int compare(OpenStatsOrder p1, OpenStatsOrder p2) {
                if (p1.getStatDate().getTime() > p2.getStatDate().getTime()) {
                    return 1;
                }
                if (p1.getStatDate().getTime() == p2.getStatDate().getTime()) {
                    return 0;
                }
                return -1;
            }
        });
        int totalOrderCount = startOpenStatsOrder.getOrderCount();
        BigDecimal totalAmount = startOpenStatsOrder.getTotalAmount();
        LinkedHashMap<String, JSONObject> map = new LinkedHashMap<String, JSONObject>();

        for (int i = 0; i < list.size(); i++) {
            OpenStatsOrder openStatsOrder = list.get(i);
            String stat = DateTimeUtils.formatDate(openStatsOrder.getStatDate());
            JSONObject e = new JSONObject();
            totalOrderCount += openStatsOrder.getOrderCount();
            totalAmount = totalAmount.add(openStatsOrder.getTotalAmount());
            e.put("statDate", stat);
            e.put("orderCount", totalOrderCount);
            e.put("totalAmount", totalAmount);
            map.put(stat, e);
        }

        if (export > 0) {
            Community community = null;
            String titles = "社区,服务名称,统计日期,订单数,订单总金额";
            if (communityId > 0) {
                community = communityMapper.selectByPrimaryKey(communityId);
                if (community == null) {
                    community = new Community();
                    community.setName("社区ID" + communityId);
                    community.setAddress("" + communityId);
                }
            } else {
                community = new Community();
                community.setName("全部");
                community.setAddress("");
            }
            CommunityService cs = null;
            if (serviceId > 0) {
                cs = communityServiceMapper.selectByPrimaryKey(serviceId);
                if (cs == null) {
                    cs = new CommunityService();
                    cs.setTitle("服务ID" + serviceId);
                }
            } else {
                cs = new CommunityService();
                cs.setTitle("全部");
            }
            response.setContentType("application/octet-stream;charset=utf-8");
            String fileName = "新增销售数据统计";
            response.addHeader("Content-Disposition",
                    "attachment;filename=" + java.net.URLEncoder.encode(fileName, "UTF-8") + ".xlsx");
            ServletOutputStream stream = response.getOutputStream();
            Workbook workbook = new XSSFWorkbook();
            try {
                Sheet sheet = workbook.createSheet("报表");
                Integer r1 = 0;

                WorkBookUtils.setTitle(titles, sheet.createRow(r1++));
                for (OpenStatsOrder openStatsOrder : list) {
                    int cnum = 0;
                    Row row = sheet.createRow(r1++);

                    String stat = DateTimeUtils.formatDate(openStatsOrder.getStatDate());
                    addOrderJson(map, stat, openStatsOrder.getOrderCount(), openStatsOrder.getTotalAmount());
                    WorkBookUtils.setCell(row, cnum++, community.getName());
                    WorkBookUtils.setCell(row, cnum++, cs.getTitle());
                    WorkBookUtils.setCell(row, cnum++, stat);
                    WorkBookUtils.setCell(row, cnum++, openStatsOrder.getOrderCount());
                    WorkBookUtils.setCell(row, cnum++, openStatsOrder.getTotalAmount());

                }

                workbook.write(stream);
            } finally {
                IOUtils.closeQuietly(workbook);
            }
            return null;
        }

        return Result.successData(map.values());
    }

    private void addOrderJson(LinkedHashMap<String, JSONObject> json, String statDate, int OrderCount,
                              BigDecimal unit) {
        JSONObject e = new JSONObject();
        e.put("statDate", statDate);
        e.put("orderCount", OrderCount);
        e.put("totalAmount", unit);
        json.put(statDate, e);
    }


    @RequestMapping("/guanjia_service_serial")
    public Result<?> guanjia_service_serial(
            @RequestParam(value = "syear", required = false, defaultValue = "0") int syear) {
        Map<String, Object> param = new HashMap<String, Object>();
        if (syear > 0) {
            param.put("syear", syear);
        }
        BigDecimal totalAmount = extOpenStatsMapper.totalAmountByYear(param);
        BigDecimal totalPicAmount = extOpenStatsMapper.totalAmountPicCaution(param);

        BigDecimal total = totalAmount.add(totalPicAmount).setScale(2, BigDecimal.ROUND_HALF_DOWN);
        List<JSONObject> returnList = new ArrayList<JSONObject>();
        JSONObject e = new JSONObject();
        e.put("totalAmount", total);
        returnList.add(e);
        return Result.successData(returnList);
    }


    @RequestMapping("/stat_order_stream")
    public Result<?> stat_order_stream(
            @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(value = "startTime", required = true) LocalDate startTime,
            @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(value = "endTime", required = true) LocalDate endTime,
            @RequestParam(value = "categoryId", defaultValue = "0") int categoryId, HttpServletResponse response)
            throws Exception {
        validatorParam(startTime, endTime);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startCreateDate = DateTimeUtils.date000000(sdf.parse(startTime.toString()));
        Date endCreateDate = DateTimeUtils.date235959(sdf.parse(endTime.toString()));

        List<ExtStatOrderStream> list = statsOpenOrderMapper.statOrderStream(startCreateDate, endCreateDate, categoryId);
        LinkedHashMap<String, JSONObject> map = new LinkedHashMap<String, JSONObject>();

        for (LocalDate next = startTime; !next.isAfter(endTime); next = next.plusDays(1)) {
            addOrderStreamJson(map, next.toString(), new BigDecimal(0),
                    new BigDecimal(0), new BigDecimal(0), new BigDecimal(0), new BigDecimal(0));
        }
        for (ExtStatOrderStream record : list) {
            addOrderStreamJson(map, record.getStatDate(), record.getTotalAmount(), record.getRefundMoney(),
                    record.getPlatformCharge(), record.getServiceCharge(), record.getReceiptAmount());
        }
        return Result.successData(map.values());
    }

    private void addOrderStreamJson(LinkedHashMap<String, JSONObject> json, String statDate, BigDecimal totalAmount
            , BigDecimal refundMoney, BigDecimal platformCharge, BigDecimal serviceCharge, BigDecimal receiptAmount) {
        JSONObject e = new JSONObject();
        e.put("statDate", statDate);
        e.put("totalAmount", totalAmount);
        e.put("refundMoney", refundMoney);
        e.put("platformCharge", platformCharge);
        e.put("serviceCharge", serviceCharge);
        e.put("receiptAmount", receiptAmount);
        json.put(statDate, e);
    }

    @RequestMapping("/zizai_stream_order_stat")
    public Result<?> zizai_stream_order_stat(
            @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(value = "startTime", required = true) LocalDate startTime,
            @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(value = "endTime", required = true) LocalDate endTime,
            @RequestParam(value = "export", defaultValue = "0") int export,
            @RequestParam(value = "index", defaultValue = "1") int index,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "categoryId", defaultValue = "0") int categoryId, HttpServletResponse response) throws IOException, ParseException {
        validatorParam(startTime, endTime);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startCreateDate = DateTimeUtils.date000000(sdf.parse(startTime.toString()));
        Date endCreateDate = DateTimeUtils.date235959(sdf.parse(endTime.toString()));

        //導出不分頁
        if (export > 0) {
            size = Integer.MAX_VALUE;
        }
        PageBounds pageBounds = new PageBounds(index, size);
        PageList<ExtStatOrderStreamDetail> list = statsOpenOrderMapper.zizaiStreamOrderStat(startCreateDate, endCreateDate, categoryId, pageBounds);

        if (export > 0) {
            response.setContentType("application/octet-stream;charset=utf-8");
            String fileName = "服务资金流水统计";
            response.addHeader("Content-Disposition",
                    "attachment;filename=" + new String((fileName + ".xlsx").getBytes(), "iso-8859-1"));
            ServletOutputStream stream = response.getOutputStream();
            Workbook workbook = new XSSFWorkbook();
            try {
                Sheet sheet = workbook.createSheet("报表");
                Integer r1 = 0;
                Row headerRow = sheet.createRow(r1);
                int i = 0;
                WorkBookUtils.setCell(headerRow, i++, "服务ID");
                WorkBookUtils.setCell(headerRow, i++, "服务名称");
                WorkBookUtils.setCell(headerRow, i++, "服务一级分类");
                WorkBookUtils.setCell(headerRow, i++, "服务二级分类");
                WorkBookUtils.setCell(headerRow, i++, "商家名称");
                WorkBookUtils.setCell(headerRow, i++, "商家类型");
                WorkBookUtils.setCell(headerRow, i++, "订单笔数");
                WorkBookUtils.setCell(headerRow, i++, "订单总额");
                WorkBookUtils.setCell(headerRow, i++, "退款笔数");
                WorkBookUtils.setCell(headerRow, i++, "退款总额");
                WorkBookUtils.setCell(headerRow, i++, "平台手续费总额");
                WorkBookUtils.setCell(headerRow, i++, "社区服务费总额");
                WorkBookUtils.setCell(headerRow, i++, "商家实收总额");

                for (ExtStatOrderStreamDetail detail : list) {
                    int cnum = 0;
                    r1++;
                    Row row = sheet.createRow(r1);
                    WorkBookUtils.setCell(row, cnum++, detail.getServiceId());
                    WorkBookUtils.setCell(row, cnum++, detail.getTitle());
                    WorkBookUtils.setCell(row, cnum++, StringUtils.isBlank(detail.getCategoryName()) ? "-" : detail.getCategoryName());
                    WorkBookUtils.setCell(row, cnum++, StringUtils.isBlank(detail.getSecondCategoryName()) ? "-" : detail.getSecondCategoryName());
                    WorkBookUtils.setCell(row, cnum++, detail.getMerchantName());
                    WorkBookUtils.setCell(row, cnum++, detail.getType() == 1 ? "公司" : "个人");
                    WorkBookUtils.setCell(row, cnum++, detail.getOrderCount());
                    WorkBookUtils.setCell(row, cnum++, detail.getTotalAmount());
                    WorkBookUtils.setCell(row, cnum++, detail.getRefundCount());
                    WorkBookUtils.setCell(row, cnum++, detail.getRefundMoney());
                    WorkBookUtils.setCell(row, cnum++, detail.getPlatformCharge());
                    WorkBookUtils.setCell(row, cnum++, detail.getServiceCharge());
                    WorkBookUtils.setCell(row, cnum++, detail.getReceiptAmount());
                }

                workbook.write(stream);
            } finally {
                IOUtils.closeQuietly(workbook);
            }
            return null;
        }
        return Result.successData(list.convert());
    }


}
