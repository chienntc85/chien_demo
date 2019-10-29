$(document).ready(function getlistBill() {
	//save table
	var table;
	//index row
	var rowclick=-1;
	var mydata;
	var status;
	
	$.ajax({
    	type : "GET",
    	url : "/HiBook_KLTN19/api/v1/status",
    	success : function(data) {
    		status=data;
    	}
    });
	
    $.ajax({
    	type : "GET",
    	url : "api/v1/bills"
    }).then(function(data) {
    	var auth = '';    	
    	$.each(data, function (i, item) {	 	
    		
    		auth+='<tr><td class="idBill">'+item.idBill+'</td> ' +
                '<td class="user">'+item.user.nameUser+'</td>'+
                '<td class="dateCreate">'+item.dateCreate+'</td>'+
                '<td class="total">'+item.total+'</td>'+
                '<td class="payment" data-id="'+item.payment.idPayment+'">'+item.payment.namePayment+'</td>'+
                '<td class="orderStatus" >'+getStatus(item.orderstatus.idStatus)+'</td>'+
                '<td class="transport" data-id="'+item.transport.idTransport+'">'+item.transport.nameTransport+'</td></tr>';
        });
    	mydata=data;
    	$('#list-Bill').append(auth);
    	table=$('#table-Bill').DataTable(); 	     
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
    
    $('#table-Bill tbody').on('change', 'select.myselect', function () {
        var optionSelected = $("option:selected", this);
        var valueSelected = this.value;
        var idStatus= optionSelected.data('id');
        $('#modalChange').modal('toggle');
        var idBill=$(this).closest("tr").find('.idBill').text();
		
        $('#change-status').click(function(){
    		$('#modalChange').modal('toggle');
    		$.ajax({
            	url : "api/v1/bills/"+idBill+"/status/"+idStatus,
            	type : "PUT",
            	success : function(data) {
            		$('.thongbao').html('<div class="alert alert-success" role="alert"><i class="far fa-check-circle"></i> Thay đổi thành công!!!</div>');
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
    
    
    $('#table-Bill tbody').on( 'click', 'tr', function () {
    	var idBill=$(this).find('.idBill').text();
		var link= "/HiBook_KLTN19/manage-detail-bill/"+idBill;
    	window.location = link;
    });

    
});