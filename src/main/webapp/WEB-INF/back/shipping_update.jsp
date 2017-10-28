<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>地址修改</title>
<%@include file="../common/head.jsp" %>

</head>
<body>
	<!-- 导航条  -->
	<jsp:include page="../common/header.jsp" />
	
	<div class="row">
		        <div class="col-md-2">
		            <div class="list-group">
		                <a href="${ctx}/shipping/pageList.action" class="list-group-item">收货地址管理</a>
		                <a href="${ctx}/shipping/addShipping.action" class="list-group-item active">添加地址</a>
		                
		            </div>
		        </div>
		        <div class="col-md-10">
		            <ul class="nav nav-tabs">
		                <li>
		                    <a href="${ctx}/shipping/pageList.action">收货地址管理</a>
		                </li>
		                <li class="active">
		                	<a href="${ctx}/shipping/addShipping.action">添加收货地址</a>
		                </li>
		            </ul>
				     <div style="width:60%; margin-top:20px;">
		            <div class="alert alert-danger" role="alert">添加前请仔细检查！！！</div>
						 <form action="${ctx}/shipping/add.action" method="post">
						 
						   	    用户id：<input class="form-control" type="text" name="userId" id="userId"/>
						  	     收货姓名：<input class="form-control" type="text" name="receiverName"/>
							      收货固定电话：<input class="form-control" type="text" name="receiverPhone"/>
							      收货移动电话：<input class="form-control" type="text" name="receiverMobile"/>
					       	       省份:<input id="status" name="receiverProvince"  class="form-control">
							      城市：<input class="form-control" type="text" name="receiverCity"/>
							      区/县：<input class="form-control" type="text" name="receiverDistrict"/>
							      详细地址：<input class="form-control" type="text" name="receiverAddress"/>
							      邮编：<input class="form-control" type="text" name="receiverZip"/>
						       <p><button class="btn btn-primary" type="submit">保存</button></p>
					    </form>
					</div>
		            
		            
		        </div>
		    </div>
	
	
</body>
</html>