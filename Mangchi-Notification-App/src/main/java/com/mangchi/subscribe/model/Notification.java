package com.mangchi.subscribe.model;

public class Notification {
	
	private int noticeIdx;
	private String memberNick;
	private String token;
	private String keyword;
	private String regdate;

	public Notification() {
		
	}

	public Notification(String memberNick, String token, String keyword) {

		this.memberNick = memberNick;
		this.token = token;
		this.keyword = keyword;
	}


	public Notification(int noticeIdx, String memberNick, String token, String keyword, String regdate) {

		this.noticeIdx = noticeIdx;
		this.memberNick = memberNick;
		this.token = token;
		this.keyword = keyword;
		this.regdate = regdate;
	}

	public int getNoticeIdx() {
		return noticeIdx;
	}

	public void setNoticeIdx(int noticeIdx) {
		this.noticeIdx = noticeIdx;
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

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	
	
	
	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "Notification [noticeIdx=" + noticeIdx + ", memberNick=" + memberNick + ", token=" + token + ", keyword="
				+ keyword + ", regdate=" + regdate + "]";
	}

	
	

}
