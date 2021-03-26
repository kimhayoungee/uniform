<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.uniform.em.common.vo.EmCommonVO" %>
<%@ page import="com.uniform.mm.setting.vo.MmSettingVO" %>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>마이 페이지</title>
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
		<style type="text/css">
			img.img{
				width:150px;
			}
			
			th.ts{
				text-align:center;
				border:1px solid;
			}
			
			td.board{
				text-align:left;
				border:1px solid;
			}
			
			td.leng{
				width:100%;
				text-align:left;
				border:1px solid;
			}
			
			td.sign{
				text-align:center;
				border:1px solid;
				height:100px;
				width:100px;
			}
			
			td.mm{
				text-align:center;
				border:1px solid;
			}
			
			table.top{
				width:40%;
			}
			
			table.left{
				width:60%;
			}
			
			table.right{
				width:35%;
				height:92px;
			}
			
			div.middle{
				width:40%;
			}
			
			div.bottom{
				width:40%;
				height:20%;
			}
		</style>
		<script type="text/javascript"
				src="/include/js/jquery-1.11.0.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				
				$("#test").hide();		
				
<%
	Object obj = request.getAttribute("myInfoVO");
	EmCommonVO ecvo = (EmCommonVO)obj;
	boolean signBool = ecvo.getEm_sign().indexOf("없음") > -1;
	
	MmSettingVO msvo = (MmSettingVO)request.getAttribute("msvo");
	request.setAttribute("msvo", msvo);
%>			
				$("#sign_btn").click(function(){
					window.open("/main/goAddSign.uni","pop","width=480,height=280");
				});
				
				$("#update_btn").click(function(){
					$("#updateForm").attr({
						"method":"POST",
						"enctype":"application/x-www-form-urlencoded",
						"action":"/em/goUpdateInfo.uni"
					});
					$("#updateForm").submit();
				});
				
				$("#message_btn").click(function(){
					location.href="/mm/goMessageMain.uni";
				});
			});
			
			function test(){
				$("#test").show();
			}
			
			function test2(){
				$("#test").hide();
			}
			
			function goMyPage(){
				location.href="/main/goMyInfo.uni";
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
			<tr id="test">
				<td>
					<ol>
						<li>항목1</li>
						<li>항목2</li>
						<li>항목3</li>
					</ol>
				</td>
				<td>
					<ol>
						<li>항목1</li>
						<li>항목2</li>
						<li>항목3</li>
					</ol>
				</td>
				<td>
					<ol>
						<li>항목1</li>
						<li>항목2</li>
						<li>항목3</li>
					</ol>
				</td>
				<td>
					<ol>
						<li>항목1</li>
						<li>항목2</li>
						<li>항목3</li>
					</ol>
				</td>
				<td>
					<ol>
						<li>항목1</li>
						<li>항목2</li>
						<li>항목3</li>
					</ol>
				</td>
				<td>
					<ol>
						<li>항목1</li>
						<li>항목2</li>
						<li>항목3</li>
					</ol>
				</td>
				<td>
					<ol>
						<li>항목1</li>
						<li>항목2</li>
						<li>항목3</li>
					</ol>
				</td>
			</tr>
		</table>
		</div>
		
		<div align="center" style="margin-top: 80px;">
			<table border="0" class="top">
				<tr>
					<td rowspan="5" colspan="3" align="center">
						<img src="/common/img/<%=ecvo.getEm_img()%>" height="185" class="img">
					</td>
					<th class="ts" colspan="2">
						사번
					</th>
					<td class="board" colspan="2">
						<%=ecvo.getI_no() %>
					</td>
					<th class="ts">
						주민번호
					</th>
					<td class="board">
						<%=ecvo.getI_rrn() %>
					</td>
				</tr>
				
				<tr>
					<th class="ts" rowspan="2">
						성<br>명
					</th>
					<th class="ts">
						한글
					</th>
					<td class="board" colspan="2">
						<%=ecvo.getI_nameKr() %>
					</td>
					<th class="ts">
						생년월일
					</th>
					<td class="board">
						<%=ecvo.getI_birth() %>
					</td>
				</tr>
				
				<tr>
					<th class="ts">
						영문
					</th>
					<td class="board" colspan="2">
						<%=ecvo.getI_firstName() + " " + ecvo.getI_lastName() %>
					</td>
					<th class="ts">
						성별
					</th>
					<td class="board">
						<%=ecvo.getI_gender() %>
					</td>
				</tr>
				
				<tr>
					<th class="ts" colspan="2">
						전화번호
					</th>
					<td class="board" colspan="2">
						<%=ecvo.getI_hp() %>
					</td>
					<th class="ts">
						비상연락
					</th>
					<td class="board">
						<%=ecvo.getI_tel() %>
					</td>
				</tr>
				
				<tr>
					<th class="ts" colspan="2">
						이메일
					</th>
					<td class="board" colspan="2">
						<%=ecvo.getI_mail() %>
					</td>
					<th class="ts">
						정보 수정일
					</th>
					<td class="board">
						<%=ecvo.getI_updateDate() %>
					</td>
				</tr>
				
				<tr>
					<th class="ts">
						지번 주소
					</th>
					<td class="leng" colspan="8">
						<%=ecvo.getI_jibun() %>
					</td>
				</tr>
				
				<tr>
					<th class="ts">
						도로명 주소
					</th>
					<td class="leng" colspan="8">
						<%=ecvo.getI_doro() %>
					</td>
				</tr>
				
				<tr>
					<th class="ts">
						우편번호
					</th>
					<td class="board" colspan="4">
						<%=ecvo.getI_postNo() %>
					</td>
					<th class="ts">
						상세 주소
					</th>
					<td class="board" colspan="4">
						<%=ecvo.getI_detail() %>
					</td>
				</tr>
			</table>
			
			<div class="middle">		
			<table align="left" class="left">
				<tr>
					<th class="ts" rowspan="3">
						재<br>직<br>사<br>항
					</th>
					<th class="ts">
						부서
					</th>
					<td class="board">
						<%=ecvo.getEm_dept() %>
					</td>
					<th class="ts">
						직위
					</th>
					<td class="board">
						<%=ecvo.getEm_position() %>
					</td>
				</tr>
				
				<tr>
					<th class="ts">
						팀
					</th>
					<td class="board">
						<%=ecvo.getEm_team() %>
					</td>
					
				</tr>
				
				<tr>
					<th class="ts">
						최종학력
					</th>
					<td class="board">
						<%=ecvo.getEm_academic() %>
					</td>
					<th class="ts">
						입사일자
					</th>
					<td class="board">
						<%=ecvo.getEm_hireDate() %>
					</td>
				</tr>		
			</table>				
			<table align="right" class="right">
				<tr>
					<th class="ts" rowspan="2">
						병<br>력
					</th>
					<th class="ts" width="40">
						군필
					</th>
					<td class="board">
						<%=ecvo.getEm_military() %>
					</td>
					<th class="ts">
						군번
					</th>
					<td class="board">
						<%=ecvo.getEm_mNo() %>
					</td>
				</tr>
				
				<tr>
					<th class="ts">
						복무 기간
					</th>
					<td class="board" colspan="3">
						<%=ecvo.getEm_mStart() + " ~ " + ecvo.getEm_mEnd() %>
					</td>
				</tr>
			</table>
			</div>
			
			<div class="bottom">
				<div width="100%">					
				<table border="0" width="20%" align="left">
					<tr>
						<th class="ts" rowspan="2" width="20px">
							기<br>타
						</th>
						<th class="ts">
							개인서명
						</th>
					</tr>
					
					<tr>				
						<td class="sign">
<%
	if(signBool){
%>							
							<input type="button" id="sign_btn" value="추가하기">
<%
	}else{
%>
							<img src="<%=ecvo.getEm_sign()%>" border="0" width="100px" height="100px">			
<%
	}
%>								
						</td>			
					</tr>
				</table>
				
				<table width="40%" align="left">
					<tr>
						<th class="ts" colspan="2">
							쪽지 및 알림 수신 여부
						</th>
					</tr>
					
					<tr>
						<th class="ts">
							쪽지
						</th>
						<th class="ts">
							알림
						</th>
					</tr>
					
					<tr>
						<td class="mm" height="75">
							<%=msvo.getMm_message() %>
						</td>
						<td class="mm" height="75">
							<%=msvo.getMm_alarm() %>
						</td>
					</tr>
				</table>
				
				<table width="35%" align="right">
					<tr>
						<th class="ts">
							면제사유
						</th>
					</tr>
					
					<tr>
						<td class="board" height="102">
							<%=ecvo.getEm_exemp() %>
						</td>
					</tr>
				</table>
				</div>
			</div>
			<input type="button" id="update_btn" value="정보 수정">
			<input type="button" id="message_btn" value="쪽지함">
		</div>	
		
		<form id="updateForm">
			<input type="hidden" name="em_sign" value="<%=ecvo.getEm_sign()%>">
			<input type="hidden" name="i_no" value="<%=i_no%>">
		</form>
<%
			}
%>
	</body>
</html>