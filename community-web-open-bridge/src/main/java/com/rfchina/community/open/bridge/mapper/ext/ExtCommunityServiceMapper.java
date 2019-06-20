package com.rfchina.community.open.bridge.mapper.ext;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.paginator.model.PageBounds;
import org.mybatis.paginator.model.PageList;

import com.rfchina.community.open.bridge.entity.ExtCommunityService;
import com.rfchina.community.open.bridge.entity.ExtCommunityServiceAdmin;
import com.rfchina.community.open.bridge.entity.SimCommunityService;

public interface ExtCommunityServiceMapper {

	
	@SelectProvider(type=ExtCommunityServiceSqlProvider.class, method="getCommunityService")
	@Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="png", property="png", jdbcType=JdbcType.VARCHAR),
        @Result(column="reorder", property="reorder", jdbcType=JdbcType.INTEGER),
        @Result(column="clause", property="clause", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="is_account", property="isAccount", jdbcType=JdbcType.INTEGER),
        @Result(column="link", property="link", jdbcType=JdbcType.VARCHAR),
        @Result(column="provide_type", property="provideType", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="app_id", property="appId", jdbcType=JdbcType.BIGINT),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="audit_comment", property="auditComment", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="audit_time", property="auditTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="category_id", property="categoryId", jdbcType=JdbcType.INTEGER),
        @Result(column="is_need_hardware", property="isNeedHardware", jdbcType=JdbcType.INTEGER),
        @Result(column="target_month_turnover", property="targetMonthTurnover", jdbcType=JdbcType.DECIMAL),
        @Result(column="paid_caution_money", property="paidCautionMoney", jdbcType=JdbcType.DECIMAL),
        @Result(column="caution_money_status", property="cautionMoneyStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="ground_mode", property="groundMode", jdbcType=JdbcType.INTEGER),
        @Result(column="merchant_id", property="merchantId", jdbcType=JdbcType.INTEGER),
        @Result(column="account_id", property="accountId", jdbcType=JdbcType.VARCHAR),
        @Result(column="audit_status", property="auditStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="clause_id", property="clauseId", jdbcType=JdbcType.INTEGER),
        @Result(column="app_secret", property="appSecret", jdbcType=JdbcType.VARCHAR),
        @Result(column="receivable_caution_money", property="receivableCautionMoney", jdbcType=JdbcType.DECIMAL),
        @Result(column="recommend_level", property="recommendLevel", jdbcType=JdbcType.DOUBLE),
        @Result(column="caution_money_type", property="cautionMoneyType", jdbcType=JdbcType.INTEGER),
        @Result(column="caution_money_pic", property="cautionMoneyPic", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="caution_bill_id", property="cautionBillId", jdbcType=JdbcType.VARCHAR),
			//@Result(column="commission_rate", property="commissionRate", jdbcType=JdbcType.DECIMAL),
		@Result(column="community_rate", property="communityRate", jdbcType=JdbcType.DECIMAL),

        @Result(column="user_range", property="userRange", jdbcType=JdbcType.INTEGER),
        @Result(column="ground_audit_status", property="groundAuditStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="shot", property="shot", jdbcType=JdbcType.VARCHAR),
        @Result(column="account_receivable_project", property="accountReceivableProject", jdbcType=JdbcType.VARCHAR),
        @Result(column="category_name", property="categoryName", jdbcType=JdbcType.VARCHAR),
		@Result(column="merchant_name", property="merchantName", jdbcType=JdbcType.VARCHAR),
		@Result(column="templete_name", property="templeteName", jdbcType=JdbcType.VARCHAR),

        @Result(column="merchant_type", property="merchantType", jdbcType=JdbcType.INTEGER),
        @Result(column="like_count", property="likeCount", jdbcType=JdbcType.INTEGER),
        @Result(column="unlike_count", property="unlikeCount", jdbcType=JdbcType.INTEGER),
        @Result(column="community_count", property="communityCount", jdbcType=JdbcType.INTEGER),
        @Result(column="community_added_count", property="communityAddedCount", jdbcType=JdbcType.INTEGER),
        @Result(column="under_reason", property="underReason", jdbcType=JdbcType.VARCHAR),
        @Result(column="service_need", property="serviceNeed", jdbcType=JdbcType.VARCHAR),
        @Result(column="quick_pay", property="quickPay", jdbcType=JdbcType.INTEGER)
    })
	public PageList<ExtCommunityService> getCommunityService(Map<String, Object> param , PageBounds pageBounds);
	

    @SelectProvider(type = ExtCommunityServiceSqlProvider.class, method = "getSimCommunityServiceList")
    @Results(id = "simCommunityServiceResults", value = {
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "title", property = "title", jdbcType = JdbcType.VARCHAR),
            @Result(column = "png", property = "png", jdbcType = JdbcType.VARCHAR),
            @Result(column = "description", property = "description", jdbcType = JdbcType.VARCHAR),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "category_id", property = "categoryId", jdbcType = JdbcType.INTEGER),
            @Result(column = "status", property = "status", jdbcType = JdbcType.INTEGER),
            @Result(column = "category_name", property = "categoryName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "recommend_level", property = "recommendLevel", jdbcType = JdbcType.DOUBLE),
            @Result(column = "select_status", property = "selectStatus", jdbcType = JdbcType.INTEGER)
    })
    public PageList<SimCommunityService> getSimCommunityServiceList(Map<String, Object> param, PageBounds pageBounds);
    
    @SelectProvider(type=ExtCommunityServiceSqlProvider.class, method="getVirtualSimCommunityServiceList")
	@ResultMap(value = "simCommunityServiceResults")
    public PageList<SimCommunityService> getVirtualSimCommunityServiceList(Map<String, Object> param, PageBounds pageBounds);
    
	
	
	@SelectProvider(type=ExtCommunityServiceSqlProvider.class, method="searchServiceName")
	public PageList<Map<String,Object>> searchServiceName(Map<String, Object> param , PageBounds pageBounds);
	
	@SelectProvider(type=ExtCommunityServiceSqlProvider.class, method="searchServiceName2")
	public PageList<Map<String,Object>> searchServiceName2(Map<String, Object> param , PageBounds pageBounds);
	
	@SelectProvider(type=ExtCommunityServiceSqlProvider.class, method="businessManagerAdminList")
	public PageList<Map<String,Object>> businessManagerAdminList(Map<String, Object> param , PageBounds pageBounds);
	
	@SelectProvider(type=ExtCommunityServiceSqlProvider.class, method="businessManagerListByType")
	public PageList<Map<String,Object>> businessManagerListByType(Map<String, Object> param , PageBounds pageBounds);
	
	/**
	 * @author:fukangwen
	 * @return PageList<Map<String,Object>>
	 * @throws
	 */
	@SelectProvider(type=ExtCommunityServiceSqlProvider.class, method="searchStoreName")
	public PageList<Map<String,Object>> searchStoreName(Map<String, Object> param , PageBounds pageBounds);
	
	@SelectProvider(type=ExtCommunityServiceSqlProvider.class, method="getCommunityServiceApply")
	  @Results(id = "extCommunityServiceResults", value = {
	            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
	            @Result(column = "title", property = "title", jdbcType = JdbcType.VARCHAR),
	            @Result(column = "png", property = "png", jdbcType = JdbcType.VARCHAR),
	            @Result(column = "reorder", property = "reorder", jdbcType = JdbcType.INTEGER),
	            @Result(column = "clause", property = "clause", jdbcType = JdbcType.VARCHAR),
	            @Result(column = "type", property = "type", jdbcType = JdbcType.INTEGER),
	            @Result(column = "is_account", property = "isAccount", jdbcType = JdbcType.INTEGER),
	            @Result(column = "link", property = "link", jdbcType = JdbcType.VARCHAR),
	            @Result(column = "provide_type", property = "provideType", jdbcType = JdbcType.INTEGER),
	            @Result(column = "status", property = "status", jdbcType = JdbcType.INTEGER),
	            @Result(column = "app_id", property = "appId", jdbcType = JdbcType.BIGINT),
	            @Result(column = "description", property = "description", jdbcType = JdbcType.VARCHAR),
	            @Result(column = "audit_comment", property = "auditComment", jdbcType = JdbcType.VARCHAR),
	            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
	            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.TIMESTAMP),
	            @Result(column = "audit_time", property = "auditTime", jdbcType = JdbcType.TIMESTAMP),
	            @Result(column = "category_id", property = "categoryId", jdbcType = JdbcType.INTEGER),
	            @Result(column = "is_need_hardware", property = "isNeedHardware", jdbcType = JdbcType.INTEGER),
	            @Result(column = "target_month_turnover", property = "targetMonthTurnover", jdbcType = JdbcType.DECIMAL),
	            @Result(column = "paid_caution_money", property = "paidCautionMoney", jdbcType = JdbcType.DECIMAL),
	            @Result(column = "caution_money_status", property = "cautionMoneyStatus", jdbcType = JdbcType.INTEGER),
	            @Result(column = "ground_mode", property = "groundMode", jdbcType = JdbcType.INTEGER),
	            @Result(column = "merchant_id", property = "merchantId", jdbcType = JdbcType.INTEGER),
	            @Result(column = "account_id", property = "accountId", jdbcType = JdbcType.VARCHAR),
	            @Result(column = "audit_status", property = "auditStatus", jdbcType = JdbcType.INTEGER),
	            @Result(column = "clause_id", property = "clauseId", jdbcType = JdbcType.INTEGER),
	            @Result(column = "app_secret", property = "appSecret", jdbcType = JdbcType.VARCHAR),
	            @Result(column = "receivable_caution_money", property = "receivableCautionMoney", jdbcType = JdbcType.DECIMAL),
	            @Result(column = "recommend_level", property = "recommendLevel", jdbcType = JdbcType.DOUBLE),
	            @Result(column = "caution_money_type", property = "cautionMoneyType", jdbcType = JdbcType.INTEGER),
	            @Result(column = "caution_money_pic", property = "cautionMoneyPic", jdbcType = JdbcType.VARCHAR),
	            @Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR),
	            @Result(column = "caution_bill_id", property = "cautionBillId", jdbcType = JdbcType.VARCHAR),
//	            @Result(column = "commission_rate", property = "commissionRate", jdbcType = JdbcType.DECIMAL),
	            @Result(column = "user_range", property = "userRange", jdbcType = JdbcType.INTEGER),
	            @Result(column = "ground_audit_status", property = "groundAuditStatus", jdbcType = JdbcType.INTEGER),
	            @Result(column = "shot", property = "shot", jdbcType = JdbcType.VARCHAR),
	            @Result(column = "account_receivable_project", property = "accountReceivableProject", jdbcType = JdbcType.VARCHAR),
	            @Result(column = "category_name", property = "categoryName", jdbcType = JdbcType.VARCHAR),
	            @Result(column = "merchant_name", property = "merchantName", jdbcType = JdbcType.VARCHAR),
	            @Result(column = "merchant_type", property = "merchantType", jdbcType = JdbcType.INTEGER),
	            @Result(column = "like_count", property = "likeCount", jdbcType = JdbcType.INTEGER),
	            @Result(column = "unlike_count", property = "unlikeCount", jdbcType = JdbcType.INTEGER),
	            @Result(column = "community_count", property = "communityCount", jdbcType = JdbcType.INTEGER),
	            @Result(column = "community_audit_comment", property = "communityAuditComment", jdbcType = JdbcType.INTEGER),
	            @Result(column = "community_added_count", property = "communityAddedCount", jdbcType = JdbcType.INTEGER),
	            @Result(column = "under_reason", property = "underReason", jdbcType = JdbcType.VARCHAR),
	            @Result(column = "select_status", property = "selectStatus", jdbcType = JdbcType.INTEGER),
	            @Result(column = "community_audit_status", property = "communityAuditStatus", jdbcType = JdbcType.INTEGER),
	            @Result(column = "apply_time", property = "applyTime", jdbcType = JdbcType.TIMESTAMP),
	            @Result(column = "community_service_status", property = "communityServiceStatus", jdbcType = JdbcType.INTEGER),
	            @Result(column = "is_menu_show", property = "isMenuShow", jdbcType = JdbcType.INTEGER),
	            @Result(column = "community_service_reorder", property = "communityServiceReorder", jdbcType = JdbcType.INTEGER)
	    })
	public PageList<ExtCommunityService> getCommunityServiceApplyList(Map<String, Object> param , PageBounds pageBounds);
	
	
	@SelectProvider(type=ExtCommunityServiceSqlProvider.class, method="getMyServiceList")
	 @Results(id = "extCommunityServiceAdminResults", value = {
	            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
	            @Result(column = "title", property = "title", jdbcType = JdbcType.VARCHAR),
	            @Result(column = "png", property = "png", jdbcType = JdbcType.VARCHAR),
	            @Result(column = "reorder", property = "reorder", jdbcType = JdbcType.INTEGER),
	            @Result(column = "clause", property = "clause", jdbcType = JdbcType.VARCHAR),
	            @Result(column = "type", property = "type", jdbcType = JdbcType.INTEGER),
	            @Result(column = "is_account", property = "isAccount", jdbcType = JdbcType.INTEGER),
	            @Result(column = "link", property = "link", jdbcType = JdbcType.VARCHAR),
	            @Result(column = "provide_type", property = "provideType", jdbcType = JdbcType.INTEGER),
	            @Result(column = "status", property = "status", jdbcType = JdbcType.INTEGER),
	            @Result(column = "app_id", property = "appId", jdbcType = JdbcType.BIGINT),
	            @Result(column = "description", property = "description", jdbcType = JdbcType.VARCHAR),
	            @Result(column = "audit_comment", property = "auditComment", jdbcType = JdbcType.VARCHAR),
	            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
	            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.TIMESTAMP),
	            @Result(column = "audit_time", property = "auditTime", jdbcType = JdbcType.TIMESTAMP),
	            @Result(column = "category_id", property = "categoryId", jdbcType = JdbcType.INTEGER),
	            @Result(column = "is_need_hardware", property = "isNeedHardware", jdbcType = JdbcType.INTEGER),
	            @Result(column = "target_month_turnover", property = "targetMonthTurnover", jdbcType = JdbcType.DECIMAL),
	            @Result(column = "paid_caution_money", property = "paidCautionMoney", jdbcType = JdbcType.DECIMAL),
	            @Result(column = "caution_money_status", property = "cautionMoneyStatus", jdbcType = JdbcType.INTEGER),
	            @Result(column = "ground_mode", property = "groundMode", jdbcType = JdbcType.INTEGER),
	            @Result(column = "merchant_id", property = "merchantId", jdbcType = JdbcType.INTEGER),
	            @Result(column = "account_id", property = "accountId", jdbcType = JdbcType.VARCHAR),
	            @Result(column = "audit_status", property = "auditStatus", jdbcType = JdbcType.INTEGER),
	            @Result(column = "clause_id", property = "clauseId", jdbcType = JdbcType.INTEGER),
	            @Result(column = "app_secret", property = "appSecret", jdbcType = JdbcType.VARCHAR),
	            @Result(column = "receivable_caution_money", property = "receivableCautionMoney", jdbcType = JdbcType.DECIMAL),
	            @Result(column = "recommend_level", property = "recommendLevel", jdbcType = JdbcType.DOUBLE),
	            @Result(column = "caution_money_type", property = "cautionMoneyType", jdbcType = JdbcType.INTEGER),
	            @Result(column = "caution_money_pic", property = "cautionMoneyPic", jdbcType = JdbcType.VARCHAR),
	            @Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR),
	            @Result(column = "caution_bill_id", property = "cautionBillId", jdbcType = JdbcType.VARCHAR),
//	            @Result(column = "commission_rate", property = "commissionRate", jdbcType = JdbcType.DECIMAL),
	            @Result(column = "user_range", property = "userRange", jdbcType = JdbcType.INTEGER),
	            @Result(column = "ground_audit_status", property = "groundAuditStatus", jdbcType = JdbcType.INTEGER),
	            @Result(column = "shot", property = "shot", jdbcType = JdbcType.VARCHAR),
	            @Result(column = "account_receivable_project", property = "accountReceivableProject", jdbcType = JdbcType.VARCHAR),
	            @Result(column = "category_name", property = "categoryName", jdbcType = JdbcType.VARCHAR),
	            @Result(column = "merchant_name", property = "merchantName", jdbcType = JdbcType.VARCHAR),
	            @Result(column = "merchant_type", property = "merchantType", jdbcType = JdbcType.INTEGER),
	            @Result(column = "like_count", property = "likeCount", jdbcType = JdbcType.INTEGER),
	            @Result(column = "unlike_count", property = "unlikeCount", jdbcType = JdbcType.INTEGER),
	            @Result(column = "community_count", property = "communityCount", jdbcType = JdbcType.INTEGER),
	            @Result(column = "community_audit_comment", property = "communityAuditComment", jdbcType = JdbcType.INTEGER),
	            @Result(column = "community_added_count", property = "communityAddedCount", jdbcType = JdbcType.INTEGER),
	            @Result(column = "under_reason", property = "underReason", jdbcType = JdbcType.VARCHAR),
	            @Result(column = "select_status", property = "selectStatus", jdbcType = JdbcType.INTEGER),
	            @Result(column = "community_audit_status", property = "communityAuditStatus", jdbcType = JdbcType.INTEGER),
	            @Result(column = "apply_time", property = "applyTime", jdbcType = JdbcType.TIMESTAMP),
	            @Result(column = "community_service_status", property = "communityServiceStatus", jdbcType = JdbcType.INTEGER),
	            @Result(column = "is_menu_show", property = "isMenuShow", jdbcType = JdbcType.INTEGER),
	            @Result(column = "community_service_reorder", property = "communityServiceReorder", jdbcType = JdbcType.INTEGER)
	    })
	public PageList<ExtCommunityServiceAdmin> getMyServiceList(Map<String, Object> param , PageBounds pageBounds);
	
	
	
	@Select("select count(*) from community_service_rela r "
			+ " join community_service s on s.id=r.service_id "
			+ " where s.status=1 and r.is_menu_show=1 and "
			+ " r.select_status=1 and r.community_id=#{community_id}")
	public Long countIsMenuShowByCommunityId(@Param("community_id") int community_id);


	@SelectProvider(type=ExtCommunityServiceSqlProvider.class, method="findServiceTitle")
	List<Map<String,Object>> findServiceTitle(Map<String, Object> param);
}
