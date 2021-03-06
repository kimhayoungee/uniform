<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.text.SimpleDateFormat" %>
<%@ page import = "java.util.Date" %>
<%@ page import="com.uniform.em.common.vo.EmCommonVO" %>
<%
   Object obj1 = request.getAttribute("ea_lineno");
   Object obj2 = request.getAttribute("i_no");
   String ea_lineno = (String)obj1;
   String i_no = (String)obj2;   
   
   SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
   Date time = new Date();
   String time1 = date.format(time);
   
   EmCommonVO ecvo = (EmCommonVO)request.getAttribute("ecvo");

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0
      , maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densityDpi=medium-dpi">
      	<title>품의서 작성</title>
      
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
      
      <!-- 제이쿼리 -->
      <script type="text/javascript"
         src="https://code.jquery.com/jquery-1.11.0.min.js"></script>
      <script type="text/javascript">
         
         $(document).ready(function(){
        	 $("#lineInsert_btn").click(function(){
             	alert("결재라인지정 클릭");
             	window.open("", "pop", "width=500, height=550");
             	$("#eaPoomForm").attr("action", "/ea/goEalinePop.uni");
             	$("#eaPoomForm").attr("target", "pop");
                 $("#eaPoomForm").submit();
             }); 
        	 
       	 $(document).ready(function(){
              $("#poomInsert_btn").click(function(){           
                $("#eaPoomForm").attr("action", "/ea/poomFormInsert.uni");
                $("#eaPoomForm").submit();               
             });            
           });                
         });
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
				border-bottom: 2px solid #d9d9d9; 
			}
			
 			/*내용의 5줄 높이 */
			table tr {
				height: 30px;
			}
			
 			/*분류하는부분 높이 */
			table .contents{
				height: 25px;
				font-size: 15px;
				border-bottom: 2px solid #d9d9d9; 
			}
			
			.whole .none{
				width: 15px;
			}			
			
			table .con_type{
				width: 40px;
			}

			table .con_title{
				width: 230px;
			}			
			
			table .con_state{
				width: 50px;
			}
			
			table .con_hu{
				width: 52px;
			}			
			
			table .con_date{
				width: 65px;
			}
			.cate{
				font-weight: bold;
				text-align:center;
			}
			.cate2{
				font-weight: bold;
				text-align:right;
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
					<li><a href="#"><%=ecvo.getI_nameKr() + " " + ecvo.getI_no() %></li>
					<li><a href="/main/goMyInfo.uni">MyPage</a></li>
					<li><a href="/sm/logout.uni">LogOut</a></li>
				</ul>
			</div>
			<!-- // GNB -->
			<!-- LNB -->
			<div class="box_lnb">
				<div class="wrap1200 box_logo">
					<h2 style="font-size:4.5em;"> 
						<a href="#"><img src="/cssExample/img/uniform_logo.png" width="180" height="53"></a>
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
	<p></p>
	<p></p>
	
	<div class="box_cate_name mnd01">
		<h2></h2>
	</div>
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
						<a href="#none">품의서 작성</a>
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
		<h2>전자결재</h2>
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
			<li><a href="/ea/goUploadList.uni">양식 다운로드</a></li>
		</ul>
	</nav>
	<!-- // SNB -->
</div>
   
   <!-- 컨텐츠 -->
   	  <div id="box_conts">	
	<article id="skipnav">
		<section class="title_cont">
		</section> 
		<!-- 컨텐츠 내용 --> 
		<section class="box_instruc_con">
			<div id="printContents"> 
				<section class="marB40">
      <form name="eaPoomForm" id="eaPoomForm" enctype="multipart/form-data" method="post">
            	            
               <input type="button" class="blue_btn" name="poomInsert_btn" id="poomInsert_btn" value="상신">
               <input type="button" class="grey_btn" name="lineInsert_btn" id="lineInsert_btn" value="결재라인지정">
          
         
            <h2 colspan="2" height="80" style="text-align:left; font-size:30px;">품의서 작성 </h2>
         
      <div class="table_wrap">
      <table border="0" style="border-collapse:collapse;">    
         
         <tr>
            
            <td width="350">
            <!-- 공통부분(파일업로드,폼) -->      
               <input type="hidden" name="i_no" id="i_no" value="<%=i_no%>">                
               <input type="hidden" name="ea_lineno" id="ea_lineno" value="<%=ea_lineno%>">
                
               
               <table class="eadocument" align="left">
                  <tr height="35">
                     <td width="100" class=cate>작성일자   :</td>
                     <td><input type="text" name="po_insertdate" id="po_insertdate" value="<%=time1 %>" style="width:200px;"></td>
                  </tr>
                  <tr height="35">
                     <td class=cate>결재라인명   :</td>
                     <td><input type="text" name="ea_linename" id="ea_linename" value="품의" style="width:200px;"></td>
                  </tr>
                  <tr height="35">
                     <td class=cate>팀   :</td>
                     <td><input type="text" name="po_team" id="po_team" style="width:200px;"></td>
                  </tr>
                  <tr height="35">
                     <td class=cate>작성자   :</td>   <!-- 작성자명 -->
                     <td><input type="text" name="po_writer" id="po_writer" value="<%=i_no %>"style="width:200px;"></td>
                  </tr>
                  <tr height="35">
                     <td class=cate>제목   :</td>
                     <td><input type="text" name="po_title" id="po_title" style="width:200px;"></td>
                  </tr>
                  <tr height="35">
          			  <td width="99px" class=cate>첨부파일   :</td>
         			   <td><input type="file" name="po_attach" id="po_attach" style="width:250px;"></td>
        		  </tr>
                  </table>
                  
            </td>
                 
            <td  width="400">
               <!-- 결재라인 -->
               
               <table class="ea" align="right">
            
            <tr>
	 			<td class=cate2>1차결재자   :</td>
	 			<td align="center"><input type="text" name="ea_line1" id="ea_line1" readonly></td></tr>
	 		<tr>
	 			<td class=cate2>2차결재자   :</td>
	 			<td align="center"><input type="text" name="ea_line2" id="ea_line2" readonly></td></tr>
	 		<tr>
	 			<td class=cate2>3차결재자   :</td>
	 			<td align="center"><input type="text" name="ea_line3" id="ea_line3" readonly></td></tr> 
                  
               </table>
              
            </td>             
                      
         </tr>
      </table>
      </div>
      <!-- 문서내용부분  -->
      <table class="eapoom">
         
         <tr height=500>
         
            <td width="800" height="500" colspan="2">
               <textarea style="height:500px; width:880px;" name="po_data" id="po_data">내용</textarea>
            </td>
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
      
      <!-- 컨텐츠 끝 -->
      
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
</html>