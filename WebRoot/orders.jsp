<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
    <title>订单管理</title>
    <link rel='stylesheet' href='css/orders.css'>
    <script src='js/jquery-3.1.1.min.js'></script>
    <script>
        $(function(){   
	       	var op1 = decodeURI(location.search);
	       	op1 = op1.substring(1);
	       if (op1 == "op=listNoPayed"){
	        	$(".orders_status li").eq(1).find("a").css("color","#C0A78C");
	        	$(".orders_status li").eq(1).css("border-bottom","2px solid #C0A78C");
	        } else if (op1 == "op=listPayed"){
	        	$(".orders_status li").eq(2).find("a").css("color","#C0A78C");
	        	$(".orders_status li").eq(2).css("border-bottom","2px solid #C0A78C");
	        } else if (op1 == "op=list") {
	        	$(".orders_status li").eq(0).find("a").css("color","#C0A78C");
	        	$(".orders_status li").eq(0).css("border-bottom","2px solid #C0A78C");
	        } 
	        
              var amount = 0;
              var ordersDetailId = "";
              $(".cart_page").each(function(index){  
	              var  count = 0;
              		$(this).find(".goodsItem").each(function(index){
	                    count += parseInt($(this).find("span.goods_price").text()) * 
	                    parseInt($(this).find(".goods_count").text());
	             	 	
              		});  
              		$(this).find(".count").first().text(count);
              		$(this).find(".goods_total_price span em").first().text("￥");
              		var status = $(this).find("li.goods_status").val(); 
              		if(status == 1){
	              		$(this).find("li.goods_status span ").first().text("未付款");
              		} else if(status == 2) {
	              		$(this).find("li.goods_status span ").first().text("待发货");
              		} else if(status == 3) {
	              		$(this).find("li.goods_status span ").first().text("已发货");
              		}
              		$(this).find("div.w").click(function(){
              			var ordersId = $(this).find("li.product").val();
              			$(this).find("div.goodsItem li.getOrdersDetailId").each(function(){
	              			ordersDetailId += "&ordersDetailId=" + $(this).val();
              			})
              			ordersDetailId = ordersDetailId.substring(1);
              			location.href = "ordersDetailServlet?" + ordersDetailId + "&ordersId=" +ordersId;
              			/* $.ajax({
            			url : 'ordersDetailServlet',
            			type : 'post',
            			contentType: "application/json",
            			/* cache : false,  
                        traditional :true,     //必须加上该句话来序列化  
                        data: '{"ordersDetailId":"' + ordersDetailId + '}',//提交的参数   
            			success : function(data) {
            				var msg;
            				$(data).each(function(index, item) {
            					msg = item.message;
            				});
            			}
            		}); */
              		});	
             });
             
             
             
            //注销操作 
            $(".top_menu .logout").click(function() {
			$.post("customerServlet", "{op:logout}", function(data) {
			location.href = "login.html";
			});
		});
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
            </div>
        </div>
    </div>
    <div class="top_next">
        <div class="logo_search">
            <div class="logo">
                <img src="image/logo.png">
            </div>
            <div class="carts_title">
                <span>我的订单</span>
            </div>
        </div>
    </div>
    <div class="detail_hr"></div>
    <div class="orders_status">
        <div class="w">
            <ul>
                <li><a href="ordersServlet?op=list">全部订单</a></li>
                <li><a href="ordersServlet?op=listNoPayed">未付款</a></li>
                <li><a href="ordersServlet?op=listPayed">已付款</a></li>
                <li><a href="#">已完成</a></li>
            </ul>
        </div>
    </div>
    <c:forEach items="${map }" var="item">
    	<div class="cart_page">
       		<div class="w">
            	<div class="cart_header">
               	  <ul>
                    <li class="product" value='${item.key.ordersId }'>
                        <span style="font-weight:700;font-size:15px;">2017-05-01</span>
                        <span style="margin-left:10px;font-size:15px;">订单号：${item.key.ordersId }</span>
                    </li>
                    <li>
                         <span>单价</span>
                        
                    </li>
                    <li>
                       <span>数量</span>
                    </li>
                    <li>
                        <span>订单总价</span>
                    </li>
                    <li>
                        <span>订单状态</span>
                    </li>
                </ul>
            </div>
            <ul>
            <c:forEach items="${item.value }" var="item_goods">
            	
                <li>
                    <div class="goodsItem">
                        <ul>
                            <li class="product">
                                <div class="goodsDetail">
                                    <div class="goodsImage">
                                        <a href="#"><img src=${item_goods.value.goodsPic }></a>
                                    </div>
                                    <div class="goodsName">
                                        <div class='goodsTitle'>
                                            <a href="#"><span>${item_goods.value.goodsName }</span></a>
                                        </div>
                                        <div class="goodsDesc">
                                            <span>${item_goods.value.goodsDesc }</span>
                                        </div>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <span>
                                    <em>￥</em>
                                    <span class="goods_price">${item_goods.value.goodsPrice }</span>
                                </span>
                            </li>
                            <li class="getOrdersDetailId" value='${item_goods.key.ordersdetailId }'>
                                    <span class="goods_count">${item_goods.key.goodsCount }</span>
                            </li>
                             <li class='goods_total_price' >
                                <span style="color:red;font-size:17px">
                                    <em>&nbsp;</em>
                                    <span class="count">&nbsp;</span>
                                </span>
                            </li>
                             <li class='goods_status' value='${item.key.ordersStatusId }'>
                                <span style="color:red;font-size:17px">
                                &nbsp;
                                </span>
                            </li>
                        </ul>
                    </div>
               	 </li>
                </c:forEach>
                 
               </ul>
       	 	</div>
   	 	</div>
   	 </div>
    </c:forEach>
</body>
</html>