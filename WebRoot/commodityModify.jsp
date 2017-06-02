<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'commodityModify.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/commodityModify.css">
	<script src="js/commodityManage.js"></script>

  </head>
  
    <body>
    <div class="index_top">
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
	        	<span><a href='#'>我的订单</a></span>
	            <span><a href='#'>购物车</a></span>
	            <span><a href='#'>请联系我们</a></span>
	        </div>
	    </div>
    </div>
    <div class="top_next">
        <div class="logo_search">
            <div class="logo">
                <img src="image/logo.png">
            </div>
	        <div class="commodity">
	                <h1>商品编辑</h1>
	         </div>
        </div>
    </div>
    <div class="menu_block">
        <div class="category_menu">
            <ul>
                <li><a href="/MyShopping/CommodityManageServlet?categoryId=1">水果蔬菜</a></li>
                <li><a href="/MyShopping/CommodityManageServlet?categoryId=2">饼干零食</a></li>
                <li><a href="/MyShopping/CommodityManageServlet?categoryId=3">新鲜肉类</a></li>
                <li><a href="/MyShopping/CommodityManageServlet?categoryId=4">图书音像</a></li>
                <li><a href="/MyShopping/CommodityManageServlet?categoryId=5">纸巾洗漱</a></li>
                <li><a href="/MyShopping/CommodityManageServlet?categoryId=6">沐浴用品</a></li>
                <li><a href="/MyShopping/CommodityManageServlet?categoryId=7">清洁用品</a></li>
                <li><a href="/MyShopping/CommodityManageServlet?categoryId=8">电子电器</a></li>
                <li><a href="/MyShopping/CommodityManageServlet?categoryId=9">美容洗护</a></li>
                <li><a href="/MyShopping/CommodityManageServlet">全部商品</a></li>
            </ul>
        </div>
    </div>
  	
  	<div class="goods_walls">
  		<form action='/MyShopping/CommoditySaveServlet?goodsId=${Goods.goodsId} ' method="post">
  			<ul>
  			<li>商品ＩＤ： ${Goods.goodsId}</li>
  			<li>商品分类：
  				<select name="categoryId">
  					<option value="-1">选择商品分类</option>
  					<option value="1">水果蔬菜</option>
  					<option value="2">饼干零食</option>
  					<option value="3">新鲜肉类</option>
  					<option value="4">图书音像</option>
  					<option value="5">纸巾洗漱</option>
  					<option value="6">沐浴用品</option>
  					<option value="7">清洁用品</option>
  				</select>
  			</li>
  			<li>
  				商品名字： <input type="text" name="goodsName" value="${Goods.goodsName }">
  			</li>
  			<li>
  				商品价格： <input type="text" name="goodsPrice"  value="${Goods.goodsPrice }">
  			</li>
  			<li>
  				商品库存： <input type="text" name="goodsStock"  value="${Goods.goodsStock }">
  			</li>
  			<li>
  				修改时间： <input type="date" name="goodsShelfTime">
  			</li>
  			<li>
  				商品描述： <textarea rows="3" cols="25" name="goodsDesc">${Goods.goodsDesc }</textarea>
  			</li>
  			<li>
  				<input type="submit" value="修改">
  				<input type="reset" value="重置">
  			</li>
  			</ul>
  		</form>
  	</div>
  </body>
</html>
