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
		/* 用于商品图片的回显 */
	    $(function() {
				var div = $('#J_imageView');
				var imgArray = [];
				div.html('');
				for ( var int = 0; int < strs.length; int++) {
					imgArray.push(strs[int]);
					$("#J_imageView").append('<img src="'+initUrl+'' + strs[int] + '" width="50px" height="80px">');
				} 
				$("#subImages").val(imgArray.join(","));
			});
		
		/* 商品分类二级联动 开始 */
		/*$(function() {
		    $.ajax({
		        url: urlPRC +"/category/categoryParent.action",
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
		});*/
	    
		/*商品分类二级联动开始*/
		$(function() {
		
			$.ajax({
				url : urlCTX + "/category/categoryParent.action",
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
	    	$("#categoryId").val($("#categoryParentId").val());
	        var parentId = $(obj).val();
	        //清空子类下拉框中的内容，出第一项外
	        $("#categoryChildId option:gt(0)").remove();
	        $.ajax({
	            url : urlCTX + "/category/category.action",
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
		
	/* 二级联动的回显 */
	    $(function(){
	    	
	        $.ajax({
	        	url :urlCTX + "/category/categoryParent.action",
	        	async:false,
	            type: 'POST',
	            dataType: 'JSON',
	            success: function(data) {
	                $.each(eval(data), function(data,textStatus,ajax) {
	                    $("<option id='op' value='"+data.id+"'>"+data.name+"</option>").appendTo($("#categoryParentId"));
	                });
	                for(var i=0;i<data.length;i++){
	                	
	                	if (parenId != 0) {
	                		if  (data[i].id != parenId) {
	                    		$("<option id='op' value='"+data[i].id+"'>"+data[i].name+"</option>").appendTo($("#categoryParentId"));
	                    	} else {
	                    		$("<option value='" + data[i].id + "'selected='selected' >" + data[i].name + "</option>").appendTo($("#categoryParentId"));
	                    	}
	                	} else if (parenId == 0) {
	                		if  (data[i].id != childId) {
	                    		$("<option id='op' value='"+data[i].id+"'>"+data[i].name+"</option>").appendTo($("#categoryParentId"));
	                    	} else {
	                    		$("<option value='" + data[i].id + "'selected='selected' >" + data[i].name + "</option>").appendTo($("#categoryParentId"));
	                    	}
	                	}
	                	
	                }
	                
	              }
	          });
	        
	        if (parenId !=0 ) {
	        	$("#categoryChildId option:gt(0)").remove();
	            $.ajax({
	            	url : urlCTX + "/category/category.action",
	            	data:"parentId="+parenId,
	            	async:false,
	            	type: 'POST',
	            	dataType: 'JSON',
	                error: function() { alert('加载数据异常，请重试!'); },
	                success: function(data,textStatus,ajax) {
	                    
	               	 if ($("#categoryParentId").val() != 0) {
	               		 
	               		 for(var i=0;i<data.length;i++){
	               			 if  (data[i].id != childId) {
	               				 $("<option id='op' value='"+data[i].id+"'>"+data[i].name+"</option>").appendTo($("#categoryChildId"));
	               			 } else {
	               				 $("<option value='" + data[i].id + "'selected='selected' >" + data[i].name + "</option>").appendTo($("#categoryChildId"));
	               			 }
	               		 }
	               	 }
	                    } 
	                
	             });
	        } else if (parenId == 0) {
	        	$("#categoryChildId option:gt(0)").remove();
	            $.ajax({
	            	url : urlCTX + "/category/category.action",
	            	data:"parentId="+childId,
	            	async:false,
	            	type: 'POST',
	            	dataType: 'JSON',
	                error: function() { alert('加载数据异常，请重试!'); },
	                success: function(data,textStatus,ajax) {
	                    
	               	 if ($("#categoryParentId").val() != 0) {
	               		 
	               		 for(var i=0;i<data.length;i++){
	               			 if  (data[i].id != childId) {
	               				 $("<option id='op' value='"+data[i].id+"'>"+data[i].name+"</option>").appendTo($("#categoryChildId"));
	               			 } else {
	               				 $("<option value='" + data[i].id + "'selected='selected' >" + data[i].name + "</option>").appendTo($("#categoryChildId"));
	               			 }
	               		 }
	               	 }
	                    } 
	                
	             });
	        	
	        }
	    	 
	         
	         var categoryParentVal = $("#categoryParentId").val();
	 		var categoryVal = $("#categoryChildId").val();
	 		
	 		if (categoryVal != '') {
	 			$("#categoryId").val(categoryVal);
	 		} else {
	 			$("#categoryId").val(categoryParentVal);
	 		}
	     
	    });
		
		
		
		
		