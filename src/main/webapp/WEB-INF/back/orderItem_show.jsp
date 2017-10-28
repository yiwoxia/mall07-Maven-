<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<%@include file="../common/head.jsp" %>
<script type="text/javascript" src="${ctx}/resources/thirdlib/layer/layer.js"></script>    
</head>

<script>
function moreAc(orderNo){
	layer.open({
	  type: 2,
	  title: false,
	  shade: [0],
	  area: ['1040px', '515px'],
	  anim: 2,
	  content: ['${ctx}/orderBack/findOrderItem.action?orderNo='+orderNo, 'yes'], //iframe的url，no代表不显示滚动条
	});
}	
function delShipping(id) {
       var isDel = confirm("您确认要删除吗？");
       if (isDel) {
           //要删除
           location.href = "${ctx}/shipping/deleteShipping.action?id="+ id;
       }
    };
</script>	

<body>
	
	<div class="row">
		        <div class="col-md-2">
		        </div>
		        <div class="col-md-10">
		            <ul class="nav nav-tabs">
		                <!-- <li><input  class="btn btn-primary" type="button" onclick="deleteAll()" value="批量删除"/></li> -->
		            </ul>
		            <div class="alert alert-info" role="alert">删除前请认真核对地址的信息<strong>确保无误</strong></div>
					    
					    <form id="mainForm" action="" method="post">
						            <table class="table">
						                <thead>
						                    <tr>
						                  <!--   <th><input type="checkbox" onclick="selectAll()" id="selectAlls"/></th> -->
						                        <th>id</th>
												<th>订单号</th>
												<th>用户id</th>
												<!-- <th>shipping—id</th> -->
												<th>实际付款金额</th>
												<th>支付类型</th>
												<th>运费</th>
												<th>订单状态</th>
												<th>支付时间</th>
												<th>发货时间</th>
												<th>交易完成时间</th>
												<th>交易关闭时间</th>
												<th>创建时间</th>
												<th>修改时间</th>
						                    </tr>
						                </thead>
						                <tbody>
						                    
								<c:forEach items="${pageBean.list}" var="orders">
									<tr>
								<%-- 	<td><input type="checkbox" name="selectIds" value="${category.id }"/></td> --%>
										<td>${orders.id}</td>
										<td>${orders.orderNo }</td>
										<td>${orders.userId }</td>
										<%-- <td>${orders.shippingId}</td> --%>
										<td>${orders.payment}</td>
										<td>${orders.paymentType}</td>
										<td>${orders.postage}</td>
										<td>${orders.status}</td>
										<td>
										<fmt:formatDate value="${orders.paymentTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
										</td>
										<td>
										<fmt:formatDate value="${orders.sendTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
										</td>
										<td>
										<fmt:formatDate value="${orders.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
										</td>
										<td>
										<fmt:formatDate value="${orders.closeTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
										</td>
										<td>
										<fmt:formatDate value="${orders.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
										</td>
										<td>
										<fmt:formatDate value="${orders.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
										</td>
										<td><a href="javascript:delShipping(${orders.id });">删除</a></td>
										<td><a onclick="moreAc(${orders.orderNo})">详细信息</a></td>										
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
		                 <a href="${ctx}/orderBack/findBackOrder.action?pageIndex=${pageBean.pageIndex-1}" aria-label="Previous">
		                   <span aria-hidden="true">&laquo;</span>
		                 </a>
		              </li>
		           </c:if>

			   <c:forEach begin="1" end="${pageBean.totalpage}" var="page">
              <c:if test="${pageBean.pageIndex!=page}">
                   <li><a href="${ctx}/orderBack/findBackOrder.action?pageIndex=${page}">${page}</a></li>
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
		                 <a href="${ctx}/orderBack/findBackOrder.action?pageIndex=${pageBean.pageIndex+1}" aria-label="Previous">
		                   <span aria-hidden="true">&raquo;</span>
		                 </a>
		              </li>
		           </c:if>
			 
			 
			 
			  </ul>
				</nav>
				<!-- 分页结束 -->
		        </div>
		    </div>
	
</body>
</html>