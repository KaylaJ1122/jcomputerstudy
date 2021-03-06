<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 수정</title>
</head>
<body>
<div id="nav">
	<%@ include file="../include/nav.jsp" %>
</div>

<form method="post" action="/board/modify-process">
	
	<input type="hidden" name="bId" value="${board.bId }"/>
	<!-- <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token } }"/> -->
	<label>제목</label>
	<input type="text" name="bTitle" value="${board.bTitle }"/><br/>
	
	<label>작성자</label>
	<input type="text" name="bWriter" value="${board.bWriter }"/><br/>
	
	<label>내용</label>
	<textarea cols="50" rows="5" name="bContent">${board.bContent}</textarea><br/>
	
	<button type="submit">완료</button>
	
</form>

<div>
	<sec:authorize access="isAuthenticated()">
		<sec:authentication property="principal" var="principal"/>
		<h2>${principal }</h2>
	</sec:authorize>
	
</div>

</body>
</html>