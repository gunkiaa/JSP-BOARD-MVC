<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="board.js?ver1"></script>
</head>
<style>
table {
	width: 600px;
	border: 1px solid gray;
}

input, textarea {
	font-size: 15pt;
}
</style>
<body>
	<form name="wr_form" action="modify_ok.do" method="post">
		<center>
			<table>
				<thead>
				<caption>
					<h1>수정</h1>
				</caption>
				</thead>
				<tbody>
					<tr>

						<td><input nmae="idx" type="hidden" value="${modify.bId}" /><input
							name="title" placeholder="제목을 입력해주세요." type="text"
							style="width: 70%;" maxlength="16" value="${modify.bTitle}" />
					</tr>
					<tr>
						<td><textarea name="content" placeholder="내용을 입력해주세요."
								style="width: 89%;" rows="20" maxlength="150">${modify.bContent}</textarea></td>
					</tr>
				</tbody>
			</table>
			<input type="button" value="완료" onclick="modifyPro()" />
		</center>
	</form>
</body>
</html>