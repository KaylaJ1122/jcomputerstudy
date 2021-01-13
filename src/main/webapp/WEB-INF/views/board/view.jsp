<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 조회</title>
</head>
<body>
<sec:authentication property="principal" var="user"/>
<p>${user }</p>
<div id="nav">
	<%@ include file="../include/nav.jsp" %>
</div>

<form method="post">
	<label>제목</label> <!-- value="${board.bTitle }"여기에서 board는 컨트롤로의 key 값이라 동일하게 설정 -->
	<input type="text" name="bTitle" value="${board.bTitle }"/><br/>
	
	<label>작성자</label>
	<input type="text" name="bWriter" value="${board.bWriter }"/><br/>
	
	<label>내용</label>
	<textarea cols="50" rows="5" name="bContent">${board.bContent }</textarea><br/>

	<div> <!-- 조회페이지에서 수정페이지로 이동 -->
		
		<a href="/board/modify?bId=${board.bId}">수정</a>
		<a href="/board/delete?bId=${board.bId}">삭제</a>
		<a href="/board/writeForm?bId=${board.bId }">답글</a>
	</div>
	

</form>

<!-- 댓글시작부분 -->
	<hr/>
	<ul>
		<c:forEach items="${reply }" var="reply">
			<li>
				<div>
					<p>${reply.username } / <fmt:formatDate value="${reply.rDateTime}" pattern="yyyy-MM-dd"/></p>
					<p>${reply.rContent }</p>
				</div>
			</li>
		</c:forEach>
	</ul>
	
	
	<div>
		<form method="post" action="/board/replyWrite">
			<!-- <p>
				<label>댓글작성자</label>
				<input type="text">
			</p> -->
			<p>
				<textarea rows="5" cols="50" name="rContent"></textarea>
			</p>
			<p>
				<input type="hidden" name="rId" value="${board.bId }">
				<input type="hidden" name="username" value="${user.username }">
				<button type="submit">댓글작성</button>
			</p>	
		</form>
	</div>
<!-- 댓글 끝부분 -->
</body>
</html>