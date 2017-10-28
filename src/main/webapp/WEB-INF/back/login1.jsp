<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd" >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>商品后台管理</title>
  <c:set var="ctx" value="${pageContext.request.contextPath }" ></c:set>
	<link rel="stylesheet" type="text/css" href="${ctx }/resources/thrLib/bootstrap/css/bootstrap.css" />
	<script type="text/javascript" src="${ctx }/resources/thrLib/jquery/jquery-1.11.1.js"></script>
<style type="text/css">
	.col-sm-10,.form-control{
		width: 100%;
	}
	h1{
		font-family: "宋体";
	}
</style>
<script type="text/javascript">
	/* $(function () {
		$("#clickImg").click(function(){
			$("#changeImg").attr("src", "${ctx }/checkImg?"+Math.random());
		});
	}); */
	
</script>
</head>
<body <%-- style="background-image: url('${ctx }/img/index.jpg');" --%>>
	<div class="container" style="margin-top:150px; width: 500px; ">
		<form class="form-horizontal" action="${ctx }/back/login.action" method="post">
			<h1>欢迎进入商城后台管理系统！</h1>
			
				<div>
					<span style="color: red;" >${error }</span>
				</div>
			
			 <div class="form-group">
			    <div class="col-sm-10">
			      <input type="text" name="username" value="${cookie_userName }" class="form-control" id="userName" id="userName" placeholder="UserName">
			      <span id="info"></span>
			    </div>
			 </div>
			 <div class="form-group">
			    <div class="col-sm-10">
			      <input type="password" name="password" value="${cookie_password }" class="form-control" id="inputPassword3" placeholder="Password">
			    </div>
			  </div>
			   <!-- <div class="form-group" style="width: 100%; margin-left: 1px; margin-bottom: 5px;" >
					<select class="form-control" id="banji_id" name="permission"  >
						<option value="" >角色选择</option>
						<option value="1" >超级管理员</option>
						<option value="2" >普通管理员</option>
					</select>
			  </div> -->
			  <!-- <div class="form-group" style="width: 100%; margin-bottom: 5px;" >
			    <div class="col-sm-10" >
				    <div class="checkbox" >
						<label> 
							<input type="checkbox" name="rememberPassword" value="rememberPassword"> 记住密码
						</label>
					</div>
			    </div>
			  </div> -->
			  <%-- <div class="form-group">
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="checkCode" id="inputEmail3" id="checkCode" placeholder="CheckCode">
			    	<img id="changeImg" alt="图片加载失败" src="${ctx}/checkImg">
			    	<!-- <span style="font-size: 10px;" >看不清，换一张</span> -->
			    	<a style="font-size: 10px; margin-top: 15px;" id="clickImg" >看不清，换一张</a>
			    </div>
			 </div> --%>
			  <div class="form-group" >
			    <div class=" col-sm-10">
			      <button type="submit" class="btn btn-primary" style="width: 470px;" align="left" >Sign in</button>
			    </div>
			  </div>
		</form>
	</div>
</body>
</html>