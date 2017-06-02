<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
    <title>确认订单信息</title>
    <link rel='stylesheet' href='css/comfirm_order.css'>
    <script src='js/jquery-3.1.1.min.js'></script>
    <script src="js/comfirm_order.js"></script>
    <script>
        $(function(){   
              $("li.goods_price").each(function(index){
                  var price = parseInt($("span.goods_price").eq(index).text());
                  var count = parseInt($(".goods_count").eq(index).text());
                  $(this).children("span").text(price * count);
              });
              
              var  count = 0;
              var amount = 0;
              $(".goodsItem").each(function(index){              
                    count += parseInt($(this).find("span.goods_price").text()) * 
                    parseInt($(this).find(".goods_count").text());
                    amount += parseInt($(this).find(".goods_count").text());
             });
              $(".pay_content .count span").text(count);  
             $(".pay_content .amount span").text(amount);
     });
    </script>
</head>
<body>
    <div class="detail_top">
        <div class="top_content">
            <div class="top_menu">
                <ul>
                    <li><a href="#">账户登录</a></li>
                    <li><a href="#">注册</a></li>
                    <li><a href="#">向导</a></li>
                    <li><a href="#">博客</a></li>
                </ul>
            </div>
            <div class="top_phone">
                <span><a href='#'>我的购物车</a></span>
                <span><a href='#'>请联系我们</a></span>
            </div>
        </div>
    </div>
    <div class="top_next">
        <div class="logo_search">
            <div class="logo">
                <img src="image/logo.png">
            </div>
            <div class="carts_title">
                <span>确认订单信息</span>
            </div>
        </div>
    </div>
    <div class="detail_hr"></div>
    <div class="address_page">
        <div class="w">
            <div class="Caddress">
			<div class="open_new">
				<button class="open_btn">新增地址</button>
			</div>
			<c:forEach items="${address }" var="item">
			<div class="add_mi">
				<input type="hidden" name="addressId" value="${item.customerAddressId }">
				<p style="border-bottom:1px dashed #ccc;line-height:28px;">${item.addressProvince } ${item.addressCity } ${item.addressArea } (${sessionScope.customer.customerName }先生收)</p>
				<p>${item.addressDetail } </p>
				<p style="text-align:right;">手机号码:${sessionScope.customer.customerMobilePhone }</p>
				<p><a class="address_update" href="#">修改</a> <a class="address_delete" href="#">删除</a></p>
			</div>
			</c:forEach>
		</div>
        </div>
    </div>
    <div class="orders_detail">
            <div class="w">
                <div class="comfirm_orders">
                    <span>订单信息</span>
                </div>
            </div>
    </div>
    <div class="cart_page">
        <div class="w">
            <div class="cart_header">
                <ul>
                    <li class="product">
                        <span>商品</span>
                    </li>
                    <li>
                        <span>单价</span>
                    </li>
                    <li>
                        <span>数量</span>
                    </li>
                    <li>
                        <span>小计</span>
                    </li>
                </ul>
            </div>
			<ul>
				<c:forEach items="${map }" var="item">
					<li>
						<div class="goodsItem">
							<input type="hidden" name="cartDetailId"
								value="${item.key.cartDetailId }">
							<ul>
								<li class="product">
									<div class="goodsDetail">
										 <div class="goodsImage">
                                      		 	<a href="#"><img src="${item.value.goodsPic }"></a>
                                   		 </div>
                                   		  <div class="goodsName">
                                      		  	<div class='goodsTitle'>
                                          		 	<a href="#"><span>${item.value.goodsName }</span></a>
                                       			</div>
	                                       	  	<div class="goodsDesc">
	                                           		<span>${item.value.goodsDesc }</span>
	                                       		</div>
                                   		 </div>
									</div> 
								</li>								
								<li>
                               		<span>
                                   		<em>￥</em>
                                   		<span class="goods_price">${item.value.goodsPrice }</span>
                               		</span>
                           		</li>
								<li>
                                   	<span class="goods_count">${item.key.goodsCount }</span>
                          		</li>
								<li class='goods_price'>
	                                <em>￥</em>
	                                <span></span>
	                            </li>
							</ul>
						</div>
					</li>
				</c:forEach>
			</ul>
    	</div>
    </div>
    <div class="orders_id">
        <div class="w">
            <div class='orders_phone'>
               	 联系人：<span>卢勇彪 &nbsp;&nbsp;13232187878</span>
            </div>
        </div>
    </div>
    <div class="pay_page">
        <div class="w">
             <div class="pay_content">
                <ul>
                    <li class="amount">
                        	 已选择<span>0</span>件商品
                    </li>
                    <li class="count">
                      	  总价：<em>¥</em><span>0</span>
                    </li>
                    <li>
                        <div class="add_order">
                          <a href="javascript:void(0)">
                            <span>生成订单</span>
                         </a>
                     	</div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <div class="shade">
		</div>
		
		<div class="shade_content">
			<div class="col-xs-12 shade_colse">
				<button class="btn_remove">x</button>
			</div>
			<div class="nav shade_content_div">
				<div class="col-xs-12 shade_title">
					新增收货地址
				</div>
				<div class="shade_from">
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
									<input type="text" name="city">
									<span class="error">城市不能为空</span>
								</td>
							</tr>
							<tr>
								<td class="t">县/区</td>
								<td>
									<input type="text" name="area">
									<span class="error">县/区不能为空</span>
								</td>
							</tr>
							<tr>
								<td class="t">详细地址</td>
								<td>
									<textarea rows="4" cols="40" name="addressDetail" style="font-size:15px;padding:5px"></textarea>
									<span class="error">请输入详细地址</span>
								</td>
							</tr>
							<tr>
								<td class="t"></td>
								<td style="line-height:18px">
									<input type="checkbox" name="addressChecked" style="width:40px;" value="1">设为默认地址
								</td>
							</tr>
						</tbody>
					</table>
					<input type="hidden" name='customerAddressId'/>
					<div class="col-xs-12">
							<input class="btn_remove" type="button" id="" onclick="javascript:onclick_close();" value="取消" />
							<input type="button" class="sub_set" id="" value="提交" />
					</div>
				</div>
			</div>
		</div>
		<input type="hidden" id="bubu" value="1">
</body>
</html>