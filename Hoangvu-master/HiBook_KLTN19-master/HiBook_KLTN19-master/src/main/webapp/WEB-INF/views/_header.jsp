<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<style>
.top-alert {
	position: fixed;
	top: 100px;
	width: 100%;
	z-index: 100000;
	font-size: 15px;
	left: 0;
	display: inline-block;
	text-align: center;
}

.top-alert .alert {
	width: auto !important;
	height: 100%;
	display: inline;
	position: relative;
	margin: 0;
	border-color: #9a9082 !important;
}

.top-alert .alert .close {
	position: absolute;
	top: 11px;
	right: 10px;
	color: inherit;
}
</style>
<!--
		==============================Hearder====================================
-->
<div class="container">
	<div class="topbar">
		<div id="menu">
			<ul>
				<li class="sdt"><span class="glyphicon glyphicon-earphone"></span>0868.934.262
				</li>
				<li class="gmail"><span class="	glyphicon glyphicon-envelope"></span>booktour@gmail.com</li>
			</ul>
		</div>
	</div>
</div>
<header id="header">
	<!-- <nav class="navbar .navbar-expand-sm navbar-inverse" data-spy="affix"
		data-offset-top="50"> -->
	<nav class="navbar .navbar-expand-sm navbar-inverse" >
		<div class="container">
			<div class="navbar-header">
				<c:choose>
					<c:when test="${pageContext.request.userPrincipal.name !=null}">
						<a class="navbar-brand" href="<%=request.getContextPath()%>/">
							<img style="width: 220px; height: 140px; margin-top: -6px;"
							src="<%=request.getContextPath()%>/resources/images/tc12.png" />
						</a>
					</c:when>
					<c:otherwise>
						<a class="navbar-brand" href="<%=request.getContextPath()%>/">
							<img style="width: 220px; height: 140px; margin-top: -6px;"
							src="<%=request.getContextPath()%>/resources/images/tc12.png" />
						</a>
					</c:otherwise>
				</c:choose>

				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
			</div>

			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav ">
					<li class="dropdown"><a href="khoahoc.html"
						class="dropdown-toggle" data-toggle="dropdown"> <i
							class="fas fa-th-list"></i> LOẠI TOUR<span class="caret"></span></a>
						<ul class="dropdown-menu" id="typeBook">

						</ul></li>
					<!-- form search -->
					<li class="search">
						<div class="header_search">
							<span class="glyphicon glyphicon-search"
								style="width: 18px; height: 18px; margin-right: 9.6px"></span>
							<input id="search" class="gtm_search_bar search-bar" name="key"
								placeholder="Tìm kiếm tour ..." style="font-family: Open Sans;"
								type="text"	/>
						</div>
					</li>
					
				</ul>

				<ul class="nav navbar-nav navbar-right"
					style="padding-left: -69px; margin-left: -29px; margin-top: -3px;">
					<c:choose>
						<c:when test="${pageContext.request.userPrincipal.name !=null}">
							<ul class="nav navbar-nav navbar-left" style="margin-top: -7px;">

								<li id="giohanghome" class="getthongbao">
									<a class="nav-link" href="<%=request.getContextPath()%>/cart">
										<img id="header_logo" alt="logo"
										src="<%=request.getContextPath()%>/resources/images/shopping-cart.png" />
										<div class="giohang_circle">
											<span></span>
										</div>
									</a>
								</li>
							</ul>
							<li class="dropdown"><a href="khoahoc.html"
								class="dropdown-toggle" data-toggle="dropdown"> <i
									class="fas fa-user fa-fw text-success"></i> Thông tin <span
									class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a class="nav-link"
										href="<%=request.getContextPath()%>/user-info">
											${pageContext.request.userPrincipal.name}</a></li>
									<li><a class="nav-link"
										href="<%=request.getContextPath()%>/logout"> Logout</a></li>
								</ul></li>
						</c:when>


						<c:otherwise>
							<li><a class="nav-link" id="nutDK" data-toggle="modal">
									ĐĂNG KÝ </a></li>
							<li><a class="nav-link" id="nutDN" data-toggle="modal">
									ĐĂNG NHẬP </a></li>
						</c:otherwise>
					</c:choose>

				</ul>


			</div>
		</div>
		<!--end container-->
	</nav>
	<!--end nav-->
</header>
<!--end header-->
<!--
		==============================Login mờ màn hình====================================
-->

<div id="idLogin" class="modal">
	<form class="modal-content animate" action="<%=request.getContextPath()%>/j_spring_security_login"
		method="post">
		<div class="imgcontainer">
			<span id="btnClose" class="close" title="Close Modal">&times;</span>
			<img src="<%=request.getContextPath()%>/resources/images/TC.png" alt="Avatar" class="avatar">
		</div>

	 	<!-- /login?error=true -->
	     <c:if test="${param.error}">
	         <div style="color:red;margin:10px 0px;">
	                Login Failed!!!<br />
	                Reason :  ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
	         </div>
	    </c:if>
		<div class="inputcontainer">
			<input type="text" id="username" placeholder="Tên đăng nhập*"
				name="username" required><br />
			<p>
				<span class="error" id="username_error"></span>
			</p>

			<input type="password" id="password" placeholder="Mật khẩu*"
				name="password" required><br />
			<p>
				<span class="error" id="password_error"></span>
			</p>

			<input type="checkbox" checked="checked"> Ghi nhớ<br />
			<button type="submit" id="btnDangNhap" class="submitbtn">Đăng nhập</button>
			<br />
		</div>
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
		<div class="inputcontainer">
			<button type="button" id="btnCancel" class="cancelbtn">Hủy</button>
			<span class="psw">Quên <a href="#">mật khẩu?</a></span>
		</div>
	</form>
	<!--end form-->
</div>
<!--end div login-->
<!--
		==============================Đăng kí====================================
-->

<div id="idCreate" class="modal">
	<form class="modal-content animate"
		action="<%=request.getContextPath()%>/register" method="post">
		<div class="imgcontainer">
			<span id="btnClose1" class="close" title="Close Modal">&times;</span>
			<img src="<%=request.getContextPath()%>/resources/images/TC.png" alt="Avatar" class="avatar">
		</div>

		<div class="inputcontainer">
			<input type="text" id="username1" placeholder="Tên người dùng*"
				name="uname" required><br />
			<p>
				<span class="error" id="username1_error"></span>
			</p>

			<input type="password" id="password0" placeholder="Mật khẩu*"
				name="psw" required><br />
			<p>
				<span class="error" id="password0_error"></span>
			</p>
			<input type="password" id="password1"
				placeholder="Nhập lại mật khẩu*" name="rpsw" required><br />
			<p>
				<span class="error" id="password1_error"></span>
			</p>

			<input type="text" id="email" placeholder="Email*" name="email"
				required><br />
			<p>
				<span class="error" id="email_error"></span>
			</p>
			<button type="submit" id="btnDangKy" class="submitbtn">Đăng Ký</button>
			<br/>
		</div>
		<div>
			<span>${erro}</span>
		</div>

		<div class="inputcontainer">
			<button type="button" id="btnCancel1" class="cancelbtn">Hủy</button>
		</div>
	</form>
	<!--end form-->
</div>
<!--end div register-->
<div class="thongbao"></div>


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
 <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/handle-js/accounthome.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/hearder.js"></script>

<c:if test="${param.erro == 1}">
	<script>
	$(document).ready(function() {
		$('.thongbao').html('<div class="top-alert"><div class="alert alert-success" role="alert"><i class="far fa-check-circle"></i> Đăng ký thành công! Vui Lòng đăng nhập lại.</div></div>');
		$('.thongbao').fadeIn();
		setTimeout(function() {
			
			$('.thongbao').fadeOut(function() {
				$('.thongbao').empty();
			});
		}, 2000);
	});
	</script>
</c:if> 
<c:if test="${param.erro == -1}">
	<script>
	$(document).ready(function() {
		$('.thongbao').html('<div class="top-alert"><div class="alert alert-danger" role="alert"><i class="far fa fa-times"></i> Đăng ký thất bại. Email đã tồn tại!</div></div>');
		$('.thongbao').fadeIn();
		setTimeout(function() {
			
			$('.thongbao').fadeOut(function() {
				$('.thongbao').empty();
			});
		}, 2000);
	});
	</script>
</c:if> 
