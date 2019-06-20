package test.open.bean;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.rfchina.community.persistence.model.OpenMerchantInfo;


public class Test {

	@org.junit.Test
	public void test() throws IllegalAccessException, InvocationTargetException {
		
		Map<String,   Object> properties=new HashMap<>();
		properties.put("id", Long.valueOf(12));
		properties.put("titleSimple","222222");
		OpenMerchantInfo bean=new OpenMerchantInfo();
		

		System.out.println(JSON.toJSONString(bean));
		System.out.println(JSON.toJSONString(properties));
	 
	}

}
