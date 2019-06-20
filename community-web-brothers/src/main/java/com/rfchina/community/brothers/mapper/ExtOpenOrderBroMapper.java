package com.rfchina.community.brothers.mapper;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface ExtOpenOrderBroMapper extends Serializable {

	@Update({ "update open_order set withdraw_status=#{withdraw_status} ,settle_id=#{settle_id} "
			+ " where bill_split_time>=#{startDate} and bill_split_time<=#{endDate} and type in (1,4,5) and bill_status=2 "
			+ " and service_id=#{service_id} " })
	public Long updateWithdrawStatus(@Param("startDate") Date startDate, @Param("endDate") Date endDate,
			@Param("withdraw_status") int withdraw_status, @Param("service_id") int service_id,
			@Param("settle_id") String settle_id);

	// OpenOrderExample example = new OpenOrderExample();
	// example.createCriteria().andCreateTimeGreaterThanOrEqualTo(DateTimeUtils.date000000(extOpenSettlementApply.getSettlementStartTime()))
	// .andCreateTimeLessThanOrEqualTo(DateTimeUtils.date235959(extOpenSettlementApply.getSettlementEndTime())).andTypeEqualTo(1).andBillStatusEqualTo(2)
	// .andServiceIdEqualTo(extOpenSettlementApply.getServiceId());
}