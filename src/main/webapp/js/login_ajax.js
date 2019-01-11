//authorize login
$(document).ready(function() {
	    $('#login').click(function(){
	    	var user = $('#username').val();
	    	var pass = $('#password').val();
	    	$.post('LoginServ',{
	    		username : user,
	    		password : pass
	    		
	    	}, function(result) {
	    		if(result == "fail"){
	    			$('#loginDiv').effect("shake");
	    			$('#uncorrect').show();
	    		}else{
	    			window.location.href = 'index_admin.jsp';
	    		}
	    	});
	    });   
});