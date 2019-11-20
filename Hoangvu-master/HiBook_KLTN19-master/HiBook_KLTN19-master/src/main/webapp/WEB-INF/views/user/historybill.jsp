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

<title>Bill of User</title>
<!--Icon fa-->
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/fontawesome-all.min.css">
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
						<div class="profile-usertitle-job">
							${info.getEmail()}</div>
					</div>
					<!-- END SIDEBAR USER TITLE -->
					<!-- SIDEBAR MENU -->
					<div class="profile-usermenu">
						<ul class="nav">
							<li><a
								href="<%=request.getContextPath()%>/user-info"> <span
									class="glyphicon glyphicon-user"></span> Thông tin
							</a></li>
							<li><a href="<%=request.getContextPath()%>/user-update">
									<span class="glyphicon glyphicon-pencil"></span> Quản lý thông tin
							</a></li>
							<li class="active"><a href="<%=request.getContextPath()%>/user-bill">
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

										<table id="table_bill" class="table table-sm table-hover" data-id="${info.getIdUser()}">
										  <thead>
										    <tr>
										      <th>Mã đơn hàng</th>
										      <th>Ngày mua</th>
										      <th>Sản phẩm</th>
										      <th>Tổng tiền</th>
										      <th>Trạng thái đơn hàng</th>
										    </tr>
										  </thead>
										  <tbody>
										    
										  </tbody>
										</table>
										<!-- /.box -->
									</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<!-- The Modal Detail Bill-->
		  <div class="modal fade " id="modalDetail" role="dialog" tabindex="-1" aria-hidden="true">
		    <div class="modal-dialog modal-lg">
		      <div class="modal-content" style="width:100%;">
		      
		        <!-- Modal Header -->
		        <div class="modal-header">
		          <h4 class="modal-title">Thông tin chi tiết</h4>
		          <button type="button" class="close" data-dismiss="modal">×</button>
		        </div>
		        
		        <!-- Modal body -->
		        <div class="modal-body" style="margin: 10px;">
			         <div class="row">
	                    <div class="col-md-4">
	                    	<div >Tên người nhận:</div>
	                    	<div class="nguoinhan">Nguyễn Viết Thanh</div>
	                    </div>
	                    <div class="col-md-4">
	                    	<div >Số điện thoại:</div>
	                    	<div class="numberphone">02555555</div>
	                    </div>
	                    <div class="col-md-4">
	                    	<div >Địa chỉ:</div>
	                    	<div class="address"></div>
	                    </div>
	                 </div><hr/>
	                 <div class="row">
	                 	<table id="table_sp" class="table table-borderless mb-0">
							<thead>
								<tr class="border-bottom text-uppercase">
									<th scope="col">Tên sách</th>
									<th scope="col">số lượng</th>
									<th scope="col">Giá</th>
									<th scope="col">Tổng</th>
								</tr>
							</thead>
							<tbody>
								
							</tbody>
						</table>
	                 </div><hr/>
	                 <div class="row">
	                 	<div class="col-md-4">
	                    	<div >Phương thức thanh toán:</div>
	                    	<div class="payment"></div>
	                    </div>
	                    <div class="col-md-4">
	                    	<div >Tình trạng:</div>
	                    	<div class="status"></div>
	                    </div>
	                    <div class="col-md-4">
	                    	<div >Vận huyển:</div>
	                    	<div class="transport"></div>
	                    </div>
	                 </div>
		        </div>
		        
		        <!-- Modal footer -->
		        <div class="modal-footer">
		          <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
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
	<script src="<%=request.getContextPath()%>/resources/js/out-js/bootstrap.min.js"></script>
	
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="<%=request.getContextPath()%>/resources/js/user-api/userbill.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/search.js"></script>
</body>
</html>