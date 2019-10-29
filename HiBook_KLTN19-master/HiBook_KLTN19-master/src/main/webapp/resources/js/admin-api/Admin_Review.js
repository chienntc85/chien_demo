$(document).ready(function getlistreview() {
	//save table
	var table;
	//index row
	var rowclick=-1;
	//state button save -1: add, >-1: update
	var button_save=-1;
	
    $.ajax({
    	type : "GET",
    	url : "api/v1/reviews"
    }).then(function(data) {
    	var auth = ''; 
    	$.each(data, function (i, item) {	 	
    		
    		auth+='<tr><td class="star">'+item.star+'</td> ' +
                '<td class="nameBook">'+item.book.nameBook+'</td>'+
                '<td class="title">'+item.title+'</td>'+
                '<td class="content">'+item.content+'</td>'+
                '<td class="timeReview">'+item.timeReview+'</td>'+
                '<td class="reportNum">'+item.reportNum+'</td>'+
                '<td class="nameUser">'+item.user.nameUser+'</td>'+
                '<td><a href="#" data-id="'+item.idReview+'" class="btn btn-icon btn-pill btn-danger delete-review" data-toggle="tooltip" title="Delete"><i class="fa fa-fw fa-trash"></i></a>'+
                '</td></tr>';
        });
    	$('#list-review').append(auth);
    	table=$('#table-review').DataTable(); 	     
 	    
    });
    
    /*==========================*/
    /*click delete */
    $('#table-review tbody ').on( 'click', 'a.delete-review', function () {
		//get data row clicked
        var id=$(this).data('id');
        var name=$(this).closest("tr").find('.nameUser').text();
        var index= table.row( $(this).closest("tr") ).index();
        alert(id);
        $('#xoa-title').text('Bạn có chắc muốn xóa bình luận của: "'+name+'" này không?');
        deletereview(id, index);
    });
    
    /* Delete review */
    function deletereview(idReview, index){
    	$('#modalDelete').modal('toggle');
    	$('#delete-review').click(function(){
    		$('#modalDelete').modal('toggle');
    		$.ajax({
            	url : "api/v1/reviews/"+idReview,
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
    	    	   },
    	    	    500: function() {
     	    	       alert('500 EntityNotFoundException');
     	    	   }
    	    	}
            });
    	});
    }
});