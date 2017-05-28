$(function() {
	$(".form_header span").first().click(function() {
		$(this).css("background-color", "#fff");
		$(this).css("border-bottom", "1px solid #fff");
		$(".form_header span").last().css("background-color", "#f5f5f5");
		$(".form_header span").last().css("border-bottom", "none");
		$(".admin_content").css("display", "none");
		$(".customer_content").css("display", "block");
	});

	$(".form_header span").last().click(function() {
		$(this).css("background-color", "#fff");
		$(this).css("border-bottom", "1px solid #fff");
		$(".form_header span").first().css("background-color", "#f5f5f5");
		$(".form_header span").first().css("border-bottom", "none");
		$(".admin_content").css("display", "block");
		$(".customer_content").css("display", "none");
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
		var customerName = $(".customer_content input[name=customerName]").val();
		var customerPassword = $(".customer_content input[name=customerPassword]").val();
		var comfirmPassword = $(".customer_content input[name=comfirmPassword]").val();
		var customerGender;

		$(".customer_content input[name=customerGender]").each(function(index, item) {
			if ($(this).prop("checked"))
				customerGender = $(this).val();
		});

		var customerAge = $(".customer_content input[name=customerAge]").val();
		var customerMobilePhone = $(".customer_content input[name=customerMobilePhone]").val();
		var customerHomePhone = $(".customer_content input[name=customerHomePhone]").val();

		if (customerName == null || customerName == "") {
			$(".customer_content input[name=customerName] + .error").css("display", "block");
			return;
		}
		if (customerPassword == null || customerPassword == "") {
			$(".customer_content input[name=customerPassword] + .error").css("display", "block");
			return;
		}
		if (customerPassword != comfirmPassword) {
			$(".customer_content input[name=comfirmPassword] + .error").css("display", "block");
			return;
		}
		if (customerAge == null || customerAge == "") {
			$(".customer_content input[name=customerAge] + .error").css("display", "block");
			return;
		}
		if (customerMobilePhone == null || customerMobilePhone == "") {
			$(".customer_content input[name=customerMobilePhone] + .error").css("display", "block");
			return;
		}
		if (customerHomePhone != customerHomePhone) {
			$(".customer_content input[name=customerHomePhone] + .error").css("display", "block");
			return;
		}

		$.post("customerServlet",
			"{customerName:'" + customerName + "',customerPassword:'" + customerPassword +
			"',customerGender:'" + customerGender + "',customerAge:" + customerAge
			+ ",customerMobilePhone:'" + customerMobilePhone +
			"',customerHomePhone:'" + customerHomePhone +
			"',comfirmPassword:'" + comfirmPassword +
			"',op:register}",
			function(data) {
				if (data == "用户名已存在") {
					$(".customer_content input[name=customerName] + .error").text(data);
					$(".customer_content input[name=customerName] + .error").css("display", "block");
				} else
					setTimeout(location.href = "login.html", 1000);
			});
	});

	$(".admin_content td[colspan='2'] a").click(function() {
		var adminName = $(".admin_content input[name=adminName]").val();
		var adminPassword = $(".admin_content input[name=adminPassword]").val();
		var comfirmPassword = $(".admin_content input[name=comfirmPassword]").val();
		var adminGender;

		$(".admin_content input[name=adminGender]").each(function(index, item) {
			if ($(this).prop("checked"))
				adminGender = $(this).val();
		});

		var adminMobilePhone = $(".admin_content input[name=adminMobilePhone]").val();

		if (adminName == null || adminName == "") {
			$(".admin_content input[name=adminName] + .error").css("display", "block");
			return;
		}
		if (adminPassword == null || adminPassword == "") {
			$(".admin_content input[name=adminPassword] + .error").css("display", "block");
			return;
		}
		if (adminPassword != comfirmPassword) {
			$(".admin_content input[name=comfirmPassword] + .error").css("display", "block");
			return;
		}
		if (adminMobilePhone == null || adminMobilePhone == "") {
			$(".admin_content input[name=adminMobilePhone] + .error").css("display", "block");
			return;
		}

		$.post("adminServlet",
			"{adminName:'" + adminName + "',adminPassword:'" + adminPassword +
			"',adminGender:'" + adminGender
			+ "',adminMobilePhone:'" + adminMobilePhone +
			"',comfirmPassword:'" + comfirmPassword +
			"',op:register}",
			function(data) {
				if (data == "姓名已存在") {
					$(".admin_content input[name=adminName] + .error").text(data);
					$(".admin_content input[name=adminName] + .error").css("display", "block");
				} else
					setTimeout(location.href = "login.html", 1000);
			});
	});
});