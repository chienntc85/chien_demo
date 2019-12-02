<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/css/fontawesome-all.min.css">
    <link rel="stylesheet" href="resources/css/datatables.min.css">
    <link rel="stylesheet" href="resources/css/fullcalendar.min.css">
    <link rel="stylesheet" href="resources/css/bootadmin.min.css">
    <style type="text/css">
    	.top-alert {
			  position: fixed;
			  top: 80px;
			  width: 100%;
			  z-index: 100000;
			  left: 0;
			  padding: 20px;
			  display: inline-block;
			  text-align: center;
			}
			.top-alert .alert {
			  width: auto !important;
			  height: 100%;
			  display: inline;
			  position: relative;
			  margin: 0;
			}
			.top-alert .alert .close {
			  position: absolute;
			  top: 11px;
			  right: 10px;
			  color: inherit;
			}
    	
    </style>

    <title>User | HiBookTourAdmin</title>
</head>
<body class="bg-light">

    <nav class="navbar navbar-expand navbar-dark bg-success">
        <a class="sidebar-toggle mr-3" href="#"><i class="fa fa-bars"></i></a>
        <a class="navbar-brand" href="#" style="font-weight:bold;">HiBookTour</a>

        <div class="navbar-collapse collapse">
            <ul class="navbar-nav ml-auto">
                
                <li class="nav-item dropdown">
                    <a href="#" id="dd_user" class="nav-link dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> ${pageContext.request.userPrincipal.name}</a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dd_user">
                        <a href="<%=request.getContextPath()%>/info_user/${getIdUseradmin}" class="dropdown-item">Profile</a>
                        <a href="<%=request.getContextPath()%>/logout" class="dropdown-item">Logout</a>
                    </div>
                </li>
            </ul>
        </div>
    </nav>

    <div class="d-flex">
		<!-- MENU LEFT -->
		<%@ include file="_leftmenu.jsp" %>
		<!-- CONTENT  -->
        <div class="content p-4">
        	
             <h2 class="mb-4">Datatable người dùng</h2>
             <div width="100%" style="text-align: right;">
             	<a id="add-user" href="add-user"  class="btn btn-icon btn-pill btn-success">
             		<i class="fa fa-fw fa-plus"></i> Thêm người dùng
             	</a>
             </div>
				
		    <div class="card mb-4">
		        <div class="card-body">
		            <table id="table-user" class="table table-hover dataTable no-footer dtr-inline" cellspacing="0" width="100%" role="grid" aria-describedby="example_info" style="width: 100%;">
		                <thead>
		                <tr>
		                    <th>ID</th>
		                    <th>Tên người dùng</th>
		                    <th>Số điện thoại</th>
		                    <th>Email</th>
		                    <th>Giới tính</th>
		                    <th>Ngày sinh</th>
		                    <th>Địa chỉ</th>
		                    <th>Quyền</th>
		                    <th class="actions">Actions</th>
		                </tr>
		                </thead>
		                <tbody id="list-user">
		                	<!--  Add list user -->
		                </tbody>
		            </table>
		        </div>
		    </div>
        </div>
        <div class="thongbao top-alert"></div>
		<!-- MODAL  DELETE-->
        <div class="modal fade" id="modalDelete" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	        <div class="modal-dialog modal-dialog-centered" role="document">
	            <div class="modal-content">
	                <div class="modal-header">
	                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	                        <span aria-hidden="true">&times;</span>
	                    </button>
	                </div>
	                <!-- modal Body  -->
		                <div class="modal-body">
		                    <div class="col-12">
	                        	<h5 id="xoa-title" class="modal-title" >Bạn có chắc muốn xóa tác giả này không?</h5>
	                    	</div>
		                </div>
		                <div class="modal-footer">
		                    <button type="button" class="btn btn-danger" data-dismiss="modal">Cancel</button>
		                    <button id="delete-user" class="btn btn-success" >Delete</button>
		                </div>
	            </div>
	        </div>
	    </div>
	    
	    <!-- MODAL CHANGE ROLE-->
        <div class="modal fade" id="modalChange" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	        <div class="modal-dialog modal-dialog-centered" role="document">
	            <div class="modal-content">
	                <div class="modal-header">
	                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	                        <span aria-hidden="true">&times;</span>
	                    </button>
	                </div>
	                <!-- modal Body  -->
		                <div class="modal-body">
		                    <div class="col-12">
	                        	<h5 id="change-title" class="modal-title" >Bạn có chắc muốn thay đổi quyền không?</h5>
	                    	</div>
		                </div>
		                <div class="modal-footer">
		                    <button type="button" class="btn btn-danger" data-dismiss="modal">Cancel</button>
		                    <button id="change-role" class="btn btn-success" >Change</button>
		                </div>
	            </div>
	        </div>
	    </div>
    </div>
    

<script src="resources/js/admin-api/Admin_User.js"></script>

<script>
    window.dataLayer = window.dataLayer || [];
    function gtag(){dataLayer.push(arguments);}
    gtag('js', new Date());

    gtag('config', 'UA-118868344-1');
</script>

<!-- CUSTOM JS AJAX  -->
<!-- <script src="resources/js/user-custom/getListuser.js"></script> -->

</body>
</html>