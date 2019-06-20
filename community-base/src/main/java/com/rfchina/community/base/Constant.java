package com.rfchina.community.base;




import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

/**
 */
public final class Constant {

	private Constant() {
	}

	public static final String community_persistence_mapper = "com.rfchina.community.persistence.mapper";
	public static final String UTF8_ENCODING = "UTF-8";

	public static final String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	public static final String DEFAULT_DATETIME2_FORMAT = "yyyy-MM-dd HH:mm";

	public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

	public static final String DEFAULT_DATE2_FORMAT = "yyyy/MM/dd";

	public static final String DEFAULT_YEAR_MONTH_FORMAT = "yyyy/MM";

	public static final String DEFAULT_YEAR_MONTH2_FORMAT = "yyyy-MM";

	public static final String SHORT_DATETIME_FORMAT = "yyyyMMddHHmmss";

	public static final String SHORT_DATE_FORMAT = "yyyyMMdd";

	public static final int DEFAULT_PARENT_ID = 0;

	public static final int DEFAULT_PAGE_INDEX = 1;

	public static final int DEFAULT_PAGE_SIZE = 20;

	public static final String ROOT_PATH = "/api/community";

	public static final String ROOT_PATH_PLATFORM = "/api/platform/admin";

	public static final String ROOT_PATH_COMMUNITY = "/api/community/admin";

	public static final String ROOT_PATH_MASTER = "/api/master/admin";

	public static final String ROOT_PATH_OPENWEB = "/api/openweb";
	
	public static final String ROOT_PATH_BROTHERS= "/api/brothers";
	
	public static final String ROOT_PATH_OPEN = "/community/api/open/admin";
	
	public static final String ROOT_PATH_OPENSTORE = "/api/openstore";

	public static final Integer DEFAULT_ROOT_ID_INTEGER = 0;

	public static final int MASTER_CHILD_ROLE_GENENAL = 1;

	public static final int MASTER_CHILD_ROLE_AGENT_RELEASE = 2;

	public static final int MASTER_CHILD_ROLE_RELEASE = 3;

	public static final String AUTO_LOGIN_PASSWORD = "tty27wEIg4a2Q3u5bQrMMyANjAh8Iu92CFobLb20cjlRdatrIDotBtjsrEG6c4QDc1Y2C2gnQv30m4Y4luvTtNiAO0nJEeiQ1Zbk";

	private static final LocalDateTime CLEARING_FEE_BEGIN_TIME = LocalDateTime.of(2017, 8, 1, 0,0,0);

	public interface ClearingFee {

		static boolean isValid() {
			LocalDateTime nowLocalDateTime = LocalDateTime.now();
			if(nowLocalDateTime.isEqual(CLEARING_FEE_BEGIN_TIME)
					|| nowLocalDateTime.isAfter(CLEARING_FEE_BEGIN_TIME)) {
				return true;
			}
			return false;
		}

		static BigDecimal calculate(BigDecimal rfpayClearingFee) {
			if(Constant.ClearingFee.isValid()) {
				if (rfpayClearingFee.longValue() >= 1) {
					BigDecimal rfpayClearingFeeWithScale = rfpayClearingFee.setScale(0, BigDecimal.ROUND_HALF_UP);
					return rfpayClearingFeeWithScale;
				}
			}
			return BigDecimal.valueOf(0);
		}
	}

	public static final Map<Integer, String> ROLE_MAP = new HashMap<Integer, String>() {

		{
			put(1, "普通");
			put(2, "代理放行");
			put(3, "自主放行");
		}
	};
	public static final Map<Integer, String> HOUSES_TYPE = new HashMap<Integer, String>() {

		{
			put(1, "房间");
			put(2, "商铺");
			put(3, "车位");
		}
	};

	public static final Map<String, String> PAYMENT_TYPE = new HashMap<String, String>() {

		{
			put("AliPay", "支付宝");
			put("WeiXin", "微信");
		}
	};

	public static final Map<String, Integer> BILL_STATUS_MAP = new HashMap<String, Integer>() {
		{
			put("SAVE", 1);
			put("TRADE_PAID_SUCCESS", 2);
			put("TRADE_REFUND_SUCCESS", 3);
			put("TRADE_REFUND_AUDITED_SUCCESS", 4);
			put("TRADE_REFUND_AUDITED_FAILURE", 5);
			put("TRADE_TIMEOUT_CLOSE", 6);
			put("TRADE_REFUND_FAILURE", 7);
			put("TRADE_SCANED_CODE", 8);
			put("APPLY_REFUND", 9);
			put("APPLY_SETTLEMENT", 10);
			put("APPLY_POST_BUSSINESS_BILLS", 11);
			put("TRADE_PAID_FAILURE", 12);
		}
	};

	public static final Map<Integer, String> INVOICE_STATUS = new HashMap<Integer,String>(){
		{
			put(0,"");
			put(1,"开票中");
			put(2,"已开票");
		}
	};

	public static final List<String> SERVICE_LIST = new ArrayList<>();
	static {
		SERVICE_LIST.add("申请拜访");
		SERVICE_LIST.add("邀请来访");
	}

	public interface YesOrNo {

		Integer YES = 1;
		Integer NO = 0;

		public static String translate(int code) {
			Map<Integer, String> map = new HashMap<>();
			map.put(YES, "是");
			map.put(NO, "否");
			return map.getOrDefault(code, "");
		}
	}



	public interface OptType {

		Integer ADD = 1;

		Integer DELETE = 2;
	}

	public interface AppEnvironment {
		String DEVELOPMENT = "development";
		String TEST = "test";
		String PRERELEASE = "prerelease";
		String PRODUCTION = "production";
	}

	public interface PlatformAdmin {

		interface Status {
			/** 已启用 */
			Integer ENABLE = 1;
			/** 禁用 */
			Integer DISABLE = 2;

			public static String translate(int code) {
				Map<Integer, String> map = new HashMap<>();
				// map.put(UNPAID, "待付款");
				map.put(ENABLE, "启用");
				map.put(DISABLE, "禁用");
				return map.getOrDefault(code, "");
			}
		}
	}

	public interface App {

		interface Id {

			/**　*/
			ValueNamePair<Integer, String> PLATFORM_ADMIN = ValueNamePair.of(180100, "平台管理后台");

			ValueNamePair<Integer, String> COMMUNITY_ADMIN = ValueNamePair.of(180200, "社区运营管理后台");

			ValueNamePair<Integer, String> MASTER_ADMIN = ValueNamePair.of(180300, "房间管理后台");

			ValueNamePair<Integer, String> MERCHANT_ADMIN = ValueNamePair.of(180400, "商家管理后台");

			ValueNamePair<Integer, String> COMMUNITY_API = ValueNamePair.of(180500, "自在社区后台API");
			
			ValueNamePair<Integer, String> OPEN_MERCHANT = ValueNamePair.of(180600, "开放平台(服务商)");
		}

		interface Type {

			int INTERNAL = 1; // 富力内部系统
		}
	}

	public interface SysResource {

		interface Status {

			/** 已启用 */
			int ENABLE = 1;
			/** 禁用 */
			int DISABLE = 2;
		}

		interface Type {
			Integer MENU = 1;
			Integer IFACE = 2;
			Integer SHARED_IFACE = 3;
		}

		interface Level {

			int LV0 = 0;
			int LV1 = 1;
			int LV2 = 2;
			int LV3 = 3;
			int LV4 = 4;
		}
	}

	public interface Ad {

		interface Status {
			Integer UNAUDIT = 1;
			Integer AUDIT_PASS = 2;
			Integer AUDIT_NOT_PASS = 3;
			Integer AUDITING = 4; // 审核中
			Integer PLATFORM_AUDIT_PASS = 10;
			Integer PLATFORM_AUDIT_NOT_PASS = 11;
			Integer PLATFORM_PUBLISH = 12;
			Integer PLATFORM_REPEAL = 13;
			Integer PLATFORM_UNAUDIT = 14;
			Integer PLATFORM_AUDITING = 15;

			public static String translate(int code) {
				Map<Integer, String> map = new HashMap<>();
				map.put(UNAUDIT, "待审核");
				map.put(AUDIT_PASS, "审核通过");
				map.put(AUDIT_NOT_PASS, "审核不通过");
				map.put(AUDITING, "审核中");
				map.put(PLATFORM_AUDIT_PASS, "平台审核通过");
				map.put(PLATFORM_AUDIT_NOT_PASS, "平台审核不通过");
				map.put(PLATFORM_PUBLISH, "上架");
				map.put(PLATFORM_REPEAL, "下架");
				map.put(PLATFORM_UNAUDIT, "平台待审核");
				map.put(PLATFORM_AUDITING, "平台审核中");
				return map.getOrDefault(code, "");
			}

		}

		interface SrcType {

			int COMMUNITY_ADMIN = 1;
			int PLATFORM_ADMIN = 2;
		}

		interface AutoFlag {

			int NORMAL = 0;
			int AUTO_REPEAL = 1;
			int AUTO_PUBLISH = 2;
		}

	}

	public interface AdCategory {

		int HOME = 1;

		int PROPERTY_PAYMENT = 2;

		interface Status {

			/** 已启用 */
			int ENABLE = 1;
			/** 禁用 */
			int DISABLE = 2;

			public static String translate(int code) {
				Map<Integer, String> map = new HashMap<>();
				map.put(ENABLE, "启用");
				map.put(DISABLE, "禁用");
				return map.getOrDefault(code, "");
			}
		}
	}

	public interface Notification {

		interface Type {

			/** APP消息推送 */
			int APP_PUSH = 1;
			/** 站内消息 */
			int SITE_MSG = 2;

			public static String translate(int code) {
				Map<Integer, String> map = new HashMap<>();
				map.put(APP_PUSH, "APP消息推送");
				map.put(SITE_MSG, "站内消息");
				return map.getOrDefault(code, "");
			}
		}

		interface Status {
			/** 社区草稿 */
			int commnunity_draft = 1;
			/** 社区审批中 */
			int commnunity_auditing = 2;
			/** 社区审核不通 */
			int commnunity_un_pass = 3;
			/** 平台草稿 */
			int platform_draft = 11;
			/** 平台审批中 */
			int platform_auditing = 12;
			/** 平台审核不通 */
			int platform_un_pass = 13;
			/** 过期状态 */
			int expired_status = 9;
			/** 发布状态 */
			int ok_publish = 21;
			/** 定时发布 */
			int Timing_up_publish = 20;
			/** 删除 */
			int DELETE = 30;

			public static String translate(int code) {
				Map<Integer, String> map = new HashMap<>();
				map.put(commnunity_draft, "社区草稿");
				map.put(commnunity_auditing, "社区审批中");
				map.put(commnunity_un_pass, "社区审核不通过");
				map.put(platform_draft, "平台草稿");
				map.put(platform_auditing, "平台审批中");
				map.put(platform_un_pass, "平台审核不通过");
				map.put(expired_status, "过期状态");
				map.put(ok_publish, "发布状态");
				map.put(Timing_up_publish, "定时发布");
				map.put(DELETE, "删除");
				return map.getOrDefault(code, "");
			}
		}
	}

	public interface CommunityAdmin {

		interface Status {

			/** 已启用 */
			Integer ENABLE = 1;
			/** 禁用 */
			Integer DISABLE = 2;

			public static String translate(int code) {
				Map<Integer, String> map = new HashMap<>();
				// map.put(UNPAID, "待付款");
				map.put(ENABLE, "启用");
				map.put(DISABLE, "禁用");
				return map.getOrDefault(code, "");
			}
		}
	}

	public interface WaterDeposit {

		interface Type {

			int ALL = 0;
			int NORMAL = 1;
		}

		interface Status {

			Integer ALL = 0;
			Integer PAY = 1;
			Integer REFUND = 2;

			public static String translate(int code) {
				Map<Integer, String> map = new HashMap<>();
				map.put(ALL, "全部");
				map.put(PAY, "已收");
				map.put(REFUND, "已退");
				return map.getOrDefault(code, "");
			}
		}

		interface ExportType {

			Integer BY_PAY_TIME = 1;
			Integer BY_REFUND_TIME = 2;
		}
	}

	public interface SysRole {

		public static final Integer SYS_ADMIN_ROLE = 1;

		interface Status {

			/** 已启用 */
			Integer ENABLE = 1;
			/** 禁用 */
			Integer DISABLE = 2;

			public static String translate(int code) {
				Map<Integer, String> map = new HashMap<>();
				// map.put(UNPAID, "待付款");
				map.put(ENABLE, "启用");
				map.put(DISABLE, "禁用");
				return map.getOrDefault(code, "");
			}
		}

		interface Type {

			/** 用户自定义 */
			int CUSTOM = 1;
			/** 系统 */
			int SYSTEM = 2;
		}
	}

	public interface SysDept {

		interface Status {

			/** 已启用 */
			Integer ENABLE = 1;
			/** 禁用 */
			Integer DISABLE = 2;

			public static String translate(int code) {
				Map<Integer, String> map = new HashMap<>();
				// map.put(UNPAID, "待付款");
				map.put(ENABLE, "启用");
				map.put(DISABLE, "禁用");
				return map.getOrDefault(code, "");
			}
		}
	}

	public interface CardReport {

		interface Category {

			/** 垃圾营销 */
			int GARBAGE_MARKETING = 1;
			/** 欺诈信息 */
			int FRAUD_INFO = 2;
			/** 有害信息 */
			int HARMFUL_INFO = 3;
			/** 违法信息 */
			int ILLEGAL_INFO = 4;
			/** 色情淫秽 */
			int PORNOGRAPHY = 5;
			/** 人身攻击 */
			int PERSONAL_ATTACK = 6;
			/** 其它 */
			int OTHER = 7;
		}

		interface Status {

			/** 未审核 */
			Integer UNAUDIT = 0;
			/** 删除卡片 */
			Integer DELETE_CARD_INFO = 1;
			/** 忽略本次举报 */
			Integer IGNORE_CARD_REPORT = 2;
		}
	}

	public interface CardInfo {

		interface Status {

			/** 正常 */
			Integer NORMAL = 1;
			/** 隐藏 */
			Integer HIDDEN = 2;
			/** 删除 */
			Integer DELETED = 3;
		}

		interface AuditStatus {

			/** 待审核 */
			Integer UNAUDIT = 1;
			/** 审核通过 */
			Integer AUDIT_PASS = 2;
			/** 审核不通过 */
			Integer AUDIT_NOTPASS = 3;
			/** 上架 */
			Integer PUBLISH = 4;
			/** 下架 */
			Integer REPEAL = 5;
			/** 审核中 */
			Integer AUDITING = 6;

			public static String translate(int code) {
				Map<Integer, String> map = new HashMap<>();
				map.put(UNAUDIT, "待审核");
				map.put(AUDIT_PASS, "审核通过");
				map.put(AUDIT_NOTPASS, "审核不通过");
				map.put(PUBLISH, "上架");
				map.put(REPEAL, "下架");
				map.put(AUDITING, "审核中");
				return map.getOrDefault(code, "");
			}
		}

		interface SquareAuditStatus {

			/** 待审核 */
			Integer UNAUDIT = 1;
			/** 审核通过 */
			Integer AUDIT_PASS = 2;
			/** 审核不通过 */
			Integer AUDIT_NOTPASS = 3;
			/** 上架 */
			Integer PUBLISH = 4;
			/** 下架 */
			Integer REPEAL = 5;
			/** 审核中 */
			Integer AUDITING = 6;

			public static String translate(int code) {
				Map<Integer, String> map = new HashMap<>();
				map.put(UNAUDIT, "待审核");
				map.put(AUDIT_PASS, "审核通过");
				map.put(AUDIT_NOTPASS, "审核不通过");
				map.put(PUBLISH, "上架");
				map.put(REPEAL, "下架");
				map.put(AUDITING, "审核中");
				return map.getOrDefault(code, "");
			}
		}
	}

	public interface CardComment {

		interface Status {

			Integer NORMAL = 1;

			Integer DELETED_BY_USER = 2;

			Integer DELETED_BY_AUDIT = 3;
		}
	}

	public interface MasterInfo {

		interface Status {

			/** 已启用 */
			Integer ENABLE = 1;
			/** 禁用 */
			Integer DISABLE = 2;

			public static String translate(int code) {
				Map<Integer, String> map = new HashMap<>();
				// map.put(UNPAID, "待付款");
				map.put(ENABLE, "启用");
				map.put(DISABLE, "禁用");
				return map.getOrDefault(code, "");
			}
		}

		interface Type {
			Integer COMPANY = 1;
			Integer COMMUNITY = 2;
			Integer PARKING = 3;
			Integer STORE = 4;

			public static String translate(int code) {
				Map<Integer, String> map = new HashMap<>();
				map.put(COMPANY, "公司");
				map.put(COMMUNITY, "社区住宅");
				map.put(PARKING, "车位");
				map.put(STORE, "商铺");
				return map.getOrDefault(code, "");
			}
		}

		interface CanVisit {
			Integer YES = 1;
			Integer NO = 2;

			public static String translate(int code) {
				Map<Integer, String> map = new HashMap<>();
				map.put(YES, "是");
				map.put(NO, "否");
				return map.getOrDefault(code, "");
			}
		}

		interface ParkingType {
			Integer NORMAL = 1;
		}

		interface ParkingOwnerType {
			Integer OWNER = 1;	//业主持有
			Integer ESTATE = 2;	//地产公司持有

			public static String translate(int code) {
				Map<Integer, String> map = new HashMap<>();
				map.put(OWNER, "业主");
				map.put(ESTATE, "物业");
				return map.getOrDefault(code, "");
			}
		}

		interface ParkingStatus {
			Integer SELF_USE = 1;
			Integer TENANT = 2;
		}
	}

	public interface MasterChild {

		// 1业主2租户3业户4家人
		interface Type {
			Integer OWNER = 1;
			Integer TENANT = 2;
			Integer BIZ_OWNER = 3;
			Integer FAMILY = 4;

			public static String translate(int code) {
				Map<Integer, String> map = new HashMap<>();
				map.put(OWNER, "业主");
				map.put(TENANT, "租户");
				map.put(BIZ_OWNER, "业户");
				map.put(FAMILY, "家人");
				return map.getOrDefault(code, "");
			}

			public static Integer reverseTranslate(String word) {
				Map<String, Integer> map = new HashMap<>();
				map.put("业主", OWNER);
				map.put("租户", TENANT);
				map.put("业户", BIZ_OWNER);
				map.put("家人", FAMILY);
				return map.getOrDefault(word, 0);
			}
		}

		interface StaffType {
			int EPM_1 = 1;
			int EMP_2 = 2;

			public static String translate(int code) {
				Map<Integer, String> map = new HashMap<>();
				map.put(EPM_1, "雇佣员工");
				map.put(EMP_2, "驻场员工");
				return map.getOrDefault(code, "");
			}
		}

		interface ParkingType {

			/** 已启用 */
			int OWNER = 1;
			/** 禁用 */
			int TENANT = 2;

			public static String translate(int code) {
				Map<Integer, String> map = new HashMap<>();
				map.put(OWNER, "业主");
				map.put(TENANT, "租户");
				return map.getOrDefault(code, "");
			}
		}

		interface StoreType {

			/** 已启用 */
			int OWNER = 1;
			/** 禁用 */
			int TENANT = 2;

			public static String translate(int code) {
				Map<Integer, String> map = new HashMap<>();
				// map.put(UNPAID, "待付款");
				map.put(OWNER, "业主");
				map.put(TENANT, "租户");
				return map.getOrDefault(code, "");
			}
		}

		interface Status {

			/** 已启用 */
			int ENABLE = 1;
			/** 禁用 */
			int DISABLE = 2;

			public static String translate(int code) {
				Map<Integer, String> map = new HashMap<>();
				map.put(ENABLE, "启用");
				map.put(DISABLE, "禁用");
				return map.getOrDefault(code, "");
			}
		}
	}

	public interface CommonCfg {
		interface Key {
			String ZIZAI_IOS_APP_STORE_URL_KEY = "zizai_ios_app_store_url_key";

			String ZIZAI_ANDROID_APP_STORE_URL_KEY = "zizai_android_app_store_url_key";
		}
		interface Status {
			Integer ENABLE = 1;
			Integer DISABLE = 2;
		}
	}

	public interface Community {

		interface Status {

			/** 已启用 */
			Integer ENABLE = 1;
			/** 禁用 */
			Integer DISABLE = 2;

			public static String translate(int code) {
				Map<Integer, String> map = new HashMap<>();
				// map.put(UNPAID, "待付款");
				map.put(ENABLE, "启用");
				map.put(DISABLE, "禁用");
				return map.getOrDefault(code, "");
			}
		}

		interface Type {
			/** 写字楼 */
			int ENABLE = 1;
			/** 住宅社区 */
			int DISABLE = 2;

			public static String translate(int code) {
				Map<Integer, String> map = new HashMap<>();
				map.put(ENABLE, "写字楼");
				map.put(DISABLE, "住宅社区");
				return map.getOrDefault(code, "");
			}
		}

		interface TopicAudit {

			Integer ENABLE = 1; // 启用

			Integer DISABLE = 2; // 不启用

			public static String translate(int code) {
				Map<Integer, String> map = new HashMap<>();
				// map.put(UNPAID, "待付款");
				map.put(ENABLE, "启用");
				map.put(DISABLE, "禁用");
				return map.getOrDefault(code, "");
			}
		}
	}

	public interface CommunityAttention {
		interface AddType {
			Integer USER = 1;
			Integer SYSTEM = 2;
		}
	}

	public interface CommunityService {

		int APPLY_VENUE = 1; // 预约场地
		int WATER_SUPPLY = 2; // 送水服务
		int APPLY_VISIT = 3; // 申请拜访
		int APPOINTMENT = 4; // 预约来访
		int PROPERTY_PAYMENT = 5; // 物业缴费
		int REPAIR_AND_ISSUE = 6; 		// 意见保修ISSUE_AND
		int FENGCHAO = 7;		//蜂巢
		int BEEBOX = 8;		//蜜蜂箱
		int PARKING = 9;
		int BIZ_APPLY = 10;	//门禁卡业务办理
		int GUARD_SERVICE = 11;	//门禁服务

		interface Status {

			Integer ENABLE = 1;
			Integer DISABLE = 2;
		}

		List<Integer> BASE_SERVICE_LIST = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10,11);

		public static String translateToEnglishName(int code) {
			Map<Integer, String> map = new HashMap<>();
			map.put(APPLY_VENUE, "APPLY_VENUE");
			map.put(WATER_SUPPLY, "WATER_SUPPLY");
			map.put(APPLY_VISIT, "APPLY_VISIT");
			map.put(APPOINTMENT, "APPOINTMENT");
			map.put(PROPERTY_PAYMENT, "PROPERTY_PAYMENT");
			map.put(REPAIR_AND_ISSUE, "REPAIR_AND_ISSUE");
			map.put(FENGCHAO, "FENGCHAO");
			map.put(BEEBOX, "BEEBOX");
			map.put(PARKING, "PARKING");
			map.put(BIZ_APPLY, "BIZ_APPLY");
			map.put(GUARD_SERVICE, "GUARD_SERVICE");
			return map.getOrDefault(code, "");
		}
	}

	public interface CommunityServiceRela {

		interface Status {
			Integer ENABLE = 1;//启用
			Integer DISABLE = 2;//禁用
			Integer STOP = 4;//停用
		}
	}

	public interface CardSubject {

		interface Type {

			/** 普通用户 */
			Integer NORMAL_USER = 1;
			/** 社区运营者 */
			Integer COMMUNITY_ADMIN = 2;
		}
	}

	public interface CardTemplate {

		public static final int BASE_TEMPLTE_ID = 1;
	}

	public interface CardCategory {

		/** 最新 */
		public static final int FIXED_LATEST_CATEGORY_ID = 1;
		/** 公告 */
		public static final int FIXED_NOTICE_CATEGORY_ID = 2;
		/** 活动 */
		public static final int FIXED_EVENT_CATEGORY_ID = 3;

		interface Type {

			/** 固定的公告 */
			Integer FIXED_NOTICE_CATEGORY = 1;
			/** 固定分类 */
			Integer FIXED_EVENT_CATEGORY = 2;
			Integer FIXED_CATEGORY = 2;
			/** 自定义分类 */
			Integer CUSTOM_CATEGORY = 3;
		}

		interface Name {

			String FIXED_NOTICE_CATEGORY = "公告";

			String FIXED_EVENT_CATEGORY = "活动";

			String CUSTOM_INFO_CATEGORY = "社区资讯";
		}

		interface Status {

			/** 已启用 */
			Integer ENABLE = 1;
			/** 禁用 */
			Integer DISABLE = 2;

			public static String translate(int code) {
				Map<Integer, String> map = new HashMap<>();
				// map.put(UNPAID, "待付款");
				map.put(ENABLE, "启用");
				map.put(DISABLE, "禁用");
				return map.getOrDefault(code, "");
			}
		}
	}

	public interface UserInfo {

		interface Status {

			Integer NORMAL = 1;
			/** 禁用 */
			Integer DISABLE = 2;

			public static String translate(int code) {
				Map<Integer, String> map = new HashMap<>();
				// map.put(UNPAID, "待付款");
				map.put(NORMAL, "启用");
				map.put(DISABLE, "禁用");
				return map.getOrDefault(code, "");
			}
		}

		interface RegSrc {
			Integer FROM_APP = 1;	//来自自在社区APP
			Integer FROM_OTHER = 2;	//来自别的
			Integer SMS_LOGIN = 3;	//短信登录
		}
	}

	public interface SearchWords {

		interface Status {

			int ENABLE = 1;
			int DISABLE = 2;
		}
	}

	public interface Passport {

		interface Status {

			Integer UNVERIFIED = 0;

			Integer ENABLE = 1;

			Integer DISABLE = 2;
			
			Integer UN_ACTIVATION = 3;

			public static String translate(int code) {
				Map<Integer, String> map = new HashMap<>();
				map.put(ENABLE, "启用");
				map.put(DISABLE, "禁用");
				map.put(UN_ACTIVATION, "未激活");
				return map.getOrDefault(code, "");
			}
		}

		interface Type {
			Integer INTERNAL = 1;
			Integer MGT_EMP = 2;
		}
	}

	public interface WaterSupply {

		interface Type {

			Integer WATER = 1; // 水
			Integer WATER_TICKET = 2; // 水票

			public static String translate(int code) {
				Map<Integer, String> map = new HashMap<>();
				map.put(WATER, "水");
				map.put(WATER_TICKET, "水票");
				return map.getOrDefault(code, "");
			}
		}

		interface Status {

			Integer ENABLE = 1;
			Integer DISABLE = 2;

			public static String translate(int code) {
				Map<Integer, String> map = new HashMap<>();
				map.put(ENABLE, "启用");
				map.put(DISABLE, "禁用");
				return map.getOrDefault(code, "");
			}
		}
	}

	public interface CommunityMsg {

		interface Status {

			/** 未发布 */
			Integer UNPUBLISHED = 1;
			/** 禁用 */
			Integer PUBLISHED = 2;
		}
	}

	public interface WaterCfg {

		int DEFAULT_INTERVAL = 30;
	}

	public interface VenueStatus {

		Integer ENABLE = 1;
		Integer DISABLE = 2;

		public static String translate(int code) {
			Map<Integer, String> map = new HashMap<>();
			map.put(ENABLE, "启用");
			map.put(DISABLE, "禁用");
			return map.getOrDefault(code, "");
		}
	}

	public interface VenueInfo {
		interface ChargeType {
			int BY_TIME = 1;
			int BY_COUNT = 2;

			public static String translate(int code) {
				Map<Integer, String> map = new HashMap<>();
				map.put(BY_TIME, "按时间计费");
				map.put(BY_COUNT, "按次数计费");
				return map.getOrDefault(code, "");
			}
		}

		interface WeekPart {
			int SUNDAY = 0;
			int MONDAY = 1;
			int TUESDAY = 2;
			int WEDNESDAY = 3;
			int THURSDAY = 4;
			int FRIDAY = 5;
			int SATURDAY = 6;

			public static String translate(int code) {
				Map<Integer, String> map = new HashMap<>();
				map.put(SUNDAY, "星期日");
				map.put(MONDAY, "星期一");
				map.put(TUESDAY, "星期二");
				map.put(WEDNESDAY, "星期三");
				map.put(THURSDAY, "星期四");
				map.put(FRIDAY, "星期五");
				map.put(SATURDAY, "星期六");
				return map.getOrDefault(code, "");
			}
		}
	}

	public interface VenueOrder {

		// 线上渠道
		public static final int reservation_channels_online = 1;
		// 线下渠道
		public static final int reservation_channels_offline = 2;

		public enum ChargeType {

			/**
			 * 1 时间段,2按次
			 *
			 */
			period_step(1), Times_step(2);

			private int index;

			ChargeType(int index) {
				this.index = index;
			}

			public int getIndex() {
				return index;
			}

		}

		public static final int END_DAY = 7;
		public static final String PAY_TRADE_NO_PREFIX = "ve_";

		public static final String payType_AliPay = "AliPay";
		public static final String payType_WeiXin = "WeiXin";
		public static final String payType_offline = "offline";

		public enum Status {

			/**
			 * 1 初始化,2抢单成功,3待支付,10订单成功,20 确认使用,21订单过期
			 *
			 */
			init(1), Rob_orders_successful(2), Pending_order(3), apply_order_fail(4), cancel_order(5), orders_successful(10), Confirm_use(20), ORDERS_EXPIRED(21);

			private int index;

			Status(int index) {
				this.index = index;
			}

			public int getIndex() {
				return index;
			}

			public static String translate(int index) {
				switch (index) {
				case 1:
					return "初始化";
				case 2:
					return "抢单成功";
				case 3:
					return "待支付";
				case 4:
					return "订单失败";
				case 5:
					return "订单取消";
				case 10:
					return "订单成功";
				case 20:
					return "确认使用";
				case 21:
					return "订单过期";
				default:
					return "";
				}
			}

		}

		public enum StatusPay {

			/**
			 * 1 初始化,3待支付,10支付成功
			 *
			 */
			init(1), Pending_order(3), pay_out_time(11), payment_successful(10), pay_offline(18);

			private int index;

			StatusPay(int index) {
				this.index = index;
			}

			public int getIndex() {
				return index;
			}

		}

	}

	public interface WaterOrder {

		public static final String PAY_TRADE_NO_PREFIX = "wo_";

		interface OrderType {
			Integer WATER = 1; // 订水
			Integer WATER_TICKET = 2; // 订水票

			public static String translate(int code) {
				Map<Integer, String> map = new HashMap<>();
				map.put(WATER, "买水");
				map.put(WATER_TICKET, "买水票");
				return map.getOrDefault(code, "");
			}
		}

		interface OrderStatus {

			/** 待付款 */
			// int ONLINE_UNPAY = 1;
			/** 待发货 */
			Integer UNDELIVERED = 2;
			/** 配送中 */
			Integer DELIVERING = 3;
			/** 已到达 */
			Integer ARRIVAL = 4;
			/** 已取消 */
			Integer CANCELLED = 5;
			/** 已拒收 */
			Integer REFUSED = 6;

			public static String translate(int code) {
				Map<Integer, String> map = new HashMap<>();
				// map.put(UNPAID, "待付款");
				map.put(UNDELIVERED, "待发货");
				map.put(DELIVERING, "配送中");
				map.put(ARRIVAL, "已送达");
				map.put(CANCELLED, "已取消");
				map.put(REFUSED, "已拒收");
				return map.getOrDefault(code, "");
			}
		}

		interface OrderSrc {

			int APP = 1;
			int SYSTEM = 2;

			public static String translate(int code) {
				Map<Integer, String> map = new HashMap<>();
				map.put(APP, "线上");
				map.put(SYSTEM, "线下");
				return map.getOrDefault(code, "");
			}
		}

		interface PayType {

			Integer CASH = 1; // 现金
			Integer WATER_TICKET = 2; // 水票
			Integer WECHAT = 3; // 微信
			Integer ALIPAY = 4; // 支付宝

			public static String translate(int code) {
				Map<Integer, String> map = new HashMap<>();
				map.put(CASH, "现金支付");
				map.put(WATER_TICKET, "水票支付");
				map.put(WECHAT, "微信");
				map.put(ALIPAY, "支付宝");
				return map.getOrDefault(code, "");
			}
		}

		/** 支付状态 */
		interface PayStatus {

			Integer ONLINE_UNPAY = 1; // 在线未支付
			Integer ONLINE_PAY = 2; // 在线已支付
			Integer ONLINE_PREPAY = 4; // 在线预付
			Integer CASH_UNPAY = 5; // 现金支付
			Integer CASH_PAY = 6; // 现金支付
		}

		interface TakeWater {

			Integer NO = 0;
			Integer YES = 1;
			Integer FINISH = 2;

			public static String translate(int code) {
				Map<Integer, String> map = new HashMap<>();
				map.put(NO, "否");
				map.put(YES, "是");
				map.put(FINISH, "完成");
				return map.getOrDefault(code, "");
			}
		}

		interface IssueTicket {

			Integer NO = 0;
			Integer YES = 1;
			Integer FINISH = 2;

			public static String translate(int code) {
				Map<Integer, String> map = new HashMap<>();
				map.put(NO, "否");
				map.put(YES, "是");
				map.put(FINISH, "完成");
				return map.getOrDefault(code, "");
			}
		}
	}

	public interface TradeStatus {

		// 交易状态, TRADE_PAID_SUCCESS: 用户支付成功,
		// TRADE_REFUND_SUCCESS: 用户退款成功,
		// TRADE_REFUND_AUDITED_SUCCESS: 用户退款审核成功,
		// TRADE_REFUND_AUDITED_FAILURE: 用户退款审核失败,
		// TRADE_TIMEOUT_CLOSE:用户未付款超时关闭
		// TRADE_PAID_FAILURE:用户支付失败

		public static final String TRADE_PAID_SUCCESS = "TRADE_PAID_SUCCESS";

		public static final String TRADE_REFUND_SUCCESS = "TRADE_REFUND_SUCCESS";

		public static final String TRADE_REFUND_AUDITED_SUCCESS = "TRADE_REFUND_AUDITED_SUCCESS";

		public static final String TRADE_REFUND_AUDITED_FAILURE = "TRADE_REFUND_AUDITED_FAILURE";
		
		public static final String TRADE_REFUND_FAILURE = "TRADE_REFUND_FAILURE";
		
		public static final String TRADE_TIMEOUT_CLOSE = "TRADE_TIMEOUT_CLOSE";
		
		public static final String TRADE_SCANED_CODE = "TRADE_SCANED_CODE";
		
		public static final String TRADE_PAID_FAILURE = "TRADE_PAID_FAILURE";
	}

	public interface RfPayType {
		public static final String ALIPAY = "AliPay";
		public static final String WEIXIN = "WeiXin";
	}
	public interface SysMsg {

		interface Target {

			int PLATFOROM_ADMIN = 1;

		}

		interface Status {

			/** 未发布 */
			int UNPUBLISHED = 1;
			/** 已发布 */
			int PUBLISHED = 2;
		}
	}

	public interface user_msg {

		// 1社区 2系统公告,3 系统消息
		interface msgType {

			/** 预约 */
			int commnunity = 1;
			/** 系统消息 */
			int sys_msg = 3;
			/** 系统公告 */
			int system_notification = 2;

		}

		interface object_type {

			// 0表示无对象,1预约,2邀约,3系统公告,4卡片,5 报修,6社区
			/** 预约 */
			int none = 0;
			/** 预约 */
			int appointment = 1;
			/** 邀约 */
			int invitations = 2;
			/** 系统消息 */
			int system_notification = 3;
			/** 卡片 */
			int card = 4;
			/** 报修 */
			int repair = 5;
			/** 社区 */
			int commnunity = 6;

		}

		interface is_read {

			// '1未读,2已读',
			int unread = 1;
			int read = 2;
		}

		interface Status {

			// 1正常,2删除
			int ok = 1;
			int del = 2;
		}
	}

	public interface ReleaseApplyGoods {
		// 状态 0待提交, 1:待审核、2:审核通过、3:审核不通过、4:完成、5:超时
		interface Status {
			public static final int INIT = 0;
			public static final int UNAUDIT = 1;
			public static final int AUDIT_PASS = 2;
			public static final int AUDIT_NOTPASS = 3;
			public static final int AUDIT_FINISH = 4;
			public static final int AUDIT_TIMEOUT = 5;

			public static String translate(int code) {
				Map<Integer, String> map = new HashMap<>();
				map.put(INIT, "待提交");
				map.put(UNAUDIT, "待审核");
				map.put(AUDIT_PASS, "审核通过");
				map.put(AUDIT_NOTPASS, "审核不通过");
				map.put(AUDIT_FINISH, "完成");
				map.put(AUDIT_TIMEOUT, "超时");
				return map.getOrDefault(code, "");
			}
		}
	}

	public interface Visit {

		interface EntranceGuardType {
			int QRCODE = 1;
			int OTHER = 2;

			public static String translate(int code) {
				Map<Integer, String> map = new HashMap<>();
				map.put(QRCODE, "二维码");
				map.put(OTHER, "其他");
				return map.getOrDefault(code, "");
			}
		}
	}

	public interface GagInfo {

		interface Status {
			int ENABLE = 1;
			int DISABlE = 2;

			public static String translate(int code) {
				Map<Integer, String> map = new HashMap<>();
				map.put(ENABLE, "启用");
				map.put(DISABlE, "禁用");
				return map.getOrDefault(code, "");
			}
		}
	}

	public interface OpenOrder {
		public static final String PAY_TRADE_NO_PREFIX = "open_";
		
		public static final String PAY_TRADE_NO_PREFIX_NEW = "life_";
		
		public String PAY_CAUTION_PREFIX = "cau_";

		public String PAY_ACTIVITY_PREFIX = "cau_a";
		
		public String PAY_FEE_PREFIX = "cau_f";
		
		interface BillStatus{
			int TRADE_UNPAID = 1;      //未支付
			int TRADE_PAID_SUCCESS = 2;     //支付成功
			int TRADE_TIMEOUT_CLOSE = 3;    //交易关闭
			int TRADE_END = 4;             //交易结束
			int TRADE_TIMEOUT_CLOSE2 = 6;             //交易结束
			public static String translate(Integer code){
				Map<Integer, String> map = new HashMap<>();
				map.put(TRADE_UNPAID, "未支付");
				map.put(TRADE_PAID_SUCCESS, "支付成功");
				map.put(TRADE_TIMEOUT_CLOSE, "交易关闭");
				map.put(TRADE_END, "交易结束");
				map.put(TRADE_TIMEOUT_CLOSE2, "支付超时");
				
				return map.getOrDefault(code, "");
			}
		}
		
		
		interface RefundStatus{
			int REFUND_AUDIT = 1;      //退款审批中
			int REFUND_SUCCESS = 2;     //退款成功
			int REFUND_FAILURE = 3;    //退款失败
			public static String translate(Integer code){
			    if(code == null){
                    return "";
                }else if(code == 1 || code == 5 ||code == 6 || code == 7){
					return "退款审批中";
				}else if(code == REFUND_SUCCESS){
					return "退款成功";
				}else if(code == REFUND_FAILURE){
					return "退款失败";
				}
				return "";
			}
		}
		
		interface WithdrawStatus{
			int UNWITHDRAW = 1;      //未到提现时间
			int ENABLE_WITHDRAW = 2;     //可提现
			int WITHDRAW_AUDIT = 3;    //提现审批中
			int WITHDRAW_SUCCESS = 4; //提现成功
			int WITHDRAW_FAILURE = 5;    //提现失败
			int NOT_WITHDRAW = 6;    //不可提现
			public static String translate(int code){
				Map<Integer, String> map = new HashMap<>();
				map.put(UNWITHDRAW, "未到提现时间");
				map.put(ENABLE_WITHDRAW, "可提现");
				map.put(WITHDRAW_AUDIT, "提现审批中");
				map.put(WITHDRAW_SUCCESS, "提现成功");
				map.put(WITHDRAW_FAILURE, "提现失败");
				map.put(NOT_WITHDRAW, "不可提现");
				
				return map.getOrDefault(code, "");
			}
		}
	}
	
	
	public interface OpenAdmin{
		interface IsNeedHardware{
			int YES = 1;
			int NO = 2;
			
			public static String translate(int code){
				Map<Integer, String> map = new HashMap<>();
				map.put(YES, "是");
				map.put(NO, "否");
				
				return map.getOrDefault(code, "");
			}
		}
		
		interface CommunityServiceAuditStatus{
			int AUDIT = 1;
			int AUDIT_PASS_UNPAID = 2; 
			int AUDIT_PASS_PAID = 3;
			int AUDIT_NOTPASS = 4;
			int CANCEL_AUDIT = 5;
			int DELETE_AUDIT = 6;
			int DELETE_NOTPASS = 7;
			int DELETE_PASS = 8;
			
			public static String translate(int code){
				Map<Integer, String> map = new HashMap<>();
				map.put(AUDIT, "审核中");
				map.put(AUDIT_PASS_UNPAID, "审核通过待缴纳保证金");
				map.put(AUDIT_PASS_PAID, "审核通过已缴纳保证金");
				map.put(AUDIT_NOTPASS, "审核不通过");
				map.put(CANCEL_AUDIT, "用户主动撤销审核");
				map.put(DELETE_AUDIT, "删除服务审批中");
				map.put(DELETE_NOTPASS, "删除服务审核不通过");
				map.put(DELETE_PASS, "删除服务审核通过");
				
				return map.getOrDefault(code, "");
			}
		}
		
		
		interface CommunityServiceGroundAuditStatus{
			int NOTAUDIT = 1;
			int AUDIT = 2; 
			int AUDIT_PASS = 3;
			int AUDIT_NOTPASS = 4;
			int CANCEL_AUDIT = 5;
			
			public static String translate(int code){
				Map<Integer, String> map = new HashMap<>();
				map.put(NOTAUDIT, "未审核");
				map.put(AUDIT, "审核中");
				map.put(AUDIT_PASS, "审核通过");
				map.put(AUDIT_NOTPASS, "审核不通过");
				map.put(CANCEL_AUDIT, "用户主动撤销审核");
				
				return map.getOrDefault(code, "");
			}
		}
		
		interface CommunityServiceGroundStatus{
			int GROUNDING = 1;
			int UNGROUNDING = 2;
			int UNDER = 3;
			int DELETE = 4;
			int UNDER_AUDIT = 5;
			
			public static String translate(int code){
				Map<Integer, String> map = new HashMap<>();
				map.put(GROUNDING, "上架");
				map.put(UNGROUNDING, "未上架");
				map.put(UNDER, "已下架");
				map.put(DELETE, "已删除");
				map.put(UNDER_AUDIT, "已删除");
				
				return map.getOrDefault(code, "");
			}
		}
		
		interface GroundMode{
			int AUTO = 1;
			int MANUAL = 2;
			
			public static String translate(int code){
				Map<Integer, String> map = new HashMap<>();
				map.put(AUTO, "自动");
				map.put(MANUAL, "手动");
				
				return map.getOrDefault(code, "");
			}
		}
		
		interface UserRange{
			int FOLLOWANDMASTERCHILD = 1;
			int MASTERCHILD = 2;
			
			public static String translate(int code){
				Map<Integer, String> map = new HashMap<>();
				map.put(FOLLOWANDMASTERCHILD, "社区关注用户跟认证用户");
				map.put(MASTERCHILD, "社区认证用户");
				
				return map.getOrDefault(code, "");
			}
		}
		
		interface CommunityServiceRelaAuditStatus{
			int NOTAUDIT = 1;
			int AUDIT = 2; 
			int APPOINTMENT_INTERVIEW = 3;
			int AUDIT_PASS =4;
			int AUDIT_NOTPASS = 5;
			
			public static String translate(int code){
				Map<Integer, String> map = new HashMap<>();
				map.put(NOTAUDIT, "待提交");
				map.put(AUDIT, "审核中");
				map.put(APPOINTMENT_INTERVIEW, "预约面谈");
				map.put(AUDIT_PASS, "审核通过");
				map.put(AUDIT_NOTPASS, "审核不通过");
				
				return map.getOrDefault(code, "");
			}
		}
		
		interface CommunityServiceRelaStatus{
			int ENABLE = 1;
			int DISABLE = 2; 
			
			public static String translate(int code){
				Map<Integer, String> map = new HashMap<>();
				map.put(ENABLE, "启用");
				map.put(DISABLE, "禁用");
				
				return map.getOrDefault(code, "");
			}
		}
		
		interface CommunityServiceRelaSelectStatus{
			int ENABLE = 1;
			int DISABLE = 2; 
			
			public static String translate(int code){
				Map<Integer, String> map = new HashMap<>();
				map.put(ENABLE, "启用");
				map.put(DISABLE, "禁用");
				
				return map.getOrDefault(code, "");
			}
		}
		
		int MAX_DEBUG_USER_COUNT = 5;
		
		int MAX_SERVICE_COUNT = 5;
		
		int MAX_SHOT_COUNT = 5;
		
		
//		服务体验中：应缴纳保证金为0元时，状态为服务体验中
//		• 未缴纳：应缴纳保证金不为0元，且已缴纳保证金为0元。未缴纳保证金的服务不允许申请上架，如果已上架或上架审核中的服务不受此状态影响。
//		• 已缴纳：支付完每笔保证金后，应缴纳保证金等于已缴纳保证金时，保证金状态变为已缴纳
//		• 待补交：已缴纳过至少一笔保证金，已缴纳保证金小于应缴纳保证金数额
//		• 已退款
		
		interface CautionMoneyStatus{
			int PAID = 1;     //已缴
			int UNPAID = 2;    //未缴
			int REFUND = 3;   //已退保证金
		}
		
		interface CautionMoneyType{
			int ONLINE = 1;      //线上
			int OFFLINE = 2;     //线下
			public static String translate(int code){
				Map<Integer, String> map = new HashMap<>();
				map.put(ONLINE, "线上");
				map.put(OFFLINE, "线下");
				
				return map.getOrDefault(code, "");
			}
		}
		
		interface SettlementApplyStatus{
//			1等待平台审核
//			2平台审核不通过
//			3等待支付中心审核
//			4支付中心审核不通过
//			5提现成功
//			8用户主动撤销提现
			int PLATFORM_AUDIT = 1;
			int PLATFORM_NOTPASS = 2;
			int PLATFORM_PASS = 3;
			int PAY_CENTER_NOTPASS = 4;
			int PAY_CENTER_PASS = 5;   //提现成功
			int CANCEL_APPLY = 8;
		}
		
		interface InvoiceStatus{
			int ALREADY_APPLY = 1 ;
			int NOT_APPLY = 2 ;
		}
		
		interface SettlementApplyType{
			int MERCHANT = 1;
			int PLATFORM_CHARGE = 2;
			int SERVICE_CHARGE = 3;
		}
		
		interface ServiceInterfaceAuditStatus{
			int AUDIT = 1;
			int AUDIT_PASS = 2;
			int AUDIT_NOTPASS = 3;
			int CANCEL_AUDIT = 4;
		}
		
		interface ServiceInterfaceStatus{
			int ENABLE = 1;
			int DISABLE = 2;
		}
		
		interface InvoiceType{
			int ZHUANYONG = 1;
			int NORMAL = 2;
			
			public static String translate(int code){
				Map<Integer, String> map = new HashMap<>();
				map.put(ZHUANYONG, "增值税专用发票");
				map.put(NORMAL, "增值税普通发票");
				
				return map.getOrDefault(code, "");
			}
		}
		
	}

	public interface merchantInfo {

		interface status {

			int normal = 1;

			int approval = 2;

			int unpass = 3;

			int draft = 4;

			int disabled = 5;

			int pass = 6;

			public static String translate(int code) {
				Map<Integer, String> map = new HashMap<>();
				map.put(normal, "正常");
				map.put(approval, "审批中");
				map.put(unpass, "审批不通过");
				map.put(draft, "草稿");
				map.put(disabled, "禁用");
				map.put(pass, "审批通过");

				return map.getOrDefault(code, "");
			}
			// 1正常 2审批中,3审批不通过,4草稿,5禁用 6审批通过
			// 1 normal 2 approval, 3 approval does not pass, 4 draft, 5
			// disabled ,pass 6
		}

		interface auditStatus {
			//1:填写中 2:审批中, 3:审批通过, 4:审批失败, 5: 用户撤回修改，商家草稿状态
			int filling = 1;

			int approval = 2;

			int pass = 3;

			int fail = 4;

			int draft = 5;

			public static String translate(int code) {
				Map<Integer, String> map = new HashMap<>();
				map.put(filling, "填写中");
				map.put(approval, "审批中");
				map.put(pass, "审批通过");
				map.put(fail, "审批失败");
				map.put(draft, "用户撤回修改，商家草稿状态");

				return map.getOrDefault(code, "");
			}
		}
		
		interface type{
			int COMPANY = 1;      //公司
			int GEREN = 2;     //个人
			public static String translate(int code){
				Map<Integer, String> map = new HashMap<>();
				map.put(COMPANY, "公司");
				map.put(GEREN, "个人");
				
				return map.getOrDefault(code, "");
			}
		}

		interface RegProgress{
			String MCH_DETAIL = "MCH_DETAIL";      //待完成商家资料
			String BINDING_MOBILE_OR_MAIL = "BINDING_MOBILE_OR_MAIL";      //待绑定手机或邮箱
			String HOME = "HOME";     //已完成,回到首页
		}
	}
	
	public interface Repair {

		interface Status {
			Integer ENABLE = 1;
			Integer DISABLE = 2;
		}

		interface Type {
			Integer CC = 1;
			Integer WO = 2;
		}

		interface FormType {
			Integer CC_ORDER = 0;
			Integer WORK_ORDER = 1;
			Integer ISSUE_ORDER = 2;

			public static String translate(int code) {
				Map<Integer, String> map = new HashMap<>();
				map.put(WORK_ORDER, "工单报修");
				map.put(ISSUE_ORDER, "意见反馈");
				return map.getOrDefault(code, "");
			}
		}
	}
	
	public interface PaymentOrder {

		Integer ROOM = 1;
		Integer STORE = 2;
		Integer PARKING = 3;

		public static String translate(int code) {
			Map<Integer, String> map = new HashMap<>();
			map.put(ROOM, "住宅");
			map.put(STORE, "商铺");
			map.put(PARKING, "车位");
			return map.getOrDefault(code, "");
		}
	}

	public interface Parking {

		interface QUERY_TYPE {
			Integer IC_CARD = 1;
			Integer CAR_PLATE_NO = 2;
		}

		/** */
		interface CaptchaType {
			Integer BIND_CAPTCHA = 1;
			Integer UNBIND_CAPTCHA = 2;
		}

		/** 1：微信；2：支付宝；99：其它支付 */
		interface PayChannel {

			Integer WEIXIN = 1;

			Integer ALIPAY = 2;

			Integer OTHER = 99;

			public static Integer transform(String code) {
				Map<String, Integer> map = new HashMap<>();
				map.put(RfPayType.WEIXIN, WEIXIN);
				map.put(RfPayType.ALIPAY, ALIPAY);
				return map.getOrDefault(code, OTHER);
			}
		}
	}

	public interface ParkingOrder {

		String PAY_TRADE_NO_PREFIX = "po_";

		interface OrderType {
			Integer TEMPORARY = 1;		//临时
			Integer MONTHLY = 2;		//月保
		}

		public static String translateOrderType(int code) {
			Map<Integer, String> map = new HashMap<>();
			map.put(OrderType.TEMPORARY, "临保");
			map.put(OrderType.MONTHLY, "月保");
			return map.getOrDefault(code, "");
		}

		interface OrderStatus {
			Integer NORMAL = 1;
			Integer CANCEL = 2;
		}

		/** 支付状态 */
		interface PayStatus {
			Integer UNPAY = 1;		//未支付
			Integer PREPAY = 2; 	// 在线预付
			Integer PAY = 3; 		// 在线已支付
			Integer TIMEOUT = 4;	//支付超时
			Integer FAIL = 5;		//支付失败

			public static String translate(int code) {
				Map<Integer, String> map = new HashMap<>();
				map.put(UNPAY, "未支付");
				map.put(PREPAY, "预支付");
				map.put(PAY, "已支付");
				map.put(TIMEOUT, "支付超时");
				map.put(FAIL, "支付失败");
				return map.getOrDefault(code, "");
			}
		}

		/** 支付来源 */
		interface PaySrc {
			Integer APP = 1;
			Integer WX_APP = 2;

			public static String translate(int code) {
				Map<Integer, String> map = new HashMap<>();
				map.put(APP, "APP");
				map.put(WX_APP, "微信小程序");
				return map.getOrDefault(code, "");
			}
		}
	}

	public interface ParkingConf {
		interface Vendor {
			String FUJI = "fuji";
			String RALID = "ralid";
		}
	}


	public interface BizApplyConf {
		interface Status {
			Integer ENABLE = 1;
			Integer DISABLE = 2;
		}
	}

	public interface BizApplyOrder {

		String PAY_TRADE_NO_PREFIX = "bao_";

		int ORDER_TIMEOUT = 15;

		interface OrderType {
			Integer CARD = 1;		//门禁卡
		}

		interface OrderStatus {
			Integer AUDUIT_UNPASS = -1;
			Integer SYSTEM_CANCEL = -2;
			Integer USER_CANCEL = -3;
			Integer UNAUDIT = 0;
			Integer AUDIT_PASS = 1;
			Integer AUDIT_PASS_UNPAY = 2;
			Integer PAY = 3;
			Integer UNOBTAIN_CARD = 4;
			Integer DONE = 5;
			Integer INVALID = 6;

			public static String translate(int code) {
				Map<Integer, String> map = new HashMap<>();
				map.put(AUDUIT_UNPASS, "审核不通过");
				map.put(SYSTEM_CANCEL, "取消");
				map.put(USER_CANCEL, "取消");
				map.put(UNAUDIT, "待审核");
				map.put(AUDIT_PASS, "审核通过");
				map.put(AUDIT_PASS_UNPAY, "审核通过, 未支付");
				map.put(PAY, "已支付");
				map.put(UNOBTAIN_CARD, "未取卡");
				map.put(DONE, "完成");
				map.put(INVALID, "已失效");
				return map.getOrDefault(code, "");
			}
		}

		interface AuditStatus {
			Integer UNAUDIT = 0;
			Integer AUDIT_PASS = 1;
			Integer AUDIT_UNPASS = -1;
			Integer CANCEL = -2;

			public static String translate(int code) {
				Map<Integer, String> map = new HashMap<>();
				map.put(UNAUDIT, "待审核");
				map.put(AUDIT_PASS, "审核通过");
				map.put(AUDIT_UNPASS, "审核不通过");
				map.put(CANCEL, "已取消");
				return map.getOrDefault(code, "");
			}
		}

		/** 支付状态 */
		interface PayStatus {
			Integer UNPAY = 1;		//未支付
			Integer PREPAY = 2; 	// 在线预付
			Integer PAY = 3; 		// 在线已支付
			Integer TIMEOUT = 4;	//支付超时
			Integer FAIL = 5;		//支付失败

			public static String translate(int code) {
				Map<Integer, String> map = new HashMap<>();
				map.put(UNPAY, "未支付");
				map.put(PREPAY, "预支付");
				map.put(PAY, "已支付");
				map.put(TIMEOUT, "支付超时");
				map.put(FAIL, "支付失败");
				return map.getOrDefault(code, "");
			}
		}

		//1:身份证 2:香港身份证  3:台湾身份证 4:澳门身份证 5:军官证 6:护照
		interface IdCardType {

			Integer CHINESE_ID_CARD = 1;		//身份证
			Integer HONGKONG_ID_CARD = 2; 		// 香港身份证
			Integer TAIWAN_ID_CARD = 3; 		// 台湾身份证
			Integer MACAU_ID_CARD = 4;			//澳门身份证
			Integer PLA_ID_CARD = 5;			//军官证
			Integer PASSPORT = 6;				//护照

			public static String translate(int code) {
				Map<Integer, String> map = new HashMap<>();
				map.put(CHINESE_ID_CARD, "身份证");
				map.put(HONGKONG_ID_CARD, "香港身份证");
				map.put(TAIWAN_ID_CARD, "台湾身份证");
				map.put(MACAU_ID_CARD, "澳门身份证");
				map.put(PLA_ID_CARD, "军官证");
				map.put(PASSPORT, "护照");
				return map.getOrDefault(code, "");
			}
		}

		// 申请人类型 1:业主 2:租户 3:业户 4:家人 50:员工
		interface ApplicantType {
			Integer OWNER = 1;
			Integer TENANT = 2;
			Integer BIZ_OWNER = 3;
			Integer FAMILY = 4;
			Integer EMP = 50;

			public static String translate(int code) {
				Map<Integer, String> map = new HashMap<>();
				map.put(OWNER, "业主");
				map.put(TENANT, "租户");
				map.put(BIZ_OWNER, "业户");
				map.put(FAMILY, "家人");
				map.put(EMP, "员工");
				return map.getOrDefault(code, "");
			}
		}

/*		*//** 支付来源 *//*
		interface PaySrc {
			Integer APP = 1;
			Integer WX_APP = 2;

			public static String translate(int code) {
				Map<Integer, String> map = new HashMap<>();
				map.put(APP, "APP");
				map.put(WX_APP, "微信小程序");
				return map.getOrDefault(code, "");
			}
		}*/
	}
	
	//门禁2微码
	public interface qrcode_type {
		interface sys_type {
			//门禁
			String guard = "guard";
			//邀约
			String visit4 = "visit4";
			//临时
			String temp = "temp";
		}
	}

	public interface BuildingInfo {

		interface PropType {
			Integer HOUSE = 1;
			Integer CBD = 2;

			public static String translate(Integer code) {
				Map<Integer, String> map = new HashMap<>();
				map.put(HOUSE, "住宅/公寓");
				map.put(CBD, "写字楼/商场");
				return map.getOrDefault(code, "");
			}
		}
	}

	public interface Visit4Blacklist {

		interface TargetType {
			Integer ROOM = 1;
			Integer USER = 2;
		}

		interface TargetStatus {
			Integer ENABLE = 1;
			Integer DISABLE = 2;
		}
	}

	public interface Platform {
		String ANDROID = "android";
		String IOS = "ios";
	}

	/** 服务对象 */
	public interface ServiceObject {
		int USERVERIFIED = 1;  //会员认证过的社区
		int USERATTENTION = 2; //会员关注过的社区
	}
	
	public interface CommunityCategory {

		/** 实体社区 */
		int ENTITY = 1;
		/** 虚拟社区 */
		int VIRTUAL = 2;

		public static String translate(int code) {
			Map<Integer, String> map = new HashMap<>();
			map.put(ENTITY, "实体社区 ");
			map.put(VIRTUAL, "虚拟社区");
			return map.getOrDefault(code, "");
		}
	}
}
