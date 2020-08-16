package com.mangchi.donate.dao;

import java.util.List;
import java.util.Map;

import com.mangchi.donate.model.Board;

public interface BoardDao {

	List<Board> selectList(Map search);
	
	int totalCount(Map search);

	Board selectViewByIdx(int idx);

	int insertDonate(Board donate);

	int deleteBoard(int idx);

	int plusViewCnt(int num, int donateIdx);

	int selectCntByIdx(int donateIdx);

	String getImg(String doImg);


}
