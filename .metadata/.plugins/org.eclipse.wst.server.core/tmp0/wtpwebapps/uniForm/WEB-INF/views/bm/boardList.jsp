<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.uniform.bm.board.vo.BmBoardVO" %>    
<%@ page import="java.util.List" %>  
<%@ page import="com.uniform.nm.notice.vo.NmNoticeVO" %>
<%@ page import="com.uniform.em.common.vo.EmCommonVO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
					  "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, 
									   minimum-scale=1.0, user-scalable=no, target-densityDpi=medium-dpi">
		<title>게시판 글목록</title>
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
		
		List<NmNoticeVO> nList = (List<NmNoticeVO>)request.getAttribute("nList");
		NmNoticeVO nnvo = null;
		
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
				console.log('boardList.jsp >>> 글목록 페이지 document ready! ');
				
				var i_no = "<%=i_no%>";
				
				if(i_no.indexOf('M')==0){
					console.log('관리자 계정으로 사이트 이용중');
				}else{
					// 체크박스 관리자계정으로 로그인 시 show로 변경
					$(".checkTh").hide();
					$(".checkTd").hide();
				}

				
				// ======= 고정프레임 image =======
				var images = ['mnd_bg07.jpg', 'mnd_bg08.jpg', 'mnd_bg09.jpg'];
				$('#box_wrap_visual').css({'background-image':'url(/mbshome/mbs/mnd/images/common/' 
										  + images[Math.floor(Math.random() * images.length)] + ')'});
					
				// ====== 글쓰기 버튼 클릭 이벤트 ===========
				$("#insertForm").click(function(){
					console.log('글쓰기 버튼 클릭! >>> 글쓰기 페이지로 이동');
					location.href="/board/insertForm.uni";
				}); // end of 글쓰기 버튼 클릭
				
				// ====== 삭제 버튼 클릭 이벤트(관리자 전용) ===========
				$("#deleteBtn").click(function(){
					console.log('삭제 버튼 클릭! >>> 체크박스 삭제 컨트롤러로 이동');
					
				
					
				}); // end of 글쓰기 버튼 클릭
				
				// ====== 글제목 클릭 이벤트 ==============
				$(".goBoardDetail").click(function(){
					console.log('글제목 클릭! >>> 상세보기 페이지로 이동');
					
					var bm_no = $(this).parents("tr").attr("data-bm_no");
					
					$("#bm_no").val(bm_no);
					$("#i_no").val(i_no);
					
					// 상세보기 페이지로 이동
					$("#searchForm").attr({
						"method":"POST",
						"action":"/board/boardDetail.uni"
					}).submit();
				});	// end of 글제목 클릭
				
				// ====== 검색버튼 클릭 이벤트 ==============
				$("#search_btn").click(function(){
					console.log('검색버튼 클릭! >>> 전체조회 조건검색 컨트롤러로 이동');
					
					// 전체조회 컨트롤러로 이동
					$("#searchForm").attr({
						"method":"POST",
						"action":"/board/boardList.uni"
					}).submit();
				}); // end of 검색버튼 클릭
									
				// ====== 카테고리 변경 이벤트 ==============
				$("#bm_category").change(function(){
					console.log('카테고리 드롭박스 변경 >>> bm_category : ' + $("#bm_category").val());
					
					// 전체조회 컨트롤러로 이동
					$("#searchForm").attr({
						"method":"POST",
						"action":"/board/boardList.uni"
					}).submit();
				}); // end of 카테고리 변경
							
				// ====== 조건 조회 후 리프레쉬된 페이지에 설정값 유지 ======
				var bm_category = "<%=bm_category %>";
				
				if(bm_category==null || bm_category=="null" || bm_category==""){
					$("#bm_category").val("전체");
				}else{
					$("#bm_category").val(bm_category);
				}
				
				var startDate = "<%=startDate%>";
				var endDate = "<%=endDate%>";
				
				if(startDate==null || startDate=="null" || startDate==""){
					$("#startDate").val("");
				}else{
					$("#startDate").val(startDate);
				}
				if(endDate==null || endDate=="null" || endDate==""){
					$("#endDate").val("");
				}else{
					$("#endDate").val(endDate);
				}

				var searchFilter = "<%=searchFilter%>";
				var keyword = "<%=keyword%>";
				
				if(searchFilter==null || searchFilter=="null" || searchFilter==""){
					$("#searchFilter").val("제목");
				}else{
					$("#searchFilter").val(searchFilter);
				}
				if(keyword==null || keyword=="null" || keyword==""){
					$("#keyword").val("");
				}else{
					$("#keyword").val(keyword);
				}
				
				$(".goNoticeDetail").on("click",function(){
					var nm_no = $(this).parents("tr").attr("data-nm");
					
					alert(nm_no);
					
					callUpdateView(nm_no);
				});
				
			}); // end of document ready
			
			function goBoardList(page){
				console.log("goBoardList 함수 호출! >>> page : " + page);
				// 히든테그에 밸류값 바인딩 후 submit
				$("#page").val(page);
				
				$("#pagingForm")
				.attr({
					"method":"post",
					"action":"/board/boardList.uni"
				}).submit();
			} // end of goBoardList 함수
			
			
			function callUpdateView(nm_no){
				$.ajax({
					url:"/nm/updateView.uni",
					type:"POST",
					data:{
						nm_no:nm_no
					},
					success:function(data){
						console.log('ajax success >>> data : ' + data);
						if(data.indexOf("실패")>-1){
							return false;
						}else{
							location.href="/nm/goNoticeDetail.uni?nm_no="+nm_no;
						}
					}
				});
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
					<li><a href="#"><%= ecvo.getI_nameKr() + " " + ecvo.getI_no() %></a></li>
					<li><a href="/main/goMyInfo.uni" id="myA">MyPage</a></li>
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
	<!-- =========================== end of 헤더  ============================ -->
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
						<a href="#none">전체글보기</a>
					</div>
				</li>
			</ul>
		</nav>
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
						<li class="on"><a href="/board/boardList.uni">전체글보기</a></li> 
						<li><a href="/nm/goNoticeList.uni">공지사항</a></li>
						<li><a href="/board/boardMyList.uni?i_no=<%=i_no %>">내가쓴글</a></li>
						<li><a href="/board/boardScrapList.uni?i_no=<%=i_no %>">스크랩글</a></li>
						<li><a href="#">인기글</a></li>
					</ul>
				</nav>
				<!-- // SNB -->
			</div>
			
			<%
				List<BmBoardVO> boardList = (List<BmBoardVO>)request.getAttribute("boardList");	
				int count = (int)request.getAttribute("count");
				
			%>
			<!-- =================== 본문 내용이 들어갈 컨텐츠 박스 ===================== -->
			<div id="box_conts">
				<article id="skipnav">
				
					<!-- ============== 해당 페이지 타이틀 ============= -->
					<section class="title_cont">
						<h2 class="title">전체글보기</h2>
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
										<!-- 조건검색 글 조회 후 현재페이지 유지할 데이터 -->
										<form id="searchForm" name="searchForm">
											<!-- ======== 상세보기 페이지 이동시 갖고 갈 데이터 ======== -->
											<input type="hidden" id="bm_no" name="bm_no">
											<input type="hidden" id="i_no" name="i_no">
											
											<!-- =============== 조건 검색 및 목록 뽑는 영역 =============== -->
											<fieldset>
												<legend>게시글 검색 설정</legend>
												<div class="category">
													<label for="bm_category"></label>
													<select id="bm_category" name="bm_category">
														<option value="전체">전체</option>
														<option value="정보">정보</option>
														<option value="자료">자료</option>
														<option value="잡담">잡담</option>
													</select>
													<span class="marL15" style="font-size:16px">전체 <%= total %>건</span>
												</div> <!-- //.category -->
												<div class="period">
													<div class="wrap_date">
														<label for="startDate" class="labelH">시작일</label>
														<input type="text" id="startDate" name="startDate" placeholder="시작일 "><a class="datePop" href="#" onclick=""><img src="/cssExample/img/btn/bg_search_date.png" alt="시작날짜 선택"></a>
														~
														<label for="findEendDatendDate" class="labelH">종료일</label>
														<input type="text" id="endDate" name="endDate" placeholder="종료일"><a class="datePop" href="#"  onclick=""><img src="/cssExample/img/btn/bg_search_date.png" alt="종료날짜 선택"></a>
													</div><!-- //.wrap_date -->
													<div class="wrap_search">
														<select id="searchFilter" name="searchFilter">
															<option value="제목">제목</option>
															<option value="내용">내용</option>
															<option value="제목+내용">제목+내용</option>
															<option value="작성자">작성자</option>
														</select>
														<label for="keyword">검색어</label>
														<input type="text" id="keyword" name="keyword" placeholder="검색어 입력">
														<input type="button" class="search_btn" id="search_btn" name="search_btn" value="검색">
														<input type="reset" class="reset_btn" id="reset_btn" name="reset_btn" value="리셋">
													</div><!-- //.wrap_search -->
												</div> <!-- //.period -->
											</fieldset>
										</form> <!-- // end of searchForm -->
									</div><!-- //overflowW marB10 -->
								</div><!-- //board marB10 -->	
												
							<!-- =============== 글목록 테이블 =============== -->
							<div class="table_wrap alignC marB10">
								<table summary="글목록">
	
									<!-- 관리자계정으로 로그인 시 체크박스 show로 변경 -->
									<colgroup>
						<%
								if(i_no.indexOf('M')==0){
						%>					
									<col class="w5per" />
						<%			
								} // end of 관리자계정으로 로그인 시 체크박스 show
						%>				
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
											<th scope="col" class="first">번호</th>
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
									if(nList!=null&&nList.size()>0){
										for(int i=0;i<nList.size();i++){
											nnvo = nList.get(i);
								%>
										<tr data-nm="<%=nnvo.getNm_no()%>">
											<td class="checkTd" align="center"><input type="checkbox" disabled></td>
											<td class="alignC first goNoticeDetail"><a href="#"><span>I</span></a></td>
											<td class="alignC goNoticeDetail"><a href="#"><span><%=nnvo.getNm_category() %></span></a></td>
											<td class="alignL goNoticeDetail"><a href="#"><span><%=nnvo.getNm_subject() %></span></a></td>
											<td class="alignC goNoticeDetail"><a href="#"><span><%=nnvo.getI_no() %></span></a></td>
											<td class="alignC goNoticeDetail"><a href="#"><span><%=nnvo.getNm_insertDate() %></span></a></td>
											<td class="alignC goNoticeDetail"><a href="#"><span><%=nnvo.getNm_view() %></span></a></td>
											<td class="alignC goNoticeDetail"><a href="#"><span></span></a></td>
										</tr>
								<%			
										}
									}
								%>	
								<%
									if(boardList!=null && boardList.size()>0){
										for(int i=0;i<boardList.size();i++){
											BmBoardVO bbvo = boardList.get(i);
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
											<td class="alignC first"><a href="#"><span class="goBoardDetail"><%=count-i %></span></a></td>
											<td class="alignC"><a href="#"><span class="goBoardDetail"><%=bbvo.getBm_category() %></span></a></td>
											<td class="alignL"><a href="#"><span class="goBoardDetail"><%=bbvo.getBm_subject() %></span></a></td>
											<td class="alignC"><a href="#"><span class="goBoardDetail"><%=bbvo.getI_nameKr() %></span></a></td>
											<td class="alignC"><a href="#"><span class="goBoardDetail"><%=bbvo.getBm_insertdate() %></span></a></td>
											<td class="alignC"><a href="#"><span class="goBoardDetail"><%=bm_view %></span></a></td>
											<td class="alignC"><a href="#"><span class="goBoardDetail"><%=bm_likey %></span></a></td>
										</tr>			
								<%			
										} // end of for	
									}else if(boardList.size()==0){
								%>		
										<tr>
											<td class="alignC first last" colspan="8">조회할 글이 없습니다.</td>
										</tr>
								<%		
									} // end of if
								%>
									</tbody>
								</table>	
							</div> <!-- //.table_wrap alignC marB10 -->
							
							<!-- 글쓰기 버튼 출력  -->
							<div class="marB40">
								<input type="button" class="blue_btn" id="insertForm" value="글쓰기">
						<%
								// 관리자계정으로 로그인 시 삭제버튼 보여주기
								if(i_no.indexOf('M')==0){
						%>			
								<input type="button" class="grey_btn" id="deleteBtn" value="삭제">
						<%
								} // end of 관리자계정
						%>		
							</div> <!-- end of 글쓰기버튼 container -->
							<!-- ================ 페이징 내비게이션 출력 ============== -->
							<!-- 페이징 인덱스 번호 클릭해서 이동할 때 필요한 데이터 -->
							<form id="pagingForm" name="pagingForm">
								<input type="hidden" id="page" name="page">
							</form>
							<section class="marB100">
								<jsp:include page="pagingBoard.jsp">
									<jsp:param value="<%=curPage%>" name="curPage"/>
									<jsp:param value="<%=total %>" name="total"/>
								</jsp:include>
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