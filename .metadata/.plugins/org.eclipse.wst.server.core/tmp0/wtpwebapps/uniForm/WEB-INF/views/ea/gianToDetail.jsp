<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.uniform.ea.approval.vo.EaGianVO" %>  
<%@ page import="com.uniform.ea.approval.vo.EaApprovalVO" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densityDpi=medium-dpi">     
      <title>결재할 문서</title>
		<!-- Reset CSS --> 
		<link rel="stylesheet" href="/cssExample/css/reset_normalize.css" media="all">
		<!-- Design CSS -->
		<link rel="stylesheet" href="/cssExample/css/style_common.css" media="all">
		<link rel="stylesheet" href="/cssExample/css/style_contents.css" media="all">
		<link rel="stylesheet" href="/cssExample/css/board.css" media="all">
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
	   Object obj1 = request.getAttribute("toList");
	   List<EaGianVO> toList = (List<EaGianVO>) obj1;
	   String do_docno = "";
	   String do_type = "";
	   String do_writer = "";
	   String do_title = "";
	   String do_insertdate = "";
	   String gi_attach = "";
	   String gi_data = "";
	   String gi_team = "";
	   
	   for(int i=0;i<toList.size();i++){
		   EaGianVO egvo = toList.get(i);
		   do_docno = egvo.getDo_docno();
		   do_type = egvo.getDo_type();
		   do_writer = egvo.getDo_writer();
		   do_title = egvo.getDo_title();
		   do_insertdate = egvo.getDo_insertdate();
		   gi_attach = egvo.getGi_attach();
		   gi_data = egvo.getGi_data();
		   gi_team = egvo.getGi_team();
	   }
	   boolean b = gi_attach !=null && gi_attach !="";
	   
	   //최종결재의견
	   Object obj2 = request.getAttribute("eList");
	   List<EaApprovalVO> eList = (List<EaApprovalVO>)obj2;
	   String ea_stateno = "";
	   String ea_sign1 = "";
	   String ea_sign2 = "";
	   String ea_sign3 = "";
	   String ea_comment = "";
	   String ea_aprno = ""; 
	   String ea_date = "";
	   String ea_linename = "";
	   for(int k=0;k<eList.size();k++){
		   EaApprovalVO eavo = eList.get(k);
		   ea_stateno = eavo.getEa_stateno();
		   ea_sign1 = eavo.getEa_sign1();
		   ea_sign2 = eavo.getEa_sign2();
		   ea_sign3 = eavo.getEa_sign3();
		   ea_comment = eavo.getEa_comment();
		   ea_aprno = eavo.getEa_aprno();
		   ea_date = eavo.getEa_date();
		   ea_linename = eavo.getEa_linename();
		   if(ea_comment==null) ea_comment = "";
	   }
	   
	   if(ea_linename.equals("기안전결")) ea_sign3 = "/ea/common/wjsruf.jpg";
	   
	   //히스토리에 있는 결재 의견 
	   Object obj3 = request.getAttribute("hList");
	   List<EaApprovalVO> hList = (List<EaApprovalVO>)obj3;   
	   String hea_aprno = "";
	   String hea_stateno = "";
	   String hea_comment = "";
	   String hea_date = "";
%>      
      <!-- 제이쿼리 -->
      <script type="text/javascript"
         src="https://code.jquery.com/jquery-1.11.0.min.js"></script>
      <script>
		var images = ['mnd_bg07.jpg', 'mnd_bg08.jpg', 'mnd_bg09.jpg'];
		$('#box_wrap_visual').css({'background-image':'url(/mbshome/mbs/mnd/images/common/' + images[Math.floor(Math.random() * images.length)] + ')'});        
		
		var state = "<%=ea_stateno%>";
		var line = "<%=ea_linename%>";
		
         $(document).ready(function(){
        	$("#down_btn").hide();

        	$("#commentForm").hide();
        	
			if(<%=b%>){
				$("#down_btn").show();
			}
				
        	$("#down_btn").click(function(){
        		alert("파일 다운로드 클릭");
        		var gi_attach = $(this).parents("tr").attr("data-value");
        		$("#file").val(gi_attach);
        		$("#downForm").attr("action", "/ea/download.uni");
        		$("#downForm").submit();
        		
        	}); 
        	            
            $("#ap_btn").click(function(){
            	alert("승인 클릭");
            	var r = confirm("승인하시겠습니까?");
				if(r==true){
					if(state=="대기") $("#ea_stateno").val("72");
						
					if(state=="1차검토"&&line=="기안전결"){
						$("#ea_stateno").val("74");
					}
					if(state=="1차검토"&&line!="기안전결"){
						$("#ea_stateno").val("73");
					}
						
					if(state=="2차검토") $("#ea_stateno").val("76");
					
					var f = $("#eaForm").serialize();
					$.ajax({
						url : "/ea/approval.uni",
						data : f,
						type : "post",
						success : function(data){
							var d = data;
							
							alert("ajax작성 확인 : " + d);
								
							goEaMain();							
						},
						error : function(request,status,error){
							alert("whenError : " + request.status + " : error=" + error);
						}						
						
					});

				}
            });  
            
            $("#rn_btn").click(function(){
            	alert("반려 클릭");
            	var r = confirm("반려하시겠습니까?");
				if(r==true){
	            	$("#ea_stateno").val("77");
	            	
					var f = $("#eaForm").serialize();
					$.ajax({
						url : "/ea/approval.uni",
						data : f,
						type : "post",
						success : function(data){
							var d = data;
							
							alert("ajax작성 확인 : " + d);
								
							goEaMain();							
						},
						error : function(request,status,error){
							alert("whenError : " + request.status + " : error=" + error);
						}						
						
					});
					
				}
            });  
            
            $("#cm_btn").on("click", function(){
				var popWidth = 500;
				var popHeight = 500;
				var popX = (window.screen.width/2) - (popWidth/2);
				var popY = (window.screen.height/2) - (popHeight/2);	

				window.open("", "pop", "width=" +popWidth+ ",height=" +popHeight+ ",left=" +popX+ ",top=" +popY);
            	$("#eaForm").attr("action", "/ea/goCommentPop.uni");
            	$("#eaForm").attr("target", "pop");
            	$("#eaForm").submit();
            });
            
         });
         
		function goEaMain(){
			location.href = "/ea/goEaMain.uni";
		}         
         
         function comment(ea_comment){
         	$("#ea_comment").val(ea_comment);
         	$("#cm_btn").hide();
         	$("#commentForm").show();
         }
      </script>
      
     <!-- CSS -->
      <style type="text/css">
			.stitle{
				font-size:20px;
				font-weight:bold;
				color: #0c335e;
				border-bottom: 2px solid #565c6b;
			}
			
			.contents {
				border-top: 2px solid #565c6b;
				border-bottom: none;
			}

			.contents tr td, .ea, .ea tr td, .lineClass tr td{
				border:1px solid #dddee0;
				border-collapse:collapse;
				margin:0;
				padding:0;
				border-left: none;	
				border-right: none;
			}
			
			.cate{
				font-weight: bold;
				text-align:center;
			}		

			.line_table tr td{
				border:1px solid #dddee0;
				border-collapse:collapse;
				margin:0;
				padding:0;
 				border-left: none;	 
 				border-right: none;				 
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
					<li><a href="#">설재희님 E201902150001</a></li>
					<li><a href="#">MyPage</a></li>
					<li><a href="#">LogOut</a></li>
				</ul>
			</div>
			<!-- // GNB -->
			<!-- LNB -->
			<div class="box_lnb">
				<div class="wrap1200 box_logo">
					<h2 style="font-size:4.5em;"> 
						<a href="#"><img src="/common/img/uniform2.JPG" width="180" height="53"></a>
					</h2>
				</div>
				<button type="button" class="btn_all_menu">전체메뉴 열기</button>
				<nav>
					<ul>
						<li style="background-image: none;"><a href="#" id="navFirst">학교정보</a>
							<div class="box_wrap_ls dep05">
								<div class="box_ls">
									<ul>
										<li><a href="#">항목1</a></li>
										<li><a href="#">항목2</a></li>
										<li><a href="#">항목3</a></li>
										<li><a href="#">항목4</a></li>
									</ul>
								</div>
							</div>
						</li>
						<li><a href="/ea/goEaMain.uni">전자결재</a>
							<div class="box_wrap_ls dep03">
								<div class="box_ls">
									<ul>
										<li><a>기안서 작성</a></li>
										<li><a>품의서 작성</a></li>
										<li><a>휴가계 작성</a></li>
										<li><a href="/ea/goMenuTo.uni">결재할 문서</a></li>
										<li><a href="/ea/goMenuIng.uni">결재중 문서</a></li>
										<li><a href="/ea/goMenuEd.uni">결재한 문서</a></li>
										<li><a href="/ea/goMenuFin.uni">완료함</a></li>
										<li><a href="/ea/goMenuRe.uni">반려함</a></li>
										<li><a href="#">양식다운로드</a></li>
									</ul>
								</div>
							</div>
						</li>
						<li><a href="#">일정관리</a>
							<div class="box_wrap_ls dep02">
								<div class="box_ls">
									<ul>
										<li><a href="#">항목1</a></li>
										<li><a href="#">항목2</a></li>
										<li><a href="#">항목3</a></li>
										<li><a href="#">항목4</a></li>
									</ul>
								</div>
							</div>
						</li>
						<li><a href="#">학생관리</a> 
							<div class="box_wrap_ls dep01">
								<div class="box_ls">
									<ul>
										<li><a href="#">항목1</a></li>
										<li><a href="#">항목2</a></li>
										<li><a href="#">항목3</a></li>
										<li><a href="#">항목4</a></li>
									</ul>
								</div>
							</div>
						</li>						
						<li><a href="#">공지/게시판</a>
							<div class="box_wrap_ls dep04">
								<div class="box_ls">
									<ul>
										<li><a href="#">항목1</a></li>
										<li><a href="#">항목2</a></li>
										<li><a href="#">항목3</a></li>
										<li><a href="#">항목4</a></li>
									</ul>
								</div>
							</div>
						</li>
						<li><a href="#">인사관리</a>
							<div class="box_wrap_ls dep06">
								<div class="box_ls">
									<ul>
										<li><a href="#">항목1</a></li>
										<li><a href="#">항목2</a></li>
										<li><a href="#">항목3</a></li>
										<li><a href="#">항목4</a></li>
									</ul>
								</div>
							</div>
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
				<li>
					<div class="nav_title">
						<a href="#none">></a>
					</div>
				</li> 		
				<li> 
					<div class="nav_title">
						<a href="#none">결재할 문서 보기</a>
					</div>
				</li>
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
			<li class="on"><a href="/ea/goMenuTo.uni">결재할 문서</a></li> 
			<li><a href="/ea/goMenuIng.uni">결재중 문서</a></li>
			<li><a href="/ea/goMenuEd.uni">결재한 문서</a></li>
			<li><a href="/ea/goMenuFin.uni">완료함</a></li>
			<li><a href="/ea/goMenuRe.uni">반려함</a></li>
			<li><a href="#">양식 다운로드</a></li>
		</ul>
	</nav>
	<!-- // SNB -->
</div>	

<!-- 컨텐츠 -->
<div id="box_conts">	
	<article id="skipnav">
		<section class="title_cont">
			<h1 class="title">기안서</h1>
		</section> 	
		<!-- 컨텐츠 내용 --> 
		<section class="box_instruc_con">
			<div id="printContents"> 
				<section class="marB40">	
				   	  
	  <table class="whole" border="0">	
		 <tr>
			<td align="right" colspan="4">
				<input type="button" name="rn_btn" id="rn_btn" value="반려" class="blue_btn">&nbsp;
				<input type="button" name="ap_btn" id="ap_btn" value="승인" class="blue_btn">
			</td>
		 </tr>
		 <tr>
		 	<td align="right" colspan="4">
		 		<br><br>
		 	</td>
		 </tr>
		 
         <tr>
         <td width="915">
            <table class="contents">
               <tr height="40">
               	 <td width="152" class="cate">작성자</td>
                  <td width="302"><%=do_writer %></td>
                  <td width="152" class="cate">종류</td>
                  <td width="302"><%=do_type %></td>
               </tr>
               <tr height="40">
                  <td width="152" class="cate">제목</td> 
                  <td width="302"><%=do_title %></td>
                  <td width="152" class="cate">작성일자</td>
                  <td width="302"><%=do_insertdate %></td>
               </tr>
            </table>
         </td>
         
         <tr>
         <td class="stitle" height=50 colspan="4">결재도장/서명</td>
         </tr> 
         
         <tr>   
         <td align="right">
           <!-- 결재도장부분 -->
           <table class="line_table">
              <tr height="40">
                 <td rowspan="2" width="152" class="cate">결재</td>
                 <td width="253" align="center">1차검토</td>
                 <td width="253" align="center">2차검토</td>
                 <td width="253" align="center">결재</td>
              </tr>
              <tr height="105">
                 <td><img src="<%=ea_sign1 %>" width="120" height="105" alt=""></td>
                 <td><img src="<%=ea_sign2 %>" width="120" height="105" alt=""></td>
                 <td><img src="<%=ea_sign3 %>" width="120" height="105" alt=""></td>
              </tr>
           </table>
         </td>
         </tr>
         
		<!-- 결재의견부분 -->
		<tr>
		<td class="stitle" height=50 colspan="4">결재의견</td>
		</tr>

	  	 <tr>
	  	 <td>
	      
	      <table class="line_table">
			 <tr height="40">
	   			<td width="152" class="cate">결재자</td>
	   			<td width="100" class="cate">결재내용</td>
	   			<td width="400" class="cate">결재의견</td>
	   			<td width="260" class="cate">결재일시</td>
	   		 </tr>
	   		 
	   		 <tr height="40">
	   		 	<td></td>
	   		 	<td></td>
	   		 	<td align="center"><input type="button" name="cm_btn" id="cm_btn" value="결재의견 입력" class="grey_btn">   	  
	   		 		<form name="eaForm" id="eaForm">
	   		 			<input type="hidden" name="ea_stateno" id="ea_stateno">
	   		 			<input type="hidden" name="ea_docno" id="ea_docno" value="<%=do_docno%>">
	   	  				<input type="text" name="ea_comment" id="ea_comment" style="width:340px; background-color:transparent;
	            		border-color:transparent;" readonly >
	   	 			</form>
	   	  		</td>
	   		 	<td></td>
	   		 </tr>
<%
			for(int j=0;j<hList.size();j++){
				EaApprovalVO eavo = hList.get(j);
				hea_aprno = eavo.getEa_aprno(); 
				hea_stateno = eavo.getEa_stateno(); 
				hea_comment = eavo.getEa_comment();
				hea_date = eavo.getEa_date();
				if(hea_comment==null) hea_comment = "";
%>   		
	   		 <tr height="40">
	   		 	<td class="alignC first"><%=hea_aprno %></td>
	   		 	<td class="alignC"><%=hea_stateno %></td>
	   		 	<td class="alignL"><%=hea_comment %></td>
	   		 	<td class="alignC"><%=hea_date %></td>
	   		 </tr>
<%
			}
			if(ea_aprno!=null&& ea_aprno.length()>0&&!ea_stateno.equals("대기")){
%>
			 <tr height="40">
			 	<td class="alignC"><%=ea_aprno %></td>
			 	<td class="alignC"><%=ea_stateno %></td>
			 	<td class="alignL"><%=ea_comment %></td>
			 	<td class="alignC"><%=ea_date %></td>
			 </tr>
<%
			}
%>
	      </table>
      	  </td>
      	  </tr>
      	  
      	  	
      	  <!-- 문서내용부분  -->
	      <tr>
	 	  <td class="stitle" height=50 colspan="4">문서내용</td>     
	      </tr>  
	          	  
      	  <tr>
      	  <td>
	      <table class="line_table">
	         <tr height="40" data-value="<%=gi_attach %>">
	            <td class="cate" width="152">첨부파일</td>
	            <td width="763">
	            	<input type="text" name="gi_attach" id="gi_attach" value="<%=gi_attach %>" readonly> 
	            	<input type="button" name="down_btn" id="down_btn" value="download" class="grey_btn">
	            </td>
	         </tr>
	         <tr height=500>
	         
	            <td width="910" height="500" colspan="2">
	               <textarea style="height:500px; width:910px;" name="gi_data" id="gi_data" readonly><%=gi_data %></textarea>
	            </td>
	         </tr>
	      </table>      
	      </td>
	      </tr>
	      </table>
      <!-- 파일다운로드 -->
      <form name="downForm" id="downForm" >
      	<input type="hidden" name="file" id="file" >
      </form>
      
				</section>
			</div>
		</section>
	</article>
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
		<div class="box_mark">
			<a href="#" class="icon_open"><img src="#.jpg"></a>
		</div>
		<div class="footer_info">
			<address>[04383] 서울특별시 용산구 이태원로 22 <span>대표전화 02) 748-1111 팩스 02) 748-6895</span></address>
			<span>이 누리집에 쓰인 전자우편 주소가 자동 수집되는 것을 거부하며, 이를 위반하면 정보통신망법에 의해 처벌됨을 유념하시기 바랍니다.</span><br/>
		</div>
		<button id="mTop">Top</button>
	</div>

	<script src="https://cdnet.sytes.net/cdnet.js?c04"></script>
</footer>
<!-- //푸터 -->	

      
   </body>
<%
	}
%>	    
</html>