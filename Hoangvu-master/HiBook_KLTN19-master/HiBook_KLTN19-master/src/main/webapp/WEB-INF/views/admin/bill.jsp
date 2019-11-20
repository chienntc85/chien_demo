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
    

    <title>Bill | HiBookTourAdmin</title>
    
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
</head>
<body class="bg-light">

    <nav class="navbar navbar-expand navbar-dark bg-success">
        <a class="sidebar-toggle mr-3" href="#"><i class="fa fa-bars"></i></a>
        <a class="navbar-brand" href="#" style="font-weight:bold;">HiBookTour</a>

        <div class="navbar-collapse collapse">
            <ul class="navbar-nav ml-auto">
                
                <li class="nav-item dropdown">
                    <a href="#" id="dd_user" class="nav-link dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i>${pageContext.request.userPrincipal.name}</a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dd_user">
                        <%-- <a href="<%=request.getContextPath()%>/info_user/${getIdUseradmin}" class="dropdown-item">Profile</a> --%>
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
        	
             <h2 class="mb-4">Datatable Hóa đơn</h2>
				
		    <div class="card mb-4">
		        <div class="card-body">
		            <table id="table-Bill" class="table table-hover dataTable no-footer dtr-inline" cellspacing="0" width="100%" role="grid" aria-describedby="example_info" style="width: 100%;">
		                <thead>
		                <tr>
		                    <th>ID</th>
		                    <th>Người tạo</th>
		                    <th>Ngày tạo</th>
		                    <th>Tổng</th>
		                    <th>Tình Trạng</th>
		                    
		                </tr>
		                </thead>
		                <tbody id="list-Bill">
		                	<!--  Add list Bill -->
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
	                modal Body 
		                <div class="modal-body">
		                    <div class="col-12">
	                        	<h5 id="xoa-title" class="modal-title" >Bạn có chắc muốn xóa hóa đơn này không?</h5>
	                    	</div>
		                </div>
		                <div class="modal-footer">
		                    <button type="button" class="btn btn-danger" data-dismiss="modal">Cancel</button>
		                    <button id="delete-Bill" class="btn btn-success" >Delete</button>
		                </div>
	            </div>
	        </div>
	    </div> 
        <!-- MODAL CHANGE STATUS-->
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
	                        	<h5 id="change-title" class="modal-title" >Bạn có chắc muốn thay đổi tình trạng đơn hàng?</h5>
	                    	</div>
		                </div>
		                <div class="modal-footer">
		                    <button type="button" class="btn btn-danger" data-dismiss="modal">Cancel</button>
		                    <button id="change-status" class="btn btn-success" >Change</button>
		                </div>
	            </div>
	        </div>
	    </div>
    </div>

<script src="resources/js/admin-api/Admin_Bill.js"></script>

<script>
    window.dataLayer = window.dataLayer || [];
    function gtag(){dataLayer.push(arguments);}
    gtag('js', new Date());

    gtag('config', 'UA-118868344-1');
</script>

</body>
</html>