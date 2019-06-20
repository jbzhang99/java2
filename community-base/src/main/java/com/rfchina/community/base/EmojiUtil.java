package com.rfchina.community.base;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiUtil {

	// public static String emoji = "";
	public static String emoji = "[^\\u0000-\\uFFFF]";
	// public static String emoji
	// ="[\\ud800\\udc00-\\udbff\\udfff\\ud800-\\udfff]";// "[^\\u0000-\\uFFFF]";

	public static String replaceAll(String title, String replace) {
		if (title == null)
			return "";
		return title.replaceAll(emoji, replace);
	}

	public static String replaceAll(String title) {
		return replaceAll(title, "");
	}

    // 判别是否包含Emoji表情
    public static boolean containsEmoji(String str) {  
     int len = str.length();  
     for (int i = 0; i < len; i++) {  
      if (isEmojiCharacter(str.charAt(i))) {  
       return true;  
      }  
     }  
     return false;  
    }  
      
    public static boolean isEmojiCharacter(char codePoint) {  
           return !((codePoint == 0x0) ||  
                   (codePoint == 0x9) ||  
                   (codePoint == 0xA) ||  
                   (codePoint == 0xD) ||  
                   ((codePoint >= 0x20) && (codePoint <= 0xD7FF)) ||  
                   ((codePoint >= 0xE000) && (codePoint <= 0xFFFD)) ||  
                   ((codePoint >= 0x10000) && (codePoint <= 0x10FFFF)));  
       }  

}
