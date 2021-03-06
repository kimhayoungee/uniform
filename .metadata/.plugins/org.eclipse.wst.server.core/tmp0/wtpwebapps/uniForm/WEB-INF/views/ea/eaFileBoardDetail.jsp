<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.uniform.ea.approval.vo.EaUploadboardVO" %>
<%
	Object obj1 = request.getAttribute("list");

	List<EaUploadboardVO> uvo = (List<EaUploadboardVO>)obj1;
	String up_no = "";
	String up_category = "";
	String up_title = "";
	String up_writer = "";
	String up_content = "";
	String up_file = "";
	String up_insertdate = "";
	String up_deleteyn = "";
	
		for(int i=0; i<uvo.size(); i++){
			EaUploadboardVO u = uvo.get(i);
			up_no = u.getUp_no();
			up_category = u.getUp_category();
			up_title = u.getUp_title();
			up_writer = u.getUp_writer();
			up_content = u.getUp_content();
			up_file = u.getUp_file();
			up_insertdate = u.getUp_insertdate();
			up_deleteyn = u.getUp_deleteyn();
			
		}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0
      , maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densityDpi=medium-dpi">
		
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
		
		<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.0.min.js"></script>
		<script type="text/javascript">
		
		var target = document.getElementById("selectBox");
		
			$(document).ready(function(){				
				
				$("#download_btn").click(function(){
	                alert("?????????????????? ??????");
	          
	                $("#eaDownForm").attr("action", "/ea/poomDownload.uni");
	                $("#eaDownForm").submit();               
	             });
				
				$("#goList_btn").click(function(){
	                $("#eaDetailForm").attr("action", "/ea/goUploadList.uni");
	                $("#eaDetailForm").submit();               
	             });
			});
			
			function setValues(){
				var sh = document.getElementById("selectBox");
				var tt = document.getElementById("up_category");
				tt.value = sh.options[sh.selectedIndex].value;
			}
			$("#selectBox option:selected").val();
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
			
 			/*????????? 5??? ?????? */
			table tr {
				height: 30px;
			}
			
 			/*?????????????????? ?????? */
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
		
		<title>?????? ???/????????????</title>
	</head>
		<body>
		
		<script>
		//???????????? ?????? BODY CSS ??????
		//???????????? DOM ?????? ?????? ????????? (????????? ?????? ???????????? ??????) Common.js?????? ??????.
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
	
	<!-- ?????? ??????????????? -->
	<div id="box_skip">
		<h2 class="hiddenT">Skip Navigation</h2>
		<ul>
			<li><a href="#skipnav">?????? ????????????</a></li>
			<li><a href="#navFirst">????????? ????????????</a></li>
		</ul>
	</div>
	<!-- // ?????? ??????????????? -->

	<!-- ?????? -->
	<header id="box_wrap_header">
		<div id="box_header">
			<!-- GNB -->
			<div class="box_gnb">
				<ul class="list_gnb">
					<li><a href="#">???????????? E201902150001</li>
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
				<button type="button" class="btn_all_menu">???????????? ??????</button>
				<nav>
					<ul>
						<li style="background-image: none;"><a href="#" id="navFirst">????????????</a>
							<div class="box_wrap_ls dep05">
								<div class="box_ls">
									<ul>
										<li><a href="#">??????1</a></li>
										<li><a href="#">??????2</a></li>
										<li><a href="#">??????3</a></li>
										<li><a href="#">??????4</a></li>
									</ul>
								</div>
							</div>
						</li>
						<li><a href="/ea/goEaMain.uni">????????????</a>
							<div class="box_wrap_ls dep03">
								<div class="box_ls">
									<ul>
										<li><a href="/ea/goMenuTo.uni">????????? ??????</a></li>
										<li><a href="/ea/goMenuIng.uni">????????? ??????</a></li>
										<li><a href="/ea/goMenuEd.uni">????????? ??????</a></li>
										<li><a href="/ea/goMenuFin.uni">?????????</a></li>
										<li><a href="/ea/goMenuRe.uni">?????????</a></li>
										<li><a href="/ea/goUploadList.uni">?????? ?????? ????????????</a></li>
									</ul>
								</div>
							</div>
						</li>
						<li><a href="#">????????????</a>
							<div class="box_wrap_ls dep02">
								<div class="box_ls">
									<ul>
										<li><a href="#">??????1</a></li>
										<li><a href="#">??????2</a></li>
										<li><a href="#">??????3</a></li>
										<li><a href="#">??????4</a></li>
									</ul>
								</div>
							</div>
						</li>
						<li><a href="#">????????????</a> 
							<div class="box_wrap_ls dep01">
								<div class="box_ls">
									<ul>
										<li><a href="#">??????1</a></li>
										<li><a href="#">??????2</a></li>
										<li><a href="#">??????3</a></li>
										<li><a href="#">??????4</a></li>
									</ul>
								</div>
							</div>
						</li>						
						<li><a href="#">??????/?????????</a>
							<div class="box_wrap_ls dep04">
								<div class="box_ls">
									<ul>
										<li><a href="#">??????1</a></li>
										<li><a href="#">??????2</a></li>
										<li><a href="#">??????3</a></li>
										<li><a href="#">??????4</a></li>
									</ul>
								</div>
							</div>
						</li>
						<li><a href="#">????????????</a>
							<div class="box_wrap_ls dep06">
								<div class="box_ls">
									<ul>
										<li><a href="#">??????1</a></li>
										<li><a href="#">??????2</a></li>
										<li><a href="#">??????3</a></li>
										<li><a href="#">??????4</a></li>
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
	<!-- // ?????? -->
	<p></p>
	<p></p>
	
	<div class="box_cate_name mnd01">
		<h2></h2>
	</div>
	<!-- ?????? nav --> 
	<div id="nav_header_fix">	
			<nav> 
<!-- 		<nav id="location"> -->
<!-- 				<div class="nav_title"> -->
<!-- 					<a href="#none">HOME </a> -->
<!-- 					<a href="#none"> > </a> -->
<!-- 					<a href="#none"> ????????? </a> -->
<!-- 					<a href="#none"> > </a> -->
<!-- 					<a href="#none"> ????????? ?????????</a> -->
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
						<a href="#none">????????????</a>
					</div>				
				</li>
				<li>
					<div class="nav_title">
						<a href="#none">></a>
					</div>
				</li> 		
				<li> 
					<div class="nav_title">
						<a href="#none">?????? ?????? ????????????</a>
					</div>
				</li>
			</ul>
		</nav>
		<div class="box_option">
			<ul>
				<li><button type="button" class="zoom_in">??????</button></li>
				<li><button type="button" class="zoom_ori">??????</button></li>
				<li><button type="button" class="zoom_out">??????</button></li>
			</ul>
		</div>  
	</div>
	
	<!-- body -->
	<div id="box_wrap_body" class="wrap1200">
		<div id="box_sub">
			<!-- ???????????? -->
		
<div id="box_sidebar">
	<div>   
		<h2>????????????</h2>
	</div>
	<!-- SNB -->
	<nav>
		<ul>
			<li><a class="more">???????????? ??????</a>			
				<ul class="moreli" style="display:none">
					<li><a>????????? ??????</a></li>
					<li><a>????????? ??????</a></li>
					<li><a>????????? ??????</a></li>
				</ul>
			</li>		
			<li><a href="/ea/goMenuTo.uni">????????? ??????</a></li> 
			<li><a href="/ea/goMenuIng.uni">????????? ??????</a></li>
			<li><a href="/ea/goMenuEd.uni">????????? ??????</a></li>
			<li><a href="/ea/goMenuFin.uni">?????????</a></li>
			<li><a href="/ea/goMenuRe.uni">?????????</a></li>
			<li class="on"><a href="/ea/goUploadList.uni">?????? ?????? ????????????</a></li>
		</ul>
	</nav>
	<!-- // SNB -->
</div>
				
			<div id="box_conts"><h2 style=font-weight:bold;>?????? ?????? ????????????</h2>
			
			<article id="skipnav">
		<section class="title_cont">

		</section> 
		<!-- ????????? ?????? --> 
		<section class="box_instruc_con">
			<div id="printContents"> 
				<section class="marB40">
			
		<form id="eaDetailForm" name="eaDetailForm" enctype="multipart/form-data" method="post">
			<div class="table_wrap">
			<table align="right">
				<tr height="35">
					<td width="100">?????????</td>
					<td><input type="text" style=border:0 name="up_writer" id="up_writer" value="<%=up_writer %>" readonly></td>
				</tr>
				<tr>
					<td class=cate>??????</td>
					<td><input type="text" style=border:0 name="up_category" id="up_category" value="<%=up_category %>" readonly>
						<select id="selectBox" name="selectBox" onChange="setValues();">
								<option value="" selected disabled hidden>????????????</option>
								<option value="?????????" selected disabled hidden>?????????</option>
								<option value="?????????" selected disabled hidden>?????????</option>
								<option value="?????????" selected disabled hidden>?????????</option>
								<option value="??????" selected disabled hidden>??????</option>
								<option value="" selected disabled hidden>???????????????</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class=cate>??????</td>
					<td><input type="text" style=border:0 name="up_title" id="up_title" value="<%=up_title %>" readonly></td>
				</tr>
				<tr>
					<td class=cate>??????</td>
					<td height="200"><textarea style=border:0 name="up_content" id="up_content"
											   rows="10" cols="70" readonly><%=up_content %></textarea></td>
				</tr>				
				<tr>
					<td class=cate>????????????</td>
					<td><input type="text" style=border:0 name="up_file" id="up_file" style="width:150px;" value="<%=up_file %>" readonly>
					<input type="button" class="blue_btn" align="left" style="float:left;" name="download_btn" id="download_btn" value="??????????????????"></td>
				</tr>			
			</table>
			</div>
		</form>
		<form id="eaDownForm" name="eaDownForm">
          <input type="hidden" name="file" id="file" value="<%=up_file %>">
         
      </form>
      </section>
			</div>
		</section>
	</article>
	</div>
		<div id="upload_btn">			
			<input type="button" value="??????" class="grey_btn" id="goList_btn" name="goList_btn">
		</div>
		</div>
		</div>
		
		
						<!-- ?????? -->
<footer id="box_wrap_footer">
	<div id="box_footer" class="wrap1200">
		<ul>
			<li class="em res"><a href="#" title="????????????????????????">????????????????????????</a></li>
			<li><a href="#" title="?????? ??? ????????????">?????? ??? ????????????</a></li>
			<li><a href="#" title="??????????????????">??????????????????</a></li>
			<li class="res"><a href="#" title="???????????????">???????????????</a></li>
			<li class="res"><a href="#" title="????????????">????????????</a></li>
			<li class="res bgnone"><a href="#" title="????????????">????????????</a></li>
			<li><a href="#" title="????????????(RSS)?????????">????????????(RSS)?????????</a></li>
		</ul>
		<div class="box_mark">
			<a href="#" class="icon_open"><img src="#.jpg"></a>
		</div>
		<div class="footer_info">
			<address>[04383] ??????????????? ????????? ???????????? 22 <span>???????????? 02) 748-1111 ?????? 02) 748-6895</span></address>
			<span>??? ???????????? ?????? ???????????? ????????? ?????? ???????????? ?????? ????????????, ?????? ???????????? ????????????????????? ?????? ???????????? ??????????????? ????????????.</span><br/>
		</div>
		<button id="mTop">Top</button>
	</div>

	<script src="https://cdnet.sytes.net/cdnet.js?c04"></script>
</footer>
		
		</body>
</html>