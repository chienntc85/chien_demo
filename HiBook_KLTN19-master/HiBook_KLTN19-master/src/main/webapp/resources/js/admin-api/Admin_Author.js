$(document).ready(function getlistAuthor() {
	//save table
	var table;
	//index row
	var rowclick=-1;
	//state button save -1: add, >-1: update
	var button_save=-1;
	
    $.ajax({
    	type : "GET",
    	url : "api/v1/authors"
    }).then(function(data) {
    	var auth = '';    	
    	$.each(data, function (i, item) {	 	
    		
    		auth+='<tr><td class="idAuthor">'+item.idAuthor+'</td> ' +
                '<td class="nameAuthor">'+item.nameAuthor+'</td>'+
                '<td>'+Object.keys(item.books).length+'</td>'+
                '<td><a href="#" class="edit-author btn btn-icon btn-pill btn-primary" data-toggle="tooltip" title="Edit" ><i class="fa fa-fw fa-edit"></i></a>'+
                '<a href="#" class="btn btn-icon btn-pill btn-danger delete-author" data-toggle="tooltip" title="Delete"><i class="fa fa-fw fa-trash"></i></a>'+
                '</td></tr>';
        });
    	$('#list-author').append(auth);
    	table=$('#table-author').DataTable(); 	     
 	    
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
    function resetInputAuthor(){
    	$('#validationServer01').val('');
        $('.invalid-feedback').css("display","none");
		$('.valid-feedback').css("display","none");
    }
    
    /*Click edit */
    $('#table-author tbody ').on( 'click', 'a.edit-author', function () {
    		//get data row clicked
    	$('#modalAdd').modal('toggle');
        var id=$(this).closest("tr").find('.idAuthor').text();
    	var name=$(this).closest("tr").find('.nameAuthor').text();
        $('#exampleModalCenterTitle').text('Sửa Lịch Trình');
        $('#validationServer01').val(name);
        button_save=id;
        rowclick=table.row( $(this).closest("tr") ).index();
	});
    /* Click add */
    $('#add-author').click(function(){
    	$('#exampleModalCenterTitle').text('Thêm Lịch Trình');
    	button_save=-1;
    	resetInputAuthor();
    });
    $('#close-add-author, .close').click(function(){
    	resetInputAuthor();
    });
	//Xử lý add & update data, button 'Save'
    $("#save-add-author").click(function(){
    	var name=$('#validationServer01').val();
    	$('#modalAdd').modal('toggle');
    	var id
    	if(name==''||name==' '){
    		$('.invalid-feedback').css("display","block");
    		$('.valid-feedback').css("display","none");
    	}else{
    		if(button_save==-1){
	    		addAuthor(name);
	    		resetInputAuthor();
    		}else if(button_save>=0){
    			updateAuthor(button_save, name, rowclick);
    		}
    	}
    });
    /* Add author */
    function addAuthor(name){
    	$.ajax({
        	type : "POST",
        	url : "api/v1/authors",
        	data:{
        		nameAuthor:name
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
    /* update author */
    function updateAuthor(idAuthor, nameAuthor, idx){
    	$.ajax({
        	url : "api/v1/authors/"+idAuthor,
        	type : "PUT",
        	data:JSON.stringify({
        		nameAuthor: nameAuthor
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
                	table.cell( idx, 1 ).data( nameAuthor ).draw();
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
    $('#table-author tbody ').on( 'click', 'a.delete-author', function () {
		//get data row clicked
        var id=$(this).closest("tr").find('.idAuthor').text();
        var name=$(this).closest("tr").find('.nameAuthor').text();
        var index= table.row( $(this).closest("tr") ).index();
        $('#xoa-title').text('Bạn có chắc muốn xóa: "'+name+'" này không?');
        deleteAuthor(id, index);
    });
    /* Delete author */
    function deleteAuthor(idAuthor, index){
    	$('#modalDelete').modal('toggle');
    	$('#delete-author').click(function(){
    		$('#modalDelete').modal('toggle');
    		$.ajax({
            	url : "api/v1/authors/"+idAuthor,
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