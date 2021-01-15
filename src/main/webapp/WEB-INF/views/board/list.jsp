<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 목록</title>
</head>
<style>
	h1 {
		text-align:center;
	}
	table{
		border-collapse:collapse;
		margin:40px auto;
	}
	
	table tr th {
		font-weight:700;
	}
	table tr td, table tr th {
		border:1px solid #818181;
		width:200px;
		text-align:center;
	}
</style>

<body>
<h1>게시판</h1>
<div id="nav">
	<%@ include file="../include/nav.jsp" %>
</div>

	<table border="1">
		<tr> <!--전체 회원 수 -->
			<td colspan="10">전체 게시글 수 : ${boardCount}</td>
		</tr>
		
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>내용</th>
			<th>작성자</th>
			<th>조회수</th>
			
		</tr>
		
		<c:forEach var="list" items="${list }">
	      	<tr>
	      		<td>${list.bId }</td>
				<c:choose>
				    <c:when test="${list.bGroupOrd ne 1}">
					    <td> 
				      		<a href="/board/view?bId=${list.bId }">[답글]${list.bTitle}</a>
				      	</td>
				    </c:when>
				    <c:otherwise>
				        <td> 
				      		<a href="/board/view?bId=${list.bId }">${list.bTitle}</a>
				      	</td>
				    </c:otherwise>
				</c:choose>
	      		<td>${list.bContent }</td>
	      		<td>${list.bWriter }</td>
	      		<td>${list.bView }</td>
	      	</tr>
      	</c:forEach>
      </table>

</body>
</html>