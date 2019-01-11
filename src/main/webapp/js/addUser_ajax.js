$(document).ready(function() {
	//check full name
	var count = 0;
	 $('#fullname2').blur(function(event) {
         var fname = $('#fullname2').val();
         if(fname.length < 6){     	
         	$('#checkFullname2').show();
         	$('#okFname2').hide();
         }else{
         	$('#okFname2').show();
         	$('#checkFullname2').hide();
         	count++;
         }
     });
	//check user name
        $('#username2').blur(function(event) {
                var name = $('#username2').val();
                if(name.length < 1){            	
                	$('#okUser2').hide();
                	$('#checkUsername2').hide();
                	$('#checkEmptyUser2').show();
                }else{
	                	 $.post('UserValidServ', {
	                         username : name
	                 }, function(result) {
	                         if(result == "valid"){
	                        	$('#checkEmptyUser2').hide(); 
	                         	$('#okUser2').show();
	                         	$('#checkUsername2').hide();
	                         	count++;
	                         }else{
	                        	 $('#checkEmptyUser2').hide();
	                         	$('#checkUsername2').show();
	                         	$('#okUser2').hide();
	                         }
	                 });
                }
               
        });
        
        //check password
        $('#password2').blur(function(event) {
            var pass = $('#password2').val();
            if(pass.length	< 6){         	
            	$('#checkPassword2').show();
            	$('#okPass2').hide();
            }else{
            	$('#okPass2').show();
            	$('#checkPassword2').hide();
            	count++;
            }
        });
        
        //check email
        $('#email2').blur(function(event) {
            var mail = $('#email2').val();
            if(mail.length < 1){            	
            	$('#okEmail2').hide();
            	$('#checkEmail2').hide();
            	$('#checkEmptyEmail2').show();
            }else{
	            $.post('EmailValidServ', {
	                    email : mail
	            }, function(result) {
	                    if(result == "valid"){
	                    	$('#checkEmptyEmail2').hide();
	                    	$('#okEmail2').show();
	                    	$('#checkEmail2').hide();
	                    	
	                    }else{
	                    	$('#checkEmptyEmail2').hide();
	                    	$('#checkEmail2').show();
	                    	$('#okEmail2').hide();
	                    	
	                    }
	            });
	            count++;
            }
            
    });
        
//      //authorize login
//	    $('#login').click(function(){
//	    	var user = $('#username').val();
//	    	var pass = $('#password').val();
//	    	$.post('LoginServ',{
//	    		username : user,
//	    		password : pass
//	    		
//	    	}, function(result) {
//	    		if(result == "fail"){
//	    			$('#loginDiv').effect("shake");
//	    			$('#uncorrect').show();
//	    		}else{
//	    			window.location.href = 'index.jsp';
//	    		}
//	    	});
//	    });   
//	    
	  //sign up
	    $('#signup-btn').click(function(){
	    	if(count < 4){
	    		//$('#user-popup').show();
	    		//$('signup-table').effect("shake");
	    		alert("Could not save record !! Please sign up again !!");
	    		window.location.herf = 'index.jsp';
	    	}else{
	    		alert("Saved!!");
	    	}
		});   
	    
	    
	    
	    
	    
});