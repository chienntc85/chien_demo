<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Home</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--bootstrap & Jquery-->
<link href="resources/css/bootstrap.css" rel="stylesheet">
<!--Icon fa-->
<link rel="stylesheet" href="resources/css/fontawesome-all.min.css">
<!--CSS-->
<link rel="stylesheet" type="text/css" href="resources/css/myhome.css" />
<link rel="stylesheet" type="text/css" href="resources/css/animate.css" />
<!-- <link rel="stylesheet" type="text/css" href="resources/css/alert.css" /> -->

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<style>
  .ui-autocomplete-category {
    font-weight: bold;
    padding: .2em .4em;
    margin: .8em 0 .2em;
    line-height: 1.5;
  }
  .ui-autocomplete{
  	z-index: 10000 !important;
  }
  </style>
</head>
<body>
	<%@ include file="_header.jsp" %>
<!--
	===========================giới thiệu====================
  -->
    <div class="container intro">
	<div class="row " >
					<div class="col-lg-3 col-md-3 col-sm-4 col-xs-12">
						<div class="single-banner">
							<div class="banner-img">
								<a href="#"><img src="<%=request.getContextPath()%>/resources/images/banner/1.png" alt="banner"></a>
							</div>
							<div class="banner-text">
								<h4>Giảm giá</h4>
								<p>Cho Tour theo nhóm</p>
							</div>
						</div>
					</div>
					<div class="col-lg-3 col-md-3 col-sm-4 col-xs-12">
						<div class="single-banner">
							<div class="banner-img">
								<a href="#"><img src="<%=request.getContextPath()%>/resources/images/banner/2.png" alt="banner"></a>
							</div>
							<div class="banner-text">
								<h4>Đảm bảo hoàn tiền</h4>
								<p>Hoàn tiền 100% nếu bạn không hài lòng</p>
							</div>
						</div>
					</div>
					<div class="col-lg-3 col-md-3 hidden-sm col-xs-12">
						<div class="single-banner">
							<div class="banner-img">
								<a href="#"><img src="<%=request.getContextPath()%>/resources/images/banner/3.png" alt="banner"></a>
							</div>
							<div class="banner-text">
								<h4>Thanh toán</h4>
								<p>Hỗ trợ thanh toán khi đặt tour</p>
							</div>
						</div>
					</div>
					<div class="col-lg-3 col-md-3 col-sm-4 col-xs-12">
						<div class="single-banner mrg-none-xs">
							<div class="banner-img">
								<a href="#"><img src="<%=request.getContextPath()%>/resources/images/banner/4.png" alt="banner"></a>
							</div>
							<div class="banner-text">
								<h4>Hỗ trợ</h4>
								<p>Gọi qua: 0868934262</p>
							</div>
						</div>
					</div>
				</div>
	</div>
	<!--
		==============================content===================================
	-->
	<!--
	=================================Slider=====================================
	-->
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>

		<!-- Wrapper for slides -->
		<div class="carousel-inner">
			<div class="item active">
				<img src="resources/images/banner/5a.jpg" alt="Hinh slide 1"
					style="width: 100%;">
			</div>

			<div class="item">
				<img src="resources/images/banner/2a.jpg" alt="Hinh slide 2"
					style="width: 100%;">
			</div>

			<div class="item">
				<img src="resources/images/banner/3a.jpg" alt="Hinh slide 3"
					style="width: 100%;">
			</div>
		</div>

		<!-- Left and right controls -->
		<a class="left carousel-control" href="#myCarousel" data-slide="prev">
			<span class="glyphicon glyphicon-chevron-left"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#myCarousel"
			data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right"></span> <span
			class="sr-only">Next</span>
		</a>
	</div>
	<!--
	================================NỘI DUNG=======================
  -->

	<!--
	========================SÁCH VỪA XUẤT BẢN================
	-->
	<div class="container-fluid" id="courseshome">
		<div class="container khung" style="text-align: center;">
			<div class="gioithieu">
				<h2>
					<i class="fas fa-seedling"></i> TOUR MỚI
				</h2>
				<p class="p_home">Một số Tour vừa mới cập nhật</p>
			</div>
			<div class="row container wow zoomIn" style="padding-top: 20px"
				id="booknew0"></div>
			<div class="row container wow zoomIn" style="padding-top: 20px"
				id="booknew1"></div>
			<div style="margin-top: 10px;">
				<button class="btn btn-success btn_xemthem"
					onclick="window.location.href='/HiBook_KLTN19/search-newbook'">Xem thêm</button>
			</div>
		</div>
	</div>
	
	<!-- Banner Ads -->
	
	<div class="container" style="margin-top: 20px">
	<c:forEach var="list" items="${listPromotion}">
		<div class="row">
			<div class="col-lg-12">
				<div class="banner-img-2">
					<a href="promotion"><img src="<%=request.getContextPath()%>/resources/images/banner/${list.getPicPromotion()}" alt="banner"></a>
					<div class="banner-text">
						<h3>Tour Đà Nẵng &amp; Spiritual Traveler Press</h3>
						<h2>Giảm đến ${list.getSaleOff()}%</h2>
					</div>
				</div>
			</div>
		</div>
		</c:forEach>
	</div>
	
	<!--
	========================SÁCHBÁN CHẠY NHẤT================
	-->
	<div class="container-fluid" id="courseshome">
		<div class="container khung" style="text-align: center;">
			<div class="gioithieu">

				<h2>
					<i style="width: fit-content;" class="fas fa-star"></i> TOUR ĐƯỢC YÊU THÍCH
				</h2>
				<p class="p_home">Những Tour du lịch được yêu thích nhất</p>
			</div>
			<div class="row container wow zoomIn" id="loadtrangchu"
				style="padding-top: 20px"></div>
			<div class="row container wow zoomIn" id="loadtrangchu1"
				style="padding-top: 20px"></div>
			<div class="text-center" style="margin-top: 10px;">
				<button class="btn btn-success btn_xemthem"
					onclick="window.location.href='/HiBook_KLTN19/search-bestsells'">Xem thêm</button>
			</div>

		</div>
	</div>
	<!--
	========================HISTORY================
	-->
	<div class="container-fluid" id="historyuser">
		<div class="container " style="text-align: center; margin-bottom:30px;">
			<div class="gioithieu">

				<h2>
					Tour đã xem
				</h2>
			</div>
			<div class="row container" id="loadhistory"
				style="padding-top: 20px"></div>
			
			<div class="text-center" style="margin-top: 10px;">
				<button class="btn btn-success btn_xemthem"
					onclick="window.location.href='/HiBook_KLTN19/user-history'">Xem thêm</button>
			</div>
		</div>
	</div>
	<!--
	========================LOGO ĐỐI TÁC================
	-->
	<div class="container">
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12">
				<div id="Carousel_doitac" class="carousel slide">

					<!-- Carousel items -->
					<div class="carousel-inner">

						<div class="item active">
							<div class="row">
								<div class="col-xs-3 col-sm-3 col-md-3">
									<a class="thumbnail"><img
										src="resources/images/logo_doitac/logo5.png" alt="Image"
										style="max-width: 100%; height: 60px;"></a>
								</div>
								<div class="col-xs-3 col-sm-3 col-md-3">
									<a class="thumbnail"><img
										src="resources/images/logo_doitac/logo4.png" alt="Image"
										style="max-width: 100%; height: 60px;"></a>
								</div>
								<div class="col-xs-3 col-sm-3 col-md-3">
									<a class="thumbnail"><img
										src="resources/images/logo_doitac/logo2.png" alt="Image"
										style="max-width: 100%; height: 60px;"></a>
								</div>
								<div class="col-xs-3 col-sm-3 col-md-3">
									<a class="thumbnail"><img
										src="resources/images/logo_doitac/logo6.png" alt="Image"
										style="max-width: 100%; height: 60px;"></a>
								</div>
							</div>
							<!--.row-->
						</div>
						<!--.item-->

						<div class="item">
							<div class="row">
								<div class="col-xs-3 col-sm-3 col-md-3">
									<a class="thumbnail"><img
										src="resources/images/logo_doitac/logo.png" alt="Image"
										style="max-width: 100%; height: 60px;"></a>
								</div>
								<div class="col-xs-3 col-sm-3 col-md-3">
									<a class="thumbnail"><img
										src="resources/images/logo_doitac/nxbkd.png" alt="Image"
										style="max-width: 100%; height: 60px;"></a>
								</div>
								<div class="col-xs-3 col-sm-3 col-md-3">
									<a class="thumbnail"><img
										src="resources/images/logo_doitac/thaiha_logo.png" alt="Image"
										style="max-width: 100%; height: 60px;"></a>
								</div>
								<div class="col-xs-3 col-sm-3 col-md-3">
									<a class="thumbnail"><img
										src="resources/images/logo_doitac/nxbtre.png" alt="Image"
										style="max-width: 100%; height: 60px;"></a>
								</div>
							</div>
							<!--.row-->
						</div>
						<!--.item-->

					</div>
					<!--.carousel-inner-->
					<a data-slide="prev" href="#Carousel_doitac"
						class="left carousel-control carousel-control-doitac-left">‹</a> <a
						data-slide="next" href="#Carousel_doitac"
						class="right carousel-control carousel-control-doitac-right">›</a>
				</div>
				<!--.Carousel-->

			</div>
		</div>
	</div>
	<!--.container-->

	<!-- REGISTER RECEIVE MAIL -->
	<div class="row">
		<div class="block-newsletter">
			<div class="col-sm-6">
				<h2>Đăng ký nhận bản tin</h2>
				<p>Đừng bỏ lỡ hàng trăm tour du lịch và các chương trình siêu hấp dẫn hàng tháng</p>
			</div>
			<div class="col-sm-6">
				<form action="#">
				<input type="email" placeholder="Enter your email address">
				<input type="submit" value="Send Email">
			</form>
			</div>
			
		</div>
	</div>
	<!-- alert thong bao  -->
	<div class="thongbao top-alert"></div>
	<!--  end alert -->
	
	<%@ include file="_footer.jsp" %>
	
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<%-- <script src="<%=request.getContextPath()%>/resources/js/out-js/jquery.min.js"></script> --%>
  	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/out-js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/out-js/wow.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/out-js/wow.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/user-api/apihome.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/search.js"></script>
	<script type="text/javascript">
		new WOW().init();
	</script>
</body>
</html>