<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.uniform.bm.reply.vo.BmReplyVO" %>    
<%@ page import="java.util.List" %>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
					  "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, 
									   minimum-scale=1.0, user-scalable=no, target-densityDpi=medium-dpi">
		<title>댓글</title>
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
			// 댓글 페이징용 데이터
			String replyTotal = (String)request.getAttribute("replyTotal");
			String curReplyPage = (String)request.getAttribute("curReplyPage");	
			// 조회한 글번호
			String bm_no = request.getParameter("bm_no");
			
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
		
			var bm_no = "<%=bm_no%>";
			var i_no = "<%=i_no%>";
		
			$(document).ready(function(){
				
				// 댓글전체목록 호출 함수 불러오기				
				callReplyList();
				
				// ====== 등록버튼 클릭 이벤트 ============
				$("#replyInsert").click(function(){
					console.log("댓글등록버튼 클릭!");
					console.log('bm_no : ' + bm_no + ', i_no : ' + i_no);
					
					var bm_recontext = $("#bm_recontext").val();
					
					$.ajax({
						url:"/reply/replyInsert.uni",
						type:"post",
						dataType:"html",
						data:{
							i_no: i_no,
							bm_no: bm_no,
							bm_recontext: bm_recontext
						},
						success:function(insertResult){
							console.log("댓글등록 ajax 성공 >>> insertResult : " + insertResult);
							alert(insertResult);
							// 입력데이터 초기화 함수 호출
							dataReset();
							// 댓글전체목록 호출
							callReplyList();
						},
						error:function(request, status, error){
			            	alert('댓글 등록에 실패했습니다.');
			            	alert('code='+request.status+" message=" + request.responseText + " error=" + error);
						}
					}); // end of ajax
					
				}); // end of 등록버튼 클릭
				
				// ====== 댓글수정 버튼 클릭 후 수정폼 출력 이벤트 ======
				$(document).on("click","#updateForm_btn",function(){
					console.log('댓글수정버튼 클릭! 수정폼 출력 함수!');
					
					// 수정취소 버튼 클릭 ???
					$("#updateReset_btn").click();
					
					// 기존 댓글내용 데이터 가져오기(bm_recontext_p)
					var bm_recontext = $(this).parents("tr").children().children().eq(1).html();
					console.log("bm_recontext : " + bm_recontext);
					// 수정버튼, 삭제버튼 숨기기
					$(this).parents("tr").find("input[type='button']").hide();
					// 댓글정보 데이터 가져오기(info_p)
					$(this).parents("tr").children().children().eq(0).html();
					
					// 댓글내용 출력되던 bm_recontext_p 영역
					var bm_recontext_p = $(this).parents("tr").children().children().eq(1);
					// 댓글내용영역 입력데이터 초기화
					bm_recontext_p.html("");
					
					// 댓글수정폼 데이터 뿌려서 출력
					var data = "<textarea name='bm_recontextUp' id='bm_recontextUp'>" + bm_recontext + "</textarea>";
					data += "<input type='button' id='update_btn' value='등록'>";
					data += "<input type='button' id='updateReset_btn' value='취소'>";
					bm_recontext_p.html(data);
					
				});	// end of 수정버튼 수정폼 출력 이벤트
				
				// ====== 수정취소 버튼 클릭 이벤트
				$(document).on("click","#updateReset_btn",function(){
					console.log('수정취소버튼 클릭이벤트 호출!');
					
					var bm_recontext =  $(this).parents("tr").find("textarea").html();
					$(this).parents("tr").find("input[type='button']").show();
					var bm_recontext_p = $(this).parents("tr").children().eq(1);
					bm_recontext_p.html(bm_recontext);
				}); // end of 수정취소버튼 클릭 - 수정폼출력
				
				// ====== 댓글수정완료버튼 클릭 이벤트 ==============
				$(document).on("click","#update_btn",function(){
					console.log('댓글수정완료버튼 클릭!');
					
					var bm_reno = $(this).parents("tr").attr("data-bm_reno");
					var bm_recontext = $("#bm_recontextUp").val();
					
					$.ajax({
						url:"/reply/replyUpdate.uni",
						type:"post",
						dataType:"html",
						data:{
							i_no: i_no,
							bm_reno: bm_reno,
							bm_recontext: bm_recontext
						},
						success:function(updateResult){
							console.log("댓글수정 ajax 성공 >>> updateResult : " + updateResult);
							alert(updateResult);
							
							// 댓글전체목록 호출
							callReplyList();
						},
						error:function(request, status, error){
			            	alert('댓글 수정에 실패했습니다.');
			            	alert('code='+request.status+" message=" + request.responseText + " error=" + error);
						}
					}); // end of ajax
				}); // end of 수정완료버튼 클릭 이벤트
				
				// ======== 댓글삭제버튼 클릭 이벤트 =====================
				$(document).on("click","#delete_btn",function(){
					console.log('댓글삭제버튼 클릭!');
					
					var bm_reno = $(this).parents("tr").attr("data-bm_reno");
					
					if(confirm("댓글을 삭제하시겠습니까?")){
						$.ajax({
							url : "/reply/replyDelete.uni",
							type: "post",
							dataType: "html",
							data: {
								i_no: i_no,
								bm_reno: bm_reno
							},
							success:function(deleteResult){
								console.log("댓글삭제 ajax 성공 >>> deleteResult : " + deleteResult);
								alert(deleteResult);
								
								// 댓글전체목록 호출
								callReplyList();
							},
							error:function(request, status, error){
				            	alert('댓글 삭제에 실패했습니다.');
				            	alert('code='+request.status+" message=" + request.responseText + " error=" + error);
							}
						}); // end of ajax
					} // end of confirm if
				}); // end of 댓글삭제버튼 클릭 이벤트	
				
				// ===== 댓글 새로고침 버튼 클릭 =========================
				$("#refresh_btn").click(function(){
					console.log("댓글 새로고침 버튼 클릭!");
					
					// 댓글전체목록조회 함수 호출 => 안됨
					//callReplyList();
				});	
			
			}); // end of document ready
			
			// 댓글전체목록 불러오는 함수
			function callReplyList(){
				console.log('callReplyList 함수 호출!');
				console.log('bm_no : ' + bm_no + ', i_no : ' + i_no);
				
				$("#replyList_ul").html("");
				
				$.ajax({
					url:"/reply/replyList.uni",
					type:"post",
					dataType:"JSON",
					data:{
						bm_no: bm_no,
						i_no: i_no
					},
					success:function(array){
						console.log('댓글전체목록조회 ajax 성공 >>> ' + array);
						var replyList = array;
						
						addNewReply(replyList);
					},
					error:function(){
						alert('댓글전체목록 조회 ajax 실패');
					}
				}); // end of ajax
				
			} // end of callReplyList
			
			// 새 댓글을 화면에 추가해서 출력하는 함수
			function addNewReply(replyList){
				console.log('addNewReply 함수 호출! >>> 조회된 댓글 갯수 replyList.length : ' + replyList.length);
				
				
				for(var i=0; i<replyList.length; i++){
					var bm_reno = replyList[i].bm_reno;
					var replyWriterI_no = replyList[i].i_no;
					var i_nameKr = replyList[i].i_nameKr;
					var bm_reinsertdate = replyList[i].bm_reinsertdate;
					var bm_recontext = replyList[i].bm_recontext;
					
					console.log('replyList['+i+'] >>>\nbm_reno : ' + bm_reno + ', i_nameKr : ' + i_nameKr + ', bm_reinsertdate : ' + bm_reinsertdate + ', bm_recontext : ' + bm_recontext );
					
					var replyWriterBool = replyWriterI_no == i_no;
					var replyMasterBool = i_no.indexOf("M") == 0;
					console.log('replyWriterBool : ' + replyWriterBool + ', replyMasterBool : ' + replyMasterBool);

					// 새 댓글 추가할 li태그 객체
					var newRe_li = $("<tr>");
					newRe_li.attr("data-bm_reno",bm_reno);
					newRe_li.attr("data-i_no",i_no);
					
					var newRe_td = $("<td>");
					newRe_td.addClass("first");
					newRe_td.addClass("last");
					
					// 작성정보가 출력될 <p>태그
					var info_p = $("<p>");
					info_p.addClass("marT5 marL5 marB5");
					
					// 댓글번호
					var num_span = $("<span>");
					num_span.addClass("bold");
					num_span.html(i+1);
					
					// 작성자명
					var i_nameKr_span = $("<span>");
					i_nameKr_span.addClass("bold");
					i_nameKr_span.addClass("marL5");
					i_nameKr_span.html(i_nameKr);
					
					// 작성일
					var bm_reinsertdate_span = $("<span>");
					bm_reinsertdate_span.addClass("marL10");
					bm_reinsertdate_span.html(bm_reinsertdate);
					
					if(replyWriterBool || replyMasterBool){		
						// 수정폼 출력버튼
						var updateForm_btn_input = $("<input>");
						updateForm_btn_input.attr({"type":"button","id":"updateForm_btn","value":"수정"});
						updateForm_btn_input.addClass("reply_btn");
	
						// 삭제버튼
						var delete_btn_input = $("<input>");
						delete_btn_input.attr({"type":"button","id":"delete_btn","value":"삭제"});
						delete_btn_input.addClass("reply_btn");
					}	
					
					// 내용
					var bm_recontext_p = $("<p>");
					bm_recontext_p.addClass("marT5 marL5 marB5");
					bm_recontext_p.html(bm_recontext);
					
					// 조립하기
					info_p.append(num_span).append(i_nameKr_span).append(bm_reinsertdate_span).append(updateForm_btn_input).append(delete_btn_input)
					newRe_td.append(info_p).append(bm_recontext_p)
					newRe_li.append(newRe_td);
					$("#replyList_ul").append(newRe_li);
					
				} // end of for
			} // end of addNewReply 함수
			
			// ===== 댓글 등록시 입력한 데이터 초기화 함수 ====
			function dataReset(){
				$("#bm_recontext").val("");
			}
			
			// =========== 댓글페이징 함수 ===========
			function goReplyList(replyPage){
				console.log("goReplyList 함수 호출! >>> replyPage : " + replyPage);
				// 히든테그에 밸류값 바인딩 후 submit
				$("#replyPage").val(replyPage);
				
				$("#replyPagingForm")
				.attr({
					"method":"post",
					"action":"/reply/replyList.uni"
				}).submit();
			} // end of goReplyList 함수
		</script>

	</head>
	<body>
	<%
		// 댓글 총갯수

	%>
		<div class="table_wrap">
			<!-- =================== 댓글 입력폼 ==================== -->						
				<table>
					<thead>
						<tr>
							<th class="alignL">댓글 총00개</th>
						</tr>
					</thead>
					<tbody id="replyList_ul">	
					
						<!-- 동적생성요소 댓글리스트 들어갈 자리 -->	
					
					</tbody>
				</table>
			<form id="replyInsertForm">	
				<table class="reply_insert_wrap">
					<tr class="marT5 marL5 marB5">
						<td>
							<lable for="bm_recontext" style="vertical-align:middle;"><b>댓글</b></lable>
							<textarea name="bm_recontext" id="bm_recontext" placeHolder="댓글을 입력해주세요."></textarea>
							<input type="button" class="blue_btn" id="replyInsert" value="등록" style="vertical-align:middle;"/>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</body>
<%
	} // end of session if문
%>		
</html>