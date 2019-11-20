<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Chi tiết Tour</title>
<!-- Bootstrap -->
<link href="<%=request.getContextPath()%>/resources/css/bootstrap.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/alert.css" />
<!-- Include the above in your HEAD tag -->
<link href="<%=request.getContextPath()%>/resources/css/detail_css.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/myhome.css" />
<!-- fa icon -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/fontawesome-all.min.css">
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
	<!-- ================CONTENT=============  -->
	<div class="container" style="margin-top: 10px;">
		<div class="row">
			<div class="col-xs-12 col-sm-6 item-photo">
				<div id="TryRead">
					<a href="#" data-toggle="modal" data-value=''
						data-target="#modalTryRead" style="color: #21b334;">>> LỊCH TRÌNH</a>
				</div>
				<!--  <img style="max-width:100%;" src="resources/images/info_user/detail.jpg" /> -->
			</div>

			<div class="col-xs-12 col-sm-6" style="border: 0px solid gray">

				<!-- Datos del vendedor y titulo del producto -->
				<h3 id="tensach" data-type=""></h3>
				<h5 style="color: #000">
					Lịch trình: <a id="tacgia" href="#"></a>
				</h5>

				<!-- Review -->
				<div class="rating">
					<div id="star_header" class="stars">
						
					</div>
				</div>
				<hr />
				<!-- Precios -->
				<h3 id="giaban" style="margin-top: 30px;">đ</h3>
				<h6 class="title-price">
					<small>Tiết kiệm: <span id="giamgia" style="color: red;">%<span></small>
				</h6>
				<h6 id="giagoc" class="title-price">
					<small></small>
				</h6>
				<hr />
				<!-- Detalles especificos del producto -->

				<div class="section" style="padding-bottom: 20px;">
					<h6 class="title-attr">
						<small>SỐ NGƯỜI</small>
					</h6>
					<div>
						<div class="btn-minus">
							<span class="glyphicon glyphicon-minus"></span>
						</div>
						<input id="get-quantity" value="1" />
						<div class="btn-plus">
							<span class="glyphicon glyphicon-plus"></span>
						</div>
					</div>
				</div>

				<!-- Botones de compra -->
				<div class="section" style="padding-bottom: 20px;">
					<button class="btn btn-success" id="btn-purchase"
						style="width: 200px; border-radius: 5px;">
						<span class="glyphicon glyphicon-shopping-cart get-email"
							aria-hidden="true" data-email="${email }"> </span>Đặt Tour
					</button>
				</div>
			</div>

			<div class="col-xs-12 col-sm-12">
				<div class="tabbable-panel">
					<div class="tabbable-line">
						<ul class="nav nav-tabs ">
							<li class="active"><a href="#tab_default_1"
								data-toggle="tab"> GIỚI THIỆU TOUR </a></li>
							<li><a href="#tab_default_2" data-toggle="tab"> THÔNG
									TIN CHI TIẾT </a></li>
							<li><a href="#tab_default_3" data-toggle="tab"> PHẢN HỒI TỪ KHÁCH HÀNG </a></li>
						</ul>
						<div class="tab-content">
							<div class="tab-pane active" id="tab_default_1"></div>
							<div class="tab-pane" id="tab_default_2">

								<table id="table_chitiet" class="table table-bordered">

								</table>

							</div>
							<div class="tab-pane" id="tab_default_3">
								<!--Thống kê Review-->
								<div class="row text-center">
									<div class="col-xs-6 col-md-4">
										<div class="rating-block">
											<h4>Đánh giá trung bình</h4>
											<h2 class="bold padding-bottom-7">
												<p id="start_tb">0</p>
												<small>/ 5</small>
											</h2>
										</div>
									</div>
									<div class="col-xs-6 col-md-4">
										<h4>Thống kê</h4>
										<div class="pull-left">
											<div class="pull-left" style="width: 35px; line-height: 1;">
												<div style="height: 9px; margin: 5px 0;">
													5 <span class="glyphicon glyphicon-star"></span>
												</div>
											</div>
											<div class="pull-left" style="width: 180px;">
												<div class="progress" style="height: 9px; margin: 8px 0;">
													<div id="thongke5_id" class="progress-bar progress-bar-success"
														role="progressbar" aria-valuenow="4" aria-valuemin="0"
														aria-valuemax="5" style="width: 0%"></div>
												</div>
											</div>
											<div id="thongke5" class="pull-right" style="margin-left: 10px;">0</div>
										</div>
										<div class="pull-left">
											<div class="pull-left" style="width: 35px; line-height: 1;">
												<div style="height: 9px; margin: 5px 0;">
													4 <span class="glyphicon glyphicon-star"></span>
												</div>
											</div>
											<div class="pull-left" style="width: 180px;">
												<div class="progress" style="height: 9px; margin: 8px 0;">
													<div id="thongke4_id" class="progress-bar progress-bar-success"
														role="progressbar" aria-valuenow="4" aria-valuemin="0"
														aria-valuemax="5" style="width: 0%"></div>
												</div>
											</div>
											<div id="thongke4" class="pull-right" style="margin-left: 10px;">0</div>
										</div>
										<div class="pull-left">
											<div class="pull-left" style="width: 35px; line-height: 1;">
												<div style="height: 9px; margin: 5px 0;">
													3 <span class="glyphicon glyphicon-star"></span>
												</div>
											</div>
											<div class="pull-left" style="width: 180px;">
												<div class="progress" style="height: 9px; margin: 8px 0;">
													<div id="thongke3_id" class="progress-bar progress-bar-success"
														role="progressbar" aria-valuenow="0" aria-valuemin="0"
														aria-valuemax="5" style="width: 0%"></div>
												</div>
											</div>
											<div id="thongke3" class="pull-right" style="margin-left: 10px;">0</div>
										</div>
										<div class="pull-left">
											<div class="pull-left" style="width: 35px; line-height: 1;">
												<div style="height: 9px; margin: 5px 0;">
													2 <span class="glyphicon glyphicon-star"></span>
												</div>
											</div>
											<div class="pull-left" style="width: 180px;">
												<div class="progress" style="height: 9px; margin: 8px 0;">
													<div id="thongke2_id" class="progress-bar progress-bar-success"
														role="progressbar" aria-valuenow="0" aria-valuemin="0"
														aria-valuemax="5" style="width: 0%"></div>
												</div>
											</div>
											<div id="thongke2" class="pull-right" style="margin-left: 10px;">0</div>
										</div>
										<div class="pull-left">
											<div class="pull-left" style="width: 35px; line-height: 1;">
												<div style="height: 9px; margin: 5px 0;">
													1 <span class="glyphicon glyphicon-star"></span>
												</div>
											</div>
											<div class="pull-left" style="width: 180px;">
												<div class="progress" style="height: 9px; margin: 8px 0;">
													<div id="thongke1_id" class="progress-bar progress-bar-success"
														role="progressbar" aria-valuenow="0" aria-valuemin="0"
														aria-valuemax="5" style="width: 0%"></div>
												</div>
											</div>
											<div id="thongke1" class="pull-right" style="margin-left: 10px;">0</div>
										</div>
									</div>
									<!--WRITE REVIEW-->
									<div class="col-xs-6 col-md-4">
										<h4>Chia sẽ cảm nhận của bạn</h4>
										<div class="well well-sm">
											<div class="text-right">
												<a class="btn btn-success btn-green" href="#reviews-anchor"
													id="open-review-box">Viết cảm nhận của bạn</a>
											</div>

											<div class="row" id="post-review-box" style="display: none;">
												<div class="col-md-12">
													<form accept-charset="UTF-8" method="GET">
														<input id="ratings-hidden" name="rating" type="hidden" value="0">
														<input class="form-control" id="title_review_write"
															name="title_write" type="text"
															style="margin-bottom: 10px;"
															placeholder="Tiêu đề nhận xét...">
														<textarea class="form-control animated" cols="50"
															id="new-review" name="comment"
															placeholder="Viết nội dung nhận xét tại đây..." rows="5"></textarea>

														<div class="text-right">
															<div class="star starrr"
																style="margin: 20px 0; font-size: 24px; color: #fd8402;"
																data-rating="0"></div>
															<a class="btn btn-danger btn-sm" href="#"
																id="close-review-box"
																style="display: none; margin-right: 10px; margin-bottom: 5px;">
																<span class="glyphicon glyphicon-remove"></span> Hủy
															</a>
															<button id="review" class="btn btn-success btn-lg">Gửi</button>
														</div>
													</form>
												</div>
											</div>
										</div>
									</div>
								</div>
								<!--END Thống kê Review-->
								<p style="font-weight: bold;">Nhận xét của khách hàng</p>
								<!--Review Box Customer 1-->
								<div class="reviews">
									<div class="row blockquote review-item">
										<div id="mucreview"></div>
									</div>
								</div>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- The Modal Doc Thu-->
	<div class="modal fade" id="modalTryRead" data-backdrop="false"
		role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content" style="width: 70%;">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalCenterTitle">LỊCH TRÌNH</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div id="mydiv">
						<iframe id="frame" src="" width="100%" height="500"> </iframe>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--CÁC SẢN PHẨM LIÊN QUAN-->
	<div class="container">
		<div class="row">
			<h3>Tour cùng loại</h3>
			<div class="col-sm-12">
				<div id="Carousel" class="carousel slide">
					<!-- Carousel items -->
					<div class="carousel-inner">
						<div class="item active">
							<div class="row" id="sp_type1"></div>
							<!--.row-->
						</div>
						<!--.item-->

						<div class="item">
							<div class="row" id="sp_type2"></div>
							<!--.row-->
						</div>
						<!--.item-->


					</div>
					<!--.carousel-inner-->
					<a data-slide="prev" href="#Carousel" class="left carousel-control">‹</a>
					<a data-slide="next" href="#Carousel" class="right carousel-control">›</a>
				</div>
				<!--.Carousel-->

			</div>
		</div>
	</div>
	<!--.container-->

	<!-- Footer -->
	<%@ include file="_footer.jsp" %>

	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<%-- <script src="<%=request.getContextPath()%>/resources/js/out-js/jquery.min.js"></script> --%>
  	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="<%=request.getContextPath()%>/resources/js/out-js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/handle-js/detailbook.js"></script>
	<!-- api -->
	<script src="<%=request.getContextPath()%>/resources/js/handle-detail.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/search.js"></script>
</body>
</html>
