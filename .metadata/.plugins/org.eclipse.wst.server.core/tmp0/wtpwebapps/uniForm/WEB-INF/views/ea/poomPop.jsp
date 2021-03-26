<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>결재선 지정</title>
      <script type="text/javascript"
            src="https://code.jquery.com/jquery-1.11.0.min.js"></script>
            <meta name="viewport" content="width=device-width, initial-scale=1.0
      , maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densityDpi=medium-dpi">
		<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.0.min.js"></script>
		

		<!-- Reset CSS --> 
		<link rel="stylesheet" href="/cssExample/css/reset_normalize.css" media="all">
		<!-- Design CSS -->
		<link rel="stylesheet" href="/cssExample/css/style_common.css" media="all">
		<link rel="stylesheet" href="/cssExample/css/style_contents.css" media="all">
		<!-- Layout CSS -->
		<link rel="stylesheet" href="/cssExample/css/layout_main.css" media="all">
		<link rel="stylesheet" href="/cssExample/css/layout_sub.css" media="all">
		<link rel="stylesheet" href="/cssExample/css/layout_responsive.css" media="all">
		<!-- Script --> 
		<script src="/cssExample/js/jquery.js"></script>
		<script src="/cssExample/js/jquery.ui.js"></script>
		<script src="/cssExample/js/jquery.bxslider.js"></script>
		<script src="/cssExample/js/common.js"></script>  
		<script src="/cssExample/js/custom.js"></script>
		<script src="/cssExample/js/main2.js"></script>  
		<script src="/cssExample/js/masonry.pkgd.js"></script>
      <script>
         $(document).ready(function(){
            $("#poom_btn").click(function(){
               console.log("poom_btn 클릭");
               console.log("poom.val > " + $("#poom").val());
               if($("#poom").val()=="fullLine"){
                  console.log("전체라인");
                  $("#ea_linename").val("품의");
               }
               if($("#poom").val()=="arbitraryLine"){
                  console.log("전결라인");
                  $("#ea_linename").val("품의전결");
               }
               
               opener.linename1($("#ea_linename").val());
               window.close();
            });
         });
      </script>
      
   </head>
   <body>
      <form name="poomForm" id="poomForm" >
         <div align="center">
            <br><br>
            <select name="poom" id="poom" >
               <option value="fullLine">품의서 라인</option>
               <option value="arbitraryLine">품의서 전결 라인</option>
            </select>
            <input type="button" class="grey_btn" style="height:17pt; name="reset_btn" id="reset_btn" value="취소">
            <input type="button" class="blue_btn" style="height:17pt; name="poom_btn" id="poom_btn" value="선택">
            <input type="hidden" name="ea_linename" id="ea_linename">            
         </div>
      </form>
   </body>
</html>