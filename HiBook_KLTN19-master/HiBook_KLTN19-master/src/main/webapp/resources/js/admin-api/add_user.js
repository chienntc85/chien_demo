$(document).ready(function getlistaddbook() {
	
	var url_string = window.location.href;
	var vars = url_string.split("/");
	var idUser = vars[vars.length-1];
	var them=true;
	
    /* Get Role*/
	$("#birthday").datepicker();
	$("#birthday").datepicker('setDate', new Date());
    $.ajax({
    	type : "GET",
    	url : "/HiBook_KLTN19/api/v1/roles"
    }).then(function(data) {
    	var role = '';    	
    	$.each(data, function (i, item) {	 	
    		role+='<option value="'+item.idRole+'">'+item.nameRole+'</option>';
        });
    	$('#role').append(role);
    });
    
    if(idUser!=''&&idUser!='add-user'){
		$.ajax({
	    	type : "GET",
	    	url : "/HiBook_KLTN19/api/v1/users/"+idUser
	    }).then(function(data) {
	    	$('#nameUser').val(data.nameUser);
	    	$('#numberphone').val(data.numberphone);
	    	$('#email').val(data.email);
	    	$('#password').val('');
	    	$(".row_role").css('display',"none");
	    	if(data.sex==0){
	    		$('input:radio[name=sex][value=0]').attr('checked', true);
	    		$('input:radio[name=sex][value=1]').attr('checked', false);
	    	}else{
	    		$('input:radio[name=sex][value=1]').attr('checked', true);
	    		$('input:radio[name=sex][value=0]').attr('checked', false);
	    	}
	    	$('#birthday').datepicker('setDate',data.birthday);
	    	$('#address').val(data.address);
	    });
		them=false;
	}
    
    $('#submit-user').click(function(){
    	var nameUser=$('#nameUser').val();
    	var numberphone=$('#numberphone').val();
    	var email=$('#email').val();
    	var password=$('#password').val();
    	var sex=$('#sex input:checked').val();
    	var birthday=$('#birthday').datepicker('getDate');
    	var formatted = (birthday.getMonth() + 1)+"/"+birthday.getDate()+"/"+birthday.getFullYear();
    	var address=$('#address').val();
    	
    	if(them==true){
	    	var role=$('#role option:selected').val();
			$.ajax({
				url : "/HiBook_KLTN19/api/v1/users",
		    	type : "POST",
		    	data:{
		    		nameUser:nameUser,
		    		numberphone:numberphone,
		    		email:email,
		    		password:password,
		    		role:role,
		    		sex:sex,
		    		birthday:formatted,
		    		address:address
		    	},
		    	success : function(data) {
		    		alert("Thêm thành công!!!");
		    		window.location = 'manage-user';
		        },
		    	statusCode: {
		    	    404: function() {
		    	      alert('404 page not found');
		    	    },
		
		    	    400: function() {
		    	       alert('400 bad request');
		    	   }
		    	}
			});
    	}else{
	    	alert(nameUser+formatted);
			$.ajax({
				url : "/HiBook_KLTN19/api/v1/users/"+idUser,
		    	type : "PUT",
		    	data:JSON.stringify({
		    		nameUser:nameUser,
		    		numberphone:numberphone,
		    		email:email,
		    		password:password,
		    		sex:sex,
		    		birthday:formatted,
		    		address:address
		    	}),
		    	headers: {
	        	      'Accept': 'application/json',
	        	      'Content-Type': 'application/json'
	        	},
		    	success : function(data) {
		    		alert("Chỉnh sửa thành công!!!");
		    		window.location = '/HiBook_KLTN19/manage-user';
		        },
		    	statusCode: {
		    	    404: function() {
		    	      alert('404 page not found');
		    	    },
		
		    	    400: function() {
		    	       alert('400 bad request');
		    	   }
		    	}
			});
    	}
    });
    
});
