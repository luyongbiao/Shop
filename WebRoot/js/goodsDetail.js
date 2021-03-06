function searchGoods() {
	if ($("#searchName").val() != null && $("#searchName").val() != "")
	window.location.href = "/MyShopping/goodsServlet?searchName=" + $("#searchName").val();
}

$(function() {
	$(".top_menu .logout").click(function() {
		$.post("customerServlet","{op:logout}", function(data) {
			location.href = "login.html";
		});
	});
	
	$(".addSuccess").css("right", (($("body").width() + 40) / 2) + "px");
	
	$(".logo_search .logo img").css("cursor", "pointer");
	$(".logo_search .logo img").click(function() {
		location.href="indexServlet";
	});

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
		if (parseInt($(this).val()) <= 0 ||
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