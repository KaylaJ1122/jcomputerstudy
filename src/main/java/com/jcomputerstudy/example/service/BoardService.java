package com.jcomputerstudy.example.service;

import java.util.List;
import com.jcomputerstudy.example.domain.Board;
import com.jcomputerstudy.example.domain.Pagination;
import com.jcomputerstudy.example.domain.Reply;

import org.springframework.security.core.GrantedAuthority;


public interface BoardService {
	// 게시물 목록
	public List<Board> selectBoardList();
	// 게시물 작성
	public void write (Board board);
	// 게시물 조회
	public Board view(int bId);
	// 게시물 수정
	public void modify(Board board);
	// 게시물 삭제
	public void delete(int bId);
	// 게시물 총 갯수
	public int boardCount();
	// 게시물 페이징 + 검색
	public List<Board> listPage(Pagination page);
	
	// 댓글 조회
	public List<Reply> replyList(int r_id);
	// 댓글 작성
	public void replyWrite(Reply reply);
	// 댓글 수정
	public void modify(Reply reply);
	// 댓글 삭제
	public void delete(Reply reply);
	
	// 답글
	public void writeForm(Board board);
	
	

	

	
}
