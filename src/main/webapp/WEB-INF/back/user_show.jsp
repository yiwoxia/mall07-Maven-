<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户管理</title>
<%@include file="../common/head.jsp" %>
<script>
	
	function delUser(id) {
	       var isDel = confirm("您确认要删除吗？");
	       if (isDel) {
	           //要删除
	           location.href = "${ctx}/user/deleteUser.action?id="+ id;
	       }
	    };
	

</script>
</head>

<body>
		<div class="row" >
		        <div class="col-md-10">
		            <div class="alert alert-info" role="alert" style="width:1190px;">删除前请认真核对分类的信息<strong>确保无误</strong></div>
					    
					    <form id="mainForm" action="" method="post" style="width:1190px; ">
						            <table class="table">
						                <thead>
						                    <tr>
						                        <th>id</th>
												<th>账户名称</th>
												<th>账户密码</th>
												<th>邮箱</th>
												<th>手机号码</th>
												<th>密保问题</th>
												<th>密保答案</th>
												<th>账户类型</th>
												<th>创建时间</th>
												<th>修改时间</th>
						                    </tr>
						                </thead>
						                <tbody>
						                    
								<c:forEach items="${pageBean.list}" var="user">
									<tr>
										<td>${user.id}</td>
										<td>${user.username }</td>
										<td>${user.password }</td>
										<td>${user.email}</td>
										<td>${user.phone}</td>
										<td>${user.question}</td>
										<td>${user.answer}</td>
										<td>
										<c:if test="${user.role == 0}">管理员</c:if>
										<c:if test="${user.role == 1}">普通用户</c:if>
										</td>
										<td>
										<fmt:formatDate value="${user.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
										</td>
										<td>
										<fmt:formatDate value="${user.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
										</td>
										<td><a href="javascript:delUser(${user.id });">删除</a></td>
										<td><a href="${ctx }/user/updateUser.action?id=${user.id}">修改</a></td>
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
		                 <a href="${ctx}/user/findUser.action?pageIndex=${pageBean.pageIndex-1}" aria-label="Previous">
		                   <span aria-hidden="true">&laquo;</span>
		                 </a>
		              </li>
		           </c:if>

			   <c:forEach begin="1" end="${pageBean.totalpage}" var="page">
              <c:if test="${pageBean.pageIndex!=page}">
                   <li><a href="${ctx}/user/findUser.action?pageIndex=${page}">${page}</a></li>
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
		                 <a href="${ctx}/user/findUser.action?pageIndex=${pageBean.pageIndex+1}" aria-label="Previous">
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