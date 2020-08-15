package com.mangchi.donate.model;

import java.util.List;

public class BoardListView {
	
	private int messageTotalCount; //게시글 전체
	private int currentPageNumber; // 현재 페이지 번호
	private int messagePerPage;	// 페이지당 행
	private int pageTotalCount;		//전체 페이지 수
	private int startrow;	//시작 행

	private List<Board> boardList;

	public BoardListView(int messageTotalCount, int currentPageNumber, int messagePerPage,
			int startrow, List<Board> boardList) {
		this.messageTotalCount = messageTotalCount;
		this.currentPageNumber = currentPageNumber;
		this.messagePerPage = messagePerPage;
		this.startrow = startrow;
		this.boardList = boardList;
		calTotalPageCount();
	}
	
	private void calTotalPageCount() {
		if(messageTotalCount==0) {
			pageTotalCount=0;
		} else {
			pageTotalCount=messageTotalCount/messagePerPage;
			if(messageTotalCount%messagePerPage>0) {
				pageTotalCount++;
			}
		}
	}

	public int getMessageTotalCount() {
		return messageTotalCount;
	}

	public int getCurrentPageNumber() {
		return currentPageNumber;
	}

	public int getMessagePerPage() {
		return messagePerPage;
	}

	public int getPageTotalCount() {
		return pageTotalCount;
	}

	public int getStartrow() {
		return startrow;
	}

	public List<Board> getBoardList() {
		return boardList;
	}

	@Override
	public String toString() {
		return "BoardListView [messageTotalCount=" + messageTotalCount + ", currentPageNumber=" + currentPageNumber
				+ ", messagePerPage=" + messagePerPage + ", pageTotalCount=" + pageTotalCount + ", startrow=" + startrow
				+ ", boardList=" + boardList + "]";
	}
	
	
	
}
