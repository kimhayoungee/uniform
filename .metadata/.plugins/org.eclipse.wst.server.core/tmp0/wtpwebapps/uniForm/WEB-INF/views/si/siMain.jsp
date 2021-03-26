<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.uniform.em.common.vo.EmCommonVO" %>
<%@ page import="com.uniform.si.info.vo.SiInfoVO" %>
<%@ page import="java.util.List" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>학생 정보 조회</title>
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
		EmCommonVO ecvo = (EmCommonVO)request.getAttribute("miniVO");
		Object obj = request.getAttribute("siList");
		List<SiInfoVO> list = (List<SiInfoVO>)obj;
		SiInfoVO sivo = null;
%>			
		<style type="text/css">
			div.all{
				width:40%;
				margin-top:80px;
			}
			div.scrollbox{
				overflow:auto;
				height:500px;
				width:680px;
			}
		</style>
		
		<script type="text/javascript"
				src="/include/js/jquery-1.11.0.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				$("#insert_btn").on("click",function(){
					window.open("/si/goInsertSi.uni","pop","width=700,height=800,left=700,top=200");
				});
				
				$(".detail").on("click",function(){
					var i_no = $(this).attr("data-num");
					alert(i_no);
					
					$("#i_no").val(i_no);
					
					window.open("","pop","width=700,height=800,left=700,top=200");
					
					$("#detailForm").attr({
						"method":"POST",
						"action":"/si/goDetailSi.uni",
						"enctype":"application/x-www-form-urlencoded",
						"target":"pop"
					});
					
					$("#detailForm").submit();
				});
			});
			
			function goSiMain(){
				location.href="/si/goSiMain.uni";
			}
		</script>		
	</head>
	<body>
		<a href="/main/goMain.uni">
			<img src="/common/img/Uniform.PNG" border="0">
		</a>
		<table align="right">
			<tr>
				<td align="center"><%=ecvo.getI_nameKr() %>님&nbsp;&nbsp;&nbsp;&nbsp;<br>(<%=ecvo.getI_no() %>)</td>
<%
		if(i_no.indexOf("E")>-1){
%>				
				<td valign="top"><a href="/main/goMyInfo.uni">마이페이지</a></td>
<%
		}
%>				
				<td valign="top">&nbsp;&nbsp;&nbsp;&nbsp;<a href="/sm/logout.uni">Logout</a></td>
			</tr>
		</table>
		<div style="height: 80px;">
		<table align="center" onmouseover="test()" onmouseout="test2()">
			<tr>
				<td>
					<input type="button" value="학교정보">
				</td>
				<td>
					<input type="button" value="전자결재" id="ea_btn">
				</td>
				<td>
					<input type="button" value="일정관리" id="pm_btn">
				</td>
				<td>
					<input type="button" value="학생관리" id="si_btn">
				</td>
				<td>
					<input type="button" value="게시판" id="bm_btn">
				</td>
				<td>
					<input type="button" value="공지사항" id="nm_btn">
				</td>
				<td>
					<input type="button" value="인사관리" id="em_btn">
				</td>
			</tr>
		</table>
		</div>
		
		<div align="center">
			<div class="all" align="left">
				<h2>학생 정보 카드</h2>
				<div class="scrollbox">
				<p>
<%
		if(i_no.indexOf("M")>-1){
%>				
				<input type="button" id="insert_btn" value="학생등록">
<%
		}
%>				
				<div>
					<table border="1">
						<tr>
							<th width="150px">학번</th>
							<th width="150px">학생 이름</th>
							<th width="300px">학과</th>
							<th width="150px">학년</th>
							<th width="150px">학적 상태</th>
						</tr>
<%
			if(list!=null&&list.size()>0){
				for(int i=0;i<list.size();i++){
					sivo = list.get(i);
%>
						<tr class="detail" data-num="<%=sivo.getI_no()%>">
							<td><%=sivo.getI_no()%></td>
							<td><%=sivo.getI_nameKr() %></td>
							<td><%=sivo.getSi_major()%></td>
							<td><%=sivo.getSi_grade()%>학년</td>
							<td><%=sivo.getSi_register()%></td>
						</tr>
<%					
				}
			}
%>						
					</table>
				</div>
				</div>
				
			</div>
			<form id="detailForm">
				<input type="hidden" id="i_no" name="i_no">
			</form>
			<select>
				<option>선택</option>
				<option>공연예술학과</option>
				<option>유아교육과</option>
				<option>관광학과</option>
				<option>디자인학과</option>
				<option>항공운항과</option>
				<option>사회복지학과</option>
			</select>
			<input type="text" id="search" name="search" placeholder="이름으로 검색">
			<input type="button" id="search_btn" value="검색">
		</div>	
	</body>
<%
	}
%>	
</html>