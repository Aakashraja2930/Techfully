package com.ticketbooking.util;

public class ResponseData <T> {
	
	private Integer code;
	
	private String message;
	
	private T data;
	
	public ResponseData() {
		super();
	}

	public ResponseData(Integer code, String message, T data) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
	}
	
	public ResponseData(Integer code, String message) {
		super();
		this.message = message;
		this.data = data;
		
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	

}
