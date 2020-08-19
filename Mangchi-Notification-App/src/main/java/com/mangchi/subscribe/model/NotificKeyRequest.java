package com.mangchi.subscribe.model;

public class NotificKeyRequest {
	
	private String noticeUser;
	private String noticeKeyword;
	private Long noticeToken;
	
	public String getNoticeUser() {
		return noticeUser;
	}
	public void setNoticeUser(String noticeUser) {
		this.noticeUser = noticeUser;
	}
	public String getNoticeKeyword() {
		return noticeKeyword;
	}
	public void setNoticeKeyword(String noticeKeyword) {
		this.noticeKeyword = noticeKeyword;
	}
	
	public Long getToken() {
		return noticeToken;
	}
	public void setToken(Long noticeToken) {
		this.noticeToken = noticeToken;
	}
	@Override
	public String toString() {
		return "NotificKeyRequest [noticeUser=" + noticeUser + ", noticeKeyword=" + noticeKeyword + ", noticeToken=" + noticeToken
				+ "]";
	}
	
	
	

}
