<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<!-- Xác định bộ mã ký tự cho văn bản HTML. -->
<meta charset="UTF-8">
<!-- ĐỊnh dạng tiêu đề HTML -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- Giúp trang web dễ nhìn trên tất cả các thiết bị -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap.css" />
<!-- CSS -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/info_css.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/myhome.css" />
<title>Thông tin User</title>
<!--Icon fa-->
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/fontawesome-all.min.css"/>
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
	<%@ include file="../_header.jsp"%>
	<!--
		==============================content===================================
	-->
	<div class="container" style="margin-top: 10px;">
		<div class="row profile">
			<div class="col-md-3">
				<div class="profile-sidebar">
					<!-- SIDEBAR USER TITLE -->
					<div class="profile-usertitle">
						<div class="profile-usertitle-name">${info.getNameUser()}</div>
						<div class="profile-usertitle-job">${info.getEmail()}</div>
					</div>
					<!-- END SIDEBAR USER TITLE -->
					<!-- SIDEBAR MENU -->
					<div class="profile-usermenu">
						<ul class="nav">
							<li class="active"><a
								href="<%=request.getContextPath()%>/user-info"> <span
									class="glyphicon glyphicon-user"></span> Thông tin
							</a></li>
							<li><a href="<%=request.getContextPath()%>/user-update">
									<span class="glyphicon glyphicon-pencil"></span> Quản lý thông tin
							</a></li>
							<li><a href="<%=request.getContextPath()%>/user-bill">
									<span class="glyphicon glyphicon-list-alt"></span> Quản lý hóa đơn
							</a></li>
							<li><a href="<%=request.getContextPath()%>/logout"> <span
									class="glyphicon glyphicon-log-out"></span> Đăng xuất
							</a></li>
						</ul>
					</div>
					<!-- END MENU -->
				</div>
			</div>
			<div class="col-md-9">
				<div class="profile-content">
					<div class="container">
						<div class="row">

							<div class="col-md-8 ">

								<div class="row">
									<h4 class="mb-4">Thông tin cá nhân</h4>
								</div>
								<div class="row">

									<div class="box box-info">
										<div class="col-sm-6">
											<h4 style="color: #4ad048;">${info.getRole().getNameRole() }
											</h4>
										</div>
										<div class="clearfix"></div>
										<hr style="margin: 5px 0 5px 0;">

										<div class="col-sm-4 col-xs-6 tital ">Tên:</div>
										<div class="col-sm-8 col-xs-6 ">${info.getNameUser()}</div>
										<div class="clearfix"></div>
										<div class="bot-border"></div>

										<div class="col-sm-4 col-xs-6 tital ">Ngày sinh:</div>
										<div class="col-sm-8">${info.getBirthday()}</div>
										<div class="clearfix"></div>
										<div class="bot-border"></div>

										<div class="col-sm-4 col-xs-6 tital ">Số điện thoại:</div>
										<div class="col-sm-8">${info.getNumberphone()}</div>
										<div class="clearfix"></div>
										<div class="bot-border"></div>

										<div class="col-sm-4 col-xs-6 tital ">Email:</div>
										<div class="col-sm-8">${info.getEmail()}</div>
										<div class="clearfix"></div>
										<div class="bot-border"></div>

										<div class="col-sm-4 col-xs-6 tital ">Giới tính:</div>
										<div class="col-sm-8">${info.getSex()==1?"Nữ":"Nam"}</div>
										<div class="clearfix"></div>
										<div class="bot-border"></div>

										<div class="col-sm-4 col-xs-6 tital ">Địa chỉ:</div>
										<div class="col-sm-8">${info.getAddress()}</div>
										<div class="clearfix"></div>
										<div class="bot-border"></div>
										<!-- /.box-body -->
									</div>
									<!-- /.box -->
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
	<!-- =================END CONTENT===========================
	 -->
	<!-- Footer -->
	<%@ include file="../_footer.jsp"%>
	<!-- ./Footer -->
	
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
  	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script
		src="<%=request.getContextPath()%>/resources/js/out-js/bootstrap.min.js"></script>

	<script
		src="<%=request.getContextPath()%>/resources/js/out-js/wow.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/out-js/wow.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/search.js"></script>
</body>
</html>