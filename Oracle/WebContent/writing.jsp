<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="board.js"></script>
</head>
<style>
table {
	width: 600px;
	border: 1px solid gray;
}
</style>
<body>
	<form name="wr_form" action="writing.do" method="post">
		<center>
			<table>
				<thead>
				<caption>
					<h1>글쓰기</h1>
				</caption>
				</thead>
				<tbody>
					<tr>
						<th>작성자</th>
						<td><input name="name" placeholder="이름을 입력해주세요." type="text" style="width: 30%;" maxlength="6" />
					</tr>
					<tr>
						<th>제목</th>
						<td><input name="title" placeholder="제목을 입력해주세요." type="text" style="width: 70%;" maxlength="25" />
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea name="content" placeholder="내용을 입력해주세요." style="width: 89%;" rows="30" maxlength="150"></textarea></td>
					</tr>
				</tbody>
			</table>
			<input type="button" value="완료" onclick="writingPro()"/>
		</center>
	</form>
</body>
</html>