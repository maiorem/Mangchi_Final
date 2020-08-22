package com.mangchi.subscribe.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mangchi.subscribe.dao.NotificationDao;
import com.mangchi.subscribe.model.Notification;

@Service
public class NotificationListService {
	
	private NotificationDao dao;
	
	@Autowired
	private SqlSessionTemplate template;

	public List<Notification> keywordByNick(String memberNick) {
		dao=template.getMapper(NotificationDao.class);
		return dao.selectKeyByMember(memberNick);
	}

}
