package com.mangchi.subscribe.dao;

import java.util.List;

import com.mangchi.subscribe.model.Notification;
import com.mangchi.subscribe.model.Subscribe;

public interface NotificationDao {

	int insertKeyword(Notification keyword);

	List<Notification> selectKeyByMember(String memberNick);

	int deleteKeyword(int noticeIdx);

	int regSubscriber(Subscribe sub);

	int countTrue(String memberNick);

	List<String> selectKeyword(String memberNick);

	int deleteSubscribe(String memberNick);

	int countCheckSubsribe(String memberNick);

}
