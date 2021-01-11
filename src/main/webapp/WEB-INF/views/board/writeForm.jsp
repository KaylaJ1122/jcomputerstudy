<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<title>게시판</title>
</head>
<body>

<form method="post" name="writeform" action="/board/writeFormPro" >
	<label>제목</label>
	<input type="text" name="bTitle"/><br/>
	
	<label>작성자</label>
	<input type="text" name="bWriter"/><br/>
	
	<label>내용</label>
	<textarea cols="50" rows="5" name="bContent"></textarea><br/>

	
	<input type="hidden" name="bGroup" value="${board.bId }">
	<input type="hidden" name="bGroupOrd" value="${board.bGroupOrd }">
	<input type="hidden" name="bDepth" value="${board.bDepth }">
	<button type="submit">답글작성</button>
	<input type="reset" value="다시작성">
	
</form>
 
</body>
</html>