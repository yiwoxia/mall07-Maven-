<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath }" ></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加分类</title>
<link rel="stylesheet" type="text/css" href="${ctx}/resources/thrLib/bootstrap/css/bootstrap.css" />
<script type="text/javascript" src="${ctx}/resources/thrLib/jquery/jquery-1.11.1.js"></script>
</head>
<body>
	<!-- head begin -->
	<!-- head end -->
	<div class="container" >
		<div class="row">
			<!-- 左边导航栏开始  -->
			<!-- 左边导航栏结束  -->
			<!-- 右边栏开始  -->
			<div class="col-md-10">
				<!-- 添加总分类 开始 -->
				<form style="margin-top: 10px;" id="form-add" action="${prc }/category/addCategory.action" method="post"  >
					
					<div class="form-group">
					   <label for="exampleInputEmail1">分类名称</label>
					   <input type="text" name="name" class="form-control" id="exampleInputEmail1" placeholder="商品名称">
				  	</div>
				  	<input type="hidden" name="parentId" value="0" />
				  	<div class="form-group">
					  <label for="exampleInputPassword1">状态</label>
						<select class="form-control"  name="status" >
							<option value="" >请选择</option>
							<option value="1" >正常</option>								
							<option value="2" >废弃</option>								
						</select>
				 	</div>
				  	<button type="submit" class="btn btn-primary">Submit</button>
				</form>
				<hr/>
				<!-- 添加总分类 结束 -->
				<!-- 添加子类 开始 -->
				<form style="margin-top: 10px;" id="form-add" action="${prc }/category/addCategory.action" method="post"  >
				
					<div class="form-group">
					  <label for="exampleInputPassword1">分类</label>
						<select class="form-control" id="categorySelect"  name="parentId" >
							<option value="" >请选择</option>
							<c:forEach items="${cplist }" var="category" >
								<option value="${category.id }" >${category.name }</option>
							</c:forEach>						
						</select>
				 	</div>
				  	<div class="form-group">
					   <label for="exampleInputEmail1">分类名称</label>
					   <input type="text" name="name" class="form-control" id="exampleInputEmail1" placeholder="商品名称">
				  	</div>
				  	<input type="hidden" name="parentId" value="0" />
				  	<div class="form-group">
					  <label for="exampleInputPassword1">状态</label>
						<select class="form-control"  name="status" >
							<option value="" >请选择</option>
							<option value="1" >正常</option>								
							<option value="2" >废弃</option>								
						</select>
				 	</div>
				  <button type="submit" class="btn btn-primary">Submit</button>
				  </div>
				  
				</form>
				<!-- 添加子类 结束 -->
			</div>
			<!-- 右边栏结束  -->
		</div>
	
	
	
</body>
</html>