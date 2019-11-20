<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<!-- Xác định bộ mã ký tự cho văn bản HTML. -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<!-- Giúp trang web dễ nhìn trên tất cả các thiết bị -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/fontawesome-all.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/datatables.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/fullcalendar.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootadmin.min.css">

<title>Chi tiết hóa đơn</title>
</head>
<body class="bg-light">
	<div class="container" style="margin-top: 20px;">
		<div class="card">
			<div class="card-body">
				<div class="row py-5">
					<div class="col-md-10 offset-md-1">
						<div class="row">
							<div class="col-md">
								<h1 class="text-uppercase">Hóa Đơn</h1>

								<p id="idBill" class="mb-0"></p>
							</div>
							<div class="col-md text-md-right">
								<img style="width: 220px;"
									src="<%=request.getContextPath()%>/resources/images/TC.png">
								<p class="mt-2 mb-0">
									tctour@gmail.com<br> (+84)868934262<br> 135 Thành Thái, Phường 14, Quận 10, TP Hồ Chí Minh
								</p>
							</div>
						</div>

						<hr class="my-5">

						<div class="row">
							<div class="col-md ">
								<h5 class="text-uppercase">Người đặt</h5>
								<p id="nameReceiver" class="mb-0" data-id="${idUser }">${namereviece}</p>
							</div>
							<div class="col-md">
								<h5 class="text-uppercase">SĐT</h5>
								<p id="numberphone">${SDT}</p>
							</div>
							<div class="col-md">
								<h5 class="text-uppercase">Ngày tạo</h5>
								<p id="dateCreate" class="mb-0">${date}</p>
							</div>
							<div class="col-md text-md-right">
								<h5 class="text-uppercase">Địa chỉ người đặt</h5>
								<p id="deliveryAdress" class="mb-0">${diachi}</p>
							</div>
						</div>

						<hr class="my-5">

						<table class="table table-borderless mb-0">
							<thead>
								<tr class="border-bottom text-uppercase">
									<th scope="col">Tên Tour</th>
									<th scope="col">Số người</th>
									<th scope="col">Giá</th>
									<th scope="col">Tổng</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="value" items="${listcart}">
									<tr>
										<td class="tensp">${value.book.getNameBook()}</td>
										<td class="soluong" data-num="${value.getQuantity()}">${value.getQuantity()}</td>
										<td class="giasp" data-many="${value.getPrice()}">${value.getPrice()}</td>
										<td class="tongtien"></td>
									</tr>
								</c:forEach>
								
							</tbody>
							
						</table>
						<hr class="my-5">
						<h3 style="text-align: right;">
							<span>Tổng Tiền:</span> <span id="tongtienbill"
								style="color: red;">0 VND</span>
						</h3>
						<hr class="my-5">
					</div>
				</div>
			</div>
		</div>
		<div style="text-align: right; margin-top: 10px;">
			<button class="btn btn-success dathang" style="margin-bottom: 20px">Xác nhận đặt Tour >></button>
		</div>
		<div class="thongbao"></div>
		<!-- MODAL -->
		<div class="modal fade" id="modalChange" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<!-- modal Body  -->
					<div class="modal-body">
						<div class="col-12">
							<h5 class="modal-title">Bạn có chắc muốn đặt Tour này?</h5>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-danger" data-dismiss="modal">Hủy bỏ</button>
						<button id="dat-hang" class="btn btn-success">Đặt Tour</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="<%=request.getContextPath()%>/resources/js/out-js/jquery.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/out-js/bootstrap.bundle.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/out-js/datatables.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/out-js/moment.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/out-js/fullcalendar.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/hoadon.js"></script>


</body>
</html>