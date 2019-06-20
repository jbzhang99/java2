package com.rfchina.community.base;
/**
 */
public class EmailConstant {

	private EmailConstant() {
	}

	public enum event {
		forget_password, invitation_to_interview,
		//
		merchant_delete_service_pass, merchant_delete_service_unpass,
		//
		merchant_info_pass, merchant_info_unpass,
		//
		payment_margin_success, register_activation,
		//
		service_disabled_community, service_disabled_platform,
		//
		service_info_pass, service_info_unpass,
		//
		service_jia_down_pass, service_jia_down_unpass,
		//
		service_jia_up_pass, service_jia_up_unpass,
		//
		service_pay_pass, service_pay_unpass;

		public String getTemplate() {
			return name() + ".ftl";
		}
	}
}
