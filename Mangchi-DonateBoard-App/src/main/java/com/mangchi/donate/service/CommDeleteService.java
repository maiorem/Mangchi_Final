package com.mangchi.donate.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mangchi.donate.dao.DonateCommentDao;

@Service
public class CommDeleteService {

	private DonateCommentDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	public int deleteMessage(int commIdx) {
		dao=template.getMapper(DonateCommentDao.class);
		return dao.deleteMessage(commIdx);
	}

}
