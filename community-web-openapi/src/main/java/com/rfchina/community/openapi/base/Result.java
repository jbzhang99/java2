package com.rfchina.community.openapi.base;

import java.io.Serializable;

import com.rfchina.community.base.exception.WorkRunTimeException;

/**
 */
public class Result<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer code = 0;

	private String msg = "";

	private T data = null;

	public Result(Integer code, String msg, T data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public Result(Integer code, String msg) {
		this.code = code;
		this.msg = msg;

	}

	public Result(Integer code) {
		this.code = code;

	}

	public Result() {
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg!=null? msg:"";
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public static <T> Result<T> create(Integer code, String msg, T data) {
		return new Result<T>(code, msg, data);
	}

	public static <T> Result<T> success(String msg) {
		return new Result<T>(StatusCode.SUCCESS.value(), msg);
	}

	public static <T> Result<T> success() {
		return success("操作成功!");
	}

	public static <T> Result<T> successData(T data) {
		return create(StatusCode.SUCCESS.value(), "OK", data);
	}

	public static <T> Result<T> create(Integer code, String msg) {
		return new Result<T>(code, msg);
	}
	
	public static void error(String msg) {
		throw new WorkRunTimeException(msg);
	}

	@Override
	public String toString() {
		return "Result{" +
				"code=" + code +
				", msg='" + msg + '\'' +
				", data=" + data +
				'}';
	}
}
