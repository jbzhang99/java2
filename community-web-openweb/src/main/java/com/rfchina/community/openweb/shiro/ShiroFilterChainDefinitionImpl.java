package com.rfchina.community.openweb.shiro;

import com.rfchina.community.base.Constant;
import com.stormpath.shiro.spring.config.web.ShiroFilterChainDefinition;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 */
@Component
public class ShiroFilterChainDefinitionImpl implements ShiroFilterChainDefinition {

	@Value("${shiro.logoutUrl}")
	private String logoutUrl;

	public final Map<String, String> filterChainDefinitionMap = new HashMap<>();

	@PostConstruct
	public void init() {
		filterChainDefinitionMap.put(logoutUrl, "logout");
		filterChainDefinitionMap.put(Constant.ROOT_PATH_OPENWEB + "/acc/**", "anon");
//		filterChainDefinitionMap.put(Constant.ROOT_PATH_OPENWEB + "/rfwallet/**", "anon");
		filterChainDefinitionMap.put(Constant.ROOT_PATH_OPENWEB + "/**", "authc");

	}

	@Override
	public Map<String, String> getFilterChainMap() {
		return filterChainDefinitionMap;
	}
}
