<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="modify">
		<input type="hidden" name="bId" value="${modify_view.bId}"> 
		<table width="500" border="1">
			
			<tr>
				<td>글번호</td>
				<td>${modify_view.bId}</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${modify_view.bName}</td>
			</tr>
			<tr>
				<td>업로드 날짜</td>
				<td>${modify_view.bDate}</td>
				
			</tr>
			<tr>
				<td>조회수</td>
				<td>${modify_view.bHit}</td>
			</tr>
			<tr>
				<td>글제목</td>
				<td>
					<input type="text" name="bTitle" value="${modify_view.bTitle}">
				</td>
			</tr>
			<tr>
				<td>글내용</td>
				<td>
					<textarea rows="10"  name="bContent">${modify_view.bContent}</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="6">
					<input type="submit" value="수정">
					<a href="list">목록으로</a>
					
				</td>
			</tr>	
		</table>
	</form>
</body>
</html>