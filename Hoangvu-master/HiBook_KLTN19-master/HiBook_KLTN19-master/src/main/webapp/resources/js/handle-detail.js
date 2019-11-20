$(document).ready(function() {

	var url_string = window.location.href;
	var vars = url_string.split("/");
	var idSach = vars[vars.length - 1];
	var gia = 0;
	$.ajax({
		type : "GET",
		url : "/HiBook_KLTN19/api/v1/books/" + idSach
	}).then(function(data) { 
				//$('#post-review-box form').attr('action', '/HiBook_KLTN19/add-review/'+idSach);
				if(data.quantity < 1){
					$('#btn-purchase').html('<i class="fas fa-ban"></i> Hết Tour');
				}
				$('.item-photo').append(
						'<img style="max-width:100%;" src="../resources/images/book/'
						+ data.picBook + '" />');
				$('#tensach').text(data.nameBook);
				$('#tensach').attr('data-type',data.typebook.idType);
				$('#giaban').text(data.price * (100 - data.discount) / 100 + " đ");
				$('#giamgia').text(data.discount + "%");
				$('#giagoc small').text("Giá tour: "+ data.price+ " đ");
				gia = data.price;
				$('#tab_default_1').append('<p style="font-weight: bold;">'
						+ data.nameBook+ '</p><p>'+ data.introBook+ '</p>');
				$('#table_chitiet')
				.append('<tbody><tr>'
						+ '<th style="width: 25%">Công ty phát hành</th><td><a href="#">'
						+ data.supplier.nameSupplier + '</a></td>'
						+ '</tr><tr><th>Lịch trình</th><td><a id="tacgia1" href="#"></a></td>'
						+ '</tr><tr><th >Địa điểm xuất phát	</th><td>'
						+ data.publisher + '</td></tr>'
						+ '<tr><th >Ngày khởi hành</th><td>'
						+ data.publicationDate + '</td></tr>'
						+ '<tr><th >Kích thước hành lý</th><td>'
						+ data.size + '</td></tr>'
						+ '<tr><th >Số người</th><td>'
						+ data.numberPage + '</td></tr>'
						+ '<tr><th >Phương tiện</th><td>'
						+ data.cover + '</td></tr></tbody>');
				var text_author = "";
				$.each(data.authors, function(i, item) {
					text_author += item.nameAuthor
					+ " ";
				});
				$('#tacgia').text(text_author);
				$('#tacgia1').text(text_author);
				// $('.h').append(trHTML);
				var text_review = "";
				var star_number=0;
				var dem=0;
				var star_arr = [0,0,0,0,0];
				$.each(data.userreviews,function(i, item) {
					var start = "";
					for (var st = 0; st < item.star; st++) {
						start += '<span class="fa fa-star checked"></span>';
					}
					star_number+=item.star;
					star_arr[item.star-1] = star_arr[item.star-1]+1;
					dem++;
					text_review += '<h4>' + item.user.nameUser + ' - ' + item.title + '</h4>'
					+ '<div class="stars">' + start + '</div>'
					+ '<p class="review-text">' + item.content + '</p>'
					+ '<small class="review-date">' + item.timeReview + '</small>'
					+ '<a href="#" style="color: #404040; font-weight: 600;"> Báo cáo</a><hr/>';
				});
				var count = data.userreviews.length;
				console.log(star_arr);
				if(count != 0){
					$('#thongke1').html(Math.ceil(star_arr[0]*100/count) +"%");
					$('#thongke1_id').width(Math.ceil(star_arr[0]*100/count) +"%");
					$('#thongke2').html(Math.ceil(star_arr[1]*100/count) +"%");
					$('#thongke2_id').width(Math.ceil(star_arr[1]*100/count) +"%");
					$('#thongke3').html(Math.ceil(star_arr[2]*100/count) +"%");
					$('#thongke3_id').width(Math.ceil(star_arr[2]*100/count) +"%");
					$('#thongke4').html(Math.ceil(star_arr[3]*100/count) +"%");
					$('#thongke4_id').width(Math.ceil(star_arr[3]*100/count) +"%");
					$('#thongke5').html(Math.ceil(star_arr[4]*100/count) +"%");
					$('#thongke5_id').width(Math.ceil(star_arr[4]*100/count) +"%");
				}
				$('#TryRead>a').data('value',data.proofread);
				if(data.proofread == '' || data.proofread == null || data.proofread.length == 0)
				{
					$('#TryRead a').remove();
				}	
				$('#mucreview').append(text_review);
				var star_tb=star_number/dem;

				for(var i=0;i<5;i++){
					if(i<star_tb){
						$("#start_tb").text(i+1);
						$('.rating-block').append('<span class="glyphicon glyphicon-star checked"></span>');
						$('#star_header').append('<span class="glyphicon glyphicon-star checked"></span>');
					}else{
						$('.rating-block').append('<span class="glyphicon glyphicon-star"></span>');
						$('#star_header').append('<span class="glyphicon glyphicon-star"></span>');
					}
				}
				$('#star_header').append('<small style="color: #337ab7">('+count+' đánh giá)</small>');
				
				/*Get book same type */
				var idType=$('#tensach').data('type');
				$.ajax({
					type : "GET",
					url : "/HiBook_KLTN19/api/v1/search-by-type",
					data:{
						type:idType
					}
				}).then(function(data) {
					var sp1='';
					var sp2='';
					$.each(data,function(i, item) {
						if(i<4){
							sp1+='<div class="col-xs-3 col-sm-3"><a href="/HiBook_KLTN19/detail-tour/'+item.idBook+'" class="thumbnail">'
								+'<img src="/HiBook_KLTN19/resources/images/book/'	+ item.picBook + '" alt="Image" style="max-height: 234px; max-width: 100%;"></a></div>';
						}else if(i>3&&i<8){
							sp2+='<div class="col-xs-3 col-sm-3"><a href="/HiBook_KLTN19/detail-tour/'+item.idBook+'" class="thumbnail">'
								+'<img src="/HiBook_KLTN19/resources/images/book/'	+ item.picBook + '" alt="Image" style="max-height: 234px; max-width: 100%;"></a></div>';
						}
					});
					if(data.length <= 4){
						//$('#Carousel').						
						$("a.left").remove();
						$("a.right").remove();
						$('#Carousel').carousel('pause');
					}
					$('#sp_type1').append(sp1);
					$('#sp_type2').append(sp2);
				});
			});

	$("#TryRead").click(function () { 
		var file=$('#TryRead a').data('value');
		if(file == '' || file == null || file.length == 0)
		{
			
		}else{$("#frame").attr("src", '/HiBook_KLTN19/resources/images/file/'+file);}
	});
	
	//click buy book (*)
	$("#btn-purchase").click(function() {
		
		var amount = $("#get-quantity").val();
		var quantity = $(".section > div > input").val();
		$.ajax({
			url : "/HiBook_KLTN19/api/v1/numCart/" + idSach,
			type : "GET",
			data : {
				price : gia,
				amount : amount
			},
			success : function(data) {
				if(data != -1) {
					//alert("Đã thêm vào giỏ!");
					$(".giohang_circle").find("span").text(data);
					// alert thongbao
					$('.thongbao').html('<div class="top-alert"><div class="alert alert-success" role="alert"><i class="far fa-check-circle"></i> Đã thêm vào giỏ!</div></div>');
					$('.thongbao').fadeIn();
					setTimeout(function() {
						
						$('.thongbao').fadeOut(function() {
							$('.thongbao').empty();
						});
					}, 2000);
				}
				else{
					// alert thongbao
					$('.thongbao').html('<div class="top-alert"><div class="top-alert alert alert-danger" role="alert"><i class="far fa fa-times"></i> Bạn vui lòng đăng nhập trước để mua hàng!!!</div></div>');
					$('.thongbao').fadeIn();
					setTimeout(function() {
						
						$('.thongbao').fadeOut(function() {
							$('.thongbao').empty();
						});
					}, 2000);
				}
			}
		});
	});
	//click review
	$('#review').click(function(){
		var star_review = $('#ratings-hidden').val();
		var title_review = $('#title_review_write').val();
		var content_review = $('#new-review').val();
		$.ajax({
			url : "/HiBook_KLTN19/api/v1/userreiew/" + idSach,
			type : "POST",
			data : {
				star : star_review,
				title : title_review,
				content : content_review
			},
			success : function(data) {
				if(data != -1) {
					//alert("Đã thêm vào giỏ!");
					$(".giohang_circle").find("span").text(data);
					// alert thongbao
					$('.thongbao').html('<div class="top-alert"><div class="alert alert-success" role="alert"><i class="far fa-check-circle"></i> Cảm ơn bạn đã để lại bình luận!</div></div>');
					$('.thongbao').fadeIn();
					setTimeout(function() {
						
						$('.thongbao').fadeOut(function() {
							$('.thongbao').empty();
						});
					}, 2000);
				}
				else{
					// alert thongbao
					$('.thongbao').html('<div class="top-alert"><div class="alert alert-danger" role="alert"><i class="far fa fa-times"></i> Bạn vui lòng đăng nhập trước!!!</div></div>');
					$('.thongbao').fadeIn();
					setTimeout(function() {
						
						$('.thongbao').fadeOut(function() {
							$('.thongbao').empty();
						});
					}, 2000);
				}
			}
		});
	});
});
