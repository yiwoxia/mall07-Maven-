<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>订单详情</title>
<%@include file="../common/head.jsp" %>
</head>
<body>
<table class="table">
				<tr>
					<th>id</th>
					<th>用户id</th>
					<th>订单号</th>
					<th>商品id</th>
					<th>商品名称</th>
					<th>商品图片</th>
					<th>商品单价</th>
					<th>商品数量</th>
					<th>商品总价</th>
					<th>创建时间</th>
					<th>修改时间</th>
              </tr>
              
			<c:forEach items="${list}" var="orderItem">
				<tr>
					<td>${orderItem.id}</td>
					<td>${orderItem.userId }</td>
					<td>${orderItem.orderNo }</td>
					<td>${orderItem.productId}</td>
					<td>${orderItem.productName}</td>
					<td>
						<img alt="" src="${orderItem.fullUrl}" width="100" height="100">
					</td>
					<td>${orderItem.currentUnitPrice}</td>
					<td>${orderItem.quantity}</td>
					<td>${orderItem.totalPrice}</td>
					<td>
					<fmt:formatDate value="${orderItem.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
					</td>
					<td>
					<fmt:formatDate value="${orderItem.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
					</td>
				</tr>
			</c:forEach>
</table>
</body>
</html>