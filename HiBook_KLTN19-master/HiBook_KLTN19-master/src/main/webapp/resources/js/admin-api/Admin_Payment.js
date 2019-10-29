$(document).ready(function getlistpayment() {
	//save table
	var table;
	//index row
	var rowclick=-1;
	//state button save -1: add, >-1: update
	var button_save=-1;
	
    $.ajax({
    	type : "GET",
    	url : "api/v1/payments"
    }).then(function(data) {
    	var auth = ''; 
    	$.each(data, function (i, item) {	 	
    		
    		auth+='<tr><td class="idpayment">'+item.idPayment+'</td> ' +
                '<td class="namepayment">'+item.namePayment+'</td>'+
                '<td><a href="#" class="edit-payment btn btn-icon btn-pill btn-primary" data-toggle="tooltip" title="Edit" ><i class="fa fa-fw fa-edit"></i></a>'+
                '<a href="#" class="btn btn-icon btn-pill btn-danger delete-payment" data-toggle="tooltip" title="Delete"><i class="fa fa-fw fa-trash"></i></a>'+
                '</td></tr>';
        });
    	$('#list-payment').append(auth);
    	table=$('#table-payment').DataTable(); 	     
 	    
    });
    /*==========================*/
    //xử lý input nhập
    $("#validationServer01").on("input",function(){
		var val_inp= $('#validationServer01').val();
	    if(val_inp===""||val_inp===" "){
	    	$('.invalid-feedback').css("display","block");
    		$('.valid-feedback').css("display","none");
	    }else{
	    	$('.invalid-feedback').css("display","none");
    		$('.valid-feedback').css("display","block");
	    }
	});
    function resetInputpayment(){
    	$('#validationServer01').val('');
        $('.invalid-feedback').css("display","none");
		$('.valid-feedback').css("display","none");
    }
    
    /*Click edit */
    $('#table-payment tbody ').on( 'click', 'a.edit-payment', function () {
    		//get data row clicked
    	$('#modalAdd').modal('toggle');
        var id=$(this).closest("tr").find('.idpayment').text();
    	var name=$(this).closest("tr").find('.namepayment').text();
        $('#exampleModalCenterTitle').text('Sửa Tác Giả');
        $('#validationServer01').val(name);
        button_save=id;
        rowclick=table.row( $(this).closest("tr") ).index();
	});
    /* Click add */
    $('#add-payment').click(function(){
    	$('#exampleModalCenterTitle').text('Thêm Tác Giả');
    	button_save=-1;
    	resetInputpayment();
    });
    $('#close-add-payment, .close').click(function(){
    	resetInputpayment();
    });
	//Xử lý add & update data, button 'Save'
    $("#save-add-payment").click(function(){
    	var name=$('#validationServer01').val();
    	$('#modalAdd').modal('toggle');
    	var id
    	if(name==''||name==' '){
    		$('.invalid-feedback').css("display","block");
    		$('.valid-feedback').css("display","none");
    	}else{
    		if(button_save==-1){
	    		addpayment(name);
	    		resetInputpayment();
    		}else if(button_save>=0){
    			updatepayment(button_save, name, rowclick);
    		}
    	}
    });
    /* Add payment */
    function addpayment(name){
    	$.ajax({
        	type : "POST",
        	url : "api/v1/payments",
        	data:{
        		namePayment:name
        	},
        	success : function(data) {
                alert('thêm thành công! ');
                location.reload();
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
    /* update payment */
    function updatepayment(idPayment, namepayment, idx){
    	$.ajax({
        	url : "api/v1/payments/"+idPayment,
        	type : "PUT",
        	data:JSON.stringify({
        		namePayment: namepayment
        	}),
        	headers: {
        	      'Accept': 'application/json',
        	      'Content-Type': 'application/json'
        	},
        	success : function(data) {
                alert('cập nhập thành công!');
                if(idx==-1){
                	location.reload();
                }else{
                	table.cell( idx, 1 ).data( namepayment ).draw();
                }
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
    /*==========================*/
    /*click delete */
    $('#table-payment tbody ').on( 'click', 'a.delete-payment', function () {
		//get data row clicked
        var id=$(this).closest("tr").find('.idpayment').text();
        var name=$(this).closest("tr").find('.namepayment').text();
        var index= table.row( $(this).closest("tr") ).index();
        $('#xoa-title').text('Bạn có chắc muốn xóa: "'+name+'" này không?');
        deletepayment(id, index);
    });
    /* Delete payment */
    function deletepayment(idPayment, index){
    	$('#modalDelete').modal('toggle');
    	$('#delete-payment').click(function(){
    		$('#modalDelete').modal('toggle');
    		$.ajax({
            	url : "api/v1/payments/"+idPayment,
            	type : "DELETE",
            	success : function(data) {
                    table.row(index).remove().draw();
                    alert('xóa thành công!');
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
    }
});