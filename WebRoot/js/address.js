$(function() {
	$(".customer_content input[name=city]").attr("disabled", true);
	$(".customer_content select[name=addressProvince]").change(function() {
		if($(this).val() == "北京市" || $(this).val() == "上海市" ||
				$(this).val() == "重庆市" || $(this).val() == "天津市")
			$(".customer_content input[name=city]").attr("disabled", true);
		else
			$(".customer_content input[name=city]").attr("disabled", false);
	});
	
	$(".customer_content table input:not([type=submit])").focus(function() {
		$(this).css("border", "1px solid #333");
	});

	$(".customer_content table input:not([type=submit])").blur(function() {
		$(this).css("border", "1px solid #e6e6e6");
	});

	$(".head_logo img").css("cursor", "pointer");
	$(".head_logo img").click(function() {
		location.href = "indexServlet";
	});
	
	$(".customer_content td[colspan='2'] a").click(function() {
		var addressProvince = $(".customer_content select[name=addressProvince]").val();
		var addressCity = $(".customer_content input[name=city]").val();
		var addressArea = $(".customer_content input[name=area]").val();
		var addressDetail = $(".customer_content textarea[name=addressDetail]").val();
		var addressChecked = 0;
		var address = "";
		
		if ($(".customer_content input[name=addressChecked]").prop("checked") == true) {
			addressChecked = 1;
		}
		
		if($(".customer_content input[name=city]").attr("disabled") == undefined)
			if (addressCity == null || addressCity == "") {
				$(".customer_content input[name=city] + .error").css("display", "block");
				return;
			}
		if (addressArea == null || addressArea == "") {
			$(".customer_content input[name=area] + .error").css("display", "block");
			return;
		}
		if (addressDetail == null || addressDetail == "") {
			$(".customer_content input[name=addressDetail] + .error").css("display", "block");
			return;
		}

		if($(".customer_content input[name=city]").attr("disabled") == undefined)
			$.post("addressServlet",
					"addressProvince=" + addressProvince + "&addressCity=" + addressCity + "&addressArea=" 
						+ addressArea + "&addressDetail=" + addressDetail + "&op=save&addressChecked=" + addressChecked,
					function(data) {
						setTimeout(location.href = "addressServlet?op=list", 1000);
				});
		else
			$.post("addressServlet",
					"addressProvince=" + addressProvince + "&addressArea=" 
						+ addressArea + "&addressDetail=" + addressDetail + "&op=save&addressChecked=" + addressChecked,
					function(data) {
						setTimeout(location.href = "addressServlet?op=list", 1000);
				});
	});

});