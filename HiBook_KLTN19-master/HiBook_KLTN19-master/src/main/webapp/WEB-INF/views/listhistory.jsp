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
			<div class="col-sm-9">
				<p style="font-size: 25px; padding: 4px;"><strong>TOUR BẠN ĐÃ XEM</strong></p>
				 
				<div class="row container " id="loadhistory0"
				style="padding-top: 20px"></div>
				
				<div class="row container " id="loadhistory1"
				style="padding-top: 20px"></div>
				
				<div class="row container " id="loadhistory2"
				style="padding-top: 20px"></div>
				
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

	<script src="<%=request.getContextPath()%>/resources/js/filter_search.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/search.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/listhistory.js"></script>
	<script>
		new WOW().init();
	</script>
</body>
</html>