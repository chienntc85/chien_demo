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

<title>Dashboard | HiBookAdmin</title>
</head>
<body class="bg-light">

	<nav class="navbar navbar-expand navbar-dark bg-success">
		<a class="sidebar-toggle mr-3" href="#"><i class="fa fa-bars"></i></a>
		<a class="navbar-brand" href="#" style="font-weight: bold;">HiBook</a>

		  <div class="navbar-collapse collapse">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item dropdown">
                    <a href="#" id="dd_user" class="nav-link dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> ${pageContext.request.userPrincipal.name}</a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dd_user">
                       <%--  <a href="<%=request.getContextPath()%>/info_user/${getIdUseradmin}" class="dropdown-item">Profile</a> --%>
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

			<h2 class="mb-4">Dashboard</h2>

			<div class="row mb-4">
				<div class="col-md">
					<div class="d-flex border">
						<div class="bg-primary text-light p-4">
							<div class="d-flex align-items-center h-100">
								<i class="fa fa-3x fa-fw fa-cog"></i>
							</div>
						</div>
						<div class="flex-grow-1 bg-white p-4">
							<p class="text-uppercase text-secondary mb-0">Usage</p>
							<h3 class="font-weight-bold mb-0">10%</h3>
						</div>
					</div>
				</div>
				<div class="col-md">
					<div class="d-flex border">
						<div class="bg-success text-light p-4">
							<div class="d-flex align-items-center h-100">
								<i class="fa fa-3x fa-fw fa-comments"></i>
							</div>
						</div>
						<div class="flex-grow-1 bg-white p-4">
							<p class="text-uppercase text-secondary mb-0">Tickets</p>
							<h3 class="font-weight-bold mb-0">374</h3>
						</div>
					</div>
				</div>
				<div class="col-md">
					<div class="d-flex border">
						<div class="bg-danger text-light p-4">
							<div class="d-flex align-items-center h-100">
								<i class="fa fa-3x fa-fw fa-shopping-cart"></i>
							</div>
						</div>
						<div class="flex-grow-1 bg-white p-4">
							<p class="text-uppercase text-secondary mb-0">Sales</p>
							<h3 class="font-weight-bold mb-0">50</h3>
						</div>
					</div>
				</div>
				<div class="col-md">
					<div class="d-flex border">
						<div class="bg-info text-light p-4">
							<div class="d-flex align-items-center h-100">
								<i class="fa fa-3x fa-fw fa-users"></i>
							</div>
						</div>
						<div class="flex-grow-1 bg-white p-4">
							<p class="text-uppercase text-secondary mb-0">Customers</p>
							<h3 class="font-weight-bold mb-0">23</h3>
						</div>
					</div>
				</div>
			</div>

			<div class="row mb-4">
				<div class="col-md-8">
					<div class="card">
						<div class="card-header bg-white font-weight-bold">Sales vs.
							Expenses</div>
						<div class="card-body">
							<div id="chart_div_3" style="width: 100%; height: 322px;"></div>
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="card">
						<div class="card-header bg-white font-weight-bold">Goals
							Completed</div>
						<div class="card-body">
							<p class="mb-2">Inventory Stocked</p>
							<div class="progress mb-3">
								<div class="progress-bar bg-primary" role="progressbar"
									style="width: 75%;" aria-valuenow="25" aria-valuemin="0"
									aria-valuemax="100">75%</div>
							</div>
							<p class="mb-2">Products Browsed</p>
							<div class="progress mb-3">
								<div class="progress-bar bg-success" role="progressbar"
									style="width: 90%;" aria-valuenow="25" aria-valuemin="0"
									aria-valuemax="100">90%</div>
							</div>
							<p class="mb-2">Products Sold</p>
							<div class="progress mb-3">
								<div class="progress-bar bg-danger" role="progressbar"
									style="width: 35%;" aria-valuenow="25" aria-valuemin="0"
									aria-valuemax="100">35%</div>
							</div>
							<p class="mb-2">Product Back Order</p>
							<div class="progress mb-3">
								<div class="progress-bar bg-secondary" role="progressbar"
									style="width: 15%;" aria-valuenow="25" aria-valuemin="0"
									aria-valuemax="100">15%</div>
							</div>
							<p class="mb-2">Payments Succeeded</p>
							<div class="progress mb-3">
								<div class="progress-bar bg-info" role="progressbar"
									style="width: 100%;" aria-valuenow="25" aria-valuemin="0"
									aria-valuemax="100">100%</div>
							</div>
							<p class="mb-2">Payments Failed</p>
							<div class="progress">
								<div class="progress-bar text-dark" role="progressbar"
									style="width: 0%;" aria-valuenow="25" aria-valuemin="0"
									aria-valuemax="100">0%</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			
		</div>
	</div>

	
	<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
	<script type="text/javascript">
        google.charts.load('current', {'packages': ['corechart']});
        google.charts.setOnLoadCallback(drawChart3);
        google.charts.setOnLoadCallback(drawChart4);

        function drawChart3() {
            var data = google.visualization.arrayToDataTable([
                ['Year', 'Sales', 'Expenses'],
                ['2013', 1000, 400],
                ['2014', 1170, 460],
                ['2015', 660, 1120],
                ['2016', 1030, 540]
            ]);

            var options = {
                title: 'Company Performance',
                hAxis: {title: 'Year', titleTextStyle: {color: '#333'}},
                vAxis: {minValue: 0}
            };

            var chart = new google.visualization.AreaChart(document.getElementById('chart_div_3'));
            chart.draw(data, options);
        }

        function drawChart4() {
            var data = google.visualization.arrayToDataTable([
                ['Country', 'Popularity'],
                ['Germany', 200],
                ['United States', 300],
                ['Brazil', 400],
                ['Canada', 500],
                ['France', 600],
                ['RU', 700]
            ]);

            var options = {};

            var chart = new google.visualization.GeoChart(document.getElementById('chart_div_4'));

            chart.draw(data, options);
        }
    </script>
	<script>
    window.dataLayer = window.dataLayer || [];
    function gtag(){dataLayer.push(arguments);}
    gtag('js', new Date());

    gtag('config', 'UA-118868344-1');
</script>

</body>
</html>