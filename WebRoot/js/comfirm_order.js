$(document).ready(function() {
	$(".Caddress .add_mi").first().css('background', 'url("image/mail_1.jpg") no-repeat').siblings('.add_mi').css('background', 'url("image/mail.jpg") no-repeat');
	$(".Caddress .add_mi").first().find("p a.address_update").css("display","inline-block");
	$(".Caddress .add_mi").first().find("p a.address_delete").css("display","none");
	
	$(".Caddress .add_mi").each(function(index, item) {
		$(this).find("p").first().css("display","block").css("overflow","hidden").css("height","29px");
	});
	
	$(".add_order a span").click(function() {
		var strc = "";
		$("input[name=cartDetailId]").each(function() {
			//alert($(this).val());
			strc += "&checked=" + $(this).val();
		});
		if (strc == "") {
			return;
		}
		strc = strc.substring(1);
		location.href = 'ordersDetailServlet?' + strc + '&op=' + 'save';
	});
	

	var span_momey = $(".span_momey");
	var b = 0;
	for (var i = 0; i < span_momey.length; i++) {
		b += parseFloat($(span_momey[i]).html());
	}
	var out_momey = $(".out_momey");
	out_momey.html(b);
	$(".shade_content").hide();
	$(".shade").hide();
	$('.nav_mini ul li').hover(function() {
		$(this).find('.two_nav').show(100);
	}, function() {
		$(this).find('.two_nav').hide(100);
	})
	$('.left_nav').hover(function() {
		$(this).find('.nav_mini').show(100);
	}, function() {
		$(this).find('.nav_mini').hide(100);
	})
	$('#jia').click(function() {
		$('input[name=num]').val(parseInt($('input[name=num]').val()) + 1);
	})
	$('#jian').click(function() {
		$('input[name=num]').val(parseInt($('input[name=num]').val()) - 1);
	})
	$('.Caddress').on('click','.add_mi',function() {
		$(this).css('background', 'url("image/mail_1.jpg") no-repeat').siblings('.add_mi').css('background', 'url("image/mail.jpg") no-repeat')
		$(this).find("p a.address_update").css("display","inline-block");
		$(".Caddress .add_mi").not($(this)).find("p a.address_update").css("display","none");
		$(this).find("p a.address_delete").css("display","none");
		$(".Caddress .add_mi").not($(this)).find("p a.address_delete").css("display","inline-block");
	})
	
	var x = Array();
	
	function func(a, b) {
		x[b] = a.html();
		alert(x)
		a.css('border', '2px solid #f00').siblings('.min_mx').css('border', '2px solid #ccc');
	}
	
	$(".btn_remove").click(function() {
		var shade_content = $(".shade_content");
		var shade = $(".shade");
		$(".shade_content input[name=customerAddressId]").val($(this).parents(".add_mi").find("input[name=addressId]").val());
		$(".shade_content select[name=addressProvince]").val($(this).parents(".add_mi").find("p").first().text().split(" ")[0]);
		$(".shade_from input[name=city]").val($(this).parents(".add_mi").find("p").first().text().split(" ")[1]);
		$(".shade_content input[name=area]").val($(this).parents(".add_mi").find("p").first().text().split(" ")[2]);
		$(".shade_content textarea[name=addressDetail]").val($(this).parents(".add_mi").find("p").eq(1).text());
		$(".shade_from input[name=addressChecked]").prop("checked", true);
		shade_content.hide();
		shade.hide();
	});
	
	$(".open_btn").click(function() {
		$(".shade_content").show();
		$(".shade").show();
		if($(".shade_from select[name=addressProvince]").val() == "北京市" ||$(".shade_from select[name=addressProvince]").val() == "上海市" ||
				$(".shade_from select[name=addressProvince]").val() == "重庆市" || $(".shade_from select[name=addressProvince]").val() == "天津市")
			$(".shade_from input[name=city]").attr("disabled", true);
		else
			$(".shade_from input[name=city]").attr("disabled", false);
	});	
	
	$(".shade_from select[name=addressProvince]").change(function() {
		if($(this).val() == "北京市" || $(this).val() == "上海市" ||
				$(this).val() == "重庆市" || $(this).val() == "天津市")
			$(".shade_from input[name=city]").attr("disabled", true);
		else
			$(".shade_from input[name=city]").attr("disabled", false);
	});
	
	$(".shade_from table input:not([type=submit])").focus(function() {
		$(this).css("border", "1px solid #333");
	});

	$(".shade_from table input:not([type=submit])").blur(function() {
		$(this).css("border", "1px solid #e6e6e6");
	});

	$(".head_logo img").css("cursor", "pointer");
	$(".head_logo img").click(function() {
		location.href = "indexServlet";
	});
	
	$(".shade_from .sub_set").click(function() {
		var addressAddressId = $(".shade_content input[name=customerAddressId]").val();
		var addressProvince = $(".shade_from select[name=addressProvince]").val();
		var addressCity = $(".shade_from input[name=city]").val();
		var addressArea = $(".shade_from input[name=area]").val();
		var addressDetail = $(".shade_from textarea[name=addressDetail]").val();
		var addressChecked = 0;
		var address = "";
		
		if ($(".shade_from input[name=addressChecked]").prop("checked") == true) {
			addressChecked = 1;
		}
		
		if($(".shade_from input[name=city]").attr("disabled") == undefined)
			if (addressCity == null || addressCity == "") {
				$(".shade_from input[name=city] + .error").css("display", "block");
				return;
			}
		if (addressArea == null || addressArea == "") {
			$(".shade_from input[name=area] + .error").css("display", "block");
			return;
		}
		if (addressDetail == null || addressDetail == "") {
			$(".shade_from input[name=addressDetail] + .error").css("display", "block");
			return;
		}
		
		alert(addressAddressId);
		if (addressAddressId == null || addressAddressId == "") {
			if($(".shade_from input[name=city]").attr("disabled") == undefined)
				$.post("addressServlet",
						"addressProvince=" + addressProvince + "&addressCity=" + addressCity + "&addressArea=" 
							+ addressArea + "&addressDetail=" + addressDetail + "&op=save&addressChecked=" + addressChecked,
						function(data) {
							location.reload();
					});
			else
				$.post("addressServlet",
						"addressProvince=" + addressProvince + "&addressArea=" 
							+ addressArea + "&addressDetail=" + addressDetail + "&op=save&addressChecked=" + addressChecked,
						function(data) {
							
							location.reload();
				});
		} else {
			if($(".shade_from input[name=city]").attr("disabled") == undefined)
				$.post("addressServlet",
						"customerAddressId=" + addressAddressId + "&addressProvince=" + addressProvince + "&addressCity=" + addressCity + "&addressArea=" 
							+ addressArea + "&addressDetail=" + addressDetail + "&op=update&addressChecked=" + addressChecked,
						function(data) {
						location.reload();
					});
			else
				$.post("addressServlet",
						"customerAddressId=" + addressAddressId + "&addressProvince=" + addressProvince + "&addressArea=" 
							+ addressArea + "&addressDetail=" + addressDetail + "&op=update&addressChecked=" + addressChecked,
						function(data) {
							
							location.reload();
				});
		}
		
			
	});
	
	$(".address_page .add_mi").click(function() {
		if ($("#bubu").val() == 0)
			return;
		
		var customerAddressId = $(this).find("input[name=addressId]").val();
		$.post("addressServlet", "op=checked&customerAddressId=" + customerAddressId);
	});
	
	$(".address_page .add_mi a.address_delete").click(function() {
		$("#bubu").val(0);
		var customerAddressId = $(this).parents(".add_mi").find("input[name=addressId]").val();
		$.post("addressServlet", "op=delete&customerAddressId=" + customerAddressId, function(data) {
			location.reload();
		});
	});
	
	$(".address_page .add_mi a.address_update").click(function() {
		$("#bubu").val(0);
		$(".shade_content input[name=customerAddressId]").val($(this).parents(".add_mi").find("input[name=addressId]").val());
		$(".shade_content select[name=addressProvince]").val($(this).parents(".add_mi").find("p").first().text().split(" ")[0]);
		$(".shade_from input[name=city]").val($(this).parents(".add_mi").find("p").first().text().split(" ")[1]);
		$(".shade_content input[name=area]").val($(this).parents(".add_mi").find("p").first().text().split(" ")[2]);
		$(".shade_content textarea[name=addressDetail]").val($(this).parents(".add_mi").find("p").eq(1).text());
		$(".shade_from input[name=addressChecked]").prop("checked", true);
		if($(".shade_from select[name=addressProvince]").val() == "北京市" ||$(".shade_from select[name=addressProvince]").val() == "上海市" ||
				$(".shade_from select[name=addressProvince]").val() == "重庆市" || $(".shade_from select[name=addressProvince]").val() == "天津市")
			$(".shade_from input[name=city]").attr("disabled", true);
		else
			$(".shade_from input[name=city]").attr("disabled", false);
		$(".shade_content").show();
		$(".shade").show();
	});
});