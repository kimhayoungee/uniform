<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.uniform.bm.board.vo.BmBoardVO" %>    
<%@ page import="java.util.List" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
					  "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, 
									   minimum-scale=1.0, user-scalable=no, target-densityDpi=medium-dpi">
		<title>게시판 내가 쓴 글</title>
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
		
		// 페이징용 데이터
		String total = (String)request.getAttribute("total");
		String curPage = (String)request.getAttribute("curPage");	
		
		// 조건조회 후 설정값 유지용 데이터
		BmBoardVO searchVO = (BmBoardVO)request.getAttribute("bbvo");
		String startDate = searchVO.getStartDate();
		String endDate = searchVO.getEndDate();
		String bm_category = searchVO.getBm_category();
		String searchFilter = searchVO.getSearchFilter();
		String keyword = searchVO.getKeyword();
		
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
		<!-- Board CSS -->
		<link rel="stylesheet" href="/cssExample/css/board.css" media="all">
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
				console.log('boardMyList.jsp >>> 내가쓴글 글목록 페이지 document ready! ');
				
				var i_no = "<%=i_no%>";
				
				// ======= 고정프레임 image =======
				var images = ['mnd_bg07.jpg', 'mnd_bg08.jpg', 'mnd_bg09.jpg'];
				$('#box_wrap_visual').css({'background-image':'url(/mbshome/mbs/mnd/images/common/' 
										  + images[Math.floor(Math.random() * images.length)] + ')'});
					
				// ====== 글제목 클릭 이벤트 ==============
				$(".goBoardDetail").click(function(){
					console.log('글제목 클릭! >>> 상세보기 페이지로 이동');
					
			
					var bm_no = $(this).parents("tr").attr("data-bm_no");
					$("#bm_no").val(bm_no);
					$("#i_no").val(i_no);
					
					// 상세보기 페이지로 이동
					$("#myListForm").attr({
						"method":"POST",
						"action":"/board/boardDetail.uni"
					}).submit();
				});	// end of 글제목 클릭
				
				// ====== 모두 체크 =========
				$("#bm_no_check").click(function(){
					if($("#bm_no_check").prop("checked")){
						$("input[name='bm_no']").prop("checked",true);
					}else{
						$("input[name='bm_no']").prop("checked",false);
					}
				});
				
				// ====== 삭제 버튼 클릭 이벤트 ==============
				$("#delete_btn").click(function(){
					console.log('삭제 버튼 클릭! >>> 다중 삭제 컨트롤러로 이동');
					
					var bm_no = "";
					
					$("input[name='bm_no']:checked").each(function(){
						bm_no = bm_no + $(this).parents("tr").attr("data-bm_no") + ",";
					});
					bm_no = bm_no.substring(0,bm_no.lastIndexOf(","));
					
					alert(bm_no);
					
					if(bm_no==null||bm_no==""){
						alert("삭제할 게시글을 선택해 주세요");
						
						return false;
					}
					
					if(confirm("삭제 하시겠습니까?")){
						alert("삭제");
						
					//	goScrapOff(bm_no,i_no);
					}else{
						return false;
					}
				}); // end of 삭제 버튼 클릭
				
			}); // end of document ready
			
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
		} // end of respondCSS()
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
						<li><a href="/board/boardList.uni">공지/게시판</a>
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
						<a href="#none">내가쓴글</a>
					</div>
				</li>
			</ul>
		</nav>
		<!-- ======== end of 헤더 nav 디렉토리 ======= -->
		<!-- ======== 헤더 nav 확대 축소 버튼 ======= -->
		<div class="box_option">
			<ul>
				<li><button type="button" class="zoom_in">확대</button></li>
				<li><button type="button" class="zoom_ori">기본</button></li>
				<li><button type="button" class="zoom_out">축소</button></li>
			</ul>
		</div> 
		<!-- ======== end of 헤더 nav 확대 축소 버튼 ======= --> 
	</div>
	<!-- ========================== end of 헤더 navigation ============================ --> 
	<!-- body -->
	<!-- ========== .wrap1200 : max-width "1200px", 좌우 padding auto -->
	<div id="box_wrap_body" class="wrap1200">
		<!-- =========== 본문 영역 상하 40px padding ========== -->
		<div id="box_sub">
			<!-- ============================== 좌측 사이드바 메뉴 선택 =============================== -->   
			<div id="box_sidebar">
				<div>   
					<h2>공지/게시판</h2>
				</div>
				<!-- SNB -->
				<nav>
					<ul>		
						<li><a href="/board/boardList.uni">전체글보기</a></li> 
						<li><a href="/nm/goNoticeList.uni">공지사항</a></li>
						<li class="on"><a href="/board/boardMyList.uni?i_no=<%=i_no%>">내가쓴글</a></li>
						<li><a href="/board/boardScrapList.uni?i_no=<%=i_no %>">스크랩글</a></li>
						<li><a href="#">인기글</a></li>
					</ul>
				</nav>
				<!-- // SNB -->
			</div>
			<!-- ============================ end of 좌측 사이드바 메뉴 선택 =========================== --> 
			<%
				List<BmBoardVO> boardMyList = (List<BmBoardVO>)request.getAttribute("boardMyList");	
				int count = (int)request.getAttribute("count");
				
			%>
			<!-- =================== 본문 내용이 들어갈 컨텐츠 박스 ===================== -->
			<div id="box_conts">
				<article id="skipnav">
				
				
					<!-- ============== 해당 페이지 타이틀 ============= -->
					<section class="title_cont">
						<h2 class="title">내가 쓴 글</h2>
					</section> 
						<!-- ================================ 해당 페이지 본문 컨텐츠 (각자 코드 들어갈 영역)================================== --> 
						
						
						<section class=""><!-- .box_instruc_con -->
							<div id="printContents"> 
							
							<!-- Board CSS -->
							<link rel="stylesheet" href="/cssExample/css/board.css" media="all">
							
							<!-- =============== 글목록 테이블 =============== -->
							<article id="content"> 
							<section>
							
							
							
							
								<div class="board marB10">
									<div class="overflowW marB10">
									
									<fieldset>
										<span class="marL15" style="font-size:16px">전체 <%= total %>건</span>
									</fieldset>
									
									</div><!-- //overflowW marB10 -->
								</div><!-- //board marB10 -->
								
								<!-- =============== 글목록 테이블 =============== -->
								<div class="table_wrap alignC marB10">
									<!-- ======== 상세보기 페이지 이동시 갖고 갈 데이터 ======== -->
									<form id="scrapForm" name="searchForm">
										<input type="hidden" id="bm_no" name="bm_no">
										<input type="hidden" id="i_no" name="i_no">
										
										<table summary="내가쓴글 글목록">
										<colgroup>
										<col class="w5per" />
										<col class="w7per" />
										<col class="w7per" />
										<col class="auto"  />
										<col class="w10per" />
										<col class="w10per" />
										<col class="w7per" />
										<col class="w7per" />
										</colgroup>	
										<thead>
											<tr>
												<th scope="col" class="checkTh"><input type="checkbox" name="bm_no_check" id="bm_no_check"></th>
												<th scope="col">번호</th>
												<th scope="col">분류</th>
												<th scope="col">제목</th>
												<th scope="col">작성자</th>
												<th scope="col">작성일</th>
												<th scope="col">조회</th>
												<th scope="col">추천</th>
											</tr>
										</thead>
										<tbody>
									<%
										if(boardMyList!=null && boardMyList.size()>0){
											for(int i=0;i<boardMyList.size();i++){
												BmBoardVO bbvo = boardMyList.get(i);
												String bm_view = bbvo.getBm_view();
												String bm_likey = bbvo.getBm_likey();
												if(bm_view==null){
													bm_view = "0";
												}
												if(bm_likey==null){
													bm_likey = "0";
												}
									%>
											<tr data-bm_no="<%=bbvo.getBm_no()%>">
												<td class="checkTd" align="center"><input type="checkbox" name="bm_no" value="<%=bbvo.getBm_no()%>"></td>
												<td class="alignC"><a href="#"><span class="goBoardDetail"><%=count-i %></span></a></td>
												<td class="alignC"><a href="#"><span class="goBoardDetail"><%=bbvo.getBm_category() %></span></a></td>
												<td class="alignL"><a href="#"><span class="goBoardDetail"><%=bbvo.getBm_subject() %></span></a></td>
												<td class="alignC"><a href="#"><span class="goBoardDetail"><%=bbvo.getI_nameKr() %></span></a></td>
												<td class="alignC"><a href="#"><span class="goBoardDetail"><%=bbvo.getBm_insertdate() %></span></a></td>
												<td class="alignC"><a href="#"><span class="goBoardDetail"><%=bm_view %></span></a></td>
												<td class="alignC"><a href="#"><span class="goBoardDetail"><%=bm_likey %></span></a></td>
											</tr>			
									<%			
											} // end of for	
										}else if(boardMyList.size()==0){
									%>		
											<tr>
												<td class="alignC first last" colspan="8">조회할 글이 없습니다.</td>
											</tr>
									<%		
										} // end of if
									%>
										</tbody>
									</table>
								</form>		
							</div> <!-- //.table_wrap alignC marB10 -->	
							
							<!-- ============== 내가쓴글 삭제 버튼 출력 ============== -->
							<div class="marB40">
								<input type="button" class="grey_btn" id="delete_btn" value="삭제">
							</div> <!-- end of 내가쓴글  -->
							
							<!-- ================ 페이징 내비게이션 출력 ============== -->
							<!-- 페이징 인덱스 번호 클릭해서 이동할 때 필요한 데이터 -->
							<form id="pagingForm" name="pagingForm">
								<input type="hidden" id="page" name="page">
							</form>
							<section class="marB100">
								<div class="">
									<jsp:include page="pagingScrap.jsp">
										<jsp:param value="<%=curPage%>" name="curPage"/>
										<jsp:param value="<%=total %>" name="total"/>
									</jsp:include>
								</div>
							</section> <!-- //.marB100 -->
							
							
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