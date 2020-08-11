package com.mangchi.donate.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mangchi.donate.dao.BoardDao;
import com.mangchi.donate.model.Board;

@Service
public class DonateListService {

	
	private BoardDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	public List<Board> getBoardList() {
		dao=template.getMapper(BoardDao.class);
		return dao.selectList();
	}

}
