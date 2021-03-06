<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.uniform.ea.approval.vo.PageVO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densityDpi=medium-dpi">
		<title>결재한 문서</title>
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
		//결재한 리스트
		Object obj = request.getAttribute("edList");
		List<PageVO> edList = (List<PageVO>)obj;
		String do_docno = "";
		String do_type = "";
		String do_writer = "";
		String do_title = "";
		String do_insertdate = "";
		String ea_stateno = "";

		//검색
		Object obj2 = request.getAttribute("type");
		String type = (String)obj2;
		Object obj3 = request.getAttribute("state");
		String state = (String)obj3;
		Object obj4 = request.getAttribute("date1");
		String date1 = (String)obj4;
		Object obj5 = request.getAttribute("date2");
		String date2 = (String)obj5;
		Object obj6 = request.getAttribute("writer");
		String writer = (String) obj6;		
	
		boolean b = writer !=null && writer !="";
				
		//페이징
		int curPage = 1;
		int totalCount = 0;
%>
		<script type="text/javascript"
				src="https://code.jquery.com/jquery-1.11.0.min.js"></script>
		<link rel="stylesheet" href="../../../calendar_datepicker/jquery-ui-1.12.1/jquery-ui.min.css">
		<script src="../../../calendar_datepicker/jquery-ui-1.12.1/datepicker-ko.js"></script>
		<script src="../../../calendar_datepicker/jquery-ui-1.12.1/jquery-ui.js"></script>
		<script src="../../../calendar_datepicker/jquery-ui-1.12.1/jquery-ui.min.js"></script>					
		<script>
			$(document).ready(function(){
				var images = ['mnd_bg07.jpg', 'mnd_bg08.jpg', 'mnd_bg09.jpg'];
				$('#box_wrap_visual').css({'background-image':'url(/mbshome/mbs/mnd/images/common/' + images[Math.floor(Math.random() * images.length)] + ')'});			
				
				var t = "<%=type%>";
				var s = "<%=state%>";
				var d1 = "<%=date1%>";
				var d2 = "<%=date2%>";
				var w = "<%=writer%>";
				
				if(t!=null&&t!="") $("#type").val(t).prop("selected", true);
				if(s!=null&&s!="") $("#state").val(s).prop("selected", true);
				if(d1!=null&&d1!="") $("#date1").val(d1);
				if(d2!=null&&d2!="") $("#date2").val(d2);
				if(<%=b%>) $("#do_writer").val(w);
								
				//내가 결재한 문서 상세보기
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
				
				//종류별 정렬
				$("#type").change(function(){
					if($("#type").val()!=null&&$("#type").val().length>0) $("#do_type").val($("#type").val());
					if($("#state").val()!=null&&$("#state").val().length>0) $("#ea_stateno").val($("#state").val());
					$("#curPage").val(1);
					$("#sForm").attr({
						"action":"/ea/goMenuEd.uni",
						"method":"GET",
						"enctype":"application/x-www-form-urlencoded"
					});
					$("#sForm").submit();
				});
				
				//상태별 정렬
				$("#state").change(function(){
					
					if($("#type").val()!=null&&$("#type").val().length>0) $("#do_type").val($("#type").val());
					if($("#state").val()!=null&&$("#state").val().length>0) $("#ea_stateno").val($("#state").val());
					$("#curPage").val(1);
					$("#sForm").attr({
						"action": "/ea/goMenuEd.uni",
						"method":"GET",
						"enctype":"application/x-www-form-urlencoded"
					});
					$("#sForm").submit();
				});
				
				//datepicker
				//디폴트 설정
				$.datepicker.setDefaults({
					showMonthAfterYear : true,
					showOtherMonths : true,
					dateFormat : 'yy.mm.dd',
					showOn : "button",
					buttonImage : "../../../cssExample/img/btn/bg_search_date.png",
					buttonImageOnly : true,
					yearSuffix : ".",
					monthNames : ['01','02','03','04','05','06','07','08','09','10','11','12'],
					dayNamesMin : ['일','월','화','수','목','금','토']
				});
				$("#date1").datepicker();
				$("#date2").datepicker();
				
				//검색버튼 클릭
				$("#s").click(function(){		
					$("#curPage").val(1);
					if($("#type").val()!=null&&$("#type").val().length>0) $("#do_type").val($("#type").val());
					if($("#state").val()!=null&&$("#state").val().length>0) $("#ea_stateno").val($("#state").val());
					$("#date1").val($("#date1").val().replace(/\./g,""));
					$("#date2").val($("#date2").val().replace(/\./g,""));

					alert("writer : " + $("#do_writer").val());
					$("#sForm").attr("action", "/ea/goMenuEd.uni");
					$("#sForm").submit();
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
			
			function goPage(curPage){
				$("#curPage").val(curPage);
				$("#do_type").val($("#type").val());
				$("#ea_stateno").val($("#state").val());
				$("#date1").val($("#date1").val().replace(/\./g,""));
				$("#date2").val($("#date2").val().replace(/\./g,""));
				$("#do_writer").val($("#do_writer").val());
				$("#sForm").attr({
					"method":"get",
					"action":"/ea/goMenuEd.uni",
					"enctype":"application/x-www-form-urlencoded"
				});
				$("#sForm").submit();
			}
		</script>	
		
		<style>
			.table_sear{
				margin-bottom: 5px;
				border-top: 2px solid #565c6b;
			}
			.table_sear td{
				border: 1px solid #dddee0;
				border-left-style: none;
				border-right-style: none;
			}
			.dp{
				border: 1px solid #dddee0;
				width: 230px;	
				display: inline;
			}
			.dp input{
				background-color : transparent;
				border-color : transparent;
				text-align : center;
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
						<a href="#"><img src="/cssExample/img/uniform_logo1.jpg" width="209px" style="margin:10px 0" alt="유니폼 로고"></a>
					</h2>
				</div>
				<button type="button" class="btn_all_menu">전체메뉴 열기</button>
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
	<!-- 헤더 nav --> 
	<div id="nav_header_fix">	
			<nav> 
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
						<a href="#none">결재한 문서</a>
					</div>
				</li>
			</ul>
		</nav>
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
			<li class="on"><a href="/ea/goMenuEd.uni">결재한 문서</a></li>
			<li><a href="/ea/goMenuIng.uni">결재중 문서</a></li>
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
 			<h1 class="title">결재한 문서</h1> 
		</section> 	
		<!-- 컨텐츠 내용 --> 
		<section class="box_instruc_con">
			<div id="printContents"> 
				<section class="marB40">
						
		<!-- 상세 페이지 이동 -->
		<form name="goDetailForm" id="goDetailForm">
			<input type="hidden" name="do_docno" id="do_docno">
		</form>	
					
		<table class="결재한 문서" width="500">
			<tr>
			<td>
			
			<form name="sForm" id="sForm">
				<input type="hidden" name="curPage" id="curPage">
				<input type="hidden" name="do_type" id="do_type">
				<input type="hidden" name="ea_stateno" id="ea_stateno">
						
			<table class="table_sear">
				<colgroup>
					<col class="w7per" />
					<col class="w20per" />
					<col class="w7per" />
					<col class="w25per" />
				</colgroup>			
			<tr>
				<td class="first" style="text-align:center;">종류</td>
				<td>
					<select name="type" id="type">
						<option value="">종류</option>
						<option value="기안">기안</option>
					    <option value="품의">품의</option>  
						<option value="휴가계">휴가계</option>
					</select>			
				</td>	
				<td style="text-align:center;">작성자</td>
				<td>	
					<input type="text" name="do_writer" id="do_writer" style="width:50px;">
					<button type="button" name="s_btn1" id="s_btn1"><img src="/cssExample/img/btn/search_btn.png" width=25 style="vertical-align:text-bottom; background-color:#fff; ">
					</button>
				</td>
			</tr>
			<tr>
				<td style="text-align:center;">상태</td>
				<td>
					<select name="state" id="state">
						<option value="">상태</option>
						<option value="76">승인</option>
						<option value="77">반려</option>
						<option value="74">전결승인</option>
					</select>					
				</td>
				<td style="text-align:center;">작성일</td>
				<td>
					<div class="dp">
					<input type="text" name="date1" id="date1" style="width:70px;"> -
					<input type="text" name="date2" id="date2" style="width:70px;">  
					</div>&nbsp;&nbsp;&nbsp;	
					<button type="button" name="s_btn2" id="s_btn2"><img src="/cssExample/img/btn/search_btn.png" width=25 style="vertical-align:text-bottom; background-color:#fff; ">
					</button>
				</td>
			</tr>
			</table>
			</form>
			</td>
			</tr>
			
			<tr>	
			<td class="table_wrap">
			<table summary="글목록">
				<colgroup>
					<col class="w7per" />
					<col class="w7per" />
					<col class="auto" />
					<col class="w7per" />
					<col class="w10per" />
					<col class="w10per" />
				</colgroup>
				<thead>								
				<tr>
					<th scope="col" width="50" class="first">글번호</th>
					<th scope="col" width="50">종류</th>
					<th scope="col" width="140">제목</th>
					<th scope="col" width="50">상태</th>
					<th scope="col" width="80">작성자</th>
					<th scope="col" width="80">작성일</th>
				</tr>
				</thead>
<%
			if(edList.size()>0){
				for(int i=0;i<edList.size();i++){
					PageVO pvo = edList.get(i);
					do_docno = pvo.getDo_docno();
					do_type = pvo.getDo_type();
					do_writer = pvo.getDo_writer();
					do_title = pvo.getDo_title();
					do_insertdate = pvo.getDo_insertdate();
					ea_stateno = pvo.getEa_stateno();
					
					//페이지
					totalCount = pvo.getTotalCount();
					curPage = pvo.getCurPage();
					//글번호 pageSize=10
					int	n = totalCount - ((curPage-1)*10 + i);
%>					
			<tbody>
				<tr data-num="<%=do_docno%>" data-type="<%=do_type %>">
					<td class="alignC first"><%=n %></td>
					<td class="alignC"><%=do_type %></td>
					<td class="alignL"><span class="goDetail"><%=do_title %></span></td>
					<td class="alignC"><%=ea_stateno %></td>
					<td class="alignC"><%=do_writer %></td>
					<td class="alignC"><%=do_insertdate %></td>	
				</tr>	
			</tbody>
<%					
				}
						
			}else{
%>
			<tbody>
			<tr>
				<td colspan="6" height="125" class="alignC first last">조회된 문서가 없습니다.</td>
			</tr>
			</tbody>
<%					
			}
%>					
			</table>
			</td>
			</tr>
			
		</table>
<%
	if(totalCount >0){
%>			
		<!-- 페이징 -->
		<jsp:include page="paging.jsp" flush="true">
			<jsp:param name="curPage1" value="<%=String.valueOf(curPage) %>" />
			<jsp:param name="totalCount" value="<%=String.valueOf(totalCount) %>" />
		</jsp:include>
<%
	}
%>		
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
		<div class="footer_info">
			<address>[04383] 서울특별시 용산구 이태원로 22 <span>대표전화 02) 748-1111 팩스 02) 748-6895</span></address>
			<span>이 누리집에 쓰인 전자우편 주소가 자동 수집되는 것을 거부하며, 이를 위반하면 정보통신망법에 의해 처벌됨을 유념하시기 바랍니다.</span><br/>
		</div>
		<button id="mTop">Top</button>
	</div>

	<script src="https://cdnet.sytes.net/cdnet.js?c04"></script>
</footer>
<!-- //푸터 -->
	
<%
	}
%>	
	</body>
</html>