<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.uniform.em.common.vo.EmCommonVO" %>
<%@ page import="com.uniform.mm.message.vo.MmMessageVO" %>
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
		EmCommonVO ecvo = (EmCommonVO)request.getAttribute("ecvo");
		List<MmMessageVO> list = (List<MmMessageVO>)request.getAttribute("messageList");
		boolean listBool = list.size()>0;
		
		String total = (String)request.getAttribute("total");
		String curPage = (String)request.getAttribute("page");
%>		
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>쪽지함</title>
		
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
		
		<script type="text/javascript"
				src="/include/js/jquery-1.11.0.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				$("#write_btn").on("click",function(){
					window.open("/mm/goInsertMessage.uni","pop","width=550,height=700,left=700,top=200");
				});
				
				$(".detail").on("click",function(){
					var mm_no = $(this).parents("tr").attr("data-num");
					
					window.open("/mm/goDetailMessage.uni?mm_no=" + mm_no,"pop","width=550,height=700,left=700,top=200");
				});
				
				$("#checkAll").on("click",function(){
					
					if($("#checkAll").prop("checked")){
						$("input[name='mm_no']").prop("checked",true);
					}else{
						$("input[name='mm_no']").prop("checked",false);
					}
				});
				
				$("#delete_btn").on("click",function(){
					var mm_no = "";
					
					$("input[name='mm_no']:checked").each(function(){
						mm_no = mm_no + $(this).parents("tr").attr("data-num") + ",";
					});
					mm_no = mm_no.substring(0,mm_no.lastIndexOf(','));
					
					alert(mm_no);
					
					if(mm_no==null||mm_no==""){
						alert("삭제할 쪽지를 선택해 주세요");
						return false;
					}
					
					if(confirm("삭제 하시겠습니까?")){
						alert("삭제하러");
						goDeleteMessage(mm_no);
					}else{
						return false;
					}
				});
				
			});
			
			function goDeleteMessage(mm_no){
				$.ajax({
					url:"/mm/deleteMessage.uni",
					type:"POST",
					data:{
						mm_no:mm_no
					},
					success:function(data){
						alert(data);
						goMessageMain();
					},
					error:function(request,status,error){
						alert("에러났다 >>> : " + request.status + " : error=" + error);
					}
				});
			}
			
			function goMessageMain(page){
					location.href="/mm/goMessageMain.uni?page=" + page;
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
					<li><a href="#"><%=ecvo.getI_nameKr() %>님 <%=ecvo.getI_no() %> </a></li>
<%
		if(i_no.indexOf("E")>-1){
%>				
				<li><a href="/main/goMyInfo.uni" id="myA">MyPage</a></li>
<%
		}
%>						
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
	<!-- =========================== end of 헤더  ============================ -->
	<p></p>	
	<p></p>

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
						<a href="#none">쪽지</a>
					</div>				
				</li>
				<li>
					<div class="nav_title">
						<a href="#none">></a>
					</div>
				</li> 		
				<li class="on"> 
					<div class="nav_title">
						<a href="#none">쪽지함</a>
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
					<h2>쪽지</h2>
				</div>
				<!-- SNB -->
				<nav>
					<ul>		
						<li class="on"><a href="/board/boardList.uni">쪽지함</a></li> 
						<li><a href="/nm/goNoticeList.uni">쪽지 쓰기</a></li>
					</ul>
				</nav>
				<!-- // SNB -->
			</div>
	
			<!-- =================== 본문 내용이 들어갈 컨텐츠 박스 ===================== -->
			<div id="box_conts">
				<article id="skipnav">
				
					<!-- ============== 해당 페이지 타이틀 ============= -->
					<section class="title_cont">
						<h2 class="title">쪽지함</h2>
					</section> 
					
					<!-- ===================== 해당 페이지 본문 컨텐츠 (각자 코드 들어갈 영역)======================= -->
					<section class=""><!-- .box_instruc_con -->
						<div id="printContents"> 
						
						<!-- Board CSS -->
						<link rel="stylesheet" href="/cssExample/css/board.css" media="all">
						
						<article id="content"> 
						<section>
												
							<!-- =============== 글목록 테이블 =============== -->
							<div class="table_wrap alignC marB10">
								<table summary="쪽지목록">
	
									<!-- 관리자계정으로 로그인 시 체크박스 show로 변경 -->
									<colgroup>			
									<col class="w5per" />
									<col class="w7per" />
									<col class="w10per" />
									<col class="w7per" />
									</colgroup>

									<thead>
										<tr>
											<th scope="col" class="checkTh"><input type="checkbox" id="checkAll"></th>
											<th scope="col" class="first">보낸사람</th>
											<th scope="col">내용</th>
											<th scope="col">날짜</th>
										</tr>
									</thead>
									<tbody>
								<%
									if(listBool){
										MmMessageVO mmvo = null;
										for(int i=0;i<list.size();i++){
											mmvo = list.get(i);
								%>
											<tr data-num="<%=mmvo.getMm_no()%>">
												<td><input type="checkbox" name="mm_no"></td>
												<td class="alignC first"><%=mmvo.getI_nameKr() %></td>
												<td class="detail"><%=mmvo.getMm_message() %></td>
												<td class="alignC"><%=mmvo.getMm_insertDate() %></td>
											</tr>
								<%				
										}
									}else if(list.size()==0){
								%>		
										<tr>
											<td class="alignC first last" colspan="8">수신한 쪽지가 없습니다.</td>
										</tr>
								<%		
									} // end of if
								%>
									</tbody>
								</table>	
							</div> <!-- //.table_wrap alignC marB10 -->
							
							<!-- 글쓰기 버튼 출력  -->
							<div class="marB40">
								<input class="grey_btn" type="button" id="delete_btn" value="삭제">
								<input class="blue_btn" type="button" id="write_btn" value="쪽지쓰기">
							</div> <!-- end of 글쓰기버튼 container -->
							<!-- ================ 페이징 내비게이션 출력 ============== -->
							<!-- 페이징 인덱스 번호 클릭해서 이동할 때 필요한 데이터 -->
							<section class="marB100">
								<jsp:include page="pagingM.jsp">
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
	<!-- ============================ // 푸터 ================================ -->
<!-- =========================== end of 공통프레임 ================================ -->
	</body>
<%
	}
%>		
</html>