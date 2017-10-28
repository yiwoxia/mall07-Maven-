<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath }" ></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>商品管理</title>
<link rel="stylesheet" type="text/css" href="${ctx}/resources/thrLib/bootstrap/css/bootstrap.css" />
<script type="text/javascript" src="${ctx}/resources/thrLib/jquery/jquery-1.11.1.js"></script>
<style type="text/css">
	.form-group{
		width: 140px;
	}
	.form-group .form-control{
		width: 90px;
	}
</style>
<script type="text/javascript">

	/* 用于高级查询分页 */
	function goPage(pageIndex) {
		$("#pageIndex").val(pageIndex);
		$("#searchForm").submit();
	}
	
	/* 删除商品  */
	function delProduct(id) {
		var isDel = confirm("确定删除？");
		if (isDel) {
			location.href="${ctx }/category/delCategory.action?id=" + id;
		}
	}
	
	/* 更改商品状态  */
	function updateStatus(id, status) {
		var isUpdate = confirm("确定修改？");
		if (isUpdate) {
			location.href="${ctx }/category/updateStatus.action?id=" + id + "&status=" + status;
		}
	}
	
	/* 批量删除  */
	function deleteAll() {
		var isDel = confirm("确定删除？");
		if (isDel) {
		$("#delForm").attr("src", "${ctx }/category/deletAll.action");
		$("#delForm").submit();
		}
	}
	
	/* 全选CheckBox */
	function selectAll() {
		$("input[name=selectIds]").prop("checked", $("#selectAlls").is(":checked"))
	}
	/* 回显 */
	$(function() {
		$("#categorySelect option[value='${condition.category.parentId}']").prop("selected", true);
	});
</script>
</head>
<body>
	<!-- head begin -->
	<!-- head end -->
	<div class="container" >
		<div class="row">
			<!-- 右边栏开始  -->
			<div class="col-md-10">
				<!-- 查询条件 开始 -->
				<form id="searchForm" action="${ctx }/category/pageListByCondition.action" method="post" class="form-inline" style="float: left; margin-top: 10px;margin-bottom: 10px;" >
					<!-- 用于查找+分页 记录反的页数 -->
					<input type="hidden" name="pageIndex" id="pageIndex" />
					<div class="form-group">
					  <label for="exampleInputPassword1">分类</label>
						<select class="form-control" id="categorySelect"  name="category.parentId" >
							<option value="" >请选择</option>
							<c:forEach items="${cplist }" var="category" >
								<option value="${category.id }" >${category.name }</option>
							</c:forEach>						
						</select>
				 	</div>
					<button type="submit" class="btn btn-default">查询</button>
					<button type="reset" class="btn btn-default">重置</button>
				</form>
				<!-- 查询条件 结束 -->
					<button onclick="javascript:deleteAll()"  class="btn btn-default">批量删除</button>
				<!-- 学生列表开始 -->
				<form id="delForm" action="${ctx }/student/deletAll.action" method="post">
					<table class="table table-striped table-bordered table-hover" style="margin-top: 10px;" >
						<tr>
							<td>
								<input type="checkbox" id="selectAlls" onclick="selectAll()" />
							</td>
							<td>类型</td>
							<td>分类编号</td>
							<td>分类名称</td>
							<td>状态</td>
							<td>创建时间</td>
							<td>更新时间</td>
							<td >更改状态</td>
							<td >删除</td>
						</tr>
						<c:forEach items="${pageBean.list }" var="category">
							<tr>
								<td>
								<input type="checkbox" id="selectAlls" name="selectIds" value="${category.id }" />
								</td>
								<td>
									<c:if test="${category.parentId == 0 }">
										父类
									</c:if>
									<c:if test="${category.parentId != 0 }">
										子类
									</c:if>
								</td>
								<td>${category.id }</td>
								<td width="100px" >${category.name }</td>
								<td>
									<c:if test="${category.status == 1 }">
										正常
									</c:if>
									<c:if test="${category.status == 2 }">
										废弃
									</c:if>
								</td>
								<td>${category.createTime }</td>
								<td>${category.updateTime }</td>
								<td><span class="glyphicon glyphicon-retweet" onclick="updateStatus(${category.id },${category.status });"></span></td>
								<td><span class="glyphicon glyphicon-trash"  onclick="delProduct(${category.id });"></span></td>
							</tr>
						</c:forEach>
					</table>
				</form>
				<!-- 学生列表结束 -->
		<!--分页开始  -->
				<div align="center">
					<nav aria-label="Page navigation">
					<ul class="pagination">
						<!-- 上一页 开始-->
						<c:if test="${pageBean.pageIndex==1}">
						  <li class="disabled"><a href="javascript:void(0)" aria-label="Previous">
						      <span aria-hidden="true">&laquo;</span>
							</a>
						  </li>
						</c:if>
		
						<c:if test="${pageBean.pageIndex!=1}">
							<li>
							   <a href="javascript:goPage('${pageBean.pageIndex-1 }');"
								aria-label="Previous">
							      <span aria-hidden="true">&laquo;</span>
							   </a>
							</li>
						</c:if>
					   <!-- 上一页 结束-->
						<c:forEach begin="1" end="${pageBean.totalpage}" var="page">
							<c:if test="${pageBean.pageIndex!=page}">
								
						             <li><a href="javascript:goPage('${page}');">${page}</a></li> 
							</c:if>
					   <!-- 遍历的时候page和pageIndex相等，高亮显示 -->
							<c:if test="${pageBean.pageIndex==page}">
							  
							  <li class="active"><a href="javascript:goPage('${page}');">${page}</a></li>
							</c:if>
						</c:forEach>
						<!-- 下一页开始   -->
						<c:if test="${pageBen.pageIndex==pageBean.totalpage }">
							<li class="disabled"><a href="javascript:void(0)" aria-label="Next">
							 <span aria-hidden="true">&raquo;</span>
							</li>
						</c:if>
						<c:if test="${pageBen.pageIndex!=pageBean.totalpage}">
								 <li>
									<a href="javascript:goPage('${pageBean.pageIndex+1 }');"
										aria-label="previous"> 
								    <span aria-hidden="true">&raquo;</span>
									</a>
								 </li>
						</c:if>
						<!-- 下一页结束   -->
					</ul>
					</nav>
			    	</div>    
			<!-- 分页结束 -->	
			</div>
			<!-- 右边栏结束  -->
		</div>
	</div>
</body>
</html>