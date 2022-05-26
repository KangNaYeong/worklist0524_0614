<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<table width="1000" border="1">
		<tr>
			<td>글번호</td>
			<td>작성자</td>
			<td>글제목</td>
			<td>업로드 날짜</td>
			<td>조회수</td>
		</tr>
	<c:forEach items="${list }" var="dto">
		<tr>
			<td>${dto.bId }</td>
			<td>${dto.bName }</td>
			<td>
				<a href="content_view?bId=${dto.bId}">${dto.bTitle }</a>
			</td>
			<td>${dto.bDate }</td>
			<td>${dto.bHit }</td>
		</tr>
	</c:forEach>
	
	<tr>
		<td>
			<a href="write_view">글작성</a>
		</td>
	</tr>	
	</table>
</body>
</html>