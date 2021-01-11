package com.jcomputerstudy.example.controller;

import java.security.Provider.Service;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jcomputerstudy.example.domain.Board;
import com.jcomputerstudy.example.domain.Pagination;
import com.jcomputerstudy.example.domain.Reply;
import com.jcomputerstudy.example.domain.User;
import com.jcomputerstudy.example.service.BoardService;
import com.jcomputerstudy.example.service.UserService;

@org.springframework.stereotype.Controller
public class Controller {
	
	public final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired UserService userservice;
	@Autowired BoardService boardservice;
	
			
	
	@RequestMapping("/")
	public String home(Model model) {
		
		List<Board> list = boardservice.selectBoardList();
		model.addAttribute("list", list);
//		logger.debug("debug");
//		logger.info("info");
//		logger.error("error");
//		
		return "/index";
	}
	
	@RequestMapping("/beforeSignUp")
	public String beforeSignUp() {
		return "/signup";
	}
	
	@RequestMapping("/signup")
	public String signup(User user) {
		// 비밀번호 암호화
		String encodedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
		
		// 유저 데이터 셋팅
		user.setPassword(encodedPassword);
		user.setAccountNonExpired(true);
		user.setEnabled(true);
		user.setAccountNonLocked(true);
		user.setCredentialsNonExpired(true);
		user.setAuthorities(AuthorityUtils.createAuthorityList("ROLE_USER"));
		
		//유저 생성
		userservice.createUser(user);

		// 유저 권한 생성
		userservice.createAuthorities(user);
		
		return "/login";
	}
	
	@RequestMapping(value="/login")
	public String beforeLogin(Model model) {
		return "/login";
	}
	
	@Secured({"ROLE_ADMIN"})
		@RequestMapping(value="/admin")
		public String admin(Model model) {
		return "/admin";
	}
	
	@Secured({"ROLE_USER"})
	@RequestMapping(value="/user/info")
	public String userInfo(Model model) {
		return "/user_info";
	}
	
	@RequestMapping(value="/denied")
	public String denied(Model model) {
		return "/denied";
	}
	
	// 게시물 목록
	@RequestMapping("/board/list")
	public String list(Model model) {
		List<Board> list =  boardservice.selectBoardList();
		int boardCount = boardservice.boardCount();
		
		model.addAttribute("list", list);
		model.addAttribute("boardCount", boardCount);
		// 모델은 컨트롤러와 뷰를 연결해주는 역할을 함
		return "/board/list";
	}
	// 게시물 작성 (작성폼을 띄우는 것)
	@RequestMapping(value="/board/write", method=RequestMethod.GET)
	public String write(Model model, Board Board) {
	
		return "/board/write"; 
	}
	
	// 게시물 작성(내용을 리스트로 보내는 부분)
	@RequestMapping(value="/board/write-process", method=RequestMethod.POST)
	public String writeProcess(Model model, Board board) {
		
		// 게시물 생성
		boardservice.write(board);
		return "redirect:/board/list"; 
	}
	
	// 게시물 조회
	@RequestMapping(value="/board/view", method=RequestMethod.GET)
	public String view(int bId, Model model) {
		Board board = boardservice.view(bId);
		
		model.addAttribute("board", board);
		
		// 댓글 조회
		List<Reply> reply = boardservice.replyList(bId); 
		model.addAttribute("reply", reply);
		
		return "/board/view";	
	}
	// 댓글 작성
	@RequestMapping(value="/board/replyWrite", method=RequestMethod.POST)
	public String replyWrite(Reply reply, Model model) {
		boardservice.replyWrite(reply);
		return "redirect:/board/view?bId=" + reply.getrId();
	}
	
	
	// 게시물 수정
	@RequestMapping(value="/board/modify", method=RequestMethod.GET)
	public String modify(Model model,int bId) {
		
		Board board = boardservice.view(bId);
		
		model.addAttribute("board", board);
		return "/board/modify";
		
	}
	
	// 게시물 수정
	@RequestMapping(value="/board/modify-process", method=RequestMethod.POST)
	public String modifyProcess(Board board) {
		
		boardservice.modify(board);
		return "redirect:/board/list?bId=" + board.getbId();
	}
	
	// 게시물 삭제
	@RequestMapping(value="/board/delete", method=RequestMethod.GET)
	public String delete(int bId, Model model) {
		boardservice.delete(bId);
		
		return "redirect:/board/list";
	}
	
	// 게시물 페이징
	@RequestMapping(value="/board/listPage", method=RequestMethod.GET)
	public String listPage(Pagination pagination, Model model, 
			@RequestParam(value="page", required=false) int page,
			@RequestParam(value="search", required=false, defaultValue="bTitle") String search,
			@RequestParam(value="keyword", required=false, defaultValue="") String keyword) {
		
		int boardCount = boardservice.boardCount();
		
		pagination = new Pagination(boardCount, page);
		pagination.setSearch(search);
		pagination.setKeyword(keyword);
		
		List<Board> list = boardservice.listPage(pagination);
		
		model.addAttribute("list", list);
		model.addAttribute("boardCount", boardCount);
		model.addAttribute("pagination", pagination);
		
		return "/board/listPage";
	}
	
	// 게시물 검색
	@RequestMapping(value="/board/search", method=RequestMethod.GET)
	public String search( Model model, Pagination pagination,
			@RequestParam(value="page", required=false) int page, 
			@RequestParam(value="search", required=false, defaultValue="bTitle") String search,
			@RequestParam(value="keyword", required=false, defaultValue="") String keyword) {
		
		int boardCount = boardservice.boardCount();
		int pageNum = (page -1)*3;
		
		
		pagination = new Pagination(boardCount, page);
	
		model.addAttribute("pagination","pagination");
		model.addAttribute("select", page);
		
		
		return "/board/listPage";
		
	}
	
	// 답글 띄우는 폼
	@RequestMapping(value="/board/writeForm", method=RequestMethod.GET)
	public String writeForm(Model model, Board Board) {
	
		return "/board/writeForm"; 
	}
	// 답글 작성폼
	@RequestMapping(value="/board/writeFormPro", method=RequestMethod.POST)
	public String writeFormPro(Model model, Board board) {
		System.out.println(board);
		boardservice.writeForm(board);
		
		return "redirect:/board/list";
	}
	
}
