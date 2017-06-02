<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>商城</title>
	<link rel='stylesheet' href='css/indexJsp.css'>
    <script src="js/jquery-3.1.1.min.js"></script>
    <script src="js/index.js"></script>
	 <script>
    	function searchGoods(){
    		if ($("#searchName").val() != null && $("#searchName").val() != "")
	    		window.location.href = "/MyShopping/goodsServlet?searchName="+$("#searchName").val();
    	}
    </script>
  </head>
  <body>
    <div class="index_top">
   		<div class="top_content">
	        <div class="top_menu">
	            <ul>
	                <c:choose>
						<c:when test="${sessionScope.customer != null }">
							<li><a>${sessionScope.customer.customerName }先生</a>
								<a class="logout">注销</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="login.html">账户登录</a></li>
						</c:otherwise>
					</c:choose>
	                <li><a href="register.html">注册</a></li>
	                <li><a href="#">向导</a></li>
	                <li><a href="#">博客</a></li>
	            </ul>
	        </div>
	        <div class="top_phone">
	        	<span><a href='ordersServlet?op=list'>我的订单</a></span>
	            <span><a href='cartServlet?op=list'>购物车</a></span>
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
	                <a class="search_btn" onclick="searchGoods()">搜索</a>
	            </div>
	       </div>
	       <div class="cart">
	       		<a href="cartServlet?op=list">
	       			<img src="image/cart.jpg">
	       			<span style="color:#000">我的购物车</span>
	       		</a>
	       </div>
        </div>
    </div>
    <div class="menu_block">
        <div class="category_menu">
            <ul>
                <li><a href="#">水果蔬菜</a></li>
                <li><a href="#">饼干零食</a></li>
                <li><a href="#">新鲜肉类</a></li>
                <li><a href="#">图书音像</a></li>
                <li><a href="#">纸巾洗漱</a></li>
                <li><a href="#">沐浴用品</a></li>
                <li><a href="#">清洁用品</a></li>
                <li><a href="#">电子电器</a></li>
                <li><a href="#">清洁用品</a></li>
                <li><a href="#">电子电器</a></li>
            </ul>
        </div>
    </div>
    <div class="picture_block">
    	<div class="w">
	        <div class="menu_classtify">
	            <ul>
	                <li><a href="#">水果蔬菜</a></li>
	                <li><a href="#">饼干零食</a></li>
	                <li><a href="#">新鲜肉类</a></li>
	                <li><a href="#">图书音像</a></li>
	                <li><a href="#">纸巾洗漱</a></li>
	                <li><a href="#">沐浴用品</a></li>
	                <li><a href="#">电子电器</a></li>
	            </ul>
	        </div>
	        <div class="picture">
	            <ul id="picture_item">
	                <li><img src='image\butterfly.jpg'></li>
	                <li><img src='image\tiger.jpg'></li>
	                <li><img src='image\water.jpg'></li>
	                <li><img src='image\desert.jpg'></li>
	                <li><img src='image\flower.jpg'></li>
	            </ul>
	            <a href='javascript:void(0)' class="prev"></a>
	             <a href='javascript:void(0)' class="next"></a>
	        </div>
        </div>
	</div>
    <div class="good_content">
    	<div class="w">
	        <div class="info">
	           <div class="purchase_info">
	                 <p>
	                   	  热门商品
	                 </p>
	                 <p>
	                     GET WHAT YOU WANT！
	                 </p>
	             </div>	                
	                 <ul>
	                 	 <c:forEach var="item" items="${goodsHits }">
		                     <li>
		                         <a>
		                             <div class="stores_img">
		                                 <img src="${item.goodsPic }">
		                             </div>
		                             <div class="stores_info">
		                                 <p>
		                                   	 ${item.goodsName }
		                                 </p>
		                                 <p>
		                                  	   销量 ${item.goodsSales } 共${item.goodsStock }件商品
		                                 </p>
		                             </div>
		                         </a>
		                     </li>
		                   </c:forEach>
	                 </ul>
	              <div class="mod">
	              	 <div class="mod_pay">
	              	 	<h4>
	              	 		<span>付款方式</span>
	              	 	</h4>
	              	 	<ul>
	              	 		<li>支付宝支付</li>
	              	 		<li>微信支付</li>
	              	 		<li>银行卡支付</li>
	              	 		<li>QQ钱包</li>
	              	 		<li>PayPal</li>
	              	 	</ul>
	              	 </div>
	              	  <div class="mod_resposibility">
	              	 	<h4>
	              	 		<span>消费者服务</span>
	              	 	</h4>
	            		<ul>
	              	 		<li>退货退款服务</li>
	              	 		<li>服务中心</li>
	              	 		<li>联系客服</li>
	              	 		<li>更多特色服务</li>
	              	 		
	              	 	</ul>
	              	 </div>
	              </div>
	       </div>
	       <div class='goods_walls'>
	          <ul>
	              <li>
	                   <div class='first_walls'>
	                       <ul>
	                          <li>
	                          <c:forEach items="${Goods}" var="result">
	                               <div class="apple">
	                               		<input type="hidden" name="goodsId" value="${result.goodsId }"/>
	                                   <div class='apple_img'>
	                                       <a>
	                                           <img src="${result.goodsPic }">
	                                           <div class="price">
	                                               <strong>
	                                                   <em>￥</em>
	                                                   <i>${result.goodsPrice}</i>
	                                               </strong>
	                                           </div>
	                                           <p>
	                                              ${result.goodsName } ${result.goodsDesc }
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
	                               <a>
	                                   <span>首页</span>
	                               </a>
	                           </li>
	                            <li class="a2">
	                               <a>
	                                   <span>上一页</span>
	                               </a>
	                           </li>	                          
	                            <li class="a3">
	                               <a>
	                               		<span>下一页</span>
	                               </a>
	                           </li>
	                            <li>
	                               <a>
	                                   <span >尾页</span>
	                               </a>
	                           </li>	                           
	                       </ul>
	                       <div class="pageCount">
	                       		当前第<span>${pageBean.currentPage }</span>页&nbsp;&nbsp;&nbsp;&nbsp;
	                           	共<span>${pageBean.pageCount }</span>页
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
