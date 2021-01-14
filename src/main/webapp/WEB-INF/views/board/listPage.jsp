<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	a {
		text-decoration:none;
		color:#000;
		font-weight:700;
	}
	
	.pagination {
		width:600px;
		heigth:50px;
		margin:10px auto;
	}
	.pagination li {
		list-style:none;
		width:50px;
		line-height:50px;
		border:1px solid #ededed;
		float:left;
		text-align:center;
		margin:0 5px;
		border-radius:5px;
	}
</style>

<body>
<h1>게시판</h1>
<div id="nav">
	<%@ include file="../include/nav.jsp" %>
</div>

	<!-- 검색창 -->
 	<div align="right">
 		<form id="searchForm" action="/board/listPage" method="GET">
 			<select name="search">
 				<option value="bTitle">제목</option>
 				<option value="bContent">내용</option>
 				<option value="bTitle_bContent">제목+내용</option>
 				<option value="bWriter">작성자</option>
 			</select>
 			<input type="text" name="keyword" value="${pagination.keyword }"/>
 			
 			<input type="hidden" name="page" value="${pagination.page }"/>
 			<input type="hidden" name="boardCount" value="${pagination.boardCount }"/>
 			<button type="button" id="searchBtn">검색</button>
 		</form>
 		
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
		
		<c:forEach  items="${list}" var="list">
	      	<tr>
	      		<td>${list.bId }</td>
	      		<td> 
	      			<a href="/board/view?bId=${list.bId }">${list.bTitle}</a>
	      		</td>
	      		<td>${list.bContent }</td>
	      		<td>${list.bWriter }</td>
	      		<td>${list.bView }</td>
	      	</tr>
      	</c:forEach>
      </table>
      
      <!-- 아래부터 페이지네이션 -->
      <input type="button" value="글쓰기" style="float:right;" onclick="location.href='/board/write'"><br>
      <div>
      	<ul class="pagination">
      		<c:choose>
      			<c:when test="${pagination.prevPage >= 5 }">
      				<li>
      					<a href="/board/listPage?page=${pagination.prevPage }">
      						◀
      					</a>
      				</li>
      			</c:when>
      		</c:choose>
  
      		<c:forEach  var="p" begin="${pagination.startPage }" end="${pagination.endPage}">
				<c:choose>
					<c:when test="${p == pagination.page }">
						<li style = "background-color:#ededed;">
							<span>${p }</span>
						</li>
					</c:when>
					<c:when test="${p != pagination.page }">
						<li>
							<a href="/board/listPage?page=${p}&search=${pagination.search}&keyword=${pagination.keyword}">${p }</a>
						</li>
					</c:when>
				</c:choose>
			</c:forEach>
			
			 <c:choose>
				<c:when test="${ pagination.nextPage <= pagination.lastPage }">
					<li style="">
						<a href="/board/listPage?page=${pagination.nextPage}">▶</a>
					</li>
				</c:when>
				
			</c:choose> 
			
			
 		</ul>
 	</div>
 	
 	<script>
		document.getElementById("searchBtn").onclick = function(){
			let search = document.getElementsByName("search")[0].value;
			let keyword = document.getElementsByName("keyword")[0].value;

			location.href="/board/listPage?page=1" + "&search=" + search + "&keyword=" + keyword;
		};
 	</script>
 
 	
</body>
</html>