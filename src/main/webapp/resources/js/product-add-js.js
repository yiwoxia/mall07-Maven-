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