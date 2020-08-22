package com.mangchi.subscribe.model;

public class SubscribeCheckRequest {
	
	private String memberNick;
	private String token;
	private String title;
	
	public String getMemberNick() {
		return memberNick;
	}
	public void setMemberNick(String memberNick) {
		this.memberNick = memberNick;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "SubscribeCheckRequest [memberNick=" + memberNick + ", token=" + token + ", title=" + title + "]";
	}
	
	
	
}
