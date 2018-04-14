<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script language="JavaScript" src="board.js"></script>
<style>
table {
	/* width: 100%; */
	border: 1px solid gray;
}

table td {
	border-bottom: 1px solid gray;
}
</style>
<body>
	<center>
		<table>
			<tr>
				<th>번호</th>
				<td>${contentView.bId}</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${contentView.bName}</td>
			</tr>
<%-- 			<tr>
				<th>작성일</th>
				<td>${contentView.bDate}</td>
			</tr> --%>
			<tr>
				<th>제목</th>
				<td>${contentView.bTitle}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>${contentView.bContent}</td>
			</tr>
		</table>
	</center>
</body>
</html>