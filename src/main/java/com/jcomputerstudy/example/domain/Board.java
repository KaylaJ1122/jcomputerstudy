package com.jcomputerstudy.example.domain;

import java.util.Date;

public class Board extends Pagination {
	private int bId;			// 글번호(PK)
	private String bTitle;		// 글제목
	private String bContent;	// 글내용
	private String bWriter;		// 글작성자
	private String bDateTime;	// 글등록시간
	private int bView;			// 글상세보기
	
	// 계층형 게시판 답글 
	private int bGroup; 	// 원글번호(답글을 단 원래글의 번호)
	private int bGroupOrd;	// 원글(답글포함)에 대한 순서(그룹내의 순서)=seq
	private int bDepth;	// 답글 계층(원글에대한건지,답글에대한건지구분하는 계층)=|v|, 답글의 답글
	
	public int getbId() {
		return bId;
	}
	public void setbId(int bId) {
		this.bId = bId;
	}
	public String getbTitle() {
		return bTitle;
	}
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	public String getbContent() {
		return bContent;
	}
	public void setbContent(String bContent) {
		this.bContent = bContent;
	}
	public String getbWriter() {
		return bWriter;
	}
	public void setbWriter(String bWriter) {
		this.bWriter = bWriter;
	}
	public String getbDateTime() {
		return bDateTime;
	}
	public void setbDateTime(String bDateTime) {
		this.bDateTime = bDateTime;
	}
	
	public int getbView() {
		return bView;
	}
	public void setbView(int bView ) {
		this.bView = bView;
	}
	public int getbGroup() {
		return bGroup;
	}
	public void setbGroup(int bGroup) {
		this.bGroup = bGroup;
	}
	public int getbGroupOrd() {
		return bGroupOrd;
	}
	public void setbGroupOrd(int bGroupOrd) {
		this.bGroupOrd = bGroupOrd;
	}
	public int getbDepth() {
		return bDepth;
	}
	public void setbDepth(int bDepth) {
		this.bDepth = bDepth;
	}
	
	
}