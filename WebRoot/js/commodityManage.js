function getId(obj){
			var id = obj.parentNode.parentNode.parentNode.childNodes[3].firstChild.innerText;
			return id;
}
function modify(obj){
	var id = getId(obj);
	window.location.href='/MyShopping/CommodityModifyServletServlet?goodsId='+id;
}
function deleteById(obj){
	var id = getId(obj);
	var msg = "您真的确定要删除吗?";
	if(confirm(msg)==true){
		window.location.href="/MyShopping/CommodityDeleteServlet?goodsId="+id;
	}else{
		return false;
	}
}
function add(){
	window.location.href="/MyShopping/addGoods.jsp";
}
function orders(){
	window.location.href="/MyShopping/AllOrdersServlet";
}