$(document).ready(function() {
	//check full name
	var count = 0;
	 $('#fullname').blur(function(event) {
         var fname = $('#fullname').val();
         if(fname.length < 6){     	
         	$('#checkFullname').show();
         	$('#okFname').hide();
         }else{
         	$('#okFname').show();
         	$('#checkFullname').hide();
         	count++;
         }
     });
        
        //check password
        $('#password').blur(function(event) {
            var pass = $('#password').val();
            if(pass.length	< 6){         	
            	$('#checkPassword').show();
            	$('#okPass').hide();
            }else{
            	$('#okPass').show();
            	$('#checkPassword').hide();
            	count++;
            }
        });
        
        
      //edit up
	    $('#signupEdit-btn').click(function(){
	    	if(count > 0){
	    		//$('#user-popup').show();
	    		alert("Saved!!");
	    		
	    	}else{
	    		alert("Could not save record !! Please sign up again !!");
	    	}
		});   
        
      
});