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

<title>User Review | BookTourAdmin</title>
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
						<a href="<%=request.getContextPath()%>/info_user/${getIdUseradmin}" class="dropdown-item">Profile</a> <a href="<%=request.getContextPath()%>/logout""
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

			<h2 class="mb-4">Datatable bình luận của khách hàng</h2>

			<div class="card mb-4">
				<div class="card-body">
					<table id="table-review"
						class="table table-hover dataTable no-footer dtr-inline"
						cellspacing="0" width="100%" role="grid"
						aria-describedby="example_info" style="width: 100%;">
						<thead>
							<tr>
								<th>Mức độ(Start)</th>
								<th>Tour</th>
								<th>Tiêu đề</th>
								<th>Nội dung</th>
								<th>Thời gian</th>
								<th>Báo cáo</th>
								<th>User</th>
								<th class="actions">Actions</th>
							</tr>
						</thead>
						<tbody id="list-review">
							<!--  Add list review -->
						</tbody>
					</table>
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
								không?</h5>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-danger" data-dismiss="modal">Cancel</button>
						<button id="delete-review" class="btn btn-success">Delete</button>
					</div>
				</div>
			</div>
		</div>

	</div>

	<script src="resources/js/admin-api/Admin_Review.js"></script>

	<script>
    window.dataLayer = window.dataLayer || [];
    function gtag(){dataLayer.push(arguments);}
    gtag('js', new Date());

    gtag('config', 'UA-118868344-1');
</script>

	<!-- CUSTOM JS AJAX  -->
	<!-- <script src="resources/js/user-custom/getListreview.js"></script> -->

</body>
</html>