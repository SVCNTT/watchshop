$(document).ready(function() {
	var count = 0;
	//add category type
	 $('#productName2').blur(function(event) {
         var type = $('#productName2').val();
         if(type.length < 1){     	
         	$('#checkproductName2').show();
         	$('#okproductName2').hide();
         }else{
         	$('#okproductName2').show();
         	$('#checkproductName2').hide();
         	count++;
         }
     });
	 
	 //add category description
	 $('#productPrice2').blur(function(event) {
         var des = $('#productPrice2').val();
         if(des.length < 1){     	
         	$('#checkproductPrice2').show();
         	$('#okproductPrice2').hide();
         }else{
         	$('#okproductPrice2').show();
         	$('#checkproductPrice2').hide();
         	count++;
         }
     });
	 
	 $('#editproduct-btn').click(function(){
		 if(count > 0){
			 alert("Save !!");
			 
		 }else{
			 alert("Cannot save record !! please update category again !!");
		 }
	 });
	
});