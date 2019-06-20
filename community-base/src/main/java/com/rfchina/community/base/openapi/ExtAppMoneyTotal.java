package com.rfchina.community.base.openapi;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ExtAppMoneyTotal {
	Long id;
	List<ExtAppMoney> moneys;

	//社区的收款id
    private String communityAccountId;
	// refund_count
	Integer refund_count = 0;

	// 平台手续费
	BigDecimal platformChargeTotal = new BigDecimal(0);
	// 商家总金额
	BigDecimal totalAmountTotal = new BigDecimal(0);

	// 社区实收
	BigDecimal serviceChargeTotal = new BigDecimal(0);
	// 社区佣金
	BigDecimal toServiceChargeTotal = new BigDecimal(0);

	// 待商家实收
	BigDecimal toReceiptAmountTotal = new BigDecimal(0);
	// 商家实收
	BigDecimal receiptAmountTotal = new BigDecimal(0);

	// 待思力账户实收
	BigDecimal toThinkAmountTotal = new BigDecimal(0);
	// 思力账户实收
	BigDecimal thinkAmountTotal = new BigDecimal(0);


	// 退款给用户
	BigDecimal refundUserTotal = new BigDecimal(0);

	BigDecimal splitAmount = new BigDecimal(0);
	
	
	
	public void build() {
		// refund_count
		refund_count = 0;
		// 平台手续费
		platformChargeTotal = new BigDecimal(0);
		// 商家总金额
		totalAmountTotal = new BigDecimal(0);
		// 社区实收
		serviceChargeTotal = new BigDecimal(0);
		// 社区佣金
		toServiceChargeTotal = new BigDecimal(0);
		// 待商家实收
		toReceiptAmountTotal = new BigDecimal(0);
		// 商家实收
		receiptAmountTotal = new BigDecimal(0);
		// 退款给用户
		refundUserTotal = new BigDecimal(0);
		toThinkAmountTotal = new BigDecimal(0);
		splitAmount = new BigDecimal(0);
		thinkAmountTotal = new BigDecimal(0);
		for (ExtAppMoney m : moneys) {
			m.build();
			refundUserTotal = refundUserTotal.add(m.getRefundUser());
			receiptAmountTotal = receiptAmountTotal.add(m.getReceiptAmount());
			toReceiptAmountTotal = toReceiptAmountTotal.add(m.getToReceiptAmount());
			toServiceChargeTotal = toServiceChargeTotal.add(m.getToServiceCharge());
			serviceChargeTotal = serviceChargeTotal.add(m.getServiceCharge());

			//思力账户
			thinkAmountTotal = thinkAmountTotal.add(m.getThinkCharge());
			toThinkAmountTotal = toThinkAmountTotal.add(m.getToThinkCharge());

			totalAmountTotal = totalAmountTotal.add(m.getTotalAmount());
			platformChargeTotal = platformChargeTotal.add(m.getPlatformCharge());
			splitAmount = splitAmount.add(m.getSplitAmount());
			refund_count += m.getIsRefund();
		}
}


	public List<ExtAppMoney> getMoneys() {
		return moneys;
	}

	public void setMoneys(List<ExtAppMoney> moneys) {
		this.moneys = moneys;
	}

	public void addMoney(ExtAppMoney money) {
		if (this.moneys == null)
			this.moneys = new ArrayList<>();
		this.moneys.add(money);
		build();
	}

	public BigDecimal getToThinkAmountTotal() {
		return toThinkAmountTotal;
	}

	public void setToThinkAmountTotal(BigDecimal toThinkAmountTotal) {
		this.toThinkAmountTotal = toThinkAmountTotal;
	}

	public BigDecimal getThinkAmountTotal() {
		return thinkAmountTotal;
	}

	public void setThinkAmountTotal(BigDecimal thinkAmountTotal) {
		this.thinkAmountTotal = thinkAmountTotal;
	}

	public Integer getRefund_count() {
		return refund_count;
	}

	public void setRefund_count(Integer refund_count) {
		this.refund_count = refund_count;
	}

	public BigDecimal getPlatformChargeTotal() {
		return platformChargeTotal;
	}

	public void setPlatformChargeTotal(BigDecimal platformChargeTotal) {
		this.platformChargeTotal = platformChargeTotal;
	}

	public BigDecimal getTotalAmountTotal() {
		return totalAmountTotal;
	}

	public void setTotalAmountTotal(BigDecimal totalAmountTotal) {
		this.totalAmountTotal = totalAmountTotal;
	}

	public BigDecimal getServiceChargeTotal() {
		return serviceChargeTotal;
	}

	public void setServiceChargeTotal(BigDecimal serviceChargeTotal) {
		this.serviceChargeTotal = serviceChargeTotal;
	}

	public BigDecimal getToServiceChargeTotal() {
		return toServiceChargeTotal;
	}

	public void setToServiceChargeTotal(BigDecimal toServiceChargeTotal) {
		this.toServiceChargeTotal = toServiceChargeTotal;
	}

	public BigDecimal getToReceiptAmountTotal() {
		return toReceiptAmountTotal;
	}

	public void setToReceiptAmountTotal(BigDecimal toReceiptAmountTotal) {
		this.toReceiptAmountTotal = toReceiptAmountTotal;
	}

	public BigDecimal getReceiptAmountTotal() {
		return receiptAmountTotal;
	}

	public void setReceiptAmountTotal(BigDecimal receiptAmountTotal) {
		this.receiptAmountTotal = receiptAmountTotal;
	}

	public BigDecimal getRefundUserTotal() {
		return refundUserTotal;
	}

	public void setRefundUserTotal(BigDecimal refundUserTotal) {
		this.refundUserTotal = refundUserTotal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "[总收=" + totalAmountTotal + ", \t 平台手续费费率  \t平台实收总=" + platformChargeTotal + ", \t社区佣金比率\t社区佣金="
				+ toServiceChargeTotal + ", \t商家待收总=" + toReceiptAmountTotal + ", \t退款数=" + refund_count + ", \t用户退款总="
				+ refundUserTotal + ", \t思力待实收=" + toThinkAmountTotal + ", \t思力实收=" + thinkAmountTotal +
				", \t商家实收=" + receiptAmountTotal + ", \t社区实收=" + serviceChargeTotal + ", \tid=" + id
				+ "]";
	}

	public String getCommunityAccountId() {
		return communityAccountId;
	}

	public void setCommunityAccountId(String communityAccountId) {
		this.communityAccountId = communityAccountId;
	}

	public BigDecimal getSplitAmount() {
		return splitAmount;
	}

	public void setSplitAmount(BigDecimal splitAmount) {
		this.splitAmount = splitAmount;
	}

}
