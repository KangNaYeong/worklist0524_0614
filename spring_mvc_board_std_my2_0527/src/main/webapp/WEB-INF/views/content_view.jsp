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
				<td>�۹�ȣ</td>
				<td>
					${content_view.bId}
				</td>
			</tr>
			<tr>
				<td>�ۼ���</td>
				<td>
					${content_view.bName}
				</td>
			</tr>
			<tr>
				<td>������</td>
				<td>
					${content_view.bTitle}
				</td>
			</tr>
			<tr>
				<td>��¥</td>
				<td>
					${content_view.bDate}
				</td>
			</tr>
			<tr>
				<td>��ȸ��</td>
				<td>
					${content_view.bHit}
				</td>
			</tr>
			<tr>
				<td>�۳���</td>
				<td height="300">
					${content_view.bContent}
				</td>
			</tr>
			
			<tr>
				<td colspan="2">
					<a href="modify_view?bId=${content_view.bId}">����</a>
					<a href="delete?bId=${content_view.bId}">����</a>
					<a href="list">�������</a>
				</td>
			</tr>
			
		</table>
	
</body>
</html>