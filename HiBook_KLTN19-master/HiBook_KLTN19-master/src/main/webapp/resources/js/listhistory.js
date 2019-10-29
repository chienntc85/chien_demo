$(document).ready(function() {
	
	$.ajax({
    	type : "GET",
    	url : "/HiBook_KLTN19/api/v1/history"
    }).then(function(data) {
    	var row1 = '';
    	var row2 = '';
    	var row3 = '';
    	$.each(data, function (i, item) {
			if(i<4){
				row1+='<div class="col-sm-6 col-md-3 tintucHome"><div class="sanpham"><div class="thumbnail entry">'+
    			'<a href="detail-book/'+item.idBook+'" class="non-textdecoration" target="_blank"><div id="hinh" class="img_center"><img src="resources/images/book/'+item.picBook+'" alt="Nature">'
				+'</div></a></div><div class="h"><span id="NameSP">'+item.nameBook+
				'</span><br/><span style="color: #8a8787; padding: 10px; font-size: 14px;">'+( item.authors[0].nameAuthor)+
				'</span><br/><span style="color: black; padding: 10px; font-size: 14px;">'+(((item.price)*(item.discount))/100)+'đ'+
				'</span><span style="color: grey; padding: 15px; font-size: 12px; text-align: center;"><del>'+(item.price)+'đ'+
				'</del></span><span style="color: red; padding: 16px; font-size: 12px; text-align: right !important;">'+
				'-'+item.discount+'%'+
				'</span><br/></div></div></div>';
			}else if(i>=4 && i<8){
				row2+='<div class="col-sm-6 col-md-3 tintucHome"><div class="sanpham"><div class="thumbnail entry">'+
    			'<a href="detail-book/'+item.idBook+'" class="non-textdecoration" target="_blank"><div id="hinh" class="img_center"><img src="resources/images/book/'+item.picBook+'" alt="Nature">'
				+'</div></a></div><div class="h"><span id="NameSP">'+item.nameBook+
				'</span><br/><span style="color: #8a8787; padding: 10px; font-size: 14px;">'+( item.authors[0].nameAuthor)+
				'</span><br/><span style="color: black; padding: 10px; font-size: 14px;">'+(((item.price)*(item.discount))/100)+'đ'+
				'</span><span style="color: grey; padding: 15px; font-size: 12px; text-align: center;"><del>'+(item.price)+'đ'+
				'</del></span><span style="color: red; padding: 16px; font-size: 12px; text-align: right !important;">'+
				'-'+item.discount+'%'+
				'</span><br/></div></div></div>';
			}else if(i>=8 && i<12){
				row3+='<div class="col-sm-6 col-md-3 tintucHome"><div class="sanpham"><div class="thumbnail entry">'+
    			'<a href="detail-book/'+item.idBook+'" class="non-textdecoration" target="_blank"><div id="hinh" class="img_center"><img src="resources/images/book/'+item.picBook+'" alt="Nature">'
				+'</div></a></div><div class="h"><span id="NameSP">'+item.nameBook+
				'</span><br/><span style="color: #8a8787; padding: 10px; font-size: 14px;">'+( item.authors[0].nameAuthor)+
				'</span><br/><span style="color: black; padding: 10px; font-size: 14px;">'+(((item.price)*(item.discount))/100)+'đ'+
				'</span><span style="color: grey; padding: 15px; font-size: 12px; text-align: center;"><del>'+(item.price)+'đ'+
				'</del></span><span style="color: red; padding: 16px; font-size: 12px; text-align: right !important;">'+
				'-'+item.discount+'%'+
				'</span><br/></div></div></div>';
			}
    		
        });
    	$('#loadhistory0').append(row1);
    	$('#loadhistory1').append(row2);
    	$('#loadhistory2').append(row3);
    	//edit_listbook(data, 9, data.length/9, 0, 1)
    });
	
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