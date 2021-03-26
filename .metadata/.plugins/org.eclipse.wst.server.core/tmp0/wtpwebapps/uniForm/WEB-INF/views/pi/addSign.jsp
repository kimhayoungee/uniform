<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>개인 서명 등록</title>
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
		<script type="text/javascript"
				src="https://code.jquery.com/jquery-1.11.0.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				$("#add_btn").on("click",function(){
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
						addSign();
					}
				});
			});
			
			function addSign(){
				var form = $("#signForm");
				var formData = new FormData(form[0]);
				formData.append("em_sign",$("#em_sign")[0].files[0]);
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
					opener.goMyPage();
					window.close();
				}
				
				function error(request,status,error){
					alert("code = "+ request.status + " message = " + request.responseText + " error = " + error);
				}
			}
		</script>		
	</head>
	<body>
		<form id="signForm"
			  name="signForm"
			  enctype="multipart/form-data">
			<h2>개인 서명 추가하기</h2>
			<input type="file" id="em_sign" name="em_sign"><br><br>
			<input type="button" id="add_btn" value="추가하기">
		</form>
	</body>
<%
	}
%>	
</html>