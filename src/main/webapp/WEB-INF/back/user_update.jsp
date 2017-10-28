<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改用户</title>
<%@include file="../common/head.jsp" %>
</head>
<script>
$(function(){
    $("#role option[value='${user.role}']").prop("selected", true);
 });

	
</script>
<body>
	
	
    <div class="row">
		        <div class="col-md-2">
		            <div class="list-group">
		                <a href="${ctx}/user/findUser.action" class="list-group-item">用户管理</a>
		                <a href="${ctx}/user/addUser.action" class="list-group-item">添加用户</a>
		                <a href="" class="list-group-item active">修改用户</a>
		                
		            </div>
		        </div>
		        <div class="col-md-10">
		            <ul class="nav nav-tabs">
		                <li>
		                    <a href="${ctx}/user/findUser.action">用户管理</a>
		                </li>
		                <li>
		                	<a href="${ctx}/user/add.action">添加用户</a>
		                </li>
		                <li class="active">
		                	<a href="">修改用户</a>
		                </li>
		            </ul>
		           <div class="alert alert-danger" role="alert">请注意不要添加重复的用户！！！</div>
		           <form style="width: 60%" action="${ctx}/user/update.action" method="post">
				   	    id：<input class="form-control" type="text" name="id" id="id" value="${user.id }" readonly="readonly"/>
					            账户名称：<input class="form-control" type="text" name="username" value="${user.username }"/>
						账户密码：<input class="form-control" type="text" name="password" value="${user.password }"/>
					       	        邮箱:<input id="email" name="email"  class="form-control" value="${user.email }">
					       	        电话号码:<input id="phone" name="phone"  class="form-control" value="${user.phone }">
					       	        密保问题:<input id="question" name="question"  class="form-control" value="${user.question }">
					       	        密保答案:<input id="answer" name="answer"  class="form-control" value="${user.answer }">
					       	        账户类型:<select id="role" name="role"  class="form-control">
					       	        	<option value="0">管理员</option>
					       	        	<option value="1">普通用户</option>
					       	        </select>
	       	        
      				 <p><button class="btn btn-primary" type="submit">保存</button></p>
   				 </form>
		            
		        </div>
	 </div>
	</div>
</body>
</html>