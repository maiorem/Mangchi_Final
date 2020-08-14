package com.mangchi.donate.model;

public class CommWriteRequest {
	
	private int donateIdx;
	private String commWriter;
	private String commText;
	
	public CommWriteRequest() {
	
	}


	public CommWriteRequest(int donateIdx, String commWriter, String commText) {
		this.donateIdx = donateIdx;
		this.commWriter = commWriter;
		this.commText = commText;
	}


	public int getDonateIdx() {
		return donateIdx;
	}


	public void setDonateIdx(int donateIdx) {
		this.donateIdx = donateIdx;
	}


	public String getCommWriter() {
		return commWriter;
	}


	public void setCommWriter(String commWriter) {
		this.commWriter = commWriter;
	}


	public String getCommText() {
		return commText;
	}


	public void setCommText(String commText) {
		this.commText = commText;
	}


	@Override
	public String toString() {
		return "CommWriteRequest [donateIdx=" + donateIdx + ", commWriter=" + commWriter + ", commText=" + commText
				+ "]";
	}

	
	
	
}

