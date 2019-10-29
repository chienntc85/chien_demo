<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Add User</title>
	<!-- Bootstrap CSS-->
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/fontawesome-all.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/bootadmin.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/custominput.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/jquery-ui.min.css">
</head>
<body>
	<div class="container">
		<!-- MAIN CONTENT-->
        <div class="main-content">
            <div class="section__content section__content--p30">
                <div class="container-fluid">
                    <div class="row">         
                        <div class="col-lg-12">
                            <div class="card">
                                <div class="card-header">
                                    <strong>User </strong>Form
                                </div>
                                <div class="card-body card-block">
                                        <div class="row form-group">
                                            <div class="col col-md-3">
                                                <label for="text-input" class=" form-control-label">Tên User</label>
                                            </div>
                                            <div class="col-12 col-md-9">
                                                <input type="text" id="nameUser" name="nameUser" placeholder="nameUser" class="form-control">
                                                <small class="form-text text-muted">This is a help text</small>
                                            </div>
                                        </div>
                                         <div class="row form-group">
                                            <div class="col col-md-3">
                                                <label for="text-input" class=" form-control-label">Số điện thoại</label>
                                            </div>
                                            <div class="col-12 col-md-9">
                                                <input type="number" id="numberphone" name="numberphone" placeholder="Numberphone" class="form-control">
                                                <small class="form-text text-muted">This is a help text</small>
                                            </div>
                                        </div>
                                        <div class="row form-group">
                                            <div class="col col-md-3">
                                                <label for="email-input" class=" form-control-label">Email</label>
                                            </div>
                                            <div class="col-12 col-md-9">
                                                <input type="email" id="email" name="email" placeholder="Enter Email" class="form-control">
                                                <small class="help-block form-text">Please enter your email</small>
                                            </div>
                                        </div>
                                        <div class="row form-group">
                                            <div class="col col-md-3">
                                                <label for="password-input" class=" form-control-label">Password</label>
                                            </div>
                                            <div class="col-12 col-md-9">
                                                <input type="password" id="password" name="password" placeholder="Password" class="form-control">
                                                <small class="help-block form-text">Please enter a complex password</small>
                                            </div>
                                        </div>
                                        
                                        
                                        <div class="row form-group row_role">
                                            <div class="col col-md-3">
                                                <label for="select" class=" form-control-label">Quyền</label>
                                            </div>
                                            <div class="col-12 col-md-9">
                                                <select name="role" id="role" class="form-control">
                                                </select>
                                            </div>
                                        </div>
                                        
                                        
                                        <div class="row form-group">
                                            <div class="col col-md-3">
                                                <label class=" form-control-label">Giới tính</label>
                                            </div>
                                            <div class="col col-md-9">
                                                <div id="sex" class="form-check">
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
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row form-group">
                                            <div class="col col-md-3">
                                                <label for="textarea-input" class=" form-control-label">Ngày sinh</label>
                                            </div>
                                            <div class="col-12 col-md-9">
                                                <input type='text' id="birthday" name="birthday" class="form-control" />
                                            </div>
                                        </div>
                                                                            
                                        <div class="row form-group">
                                            <div class="col col-md-3">
                                                <label for="textarea-input" class=" form-control-label">Địa chỉ</label>
                                            </div>
                                            <div class="col-12 col-md-9">
                                                <textarea name="address" id="address" rows="3" placeholder="Enter Address..." class="form-control"></textarea>
                                            </div>
                                        </div>
                                </div>
                                <div class="card-footer">
                                    <button id="submit-user" class="btn btn-primary btn-sm">
                                        <i class="fas fa-check-circle"></i> Submit
                                    </button>
                                    <button id="reset_user" class="btn btn-danger btn-sm">
                                        <i class="fa fa-ban"></i> Reset
                                    </button>
                                </div>
                            </div>
                        </div>
                        <!--===============-->
                    </div>
                    
                </div>
            </div>
        </div>
	</div>
<script src="<%=request.getContextPath() %>/resources/js/out-js/jquery.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/out-js/bootstrap.bundle.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/out-js/bootadmin.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/out-js/jquery-ui.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/admin-api/add_user.js"></script>
</body>
</html>