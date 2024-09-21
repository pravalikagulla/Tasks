package com.example.demo.exception;

public class CustomException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	private String field;
	private String message;
	
	public CustomException(String field, String message) {
		super();
		this.field = field;
		this.message = message;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
