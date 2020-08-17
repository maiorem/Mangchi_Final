package com.mangchi.donate.model;

import org.springframework.web.multipart.MultipartFile;

public class BoardEditRequest {
	
	private int donateIdx;
	private String writer;	
	private String title;
	private String content;
	private String doLoc;
	private int doStatus;
	
	private MultipartFile doImg;
	private String oldImg;
	
	
	
	
	public int getDoStatus() {
		return doStatus;
	}
	public void setDoStatus(int doStatus) {
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
	public String getDoLoc() {
		return doLoc;
	}
	public void setDoLoc(String doLoc) {
		this.doLoc = doLoc;
	}
	public MultipartFile getDoImg() {
		return doImg;
	}
	public void setDoImg(MultipartFile doImg) {
		this.doImg = doImg;
	}
	public String getOldImg() {
		return oldImg;
	}
	public void setOldImg(String oldImg) {
		this.oldImg = oldImg;
	}
	@Override
	public String toString() {
		return "BoardEditRequest [donateIdx=" + donateIdx + ", writer=" + writer + ", title=" + title + ", content="
				+ content + ", doLoc=" + doLoc + ", doStatus=" + doStatus + ", doImg=" + doImg.getOriginalFilename() + ", oldImg=" + oldImg
				+ "]";
	}


	
	
	
	

}
