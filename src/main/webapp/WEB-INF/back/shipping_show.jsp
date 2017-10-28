<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>收货地址管理</title>
<%@include file="../common/head.jsp" %>
<script>
	function delShipping(id) {
	       var isDel = confirm("您确认要删除吗？");
	       if (isDel) {
	           //要删除
	           location.href = "${ctx}/shipping/deleteShipping.action?id="+ id;
	       }
	    };
</script>
<script type="text/javascript">
	var urlPRC="${pageContext.request.contextPath}";
</script>
<script type="text/javascript" src="${ctx}/resources/js/product-list-js.js">
</script>	
</head>
<body>
	
	<div class="row">
		        <div class="col-md-2">
		        </div>
		        <div class="col-md-10">
		            <div class="alert alert-info" role="alert">修改前请仔细检查！！！<strong>确保无误</strong></div>
					    
					    <form id="mainForm" action="" method="post">
						            <table class="table">
						                <thead>
						                    <tr>
						                  <!--   <th><input type="checkbox" onclick="selectAll()" id="selectAlls"/></th> -->
						                        <th>id</th>
												<th>用户id</th>
												<th>收货人姓名</th>
												<th>收货固定电话</th>
												<th>收货移动电话</th>
												<th>省份/城市/县</th>
												<th>详细地址</th>
												<th>邮编</th>
												<th>创建时间</th>
												<th>修改时间</th>
						                    </tr>
						                </thead>
						                <tbody>
						                    
								<c:forEach items="${pageBean.list}" var="shipping">
									<tr>
								<%-- 	<td><input type="checkbox" name="selectIds" value="${category.id }"/></td> --%>
										<td>${shipping.id}</td>
										<td>${shipping.userId }</td>
										<td>${shipping.receiverName }</td>
										<td>${shipping.receiverPhone}</td>
										<td>${shipping.receiverMobile}</td>
										<td>${shipping.receiverProvince}/${shipping.receiverCity}/${shipping.receiverDistrict}</td>
										<td>${shipping.receiverAddress}</td>
										<td>${shipping.receiverZip}</td>
										<td>
										<fmt:formatDate value="${shipping.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
										</td>
										<td>
										<fmt:formatDate value="${shipping.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
										</td>
										<td><a href="javascript:delShipping(${shipping.id });">删除</a></td>
										<td><a href="${ctx }/shipping/updateShipping.action?id=${shipping.id}">修改</a></td>
									</tr>
								</c:forEach>
						                </tbody>
						            </table>
		            
		            </form>
		            
		            <!-- 分页开始 -->
				<nav aria-label="Page navigation" class="pull-right">
				 <ul class="pagination">
			    <c:if test="${pageBean.pageIndex==1}">
		              <li class="disabled">
		                 <a href="javascript:void(0);" aria-label="Previous">
		                   <span aria-hidden="true">&laquo;</span>
		                 </a>
		              </li>
          		 </c:if>
		           <c:if test="${pageBean.pageIndex!=1}">
		              <li>
		                 <a href="${ctx}/shipping/pageLists.action?pageIndex=${pageBean.pageIndex-1}" aria-label="Previous">
		                   <span aria-hidden="true">&laquo;</span>
		                 </a>
		              </li>
		           </c:if>

			   <c:forEach begin="1" end="${pageBean.totalpage}" var="page">
              <c:if test="${pageBean.pageIndex!=page}">
                   <li><a href="${ctx}/shipping/pageLists.action?pageIndex=${page}">${page}</a></li>
              </c:if>
              <!-- 遍历的时候page和pageIndex相等，高亮显示 -->
              <c:if test="${pageBean.pageIndex==page}">
                   <li class="active"><a href="javascript:void(0);">${page}</a></li>
              </c:if>
           </c:forEach>

			  
			   
			 <c:if test="${pageBean.pageIndex == pageBean.totalpage}">
		              <li class="disabled">
		                 <a href="javascript:void(0);" aria-label="Previous">
		                   <span aria-hidden="true">&raquo;</span>
		                 </a>
		              </li>
          		 </c:if>
		           <c:if test="${pageBean.pageIndex!=pageBean.totalpage}">
		              <li>
		                 <a href="${ctx}/shipping/pageLists.action?pageIndex=${pageBean.pageIndex+1}" aria-label="Previous">
		                   <span aria-hidden="true">&raquo;</span>
		                 </a>
		              </li>
		           </c:if>
			 
			 
			 
			  </ul>
				</nav>
				<!-- 分页结束 -->
		        </div>
		    </div>
		</div>
</body>
</html>