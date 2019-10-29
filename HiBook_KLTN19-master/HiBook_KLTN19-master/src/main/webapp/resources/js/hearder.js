$(document).ready(function() {
	/*===============Chung nhiều trang================================MUCH Using menu*/
	$('input.gtm_search_bar').keyup(function(e){
		if(e.keyCode == 13)
		{
			var key=$(this).val();
			window.location="/HiBook_KLTN19/search-key?key="+key;
		}
	});
	$.ajax({
		type : "GET",
		url : "/HiBook_KLTN19/api/v1/typebooks"
	}).then(function(data) {
		var type = '';    	
		$.each(data, function (i, item) {	 	
			type+='<li><a href="/HiBook_KLTN19/search-type/'+item.idType+'">'+item.nameType+'</a></li>';
		});
		$('#typeBook').append(type); 
	});
	$(".getthongbao").each(
			function() {
				$.ajax({
					url : "/HiBook_KLTN19/api/v1/numCart/",
					type : "GET",
					success : function(data) {
						if (data != null) {
							// alert(data);
							$("#giohanghome").find("span")
							.text(data);
						}
					}

				})

			});
	
});