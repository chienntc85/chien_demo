$(document).ready(function() {
	var url_string = window.location.href;
	var vars = url_string.split("/");
	var idSach = vars[vars.length - 1];
	
	/*Get data of transport and payment*/
	$.ajax({
    	type : "GET",
    	url : "/HiBook_KLTN19/api/v1/transports"
    }).then(function(data) {
    	var trans = ''; 
    	$.each(data, function (i, item) {
    		var check = "";
    		if(i==0){ 
    			check ="checked";
    		}
    		trans += '<label><input type="radio" name="vanchuyen" ' + check + ' value='+item.idTransport+' >'+item.nameTransport+'</label>';
    	});
    	$('#trans').append(trans);
    });
	$.ajax({
    	type : "GET",
    	url : "/HiBook_KLTN19/api/v1/payments"
    }).then(function(data) {
    	var pay = ''; 
    	$.each(data, function (i, item) {
    		var check = "";
    		if(i==0){ 
    			check ="checked";
    		}
    		pay += '<label><input type="radio" name="noigiaohang" ' + check + ' value='+item.idPayment+' >'+item.namePayment+'</label>';
    	});
    	$('#pay').append(pay);
    });
	
	GanTongTien();
	function GanTongTien(isEventChange) {
		var tongtiensp = 0;
		$(".totalmoney").each(
				function(i, price) {
					var giatiensp = $(this).closest("tr").find(".giatien").attr("data-price");
					var soluong = $(this).closest("tr").find(".soluong input").val();
					
					var giatien = soluong * giatiensp;
					tongtiensp = tongtiensp + giatien;
					if (!isEventChange) {
						$(this).html("<span>" + giatien + " VND"+ "</span>");
					}
					$("#totalall").html( "<h5>" + "<strong>" + "Tổng Tiền: " + tongtiensp + " VND" + "</strong>" + "</h5>");
				});

	}
	/*Update quantity when user change number book in cart*/
	$(".soluong_giohang").change(
			function() {
				var soluong1 = parseInt($(this).val());

				var giatiensp1 = $(this).closest("tr").find(".giatien").attr("data-price");
				var tongtien1 = soluong1 * giatiensp1;
				$(this).closest("tr").find(".totalmoney").html("<span>" + tongtien1 + " VND" + "</span>");											
				GanTongTien(true);	
				var idCart= $(this).closest("tr").find( "#getIdCart").attr("data-idCart");
				$.ajax({
					url:"/HiBook_KLTN19/api/v1/carts/"+ idCart,
					type:"PUT",
					data:JSON.stringify({
						quantity : soluong1
		        	}),
		        	headers: {
		        	      'Accept': 'application/json',
		        	      'Content-Type': 'application/json'
		        	},
					success: function(value){
					}
				})

			});

	/*Delete a book in cart */
	$(".deletecart").click(function() {
		var seft=$(this);
		var idCart= $(this).closest("tr").find("#getIdCart").attr("data-idCart");
		$.ajax({
			url:"/HiBook_KLTN19/api/v1/carts/"+idCart,
			type:"DELETE",
			success: function(value){
				seft.closest("tr").remove();
				GanTongTien();
				var value = $(".giohang_circle").find("span").text();
				value--;
				$(".giohang_circle").find("span").text(value);	 
				$('.thongbao').html('<div class="top-alert"><div class="alert alert-danger" role="alert"><i class="far fa fa-times"></i> Xóa thành công!!!</div></div>');
				$('.thongbao').fadeIn();
				setTimeout(function() {
					
					$('.thongbao').fadeOut(function() {
						$('.thongbao').empty();
					});
				}, 2000);
			}
		});


	});
});