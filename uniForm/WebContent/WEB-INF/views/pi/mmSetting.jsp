<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.uniform.mm.setting.vo.MmSettingVO" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>쪽지 및 알람</title>
<%
	//EmCommonController에서 보낸 infoUpdate 페이지로 보낸 msvo를 꺼냄
	MmSettingVO msvo = (MmSettingVO)request.getAttribute("msvo");
	String mm_message = msvo.getMm_message();
	String mm_alarm = msvo.getMm_alarm();
%>		
			<script type="text/javascript"
					src="/include/js/jquery-1.11.0.min.js"></script>
			<script type="text/javascript">
				$(document).ready(function(){
					var meBool = 'Y'=="<%=mm_message%>".toUpperCase();
					var alBool = 'Y'=="<%=mm_alarm%>".toUpperCase();
					
					if(meBool){
						$("#meY").prop("checked",true);
					}else{
						$("#meN").prop("checked",true);
					}
					
					if(alBool){
						$("#alY").prop("checked",true);
					}else{
						$("#alN").prop("checked",true);
					}
					
					$("#updateMm_btn").on("click",function(){
						var mm_message = $("input[name='mm_message']:checked").val();
						var mm_alarm = $("input[name='mm_alarm']:checked").val();
						alert(mm_message + " : " + mm_alarm);
						
						callUpdateMm(mm_message,mm_alarm);
					});
				});
				
				function callUpdateMm(mm_message,mm_alarm){
					$.ajax({
						url:"/em/updateMm.uni",
						type:"POST",
						data:{
							mm_message:mm_message,
							mm_alarm:mm_alarm
						},
						success:function(data){
							alert(data);
							if(data.indexOf("실패")>-1){
								return false;
							}else{
								opener.goUpdatePage();
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
		<h1>쪽지 및 알람 설정</h1>
		
		<div align="center">
			쪽지 수신 : <input type="radio" id="meY" name="mm_message" class="test" value="Y">
			<label for="meY">동의</label>
			<input type="radio" id="meN" name="mm_message" class="test" value="N">
			<label for="meN">거부</label><p>
			
			푸쉬 알림 : <input type="radio" id="alY" name="mm_alarm" value="Y">
			<label for="alY">동의</label>
			<input type="radio" id="alN" name="mm_alarm" value="N">
			<label for="alN">거부</label>
			<p>
			<input type="button" id="updateMm_btn" value="저장">
		</div>
	</body>
</html>