package com.mangchi.donate.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mangchi.donate.dao.BoardDao;
import com.mangchi.donate.model.Board;

@Service
public class DonateViewService {

	private BoardDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	
	public Board getViewByidx(int idx) {
		dao=template.getMapper(BoardDao.class);
		return dao.selectViewByIdx(idx);
		
	}
}
