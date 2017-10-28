<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="com.situ.mall.pojo.Product"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加商城</title>
<!-- 调head路径 -->
<%@include file="../common/head.jsp"%>
<link
	href="${ctx}/resources/thirdlib/kindeditor/themes/default/default.css"
	type="text/css" rel="stylesheet">
<script type="text/javascript" src="${ctx}/resources/thirdlib/layer/layer.js"></script> 
<script type="text/javascript" charset="utf-8"
	src="${ctx}/resources/thirdlib/kindeditor/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8"
	src="${ctx}/resources/thirdlib/kindeditor/lang/zh_CN.js"></script>
<style type="text/css">
#categoryParentId, #categoryChildId {
	width: 20%;
	float: left;
}

#text {
	float: left;
	margin-top: 7px;
}

.form-group {
	clear: left;
}
</style>
<script type="text/javascript">
	/* function uploadPic(){
	 //定义参数("src" , "/pic/" + data.fileName);
	 var options = {
	 url : "${pageContext.request.contextPath}/upload/uploadPic.action",
	 dataType : "json",
	 type : "post",
	 success : function(data){
	 $("#mainImage").val(data.fileName);
	 $("#imgId").attr("src", data.filePath);
	 }
	 };
	 $("#form-add").ajaxSubmit(options);
	 } */
	/* 上传图片  */
	function uploadPic() {
		//定义参数
		var options = {
			url : "${pageContext.request.contextPath}/upload/uploadPic.action",
			dataType : "json",
			type : "post",
			success : function(data) {
				/* mainImage获得参数的 */
				$("#mainImage").val(data.fileName);
				console.log(data);
				/* imgSrc图片存储的路径 */
				$("#imgSrc").attr("src", data.filePath);
			}
		};
		$("#form-add").ajaxSubmit(options);
	}
	/*商品分类二级联动开始*/
	$(function() {

		$.ajax({
			url : "/Java1707Mall/category/categoryParent.action",
			dateType : "json",
			success : function(data, textStatus, ajax) {
				//append_template(data, "province");
				var html = "<option value=''>-请选择1111-</option>";
				for (var i = 0; i < data.length; i++) {
					html += "<option value='"+data[i].id+"'>" + data[i].name
							+ "</option>";
				}
				$("#categoryParentId").html(html);
			}
		});
	});
	function selectCategories(obj) {
		var parentId = $(obj).val();
		//清空子类下拉框中的内容，出第一项外
		$("#categoryChildId option:gt(0)").remove();
		$.ajax({
			url : "/Java1707Mall/category/category.action",
			//内容
			data : "parentId=" + parentId,
			//类型
			dataType : "json",
			success : function(data, textStatus, ajax) {
				//append_template(data, "city");
				var html = "<option value=''>-请选择-</option>"
				for (var i = 0; i < data.length; i++) {
					html += "<option value='"+data[i].id+"'>" + data[i].name
							+ "</option>";
				}
				$("#categoryChildId").html(html);
			}
		});
	}
	function selectId() {
		var categoryParentVal = $("#categoryParentId").val();
		var categoryVal = $("#categoryChildId").val();

		if (categoryVal != '') {
			$("#categoryId").val(categoryVal);
		} else {
			$("#categoryId").val(categoryParentVal);
		}
	}

	//封装其通用内容
	function append_template(jsonData, target) {
		var length = jsonData.length;
		var html = "<option value=''>-请选择-</option>";
		for (var i = 0; i < length; i++) {
			html += "<option value='"+data[i].id+"'>" + data[i].name
					+ "</option>";
		}
		$("#" + target).html(html);
	};
	/* 商品分类二级联动 结束 */
	
	/* 进行ajax状态 */
	function submitFrom(){
		var options={
			url:"${ctx}/mall/addProdutCont.action",
			type:"post",
			dataType:"json",
			data:$("#add-form").serialize(),
			success:function(data){
				/* if(data.status == 0){
					alert(data.msg);
				}else{
					alert(data.msg);
				} */
				if(data.status==0){
            		layer.confirm(
           				'添加成功',
           				{btn:['关闭','跳转到列表界面']},
           				function(index){
           					layer.close(index);
           				},
           				function(){
           					window.location.href = "${ctx}/mall/pageList.action";
           				}
           			);
            	} else{
            		layer.msg("添加失败");
            	}
			}
		}
		$.ajax(options)
	};
	/*清空表单*/
	function clearFrom(){
		$("#add-form")[0].reset();
	}
</script>
</head>
<body>

			<!-- 右边栏开始  -->
			<div class="col-md-10">
				<!-- 添加商品 开始 -->
				<form style="margin-top: 10px;"
					action="${ctx}/mall/addProdutCont.action" method="post"
					enctype="multipart/form-data" id="add-form">
					<!-- 商品分类开始 -->
					<div class="form-group" onmouseout="selectId()">
						<label for="exampleInputEmail1" id="text">产品分类：&nbsp;&nbsp;&nbsp;</label>
						<select id="categoryParentId" onchange="selectCategories(this)"
							class="form-control select">
							<option value="">-请选择-</option>
						</select> <label for="exampleInputEmail1" id="text">&nbsp;&nbsp;&nbsp;产品类型：&nbsp;&nbsp;&nbsp;</label>
						<select id="categoryChildId" class="form-control select">
							<option value="">-请选择-</option>
						</select>
					</div>
					<input type="hidden" id="categoryId" name="categoryId">
					<!-- 商品分类结束 -->
					<div class="form-group">
						<label for="exampleInputEmail1">商品名称</label> <input type="text"
							name="name" class="form-control" id="exampleInputEmail1"
							placeholder="商品名称">
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1"> 商品副标题</label> <input type="text"
							name="subtitle" categoryId" class="form-control"
							id="exampleInputEmail1" placeholder="副标题">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">价格</label> <input type="text"
							name="price" class="form-control" id="exampleInputPassword1"
							placeholder="价格">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">库存</label> <input type="text"
							name="stock" class="form-control" id="exampleInputPassword1"
							placeholder="库存">
					</div>
					<div class="form_group">
						<label for="exampleInputPassword1">状态</label> <select
							name="status" class="form-control">
							<option value="">请选择</option>
							<option value="1">在售</option>
							<option value="2">下架</option>
							<option value="3">删除</option>
						</select>
					</div>
					<!--   
				  <div class="form-group">
					  <label for="exampleInputPassword1">商品价格</label>
					  <input type="text" name="price" class="form-control" id="exampleInputPassword1" placeholder="商品价格">
				  </div>
				  <div class="form-group">
					  <label for="exampleInputPassword1">货存</label>
					  <input type="text" name="stock" class="form-control" id="exampleInputPassword1" placeholder="货存">
				  </div> -->

					<div class="form-group">
						<label>产品主图</label> 
						<img alt="" id="imgSrc" src="" width=100 height=100> 
						<input type="hidden" name="mainImage" id="mainImage" /> 
						<input type="file" name="pictureFile" onchange="uploadPic();" />
					</div>

					<div class="from-group">
						<label>商品图片</label> <a href="javaSCRIPT:void(0)"
							class="picFileUpload" id="picFileUpload">上传图片</a> <input
							type="hidden" name="subImages" id="subImages" />
						<div id="J_imageView"></div>
					</div>
					<div calss="form-group">
						<label>商品描述</label>
						<textarea style="width: 900px; heighjt: 300px;" name="detail"></textarea>
					</div>

					<button type="button" class="btn btn-primary" onclick="submitFrom()">添加商品</button>
					<button type="button" class="btn btn-primary" onclick="clearFrom()">清空表单</button>
				</form>
				<!-- 添加学生 结束 -->
			</div>
	<!-- 中间内容部分 end -->
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
				//富文本编辑器
				myKindEditor = KindEditor.create('#form-add[name=detail]', kingEditorParams);
			});
</script>
