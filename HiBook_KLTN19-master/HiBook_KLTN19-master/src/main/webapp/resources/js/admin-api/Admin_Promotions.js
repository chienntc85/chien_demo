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
    	url : "api/v1/promotions"
    }).then(function(data) {
    	var promotion = '';    	
    	$.each(data, function (i, item) {
    		promotion+='<tr><td class="idPromotion">'+item.idPromotion+'</td> ' +
                '<td ><a href="#" style="text-decoration: none;" class="title font-weight-bold">'+item.titlePromotion+'</a></td>'+
                '<td class="content">'+item.contentPromotion+'</td>'+
                '<td class="pic"><img class="card-img-top" src="resources/images/banner/'+item.picPromotion+'"/></td>'+
                '<td class="timeStart">'+item.timeStart +'</td>'+
                '<td class="timeEnd">'+item.timeEnd+'</td>'+
                '<td class="discount">'+item.saleOff+'%'+'</td>'+
                '<td><a href="add-promotion/'+item.idPromotion+'" class="edit-book btn btn-icon btn-pill btn-primary" data-toggle="tooltip" title="Edit" ><i class="fa fa-fw fa-edit"></i></a>'+
                '<a href="#" class="btn btn-icon btn-pill btn-danger delete-promotion" data-toggle="tooltip" title="Delete"><i class="fa fa-fw fa-trash"></i></a>'+
                '</td></tr>';
    		
        });
    	mydata=data;
    	$('#list-promotion').append(promotion);
    	table=$('#table-promotion').DataTable(); 	         
    });
    $('#table-promotion tbody').on( 'click', 'a.title', function () {
		//get data row clicked
		$('#modalDetail').modal('toggle');
		$('#chitiet_body').empty();
		$('#list-book').empty();
		var row=table.row( $(this).closest("tr") ).index();
		/*Get data from table */
		var title=$(this).closest("tr").find('.title').text();
		var content= $(this).closest("tr").find('.content').html();
		var img= $(this).closest("tr").find('.pic img').attr('src');
		var timeStart=$(this).closest("tr").find('.timeStart').text();
		var timeEnd= $(this).closest("tr").find('.timeEnd').text();
		var discount= $(this).closest("tr").find('.discount').text();
		/*set data in model detail */
		$('#tenkhuyenmai').text(title);
		$('#img_promotion img').attr('src',img);
		
		var chitiet='<tr><td >Thời gian bắt đầu</td><td>'+timeStart+'</td></tr>'+
			'<tr><td >Thời gian kết thúc</td><td>'+timeEnd+'</td></tr>'+
			'<tr><td>Giá giảm</td><td>'+discount+'</td></tr>';
		$('#chitiet_body').append(chitiet);
		
		var detail_book='';
		$.each(mydata[row].books, function (i, item) {
			detail_book+='<tr><td class="idBook">'+item.idBook+'</td> ' +
            '<td class="nameBook font-weight-bold">'+item.nameBook+'</td>'+
            '<td class="pic"><img class="card-img-top" style="width: 50px" src="resources/images/book/'+item.picBook+'"/></td>'+
            '<td class="discount">'+item.discount+'%'+'</td></tr>';
		});
		$('#list-book').append(detail_book);
		$('#table-book').DataTable()
		$('#gioithieu').html(content);
    });
    
    /*click delete*/ 
    $('#table-promotion tbody ').on( 'click', 'a.delete-promotion', function () {
		//get data row clicked
        var id=$(this).closest("tr").find('.idPromotion').text();
        var name=$(this).closest("tr").find('.title').text();
        var index= table.row( $(this).closest("tr") ).index();
        $('#xoa-title').text('Bạn có chắc muốn xóa: "'+name+'" không?');
        
        deletebook(id, index);
    });
    /* Delete book*/ 
    function deletebook(idPromotion, index){
    	$('#modalDelete').modal('toggle');
    	$('#delete-promotion').click(function(){
    		$('#modalDelete').modal('toggle');
    		$.ajax({
    			type : "DELETE",
            	url : "api/v1/promotions/"+idPromotion,

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