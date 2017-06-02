<%@ page language="java" import="java.util.*" import="org.bqj.shopping.entity.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>"> 
    <title>商城</title>
 
    <link rel='stylesheet' href='css/good.css'>
    <script src="js/jquery-3.1.1.min.js"></script>
    <script src="js/index.js"></script>
    <script>
    	function searchGoods(){
    		var searchName =document.getElementById('searchName').value;
    		window.location.href = "/MyShopping/goodsServlet?searchName="+searchName;
    	}
    </script>
	<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
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
            <div class="search_content">
	            <div class="search">
	                <input type="text" id="searchName">
	                <a class="search_btn"  onclick="searchGoods()">搜索</a>
	            </div>
	       </div>
	       <div class="cart">
	       		<a>
	       			<img src="image/cart.jpg">
	       			<span>我的购物车</span>
	       		</a>
	       </div>
        </div>
    </div>
    <div class="menu_block">
        <div class="category_menu">
            <ul>
                <li><a href="/MyShopping/goodsCategoryServlet?categoryId=1">水果蔬菜</a></li>
                <li><a href="/MyShopping/goodsCategoryServlet?categoryId=2">饼干零食</a></li>
                <li><a href="/MyShopping/goodsCategoryServlet?categoryId=3">新鲜肉类</a></li>
                <li><a href="/MyShopping/goodsCategoryServlet?categoryId=4">图书音像</a></li>
                <li><a href="/MyShopping/goodsCategoryServlet?categoryId=5">纸巾洗漱</a></li>
                <li><a href="/MyShopping/goodsCategoryServlet?categoryId=6">沐浴用品</a></li>
                <li><a href="/MyShopping/goodsCategoryServlet?categoryId=7">清洁用品</a></li>
                <li><a href="#">电子电器</a></li>
                <li><a href="#">清洁用品</a></li>
                <li><a href="#">电子电器</a></li>
            </ul>
        </div>
    </div>   
    <div class="good_content">
    	<div class="w">
	       <div class='goods_walls'>
	          <ul>
	              <li>
	                   <div class='first_walls'>
	                       <ul>
	                          <li>
	                          	<c:forEach items="${goods}" var="goods">
	                               <div class="apple">
	                                   <div class='apple_img'>
	                                       <a>
	                                           <img src="${goods.goodsPic}">
	                                           <div class="price">
	                                               <strong>
	                                                   <em>￥</em>
	                                                   <i>${goods.goodsPrice}</i>
	                                               </strong>
	                                           </div>
	                                           <p>
	                                              ${goods.goodsName}  ${goods.goodsDesc} 
	                                           </p>
	                                       </a>
	                                   </div>
	                               </div>
	                               </c:forEach>
	                          </li> 
	                       </ul>
	                   </div>
	             </li>
	           </ul>
	               <div class="pages_walls">
	                   <div class="goods_pages">
	                       <ul>
	                           <li>
	                               <a href="javascript:void(0)">
	                                   <span >上一页</span>
	                               </a>
	                           </li>
	                           <li>
	                                <a href="javascript:void(0)">
	                                   <span>1</span>
	                               </a>
	                           </li>
	                            <li>
	                                <a href="javascript:void(0)">
	                                   <span>2</span>
	                               </a>
	                           </li>
	                            <li>
	                               <a href="javascript:void(0)">
	                                   <span>3</span>
	                               </a>
	                           </li>
	                            <li>
	                               <a href="#">
	                                   <span>...</span>
	                               </a>
	                           </li>
	                            <li>
	                               <a href="#">
	                                   <span>下一页</span>
	                               </a>
	                           </li>
	                       </ul>
	                       <div class="pageCount">
	                           <span>共10页</span>
	                       </div>
	                   </div>
	               </div>
	           </div>
	        </div>
        </div>
    <div class="index_end">
    <div class="page_end">
          <p>
            <span>
              <a  href="javascript:void(0)">关于我们</a></span>
            <span>
              <a href="javascript:void(0)">合作伙伴</a></span>
            <span>
              <a href="javascript:void(0)">廉正举报</a></span>
            <span>
              <a href="javascript:void(0)">联系客服</a></span>
            <span>
              <a href="javascript:void(0)">联系我们</a></span>
            <span>
              <a href="javascript:void(0)">法律声明及隐私权政策</a></span>
            <span>
              <a href="javascript:void(0)">知识产权</a></span>
          </p>
          <p>
            <span>
              Copyright © 2016 - 2017  SC.com 版权所有
              <br>
              消费者维权热线：4006067733
              <a class='permi_for_operation' href="javasscript:void(0)">经营证照</a>
            </span>
          </p>
        </div>       
    </div>
</html>
