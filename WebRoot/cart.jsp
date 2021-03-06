<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<meta charset="utf-8">
<title>购物车</title>
<link rel='stylesheet' href='css/cart.css'>
<script src='js/jquery-3.1.1.min.js'></script>
<script src='js/cart.js'></script>
<c:if test="${map != null }">
	<script>
			$(function() {
				$(".top_menu .logout").click(function() {
					$.post("customerServlet","{op:logout}", function(data) {
						location.href = "login.html";
					});
				});
				
				$(".contain").css("display", "none");
				$(".cart_page").css("display", "block");
				$(".pay_page").css("display", "block");
			});
			
			function searchGoods() {
				if ($("#searchName").val() != null && $("#searchName").val() != "")
				window.location.href = "/MyShopping/goodsServlet?searchName=" + $("#searchName").val();
			}
		</script>
</c:if>
</head>
<body>
	<div class="detail_top">
		<div class="top_content">
			<div class="top_menu">
				<ul>
					<c:choose>
						<c:when test="${sessionScope.customer != null }">
							<li><a>${sessionScope.customer.customerName }先生</a>
								<a class="logout">注销</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="login.html">账户登录</a></li>
						</c:otherwise>
					</c:choose>
					<li><a href="register.html">注册</a></li>
					<li><a href="#">向导</a></li>
					<li><a href="#">博客</a></li>
				</ul>
			</div>
			<div class="top_phone">
				<span><a href='ordersServlet?op=list'>我的订单</a></span>
				<span><a href='#'>请联系我们</a></span>
			</div>
		</div>
	</div>
	<div class="top_next">
		<div class="logo_search">
			<div class="logo">
				<img src="image/logo.png">
			</div>
			<div class="cart_title">
				<span>我的购物车</span>
			</div>
			<div class="search_content">
				<div class="search">
					<input type="text" id="searchName">
	                <a class="search_btn" onclick="searchGoods()">搜索</a>
				</div>
			</div>
		</div>
	</div>
	<div class="detail_hr"></div>
	<div class="contain">
		<div class="w">
			<div class="message">
				<ul>
					<li class="txt">购物车空空如也</li>
					<li><a href="indexServlet">去购物></a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="cart_page" hidden>
		<div class="w">
			<div class="cart_header">
				<ul>
					<li><input type="checkbox" class="selectAll"> <span>全选</span>
					</li>
					<li class="product"><span>商品</span></li>
					<li><span>单价</span></li>
					<li><span>数量</span></li>
					<li><span>小计</span></li>
					<li><span>操作</span></li>
				</ul>
			</div>
			<ul>
				<c:forEach items="${map }" var="item">
					<li>
						<div class="goodsItem">
							<input type="hidden" name="cartDetailId"
								value="${item.value.cartDetailId }">
							<ul>
								<li><input type="checkbox" class="selectOne" name="goodsForSelectOne" value="${item.value.cartDetailId}"></li>
								<li class="product">
									<div class="goodsDetail">
										<div class="goodsImage">
											<a href="#"><img src="${item.key.goodsPic }"></a>
										</div>
										<div class="goodsName">
											<div class='goodsTitle'>
												<a href="#"><span>${item.key.goodsName }</span></a>
											</div>
											<div class="goodsDesc">
												<span>${item.key.goodsDesc }</span>
											</div>
										</div>
									</div>
								</li>
								<li><span> <em>￥</em> <span class="goods_price">${item.key.goodsPrice }</span>
								</span></li>
								<li>
									<div class="goods_count">
										<span class='count_img'></span> <span> <input
											type="text" name="count" value='${item.value.goodsCount }'>
										</span> <span class='count_img'></span>
									</div>
								</li>
								<li class='goods_price'><em>￥</em> <span></span></li>
								<li><span><a
										href="cartServlet?op=delete&cartDetailId=${item.value.cartDetailId }"
										style='color:red'>删除</a></span></li>
							</ul>
						</div>
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>
	<div class="pay_page" hidden>
		<div class="w">
			<div class="pay_content">
				<ul>
					<li><input type="checkbox" class="selectAll"> <span>全选</span>
					</li>
					<li class="product"><a>删除选中的商品</a></li>
					<li class="amount">已选择<span>0</span>件商品
					</li>
					<li class="count">总价：<em>¥</em><span>0</span>
					</li>
					<li>
						<div class="add_order">
							<a href="javascript:void(0)"><span>结算</span>
							</a>
						</div>
					</li>
				</ul>
			</div>
		</div>
	</div>
	<div class="addSuccess">
		<span>加入购物车成功</span>
	</div>
</body>
</html>