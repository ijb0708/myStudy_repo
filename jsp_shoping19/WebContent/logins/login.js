$(document).ready(function() {
	$("#login").click(function() {
		var query = {
			id : $("#id").val(),
			pwd : $("#pwd").val()
		};

		$.ajax({
			type : "POST",
			url : "/jsp_test/login.do",
			data : query,
			success : function(data) {
 alert("daf");
				$("#check").text("로그인되었습니다.");

			}

		});
	});
});
