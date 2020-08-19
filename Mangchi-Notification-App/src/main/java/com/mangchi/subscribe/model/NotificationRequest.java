package com.mangchi.subscribe.model;


public class NotificationRequest {

	private String title;
	private String message;
	private String token;

	public NotificationRequest(String title, String message, String token) {
	    this.title = title;
	    this.message = message;
	    this.token = token;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "NotificationRequest [title=" + title + ", message=" + message + ", token=" + token + "]";
	}
	
	                                                             
	

}
