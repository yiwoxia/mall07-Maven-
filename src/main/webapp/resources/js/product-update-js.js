	/* 上传图片  */
		function uploadPic(){
		//定义参数
		var options = {
				url : "${pageContext.request.contextPath}/upload/uploadPic.action",
				dataType : "json",
				type : "post",
				success : function(data){
					/* mainImage获得参数的 */
					$("#mainImage").val(data.fileName);
					console.log(data);
					/* imgSrc图片存储的路径 */
					$("#imgSrc").attr("src" ,data.filePath);
				}
		};
		$("#form-add").ajaxSubmit(options);
	}
		
		/* 商品分类二级联动 开始 */
		$(function() {
		    $.ajax({
		        url:"/Java1707Mall/category/categoryParent.action",
		        dataType:"json",
		        success:function(data,textStatus,ajax){
		           //append_template(data, "province");
		           var html = "<option value=''>-请选择-</option>";
		           for(var i=0;i<data.length;i++){
		               html +="<option value='"+data[i].id+"'>"+data[i].name+"</option>";
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
		        url:"/Java1707Mall/category/category.action",
		        data:"parentId="+parentId,
		        dataType:"json",
		        success:function(data,textStatus,ajax){
		           //append_template(data, "city");
		           
		           var html = "<option value=''>-请选择-</option>";
		           for(var i=0;i<data.length;i++){
		               html +="<option value='"+data[i].id+"'>"+data[i].name+"</option>";
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
		function append_template(jsonData,target){
		    var length = jsonData.length;
		    var html = "<option value=''>-请选择-</option>";
		    for(var i=0;i<length;i++){
		        html +="<option value='"+data[i].id+"'>"+data[i].name+"</option>";
		    }
		    $("#"+target).html(html);
		}; 
		/* 商品分类二级联动 结束 */
		
		/* 回显  */
		$(function() {
			$("#status option[value='${product.status}']").prop("selected", true);
		});
		
		
		
		
		