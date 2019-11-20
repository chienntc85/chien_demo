$(document).ready(function getlistaddbook() {
	
	var url_string = window.location.href;
	var vars = url_string.split("/");
	var idPromotion = vars[vars.length-1];
	var them=true;
	var hinh;
	var docthu;
	var names = [];
	var projects = [];
	var arr_books = [];

	/*Custom Date */
	$('input[id$=dateStart]').datepicker({
	    dateFormat: 'yy-mm-dd'
	});
	$('input[id$=dateEnd]').datepicker({
		dateFormat: 'yy-mm-dd'
	});
	
	/* Get All Book*/
    var autocomplete = function(element, data) {
    	$.ajax({
    		type : "GET",
    		url : "/HiBook_KLTN19/api/v1/books"
    	}).then(function(data) {
    		projects = data;
    	});
    	 element.autocomplete({
    	        minLength: 0,
    	        source: function(request, response) {
    	            var matcher = new RegExp($.ui.autocomplete.escapeRegex(request.term), "i");
    	            response($.grep(projects, function(value) {
    	                return matcher.test(value.nameBook);
    	            }));
    	        },
    	        create: function() {
    	            element.val(projects.nameBook);
    	        },
    	        focus: function(event, ui) {
    	            element.val(ui.item.nameBook);
    	            return false;
    	        },
    	        select: function(event, ui) {
    	        	$( "#project" ).val( ui.item.nameBook );
    				$( "#project-id" ).val( ui.item.idBook );
    				$( "#project-icon" ).attr( "src", "/HiBook_KLTN19/resources/images/book/" + ui.item.picBook );
    				
    				return false;
    	        }
    	    }).autocomplete( "instance" )._renderItem = function( ul, item ) {
    			return $( "<li>" )
    			.append( "<div><img style='width: 30px;' src='/HiBook_KLTN19/resources/images/book/" + item.picBook + "' alt=''> " + item.nameBook + "<br></div>" )
    			.appendTo( ul );
    		};/*.data('autocomplete')._renderItem = function(ul, item) {
    		 
	    		 return $('<li></li>')
	             .data('item.autocomplete', item)
	             .append( "<a><img style='width: 30px;' src='resources/images/book/" + item.picBook + "' alt=''> " + item.nameBook + "<br></a>" )
	             .appendTo(ul);
	    	 };*/
    };
	autocomplete($('#project'));
	
	/*Load info of object if case is "EDIT" */
	if(idPromotion!=''&&idPromotion!='add-promotion'){
		$.ajax({
			type : "GET",
			url : "/HiBook_KLTN19/api/v1/promotions/"+idPromotion
		}).then(function(data) {
			$('#title').val(data.titlePromotion);
			$('#discount').val(data.saleOff);
			$('#dateStart').val(data.timeStart);
			$('#dateEnd').val(data.timeEnd);
			CKEDITOR.instances.intro.setData(data.contentPromotion);
			hinh=data.picPromotion;
			//Books
			arr_books = [];
			$.each(data.books, function(i,item){
				//add into table
				var strBookRow = '<tr><td><img style="width: 60px;" src="/HiBook_KLTN19/resources/images/book/' + item.picBook + '"></td><td class="nameBook" data-id="'+item.idBook+'">'+item.nameBook+'</td>'+
						'<td><a href="javascript:void(0);" class="btn btn-icon btn-pill btn-danger del_book"><i class="fa fa-fw fa-trash"></i></a>'+
		                '</td></tr>';
				$('#lstBookPromotion').append(strBookRow);
				//them id vao arr_books
				arr_books[arr_books.length]=item.picBook; 
			});
		});
		them=false;
	}

	/*Upload Img*/
	var imgfiles =[];
	$('#file-multiple-img').change(function(event){
		$('#progressBarImg').text('0%');
		$('#progressBarImg').css('width','0%');
		imgfiles = event.target.files;
		forms=new FormData();
		forms.append("file", imgfiles[0]);
		$.ajax({
			type : "POST",
			url : "/HiBook_KLTN19/api/v1/upload-img-promotion",
			data: forms,
			contentType: false,
			processData: false,
			enctype: "multipart/form-data",
			xhr: function(){
				//Get XmlHttpRequest object
				var xhr = $.ajaxSettings.xhr() ;

				//Set onprogress event handler 
				xhr.upload.onprogress = function(event){
					var perc = Math.round((event.loaded / event.total) * 100);
					$('#progressBarImg').text(perc + '%');
					$('#progressBarImg').css('width',perc + '%');
				};
				return xhr ;
			}
		}).then(function(data) {
			$('#file-multiple-img').text(data);

		});
	});
	$("#reset_book").click(function(){
		$('#progressBarFile').text('0%');
		$('#progressBarFile').css('width','0%');
		$('#progressBarImg').text('0%');
		$('#progressBarImg').css('width','0%');
	});

	$('#BookPromotion').click(function(){
		var nameBook=$('#project').val();
		var id = $('#project-id').val();
		var img = $( "#project-icon" ).attr( "src");
		if(nameBook!='' && id !=''){
			//add into table
			var strBookRow = '<tr><td><img style="width: 60px;" src="' + img + '"></td><td class="nameBook" data-id="'+id+'">'+nameBook+'</td>'+
					'<td><a href="javascript:void(0);" class="btn btn-icon btn-pill btn-danger del_book"><i class="fa fa-fw fa-trash"></i></a>'+
	                '</td></tr>';
			$('#lstBookPromotion').append(strBookRow);
			//them id vao arr_books
			arr_books[arr_books.length]=id; 
			//reset info
			$( "#project" ).val('');
	        $( "#project-id" ).val('');
	        $( "#project-icon" ).attr( "src", "" );
	        console.log(arr_books);
		}
	});
	$('.table tbody').on( 'click', 'a.del_book', function () {
		var idClick=$(this).closest("tr").find('.nameBook').data('id');
		//alert(idClick);
		$.each(arr_books, function(i,item){
			if(item==idClick){
				arr_books[i]=arr_books[arr_books.length-1];
				arr_books.length--;
			}
		});	
		//reset
		$(this).closest("tr").remove();
		console.log(arr_books);
	});
	
	$('#submit_promotion').click(function(){
				
		var title=$('#title').val();
		var discount=$('#discount').val();
		var dateStart=$('#dateStart').val();
		var dateEnd=$('#dateEnd').val();
		var intro=CKEDITOR.instances.intro.getData();
		var file_img=$('#file-multiple-img').text();
		//alert(intro);
		
		
		if(them){
			//alert(title+"__"+discount+"__"+dateStart+"__"+dateEnd+"__"+intro+"__"+file_img+"__"+idPromotion);
			$.ajax({
				url : "/HiBook_KLTN19/api/v1/promotions",
				type : "POST",
				data:{
					title:title,
					discount:discount,
					dateStart:dateStart,
					dateEnd:dateEnd,
					intro:intro,
					fileimg:file_img,
					arr_books:arr_books
				},
				success : function(data) {
					alert('thêm thành công!');
					window.location = '/HiBook_KLTN19/manage-promotion';
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
		}else{
			if(file_img==''){
				file_img=hinh;
			}

			$.ajax({
				url : "/HiBook_KLTN19/api/v1/promotions/"+idPromotion,
				type : "PUT",
				data:JSON.stringify({
					title:title,
					discount:discount,
					dateStart:dateStart,
					dateEnd:dateEnd,
					intro:intro,
					fileimg:file_img,
					arr_books:arr_books
				}),
				headers: {
					'Accept': 'application/json',
					'Content-Type': 'application/json'
				},
				success: function(data) {
					alert('update thành công!');
					window.location = '/HiBook_KLTN19/manage-promotion';
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
	});
	
	
});


