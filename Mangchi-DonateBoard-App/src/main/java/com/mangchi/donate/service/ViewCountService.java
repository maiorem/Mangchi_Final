package com.mangchi.donate.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mangchi.donate.dao.BoardDao;

@Service
public class ViewCountService {
	
	private BoardDao dao;
	
	@Autowired
	private SqlSessionTemplate template;

	public int cntView(int donateIdx) {
		dao=template.getMapper(BoardDao.class);
		int viewCnt=dao.selectCntByIdx(donateIdx);
		System.out.println("이전 조회수 : "+viewCnt);
		viewCnt+=1;
		
		return dao.plusViewCnt(viewCnt, donateIdx);
	}

}
