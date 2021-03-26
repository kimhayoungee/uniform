<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.List" %>
<%@ page import="com.uniform.ea.approval.vo.EaPoomVO" %>
<%@ page import="com.uniform.ea.approval.vo.EaLineVO" %>
<%@ page import="com.uniform.ea.approval.vo.EaDocumentVO" %>
<%@ page import="com.uniform.ea.approval.vo.EaApprovalVO" %>
<%@ page import="com.uniform.common.info.vo.CommonInfoVO" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.HashMap"%>

<%
    Object obj1 = request.getAttribute("EaPoomVO");
	Object obj2 = request.getAttribute("EaLineVO");
	Object obj3 = request.getAttribute("EaDocumentVO");
	Object obj4 = request.getAttribute("EaApprovalVO");
	Object obj5 = request.getAttribute("sign");	
	
	List<EaPoomVO> list = (List<EaPoomVO>)obj1;   
	String do_docno = "";
	String do_type = "";
	String do_writer = "";
	String do_writerno = "";
	String do_title = "";
	String do_insertdate = "";
	String po_team = "";
	String po_data = "";
	String po_attach = "";
	String po_insertdate = "";
	String po_updatedate = "";
	
	for(int i=0; i<list.size(); i++){
		EaPoomVO p = list.get(i);
		do_docno = p.getDo_docno();
		do_type = p.getDo_type();
		do_writerno = p.getDo_writerno();
		do_writer = p.getDo_writer();
		do_title = p.getDo_title();
		do_insertdate = p.getDo_insertdate();
		po_team = p.getPo_team();
		po_data = p.getPo_data();
		po_attach = p.getPo_attach();
		po_insertdate = p.getPo_insertdate();
		po_updatedate = p.getPo_updatedate();
	}	
	
	List<EaLineVO> line = (List<EaLineVO>)obj2;
	String ea_lineno = "";
	String ea_linename = "";
	String ea_line1 = "";
	String ea_line2 = "";
	String ea_line3 = "";
	if(line!=null){
		for(int i=0; i<line.size(); i++){
			EaLineVO l = line.get(i);
			ea_lineno = l.getEa_lineno();
			ea_linename = l.getEa_linename();
			ea_line1 = l.getEa_line1();
			ea_line2 = l.getEa_line2();
			ea_line3 = l.getEa_line3();		
		}
	}
	
	List<EaDocumentVO> doc = (List<EaDocumentVO>)obj3;
	
	
	String do_deleteyn = "";
	String do_lineno = "";
	String do_aprno = "";
	
	if(doc!=null){
		for(int i=0; i<doc.size(); i++){
			EaDocumentVO d = doc.get(i);
			do_docno = d.getDo_docno();
			do_type = d.getDo_type();
			do_writer = d.getDo_writer();
			do_writerno = d.getDo_writerno();
			do_title = d.getDo_title();
			do_insertdate = d.getDo_insertdate();
			do_deleteyn = d.getDo_deleteyn();
			do_lineno = d.getDo_lineno();
			do_aprno = d.getDo_aprno();
		}
	}	
	
	List<EaApprovalVO> ea = (List<EaApprovalVO>)obj4; 
	String ea_no = "";
	String ea_docno = "";
	String ea_aprno = "";
	String ea_stateno = "";
	String ea_sign1 = "";
	String ea_sign2 = "";
	String ea_sign3 = "";
	String ea_comment = "";
	String ea_date = "";
	
	if(ea!=null){
		for(int i=0; i<ea.size(); i++){
			EaApprovalVO e = ea.get(i);
			ea_no = e.getEa_no();
			ea_docno = e.getEa_docno();
			ea_aprno = e.getEa_aprno();
			ea_stateno = e.getEa_stateno();
			ea_sign1 = e.getEa_sign1();
			ea_sign2 = e.getEa_sign2();
			ea_sign3 = e.getEa_sign3();
			ea_comment = e.getEa_comment();
			ea_date = e.getEa_date();
		}
	}	
	
	String sign = (String)obj5;
	String em_sign = "";

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1.0
      , maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densityDpi=medium-dpi">
      	<title>품의서 작성</title>
      
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

<title>품의서 디테일</title>
<script type="text/javascript"
         src="https://code.jquery.com/jquery-1.11.0.min.js"></script>
         
      <script type="text/javascript">

      var state = "<%=ea_stateno %>";
      var line = "<%=ea_linename%>";
      
      
         $(document).ready(function(){
        	 if("#first".val == null){
             	$("#b").hide();
             	$("#c").hide();
             }
        	 if("#second".val == null){
        		 $("#c").hide();
        	 }
            $("#sign_btn").click(function(){
               alert("승인클릭");
               
              if(state == "71")$("#ea_stateno").val("72");
              if(state == "72" && line =="품의전결"){
            	  $("#ea_stateno").val("74");
              }
              if(state == "72" && line !="품의전결"){
            	  $("#ea_stateno").val("73");
              }
              if(state=="73")$("#ea_stateno").val("76");
              
               $("#eaPoomDetailForm").attr("action", "/ea/poomSign.uni");
               $("#eaPoomDetailForm").submit();               
            }); 
            
            $("#back_btn").click(function(){
                alert("반려클릭");
          		alert("doc > " + $("#do_docno").val());
                $("#eaPoomDetailForm").attr("action", "/ea/poomBack.uni");
                $("#eaPoomDetailForm").submit();               
             });
            
            $("#a").click(function(){
                
               	$("#first").attr("src", "<%=sign %>");
               	$("#a").hide();
                $("#poomDetail").submit();               
             });
            
			$("#b").click(function(){
                
               	$("#second").attr("src", "<%=sign %>");
               	$("#b").hide();
                $("#poomDetail").submit();               
             });
             
			$("#c").click(function(){
			    
			   	$("#last").attr("src", "<%=sign %>");
			   	$("#c").hide();
			    $("#poomDetail").submit();               
			 });
            
            $("#download_btn").click(function(){
                alert("파일다운로드 클릭");
          
                $("#downForm").attr("action", "/ea/poomDownload.uni");
                $("#downForm").submit();               
             });
         });   
                 
      </script>
      
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
			.cate{
				font-weight: bold;
				text-align:center;
			}
			.cate2{
				font-weight: bold;
				text-align:right;
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
										<li><a href="/ea/goUploadList.uni">양식다운로드</a></li>
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
						<a href="#none">결재 할 문서</a>
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
			<li><a href="/ea/goUploadList.uni">양식 다운로드</a></li>
		</ul>
	</nav>
	<!-- // SNB -->
</div>

<!-- 컨텐츠 -->
<div id="box_conts">
<article id="skipnav">
		<section class="title_cont">
		</section> 
		<!-- 컨텐츠 내용 --> 
		<section class="box_instruc_con">
			<div id="printContents"> 
				<section class="marB40">
				
      <form name="eaPoomDetailForm" id="eaPoomDetailForm" method="post">
      	<input type="button" class="blue_btn" name="sign_btn" id="sign_btn" value="승인">            
        <input type="button" class="grey_btn" name="back_btn" id="back_btn" value="반려">
      	
      	<input type="hidden" name="do_docno" id="do_docno" value="<%=do_docno %>">
      	<input type="hidden" name="do_stateno" id="do_stateno">
      	
      	<h2 colspan="2" height="80" style="text-align:left; font-size:30px;">품의서</h2>
      </form>
      <div class="table_wrap">
      <table border="0" style="border-collapse:collapse;">       
         
         <tr>
            <td width="350">
            <!-- 공통부분(파일업로드,폼) -->      
               <table class="eadocument">
                  <tr height="35">
                     <td width="100" class=cate>작성일자</td>
                     <td><input type="text" style="border:0" name="po_insertdate" id="po_insertdate" style="width:250px;"
                     value="<%=do_insertdate %>"></td>
                  </tr>
                  <tr height="35">
                     <td class=cate>결재라인명</td>
                     <td><input type="text" style="border:0" name="ea_linename" id="ea_linename" style="width:250px;"
                     value="<%=ea_linename %>"></td>
                  </tr>
                  <tr height="35">
                     <td class=cate>팀</td>
                     <td><input type="text" style="border:0" name="po_team" id="po_team" style="width:250px;"
                     value="<%=po_team %>"></td>
                  </tr>
                  <tr height="35">
                     <td class=cate>작성자</td>   <!-- 작성자명 -->
                     <td><input type="text" style="border:0" name="po_writer" id="po_writer" style="width:250px;"
                     value="<%=do_writer %>"></td>
                  </tr>
                  <tr height="35">
                     <td class=cate>제목</td>
                     <td><input type="text" style="border:0" name="po_title" id="po_title" style="width:250px;"
                     value="<%=do_title %>"></td>
                  </tr>
               </table>
            </td>
            
            <td width="300" align="right">
               <!-- 결재라인 -->
               <table class="ea">
               <tr height="35">
                     <td width="95" class=cate>1차결재</td>
                     <td width="95" class=cate>2차결재</td>
                     <td width="95" class=cate>결재</td>
                  </tr>
                  <tr height="95">
                     <td height="95"><img src="<%=ea_sign1%>"></td>
                     <td height="95"><img src="<%=ea_sign2%>"></td>
                     <td height="95"><img src="<%=ea_sign3%>"></td>
                  </tr>            
 <!-- <input type="button" name="a" id="a"> <input type="button" name="b" id="b"> <input type="button" name="c" id="c">  -->
            <tr>
	 			<td width=80><input type="text" style="width:110px; border:0" name="ea_line1" id="ea_line1"  value="<%=ea_line1 %>" readonly></td>
	 			<td width=80><input type="text" style="width:110px; border:0" name="ea_line2" id="ea_line2"  value="<%=ea_line2 %>" readonly></td>
	 			<td width=80><input type="text" style="width:110px; border:0" name="ea_line3" id="ea_line3"  value="<%=ea_line3 %>" readonly></td>                  
            </tr>
               </table>            
      </table>
      </div>
      <!-- 문서내용부분  -->
      <table class="eapoom">
         <tr height="35">
            <td width="95px" class=cate>첨부파일</td>
            <td><input type="text" name="po_attach" id="po_attach" style="width:150px; border:0" value="<%=po_attach %>">
            <input type="button" class="blue_btn" style="float:left;" name="download_btn" id="download_btn" value="파일다운로드"></td>
         </tr>
         
         <tr height=500>         
            <td width="800" height="500" colspan="2">
               <textarea style="height:500px; width:910px;" name="po_data" id="po_data"><%=po_data %></textarea>
            </td>
         </tr>
      </table>
      
      </section>
			</div>
		</section>
	</article>
   </div>
  </div>
 </div>   
     
      <form id="downForm" name="downForm">
          <input type="hidden" name="file" id="file" value="<%=po_attach %>">
         
      </form>
      </div>
</body>
</html>