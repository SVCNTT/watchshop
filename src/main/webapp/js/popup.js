$(document).ready(function(){
	//user popup
	$("#addUser-popup").click(function(){
		$("#user-popup").show();
	});
	$("#cancel-btn").click(function(){
		$("#user-popup").hide();
	});
	$("#cancelEdit-btn").click(function(){
		$("#edit-popup").hide();
	});
	
	
	//product popup
	$("#addProduct-popup").click(function(){
		$("#product-popup").show();
	});
	
	$("#cancelproduct-btn").click(function(){
		$("#product-popup").hide();
	});
	$('#cancelEditproduct-btn').click(function(){
		$('#Editproduct-popup').hide();
	})
	
	
	//category popup
	$("#addCategory-popup").click(function(){
		$("#category-popup").show();
	});
	
	$("#cancelCate-btn").click(function(){
		$("#category-popup").hide();
	});
	$("#cancelCateEdit-btn").click(function(){
		$("#categoryEdit-popup").hide();
	});
	
	
});

//edit user popup
function editUser(id){
	//$("#editUser-popup").click(function(){
	$.post('EditUser',{
		id : id,
		
	}, function(result) {
		var arr = result.split("|");
		//console.log(arr);
		$('input#idUser').val(arr[0]);
		$('input#fullname').val(arr[1]);
		$('input#username').val(arr[2]);
		$('input#password').val(arr[3]);
		$('input#email').val(arr[4]);
	});
	$("#edit-popup").show();
	//});
}

//edit category popup
function editCate(id){
	$.post('EditCategory',{
		id : id,
		
	}, function(result) {
		var arr = result.split("|");
		//console.log(arr);
		$('input#idCate').val(arr[0]);
		$('input#type2').val(arr[1]);
		$('input#description2').val(arr[2]);
	});
	$("#categoryEdit-popup").show();
	//});
}

//edit product popup
function editProduct(id){
	$.post('EditProduct',{
		id : id,
		
	}, function(result) {
		var arr = result.split("|");
		//console.log(arr);
		$('input#idProduct').val(arr[0]);
		$('input#productName2').val(arr[1]);
		$('input#productPrice2').val(arr[3]);
		$('input#productImg3').val(arr[4]);
	});
	$("#Editproduct-popup").show();
	//});
}


