	$(function() {
		$('.customer_content input').blur(function(){
			var index = $(this).parents('tr').index();
			$('.kong').hide();
			$('.customer_content tr').each(function(i){
				if(i>index)	return;
				if(!$(this).find('input').val() && $(this).hasClass('item')){
					$(this).find('.kong').show();
				}
			})
		});
		
		$("form").submit(function(){
			return false;
		});
		$("table input[type=submit]").click(function() {
		        var customerName = $('.customer_content input[name=customerName]').val();
		        var customerPassword = $('.customer_content input[name=customerPassword]').val();
		        //var customerLoginError = $(".register_error").first();
		        
		        if (customerName == null || customerName == "") {
		 
		        	$("#kong_name").css("display", "block");
		        	
		        			
		        			
		        	return;
		        }
		        if (customerPassword == null || customerPassword == "") {
		        	customerLoginError.children("span").first().text("密码不能为空");
		        	customerLoginError.css("display", "block");
		        	return;
		        }
	
		$.ajax({
			 url:'customerServlet',
	         type:'post',
	         data: '{"customerName":"'+customerName+'","customerPassword":"'+customerPassword+'","op":"register"}',
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
});