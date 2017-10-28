	/* 用于高级查询分页 */
	function goPage(pageIndex) {
		$("#pageIndex").val(pageIndex);
		$("#a").submit();
	}
	/* 删除商品  */
	function deleProduct(id){
		var isDel = confirm("您确认要删除吗？")
		if(isDel){
			location.href=urlPRC+"/mall/deleteById.action?id=" + id;
		}
	}
	/* 更改商品状态  */
	function updateStatus(id, status) {
		var isUpdate = confirm("确定修改？");
		if (isUpdate) {
			location.href=urlPRC+"/mall/updateStatus.action?id=" + id + "&status=" + status;
		}
	}

	/* 批量删除  */
	
	function deleAll(){
		   var isDel = confirm("您确认要删除吗？");
		     if(isDel){
		    	 //要删除
		    	$("#delForm").attr("action",urlPRC+"/mall/delAll.action");
		    	 //提交
		    	$("#delForm").submit();
		     }
		
		} 
	/* 全选CheckBox */
	function selectAll() {
		$("input[name=selectIds]").prop("checked", $("#selectAlls").is(":checked"))
	}
	/* 批量修改 */
	function updateAllStatus() {
		var isUpdate = confirm("确定修改？");
		if (isUpdate) {
		
			//var statusIds = $("#statusId").val();
			$("#delForm").attr("action", urlPRC + "/product/updateAllStatus.action");
			$("#delForm").submit();
		}
	}
	