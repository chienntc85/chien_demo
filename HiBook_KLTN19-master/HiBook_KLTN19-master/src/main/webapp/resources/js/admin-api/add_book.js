$(document).ready(function getlistaddbook() {

	var url_string = window.location.href;
	var vars = url_string.split("/");
	var idBook = vars[vars.length-1];
	var them=true;
	var hinh;
	var docthu;
	var tagsubmit = [];

	/* Get Author Book*/
	$.ajax({
		type : "GET",
		url : "/HiBook_KLTN19/api/v1/authors"
	}).then(function(data) {
		var auth = '';    	
		$.each(data, function (i, item) {	 	
			auth+='<option data-id="'+item.idAuthor+'" value="'+item.nameAuthor+'">'+item.nameAuthor+'</option>';
		});
		$('select#idAuthor').append(auth);
	});

	if(idBook!=''&&idBook!='add-book'){
		$.ajax({
			type : "GET",
			url : "/HiBook_KLTN19/api/v1/books/"+idBook
		}).then(function(data) {
			$('#nameBook').val(data.nameBook);
			$('#price').val(data.price);
			$('#discount').val(data.discount);
			$('#publisher').val(data.publisher);
			$('#size').val(data.size);
			$('#numberPage').val(data.numberPage);
			$('#publicationDate').val(data.publicationDate);
			$('#quantity').val(data.quantity);
			$('.radio input:checked').val(data.cover);
			if(data.cover=='Bìa mềm'){
				$('.radio input:radio[name=cover][id="radio1"]').attr('checked', true);
				$('.radio input:radio[name=cover][id="radio2"]').attr('checked', false);
			}else{
				$('.radio input:radio[name=cover][id="radio2"]').attr('checked', true);
				$('.radio input:radio[name=cover][id="radio1"]').attr('checked', false);
			}
			CKEDITOR.instances.intro.setData(data.introBook);
			hinh=data.picBook;
			docthu=data.proofread;
			$("#idType option[value='" + data.typebook.idType +"']").attr("selected","selected");
			$("#idSupplier option[data-id='" + data.supplier.idSupplier +"']").attr("selected","selected");
			//author
			var arr1=data.authors;
			var add='';
			$.each(arr1, function (i, item) {
				/*var name=$('#idAuthor > option[data-id='+arr1[i]+']').text();*/
				add+='<div class="alert alert-info alert-dismissible fade show" style="width:max-content; margin-right: 4px; display: -webkit-inline-box;">'+
				'<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>'+
				'<strong data-id="'+item.idAuthor+'">'+item.nameAuthor+'</strong></div>';
				arr[arr.length]=item.idAuthor;
			});
			$('#arr_author').append(add);
			//tagsearch
			var arr2 = data.tagList.split(",");
			var add1 = '';
			$.each(arr2, function (i, item) {
				/*var name=$('#idAuthor > option[data-id='+arr1[i]+']').text();*/
				add1+='<div class="alert alert-info alert-dismissible fade show" style="width:max-content; margin-right: 4px; display: -webkit-inline-box;">'+
				'<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>'+
				'<strong>'+item+'</strong></div>';
				tagsubmit[tagsubmit.length] = item;
			});
			$('#arr_tag').append(add1);
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
			url : "/HiBook_KLTN19/api/v1/upload-img",
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
	var files =[];
	$('#file-multiple-proofread').change(function(event){
		$('#progressBarFile').text('0%');
		$('#progressBarFile').css('width','0%');
		files = event.target.files;
		forms=new FormData();
		forms.append("file", files[0]);
		$.ajax({
			type : "POST",
			url : "/HiBook_KLTN19/api/v1/upload-img",
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
					$('#progressBarFile').text(perc + '%');
					$('#progressBarFile').css('width',perc + '%');
				};
				return xhr ;
			}
		}).then(function(data) {
			$('#file-multiple-proofread').text(data);
		});
	});
	$("#reset_book").click(function(){
		$('#progressBarFile').text('0%');
		$('#progressBarFile').css('width','0%');
		$('#progressBarImg').text('0%');
		$('#progressBarImg').css('width','0%');
	});
	
	/* Event selected author*/
	var arr=[];
	$('#idAuthor').change(function(){
		var optionSelected = $("option:selected", this);
		var valueSelected = this.value;
		var id=$("#idAuthor option:selected").data('id');
		/* $("#idAuthor option:selected").hide();
       var add = '<div class="alert alert-info alert-dismissible fade show" style="width:max-content; margin-right: 4px; display: -webkit-inline-box;">'+
  		    '<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>'+
  		    '<strong data-id="'+id+'">'+valueSelected+'</strong></div>';
   		   arr[arr.length]=id; */
		var add='';
		if(arr.length==0){
			add='<div class="alert alert-info alert-dismissible fade show" style="width:max-content; margin-right: 4px; display: -webkit-inline-box;">'+
			'<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>'+
			'<strong data-id="'+id+'">'+valueSelected+'</strong></div>';
			arr[arr.length]=id; 
		}else{
			var flag=0;
			$.each(arr, function(i,item){
				if(item==id){
					flag=1;
				}
			})
			if(flag==0){
				add='<div class="alert alert-info alert-dismissible fade show" style="width:max-content; margin-right: 4px; display: -webkit-inline-box;">'+
				'<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>'+
				'<strong data-id="'+id+'">'+valueSelected+'</strong></div>';
				arr[arr.length]=id;
			}
		}

		$('#arr_author').append(add);
	});
	$('#arr_author').on('click', 'a.close',function(){
		var id=$(this).parent('div').find('strong').data('id');
		alert(id);
		$.each(arr, function(i,item){
			if(item==id){
				arr[i]=arr[arr.length-1];
				arr.length--;
			}
		})
	});
	
	/*Event enter in input Tagsearch*/
	$("#tagSearch").keypress(function(event){
	    var keycode = (event.keyCode ? event.keyCode : event.which);
	    var tag = $('#tagSearch').val().trim();
	    if(keycode == '13' && tag !== ""){
	        var listTag = '<div class="alert alert-info alert-dismissible fade show" style="width:max-content; margin-right: 4px; display: -webkit-inline-box;">'+
			'<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>'+
			'<strong>'+tag+'</strong></div>';
	        $('#arr_tag').append(listTag);
	        tagsubmit[tagsubmit.length] = tag;
	        $('#tagSearch').val('');
	    }
	});
	$('#arr_tag').on('click', 'a.close',function(){
		var name = $(this).parent('div').find('strong').html();
		$.each(tagsubmit, function(i,item){
			if(item==name){
				tagsubmit[i]=tagsubmit[tagsubmit.length-1];
				tagsubmit.length--;
			}
		});
	});
	
	$('#submit_book').click(function(){
		var nameBook=$('#nameBook').val();
		var price=$('#price').val();
		var discount=$('#discount').val();
		var publisher=$('#publisher').val();
		var size=$('#size').val();
		var numberPage=$('#numberPage').val();
		var publicationDate=$('#publicationDate').val();
		var quantity=$('#quantity').val();
		var cover= $('.radio input:radio[name=cover][checked="checked"]').val();
		var intro=CKEDITOR.instances.intro.getData();
		var idType= $('#idType option:selected').val();
		var idSup= $('#idSupplier option:selected').data('id');
		var file_img=$('#file-multiple-img').text();
		var file_proofread=$('#file-multiple-proofread').text();

		if(them){
			$.ajax({
				url : "/HiBook_KLTN19/api/v1/books",
				type : "POST",
				data:{
					publisher:publisher,
					nameBook:nameBook,
					price:price,
					discount:discount,
					size:size,
					numberPage:numberPage,
					publicationDate:publicationDate,
					quantity:quantity,
					cover:cover,
					intro:intro,
					fileimg:file_img,
					fileproofread:file_proofread,
					idType:idType,
					idSupplier:idSup,
					arr_author:arr,
					tags : tagsubmit.toString()
				},
				success : function(data) {
					alert('thêm thành công!');
					window.location = '/HiBook_KLTN19/manage-book';
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
			if(file_proofread=='')
			{
				file_proofread=docthu;
			}

			$.ajax({
				url : "/HiBook_KLTN19/api/v1/books/"+idBook,
				type : "PUT",
				data:JSON.stringify({
					publisher:publisher,
					nameBook:nameBook,
					price:price,
					discount:discount,
					size:size,
					numberPage:numberPage,
					publicationDate:publicationDate,
					quantity:quantity,
					cover:cover,
					intro:intro,
					fileimg:file_img,
					fileproofread:file_proofread,
					idType:idType,
					idSupplier:idSup,
					arr_author:arr,
					tags : tagsubmit.toString()
				}),
				headers: {
					'Accept': 'application/json',
					'Content-Type': 'application/json'
				},
				success: function(data) {
					alert('update thành công!');
					window.location = '/HiBook_KLTN19/manage-book';
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


