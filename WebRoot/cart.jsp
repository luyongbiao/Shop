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
    <c:if test="${map == null }">
		<script>
			$(function() {
				$(".cart_page").css("display", "none");
				$(".pay_page").css("display", "none");
				$(".contain").css("display", "block");
			});
		</script>
	</c:if>
</head>
<body>
    <div class="detail_top">
        <div class="top_content">
            <div class="top_menu">
                <ul>
                    <li><a href="#">账户登录</a></li>
                    <li><a href="#">注册</a></li>
                    <li><a href="#">向导</a></li>
                    <li><a href="#">博客</a></li>
                </ul>
            </div>
            <div class="top_phone">
                <span><a href='#'>我的订单</a></span>
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
                    <input type="text">
                    <a class="search_btn" href="#">搜索</a>
                </div>
           </div>
        </div>
    </div>
    <div class="detail_hr"></div>
    <div class="contain" hidden>
    	<div class="w">
    		<div class="message">
    			<ul>
    				<li class="txt">
    					购物车空空如也
    				</li>
    				<li>
    					<a href="index.html">去购物></a>
    				</li>
    			</ul>
    		</div>
    	</div>
    </div>
    <div class="cart_page">
        <div class="w">
            <div class="cart_header">
                <ul>
                    <li>
                        <input type="checkbox" class="selectAll">
                        <span>全选</span>
                    </li>
                    <li class="product">
                        <span>商品</span>
                    </li>
                    <li>
                        <span>单价</span>
                    </li>
                    <li>
                        <span>数量</span>
                    </li>
                    <li>
                        <span>小计</span>
                    </li>
                    <li>
                        <span>操作</span>
                    </li>
                </ul>
            </div>
	           <ul>
	            	<c:forEach items="${map }" var="item">
		                <li>
		                    <div class="goodsItem">
		                    	<input type="hidden" name="cartDetailId" value="${item.value.cartDetailId }">
		                        <ul>
		                            <li>
		                                <input type="checkbox" class="selectOne">
		                            </li>
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
		                            <li>
		                                <span>
		                                    <em>￥</em>
		                                    <span class="goods_price">${item.key.goodsPrice }</span>
		                                </span>
		                            </li>
		                            <li>
		                                <div class="goods_count">
		                                    <span class='count_img'></span>
		                                    <span>
		                                         <input type="text" name="count" value='${item.value.goodsCount }'>
		                                     </span>
		                                    <span class='count_img'></span>
		                               </div>
		                            </li>
		                            <li class='goods_price'>
		                                <em>￥</em>
		                                <span></span>
		                            </li>
		                            <li>
		                                <span><a href="cartServlet?op=delete&cartDetailId=${item.value.cartDetailId }" style='color:red'>删除</a></span>
		                            </li>
		                        </ul>
		                    </div>
		                </li>
	            	</c:forEach>
	           </ul>
        </div>
    </div>
    <div class="pay_page">
        <div class="w">
             <div class="pay_content">
                <ul>
                    <li>
                        <input type="checkbox" class="selectAll">
                        <span>全选</span>
                    </li>
                    <li class="product">
                        <a>删除选中的商品</a>
                    </li>
                    <li class="amount">
                         已选择<span>0</span>件商品
                    </li>
                    <li class="count">
                        总价：<em>¥</em><span>0</span>
                    </li>
                    <li>
                        <div class="add_order">
                          <a href="#">
                            <span>结算</span>
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