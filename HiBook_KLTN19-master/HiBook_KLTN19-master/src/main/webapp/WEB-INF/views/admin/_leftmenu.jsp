<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<div class="sidebar sidebar-dark bg-dark">
	<ul class="list-unstyled">
		<li class="active"><a href="dashboard"><i
				class="fa fa-fw fa-tachometer-alt"></i> Dashboard</a></li>
		<li><a href="#sm_base" data-toggle="collapse" aria-expanded="true"> <i
				class="fa fa-fw fa-cube"></i> Base </a>
			<ul id="sm_base" class="list-unstyled collapse show">
				<li><a href="manage-author"> Tác giả</a></li>
				<li><a href="manage-orderstatus"> Tình trạng đơn hàng</a></li>
				<li><a href="manage-payment"> Thanh toán</a></li>
				<li><a href="manage-supplier"> Nhà cung cấp</a></li>
				<li><a href="manage-transport"> Vận chuyển</a></li>
				<li><a href="manage-typebook"> Loại sách</a></li>
				<li><a href="manage-userreview"> Review sách</a></li>
			</ul></li>
		<li><a href="manage-book"><i class="fas fa-fw fa-book"></i> Sách</a></li>
		<li><a href="manage-bill"><i class="fa fa-fw fa-edit"></i> Hóa đơn</a></li>
		<li><a href="manage-user"><i class="fa fa-fw fa-users"></i> Tài khoản</a></li>
		<li><a href="manage-promotion"><i class="fas fa-gift"></i> Khuyến mãi</a></li>
	</ul>
</div>

<script src="resources/js/out-js/jquery.min.js"></script>
<script src="resources/js/out-js/bootstrap.bundle.min.js"></script>
<script src="resources/js/out-js/datatables.min.js"></script>
<script src="resources/js/out-js/moment.min.js"></script>
<script src="resources/js/out-js/fullcalendar.min.js"></script>
<script src="resources/js/out-js/bootadmin.min.js"></script>
