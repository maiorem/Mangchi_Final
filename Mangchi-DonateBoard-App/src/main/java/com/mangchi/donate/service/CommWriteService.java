package com.mangchi.donate.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mangchi.donate.dao.DonateCommentDao;
import com.mangchi.donate.model.CommWriteRequest;
import com.mangchi.donate.model.Comments;

@Service
public class CommWriteService {
	
	private DonateCommentDao dao;
	
	@Autowired
	private SqlSessionTemplate template;

	public int writeComments(CommWriteRequest writeRequest) {
		dao=template.getMapper(DonateCommentDao.class);
		Comments comm=new Comments(writeRequest.getDonateIdx(), writeRequest.getCommWriter(), writeRequest.getCommText());
				
		return dao.writeComm(comm);
	}

}
