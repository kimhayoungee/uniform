<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.uniform.bm.board.vo.BmBoardVO" %>    
<%@ page import="java.util.List" %>     
<%@ page import="com.uniform.em.common.vo.EmCommonVO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
					  "http://www.w3.org/TR/html4/loose.dtd">
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
		
			// 검색조건 데이터
			BmBoardVO searchVO = (BmBoardVO)request.getAttribute("bbvo");
	
			List<BmBoardVO> boardDetailList = (List<BmBoardVO>)request.getAttribute("boardDetailList");
			
			// 댓글목록 조회용 글번호 데이터
			String bm_no = "";
		
			if(boardDetailList!=null && boardDetailList.size()>0){
					BmBoardVO bbvo = boardDetailList.get(0);
					
					// 추천여부 테스트
					System.out.println("1------bm_likeyyn : " + bbvo.getBm_likeyyn());
					// 스크랩여부 테스트
					System.out.println("1------bm_scrapyn : " + bbvo.getBm_scrapyn());
					
					bm_no = bbvo.getBm_no();
					// null값 0으로 변환해서 출력
					String bm_view = bbvo.getBm_view();
					String bm_likey = bbvo.getBm_likey();
					String bm_scrap = bbvo.getBm_scrap();
					if(bm_view==null){
						bm_view = "0";
					}
					if(bm_likey==null){
						bm_likey = "0";
					}
					if(bm_scrap==null){
						bm_scrap = "0";
					}
					
			EmCommonVO ecvo = (EmCommonVO)request.getAttribute("ecvo");		
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
				
				// 현재 로그인 중인 회원번호
				var loginI_no = "<%= i_no%>";
				// 글 작성자 회원번호
				var writerI_no = "<%=bbvo.getI_no() %>";
				console.log('loginI_no : ' + loginI_no + ', writerI_no : ' + writerI_no);
				
				var masterBool = loginI_no.indexOf('M') == 0;
				var writerBool = loginI_no == writerI_no;
				console.log('masterBool : ' + masterBool + ', writerBool : ' + writerBool);
				
				// 관리자나 작성자가 로그인 시 수정삭제 버튼 보여주기
				if(writerBool || masterBool){
					$("#updateForm").show();
					$("#delete_btn").show();
				// 그 외엔 숨겨두기	
				}else{
					$("#updateForm").hide();
					$("#delete_btn").hide();
				}
				
				// 댓글 작성자 회원번호
				
				
				// ====== 수정 버튼 클릭 이벤트 ===========
				$("#updateForm").click(function(){
					console.log('수정 버튼 클릭! >>>');
					
					// 수정폼으로 이동
					$("#detailForm").attr({
						"method":"POST",
						"action":"/board/updateForm.uni"
					}).submit();
					
				}); // end of 등록 버튼 클릭
				
				// ====== 삭제 버튼 클릭 이벤트 ===========
				$("#delete_btn").click(function(){
					console.log('삭제 버튼 클릭! >>>');
					
					// 삭제 컨트롤러로 거친 후 글목록으로 이동
					$("#detailForm").attr({
						"method":"POST",
						"action":"/board/boardDelete.uni"
					}).submit();
					
				}); // end of 등록 버튼 클릭
				
				// ====== 글목록 버튼 클릭 이벤트 ===========
				$("#boardList").click(function(){
					console.log('글목록 버튼 클릭! >>> boardList로 이동');
					
					// 글목록 페이지로 이동
					$("#searchDataForm").attr({
						"method":"POST",
						"action":"/board/boardList.uni"
					}).submit();
				}); // end of 등록 버튼 클릭
				
				// ====== 다운로드 버튼 클릭 이벤트 ===========
				$("#download_btn").click(function(){
					console.log('다운로드 버튼 클릭! >>> 다운로드 시작 경유 페이지로 이동');
					
					goDownload();
				}); // end of 등록 버튼 클릭
				
				// ====== 추천 버튼 클릭 이벤트 ===========
				$(".likey_btn").click(function(){
					console.log('like 버튼 클릭! >>> 좋아요 구현 컨트롤러로 이동');
					
					var i_no = $("#i_no").val();
					var bm_no = $("#bm_no").val();
					
					$.ajax({
						url: "/board/boardLikey.uni",
						type: "post",
						dataType:"JSON",
						data:{
							i_no: i_no,
							bm_no: bm_no
						},
						success:function(boardLikeyResult){
							console.log("추천 ajax 성공 >>> boardLikeyResult : " + boardLikeyResult);
							alert(boardLikeyResult.result);
							$(".likey_btn").html("");
							if(boardLikeyResult.result.indexOf("취소")>-1){
								$(".likey_btn").html("<img alt='비추천' src='/cssExample/img/icon/unlike.png'>");
							}else{
								$(".likey_btn").html("<img alt='추천' src='/cssExample/img/icon/like.png'>");
							}
							
							$(".cnt").html("추천" + boardLikeyResult.cnt);
							
						},
						error:function(request, status, error){
			            	alert('추천에 실패했습니다. 잠시 후 다시 시도해주세요.');
			            	alert('code='+request.status+" message=" + request.responseText + " error=" + error);
						}
					}); // end of ajax
				}); // end of 추천 버튼 클릭
				
				// ====== 스크랩 버튼 클릭 이벤트 ===========
				$(".scrap_btn").click(function(){
					console.log('스크랩 버튼 클릭! >>> 스크랩 구현 컨트롤러로 이동');
					
					var bm_no = $("#bm_no").val();
					var i_no = $("#i_no").val();
					
					$.ajax({
						url:"/board/boardScrap.uni",
						type:"POST",
						dataType:"JSON",
						data:{
							bm_no:bm_no,
							i_no:i_no
						},
						success:function(data){
							alert(data.result);
							
							if(data.result.indexOf("취소")>-1){
								$(".scrap_btn").html("<img alt='비스크랩' src='/cssExample/img/icon/unscrap.png'>");
							}else{
								$(".scrap_btn").html("<img alt='비추천' src='/cssExample/img/icon/scrap.png'>");
							}
							
							$(".cnt2").html('스크랩' + data.cnt);
						},
						error:function(request,status,error){
							alert("에러 났어요 >>> : " + request.status + " : error=" + error);
						}
					});
					
				}); // end of 스크랩 버튼 클릭
				
			}); // document ready
			
			function goDownload(){
				// 다운로드 컨트롤러 이동
				$("#detailForm").attr({
					"method":"POST",
					"action":"/board/boardFileDownload.uni"
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
					<li><a href="#"><%=ecvo.getI_nameKr() + " " + ecvo.getI_no() %></a></li>
					<li><a href="/main/goMyInfo.uni">MyPage</a></li>
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
						<a href="#none">게시글 상세보기</a>
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
					<h2>게시판</h2>
				</div>
				<!-- SNB -->
				<nav>
					<ul>		
						<li><a href="/board/boardList.uni">전체글보기</a></li> 
						<li><a href="/nm/goNoticeList.uni">공지사항</a></li>
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
							<h2 class="title">게시글 상세보기</h2>
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
									
		<!-- 글목록으로 돌아갈 때 조건 유지용 데이터 -->							
		<form id="searchDataForm" name="searchDataForm">
			<input type="hidden" id="bm_category" name="bm_category" value="<%=searchVO.getBm_category() %>">
			<input type="hidden" id="startDate" name="startDate" value="<%=searchVO.getStartDate()%>">
			<input type="hidden" id="endDate" name="endDate" value="<%=searchVO.getEndDate()%>">
			<input type="hidden" id="searchFilter" name="searchFilter" value="<%=searchVO.getSearchFilter()%>">
			<input type="hidden" id="keyword" name="keyword" value="<%=searchVO.getKeyword()%>">
			<input type="hidden" id="page" name="page" value="<%=searchVO.getPage()%>">
		</form>
		<form id="detailForm" name="detailForm">
			<!-- like 버튼 클릭시 가져갈 회원번호,글번호 데이터 -->
			<!-- 글수정 폼으로 이동, 글삭제 시 가져갈 글번호 데이터 -->
			<input type="hidden" id="bm_no" name="bm_no" value="<%= bbvo.getBm_no()%>">
			<!-- 글삭제 시 가져갈 로그인 중인 회원번호 데이터 -->
			<input type="hidden" id="i_no" name="i_no" value="<%=i_no %>">
			<!-- 파일 다운로드시 가져갈 파일명 데이터 -->
			<input type="hidden" id="bm_file" name="bm_file" value="<%= bbvo.getBm_file()%>">
			
		
			<!-- =============== 상세보기 테이블 =============== -->
			<div class="table_wrap alignC" style="border-bottom:0px;">
				<table summary="상세보기">
					<colgroup>
					<col class="w20per"/>
					<col class="auto" />
					<col class="w20per"/>
					<col class="auto" />
					</colgroup>
					
					<tr>
						<th style="border-top:1px solid #565c6b;">분류</th>
						<td colspan="3" class="alignL padL15"><%=bbvo.getBm_category() %></td>
					</tr>
					<tr>
						<th>제목</th>
						<td colspan="3" class="alignL padL15"><%=bbvo.getBm_subject() %></td>
					</tr>
					<tr>
						<th>작성자</th>
						<td colspan="3" class="alignL padL15"><%=bbvo.getI_nameKr() %></td>
					</tr>
					<tr>
						<th>작성일</th>
						<td class="alignL padL15"><%=bbvo.getBm_insertdate() %></td>
						<th>수정일</th>
						<td class="alignL padL15"><%=bbvo.getBm_updatedate() %></td>
					</tr>
					<tr>
						<th>조회</th>
						<td colspan="3" class="alignL padL15"><%=bm_view %></td>
					</tr>
				
		<%			
				if(bbvo.getBm_image()!=null && bbvo.getBm_image()!=""){
		%>			
					<tr id="imageContainer">
						<td colspan="4" class="alignL padT20 padR20 padB20 padL20"><img id="bm_image" style="max-height:400px;" src="<%=bbvo.getBm_image() %>"/></td>
					</tr>
		<%	
				}
		%>					
					<tr>
						<td colspan="4" class="alignL padT20 padR20 padB20 padL20" style="min-height:400px;"><%=bbvo.getBm_context() %></td>
					</tr>
		<%			
				if(bbvo.getBm_image()!=null && bbvo.getBm_image()!=""){
		%>						
					<tr>
						<th>첨부파일</th>
						<td colspan="3" class="alignL">
							<a href="javascript:goDownload()"><%=bbvo.getBm_file() %></a>
							<input type="button" class="grey_btn" name="download_btn" id="download_btn" value="다운로드">
						</td>
					</tr>
		<%	
				}
		%>						
				</table>
			</div> <!-- //.table_wrap alignC marB10 -->
			
				<!-- ================ 추천/스크랩 버튼 출력 ================ -->
			<fieldset>	
				<div class="marB10 alignC" style="padding:15px">
		<%
				if(bbvo.getBm_likeyyn()!=null && bbvo.getBm_likeyyn()!=""){					
					if(bbvo.getBm_likeyyn().equals("Y")){
			%>	
						<a href="#"><b><span class="likey_btn"><img alt="추천" src="/cssExample/img/icon/like.png"></span></b></a><span class="cnt">추천 <%=bm_likey %></span>
			<%	
					}else{
			%>		
						<a href="#"><span class="likey_btn"><img alt="비추천" src="/cssExample/img/icon/unlike.png"></span></a><span class="cnt">추천 <%=bm_likey %></span>
			<%			
					} // end of not "Y"					
				}else{					
			%>		
					<a href="#"><span class="likey_btn"><img alt="비추천" src="/cssExample/img/icon/unlike.png"></span></a><span class="cnt">추천 <%=bm_likey %></span>
			<%										
				} // end of bm_likeyyn not null

				if(bbvo.getBm_scrapyn()!=null && bbvo.getBm_scrapyn()!=""){
					if(bbvo.getBm_scrapyn().equals("Y")){
			%>	
					<a href="#"><span class="scrap_btn"><img alt="스크랩" src="/cssExample/img/icon/scrap.png"></span></a><span class="cnt2">스크랩 <%=bm_scrap %></span>
			<%	
					}else{
			%>		
					<a href="#"><span class="scrap_btn"><img alt="비스크랩" src="/cssExample/img/icon/unscrap.png"></span></a><span class="cnt2">스크랩 <%=bm_scrap %></span>
			<%			
					} // end of not "Y"					
				}else{					
			%>
					<a href="#"><span class="scrap_btn"><img alt="비스크랩" src="/cssExample/img/icon/unscrap.png"></span></a><span class="cnt2">스크랩 <%=bm_scrap %></span>
			<%										
				} // end of bm_scrapyn not null	
			%>	
				</div>
			</fieldset>	
		</form>	
	<%

		}else{
				
		}
	%>					
				<!-- ========== 댓글 =========================================== -->
				<jsp:include page="reply.jsp">
					<jsp:param name="bm_no" value="<%=bm_no %>"/>
				</jsp:include>
				
				<!-- ================ 수정/삭제/글목록 버튼 출력 ================ -->
				<fieldset>
					<div class="marB100">
						<input type="button" class="grey_btn" id="delete_btn" value="삭제">
						<input type="button" class="blue_btn" id="updateForm" value="수정">
						<input type="button" class="grey_btn" id="boardList" value="글목록">
					</div>
				</fieldset>
			</div>
		
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