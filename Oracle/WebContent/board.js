function writingPro(){
	var form = document.wr_form;
	
	if(form.title.value == ""){
		alert("제목을 입력해주세요.");
		return;
	}
	if(form.content.value == ""){
		alert("내용을 입력해주세요.");
		return;
	}
}