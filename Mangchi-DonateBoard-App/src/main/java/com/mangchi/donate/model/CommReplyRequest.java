package com.mangchi.donate.model;

public class CommReplyRequest {
	
	private int donateIdx;
	private int commParent;
	private int commDepth;
	private String commWriter;
	private String commText;


	public CommReplyRequest() {
		
	}


	public CommReplyRequest(int donateIdx, int commParent, int commDepth, String commWriter, String commText) {
		this.donateIdx = donateIdx;
		this.commParent = commParent;
		this.commDepth = commDepth;
		this.commWriter = commWriter;
		this.commText = commText;
	}


	public int getDonateIdx() {
		return donateIdx;
	}


	public void setDonateIdx(int donateIdx) {
		this.donateIdx = donateIdx;
	}


	public int getCommParent() {
		return commParent;
	}


	public void setCommParent(int commParent) {
		this.commParent = commParent;
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


	
	
	
	public int getCommDepth() {
		return commDepth;
	}


	public void setCommDepth(int commDepth) {
		this.commDepth = commDepth;
	}


	@Override
	public String toString() {
		return "CommReplyRequest [donateIdx=" + donateIdx + ", commParent=" + commParent + ", commDepth=" + commDepth
				+ ", commWriter=" + commWriter + ", commText=" + commText + "]";
	}
	
	
	
}
