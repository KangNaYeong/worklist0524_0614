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
				<td>��ȣ</td>
				<td>${content_view.bid }</td>
			</tr>
			<tr>
				<td>�ۼ���</td>
				<td>${content_view.bdate }</td>
			</tr>
			<tr>
				<td>��Ʈ</td>
				<td>${content_view.bhit }</td>
			</tr>
			<tr>
				<td>�̸�</td>
				<td>
					<input type="text" name="bname" value="${content_view.bname}">
				</td>
			</tr>
			<tr>
				<td>����</td>
				<td>
					<input type="text" name="btitle" value="${content_view.btitle }">
				</td>
			</tr>
			<tr>
				<td>����</td>
				<td>
					<input type="text" name="bcontent" value="${content_view.bcontent}">
				</td>
			</tr>
			
			<tr>
				<td>
					<input type="submit" value="����">
					<a href="delete?bid=${content_view.bid}">����</a>
					<a href="list">�������</a>
				</td>			
			</tr>
			
		</form>
	</table>
</body>
</html>