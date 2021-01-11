package com.jcomputerstudy.example.domain;

import java.util.Date;

public class Reply {
	
	private int rRownum; 		// 댓글 고유번호
	private int rId; 			// 게시물 고유번호
	private String username;		// 댓글 작성자
	private String rContent;	// 댓글 내용
	private Date rDateTime;		// 댓글 작성 날짜
	
	// 댓글 작성시에 필요한 데이터 rId, rWriter, rContent 
	
	public int getrRownum() {
		return rRownum;
	}
	public void setrRownum(int rRownum) {
		this.rRownum = rRownum;
	}
	public int getrId() {
		return rId;
	}
	public void setrId(int rId) {
		this.rId = rId;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getrContent() {
		return rContent;
	}
	public void setrContent(String rContent) {
		this.rContent = rContent;
	}
	public Date getrDateTime() {
		return rDateTime;
	}
	public void setrDateTime(Date rDateTime) {
		this.rDateTime = rDateTime;
	}
	
	
}
	