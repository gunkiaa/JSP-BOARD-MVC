<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.Date"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="dto.BoardDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판</title>
<style>
table {
	border: 1px solid gray;
	width: 100%;
}

table th, td {
	border: 1px solid gray;
	text-align: center;
}

table th {
	background-color: gray;
	color: white;
}

#nav_menu ul {
	list-style-type: none;
	/* 좌측 여백 없애기 */
	padding-left: 0px;
	/* 우측 정렬 하기 */
	float: right;
}

#nav_menu ul li {
	display: inline;
	border-left: 1px solid #c0c0c0;
	/* 테두리와 메뉴 간격 벌리기. padding: 위 오른쪽 아래 왼쪽; */
	padding: 0px 10px 0px 10px;
	/* 메뉴와 테두리 사이 간격 벌리기. margin: 위 오른쪽 아래 왼쪽; */
	margin: 5px 0px 5px 0px;
}

#nav_menu ul li:first-child {
	border-left: none;
}
</style>
<div id="nav_menu">
	<ul>
		<li><a href="#">로그인</a></li>
		<li><a href="#">회원가입</a></li>
	</ul>
</div>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th style="width: 5%;">번호</th>
				<th style="width: 68%;">제목</th>
				<th style="width: 10%;">작성자</th>
				<th style="width: 10%;">날짜</th>
				<th style="width: 7%;">조회수</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="dto">
				<tr>
					<td>${dto.bId}</td>
					<td><a href="contentView.do?idx=${dto.bId}">${dto.bTitle}</a></td>
					<td>${dto.bName}</td>
					<td>${dto.bDate}</td>
					<td>${dto.bHit}</td>
					<td><a href="delete.do?idx=${dto.bId}"><button>삭제</button></a></td>
				</tr>
			</c:forEach>
			<%-- 			<%
				ArrayList<BoardDTO> list = (ArrayList<BoardDTO>) request.getAttribute("list");

				int bId = 0;
				String bTitle = "";
				String bName = "";
				String bDate = null;
				int bHit = 0;
				for (BoardDTO dto : list) {
					bId = dto.getbId();
					bTitle = dto.getbTitle();
					bName = dto.getbName();
					bDate = dto.getbDate();
					bHit = dto.getbHit();
			%>
			<tr>
				<td><%=bId%></td>
			</tr>
			<%
				}
			%> --%>
		</tbody>
	</table>
	<div align="right">
		<a href="writing.jsp"><button>글쓰기</button></a>
	</div>
</body>
</html>