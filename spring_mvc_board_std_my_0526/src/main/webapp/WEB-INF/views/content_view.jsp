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
			<td>�۹�ȣ</td>
			<td>�ۼ���</td>
			<td>������</td>
			<td>�۳���</td>
			<td>���ε� ��¥</td>
			<td>��ȸ��</td>
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
			<a href="modify_view?bId=${content_view.bId}">����</a>
			<a href="list">�������</a>
			<a href="delete?bId=${content_view.bId}">����</a>
			
		</td>
	</tr>	
	</table>
</body>
</html>