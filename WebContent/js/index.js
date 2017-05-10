$(function(){
          $(".picture .prev, .picture .next").hide();
          var bb = $("#picture_item li:last");
          var aa = $("#picture_item li:first");
          setInterval(function(){
           if(bb.is(":visible")){
            aa.fadeIn(1000).addClass("in");
            bb.hide();
           }else{
            $("#picture_item li:visible").addClass("in");
            $("#picture_item li.in").next().fadeIn(1000);
            $("#picture_item li.in").fadeOut(1000).removeClass("in");
           }
          },5000);
          
          $(".picture").mouseover(function() {
            $(".picture .prev, .picture .next").show();
          });
          
          $(".picture").mouseout(function() {
            $(".picture .prev, .picture .next").hide();
             
          });
          
          $(".picture .next").click(function() {
            if(bb.is(":visible")){
                aa.fadeIn(1000).addClass("in");
                bb.hide();
               }else{
                $("#picture_item li:visible").addClass("in");
                $("#picture_item li.in").next().fadeIn(1000);
                $("#picture_item li.in").fadeOut(1000).removeClass("in");
                 }
          });
          
          $(".picture .prev").click(function() {
            if(aa.is(":visible")){
                bb.fadeIn(1000).addClass("in");
                aa.hide();
               }else{
                $("#picture_item li:visible").addClass("in");
                $("#picture_item li.in").prev().fadeIn(1000);
                $("#picture_item li.in").fadeOut(1000).removeClass("in");
                 }
          });
          
           $(".picture .prev").click(function() {
            if(aa.is(":visible")){
                bb.fadeIn(1000).addClass("in");
                aa.hide();
               }else{
                $("#picture_item li:visible").addClass("in");
                $("#picture_item li.in").prev().fadeIn(1000);
                $("#picture_item li.in").fadeOut(1000).removeClass("in");
                 }
          });
           
          $(".goods_walls .goods_pages a").click(function() {
             $(".goods_walls .goods_pages a").not(this).css("background-color", "#FFF").css("color","#000");
             $(this).css("background-color","#FF4500").css("color","#fff");
          });
          
          $(".goods_walls .goods_pages a").mouseover(function() {
             $(this).css("border-color","#FF8C00");
          });
          
           
          $(".goods_walls .goods_pages a").mouseout(function() {
             $(this).css("border-color","#ededed");
          });
            
          $(".apple_img").mouseover(function() {
             $(this).css("border-color","#FF8C00");
          });
            
          $(".apple_img").mouseout(function() {
             $(this).css("border-color","#ededed");
          });
          
          setInterval(function(){
                var img = $(".promotion_img");
                img.animate({height:'200px',opacity:'0.4'},1000);
                img.animate({width:'400px',opacity:'0.8'},1000);
                img.animate({height:'200px',opacity:'0.4'},1000);
                img.animate({width:'400px',opacity:'0.8'},2000);
            
          },1000);
          
 });