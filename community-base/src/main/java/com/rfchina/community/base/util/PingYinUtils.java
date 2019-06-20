package com.rfchina.community.base.util;

import com.alibaba.fastjson.JSONObject;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName PingYinUtils
 * @Description 汉字转拼音
 * @Author wlrllr
 * @Date 2019/1/31 15:01
 * @Version 1.0
 **/
public class PingYinUtils {
    private static HanyuPinyinOutputFormat format;

    static {
        format = new HanyuPinyinOutputFormat();
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE); //无声调表示
        //WITH_U_UNICODE:ü,WITH_V:v WITH_U_AND_COLON:u:
        format.setVCharType(HanyuPinyinVCharType.WITH_V);
    }

    private static final String PY_G = "GROUP";
    private static final String PY_F = "FIRST";
    private static final String PY_ALL = "ALL";
    public static String getPingYin(String str) {
        return getPingYin(str, PY_G).getPy();
    }

    public static String getPingYinFirst(String str) {
        return getPingYin(str, PY_F).getPyFirst();
    }

    public static JSONObject getPingYinAll(String str){
        return (JSONObject)JSONObject.toJSON(getPingYin(str, PY_ALL));
    }

    private static PYModel getPingYin(String str, String code) {
        PYModel py = new PYModel();
        StringBuilder pyGroup = new StringBuilder();
        StringBuilder pyFirst = new StringBuilder();
        if (StringUtils.isNotBlank(str)) {
            str = clearSpecialChar(str);
            char[] chars = str.trim().toCharArray();
            try {
                for (int i = 0; i < chars.length; i++) {
                    Object pyTemp = "";
                    Object pyFirstTemp = "";
                    if (String.valueOf(chars[i]).matches("[\\u4E00-\\u9FA5]+")) {
                        String[] pinyinStrArray = PinyinHelper.toHanyuPinyinStringArray(chars[i], format);
                        if (PY_F.equals(code)) {
                            pyFirstTemp = pinyinStrArray[0].charAt(0);
                        } else if (PY_G.equals(code)) {
                            pyTemp = pinyinStrArray[0];
                        } else if (PY_ALL.equals(code)) {
                            pyTemp = pinyinStrArray[0];
                            pyFirstTemp = pinyinStrArray[0].charAt(0);
                         }
                    }else{
                        pyTemp = chars[i];
                        pyFirstTemp = chars[i];
                    }
                    pyGroup.append(pyTemp);
                    pyFirst.append(pyFirstTemp);
                }
            } catch (BadHanyuPinyinOutputFormatCombination e) {
                e.printStackTrace();
            }
            py.setPy(pyGroup.toString());
            py.setPyFirst(pyFirst.toString());
        }
        return py;
    }

    public static String clearSpecialChar(String str) {
        str = str.replaceAll("[\\p{Punct}\\p{Space}]+", "");
        String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}<>《》【】‘；：”“’。，、？]";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(str);
        str = matcher.replaceAll("").trim();
        return str;
    }


    public static void main(String[] args) {
        String py = getPingYin("刘我绿是拼音i am aa!");

        String pyf = getPingYinFirst("刘我绿是拼音i am aa!");
        System.out.println(py);
        System.out.println(pyf);
        System.out.println(JSONObject.toJSONString(getPingYinAll("刘我绿是拼音i am aa!")));
    }
}
class PYModel{

    private String py;
    private String pyFirst;

    public String getPy() {
        return py;
    }

    public void setPy(String py) {
        this.py = py;
    }

    public String getPyFirst() {
        return pyFirst;
    }

    public void setPyFirst(String pyFirst) {
        this.pyFirst = pyFirst;
    }
}
