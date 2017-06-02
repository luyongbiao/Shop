$(function() {
	$(".top_menu .logout").click(function() {
		$.post("customerServlet", "{op:logout}", function(data) {
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


	$(".picture .prev, .picture .next").hide();
	var bb = $("#picture_item li:last");
	var aa = $("#picture_item li:first");
	setInterval(function() {
		if (bb.is(":visible")) {
			aa.fadeIn(1000).addClass("in");
			bb.hide();
		} else {
			$("#picture_item li:visible").addClass("in");
			$("#picture_item li.in").next().fadeIn(1000);
			$("#picture_item li.in").fadeOut(1000).removeClass("in");
		}
	}, 5000);

	$(".picture").mouseover(function() {
		$(".picture .prev, .picture .next").show();
	});

	$(".picture").mouseout(function() {
		$(".picture .prev, .picture .next").hide();

	});

	$(".picture .next").click(function() {
		if (bb.is(":visible")) {
			aa.fadeIn(1000).addClass("in");
			bb.hide();
		} else {
			$("#picture_item li:visible").addClass("in");
			$("#picture_item li.in").next().fadeIn(1000);
			$("#picture_item li.in").fadeOut(1000).removeClass("in");
		}
	});

	$(".picture .prev").click(function() {
		if (aa.is(":visible")) {
			bb.fadeIn(1000).addClass("in");
			aa.hide();
		} else {
			$("#picture_item li:visible").addClass("in");
			$("#picture_item li.in").prev().fadeIn(1000);
			$("#picture_item li.in").fadeOut(1000).removeClass("in");
		}
	});

	$(".picture .prev").click(function() {
		if (aa.is(":visible")) {
			bb.fadeIn(1000).addClass("in");
			aa.hide();
		} else {
			$("#picture_item li:visible").addClass("in");
			$("#picture_item li.in").prev().fadeIn(1000);
			$("#picture_item li.in").fadeOut(1000).removeClass("in");
		}
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

	setInterval(function() {
		var img = $(".promotion_img");
		img.animate({
			height : '200px',
			opacity : '0.4'
		}, 1000);
		img.animate({
			width : '400px',
			opacity : '0.8'
		}, 1000);
		img.animate({
			height : '200px',
			opacity : '0.4'
		}, 1000);
		img.animate({
			width : '400px',
			opacity : '0.8'
		}, 2000);
	}, 1000);

	function searchGoods() {
		var searchName = document.getElementById('searchName').value;
		window.location.href = "/MyShopping/goodsServlet?searchName=" + searchName;
	}

	var pageCount = parseInt($(".goods_walls .goods_pages .pageCount span").last().text());

	$(".goods_walls .goods_pages ul li a").each(function(index) {
		$(this).click(function() {
			var currentPage = parseInt($(".goods_walls .goods_pages .pageCount span").first().text());

			var prevPage = currentPage - 1;
			var nextPage = currentPage + 1;


			if (index == 0) {
				if (currentPage != 1) {
					if (prevPage)
						$.post("indexServlet", "currentPage=1",
							function(data) {
								ajaxRequest(data, 1);
							}, 'json');
				}
			} else if (index == 1) {
				if ((currentPage - 1) > 0) {
					$.post("indexServlet", "currentPage=" + prevPage,
						function(data) {
							ajaxRequest(data, prevPage);
						}, 'json');
				}
			} else if (index == 2) {
				if (nextPage <= pageCount) {
					$.ajax({
						url : "indexServlet",
						data : "currentPage=" + nextPage,
						type : 'post',
						dataType : 'json',
						success : function(data) {
							ajaxRequest(data, nextPage);
						}
					});
				}
			}
			else
				$.post("indexServlet", "currentPage=" + pageCount,
					function(data) {
						ajaxRequest(data, pageCount);
					}, 'json');
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
	$('.goods_pages li').click(function(){
		$('body').scrollTop($('.first_walls').offset().top);
	})
	
});