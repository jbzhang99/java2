package com.rfchina.community.base;

public class KeyValueDomain {
	private String key;
	private String value;

	public KeyValueDomain(){

	}
	public KeyValueDomain(String key, String value){
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
