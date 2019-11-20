$(document).ready(function getliststatus() {
	//save table
	var table;
	//index row
	var rowclick=-1;
	//state button save -1: add, >-1: update
	var button_save=-1;
	
    $.ajax({
    	type : "GET",
    	url : "api/v1/status"
    }).then(function(data) {
    	var auth = '';    	
    	$.each(data, function (i, item) {	 	
    		
    		auth+='<tr><td class="idstatus">'+item.idStatus+'</td> ' +
                '<td class="namestatus">'+item.nameStatus+'</td>'+
                '<td><a href="#" class="edit-status btn btn-icon btn-pill btn-primary" data-toggle="tooltip" title="Edit" ><i class="fa fa-fw fa-edit"></i></a>'+
                '<a href="#" class="btn btn-icon btn-pill btn-danger delete-status" data-toggle="tooltip" title="Delete"><i class="fa fa-fw fa-trash"></i></a>'+
                '</td></tr>';
        });
    	$('#list-status').append(auth);
    	table=$('#table-status').DataTable(); 	     
 	    
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
    function resetInputstatus(){
    	$('#validationServer01').val('');
        $('.invalid-feedback').css("display","none");
		$('.valid-feedback').css("display","none");
    }
    
    /*Click edit */
    $('#table-status tbody ').on( 'click', 'a.edit-status', function () {
    		//get data row clicked
    	$('#modalAdd').modal('toggle');
        var id=$(this).closest("tr").find('.idstatus').text();
    	var name=$(this).closest("tr").find('.namestatus').text();
        $('#exampleModalCenterTitle').text('Sửa trạng thái');
        $('#validationServer01').val(name);
        button_save=id;
        rowclick=table.row( $(this).closest("tr") ).index();
	});
    /* Click add */
    $('#add-status').click(function(){
    	$('#exampleModalCenterTitle').text('Thêm trạng thái');
    	button_save=-1;
    	resetInputstatus();
    });
    $('#close-add-status, .close').click(function(){
    	resetInputstatus();
    });
	//Xử lý add & update data, button 'Save'
    $("#save-add-status").click(function(){
    	var name=$('#validationServer01').val();
    	$('#modalAdd').modal('toggle');
    	var id
    	if(name==''||name==' '){
    		$('.invalid-feedback').css("display","block");
    		$('.valid-feedback').css("display","none");
    	}else{
    		if(button_save==-1){
	    		addstatus(name);
	    		resetInputstatus();
    		}else if(button_save>=0){
    			updatestatus(button_save, name, rowclick);
    		}
    	}
    });
    /* Add status */
    function addstatus(name){
    	$.ajax({
        	type : "POST",
        	url : "api/v1/status",
        	data:{
        		nameStatus:name
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
    /* update status */
    function updatestatus(idStatus, nameStatus, idx){
    	$.ajax({
        	url : "api/v1/status/"+idStatus,
        	type : "PUT",
        	data:JSON.stringify({
        		nameStatus: nameStatus
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
                	table.cell( idx, 1 ).data( nameStatus ).draw();
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
    $('#table-status tbody ').on( 'click', 'a.delete-status', function () {
		//get data row clicked
        var id=$(this).closest("tr").find('.idstatus').text();
        var name=$(this).closest("tr").find('.namestatus').text();
        var index= table.row( $(this).closest("tr") ).index();
        $('#xoa-title').text('Bạn có chắc muốn xóa: "'+name+'" này không?');
        deletestatus(id, index);
    });
    /* Delete status */
    function deletestatus(idStatus, index){
    	$('#modalDelete').modal('toggle');
    	$('#delete-status').click(function(){
    		$('#modalDelete').modal('toggle');
    		$.ajax({
            	url : "api/v1/status/"+idStatus,
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