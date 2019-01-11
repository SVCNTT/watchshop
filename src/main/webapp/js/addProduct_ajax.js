$(document).ready(function() {
	var count = 0;
	//add product name
	 $('#productName').blur(function(event) {
         var pname = $('#productName').val();
         if(pname.length < 1){     	
         	$('#checkproductName').show();
         	$('#okproductName').hide();
         }else{
         	$('#okproductName').show();
         	$('#checkproductName').hide();
         	count++;
         }
     });
	 
	 //add product price
	 $('#productPrice').blur(function(event) {
         var pprice = $('#productPrice').val();
         if(pprice.length < 1){     	
         	$('#checkproductPrice').show();
         	$('#okproductPrice').hide();
         }else{
         	$('#okproductPrice').show();
         	$('#checkproductPrice').hide();
         	count++;
         }
     });
	 
	 $('#addproduct-btn').click(function(){
		 if(count < 2){
			 alert("Cannot save record !! please add product again !!");
			 //window.location.href = "http://localhost:8080/AdminPanel/ProductServ";
		 }else{
			 alert("Save !!");
		 }
	 });
	
});