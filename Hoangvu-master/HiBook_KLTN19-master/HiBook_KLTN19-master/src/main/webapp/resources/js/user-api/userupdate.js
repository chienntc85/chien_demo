$(document).ready(function() {
	$("#birthday").datepicker();
	var idUser= $('#myTabContent').data('id');
	
	$('#btn_LuuInfo').click(function(){
		var nameUser=$('#nameUser').val();
    	var numberphone=$('#numberphone').val();
    	var email=$('.profile-usertitle-job').text();
    	var password='';
    	var sex=$('.radio input:checked').val();
    	var birthday=$('#birthday').datepicker('getDate');
    	var formatted = (birthday.getMonth() + 1)+"/"+birthday.getDate()+"/"+birthday.getFullYear();
    	var address=$('#address').val();
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
				// alert thongbao
				$('.thongbao').html('<div class="top-alert"><div class="alert alert-success" role="alert"><i class="far fa-check-circle"></i> Thay đổi thông tin thành công!</div></div>');
				$('.thongbao').fadeIn();
				setTimeout(function() {
					
					$('.thongbao').fadeOut(function() {
						$('.thongbao').empty();
						window.location = '/HiBook_KLTN19/user-update';
					});
				}, 1000);
	    		
	        },
	    	statusCode: {
	    		404: function() {
		    	      //alert('404 page not found');
		    	    	$('.thongbao').html('<div class="top-alert"><div class="top-alert alert alert-danger" role="alert"><i class="far fa fa-times"></i> 404 page not found!</div></div>');
		    			$('.thongbao').fadeIn();
		    			setTimeout(function() {
		    				
		    				$('.thongbao').fadeOut(function() {
		    					$('.thongbao').empty();
		    				});
		    			}, 2000);
		    	    },
		
		    	    400: function() {
		    	       //alert('400 bad request');
		    	    	$('.thongbao').html('<div class="top-alert"><div class="top-alert alert alert-danger" role="alert"><i class="far fa fa-times"></i> 400 bad request!</div></div>');
		    			$('.thongbao').fadeIn();
		    			setTimeout(function() {
		    				
		    				$('.thongbao').fadeOut(function() {
		    					$('.thongbao').empty();
		    				});
		    			}, 2000);
		    	   }
	    	}
		});
	});
	$('#btn_LuuPass').click(function(){
		var old=$('#passwordold').val();
		var pass=$('#passwordnew').val();
		var pass1=$('#passwordagain').val();
		if(pass==pass1){
			$.ajax({
				url : "/HiBook_KLTN19/api/v1/users/"+idUser,
		    	type : "POST",
		    	data:{
		    		old:old,
		    		passnew:pass
		    	},
		    	success : function(data) {
		    		if(data==1){
						// alert thongbao
						$('.thongbao').html('<div class="top-alert"><div class="alert alert-success" role="alert"><i class="far fa-check-circle"></i> Đổi mật khẩu thành công!</div></div>');
						$('.thongbao').fadeIn();
						setTimeout(function() {
							
							$('.thongbao').fadeOut(function() {
								$('.thongbao').empty();
							});
						}, 2000);
		    		}else if(data==-1){
		    			//alert("Mật khẩu cũ không chính xác!!!");
		    			$('.thongbao').html('<div class="top-alert"><div class="top-alert alert alert-danger" role="alert"><i class="far fa fa-times"></i> Mật khẩu cũ không chính xác!!!</div></div>');
						$('.thongbao').fadeIn();
						setTimeout(function() {
							
							$('.thongbao').fadeOut(function() {
								$('.thongbao').empty();
							});
						}, 2000);
		    		}
		        },
		    	statusCode: {
		    	    404: function() {
		    	      //alert('404 page not found');
		    	    	$('.thongbao').html('<div class="top-alert"><div class="top-alert alert alert-danger" role="alert"><i class="far fa fa-times"></i> 404 page not found!</div></div>');
		    			$('.thongbao').fadeIn();
		    			setTimeout(function() {
		    				
		    				$('.thongbao').fadeOut(function() {
		    					$('.thongbao').empty();
		    				});
		    			}, 2000);
		    	    },
		
		    	    400: function() {
		    	       //alert('400 bad request');
		    	    	$('.thongbao').html('<div class="top-alert"><div class="top-alert alert alert-danger" role="alert"><i class="far fa fa-times"></i> 400 bad request!</div></div>');
		    			$('.thongbao').fadeIn();
		    			setTimeout(function() {
		    				
		    				$('.thongbao').fadeOut(function() {
		    					$('.thongbao').empty();
		    				});
		    			}, 2000);
		    	   }
		    	}
			});
		}else{
			//alert("Nhập lại mật khẩu mới không trùng nhau!");
			$('.thongbao').html('<div class="top-alert"><div class="top-alert alert alert-danger" role="alert"><i class="far fa fa-times"></i> Nhập lại mật khẩu mới không trùng nhau!</div></div>');
			$('.thongbao').fadeIn();
			setTimeout(function() {
				
				$('.thongbao').fadeOut(function() {
					$('.thongbao').empty();
				});
			}, 2000);
		}
	});
	

});