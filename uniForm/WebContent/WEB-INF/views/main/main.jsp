<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.uniform.em.common.vo.EmCommonVO" %>    
<%@ page import="java.util.List" %>
<%@ page import="com.uniform.nm.notice.vo.NmNoticeVO" %>
<%@ page import="com.uniform.mm.message.vo.MmMessageVO" %>
<%@ page import="com.uniform.bm.board.vo.BmBoardVO" %>
<%@ page import="com.uniform.ea.approval.vo.PageVO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densityDpi=medium-dpi">
		<title>Uniform</title>
		<script type="text/javascript"
				src="/include/js/jquery-1.11.0.min.js"></script>
		<script type="text/javascript"
				src="/include/js/alarm.js"></script>		
		
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
%>		
		<!-- 
		<script type="text/javascript"
				src="/include/js/jquery-1.11.0.min.js"></script>
				 -->		 
		<script type="text/javascript">
			$(document).ready(function(){
				$("#test").hide();
<%
	Object obj = request.getAttribute("mainVO");
	EmCommonVO ecvo = (EmCommonVO)obj;
	String i_nameKr = ecvo.getI_nameKr();
	String em_img = ecvo.getEm_img();
	String em_position = ecvo.getEm_position();
	String em_dept = ecvo.getEm_dept();
	String em_team = ecvo.getEm_team();
	if(em_dept==null) em_dept = "";
	if(em_team==null) em_team = "";
	if(em_position==null) em_position = "";
	
	int mSize = (int)request.getAttribute("mSize");
	boolean masterBool = i_no.indexOf("M") > -1;
	
	List<NmNoticeVO> nList = (List<NmNoticeVO>)request.getAttribute("noticeList");
	NmNoticeVO nnvo = null;
	
	List<BmBoardVO> bList = (List<BmBoardVO>)request.getAttribute("boardList");
	BmBoardVO bbvo = null;
	
	List<MmMessageVO> mList = (List<MmMessageVO>)request.getAttribute("messageList");
	MmMessageVO mmvo = null;
	
	List<PageVO> toList = (List<PageVO>)request.getAttribute("toList");
	PageVO pvo = null;
%>				
				if(<%=masterBool%>){
					$("#myA").hide();
				}// 마스터 계정일 경우 마이페이지 버튼을 숨기는 if문 종료

			});
			
		</script>
		
		<script type="text/javascript">
			var i_no = "<%=i_no%>";
	        
	    </script>	
	    <style>
	    	.my_table{
	    		border-top: 3px solid #565c6b !important;
				border-bottom: 3px solid #565c6b;
	    	}
	    	.my_table td{
	    		padding:8px;
	    	}
	    	.name{
	    		text-align:right;
	    		font-weight:bold;
	    		vertical-align:bottom;
	    	}
	    	.gogogo{
	    		font-size:20px;
	    		font-weight:bold;
	    	}
	    	.univ_img{
	    		position: relative;
				width: 100%;
				height: 175px;
	    		background: url("/cssExample/img/mainImg.jpg") 50% 80% no-repeat;
	    	}
			.whole .none{
				width: 15px;
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
 			/*내용의 5줄 높이 */
			table tr {
				height: 30px;
			}	    	
			table .contents{
				height: 25px;
				font-size: 15px;
				background-color: #f4f5f7;
			}	    	
	    	table .b_cate{
	    		width:25px;
	    	}
	    	table .b_sub{
	    		width: 140px;
	    	}
	    	table .b_name{
	    		width: 30px;
	    	}
	    	table .b_date{
	    		width: 30px;
	    	}

	    	table .e_type{
	    		width:25px;
	    	}
	    	table .e_ti{
	    		width: 140px;
	    	}
	    	table .e_sta{
	    		width: 30px;
	    	}
	    	table .e_wri{
	    		width: 30px;
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

			</div>
			<!-- // GNB -->
			<!-- LNB -->
			<div class="box_lnb">
				<div class="wrap1200 box_logo">
					<h2 style="font-size:4.5em;">
						<a href="/main/goMain.uni"><img src="/cssExample/img/uniform_logo1.jpg" width="209px" style="margin:10px 0" alt="유니폼 로고"></a>
					</h2>
				</div>
				
				<nav>
					<ul>
						<li style="background-image: none;"><a href="#" id="navFirst">학교정보</a>
						</li>
						<li><a href="/ea/main.uni">전자결재</a>
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
	<p></p>	
	<p></p>	
	<div class="box_cate_name mnd01">
		<h2></h2>
	</div>	
	<!-- 헤더 nav --> 

	<!-- body -->
	<div id="box_wrap_body" class="wrap1200">
		<div id="box_sub">
			<!-- 사이드바 -->
		
<div id="box_sidebar">
	<div align="center">   
		<table class="my_table" style="text-align:center;">
			<tr align="center">
				<td style="padding:0px;" rowspan="4" height="140" ><img width="105" height="140" src="/common/img/<%=em_img%>" align="left"></td>
				<td colspan="2" class="name" height="65"><%=i_nameKr %> <%=em_position %></td>
			</tr>
			<tr height="25" style="text-align:right;">
				<td colspan="2" style="padding:0px;">&nbsp;&nbsp;&nbsp;<%=i_no %></td>
			</tr>
			<tr height="25" style="text-align:right;">
				<td colspan="2" style="padding:0px;">&nbsp;&nbsp;<%=em_dept%></td>
			</tr>
			
			<tr height="25" style="text-align:right;">
				<td colspan="2" style="padding:0px;">&nbsp;&nbsp;<%=em_team %></td>
			</tr>
			
			<tr>
			    <td>쪽지 <a href="/mm/goMessageMain.uni"><%=mSize %></a> 개	</td>
				<td style="color:#000080;font-weight:bold;">
<%
				if(i_no.indexOf("E")>-1){
%>				
					<a href="/main/goMyInfo.uni" id="myA">My Page</a>
<%
				}
%>				
				</td>
				<td><a href="/sm/logout.uni">Logout</a></td>
			</tr>

		</table>
	</div>
	<!-- SNB -->

	<!-- // SNB -->
</div>	

<!-- 컨텐츠 -->
<div id="box_conts">	
	<article id="skipnav">
		<section class="title_cont">
<!-- 			<h2 class="title">전자결재</h2> -->
		</section> 
		<!-- 컨텐츠 내용 --> 
		<section class="">
			<div id="printContents"> 
				<section class="marB40">	
				
		<input type="hidden" id="size" value="<%=mSize%>">
		<input type="hidden" id="i_no" value="<%=i_no%>">	

		<table class="whole">
			<!-- 공지사항 -->
			<tr>
			<td>			
			<table class="t1">
				<tr>
					<td colspan="4" align="left"><a class="gogogo" href="#">공지사항</a></td>
				</tr>
				<tr class="contents" height=25>
					<td class="b_cate">분류</td>
					<td class="b_sub">제목</td>
					<td class="b_name">작성자</td>
					<td class="b_date">작성일</td>
				</tr>
<%
	if(nList.size()>0){
		for(int i=0;i<nList.size()&&i<5;i++){
			nnvo = nList.get(i);
			String nm_category = nnvo.getNm_category();
			String nm_subject = nnvo.getNm_subject();
			String nm_ino = nnvo.getI_no();
			String nm_insertdate = nnvo.getNm_insertDate();
			
			if(nm_subject.length()>7){
				nm_subject = nm_subject.substring(0,7) + "...";
			}
%>
				<tr>
					<td><%=nm_category%></td>
					<td><%=nm_subject%></td>
					<td><%=nm_ino%></td>
					<td><%=nm_insertdate%></td>
				</tr>
<%			
		} //for
		for(int j=0;j<5-(nList.size());j++){
%>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>										
<%					
		} //for
		
	}else{
%>
				<tr>
					<td colspan="4" height="151px" align="center">조회된 공지사항이 없습니다.</td>
				</tr>
<%	
	} //if 
%>				
			</table>
			</td>
			
			<td class="none"></td>
			<!-- 쪽지 -->
			<td>
			<table class="t2">
				<tr>
					<td colspan="3" align="left"><a class="gogogo" href="#">쪽지</a></td>
				</tr>
				<tr class="contents" height=25>
					<td>보낸사람</td>
					<td>내용</td>
					<td>날짜</td>
				</tr>
<%
	if(mList.size()>0){
		for(int k=0;k<mList.size()&&k<5;k++){
			mmvo = mList.get(k);
			String mm_inamekr = mmvo.getI_nameKr();
			String mm_message = mmvo.getMm_message();
			String mm_insertdate = mmvo.getMm_insertDate();
			
			if(mm_message.length()>7){
				mm_message = mm_message.substring(0,7) + "...";
			}
%>
				<tr>
					<td><%=mm_inamekr%></td>
					<td><%=mm_message%></td>
					<td><%=mm_insertdate%></td>
				</tr>
<%			
		} //for
		for(int l=0;l<5-(mList.size());l++){
%>
				<tr>
					<td></td>
					<td></td>
					<td></td>
				</tr>					

<%			
		} //for
		
	}else{
%>		
				<tr>
					<td colspan="3" height="151px" align="center">조회된 쪽지가 없습니다.</td>
				</tr>		

<%		
	}
%>				
			</table>
			</td>			
			</tr>
			
			<!-- 게시판 -->
			<tr>
			<td>
			<table class="t3">
				<tr>
					<td colspan="4" align="left"><a class="gogogo" href="/board/boardList.uni">게시판</a></td>
				</tr>
				<tr class="contents" height=25>
					<td class="b_cate">분류</td>
					<td class="b_sub">제목</td>
					<td class="b_name">작성자</td>
					<td class="b_date">작성일</td>
				</tr>
<%
	if(bList.size()>0){
		for(int m=0;m<bList.size()&&m<5;m++){
			bbvo = bList.get(m);
			String bm_category = bbvo.getBm_category();
			String bm_subject = bbvo.getBm_subject();
			String bm_inamekr = bbvo.getI_nameKr();
			String bm_insertdate = bbvo.getBm_insertdate();
			
			if(bm_subject.length()>7){
				bm_subject = bm_subject.substring(0,7) + "...";
			}
%>			
				<tr>
					<td><%=bm_category%></td>
					<td><%=bm_subject%></td>
					<td><%=bm_inamekr%></td>
					<td><%=bm_insertdate%></td>
				</tr>		
<%			
		} //for
		for(int n=0;n<5-(bList.size());n++){
%>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>				
<%			
		} //for	
	}else{
%>		
				<tr>
					<td colspan="4" height="151px" align="center">조회된 게시글이 없습니다.</td>
				</tr>
<%		
	}
%>				
			</table>
			</td>
			
			<td class="none"></td>
			<!-- 결재할 문서 -->
			<td>
			<table class="t4">
				<tr>
					<td colspan="4" align="left"><a class="gogogo" href="/ea/goMenuTo.uni">결재할 문서</a></td>
				</tr>
				<tr class="contents" height=25>
					<td class="e_type">종류</td>
					<td class="e_ti">제목</td>
					<td class="e_sta">상태</td>
					<td class="e_wri">작성자</td>
				</tr>
<%
	if(toList.size()>0){
		for(int o=0;o<toList.size()&&o<5;o++){
			pvo = toList.get(o);
			String do_type = pvo.getDo_type();
			String do_writer = pvo.getDo_writer();
			String do_title = pvo.getDo_title();
			String do_insertdate = pvo.getDo_insertdate();
			String ea_stateno = pvo.getEa_stateno();
			if(ea_stateno.equals("71")) ea_stateno="대기";
			if(ea_stateno.equals("72")) ea_stateno="1차검토";
			if(ea_stateno.equals("73")) ea_stateno="2차검토";
			
			if(do_writer.length()>7){
				do_writer = do_writer.substring(0,7) + "...";
			}
%>		 
				<tr>
					<td><%=do_type%></td>
					<td><%=do_title%></td>
					<td><%=ea_stateno%></td>
					<td><%=do_writer%></td>
				</tr>
<%			
		}
		for(int p=0;p<5-(toList.size());p++){
%>		
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>		
<%		}
	}else{
%>		
				<tr>
					<td colspan="4" height="151px" align="center">조회된 문서가 없습니다.</td>
				</tr>
<%		
	}

%>				
				
			</table>
			</td>
			</tr>
		
		</table>

				</section>
			</div>
		</section>
	</article>
<!-- </div>	 -->
				 
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

	</body>
<%
	}
%>	
</html>