function searchGoods() {
	var currentPage = parseInt($(".goods_walls .goods_pages .pageCount span").first().text());
	if ($("#searchName").val() != null && $("#searchName").val() != "")
		window.location.href = "/MyShopping/goodsServlet?currentPage" + currentPage + 
			"&searchName=" + $("#searchName").val();
}


$(function() {
	if(location.search.lastIndexOf("searchName") != -1)
		$("#searchName").val(location.search.substring(location.search.lastIndexOf("searchName") + 11));
	
	$(".logout").click(function() {
		$.post("customerServlet","{op:logout}", function(data) {
			location.href = "login.html";
		});
	});
	
	$(".goods_walls .apple").each(function() {
		$(this).click(function() {
			var goodsId = $(this).find("input[name=goodsId]").val();
			location.href = "goodsServlet?goodsId=" + goodsId;
		});
	});

	$(".logo_search .logo img").css("cursor", "pointer");
	$(".logo_search .logo img").click(function() {
		location.href = "indexServlet";
	});

	$(".goods_walls .goods_pages a").mouseover(function() {
		$(this).css("border-color", "#FF8C00");
	});

	$(".goods_walls .goods_pages a").mouseout(function() {
		$(this).css("border-color", "#ededed");
	});

	$(".apple_img").mouseover(function() {
		$(this).css("border-color", "#FF8C00");
	});

	$(".apple_img").mouseout(function() {
		$(this).css("border-color", "#ededed");
	});

	var pageCount = parseInt($(".goods_walls .goods_pages .pageCount span").last().text());
	
	if (location.search.lastIndexOf("goodsServlet") != -1) {
	$(".goods_walls .goods_pages ul li a").each(function(index) {
		$(this).click(function() {
			var currentPage = parseInt($(".goods_walls .goods_pages .pageCount span").first().text());

			var prevPage = currentPage - 1;
			var nextPage = currentPage + 1;

			if (index == 0) {
				if (currentPage != 1) {
					if (prevPage)
						$.post("goodsServlet", "currentPage=1&searchName=" + $("#searchName").val(),
							function(data) {
								ajaxRequest(data, 1);
							}, 'json');
				}
			} else if (index == 1) {
				if ((currentPage - 1) > 0) {
					$.post("goodsServlet", "currentPage=" + prevPage + "&searchName=" + $("#searchName").val(),
						function(data) {
							ajaxRequest(data, prevPage);
						}, 'json');
				}
			} else if (index == 2) {
				if (nextPage <= pageCount) {
					$.ajax({
						url : "goodsServlet",
						data : "currentPage=" + nextPage + "&searchName=" + $("#searchName").val(),
						type : 'post',
						dataType : 'json',
						success : function(data) {
							ajaxRequest(data, nextPage);
						}
					});
				}
			}
			else {
				$.post("goodsServlet", "currentPage=" + pageCount + "&searchName=" + $("#searchName").val(),
					function(data) {
						ajaxRequest(data, pageCount);
					}, 'json');
			}
		});

		function ajaxRequest(data, currentPage) {
			$(".pages_walls .pageCount span").first().text(currentPage);

			for (var i = 11; i >= data.length; i--) {
				$(".goods_walls .apple").eq(i).css("display", "none");
			}

			if (currentPage != pageCount) {
				$(".goods_walls .apple").css("display", "block");
			}

			$(data).each(function(index, item) {
				var goodsDiv = $(".goods_walls .first_walls .apple").eq(index);
				goodsDiv.find(".apple_img img").attr("src", item.goodsPic);
				goodsDiv.find(".price i").text(item.goodsPrice);
				goodsDiv.find(".apple_img p").text(item.goodsName + " " + item.goodsDesc);
				goodsDiv.find(".apple_img img").attr("src", item.goodsPic);
				goodsDiv.find("input[name=goodsId]").val(item.goodsId);
			});
		}
		});
	} else {
		var categoryId = location.search.substring(location.search.lastIndexOf("categoryId") + 11);
		$(".goods_walls .goods_pages ul li a").each(function(index) {
			$(this).click(function() {
				var currentPage = parseInt($(".goods_walls .goods_pages .pageCount span").first().text());

				var prevPage = currentPage - 1;
				var nextPage = currentPage + 1;

				if (index == 0) {
					if (currentPage != 1) {
						if (prevPage)
							$.post("goodsCategoryServlet", "currentPage=1&categoryId=" + categoryId,
								function(data) {
									ajaxRequest(data, 1);
								}, 'json');
					}
				} else if (index == 1) {
					if ((currentPage - 1) > 0) {
						$.post("goodsCategoryServlet", "currentPage=" + prevPage + "&categoryId=" + categoryId,
							function(data) {
								ajaxRequest(data, prevPage);
							}, 'json');
					}
				} else if (index == 2) {
					if (nextPage <= pageCount) {
						$.ajax({
							url : "goodsCategoryServlet",
							data : "currentPage=" + nextPage + "&categoryId=" + categoryId,
							type : 'post',
							dataType : 'json',
							success : function(data) {
								ajaxRequest(data, nextPage);
							}
						});
					}
				}
				else {
					$.post("goodsCategoryServlet", "currentPage=" + pageCount + "&categoryId=" + categoryId,
						function(data) {
							ajaxRequest(data, pageCount);
						}, 'json');
				}
			});

			function ajaxRequest(data, currentPage) {
				$(".pages_walls .pageCount span").first().text(currentPage);

				for (var i = 11; i >= data.length; i--) {
					$(".goods_walls .apple").eq(i).css("display", "none");
				}

				if (currentPage != pageCount) {
					$(".goods_walls .apple").css("display", "block");
				}

				$(data).each(function(index, item) {
					var goodsDiv = $(".goods_walls .first_walls .apple").eq(index);
					goodsDiv.find(".apple_img img").attr("src", item.goodsPic);
					goodsDiv.find(".price i").text(item.goodsPrice);
					goodsDiv.find(".apple_img p").text(item.goodsName + " " + item.goodsDesc);
					goodsDiv.find(".apple_img img").attr("src", item.goodsPic);
					goodsDiv.find("input[name=goodsId]").val(item.goodsId);
				});
			}
			});
	}
});