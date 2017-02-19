package com.cmcc.exception;

/*
 * 自定义异常
 */
public class MyException extends Exception {

	private static final long serialVersionUID = 8892112310310366031L;

	private String url;
	private String message;
	
	public MyException(String url, String message) {
		super();
		this.url = url;
		this.message = message;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
