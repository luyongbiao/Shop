$(document).ready(function(){
      $(".add_order a span").click(function() {
    	  	var strc = "";
    	  	$("input[name=cartDetailId]").each(function(){
    	  		//alert($(this).val());
    	  			strc+= "&checked=" + $(this).val();
    	  	});
    	  	if(strc == "") {
    	  		return;
    	  	}
    	  	strc = strc.substring(1);
    	  	location.href = 'ordersDetailServlet?' + strc + '&op=' + 'save';
    	});
      });