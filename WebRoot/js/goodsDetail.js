$(function() {
    		$(".addSuccess").css("right",(($(document).width()) / 2) + "px");
    		
    		
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
    				dataType:'json',
    				success:function(dataObj) {
    					var message;    					
    					$(dataObj).each(function(index, item) {
    						message = item.message;
    						alert(message);
    					});
    					
    					if (message == "logout") {
    						$(".addSuccess span").text("未登录");
    						$(".addSuccess").css("display", "block");
    						setTimeout(function() {
    							location.href = "http://localhost:8080/MyShopping/login.html";
    						}, 1500);					
    					} else {
    						$(".addSuccess span").text("加入购物车成功");
    						 $(".addSuccess").css("display", "block");
    						setTimeout(function() {
    							$(".addSuccess").css("display","none");
    						}, 1500);
    					}
    				}
    			});
    		});
    	});