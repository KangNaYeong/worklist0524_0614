<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table width="500" border="1">
		<form method="post" action="modify">
			<input type="hidden" name="bid" value="${content_view.bid}">
			<tr>
				<td>번호</td>
				<td>${content_view.bid }</td>
			</tr>
			<tr>
				<td>작성일</td>
				<td>${content_view.bdate }</td>
			</tr>
			<tr>
				<td>히트</td>
				<td>${content_view.bhit }</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>
					<input type="text" name="bname" value="${content_view.bname}">
				</td>
			</tr>
			<tr>
				<td>제목</td>
				<td>
					<input type="text" name="btitle" value="${content_view.btitle }">
				</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>
					<input type="text" name="bcontent" value="${content_view.bcontent}">
				</td>
			</tr>
			
			<tr>
				<td>
					<input type="submit" value="수정">
					<a href="delete?bid=${content_view.bid}">삭제</a>
					<a href="list">목록으로</a>
				</td>			
			</tr>
			
		</form>
	</table>
</body>
</html>