$(document).ready(function getlistbook() {
	//save table
	var table;
	//index row
	var rowclick=-1;
	//state button save -1: add, >-1: update
	var button_save=-1;
	var mydata;
	
    $.ajax({
    	type : "GET",
    	url : "api/v1/books"
    }).then(function(data) {
    	var auth = '';    	
    	$.each(data, function (i, item) {	 	
    		
    		auth+='<tr><td class="idBook">'+item.idBook+'</td> ' +
                '<td ><a href="#" style="text-decoration: none;" class="namebook font-weight-bold">'+item.nameBook+'</a></td>'+
                '<td class="picBook"><img class="card-img-top" src="resources/images/book/'+item.picBook+'"/></td>'+
                '<td class="publicationDate">'+item.publicationDate+'</td>'+
                '<td class="quantity">'+item.quantity+'</td>'+
                '<td class="price">'+item.price+'</td>'+
                '<td class="discount">'+item.discount+'</td>'+
                '<td class="typeBook" data-id="'+item.typebook.idType+'">'+item.typebook.nameType+'</td>'+
                '<td class="supplier" data-id="'+item.supplier.idSupplier+'">'+item.supplier.nameSupplier+'</td>'+
                '<td><a href="#" class="edit-book btn btn-icon btn-pill btn-primary" data-toggle="tooltip" title="Edit" ><i class="fa fa-fw fa-edit"></i></a>'+
                '<a href="#" class="btn btn-icon btn-pill btn-danger delete-book" data-toggle="tooltip" title="Delete"><i class="fa fa-fw fa-trash"></i></a>'+
                '</td></tr>';
    		
        });
    	mydata=data;
    	$('#list-book').append(auth);
    	table=$('#table-book').DataTable(); 	     
 	    
    });
    $('#table-book tbody').on( 'click', 'a.namebook', function () {
		//get data row clicked
		$('#modalDetail').modal('toggle');
		$('#chitiet_body').empty();
		var row=table.row( $(this).closest("tr") ).index();
		
		var tensach=$(this).closest("tr").find('.namebook').text();
		var img= $(this).closest("tr").find('.picBook img').attr('src');
		var publicationDate=$(this).closest("tr").find('.publicationDate').text();
		var quantity= $(this).closest("tr").find('.quantity').text();
		var supplier= $(this).closest("tr").find('.supplier').text();
		var type=$(this).closest("tr").find('.typeBook').text();
		var price=$(this).closest("tr").find('.price').text();
		var discount=$(this).closest("tr").find('.discount').text();
		$('#img_book img').attr('src',img);
		$('#tensach').text(tensach);
		$('#gia').text(price+' vnđ');
		$('#giam').text(discount+'%');
		$('#chitiet_body').append(chitiet);
		$('#gioithieu').html(mydata[row].introBook);
		$('#docthu').text(mydata[row].proofread);
		var chitiet='<tr><td >NXB</td><td>'+mydata[row].publisher+'</td></tr>'+
			'<tr><td >Kích thước</td><td>'+mydata[row].size+'</td></tr>'+
			'<tr><td>Số trang</td><td>'+mydata[row].numberPage+'</td></tr>'+
			'<tr><td >Ngày phát hành</td><td>'+publicationDate+'</td></tr>'+
			'<tr><td >Số lượng</td><td>'+quantity+'</td></tr>'+
			'<tr><td >Loại bìa</td><td>'+mydata[row].cover+'</td></tr>'+
			'<tr><td >Nhà cung cấp</td><td>'+supplier+'</td></tr>'+
			'<tr><td >Loại sách</td><td>'+type+'</td></tr>'+
			'<tr><td >tag tìm kiếm</td><td>'+mydata[row].tagList+'</td></tr>';
		$('#chitiet_body').append(chitiet);
		$('#gioithieu').html(mydata[row].introBook);
		$('#docthu').text(mydata[row].proofread);
    });
    /*click update*/ 
    $('#table-book tbody ').on( 'click', 'a.edit-book', function () {
		//get data row clicked
        var id=$(this).closest("tr").find('.idBook').text();
        window.location = '/HiBook_KLTN19/add-book/'+id;
    });
    
    /*click delete*/ 
    $('#table-book tbody ').on( 'click', 'a.delete-book', function () {
		//get data row clicked
        var id=$(this).closest("tr").find('.idBook').text();
        var name=$(this).closest("tr").find('.namebook').text();
        var index= table.row( $(this).closest("tr") ).index();
        $('#xoa-title').text('Bạn có chắc muốn xóa cuốn: "'+name+'" không?');
        deletebook(id, index);
    });
    /* Delete book*/ 
    function deletebook(idBook, index){
    	$('#modalDelete').modal('toggle');
    	$('#delete-book').click(function(){
    		$('#modalDelete').modal('toggle');
    		$.ajax({
            	url : "api/v1/books/"+idBook,
            	type : "DELETE",
            	success : function(data) {
                    table.row(index).remove().draw();
                    mydata.splice(index, 1);
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