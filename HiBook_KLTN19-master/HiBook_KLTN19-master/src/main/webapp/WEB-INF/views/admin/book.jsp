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
    

    <title>Book | HiBookAdmin</title>
</head>
<body class="bg-light">

    <nav class="navbar navbar-expand navbar-dark bg-success">
        <a class="sidebar-toggle mr-3" href="#"><i class="fa fa-bars"></i></a>
        <a class="navbar-brand" href="#" style="font-weight:bold;">HiBook</a>

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
        	
             <h2 class="mb-4">Datatable Sách</h2>
             <div width="100%" style="text-align: right;">
             	<a id="add-book" href="add-book"  class="btn btn-icon btn-pill btn-success">
             		<i class="fa fa-fw fa-plus"></i> Thêm Sách
             	</a>
             </div>
				
		    <div class="card mb-4">
		        <div class="card-body">
		            <table id="table-book" class="table table-hover dataTable no-footer dtr-inline" cellspacing="0" width="100%" role="grid" aria-describedby="example_info" style="width: 100%;">
		                <thead>
		                <tr>
		                    <th>ID</th>
		                    <th>Tên Sách</th>
		                    <th>Ảnh</th>
		                    <th>Ngày xuất bản</th>
		                    <th>Số lượng</th>
		                    <th>Giá</th>
		                    <th>Giảm giá</th>
		                    <th>Loại sách</th>
		                    <th>Nhà cung cấp</th>
		                    <th class="actions">Actions</th>
		                </tr>
		                </thead>
		                <tbody id="list-book">
		                	<!--  Add list book -->
		                </tbody>
		            </table>
		        </div>
		    </div>
        </div>
        
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
	                        	<h5 id="xoa-title" class="modal-title" >Bạn có chắc muốn xóa cuốn sách này không?</h5>
	                    	</div>
		                </div>
		                <div class="modal-footer">
		                    <button type="button" class="btn btn-danger" data-dismiss="modal">Cancel</button>
		                    <button id="delete-book" class="btn btn-success" >Delete</button>
		                </div>
	            </div>
	        </div>
	    </div>
        <!-- The Modal Detail product-->
		  <div class="modal fade " id="modalDetail">
		    <div class="modal-dialog modal-lg">
		      <div class="modal-content">
		      
		        <!-- Modal Header -->
		        <div class="modal-header">
		          <h4 class="modal-title">Thông tin chi tiết</h4>
		          <button type="button" class="close" data-dismiss="modal">×</button>
		        </div>
		        
		        <!-- Modal body -->
		        <div class="modal-body">
			         <div class="row">
	                    <div class="col-md-4 text-center" id="img_book">
	                    	<img style="max-width: 80%;" src="" class="img-responsive">
	                    </div>
	                    <div class="col-md-8" id='img_content'>
	                    	<h4 id="tensach"></h4>
	                    	<div class="row">
	                    		<div class="col-sm-6">
	                    			<strong>Giá gốc: <p id="gia" style="color: red;"></p></strong>
	                    		</div>
	                    		<div class="col-sm-6">
	                    			<strong>Giảm: <p id="giam" style="color: red;"></p></strong>
	                    		</div>
	                    	</div>
	                    	<table class="table table-bordered">
				                <tbody id="chitiet_body">
					                
				                </tbody>
				            </table>
	                    </div>
	                 </div>
	                 <div class="row" style="max-width:90%; margin:auto;">
	                 	<h5>Giới thiệu</h5>
	                 	<div id="gioithieu"></div>
	                 	<p><strong>Đọc thử: </strong><a href="#" id="docthu"></a></p>
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

<script src="resources/js/admin-api/Admin_Book.js"></script>

<script>
    window.dataLayer = window.dataLayer || [];
    function gtag(){dataLayer.push(arguments);}
    gtag('js', new Date());

    gtag('config', 'UA-118868344-1');
</script>

<!-- CUSTOM JS AJAX  -->
<!-- <script src="resources/js/user-custom/getListbook.js"></script> -->

</body>
</html>