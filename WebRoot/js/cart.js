$(document).ready(function(){
			var arr = [];
			$(".pay_content li.product a").click(function() {
				var i = 0;
				$(".selectOne[type=checkbox]").each(function() {
						if($(this).prop("checked")) {
							i++;
						}
				});
				
				if (i != 0) {
					var url = "cartServlet?";
					 $(".goodsItem").each(function() {
						if ($(this).find(".selectOne[type=checkbox]").prop("checked"))
							url += "cartDetailId=" + $(this).find("input[name=cartDetailId]").val() + "&";
					 });
					
					url += "op=deleteMore";
					location.href= url;
				}
			});
			
			$(".logo_search .logo img").css("cursor", "pointer");
			$(".logo_search .logo img").click(function() {
				location.href="indexServlet";
			});
			
			$(".addSuccess").css("right",(($("body").width() + 40) / 2) + "px");
			
			var height_Items = $(".goodsItem").length * 130;
			$(".cart_page").height(height_Items + $(".cart_page").height() + "px");
			
			$(".goods_count").each(function(index){
				$(this).find("span").first().click(function() {
					if (parseInt($(".goods_count").eq(index).find("span").eq(1).find("input").val()) > 1)
						$(".goods_count").eq(index).find("span").eq(1).find("input").val(
								parseInt($(".goods_count").eq(index).find("span").eq(1).find("input").val()) - 1);
					});
				});
             
             $(".goods_count").each(function(index){
                $(this).find("span").last().click(function() {
                        $(".goods_count").eq(index).find("span").eq(1).find("input").val(
                                    parseInt($(".goods_count").eq(index).find("span").eq(1).find("input").val()) + 1);
                 });
                      
              });
              
              $(".goods_count").each(function(index){
                    $(this).find("input").blur(function() {
                        if(parseInt($(this).val()) <= 0 ||
                                !$(this).val().match(/^[0-9]*$/g) || $(this).val() == "") {
                            $(this).val(1);
                        }
                        
                         while ($(this).val().match(/^0/g)) {
                            $(this).val($(this).val().substring(1));
                         }
                     });
              });
              
              $(".goodsItem").each(function(index){
                    $(this).find("input").blur(function() {
                        var price =  parseInt($(".goodsItem").eq(index).find("span.goods_price").text());                        
                        var count = parseInt($(".goodsItem").eq(index).find("input[name=count]").val());
                         $(".goodsItem").eq(index).find("li.goods_price span").text(price * count);
                         var totalPrice = $(".goodsItem").eq(index).find("li.goods_price span").text();
                         var cartDetailId = $(this).parents(".goodsItem").find("input[name=goodsForSelectOne]").val();   
                         $.ajax({
                    			url : 'cartServlet',
                    			type : 'post',
                    			data : '{"cartDetailId":"' + cartDetailId + '","goodsCount":"' + count + '","totalPrice":"' + totalPrice + '","op":"update"}', 
                    			contentType : 'application/json;charset=utf-8',
                    		});
                    });
                    
                   $(this).find(".goods_count span").not("[type=text]").click(function() {
                        var price =  parseInt($(".goodsItem").eq(index).find("span.goods_price").text());                        
                        var count = parseInt($(".goodsItem").eq(index).find("input[name=count]").val());
                        $(".goodsItem").eq(index).find("li.goods_price span").text(price * count);
                        var totalPrice = $(".goodsItem").eq(index).find("li.goods_price span").text();
                        var cartDetailId = $(this).parents(".goodsItem").find("input[name=goodsForSelectOne]").val();   
                        /* alert(cartDetailId);*/
                         $.ajax({
                   			url : 'cartServlet',
                   			type : 'post',
                   			data : '{"cartDetailId":"' + cartDetailId + '","goodsCount":"' + count + '","totalPrice":"' + totalPrice + '","op":"update"}', 
                   			contentType : 'application/json;charset=utf-8',
                   		});
                         
                         
                   });
              });
              
              $("li.goods_price span").each(function(index){
                  var price = parseInt($("span.goods_price").eq(index).text());
                  var count = parseInt($(".goods_count input[name=count]").eq(index).val());
                  $(this).text(price * count);
              });
              
              
              
              $(".selectAll[type=checkbox]").each(function(index){
                 $(this).change(function() {
                 if ($(this).prop("checked")) {
                    $(".selectOne[type=checkbox]").prop("checked",true);
                    $(this).prop("checked",true);
                    $(".selectAll[type=checkbox]").prop("checked",true);
                } else {
                    $(".selectOne[type=checkbox]").prop("checked", false);
                    $(this).prop("checked",false);
                    $(".selectAll[type=checkbox]").prop("checked",false);
                    
                }
                });  
              });
              
              $(".selectOne").each(function(index){
                   $(".goodsItem").eq(index).find("input").blur(totalCount);
                   $(".goodsItem").eq(index).find("input").blur(amount);
                    
                   $(".goodsItem").eq(index).find(".goods_count span").not("[type=text]").click(totalCount);
                   $(".goodsItem").eq(index).find(".goods_count span").not("[type=text]").click(amount);
                    
                    $(".selectOne").change(totalCount); 
                    $(".selectOne").change(amount); 
                    
                    $(".selectAll").change(totalCount);
                   $(".selectAll").change(amount);
                    
                    function totalCount(){
                        var  count = 0;
                        $(".selectOne").each(function(index){
                            if ($(this).prop('checked') == true) {
                                count += parseInt($(".goodsItem").eq(index).find("span.goods_price").text()) * 
                                parseInt($(".goodsItem").eq(index).find(".goods_count input[name=count]").val());
                            }
                        });
                         $(".pay_content .count span").text(count);
                   }
                   
                   function amount() {
                        var  amount = 0;
                        $(".selectOne").each(function(index){
                            if ($(this).prop('checked') == true) {
    
                                amount += 
                            parseInt($(".goodsItem").eq(index).find(".goods_count input[name=count]").val());
                            }
                        });
                         $(".pay_content .amount span").text(amount);
                   }
              });
              
              $(".add_order a span").click(function() {
            	  	var str = "";
            	  	$("input[name=goodsForSelectOne]").each(function(){
            	  		//alert($(this).val());
            	  		if ($(this).is(':checked')) {
            	  			str+= "&checked=" + $(this).val();
            	  			$(this).parent("li").parent("ul").find(".goods_count input[name=count]").val();       
            	  		}
            	  	});
            	  	if(str == "") {
            	  		return;
            	  	}
            	  	str = str.substring(1);
            	  	
            	  	location.href = 'ordersDetailServlet?' + str;
            		/*$.ajax({
            			url : 'ordersDetailServlet',
            			type : 'post',
            			cache : false,  
                        traditional :true,    //必须加上该句话来序列化  
                        data: str,//提交的参数   
            			success : function(data) {
            				var msg;
            				$(data).each(function(index, item) {
            					msg = item.message;
            				});
            			}
            		});*/
            	  	
            	  	
            	  	
            	});
              $(".add_cart span").click(function() {
          		var goodsId = $("input[name=goodsId]").val();
          		var goodsCount = parseInt($(".goods_count span input").val());
          		var price = $(".goods_price .price span").text();
          		var totalPrice = goodsCount * price;

          		$.ajax({
          			url : 'cartServlet',
          			type : 'post',
          			data : '{"goodsId":"' + goodsId + '","goodsCount":"' + goodsCount + '","totalPrice":"'
          				+ totalPrice + '","op":"save"}',
          			contentType : 'application/json;charset=utf-8',
          			success : function(data) {
          				var msg;
          				$(data).each(function(index, item) {
          					msg = item.message;
          				});
          				
          				if (msg == "logout") {
          					$(".addSuccess span").text("未登录");
          					$(".addSuccess").css("display", "block");
          					setTimeout(function() {
          						location.href = "http://localhost:8080/MyShopping/login.html";
          					}, 1500);
          				} else {
          					$(".addSuccess span").text("加入购物车成功");
          					$(".addSuccess").css("display", "block");
          					setTimeout(function() {
          						$(".addSuccess").css("display", "none");
          					}, 1500);
          				}
          			}
          		});
          	});
              
              
              
              
              
              
              
             
              
              
              
              
              
              
              
              
              
              
              
              
              
     });