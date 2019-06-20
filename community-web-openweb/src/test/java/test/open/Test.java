package test.open;

import org.apache.commons.lang3.EnumUtils;

import com.rfchina.community.base.OpenConstant;

public class Test {

	public static void main(String[] args) {
		String d="";
// TODO Auto-generated method stub
		System.out.println("ddddd".matches("[failure|success]"));
		System.out.println("failure".matches("[failure|success]"));
		System.out.println("success".matches("[failure|success]"));
		System.out.println("FAILURE".matches("[failure|success]"));

		System.out.println(	EnumUtils.isValidEnum(OpenConstant.open_service_detail.develop_type.class, "TEMPLETE"));
		System.out.println(	EnumUtils.isValidEnum(OpenConstant.open_service_detail.develop_type.class, "TEMPLE1TE"));
			System.out.println(OpenConstant.open_service_detail.develop_type.valueOf("TEMPLETE"));
		
	}


}
