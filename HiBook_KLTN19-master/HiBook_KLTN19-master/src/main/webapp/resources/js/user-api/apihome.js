$(document).ready(function() {
	
	/*======== Best selling books==========*/
    $.ajax({
    	type : "GET",
    	url : "/HiBook_KLTN19/api/v1/bestsells"
    }).then(function(data) {
    	var row1 = '';
    	var row2 = '';
    	$.each(data, function (i, item) {
    		if(i<4){
    			row1 += '<div class="col-sm-6 col-md-3 tintucHome" style="margin-top: 20px;"><div class="sanpham"><div class="thumbnail entry"><a href="detail-tour/'+item.idBook+'" class="non-textdecoration" target="_blank"><div id="hinh" class="img_center"><img src="resources/images/book/'+item.picBook+'" alt="Nature">'
				+'</div></a></div><div class="h"><span id="NameSP">'+item.nameBook+
				'</span><br/><span style="color: #8a8787; padding: 10px; font-size: 14px;"></span><br/><span style="color: black; padding: 10px; font-size: 14px;">'+(((item.price)*(item.discount))/100)+'đ'+
				'</span><span style="color: grey; padding: 15px; font-size: 12px; text-align: center;"><del>'+(item.price)+'đ'+
				'</del></span><span style="color: red; padding: 16px; font-size: 12px; text-align: right !important;">'+
				'-'+item.discount+'%'+
				'</span><br/></div></div></div>';
    			
    		}
    		else if(i<8 && i>=4){
    			row2 += '<div class="col-sm-6 col-md-3 tintucHome" style="margin-top: 20px;"><div class="sanpham"><div class="thumbnail entry"><a href="detail-tour/'+item.idBook+'" class="non-textdecoration" target="_blank"><div id="hinh" class="img_center"><img src="resources/images/book/'+item.picBook+'" alt="Nature">'
				+'</div></a></div><div class="h"><span id="NameSP">'+item.nameBook+
				'</span><br/><span style="color: #8a8787; padding: 10px; font-size: 14px;"></span><br/><span style="color: black; padding: 10px; font-size: 14px;">'+(((item.price)*(item.discount))/100)+'đ'+
				'</span><span style="color: grey; padding: 15px; font-size: 12px; text-align: center;"><del>'+(item.price)+'đ'+
				'</del></span><span style="color: red; padding: 16px; font-size: 12px; text-align: right !important;">'+
				'-'+item.discount+'%'+
				'</span><br/></div></div></div>';
    			
    		}
    		
        });
    	$('#loadtrangchu').append(row1);
    	$('#loadtrangchu1').append(row2);
    });
    /*======Sách mới xuất bản========= */
    $.ajax({
    	type : "GET",
    	url : "/HiBook_KLTN19/api/v1/newbook"
    }).then(function(data) {
    	var row3 = '';
    	var row4 = '';
    	$.each(data, function (i, item) {
    		if(i<4){
    			row3 += '<div class="col-sm-6 col-md-3 tintucHome" style="margin-top: 20px;"><div class="sanpham"><div class="thumbnail entry">'+
    			'<a href="detail-tour/'+item.idBook+'" class="non-textdecoration" target="_blank"><div id="hinh" class="img_center"><img src="resources/images/book/'+item.picBook+'" alt="Nature">'
				+'</div></a></div><div class="h"><span id="NameSP">'+item.nameBook+
				'</span><br/><span style="color: #8a8787; padding: 10px; font-size: 14px;">'+( item.authors[0].nameAuthor)+
				'</span><br/><span style="color: black; padding: 10px; font-size: 14px;">'+(((item.price)*(item.discount))/100)+'đ'+
				'</span><span style="color: grey; padding: 15px; font-size: 12px; text-align: center;"><del>'+(item.price)+'đ'+
				'</del></span><span style="color: red; padding: 16px; font-size: 12px; text-align: right !important;">'+
				'-'+item.discount+'%'+
				'</span><br/></div></div></div>';
    		}
    		else if(i<8 && i>=4){
    			row4 += '<div class="col-sm-6 col-md-3 tintucHome" style="margin-top: 20px;"><div class="sanpham"><div class="thumbnail entry">'+
    			'<a href="detail-tour/'+item.idBook+'" class="non-textdecoration" target="_blank"><div id="hinh" class="img_center"><img src="resources/images/book/'+item.picBook+'" alt="Nature">'
				+'</div></a></div><div class="h"><span id="NameSP">'+item.nameBook+
				'</span><br/><span style="color: #8a8787; padding: 10px; font-size: 14px;">'+( item.authors[0].nameAuthor)+
				'</span><br/><span style="color: black; padding: 10px; font-size: 14px;">'+(((item.price)*(item.discount))/100)+'đ'+
				'</span><span style="color: grey; padding: 15px; font-size: 12px; text-align: center;"><del>'+(item.price)+'đ'+
				'</del></span><span style="color: red; padding: 16px; font-size: 12px; text-align: right !important;">'+
				'-'+item.discount+'%'+
				'</span><br/></div></div></div>';
    		}
        });
    	$('#booknew0').append(row3);
    	$('#booknew1').append(row4);
    	/*======== Get History of User==========*/
    	$.ajax({
			url : "/HiBook_KLTN19/api/v1/history",
	    	type : "GET",
	    	success : function(data) {
	    		//$('#historyuser').remove();
	    		var his='';
				$.each(data,function(i, item) {
					if(i<4){
						his+='<div class="col-sm-6 col-md-3 tintucHome"><div class="sanpham"><div class="thumbnail entry">'+
		    			'<a href="detail-tour/'+item.idBook+'" class="non-textdecoration" target="_blank"><div id="hinh" class="img_center"><img src="resources/images/book/'+item.picBook+'" alt="Nature">'
						+'</div></a></div><div class="h"><span id="NameSP">'+item.nameBook+
						'</span><br/><span style="color: #8a8787; padding: 10px; font-size: 14px;">'+( item.authors[0].nameAuthor)+
						'</span><br/><span style="color: black; padding: 10px; font-size: 14px;">'+(((item.price)*(item.discount))/100)+'đ'+
						'</span><span style="color: grey; padding: 15px; font-size: 12px; text-align: center;"><del>'+(item.price)+'đ'+
						'</del></span><span style="color: red; padding: 16px; font-size: 12px; text-align: right !important;">'+
						'-'+item.discount+'%'+
						'</span><br/></div></div></div>';
					}
				});
				$('#loadhistory').append(his);
	        },
	    	statusCode: {
	    	    404: function() {
	    	    	$('#historyuser').remove();
	    	    }
	    	}
		});
    });
});