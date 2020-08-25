package com.mangchi.subscribe.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mangchi.subscribe.dao.NotificationDao;

@Service
public class CheckSubsribeService {
	
	private NotificationDao dao;
	
	@Autowired
	private SqlSessionTemplate template;

	public int subsribeCheck(String memberNick) {
		dao=template.getMapper(NotificationDao.class);
		return dao.countCheckSubsribe(memberNick);
	}

}