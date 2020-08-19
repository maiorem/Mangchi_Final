package com.mangchi.subscribe.service;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mangchi.subscribe.dao.NotificationDao;
import com.mangchi.subscribe.model.NotificKeyRequest;
import com.mangchi.subscribe.model.Notification;

@Service
public class NotificationService {
	
	private NotificationDao dao;
	
	@Autowired
	private SqlSessionTemplate template;

	public int insertKeyword(NotificKeyRequest notReqesut) {
		dao=template.getMapper(NotificationDao.class);
		Notification keyword=new Notification(notReqesut.getNoticeUser(), notReqesut.getToken(), notReqesut.getNoticeKeyword());
		
		return dao.insertKeyword(keyword);
	}

 
}
