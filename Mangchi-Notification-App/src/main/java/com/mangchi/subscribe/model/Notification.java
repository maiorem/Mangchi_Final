package com.mangchi.subscribe.model;

public class Notification {
	
	private int noticeIdx;
	private String memberNick;
	private Long token;
	private String keyword;

	public Notification(String memberNick, Long token, String keyword) {

		this.memberNick = memberNick;
		this.token = token;
		this.keyword = keyword;
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

	public Long getToken() {
		return token;
	}

	public void setToken(Long token) {
		this.token = token;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "Notification [noticeIdx=" + noticeIdx + ", memberNick=" + memberNick + ", token=" + token + ", keyword="
				+ keyword + "]";
	}
	
	

}
