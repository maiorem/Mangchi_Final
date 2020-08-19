package com.mangchi.subscribe.dao;

import com.mangchi.subscribe.model.Notification;

public interface NotificationDao {

	int insertKeyword(Notification keyword);

	String selectKeyByMember(String memberNick);

	int deleteKeyword(int noticeIdx);

}
