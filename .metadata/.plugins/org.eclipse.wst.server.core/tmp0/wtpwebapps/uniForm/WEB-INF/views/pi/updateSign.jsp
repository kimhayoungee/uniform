<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ page import="com.uniform.em.common.vo.EmCommonVO" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>서명 수정</title>
<%
	Object obj = request.getAttribute("ecvo");
	EmCommonVO ecvo = (EmCommonVO)obj;
%>		
		<script type="text/javascript"
				src="https://code.jquery.com/jquery-1.11.0.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				
				$("#signUpdate_btn").on("click",function(){
					var file = $("#em_sign").val();
					var fileBool = file==null||file=="";
					if(fileBool){
						alert("추가할 파일을 선택해 주세요");
						return false;
					}else{
						var ext = $("#em_sign").val().split(".").pop().toLowerCase();
						if(ext!=""){
							if(jQuery.inArray(ext,['gif','png','jpg','jpeg'])== -1){
								alert("이미지 파일만 업로드 가능합니다.");
								return false;
							}
						}
						updateSign();
					}
				});
				
			});
			
			function updateSign(){
				var form = $("#signForm");
				var formData = new FormData(form[0]);
				formData.append("em_sign",$("#em_sign")[0].files[0]);
				formData.append("old_img",$("#old_sign").val());
				$.ajax({
					url:"/em/addSign.uni",
					processData:false,
					contentType:false,
					type:"POST",	
					data:formData,
					success:success,
					error:error
				});
				
				function success(data){
					alert("성공");
					opener.goUpdatePage();
					window.close();
				}
				
				function error(request,status,error){
					alert("code = "+ request.status + " message = " + request.responseText + " error = " + error);
				}
			}
		</script>			
	</head>
	<body>
		<h1>서명 변경</h1>
		<div align="center">
			<form id="signForm">
				<input type="hidden" id="old_sign" name="old_sign" value="<%=ecvo.getEm_sign()%>">
				<input type="file" id="em_sign" name="em_sign"><br><br>
			</form>
			<input type="button" id="signUpdate_btn" value="변경하기">
		</div>
	</body>
</html>