<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table width="1000" border="1">
		<tr>
			<td>글번호</td>
			<td>작성자</td>
			<td>글제목</td>
			<td>글내용</td>
			<td>업로드 날짜</td>
			<td>조회수</td>
		</tr>
	
		<tr>
			<td>${content_view.bId}</td>
			<td>${content_view.bName}</td>
			<td>${content_view.bTitle}</td>
			<td>${content_view.bContent}</td>
			<td>${content_view.bDate}</td>
			<td>${content_view.bHit}</td>
		</tr>
	
	<tr>
		<td colspan="6">
			<a href="modify_view?bId=${content_view.bId}">수정</a>
			<a href="list">목록으로</a>
			<a href="delete?bId=${content_view.bId}">삭제</a>
			
		</td>
	</tr>	
	</table>
</body>
</html>