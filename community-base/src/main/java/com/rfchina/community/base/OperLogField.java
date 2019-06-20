package com.rfchina.community.base;

/**
 */
public final class OperLogField {

    public static final String ID = "ID";

    public static final String PARENT_ID = "父ID";

    public static final String COMMUNITY_ID = "社区ID";

    public static final String STATUS = "状态";

    public static final String SORTING = "排序";

    public static final String TITLE = "标题";

    public static final String CONTENT = "内容";

    public static final String TYPE = "类型";

    public static final String NAME = "名称";

    public static final String IP = "登录IP";

    public static final String REMARK = "备注";

    public static final String UID = "用户ID";

    public interface Operation {

        public static final String NEW = "新增";

        public static final String EDIT = "编辑";

        public static final String DELETE = "删除";

        public static final String EXPORT = "导出";

        public static final String IMPORT = "导入";

        public static final String UPLOAD = "上传";

        public static final String DOWNLOAD = "下载";

        public static final String AUDIT = "审核";

        public static final String UPDATE_STATUS = "修改状态";

        public static final String SORTING = "排序";
    }

    public static final String formEventName(String moduleName, String operation) {
        return moduleName + "-" + operation;
    }

    public interface Ad {
        public static final String MODULE_NAME = "广告管理";
        public static final String CATEGORY_ID = "广告位ID";
        public static final String LINK = "广告链接";
        public static final String IMG_URL = "广告图片";
        public static final String NAME = "广告名称";
        public static final String INTRO = "广告简介";
        public static final String START_TIME = "广告起始时间";
        public static final String END_TIME = "广告结束时间";
        public static final String REASON = "审核意见";
    }

    public interface AdCategory {
        public static final String MODULE_NAME = "广告位管理";
        public static final String NAME = "广告位名称";
        public static final String INTRO = "广告位说明";
    }

    public interface AdminProfile {
        public static final String MODULE_NAME = "管理员管理";
        public static final String DEPT = "部门";
        public static final String PHONE = "手机";
        public static final String REALNAME = "姓名";
        public static final String USERNAME = "账号";
        public static final String PASSWORD = "密码";
        public static final String EMAIL = "邮箱";
    }

    public interface SensitiveWords {
        public static final String MODULE_NAME = "敏感词管理";
        public static final String WORDS = "敏感词";
        public static final String RPL_WORDS = "替换词";
        public static final String IMPORT_SIZE = "导入条数";
    }

    public interface CommunityAdmin {
        public static final String MODULE_NAME = "员工管理";
        public static final String REALNAME = "姓名";
        public static final String PHONE = "手机号码";
        public static final String TEL = "分机号码";
        public static final String EMAIL = "邮箱";
        public static final String POSITION = "职位";
        public static final String EXPORT_SIZE = "导出条数";
        public static final String IMPORT_SIZE = "导入条数";
        public static final String DEPT_LIST = "部门列表";
        public static final String ROLE_LIST = "角色列表";
    }

    public interface CardCategory {
        public static final String MODULE_NAME = "卡片类型管理";
        public static final String NAME = "卡片类型名称";
        public static final String TEMPLATE_ID = "模板ID";
    }

    public interface SysDept {
        public static final String MODULE_NAME = "部门管理";
        public static final String NAME = "部门名称";
        public static final String SUB_DEPT_LIST = "子部门列表";
        public static final String DEPT_LIST = "部门列表";
    }

    public interface SysRole {
        public static final String MODULE_NAME = "角色权限管理";
        public static final String NAME = "角色名称";
        public static final String REMARK = "角色说明";
        public static final String RESOURCE_ID_LIST = "权限ID列表";
        public static final String DELETECD_RESOURCE_ID_LIST = "删除的权限ID列表";
        public static final String PREVIOUS_RESOURCE_ID_LIST = "修改前的权限ID列表";
        public static final String NEW_RESOURCE_ID_LIST = "修改后的权限ID列表";
        public static final String INSERTED_RESOURCE_ID_LIST = "新增的权限ID列表";
    }

    public interface Community {
        public static final String MODULE_NAME = "社区资料管理";
        public static final String NAME = "社区名称";
        public static final String BG_IMG_URL = "封面链接";
        public static final String LOGO_URL = "头像链接";
        public static final String INTRO = "社区介绍";
        public static final String TOPIC_AUDIT = "开启话题审核";
        public static final String PHONE = "手机号码";
        public static final String TEL = "联系电话";
        public static final String ADDRESS = "社区地址";
        public static final String AREA = "区域";
        public static final String TYPE = "社区类型";
        public static final String ADMIN_PHONE = "管理者手机号码";
        public static final String ADMIN_USERNAME = "管理者账号";
        public static final String ADMIN_REALNAME = "管理者姓名";
        public static final String ADMIN_PASSWORD = "管理者密码";
        public static final String LONGITUDE = "经度";
        public static final String LATITUDE = "纬度";
        public static final String FILE_URLS_LIST = "社区资料文件URL列表";
    }

    public interface CommunityFile {
        public static final String NAME = "社区资料文件名";
        public static final String FILE_URL = "文件URL";
    }

    public interface Card {
        public static final String MODULE_NAME = "卡片管理";
        public static final String CATEGORY_ID = "卡片类型ID";
        public static final String ATTACHMENT = "卡片图片链接";
        public static final String PUB_TO_SQUARE = "同步到广场";
        public static final String AUDIT_STATUS = "审核状态";
        public static final String AUDIT_TIME = "审核时间";
        public static final String AUDIT_REASON = "审核意见";
    }

    public interface CardReport {
        public static final String MODULE_NAME = "举报管理";
    }

    public interface WaterSupplyCfg {
        public static final String MODULE_NAME = "送水服务-送水配置";
        public static final String INTERVAL = "最短预约送水服务时间(分钟)";
    }

    public interface WaterDeposit {
        public static final String MODULE_NAME = "送水服务-押金管理";
        public static final String EXPORT_WATER_DEPOSIT_MODULE_NAME = MODULE_NAME + "-导出操作";
        public static final String ROOM_ID = "房间号ID";
        public static final String ROOM_OWNER = "业主";
        public static final String CONTACT = "联系人";
        public static final String PHONE = "联系电话";
        public static final String WATER_BRAND_ID = "饮用水品牌ID";
        public static final String AMOUNT = "押金金额(元)";
        public static final String PAY_TIME = "缴纳时间";
        public static final String REFUND_TIME = "退还押金时间";
        public static final String REMARK = "备注";
        public static final String EXPORT_SIZE = "导出条数";
    }

    public interface WaterOrder {
        public static final String MODULE_NAME = "送水服务-订单管理";
        public static final String ASSIGN_STAFF_MODULE_NAME = MODULE_NAME + "-指派人员";
        public static final String EDIT_STAFF_MODULE_NAME = MODULE_NAME + "-改派人员";
        public static final String TAKE_WATER_MODULE_NAME = MODULE_NAME + "-取水操作";
        public static final String RECEIPT_TICKET_MODULE_NAME = MODULE_NAME + "-收票操作";
        public static final String ISSUE_TICKET_MODULE_NAME = MODULE_NAME + "-出票操作";
        public static final String REFUSE_WATER_ORDER_MODULE_NAME = MODULE_NAME + "-拒收操作";
        public static final String EXPORT_WATER_ORDER_MODULE_NAME = MODULE_NAME + "-导出操作";
        public static final String ROOM_ID = "房间号ID";
        public static final String CONTACT = "联系人";
        public static final String PHONE = "联系电话";
        public static final String WATER_BRAND_ID = "饮用水品牌ID";
        public static final String ORDER_TIME = "预订时间";
        public static final String ORDER_TYPE = "订单类型";
        public static final String ORDER_STATUS = "订单状态";
        public static final String NUM = "订购数量";
        public static final String REMARK = "备注";
        public static final String STAFF_NAME = "配送员姓名";
        public static final String STAFF_PHONE = "配送员电话";
        public static final String TAKE_WATER = "取水操作";
        public static final String ISSUE_TICKET = "出票操作";
        public static final String RECEIPT_TICKET = "出票操作";
        public static final String EXPORT_SIZE = "导出条数";
    }

    public interface WaterSupply {
        public static final String MODULE_NAME = "送水服务-饮用水管理";
        public static final String AMOUNT = "单价(元)";
        public static final String CAPACITY = "容量(升)";
        public static final String DEPOSIT = "押金(元)";
        public static final String N = "联系电话";
        public static final String WATER_BRAND_ID = "饮用水品牌ID";
        public static final String NUM = "规格数量";
        public static final String START_DATE = "有效期(起)";
        public static final String END_DATE = "有效期(止)";
        public static final String INTRO = "描述";
    }

    public interface MasterChild {
        public static final String MODULE_NAME = "认证会员管理";
        public static final String MASTER_ID = "房间ID";
        public static final String EMAIL = "邮箱";
        public static final String NAME = "姓名";
        public static final String PHONE = "手机号码";
        public static final String PARKING_NUM = "车位号";
        public static final String PARKING_TYPE = "停车身份";
        public static final String PLATE_NUM = "车牌号";
        public static final String STORE_NAME = "店铺名称";
        public static final String STORE_NUM = "店铺号";
        public static final String STORE_TYPE = "店铺类型";
        public static final String STAFF_TYPE = "员工类型";
        public static final String IMPORT_SIZE = "导入条数";
        public static final String EXPORT_SIZE = "导出条数";
    }

    public interface MasterInfo {
        public static final String MODULE_NAME = "会员管理";
        public static final String IMPORT_SIZE = "导入条数";
        public static final String ADDRESS = "地址";
        public static final String AREA_ID = "区域ID";
        public static final String CHARGE_NAME = "负责人姓名";
        public static final String CHARGE_PHONE = "负责人电话";
        public static final String FLOOR = "楼层";
        public static final String ROOM = "房间";
        public static final String TEL = "联系电话";
        public static final String LOUDONG = "楼栋";
        public static final String TYPE = "类型";
        public static final String TITLE = "公司名称";
        public static final String CAN_VISIT = "是否可拜访";
        public static final String ROLE_COUNT = "代理人数量上限";
    }

    public interface MasterFile {
        public static final String MODULE_NAME = "会员资料";
        public static final String LINK = "资料链接";
        public static final String NAME = "资料名称";
    }

    public interface Repair {
        public static final String MODULE_NAME = "意见报修";
        public static final String EXT_SYS_ID = "外部系统ID";
        public static final String DISPLAY_NAME = "显示名称";
        public static final String SEQUENCE = "序号";
    }

    public interface ReleaseApplyGoods {
        public static final String MODULE_NAME = "门禁管理";
        public static final String AUDIT_STATUS = "审核结果";
        public static final String AUDIT_CONTENT = "审核意见";
        public static final String AUDIT_EXT_PHONE = "社区放行人电话";
    }

    public interface ReleaseGoodsApply {
        public static final String MODULE_NAME = "物品放行";
        public static final String APPLICANT_NAME = "申请人名称";
        public static final String APPLICANT_PHONE = "申请人手机号码";
        public static final String CARRIER_NAME = "带运人名称";
        public static final String CARRIER_PHONE = "带运人手机号码";
        public static final String RELEASE_START_TIME = "放行开始时间";
        public static final String RELEASE_END_TIME = "放行结束时间";
        public static final String RELEASE_GOODS = "放行物品";
    }

    public interface CommunityQrCode {
        public static final String MODULE_NAME = "临时二维码管理";
        public static final String COUNT = "二维码数量";
        public static final String EXPIRE_TIME = "过期时间";
    }

    public interface Upload {
        public static final String UPLOAD_IMG_NAME = "图片上传";
        public static final String UPLOAD_AD_IMG_NAME = "广告管理-图片上传";
        public static final String UPLOAD_COMMUNITY_FILE_NAME = "社区资料-资料文件上传";
    }

    public interface SysNoticePlatform {
        public static final String UPLOAD_IMG_NAME = "图片上传";
    }

    public interface Venue {
        public static final String MODULE_NAME = "会所预订";
        public static final String SERVICE_NAME = "服务名称";
        public static final String SERVICE_ID = "服务ID";
        public static final String VENUE_ID = "场地ID";
        public static final String START_BIZ_TIME = "营业时间(起)";
        public static final String END_BIZ_TIME = "营业时间(止)";
        public static final String START_SERV_TIME = "暂停时间(起)";
        public static final String END_SERV_TIME = "暂停时间(止)";
        public static final String WEEK_PART = "营业时间";
        public static final String ORDER_TIME = "预约时间";
        public static final String ADDRESS = "地址";
        public static final String VENUE_NAME = "场地名称";
        public static final String CHARGE_TYPE = "计价方式";
        public static final String PPV = "按次价格";
        public static final String DEF_PRICE = "默认价格";
        public static final String ORDER_NAME = "预约人";
        public static final String ORDER_PHONE = "联系电话";
        public static final String DATE_RANGE = "预订时间段";
        public static final String PRICE_RANGE = "价格区间";
    }

    public interface AccountExport {
        public static final String MODULE_NAME = "财务管理";
    }

    public interface SysNotice {
        public static final String MODULE_NAME = "系统消息";
        public static final String TITLE = "标题";
        public static final String CONTENT = "内容";
        public static final String PUSH_COMMUNITY = "社区后台接收对象";
        public static final String PUSH_PLATFORM = "平台后台接收对象";
        public static final String PUSH_MASTER = "房间后台接收对象";
    }

    public interface Notification {
        public static final String MODULE_NAME = "APP推送管理";
        public static final String PUSH_TIME = "推送时间";
        public static final String PUSH_TYPE = "推送类型";
        public static final String THUMB = "图片地址";
        public static final String AUDIT_REMARK = "审核意见";
    }

    public interface PropertyPayment {
        public static final String MODULE_NAME = "物业缴费";
    }

    public interface Visit {
        public static final String MODULE_NAME = "门禁管理";
        public static final String OPEN_TIME = "开门时间";
        public static final String CLOSE_TIME = "关门时间";
        public static final String SUPPORT_ENTRACE_GUARD = "是否支持门禁";
        public static final String ENTRACE_GUARD_TYPE = "门禁形式";
        public static final String FOLLOW_MUST = "必须提供随行人信息";
        public static final String FOLLOW_MAX = "随行人数上限";
    }

    public interface GagInfo {
        public static final String MODULE_NAME = "会员管理-禁言操作";
    }
}
