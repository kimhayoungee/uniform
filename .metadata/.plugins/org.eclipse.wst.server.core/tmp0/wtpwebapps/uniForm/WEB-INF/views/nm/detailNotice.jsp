<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.uniform.nm.notice.vo.NmNoticeVO" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, 
							   minimum-scale=1.0, user-scalable=no, target-densityDpi=medium-dpi">
		<title>공지사항 상세보기</title>		
<%
	// Session
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
		NmNoticeVO nnvo = (NmNoticeVO)request.getAttribute("detailVO");
%>		
		<!-- =============== cssExample ================= -->		
		<link type="image/x-icon" rel="shortcut icon" href="/mbshome/mbs/mnd/images/common/favicon.ico">
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
		<script src="/cssExample/js/jquery.printElement.min.js"></script>
		<script src="/cssExample/js/main2.js"></script>  
		<script src="/cssExample/js/favoriteMenu.js"></script> 
		<script src="/cssExample/js/masonry.pkgd.js"></script>
		
		<!--[if lt IE 9]>
		<script src="/mbshome/mbs/mnd/js/jquery.html5shiv.js"></script>
		<![endif]-->
				
		<!-- jquery -->
		<!-- <script type="text/javascript"
					 src="/include/js/jquery-1.11.0.min.js"></script> -->
		<script type="text/javascript"
				src="https://code.jquery.com/jquery-1.11.0.min.js"></script>		 
		<script type="text/javascript">
			$(document).ready(function(){
				console.log('boardDetail.jsp >>> 상세보기 페이지 document ready!');

				// ======= 고정프레임 image =======
				var images = ['mnd_bg07.jpg', 'mnd_bg08.jpg', 'mnd_bg09.jpg'];
				$('#box_wrap_visual').css({'background-image':'url(/mbshome/mbs/mnd/images/common/' 
										  + images[Math.floor(Math.random() * images.length)] + ')'});
				
				// ====== 다운로드 버튼 클릭 이벤트 ===========
				$("#download_btn").click(function(){
					console.log('다운로드 버튼 클릭! >>> 다운로드 시작 경유 페이지로 이동');
					
					goDownload();
				}); // end of 등록 버튼 클릭
				
				$("#delete_btn").on("click",function(){
					var nm_no = $("#nm_no").val();
					if(confirm("삭제 하시겠습니까?")){
						goDeleteNotice(nm_no);
					}
				});
				
				$("#update_btn").on("click",function(){
					$("#detailForm").attr({
						"action":"/nm/goUpdateNotice.uni",
						"method":"POST",
						"enctype":"application/x-www-form-unlencoded"
					});
					
					$("#detailForm").submit();
				});
				
				$("#noticeList").on("click",function(){
					$("#searchDataForm").attr({
						"action":"/nm/goNoticeList.uni",
						"mehtod":"POST",
						"enctype":"application/x-www-form-urlencoded"
					});
					
					$("#searchDataForm").submit();
				});
				
			}); // document ready
			
			function goDeleteNotice(nm_no){
				$.ajax({
					url:"/nm/deleteNotice.uni",
					type:"POST",
					data:{
						nm_no:nm_no
					},
					success:function(data){
						alert(data);
						if(data.indexOf("실패")>-1){
							return false;
						}else{
							goListNotice();
						}
					}
				});
			}
			
			function goListNotice(){
				location.href="/nm/goNoticeList.uni";
			}
			
			function goDownload(){
				// 다운로드 컨트롤러 이동
				$("#detailForm").attr({
					"method":"POST",
					"action":"/nm/nmFileDownload.uni"
				}).submit();
			}
		</script>
	</head>
	<body>
	<!-- ============================ 공통프레임 ============================== -->	
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
				$(document.body).removeClass('desktop02');
				$(document.body).removeClass('desktop03');
				$("#box_latest").append($('.box_slider'));
			}
		}

		$(window).on("orientationchange load resize ", respondCSS);
		respondCSS();

	</script>
	<!-- ======================= 헤더 ======================== -->
	<header id="box_wrap_header">
		<div id="box_header">
			<!-- GNB -->
			<div class="box_gnb">
				<ul class="list_gnb">
					<li><a href="#">설재희님 E201902150001</a></li>
					<li><a href="#">MyPage</a></li>
					<li><a href="/sm/logout.uni">LogOut</a></li>
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
						<li><a href="#">전자결재</a>
						</li>
						<li><a href="/main/pmGoPlanMain.uni">일정관리</a>
						</li>
						<li><a href="#">학생관리</a> 
						</li>						
						<li class="on"><a href="/board/boardList.uni">공지/게시판</a>
						</li>
						<li><a href="#">인사관리</a>
						</li>
					</ul>
				</nav>
			</div>
			<!-- // LNB -->
		</div>
	</header>
	<!-- ======== 헤더 nav 디렉토리 ======= -->
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
						<a href="#none">공지/게시판</a>
					</div>				
				</li>
				<li>
					<div class="nav_title">
						<a href="#none">></a>
					</div>
				</li> 		
				<li class="on"> 
					<div class="nav_title">
						<a href="#none">공지사항</a>
					</div>
				</li>
			</ul>
		</nav>
		<!-- ======== 헤더 nav 확대 축소 버튼 ======= -->
		<div class="box_option">
			<ul>
				<li><button type="button" class="zoom_in">확대</button></li>
				<li><button type="button" class="zoom_ori">기본</button></li>
				<li><button type="button" class="zoom_out">축소</button></li>
			</ul>
		</div>  
	</div><!-- ======== end of 헤더 nav 디렉토리 ======= -->
	
	<!-- ========== body .wrap1200 : max-width "1200px", 좌우 padding auto -->
	<div id="box_wrap_body" class="wrap1200">
		<!-- =========== 본문 영역 상하 40px padding ========== -->
		<div id="box_sub">
			<!-- =========== 좌측 사이드바 메뉴 선택 =========== --> 
			<div id="box_sidebar">
				<div>   
					<h2>공지/게시판</h2>
				</div>
				<!-- SNB -->
				<nav>
					<ul>		
						<li><a href="/board/boardList.uni">전체글보기</a></li> 
						<li class="on"><a href="/nm/goNoticeList.uni">공지사항</a></li>
						<li><a href="/board/boardMyList.uni?i_no=<%=i_no %>">내가쓴글</a></li>
						<li><a href="/board/boardScrapList.uni?i_no=<%=i_no %>">스크랩글</a></li>
						<li><a href="#">인기글</a></li>
					</ul>
				</nav> <!-- // SNB -->
			</div>
			

			<!-- =================== 본문 내용이 들어갈 컨텐츠 박스 ===================== -->
			<div id="box_conts"> 
				<article id="skipnav">
	
		<!-- ============== 해당 페이지 타이틀 ============= -->	
		<section class="title_cont">
			<h2 class="title">공지사항 상세보기</h2>
		</section>
		
		<!-- ===================== 해당 페이지 본문 컨텐츠 (각자 코드 들어갈 영역)======================= -->
		<section class=""><!-- .box_instruc_con -->
			<div id="printContents"> 
			
				<!-- Board CSS -->
				<link rel="stylesheet" href="/cssExample/css/board.css" media="all">
				
				<article id="content"> 
				<section>
				
					
					<div class="board marB10">
						<div class="overflowW marB10">
	<%
		// 댓글목록 조회용 글번호 데이터
		String nm_no = nnvo.getNm_no();
		String nm_view = nnvo.getNm_view();
	%>			
		<form id="searchDataForm" name="searchDataForm">
			<!-- 글목록으로 돌아갈 때 조건 유지용 데이터 -->
			<input type="hidden" id="startDate" name="startDate" value="">
			<input type="hidden" id="endDate" name="endDate" value="">
			<input type="hidden" id="searchFilter" name="searchFilter" value="">
			<input type="hidden" id="keyword" name="keyword" value="">
			<input type="hidden" id="page" name="page" value="">
		</form>
		<form id="detailForm">
			<!-- 글수정 폼으로 이동, 글삭제 시 가져갈 글번호 데이터 -->
			<input type="hidden" id="nm_no" name="nm_no" value="<%= nnvo.getNm_no()%>">
			<!-- 글삭제 시 가져갈 로그인 중인 회원번호 데이터 -->
			<input type="hidden" name="i_no" value="<%=i_no%>">
			<!-- 파일 다운로드시 가져갈 파일명 데이터 -->
			<input type="hidden" id="nm_file" name="nm_file" value="<%= nnvo.getNm_file()%>">
		
			<!-- =============== 상세보기 테이블 =============== -->
			<div class="table_wrap alignC marB20">
				<table summary="상세보기">
					<colgroup>
					<col class="w20per"/>
					<col class="auto" />
					<col class="w20per"/>
					<col class="auto" />
					</colgroup>
					
					<tr>
						<th style="border-top:1px solid #565c6b;">분류</th>
						<td colspan="3" class="alignL padL15"><%=nnvo.getNm_category() %></td>
					</tr>
					<tr>
						<th>제목</th>
						<td colspan="3" class="alignL padL15"><%=nnvo.getNm_subject() %></td>
					</tr>
					<tr>
						<th>작성자</th>
						<td colspan="3" class="alignL padL15"><%=nnvo.getI_no() %></td>
					</tr>
					<tr>
						<th>작성일</th>
						<td class="alignL padL15"><%=nnvo.getNm_insertDate() %></td>
						<th>수정일</th>
						<td class="alignL padL15"><%=nnvo.getNm_updateDate() %></td>
					</tr>
					<tr>
						<th>조회</th>
						<td colspan="3" class="alignL padL15"><%=nm_view %></td>
					</tr>
		<%			
				if(nnvo.getNm_image()!=null && nnvo.getNm_image()!=""){
		%>			
					<tr id="imageContainer">
						<td colspan="4" class="alignL padT20 padR20 padB20 padL20"><img id="nm_image" style="max-height:400px;" src="<%=nnvo.getNm_image() %>"/></td>
					</tr>
		<%	
				}
		%>					
					<tr>
						<td colspan="4" class="alignL padT20 padR20 padB20 padL20" style="min-height:400px;"><%=nnvo.getNm_context() %></td>
					</tr>
		<%
				if(nnvo.getNm_file()!=null&&nnvo.getNm_file()!=""){
		%>				
					<tr>
						<th>첨부파일</th>
						<td colspan="3" class="alignL">
							<a href="javascript:goDownload()"><%=nnvo.getNm_file() %></a>
							<input type="button" class="grey_btn" name="download_btn" id="download_btn" value="다운로드">
						</td>
					</tr>
		<%
				}
		%>			
				</table>	
			</div> <!-- //.table_wrap alignC marB20 -->
		</form>			
				<!-- ================ 수정/삭제/글목록 버튼 출력 ================ -->
			<fieldset>	
				<div class="marB100">
<%
				if(i_no.indexOf("M")>-1){
%>				
					<input type="button" class="blue_btn" id="update_btn" value="수정">
					<input type="button" class="grey_btn" id="delete_btn" value="삭제">
<%
				}
%>					
					<input type="button" class="grey_btn" id="noticeList" value="글목록">
				</div>
			</fieldset>
		</div> <!-- //.overflow -->
</div> <!-- end of printContents -->
							</section> <!-- //.box_instruc_con -->
							<!-- =========================== end of 해당 페이지 본문 컨텐츠 ================================ --> 					
							</section>
							</article> <!-- // content -->
							
						</article> <!-- // skipnav -->	 					 
					</div> <!-- end of 컨텐츠 박스(box_conts) -->
				
			</div> <!-- // end of box_sub -->
		</div> <!-- // box_wrap_body -->
		<!-- ============================== 푸터 ================================= -->
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
		<!-- ============================ // 푸터 ================================ -->
	<!-- =========================== end of 공통프레임 ================================ -->
	</body>
<%
	} // end of session if문
%>	
</html>