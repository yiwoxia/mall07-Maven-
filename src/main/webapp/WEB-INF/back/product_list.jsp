<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="com.situ.mall.pojo.Product"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>商品管理</title>
<!-- 调head路径 -->
<%@include file="../common/head.jsp" %>
<style type="text/css">
		.form-group{
		width: 140px;
	}
	.form-group .form-control{
		width: 90px;
	}
	/*使超长的文字变成省略号  只加一个属性即可  ：white-space：nowrap；
	text-align 属性规定元素中的文本的水平对齐方式。
	white-space 属性设置如何处理元素内的空白。
	nowrap文本不会换行，文本会在在同一行上继续，直到遇到 <br> 标签为止。
	overflow 属性规定当内容溢出元素框时发生的事情。
	hidden 内容会被修剪，并且其余内容是不可见的。
	ellipsis 显示省略符号来代表被修剪的文本*/
	td{
		text-align: center;
		 white-space:nowrap;
		 overflow:hidden;
		 text-overflow: ellipsis;
		 
	}
	table{
		 table-layout:fixed;
	}
</style>
<script type="text/javascript">
	/* 用于高级查询分页 */
	function goPage(pageIndex1) {
		$("#pageIndex1").val(pageIndex1);
		$("#a").submit();
	}
	function delProduct(id) {
	       var isDel = confirm("您确认要删除吗？");
	       if (isDel) {
		           //要删除
		          var options = {
				url:"${ctx}/mall/deleteById.action",
				type:"post",
				dateType:"json",
				data:'id='+id,
				success:function(data){
					if(data.status == 0){
						layer.confirm(
	            				'删除成功',
	            				{btn:['关闭']},
	            				function(){
	            					window.location.href = "${ctx}/mall/pageList.action";
	            				}
	            			);
					}else {
						layer.msg("删除失败");
					}
				}
			}
			$.ajax(options)
    }
 };
 
/* 静态 */ 
 function updateStatusOnline(id,status) {
     var isUpd = confirm("您确认要上架或下架吗？");
     if (isUpd) {
	           //要删除
	          var options = {
			url:"${ctx}/mall/updateStatusOnline.action",
			type:"post",
			dateType:"json",
			data:{'id':id ,'status':status},
			/* data:{'id':id ,'status':status}, */
			success:function(data){
				if(data.status == 0){
					layer.confirm(
          				'静态化成功',
          				{btn:['关闭']},
          				function(){
          					window.location.href = "${ctx}/mall/pageList.action";
          				}
          			);
				}else {
					layer.msg("静态化失败");
				}
			}
		}
		$.ajax(options)
}
};
</script>
<script type="text/javascript">  
       var urlPRC="${pageContext.request.contextPath}";  
</script>  
<script type="text/javascript" src="${ctx}/resources/js/product-list-js.js"></script>
</head>
<body>

 <!--  多条件查询开始  -->
		  <form action="${ctx}/mall/seacherByCondition.action" method="post" class="form-inline" id="a" style="margin-left: 90px;" >

				<!-- 用于查找+分页 记录反的页数 -->
					<input type="hidden" name="pageIndex" id="pageIndex" /> 
					<div class="form-group">
						<label for="exampleInputName2">商品名称</label>
					    <input type="text" name="product.name" value="${condition.product.name }" class="form-control" id="exampleInputName2" placeholder="商品名称">
						<button type="submit" class="btn btn-default">搜索</button>
						<button type="reset" class="btn btn-default">重置</button>
				 	</div>
			</form> 		
 <!--  多条件查询结束 -->
 <!-- 查询条件 结束 -->
					<button onclick="javascript:deleAll()"  class="btn btn-default">批量删除</button>
					<button onclick="javascript:updateAllStatus()"  class="btn btn-default">批量上架</button>
					<button onclick="javascript:updateAllStatus()"  class="btn btn-default">批量下架</button>
 <!-- 列表开始  -->
			<form id="delForm" action="" method="post">
            <table class="table table-striped table-bordered table-hover" style="margin-top: 10px;">
			<tr>
			    <td>
			    	<input type="checkbox" onclick="selectAll();" id="selectAlls" /></td>
			    <td>分类</td>
				<td>商品名称</td>
				<td>商品副标题</td>
				<td>商品价格</td>
				<td>库存</td>
				<td>商品图片</td>
				<td>状态</td>
				<td title="上线/下线">上线/下线</td>
				<td>创建时间</td>
				<td>更新时间</td>	
				<td colspan="3">操作</td>
			</tr>
			
			<c:forEach items="${pageBean.list}" var="product">
				<tr>
				   <td>
						<input type="hidden" id="statusId" name="statusIds" value="${product.status}" />
					   <input type="checkbox" name="selectIds" value="${product.id}"></td>
					<td title="${product.category.name }">${product.category.name }</td>
					<td  width="100px" title="${product.name }">${product.name}</td>
					<td title="${product. subtitle}">${product. subtitle}</td>
					<td title="${product.price}">${product.price}</td>
					<td title="${product.stock}">${product.stock}</td>
					<%-- <td><img alt="" src="/pic/${product.mainImage}" width="50" height="50"></td> --%>
					<td>
						<%-- <img alt="无图" id="imgId" src="/pic/${product.mainImage }" width="50px" height="50px" > --%>
						<img alt="无图" id="imgId" src="${product.fullUrl}" width="50px" height="50px" > 
						<%-- <img alt="无图" id="imgId"  src="${product.fullUrl}" width="80" height="60" "> --%>
					</td>
					<td>
						<c:if test="${product.status==1}">
							在售
						</c:if>
						<c:if test="${product.status==2}">
							下架
						</c:if>
					</td>
					<td>${product.createTime}</td>
					<td>${product.updateTime}</td>
					 <td><a href="javascript:void(0)" onclick="updateStatus(${product.id },${product.status });">修改状态</a></td>
					 <td><a href="${ctx}/mall/toUpdateProduct.action?id=${product.id}" method="post">修改</a>
					 <td><a class="glyphicon glyphicon-retweet" href="javascript:updateStatusOnline(${product.id },${product.status});"></a></td>
					<td><a href="javascript:delProduct(${product.id });">删除</a></td>
				
				
					<%-- <td><a class="glyphicon glyphicon-retweet" href="${ctx}/mall/updateStatusOnline.action?id=${product.id }&status=${product.status }"></a></td> --%>
					<%-- <td><a href="javascript:deleProduct('${product.id}')" method="post" >删除</a> 
					</td>   --%>
					<%-- <td><span class="glyphicon glyphicon-retweet" onclick="updateStatus(${product.id },${product.status });"></span></td>
					<td><span class="glyphicon glyphicon-pencil" onclick="update(${product.id})" ></span></td>
					<td><span class="glyphicon glyphicon-trash" onclick="delProduct(${product.id })" ></span></td> --%>
				</tr>
			</c:forEach>
		</table>	      
   </form>	
<!-- 列表结束  -->
	
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
		
</body>
</html>