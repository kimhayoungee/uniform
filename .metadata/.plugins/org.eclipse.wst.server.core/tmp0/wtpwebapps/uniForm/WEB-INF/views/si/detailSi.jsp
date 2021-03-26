<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.uniform.si.info.vo.SiInfoVO" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
<%
	HttpSession hs = request.getSession();
	String i_no = (String)hs.getAttribute("i_no");
	
	Object obj = request.getAttribute("detailVO");
	SiInfoVO sivo = (SiInfoVO)obj;
%>	
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>학생 기록 카드</title>
		<script type="text/javascript"
				src="/include/js/jquery-1.11.0.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				$("#update_btn").on("click",function(){
					$("#i_no").val("<%=sivo.getI_no()%>");
					
					$("#updateForm").attr({
						"method":"POST",
						"action":"/si/goUpdateSi.uni",
						"enctype":"application/x-www-form-urlencoded"
					});
					
					$("#updateForm").submit();
				});
				
				$("#delete_btn").on("click",function(){
					$("#i_no").val("<%=sivo.getI_no()%>");
					$("#si_img").val("<%=sivo.getSi_img()%>");
					
					if(confirm("삭제 하시겠습니까?")){
						callDeleteSi();
					}
				});
			});
			
			function callDeleteSi(){
				var no = $("#i_no").val();
				var img = $("#si_img").val();
				$.ajax({
					url:"/si/deleteSi.uni",
					type:"POST",
					data:{
						i_no:no,
						si_img:img
					},
					success:function(data){
						alert(data);
						
						if(data.indexOf("실패")>-1){
							return false;
						}else{
							opener.goSiMain();
							window.close();
						}
					},
					error:function(request,status,error){
						alert("에러났다 >>> : " + request.status + " : error=" + error);
					}
				});
			}
		</script>		
	</head>
	<body>
		<div>
			<h2>학생 조회</h2>
			<p>
			
			</p>
<%
		if(i_no.indexOf("M")>-1){
%>			
			<input type="button" id="update_btn" value="수정하기">
			<input type="button" id="delete_btn" value="삭제하기">
			<p>
			
			</p>
<%
		}
%>			
			<table border="1">
				<tr>
					<td rowspan="8">
						<img alt="사진" src="/si/img/<%=sivo.getSi_img() %>" width="150px" height="190px">
						<input type="hidden" id="si_img" name="si_img">
					</td>
					<th width="120px">
						이름(한글)
					</th>
					<td width="150px">
						<%=sivo.getI_nameKr() %>
					</td>
					<th width="120px">
						성별
					</th>
					<td width="100px">
						<%=sivo.getI_gender() %>
					</td>
				</tr>
				
				<tr>
					<th>
						영문(성)
					</th>
					<td colspan="3">
						<%=sivo.getI_firstName() %>
					</td>
				</tr>
				
				<tr>
					<th>
						영문(이름)
					</th>
					<td colspan="3">
						<%=sivo.getI_lastName() %>
					</td>
				</tr>
				
				<tr>
					<th>
						생년월일
					</th>
					<td colspan="3">
						<%=sivo.getI_birth() %>
					</td>
				</tr>
				
				<tr>
					<th>
						주민등록번호
					</th>
					<td colspan="3">
						<%=sivo.getI_rrn() %>
					</td>
				</tr>
				
				<tr>
					<th>
						전화번호
					</th>
					<td colspan="3">
						<%=sivo.getI_hp() %>
					</td>
				</tr>
				
				<tr>
					<th>
						비상연락
					</th>
					<td colspan="3">
						<%=sivo.getI_tel() %>
					</td>
				</tr>
				
				<tr>
					<th>
						이메일
					</th>
					<td colspan="3">
						<%=sivo.getI_mail() %>
					</td>
				</tr>
			</table>
			<p>
			
			</p>
			<table border="1">
				<tr>
					<th width="120px">
						우편번호
					</th>
					<td width="200px">
						<%=sivo.getI_postNo() %>
					</td>
				</tr>
			</table>
			
			<table border="1">
				<tr>
					<th width="120px">
						도로명 주소
					</th>
					<td width="540px">
						<%=sivo.getI_doro() %>
					</td>
				</tr>
				
				<tr>
					<th width="120px">
						지번 주소
					</th>
					<td>
						<%=sivo.getI_jibun() %>
					</td>
				</tr>
				
				<tr>
					<th width="120px">
						상세 주소
					</th>
					<td>
						<%=sivo.getI_detail() %>
					</td>
				</tr>
			</table>
			<p>
			
			</p>
			<table border="1">
				<tr>
					<th width="100px">학과</th>
					<td width="160px">
						<%=sivo.getSi_major() %>
					</td>
					<th width="100px">학년</th>
					<td width="90px">
						<%=sivo.getSi_grade() %>학년
					</td>
					<th width="100px">학기</th>
					<td width="90px">
						<%=sivo.getSi_semester() %>학기
					</td>
				</tr>
				
				<tr>
					<th width="100px">출신학교</th>
					<td width="160px">
						<%=sivo.getSi_highschool() %>
					</td>
					<th width="100px">이수학점</th>
					<td width="90px">
						<%=sivo.getSi_credits() %>
					</td>
					<th width="100px">평균학점</th>
					<td width="90px">
						<%=sivo.getSi_avg() %>
					</td>
				</tr>
			</table>
			<p>
			
			</p>
			<table border="1">
				<tr>
					<th width="100px">학적상태</th>
					<td width="160px">
						<%=sivo.getSi_register() %>
					</td>
					<th width="100px">입학일자</th>
					<td width="90px">
						<%=sivo.getSi_admissionDate() %>
					</td>
					<th width="100px">졸업일자</th>
					<td width="90px">
						<%=sivo.getSi_graduationDate() %>
					</td>
				</tr>
			</table>
			<p>
			
			</p>
			<table border="1">
				<tr>
					<th>입학정보</th>
					<td>
						<textarea cols="71" rows="5" readonly><%=sivo.getSi_admissionInfo() %></textarea>
					</td>
				</tr>
			</table>
		</div>
		<form id="updateForm">
			<input type="hidden" id="i_no" name="i_no">
		</form>
	</body>
</html>