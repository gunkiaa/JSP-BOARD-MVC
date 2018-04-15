function writingPro() {
	var form = document.wr_form;

	if (form.name.value == "") {
		alert("이름을 입력해주세요.");
		return;
	}
	if (form.title.value == "") {
		alert("제목을 입력해주세요.");
		return;
	}
	if (form.content.value == "") {
		alert("내용을 입력해주세요.");
		return;
	}
	form.submit();
}