package com.mangchi.donate.model;

public class Board {
	
	private int donateIdx;
	private int memberIdx;
	
	private String memberId;
	
	private String doTitle;
	private String doText;
	private String doImg;
	private String doLoc;
	private String doDate;
	private String doViewCnt;
	private int doParents;
	private int doDepth;
	private int doStatus;
	
	public Board() {}

	public Board(int memberIdx, String doTitle, String doText) {
		this.memberIdx = memberIdx;
		this.doTitle = doTitle;
		this.doText = doText;
	}

	public Board(int memberIdx, String doTitle, String doText, String doImg, String doLoc, String doViewCnt,
			int doParents, int doDepth, int doStatus) {
		this.memberIdx = memberIdx;
		this.doTitle = doTitle;
		this.doText = doText;
		this.doImg = doImg;
		this.doLoc = doLoc;
		this.doViewCnt = doViewCnt;
		this.doParents = doParents;
		this.doDepth = doDepth;
		this.doStatus = doStatus;
	}

	public Board(String memberId, String doTitle, String doText, String doImg, String doLoc, String doViewCnt,
			int doParents, int doDepth, int doStatus) {
		this.memberId = memberId;
		this.doTitle = doTitle;
		this.doText = doText;
		this.doImg = doImg;
		this.doLoc = doLoc;
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

	public int getMemberIdx() {
		return memberIdx;
	}

	public void setMemberIdx(int memberIdx) {
		this.memberIdx = memberIdx;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getDoTitle() {
		return doTitle;
	}

	public void setDoTitle(String doTitle) {
		this.doTitle = doTitle;
	}

	public String getDoText() {
		return doText;
	}

	public void setDoText(String doText) {
		this.doText = doText;
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

	public String getDoDate() {
		return doDate;
	}

	public void setDoDate(String doDate) {
		this.doDate = doDate;
	}

	public String getDoViewCnt() {
		return doViewCnt;
	}

	public void setDoViewCnt(String doViewCnt) {
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
		return "Board [donateIdx=" + donateIdx + ", memberIdx=" + memberIdx + ", memberId=" + memberId + ", doTitle="
				+ doTitle + ", doText=" + doText + ", doImg=" + doImg + ", doLoc=" + doLoc + ", doDate=" + doDate
				+ ", doViewCnt=" + doViewCnt + ", doParents=" + doParents + ", doDepth=" + doDepth + ", doStatus="
				+ doStatus + "]";
	}
	
	
	
	
	

}
