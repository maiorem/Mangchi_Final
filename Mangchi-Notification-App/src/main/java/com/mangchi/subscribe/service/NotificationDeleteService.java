package com.mangchi.subscribe.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mangchi.subscribe.dao.NotificationDao;

@Service
public class NotificationDeleteService {

	private NotificationDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	public int deleteKey(int noticeIdx) {
		dao=template.getMapper(NotificationDao.class);
		
		return dao.deleteKeyword(noticeIdx);
	}

}
