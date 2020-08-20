package com.mangchi.subscribe.model;

public class Subscribe {
	
	private int subscribeIdx;
	private String memberNick;
	private String token;
	private String regdate;
	
	public Subscribe() {
		
	}

	public Subscribe(String memberNick, String token) {
		this.memberNick = memberNick;
		this.token = token;
	}

	public Subscribe(int subscribeIdx, String memberNick, String token, String regdate) {
		this.subscribeIdx = subscribeIdx;
		this.memberNick = memberNick;
		this.token = token;
		this.regdate = regdate;
	}

	public int getSubscribeIdx() {
		return subscribeIdx;
	}

	public void setSubscribeIdx(int subscribeIdx) {
		this.subscribeIdx = subscribeIdx;
	}

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

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "Subscribe [subscribeIdx=" + subscribeIdx + ", memberNick=" + memberNick + ", token=" + token
				+ ", regdate=" + regdate + "]";
	}
	
	

}
