package com.rfchina.community.base.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 */
public final class RegexUtils {

    private RegexUtils() {

    }
    public static final String emailAddressPattern = "\\b(^['_A-Za-z0-9-]+(\\.['_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\\.[A-Za-z0-9-]+)*((\\.[A-Za-z0-9]{2,})|(\\.[A-Za-z0-9]{2,}\\.[A-Za-z0-9]{2,}))$)\\b";
	
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

//    public static final Pattern VALID_MOBILE_REGEX =
//            Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
    
    public static final Pattern VALID_MOBILE_REGEX =

          Pattern.compile("^1(\\d){10}$");

    public static final Pattern VALID_USERNAME_REGEX =
            Pattern.compile("^[a-zA-Z]\\w{5,17}$");

    public static final Pattern VALID_PASSWORD_REGEX =
            Pattern.compile("^[a-zA-Z0-9]{6,16}$");

    public static final Pattern VALID_TELEPHONE_REGEX = Pattern.compile("(?:(\\(\\+?86\\))(0[0-9]{2,3}\\-?)?([2-9][0-9]{6,7})+(\\-[0-9]{1,4})?)|" +
                "(?:(86-?)?(0[0-9]{2,3}\\-?)?([2-9][0-9]{6,7})+(\\-[0-9]{1,4})?)");

    public static final Pattern VALID_POSITIVE_NUM =
            Pattern.compile("^[+]{0,1}(\\d+)$|^[+]{0,1}(\\d+\\.\\d+)$");
    
    public final static boolean isEmail(String email) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(email);
        return matcher.find();
    }

    public final static boolean isMobile(String mobile) {
        Matcher matcher = VALID_MOBILE_REGEX .matcher(mobile);
        return matcher.find();
    }

    public final static boolean isUsername(String username) {
        Matcher matcher = VALID_USERNAME_REGEX .matcher(username);
        return matcher.find();
    }

    public final static boolean isValidPassword(String password) {
        Matcher matcher = VALID_PASSWORD_REGEX .matcher(password);
        return matcher.find();
    }

    public final static boolean isTelephone(String telephone) {
        Matcher matcher = VALID_TELEPHONE_REGEX .matcher(telephone);
        return matcher.find();
    }
    public final static boolean isPositiveNum(String numStr) {
    	Matcher matcher = VALID_POSITIVE_NUM .matcher(numStr);
    	return matcher.find();
    }
}
