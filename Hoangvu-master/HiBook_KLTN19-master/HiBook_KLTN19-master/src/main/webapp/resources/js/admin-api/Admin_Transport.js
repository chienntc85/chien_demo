$(document).ready(function getlisttransport() {
	//save table
	var table;
	//index row
	var rowclick=-1;
	//state button save -1: add, >-1: update
	var button_save=-1;
	
    $.ajax({
    	type : "GET",
    	url : "api/v1/transports"
    }).then(function(data) {
    	var auth = ''; 
    	$.each(data, function (i, item) {	 	
    		
    		auth+='<tr><td class="idtransport">'+item.idTransport+'</td> ' +
                '<td class="nametransport">'+item.nameTransport+'</td>'+
                '<td class="describes">'+item.describes+'</td>'+
                '<td class="fee">'+item.fee+'</td>'+
                '<td><a href="#" class="edit-transport btn btn-icon btn-pill btn-primary" data-toggle="tooltip" title="Edit" ><i class="fa fa-fw fa-edit"></i></a>'+
                '<a href="#" class="btn btn-icon btn-pill btn-danger delete-transport" data-toggle="tooltip" title="Delete"><i class="fa fa-fw fa-trash"></i></a>'+
                '</td></tr>';
        });
    	$('#list-transport').append(auth);
    	table=$('#table-transport').DataTable(); 	     
 	    
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
    function resetInputtransport(){
    	$('#validationServer01').val('');
        $('.invalid-feedback').css("display","none");
		$('.valid-feedback').css("display","none");
		if($('#validationServer02').val('')=='')
			$('.invalid-feedback').css("display","none");
		else{
			$('.valid-feedback').css("display","none");
		}
		$('#validationServer02').val('');
		$('#validationServer03').val('0');
    }
    
    /*Click edit */
    $('#table-transport tbody ').on( 'click', 'a.edit-transport', function () {
    		//get data row clicked
    	$('#modalAdd').modal('toggle');
        var id=$(this).closest("tr").find('.idtransport').text();
    	var name=$(this).closest("tr").find('.nametransport').text();
    	var describes=$(this).closest("tr").find('.describes').text();
    	var fee=$(this).closest("tr").find('.fee').text();
        $('#exampleModalCenterTitle').text('Sửa Loại Vận Chuyển');
        $('#validationServer01').val(name);
        $('#validationServer02').val(describes);
        $('#validationServer03').val(fee);
        button_save=id;
        rowclick=table.row( $(this).closest("tr") ).index();
	});
    /* Click add */
    $('#add-transport').click(function(){
    	$('#exampleModalCenterTitle').text('Thêm phương thức thanh toán');
    	button_save=-1;
    	resetInputtransport();
    });
    $('#close-add-transport, .close').click(function(){
    	resetInputtransport();
    });
	//Xử lý add & update data, button 'Save'
    $("#save-add-transport").click(function(){
    	var name=$('#validationServer01').val();
    	var describes=$('#validationServer02').val();
    	var fee=$('#validationServer03').val();
    	$('#modalAdd').modal('toggle');
    	if(name==''||name==' '){
    		$('.invalid-feedback').css("display","block");
    		$('.valid-feedback').css("display","none");
    	}else{
    		if(button_save==-1){
	    		addtransport(name, describes, fee);
	    		resetInputtransport();
    		}else if(button_save>=0){
    			updatetransport(button_save, name, describes, fee, rowclick);
    		}
    	}
    });
    /* Add transport */
    function addtransport(name, describes, fee){
    	$.ajax({
        	type : "POST",
        	url : "api/v1/transports",
        	data:{
        		nameTransport:name,
        		describes: describes,
        		fee: fee
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
    /* update transport */
    function updatetransport(idTransport, nametransport, describes, fee, idx){
    	$.ajax({
        	url : "api/v1/transports/"+idTransport,
        	type : "PUT",
        	data:JSON.stringify({
        		nameTransport: nametransport,
        		describes: describes,
        		fee: fee
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
                	table.cell( idx, 1 ).data( nametransport ).draw();
                	table.cell( idx, 2 ).data( describes ).draw();
                	table.cell( idx, 3 ).data( fee ).draw();
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
    $('#table-transport tbody ').on( 'click', 'a.delete-transport', function () {
		//get data row clicked
        var id=$(this).closest("tr").find('.idtransport').text();
        var name=$(this).closest("tr").find('.nametransport').text();
        var index= table.row( $(this).closest("tr") ).index();
        $('#xoa-title').text('Bạn có chắc muốn xóa: "'+name+'" này không?');
        deletetransport(id, index);
    });
    /* Delete transport */
    function deletetransport(idTransport, index){
    	$('#modalDelete').modal('toggle');
    	$('#delete-transport').click(function(){
    		$('#modalDelete').modal('toggle');
    		$.ajax({
            	url : "api/v1/transports/"+idTransport,
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