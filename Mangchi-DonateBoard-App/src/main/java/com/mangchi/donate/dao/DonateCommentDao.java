package com.mangchi.donate.dao;

import java.util.List;

import com.mangchi.donate.model.Comments;

public interface DonateCommentDao {

	List<Comments> getCommList(int donateIdx);

	int writeComm(Comments comm);

}
