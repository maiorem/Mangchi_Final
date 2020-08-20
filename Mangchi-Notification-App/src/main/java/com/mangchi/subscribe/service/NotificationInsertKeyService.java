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
public class NotificationInsertKeyService {
	
	private NotificationDao dao;
	
	@Autowired
	private SqlSessionTemplate template;

	public int insertKeyword(NotificKeyRequest notReqesut) {
		System.out.println("키워드 등록 요청 ========> "+notReqesut);
		dao=template.getMapper(NotificationDao.class);
		Notification keyword=new Notification(notReqesut.getMemberNick(), notReqesut.getToken(), notReqesut.getKeyword());
		System.out.println("키워드 등록!!! ========> "+keyword);
		return dao.insertKeyword(keyword);
	}

 
}
