<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.uniform.ea.approval.vo.EaVacationVO" %>    
<%@ page import="com.uniform.ea.approval.vo.EaApprovalVO" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densityDpi=medium-dpi">
      <title>휴가계 상세</title>
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
			
	   Object obj1 = request.getAttribute("list");
	   List<EaVacationVO> list = (List<EaVacationVO>) obj1;
	   String do_docno = "";
	   String do_type = "";
	   String do_writer = "";
	   String do_title = "";
	   String do_insertdate = "";
	   String va_vatype = "";
	   String va_offdate = "";
	   String va_phone = "";
	   String va_reason = "";
	   
	   for(int i=0;i<list.size();i++){
		   EaVacationVO evvo = list.get(i);
		   do_docno = evvo.getDo_docno();
		   do_type = evvo.getDo_type();
		   do_writer = evvo.getDo_writer();
		   do_title = evvo.getDo_title();
		   do_insertdate = evvo.getDo_insertdate();
		   va_vatype = evvo.getVa_vatype();
		   va_offdate = evvo.getVa_offdate();
		   va_phone = evvo.getVa_phone();
		   va_reason = evvo.getVa_reason();
	   }
	   
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
	   
	   //히스토리에 있는 결재 의견 
	   Object obj3 = request.getAttribute("hList");
	   List<EaApprovalVO> hList = (List<EaApprovalVO>)obj3;
%>      
      <!-- 제이쿼리 -->
      <script type="text/javascript"
         src="https://code.jquery.com/jquery-1.11.0.min.js"></script>
      <script>
         $(document).ready(function(){
        	$("#delete_btn").hide();
        	
        	var images = ['mnd_bg07.jpg', 'mnd_bg08.jpg', 'mnd_bg09.jpg'];
			$('#box_wrap_visual').css({'background-image':'url(/mbshome/mbs/mnd/images/common/' + images[Math.floor(Math.random() * images.length)] + ')'});

			var state = "<%=ea_stateno%>";
			alert("state" + state);
			
			if(state=="대기") $("#delete_btn").show();
            
            $("#delete_btn").click(function(){
            	var r = confirm("상신을 취소하시겠습니까?");
				if(r==true){
	            	$("#vacaForm").attr("action", "/ea/docDelete.uni");
	            	$("#vacaForm").submit();
				}
            });            
         });
      </script>
      
      <!-- CSS -->
      <style type="text/css">
         .eadocument input{
            background-color : transparent;
            border-color : transparent;
            text-align : center;
         }

         .eadocument, .eadocument tr td, .ea, .ea tr td,
         .va, .va tr td, .comment, .comment tr td
         {
            border:1px solid black;
            border-collapse:collapse;
            margin:0;
            padding:0;
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
						<a href="#none">휴가계 작성</a>
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
			<li class="on"><a class="more">결재문서 작성</a>			
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
			<li><a href="#">양식 다운로드</a></li>
		</ul>
	</nav>
	<!-- // SNB -->
</div>	

<!-- 컨텐츠 -->
<div id="box_conts">	
	<article id="skipnav">
		<section class="title_cont">
			<h1 class="title">기안서 작성</h1>
		</section> 	
		<!-- 컨텐츠 내용 --> 
		<section class="box_instruc_con">
			<div id="printContents"> 
				<section class="marB40">	
				  
   
      <form name="vacaForm" id="vacaForm">
      <table border="0" style="border-collapse:collapse; margin:0; padding:0;">    
         <tr>
            <td colspan="2" align="right">
               <input type="button" name="delete_btn" id="delete_btn" value="상신 취소" class="grey_btn">
               <input type="hidden" name="do_docno" id="do_docno" value="<%=do_docno %>" >
            </td>
         </tr>
         <tr height="70" >
            <td colspan="2" style="text-align:center; font-size:30px;">휴 가 계 </td>
         </tr>
         <tr>
            <td width="470">
               
               <table class="eadocument">
                  <tr height="35">
                     <td width="150" align="center">종류</td>
                     <td width="310"><%=do_type %></td>
                  </tr>
                  <tr height="35">
                     <td width="150" align="center">작성자</td>
                     <td width="310"><%=do_writer %></td>
                  </tr>
                  <tr height="35">
                     <td width="150" align="center">제목</td> 
                     <td width="310"><%=do_title %></td>
                  </tr>
                  <tr height="35">
                     <td width="150" align="center">작성일자</td>
                     <td width="310"><%=do_insertdate %></td>
                  </tr>
               </table>
            </td>
            
            <td align="right">
               <!-- 결재도장부분 -->
               <table class="ea">
                  <tr height="35">
                     <td rowspan="2" width="30" align="center">결재</td>
                     <td width="120" align="center">1차결재</td>
                     <td width="120" align="center">결재</td>
                  </tr>
                  <tr height="105">
                     <td><img src="<%=ea_sign1 %>" width="120" height="105" alt=""></td>
                     <td><img src="<%=ea_sign2 %>" width="120" height="105" alt=""></td>
                  </tr>
               </table>
            </td>
         </tr>
      </table>
 
      <!-- 결재의견부분 -->
<%
		if(!ea_stateno.equals("대기")){
%>      
      <table class="comment">
		 <tr height="35">
   			<td width="100" align="center">결재자</td>
   			<td width="100" align="center">결재내용</td>
   			<td width="343" align="center">결재의견</td>
   			<td width="200" align="center">결재일시</td>
   		 </tr>
<%
			for(int j=0;j<hList.size();j++){
				EaApprovalVO eavo = hList.get(j);
				String hea_aprno = eavo.getEa_aprno(); //이름
				String hea_stateno = eavo.getEa_stateno(); //상태디테일
				String hea_comment = eavo.getEa_comment();
				String hea_date = eavo.getEa_date();
				if(hea_comment==null) hea_comment = "";
%>   		
   		 <tr height="35">
   		 	<td><%=hea_aprno %></td>
   		 	<td><%=hea_stateno %></td>
   		 	<td><%=hea_comment %></td>
   		 	<td><%=hea_date %></td>
   		 </tr>		
   		 
<%
			} //for문
%>

		 <tr height="35">
		 
		 	<td><%=ea_aprno %></td>
		 	<td><%=ea_stateno %></td>
		 	<td><%=ea_comment %></td>
		 	<td><%=ea_date %></td>
		 </tr>
      </table>	
<%
		} //if문
%>      

      <!-- 문서내용부분  -->
      <table class="va">
			<tr>
				<td width="150" height="50" align="center">휴가종류</td>
				<td width="590" align="left"><%=va_vatype %></td>
			</tr>	
			<tr>
				<td height="50" align="center">신청일자</td>
				<td width="590" align="left"><%=va_offdate %></td>
			</tr>
			<tr>
				<td height="50" align="center">연락처</td>
				<td width="590" align="left"><%=va_phone %></td>
			</tr>				
			<tr>
				<td height="50" align="center">신청사유</td>
				<td><textarea name="va_reason" id="va_reason" style="width:590px;height:200px;"><%=va_reason %></textarea></td>
			</tr>
      </table>   
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