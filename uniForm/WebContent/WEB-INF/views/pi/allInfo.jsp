<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>정보 수정</title>
<%
	String type = (String)request.getAttribute("type");
%>		
		<script type="text/javascript"
				src="/include/js/jquery-1.11.0.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				$(".hp").hide();
				$(".tel").hide();
				$(".mail").hide();
				if("<%=type%>"=="hp"){
					$(".hp").show();
				}else if("<%=type%>"=="tel"){
					$(".tel").show();
				}else if("<%=type%>"=="mail"){
					$(".mail").show();
				}
				
				$("#mailSelect").on("click",function(){
					var plus = $("#mailSelect").val();
					
					if(plus=="self"){
						$("#select").prop("disabled",false);
						$("#select").val("");
					}else{
						$("#select").prop("disabled",true);
						$("#select").val(plus);
					}
				});
				
				$("#info_btn").on("click",function(){
					var i_hp = $("#i_hp").val();
					var i_tel = $("#i_tel").val();
					var i_mail = $("#i_mail").val();
					
					if(i_mail!=null&&i_mail!=""){
						i_mail = i_mail + "@" + $("#select").val();
					}
					
					if("<%=type%>"=="hp"){
						
						if(i_hp==null||i_hp==""){
							i_hp = "없음";
						}else{
							if(i_hp.indexOf("-")>-1||i_hp.length>12){
								alert("잘못 입력하셨습니다");
								return false;
							}
						}
						
					}else if("<%=type%>"=="tel"){
						
						if(i_tel==null||i_tel==""){
							i_tel = "없음";
						}else{
							if(i_tel.indexOf("-")>-1||i_tel.length>12){
								alert("잘못 입력하셨습니다");
								return false;
							}
						}
						
					}else if("<%=type%>"=="mail"){
						if(i_mail==null||i_mail==""){
							i_mail = "없음";
						}
					}
					
					callUpdateInfo(i_hp,i_tel,i_mail);
				});
				
			});
			
			function callUpdateInfo(i_hp,i_tel,i_mail){
				$.ajax({
					url:"/em/updateInfo.uni",
					data:{
						i_hp:i_hp,
						i_tel:i_tel,
						i_mail:i_mail
					},
					success:function(data){
						alert(data);
						if(data.indexOf("실패")>-1){
							return false;
						}else{
							opener.goUpdatePage();
							window.close();
						}
					}
				});
			}
		</script>		
	</head>
	<body>
		<div align="center">
			<table border="0">
				<tr class="hp">
					<td>
						핸드폰 번호 : <input type="text" id="i_hp" placeholder="-는 빼고 입력해 주세요">
					</td>
				</tr>
				
				<tr class="tel">
					<td>
						비상 연락 : <input type="text" id="i_tel" placeholder="-는 빼고 입력해 주세요">
					</td>
				</tr>
				
				<tr class="mail">
					<td>
						이메일 : <input type="text" id="i_mail">@
						<select id="mailSelect">
							<option value="self">직접입력</option>
							<option value="naver.com">naver.com</option>
							<option value="daum.net">daum.net</option>
							<option value="google.com">google.com</option>
							<option value="yahoo.co.kr">yahoo.co.kr</option>
							<option value="hotmail.com">hotmail.com</option>
							<option value="nate.com">nate.com</option>
						</select>
						<input type="text" id="select">
					</td>
				</tr>
			</table>
			<input type="button" id="info_btn" value="저장하기">
		</div>
	</body>
</html>