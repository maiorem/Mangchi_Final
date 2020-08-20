package com.mangchi.subscribe.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mangchi.subscribe.dao.NotificationDao;
import com.mangchi.subscribe.model.Subscribe;
import com.mangchi.subscribe.model.SubscribeRequest;

@Service
public class SubsribeRegService {
	
	private NotificationDao dao;
	
	@Autowired
	private SqlSessionTemplate template;

	public int subscriberReg(SubscribeRequest subRequest) {
		dao=template.getMapper(NotificationDao.class);
		Subscribe sub=new Subscribe(subRequest.getMemberNick(), subRequest.getToken());
		
		return dao.regSubscriber(sub);
	}

}
