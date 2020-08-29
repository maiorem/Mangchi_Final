package com.mangchi.donate.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Board {
	
	private int donateIdx;
	private String writer;	
	private String title;
	private String content;
	private String doImg;
	private String doLoc;
	private Date doDate;
	private int doViewCnt;
	private int doParents;
	private int doDepth;
	private int doStatus;
	
	public Board() {}

	public Board(String writer, String title, String content) {
		this.writer = writer;
		this.title = title;
		this.content = content;
	}
	
	
	
	
	public Board(String writer, String title, String content, String doLoc) {
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.doLoc = doLoc;
	}
	
	

	public Board(int donateIdx, String writer, String title, String content, String doImg, String doLoc, int doStatus) {

		this.donateIdx = donateIdx;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.doImg = doImg;
		this.doLoc = doLoc;
		this.doStatus = doStatus;
	}

	public Board(int donateIdx, String writer, String title, String content, String doImg, String doLoc, Date doDate,
			int doViewCnt, int doParents, int doDepth, int doStatus) {
		this.donateIdx = donateIdx;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.doImg = doImg;
		this.doLoc = doLoc;
		this.doDate = doDate;
		this.doViewCnt = doViewCnt;
		this.doParents = doParents;
		this.doDepth = doDepth;
		this.doStatus = doStatus;
	}

	public int getDonateIdx() {
		return donateIdx;
	}

	public void setDonateIdx(int donateIdx) {
		this.donateIdx = donateIdx;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDoImg() {
		return doImg;
	}

	public void setDoImg(String doImg) {
		this.doImg = doImg;
	}

	public String getDoLoc() {
		return doLoc;
	}

	public void setDoLoc(String doLoc) {
		this.doLoc = doLoc;
	}
	
	
	public Date getDoDate() {
		return doDate;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	public void setDoDate(Date doDate) {
		this.doDate = doDate;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	public java.util.Date getToDate() {
		return new java.util.Date(doDate.getTime());
	}


	public int getDoViewCnt() {
		return doViewCnt;
	}

	public void setDoViewCnt(int doViewCnt) {
		this.doViewCnt = doViewCnt;
	}

	public int getDoParents() {
		return doParents;
	}

	public void setDoParents(int doParents) {
		this.doParents = doParents;
	}

	public int getDoDepth() {
		return doDepth;
	}

	public void setDoDepth(int doDepth) {
		this.doDepth = doDepth;
	}

	public int getDoStatus() {
		return doStatus;
	}

	public void setDoStatus(int doStatus) {
		this.doStatus = doStatus;
	}

	@Override
	public String toString() {
		return "Board [writer=" + writer + ", title=" + title + ", content=" + content + ", doImg=" + doImg + "]";
	}

	
	
	
	

}
