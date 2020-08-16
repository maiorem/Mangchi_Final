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
		System.out.println("대댓글 요청 =========> "+replyRequest);
		Comments reComm=new Comments(replyRequest.getDonateIdx(), replyRequest.getCommWriter(), replyRequest.getCommText(), replyRequest.getCommParent(), replyRequest.getCommDepth()+1);
		System.out.println("방금 쓴 대댓글 =======> "+reComm);		
		return dao.reply(reComm);
	}

}
