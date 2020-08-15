package com.mangchi.donate.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mangchi.donate.dao.BoardDao;
import com.mangchi.donate.model.Board;
import com.mangchi.donate.model.BoardListView;

@Service
public class DonateListService {

	
	private BoardDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	private final int MESSAGE_COUNT_PER_PAGE=12;

	
	public BoardListView getBoardList(HttpServletRequest request) {
		dao=template.getMapper(BoardDao.class);
		
		Map<String, Object> search=new HashMap<String, Object>();
		
		String searchKey=request.getParameter("searchKeyWord");
		System.out.println("검색 키워드 : "+searchKey);
		
		if(searchKey!=null && !searchKey.isEmpty()) {
			search.put("searchKey", searchKey);
		}
		
		BoardListView listView=null;
		List<Board> board=null;
		
		//전체 게시물 수
		int messageTotalCount=dao.totalCount(search);
		System.out.println("전체 게시물 수: "+messageTotalCount);
		int startrow=0;
		int currentPage=1;
		String page=request.getParameter("page");
		System.out.println("파라미터 페이지 :"+page);
		
		if(page!=null) {
			currentPage=Integer.parseInt(page);
		}
		
		if(messageTotalCount>0) {
			startrow=(currentPage-1)*MESSAGE_COUNT_PER_PAGE;
			search.put("startrow", startrow);
			search.put("count", MESSAGE_COUNT_PER_PAGE);
			
			board=dao.selectList(search);
			
		} else {
			currentPage=0;
			board=Collections.emptyList();
		}
		System.out.println("현재페이지 : "+currentPage);
		System.out.println("출력 되는 게시판 리스트 ===========> "+board);
		
		listView=new BoardListView(messageTotalCount, currentPage, MESSAGE_COUNT_PER_PAGE, startrow, board);
		System.out.println("페이지당 리스트 뷰 ============> "+listView);
		
		return listView;
	}

}
