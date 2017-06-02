<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>地址</title>
<link rel='stylesheet' href='css/address.css'>
<script src='js/jquery-3.1.1.min.js'></script>
<script>
	$(function() {
		$(".customer_content option[value=${customerAddress.addressProvince }]").attr("selected",true);
		if (${customerAddress.addressChecked} == 1)
			$(".customer_content input[type=checkbox]").attr("checked", true);
		
		if($(".customer_content select[name=addressProvince]").val() == "北京市" ||
			$(".customer_content select[name=addressProvince]").val() == "上海市" ||
			$(".customer_content select[name=addressProvince]").val() == "重庆市" ||
			$(".customer_content select[name=addressProvince]").val() == "天津市") {
				$(".customer_content input[name=city]").attr("disabled", true);
			}
		
		var customerAddressId = ${customerAddress.customerAddressId};
		
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
					"customerAddressId=" + customerAddressId + "&addressProvince=" + addressProvince + "&addressCity=" + addressCity + "&addressArea=" 
						+ addressArea + "&addressDetail=" + addressDetail + "&op=update&addressChecked=" + addressChecked,
					function(data) {
						setTimeout(location.href = "addressServlet?op=list", 1000);
				});
		else
			$.post("addressServlet",
					"customerAddressId=" + customerAddressId + "&addressProvince=" + addressProvince + "&addressArea=" 
						+ addressArea + "&addressDetail=" + addressDetail + "&op=update&addressChecked=" + addressChecked,
					function(data) {
						setTimeout(location.href = "addressServlet?op=list", 1000);
			});
		});
	});
</script>
<script src='js/addressUpdate.js'></script>
</head>
<body>
	<div class="register_head">
		<div class="w">
			<div class="head_logo">
				<img src="image/logo.png">
			</div>
			<div class="head_login">
				<span>欢迎光临</span>
			</div>
		</div>
	</div>
	<div class="head_hr"></div>
	<div class="register_form">
		<div class="w">
			<div class="shadow"></div>
			<input type="hidden" name="op" value="register">
			<div class="form_content">
				<div class="form_header">
					<span class="customer_login">修改地址</span>
					<a href="indexServlet">前往首页</a>
				</div>
				<div class=customer_content>
					<table>
						<tbody>
							<tr>
								<td class="t">省份/直辖市</td>
								<td>
									<select name="addressProvince" style="width:180px;height:30px;font-size:18px;">
										<option value="北京市">北京市
										<option value="上海市">天津市
										<option value="重庆市">重庆市
										<option value="上海市">上海市
										<option value="内蒙古自治区">内蒙古自治区
										<option value="新疆维吾尔自治区">新疆维吾尔自治区
										<option value="西藏自治区">西藏自治区
										<option value="广西壮族自治区">广西壮族自治区
										<option value="宁夏回族自治区">宁夏回族自治区
										<option value=香港特别行政区>香港特别行政区省
										<option value="澳门特别行政区">澳门特别行政区
										<option value="广东省">广东省
										<option value="云南省">云南省
										<option value="山西省">山西省
										<option value="陕西省">陕西省
										<option value="黑龙江省">黑龙江省
										<option value="河北省">河北省
										<option value="辽宁省">辽宁省
										<option value="吉林省">吉林省
										<option value="江苏省">江苏省
										<option value="浙江省">浙江省
										<option value="安徽省">安徽省
										<option value="福建省">福建省
										<option value="江西省">江西省
										<option value="山东省">山东省
										<option value="河南省">河南省
										<option value="湖北省">湖北省
										<option value="湖南省">湖南省
										<option value="海南省">海南省
										<option value="四川省">四川省
										<option value="贵州省">贵州省
										<option value="甘肃省">甘肃省
										<option value="青海省">青海省
										<option value="台湾省">台湾省
									</select>
								</td>
							</tr>
							<tr>
								<td class="t">市</td>
								<td>
									<input type="text" name="city" value="${customerAddress.addressCity }">
									<span class="error">城市不能为空</span>
								</td>
							</tr>
							<tr>
								<td class="t">县/区</td>
								<td>
									<input type="text" name="area"  value="${customerAddress.addressArea }">
									<span class="error">县/区不能为空</span>
								</td>
							</tr>
							<tr>
								<td class="t">详细地址</td>
								<td>
									<textarea rows="4" cols="40" name="addressDetail" style="font-size:15px;padding:5px">${customerAddress.addressDetail }</textarea>
									<span class="error">请输入详细地址</span>
								</td>
							</tr>
							<tr>
								<td class="t"></td>
								<td style="line-height:18px">
									<input type="checkbox" name="addressChecked" style="width:40px;" value="1">设为默认地址
								</td>
							</tr>
							<tr>
								<td colspan='2'><a>提交</a>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>