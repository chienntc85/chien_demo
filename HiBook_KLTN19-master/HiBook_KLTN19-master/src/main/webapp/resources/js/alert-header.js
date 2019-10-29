// alert thongbao
$('.thongbao').html('<div class="alert alert-success" role="alert"><i class="far fa-check-circle"></i> Thay đổi thành công!!!</div>');
$('.thongbao').fadeIn();
setTimeout(function() {
	
	$('.thongbao').fadeOut(function() {
		$('.thongbao').empty();
	});
}, 1000);