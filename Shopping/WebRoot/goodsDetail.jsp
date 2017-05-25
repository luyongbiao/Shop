<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>商品详情</title>
    <link rel='stylesheet' href='css/goodsDetail.css'>
    <script src="js/jquery-3.1.1.min.js"></script>
    <script>
    	$(function() {
    		$(".addSuccess").css("right",(($("body").width() + 40) / 2) + "px");
    		
    		
    		$(".goods_count").find("span").first().click(function() {
    			if (parseInt($(".goods_count").find("span").eq(1).find("input").val()) > 1)
    				$(".goods_count").find("span").eq(1).find("input").val(
    					parseInt($(".goods_count").find("span").eq(1).find("input").val()) - 1);
    		});
    		
    		$(".goods_count").find("span").last().click(function() {
    			$(".goods_count").find("span").eq(1).find("input").val(
    				parseInt($(".goods_count").find("span").eq(1).find("input").val()) + 1);
    		});
    		
    		$(".goods_count").find("input").blur(function() {
    			if(parseInt($(this).val()) <= 0 ||
    				!$(this).val().match(/^[0-9]*$/g) || $(this).val() == "") {
    					$(this).val(1);
    				}
    				
    				while ($(this).val().match(/^0/g)) {
    					$(this).val($(this).val().substring(1));
    				}
    		});
    		
    		$(".add_cart span").click(function() {
    			var goodsId = $("input[name=goodsId]").val();
    			var goodsCount = parseInt($(".goods_count span input").val());
    			var price = $(".goods_price .price span").text();
    			var totalPrice = goodsCount * price;
    		
    			$.ajax({
    				url:'cartServlet',
    				type:'post',
    				data:'{"goodsId":"' + goodsId + '","goodsCount":"' + goodsCount + '","totalPrice":"' 
    							+ totalPrice + '","op":"save"}',
    				contentType:'application/json;charset=utf-8',
    				success:function(data) {
    					if (data == "logout") {
    						$(".addSuccess span").text("未登录");
    						$(".addSuccess").css("display","block");
    						setTimeout(function() {
    							location.href = "http://localhost:8080/MyShopping/login.html";
    						}, 1500);					
    					} else {
    						$(".addSuccess span").text("加入购物车成功");
    						$(".addSuccess").css("display","block");
    						setTimeout(function() {
    							$(".addSuccess").css("display","none");
    						}, 1500);
    					}
    				}
    			});
    		});
    		
    		$(".cart a span").click(function() {
    			$.ajax({
					url:'cartServlet',
					type:'post',
					data:'{"op":"list"}',
					contentType:'application/json;charset=utf-8',
					dataType:'json',
					success:function(result) {
						var dataObject = result;
						var message;
						 $(dataObject).each(function(index, item) {
	                	 	message = item.message;
	                	 });
						
						if (message == "logout") {
							$(".addSuccess span").text("未登录");
    						$(".addSuccess").css("display","block");
    						setTimeout(function() {
    							location.href = "http://localhost:8080/MyShopping/login.html";
    						}, 1500);		
						} else if (message == "none") {
							$.post('cart.html',null);
						} else if (message == "right"){
							 var map;
			               	 var cart;
			               	 
			               	 $(dataObject).each(function(index, item) {
			               	 	map = item.map;
			               	 	cart = item.cart;
			               	 	<jsp:forward page="b.jsp"></jsp:forward> 
			               	 });
			               	 
						}
	                }    
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
                    <li><a href="login.html">账户登录</a></li>
                    <li><a href="register.html">注册</a></li>
                    <li><a href="#">向导</a></li>
                    <li><a href="#">博客</a></li>
                </ul>
            </div>
            <div class="top_phone">
                <span><a href='orders.html'>我的订单</a></span>
                <span><a href='cart.html'>购物车</a></span>
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
                    <input type="text">
                    <a class="search_btn" href="#">搜索</a>
                </div>
           </div>
           <div class="cart">
                <a>
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
                <img src="image/apple.jpg">
            </div>
            <div class="goods_content">
            	<input type="hidden" name="goodsId" value="1005">
                <div class="goods_detail">
                    <span>王小二 苹果水果批发包邮 新鲜山东烟台栖霞红富士苹果 平果一箱</span>
                    <span>自然成熟 新鲜直达 酸甜如初恋</span>
                </div>
                <div class="goods_price">
                    <span>价格</span>
                    <div class="price">
                        <em>￥</em>
                        <span>115.50</span>
                    </div>
                </div>
                <div class="goods_count">
                    <span class='count_img'></span>
                    <span>
                        <input type="text" name="count" value='1'>
                    </span>
                    <span class='count_img'></span>
                    共10件
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