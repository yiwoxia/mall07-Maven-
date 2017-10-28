<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>订单详情</title>
<%@ include file="common/head.jsp" %>
<link rel="stylesheet" type="text/css" href="${ctx}/resources/front/css/index_style.css">
<link rel="shortcut icon" type="image/x-icon" href="${ctx}/resources/front/img/icon/favicon.ico">
<link rel="stylesheet" type="text/css" href="${ctx}/resources/front/css/order/base_myorder.css">
<link rel="stylesheet" type="text/css" href="${ctx}/resources/front/css/order/member_myorder.css">
<script type="text/javascript" src="${ctx}/resources/thirdlib/layer/layer.js"></script>    
<script type="text/javascript" src="${ctx}/resources/thirdlib/jquery/jquery-1.11.1.js"></script>
</head>
<script type="text/javascript">



function moreAc(orderNo){
	alert("123");
	layer.open({
	  type: 2,
	  title: false,
	  shade: [0],
	  area: ['1040px', '515px'],
	  anim: 2,
	  content: ['${ctx}/orderBack/findOrderItem.action?orderNo='+orderNo, 'yes'], //iframe的url，no代表不显示滚动条
	})
};
</script>
<body>

<div class="center" style=" width: 1200px; margin: 0 auto;">
	<section id="member">
	<div class="member-center clearfix">
		<div class="member-left fl">
			<div class="member-apart clearfix">
				<div class="fl"><a href="#"><img src="img/mem.png"></a></div>
				<div class="fl">
					<p>用户名：</p>
					<p><a href="#">${user.username }</a></p>
					<p>搜悦号：</p>
					<p>389323080</p>
				</div>
			</div>
			<div class="member-lists">
				<dl>
					<dt>我的商城</dt>
					<dd class="cur"><a href="#">我的订单</a></dd>
					<dd><a href="#">我的收藏</a></dd>
					<dd><a href="#">账户安全</a></dd>
					<dd><a href="#">我的评价</a></dd>
					<dd><a href="#">地址管理</a></dd>
				</dl>
				<dl>
					<dt>客户服务</dt>
					<dd><a href="#">退货申请</a></dd>
					<dd><a href="#">退货/退款记录</a></dd>
				</dl>
				<dl>
					<dt>我的消息</dt>
					<dd><a href="#">商城快讯</a></dd>
					<dd><a href="#">帮助中心</a></dd>
				</dl>
			</div>
		</div>
		<div class="member-right fr">
			<div class="member-head">
				<div class="member-heels fl"><h2>我的订单</h2></div>
				<div class="member-backs member-icons fr"><a href="#">搜索</a></div>
				<div class="member-about fr"><input placeholder="商品名称/商品编号/订单编号" type="text"></div>
			</div>
			<div class="member-whole clearfix">
				<ul id="H-table" class="H-table">
					<li class="cur"><a href="#">我的订单</a></li>
					<li><a href="#">待付款<em>(44)</em></a></li>
					<li><a href="#">待发货</a></li>
					<li><a href="#">待收货</a></li>
					<li><a href="#">交易完成</a></li>
					<li><a href="#">订单信息</a></li>
				</ul>
			</div>
			<div class="member-border">
				<div class="member-return H-over">
					<div class="member-cancel clearfix">
						<span class="be1">订单信息</span>
						<span class="be2">收货人</span>
						<span class="be2">订单金额</span>
						<span class="be2">订单时间</span>
						<span class="be2">订单状态</span>
						<span class="be2">订单操作</span>
					</div>
					<div class="member-sheet clearfix">
							<ul>
								<c:forEach items="${list }" var="order">
									<li>
									<div class="member-minute clearfix">
										<span>${order.createTime }</span>
										<span>订单号：<em>${order.orderNo }</em></span>
										<span><a href="#">${order.shipping.receiverProvince }&nbsp;&nbsp;${order.shipping.receiverCity }</a></span>
										<span class="member-custom">客服电话：<em>010-6544-0986</em></span>
									</div>
										<div class="member-circle clearfix">
										<div class="ci1">
											<c:forEach items="${order.orderItems }" var="orderItem">
												<div class="ci7 clearfix">
													<span class="gr1"><a href="#"><img src="${orderItem.fullUrl }" title="" about="" width="60" height="60"></a></span>
													<span class="gr2"><a href="#">${orderItem.productName }</a></span>
													<span class="gr3">X${orderItem.quantity }</span>
												</div>
											</c:forEach>
										</div>
										<div class="ci2">${order.shipping.receiverName }</div>
										<div class="ci3"><b>${order.payment }</b>
											<c:if test="${order.paymentType==1 }">
												<p>在线支付</p>
											</c:if>
											<c:if test="${order.paymentType==2 }">
												<p>货到付款</p>
											</c:if>
										<p class="iphone">手机订单</p></div>
										<div class="ci4"><p>2015-09-22</p></div>
										<div class="ci5">
											<c:if test="${order.status==10 }">
												<p>未支付</p>
											</c:if>
											 <%-- <input type="button" onclick="moreAc('${order.orderNo}')" >详细信息</input></div> --%>
											<p><a href="javascript:moreAc('${order.orderNo}')">详细信息</a></p></div>
											 <%-- <p><a onclick="moreAc(${order.orderNo})">详细信息</a></p></div>  --%>
											<%-- <p><a href="${ctx}/orderBack/findOrderItem.action?orderNo=${order.orderNo}">详细信息</a></p></div> --%>
										<div class="ci5 ci8"><p><a href="#" class="member-touch">提醒发货</a> </p> <p><a href="#">取消订单</a> </p></div>
									</div>
									
								</li>
							</c:forEach>
						</ul>
					</div>
				</div>

				<div class="clearfix" style="padding:30px 20px;">
					<div class="fr pc-search-g pc-search-gs">
						<a style="display:none" class="fl " href="#">上一页</a>
						<a href="#" class="current">1</a>
						<a href="javascript:;">2</a>
						<a href="javascript:;">3</a>
						<a href="javascript:;">4</a>
						<a href="javascript:;">5</a>
						<a href="javascript:;">6</a>
						<a href="javascript:;">7</a>
						<span class="pc-search-di">…</span>
						<a href="javascript:;">1088</a>
						<a title="使用方向键右键也可翻到下一页哦！" class="" href="javascript:;">下一页</a>
					</div>
				</div>

			</div>
		</div>
		<div class="clearfix"></div>
	</div>
</section>
</div>
<div style="height:100px"></div>
<div class="sp">
			<div class="sp1">
				<p style="color: rgb(51,51,51);">品质保障</p>
				<p style="font-size: 12px; color: #808080;margin-top: 5px;">品质护航 购物无忧</p>
			</div>
			<div class="sp2">
				<p style="color: rgb(51,51,51);">品质保障</p>
				<p style="font-size: 12px; color: #808080;margin-top: 5px;">品质护航 购物无忧</p>
			</div>
			<div class="sp3">
				<p style="color: rgb(51,51,51);">品质保障</p>
				<p style="font-size: 12px; color: #808080;margin-top: 5px;">品质护航 购物无忧</p>
			</div>
			<div class="sp4">
				<p style="color: rgb(51,51,51);">品质保障</p>
				<p style="font-size: 12px; color: #808080;margin-top: 5px;">品质护航 购物无忧</p>
			</div>
			<div class="clearfix"></div>
		</div>
		<div class="more">
			<div class="mb1">
				<ul>
					<li>
						购物指南
					</li>
					<li>
						<a href="">
							&nbsp;&nbsp;免费注册
						</a>
					</li>
					<li>
						<a href="">
							&nbsp;&nbsp;开通支付宝
						</a>
					</li>
					<li>
						<a href="">
							&nbsp;&nbsp;支付宝充值
						</a>
					</li>
				</ul>
			</div>
			<div class="mb2">
				<ul>
					<li>
						品质保障
					</li>
					<li>
						<a href="">
							&nbsp;&nbsp;发票保障
						</a>
					</li>
					<li>
						<a href="">
							&nbsp;&nbsp;售后规则
						</a>
					</li>
					<li>
						<a href="">
							&nbsp;&nbsp;缺货赔付
						</a>
					</li>
				</ul>
			</div>
			<div class="mb3">
				<ul>
					<li>
						支付方式
					</li>
					<li>
						<a href="">
							&nbsp;&nbsp;快捷支付
						</a>
					</li>
					<li>
						<a href="">
							&nbsp;&nbsp;信用卡
						</a>
					</li>
					<li>
						<a href="">
							&nbsp;&nbsp;货到付款
						</a>
					</li>
				</ul>
			</div>
			<div class="mb4">
				<ul>
					<li>
						商家服务
					</li>
					<li>
						<a href="">
							&nbsp;&nbsp;商家入驻
						</a>
					</li>
					<li>
						<a href="">
							&nbsp;&nbsp;商家中心
						</a>
					</li>
					<li>
						<a href="">
							&nbsp;&nbsp;运营服务
						</a>
					</li>
				</ul>
			</div>
			<div class="mb5">
				<ul>
					<li>
						手机靓淘
					</li>
					<li>
						<img src="${ctx }/resources/front/img/98.png"/>
					</li>
				</ul>
			</div>
			<div class="clearfix"></div>
		</div>
		<div class="link">
			<ul>
				<li>
					<a href="">
						关于靓淘
					</a>
				</li>
				<li>
					<a href="">
						帮助中心
					</a>
				</li>
				<li>
					<a href="">
						开放平台
					</a>
				</li>
				<li>
					<a href="">
						诚聘精英
					</a>
				</li>
				<li>
					<a href="">
						联系我们
					</a>
				</li>
				<li>
					<a href="">
						网站合作
					</a>
				</li>
				<li>
					<a href="">
						法律声明及隐私政策
					</a>
				</li>
				<li>
					<a href="">
						知识产权
					</a>
				</li>
				<li>
					<a href="">
						廉政举报
					</a>
				</li>
				<li>
					<a href="">
						规则意见征集
					</a>
				</li>
			</ul>
		</div>
		<div class="copyright">
			COPYRIGHT 2010-2017 北京创锐文化传媒有限公司 JUMEI.COM 保留一切权利. 客服热线：400-123-888888<br /> 
			京公网安备 110101020011226|京ICP证111033号|食品流通许可证 SP1101051110165515（1-1）|营业执照
		</div>

</body>


</html>