package com.mangchi.donate.model;

import org.springframework.web.multipart.MultipartFile;

public class BoardWriteRequest {
	
	private String title;
	private String contents;
	
	private MultipartFile img;
	
	private String imgPath;
	
	public BoardWriteRequest() {
	
	}

	public BoardWriteRequest(String title, String contents, String imgPath) {
		this.title = title;
		this.contents = contents;
		this.imgPath = imgPath;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public MultipartFile getImg() {
		return img;
	}

	public void setImg(MultipartFile img) {
		this.img = img;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	@Override
	public String toString() {
		return "BoardWriteRequest [title=" + title + ", contents=" + contents + ", img=" + img + ", imgPath=" + imgPath
				+ "]";
	}
	
	
	
	
}
