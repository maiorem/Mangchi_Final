package com.mangchi.donate.model;

public class Comments {
	
	private int commIdx;
	private int donateIdx;
	private String commWriter;
	private String commText;
	private String commRegdate;
	private int commParent;
	private int commDepth;
	

	public Comments() {
	
	}




	public Comments(int donateIdx, String commWriter, String commText) {
		this.donateIdx = donateIdx;
		this.commWriter = commWriter;
		this.commText = commText;
	}
	
	


	public Comments(int commIdx, int donateIdx, String commWriter, String commText, String commRegdate, int commParent,
			int commDepth) {
		this.commIdx = commIdx;
		this.donateIdx = donateIdx;
		this.commWriter = commWriter;
		this.commText = commText;
		this.commRegdate = commRegdate;
		this.commParent = commParent;
		this.commDepth = commDepth;
	}




	public int getCommIdx() {
		return commIdx;
	}


	public void setCommIdx(int commIdx) {
		this.commIdx = commIdx;
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


	public String getCommRegdate() {
		return commRegdate;
	}


	public void setCommRegdate(String commRegdate) {
		this.commRegdate = commRegdate;
	}


	public int getCommParent() {
		return commParent;
	}


	public void setCommParent(int commParent) {
		this.commParent = commParent;
	}


	public int getCommDepth() {
		return commDepth;
	}


	public void setCommDepth(int commDepth) {
		this.commDepth = commDepth;
	}


	@Override
	public String toString() {
		return "Comments [commIdx=" + commIdx + ", donateIdx=" + donateIdx + ", commWriter=" + commWriter
				+ ", commText=" + commText + ", commRegdate=" + commRegdate + ", commParent=" + commParent
				+ ", commDepth=" + commDepth + "]";
	}
	
	
	
	

}
