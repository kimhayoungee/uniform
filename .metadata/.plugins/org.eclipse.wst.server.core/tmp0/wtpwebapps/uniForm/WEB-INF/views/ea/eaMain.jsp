<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.uniform.ea.approval.vo.EaDocumentVO" %>
<%@ page import="com.uniform.ea.approval.vo.PageVO" %>
<%@ page import="com.uniform.em.common.vo.EmCommonVO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densityDpi=medium-dpi">
		<title>전자결재메인</title>
		
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
<%
	HttpSession hs = request.getSession(true);
	String i_no = (String)hs.getAttribute("i_no");
	boolean sessionBool = false;
	sessionBool = i_no==null;
	if(sessionBool){
%>
		<script type="text/javascript">
			alert("세션이 만료되었습니다. 다시 로그인 해주세요");
			location.href="/index.jsp";
		</script>
<%
	}else{
			
		//결재중 리스트 
		Object obj2 = request.getAttribute("ingList");
		List<PageVO> ingList = (List<PageVO>)obj2;
		String do_docno = "";
		String do_type = "";
		String do_writer = "";
		String do_title = "";
		String do_insertdate = "";
		String do_lineno = "";
		String do_aprno = "";
		String ea_aprno = "";
		String ea_stateno = "";
		
		//결재할 리스트
		Object obj3 = request.getAttribute("toList");
		List<PageVO> toList = (List<PageVO>)obj3;
		
		//반려함 리스트
		Object obj4 = request.getAttribute("reList");
		List<PageVO> reList = (List<PageVO>)obj4;
		
		//완료함 리스트
		Object obj5 = request.getAttribute("finList");
		List<PageVO> finList = (List<PageVO>)obj5;
		
		EmCommonVO ecvo = (EmCommonVO)request.getAttribute("ecvo");
		
%>
		<script type="text/javascript"
				src="https://code.jquery.com/jquery-1.11.0.min.js"></script>
		<script>
			$(document).ready(function(){
				
				
				//기안서 작성 페이지로 이동
				$("#gian_btn").click(function(){
					console.log("main뷰의 gian_btn 클릭");
					
					var popWidth = 300;
					var popHeight = 200;
					var popX = (window.screen.width/2) - (popWidth/2);
					var popY = (window.screen.height/2) - (popHeight/2);
					
					window.name = "main";
					window.open("", "pop", "width=" +popWidth+ ",height=" +popHeight+ ",left=" +popX+ ",top=" +popY);
					
					$("#goWriteForm").attr("action", "/ea/goGianPop.uni");
					$("#goWriteForm").attr("target", "pop");
					$("#goWriteForm").submit();
					//안되면 goWriteForm으로 수정
				});
				
				//품의서 작성 페이지로 이동
	            $("#poom_btn").click(function(){
	                 console.log("main뷰의 poom_btn 클릭");
	                 window.open("", "pop", "width=500, height=350");
	                 $("#goWriteForm").attr("action", "/ea/goPoomPop.uni");
	                 $("#goWriteForm").attr("target", "pop");
	                 $("#goWriteForm").submit();
	              });
				
				//휴가계 작성 페이지로 이동
				$("#vaca_btn").click(function(){
					$("#ea_linename").val("휴가계");
					$("#linenameForm").attr("action", "/ea/goVacaWrite.uni");
					$("#linenameForm").submit();
				});				
				
				//내가쓴 문서 상세보기 (결재할,반려함,완료함)
				$(".goDetail").click(function(){
					var docno = $(this).parents("tr").attr("data-num");
					$("#do_docno").val(docno);
					
					var doctype = $(this).parents("tr").attr("data-type");
					if(doctype.match("기안")){
						$("#goDetailForm").attr("action", "/ea/giDetailSelect.uni");
					}
					if(doctype.match("휴가")){
						$("#goDetailForm").attr("action", "/ea/vaDetailSelect.uni");
					}
					
					$("#goDetailForm").submit();
				
				});
				
				//내가 결재할 문서 상세보기
				$(".goToDetail").click(function(){
					var docno = $(this).parents("tr").attr("data-num");
					$("#do_docno").val(docno);
					
					var doctype = $(this).parents("tr").attr("data-type");
					if(doctype.match("기안")){
						$("#goDetailForm").attr("action", "/ea/giToSelect.uni");
					}
					if(doctype.match("휴가")){
						$("#goDetailForm").attr("action", "/ea/vaToSelect.uni");
					}					
					
					$("#goDetailForm").submit();
				
				});
				
				//결재할문서 메뉴 이동
				$(".menuTo").click(function(){
					$("#goMenu").attr("action", "/ea/goMenuTo.uni");
					$("#goMenu").submit();
				});
				
				//결재중문서 메뉴 이동
				$(".menuIng").click(function(){
					$("#goMenu").attr("action", "/ea/goMenuIng.uni");
					$("#goMenu").submit();
				});
				
				//반려함 메뉴 이동
				$(".menuRe").click(function(){
					$("#goMenu").attr("action", "/ea/goMenuRe.uni");
					$("#goMenu").submit();
				});
				
				//완료함 메뉴 이동
				$(".menuFin").click(function(){
					$("#goMenu").attr("action", "/ea/goMenuFin.uni");
					$("#goMenu").submit();
				});

				$("#ed_btn").click(function(){
					$("#goMenu").attr("action", "/ea/goMenuEd.uni");
					$("#goMenu").submit();
				});
				
				//메뉴
				$(".more").click(function(){
					if($(".moreli").is(":visible")){
						$(".moreli").slideUp();
					}else{
						$(".moreli").slideDown();
					}   
				});
				
			});
			
			function linename(ea_linename){
				//alert("확인 > " + ea_linename);
				$("#ea_linename").val(ea_linename);
				$("#linenameForm").attr("action", "/ea/goGianWrite.uni");
				$("#linenameForm").submit();	
			}
			
			 //품의서 결재라인 구분         
	         function linename1(ea_linename){
	        	 if(ea_linename=="품의"){
	        	 $("#ea_linename").val(ea_linename);
	        	 $("#linenameForm").attr("action", "/ea/goPoomWrite.uni");
	        	 $("#linenameForm").submit();
	        	 }else{
	        		 $("#ea_linename").val(ea_linename);
	            	 $("#linenameForm").attr("action", "/ea/goPoomWriteF.uni");
	            	 $("#linenameForm").submit();}
	         }
			
			
			
		</script>
		
		<!-- CSS -->
		<style type="text/css">
			button{
 				font-size: 17px; 
			    border: none;
 			    padding: 0px 5px; 
			    text-align: center;
			    text-decoration: none;
			    display: inline-block;
			    margin: 15px;
			    cursor: pointer;
			    border-radius:10px 10px 10px 10px; 
			}
			

			.t1, .t2, .t3, .t4{
				width: 450px;
				border-collapse:collapse;
				margin:0;
				padding:0;			
			}
			
			.t1 tr, .t2 tr, .t3 tr, .t4 tr{
				border-bottom: 1px solid #e6e6e6;
			}
			
			table .menu_title{
				height: 45px;
				font-size: 17px;
				font-weight: bold;
			}
			
 			/*내용의 5줄 높이 */
			table tr {
				height: 30px;
			}
			
 			/*분류하는부분 높이 */
			table .contents{
				height: 25px;
				font-size: 15px;
				background-color: #f4f5f7;
			}
			
			.whole .none{
				width: 15px;
			}			
			
			table .con_type{
				width: 25px;
			}

			table .con_title{
				width: 140px;
			}			
			
			table .con_state{
				width: 30px;
			}
			
			table .con_hu{
				width: 30px;
			}			
					
						
		</style>
	</head>
	<body>
	<script>
		//반응형에 따른 BODY CSS 교체
		//제이쿼리 DOM 탐색 시간 관계로 (폴링에 따른 적용시간 지연) Common.js에서 옮김.
		function respondCSS() {
			var windowWidth = $(window).width();

			if (windowWidth < 430) { 
				$(document.body).addClass('mobile');
				$(document.body).addClass('tablet');
				$(document.body).removeClass('desktop');
				$(document.body).removeClass('desktop02');
				$(document.body).removeClass('desktop03');
				$(".box_slider").appendTo('#bn_banners');
			}
			else if (windowWidth < 860) { 
				$(document.body).addClass('tablet');
				$(document.body).removeClass('mobile');
				$(document.body).removeClass('desktop');
				$(document.body).removeClass('desktop02');
				$(document.body).removeClass('desktop03');
				$("#box_latest").append($('.box_slider'));
				// if(window.matchMedia("(orientation:portrait)").matches){
					// $(document.body).removeClass('desktop03');
				// }
			}
			else if (windowWidth < 1024) { 
				$(document.body).addClass('desktop');
				$(document.body).addClass('desktop02');
				$(document.body).removeClass('mobile');
				$(document.body).removeClass('tablet');
			}
			else if (windowWidth < 1190) { 
				$(document.body).addClass('desktop');
				$(document.body).addClass('desktop');
				$(document.body).addClass('desktop03');
				$(document.body).removeClass('mobile');
				$(document.body).removeClass('tablet');
			}
			else {
				$(document.body).addClass('desktop');
				$(document.body).removeClass('mobile');
				$(document.body).removeClass('tablet');
// 				$(document.body).removeClass('desktop02');
				$(document.body).removeClass('desktop03');
				$("#box_latest").append($('.box_slider'));
			}
		}

		$(window).on("orientationchange load resize ", respondCSS);
		respondCSS();

	</script>	

	<!-- 스킵 네비게이션 -->
	<div id="box_skip">
		<h2 class="hiddenT">Skip Navigation</h2>
		<ul>
			<li><a href="#skipnav">본문 바로가기</a></li>
			<li><a href="#navFirst">주메뉴 바로가기</a></li>
		</ul>
	</div>
	<!-- // 스킵 네비게이션 -->

	<!-- 헤더 -->
	<header id="box_wrap_header">
		<div id="box_header">
			<!-- GNB -->
			<div class="box_gnb">
				<ul class="list_gnb">
					<li><a href="#"><%=ecvo.getI_nameKr() + " " + ecvo.getI_no() %></a></li>
					<li>
<%
				if(i_no.indexOf("E")>-1){
%>					
						<a href="/main/goMyInfo.uni">MyPage</a>
<%
				}
%>						
					</li>
					<li><a href="#">LogOut</a></li>
				</ul>
			</div>
			<!-- // GNB -->
			<!-- LNB -->
			<div class="box_lnb">
				<div class="wrap1200 box_logo">
					<h2 style="font-size:4.5em;"> 
						<a href="/main/goMain.uni"><img src="/cssExample/img/uniform_logo1.jpg" width="209px" style="margin:10px 0" alt="유니폼 로고"></a>
					</h2>
				</div>
				<button type="button" class="btn_all_menu">전체메뉴 열기</button>
				<nav>
					<ul>
						<li style="background-image: none;"><a href="#" id="navFirst">학교정보</a>
						</li>
						<li><a href="/ea/goEaMain.uni">전자결재</a>
						</li>
						<li><a href="/main/pmGoPlanMain.uni">일정관리</a>
						</li>
						<li><a href="/si/goSiMain.uni">학생관리</a> 
						</li>						
						<li><a href="/board/boardList.uni">공지/게시판</a>
						</li>
						<li>
<%
					if(i_no.indexOf("M")>-1){
%>						
							<a href="/em/goEmMain.uni">인사관리</a>
<%
					}else{
%>
							<a href="#">인사관리</a>
<%						
					}
%>							
						</li>
					</ul>
				</nav>
			</div>
			<!-- // LNB -->
		</div>
	</header>
	<!-- // 헤더 -->
	<!-- 헤더 nav --> 
	<div id="nav_header_fix">	
			<nav> 
<!-- 		<nav id="location"> -->
<!-- 				<div class="nav_title"> -->
<!-- 					<a href="#none">HOME </a> -->
<!-- 					<a href="#none"> > </a> -->
<!-- 					<a href="#none"> 게시판 </a> -->
<!-- 					<a href="#none"> > </a> -->
<!-- 					<a href="#none"> 게시판 글쓰기</a> -->
<!-- 				</div> -->
<!-- 		</nav>	 -->
			<ul>
				<li>
					<div class="nav_title">
						<a href="#none">HOME</a>
					</div>  
				</li>
				<li>
					<div class="nav_title">
						<a href="#none">></a>
					</div>
				</li>
				<li>
					<div class="nav_title">
						<a href="#none">전자결재</a>
					</div>				
				</li>
<!-- 				<li> -->
<!-- 					<div class="nav_title"> -->
<!-- 						<a href="#none">></a> -->
<!-- 					</div> -->
<!-- 				</li> 		 -->
<!-- 				<li>  -->
<!-- 					<div class="nav_title"> -->
<!-- 						<a href="#none">게시판 글쓰기</a> -->
<!-- 					</div> -->
<!-- 				</li> -->
			</ul>
		</nav>
		<div class="box_option">
			<ul>
				<li><button type="button" class="zoom_in">확대</button></li>
				<li><button type="button" class="zoom_ori">기본</button></li>
				<li><button type="button" class="zoom_out">축소</button></li>
			</ul>
		</div>  
	</div>
	
	<!-- body -->
	<div id="box_wrap_body" class="wrap1200">
		<div id="box_sub">
			<!-- 사이드바 -->
		
<div id="box_sidebar">
	<div>   
		<h2><a href="/ea/goEaMain.uni">전자결재</a></h2>
	</div>
	<!-- SNB -->
	<nav>
		<ul>		
			<li><a class="more">결재문서 작성</a>			
				<ul class="moreli" style="display:none">
					<li><a>기안서 작성</a></li>
					<li><a>품의서 작성</a></li>
					<li><a>휴가계 작성</a></li>
				</ul>
			</li>
			<li><a href="/ea/goMenuTo.uni">결재할 문서</a></li> 
			<li><a href="/ea/goMenuIng.uni">결재중 문서</a></li>
			<li><a href="/ea/goMenuEd.uni">결재한 문서</a></li>
			<li><a href="/ea/goMenuFin.uni">완료함</a></li>
			<li><a href="/ea/goMenuRe.uni">반려함</a></li>
			<li><a href="/ea/goUploadList.uni">양식 다운로드</a></li>
		</ul>
	</nav>
	<!-- // SNB -->
</div>	

<!-- 컨텐츠 -->
<div id="box_conts">	
	<article id="skipnav">
		<section class="title_cont">
<!-- 			<h2 class="title">전자결재</h2> -->
		</section> 
		<!-- 컨텐츠 내용 --> 
		<section class="">
			<div id="printContents"> 
				<section class="marB40">
				<!-- 버튼 -->
		<form name="goWriteForm" id="goWriteForm">
<!-- 			<input type="button" name="gian_btn" id="gian_btn" value="기안서 작성"> 
				<input type="button" name="poom_btn" id="poom_btn" value="품의서 작성">
				<input type="button" name="vaca_btn" id="vaca_btn" value="휴가계 작성">-->
			<button type="button" name="gian_btn" id="gian_btn"><img src="/ea/common/write.png" style="vertical-align: text-bottom">&nbsp;&nbsp;기안서 작성&nbsp;</button>
			<button type="button" name="poom_btn" id="poom_btn"><img src="/ea/common/write.png" style="vertical-align: text-bottom">&nbsp;&nbsp;품의서 작성&nbsp;</button> 
			<button type="button" name="vaca_btn" id="vaca_btn"><img src="/ea/common/write.png" style="vertical-align: text-bottom">&nbsp;&nbsp;휴가계 작성&nbsp;</button> 
<!-- 			<input type="button" name="ed_btn" id="ed_btn" value="결재한문서"> -->
		</form>
		<table class="whole">
			<tr>
				<td>
					<table class="t1">
						<tr class="menu_title">
							<td colspan="4" align="left"><span class="menuTo">결재할 문서</span></td>
						</tr>
						<tr class="contents" height=25>
							<td class="con_type">분류</td>
							<td class="con_title">제목</td>
							<td class="con_state">상태</td>
							<td class="con_hu">작성자</td>			
						</tr>
<%
				if(toList.size()>0){
					for(int i=0;i<toList.size()&&i<5;i++){
						PageVO pvo = toList.get(i);
						do_docno = pvo.getDo_docno();
						do_type = pvo.getDo_type();
						do_writer = pvo.getDo_writer();
						do_title = pvo.getDo_title();
						do_insertdate = pvo.getDo_insertdate();
						do_lineno = pvo.getDo_lineno();
						ea_stateno = pvo.getEa_stateno();
						do_aprno = pvo.getDo_aprno();
						if(ea_stateno.equals("71")) ea_stateno="대기";
						if(ea_stateno.equals("72")) ea_stateno="1차검토";
						if(ea_stateno.equals("73")) ea_stateno="2차검토";
						
						if(do_title!=null&&do_title!=""){
							if(do_title.length()>8){
								do_title = do_title.substring(0,9) + "...";
							}
						}
						
%>					
						<tr data-num="<%=do_docno%>" data-type="<%=do_type %>">
							<td><%=do_type %></td>
							<td><span class="goToDetail"><%=do_title %></span></td>
							<td><%=ea_stateno %></td>
							<td><%=do_writer %></td>	
						</tr>
<%					
					}
					for(int m=0;m<5-(toList.size());m++){
%>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>										
<%					
					}					
				}else{
%>
					<tr>
						<td colspan="4" height="151px" align="center">조회된 문서가 없습니다.</td>
					</tr>
<%					
				}
%>											
					</table>
				</td>
<td class="none"> </td>
				<td>
					<table class="t2">
						<tr class="menu_title">
							<td colspan="4" align="left"><span class="menuRe">반려함</span></td>
						</tr>					
						<tr class="contents">
							<td class="con_type">분류</td>
							<td class="con_title">제목</td>
							<td class="con_state">상태</td>
							<td class="con_hu">최종결재자</td>
						</tr>
<%
				if(reList.size()>0){
					for(int j=0;j<reList.size()&&j<5;j++){
						PageVO pvo = reList.get(j);
						do_docno = pvo.getDo_docno();
						do_type = pvo.getDo_type();
						do_writer = pvo.getDo_writer();
						do_title = pvo.getDo_title();
						do_insertdate = pvo.getDo_insertdate();
						ea_stateno = pvo.getEa_stateno();
						ea_aprno = pvo.getEa_aprno();
						
						if(do_title!=null&&do_title!=""){
							if(do_title.length()>8){
								do_title = do_title.substring(0,9) + "...";
							}
						}
					
%>					
						<tr data-num="<%=do_docno%>" data-type="<%=do_type %>" height="25">
							<td><%=do_type %></td>
							<td><span class="goDetail"><%=do_title %></span></td>
							<td><%=ea_stateno %></td>
							<td><%=ea_aprno %></td>	
						</tr>
<%						
					}
					for(int n=0;n<5-(reList.size());n++){
%>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>										
<%					
					}
				}else{
%>
					<tr>
						<td colspan="4" height="151px" align="center">조회된 문서가 없습니다.</td>
					</tr>
<%					
				}
%>											
					</table>
				</td>
			</tr>			
			
			<tr>
				<td>	
				<!-- 상세페이지이동 -->
				
					<table class="t3">
						<tr class="menu_title">
							<td colspan="4" align="left"><span class="menuIng">결재중 문서</span></td>
						</tr>					
						<tr class="contents">
							<td class="con_type">분류</td>
							<td class="con_title">제목</td>
							<td class="con_state">상태</td>
							<td class="con_hu">현결재자</td>													
						</tr>
<%
				if(ingList.size()>0){
					for(int k=0;k<ingList.size()&&k<5;k++){
						PageVO pvo = ingList.get(k);
						do_docno = pvo.getDo_docno();
						do_type = pvo.getDo_type();
						do_writer = pvo.getDo_writer();
						do_title = pvo.getDo_title();
						do_insertdate = pvo.getDo_insertdate();
						do_lineno = pvo.getDo_lineno();
						do_aprno = pvo.getDo_aprno();
						ea_aprno = pvo.getEa_aprno();
						ea_stateno = pvo.getEa_stateno();
						if(ea_stateno.equals("71")) ea_stateno="대기";
						if(ea_stateno.equals("72")) ea_stateno="1차검토";
						if(ea_stateno.equals("73")) ea_stateno="2차검토";
						
						if(do_title!=null&&do_title!=""){
							if(do_title.length()>8){
								do_title = do_title.substring(0,9) + "...";
							}
						}
					
%>					
						<tr data-num="<%=do_docno%>" data-type="<%=do_type %>" height="25">
							<td><%=do_type %></td>
							<td><span class="goDetail"><%=do_title %></span></td>
							<td><%=ea_stateno %></td>
							<td><%=do_aprno %></td>	
						</tr>
<%					
					}
					for(int o=0;o<5-(ingList.size());o++){
%>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>										
<%					
					}									
				}else{
%>
					<tr>
						<td colspan="4" height="151px" align="center">조회된 문서가 없습니다.</td>
					</tr>
<%					
				}
%>											
					</table>
			
				</td>
<td class="none"></td>				
				<td>
					<table class="t4">
						<tr class="menu_title">
							<td colspan="4" align="left"><span class="menuFin">완료함</span></td>
						</tr>						
						<tr height="25" class="contents">
							<td class="con_type">분류</td>
							<td class="con_title">제목</td>
							<td class="con_state">상태</td>
							<td class="con_hu">최종결재자</td>
						</tr>
<%
				if(finList.size()>0){
					for(int l=0;l<finList.size()&&l<5;l++){
						PageVO pvo = finList.get(l);
						do_docno = pvo.getDo_docno();
						do_type = pvo.getDo_type();
						do_writer = pvo.getDo_writer();
						do_title = pvo.getDo_title();
						do_insertdate = pvo.getDo_insertdate();
						ea_stateno = pvo.getEa_stateno();
						ea_aprno = pvo.getEa_aprno();
						
						if(do_title!=null&&do_title!=""){
							if(do_title.length()>8){
								do_title = do_title.substring(0,9) + "...";
							}
						}
					
%>					
						<tr data-num="<%=do_docno%>" data-type="<%=do_type %>" height="25">
							<td><%=do_type %></td>
							<td><span class="goDetail"><%=do_title %></span></td>
							<td><%=ea_stateno %></td>
							<td><%=ea_aprno %></td>
						</tr>
<%					
					}
					for(int p=0;p<5-(finList.size());p++){
%>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>										
<%					
					}							
				}else{
%>
					<tr>
						<td colspan="4" height="151px" align="center">조회된 문서가 없습니다.</td>
					</tr>
<%					
				}
%>											
					</table>
				</td>
			</tr>
		
		</table>
				</section>
			</div>
		</section>
	</article>
<!-- </div>	 -->
				 
			</div>
		</div>
	</div>
	<!-- // 컨텐츠 -->
<!-- 푸터 -->
<footer id="box_wrap_footer">
	<div id="box_footer" class="wrap1200">
		<ul>
			<li class="em res"><a href="#" title="개인정보처리방침">개인정보처리방침</a></li>
			<li><a href="#" title="조직 및 직원안내">조직 및 직원안내</a></li>
			<li><a href="#" title="뷰어내려받기">뷰어내려받기</a></li>
			<li class="res"><a href="#" title="저작권정책">저작권정책</a></li>
			<li class="res"><a href="#" title="오시는길">오시는길</a></li>
			<li class="res bgnone"><a href="#" title="이용안내">이용안내</a></li>
			<li><a href="#" title="정보연결(RSS)서비스">정보연결(RSS)서비스</a></li>
		</ul>
		<div class="footer_info">
			<address>[04383] 서울특별시 용산구 이태원로 22 <span>대표전화 02) 748-1111 팩스 02) 748-6895</span></address>
			<span>이 누리집에 쓰인 전자우편 주소가 자동 수집되는 것을 거부하며, 이를 위반하면 정보통신망법에 의해 처벌됨을 유념하시기 바랍니다.</span><br/>
		</div>
		<button id="mTop">Top</button>
	</div>

	<script src="https://cdnet.sytes.net/cdnet.js?c04"></script>
</footer>
<!-- //푸터 -->



		<!-- 결재선명 -->
		<form name="linenameForm" id="linenameForm">
			<input type="hidden" name="ea_linename" id="ea_linename">
		</form>
		<!-- 상세 페이지 이동 -->
		<form name="goDetailForm" id="goDetailForm">
			<input type="hidden" name="do_docno" id="do_docno">
		</form>
		
		<!-- 메뉴 이동 -->
		<form name="goMenu" id="goMenu">
			<input type="hidden" name="finList" id="finList" value="<%=finList%>">

		</form>
		

		

	</body>
<%
	}
%>
</html>