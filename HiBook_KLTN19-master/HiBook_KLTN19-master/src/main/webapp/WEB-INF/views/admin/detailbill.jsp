<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/fontawesome-all.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/datatables.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/fullcalendar.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/bootadmin.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/alert.css">

    <title>Detail Bill | HiBookTourAdmin</title>
    
</head>
<body class="bg-light">
<div class="container">
    <h2 class="mb-4">HÓA ĐƠN</h2>
    <hr>
	<h5 class="mb-4">Tình trạng:</h5>
	<p class="orderStatus"></p>
	
    <div class="card">
        <div class="card-body">
            <div class="row py-5">
                <div class="col-md-10 offset-md-1">
                    <div class="row">
                        <div class="col-md">
                            <h1 class="text-uppercase">Hóa Đơn</h1>
                            <h5 class="text-uppercase">No.</h5>
                            <p id="idBill" class="mb-0"></p>
                        </div>
                        <div class="col-md text-md-right">
                            <img style="width: 220px;" src="<%=request.getContextPath() %>/resources/images/TC.png">
                            <p class="mt-2 mb-0">
                                booktour@gmail.com<br>
                                (+84)0868934262<br>
                                135 Thành Thái, phường 10, Quận 10, TP Hồ Chí Minh
                            </p>
                        </div>
                    </div>

                    <hr class="my-5">

                    <div class="row">
                    	<div class="col-md ">
                            <h5 class="text-uppercase">Người đặt</h5>
                            <p id="nameReceiver" class="mb-0"></p>
                        </div>
                        <div class="col-md">
                            <h5 class="text-uppercase">SĐT</h5>
                            <p id="numberphone"></p>
                        </div>
                        <div class="col-md">
                            <h5 class="text-uppercase">Ngày tạo</h5>
                            <p id="dateCreate" class="mb-0"></p>
                        </div>
                        <div class="col-md text-md-right">
                            <h5 class="text-uppercase">Địa chỉ </h5>
                            <p id="deliveryAdress" class="mb-0">
                                
                            </p>
                        </div>
                    </div>

                    <hr class="my-5">

                    <table class="table table-borderless mb-0">
                        <thead>
                        <tr class="border-bottom text-uppercase">
                            <th scope="col">Tên tour</th>
                            <th scope="col">Hình</th>
                            <th scope="col">Số lượng</th>
                            <th scope="col">Giá</th>
                            <th scope="col" class="text-right">Tổng</th>
                        </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                    <hr class="my-5">
                    <div class="row">
                    	<div class="col-md">
                            <h5 class="text-uppercase">Người tạo</h5>
                            <p id="nameUser" class="mb-0"></p>
                        </div>
                    	<div class="col-md ">
                            <h5 class="text-uppercase">Phương thức thanh toán</h5>
                            <p id="payment" class="mb-0"></p>
                        </div>
                        
                        <div class="col-md text-md-right">
                            <h5 class="text-uppercase">Địa điểm thanh toán</h5>
                            <p id="transport" class="mb-0">
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
     <div class="thongbao"></div>
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
	                        	<h5 id="change-title" class="modal-title" >Bạn có chắc muốn thay đổi tình trạng tour đã đặt?</h5>
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
<script src="<%=request.getContextPath() %>/resources/js/out-js/jquery.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/out-js/bootstrap.bundle.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/out-js/datatables.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/out-js/moment.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/out-js/fullcalendar.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/out-js/bootadmin.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/admin-api/detail-bill.js"></script>

<script>
    window.dataLayer = window.dataLayer || [];
    function gtag(){dataLayer.push(arguments);}
    gtag('js', new Date());

    gtag('config', 'UA-118868344-1');
</script>

</body>
</html>