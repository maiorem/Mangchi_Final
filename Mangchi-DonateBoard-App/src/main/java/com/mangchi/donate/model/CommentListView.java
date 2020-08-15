package com.mangchi.donate.model;

import java.util.List;

public class CommentListView {
	
	private int commTotalCount; //댓글 전체
	private int currentPageNumber; // 현재 페이지 번호
	private int commPerPage;	// 페이지당 행
	private int pageTotalCount;		//전체 페이지 수
	private int startrow;	//시작 행
	
	private List<Comments> commList;

	public CommentListView(int commTotalCount, int currentPageNumber, int commPerPage, int startrow,
			List<Comments> commList) {
		this.commTotalCount = commTotalCount;
		this.currentPageNumber = currentPageNumber;
		this.commPerPage = commPerPage;
		this.startrow = startrow;
		this.commList = commList;
		calTotalPageCount();
	}
	
	private void calTotalPageCount() {
		if(commTotalCount==0) {
			pageTotalCount=0;
		} else {
			pageTotalCount=commTotalCount/commPerPage;
			if(commTotalCount%commPerPage>0) {
				pageTotalCount++;
			}
		}
	}

	public int getCommTotalCount() {
		return commTotalCount;
	}

	public int getCurrentPageNumber() {
		return currentPageNumber;
	}

	public int getCommPerPage() {
		return commPerPage;
	}

	public int getPageTotalCount() {
		return pageTotalCount;
	}

	public int getStartrow() {
		return startrow;
	}

	public List<Comments> getCommList() {
		return commList;
	}

	@Override
	public String toString() {
		return "CommentListView [commTotalCount=" + commTotalCount + ", currentPageNumber=" + currentPageNumber
				+ ", commPerPage=" + commPerPage + ", pageTotalCount=" + pageTotalCount + ", startrow=" + startrow
				+ ", commList=" + commList + "]";
	}

	
	
	
}
