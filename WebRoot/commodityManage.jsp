<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"> 
    <title>My JSP 'commodityManage.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/commodityManage.css">
	<script src="js/commodityManage.js"></script>
	<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
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
	                <h1>商品管理</h1>
	         </div>
	         <div class="commodity1">
	                <input type="button" value="上传商品" onclick="add()">
	         </div>
	         <div class="commodity1">
	                <input type="button" value="管理订单" onclick="orders()">
	         </div>
        </div>
    </div>
    <div class="menu_block">
        <div class="category_menu">
            <ul>
                <li><a href="/MyShopping/CommodityManageServlet?categoryId=1">水果蔬菜</a></li>
                <li><a href="/MyShopping/CommodityManageServlet?categoryId=2">饼干零食</a></li>
                <li><a href="/MyShopping/CommodityManageServlet?categoryId=3">新鲜肉类</a></li>
<<<<<<< .mine
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
  	<div class="describe">
  		<ul>
  			<li><h3>商品图片</h3></li>
  			<li><h3>商品ＩＤ</h3></li>
  			<li><h3>商品名称</h3></li>
  			<li><h3>商品价格</h3></li>
  			<li><h3>操　　作</h3></li>
  		</ul>
  	</div>
  	<div class="goods_walls">
  		<c:forEach items="${Goods }" var ="result">
	  		<div class="first_walls">
	  			<ul>
	  				<li><img src="${result.goodsPic }" /></li>
	  				<li><h3>${result.goodsId }</h3></li>
	  				<li><h3>${result.goodsName }</h3></li>
	  				<li><h3>￥${result.goodsPrice }</h3></li>
	  				<li>
	  					<span><input type='button' value='编辑商品' onclick="modify(this)"></span>
	  					<span><input type='button' value='删除商品' onclick="deleteById(this)"></span>
					</li>
	  			</ul>
	  		</div>
  		</c:forEach>
  	</div>
  </body>
</html>
=======
                <li><a href="/MyShopping/CommodityManageServlet?categoryId=7">清洁用品</a></li>
                <li><a href="/MyShopping/CommodityManageServlet?categoryId=8">电子电器</a></li>
                <li><a href="/MyShopping/CommodityManageServlet?categoryId=9">美容洗护</a></li>
                <li><a href="/MyShopping/CommodityManageServlet">全部商品</a></li>
            </ul>
        </div>
    </div>
  	<div class="describe">
  		<ul>
  			<li><h3>商品图片</h3></li>
  			<li><h3>商品ＩＤ</h3></li>
  			<li><h3>商品名称</h3></li>
  			<li><h3>商品价格</h3></li>
  			<li><h3>操　　作</h3></li>
  		</ul>
  	</div>
  	<div class="goods_walls">
  		<c:forEach items="${Goods }" var ="result">
	  		<div class="first_walls">
	  			<ul>
	  				<li><img src="${result.goodsPic }" /></li>
	  				<li><h3>${result.goodsId }</h3></li>
	  				<li><h3>${result.goodsName }</h3></li>
	  				<li><h3>￥${result.goodsPrice }</h3></li>
	  				<li>
	  					<span><input type='button' value='编辑商品' onclick="modify(this)"></span>
	  					<span><input type='button' value='删除商品' onclick="deleteById(this)"></span>
					</li>
	  			</ul>
	  		</div>
  		</c:forEach>
  	</div>
  </body>
</html>



>>>>>>> .theirs
