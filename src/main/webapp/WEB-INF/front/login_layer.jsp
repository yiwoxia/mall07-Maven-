<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="../common/head.jsp" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>靓淘网-登录</title>
		<link rel="stylesheet" href="${ctx}/resources/front/css/login_style.css" />
		<script type="text/javascript">
			function submitForm() {
				var options = {
						url:"${ctx}/user/login.shtml",
						type:"post",
						dataType:"json",
						data:$("#login_form").serialize(),
						success:function(data){
							if(data.status == 0) {
								layer.msg(data.msg);
								//当你在iframe页面关闭自身时
								var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
								setTimeout(function(){
									parent.layer.close(index); //再执行关闭  
									window.parent.location.reload();//刷新父页面
								},1000);
							} else {
								layer.msg(data.msg);
							} 
						}
				};
				$.ajax(options);
			}
		</script>
	</head>

	<body>
				<div class="login">
					<form id="login_form">
						<ul>
							<li class="login_title_1">
								<a href="">密码登录</a>

							</li>
							<li class="login_title_2">
								<a href="">扫码登录</a>
							</li>
							<li>
								<input class="login_user" type="text" name="name" placeholder="会员名/邮箱/手机号" />
								<input class="login_password" type="password" name="password" placeholder="密码" />
								<input class="login_btn" type="button" onclick="submitForm()" value="登录" />
							</li>
						</ul>
					</form>
				</div>
	</body>

</html>