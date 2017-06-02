function updateStatus(obj) {
	var id = obj.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.querySelector(".cart_header .product span:last-child b").innerHTML;
	window.location.href="/MyShopping/UpdateStatusServlet?orderId="+id;
}