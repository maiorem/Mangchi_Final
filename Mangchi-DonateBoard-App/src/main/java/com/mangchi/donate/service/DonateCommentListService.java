package com.mangchi.donate.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.mangchi.donate.dao.DonateCommentDao;
import com.mangchi.donate.model.Comments;

@Service
public class DonateCommentListService {

	private DonateCommentDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	//한 게시글에 있는 댓글 리스트
	public List<Comments> getCommList(int donateIdx) {
		dao=template.getMapper(DonateCommentDao.class);
		return dao.getCommList(donateIdx);
	}
	
	//댓글 달기
	
	
	//댓글의 댓글 달기
	
	
	//댓글 삭제
	
	//댓글 수정

}
