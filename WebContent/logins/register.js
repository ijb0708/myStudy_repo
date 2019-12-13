$(document).ready(function(){
	$("#process").click(function(){//[가입하기]버튼 클릭
		  var query = {
				  id:$("#id").val(), 
				  pwd:$("#pwd").val(),
				  scial_num:$("#scial_num").val(),
				  email:$("#email").val(),
			      name:$("#name").val(),
			      address:$("#address").val(),
			      tel:$("#tel").val()
			      
		  };
		  $.ajax({
		      type:"POST",
		      url:"/jsp_test/Register.do",
		      data:query,
		      success:function(data){

		    	  $("#check").text("가입되었습니다.");
		 
		 	  }
		  });
	});
	
	$("#cancle").click(function(){//[취소]버튼 클릭
		alert("취소");
		window.location.href("/jsp_test/index.do");
	});

 });

