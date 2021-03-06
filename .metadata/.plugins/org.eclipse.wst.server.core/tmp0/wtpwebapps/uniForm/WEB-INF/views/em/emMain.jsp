<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.uniform.em.common.vo.EmCommonVO" %>    
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
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
		if(i_no.indexOf("M")>-1){
			EmCommonVO ecvo = (EmCommonVO)request.getAttribute("ecvo");
			List<EmCommonVO> list = (List<EmCommonVO>)request.getAttribute("infoList");
			String keyword = (String)request.getAttribute("keyword");
			String search = (String)request.getAttribute("search");
%>			
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
		
		<title>인사 기록 카드</title>
		
		<style type="text/css">
			div.all{
				width:40%;
				margin-top:80px;
			}
			div.scrollbox{
				overflow:auto;
				height:500px;
				width:680px;
			}
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
		</style>
		
		<script type="text/javascript"
				src="/include/js/jquery-1.11.0.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				var keyword = "<%=keyword%>";
				var search = "<%=search%>";
				
				if(keyword!=null&&keyword!="null"){
					$("#keyword").val(keyword);
				}
				if(search!=null&&search!="null"){
					$("#search").val(search);
				}
				
				$("#insert_btn").on("click",function(){
					var popWidth = 700;
					var popHeight = 875;
					var popX = (window.screen.width/2) - (popWidth/2);
					var popY = (window.screen.height/2) - (popHeight/2);
					
					window.open("/em/goInsertEmp.uni", "pop", "width=" +popWidth+ ",height=" +popHeight+ ",left=" +popX+ ",top=" +popY);
				});
				
				$(".emp").on("click",function(){
					var popWidth = 720;
					var popHeight = 840;
					var popX = (window.screen.width/2) - (popWidth/2);
					var popY = (window.screen.height/2) - (popHeight/2);
					
					var i_no = $(this).attr("data-num");
					alert(i_no);
					$("#i_no").val(i_no);
					
					window.open("", "pop", "width=" +popWidth+ ",height=" +popHeight+ ",left=" +popX+ ",top=" +popY);
					$("#detailForm").attr({
						"action":"/em/goDetailEmp.uni",
						"method":"POST",
						"enctype":"application/x-www-form-urlencoded",
						"target":"pop"
					});
					
					$("#detailForm").submit();
				});
				
				$("#search_btn").on("click",function(){
					$("#detailForm").attr({
						"action":"goEmMain.uni",
						"method":"POST",
						"enctype":"application/x-www-form-urlencoded"
					});
					
					$("#detailForm").submit();
				});
			});
			
			function goEmMain(){
				location.href="/em/goEmMain.uni";
			}
		</script>		
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
					<li>
<%
			if(i_no.indexOf("E")>-1){
%>					
						<a href="#/main/goMyInfo.uni">MyPage</a>
<%
			}
%>						
					</li>
					<li><a href="/sm/logout.uni">LogOut</a></li>
				</ul>
			</div>
			<!-- // GNB -->
			<!-- LNB -->
			<div class="box_lnb">
				<div class="wrap1200 box_logo">
					<h2 style="font-size:4.5em;"> 
						<a href="/main/goMain.uni"><img src="/cssExample/img/uniform_logo.png" width="180" height="53"></a>
					</h2>
				</div>
				<nav>
					<ul>
						<li style="background-image: none;"><a href="#" id="navFirst">학교정보</a>
						</li>
						<li><a href="/ea/goEaMain.uni">전자결재</a>
						</li>
						<li><a href="#">일정관리</a>
						</li>
						<li><a href="#">학생관리</a> 
						</li>						
						<li><a href="#">공지/게시판</a>
						</li>
						<li><a href="#">인사관리</a>
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
						<a href="#none">인사관리</a>
					</div>				
				</li>
				<li>
					<div class="nav_title">
						<a href="#none">></a>
					</div>
				</li> 		
				<li> 
					<div class="nav_title">
						<a href="#none">인사기록카드</a>
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
		<h2>인사관리</h2>
	</div>
	<!-- SNB -->
	<nav>
		<ul>		
			<li class="on"><a href="/em/goEmMain.uni">인사기록카드</a></li> 
			
		</ul>
	</nav>
	<!-- // SNB -->
</div>	
	<!-- 컨텐츠 -->	
	
		<div id="box_conts" align="center">			
				<h2 style="font-weight:bold; text-align:left;">인사 기록 카드</h2>
				<article id="skipnav">
		<!-- 컨텐츠 내용 --> 
		<section class="">
			<div id="printContents"> 
				<section class="marB40">
			
			</div>
			<fieldset>
					<div class="marB10">
						<span style="float: left; margin-left:112px; margin-bottom:5px;"><input type="button" class="blue_btn" id="insert_btn" value="교직원등록"></span>
					</div>
			</fieldset> 
				
				<p>
				
				</p>
				<div class="scrollbox">
				
				<div class="table_wrap">
					<table border="0">
						<tr>
							<th width="150px" align=center>사원 번호</th>
							<th width="150px" align=center>사원 이름</th>
							<th width="150px" align=center>처</th>
							<th width="150px" align=center>입사일자</th>
						</tr>
<%
			for(int i=0;i<list.size();i++){
				EmCommonVO vo = list.get(i);
%>
						<tr class="emp" data-num="<%=vo.getI_no() %>">
							<td align=center><%=vo.getI_no() %></td>
							<td align=center><%=vo.getI_nameKr() %></td>
							<td align=center><%=vo.getEm_dept() %></td>
							<td align=center><%=vo.getEm_hireDate() %></td>
						</tr>
<%				
			}
%>						

					</table>					
		</div>
		<form id="detailForm">
				<input type="hidden" id="i_no" name="i_no">
				<select id="keyword" name="keyword">
					<option value="">전체</option>
					<option value="11">기획처</option>
					<option value="12">교학처</option>
					<option value="13">사무처</option>
					<option value="14">국제협력처</option>
				</select>
				<input type="text" id="search" name="search" placeholder="이름">
				<input type="button" class="blue_btn" id="search_btn" value="검색">
			</form>
				</div>
				</section>
				
			</div>
		</section>
	</article>
			
			</div>	
			</div>
			
			
		
		
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

	</body>
<%
		}// 관리자 계정여부 if문
	}// 부여받은 session 체크 if문
%>	
</html>