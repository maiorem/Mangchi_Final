package com.mangchi.donate.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mangchi.donate.dao.DonateCommentDao;
import com.mangchi.donate.model.CommReplyRequest;
import com.mangchi.donate.model.Comments;

@Service
public class CommReplyService {
	
	private DonateCommentDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	

	public int reply(CommReplyRequest replyRequest) {
		dao=template.getMapper(DonateCommentDao.class);
		Comments reComm=new Comments(replyRequest.getDonateIdx(), replyRequest.getCommWriter(), replyRequest.getCommText(), replyRequest.getCommParent(), replyRequest.getCommDepth()+1);
				
		return dao.reply(reComm);
	}

}
