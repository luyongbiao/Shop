<%@ page language="java" import="java.util.*"
	import="org.bqj.shopping.entity.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<title>商城</title>
<link rel='stylesheet' href='css/good.css'>
<script src="js/jquery-3.1.1.min.js"></script>
<script src="js/goods.js"></script>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
</head>
<body>
	<div class="index_top">
		<div class="top_content">
			<div class="top_menu">
				<ul>
					<c:choose>
						<c:when test="${sessionScope.customer != null }">
							<li><a>${sessionScope.customer.customerName }先生</a> <a
								class="logout">注销</a></li>
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
				<span><a href='#'>我的订单</a></span> <span><a
					href="cartServlet?op=list">购物车</a></span> <span><a href='#'>请联系我们</a></span>
			</div>
		</div>
	</div>
	<div class="top_next">
		<div class="logo_search">
			<div class="logo">
				<img src="image/logo.png">
			</div>
			<div class="search_content">
				<div class="search">
					<input type="text" id="searchName"> <a class="search_btn"
						onclick="searchGoods()">搜索</a>
				</div>
			</div>
			<div class="cart">
				<a href="cartServlet?op=list"> <img src="image/cart.jpg">
					<span style="color:#000">我的购物车</span>
				</a>
			</div>
		</div>
	</div>
	<div class="menu_block">
		<div class="category_menu">
			<ul>
				<li><a href="/MyShopping/goodsCategoryServlet?categoryId=1">水果蔬菜</a></li>
				<li><a href="/MyShopping/goodsCategoryServlet?categoryId=2">饼干零食</a></li>
				<li><a href="/MyShopping/goodsCategoryServlet?categoryId=3">新鲜肉类</a></li>
				<li><a href="/MyShopping/goodsCategoryServlet?categoryId=4">图书音像</a></li>
				<li><a href="/MyShopping/goodsCategoryServlet?categoryId=5">纸巾洗漱</a></li>
				<li><a href="/MyShopping/goodsCategoryServlet?categoryId=6">沐浴用品</a></li>
				<li><a href="/MyShopping/goodsCategoryServlet?categoryId=7">清洁用品</a></li>
				<li><a href="#">电子电器</a></li>
				<li><a href="#">清洁用品</a></li>
				<li><a href="#">电子电器</a></li>
			</ul>
		</div>
	</div>
	<div class="good_content">
		<div class="w">
			<div class='goods_walls'>
				<ul>
					<li>
						<div class='first_walls'>
							<ul>
								<li><c:forEach items="${goods}" var="goods">
										<div class="apple">
											<input type="hidden" name="goodsId" value="${goods.goodsId }" />
											<div class='apple_img'>
												<a> <img src="${goods.goodsPic}">
													<div class="price">
														<strong> <em>￥</em> <i>${goods.goodsPrice}</i>
														</strong>
													</div>
													<p>${goods.goodsName}${goods.goodsDesc}</p>
												</a>
											</div>
										</div>
									</c:forEach></li>
							</ul>
						</div>
					</li>
				</ul>
				<div class="pages_walls">
					<div class="goods_pages">
						<ul>
							<li><a> <span>首页</span>
							</a></li>
							<li class="a2"><a> <span>上一页</span>
							</a></li>
							<li class="a3"><a> <span>下一页</span>
							</a></li>
							<li><a> <span>尾页</span>
							</a></li>
						</ul>
						<div class="pageCount">
							当前第<span>${pageBean.currentPage }</span>页&nbsp;&nbsp;&nbsp;&nbsp;
							共<span>${pageBean.pageCount }</span>页
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</html>
