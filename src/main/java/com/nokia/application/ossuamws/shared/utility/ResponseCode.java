package com.nokia.application.ossuamws.shared.utility;

import java.time.LocalDateTime;

public class ResponseCode {
	
	private Integer responseCode;
	private String message;
	private String action;
	private LocalDateTime timestamp;
	private Object obj;
	
	

	public ResponseCode() {
	
	}

	public ResponseCode(String message2) {
		// TODO Auto-generated constructor stub
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Integer getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(Integer responseCode) {
		this.responseCode = responseCode;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime localDateTime) {
		this.timestamp = localDateTime;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
}

