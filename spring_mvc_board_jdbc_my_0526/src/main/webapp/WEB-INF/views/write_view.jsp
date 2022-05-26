<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="write">
		<table width="500" border="1">
			<tr>
				<td>작성자</td>
				<td>
					<input type="text" size="50" name="bName">
				</td>
			</tr>
			
			<tr>
				<td>글제목</td>
				<td>
					<input type="text" size="50" name="bTitle">
				</td>
				
			</tr>
			<tr>
				<td>글내용</td>
				<td>
					<textarea rows="10" name="bContent"></textarea> 
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="입력">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>