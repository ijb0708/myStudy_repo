${"#insertButton"}.click(function() {

	if(${'#content'}.val() != "") {
		$.ajax({
			url:'',
			type:'get',
			dataType:'json',
			data:{
				content:${'#content'}.val()
			}
		}).done(function(data) {
			alert("보냈습니다.");
		}).fail(function(error) {
			alert("실패!");
		})
	}else {
		alert("글자를 입력해주세요!!")
	}
})