package com.jcomputerstudy.example.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;
import com.jcomputerstudy.example.domain.Board;
import com.jcomputerstudy.example.domain.Pagination;
import com.jcomputerstudy.example.domain.Reply;
import com.jcomputerstudy.example.mapper.BoardMapper;

@Service("BoardServiceImpl")
public class BoardServiceImpl implements BoardService {
	
	
	@Autowired BoardMapper boardmapper;
	
	//게시물 목록
	@Override
	public List<Board> selectBoardList() {
		// TODO Auto-generated method stub
		return boardmapper.selectBoardList();
	}
	
	// 게시물 작성
	@Override
	public void write(Board board) {
		// TODO Auto-generated method stub
		board.setbGroupOrd(1);
		boardmapper.write(board);
		board.setbGroup(board.getbId());
		boardmapper.updatebGroup(board);
	}
	// 게시물 목록
	@Override
	public Board view(int bId) {
		return boardmapper.view(bId);
	}
	// 게시물 수정
	@Override
	public void modify(Board board) {
		boardmapper.modify(board);
	}
	// 게시물 삭제
	@Override
	public void delete(int bId) {
		boardmapper.delete(bId);
	}
	// 게시물 총 갯수
	@Override
	public int boardCount() {
		return boardmapper.boardCount();
	}
	// 게시물 페이징 + 검색
	@Override
	public List<Board> listPage(Pagination page) {
		return boardmapper.listPage(page);
	}
	
	// 댓글 조회
	@Override
	public List<Reply> replyList(int r_id) {
		return boardmapper.replyList(r_id);
	}
	// 댓글 작성
	@Override
	public void replyWrite(Reply reply) {
		boardmapper.replyWrite(reply);
	}
	// 댓글 수정
	@Override
	public void modify(Reply reply) {
		boardmapper.modify(reply);
	}
	// 댓글 삭제
	@Override
	public void delete(Reply reply) {
		boardmapper.delete(reply);
	}
	
	//답글
	@Override
	public void writeForm(Board board) {
		int groupOrdMax = boardmapper.max(board)+1;
		/*board.setbGroupOrd(bGroupOrd);*/
		
		board.setbGroupOrd(groupOrdMax);
		boardmapper.writeForm(board);
		/*board.setbGroupOrd(board.getbGroup());
		boardmapper.updatebGroupOrd(board);*/

	}
	
//	@Override
//	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//		String name = authentication.getUsername();
//		String password = authentication.getCredentials().toString();
//		
//		if(username.equals("b_writer"))
//	}
}