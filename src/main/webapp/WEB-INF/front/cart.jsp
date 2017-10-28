<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="../common/head.jsp" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>靓淘网_购物车</title>
		<link rel="stylesheet" href="${ctx}/resources/front/css/cart_style.css" />
		<link rel="stylesheet" href="${ctx}/resources/front/css/login_layer_style.css" />
		<script type="text/javascript" src="${ctx }/resources/front/js/jquery.js"></script>
		<script type="text/javascript">
		function submite(productId) {
			var num = $("#num").val();
			num --;
			if(num == 0){
				delCart(productId);
				return
			}
			$("#num").val(num)
			window.location.href="${ctx}/cart/addCart.shtml?productId="+productId+"&amount=-1";
		}
		function add(productId){
			var num = $("#num").val();
			if(num == "${product.stock}"){
				num = "${product.stock}";
				alert("只能购买"+num+"件")
				return;
			}else{
				num++;
			}
			$("#num").val(num)
			window.location.href="${ctx}/cart/addCart.shtml?productId="+productId+"&amount=1";
		}
		function delCart(productId) {
			var isDel = confirm("确定要删除？");
			if (isDel) {
				window.location.href="${ctx}/cart/delCart.shtml?productId="+productId;
			}
		}

		</script>
		
<style type="text/css">
	.logins{
		width:365px;
		height:100px;
		display:none;
		margin: 0 auto;
	}
</style>
		
	</head>

	<body>
	
		<!-----------------------1.top-------------------->
		<jsp:include page="../front/common/head.jsp" />
		
		<div class="logo_center">
			<div class="left">
				<img class="logo_img"src="${ctx}/resources/front/img/LOGO.png" />
				<span class="car_text"><a href="${ctx }/index.shtml" method="post">购物车</a></span>
			</div>
			<div class="right">
				<input class="car_input" type="text" />
				<input class="car_search" type="button" value="搜索" />
			</div>
		</div>
		<div class="title">
			<div class="title_top">
				<ul>
					<li>
						<a href="">全部商品</a>
					</li>
					<li>
						<a href="">降价商品</a>
					</li>
					<li>
						<a href="">库存紧张</a>
					</li>
				</ul>
				<p style="margin:0;padding-right: 10px; float: right;line-height: 40px;">配送至：<span style="border: 1px solid rgb(51,51,51);">山东省 青岛市 市南区 <img src="${ctx}/resources/front/img/narrow.png"/></span></p>
			</div>
			<div class="title_center">
				<ul style="color: #666666;margin-top: 10px;margin-bottom: 10px;">
					<li style="margin-left: 16px;margin-right: 8px;">
						<input type="checkbox" />
					</li>
					<li style="margin-left: 8px;margin-right: 38px;">全选</li>
					<li style="margin-left: 38px;margin-right: 168px;">商品</li>
					<li style="margin-left: 138px;margin-right: 58px;">单价</li>
					<li style="margin-left: 58px;margin-right: 58px;">数量</li>
					<li style="margin-left: 58px;margin-right: 58px;">小计</li>
					<li style="margin-left: 58px;margin-right: 36px;">操作</li>
				</ul>
			</div>
			<div class="title_bottom">
			<input type="checkbox" style="color: #666666;margin: 23px 11px 10px 22px;" />
			<img src="${ctx}/resources/front/img/156.png" style="margin: 0px 142px 0px 11px; " />
			<img src="${ctx}/resources/front/img/157.png" style="margin-left: 142px; " />
		</div>
		</div>

		<c:forEach items="${buyCartVO.items}" var="cartItemVO">
			<div class="car_1">
				<div class="car_1_top">
					<img src="${ctx}/resources/front/img/158.png" />
					<p class="car_1_top_p">
						<span class="span1">
							活动商品购满¥105.00 , 即可加价换购商品1件&gt;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</span>
						<span class="span2">
							&nbsp;查看换购品
						</span>
						<span class="span3">
							&nbsp;&nbsp;去凑单&gt;
						</span>
					</p>
				</div>
				<div class="car_2_bottom">
					<div class="car_con_1">
						<input type="checkbox" />
					</div>
					<div class="car_con_2" >
						<img src="${cartItemVO.product.fullUrl}" style="width:95px; height: 85px; "/>
					</div> 
					<div class="car_con_3">
						<p class="p_title">${cartItemVO.product.name}</p>
						<img src="${ctx}/resources/front/img/160.png" />
						<p class="p_seven">&nbsp;支持7天无理由退货</p>
						<img src="${ctx}/resources/front/img/161.png" />
						<p class="p_select">&nbsp;选包装</p>
					</div>
					<ul class="car_ul">
						<li class="price">
							<span style="color: #CCCCCC; margin-bottom: 15px;line-height: 20px;">
								<del>
									¥ 1699.00<br />
								</del>
							</span>
							<span style="color: #666666;">
								¥ ${cartItemVO.product.price}
							</span>
						</li>
						<li class="num_select">
							<input class="car_ul_btn1" type="button" onclick="submite(${cartItemVO.product.id})" value="-" />
							<input class="car_ul_text" type="text" placeholder="1" id="num" value="${cartItemVO.amount}" />
							<input class="car_ul_btn2" type="button" onclick="add(${cartItemVO.product.id})" value="+" />
						</li>
						<li class="money">
							<span style="color: #F41443;">
								¥ ${cartItemVO.product.price*cartItemVO.amount}
							</span>
						</li>
						<li class="delete">
							<img onclick="delCart(${cartItemVO.product.id})" src="${ctx}/resources/front/img/166.png" />
						</li>
					</ul>
				</div>
				<div class="clearfix"></div>
			</div>
		</c:forEach>
		
		<div class="blank">
			
		</div>
		<div class="total">
				<ul style="color: #666666;margin-top: 10px;margin-bottom: 10px;">
					<li style="margin-left: 16px;margin-right: 8px;">
						<input type="checkbox" />
					</li>
					<li style="margin-left: 8px;margin-right: 265px;">全选</li>
					<li style="margin-left: 265px;margin-right: 18px;">总金额（已免运费）：<span style="color: #F41443;">¥${buyCartVO.totalPrice}</span></li>
					 <li class="total_right"><a  href="javascript:login1()"   target="_blank">立即结算</a></li> 
					<%-- <li class="total_right"><a href="${ctx}/order/preparedorede.shtml">立即结算</a></li> --%>
				</ul>
			</div>
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
						<img src="${ctx}/resources/front/img/98.png"/>
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
<div class="logins" id="login">
			<form id="login_form">
				<ul>
					<li class="login_title_1">
						<a href="">密码登录</a>

					</li>
					<li class="login_title_2">
						<a href="">扫码登录</a>
					</li>
					<li>
						<input class="login_user" type="text" name="username" placeholder="会员名/邮箱/手机号" />
						<input class="login_password" type="password" name="password" placeholder="密码" />
						<input class="login_btn" type="button" onclick="submitForm()" value="登录" />
					</li>
				</ul>
			</form>
</div>

<script type="text/javascript">

function login(){
	layer.open({
		type:2,//(iframe层)
		title:'用户登录',
		area:['365px','100px'],
		offset:'300px',//只定义top坐标，水平保持居中
		content:"${ctx}/order/preparedorede.shtml"
	});
}


function login1(){
	layer.open({
		type:1,//（iframe层）
		title:'用户登录',
		area: ['400px', '350px'],
		offset: '200px',//只定义top坐标，水平保持居中
		content:$('#login')
	});
}
function submitForm() {
	var options = {
			url:"${ctx}/login/log.shtml",
			type:"post",
			dataType:"json",
			data:$("#login_form").serialize(),
			success:function(data){
				if(data.status == 0) {
					parent.layer.msg(data.msg);
					//当你在iframe页面关闭自身时
					var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
					setTimeout(function(){
						parent.layer.close(index); //再执行关闭  
						window.parent.location.href ="${ctx}/order/preparedorede.shtml";//刷新父页面
					},1000);
				} else {
					layer.msg(data.msg);
				} 
			}
	};
	$.ajax(options);
}
	
	
</script>
</html>