package test;

import com.rfchina.community.base.openapi.ExtAppMoney;
import com.rfchina.community.base.openapi.ExtAppMoneyTotal;

import java.math.BigDecimal;

public class TestMoney {
	public static void main(String[] args) {
		ExtAppMoneyTotal total = new ExtAppMoneyTotal();
//		this.platformFee = platformFee;
//		this.totalAmount = totalAmount;
//		this.communityRate = communityRate;
//		this.thinkRate = thinkRate;
//		this.isRefund = isRefund;
//		total.addMoney(new ExtAppMoney(new BigDecimal("20"), new BigDecimal("1"), new BigDecimal("3"), new BigDecimal("3"), 1));
//		total.addMoney(new ExtAppMoney(new BigDecimal("45"), new BigDecimal("1"), new BigDecimal("4"), new BigDecimal("3"),0));
//		total.addMoney(new ExtAppMoney(new BigDecimal("0.01"), new BigDecimal("8"), new BigDecimal("1"),new BigDecimal("3"), 1));
//		total.addMoney(new ExtAppMoney(new BigDecimal("30.02"), new BigDecimal("0"), new BigDecimal("1"),new BigDecimal("3"), 1));
//		total.addMoney(new ExtAppMoney(new BigDecimal("0.01"), new BigDecimal("8"), new BigDecimal("6"),new BigDecimal("8"), 1));
//		total.addMoney(new ExtAppMoney(new BigDecimal("0.02"), new BigDecimal("8"), new BigDecimal("6"),new BigDecimal("8"), 1));
		//total.addMoney(new ExtAppMoney(new BigDecimal("0.07"), new BigDecimal("5"), new BigDecimal("25"),new BigDecimal("20"), 0));
		//total.addMoney(new ExtAppMoney(new BigDecimal("0.1"), new BigDecimal("5"), new BigDecimal("20"),new BigDecimal("25"), 0));
		total.addMoney(new ExtAppMoney(new BigDecimal("0.05"), new BigDecimal("20"), new BigDecimal("20"),new BigDecimal("20"), 1));
		total.build();
		for (ExtAppMoney string : total.getMoneys()) {
			System.out.println(string);
		}
		System.out.println(total);
	}
}
