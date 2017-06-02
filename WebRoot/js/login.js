	$(function() {
		 $(".login_logo img").css("cursor", "pointer");
		 $(".login_logo img").click(function() {
				location.href="indexServlet";
		});
		
	    $(".content_header span").first().click(function() {
	        $(".content_header span").last().css("border-bottom","3px solid #ccc");
	        $(".content_header span").last().css("color","#ccc")
	        $(this).css("border-bottom","3px solid rgb(85,166,206)");
	        $(this).css("color","rgb(85,166,206)")
	        $(".adminLogin_page").hide();
	        $(".login_page").show();
	    });
	    
	    $(".content_header span").last().click(function() {
	        $(".content_header span").first().css("border-bottom","3px solid #ccc");
	        $(".content_header span").first().css("color","#ccc");
	         $(this).css("border-bottom","3px solid rgb(85,166,206)");
	        $(this).css("color","rgb(85,166,206)")
	        $(".login_page").hide();
	        $(".adminLogin_page").show();
	       
	    });
	    
	    $(".adminLogin_button").click(function() {
	        var adminName = $('.adminLogin_page input[name=name]').val();
	        var adminPassword = $('.adminLogin_page input[name=password]').val();
	        var adminLoginError = $(".login_error").last();
	        if (adminName == null || adminName == "") {
	        	adminLoginError.children("span").first().text("用户名不能为空");
	        	adminLoginError.css("display", "block");
	        	return;
	        }
	        if (adminPassword == null || adminPassword == "") {
	        	adminLoginError.children("span").first().text("密码不能为空");
	        	adminLoginError.css("display", "block");
	        	return;
	        }
	        
	        var a =   $.ajax({
	                url:'adminServlet',
	                type:'post',
	                data: '{"adminName":"'+adminName+'","adminPassword":"'+adminPassword+'","op":"login"}',
	                /* dataType:'json',   //指定返回值类型 */
	                contentType:'application/json;charset=utf-8',
	                success:function(data,responseXML) {
	                	if (data == "error") {
	                		adminLoginError.children("span").first().text("用户名或密码错误");
	                		adminLoginError.css("display", "block");
	                	} else
	                		location.href = "http://localhost:8080/MyShopping/" + data;
	                }               
	            });
	       });
	    
	    $(".login_button").click(function() {
	        var customerName = $('.login_page input[name=name]').val();
	        var customerPassword = $('.login_page input[name=password]').val();
	        var customerLoginError = $(".login_error").first();
	        
	        if (customerName == null || customerName == "") {
	        	customerLoginError.children("span").first().text("用户名不能为空");
	        	customerLoginError.css("display", "block");
	        	return;
	        }
	        if (customerPassword == null || customerPassword == "") {
	        	customerLoginError.children("span").first().text("密码不能为空");
	        	customerLoginError.css("display", "block");
	        	return;
	        }
	        
	        var a =   $.ajax({
	                url:'customerServlet',
	                type:'post',
	                data: '{"customerName":"'+customerName+'","customerPassword":"'+customerPassword+'","op":"login"}',
	                /* dataType:'json',   //指定返回值类型 */
	                contentType:'application/json;charset=utf-8',
	                success:function(data) {
	                	if (data == "error") {
	                		customerLoginError.children("span").first().text("用户名或密码错误");
	                		customerLoginError.css("display", "block");
	                	}  else
	                		location.href = "http://localhost:8080/MyShopping/indexServlet";
	                }               
	            });
	       });
	});