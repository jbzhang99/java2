package com.rfchina.community.base.openapi;

import com.rfchina.api.request.pay.FuPayCreateRequest.GoodsDetail;
import com.rfchina.community.base.exception.WorkRunTimeException;

import java.math.BigDecimal;

public class ExtAppMoney extends ExtAppMoneyBase {
	Long openOrderId;
	// 平台手续费比例
	BigDecimal platformFee = new BigDecimal(0);
	// 平台手续费
	BigDecimal platformCharge = new BigDecimal(0);
	// 商家总金额

	// 社区佣金比例
	BigDecimal communityRate = new BigDecimal(0);
	// 社区实收
	BigDecimal serviceCharge = new BigDecimal(0);
	// 社区佣金
	BigDecimal toServiceCharge = new BigDecimal(0);

	// 待商家实收
	BigDecimal toReceiptAmount = new BigDecimal(0);
	// 商家实收
	BigDecimal receiptAmount = new BigDecimal(0);

	//思力佣金比例
	BigDecimal thinkRate = new BigDecimal(0);
	// 思力佣金实收
	BigDecimal thinkCharge = new BigDecimal(0);
	// 思力佣金佣金
	BigDecimal toThinkCharge = new BigDecimal(0);

	Integer serviceId;
	String accountId;
	String thinkAccountId;
	// 是否退款
	int isRefund = 0;
	
	
	private String refundBillId;
	// 退款给用户
	BigDecimal refundUser = new BigDecimal(0);
	// 拆单的金额
	BigDecimal splitAmount = new BigDecimal(0);
	public static void validator(Boolean flag, String msg) {
		if (flag)
			throw new WorkRunTimeException(msg);
	}

	//TODO 重新计算规则
	public void build() {
		//商家手续费
		BigDecimal receiptRate = new BigDecimal(100).subtract(platformFee).subtract(communityRate).subtract(thinkRate);
		validator(receiptRate.compareTo(new BigDecimal(0)) <= 0, "商家实收比例不能小于等于0");
		//先计算商家金额
		toReceiptAmount = totalAmount.multiply(receiptRate).divide(new BigDecimal("100")).setScale(2,
				BigDecimal.ROUND_HALF_UP);
		//算出的商家应实收金额小于等于0,最低也要0.01
		if(toReceiptAmount.compareTo(new BigDecimal(0)) <= 0){
			toReceiptAmount = new BigDecimal("0.01");
		}

		BigDecimal blanceAmount = totalAmount.subtract(toReceiptAmount);
		// 平台手续费计算，单位元
		platformCharge = calcCharge(platformFee,platformCharge,blanceAmount);
		blanceAmount = blanceAmount.subtract(platformCharge);

		// 思力佣金，单位元
		toThinkCharge = calcCharge(thinkRate,toThinkCharge,blanceAmount);
		blanceAmount = blanceAmount.subtract(toThinkCharge);

		// 社区佣金，单位元
        toServiceCharge = calcCharge(communityRate,toServiceCharge,blanceAmount);
		blanceAmount = blanceAmount.subtract(toServiceCharge);

		// 待商家实收
		if(blanceAmount.compareTo(new BigDecimal(0)) > 0){
			toReceiptAmount = toReceiptAmount.add(blanceAmount);
		}
		splitAmount=totalAmount;
		refundBuild(isRefund);
	}

	private BigDecimal calcCharge(BigDecimal fee,BigDecimal charge,BigDecimal blanceAmount) {
		if(fee.compareTo(new BigDecimal(0)) > 0 && blanceAmount.compareTo(new BigDecimal(0)) > 0) {
			charge = totalAmount.multiply(fee).divide(new BigDecimal("100")).setScale(2,
					BigDecimal.ROUND_HALF_UP);
			if (charge.compareTo(blanceAmount) >= 0) {
				// 手续费少于剩余余额
				charge = blanceAmount;
			}
		}
		return charge;
	}

	public ExtAppMoney(BigDecimal totalAmount, BigDecimal platformFee, BigDecimal communityRate, BigDecimal thinkRate, int isRefund) {
		this.platformFee = platformFee;
		this.totalAmount = totalAmount;
		this.communityRate = communityRate;
		this.thinkRate = thinkRate;
		this.isRefund = isRefund;

	}

	public ExtAppMoney() {

	}

	public void refundBuild(int isRefund) {
		BigDecimal ref = new BigDecimal(0);
		if (isRefund == 1) {
			ref = new BigDecimal(1);
		}
		BigDecimal radix = new BigDecimal(1).subtract(ref);
		refundUser = totalAmount.multiply(ref);
		// =(1-I3)*E3
		serviceCharge = radix.multiply(toServiceCharge);
		// =(1-I3)*E3
		thinkCharge = radix.multiply(toThinkCharge);
		// =C3-G3-(1-I3)*E3-I3*K3
		receiptAmount = totalAmount.subtract(platformCharge)
				.subtract(radix.multiply(toServiceCharge))
				.subtract(radix.multiply(toThinkCharge))
				.subtract(ref.multiply(refundUser));
		
		// 退款的拆单金额怎么算(商家的拆单金额，由于社区服务费跟思力账户是单独拆的，需要先减掉)
		splitAmount=totalAmount.subtract(radix.multiply(toServiceCharge))
				               .subtract(radix.multiply(toThinkCharge));
		
	}

	public String getThinkAccountId() {
		return thinkAccountId;
	}

	public void setThinkAccountId(String thinkAccountId) {
		this.thinkAccountId = thinkAccountId;
	}

	public BigDecimal getPlatformFee() {
		return platformFee;
	}

	public void setPlatformFee(BigDecimal platformFee) {
		this.platformFee = platformFee;
	}

	public BigDecimal getPlatformCharge() {
		return platformCharge;
	}

	public void setPlatformCharge(BigDecimal platformCharge) {
		this.platformCharge = platformCharge;
	}

	public BigDecimal getCommunityRate() {
		return communityRate;
	}

	public void setCommunityRate(BigDecimal commissionRate) {
		this.communityRate = commissionRate;
	}

	public BigDecimal getServiceCharge() {
		return serviceCharge;
	}

	public void setServiceCharge(BigDecimal serviceCharge) {
		this.serviceCharge = serviceCharge;
	}

	public BigDecimal getToServiceCharge() {
		return toServiceCharge;
	}

	public void setToServiceCharge(BigDecimal toServiceCharge) {
		this.toServiceCharge = toServiceCharge;
	}

	public BigDecimal getToReceiptAmount() {
		return toReceiptAmount;
	}

	public void setToReceiptAmount(BigDecimal toReceiptAmount) {
		this.toReceiptAmount = toReceiptAmount;
	}

	public BigDecimal getReceiptAmount() {
		return receiptAmount;
	}

	public void setReceiptAmount(BigDecimal receiptAmount) {
		this.receiptAmount = receiptAmount;
	}

	public int getIsRefund() {
		return isRefund;
	}

	public void setIsRefund(int isRefund) {
		this.isRefund = isRefund;

	}

	public BigDecimal getThinkRate() {
		return thinkRate;
	}

	public void setThinkRate(BigDecimal thinkRate) {
		this.thinkRate = thinkRate;
	}

	public BigDecimal getThinkCharge() {
		return thinkCharge;
	}

	public void setThinkCharge(BigDecimal thinkCharge) {
		this.thinkCharge = thinkCharge;
	}

	public BigDecimal getToThinkCharge() {
		return toThinkCharge;
	}

	public void setToThinkCharge(BigDecimal toThinkCharge) {
		this.toThinkCharge = toThinkCharge;
	}

	public BigDecimal getRefundUser() {
		return refundUser;
	}

	public void setRefundUser(BigDecimal refundUser) {
		this.refundUser = refundUser;
	}

	@Override
	public String toString() {
		return "[商家=" + totalAmount + ", \t平台手续费费率=" + platformFee + ", \t平台实收=" + platformCharge + ", \t社区佣金比率="
				+ communityRate + ", \t社区佣金=" + toServiceCharge + ", \t商家待收=" + toReceiptAmount + ", \t" +
				"思力佣金比率=\t" + thinkRate + ", \t思力佣金=\t" + toThinkCharge + ", \t商家待收=\" + toReceiptAmount + \",\t是否退款="
				+ isRefund + ", \t用户退款=" + refundUser + ", \t商家实收=" + receiptAmount + ", \t社区实收=" + serviceCharge  + ", \t拆单给商家金额=" + splitAmount + "]";
		
	}

	public Integer getServiceId() {
		return serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public Long getOpenOrderId() {
		return openOrderId;
	}

	public void setOpenOrderId(Long openOrderId) {
		this.openOrderId = openOrderId;
	}

	 

	public String getRefundBillId() {
		return refundBillId;
	}

	public void setRefundBillId(String refundBillId) {
		this.refundBillId = refundBillId;
	}

	public BigDecimal getSplitAmount() {
		return splitAmount;
	}

	public void setSplitAmount(BigDecimal splitAmount) {
		this.splitAmount = splitAmount;
	}
	
	public String getGoodDetailShowName() {
		StringBuffer showName = new StringBuffer();
		if(this.getGoodsDetails() == null)
			return showName.toString();
		for(GoodsDetail detail : this.getGoodsDetails()) {
			//【店铺A名称】：【属于店铺A的商品名称】：【件数】 【单价】
			showName.append("【");
			showName.append(detail.getName());
			showName.append(" " + detail.getPrice());
			showName.append("\n");
		}
		return showName.toString();
	}

}
