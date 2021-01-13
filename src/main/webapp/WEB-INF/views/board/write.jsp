<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 작성</title>
</head>
<body>
<sec:authentication property="principal" var="user"/>
<div id="nav">
	<%@ include file="../include/nav.jsp" %>
</div>

<form method="post" action="/board/write-process">
	
	<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token } }"/>

	<label>제목</label>
	<input type="text" name="bTitle"/><br/>
	
	<!--  <label>작성자</label>-->
	<input type="hidden" name="bWriter" value="${user.uName }"/><br/>
	
	<label>내용</label>
	<textarea cols="50" rows="5" name="bContent"></textarea><br/>
	
	
	
	<button type="submit">작성</button>
	
</form>

</body>
</html>