package com.mangchi.subscribe.model;

public class NotificKeyRequest {
	
	private String memberNick;
	private String keyword;
	private String token;
	public String getMemberNick() {
		return memberNick;
	}
	public void setMemberNick(String memberNick) {
		this.memberNick = memberNick;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	@Override
	public String toString() {
		return "NotificKeyRequest [memberNick=" + memberNick + ", keyword=" + keyword + ", token=" + token + "]";
	}

	
	
	
	

}
