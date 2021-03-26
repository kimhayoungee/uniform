<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.uniform.em.common.vo.EmCommonVO" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>개인 정보 수정</title>
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
		Object obj = request.getAttribute("updateInfo");
		EmCommonVO ecvo = (EmCommonVO)obj;
%>		
		<style type="text/css">
			div.d1{
				width:25%;
			}
		</style>	
			
		<script type="text/javascript"
				src="/include/js/jquery-1.11.0.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				var type = "";
				$(".type").on("click",function(){
					var type = $(this).parents("tr").attr("data-type");
					
					
					if(type=="pw"){
						goUpdatePassword();
					}else if(type=="mm"){
						goUpdateMm();
					}else{
						goAllInfo(type);
					}
				});
				
				$("#sign_btn").on("click",function(){
					window.open("/em/goUpdateSign.uni?em_sign=<%=ecvo.getEm_sign()%>","pop","width=500,height=500");
				});
				
				$("#update_btn").on("click",function(){
					window.open("/em/goUpdateAddr.uni","pop","width=500,height=500");
				});
			});	
			
			function goUpdatePage(){
				location.href="/em/goUpdateInfo.uni";
			}
			
			function goAllInfo(type){
				window.open("/em/splitType/" + type + ".uni","pop","width=550,height=200,left=800,top=400");
			}
			
			function goUpdatePassword(){
				window.open("/em/goUpdatePassword.uni","pop","width=550,height=300,left=800,top=400");
			}
			
			function goUpdateMm(){
				window.open("/em/goUpdateMm.uni","pop","width=550,height=300,left=800,top=400");
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
				<td valign="top"><a href="/main/goMyInfo.uni">마이페이지</a></td>
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
			<div class="d1">
				<h2>정보수정</h2>
				<table border="1" align="center">					
					<tr data-type="hp">
						<th width="125px">전화번호</th>
						<td class="type" width="370px">
							<%=ecvo.getI_hp() %>
						</td>
					</tr>
					
					<tr data-type="tel">
						<th>비상연락</th>
						<td class="type" width="370px">
							<%=ecvo.getI_tel() %>
						</td>
					</tr>
					
					<tr data-type="mail">
						<th>이메일</th>
						<td class="type" width="370px">
							<%=ecvo.getI_mail() %>
						</td>
					</tr>
				</table>
				<p>
				<table border="1">
					<tr data-type="pw">
						<td width="500px" class="type" colspan="2">비밀번호 변경</td>
					</tr>
				</table>
				<p>
				<table border="1" align="center">
					<tr>
						<th width="150px">지번 주소</th>
						<td width="380px"><%=ecvo.getI_jibun() %></td>
					</tr>
					
					<tr>
						<th>도로명 주소</th>
						<td width="380px"><%=ecvo.getI_doro() %></td>
					</tr>
					
					<tr>
						<th>우편번호</th>
						<td width="380px"><%=ecvo.getI_postNo() %></td>
					</tr>
					
					<tr>
						<th>상세주소</th>
						<td width="380px"><%=ecvo.getI_detail() %></td>
					</tr>
				</table>
				<div align="right">
					<input type="button" id="update_btn" value="변경하기">
				</div>
				<p>
				<table border="1">
					<tr data-type="mm">
						<td width="500px" class="type" colspan="2">쪽지 및 알람</td>
					</tr>
				</table>
				<p>
				<table border="1">
					<tr>
						<th>개인서명</th>
						<td>
							<img src="<%=ecvo.getEm_sign()%>" width="100px" height="100px">
						</td>
					</tr>
				</table>
				<input type="button" id="sign_btn" value="변경하기">
			</div>
		</div>
	</body>
<%
	}
%>	
</html>