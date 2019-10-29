<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<!-- Xác định bộ mã ký tự cho văn bản HTML. -->
<meta charset="UTF-8">
<!-- ĐỊnh dạng tiêu đề HTML -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- Giúp trang web dễ nhìn trên tất cả các thiết bị -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap.css" />
<!-- CSS -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/info_css.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/myhome.css" />

<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/jquery-ui.min.css">
<title>Update User</title>
<!--Icon fa-->
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/fontawesome-all.min.css">
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
	<%@ include file="../_header.jsp"%>
	<!--
		==============================content===================================
	-->
	<div class="container" style="margin-top: 10px;">
		<div class="row profile">
			<div class="col-md-3">
				<div class="profile-sidebar">
					<!-- SIDEBAR USER TITLE -->
					<div class="profile-usertitle">
						<div class="profile-usertitle-name">${info.getNameUser()}</div>
						<div class="profile-usertitle-job">${info.getEmail()}</div>
					</div>
					<!-- END SIDEBAR USER TITLE -->
					<!-- SIDEBAR MENU -->
					<div class="profile-usermenu">
						<ul class="nav">
							<li><a
								href="<%=request.getContextPath()%>/user-info"> <span
									class="glyphicon glyphicon-user"></span> Thông tin
							</a></li>
							<li class="active"><a href="<%=request.getContextPath()%>/user-update">
									<span class="glyphicon glyphicon-pencil"></span> Quản lý thông tin
							</a></li>
							<li><a href="<%=request.getContextPath()%>/user-bill">
									<span class="glyphicon glyphicon-list-alt"></span> Quản lý hóa đơn
							</a></li>
							<li><a href="<%=request.getContextPath()%>/logout"> <span
									class="glyphicon glyphicon-log-out"></span> Đăng xuất
							</a></li>
						</ul>
					</div>
					<!-- END MENU -->
				</div>
			</div>
			<div class="col-md-9">
				<div class="profile-content">
					<div class="container">
						<div class="row">

							<div class="col-md-8 ">

									<div class="panel-heading">
										<h4>Chỉnh sửa thông tin cá nhân</h4>
									</div>
									<div class="panel-body">

										<div class="box box-info">
											<!--edit thong tin-->
											<div class="well">
												<ul class="nav nav-tabs">
													<li class="active"><a href="#home" data-toggle="tab">Thông
															tin</a></li>
													<li><a href="#profile" data-toggle="tab">Mật khẩu</a></li>
												</ul>
												<div id="myTabContent" class="tab-content" data-id="${info.getIdUser()}">
													<div class="tab-pane active in" id="home">
														<div id="tab" ">
															<label>Tên tài khoản</label> 
																<input type="text" id="nameUser" name="nameUser" class="form-control" value="${info.getNameUser() }">
															<label>Số điện thoại</label>
																<input type="number" id="numberphone" name="numberphone" class="form-control" value="${info.getNumberphone() }">
															<label>Giới tính</label> 
																<c:if test="${info.getSex() ==1}">
																	<div class="radio">
				                                                        <label for="radio1" class="form-check-label ">
				                                                            <input type="radio" id="radio1" name="sex" value="0" class="form-check-input" >Nam
				                                                        </label>
				                                                    </div>
				                                                    <div class="radio">
				                                                        <label for="radio2" class="form-check-label ">
				                                                            <input type="radio" id="radio2" name="sex" value="1" class="form-check-input" checked>Nữ
				                                                        </label>
				                                                    </div>
																</c:if>
																<c:if test="${info.getSex() ==0}">
																	<div class="radio">
				                                                        <label for="radio1" class="form-check-label ">
				                                                            <input type="radio" id="radio1" name="sex" value="0" class="form-check-input" checked>Nam
				                                                        </label>
				                                                    </div>
				                                                    <div class="radio">
				                                                        <label for="radio2" class="form-check-label ">
				                                                            <input type="radio" id="radio2" name="sex" value="1" class="form-check-input">Nữ
				                                                        </label>
				                                                    </div>
																</c:if>
																 
															<label>Ngày sinh</label> 
																 <input type='text' id="birthday" name="birthday" class="form-control" value="${info.getBirthday() }" />
															<label>Địa chỉ</label>
																<textarea name="address" id="address" rows="3" placeholder="Enter Address..." class="form-control">${info.getAddress() }</textarea>
															<div class="btn-sm">
																<button id="btn_LuuInfo" class="btn btn-primary">Lưu</button>
															</div>
														</div>
													</div>
													<div class="tab-pane fade" id="profile">
														<div id="tab2">
															<label>Mật khẩu cũ</label> <input type="password" id="passwordold" name="passwordold" placeholder="Nhập mật khẩu cũ" class="form-control"> 
															<label>Mật khẩu mới</label> <input type="password" id="passwordnew" name="passwordnew" placeholder="Nhập mật khẩu mới" class="form-control">
															<label>Nhập lại mật khẩu mới</label> <input type="password" id="passwordagain" name="passwordagain" placeholder="Nhập lại mật khẩu mới" class="form-control">
															<div>
																<button id="btn_LuuPass" class="btn btn-primary">Lưu</button>
															</div>
														</div>
													</div>
												</div>
												<!--end edit thong tin-->
											</div>
										</div>
									</div>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- =================END CONTENT===========================
	 -->
	<!-- Footer -->
	<%@ include file="../_footer.jsp"%>
	<!-- ./Footer -->
	
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
  	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="<%=request.getContextPath()%>/resources/js/out-js/bootstrap.min.js"></script>
	
	<script src="<%=request.getContextPath() %>/resources/js/out-js/jquery-ui.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="<%=request.getContextPath()%>/resources/js/user-api/userupdate.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/search.js"></script>
</body>
</html>