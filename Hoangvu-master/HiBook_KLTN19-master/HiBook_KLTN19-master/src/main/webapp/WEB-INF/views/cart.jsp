<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Home</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--bootstrap & Jquery-->
<link href="resources/css/bootstrap.css" rel="stylesheet">
<!--Icon fa-->
<link rel="stylesheet" href="resources/css/fontawesome-all.min.css">

<!--CSS-->
<link rel="stylesheet" type="text/css" href="resources/css/myhome.css" />
<link rel="stylesheet" type="text/css" href="resources/css/animate.css" />
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/stylecart.css" />
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" type="text/css" href="resources/css/alert.css" />
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
	<%@ include file="_header.jsp" %>

	<!--

	================================NỘI DUNG=======================
  -->

	<div class="container" style="margin-top: 10px;">
		<div class="col-md-12">
			<h4 class="lbl-shopping-cart lbl-shopping-cart-gio-hang" style="margin: 23px;
    /* margin-top: 45px; */
    margin-bottom: -5px;
    margin-top: 38px;">
				Giỏ hàng <span>(${listcart.size() } sản phẩm)</span>
			</h4>
		</div>
		<div class="col-md-12">
			<div class="col-md-8" id="shopping-cart">
			

				<table id="cart" class="table table-hover table-condensed">
					<thead>
						<tr>
							<th style="width: 50%">Tên Tour</th>
							<th style="width: 10%">Giá</th>
							<th style="width: 8%">Số người</th>
							<th style="width: 22%" class="text-center">Thành tiền</th>
							<th style="width: 10%"></th>
						</tr>
					</thead>
					
					<tbody>
					<c:forEach var="list" items="${listcart}">
						<tr >
							<td data-th="Product">
								<div class="row">
									<div class="col-md-8 hidden-xs" >
										<img id="getIdCart" data-idCart="${list.getIdCart()}"
											src="<%=request.getContextPath() %>/resources/images/book/${list.book.getPicBook()}"
											alt="Sản phẩm 1" class="img-responsive" width="100">
											<h4 class="nomargin" style="color: red;">${list.book.getNameBook()}</h4>
									</div>
									
								</div>
							</td>
							<td class="giatien" data-price="${list.getPrice()}">${list.getPrice()}&nbsp;₫</td>
							<td  class="soluong" style="padding: 2px;">
								<input class="form-control text-center soluong_giohang" value='${list.getQuantity()}' type="number" min="1" >
							</td>
							<td class="totalmoney" data-th="Subtotal" class="text-center"></td>
							<td class="actions" data-th="">
								<button class="btn btn-danger btn-sm deletecart" >
									<i class="fa fa-trash"></i>
								</button>
							</td>
						</tr>
						</c:forEach>
						
					</tbody>
					
					<tfoot>
						
						<tr>
							<td>
								<a href="<%=request.getContextPath()%>/" class="btn btn-warning">
								<i class="fa fa-angle-left"></i>Tiếp tục đặt tour</a></td>
							<td colspan="2" class="hidden-xs"></td>
							<td class="hidden-xs text-center" id="totalall"><strong>Tổng tiền:</strong></td>
							
						</tr>
					</tfoot>
				</table>

			</div>

			<div class="col-md-4 col-sm-12" style="margin-top: -27px;">
				<h3>Thông Tin Đặt Tour</h3>
				 <form action="<%=request.getContextPath()%>/detail-bill" method="POST">
				 	
					<div class="form-group">
						<label for="usr">Name:</label> <input type="text"
							class="form-control" id="usr" name="tenKhachHang" value="${userinfo.getNameUser()}" required>
					</div>
					<div class="form-group">
						<label for="pwd">Number Phone:</label> 
						<input type="number" style="padding: 12px 20px; " class="form-control" id="pwd" name="soDT" value="${userinfo.getNumberphone()}" required>
					</div>
					<div class="form-group">
						<label for="pay">Phương Thức Thanh Toán:</label>
						<div class="radio" id="pay">
							<!-- GET PAYMENTs -->
						</div>
					</div>


					<div class="form-group">
						<label for="adr">Address:</label> 
						<input type="text" class="form-control" id="adr" name="diaChiGiao" value="${userinfo.getAddress()}" required>
					</div>
					<div class="form-group">
						<label for="pay">Phương Thức Vận Chuyển:</label>
						<div class="radio" id="trans">
							<!-- GET TRANSPORTs -->
						</div>
					</div>
					<div>		
						<input type="submit" value="Đặt Hàng" class="btn btn-danger dathang" 
							style="margin-bottom: 11px"/>
					</div>
				</form>	
				
			</div>

		</div>
	</div>
	<!--
	===========================giới thiệu====================
  -->

	<!-- Footer -->
	<%@ include file="_footer.jsp" %>
	
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="<%=request.getContextPath()%>/resources/js/out-js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/out-js/wow.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/out-js/wow.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/cart.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/search.js"></script>
	<script>
		new WOW().init();
	</script>
</body>
</html>