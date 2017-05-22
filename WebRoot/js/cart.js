$(document).ready(function(){
              var height_Items = $(".goodsItem").length * 130;
              $(".cart_page").height(height_Items + $(".cart_page").height() + "px");
             
             $(".goods_count").each(function(index){
                $(this).find("span").first().click(function() {
                  if (parseInt($(".goods_count").eq(index).find("span").eq(1).find("input").val()) > 1)
                        $(".goods_count").eq(index).find("span").eq(1).find("input").val(
                                    parseInt($(".goods_count").eq(index).find("span").eq(1).find("input").val()) - 1);
                 });
                      
              });
             
             $(".goods_count").each(function(index){
                $(this).find("span").last().click(function() {
                        $(".goods_count").eq(index).find("span").eq(1).find("input").val(
                                    parseInt($(".goods_count").eq(index).find("span").eq(1).find("input").val()) + 1);
                 });
                      
              });
              
              $(".goods_count").each(function(index){
                    $(this).find("input").blur(function() {
                        if(parseInt($(this).val()) <= 0 ||
                                !$(this).val().match(/^[0-9]*$/g) || $(this).val() == "") {
                            $(this).val(1);
                        }
                        
                         while ($(this).val().match(/^0/g)) {
                            $(this).val($(this).val().substring(1));
                         }
                     });
              });
              
              $(".goodsItem").each(function(index){
                    $(this).find("input").blur(function() {
                        var price =  parseInt($(".goodsItem").eq(index).find("span.goods_price").text());                        
                        var count = parseInt($(".goodsItem").eq(index).find("input[name=count]").val());
                         $(".goodsItem").eq(index).find("li.goods_price span").text(price * count);
                   });
                    
                   $(this).find(".goods_count span").not("[type=text]").click(function() {
                        var price =  parseInt($(".goodsItem").eq(index).find("span.goods_price").text());                        
                        var count = parseInt($(".goodsItem").eq(index).find("input[name=count]").val());
                         $(".goodsItem").eq(index).find("li.goods_price span").text(price * count);
                   });
              });
              
              $("li.goods_price span").each(function(index){
                  var price = parseInt($("span.goods_price").eq(index).text());
                  var count = parseInt($(".goods_count input[name=count]").eq(index).val());
                  $(this).text(price * count);
              });
              
              
              
              $(".selectAll[type=checkbox]").each(function(index){
                 $(this).change(function() {
                 if ($(this).prop("checked")) {
                    $(".selectOne[type=checkbox]").prop("checked",true);
                    $(this).prop("checked",true);
                    $(".selectAll[type=checkbox]").prop("checked",true);
                } else {
                    $(".selectOne[type=checkbox]").prop("checked", false);
                    $(this).prop("checked",false);
                    $(".selectAll[type=checkbox]").prop("checked",false);
                    
                }
                });  
              });
              
              $(".selectOne").each(function(index){
                   $(".goodsItem").eq(index).find("input").blur(totalCount);
                   $(".goodsItem").eq(index).find("input").blur(amount);
                    
                   $(".goodsItem").eq(index).find(".goods_count span").not("[type=text]").click(totalCount);
                   $(".goodsItem").eq(index).find(".goods_count span").not("[type=text]").click(amount);
                    
                    $(".selectOne").change(totalCount); 
                    $(".selectOne").change(amount); 
                    
                    $(".selectAll").change(totalCount);
                   $(".selectAll").change(amount);
                    
                    function totalCount(){
                        var  count = 0;
                        $(".selectOne").each(function(index){
                            if ($(this).prop('checked') == true) {
                                count += parseInt($(".goodsItem").eq(index).find("span.goods_price").text()) * 
                                parseInt($(".goodsItem").eq(index).find(".goods_count input[name=count]").val());
                            }
                        });
                         $(".pay_content .count span").text(count);
                   }
                   
                   function amount() {
                        var  amount = 0;
                        $(".selectOne").each(function(index){
                            if ($(this).prop('checked') == true) {
    
                                amount += 
                            parseInt($(".goodsItem").eq(index).find(".goods_count input[name=count]").val());
                            }
                        });
                         $(".pay_content .amount span").text(amount);
                   }
              });
              
     });