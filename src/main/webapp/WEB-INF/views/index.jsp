<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Home Page</h1>
		<!-- 
	<table>
		<tr>
			<td>id</td>
			<td>title</td>
			<td>content</td>
			<td>writer</td>
		</tr>
		<c:forEach var="list" items="${list }">
	      	<tr>
	      		<td>${list.bId }</td>
	      		<td>${list.bTitle }</td>
	      		<td>${list.bContent }</td>
	      		<td>${list.bWriter }</td>
	      	</tr>
      	</c:forEach>
      	

      </table>
      -->
        <hr>
        <div>
           <sec:authorize access="isAnonymous()">
              <a href="/login">로그인</a> <br>
              <a href="/beforeSignup">회원가입</a>
           </sec:authorize>   
            <sec:authorize access="isAuthenticated()">
               <a href="/logout">로그아웃</a>
               <sec:authentication property="principal" var="principal"/>
               <h2>${principal }</h2>
            </sec:authorize>
            
        </div>
        <div>
         <sec:authorize access="isAuthenticated()">        
               <a href="/user/info">내 정보</a>
               <a href="/admin">관리자</a>
               
            </sec:authorize>
        </div>   
        
        <div>
        	<a href="/board/list">게시물 목록</a> <br>
        	<a href="/board/write">게시물 작성</a><br>
        	
        </div>

</body>
</html> 