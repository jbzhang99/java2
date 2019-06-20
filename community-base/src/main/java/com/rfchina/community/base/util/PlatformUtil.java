package com.rfchina.community.base.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.rfchina.community.base.exception.WorkRunTimeException;

public class PlatformUtil {

	enum PLATFORM {
		PF_BOOLEAN, PF_OBJECT, PF_ARRAY
	}

	public static Object check(JSONObject result, PLATFORM type, Integer... codes) {
		if (result == null || !result.containsKey("code")) {
			throw new WorkRunTimeException("底层通讯错误!");
		}
		int code = result.getIntValue("code");
		for (Integer cd : codes) {
			if (code == cd) {
				switch (type) {
				case PF_BOOLEAN:
					return true;
				case PF_OBJECT:
					return result.getJSONObject("data");
				case PF_ARRAY:
					return result.getJSONArray("data");
				default:
					break;
				}

			}
		}
		throw new WorkRunTimeException(code + ":" + result.getString("msg"));
	}

	public static boolean check(JSONObject result, Integer... codes) {
		return (boolean) check(result, PLATFORM.PF_BOOLEAN, codes);
	}

	public static JSONObject checkJSONObject(JSONObject result, Integer... codes) {
		return (JSONObject) check(result, PLATFORM.PF_OBJECT, codes);
	}

	public static JSONArray checkJSONArray(JSONObject result, Integer... codes) {
		return (JSONArray) check(result, PLATFORM.PF_ARRAY, codes);
	}

	public static boolean check(JSONObject result) {
		return (boolean) check(result, PLATFORM.PF_BOOLEAN, 1001);
	}

	public static JSONObject checkJSONObject(JSONObject result) {
		return (JSONObject) check(result, PLATFORM.PF_OBJECT, 1001);
	}

	public static JSONArray checkJSONArray(JSONObject result) {
		return (JSONArray) check(result, PLATFORM.PF_ARRAY, 1001);
	}
}
