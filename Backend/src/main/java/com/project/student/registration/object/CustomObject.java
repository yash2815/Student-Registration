package com.project.student.registration.object;

import com.project.student.registration.entity.Student;

public class CustomObject<T> {
	
	private int statusCode;
	private T data;
	private String responseMessage;
	
	
	public CustomObject(int statusCode, T data, String responseMessage) {
		super();
		this.statusCode = statusCode;
		this.data = data;
		this.responseMessage = responseMessage;
	}


	public CustomObject() {
		super();
	}


	public int getStatusCode() {
		return statusCode;
	}


	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}


	public T getData() {
		return data;
	}


	public void setData(T data) {
		this.data = data;
	}


	public String getResponseMessage() {
		return responseMessage;
	}


	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	
	

}
