$(document).ready(function() {
	var count = 0;
	//add category type
	 $('#type2').blur(function(event) {
         var type = $('#type2').val();
         if(type.length < 1){     	
         	$('#checkType2').show();
         	$('#okType2').hide();
         }else{
         	$('#okType2').show();
         	$('#checkType2').hide();
         	count++;
         }
     });
	 
	 //add category description
	 $('#description2').blur(function(event) {
         var des = $('#description2').val();
         if(des.length < 1){     	
         	$('#checkDescription2').show();
         	$('#okDescription2').hide();
         }else{
         	$('#okDescription2').show();
         	$('#checkDescription2').hide();
         	count++;
         }
     });
	 
	 $('#editCategory-btn').click(function(){
		 if(count > 0){
			 alert("Save !!");
			 
		 }else{
			 alert("Cannot save record !! please update category again !!");
		 }
	 });
	
});