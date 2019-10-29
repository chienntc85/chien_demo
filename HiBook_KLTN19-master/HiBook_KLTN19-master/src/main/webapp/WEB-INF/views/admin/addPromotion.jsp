<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/fontawesome-all.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/bootadmin.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/custominput.css">
<%-- <link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/jquery-ui.css"> --%>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">


<title>Add Promotion | HiBookAdmin</title>
</head>
<body class="bg-light">

	<!-- Modal Add  -->
	<div class="container ">

		<!-- Modal body -->
		<div class="row">
			<div class="col-lg-12">
				<div class="card">
					<div class="card-header">
						<strong>Promotion</strong> Form
					</div>
					<div class="card-body card-block">
						<div class="row form-group">
							<div class="col col-md-2">
								<label for="text-input" class=" form-control-label">Tiêu
									đề</label>
							</div>
							<div class="col-12 col-md-10">
								<input type="text" id="title" name="title"
									placeholder="" class="form-control" value="">
								<small class="form-text text-muted">This is a help text
								</small>
							</div>
						</div>

						<div class="row form-group">
							<div class="col col-md-2">
								<label for="text-input" class=" form-control-label">Giảm
									(%)</label>
							</div>
							<div class="col-12 col-md-10">
								<input type="number" id="discount" name="discount"
									placeholder="" class="form-control" value=""> <small
									class="form-text text-muted">This is a help number</small>
							</div>
						</div>


						<div class="row form-group">
							<div class="col col-md-2">
								<label for="text-input" class=" form-control-label">Ngày
									Bắt Đầu</label>
							</div>
							<div class="col-12 col-md-10">
								<input type="text" id="dateStart" name="publicationDate"
									placeholder="" class="form-control" value=""> <small
									class="form-text text-muted">ex: 02-10-2018</small>
							</div>
						</div>
						<div class="row form-group">
							<div class="col col-md-2">
								<label for="text-input" class=" form-control-label">Ngày
									Kết Thúc</label>
							</div>
							<div class="col-12 col-md-10">
								<input type="text" id="dateEnd" name="publicationDate"
									placeholder="" class="form-control" value=""> <small
									class="form-text text-muted">ex: 10-10-2019</small>
							</div>
						</div>

						<div class="row form-group">
							<div class="col col-md-2">
								<label for="textarea-input" class=" form-control-label">Nội
									dung</label>
							</div>
							<div class="col-12 col-md-10">
								<textarea name="intro" id="intro" rows="9"
									placeholder="Nội dung ..." class="ckeditor form-control"></textarea>
							</div>
						</div>
						<div class="row form-group">
							<div class="col col-md-2">
								<label for="file-multiple-img" class=" form-control-label">Ảnh</label>
							</div>
							<div class="col-12 col-md-10 mb-3">
								<div class="mb-3">
									<input type="file" id="file-multiple-img" accept="image/*"
										name="fileimg" value=""
										class="form-control-file md-3 cus-input">
								</div>
								<!-- Bootstrap Progress bar -->
								<div class="progress">
									<div id="progressBarImg"
										class="progress-bar progress-bar-striped bg-success"
										role="progressbar" aria-valuenow="0" aria-valuemin="0"
										aria-valuemax="100" style="width: 0%">0%</div>
								</div>
							</div>
						</div>
						<div class="row form-group">
							<div class="col col-md-2">
								<label for="file-multiple-proofread" class=" form-control-label">Sách
									Khuyến Mãi</label>
							</div>
							<div class="col-12 col-md-10">
								<div class="container">
									<div class="row">
										<div class="ui-widget">
											<div id="project-label">Tìm sách:</div>
											<img id="project-icon" style='width: 60px;' src=""
												class="ui-state-default" alt=""> <input id="project">
											<input type="hidden" id="project-id"> <input
												id="BookPromotion" type="button"
												class="btn btn-primary btn-sm" value='Thêm' />
										</div>
									</div>
									<div class="row">
										<table class="table table-striped">
											<thead>
												<tr>
													<th>STT</th>
													<th>Khuyến Mãi</th>
													<th>Xóa</th>
												</tr>
											</thead>
											<tbody id="lstBookPromotion">

											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="card-footer">
						<button id="submit_promotion" class="btn btn-primary btn-sm">
							<i class="fa fa-dot-circle-o"></i> Submit
						</button>
						<button type="<%=request.getContextPath()%>/reset"
							id="<%=request.getContextPath()%>/reset_book"
							class="btn btn-danger btn-sm">
							<i class="fa fa-ban"></i> Reset
						</button>
					</div>
				</div>
			</div>
			<!--===============-->
		</div>
	</div>
	<script src="https://cdn.ckeditor.com/4.7.0/full-all/ckeditor.js"></script>
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<%-- <script
		src="<%=request.getContextPath()%>/resources/js/out-js/jquery.js"></script> --%>
	<script
		src="<%=request.getContextPath()%>/resources/js/out-js/bootstrap.bundle.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/out-js/bootadmin.min.js"></script>

	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/admin-api/add_promotion.js"></script>
	<script>
		jQuery.curCSS = function(element, prop, val) {
		    return jQuery(element).css(prop, val);
		};
		var editorInstance = CKEDITOR
				.replace(
						document.getElementById("intro"),
						{
							language_list : [ "ar:Arabic:rtl", "fr:French",
									"es:Spanish", "en:English" ],
							disableNativeSpellChecker : true,
							removeButtons : "Subscript,Superscript",
							extraPlugins : "colorbutton,print,font,autolink,justify",
							removePlugins : "sourcearea,maximize,image,stylescombo,scayt,wsc,elementspath,blockquote,link,specialchar,resize",
							title : this.title,
							readOnly : false,
							resize_enabled : false,
							autoGrow_minHeight : 200,
							autoGrow_bottomSpace : 50,
							autoGrow_onStartup : true,
							toolbarStartupExpanded : false,
							toolbarGroups : [
									{
										name : "others"
									},
									{
										name : "clipboard",
										groups : [ "clipboard", "undo" ]
									},
									{
										name : "editing",
										groups : [ "find", "selection",
												"spellchecker" ]
									},
									{
										name : "links"
									},
									{
										name : "insert"
									},
									{
										name : "forms"
									},
									{
										name : "tools"
									},
									{
										name : "styles"
									},
									"/",
									{
										name : "basicstyles",
										groups : [ "basicstyles", "cleanup" ]
									},
									{
										name : "paragraph",
										groups : [ "list", "indent", "blocks",
												"align", "bidi" ]
									},
									{
										name : "colors"
									},
									{
										name : "document",
										groups : [ "mode", "document",
												"doctools" ]
									} ]
						});
	</script>


</body>
</html>