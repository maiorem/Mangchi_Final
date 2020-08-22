package com.mangchi.subscribe.model;

public class NotificationCheckRequest {
	
	private String memberNick;
	private String title;
	private String token;
	public String getMemberNick() {
		return memberNick;
	}
	public void setMemberNick(String memberNick) {
		this.memberNick = memberNick;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	@Override
	public String toString() {
		return "NotificationCheckRequest [memberNick=" + memberNick + ", title=" + title + ", token=" + token + "]";
	}
	
	
	

}
