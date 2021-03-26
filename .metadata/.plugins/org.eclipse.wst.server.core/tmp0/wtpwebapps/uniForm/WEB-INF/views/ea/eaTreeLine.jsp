<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.uniform.common.info.vo.*" %>
<%
   Object obj1 = request.getAttribute("i_no"); 
   String i_no = (String)obj1;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>결재라인 지정</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0
      , maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densityDpi=medium-dpi"/>
	
	
	
		
    <style type="text/css">
      body { margin:0; padding: 0;}
	ul, ol, li{list-style:none; font-size: 12px;}
	
	/* 트리메뉴 css */
	.tree_box { width:400px; border:1px solid #ccd3d9;margin: 30px auto;}
	.tree_box .title { padding:5px 0 5px 19px ;background:#f8f8f9;border-bottom:1px solid #ccd3d9;}
	.tree_box .title strong {margin-right:12px;}
	.tree_menu {line-height:18px;}
	.tree_menu strong {font-weight:normal;}
	.tree_menu label input {vertical-align:-2px;}
	.tree_menu .depth_1 a {vertical-align:bottom;text-decoration:none;}
	.tree_menu .depth_1 strong {padding-left:19px;background:url(http://cfile26.uf.tistory.com/image/224E6B45569458082AA795) no-repeat 0px 2px;}
	.tree_menu .depth_2 li {margin-top:-2px;background:url(http://cfile9.uf.tistory.com/image/22601F4B569457FF051E7E) no-repeat 5px 0px;}
	.tree_menu .depth_2 li a em {display:inline-block;width:31px;height:11px;background:url(http://cfile27.uf.tistory.com/image/2265AB4B569457FD1306CB) 100% 0;font-size:0;line-height:0;vertical-align:middle;}
	.tree_menu .depth_2 li a em.on {background-position:0 100%;}
	.tree_menu li.last {background:none;}
	.tree_menu li.last {background:none;}
	.tree_menu .depth_3 {display:none;padding-left:23px;}
	.tree_menu .depth_3 li {margin:0;padding:3px 0 0 14px;line-height:1;background:url(http://cfile8.uf.tistory.com/image/2456D34B569457FC14828D) no-repeat 0 0;}
	.tree_menu .depth_3 li a {display:block;padding-left:15px;background:url(http://cfile26.uf.tistory.com/image/216841455694580A1ADE12) no-repeat 0 2px;}
	.msie6 .tree_menu .depth_3 li a {display:inline-block;}
	.tree_menu li.end {background:url(http://cfile23.uf.tistory.com/image/2272CF4B5694580418FF9C) no-repeat 0 0;}
	.form_tree_menu .depth_1 {background:url(http://cfile9.uf.tistory.com/image/22601F4B569457FF051E7E) no-repeat 5px 5px;}
	.form_tree_menu ul.depth_2 li {margin-left:6px;padding-left:27px;background:url(http://cfile25.uf.tistory.com/image/2757834B5694580514C5D6) no-repeat 0 5px;}
   
#preview{
				z-index: 9999;
				position:absolute;
				border:0px solid #ccc;
				background:#333;
				padding:1px;
				display:none;
				color:#fff;
			}
			
.stickytooltip{
box-shadow: 5px 5px 8px #818181; /*shadow for CSS3 capable browsers.*/
-webkit-box-shadow: 5px 5px 8px #818181;
-moz-box-shadow: 5px 5px 8px #818181;
display:none;
position:absolute;
display:none;
border:2px solid black; /*Border around tooltip*/
background:white;
z-index:3000;
}


.stickytooltip .stickystatus{ /*Style for footer bar within tooltip*/
background:black;
color:white;
padding-top:5px;
text-align:center;
font:11px 돋움;
letter-spacing:-1px;
}

input[type='button'] {
    display: block;
    float: right;
    height: 30px;
    padding: 0 10px;
    margin-left: 5px;
    line-height: 27px;
    font-size: 0.9em;
    vertical-align: middle;
}
input.blue_btn {
    min-width: 48px;
	background: #295e9c;
	color: #fff;
	border: 1px solid #333333;
}
input.grey_btn {
	min-width: 48px;
	background: #f3f3f3;
	color: #33333;
	border: 1px solid #d0d0d0;
}
.table_wrap {
	margin-bottom: 5px;
	border-top: 2px solid #565c6b !important;
	border-bottom: 2px solid #565c6b;
}
   
    </style>
    
    <script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
    
   <script type="text/javascript">
   $(document).ready(function () {
   function tree_menu() {
	   // $('.depth_2');
	   $('ul.depth_2 >li > a').click(function(e) {

	     var temp_el = $(this).next('ul');
	     var depth_3 = $('.depth_3');

	     // 처음에 모두 슬라이드 업 시켜준다.
	     depth_3.slideUp(300);
	     // 클릭한 순간 모두 on(-)을 제거한다.// +가 나오도록
	     depth_3.parent().find('em').removeClass('on');

	     if (temp_el.is(':hidden')) {
	       temp_el.slideDown(300);
	       $(this).find('em').addClass('on').html('하위폴더 열림');
	     } else {
	       temp_el.slideUp(300);
	       $(this).find('em').removeClass('on').html('하위폴더 닫힘');
	     }

	     return false;

	   });
	 }
	 if ($('#tree_menu').is(':visible')) {
	   tree_menu();
	 }
	 
	 
	 $(".depth_3").click(function(){
		 var i_nameKr = $(this).children("li").attr("data");
		 alert(">>" + i_nameKr );
          $.ajax({
             url:'/ea/eaLine/' +  i_nameKr + '.uni',
             type:'put',
             headers:{
                   "Content-Type" : "application/json",
                   "X-HTTP-Method-Override" : "PUT"},
                   data:JSON.stringify({
               			 i_nameKr : i_nameKr  }),
                   dataType:'text',
                   error : function(){ //실행 시 오류가 발생하였을 경우
                       alert("시스템 오류 발생, 관리자에게 문의하세요");
                   },
                   success:function(result){
                      console.log("result: " + result);
                      if(result != null){
                    	  $("#person").val(result);                    	  
                      }
                      else if(result == 'FAIL'){

                      }
                   }
                });
          });
	 
	 	$("#check").click(function(){
	 		if(opener.document.getElementById("ea_line1").value == ""){
	 			opener.$("#ea_line1").val($("#person").val());
		 		window.opener.document.getElementById("ea_line1").value=$("#person").val();
		 		alert("1차결재자" + opener.$("#ea_line1").val());
		 		}
	 		else if(opener.document.getElementById("ea_line2").value == ""){
		 		window.opener.document.getElementById("ea_line2").value=$("#person").val();
		 		}
	 		else if(opener.document.getElementById("ea_line3").value == ""){
		 		window.opener.document.getElementById("ea_line3").value=$("#person").val();
		 		window.close();
		 		}
	 	});
	 	
	 	$("#close").click(function(){
	 		window.close();
	 	});
   });
   
   $(document).ready(function() {
       
       var xOffset = 10;
       var yOffset = 30;

       $(document).on("mouseover",".thumbnail",function(e){ //마우스 오버시
			
			$("body").append("<p id='preview'><img src='/common/img/1.jpg'"+ $(this).attr("src") +"' width='100px' /></p>"); //보여줄 이미지를 선언					 
			$("#preview")
				.css("top",(e.pageY - xOffset) + "px")
				.css("left",(e.pageX + yOffset) + "px")
				.fadeIn("fast"); //미리보기 화면 설정 셋팅
		});
		
		$(document).on("mousemove",".thumbnail",function(e){ //마우스 이동시
			$("#preview")
				.css("top",(e.pageY - xOffset) + "px")
				.css("left",(e.pageX + yOffset) + "px");
		});
		
		$(document).on("mouseout",".thumbnail",function(){ //마우스 아웃시
			$("#preview").remove();
		});
		
		$(document).on("mouseover",".thumbnail2",function(e){ //마우스 오버시
			
			$("body").append("<p id='preview'><img src='/common/img/2.jpg'"+ $(this).attr("src") +"' width='100px' /></p>"); //보여줄 이미지를 선언					 
			$("#preview")
				.css("top",(e.pageY - xOffset) + "px")
				.css("left",(e.pageX + yOffset) + "px")
				.fadeIn("fast"); //미리보기 화면 설정 셋팅
		});
		
		$(document).on("mousemove",".thumbnail2",function(e){ //마우스 이동시
			$("#preview")
				.css("top",(e.pageY - xOffset) + "px")
				.css("left",(e.pageX + yOffset) + "px");
		});
		
		$(document).on("mouseout",".thumbnail2",function(){ //마우스 아웃시
			$("#preview").remove();
		});
		
		$(document).on("mouseover",".thumbnail3",function(e){ //마우스 오버시
			
			$("body").append("<p id='preview'><img src='/common/img/3.jpg'"+ $(this).attr("src") +"' width='100px' /></p>"); //보여줄 이미지를 선언					 
			$("#preview")
				.css("top",(e.pageY - xOffset) + "px")
				.css("left",(e.pageX + yOffset) + "px")
				.fadeIn("fast"); //미리보기 화면 설정 셋팅
		});
		
		$(document).on("mousemove",".thumbnail3",function(e){ //마우스 이동시
			$("#preview")
				.css("top",(e.pageY - xOffset) + "px")
				.css("left",(e.pageX + yOffset) + "px");
		});
		
		$(document).on("mouseout",".thumbnail3",function(){ //마우스 아웃시
			$("#preview").remove();
		});
		
		$(document).on("mouseover",".thumbnail4",function(e){ //마우스 오버시
			
			$("body").append("<p id='preview'><img src='/common/img/4.jpg'"+ $(this).attr("src") +"' width='100px' /></p>"); //보여줄 이미지를 선언					 
			$("#preview")
				.css("top",(e.pageY - xOffset) + "px")
				.css("left",(e.pageX + yOffset) + "px")
				.fadeIn("fast"); //미리보기 화면 설정 셋팅
		});
		
		$(document).on("mousemove",".thumbnail4",function(e){ //마우스 이동시
			$("#preview")
				.css("top",(e.pageY - xOffset) + "px")
				.css("left",(e.pageX + yOffset) + "px");
		});
		
		$(document).on("mouseout",".thumbnail4",function(){ //마우스 아웃시
			$("#preview").remove();
		});
		
		$(document).on("mouseover",".thumbnail5",function(e){ //마우스 오버시
			
			$("body").append("<p id='preview'><img src='/common/img/5.jpg'"+ $(this).attr("src") +"' width='100px' /></p>"); //보여줄 이미지를 선언					 
			$("#preview")
				.css("top",(e.pageY - xOffset) + "px")
				.css("left",(e.pageX + yOffset) + "px")
				.fadeIn("fast"); //미리보기 화면 설정 셋팅
		});
		
		$(document).on("mousemove",".thumbnail5",function(e){ //마우스 이동시
			$("#preview")
				.css("top",(e.pageY - xOffset) + "px")
				.css("left",(e.pageX + yOffset) + "px");
		});
		
		$(document).on("mouseout",".thumbnail5",function(){ //마우스 아웃시
			$("#preview").remove();
		});
		
		$(document).on("mouseover",".thumbnail6",function(e){ //마우스 오버시
			
			$("body").append("<p id='preview'><img src='/common/img/6.jpg'"+ $(this).attr("src") +"' width='100px' /></p>"); //보여줄 이미지를 선언					 
			$("#preview")
				.css("top",(e.pageY - xOffset) + "px")
				.css("left",(e.pageX + yOffset) + "px")
				.fadeIn("fast"); //미리보기 화면 설정 셋팅
		});
		
		$(document).on("mousemove",".thumbnail6",function(e){ //마우스 이동시
			$("#preview")
				.css("top",(e.pageY - xOffset) + "px")
				.css("left",(e.pageX + yOffset) + "px");
		});
		
		$(document).on("mouseout",".thumbnail6",function(){ //마우스 아웃시
			$("#preview").remove();
		});
		
		$(document).on("mouseover",".thumbnail7",function(e){ //마우스 오버시
			
			$("body").append("<p id='preview'><img src='/common/img/7.jpg'"+ $(this).attr("src") +"' width='100px' /></p>"); //보여줄 이미지를 선언					 
			$("#preview")
				.css("top",(e.pageY - xOffset) + "px")
				.css("left",(e.pageX + yOffset) + "px")
				.fadeIn("fast"); //미리보기 화면 설정 셋팅
		});
		
		$(document).on("mousemove",".thumbnail7",function(e){ //마우스 이동시
			$("#preview")
				.css("top",(e.pageY - xOffset) + "px")
				.css("left",(e.pageX + yOffset) + "px");
		});
		
		$(document).on("mouseout",".thumbnail7",function(){ //마우스 아웃시
			$("#preview").remove();
		});
		
		$(document).on("mouseover",".thumbnail8",function(e){ //마우스 오버시
			
			$("body").append("<p id='preview'><img src='/common/img/8.jpg'"+ $(this).attr("src") +"' width='100px' /></p>"); //보여줄 이미지를 선언					 
			$("#preview")
				.css("top",(e.pageY - xOffset) + "px")
				.css("left",(e.pageX + yOffset) + "px")
				.fadeIn("fast"); //미리보기 화면 설정 셋팅
		});
		
		$(document).on("mousemove",".thumbnail8",function(e){ //마우스 이동시
			$("#preview")
				.css("top",(e.pageY - xOffset) + "px")
				.css("left",(e.pageX + yOffset) + "px");
		});
		
		$(document).on("mouseout",".thumbnail8",function(){ //마우스 아웃시
			$("#preview").remove();
		});
		
		$(document).on("mouseover",".thumbnail9",function(e){ //마우스 오버시
			
			$("body").append("<p id='preview'><img src='/common/img/9.jpg'"+ $(this).attr("src") +"' width='100px' /></p>"); //보여줄 이미지를 선언					 
			$("#preview")
				.css("top",(e.pageY - xOffset) + "px")
				.css("left",(e.pageX + yOffset) + "px")
				.fadeIn("fast"); //미리보기 화면 설정 셋팅
		});
		
		$(document).on("mousemove",".thumbnail9",function(e){ //마우스 이동시
			$("#preview")
				.css("top",(e.pageY - xOffset) + "px")
				.css("left",(e.pageX + yOffset) + "px");
		});
		
		$(document).on("mouseout",".thumbnail9",function(){ //마우스 아웃시
			$("#preview").remove();
		});
		
		$(document).on("mouseover",".thumbnail10",function(e){ //마우스 오버시
			
			$("body").append("<p id='preview'><img src='/common/img/10.jpg'"+ $(this).attr("src") +"' width='100px' /></p>"); //보여줄 이미지를 선언					 
			$("#preview")
				.css("top",(e.pageY - xOffset) + "px")
				.css("left",(e.pageX + yOffset) + "px")
				.fadeIn("fast"); //미리보기 화면 설정 셋팅
		});
		
		$(document).on("mousemove",".thumbnail10",function(e){ //마우스 이동시
			$("#preview")
				.css("top",(e.pageY - xOffset) + "px")
				.css("left",(e.pageX + yOffset) + "px");
		});
		
		$(document).on("mouseout",".thumbnail10",function(){ //마우스 아웃시
			$("#preview").remove();
		});
		
		$(document).on("mouseover",".thumbnail11",function(e){ //마우스 오버시
			
			$("body").append("<p id='preview'><img src='/common/img/11.jpg'"+ $(this).attr("src") +"' width='100px' /></p>"); //보여줄 이미지를 선언					 
			$("#preview")
				.css("top",(e.pageY - xOffset) + "px")
				.css("left",(e.pageX + yOffset) + "px")
				.fadeIn("fast"); //미리보기 화면 설정 셋팅
		});
		
		$(document).on("mousemove",".thumbnail11",function(e){ //마우스 이동시
			$("#preview")
				.css("top",(e.pageY - xOffset) + "px")
				.css("left",(e.pageX + yOffset) + "px");
		});
		
		$(document).on("mouseout",".thumbnail11",function(){ //마우스 아웃시
			$("#preview").remove();
		});
		
		$(document).on("mouseover",".thumbnail12",function(e){ //마우스 오버시
			
			$("body").append("<p id='preview'><img src='/common/img/12.jpg'"+ $(this).attr("src") +"' width='100px' /></p>"); //보여줄 이미지를 선언					 
			$("#preview")
				.css("top",(e.pageY - xOffset) + "px")
				.css("left",(e.pageX + yOffset) + "px")
				.fadeIn("fast"); //미리보기 화면 설정 셋팅
		});
		
		$(document).on("mousemove",".thumbnail12",function(e){ //마우스 이동시
			$("#preview")
				.css("top",(e.pageY - xOffset) + "px")
				.css("left",(e.pageX + yOffset) + "px");
		});
		
		$(document).on("mouseout",".thumbnail12",function(){ //마우스 아웃시
			$("#preview").remove();
		});
		
		$(document).on("mouseover",".thumbnail13",function(e){ //마우스 오버시
			
			$("body").append("<p id='preview'><img src='/common/img/13.jpg'"+ $(this).attr("src") +"' width='100px' /></p>"); //보여줄 이미지를 선언					 
			$("#preview")
				.css("top",(e.pageY - xOffset) + "px")
				.css("left",(e.pageX + yOffset) + "px")
				.fadeIn("fast"); //미리보기 화면 설정 셋팅
		});
		
		$(document).on("mousemove",".thumbnail13",function(e){ //마우스 이동시
			$("#preview")
				.css("top",(e.pageY - xOffset) + "px")
				.css("left",(e.pageX + yOffset) + "px");
		});
		
		$(document).on("mouseout",".thumbnail13",function(){ //마우스 아웃시
			$("#preview").remove();
		});
		
		$(document).on("mouseover",".thumbnail14",function(e){ //마우스 오버시
			
			$("body").append("<p id='preview'><img src='/common/img/14.jpg'"+ $(this).attr("src") +"' width='100px' /></p>"); //보여줄 이미지를 선언					 
			$("#preview")
				.css("top",(e.pageY - xOffset) + "px")
				.css("left",(e.pageX + yOffset) + "px")
				.fadeIn("fast"); //미리보기 화면 설정 셋팅
		});
		
		$(document).on("mousemove",".thumbnail14",function(e){ //마우스 이동시
			$("#preview")
				.css("top",(e.pageY - xOffset) + "px")
				.css("left",(e.pageX + yOffset) + "px");
		});
		
		$(document).on("mouseout",".thumbnail14",function(){ //마우스 아웃시
			$("#preview").remove();
		});
		
        
   });
    </script>
 
</head>
<body>
<div>
			<h3>결재라인지정</h3>
					
<div class="table_wrap">
<table>
	<form id="ealine" name="ealine">  
    <div class="tree_box">
    <div class="con">
        <ul id="tree_menu" class="tree_menu">
        	<li class="depth_1"><strong>총장</strong>
                <ul class="depth_2">
                	<li>
                        <a href="#none"><em>폴더</em> 총장</a>
                        <ul class="depth_3">
                            <li data="김태평" class="end"><a href="#none" class="thumbnail" height='50px'>김태평</a></li>
                        </ul>
                    </li>
                </ul>
            </li>
            <li class="depth_1"><strong>기획처</strong>
                <ul class="depth_2" >
                	<li>
                        <a href="#none"><em>폴더</em> 기획처장</a>
                        <ul class="depth_3">
                            <li data="정상희" class="end"><a href="#none" class="thumbnail2" height='50px'>정상희</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#none"><em>폴더</em> 기획팀</a>
                        <ul class="depth_3">
                            <li data="최성남" class="end"><a href="#none" class="thumbnail3" height='50px'>팀장 최성남</a></li>
                        </ul>
                    </li>
                    <li class="last">
                        <a href="#none"><em>폴더</em> 홍보팀</a>
                        <ul class="depth_3">
                            <li data="김영권" class="end"><a href="#none" class="thumbnail4" height='50px'>팀장 김영권</a></li>
                            </ul>
                    </li>
                </ul>
            </li>
            <li class="depth_1"><strong>교학처</strong>
                <ul class="depth_2">
                	<li>
                        <a href="#none"><em>폴더</em> 교학처장</a>
                        <ul class="depth_3">
                            <li data="박근덕" class="end"><a href="#none" class="thumbnail5" height='50px'>박근덕</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#none"><em>폴더</em> 입학관리팀</a>
                        <ul class="depth_3">
                            <li data="서인성" class="end"><a href="#none" class="thumbnail6" height='50px'>팀장 서인성</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#none"><em>폴더</em> 교무팀</a>
                        <ul class="depth_3">
                            <li data="양진욱" class="end"><a href="#none" class="thumbnail7" height='50px'>팀장 양진욱</a></li>
                        </ul>
                    </li>
                    <li class="last">
                        <a href="#none"><em>폴더</em> 학사지원팀</a>
                        <ul class="depth_3">
                            <li data="최용선" class="end"><a href="#none" class="thumbnail8" height='50px'>팀장 최용선</a></li>
                        </ul>
                    </li>
                </ul>
            </li>
            <li class="depth_1"><strong>사무처</strong>
                <ul class="depth_2" >
                	<li>
                        <a href="#none"><em>폴더</em> 사무처장</a>
                        <ul class="depth_3">
                            <li data="조대진" class="end"><a href="#none" class="thumbnail9" height='50px'>조대진</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#none"><em>폴더</em> 총무팀</a>
                        <ul class="depth_3">
                            <li data="문찬미" class="end"><a href="#none" class="thumbnail10" height='50px'>팀장 문찬미</a></li>
                        </ul>
                    </li>
                    <li class="last">
                        <a href="#none"><em>폴더</em> 재무팀</a>
                        <ul class="depth_3">
                            <li data="김나미" class="end"><a href="#none" class="thumbnail11" height='50px'>팀장 김나미</a></li>
                        </ul>
                    </li>
                </ul>
            </li>
            <li class="depth_1"><strong>국제협력처</strong>
                <ul class="depth_2" >
                	<li>
                        <a href="#none"><em>폴더</em> 국제협력처장</a>
                        <ul class="depth_3">
                            <li data="안진호" class="end"><a href="#none" class="thumbnail12" height='50px'>안진호</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#none"><em>폴더</em> 국제교류팀</a>
                        <ul class="depth_3">
                            <li data="조정현" class="end"><a href="#none" class="thumbnail13" height='50px'>팀장 조정현</a></li>
                        </ul>
                    </li>
                    <li class="last">
                        <a href="#none"><em>폴더</em> 국제학생지원팀</a>
                        <ul class="depth_3">
                            <li data="황미혜" class="end"><a href="#none" class="thumbnail14" height='50px'>팀장 황미혜</a></li>
                        </ul>
                    </li>
                </ul>
            </li>            
        </ul>
    </div>
</div>

 		
	
<!--//트리메뉴-->
 </form>
 		<tr>
 			<td>결재자
 			<input type="text" name="person" id="person" readonly></td>
 					 	
 		<td>			
			<input type="button" class=grey_btn name="close" id="close" value="닫기 ">
			<input type="button" class=blue_btn name="check" id="check" value="추가"></td>	
		</tr>
 </table>
 </div>
 </div>
 	
</body>
</html>