<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>商品详情</title>
    <link rel='stylesheet' href='css/goodsDetail.css'>
    <script src="js/jquery-3.1.1.min.js"></script>
    <script src="js/goodsDetail.js"></script>
</head>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
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
                <span><a href='orders.html'>我的订单</a></span>
                <span><a href="cartServlet?op=list">购物车</a></span>
                <span><a href='#'>请联系我们</a></span>
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
                    <input type="text" id="searchName">
	                <a class="search_btn" onclick="searchGoods()">搜索</a>
                </div>
           </div>
           <div class="cart">
                <a href="cartServlet?op=list" style="color:#000">
                    <img src="image/cart.jpg">
                    <span>我的购物车</span>
                </a>
           </div>
        </div>
    </div>
    <div class="detail_hr"></div>
    <div class="goods_page">
        <div class="w">
            <div class="goods_picture">
                <img src="${goods.goodsPic }">
            </div>
            <div class="goods_content">
            	<input type="hidden" name="goodsId" value="${goods.goodsId }">
                <div class="goods_detail">
                    <span>${goods.goodsName }</span>
                    <span>${goods.goodsDesc }</span>
                </div>
                <div class="goods_price">
                    <span>价格</span>
                    <div class="price">
                        <em>￥</em>
                        <span>${goods.goodsPrice }</span>
                    </div>
                </div>
                <div class="goods_count">
                    <span class='count_img'></span>
                    <span>
                        <input type="text" name="count" value='1'>
                    </span>
                    <span class='count_img'></span>
                    共${goods.goodsStock }件
                </div>
                 <div class="goods_cart">
                      <div class="add_cart">
                        <a>
                            <span>加入购物车</span>
                        </a>
                     </div>
                     <div class="add_order">
                        <a>
                            <span>立即购买</span>
                         </a>
                     </div>
                 </div>
            </div>
        </div>
    </div>
    <div class="addSuccess">
    	<span>加入购物车成功</span>
    </div>
</body>
</html>