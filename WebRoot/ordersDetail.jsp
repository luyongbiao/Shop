<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
    <title>订单详情</title>
    <link rel='stylesheet' href='css/ordersDetail.css'>
    <script src='js/jquery-3.1.1.min.js'></script>
    <script>
        $(function(){   
              $("li.goods_price").each(function(index){
                  var price = parseInt($("span.goods_price").eq(index).text());
                  var count = parseInt($(".goods_count").eq(index).text());
                  $(this).children("span").text(price * count);
              });
              
              var  count = 0;
              var amount = 0;
              $(".goodsItem").each(function(index){              
                    count += parseInt($(this).find("span.goods_price").text()) * 
                    parseInt($(this).find(".goods_count").text());
                    amount += parseInt($(this).find(".goods_count").text());
             });
                    var status = $(this).find("li.goods_status").val(); 
              		if(status == 1){
	              		$(this).find("li.goods_status span ").first().text("未付款");
              		} else if(status == 2) {
	              		$(this).find("li.goods_status span ").first().text("待发货");
              		} else if(status == 3) {
	              		$(this).find("li.goods_status span ").first().text("已发货");
              		}
              $(".pay_content .count span").text(count);  
             $(".pay_content .amount span").text(amount);
              
     });
    </script>
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
                    <li><a href="#">向导</a></li>
                    <li><a href="#">博客</a></li>
                </ul>
            </div>
            <div class="top_phone">
                <span><a href='#'>我的购物车</a></span>
                <span><a href='#'>请联系我们</a></span>
                 <span><a href='ordersServlet?op=list' id="myOrders">我的订单</a></span>
            </div>
        </div>
    </div>
    <div class="top_next">
        <div class="logo_search">
            <div class="logo">
                <img src="image/logo.png">
            </div>
            <div class="carts_title">
                <span>订单详情</span>
            </div>
        </div>
    </div>
    <div class="detail_hr"></div>
     <div class="orders_detail">
            <div class="w">
                <div class="comfirm_orders" style="margin:20px 0;">
                    <span>订单信息</span>
                </div>
            </div>
    </div>
    <div class="cart_page">
        <div class="w">
            <div class="cart_header">
                <ul>
                    <li class="product">
                        <span style="font-weight:700;font-size:15px;">2017-05-01</span>
                        <span style="margin-left:10px;font-size:15px;">订单号：${orders.ordersId}</span>
                    </li>
                    <li>
                         <span>单价</span>
                        
                    </li>
                    <li>
                       <span>数量</span>
                    </li>
                     <li>
                       <span>订单状态</span>
                    </li>
                </ul>
            </div>
            <ul>
            	<c:forEach items="${map }" var="item">
	                <li>
	                    <div class="goodsItem">
	                        <ul>
	                            <li class="product">
	                                <div class="goodsDetail">
	                                    <div class="goodsImage">
	                                        <a href="#"><img src="${item.value.goodsPic }"></a>
	                                    </div>
	                                    <div class="goodsName">
	                                        <div class='goodsTitle'>
	                                            <a href="#"><span>${item.value.goodsName }</span></a>
	                                        </div>
	                                        <div class="goodsDesc">
	                                            <span>${item.value.goodsDesc }</span>
	                                        </div>
	                                    </div>
	                                </div>
	                            </li>
	                            <li>
	                                <span>
	                                    <em>￥</em>
	                                    <span class="goods_price">${item.value.goodsPrice }</span>
	                                </span>
	                            </li>
	                            <li>
	                                    <span class="goods_count">${item.key.goodsCount }&nbsp;</span>
	                            </li>
	                            <li class="goods_status" value="${orders.ordersStatusId }">
	                                <span style='color:red;font-size:18px'>&nbsp;</span>
	                            </li>
	                        </ul>
	                    </div>
	                </li>
                </c:forEach>
            </ul>
        </div>
    </div>
    <div class="orders_id">
        <div class="w">
            <div class="orders_address">
                寄送至：<span>广东省广州市 海珠滨江仲恺农业工程学院海珠校区 北区6栋209</span>
            </div>
            <br/>
            <div class='orders_phone'>
                联系人：<span>卢勇彪 &nbsp;&nbsp;13232187878</span>
            </div>
        </div>
    </div>
     <div class="pay_page">
        <div class="w">
             <div class="pay_content">
                <ul>
                    <li class="amount">
                         已选择<span>0</span>件商品
                    </li>
                    <li class="count">
                        总价：<em>¥</em><span>0</span>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</body>
</html>