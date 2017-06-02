$(function() {
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
});