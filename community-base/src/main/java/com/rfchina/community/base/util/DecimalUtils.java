package com.rfchina.community.base.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import org.apache.commons.lang3.math.NumberUtils;

/**
 * 由于Java的简单类型不能够精确的对浮点数进行运算，这个工具类提供精 确的浮点数运算，包括加减乘除和四舍五入。
 * @author maixingnian
 * @since 3.2
 */
public class DecimalUtils {
	private static final int DEF_DIV_SCALE = 10; 

	//这个类不能实例化
	private DecimalUtils() {}
	
	public static BigDecimal doubleToBigDecimalWithTwoScale(Double d) {
		DecimalFormat decimalFormat = new DecimalFormat("#.00");
		BigDecimal bigDecimal = NumberUtils.createBigDecimal(decimalFormat.format(d));
		return bigDecimal;
	}

	public static BigDecimal toBigDecimalWithTwoScale(String str) {
		DecimalFormat decimalFormat = new DecimalFormat("#.00");
		BigDecimal bigDecimal = NumberUtils.createBigDecimal(decimalFormat.format(NumberUtils.createDouble(str)));
		return bigDecimal;
	}
	
	/**
	 * 四舍五入
	 * @param b1 被操作数
	 * @param newScale 保留数位
	 * @param roundingMode 末尾保留模式
	 * BigDecimal.ROUND_UP 进位处理 2.333 -> 2.34
	 * BigDecimal.ROUND_DOWN  直接去掉多余的小数 2.336 -> 2.33
	 * BigDecimal.ROUND_HALF_DOWN 四舍五入 2.336 -> 2.33
	 * BigDecimal.ROUND_HALF_UP 四舍五入 2.35 -> 2.4
	 * @return
	 */
	public static BigDecimal bigDecimalScale(BigDecimal b1, int newScale, int roundingMode) {
		return b1.setScale(newScale, roundingMode);
	}
	
	/**
	 * 默认四舍五入
	 * @param b1
	 * @param newScale
	 * @return 
	 */
	public static BigDecimal bigDecimalScale(BigDecimal b1, int newScale) {
		return bigDecimalScale(b1,newScale, BigDecimal.ROUND_HALF_UP);
	}
	
	/**
	 * obj对象转换为BigDecimal
	 * @param obj
	 * @return BigDecimal
	 */
	public static BigDecimal obj2BigDecimal(Object obj) {
		BigDecimal bigDecimal = new BigDecimal(obj.toString());
		return bigDecimal;
	}
	
	/**
	 * 提供精确的加法运算。
	 * @param v1 被加数
	 * @param v2 加数
	 * @return 两个参数的和
	 */
	public static double add(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return add(b1, b2).doubleValue();
	}
	
	/**
	 * 提供精确的加法运算。
	 * @param b1  被加数
	 * @param b2  加数
	 * @return 两个参数的和
	 */
	public static BigDecimal add(BigDecimal b1, BigDecimal b2) {
		return b1.add(b2);
	}

	/**
	 * 提供精确的减法运算。
	 * @param v1 被减数
	 * @param v2 减数
	 * @return 两个参数的差
	 */
	public static double sub(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return sub(b1, b2).doubleValue();
	}
	
	/**
	 * 提供精确的减法运算。
	 * @param b1  被减数
	 * @param b2 减数
	 * @return 两个参数的差
	 */
	public static BigDecimal sub(BigDecimal b1, BigDecimal b2) {
		return b1.subtract(b2);
	}

	/**
	 * 提供精确的乘法运算。
	 * @param v1 被乘数
	 * @param v2 乘数
	 * @return 两个参数的积
	 */
	public static double mul(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return mul(b1, b2).doubleValue();
	}
	
	/**
	 * 提供精确的乘法运算。
	 * @param b1 被乘数
	 * @param b2 乘数
	 * @return 两个参数的积
	 */
	public static BigDecimal mul(BigDecimal b1, BigDecimal b2) {
		return b1.multiply(b2);
	}

	/**
	 * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到 小数点以后10位，以后的数字四舍五入。
	 * @param v1 被除数
	 * @param v2 除数
	 * @return 两个参数的商
	 */
	public static double div(double v1, double v2) {
		return div(v1, v2, DEF_DIV_SCALE);
	}
	
	/**
	 * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到 小数点以后10位，以后的数字四舍五入。
	 * @param b1  被除数
	 * @param b2 除数
	 * @return 两个参数的商
	 */
	public static BigDecimal div(BigDecimal b1, BigDecimal b2) {
		return div(b1, b2, DEF_DIV_SCALE);
	}

	/**
	 * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指 定精度，以后的数字四舍五入。
	 * @param v1 被除数
	 * @param v2  除数
	 * @param scale 表示表示需要精确到小数点以后几位。
	 * @return 两个参数的商
	 */
	public static double div(double v1, double v2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return div(b1, b2, scale).doubleValue();
	}
	
	/**
	 * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指 定精度，以后的数字四舍五入。
	 * @param b1 被除数
	 * @param b2  除数
	 * @param scale 表示表示需要精确到小数点以后几位。
	 * @return 两个参数的商
	 */
	public static BigDecimal div(BigDecimal b1, BigDecimal b2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * 提供精确的小数位四舍五入处理。
	 * @param v 需要四舍五入的数字
	 * @param scale 小数点后保留几位
	 * @return 四舍五入后的结果
	 */
	public static double round(double v, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		BigDecimal b = new BigDecimal(Double.toString(v));
		BigDecimal one = new BigDecimal("1");
		return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
}
