<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加用户</title>
<%@include file="../common/head.jsp" %>
</head>
<body>
	  <div class="row">
		        <div class="col-md-2">
		        </div>
		        <div class="col-md-10">
		           <div class="alert alert-danger" role="alert">请注意不要添加重复的用户！！！</div>
		           <form style="width: 60%" action="${ctx}/user/add.action" method="post">
				   	    id：<input class="form-control" type="text" name="id" id="id"/>
				  	     账户名称：<input class="form-control" type="text" name="username"/>
					       账户密码：<input class="form-control" type="text" name="password"/>
					       	        邮箱:<input id="email" name="email"  class="form-control">
					       	        电话号码:<input id="phone" name="phone"  class="form-control">
					       	      密保问题:<input id="question" name="question"  class="form-control">
					       	       密保答案:<input id="answer" name="answer"  class="form-control">
					       	        账户类型:<select name="role"  class="form-control">
					       	        	<option value="0">管理员</option>
					       	        	<option value="1">普通用户</option>
					       	        </select>
					       	        
       <p><button class="btn btn-primary" type="submit">保存</button></p>
    </form>
		            
		        </div>
		    </div>

</body>
</html>