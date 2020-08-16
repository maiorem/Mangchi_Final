package com.mangchi.donate.model;

import org.springframework.web.multipart.MultipartFile;

public class BoardWriteRequest {
	
	private String writer;
	private String title;
	private String content;
	private String doLoc;
	
	private MultipartFile doImg;
	
	private String imgPath;
	
	public BoardWriteRequest() {
	
	}

	public BoardWriteRequest(String writer, String title, String content) {
		this.writer = writer;
		this.title = title;
		this.content = content;
	}
	
	

	public BoardWriteRequest(String writer, String title, String content, String doLoc) {

		this.writer = writer;
		this.title = title;
		this.content = content;
		this.doLoc = doLoc;
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


	
	

	public MultipartFile getDoImg() {
		return doImg;
	}

	public void setDoImg(MultipartFile doImg) {
		this.doImg = doImg;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	
	
	

	public String getDoLoc() {
		return doLoc;
	}

	public void setDoLoc(String doLoc) {
		this.doLoc = doLoc;
	}

	@Override
	public String toString() {
		return "BoardWriteRequest [writer=" + writer + ", title=" + title + ", content=" + content + ", doLoc=" + doLoc
				+ "]";
	}

	
	
	
	

	
	
	
}
