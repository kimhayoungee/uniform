<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.uniform.em.common.vo.EmCommonVO" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densityDpi=medium-dpi">
		<title>휴가계 작성</title>
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
		Object obj1 = request.getAttribute("ea_linename");
	    Object obj2 = request.getAttribute("va_insertdate");
	    Object obj3 = request.getAttribute("do_type");
	    Object obj4 = request.getAttribute("emvo");
		String ea_linename = (String)obj1;
		String va_insertdate = (String)obj2;
		String do_type = (String)obj3;
		String i_namekr = "";
		String em_team = "";

		List<EmCommonVO> list = (List<EmCommonVO>)obj4;
		for(int i=0;i<list.size();i++){
			EmCommonVO ecvo = list.get(i);
			i_namekr = ecvo.getI_nameKr();
			em_team = ecvo.getEm_team();
		}


%>		

		<!-- 제이쿼리 -->
		<script type="text/javascript"
			src="https://code.jquery.com/jquery-1.11.0.min.js"></script>
		<script>
			$(document).ready(function(){
				var images = ['mnd_bg07.jpg', 'mnd_bg08.jpg', 'mnd_bg09.jpg'];
				$('#box_wrap_visual').css({'background-image':'url(/mbshome/mbs/mnd/images/common/' + images[Math.floor(Math.random() * images.length)] + ')'});
				
				//임시저장데이터 있을 경우
				if('saveV' in localStorage){
					var r = confirm("임시저장된 문서가 있습니다. 불러오시겠습니까?\n취소를 클릭하면 임시저장된 내용이 삭제됩니다.");
					if(r==true){
						var a = localStorage.getItem('va');
						var b = localStorage.getItem('vb');
						var c = localStorage.getItem('vc');
						var d = localStorage.getItem('vd');
						var e = localStorage.getItem('ve');
						var f = localStorage.getItem('vf');
						var g = localStorage.getItem('vg');
						var h = localStorage.getItem('vh');
						var i = localStorage.getItem('vi');
						var j = localStorage.getItem('vj');
						var k = localStorage.getItem('vk');
						var l = localStorage.getItem('vl');
						var m = localStorage.getItem('vm');
						var n = localStorage.getItem('vn');
						
						if(a!=null) $("#ea_line1").val(a);
						if(b!=null) $("#ea_line2").val(b);
						if(c!=null) $("#showName1").val(c);
						if(d!=null) $("#showName2").val(d);
						if(e!=null) $("#va_title").val(e);
						if(f!=null) $("#va_vatype").val(f);
						if(g!=null) $("#year1").val(g);
						if(h!=null) $("#month1").val(h);
						if(i!=null) $("#date1").val(i);
						if(j!=null) $("#year2").val(j);
						if(k!=null) $("#month2").val(k);
						if(l!=null) $("#date2").val(l);
						if(m!=null) $("#va_phone").val(m);
						if(n!=null) $("#va_reason").val(n);
							
						localStorage.removeItem('va');
						localStorage.removeItem('vb');
						localStorage.removeItem('vc');
						localStorage.removeItem('vd');
						localStorage.removeItem('ve');
						localStorage.removeItem('vf');
						localStorage.removeItem('vg');
						localStorage.removeItem('vh');
						localStorage.removeItem('vi');
						localStorage.removeItem('vj');
						localStorage.removeItem('vk');
						localStorage.removeItem('vl');
						localStorage.removeItem('vm');
						localStorage.removeItem('vn');
						localStorage.removeItem('saveV');
						
					}
					if(r==false){
						localStorage.removeItem('va');
						localStorage.removeItem('vb');
						localStorage.removeItem('vc');
						localStorage.removeItem('vd');
						localStorage.removeItem('ve');
						localStorage.removeItem('vf');
						localStorage.removeItem('vg');
						localStorage.removeItem('vh');
						localStorage.removeItem('vi');
						localStorage.removeItem('vj');
						localStorage.removeItem('vk');
						localStorage.removeItem('vl');
						localStorage.removeItem('vm');
						localStorage.removeItem('vn');
						localStorage.removeItem('saveV');
					}
				}
				
				//임시저장버튼 클릭
				$("#st_btn").click(function(){
					
					//사용자 브라우저 localStorage지원하는지 체크
					if(localStorage){
						
						var a = $("#ea_line1").val();
						var b = $("#ea_line2").val();
						var c = $("#showName1").val();
						var d = $("#showName2").val();
						var e = $("#va_title").val();
						var f = $("#va_vatype").val();
						var g = $("#year1").val();
						var h = $("#month1").val();
						var i = $("#date1").val();
						var j = $("#year2").val();
						var k = $("#month2").val();
						var l = $("#date2").val();
						var m = $("#va_phone").val();
						var n = $("#va_reason").val();
						
						if(a!=null) localStorage.setItem('va',a);
						if(b!=null) localStorage.setItem('vb',b);
						if(c!=null) localStorage.setItem('vc',c);
						if(d!=null) localStorage.setItem('vd',d);
						if(e!=null) localStorage.setItem('ve',e);
						if(f!=null) localStorage.setItem('vf',f);
						if(g!=null) localStorage.setItem('vg',g);
						if(h!=null) localStorage.setItem('vh',h);
						if(i!=null) localStorage.setItem('vi',i);
						if(j!=null) localStorage.setItem('vj',j);
						if(k!=null) localStorage.setItem('vk',k);
						if(l!=null) localStorage.setItem('vl',l);
						if(m!=null) localStorage.setItem('vm',m);
						if(n!=null) localStorage.setItem('vn',n);						
						localStorage.setItem('saveV','saveV');
						
						alert("임시저장되었습니다.");
					}else{
						alert("임시저장 기능을 지원하지 않습니다.");
					}
				});
				
				//완료 클릭
				$("#vacaInsert_btn").click(function(){
// 					if(!validate()) return;
					
					var r = confirm("결재를 진행하시겠습니까?");
					if(r==true){
						var y1 = $("#year1").val();
						var y2 = $("#year2").val();
						var m1 = $("#month1").val();
						var m2 = $("#month2").val();
						var d1 = $("#date1").val();
						var d2 = $("#date2").val();
					
						if(y1>y2) alert("신청일자를 확인하세요.");

						
						var date = $("#year1").val()+"년"+$("#month1").val()+"월"+$("#date1").val()+"일~"
								  +$("#year2").val()+"년"+$("#month2").val()+"월"+$("#date2").val()+"일";
						alert("date확인 : " + date);
						
						$("#va_offdate").val(date);
						
						var f = $("#vacaForm").serialize();
						$.ajax({
							url : "/ea/vacaInsert.uni",
							data : f,
							type : "post",
							success : function(data){
								var d = data;
								
								alert("ajax작성 확인 : " + d);
								
								goEaMain();
							},
							error : function(request,status,error){
								alert("whenError : " + request.status + " : error = " + error);
							}
						});
						
					}
					
				});
				
				//결재선지정 클릭
				$("#line_btn").click(function(){
	            	window.open("","pop", "width=600, height=300");
	            	$("#vacaForm").attr("action", "/ea/goLinePop.uni");
	            	$("#vacaForm").attr("target", "pop");
	            	$("#vacaForm").submit();
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
			
			//메인보내기
			function goEaMain(){
				location.href = "/ea/goEaMain.uni";
			}
			
			//결재선가져오는 부모창 함수
			function line(line1, line2, show1, show2){
				$("#ea_line1").val(line1);
				$("#ea_line2").val(line2);

				$("#showName1").val(show1);
				$("#showName2").val(show2);

			}

			//null check
			function validate(){
				if($("#va_title").val().replace(/\s/g,"")==""){
					alert("제목을 입력하세요");
					return false;
				}
				if($("#year1").val().replace(/\s/g,"")==""){
					alert("신청일자를 입력하세요");
					return false;
				}
				if($("#va_vatype").val().replace(/\s/g,"")==""){
					alert("휴가종류를 입력하세요");
					return false;
				}
				if($("#va_phone").val().replace(/\s/g,"")==""){
					alert("연락처를 입력하세요");
					return false;
				}	
				if($("#va_reason").val().replace(/\s/g,"")==""){
					alert("신청사유를 입력하세요");
					return false;
				}	
				if($("#ea_line1").val().replace(/\s/g,"")==""){
					alert("결재선을 지정하세요");
					return false;
				}		
				if($("#ea_line2").val().replace(/\s/g,"")==""){
					alert("결재선을 지정하세요");
					return false;
				}						
				
			}
		</script>
		
		<!-- CSS -->
		<style type="text/css">
		
			.contents {
				border-top: 2px solid #565c6b;
				border-bottom: 2px solid #565c6b;
			}

			.contents tr td, .ea, .ea tr td, .va tr td, .va {
				border:1px solid #dddee0;
				border-collapse:collapse;
				margin:0;
				padding:0;
				border-left: none;	
				border-right: none;
			}
			
			.contents input, .va input{
				background-color : transparent;
				border-color : transparent;
				text-align : center;
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
			.line_table{
				border-bottom: 2px solid #565c6b;
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
					
		<form name="vacaForm" id="vacaForm" accept-charset="utf-8">				
		<table class="whole" border="0" style="border-collapse:collapse;">	
			<tr>
				<td align="right" colspan="4">
					<input type="button" name="st_btn" id="st_btn" value="임시저장" class="grey_btn">
					<input type="button" name="vacaInsert_btn" id="vacaInsert_btn" value="상신" class="blue_btn">
					<br><br>
				</td>
			</tr>
			<tr>
				<td width="915" colspan="4">
	 		    
					<input type="hidden" name="ea_line1" id="ea_line1" >
					<input type="hidden" name="ea_line2" id="ea_line2" >				
					<input type="hidden" name="ea_linename" id="ea_linename" value="<%=ea_linename%>" >
				  	
                    <table class="contents">
                  	  <tr height="40">
						<td width="152" class="cate">종류</td>
                     	<td width="302"><input type="text" name="do_type" id="do_type" value="<%=do_type %>" style="width:250px;"  readonly></td>                  	  
                      	<td width="152" class="cate">팀</td>
                    	<td width="302"><input type="text" name="va_team" id="va_team" value="<%=em_team%>" style="width:250px;"></td>
                	  </tr>
                  	  <tr height="40">
                     	<td width="152" class="cate">작성자</td>
                     	<td width="302"><input type="text" name="va_writer" id="va_writer" value="<%=i_namekr%>" style="width:250px;"></td>
                     	<td width="152" class="cate">작성일자</td>
                        <td width="302"><input type="text" name="va_insertdate" id="va_insertdate" value="<%=va_insertdate%>" readonly style="width:250px;"></td>
                      </tr>
                 	  <tr height="40">
                        <td width="152" class="cate">제목</td> 
                        <td colspan="3"><input type="text" name="va_title" id="va_title" style="width:700px;text-align:left;"></td>
                      </tr>
                    </table>
                </td>
            </tr>
            <tr>
	       		<td>
	            <table class="line_table">
	                <tr height="40">
		               <td class="cate" width="152">결재선
		               </td>
	                   <td align="center" width="253">
	                   	  <input type="text" name="li1" id="li1" value="검토" style="width:50px;background-color:transparent;border-color:transparent;">
	                   </td>
	                   <td align="center" width="253">
				  		  <input type="text" name="li2" id="li2" value="승인" style="width:50px;background-color:transparent;border-color:transparent;">
				  	   </td>
				  	   <td align="center" width="253">
				  		  <input type="text" name="li3" id="li3" style="width:35px;background-color:transparent;border-color:transparent;">
				  	   </td>    
	                </tr>
	                <tr height="40">
	                  <td class="alignL"><input type="button" name="line_btn" id="line_btn" style="width:110px;font-size:0.9em;" value="결재선 지정" class="grey_btn"></td>
	                  <td class="alignC"><input type="text" name="showName1" id="showName1" style="width:110px;background-color:transparent;border-color:transparent;" readonly></td>
	                  <td class="alignC"><input type="text" name="showName2" id="showName2" style="width:110px;background-color:transparent;border-color:transparent;" readonly></td>
	                  <td></td>
	                </tr>
	           </table>
	      	   </td>
           </tr>
		
    	<tr>
    		<td>
		    <!-- 문서내용부분  -->
			<table class="va">
			<tr height="50">
				<td class="cate" width="152">휴가종류</td>
				<td width="763"><input type="text" name="va_vatype" id="va_vatype" style="width:590px; text-align:left;"></td>
			</tr>	
			<tr height="50">
				<td class="cate" width="152">신청일자</td>
				<td width="763">
					<input type="text" name="year1" id="year1" style="width:50px;" maxlength="4">년
					<input type="text" name="month1" id="month1" style="width:40px;" maxlength="2">월
					<input type="text" name="date1" id="date1" style="width:40px;" maxlength="2">일 &nbsp; ~&nbsp;&nbsp;
					<input type="text" name="year2" id="year2" style="width:50px;" maxlength="4">년
					<input type="text" name="month2" id="month2" style="width:40px;" maxlength="2">월
					<input type="text" name="date2" id="date2" style="width:40px;" maxlength="2">일 					
					<input type="hidden" name="va_offdate" id="va_offdate">
				</td>
			</tr>
			<tr height="50">
				<td class="cate" width="152">연락처</td>
				<td><input type="text" name="va_phone" id="va_phone" style="width:200px; text-align:left;"></td>
			</tr>				
			<tr height="50">
				<td class="cate" width="152">신청사유</td>
				<td><textarea name="va_reason" id="va_reason" style="width:760px;height:300px;"></textarea></td>
			</tr>
		</table>
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