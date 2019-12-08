$(document).ready(function(){
$("#login").click(function(){
var query = {id : $("id").val(),
passwd:$("#passwd").val()};

$.ajax({
	type:"POST",
	url:"/jsp_test/login.do",
	data:query,

});
});
});

