
$('#boardButton').click(function() {
	window.location.href = '/board';
})

$('#loginButton').click(function() {
	$.ajax({
		url:'/users/login',
		dataType: 'json',
		type:'POST',
		data: {
			userId:$('#inputId').val(),
			passWd:$('#inputPasswd').val()
		}
	})
	.done(function(data) {
		console.log('result: ' + retResult(data['result']));
		console.log('session: ' + sessionStorage.getItem("userName"));
		window.location.href = '/';
	})
	.fail(function(log) {
		console.log('error !!');
	});
});

$('#logOutButton').click(function() {
	$.ajax({
		url:'/users/logout',
		type:'GET'
	})
	.done(function(data) {
		console.log('result: ' + data['result']);
		window.location.href = '/';

	})
	.fail(function(log) {
		console.log('error !!');
	});
})

retResult =function(idx) {
	return {
		0:'not Found id',
		1:'wrong passwd',
		2:'success'
	}[idx];
};