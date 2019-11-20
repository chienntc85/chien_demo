$(document).ready(function getlistsupplier() {
	//save table
	var table;
	//index row
	var rowclick=-1;
	//state button save -1: add, >-1: update
	var button_save=-1;
	
    $.ajax({
    	type : "GET",
    	url : "api/v1/suppliers"
    }).then(function(data) {
    	var auth = ''; 
    	$.each(data, function (i, item) {	 	
    		
    		auth+='<tr><td class="idsupplier">'+item.idSupplier+'</td> ' +
                '<td class="namesupplier">'+item.nameSupplier+'</td>'+
                '<td><a href="#" class="edit-supplier btn btn-icon btn-pill btn-primary" data-toggle="tooltip" title="Edit" ><i class="fa fa-fw fa-edit"></i></a>'+
                '<a href="#" class="btn btn-icon btn-pill btn-danger delete-supplier" data-toggle="tooltip" title="Delete"><i class="fa fa-fw fa-trash"></i></a>'+
                '</td></tr>';
        });
    	$('#list-supplier').append(auth);
    	table=$('#table-supplier').DataTable(); 	     
 	    
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
    function resetInputsupplier(){
    	$('#validationServer01').val('');
        $('.invalid-feedback').css("display","none");
		$('.valid-feedback').css("display","none");
    }
    
    /*Click edit */
    $('#table-supplier tbody ').on( 'click', 'a.edit-supplier', function () {
    		//get data row clicked
    	$('#modalAdd').modal('toggle');
        var id=$(this).closest("tr").find('.idsupplier').text();
    	var name=$(this).closest("tr").find('.namesupplier').text();
        $('#exampleModalCenterTitle').text('Sửa công ty lữ hành');
        $('#validationServer01').val(name);
        button_save=id;
        rowclick=table.row( $(this).closest("tr") ).index();
	});
    /* Click add */
    $('#add-supplier').click(function(){
    	$('#exampleModalCenterTitle').text('Thêm công ty lữ hành');
    	button_save=-1;
    	resetInputsupplier();
    });
    $('#close-add-supplier, .close').click(function(){
    	resetInputsupplier();
    });
	//Xử lý add & update data, button 'Save'
    $("#save-add-supplier").click(function(){
    	var name=$('#validationServer01').val();
    	$('#modalAdd').modal('toggle');
    	var id
    	if(name==''||name==' '){
    		$('.invalid-feedback').css("display","block");
    		$('.valid-feedback').css("display","none");
    	}else{
    		if(button_save==-1){
	    		addsupplier(name);
	    		resetInputsupplier();
    		}else if(button_save>=0){
    			updatesupplier(button_save, name, rowclick);
    		}
    	}
    });
    /* Add supplier */
    function addsupplier(name){
    	$.ajax({
        	type : "POST",
        	url : "api/v1/suppliers",
        	data:{
        		nameSupplier:name
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
    /* update supplier */
    function updatesupplier(idSupplier, namesupplier, idx){
    	$.ajax({
        	url : "api/v1/suppliers/"+idSupplier,
        	type : "PUT",
        	data:JSON.stringify({
        		nameSupplier: namesupplier
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
                	table.cell( idx, 1 ).data( namesupplier ).draw();
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
    $('#table-supplier tbody ').on( 'click', 'a.delete-supplier', function () {
		//get data row clicked
        var id=$(this).closest("tr").find('.idsupplier').text();
        var name=$(this).closest("tr").find('.namesupplier').text();
        var index= table.row( $(this).closest("tr") ).index();
        $('#xoa-title').text('Bạn có chắc muốn xóa: "'+name+'" này không?');
        deletesupplier(id, index);
    });
    /* Delete supplier */
    function deletesupplier(idSupplier, index){
    	$('#modalDelete').modal('toggle');
    	$('#delete-supplier').click(function(){
    		$('#modalDelete').modal('toggle');
    		$.ajax({
            	url : "api/v1/suppliers/"+idSupplier,
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