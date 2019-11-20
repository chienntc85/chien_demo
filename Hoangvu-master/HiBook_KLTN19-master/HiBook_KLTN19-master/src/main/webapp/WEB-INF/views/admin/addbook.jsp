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
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/bootadmin.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/custominput.css">

    <title>Add Book Tour | HiBokkTourAdmin</title>
</head>
<body class="bg-light">

  		<!-- Modal Add  -->
  		<div class="container ">
		        
		        <!-- Modal body -->
         <div class="row">         
             <div class="col-lg-12">
                 <div class="card">
                     <div class="card-header">
                         <strong>Book</strong> Form
                     </div>
	                     <div class="card-body card-block">
	                             <div class="row form-group">
	                                 <div class="col col-md-3">
	                                     <label for="text-input" class=" form-control-label">Tên tour</label>
	                                 </div>
	                                 <div class="col-12 col-md-9">
	                                     <input type="text" id="nameBook" name="nameBook" placeholder="Tên tour" class="form-control">
	                                     <small class="form-text text-muted">This is a help text</small>
	                                 </div>
	                             </div>
	                             <div class="row form-group">
	                                 <div class="col col-md-3">
	                                     <label for="text-input" class=" form-control-label">Giá Tour</label>
	                                 </div>
	                                 <div class="col-12 col-md-9">
	                                     <input type="number" id="price" name="price" placeholder="Giá Tour" class="form-control">
	                                     <small class="form-text text-muted">This is a help number</small>
	                                 </div>
	                             </div>
	                             <div class="row form-group">
	                                 <div class="col col-md-3">
	                                     <label for="text-input" class=" form-control-label">Giảm giá(%)</label>
	                                 </div>
	                                 <div class="col-12 col-md-9">
	                                     <input type="number" id="discount" name="discount" placeholder="Giảm giá" class="form-control">
	                                     <small class="form-text text-muted">This is a help number</small>
	                                 </div>
	                             </div>
	                             <div class="row form-group">
	                                 <div class="col col-md-3">
	                                     <label for="text-input" class=" form-control-label">Địa điểm xuất phát</label>
	                                 </div>
	                                 <div class="col-12 col-md-9">
	                                     <input type="text" id="publisher" name="publisher" placeholder="địa điểm xuất phát" class="form-control">
	                                     <small class="form-text text-muted">This is a help text</small>
	                                 </div>
	                             </div>
	                             <div class="row form-group">
	                                 <div class="col col-md-3">
	                                     <label for="text-input" class=" form-control-label">Số lượng Tour</label>
	                                 </div>
	                                 <div class="col-12 col-md-9">
	                                     <input type="text" id="size" name="size" placeholder="Size" class="form-control">
	                                     <small class="form-text text-muted">ex: 20(kg)</small>
	                                 </div>
	                             </div>
	                             <div class="row form-group">
	                                 <div class="col col-md-3">
	                                     <label for="text-input" class=" form-control-label">Số ngày</label>
	                                 </div>
	                                 <div class="col-12 col-md-9">
	                                     <input type="number" id="numberPage" name="numberPage" placeholder="Số ngày" class="form-control">
	                                     <small class="form-text text-muted">This is a help number</small>
	                                 </div>
	                             </div>
	                             <div class="row form-group">
	                                 <div class="col col-md-3">
	                                     <label for="text-input" class=" form-control-label">Ngày khời hành</label>
	                                 </div>
	                                 <div class="col-12 col-md-9">
	                                     <input type="text" id="publicationDate" name="publicationDate" placeholder="Ngày khời hành" class="form-control">
	                                     <small class="form-text text-muted">ex: 10-10-2019</small>
	                                 </div>
	                             </div>
	                             <div class="row form-group">
	                                 <div class="col col-md-3">
	                                     <label for="text-input" class=" form-control-label">Khối lượng hành lý</label>
	                                 </div>
	                                 <div class="col-12 col-md-9">
	                                     <input type="number" id="quantity" name="quantity" placeholder="Khối lượng hành lý" class="form-control">
	                                     <small class="form-text text-muted">This is a help number</small>
	                                 </div>
	                             </div>
	                             <div class="row form-group">
	                                 <div class="col col-md-3">
	                                     <label class=" form-control-label">Phương tiện</label>
	                                 </div>
	                                 <div class="col col-md-9">
	                                     <div class="form-check">
	                                         <div class="radio">
	                                             <label for="radio1" class="form-check-label ">
	                                                 <input type="radio" id="radio1" name="cover" value="Bìa mềm" class="form-check-input" checked="true">Máy bay
	                                             </label>
	                                         </div>
	                                         <div class="radio">
	                                             <label for="radio2" class="form-check-label ">
	                                                 <input type="radio" id="radio2" name="cover" value="Bìa cứng" class="form-check-input">Xe khách
	                                             </label>
	                                         </div>
	                                     </div>
	                                 </div>	
	                             </div>
	                             <div class="row form-group">
	                                 <div class="col col-md-3">
	                                     <label for="textarea-input" class=" form-control-label">Giới thiệu tour</label>
	                                 </div>
	                                 <div class="col-12 col-md-9">
	                                     <textarea name="intro" id="intro" rows="9" placeholder="Content..." class="form-control"></textarea>
	                                 </div>
	                             </div>
	                             <div class="row form-group">
	                                 <div class="col col-md-3">
	                                     <label for="file-multiple-img" class=" form-control-label">Hình tour</label>
	                                 </div>
	                                 <div class="col-12 col-md-9 mb-3">
	                                 	<div class="mb-3">
	                                 		<input type="file" id="file-multiple-img" accept="image/*" name="fileimg" value="" class="form-control-file md-3 cus-input">
	                                 	</div>
	                                     <!-- Bootstrap Progress bar -->
									    <div class="progress">
									      <div id="progressBarImg" class="progress-bar progress-bar-striped bg-success" role="progressbar"
									        aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 0%">0%</div>
									    </div>
	                                 </div>
								</div>
	                             <div class="row form-group">
	                                 <div class="col col-md-3">
	                                     <label for="file-multiple-proofread" class=" form-control-label">File review</label>
	                                 </div>
	                                 <div class="col-12 col-md-9">
	                                 	<div class="mb-3">
	                                 		<input type="file" id="file-multiple-proofread" name="fileproofread" value="" class="form-control-file cus-input">
	                                 	</div>
	                                      <!-- Bootstrap Progress bar -->
									    <div class="progress">
									      <div id="progressBarFile" class="progress-bar progress-bar-striped bg-info" role="progressbar"
									        aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 0%">0%</div>
									    </div>
	                                 </div>
	                             </div>
	                             <div class="row form-group">
	                                 <div class="col col-md-3">
	                                     <label for="select" class=" form-control-label">Loại tour</label>
	                                 </div>
	                                 <div class="col-12 col-md-9">
	                                     <select name="idType" id="idType" class="form-control">
	                                         <c:forEach items="${type}" var="type">
	                                     		<option value="${type.getIdType()}">${type.getNameType()}</option>
	                                     	</c:forEach>
	                                     </select>
	                                 </div>
	                             </div>
	                             <div class="row form-group">
	                                 <div class="col col-md-3">
	                                     <label for="select" class=" form-control-label">Công ty lữ hành</label>
	                                 </div>
	                                 <div class="col-12 col-md-9">
	                                     <select name="idSupplier" id="idSupplier" class="form-control">
	                                     	<c:forEach items="${supplier}" var="supplier">
	                                     		<option data-id="${supplier.getIdSupplier()}">${supplier.getNameSupplier()}</option>
	                                     	</c:forEach>
	                                     </select>
	                                 </div>
	                             </div>
	                             <div class="row form-group">
	                                 <div class="col col-md-3">
	                                     <label for="multiple-select" class=" form-control-label">Lịch trình</label>
	                                 </div>
	                                 <div class="col col-md-3">
	                                     <select name="idAuthor" id="idAuthor" class="form-control " >
	                                     </select>
	                                 </div>
	                                 <div  class="col col-md-6">
	                                     <div id="arr_author"> </div>
	                                 </div>
	                             </div>
	                             <div class="row form-group">
	                                 <div class="col col-md-3">
	                                     <label for="multiple-select" class=" form-control-label">Tag</label>
	                                 </div>
	                                 <div class="col col-md-3">
	                                     <input type="text" name="tagsearch" id="tagSearch" class="form-control" placeholder="+tag"/>
	                                 </div>
	                                 <div  class="col col-md-6">
	                                     <div id="arr_tag"> </div>
	                                 </div>
	                             </div>
	                     </div>
	                     <div class="card-footer">
	                         <button id="submit_book" class="btn btn-primary btn-sm">
	                             <i class="fa fa-dot-circle-o"></i> Submit
	                         </button>
	                         <button type="<%=request.getContextPath() %>/reset" id="<%=request.getContextPath() %>/reset_book" class="btn btn-danger btn-sm">
	                             <i class="fa fa-ban"></i> Reset
	                         </button>
	                     </div>
                 </div>
             </div>
             <!--===============-->
         </div>
    </div>
<script src="https://cdn.ckeditor.com/4.7.0/full-all/ckeditor.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/out-js/jquery.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/out-js/bootstrap.bundle.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/out-js/bootadmin.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/admin-api/add_book.js"></script>
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