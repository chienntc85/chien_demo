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

<title>Author | HiBookAdmin</title>
</head>
<body class="bg-light">

	<nav class="navbar navbar-expand navbar-dark bg-success">
		<a class="sidebar-toggle mr-3" href="#"><i class="fa fa-bars"></i></a>
		<a class="navbar-brand" href="#" style="font-weight: bold;">HiBook</a>

		<div class="navbar-collapse collapse">
			<ul class="navbar-nav ml-auto">
				
				<li class="nav-item dropdown"><a href="#" id="dd_user"
					class="nav-link dropdown-toggle" data-toggle="dropdown"><i
						class="fa fa-user"></i> ${pageContext.request.userPrincipal.name}</a>
					<div class="dropdown-menu dropdown-menu-right"
						aria-labelledby="dd_user">
						<%-- <a href="<%=request.getContextPath()%>/info_user/${getIdUseradmin}" class="dropdown-item">Profile</a>  --%>
						<a href="<%=request.getContextPath()%>/logout"
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

			<h2 class="mb-4">Datatable Tác Giả</h2>
			<div width="100%" style="text-align: right;">
				<a id="add-author" href="#"
					class="btn btn-icon btn-pill btn-success" data-toggle="modal"
					data-target="#modalAdd"> <i class="fa fa-fw fa-plus"></i> Thêm
					Tác Giả
				</a>
			</div>

			<div class="card mb-4">
				<div class="card-body">
					<table id="table-author"
						class="table table-hover dataTable no-footer dtr-inline"
						cellspacing="0" width="100%" role="grid"
						aria-describedby="example_info" style="width: 100%;">
						<thead>
							<tr>
								<th>ID</th>
								<th>Tên Tác Giả</th>
								<th>Số sách</th>
								<th class="actions">Actions</th>
							</tr>
						</thead>
						<tbody id="list-author">
							<!--  Add list Author -->
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
						<h5 class="modal-title" id="exampleModalCenterTitle">Thêm Tác
							Giả</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<!-- modal Body  -->
					<div class="modal-body">
						<div class="col-12">
							<label for="validationServer01">Tên tác giả</label> <input
								type="text" class="form-control is-valid"
								id="validationServer01" placeholder="Name Author*" required>
							<div class="invalid-feedback" style="display: none;">Hãy
								nhập tên tác giả.</div>
							<div class="valid-feedback" style="display: none;">Looks
								good!</div>
						</div>
					</div>
					<div class="modal-footer">
						<button id="close-add-author" type="button"
							class="btn btn-secondary" data-dismiss="modal">Close</button>
						<button id="save-add-author" class="btn btn-success">Save</button>
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
								tác giả này không?</h5>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-danger" data-dismiss="modal">Cancel</button>
						<button id="delete-author" class="btn btn-success">Delete</button>
					</div>
				</div>
			</div>
		</div>

	</div>

	<script src="resources/js/admin-api/Admin_Author.js"></script>

	<script>
    window.dataLayer = window.dataLayer || [];
    function gtag(){dataLayer.push(arguments);}
    gtag('js', new Date());

    gtag('config', 'UA-118868344-1');
</script>

	<!-- CUSTOM JS AJAX  -->
	<!-- <script src="resources/js/user-custom/getListAuthor.js"></script> -->

</body>
</html>