<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>List Search</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!--bootstrap & Jquery-->
	<link href="<%=request.getContextPath()%>/resources/css/bootstrap.css" rel="stylesheet">
	<!--Icon fa-->
	<link rel="stylesheet" href="resources/css/fontawesome-all.min.css">

	<!--CSS-->
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/myhome.css" />
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/animate.css" />
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/list_search_css.css" />
	<link href="https://fonts.googleapis.com/css?family=Open+Sans"
		rel="stylesheet">
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
	
	<%@ include file="_header.jsp" %>
	<!--
		==============================content===================================
	-->
	
	<div class="container" style="margin-top: 10px;margin-bottom: 50px;">
		<div class="row">
			<div class="col-sm-3">
				<div class="card" style="border: 1px solid #99ca8d; padding: 15px; border-radius: 5px;">
					<div class="card-header">
						<h5><strong>LỌC THEO</strong></h5><hr/>
					</div>
					<div class="card-body">
					    <h5 class="card-title" style="color: black;"><strong>LỊCH TRÌNH</strong></h5>
					    <div class="bg" id="filter_author">
					    	<c:forEach var="item" items="${search.lstAuthor}">
					    		<label class="chiller_cb">${item.nameAuthor} (${item.numBookSearch})
								  <input type="checkbox" data-author="${item.nameAuthor}">
								  <span class="checkmark"></span>
								</label>
							</c:forEach>
						</div>
					</div>
					<div class="card-body">
					    <h5 class="card-title" style="color: black;"><strong>NHÀ CUNG CẤP</strong></h5>
					    <div class="bg" id="filter_supplier">
					    	<c:forEach var="item" items="${search.lstSupplier}">
					    		<label class="chiller_cb">${item.nameSupplier} (${item.numBookSearch})
								  <input type="checkbox" data-supplier="${item.idSupplier}">
								  <span class="checkmark"></span>
								</label>
							</c:forEach>
						</div>
					</div>
					<div class="card-body">
					    <h5 class="card-title" style="color: black;"><strong>ĐỊA ĐIỂM XUẤT PHÁT</strong></h5>
					    <div class="bg" id="filter_publisher">
					    	<c:forEach var="item" items="${search.lstPublisher}">
					    		<label class="chiller_cb">${item.namePublisher} (${item.numBookSearch})
								  <input type="checkbox" data-publisher="${item.namePublisher}">
								  <span class="checkmark"></span>
								</label>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
			<div class="col-sm-9">
				<p style="font-size: 25px; padding: 4px;"><strong>DANH SÁCH TÌM KIẾM</strong></p>
				 <div class="form-group" style="width: 20%; text-align: right;display: -webkit-box;">
				       <select class="form-control">
				        <option>Sắp xếp</option>
				        <option>Tour đặt nhiều nhất</option>
				        <option>Chi phí Tour</option>
				        <option>Mới nhất</option>
				      </select>
				      <%--<select class="form-control" style="margin-left: 20px;">
				        <option>6 Tour</option>
				        <option>12 Tour</option>
				        <option>24 Tour</option>
				      </select>  --%>
				  </div>
				<div id="list_search" class="row wow slideInUp" style="padding-top: 20px">
					<%-- <c:forEach var="item" items="${search.currentBooks}">
						<div class="col-sm-6 col-md-4 " style="margin-bottom: 20px;">
							<div class="sanpham">
								<div class="thumbnail entry">
									<a href="/HiBook_KLTN19/detail-book/${item.idBook}" class="non-textdecoration" target="_blank">
									<div id="hinh" class="img_center">
										<img src="/HiBook_KLTN19/resources/images/book/${item.picBook}" alt="Nature">
									</div>
									</a>
								</div>
								<div class="h">
									<span id="NameSP">${item.nameBook}</span><br />
									<span style="color: #8a8787; padding: 10px; font-size: 14px;">
										<c:forEach var="author" items="${item.authors}">
											${author.nameAuthor} 
										</c:forEach>
									</span><br/> 
									<span style="color: black; padding: 10px; font-size: 14px;">${Math.round(item.price*(1-item.discount/100))}đ</span>
									<span style="color: grey; padding: 15px; font-size: 12px; text-align: center;"><del>${item.price}đ</del></span>
									<span style="color: red; padding: 16px; font-size: 12px; text-align: right !important;">-${item.discount}%</span><br />
								</div>
							</div>
						</div>
					</c:forEach> --%>
				</div>
				
				<div id="right_pagination">
					<ul class="pagination">
						<!-- li pagination  -->
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!--  -->
	<%@ include file="_footer.jsp" %>
	
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<%-- 	<script src="<%=request.getContextPath()%>/resources/js/out-js/jquery.min.js"></script> --%>

	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="<%=request.getContextPath()%>/resources/js/out-js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/out-js/wow.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/out-js/wow.js"></script>

	<script src="<%=request.getContextPath()%>/resources/js/filter_search.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/search.js"></script>
	<script>
		new WOW().init();
	</script>
</body>
</html>