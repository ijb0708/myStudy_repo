
$('#loginButton').click(function() {
	$.ajax({
		url:'/users/login',
		type:'POST',
		dataType:'json',
		data: {
			userId:$('#inputId').val(),
			passWd:$('inputPasswd').val()
		}
	})
	.done(function(data) {
		console.log('success');
	})
	.fail(function(log) {
		console.log('error : ' + log);
	})
})
