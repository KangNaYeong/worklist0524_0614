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
			<tr>
				<td>글번호</td>
				<td>
					${content_view.bId}
				</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>
					${content_view.bName}
				</td>
			</tr>
			<tr>
				<td>글제목</td>
				<td>
					${content_view.bTitle}
				</td>
			</tr>
			<tr>
				<td>날짜</td>
				<td>
					${content_view.bDate}
				</td>
			</tr>
			<tr>
				<td>조회수</td>
				<td>
					${content_view.bHit}
				</td>
			</tr>
			<tr>
				<td>글내용</td>
				<td height="300">
					${content_view.bContent}
				</td>
			</tr>
			
			<tr>
				<td colspan="2">
					<a href="modify_view?bId=${content_view.bId}">수정</a>
					<a href="delete?bId=${content_view.bId}">삭제</a>
					<a href="list">목록으로</a>
				</td>
			</tr>
			
		</table>
	
</body>
</html>