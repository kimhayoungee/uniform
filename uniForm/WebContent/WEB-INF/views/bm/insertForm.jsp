<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.uniform.em.common.vo.EmCommonVO" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
					  "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, 
							   minimum-scale=1.0, user-scalable=no, target-densityDpi=medium-dpi">
		<title>게시글 쓰기</title>
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
		
		<!-- SmartEditor2 -->
		<script type="text/javascript" src="/api/smarteditor2-2.10.0/js/service/HuskyEZCreator.js" charset="utf-8"></script>
		
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
				console.log('insertForm.jsp >>> 글쓰기 페이지 document ready!');

				// ======= 고정프레임 image =======
				var images = ['mnd_bg07.jpg', 'mnd_bg08.jpg', 'mnd_bg09.jpg'];
				$('#box_wrap_visual').css({'background-image':'url(/mbshome/mbs/mnd/images/common/' 
										  + images[Math.floor(Math.random() * images.length)] + ')'});
				
				/* smart editor 생성 코드 */
				var oEditors = [];
				nhn.husky.EZCreator.createInIFrame({
					oAppRef: oEditors,
					elPlaceHolder: "bm_context",
					sSkinURI: "/api/smarteditor2-2.10.0/SmartEditor2Skin.html",
					htParams:{
						// 툴바 사용여부
						bUseToolbar : true,
						// 입력창 크기 조절바 사용여부
						bUseVerticalResizer : true,
						// 모드 탭(Editor|Html|TEXT)사용여부
						bUseModeChanger : false,
						fOnBeforeUnload : function(){							
						}
					},
					fCreator: "createSEditor2"
				});
				
				// ====== 등록 버튼 클릭 이벤트 ===========
				$("#insert_btn").click(function(){
					console.log('등록 버튼 클릭! >>>');
					
					// 스마트 에디터 form 전송
					oEditors.getById["bm_context"].exec("UPDATE_CONTENTS_FIELD", []);
					
					// insert 컨트롤러 거친 후 상세보기 페이지로 이동
					$("#insertForm").attr({
						"method":"POST",
						"enctype":"multipart/form-data",
						"action":"/board/boardInsert.uni"
					}).submit();
					
				}); // end of 등록 버튼 클릭
				
				// ====== 글목록 버튼 클릭 이벤트 ===========
				$("#boardList").click(function(){
					console.log('글목록 버튼 클릭! >>> boardList로 이동');
					
					location.href="/board/boardList.uni";
				}); // end of 등록 버튼 클릭
			});
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
	<!-- 스킵 네비게이션
	<div id="box_skip">
		<h2 class="hiddenT">Skip Navigation</h2>
		<ul>
			<li><a href="#skipnav">본문 바로가기</a></li>
			<li><a href="#navFirst">주메뉴 바로가기</a></li>
		</ul>
	</div>
	 // 스킵 네비게이션 -->

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
						<a href="/main/goMain.uni">Uniform</a>
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
	<!-- =========================== end of 헤더  ============================ -->
	<p></p>	
	<p></p>
  	<!-- ========================= 메인 이미지 타이틀이 들어갈 위치 ==================== -->
	<div class="box_cate_name mnd01">
		<h2></h2>
	</div>
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
						<a href="#none">게시글쓰기</a>
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
					<section class="title_cont" >
						<h2 class="title">게시글쓰기</h2>
					</section> 
	
						<!-- ===================== 해당 페이지 본문 컨텐츠 (각자 코드 들어갈 영역)======================= --> 
						<section class="">
							<div id="printContents"> 
						
						<!-- Board CSS -->
						<link rel="stylesheet" href="/cssExample/css/board.css" media="all">

						<article id="content"> 
						<section>	
					
							<!-- =========================================== 각자 집어넣을 내용 ================================================ -->
		
							<form id="insertForm" name="insertForm">
								<input type="hidden" id="i_no" name="i_no" value="<%=i_no%>">
								
								<!-- =============== 글쓰기 테이블 =============== -->
								<div class="table_wrap alignC marB15">
									<table summary="게시판 글쓰기">
									<colgroup>
									<col class="w15per" />
									<col class="w15per" />
									<col class="w15per" />
									<col class="auto" />
									</colgroup>
										
										<tr style="border-top:1px solid #565c6b;">
											<th scope="col" >분류</th>
											<td scope="col"	style="padding:1px 1px;">
												<div class="insert_category">
													<select name="bm_category" id="bm_category" style="width:100%;height:100%;">
														<option value="정보">정보</option>
														<option value="자료">자료</option>
														<option value="잡담">잡담</option>
													</select>
												</div>	
											</td>	
								    		<th scope="col">제목</th>
								    		<td scope="col"	style="padding:1px 1px;">
									    		<div class="insert_subject">
									    			<input type="text" name="bm_subject" id="bm_subject" style="width:99%;height:100%;" placeholder="제목을 입력해주세요">
												</div><!-- //.subject -->
											</td>	
										</tr>
										<tr>
											<td colspan="4">
												<textarea name="bm_context" id="bm_context" style="width:100%;" rows="10"></textarea>
											</td>
										</tr>
										<tr>	
											<th>이미지</th>
											<td colspan="3" class="alignL">
												<input type="file" name="bm_image" id="bm_image" style="width:auto;">
											</td>
										</tr>
										<tr>	
											<th>첨부파일</th>
											<td colspan="3" class="alignL">
												<input type="file" name="bm_file" id="bm_file" style="width:auto;">
											</td>
										</tr>
									</table>
								</div> <!-- //.table_wrap alignC marB10 -->
												
								<!-- ================ 등록/글목록 버튼 출력 ================ -->
								<fieldset>
									<div class="marB100">
										<input type="button" class="blue_btn" id="insert_btn" value="등록">
										<input type="button" class="grey_btn" id="boardList" value="글목록">
									</div>
								</fieldset>
							</form>	
								
						<!-- =========================================== end of 각자 집어넣을 내용 ================================================ -->	
					</section>
					</article> <!-- // content -->

						</div> <!-- end of printContents -->
					</section> <!-- //.box_instruc_con -->
					<!-- =========================== end of 해당 페이지 본문 컨텐츠 ================================ --> 
					
				</article> <!-- // skipnav --> 
			</div> <!-- end of 컨텐츠 박스(box_conts) -->
			
		</div> <!-- // end of box_sub -->
	</div>  <!-- // box_wrap_body -->



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
	<!-- =========================== end of 공통프레임 ================================ -->
	</body>
<%
	} // end of session if문
%>	
</html>