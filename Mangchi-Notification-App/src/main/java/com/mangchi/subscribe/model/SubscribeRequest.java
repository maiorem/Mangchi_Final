package com.mangchi.subscribe.model;

public class SubscribeRequest {

	private String memberNick;
	private String token;
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
	@Override
	public String toString() {
		return "SubscribeRequest [memberNick=" + memberNick + ", token=" + token + "]";
	}
	
	
}
