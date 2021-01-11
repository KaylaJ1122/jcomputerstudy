package com.jcomputerstudy.example.domain;

import com.jcomputerstudy.example.service.BoardService;

public class Pagination {
	int boardCount; // board테이블에 등록된 총 board수(=total)
	int page; 		// 현재 페이지번호
	int pageNum;	// boardCount/page=화면에 나타낼board index 번호
	int startPage; 	// pagination의 시작(ex. 1,6,11)
	int endPage;  	// pagination의 끝(ex. 5,10,15)
	int lastPage;	// (boardCount/화면에표시할개수), pagination 마지막 번호
	int prevPage;	// pagination의 이전 목록
	int nextPage;	// pagination의 다음 목록
	String search;	// 검색 타입
	String keyword;	// 검색 키워드

	public static final int pageUnit=5;//한번에 불러 올 pagination수
	public static final int perPage=3; //한번에 불러 올 boardCount 수

	
	public Pagination() {
		
	}
	public Pagination(int boardCount, int page) {
		this.page = page;
		this.pageNum = (page-1)*3;
		startPage = ((page-1)/pageUnit)*pageUnit+1;
		lastPage = (int) ((int)Math.ceil(boardCount)/(float)perPage);
		endPage = startPage+pageUnit-1;
		endPage = endPage < lastPage ? endPage : lastPage;
//		prevPage = (endPage = pageUnit);
		prevPage = startPage - 1;

		nextPage = (startPage + pageUnit);
		
	}
	public int getBoardCount() {
		return boardCount;
	}
	public void setBoardCount(int boardCount) {
		this.boardCount = boardCount;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getLastPage() {
		return lastPage;
	}
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	public int getPrevPage() {
		return prevPage;
	}
	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	public int getPageUnit() {
		return pageUnit;
	}

	public int getPerPage() {
		return perPage;
	}
	
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	@Override
	public String toString() {
		return "Pagination [boardCount=" + boardCount + ", page=" + page + ", pageNum=" + pageNum + ", startPage="
				+ startPage + ", endPage=" + endPage + ", lastPage=" + lastPage + ", prevPage=" + prevPage
				+ ", nextPage=" + nextPage + ", getBoardCount()=" + getBoardCount() + ", getPage()=" + getPage()
				+ ", getPageNum()=" + getPageNum() + ", getStartPage()=" + getStartPage() + ", getEndPage()="
				+ getEndPage() + ", getLastPage()=" + getLastPage() + ", getPrevPage()=" + getPrevPage()
				+ ", getNextPage()=" + getNextPage() + ", search=" + search + ", keyword=" + keyword + ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
		
	}
	
	
	

	
	
	
	
}
