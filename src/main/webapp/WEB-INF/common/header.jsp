<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:set var="ctx" value="${pageContext.request.contextPath }" ></c:set>
	<link rel="stylesheet" type="text/css" href="${ctx}/resources/thrLib/bootstrap/css/bootstrap.css" />
	<script type="text/javascript" src="${ctx}/resources/thrLib/jquery/jquery-1.11.1.js"></script>

	<!-- head begin -->
		<nav class="navbar navbar-default">
		  <div class="container">
		    <!-- Brand and toggle get grouped for better mobile display -->
		    <div class="navbar-header">
		      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
		        <span class="sr-only">Toggle navigation</span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		      </button>
		      <a class="navbar-brand" href="#">网站后台管理系统</a>
		    </div>
		
		    <!-- Collect the nav links, forms, and other content for toggling -->
		    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		      <ul class="nav navbar-nav">
		        <li class="active"><a href="${ctx }/mall/pageList.action">商品管理 <span class="sr-only">(current)</span></a></li>
		        <li><a href="${ctx }/category/pageList.action">分类管理</a></li>
		        <li><a href="${ctx }/banner/pageList.action"> <span class="glyphicon glyphicon-tags" aria-hidden="true"></span>广告图管理</a></li>
		        <li><a href="${ctx}/user/findUser.action"> <span class="glyphicon glyphicon-tags" aria-hidden="true"></span> 用户管理 </a></li>
		        <li><a href="${ctx }/shipping/pageLists.action">收货地址管理 </a></li>
		        <li class="active"><a href="${ctx}/orderBack/findBackOrder.action"> <span class="glyphicon glyphicon-tags" aria-hidden="true"></span> 订单管理 </a></li>
		       
		      </ul>
		      <ul class="nav navbar-nav navbar-right">
		       
		        <li><a href="#">当前在线<span style="color: red;">${count }</span>人</a></li>
		        <li><a href="${ctx }/loginOut/loginOut.action">退出</a></li>
		      </ul>
		    </div><!-- /.navbar-collapse -->
		  </div><!-- /.container-fluid -->
		</nav>
	<!-- head end -->