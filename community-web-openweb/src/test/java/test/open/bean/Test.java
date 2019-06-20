package test.open.bean;

import static org.junit.Assert.fail;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import com.rfchina.community.persistence.model.Community;
import org.apache.commons.beanutils.BeanUtils;

import com.alibaba.fastjson.JSON;
import com.rfchina.community.persistence.model.OpenMerchantInfo;
import org.springframework.web.bind.support.WebRequestDataBinder;


public class Test {

	@org.junit.Test
	public void test() throws IllegalAccessException, InvocationTargetException {
		
		Map<String,   Object> properties=new HashMap<>();
		properties.put("id", Long.valueOf(12));
		properties.put("titleSimple","222222");
		OpenMerchantInfo bean=new OpenMerchantInfo();
		
		BeanUtils.populate(bean, properties);

		System.out.println(JSON.toJSONString(bean));
		System.out.println(JSON.toJSONString(properties));

		Community community = new Community();

		WebRequestDataBinder binder = new WebRequestDataBinder(community);
		//binder.registerCustomEditor();
	}

}
