package com.rfchina.community.service.openser.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import com.rfchina.community.persistence.model.OpenStoreVerifyCard;

public class ExtVerifyCardVO extends OpenStoreVerifyCard implements Serializable {
	    /**
	 * 
	 */

	    private String phone;
	    
	    private String nickname;
	    
	    private BigDecimal verifyMoney;
	    
	    private String outTradeNo;
	    
		public String getOutTradeNo() {
			return outTradeNo;
		}

		public void setOutTradeNo(String outTradeNo) {
			this.outTradeNo = outTradeNo;
		}

		public BigDecimal getVerifyMoney() {
			return verifyMoney;
		}

		public void setVerifyMoney(BigDecimal verifyMoney) {
			this.verifyMoney = verifyMoney;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getNickname() {
			return nickname;
		}

		public void setNickname(String nickname) {
			this.nickname = nickname;
		}

	    
}