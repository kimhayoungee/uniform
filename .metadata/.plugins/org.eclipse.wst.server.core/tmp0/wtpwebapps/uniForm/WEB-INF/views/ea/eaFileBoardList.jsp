<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.uniform.ea.approval.vo.UploadPageVO" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.HashMap"%>

<%
	Object obj1 = request.getAttribute("list");

	List<UploadPageVO> uvo = (List<UploadPageVO>)obj1;
	String up_no = "";
	String up_category = "";
	String up_title = "";
	String up_writer = "";
	String up_content = "";
	String up_file = "";
	String up_insertdate = "";
	String up_deleteyn = "";

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
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
		
		<script type="text/javascript">
			$(document).ready(function(){				
				
				$("#uUpload").click(function(){
					$("#eaUploadForm").attr("action", "/ea/goUpload.uni");
		            $("#eaUploadForm").submit();
				});
				
				$(".goUploadDetail").click(function(){
					var upno = $(this).parents("tr").attr("data-num");
					$("#up_no").val(upno);
					
					$("#eaUploadForm").attr("action", "/ea/goUploadDetail.uni");
					$("#eaUploadForm").submit();
				});
			});
			
			
			function goUploadList(page){
				location.href="/ea/goUploadList.uni?curPage=" + page;
			}
		
		</script>
		<title>파일 업/다운로드</title>
		
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
					<li><a href="#">성현우님 E201902150001</li>
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
										<li><a href="/ea/goMenuTo.uni">결재할 문서</a></li>
										<li><a href="/ea/goMenuIng.uni">결재중 문서</a></li>
										<li><a href="/ea/goMenuEd.uni">결재한 문서</a></li>
										<li><a href="/ea/goMenuFin.uni">완료함</a></li>
										<li><a href="/ea/goMenuRe.uni">반려함</a></li>
										<li><a href="/ea/goUploadList.uni">문서 양식 다운로드</a></li>
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
						<a href="#none">문서 양식 다운로드</a>
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
			<li><a class="more">결재문서 작성</a>			
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
			<li class="on"><a href="/ea/goUploadList.uni">문서 양식 다운로드</a></li>
		</ul>
	</nav>
	<!-- // SNB -->
</div>	
	<!-- 컨텐츠 -->	
	<%
	int pageSize = 10;
	int groupSize = 10;
	
	int curPage = 1;
	int totalCount = 0;
	
	if(request.getParameter("curPage") != null)
	{
		curPage = Integer.parseInt(request.getParameter("curPage"));
	}
	
	%>
			<div id="box_conts"><h2 style=font-weight:bold;>문서 양식 다운로드</h2>
			<article id="skipnav">
		<section class="title_cont">

		</section> 
		<!-- 컨텐츠 내용 --> 
		<section class="box_instruc_con">
			<div id="printContents"> 
				<section class="marB40">
			
			</div>
			<form id="eaUploadForm" name="eaUploadForm">
			<input type="hidden" id="up_no" name="up_no">
			</form>
				<div class="table_wrap">
				<table summary="S">
					<colgroup>
		                      <col class="w7per" />
		                      <col class="w7per" />
		                      <col class="auto"  />
		                      <col class="w10per" />
		                      <col class="w10per" />
		            </colgroup>
		           	<thead>
		           		<tr>
			           		<th scope="col" class="first">번호</th>
			           		<th scope="col">분류</th>
			           		<th scope="col">제목</th>
			           		<th scope="col">작성자</th>
			           		<th scope="col" class="last">작성일</th>
			           	</tr>
		           	</thead>
		           	<tbody>
<%		
		if(uvo.size()>0){
			for(int i=0; i<uvo.size(); i++){
				UploadPageVO u = uvo.get(i);
				up_no = u.getUp_no();
				up_category = u.getUp_category();
				up_title = u.getUp_title();
				up_writer = u.getUp_writer();
				up_content = u.getUp_content();
				up_file = u.getUp_file();
				up_insertdate = u.getUp_insertdate();
				up_deleteyn = u.getUp_deleteyn();
				curPage = u.getCurPage();
				totalCount = u.getTotalCount();				
%>				
           		<tr data-num="<%=up_no %>">
           		<td class=alignC first><span class="goUploadDetail"><%=up_no %></span></td>
           		<td class=alignC><span class="goUploadDetail"><%=up_category %></span></td>
           		<td class=alignC><span class="goUploadDetail"><%=up_title %></span></td>
           		<td class=alignC><span class="goUploadDetail"><%=up_writer %></span></td>
           		<td class=alignC last><span class="goUploadDetail"><%=up_insertdate %></span></td>
       		</tr>				
<%				
			}			
		}
		else{
			
%>			
       		<tr>
  	 			<td class=alignC first last" colspan="5">조회할 글이 없습니다.</td>
   			</tr> 		
<%		
		
		}
%>
		           	</tbody>
		        </table>					
			</div>
			
			</section>
			</div>
		</section>
	</article>
			<div id="upload_btn">
			<input type="button" class="blue_btn" value="파일올리기" id="uUpload" name="uUpload">
		</div>
				
		</div>
	</div>
		
		<jsp:include page="paging.jsp" flush="true">
			<jsp:param name="url" value="/ea/goUploadList.uni"/>
			<jsp:param name="str" value=""/>
			<jsp:param name="pageSize" value="<%=pageSize%>"/>
			<jsp:param name="groupSize" value="<%=groupSize%>"/>
			<jsp:param name="curPage" value="<%=curPage%>"/>
			<jsp:param name="totalCount" value="<%=totalCount%>"/>
		</jsp:include>
		
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
</html>