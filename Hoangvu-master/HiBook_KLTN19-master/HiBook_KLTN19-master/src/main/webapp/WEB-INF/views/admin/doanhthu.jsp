<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/fontawesome-all.min.css">
<link rel="stylesheet" href="resources/css/datatables.min.css">
<link rel="stylesheet" href="resources/css/fullcalendar.min.css">
<link rel="stylesheet" href="resources/css/bootadmin.min.css">

<title>TypeTour | HiBookTourAdmin</title>
</head>
<body class="bg-light">

	<nav class="navbar navbar-expand navbar-dark bg-success">
		<a class="sidebar-toggle mr-3" href="#"><i class="fa fa-bars"></i></a>
		<a class="navbar-brand" href="#" style="font-weight: bold;">HiBookTour</a>

		<div class="navbar-collapse collapse">
			<ul class="navbar-nav ml-auto">
				
				<li class="nav-item dropdown"><a href="#" id="dd_user"
					class="nav-link dropdown-toggle" data-toggle="dropdown"><i
						class="fa fa-user"></i> ${pageContext.request.userPrincipal.name}</a>
					<div class="dropdown-menu dropdown-menu-right"
						aria-labelledby="dd_user">
						<a href="<%=request.getContextPath()%>/info_user/${getIdUseradmin}" class="dropdown-item">Profile</a> <a href="<%=request.getContextPath()%>/logout"
							class="dropdown-item">Logout</a>
					</div></li>
			</ul>
		</div>
	</nav>

	<div class="d-flex">
		<!-- MENU LEFT -->
		<%@ include file="_leftmenu.jsp" %>
		<!-- CONTENT  -->
		<div class="content p-4">

			<h2 class="mb-4">Datatable Doanh Thu</h2>
			<div width="100%" style="text-align: right;">
				<p>Doanh Thu Năm </p> <p>${nam}đ</p>
			</div>

			<div class="card mb-4">
				<div class="card-body">
					<table id="table-typebook"
						class="table table-hover dataTable no-footer dtr-inline"
						cellspacing="0" width="100%" role="grid"
						aria-describedby="example_info" style="width: 100%;">
						<thead>
							<tr>
								<th>Tháng 1</th>
								<th>Tháng 2</th>
								<th>Tháng 3</th>
								<th>Tháng 4</th>
								<th>Tháng 5</th>
								<th>Tháng 6</th>
								<th>Tháng 7</th>
								<th>Tháng 8</th>
								<th>Tháng 9</th>
								<th>Tháng 10</th>
								<th>Tháng 11</th>
								<th>Tháng 12</th>
							</tr>
						</thead>
						<tbody id="list-typebook">
							<tr>
							<td>${thang1}đ</td> </br>
							<td>${thang2}đ</td>
							<td>${thang3}đ</td>
							<td>${thang4}đ</td>
							<td>${thang5}đ</td>
							<td>${thang6}đ</td>
							<td>${thang7}đ</td>
							<td>${thang8}đ</td>
							<td>${thang9}đ</td>
							<td>${thang10}đ</td>
							<td>${thang11}đ</td>
							<td>${thang12}đ</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="card mb-4">
				<div class="card-body">
					<table id="table-typebook"
						class="table table-hover dataTable no-footer dtr-inline"
						cellspacing="0" width="100%" role="grid"
						aria-describedby="example_info" style="width: 100%;">
						<thead>
							<tr>
								<th>Qúy 1</th>
								<th>Qúy 2</th>
								<th>Qúy 3</th>
								<th>Qúy 4</th>
							</tr>
						</thead>
						<tbody id="list-typebook">
							<tr>
							<td>${Doanhthuqui1}đ</td> </br>
							<td>${Doanhthuqui2}đ</td>
							<td>${Doanhthuqui3}đ</td>
							<td>${Doanhthuqui4}đ</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<!-- MODAL  ADD-->
		<div class="modal fade" id="modalAdd" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalCenterTitle">Thêm
							Loại Tour</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<!-- modal Body  -->
					<div class="modal-body">
						<div class="col-12">
							<label for="validationServer01">Tên loại Tour</label> <input
								type="text" class="form-control is-valid"
								id="validationServer01" placeholder="Name typebook*" required>
							<div class="invalid-feedback" style="display: none;">Hãy
								nhập tên loại tour.</div>
							<div class="valid-feedback" style="display: none;">Looks
								good!</div>
						</div>
					</div>
					<div class="modal-footer">
						<button id="close-add-typebook" type="button"
							class="btn btn-secondary" data-dismiss="modal">Close</button>
						<button id="save-add-typebook" class="btn btn-success">Save</button>
					</div>
				</div>
			</div>
		</div>
		<!-- MODAL  DELETE-->
		<div class="modal fade" id="modalDelete" tabindex="-1" role="dialog"
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
							<h5 id="xoa-title" class="modal-title">Bạn có chắc muốn xóa
								loại tour này không?</h5>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-danger" data-dismiss="modal">Cancel</button>
						<button id="delete-typebook" class="btn btn-success">Delete</button>
					</div>
				</div>
			</div>
		</div>

	</div>


	<script>
    window.dataLayer = window.dataLayer || [];
    function gtag(){dataLayer.push(arguments);}
    gtag('js', new Date());

    gtag('config', 'UA-118868344-1');
</script>

	<!-- CUSTOM JS AJAX  -->
	<!-- <script src="resources/js/user-custom/getListtypebook.js"></script> -->

</body>
</html>