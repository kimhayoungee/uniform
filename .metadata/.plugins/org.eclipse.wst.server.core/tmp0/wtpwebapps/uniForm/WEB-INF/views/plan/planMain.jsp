<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.uniform.pm.plan.vo.PmPlanVO" %>
<%@ page import="java.util.List" %>   
<%@ page import="com.uniform.em.common.vo.EmCommonVO" %>  
<%
	response.setCharacterEncoding("UTF-8");
%>    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>FullCalendar Example</title>
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
%>	
	<!-- fullcalendar CSS -->
    <link rel=" shortcut icon" href="/api/fullcalendar-4.4.0/image/favicon.ico">
	
    <link rel="stylesheet" href="/api/fullcalendar-4.4.0/vendor/css/fullcalendar.min.css" />
    <link rel="stylesheet" href="/api/fullcalendar-4.4.0/vendor/css/bootstrap.min.css">
    <link rel="stylesheet" href="/api/fullcalendar-4.4.0/vendor/css/select2.min.css" />
    <link rel="stylesheet" href="/api/fullcalendar-4.4.0/vendor/css/bootstrap-datetimepicker.min.css" />
    <link rel="stylesheet" href="/api/fullcalendar-4.4.0/css/main.css">
    <link rel="stylesheet" href="/api/fullcalendar-4.4.0/css/placeMap.css">
    
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:400,500,600">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

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
		
		
		
		<!-- Script 
		<script src="/cssExample/js/jquery.js"></script>
		<script src="/cssExample/js/jquery.ui.js"></script>
		<script src="/cssExample/js/jquery.bxslider.js"></script>
		<script src="/cssExample/js/common.js"></script>  
		<script src="/cssExample/js/custom.js"></script>
		<script src="/cssExample/js/jquery.printElement.min.js"></script>
		<script src="/cssExample/js/main2.js"></script>  
		<script src="/cssExample/js/favoriteMenu.js"></script> 
		<script src="/cssExample/js/masonry.pkgd.js"></script>
		--> 
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

	<!-- ======================= 헤더 ======================== -->
	<header id="box_wrap_header">
		<div id="box_header">
			<!-- GNB -->
			<div class="box_gnb">
				<ul class="list_gnb">
					<li><a href="#"><%=ecvo.getI_nameKr() + " " + ecvo.getI_no() %></a></li>
					<li><a href="/main/goMyInfo.uni" id="myA">MyPage</a></li>
					<li><a href="/sm/logout.uni">LogOut</a></li>
				</ul>
			</div>
			<!-- // GNB -->
			<!-- LNB -->
			<div class="box_lnb">
				<div class="wrap1200 box_logo">
					<h2 style="font-size:4.5em;">
						<a href="/main/goMain.uni"><img src="/cssExample/img/uniform_logo1.jpg" width="209px" alt="유니폼 로고"></a>
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
	<div id="nav_header_fix" style="margin-top:-10px;">	 
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
						<a href="#none">일정관리</a>
					</div>				
				</li>
			</ul>
		</nav>
	</div><!-- ======== end of 헤더 nav 디렉토리 ======= -->
	
	<!-- ========== body .wrap1200 : max-width "1200px", 좌우 padding auto -->
	<div id="box_wrap_body" class="wrap1200">
		<!-- =========== 본문 영역 상하 40px padding ========== -->
		<div id="box_sub" style="padding:20px;">
			<!-- =========== 좌측 사이드바 메뉴 선택 =========== -->   
			<div id="box_sidebar">
				<div>   
					<h2>일정관리</h2>
				</div>
				<!-- ================== 필터  ================================================= -->
       <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">필터</h3>
            </div>
            <div class="panel-body">
                <div class="col-lg-12">
                    <label for="calendar_view">캘린더 조회</label><br>
                    <div class="input-group">
                    	<label class="radio-inline">
	                    	<input class='type_filter' name="typeFilter" type="radio" id="typeFilterAll" value="전체" checked>전체일정
	                    </label>
                    	<br>
                    	<label class="radio-inline">
	                    	<input class='type_filter' name="typeFilter" type="radio" id="typeFilterDept" value="부서" >부서일정
	                    </label>
	                    <br>
	                    <div style="margin-left:20px;">
	                        <label class="checkbox-inline">
	                        	<input class='dept_filter' name="dept_filter" type="checkbox" id="deptFilter12" value="12" disabled>기획처
	                        </label>
	                        <br>
	                        <label class="checkbox-inline">
	                        	<input class='dept_filter' name="dept_filter" type="checkbox" id="deptFilter13" value="13" disabled>교학처
	                        </label>
	                        <br>
	                        <label class="checkbox-inline">
	                        	<input class='dept_filter' name="dept_filter" type="checkbox" id="deptFilter14" value="14" disabled>사무처
	                        </label>
	                        <br>
	                        <label class="checkbox-inline">
	                        	<input class='dept_filter' name="dept_filter" type="checkbox" id="deptFilter15" value="15" disabled>국제협력처
	                        </label>
                        </div>
                        <br>
                        <label class="radio-inline">
	                    	<input class='type_filter' name="typeFilter" type="radio" id="typeFilterMy" value="개인" >개인일정
	                    </label> 
                    </div>
                </div><!-- col-lg-6 -->
            </div><!-- /.filter panel-body -->
        </div><!-- /.filter panel -->
			</div>
			<!-- =================== 본문 내용이 들어갈 컨텐츠 박스 ===================== -->
			<div id="box_conts">
				<article id="skipnav">
					
					<!-- ===================== 해당 페이지 본문 컨텐츠 (각자 코드 들어갈 영역)======================= -->
					<section class=""><!-- .box_instruc_con -->
						<div id="printContents"> 
						
						<article id="content"> 
						<section>
						
<!-- ============================ 일정관리 내용 시작 =================================== -->
    <div class="container" style="width:auto;">
	<!-- ============ 현재 로그인 중인 아이디 세션에서 꺼내온 회원번호 =================================== -->
	<input type="hidden" id="i_no" name="i_no" value="<%=i_no%>">
	
        <!-- ============ 일자 클릭시 공유캘린더 선택 메뉴 오픈 =========================================== -->
        <div id="contextMenu" class="dropdown clearfix">
            <ul class="dropdown-menu dropNewEvent" role="menu" aria-labelledby="dropdownMenu"
                style="display:block; position:relative; margin-bottom:5px;">
                <li><a tabindex="-1" href="#">전체</a></li>
                <li><a tabindex="-1" href="#">부서</a></li>
                <li><a tabindex="-1" href="#">개인</a></li>
                <li class="divider"></li>
                <li><a tabindex="-1" href="#" data-role="close">Close</a></li>
            </ul>
        </div>

		<!-- ============ 캘린더 격자 출력 ======================================================== -->
        <div id="wrapper">
            <div id="loading"></div>
            <div id="calendar"></div>
        </div>
        
        <!-- ============== 일정 상세보기 MODAL ================================================== -->
        <div class="modal fade" tabindex="-1" role="dialog" id="eventDetailModal">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title"></h4>
                    </div>   
                    <div class="modal-body">
                        <div class="row">
                            <div class="col-xs-12">
                                <label class="col-xs-4" for="detail-title">일정명</label>
                                <span class="inputModal" name="detail-title" id="detail-title"></span>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-12">
                                <label class="col-xs-4" for="detail-username">작성자</label>
                                <span class="inputModal" name="detail-username" id="detail-username"></span>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-12">
                                <label class="col-xs-4" for="detail-allDay">하루종일</label>
                                <span class="inputModal allDayNewEvent" name="detail-allDay" id="detail-allDay"></span>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-12">
                                <label class="col-xs-4" for="detail-start">시작일</label>
                                <span class="inputModal" name="detail-start" id="detail-start"></span>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-12">
                                <label class="col-xs-4" for="detail-end">종료일</label>
                                <span class="inputModal" name="detail-end" id="detail-end"></span>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-12">
                                <label class="col-xs-4" for="detail-type">공유캘린더</label>
                                <span class="inputModal" name="detail-type" id="detail-type">전체/부서/개인(수정예정)</span>
                            </div>
                        </div>
            <div class="deptRow-detailEvent">
                        <div class="row">
                            <div class="col-xs-12">        
                                <label class="col-xs-4" for="detail-dept">부서</label>
                               	<span class="inputModal" name="" id="detail-dept"></span>
                            </div>
                        </div>
            </div>            
                        <div class="row">
                            <div class="col-xs-12">
                                <label class="col-xs-4" for="detail-place">장소</label>
                                <span class="inputModal" name="detail-place" id="detail-place"></span>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-12">
                                <label class="col-xs-4" for="detail-participant">내부참여자</label>
                                <span class="inputModal" name="detail-participant" id="detail-participant"></span>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-12">
                                <label class="col-xs-4" for="detail-alarm">알림받기</label>
                                <span class="inputModal alarmNewEvent" id="detail-alarm"></span>
                            </div>
                        </div>
            <div class="alarmTimeRow-detailEvent">
                        <div class="row">
                            <div class="col-xs-12">
                                <label class="col-xs-4" for="detail-alarmTime">알림시간</label>
                                <span class="inputModal" name="detail-alarmTime" id="detail-alarmTime"></span>
                            </div>
                        </div>
            </div>            
                        <div class="row">
                            <div class="col-xs-12">                               
                                <label class="col-xs-4" for="detail-message">쪽지발송</label>
                                <span class="messageNewEvent" id="detail-message"></span>                                     
                            </div>
                        </div>
            <div class="recipientRow-detailEvent">  
                        <div class="row">
                            <div class="col-xs-12">
                                <label class="col-xs-4" for="detail-recipient">쪽지수신인</label>
                                <span class="inputModal" name="detail-recipient" id="detail-recipient"></span>
                            </div>
                        </div>
            </div>            
                        <div class="row">
                            <div class="col-xs-12">
                                <label class="col-xs-4" for="detail-desc">설명</label>
                                <span class="inputModal" name="detail-desc" id="detail-desc" rows="4" cols="50"></span>
                            </div>
                        </div>
                    </div>				 
        		<!-- ================ 일정 상세보기 modal 버튼 =========================================== -->
                <div class="modal-footer modalBtnContainer-detailEvent">
                	<span class="privilege-detailEvent">
                    	<button type="button" class="btn btn-primary" id="updateModal">수정</button>
	                    <button type="button" class="btn btn-danger" id="deleteEvent">삭제</button>	                    
                    </span>&nbsp;
                    <span>
                    	<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
                    </span>                   
                </div><!-- ========================================================= -->
               	    
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->

        <!-- ============== 일정 추가 MODAL ================================================== -->
        <div class="modal fade" tabindex="-1" role="dialog" id="eventModal">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title"></h4>
                    </div>
                    <div class="modal-body">
                        <div class="row">
                            <div class="col-xs-12">
                                <label class="col-xs-4" for="edit-allDay">하루종일</label>
                                <input class='allDayNewEvent' id="edit-allDay" type="checkbox">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-12">
                                <label class="col-xs-4" for="edit-title">일정명</label>
                                <input class="inputModal" type="text" name="edit-title" id="edit-title"
                                    required="required" />
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-12">
                                <label class="col-xs-4" for="edit-start">시작일</label>
                                <input class="inputModal" type="text" name="edit-start" id="edit-start" />
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-12">
                                <label class="col-xs-4" for="edit-end">종료일</label>
                                <input class="inputModal" type="text" name="edit-end" id="edit-end" />
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-12">
                                <label class="col-xs-4" for="edit-type">공유캘린더</label>
                                <select class="inputModal" type="text" name="edit-type" id="edit-type">
                                    <option value="전체">전체</option>
                                    <option value="부서">부서</option>
                                    <option value="개인">개인</option>
                                </select>
                            </div>
                        </div>
            <div class="deptRow-addEvent">
                        <div class="row">
                            <div class="col-xs-12">        
                                <label class="col-xs-4" for="edit-dept">부서</label>
                                	<input class='edit-dept' name="dept[]" id="dept12" type="checkbox" value="11">기획처
                                	<input class='edit-dept' name="dept[]" id="dept13" type="checkbox" value="12">교학처
                                	<input class='edit-dept' name="dept[]" id="dept14" type="checkbox" value="13">사무처
                                	<input class='edit-dept' name="dept[]" id="dept15" type="checkbox" value="14">국제협력처
                            </div>
                        </div>
            </div>           
                        <div class="row">
                            <div class="col-xs-12">
                                <label class="col-xs-4" for="edit-color">색상</label>
                                <select class="inputModal" name="color" id="edit-color">
                                    <option value="#D25565" style="color:#D25565;">빨간색</option>
                                    <option value="#9775fa" style="color:#9775fa;">보라색</option>
                                    <option value="#ffa94d" style="color:#ffa94d;">주황색</option>
                                    <option value="#74c0fc" style="color:#74c0fc;">파란색</option>
                                    <option value="#f06595" style="color:#f06595;">핑크색</option>
                                    <option value="#63e6be" style="color:#63e6be;">연두색</option>
                                    <option value="#a9e34b" style="color:#a9e34b;">초록색</option>
                                    <option value="#4d638c" style="color:#4d638c;">남색</option>
                                    <option value="#495057" style="color:#495057;">검정색</option>
                                </select>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-12">
                                <label class="col-xs-4" for="edit-place">장소</label>
                                <span class="inputModal">
                                <input type="text" name="edit-place" id="edit-place" />
                                <button class="btn btn-default" type="button" id="searchPlace">지도검색</button>
                                </span>
                            </div>
                        </div>         
                        <div class="row">
                            <div class="col-xs-12">
                                <label class="col-xs-4" for="edit-participant">내부참여자</label>
                                <select style="width:65%;" class="inputModal" name="participant" id="edit-participant" multiple="multiple">
                                	<option value="test1">관리자</option>
                                	<option value="test2">김자바</option>
                                	<option value="test3">오나클</option>
                                </select>
                            </div>
             			</div>
                        <div class="row">
                            <div class="col-xs-12">
                                <label class="col-xs-4" for="edit-alarm">알림받기</label>
                                <input class="alarmNewEvent" id="edit-alarm" type="checkbox">
                            </div>
                        </div>
             <div class="alarmTimeRow-addEvent">
                        <div class="row">
                            <div class="col-xs-12">
                                <label class="col-xs-4" for="edit-alarmTime">알림시간</label>
                                <input class="inputModal" type="text" name="edit-alarmTime" id="edit-alarmTime" />
                            </div>
                        </div>
             </div>             
                        <div class="row">
                            <div class="col-xs-12">                               
                                <label class="col-xs-4" for="edit-message">쪽지발송</label>
                                <input class="messageNewEvent" id="edit-message" type="checkbox">                                        
                            </div>
                        </div>
             <div class="recipientRow-addEvent">           
                        <div class="row">
                            <div class="col-xs-12">
                                <label class="col-xs-4" for="edit-recipient">쪽지수신인</label>
                                <select class="inputModal" name="recipient" id="edit-recipient" multiple="multiple">
                                	<option value="test1">관리자</option>
                                
								    <option value="E202002140001">김자바</option>
								    <option value="test1">오칠희</option>
								
								
									<option value="E202002170002">오나클</option>
                                </select>
                            </div>
             			</div>
              </div>
                        <div class="row">
                            <div class="col-xs-12">
                                <label class="col-xs-4" for="edit-desc">설명</label>
                                <textarea rows="4" cols="50" class="inputModal" name="edit-desc"
                                    id="edit-desc"></textarea>
                            </div>
                        </div>

                    </div>
                    <!-- ================= 일정추가 modal 버튼 =================================== -->
                    <div class="modal-footer modalBtnContainer-addEvent">
                        <button type="button" class="btn btn-default" id="add-reset" data-dismiss="modal">취소</button>
                        <button type="button" class="btn btn-primary" id="save-event">저장</button>
                    </div>
                    <!-- ================= 일정수정 modal 버튼 =================================== -->
                    <div class="modal-footer modalBtnContainer-modifyEvent">
                        <button type="button" class="btn btn-default" id="modify-reset" data-dismiss="modal">취소</button>
                        <button type="button" class="btn btn-primary" id="updateEvent">저장</button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
        
        <!-- ================== 지도 modal  ================================================= -->
        <div class="modal fade" tabindex="-1" role="dialog" id="mapModal">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                	<div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title"></h4>
                    </div><!-- /.modal-header -->
                    <div class="modal-body">
                    	<div class="row">
                    		<div class="col-xs-12">
								<input type="radio" name="placeFilter" id="keywordPlace" value="keywordPlace">&nbsp;
								<label for="keywordPlace">키워드</label>&nbsp;&nbsp;&nbsp;
								<input type="radio" name="placeFilter" id="addrPlace" value="addrPlace">&nbsp;
								<label for="addrPlace">주소</label>&nbsp;&nbsp;&nbsp;
								<input type="text" class="" id="inputPlace">&nbsp;&nbsp;&nbsp;
								<button type="button" class="btn btn-primary" id="searchWord_btn">검색</button>
								<button type="button" class="btn btn-default" id="marker_btn">마커</button>
							</div>
                        </div>
                        <div class="row">
                        	<div class="col-xs-12">
                        	
	                        	<div class="map_wrap">
									<!-- 지도 영역 -->
			                        <div id="map" style="width:100%; height:100%; position:relative; overflow:hidden;"></div>
			                        <div id="menu_wrap" class="bg_white">
		        						<!-- 검색 리스트 -->
								        <ul id="placesList"></ul>
								        <div id="pagination"></div>
									</div>
								</div>
							
							</div>	
						</div>
                    
                    </div><!-- /.modal-body -->
                    <!-- ================= 지도 modal 버튼 =================================== -->
                    <div class="modal-footer modalBtnContainer-placeMap">
                    	<button type="button" class="btn btn-default" id="map-reset" data-dismiss="modal">취소</button>
                    	<button type="button" class="btn btn-primary" id="selectPlace">확인</button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->        
        
    </div><!-- /.container -->



<!--  ============================= css 공통프레임  ========================== -->
<!-- =========================== end of 해당 페이지 본문 컨텐츠 ================================ --> 					
						</section>
						</article> <!-- // content -->

						</div><!-- end of printContents -->
					</section> <!-- //.box_instruc_con -->
					
				
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

	<!-- fullcalendar JS -->
    <script src="/api/fullcalendar-4.4.0/vendor/js/jquery.min.js"></script>
    <script src="/api/fullcalendar-4.4.0/vendor/js/bootstrap.min.js"></script>
    <script src="/api/fullcalendar-4.4.0/vendor/js/moment.min.js"></script>
    <script src="/api/fullcalendar-4.4.0/vendor/js/fullcalendar.min.js"></script>
    <script src="/api/fullcalendar-4.4.0/vendor/js/ko.js"></script>
    <script src="/api/fullcalendar-4.4.0/vendor/js/select2.min.js"></script>
    <script src="/api/fullcalendar-4.4.0/vendor/js/bootstrap-datetimepicker.min.js"></script>
    <script src="/api/fullcalendar-4.4.0/js/main.js"></script>
    <script src="/api/fullcalendar-4.4.0/js/addEvent.js"></script>
    <script src="/api/fullcalendar-4.4.0/js/editEvent.js"></script>
    <script src="/api/fullcalendar-4.4.0/js/detailEvent.js"></script>
    <script src="/api/fullcalendar-4.4.0/js/etcSetting.js"></script>
    <script src="/api/fullcalendar-4.4.0/js/placeMap.js"></script>

    
    <!-- kakao map API -->
    <!-- <script type="text/javascript" 
    		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=5045ddb9aba8c01237695bb3d59a38a2"></script> -->
    <!-- kakao services, clusterer, drawing 라이브러리 불러오기 -->
	<script type="text/javascript" 
			src="//dapi.kakao.com/v2/maps/sdk.js?appkey=5045ddb9aba8c01237695bb3d59a38a2&libraries=services,clusterer,drawing"></script>
</body>
<%
	}
%>	
</html>