package com.mangchi.donate.service;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mangchi.donate.dao.DonateCommentDao;
import com.mangchi.donate.model.CommentListView;
import com.mangchi.donate.model.Comments;

@Service
public class DonateCommentListService {

	private DonateCommentDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	private final int COMMENTS_COUNT_PER_PAGE=10;

	
	//한 게시글에 있는 댓글 리스트
	public CommentListView getCommList(int donateIdx, HttpServletRequest request) {
		dao=template.getMapper(DonateCommentDao.class);
		
		CommentListView commListView=null;
		List<Comments> commList=null;
		
		int commTotalCount=dao.commTotalCount(donateIdx);
		System.out.println("현 게시물 전체 댓글 수 : "+commTotalCount);
		int startrow=0;
		int currentPage=1;
		String page=request.getParameter("page");
		System.out.println("코멘트 파라미터 페이지 :"+page);
		
		if(page!=null) {
			currentPage=Integer.parseInt(page);
		}
		
		if(commTotalCount>0) {
			startrow=(currentPage-1)*COMMENTS_COUNT_PER_PAGE;
			commList=dao.getCommList(donateIdx, startrow, COMMENTS_COUNT_PER_PAGE);
			
		} else {
			currentPage=0;
			commList=Collections.emptyList();
		}
		System.out.println("코멘트 현재페이지 : "+currentPage);
		System.out.println("코멘트 리스트"+commList);
		
		commListView=new CommentListView(commTotalCount, currentPage, COMMENTS_COUNT_PER_PAGE, startrow, commList);
		
		
		return commListView;
	}
	


}
