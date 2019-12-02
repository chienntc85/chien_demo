$(document).ready(function getlisttypebook() {
	//save table
	var table;
	//index row
	var rowclick=-1;
	//state button save -1: add, >-1: update
	var button_save=-1;
	
    $.ajax({
    	type : "GET",
    	url : "api/v1/typebooks"
    }).then(function(data) {
    	var auth = '';    	
    	$.each(data, function (i, item) {	 	
    		
    		auth+='<tr><td class="idType">'+item.idType+'</td> ' +
                '<td class="nameType">'+item.nameType+'</td>'+
                '<td><a href="#" class="edit-typebook btn btn-icon btn-pill btn-primary" data-toggle="tooltip" title="Edit" ><i class="fa fa-fw fa-edit"></i></a>'+
                '<a href="#" class="btn btn-icon btn-pill btn-danger delete-typebook" data-toggle="tooltip" title="Delete"><i class="fa fa-fw fa-trash"></i></a>'+
                '</td></tr>';
        });
    	$('#list-typebook').append(auth);
    	table=$('#table-typebook').DataTable(); 	     
 	    
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
    function resetInputtypebook(){
    	$('#validationServer01').val('');
        $('.invalid-feedback').css("display","none");
		$('.valid-feedback').css("display","none");
    }
    
    /*Click edit */
    $('#table-typebook tbody ').on( 'click', 'a.edit-typebook', function () {
    		//get data row clicked
    	$('#modalAdd').modal('toggle');
        var id=$(this).closest("tr").find('.idType').text();
    	var name=$(this).closest("tr").find('.nameType').text();
        $('#exampleModalCenterTitle').text('Sửa Tác Giả');
        $('#validationServer01').val(name);
        button_save=id;
        rowclick=table.row( $(this).closest("tr") ).index();
	});
    /* Click add */
    $('#add-typebook').click(function(){
    	$('#exampleModalCenterTitle').text('Thêm Loại Tour');
    	button_save=-1;
    	resetInputtypebook();
    });
    $('#close-add-typebook, .close').click(function(){
    	resetInputtypebook();
    });
	//Xử lý add & update data, button 'Save'
    $("#save-add-typebook").click(function(){
    	var name=$('#validationServer01').val();
    	$('#modalAdd').modal('toggle');
    	var id
    	if(name==''||name==' '){
    		$('.invalid-feedback').css("display","block");
    		$('.valid-feedback').css("display","none");
    	}else{
    		if(button_save==-1){
	    		addtypebook(name);
	    		resetInputtypebook();
    		}else if(button_save>=0){
    			updatetypebook(button_save, name, rowclick);
    		}
    	}
    });
    /* Add typebook */
    function addtypebook(name){
    	$.ajax({
        	type : "POST",
        	url : "api/v1/typebooks",
        	data:{
        		nameType:name
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
    /* update typebook */
    function updatetypebook(idType, nameType, idx){
    	$.ajax({
        	url : "api/v1/typebooks/"+idType,
        	type : "PUT",
        	data:JSON.stringify({
        		nameType: nameType
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
                	table.cell( idx, 1 ).data( nameType ).draw();
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
    $('#table-typebook tbody ').on( 'click', 'a.delete-typebook', function () {
		//get data row clicked
        var id=$(this).closest("tr").find('.idType').text();
        var name=$(this).closest("tr").find('.nameType').text();
        var index= table.row( $(this).closest("tr") ).index();
        $('#xoa-title').text('Bạn có chắc muốn xóa: "'+name+'" này không?');
        deletetypebook(id, index);
    });
    /* Delete typebook */
    function deletetypebook(idType, index){
    	$('#modalDelete').modal('toggle');
    	$('#delete-typebook').click(function(){
    		$('#modalDelete').modal('toggle');
    		$.ajax({
            	url : "api/v1/typebooks/"+idType,
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