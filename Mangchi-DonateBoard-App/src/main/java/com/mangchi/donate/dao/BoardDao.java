package com.mangchi.donate.dao;

import java.util.List;

import com.mangchi.donate.model.Board;

public interface BoardDao {

	List<Board> selectList();

	Board selectViewByIdx(int idx);

	int insertDonate(Board donate);

}
