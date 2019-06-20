package com.rfchina.community.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 */
public final class OpenConstant {

	private OpenConstant() {
	}

	// 15天前的
	public static final int public_BATCH_RUN_day = 15;
	public static final int refund_store_day = 14;
	// test环境
	public static final int TEST_BATCH_RUN_day = 1;

	// 测试环境
	public static final int TEST_BATCH_RUN = 1;

	// 拆单时间
	public static final int SPLIT_BATCH_TIME = 17;

	// 社区拆单天数16
	public static final int communtiy_public_BATCH_RUN_day = 16;
	// test社区拆单天数1
	public static final int communtiy_test_BATCH_RUN_day = 1;
	// 社区拆单12
	public static final int communtiy_Batch_time = 12;

	// 社区接口
	public static final String ROOT_PATH_COMMUNITY = "/api/community/open/bridgeapi";
	// 平台接口
	public static final String ROOT_PATH_PLATFORM = "/api/platform/open/bridgeapi";
	// 平台接口
	public static final String ROOT_PATH_PLATFORM_STATS = "/api/stats/open/bridgeapi";
	// app api接口
	public static final String ROOT_PATH_APP = "/api/app/open/bridgeapi";

	// 商场调取接口
	public static final String ROOT_PATH_OPEN_STORE = "/community/api/open/store";

	public interface open_service_detail {

		public enum develop_type {
			// 模板
			TEMPLETE,
			// 自主开发
			SELF;
		}

		public enum templete_name {
			// 商城模板
			STORE("STORE", "微商城模板"),INFO("INFO", "周边商家模板");
			private String code;
			private String label;

			templete_name(String code, String label) {
				this.code = code;
				this.label = label;
			}

			public String getCode() {
				return code;
			}

			public void setCode(String code) {
				this.code = code;
			}

			public String getLabel() {
				return label;
			}

			public void setLabel(String label) {
				this.label = label;
			}

			public static Boolean isExist(String templete) {
				for (templete_name record : templete_name.values()) {
					if (record.getCode().equals(templete))
						return true;
				}
				return false;
			}

		}

		public interface templete_status {
			// 禁用
			int Disable = 0;
			// 启用
			int start_up = 1;
		}
	}

	//
	public interface open_order {

		public static final String PAY_TRADE_NO_PREFIX = "open_";

		public String PAY_CAUTION_PREFIX = "cau_";

		// '退款状态 0无 1：退款审批中，2：退款成功，3：退款失败'

		// 2支付成功

		public interface BillStatus {
			int TRADE_UNPAID = 1; // 未支付
			int TRADE_PAID_SUCCESS = 2; // 支付成功
			int TRADE_TIMEOUT_CLOSE = 3; // 交易关闭
			int TRADE_END = 4; // 交易结束
			int TRADE_TIMEOUT_CLOSE2 = 6; // 交易结束

			public static String translate(int code) {
				Map<Integer, String> map = new HashMap<>();
				map.put(TRADE_UNPAID, "未支付");
				map.put(TRADE_PAID_SUCCESS, "支付成功");
				map.put(TRADE_TIMEOUT_CLOSE, "交易关闭");
				map.put(TRADE_END, "交易结束");
				map.put(TRADE_TIMEOUT_CLOSE2, "支付超时");

				return map.getOrDefault(code, "");
			}
		}

		public interface BillSplitStatus {
			int no = 2;
			int split = 1;

			public static String translate(int code) {
				Map<Integer, String> map = new HashMap<>();
				map.put(no, "未拆单");
				map.put(split, "已拆单");

				return map.getOrDefault(code, "");
			}
		}

		public interface RefundStatus {
			int NO_REFUND = 0; // 没有退款
			int REFUND_AUDIT = 1; // 退款审批中
			int REFUND_SUCCESS = 2; // 退款成功
			int REFUND_FAILURE = 3; // 退款失败
			int REFUND_STORE_AUDIT = 4; // 商家审核

			public static String translate(int code) {
				Map<Integer, String> map = new HashMap<>();
				map.put(NO_REFUND, "无");
				map.put(REFUND_AUDIT, "退款审批中");
				map.put(REFUND_SUCCESS, "退款成功");
				map.put(REFUND_FAILURE, "退款失败");
				map.put(REFUND_STORE_AUDIT, "商家审核中");

				return map.getOrDefault(code, "");
			}
		}

		public interface WithdrawStatus {
			int UNWITHDRAW = 1; // 未到提现时间
			int ENABLE_WITHDRAW = 2; // 可提现
			int WITHDRAW_AUDIT = 3; // 提现审批中
			int WITHDRAW_SUCCESS = 4; // 提现成功
			int WITHDRAW_FAILURE = 5; // 提现失败
			int NOT_WITHDRAW = 6; // 不可提现

			public static String translate(int code) {
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

		// '物业服务费状态，1：不可结算，2：可结算但未结算，3：已结算',
		public interface ServiceChargeStatus {
			int init = 1; // 1：不可结算
			int ok = 2; // ：可结算但未结算
			int finish = 3; // 已结算

			public static String translate(int code) {
				Map<Integer, String> map = new HashMap<>();
				map.put(init, "不可结算");
				map.put(ok, "可结算但未结算");
				map.put(finish, "已结算");
				return map.getOrDefault(code, code + "");
			}
		}

		public interface Type {
			int normal = 1; // 合并支付之前订单
			int caution = 2; // 保证金
			int activity = 3; // 活动缴费
			int total_normal = 4; // 合并支付订单
			int quick = 5; // 闪付订单
			int verify = 6; // 核销订单

			public static String translate(int code) {
				Map<Integer, String> map = new HashMap<>();
				map.put(normal, "合并支付之前订单");
				map.put(caution, "保证金");
				map.put(activity, "活动缴费");
				map.put(total_normal, "合并支付订单");
				map.put(quick, "闪付订单");
				map.put(verify, "核销订单");

				return map.getOrDefault(code, "");
			}
		}

	}

	// 服务体验中：应缴纳保证金为0元时，状态为服务体验中
	// • 未缴纳：应缴纳保证金不为0元，且已缴纳保证金为0元。未缴纳保证金的服务不允许申请上架，如果已上架或上架审核中的服务不受此状态影响。
	// • 已缴纳：支付完每笔保证金后，应缴纳保证金等于已缴纳保证金时，保证金状态变为已缴纳
	// • 待补交：已缴纳过至少一笔保证金，已缴纳保证金小于应缴纳保证金数额
	// • 已退款

	public interface CautionMoneyStatus {
		int PAID = 1; // 已缴
		int UNPAID = 2; // 未缴
		int REFUND = 3; // 已退保证金
		int EXPERIENCING = 4;// 服务体验中
		int REPLENISH = 5;// 待补交

		public static String translate(int code) {
			Map<Integer, String> map = new HashMap<>();
			map.put(PAID, "已缴纳");
			map.put(UNPAID, "初始化");
			map.put(REFUND, "已退保证金");
			map.put(EXPERIENCING, "服务体验中");
			map.put(REPLENISH, "待补交");
			return map.getOrDefault(code, code + "");
		}
	}

	public interface Caution {
		String qrcode = "qrcode";
		String pic = "pic";

		public static String translate(int code) {
			Map<String, String> map = new HashMap<>();
			map.put(qrcode, "二维码支付");
			map.put(pic, "上传图片支付");
			return map.getOrDefault(code, code + "");
		}
	}
	
	public interface ResourceType {
		int APP = 1; // app支付
		int WEIXIN_WAP = 2; // 微信网页支付
		int ALI_APP = 3; // 支付宝网页支付
		int NORMAL_WAP = 4; // 普通网页支付

		public static String translate(int code) {
			Map<Integer, String> map = new HashMap<>();
			map.put(APP, "app支付");
			map.put(WEIXIN_WAP, "微信网页支付");
			map.put(ALI_APP, "支付宝网页支付");
			map.put(NORMAL_WAP, "普通网页支付");
			return map.getOrDefault(code, code + "");
		}
	}
	
	/**
	 * @author:fukangwen
	 * @Description: 1.可报名 ,2 已报名待审核, 3报名成功待缴费, 4报名成功已缴费,5报名不通过（需要拒绝理由）, 6报名截止
	 */
	public interface SignUpCheckStatus {
		int CAN_SIGNUP = 1; //可报名 
		int CHECKING= 2; // 审核中
		int PASS = 3; // 报名审核通过
		int PAID = 4; // 缴费成功
		int NO_PASS = 5; // 审核不通过
		int CAN_NOT_SIGN_UP = 6;//报名截止
		public static String translate(int code) {
			Map<Integer, String> map = new HashMap<>();
			map.put(CAN_SIGNUP, "可报名");
			map.put(CHECKING, "审核中");
			map.put(PASS, "报名审核通过");
			map.put(PAID, "缴费成功");
			map.put(NO_PASS, "审核不通过");
			map.put(CAN_NOT_SIGN_UP, "报名截止");
			return map.getOrDefault(code, code + "");
		}
	}

	public interface DiscountStatus {
		// 禁用
		int invalid_status = 0;
		// 启用
		int valid_status = 1;
	}
	
	public enum StockOperate{
		ADD, DEC, SET;
	}
	
	public enum StockSource{
		ADMIN, CLIENT;
	}
	
	//分类状态
	public interface CategoryStatus {
		// 禁用
		int invalid_status = 0;
		// 启用
		int valid_status = 1;
	}
	
	//商品状态
	public enum GoodStatus{
		GROUNDING(1,"上架"),UNDER(2, "下架"),DEL(3, "删除");
		public int key;
		public String label;
		GoodStatus(int key, String label){
			this.key = key;
			this.label = label;
		}
		public int getKey() {
			return key;
		}
		public void setKey(int key) {
			this.key = key;
		}
		public String getLabel() {
			return label;
		}
		public void setLabel(String label) {
			this.label = label;
		}
	}
	
	//客户端来源
	public interface ClientType {
		// app
		String APP = "APP";
		// 网页
		String WAP = "WAP";
	}
	
	//支付方式
	public interface PayType {
		// app
		String APP = "APP";
		// 预支付
		String PRE = "PRE";
		//pos鸡
		String POS = "POS";
		//小程序微信
		String SAPP = "SAPP";
	}
	
	//交易类型: 
	public interface TradeType {
		// 支付宝移动网站支付或微信公众号支付
		String JSAPI = "JSAPI";
		// 微信原生扫码支付
		String NATIVE = "NATIVE";
		//支付宝或微信APP支付
		String APP = "APP";
		//支付宝当面付或微信刷卡支付
		String MICROPAY = "MICROPAY";
		//H5
		String H5 = "H5";
		//小程序微信支付
		String SAPP = "SAPP";
	}
	
	//支付方式
		public interface PayChannel {
			// 支付宝
			String AliPay = "AliPay";
			// 微信
			String WeiXin = "WeiXin";
			//银联
			String UnionPay = "UnionPay";
		}
		
		//核销状态
		public interface VerifyStatus {
			// 未使用
			int UN_USE = 0;
			// 已使用
			int USED = 1;
			//未开始
			int NEVER_START = 2;
			//已过期
			int INVALID = 3;
			
			public static String translate(int code) {
				Map<Integer, String> map = new HashMap<>();
				map.put(UN_USE, "待核销");
				map.put(USED, "已核销");
				map.put(NEVER_START, "未生效");
				map.put(INVALID, "已失效");
				return map.getOrDefault(code, code + "");
			}
		}
		
		
		//支付方式
		public interface CommunityServiceType {
			//1基础生活服务,2物业服务，3：第三方服务，4.内部第三方开发服务。5：不需要显示在前端的基础服务'
			int base_life = 1;
			int property = 2;
			int third_out_life = 3;
			int third_inner_life = 4;
			int base_not_need_show = 5;
		}
		
		

		// 优惠券的状态
		public enum CouponStatus {
			disabled(0), enabled(1), delete(2);
			private int status;

			CouponStatus(int status) {
				this.status = status;
			}

			public int getStatus() {
				return status;
			}

			public static CouponStatus trun(int status) {
				for (CouponStatus cs : CouponStatus.values()) {
					if (status == cs.getStatus()) {
						return cs;
					}
				}
				return null;

			}
		}
		//优惠券有效状态
		public static interface CardRecordStatus {
			public int valid = 1;
			public int invalid = 0;
		}
		
		//优惠券公开状态
		public static interface CouponOpenStatus {
			public int open = 1;
			public int privated = 0;
		}
		//优惠券核销状态
		public static interface ConfirmStatus {
			// 0未核销 1核销 2核销中
			public int no_confirm = 0;
			public int confirm = 1;
			public int confirming = 2;
		}

		// 优惠形式
		public enum ItemType {
			change(2001, "抵用"), discount(2002, "折扣");
			private int code;
			private String label;

			ItemType(int code, String label) {
				this.code = code;
				this.label = label;
			}

			public int getCode() {
				return code;
			}

			public void setCode(int code) {
				this.code = code;
			}

			public String getLabel() {
				return label;
			}

			public void setLabel(String label) {
				this.label = label;
			}

			public static Boolean isExist(int code) {
				for (ItemType it : ItemType.values()) {
					if (code == it.getCode()) {
						return true;
					}
				}
				return false;

			}
		}

		// 优惠形式
		public enum CardRecordResource {
			user_receive(2001, "用户领取"), store_send(2002, "商家发放"),platform_send(2003, "平台发放");
			private int code;
			private String label;

			CardRecordResource(int code, String label) {
				this.code = code;
				this.label = label;
			}

			public int getCode() {
				return code;
			}

			public void setCode(int code) {
				this.code = code;
			}

			public String getLabel() {
				return label;
			}

			public void setLabel(String label) {
				this.label = label;
			}
		}
		
		
		//优惠券核销状态
		public static interface CouponSource {
			// 2001 用户自己领取的， 2002 平台发送的
			public int user_receive = 2001;
			public int platform_give = 2002;
		}
		
		public static String CouponRedisPrefix = "open_store_coupon_";
		
		// 商家业务分类
		public enum OpenServiceDetailTab {
			xfsj(1, "小富市集"), 
			third(2, "平台对接"),
			templete(3, "生活商城"),
			platfrom_winter_term(4, "平台自在美居"),
			service_winter_term(5, "物业自在美居"),
			zizai_e(6, "自在e站");
			
			private int code;
			private String label;

			OpenServiceDetailTab(int code, String label) {
				this.code = code;
				this.label = label;
			}

			public int getCode() {
				return code;
			}

			public void setCode(int code) {
				this.code = code;
			}

			public String getLabel() {
				return label;
			}

			public void setLabel(String label) {
				this.label = label;
			}

			public static String getTabName(int type) {
				for(OpenServiceDetailTab tab : OpenServiceDetailTab.values()) {
					if(tab.getCode() == type)
						return tab.getLabel();
				}
				return "";
			}
		}
		
		
		public enum OpenStorePayStatus {
			NOPAYMENT(0, "未支付"), PAY(1, "已支付"),PAY_TIME_OUT(2,"支付超时");
			private int code;
			private String label;

			OpenStorePayStatus(int code, String label) {
				this.code = code;
				this.label = label;
			}

			public int getCode() {
				return code;
			}

			public void setCode(int code) {
				this.code = code;
			}

			public String getLabel() {
				return label;
			}

			public void setLabel(String label) {
				this.label = label;
			}

			public static String getLabel(Integer payStatus) {
				if(payStatus == null)
					return "-";
				for (OpenStorePayStatus record : OpenStorePayStatus.values()) {
					if (record.getCode() == payStatus)
						return record.getLabel();
				}
				return "-";
			}
		}

		public enum OpenStoreSendStatus {
			NOT_SEND(0, "未发货"), SEND(1, "已发货"), COMPLETE(2, "已完成");
			private int code;
			private String label;

			OpenStoreSendStatus(int code, String label) {
				this.code = code;
				this.label = label;
			}

			public int getCode() {
				return code;
			}

			public void setCode(int code) {
				this.code = code;
			}

			public String getLabel() {
				return label;
			}

			public void setLabel(String label) {
				this.label = label;
			}

			public static String getLabel(Integer sendStatus) {
				if(sendStatus == null)
					return "-";
				for (OpenStoreSendStatus record : OpenStoreSendStatus.values()) {
					if (record.getCode() == sendStatus)
						return record.getLabel();
				}
				return "-";
			}
		}
		/**
		 * 、无，显示“-”，此时用户、平台或商家可以发起退款

			4、客户申请退款：此时需要商家审批，显示“审批”按钮，商家审批通过/驳回后，该按钮变为“详情”，点击查看退款详情。

			1、平台处理中：商家审批通过，或者商家、平台直接发起的退款则为该状态

			2、退款成功：支付中心退款超过

			3、退款失败：支付中心驳回或者支付中心退款失败，需要具体原因。
		 * @author fukangwen
		 *
		 */
		public enum OpenStoreRefundStatus {
			none(0, "-"), ing(1, "平台处理中"), Success(2, "退款成功"), error(3, "退款失败"),user_apply(4, "客户申请退款") ;
			private int code;
			private String label;

			OpenStoreRefundStatus(int code, String label) {
				this.code = code;
				this.label = label;
			}

			public int getCode() {
				return code;
			}

			public void setCode(int code) {
				this.code = code;
			}

			public String getLabel() {
				return label;
			}

			public void setLabel(String label) {
				this.label = label;
			}

			public static String getLabel(Integer refundStatus) {
				if(refundStatus == null)
					return "-";
				for (OpenStoreRefundStatus record : OpenStoreRefundStatus.values()) {
					if (record.getCode() == refundStatus)
						return record.getLabel();
				}
				return "-";
			}
		}

		public enum OpenStoreExpressType {
			EXPRESS("EXPRESS", "快递"), SELF("SELF", "自提"), VISIT("VISIT", "上门"), NOT_NEED("NOT_NEED", "无需配送");
			private String code;
			private String label;

			OpenStoreExpressType(String code, String label) {
				this.code = code;
				this.label = label;
			}

			public String getCode() {
				return code;
			}

			public void setCode(String code) {
				this.code = code;
			}

			public String getLabel() {
				return label;
			}

			public void setLabel(String label) {
				this.label = label;
			}

			public static Boolean isExist(String expressType) {
				for (OpenStoreExpressType record : OpenStoreExpressType.values()) {
					if (record.getCode().equals(expressType))
						return true;
				}
				return false;
			}

		}
		
		// 订单分类
		public enum OpenStoreOrderType {
			history(0, "历史记录"), 
			wuye(1, "物业拎包订单"),
			platform(1, "平台拎包订单"),
			xfsj(2, "小富市集订单"),
			estation(3, "自在E站订单"),
			templete(4, "商城模板订单");
			
			private int level;	//优先级，越小越高
			private String label;

			OpenStoreOrderType(int level, String label) {
				this.level = level;
				this.label = label;
			}

			public int getLevel() {
				return level;
			}


			public void setLevel(int level) {
				this.level = level;
			}


			public String getLabel() {
				return label;
			}


			public void setLabel(String label) {
				this.label = label;
			}


			public static int getTypeLevel(String type) {
				for(OpenStoreOrderType tab : OpenStoreOrderType.values()) {
					if(tab.toString().equals(type))
						return tab.getLevel();
				}
				return 999;
			}

			public static String getTypeLabel(String type) {
				for(OpenStoreOrderType tab : OpenStoreOrderType.values()) {
					if(tab.toString().equals(type))
						return tab.getLabel();
				}
				return "";
			}
		}
		
		//优惠券公开状态
		public static interface AddressManageDefaultStatus {
			public int default_status = 1;
			public int no_default_status = 0;
		}

	/**
	 * 商品排序类型
	 */
	public enum OpenStoreGoodSortType {
		GENERAL("GENERAL", "综合"),
		SALE_AMOUNT("SALE_AMOUNT", "销量"),
		FRESH("FRESH", "新品"),
		PRICE("PRICE", "价格");

		private String code;
		private String label;

		OpenStoreGoodSortType(String code, String label) {
			this.code = code;
			this.label = label;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getLabel() {
			return label;
		}

		public void setLabel(String label) {
			this.label = label;
		}

		public static Boolean isExist(String sortType) {
			for (OpenStoreGoodSortType record : OpenStoreGoodSortType.values()) {
				if (record.getCode().equals(sortType))
					return true;
			}
			return false;
		}

	}

	//商品sort
	public static interface OpenStoreGoodSort {
		public String up = "up";
		public String down = "down";
	}

	//优惠
	public enum OpenStoreDiscountType {
		//ALL_DISCOUNT("ALL_DISCOUNT", "所有优惠"),
		FULL_DISCOUNT("FULL_DISCOUNT", "满减")//,
		//ASSEMBLE("ASSEMBLE", "拼团")
		;

		private String code;
		private String label;

		OpenStoreDiscountType(String code, String label) {
			this.code = code;
			this.label = label;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getLabel() {
			return label;
		}

		public void setLabel(String label) {
			this.label = label;
		}

		public static Boolean isExist(String type) {
			for (OpenStoreDiscountType record : OpenStoreDiscountType.values()) {
				if (record.getCode().equals(type))
					return true;
			}
			return false;
		}

		public static List<KeyValueDomain> getList() {
			List<KeyValueDomain> list = new ArrayList<>();
			for (OpenStoreDiscountType record : OpenStoreDiscountType.values()) {
				KeyValueDomain domain = new KeyValueDomain(record.getCode(), record.getLabel());
				list.add(domain);
			}
			return list;
		}

	}
	//店铺
	public enum OpenStoreType {
		FLAG_SHIP("FLAG_SHIP", "旗舰店");

		private String code;
		private String label;

		OpenStoreType(String code, String label) {
			this.code = code;
			this.label = label;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getLabel() {
			return label;
		}

		public void setLabel(String label) {
			this.label = label;
		}

		public static Boolean isExist(String type) {
			for (OpenStoreType record : OpenStoreType.values()) {
				if (record.getCode().equals(type))
					return true;
			}
			return false;
		}

		public static List<KeyValueDomain> getList() {
			List<KeyValueDomain> list = new ArrayList<>();
			for (OpenStoreType record : OpenStoreType.values()) {
				KeyValueDomain domain = new KeyValueDomain(record.getCode(), record.getLabel());
				list.add(domain);
			}
			return list;
		}

	}
	//邮费
	public enum OpenStorePostage {
		NO_POSTAGE("NO_POSTAGE", "包邮");

		private String code;
		private String label;

		OpenStorePostage(String code, String label) {
			this.code = code;
			this.label = label;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getLabel() {
			return label;
		}

		public void setLabel(String label) {
			this.label = label;
		}

		public static Boolean isExist(String type) {
			for (OpenStorePostage record : OpenStorePostage.values()) {
				if (record.getCode().equals(type))
					return true;
			}
			return false;
		}

		public static List<KeyValueDomain> getList() {
			List<KeyValueDomain> list = new ArrayList<>();
			for (OpenStorePostage record : OpenStorePostage.values()) {
				KeyValueDomain domain = new KeyValueDomain(record.getCode(), record.getLabel());
				list.add(domain);
			}
			return list;
		}

	}

}
