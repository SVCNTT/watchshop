$(document).ready(function() {
	var count = 0;
	//add category type
	 $('#type').blur(function(event) {
         var fname = $('#type').val();
         if(fname.length < 1){     	
         	$('#checkType').show();
         	$('#okType').hide();
         }else{
         	$('#okType').show();
         	$('#checkType').hide();
         	count++;
         }
     });
	 
	 //add category description
	 $('#description').blur(function(event) {
         var fname = $('#description').val();
         if(fname.length < 1){     	
         	$('#checkDescription').show();
         	$('#okDescription').hide();
         }else{
         	$('#okDescription').show();
         	$('#checkDescription').hide();
         	count++;
         }
     });
	 
	 $('#addCategory-btn').click(function(){
		 if(count < 2){
			 alert("Cannot save record !! please add category again !!");
		 }else{
			 alert("Save !!");
		 }
	 });
	
});