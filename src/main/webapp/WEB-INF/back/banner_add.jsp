<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath }" ></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加广告图组</title>
	<!-- head begin -->
<link rel="stylesheet" type="text/css" href="${ctx }/resources/thirdlib/kindeditor/themes/default/default.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/resources/thrLib/bootstrap/css/bootstrap.css" />
<script type="text/javascript" src="${ctx}/resources/thrLib/jquery/jquery-1.11.1.js"></script>
<script  type="text/javascript" src="${ctx }/resources/thirdlib/kindeditor/kindeditor-all-min.js" /></script>
<script type="text/javascript" src="${ctx }/resources/thirdlib/kindeditor/lang/zh_CN.js"></script>
<style type="text/css">
	#categoryParentId,#categoryChildId{
		width: 20%;
		float: left;
	}
	#text{
		float: left;
		margin-top: 7px;
	}
	.form-group{
		clear: left;
	}
</style>
<script type="text/javascript">
	/* var urlPRC="${pageContext.request.contextPath}";  */
	
</script>
<%--  <script type="text/javascript" src="${ctx }/resources/js/product-add.js"></script>  --%>
</head>
<body>
	<div class="container" >
		<div class="row">
			<!-- 左边导航栏开始  -->
			<!-- 左边导航栏结束  -->
			<!-- 右边栏开始  -->
			<div class="col-md-10">
				<!-- 添加商品 开始 -->
				<form style="margin-top: 10px;" id="form-add" action="${ctx }/banner/addBanner.action" method="post" enctype="multipart/form-data" >
				
				  <div class="form-group">
					   <label for="exampleInputEmail1">广告图名称</label>
					   <input type="text" name="name" class="form-control" id="exampleInputEmail1" placeholder="商品名称">
				  </div>
				  <div class="form-group">
					   <label for="exampleInputEmail1">状态</label>
					   <input type="text" name="status" value="2" readonly="readonly" class="form-control" id="exampleInputEmail1">
				  </div>
				  
				 	<div class="from-group">
						<label>商品图片</label> 
						<a href="javaSCRIPT:void(0)" class="picFileUpload" id="picFileUpload">上传图片</a> 
						<input type="hidden" name="imageUrl" id="subImages" />
						<div id="J_imageView"></div>
					</div>
					
				  <button type="submit" class="btn btn-primary">Submit</button>
				  </div>
				</form>
				<!-- 添加学生 结束 -->
			</div>
			<!-- 右边栏结束  -->
</body>
</html>
<script type="text/javascript">
	var myKindEditor;
	KindEditor
			.ready(function(K) {
				var kingEditorParams = {
					//指定上传文件参数名称
					filePostName : "pictureFile",
					//指定上传文件请求的url请求的是UploadController里面的类型方法。
					uploadJson : '${ctx}/upload/pic.action',
					//上传类型，分别为image、flash、media、file
					dir : "image",
					afterBlur : function() {
						this.sync();
					}
				}
	
				var editor = K.editor(kingEditorParams);
				K('#picFileUpload').click(function() {
					editor.loadPlugin('multiimage', function() {
						editor.plugin.multiImageDialog({
							clickFn : function(urlList) {
								var div = K('#J_imageView');
								var imgArray = [];
								div.html('');
								K.each(urlList, function(i, data) {
									var urlStr = data.url;
		 							var urlIndex = urlStr.lastIndexOf("/") + 1;
		 							var fileName = urlStr.substr(urlIndex, urlStr.length);
		 							imgArray.push(fileName);
		 							div.append('<img src="' + urlStr + '" width="50px" height="80px">');
		 						});
								$("#subImages").val(imgArray.join(","));
								editor.hideDialog();
							}
						});
					});
				});
			});
</script>
