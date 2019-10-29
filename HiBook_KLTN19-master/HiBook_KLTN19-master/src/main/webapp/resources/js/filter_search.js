$(document).ready(function() {
	//get element last path, to get list book corresponding to require
	var url = window.location;
	var pathName = url.pathname.substring(url.pathname.lastIndexOf('/') + 1, url.pathname.length);
	if(pathName.length == 1){
		pathName_1 = url.pathname.substring(0, url.pathname.lastIndexOf('/'));
		pathName = pathName_1.substring(pathName_1.lastIndexOf('/') + 1, pathName_1.length)+"/"+pathName;
	}else if(window.location.href.indexOf("?") > -1){
		var url_full = window.location.href;
		pathName = url_full.substring(url_full.lastIndexOf('/') + 1, url_full.length);
	}
	var size_current = 6;
	
	//get all list book as required
	var data_all = [];
	$.ajax({
    	type : "GET",
    	url : "/HiBook_KLTN19/api/v1/"+pathName
    }).then(function(data) {
    	data_all = data;
    	edit_listbook(data_all.allBooks, size_current, data_all.currentpage, data_all.currentpage+1, data_all.currentpage-1);
    });
	
	//Arrays to support search
	var publishers = [];
	var authors = [];
	var supliers = [];
	
	//Cath event change of checkbox
	$("#filter_author input[type='checkbox']").change(function(){
		var current_check = $(this).data('author');
		if ($(this).is(':checked')) {
			authors.push(current_check);
		}else{
			authors = jQuery.grep(authors, function(value) {
			  return value != current_check;
			});
		}
		//filter follow change of checkbox just selected
		var search = filter_search(publishers , authors, supliers, data_all.allBooks);
		//Change display list book 
		edit_listbook(search, size_current, data_all.currentpage, data_all.currentpage+1, data_all.currentpage-1);
		
	});
	$("#filter_supplier input[type='checkbox']").change(function(){
		var current_check1 = $(this).data('supplier');
		if ($(this).is(':checked')) {
			supliers.push(current_check1);
		}else{
			supliers = jQuery.grep(supliers, function(value) {
			  return value != current_check1;
			});
		}
		var search = filter_search(publishers , authors, supliers, data_all.allBooks);
		edit_listbook(search, size_current, data_all.currentpage, data_all.currentpage+1, data_all.currentpage-1);
		console.log(search);
		
	});
	$("#filter_publisher input[type='checkbox']").change(function(){
		var current_check2 = $(this).data('publisher');
		if ($(this).is(':checked')) {
			 publishers.push(current_check2);
		}else{
			publishers = jQuery.grep(publishers, function(value) {
			  return value != current_check2;
			});
		}
		var search = filter_search(publishers , authors, supliers, data_all.allBooks);
		edit_listbook(search, size_current, data_all.currentpage, data_all.currentpage+1, data_all.currentpage-1);
		console.log(search);
	});
	// filter
	function filter_search(publishers , authors, supliers, data_alll){
		var data_all_1 = data_alll;
		if(authors.length !== 0){
			data_all_1 = data_all_1.filter(function(item) {
				  for (var value in authors) {
					  for (var item_author in item.authors) {
					    if (item.authors[item_author]['nameAuthor'] !== undefined && item.authors[item_author]['nameAuthor'] === authors[value])
					      return true;//
					  }
				  }
			  return false;
			});
		}
		if(publishers.length !== 0){
			data_all_1 = data_all_1.filter(function(item) {
				  for (var value in publishers) {
				    if (item['publisher'] !== undefined && item['publisher'] === publishers[value])
				      return true;//
				  }
			  return false;
			});
		}
		if(supliers.length !== 0){
			data_all_1 = data_all_1.filter(function(item) {
				  for (var value in supliers) {
					  for (var item_supplier in item.supplier) {
					    if (item.supplier[item_supplier] !== undefined && item.supplier[item_supplier] === supliers[value])
					      return true;
					  }
				  }
			  return false;
			});
		}
		return data_all_1;
	}
	//done change dispay listbook and pagination
	function edit_listbook(filter_search, size, page, next, pre){
		//show list book
		$("#list_search").empty();
		var sp_search='';
		$.each(filter_search, function (i, item) {
			if((page-1)*6 <= i && i < (((page-1)*6)+6))
			{
				sp_search+='<div class="col-sm-6 col-md-4 " style="margin-bottom: 20px;"><div class="sanpham"><div class="thumbnail entry">'
					+'<a href="/HiBook_KLTN19/detail-book/'+item.idBook+'" class="non-textdecoration" target="_blank"><div id="hinh" class="img_center">'
					+'<img src="/HiBook_KLTN19/resources/images/book/'+item.picBook+'" alt="Nature"></div></a>'
					+'</div><div class="h"><span id="NameSP">'+item.nameBook+'</span><br /><span style="color: #8a8787; padding: 10px; font-size: 14px;">';
				$.each(item.authors, function (i, author) {
					sp_search += author.nameAuthor+" ";
				});
				sp_search+='</span><br/><span style="color: black; padding: 10px; font-size: 14px;">'+Math.round(item.price*(1-item.discount/100))+'đ</span>'
					+'<span style="color: grey; padding: 15px; font-size: 12px; text-align: center;"><del>'+item.price+'đ</del></span>'
					+'<span style="color: red; padding: 16px; font-size: 12px; text-align: right !important;">-'+item.discount+'%</span><br /></div></div></div>';
			}

	    });
		$("#list_search").append(sp_search);
		//edit pagination
		pagination(filter_search.length <= size ? 1 : (filter_search.length/size+1), page, next, pre)
	}
	//edit pagination
	function pagination(total, page, next, pre){
		var page_pagination = '';
		$(".pagination").empty();
		if(pre < 1){
			page_pagination += '<li class="disabled"><a>«</a></li>';
		}else {
			var newurl1 = window.location.href + "/" + pre;
			page_pagination += '<li><a data-page="'+pre+'">«</a></li>';
		}
		for(var i = 1 ; i <= total ; i++){
			var newurl = window.location.href + "/" + i;
			if(page == i){
				page_pagination+='<li class="active"><a data-page="'+i+'">'+i+' <span class="sr-only">(current)</span></a></li>';
			}else{
				page_pagination+='<li ><a data-page="'+i+'">'+i+' <span class="sr-only">(current)</span></a></li>';
			}
		}
		if(next > total){
			page_pagination += '<li class="disabled"><a href="#">»</a></li>';
		}else{
			var newurl2 = window.location.href + "/" + next;
			page_pagination += '<li class=""><a data-page="'+next+'">»</a></li>';
		}
		
		$('.pagination').append(page_pagination);
	}
	
	//get event click move page
	$('#right_pagination ul').on( 'click', 'li a', function () {
		var page_change = $(this).data('page');
		var search = filter_search(publishers , authors, supliers, data_all.allBooks);
		edit_listbook(search, size_current, page_change, page_change+1, page_change-1);
	});

});