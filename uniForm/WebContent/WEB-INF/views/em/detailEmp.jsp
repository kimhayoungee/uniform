<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.uniform.em.common.vo.EmCommonVO" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
<%
	EmCommonVO ecvo = (EmCommonVO)request.getAttribute("detailVO");
%>	
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
				
		<title>교직원 조회</title>
		<script type="text/javascript"
				src="/include/js/jquery-1.11.0.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				$("#update_btn").on("click",function(){
					$("#i_no").val("<%=ecvo.getI_no()%>");
					$("#detailForm").attr({
						"method":"POST",
						"action":"/em/goUpdateEmp.uni",
						"enctype":"application/x-www-form-urlencoded"
					});
					
					$("#detailForm").submit();
				});
				
				$("#delete_btn").on("click",function(){
					alert($("#i_no").val("<%=ecvo.getI_no()%>"));
					$("#em_img").val("<%=ecvo.getEm_img()%>");
					
					if(confirm("삭제 하시겠습니까?")){
						callDeleteEmp();
					}
				});
			});
			
			function callDeleteEmp(){
				var no = $("#i_no").val();
				var img = $("#em_img").val();
				$.ajax({
					url:"/em/deleteEmp.uni",
					type:"POST",
					data:{
						i_no:no,
						em_img:img
					},
					success:function(data){
						alert(data);
						
						if(data.indexOf("실패")>-1){
							return false;
						}else{
							opener.goEmMain();
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
			<input type="button" class=blue_btn style="height:18pt;" id="delete_btn" value="삭제하기">
			<input type="button" class=grey_btn style="height:18pt;" id="update_btn" value="수정하기">
			
		<div>
			<h2>교직원 조회</h2>
			<p>
			
			</p>
			
			<p>
			
			</p>
			<div class="table_wrap">
			<table border="0">
				<tr>
					<td rowspan="8">
						<img alt="사진" src="/common/img/<%=ecvo.getEm_img() %>" width="150px" height="190px">
					</td>
					<th width="120px">
						이름(한글)
					</th>
					<td width="150px">
						<%=ecvo.getI_nameKr() %>
					</td>
					<th width="120px">
						성별
					</th>
					<td width="100px">
						<%=ecvo.getI_gender() %>
					</td>
				</tr>
				
				<tr>
					<th>
						영문(성)
					</th>
					<td colspan="3">
						<%=ecvo.getI_firstName() %>
					</td>
				</tr>
				
				<tr>
					<th>
						영문(이름)
					</th>
					<td colspan="3">
						<%=ecvo.getI_lastName() %>
					</td>
				</tr>
				
				<tr>
					<th>
						생년월일
					</th>
					<td colspan="3">
						<%=ecvo.getI_birth() %>
					</td>
				</tr>
				
				<tr>
					<th>
						주민등록번호
					</th>
					<td colspan="3">
						<%=ecvo.getI_rrn() %>
					</td>
				</tr>
				
				<tr>
					<th>
						전화번호
					</th>
					<td colspan="3">
						<%=ecvo.getI_hp() %>
					</td>
				</tr>
				
				<tr>
					<th>
						비상연락
					</th>
					<td colspan="3">
						<%=ecvo.getI_tel() %>
					</td>
				</tr>
				
				<tr>
					<th>
						이메일
					</th>
					<td colspan="3">
						<%=ecvo.getI_mail() %>
					</td>
				</tr>
			</table>
			</div>
			<p>
			
			</p>
			<div class="table_wrap">
			<table border="0">
				<tr>
					<th width="120px">
						우편번호
					</th>
					<td width="200px">
						<%=ecvo.getI_postNo() %>
					</td>
				</tr>
			</table>
			
			<table border="0">
				<tr>
					<th width="120px">
						도로명 주소
					</th>
					<td width="540px">
						<%=ecvo.getI_doro() %>
					</td>
				</tr>
				
				<tr>
					<th width="120px">
						지번 주소
					</th>
					<td>
						<%=ecvo.getI_jibun() %>
					</td>
				</tr>
				
				<tr>
					<th width="120px">
						상세 주소
					</th>
					<td>
						<%=ecvo.getI_detail() %>
					</td>
				</tr>
			</table>
			</div>
			<p>
			
			</p>
			<div class="table_wrap">
			<table border="0">
				<tr>
					<th width="120px">
						입사일
					</th>
					<td width="204px">
						<%=ecvo.getEm_hireDate() %>
					</td>
					
					<th width="120px">
						최종 학력
					</th>
					<td width="204px">
						<%=ecvo.getEm_academic() %>
					</td>
				</tr>
			</table>
			</div>
			
			<div class="table_wrap">
			<table border="0">
				<tr>
					<th width="120px">
						처부
					</th>
					<td width="92px">
						<%=ecvo.getEm_dept() %>
					</td>
					<th width="120px">
						직위
					</th>
					<td width="92px">
						<%=ecvo.getEm_position() %>
					</td>
					<th width="120px">
						팀
					</th>
					<td width="92px">
						<%=ecvo.getEm_team() %>
					</td>
				</tr>
			</table>
			</div>
			<p>
			
			</p>
			<div class="table_wrap">
			<table border="0">
				<tr>
					<th width="120px">
						군필
					</th>
					<td width="150px">
						<%=ecvo.getEm_military() %>
					</td>
					<th width="120px">
						군번
					</th>
					<td width="258px">
						<%=ecvo.getEm_mNo() %>
					</td>
				</tr>
				
				<tr>
					<th width="120px">
						복무 기간
					</th>
					<td colspan="3">
						<%=ecvo.getEm_mStart() %> ~ <%=ecvo.getEm_mEnd() %>
					</td>
				</tr>
				
				<tr>
					<th colspan="4">
						면제사유
					</th>
				</tr>
				
				<tr>
					<td colspan="4" height="100px" style="vertical-align:top;">
						<%=ecvo.getEm_exemp() %>
					</td>
				</tr>
			</table>
			</div>
			<p>
			
			</p>
			<div class="table_wrap">
			<table border="0">
				<tr>
					<th width="120px">
						입력일
					</th>
					<td width="200px">
						<%=ecvo.getI_insertDate() %>
					</td>
				</tr>
				
				<tr>
					<th width="120px">
						최종 수정일
					</th>
					<td width="200px">
						<%=ecvo.getI_updateDate() %>
					</td>
				</tr>
			</table>
			</div>
		</div>
		
		<form id="detailForm">
			<input type="hidden" id="i_no" name="i_no">
			<input type="hidden" id="em_img" name="em_img">
		</form>
	</body>
</html>