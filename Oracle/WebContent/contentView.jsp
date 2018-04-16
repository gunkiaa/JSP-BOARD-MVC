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
	width: 100%;
	border: 1px solid gray;
}

table td, th {
	border: 1pt solid black;
	text-align: center;
}

table th {
	width: 50%;
	background-color: gray;
	color: white;
}

#nae {
	background-color: #cecece
}

#title {
	border: 3pt solid black;
	height: 40px;
}

#content {
	height: 300px;
}
</style>
<body>
	<center>
		<table>
			<tr>
				<th>번호</th>
				<td id="nae">${contentView.bId}</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td id="nae">${contentView.bName}</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td id="nae">${contentView.bDateTime}</td>
			</tr>
			<tr>
				<th>조회수</th>
				<td id="nae">${contentView.bHit}</td>
			</tr>
			<tr>
				<td id="title" colspan="2">${contentView.bTitle}</td>
			</tr>
			<tr>
				<td id="content" colspan="2">${contentView.bContent}</td>
			</tr>
		</table>
		<div align="right">
			<a href="modify.do?idx=${contentView.bId}"><button>수정</button></a> <a
				href="delete.do?idx=${contentView.bId}"><button>삭제</button></a>
		</div>
	</center>
</body>
</html>