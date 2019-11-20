$(document).ready(function getlistBill() {
	var status;
	var url_string = window.location.href;
	var vars = url_string.split("/");
	var idBill = vars[vars.length-1];
	$.ajax({
    	type : "GET",
    	url : "/HiBook_KLTN19/api/v1/status",
    	success : function(data) {
    		status=data;
    	}
    });
	
    $.ajax({
    	type : "GET",
    	url : "/HiBook_KLTN19/api/v1/bills/"+idBill
    }).then(function(data) {
    	var auth = '';  
    	$('p.orderStatus').append(getStatus(data.orderstatus.idStatus));
    	$('#idBill').text(data.idBill);
    	$('#nameReceiver').text(data.nameReceiver);
    	$('#numberphone').text(data.numberphone);
    	$('#dateCreate').text(data.dateCreate);
    	$('#deliveryAdress').text(data.deliveryAdress);
    	
    	//info sách
    	var detail='';
    	var total_all=0;
    	$.each(data.detailbills,function(i, item){
    		detail+='<tr><td id="nameBook">'+item.book.nameBook+'</td>'+
                '<td id="imgBook"><img style="width: 100px;" src="/HiBook_KLTN19/resources/images/book/'+item.book.picBook+'"/></td>'+
                '<td id="quantity">'+item.quantityBuy+'</td>'+
                '<td id="price">'+item.price+'</td>'+
                '<td id="total" class="text-right">'+item.quantityBuy*item.price+'</td>'+
                '</tr>';
    		total_all+=item.quantityBuy*item.price;
    	});
    	detail+='<tr class="bg-light font-weight-bold"><td></td><td></td><td></td>'+
            '<td class="text-uppercase">Tổng cộng</td><td id="total-all" class="text-right">'+total_all+'</td></tr>'+
            '<tr class="bg-light font-weight-bold"><td></td><td></td><td></td>'+
            '<td class="text-uppercase">Vận chuyển</td><td class="text-right">'+data.transport.fee+'</td></tr>'+
            '<tr class="bg-light font-weight-bold"><td></td><td></td><td></td>'+
            '<td class="text-uppercase">Tổng thanh toán</td><td id="total-payment" class="text-right">'+(total_all+data.transport.fee)+'</td></tr>';
    	$('tbody').append(detail);
    	$('#nameUser').text(data.user.nameUser);
    	$('#payment').text(data.payment.namePayment);
    	$('#transport').text(data.transport.nameTransport);
    });
    function getStatus(sta_selected){
		var status1='<select class="badge-success myselect">';
		$.each(status, function (i, item) {
    		if(sta_selected==item.idStatus){
    			status1+='<option data-id="'+item.idStatus+'" selected>'+item.nameStatus+'</option>';
    		}else{
    			status1+='<option data-id="'+item.idStatus+'">'+item.nameStatus+'</option>';
    		}
        });
		status1+='</select>';
		return status1;
	}
    
    $('p.orderStatus').on('change', 'select.myselect', function () {
        var optionSelected = $("option:selected", this);
        var valueSelected = this.value;
        var idStatus= optionSelected.data('id');
        $('#modalChange').modal('toggle');
		
        $('#change-status').click(function(){
    		$('#modalChange').modal('toggle');
    		$.ajax({
            	url : "/HiBook_KLTN19/api/v1/bills/"+idBill+"/status/"+idStatus,
            	type : "PUT",
            	success : function(data) {
            		// alert thongbao
            		$('.thongbao').html('<div class="top-alert"><div class="alert alert-success" role="alert"><i class="far fa-check-circle"></i> Thay đổi thành công!!!</div></div>');
            		$('.thongbao').fadeIn();
            		setTimeout(function() {
            			
            			$('.thongbao').fadeOut(function() {
            				$('.thongbao').empty();
                		});
                	}, 1000);
            		//alertsuccess("Thay đổi thành công!!!");
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
    	});
    });

    
});