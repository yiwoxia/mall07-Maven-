<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="Generator" content="EditPlus®">
	<meta name="Author" content="">
	<meta name="Keywords" content="">
	<meta name="Description" content="">
	<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
	<meta name="renderer" content="webkit">
	<title>确认订单</title>
	<%@ include file="common/head.jsp" %>
	<%@ include file="common/logo.jsp" %>
	<link rel="shortcut icon" type="image/x-icon" href="${ctx }/resources/front/img/favicon.ico">
	<link rel="stylesheet" type="text/css" href="${ctx }/resources/front/css/order.css">
	<link rel="stylesheet" type="text/css" href="${ctx }/resources/front/css/car/order_base.css">
	<link rel="stylesheet" type="text/css" href="${ctx}/resources/front/css/car/order_home.css">
	<script type="text/javascript" src="${ctx}/resources/thirdlib/layer/layer.js"></script>   
	<script type="text/javascript">
/* 		 function toAddorder() {
			var isSub = confirm("确定下单？");
			if (isSub) {
				 $("#subForms").submit();
			}
		}
 */		 /* 提交订单 */
		 function toAddorder() {
			 var isSub = confirm("确定下单？"); 
			
			 if (isSub) {
				var payType = $("input[name=selectPaymentType]:checked").val();
				var payType = $("input[name=paymentType]").val($("input[name=selectPaymentType]:checked").val());
				var payType = $("input[name=shippingId]").val($("input[name=selectAddress]:checked").val());
				
				 $("#subForm").submit();
			}
		}

 function add(){
		layer.open({
		type: 2 ,//Page层类型
		 area: ['350px', '600px'],
		 shade: 0.6 ,//遮罩透明度
		maxmin: true, //允许全屏最小化
		 anim: 1, //0-6的动画形式，-1不开启
		 content:"${ctx}/order/add.action"

		});
	}
 
 
	</script>

</head>
<body>


<div class="center" style="background:#fff; width: 1200px; margin: 0 auto;">
	<!--收货地址body部分开始-->
	<div class="border_top_cart">
		<div class="container">
			<div class="checkout-box">
			<form id="subForms" action="${ctx}/order/addOrder.shtml" method="post">
					<div class="checkout-box-bd">
						<!-- 地址状态 0：默认选择；1：新增地址；2：修改地址 -->
						<input type="hidden" name="Checkout[addressState]" id="addrState"   value="0">
						<!-- 收货地址 -->
						
						<div class="xm-box">
							<div class="box-hd ">
								<h2 class="title">收货地址</h2>
								<!---->
							</div>
							<div class="box-bd">
								<div class="clearfix xm-address-list" id="checkoutAddrList">
									<c:forEach items="${shippings}" var="shipping">
										
									<div class="div">
										<label for="address${shipping.id }">
											<dl class="item"  >
												<dt>
													<strong class="itemConsignee">${shipping.receiverName}</strong>
													<span class="itemTag tag">家</span>
												</dt>
												<dd>
													<p class="tel itemTel"></p>
													<p class="itemRegion">${shipping.receiverProvince}&nbsp;&nbsp;${shipping.receiverCity }</p>
													<p class="itemStreet">${shipping.receiverAddress}</p>
													<p class="itemRegion">联系电话：${shipping.receiverPhone}&nbsp;&nbsp;</p>
													<p class="itemStreet">移动电话：${shipping.receiverMobile }</p>
													<p class="itemStreet">邮编${shipping.receiverZip}</p>
													<span class="edit-btn J_editAddr">编辑</span>
												</dd>
													<input id="address${shipping.id }" type="radio" name="selectAddress"  value="${shipping.id }">
											</dl>
										</label>
										</div>
									</c:forEach>
									<div class="item use-new-addr"  id="J_useNewAddr" data-state="off"   onclick="addAddress()"  ">
										<span class="iconfont icon-add"><img src="${ctx}/resources/front/img/add_cart.png" /></span>
										使用新地址
									</div>
								</div>
								<div class="xm-edit-addr-backdrop" id="J_editAddrBackdrop"></div>
							</div>
						</div>
						<!-- 收货地址 END-->								

								
								
								<input type="hidden" name="newAddress[type]" id="newType" value="common">
								<input type="hidden" name="newAddress[consignee]" id="newConsignee">
								<input type="hidden" name="newAddress[province]" id="newProvince">
								<input type="hidden" name="newAddress[city]" id="newCity">
								<input type="hidden" name="newAddress[district]" id="newCounty">
								<input type="hidden" name="newAddress[address]" id="newStreet">
								<input type="hidden" name="newAddress[zipcode]" id="newZipcode">
								<input type="hidden" name="newAddress[tel]" id="newTel">
								<input type="hidden" name="newAddress[tag_name]" id="newTag">
								
								<div class="xm-edit-addr-backdrop" id="J_editAddrBackdrop"></div>
							</div>                </div>
						<!-- 收货地址 END-->
						<div id="checkoutPayment">
								<!-- 支付方式 -->
							<div class="xm-box">
								<div class="box-hd ">
									<h2 class="title">支付方式</h2>
								</div>
								<div class="box-bd">
									<ul id="checkoutPaymentList" class="checkout-option-list clearfix J_optionList">
											<li class="item selected aaa" >
												<label for="paymentTypeOnline">
													<div class="payType">
														<input id="paymentTypeOnline" type="radio" name="selectPaymentType" checked="checked" value="1">
														<p>
															在线支付 <span></span>
														</p>
														</div>
												</label>
											</li>
											<li class="item selected aaa">
												<label for="paymentTypeOffline">
													<div class="payType">
														<input id="paymentTypeOffline" type="radio" name="selectPaymentType"  value="2">
														<p>
															货到付款<span></span>
														</p>
														</div>
												</label>
											</li>
									</ul>
								</div>
								
							</div>
							<!-- 支付方式 END-->
							<div class="xm-box">
								<div class="box-hd ">
									<h2 class="title">配送方式</h2>
								</div>
								<div class="box-bd">
									<ul id="checkoutShipmentList" class="checkout-option-list clearfix J_optionList">
										<li class="item selected">
											<input type="radio" data-price="0" name="Checkout[shipment_id]" checked="checked" value="1">
											<p>
												快递配送（免运费）                                <span></span>
											</p>
										</li>
									</ul>
								</div>
							</div>
							<!-- 配送方式 END-->                    <!-- 配送方式 END-->
						</div>
					
					</div>
					<div class="checkout-box-ft">
						<!-- 商品清单 -->
						<div id="checkoutGoodsList" class="checkout-goods-box">
							<div class="xm-box">
								<div class="box-hd">
									<h2 class="title">确认订单信息</h2>
								</div>
								<div class="box-bd">
									<dl class="checkout-goods-list">
										<dt class="clearfix">
											<span class="col col-1">商品名称</span>
											<span class="col col-2">购买价格</span>
											<span class="col col-3">购买数量</span>
											<span class="col col-4">小计（元）</span>
										</dt>
										
										<c:forEach items="${buyCartVO.items}" var="cartItemVO">
										<dd class="item clearfix">
											<div class="item-row">
												<div class="col col-1">
													<div class="g-pic">
														<img src="${cartItemVO.product.fullUrl}" width="40" height="40" />
													</div>
													<div class="g-info">
														<a href="#" target="_blank">
															${cartItemVO.product.name }
														</a>
													</div>
												</div>

												<div class="col col-2">${cartItemVO.product.price }元</div>
												<div class="col col-3">${cartItemVO.amount }</div>
												<div class="col col-4">${cartItemVO.product.price * cartItemVO.amount }元</div>
											</div>
											<br/>
										</c:forEach>
										</dd>
							
									<div class="checkout-count clearfix">
										<div class="checkout-count-extend xm-add-buy">
											<h3 class="title">会员留言</h2></br>
												<input type="text" />

										</div>
										<!-- checkout-count-extend -->
										<div class="checkout-price">
											<ul>

												<li>
													订单总额：<span>${buyCartVO.totalPrice }元</span>
												</li>
												<li>
													活动优惠：<span>-0元</span>
													
												</li>
												<li>
													优惠券抵扣：<span id="couponDesc">-0元</span>
												</li>
												<li>
													运费：<span id="postageDesc">0元</span>
													<input type="hidden" name="postage" value="12"/>
												</li>
											</ul>
											<p class="checkout-total">应付总额：<span><strong id="totalPrice">${buyCartVO.totalPrice }</strong>元</span></p>
											<input type="hidden" name="payment" value="${buyCartVO.totalPrice }"/>
										</div>
										<!--  -->
									</div>
								</div>
							</div>

							<!--S 加价购 产品选择弹框 -->
							<div class="modal hide modal-choose-pro" id="J_choosePro-664">
								<div class="modal-header">
									<span class="close" data-dismiss='modal'><i class="iconfont">&#xe617;</i></span>
									<h3>选择产品</h3>
									<div class="more">
										<div class="xm-recommend-page clearfix">
											<a class="page-btn-prev   J_carouselPrev iconfont" href="javascript: void(0);">&#xe604;</a><a class="page-btn-next  J_carouselNext iconfont" href="javascript: void(0);">&#xe605;</a>
										</div>
									</div>
								</div>
								<div class="modal-body J_chooseProCarousel">
									<div class="J_carouselWrap modal-choose-pro-list-wrap">
										<ul class="clearfix J_carouselList">
										</ul>
									</div>
								</div>
								<div class="modal-footer">
									<a href="#" class="btn btn-disabled J_chooseProBtn">加入购物车</a>
								</div>
							</div>
							<!--E 加价购 产品选择弹框 -->

							<!--S 保障计划 产品选择弹框 -->


						</div>
						<!-- 商品清单 END -->
						<input type="hidden"  id="couponType" name="Checkout[couponsType]">
						<input type="hidden" id="couponValue" name="Checkout[couponsValue]">
						<div class="checkout-confirm">

							<a href="#" class="btn btn-lineDakeLight btn-back-cart">返回购物车</a>
							<button  onclick="toAddorder()" class="btn btn-primary">立即下单</button> 
							<%-- <a href="${prc }/index.shtml" class="btn btn-primary">立即下单</a> --%>
						
						</div>
					</div>
					</form>
			</div>
						<%-- <form id="subForms" action="${ctx}/order/addOrder.shtml" method="post">
							<input type="text" name="shippingId" value="${shipping.id }" />
							<input type="text" name="payment" value="${buyCart.totalPrice }" />
							<input type="text" name="paymentType" value="1" />
							<input type="text" name="postage" value="0" />
							<input type="text" name="status" value="10" />
						</form> --%>
				
		</div>
		<!-- 禮品卡提示 S-->
		<div class="modal hide lipin-modal" id="lipinTip">
			<div class="modal-header">
				<h2 class="title">温馨提示</h2>
				<p> 为保障您的利益与安全，下单后礼品卡将会被使用，<br>
					且订单信息将不可修改。请确认收货信息：</p>
			</div>
			<div class="modal-body">
				<ul>
					<li><strong>收&nbsp;&nbsp;货&nbsp;&nbsp;人：</strong><span id="lipin-uname"></span></li>
					<li><strong>联系电话：</strong><span id="lipin-uphone"></span></li>
					<li><strong>收货地址：</strong><span id="lipin-uaddr"></span></li>
				</ul>
			</div>
			<div class="modal-footer">
				<span class="btn btn-primary" id="useGiftCard">确认下单</span><span class="btn btn-dakeLight" id="closeGiftCard">返回修改</span>
			</div>
		</div>
		<!--  禮品卡提示 E-->
		<!-- 预售提示 S-->
		<div class="modal hide yushou-modal" id="yushouTip">
			<div class="modal-body">
				<h2>请确认收货地址及发货时间</h2>
				<ul class="list">
					<li>
						<strong>请确认配送地址，提交后不可变更：</strong>
						<p id="yushouAddr"> </p>
						<span class="icon-common icon-1"></span>
					</li>
					<li>
						<strong>支付后发货</strong>
						<p>如您随预售商品一起购买的商品，将与预售商品一起发货</p>
						<span class="icon-common icon-2"></span>
					</li>
					<li>
						<strong>以支付价格为准</strong>
						<p>如预售产品发生调价，已支付订单价格将不受影响。</p>
						<span class="icon-common icon-3"></span>
					</li>
				</ul>
			</div>
			<div class="modal-footer">
				<p id="yushouOk" class="yushou-ok">
					<span class="icon-checkbox"><i class="iconfont">&#xe626;</i></span>
					我已确认收货地址正确，不再变更</p>
				<span class="btn btn-lineDakeLight" data-dismiss="modal">返回修改地址</span>
				<span class="btn btn-primary" id="yushouCheckout">继续下单</span>

			</div>
		</div>
		<!--  预售提示 E-->

		<script id="newAddrTemplate" type="text/x-dot-template">
			<dl class="item selected" data-isnew="true" data-consignee="{{=it.consignee}}" data-tel="{{=it.tel}}" data-province="{{=it.province}}" data-provincename="{{=it.provinceName}}" data-city="{{=it.city}}" data-cityname="{{=it.cityName}}" data-county="{{=it.county}}" data-countyname="{{=it.countyName}}" data-zipcode="{{=it.zipcode}}" data-street="{{=it.street}}" data-tag="{{=it.tag}}">
				<dt>
					<strong class="itemConsignee">{{=it.consignee}}</strong>
					{{? it.tag }}
					<span  class="itemTag tag">{{=it.tag}}</span>
					{{?}}
				</dt>
				<dd>
					<p class="tel itemTel">{{=it.tel}}</p>
					<p  class="itemRegion">{{=it.provinceName}} {{=it.cityName}} {{=it.countyName}}</p>
					<p  class="itemStreet">{{=it.street}} ({{=it.zipcode}})</p>
					<span class="edit-btn J_editAddr">编辑</span>
				</dd>
			</dl>
		</script>

		<!-- 保险弹窗 -->
		<!-- 保险弹窗 -->

	
	</div>
	<!--收货地址body部分结束-->
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
		
		
		
	<div id="addAddress" >
	<form id="subAddrForm" >
	<div class="xm-edit-addr-box" id="J_editAddrBox">
				<div class="bd">
					<div class="item">
						<label>收货人姓名<span>*</span></label>
						<input type="text" name="receiverName" id="Consignee" class="input" placeholder="收货人姓名" maxlength="15" autocomplete='off'>
						<p class="tip-msg tipMsg"></p>
					</div>
					<div class="item">
						<label>联系电话<span>*</span></label>
						<input type="text" name="receiverPhone" class="input" id="Telephone" placeholder="11位手机号" autocomplete='off'>
						<p class="tel-modify-tip" id="telModifyTip"></p>
						<p class="tip-msg tipMsg"></p>
					</div>
					<div class="item">
						<label>移动电话<span>*</span></label>
						<input type="text" name="receiverMobile" class="input" id="Telephone" placeholder="11位手机号" autocomplete='off'>
						<p class="tel-modify-tip" id="telModifyTip"></p>
						<p class="tip-msg tipMsg"></p>
					</div>
					<div class="item">
						<label>地址<span>*</span></label>
						<select name="receiverProvince" onchange="selectCitys(this)" id="province" class="select-1">
							<option>省份/自治区</option>
						</select>
						<select name="receiverCity"  id="city" onchange="selectAreas(this)" class="select-2" >
							<option>城市/地区/自治州</option>
						</select>
						<select name="receiverDistrict"  id="area" class="select-3" >
							<option>区/县</option>
						</select>
						<textarea   name="receiverAddress" class="input-area" id="Street" placeholder="路名或街道地址，门牌号"></textarea>
						<p class="tip-msg tipMsg"></p>
					</div>
					<div class="item">
						<label>邮政编码<span>*</span></label>
						<input type="text" name="receiverZip" id="Zipcode" class="input" placeholder="邮政编码"  autocomplete='off'>
						<p class="zipcode-tip" id="zipcodeTip"></p>
						<p class="tip-msg tipMsg"></p>
					</div>
				</div>
				<div class="ft clearfix">
					<button  type="button" onclick="closeLayer()" class="btn btn-lineDake btn-small " id="J_editAddrCancel">取消</button>
					<button type="button" onclick="subAddress()" class="btn btn-primary btn-small " id="J_editAddrOk">保存</button>
				</div>
			</div>
		</form>
			<!--点击弹出新增/收货地址界面end-->
	<div class="xm-edit-addr-backdrop" id="J_editAddrBackdrop"></div>
</div>
		
		
</body>
<script type="text/javascript">



/* function login1(){
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
	 */
	
	 /* 关闭layer  */
		function closeLayer() {
			layer.close(layer.index);
		}

	 
	 /* 添加新地址  */
		function addAddress() {
			alert("123");
			layer.open({
				  type: 1,
				  title: false,
				  closeBtn: 0,
				  offset: '20px',
				  shadeClose: true,
				  area: ['350px', '465px'],
				  content: $('#addAddress')
				});
		}
		
		/* 添加地址  */
		function subAddress() {
			var options = {
				url : "${ctx}/order/addAddress.shtml",
				type : "post",
				datatype : "json",
				data : $("#subAddrForm").serialize(),
				/* data: document.getElementById("subAddrForm").serialize(), */
				success : function (data) {
					if (data.status == 0) {
					
						layer.msg(data.msg);
						setTimeout(function () {
							parent.layer.closeAll();
							//parent.layer.close(index); //再执行关闭 
							window.parent.location.reload();
						}, 1000)
						
					}else {
							layer.msg(data.msg);
						
					}
				}
			}
			$.ajax(options);
		}

		/* 省市县三级联动  */
		
		$(function() {
	       $.ajax({
	           url:"${ctx}/order/selectProvinces.shtml",
	           dataType:"json",
	           success:function(data,textStatus,ajax){
	        	   //alert(ajax.responseText);
	              //append_template(data, "province");
	              var html = "<option>省份/自治区</option>";
	              for(var i=0;i<data.length;i++){
	                  html +="<option provinceId='"+data[i].id+"'  value='"+data[i].province+"'>"+data[i].province+"</option>";
	              }
	               $("#province").html(html);
	           }
	       });
	   });
	 
	 
function selectCitys(obj) {
    var provinceId = $(obj).find("option:selected").attr("provinceId");
    //清空城市下拉框中的内容，出第一项外
    $("#city option:gt(0)").remove();
    //清空地区下拉框中的内容，出第一项外
    $("#area option:gt(0)").remove();
    $.ajax({
        url:"${ctx}/order/selectCitys.shtml",
        data:"provinceId="+provinceId,
        dataType:"json",
        success:function(data,textStatus,ajax){
     	   //alert(ajax.responseText);
           //append_template(data, "city");
           
           var html = "<option>-请选择-</option>";
           for(var i=0;i<data.length;i++){
               html +="<option cityId='"+data[i].id+"' value='"+data[i].city+"'>"+data[i].city+"</option>";
           }
           $("#city").html(html);
        }
    });
}
	
function selectAreas(obj) {
    var cityId = $(obj).find("option:selected").attr("cityId");
    //清空地区下拉框中的内容，出第一项外
    $("#area option:gt(0)").remove();
    $.ajax({
        url:"${ctx}/order/selectAreas.shtml",
        data:"cityId="+cityId,
        dataType:"json",
        success:function(data,textStatus,ajax){
           //alert(ajax.responseText);
           //append_template(data, "area");
           
           var html = "<option>城市/地区/自治州</option>";
           for(var i=0;i<data.length;i++){
               html +="<option data='"+data[i].id+"' value='"+data[i].district+"'>"+data[i].district+"</option>";
           }
           $("#area").html(html);
        }
    });
}

//封装其通用内容
function append_template(jsonData,target){
    var length = jsonData.length;
    var html = "<option>区/县</option>";
    for(var i=0;i<length;i++){
        html +="<option data='"+data[i].id+"' value='"+data[i].province+"'>"+data[i].province+"</option>";
    }
    $("#"+target).html(html);
};

/* 设置初始选择的radio  */
$(function(){
	$("#checkoutAddrList .item:first").addClass("current").css("background-color", "rgb(223,223,223)");
	$("#checkoutPaymentList div:first").addClass("current").css("background-color", "rgb(223,223,223)");
});
	

/* 选择地址  */
$("#checkoutAddrList .div").click(function() {
	var address ;
	address = $(this).index();
	$("#checkoutAddrList .item").removeClass("current").css("background-color", "white").eq(address).addClass("current").css("background-color", "rgb(223,223,223)");
});


/* 选择支付方式   */
$(".checkout-option-list li").click(function() {
	var  payType;
	payType = $(this).index();
	$(".checkout-option-list div").removeClass("current").css("background-color", "white").eq(payType).addClass("current").css("background-color", "rgb(223,223,223)");
})
</script>
</html>